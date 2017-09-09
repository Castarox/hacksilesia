function validate() {

        var f = document.getElementById("add-form").elements;
        var isDataValid = true;

        for (var i = 0; i < f.length; i++) {
            if (f[i].value.length == 0) isDataValid = false;
        }
    document.getElementById('sbt').disabled = !isDataValid;
}