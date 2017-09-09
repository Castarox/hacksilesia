var addForm = document.forms['add-form'];
addForm.addEventListener('submit', validate);

function validate(evt) {
    evt.preventDefault();

    if (addForm.name.value.length < 3 || addForm.name.value.value == "" ) {
        addForm.name.style.borderColor="#E33054";
        return false;
    }
    if (addForm.start.value.length < 3 || addForm.start.value.length =="" ) {
        addForm.start.style.borderColor="#E33054";
        return false;
    }
    if (addForm.end.value.length < 3 || addForm.end.value.length =="" ) {
        addForm.end.style.borderColor="#E33054";
        return false;
    }
    if (addForm.contact.value.length < 3 || addForm.contact.value.length =="" ) {
        addForm.contact.style.borderColor="#E33054";
        return false;
    }
    if (addForm.time.value.length < 3 || addForm.time.value.length =="" ) {
        addForm.time.style.borderColor="#E33054";
        return false;
    }
    if (addForm.others.value.length < 3 || addForm.others.value.length =="" ) {
        addForm.others.style.borderColor="#E33054";
        return false;
    }



    addForm.submit();
}