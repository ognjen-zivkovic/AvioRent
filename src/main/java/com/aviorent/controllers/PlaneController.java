package com.aviorent.controllers;

import com.aviorent.dtos.NewPlaneDto;
import com.aviorent.dtos.PlaneWithImagesDto;
import com.aviorent.models.Plane;
import com.aviorent.models.PlaneImage;
import com.aviorent.services.PlaneImageService;
import com.aviorent.services.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    @Autowired
    private PlaneImageService planeImageService;

    @GetMapping("/adminPlanes")
    public String adminPlanes(Model model) {
        List<Plane> planes = planeService.getAll();
        List<PlaneWithImagesDto> dto = new ArrayList<PlaneWithImagesDto>();
        for (Plane p : planes) {
            PlaneWithImagesDto temp = new PlaneWithImagesDto();
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
        return "adminPlanes";
    }


    @PostMapping("/newPlane")
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

        return new ModelAndView("redirect:/adminPlanes");
    }

    @PostMapping("/getRow")
    public @ResponseBody
    Plane getPlaneByIdAjax(@RequestParam long id) {
        return planeService.getById(id).get();
    }

    @PostMapping("/deletePlane")
    public ModelAndView deletePlane(@RequestParam long planeId, RedirectAttributes redirectAttributes) {
        planeService.deleteById(planeId);
        redirectAttributes.addFlashAttribute("planeDeleted", true);
        return new ModelAndView("redirect:/adminPlanes");
    }

    @PostMapping("/editPlane")
    public ModelAndView editPlane(@ModelAttribute Plane plane, RedirectAttributes redirectAttributes) {
        planeService.update(plane);
        redirectAttributes.addFlashAttribute("planeUpdated", true);
        return new ModelAndView("redirect:/adminPlanes");
    }

    @Transactional
    @PostMapping("/deletePlaneImage")
    public @ResponseBody
    Plane deletePlaneImage(@RequestParam long id, @RequestParam long planeId) {
        PlaneImage planeImage = planeImageService.getByPlaneImageId(id);
        File fileToDelete = new File("/src/main/upload/static/planeImages" + planeImage.getImagePath());
        fileToDelete.delete();
        planeImageService.deleteByPlaneImageId(id);
        Plane plane = planeService.getById(planeId).get();
        return plane;
    }

    @PostMapping("/addPlaneImage")
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

        return new ModelAndView("redirect:/adminPlanes");
    }

}
