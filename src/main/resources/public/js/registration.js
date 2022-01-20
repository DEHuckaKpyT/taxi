async function onLoadBodyRegistration() {
    $.fn.setCursorPosition = function (pos) {
        if ($(this).get(0).setSelectionRange) {
            $(this).get(0).setSelectionRange(pos, pos);
        } else if ($(this).get(0).createTextRange) {
            var range = $(this).get(0).createTextRange();
            range.collapse(true);
            range.moveEnd('character', pos);
            range.moveStart('character', pos);
            range.select();
        }
    };

    $("#input-box-number-registration").click(function () {
        $(this).setCursorPosition(4);
    }).mask("+7 (999) 999-99-99");
    // }).mask("8(999) 999-9999",{autoclear: false});

    var response = await fetch("/user/auth");
    data = await response.json();

    var newA;
    newA = document.createElement("a");
    newA.id = "text-index-create-order";
    newA.class = "text";
    newA.href = "/index";
    newA.innerText = "Заказать";
    document.body.appendChild(newA);

    if (data.flag) {
        newA = document.createElement("a");
        newA.id = "text-index-logout";
        newA.class = "text";
        newA.href = "/logout";
        newA.innerText = "Выйти";
        document.body.appendChild(newA);
        newA = document.createElement("a");
        newA.id = "text-index-history";
        newA.class = "text";
        newA.href = "/history";
        newA.innerText = "История";
        document.body.appendChild(newA);
        newA = document.createElement("a");
        newA.id = "text-index-profile";
        newA.class = "text";
        newA.href = "/profile";
        newA.innerText = "Профиль";
        document.body.appendChild(newA);
    } else {
        newA = document.createElement("a");
        newA.id = "text-index-login";
        newA.class = "text";
        newA.href = "/<c:url value=\"/logout\" />";
        newA.innerText = "Войти";
        document.body.appendChild(newA);
    }
}
async function createUser() {

    let url = "/user/create";
    let requestData = {
        "lastname": document.getElementById('input-box-lastname-registration').value,
        "firstname": document.getElementById('input-box-firstname-registration').value,
        "number": document.getElementById('input-box-number-registration').value,
        "email": document.getElementById('input-box-email-registration').value,
        "username": document.getElementById('input-box-login-registration').value,
        "password": document.getElementById('input-box-password-registration').value
    };

    // Default options are marked with *
    const response = await fetch(url, {
        method: 'POST', // *GET, POST, PUT, DELETE, etc.
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'include', // include, *same-origin, omit
        headers: {
            'Content-Type': 'application/json'
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer', // no-referrer, *client
        body: JSON.stringify(requestData) // body data type must match "Content-Type" header
    })
        .catch(error => alert(error.message))

    let responseData = await response.json();
    if (response.ok) {
        alert("Успешно!");
        window.open("/login", "_self");
    } else {
        alert("Ошибка: " + responseData.message);
    }
}