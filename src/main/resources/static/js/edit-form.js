$(document).ready(function () {
    // setTimeout(startSet, 3000);
    $(window).load(startSet());
    $(window).load(endSet());
    function startSet() {
        var start_lati = $('#start').data("latitude");
        var start_long = $('#start').data("longitude");
        var url = "https://maps.googleapis.com/maps/api/geocode/json?latlng="+ start_lati + "," + start_long + "&key=AIzaSyClhLo7xcQp1G13D7VSR65oekjtwj1Llsc";
        $.ajax({
            url: url,
            type: 'get',

            success: function (data) {
                $('#start').val(data.results[1].formatted_address)
            },
            error: function (e) {
                alert("dupa")
            }
        });
    }

    function endSet() {
        var end_lati = $('#end').data("latitude");
        var end_long = $('#end').data("longitude");
        var url = "https://maps.googleapis.com/maps/api/geocode/json?latlng="+ end_lati + "," + end_long + "&key=AIzaSyClhLo7xcQp1G13D7VSR65oekjtwj1Llsc";
        $.ajax({
            url: url,
            type: 'get',

            success: function (data) {
                $('#end').val(data.results[1].formatted_address)
            },
            error: function (e) {
                alert("dupa")
            }
        });
    }

    $("#submit").click(function(e)  {
        e.preventDefault();
        alert("dupa");
        var name = $('#name').val();
        var select = $('#select').val();
        var contact = $('#contact').val();
        var time = $('#time').val();
        var others = $('#others').val();
        var start_latitude = $('#start').data("latitude");
        var start_longitude = $('#start').data("longitude");
        var end_latitude = $('#end').data("latitude");
        var end_longitude = $('#end').data("longitude");
        var link = $('#name').data("link");
        var url = "/track/" + link;
        alert(url);
        $.ajax({
            url: url,
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
            success: function () {
                alert("Udało ci się edytować");
                location.reload();
            },
            error: function (e) {
                alert("dupa")
            }
        });
    });

    $("#remove").on('click', function (e) {
        e.preventDefault();
        alert("jeste");
        var link = $('#name').data("link");
        $.ajax({
            url: "/track/remove",
            type: 'post',
            contentType: "application/json",
            dataType: 'json',
            data: JSON.stringify({
                    link: link
                }),

            success: function (data) {
                alert("Udało ci się usunąć");
                window.location.href ="/tracks";
            },
            error: function (e) {
                alert("dupa")
            }
        });
    })

});
