$(document).ready(function(){

    $('.nBtn, .table .eBtn').click(function(e){
        e.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text == 'Edit') {
            $.getJSON(href, function(response){
            //$('.myForm #kategoriId').val(response.kategoriId).hide(); ini aslinya
                $('.myForm #roleId').val(response.roleId).hide();
                $('.myForm #name').val(response.name);
            });
            $('.myForm #roleModal').modal();
        } else {
//         $('.myForm #kategoriId').val('0').hide(); ini aslinya
            $('.myForm #roleId').val('0').hide();
            $('.myForm #name').val('');
            $('.myForm #roleModal').modal();
        }

    });

    $('.rBtn').click(function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        $(".myRemoveRole .dBtn").attr('href',href);
        $('.myRemoveRole #roleModal').modal();

    });

});