$(document).ready(function(){

    $('.nBtn, .table .eBtn').click(function(e){
        e.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text == 'Edit') {
            $.getJSON(href, function(response){
            //$('.myForm #userId').val(response.userId).hide(); ini aslinya
                $('.myForm #userId').val(response.roleId).hide();
                $('.myForm #firstName').val(response.firstName);
                $('.myForm #lastName').val(response.lastName);
                $('.myForm #email').val(response.email);
                $('.myForm #password').val(response.password);
            });
            $('.myForm #userModal').modal();
        } else {
//         $('.myForm #kategoriId').val('0').hide(); ini aslinya
            $('.myForm #userId').val('0').hide();
            $('.myForm #firstName').val('');
            $('.myForm #lastName').val('');
            $('.myForm #email').val('');
            $('.myForm #password').val('');
            $('.myForm #userModal').modal();
        }

    });

    $('.rBtn').click(function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        $(".myRemoveUser .dBtn").attr('href',href);
        $('.myRemoveUser #userModal').modal();

    });

});