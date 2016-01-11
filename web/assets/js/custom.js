function passwordValidade(input) {
    if (input.value != document.getElementById('inputPassword').value) {
        input.setCustomValidity('As senhas não coincidem. Digite novamente');
    } else {
        input.setCustomValidity('');
    }
}

function maskData(input) {
    var data = input.value;
    if (data.length == 2) {
        data = data + '/';
        document.forms[0].data.value = data;
        return true;
    }
    if (data.length == 5) {
        data = data + '/';
        document.forms[0].data.value = data;
        return true;
    }
}

$(document).ready(function() {
    var ctrlDown = false;
    var ctrlKey = 17,
        cKey = 67,
        vKey = 86;

    $(document).keydown(function(e) {
        if (e.keyCode == ctrlKey) ctrlDown = true;
    }).keyup(function(e) {
        if (e.keyCode == ctrlKey) ctrlDown = false;
    });

    $(".no-paste").keydown(function(e) {
        if (ctrlDown && (e.keyCode == vKey || e.keyCode == cKey)) {
            return false;
        }
    });
});
