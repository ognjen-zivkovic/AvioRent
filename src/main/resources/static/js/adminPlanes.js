$(function () {
    $(document).on('click', '.delete', function (e) {
        e.preventDefault();
        $('#delete').modal('show');
        var id = $(this).data('id');
        getRow(id);
    });





    $(function () {
        $('#example1').DataTable({
            responsive: true,
            'paging'      : false,
            'lengthChange': false,
            'searching'   : true,
            'ordering'    : true,
            'info'        : false,
            'autoWidth'   : false,
            order: [[ 0, 'desc' ]]

        })

    })


    $(document).on('click', '#image', function (e) {

        $('.imageSubmitBtn').prop('disabled',false);

    });


    $(document).on('click', '.edit', function (e) {
        e.preventDefault();
        $('#edit').modal('show');
        var id = $(this).data('id');
        getRow(id);
    });

    $(document).on('click', '.photo', function (e) {
        e.preventDefault();
        var id = $(this).data('id');
        $(".gallery").remove();
        $(".editImagesForm").remove();
        getRow(id);
    });


    $(document).on('click', '.deleteImage', function (e) {
        e.preventDefault();
        var id = $(this).data('id');
        var planeId = $(this).data('planeid');
        $.ajax({
            type: 'POST',
            url: '/admin/deletePlaneImage',
            data: {id: id, planeId: planeId},
            dataType: 'json',
            success: function (response) {
                $(".gallery").remove();
                $(".editImagesForm").remove();
                var images = response.images;
                toastr.success("Image successfully removed.");
                if (images.length > 0) {
                    $('#imageModal').append('<table>');
                    $('#imageModal').append('<tr>');
                    for (let i = 0; i < images.length; i++) {

                        $('#imageModal').append('<td>');
                        $('#imageModal').append('  <div class="gallery">\n' +
                            '                    <i class="fa fa-minus-circle minus deleteImage" style="cursor: pointer;"  aria-hidden="true" data-id="' + images[i].planeImageId + '" data-planeid="' + response.planeId + '"></i>\n' +
                            '                    \n' +
                            '                        <img src="' + images[i].imagePath + '" style="width:180px;height:110px;">\n' +
                            '                    \n' +
                            '                </div>\n');
                        $('#imageModal').append('<td>');
                        if (i == images.length) {
                            $('#imageModal').append('</tr>');
                            break;
                        }
                        if (i != 0 && i % 3 == 0) {
                            $('#imageModal').append('</tr>');
                            if (i != images.length)
                                $('#imageModal').append('<tr>');
                        }

                    }
                    $('#imageModal').append('</table>');

                } else {
                    $("#planeTableImg"+response.planeId).remove();

                }
                $('#imageModal').append('<form style="margin-top: 10px;" class="form-horizontal editImagesForm" method="POST" action="/admin/addPlaneImage" enctype="multipart/form-data">\n' +
                    '                    <input type="hidden" class="planeid" name="planeId" value="'+response.planeId+'">\n' +
                    '                    <div class="form-group">\n' +
                    '                        <label for="image" class="col-sm-3 control-label"></label>\n' +
                    '\n' +
                    '                        <div class="col-sm-9">\n' +
                    '                            <input type="file" id="image" name="image" required multiple>\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '            </div>\n' +
                    '            <br>\n' +
                    '            <div class="modal-footer">\n' +
                    '                <button type="button" class="btn btn-default btn-flat pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Close</button>\n' +
                    '                <button disabled type="submit" class="btn btn-success btn-flat imageSubmitBtn" name="upload"><i class="fa fa-check-square-o"></i> Update</button>\n' +
                    '                </form>');
            }
            ,
            error: function () {
                alert("error");
            }
        });
    });


});

function getRow(id) {
    $.ajax({
        type: 'POST',
        url: '/admin/getRow',
        data: {id: id},
        dataType: 'json',
        success: function (response) {
            $('.planeid').val(response.planeId);
            $('.planeModel').html(response.model);
            $('.edit_model').val(response.model);
            $('.edit_seats').val(response.seats);
            $('.edit_maxspeed').val(response.maxSpeed);
            $('.edit_price').val(response.price);
            $('.edit_range').val(response.range);
            $('.imageEditHeader').html(response.model + ' images');

            var images = response.images;

            if (images.length > 0) {
                $('#imageModal').append('<table>');
                $('#imageModal').append('<tr>');
                for (let i = 0; i < images.length; i++) {

                    $('#imageModal').append('<td>');
                    $('#imageModal').append('  <div class="gallery">\n' +
                        '                    <i class="fa fa-minus-circle minus deleteImage" style="cursor: pointer;" aria-hidden="true" data-id="' + images[i].planeImageId + '" data-planeid="' + response.planeId + '"></i>\n' +
                        '                   \n' +
                        '                        <img src="' + images[i].imagePath + '" style="width:180px;height:110px;">\n' +
                        '                   \n' +
                        '                </div>\n');
                    $('#imageModal').append('<td>');
                    if (i == images.length) {
                        $('#imageModal').append('</tr>');
                        break;
                    }
                    if (i != 0 && i % 3 == 0) {
                        $('#imageModal').append('</tr>');
                        if (i != images.length)
                            $('#imageModal').append('<tr>');
                    }

                }
                $('#imageModal').append('</table>');
            }
            $('#imageModal').append('<form style="margin-top: 10px;" class="form-horizontal editImagesForm" method="POST" action="/admin/addPlaneImage" enctype="multipart/form-data">\n' +
                '                    <input type="hidden" class="planeid" name="planeId" value="'+response.planeId+'">\n' +
                '                    <div class="form-group">\n' +
                '                        <label for="image" class="col-sm-3 control-label"></label>\n' +
                '\n' +
                '                        <div class="col-sm-9">\n' +
                '                            <input type="file" id="image" name="image" required multiple>\n' +
                '                        </div>\n' +
                '                    </div>\n' +
                '            </div>\n' +
                '            <br>\n' +
                '            <div class="modal-footer">\n' +
                '                <button type="button" class="btn btn-default btn-flat pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Close</button>\n' +
                '                <button disabled type="submit" class="btn btn-success btn-flat imageSubmitBtn" name="upload"><i class="fa fa-check-square-o"></i> Update</button>\n' +
                '                </form>');
        }
    });
}