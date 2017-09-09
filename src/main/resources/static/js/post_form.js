$(document).ready(function () {

   $("#add-form").change(function () {
       var name = $('#name').val();
       var select = $('#select').val();
       var contact = $('#contact').val();
       var time = $('#time').val();
       var others = $('#others').val();
       if (name.length >= 3){
           if (contact.length >= 9){
               if($('#start').length > 0){
                   if ($('#end').length > 0){
                       $('#submit').attr("disabled", false);
                   }else {
                       $('#submit').attr("disabled", true);
                   }
               }else {
                   $('#submit').attr("disabled", true);

               }
           }else {
               $('#submit').attr("disabled", true);
           }
       }else {
           $('#submit').attr("disabled", true);
       }
   });

   $('#back').click(function (e) {
       e.preventDefault();
       window.location.href ="/tracks";
       return (false);
   });

   $("#add-form").submit(function(e)  {
       e.preventDefault();
       var name = $('#name').val();
       var select = $('#select').val();
       var contact = $('#contact').val();
       var time = $('#time').val();
       var others = $('#others').val();
       var startCity = $('#start').val();
       var endCity = $('#end').val();
       $.ajax({
           url: '/track/new',
           type: 'post',
           contentType: "application/json",
           dataType: 'json',
           data: JSON.stringify({name: name,
               startCity: startCity,
               endCity: endCity,
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