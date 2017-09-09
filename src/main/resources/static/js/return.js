$(document).ready()
{
    $(function () {
        var buttonpressed;
        $('.submit').click(function () {
            buttonpressed = $(this).attr('name');
        });
        $('form').submit(function (e) {
            if (buttonpressed === "back"){
                e.preventDefault();
                window.location.href ="/tracks";
                return (false);
            }
            buttonpressed = '';
            return (true);
        })
    })
}