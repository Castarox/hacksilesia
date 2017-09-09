$(document).ready(function () {
    // $(window).keydown(function(event){
    //     if(event.keyCode == 13) {
    //         event.preventDefault();
    //         return false;
    //     }
    // });

   $("#submit").click(function()  {
       // $('.form').preventDefault();
       var name = $('#name').val();
       var select = $('#select').val();
       var contact = $('#contact').val();
       var time = $('#time').val();
       var others = $('#others').val();
       var start_latitude = $('#start').data("latitude");
       var start_longitude = $('#start').data("longitude");
       var end_latitude = $('#end').data("latitude");
       var end_longitude = $('#end').data("longitude");
       $.ajax({
           url: '/track/new',
           type: 'post',
           contentType: "application/json",
           dataType: 'json',
           data: JSON.stringify({name: name,
               start_latitude: start_latitude,
               start_longitude: start_longitude,
               end_latitude: end_latitude,
               end_longitude: end_longitude,
               space:select,
               telephone:contact,
               time:time,
               other:others}),
           success: function (data) {
               alert("Trasa stworzona twój link to http://localhost:8080/track/" + data['link'])
           },
           error: function (e) {
               alert("dupa")
           }
       });
   })
});