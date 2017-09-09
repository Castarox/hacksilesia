var map;
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
    var distance = 5;

    $.ajax({
    url: '/passenger/start/' + latitude + '/' + longitude + '/' + distance,
    type: 'get',
    success: function (data) {
        data.forEach(function (track) {
            var track_position = {lat: track['startLatitude'], lng: track['startLongitude']};
            new google.maps.Marker({
            position: track_position,
            map: map
            });
        });
        var center = new google.maps.LatLng(latitude, longitude);
        map.panTo(center);
        smoothZoom(map, 16, map.getZoom());
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