$(document).ready(function(){

    $('.nBtn, .table .eBtn').click(function(e){
        e.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text == 'Edit') {
            $.getJSON(href, function(response){
            //$('.myForm #kategoriId').val(response.kategoriId).hide(); ini aslinya
                $('.myForm #projectId').val(response.reportId).hide();
                $('.myForm #namaProject').val(response.namaProject);
                $('.myForm #keteranganProject').val(response.keteranganProject);
                $('.myForm #asalProject').val(response.asalProject);
                $('.myForm #durasiProject').val(response.durasiProject);
            });
            $('.myForm #projectModal').modal();
        } else {
//         $('.myForm #kategoriId').val('0').hide(); ini aslinya
            $('.myForm #projectId').val('0').hide()
            $('.myForm #namaProject').val('');
            $('.myForm #keteranganProject').val('');
            $('.myForm #asalProject').val('');
            $('.myForm #durasiProject').val('');
            $('.myForm #projectModal').modal();
        }

    });

    $('.rBtn').click(function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        $(".myRemove .dBtn").attr('href',href);
        $('.myRemove #projectModal').modal();

    });

});