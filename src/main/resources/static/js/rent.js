document.querySelectorAll('.plane_item').forEach(item => {
    item.addEventListener('click', event => {

         const planeId = item.querySelector('.id').innerText;
         console.log(planeId);

        document.getElementById("planeId").value = planeId;
        console.log(document.getElementById("planeId"))
    })
})
