function onLoadBodyRegistration() {
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
}

// function submitRegistrationForm(event) {
//     event.preventDefault();
//
//     const response = postData("/user/create",
//         {
//             "lastname": event.target['input-box-lastname-registration'].value,
//             "firstname": event.target['input-box-firstname-registration'].value,
//             "number": event.target['input-box-number-registration'].value,
//             "email": event.target['input-box-email-registration'].value,
//             "username": event.target['input-box-login-registration'].value,
//             "password": event.target['input-box-password-registration'].value
//         })
//         .then((data) => {
//             console.log(data); // JSON data parsed by `response.json()` call
//         });
//     console.log(response);
//
//     if (response == null) window.open("/login", "_self");
//     else alert(response);
// }

async function createUser() {

    let url = "http://localhost:5433/user/create";
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