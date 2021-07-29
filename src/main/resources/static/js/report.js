$(document).ready(function(){

    $('.nBtn, .table .eBtn').click(function(e){
        e.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text == 'Edit') {
            $.getJSON(href, function(response){
            //$('.myForm #kategoriId').val(response.kategoriId).hide(); ini aslinya
                $('.myForm #reportId').val(response.reportId).hide();
                $('.myForm #namaReport').val(response.namaReport);
            });
            $('.myForm #exampleModal').modal();
        } else {
//         $('.myForm #kategoriId').val('0').hide(); ini aslinya
            $('.myForm #reportId').val('0').hide();

            $('.myForm #namaReport').val('');
            $('.myForm #exampleModal').modal();
        }

    });

    $('.rBtn').click(function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        $(".myRemove .dBtn").attr('href',href);
        $('.myRemove #exampleModal').modal();

    });

});