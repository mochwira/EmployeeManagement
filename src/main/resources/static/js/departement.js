$(document).ready(function(){

    $('.nBtn, .table .eBtn').click(function(e){
        e.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text == 'Edit') {
            $.getJSON(href, function(response){
            //$('.myForm #kategoriId').val(response.kategoriId).hide(); ini aslinya
                $('.myForm #departementId').val(response.departementId).hide();
                $('.myForm #departementName').val(response.departementName);
            });
            $('.myForm #departementModal').modal();
        } else {
//         $('.myForm #kategoriId').val('0').hide(); ini aslinya
            $('.myForm #departementId').val('0').hide();

            $('.myForm #departementName').val('');
            $('.myForm #departementModal').modal();
        }

    });

    $('.rBtn').click(function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        $(".myRemoveDepartement .dBtn").attr('href',href);
        $('.myRemoveDepartement #departementModal').modal();

    });

});