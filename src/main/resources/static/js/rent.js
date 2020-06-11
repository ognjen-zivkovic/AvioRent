const planes = document.querySelectorAll('.plane_item')

planes.forEach(item => {
    item.addEventListener('click', event => {
         const planeId = item.querySelector('.id').innerText;

        document.getElementById("planeId").value = planeId;

        let planeClass = "plane_selected";
        planes.forEach(plane => plane.classList.remove(planeClass))
        item.classList.add("plane_selected");
    })
})
