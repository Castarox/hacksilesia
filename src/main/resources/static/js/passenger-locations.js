var map;
var address;
function initMap() {
    var poland_center = {lat: 52.151445, lng: 19.158053};
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 8,
        center: poland_center
    });
    var user_input = document.getElementById('start');
    autocomplete_start = new google.maps.places.Autocomplete(
        (user_input),
        {types: ['geocode']}
        );
    autocomplete_start.setComponentRestrictions(
        {'country': ['pl']}
    );
    autocomplete_start.addListener('place_changed', setStartLatLon);
    }

function setStartLatLon() {
    var place = autocomplete_start.getPlace();
    var latitude = place.geometry.location.lat();
    var longitude = place.geometry.location.lng();
    var distance = 1;


    var image = 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png';
    var myMarker = new google.maps.Marker({
        position: {lat: latitude, lng: longitude},
        map: map,
        animation: google.maps.Animation.DROP,
        icon: image,
        title: 'me'
    });

    $.ajax({
    url: '/passenger/start/' + latitude + '/' + longitude + '/' + distance,
    type: 'get',
    success: function (data) {
        data.forEach(function (track) {
            var lat = track['startLatitude'];
            var lng = track['startLongitude'];
            var track_position = {lat: lat, lng: lng};
            var link = '/track/' +  track['id'];
            var time = track['time'];
            var url = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + lat + "," + lng + "&key=AIzaSyBAmG56Uzmyg04aMF30VHC0V_37n25DfDg";
            var address;
            $.ajax({
                url: url,
                type: 'get',
                success: function (googleObj) {
                    address = googleObj.results[1].formatted_address;
                    console.log(address);
                    var contentString =
                    '<div id="content">'+
                    '<div id="siteNotice">'+
                    '</div>'+
                    '<h1 id="firstHeading" class="firstHeading">' + time + '</h1>'+
                    '<div id="bodyContent">'+
                    '<p><h3><b>JEDZIE DO :' + track['endCity'] + ' </b></h3>' +
                    '<a href=' + link + '>'+
                    'LINK DO OGŁOSZENIA</a> '+
                    '</div>'+
                    '</div>';
                    var infowindow = new google.maps.InfoWindow({
                    content: contentString
                    });
                    var marker = new google.maps.Marker({
                    position: track_position,
                    map: map,
                    title: track['name']
                    });
                    marker.addListener('click', function() {
                    infowindow.open(map, marker);
                    });
                    },
                error: function (e) {
                    alert(e);
                }
            });
        });
        var center = new google.maps.LatLng(latitude, longitude);
        map.panTo(center);
        smoothZoom(map, 17, map.getZoom());
    },
        error: function (e) {
           console.log(e);
        }
    });
}

function smoothZoom (map, max, cnt) {
    if (cnt >= max) {
        return;
    }
    else {
        z = google.maps.event.addListener(map, 'zoom_changed', function(event){
            google.maps.event.removeListener(z);
            smoothZoom(map, max, cnt + 1);
        });
        setTimeout(function(){map.setZoom(cnt)}, 150);
    }
}

function getAddress(lat, lng) {
    var url = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + lat + "," + lng + "&key=AIzaSyClhLo7xcQp1G13D7VSR65oekjtwj1Llsc";
    $.ajax({
        url: url,
        type: 'get',
        success: function (googleObj) {
            console.log(googleObj.results[1].formatted_address);
            address = googleObj.results[1].formatted_address;

        },
        error: function (e) {
            alert(e);
        }
    })
}