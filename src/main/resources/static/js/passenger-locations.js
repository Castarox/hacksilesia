function initMap() {
    var uluru = {lat: -25.363, lng: 131.044};
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 4,
        center: uluru
    });
    var marker = new google.maps.Marker({
            position: uluru,
            map: map
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
    document.getElementById('start').setAttribute('data-latitude',latitude);
    document.getElementById('start').setAttribute('data-longitude',longitude);
}