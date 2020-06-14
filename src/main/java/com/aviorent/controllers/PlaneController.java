package com.aviorent.controllers;

import com.aviorent.dtos.NewPlaneDto;
import com.aviorent.dtos.PlaneWithImagesDto;
import com.aviorent.models.Plane;
import com.aviorent.models.PlaneImage;
import com.aviorent.models.Rent;
import com.aviorent.services.PlaneImageService;
import com.aviorent.services.PlaneService;
import com.aviorent.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    @Autowired
    private PlaneImageService planeImageService;

    @Autowired
    private RentService rentService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/admin/planes/page/{page}")
    public ModelAndView adminPlanes(@PathVariable("page") int page) {
        ModelAndView modelAndView = new ModelAndView("planes");
        PageRequest pageable = PageRequest.of(page - 1, 5, Sort.by("planeId").descending());
        Page<Plane> planePage = planeService.getPaginatedPlanes(pageable);
        int totalPages = planePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }
        Page<PlaneWithImagesDto> dtoPage = planePage.map(new Function<Plane, PlaneWithImagesDto>() {
            @Override
            public PlaneWithImagesDto apply(Plane plane) {
                PlaneWithImagesDto dto = new PlaneWithImagesDto();
                dto.setPlaneId(plane.getPlaneId());
                List<PlaneImage> planeImages = new ArrayList<>(plane.getImages());
                dto.setImages(planeImages);
                dto.setMaxSpeed(plane.getMaxSpeed());
                dto.setModel(plane.getModel());
                dto.setPrice(plane.getPrice());
                dto.setRange(plane.getRange());
                dto.setSeats(plane.getSeats());
                Rent rent = rentService.getByPlane(plane);
                Date currentDate = new Date();
                Date dateStart = null;
                if (rent != null) {
                    dateStart = rent.getDateStart();
                    if (currentDate.before(dateStart)) {
                        dto.setCurrentlyRented(false);
                    } else if (currentDate.after(dateStart)) {
                        Date dateEnd = rent.getDateEnd();
                        if (currentDate.after(dateEnd))
                            dto.setCurrentlyRented(false);
                        else
                            dto.setCurrentlyRented(true);
                    }
                }
                return dto;
            }
        });
        modelAndView.addObject("activePlaneList", true);
        modelAndView.addObject("planes", dtoPage.getContent());
        return modelAndView;
    }

    @GetMapping("/admin/planes")
    public String adminPlanes(Model model) {
        return "redirect:/admin/planes/page/1";
        /*List<Plane> planes = planeService.getAll();
        List<PlaneWithImagesDto> dto = new ArrayList<PlaneWithImagesDto>();
        Date currentDate = new Date();
        Date dateStart = null;
        for (Plane p : planes) {
            PlaneWithImagesDto temp = new PlaneWithImagesDto();

            Rent rent = rentService.getByPlane(p);

            if (rent != null) {
                dateStart = rent.getDateStart();
                if (currentDate.before(dateStart)) {
                    temp.setCurrentlyRented(false);
                } else if (currentDate.after(dateStart)) {
                    Date dateEnd = rent.getDateEnd();
                    if (currentDate.after(dateEnd))
                        temp.setCurrentlyRented(false);
                    else
                        temp.setCurrentlyRented(true);
                }
            }

            temp.setPlaneId(p.getPlaneId());
            temp.setMaxSpeed(p.getMaxSpeed());
            temp.setModel(p.getModel());
            temp.setPrice(p.getPrice());
            temp.setRange(p.getRange());
            temp.setSeats(p.getSeats());
            temp.setImages(planeImageService.getAllByPlane(p));
            dto.add(temp);
        }

        model.addAttribute("planes", dto);
        return "adminPlanes";*/
    }


    @PostMapping("/admin/newPlane")
    public ModelAndView insertNewPlane(@ModelAttribute NewPlaneDto planeDto, RedirectAttributes redirectAttributes) {
        String uploadDirectory = System.getProperty("user.dir") + "/src/main/upload/static/planeImages";
        Plane newPlane = new Plane();
        newPlane.setModel(planeDto.getModel());
        newPlane.setPrice(planeDto.getPrice());
        newPlane.setSeats(planeDto.getSeats());
        newPlane.setRange(planeDto.getRange());
        newPlane.setMaxSpeed(planeDto.getMaxSpeed());


        Set<PlaneImage> planeImageSet = new HashSet<PlaneImage>();
        String shortenUrl = "/upload/static/planeImages/";
        for (MultipartFile image : planeDto.getImages()) {
            Path imageNameAndPath = Paths.get(uploadDirectory, image.getOriginalFilename());
            shortenUrl += image.getOriginalFilename();
            try {
                PlaneImage planeImage = new PlaneImage();
                Files.write(imageNameAndPath, image.getBytes());
                planeImage.setImagePath(shortenUrl);
                planeImage.setPlane(newPlane);
                planeImageSet.add(planeImage);
                shortenUrl = "/upload/static/planeImages/";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        newPlane.setImages(planeImageSet);
        planeService.save(newPlane);

        redirectAttributes.addFlashAttribute("newPlane", true);

        return new ModelAndView("redirect:/admin/planes/page/1");
    }

    @PostMapping("/admin/getRow")
    public @ResponseBody
    Plane getPlaneByIdAjax(@RequestParam long id) {
        return planeService.getById(id).get();
    }

    @PostMapping("/admin/deletePlane")
    public ModelAndView deletePlane(@RequestParam long planeId, RedirectAttributes redirectAttributes) {
        planeService.deleteById(planeId);
        redirectAttributes.addFlashAttribute("planeDeleted", true);
        return new ModelAndView("redirect:/admin/planes/page/1");
    }

    @PostMapping("/admin/editPlane")
    public ModelAndView editPlane(@ModelAttribute Plane plane, RedirectAttributes redirectAttributes) {
        planeService.update(plane);
        redirectAttributes.addFlashAttribute("planeUpdated", true);
        return new ModelAndView("redirect:/admin/planes/page/1");
    }

    @Transactional
    @PostMapping("/admin/deletePlaneImage")
    public @ResponseBody
    Plane deletePlaneImage(@RequestParam long id, @RequestParam long planeId) {
        PlaneImage planeImage = planeImageService.getByPlaneImageId(id);
        File fileToDelete = new File("/src/main/upload/static/planeImages" + planeImage.getImagePath());
        fileToDelete.delete();
        planeImageService.deleteByPlaneImageId(id);
        Plane plane = planeService.getById(planeId).get();
        return plane;
    }

    @PostMapping("/admin/addPlaneImage")
    public ModelAndView addPlaneImage(@RequestParam MultipartFile[] image, @RequestParam int planeId, RedirectAttributes redirectAttributes) {
        String uploadDirectory = System.getProperty("user.dir") + "/src/main/upload/static/planeImages";
        Plane plane = planeService.getById(planeId).get();
        String shortenUrl = "/upload/static/planeImages/";
        for (MultipartFile img : image) {
            Path imageNameAndPath = Paths.get(uploadDirectory, img.getOriginalFilename());
            shortenUrl += img.getOriginalFilename();
            try {
                PlaneImage planeImage = new PlaneImage();
                Files.write(imageNameAndPath, img.getBytes());
                planeImage.setImagePath(shortenUrl);
                planeImage.setPlane(plane);
                planeImageService.Save(planeImage);
                redirectAttributes.addFlashAttribute("planeImagesUpdated", true);
                shortenUrl = "/upload/static/planeImages/";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new ModelAndView("redirect:/admin/planes/page/1");
    }

}
