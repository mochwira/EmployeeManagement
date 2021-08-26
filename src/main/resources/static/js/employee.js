$(document).ready(function(){

    $('.nBtn, .table .eBtn').click(function(e){
        e.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text == 'Edit') {
            $.getJSON(href, function(response){
            //$('.myForm #userId').val(response.userId).hide(); ini aslinya
                $('.myForm #employeeId').val(response.employeeId).hide();
                $('.myForm #firstName').val(response.firstName);
                $('.myForm #lastName').val(response.lastName);
                $('.myForm #email').val(response.email);
                $('.myForm #departementId').val(response.departementId);
                $('.myForm #userId').val(response.userId);
            });
            $('.myForm #employeeModal').modal();
        } else {
//         $('.myForm #kategoriId').val('0').hide(); ini aslinya
            $('.myForm #employeeId').val('0').hide();
            $('.myForm #firstName').val('');
            $('.myForm #lastName').val('');
            $('.myForm #email').val('');
            $('.myForm #departementId').val('');
            $('.myForm #userId').val('');
            $('.myForm #employeeModal').modal();
        }

    });

    $('.rBtn').click(function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        $(".myRemoveEmployee .dBtn").attr('href',href);
        $('.myRemoveEmployee #employeeModal').modal();

    });

});