$(document).ready(function(){

    $('.nBtn, .table .eBtn').click(function(e){
        e.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text == 'Edit') {
            $.getJSON(href, function(response){
            //$('.myForm #kategoriId').val(response.kategoriId).hide(); ini aslinya
                $('.myForm #reportId').val(response.reportId).hide();
                $('.myForm #reportName').val(response.reportName);
                $('.myForm #kategoriId').val(response.kategoriId);
                $('.myForm #reportDetail').val(response.reportDetail);
                $('.myForm #reportTime').val(response.reportTime);
            });
            $('.myForm #exampleModal').modal();
        } else {
//         $('.myForm #kategoriId').val('0').hide(); ini aslinya
            $('.myForm #reportId').val('0').hide();

            $('.myForm #reportName').val('');
            $('.myForm #kategoriId').val('');
            $('.myForm #reportDetail').val('');
            $('.myForm #reportTime').val('');
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