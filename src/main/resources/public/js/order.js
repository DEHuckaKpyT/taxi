var myFieldset = newElem = null;
var data = null;

async function onLoadBodyOrder() {
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

    $("#text-number-order").click(function () {
        $(this).setCursorPosition(4);
    }).mask("+7 (999) 999-99-99");
    // }).mask("8(999) 999-9999",{autoclear: false});


    var response = await fetch("http://localhost:5433/option/list");
    data = await response.json();

    var newElem = document.createElement("p");
    let htmlText = "";
    for (var elem in data) {
        htmlText = htmlText + "<p><input type=\"checkbox\" class=\"check-box\">" + data[elem].optionName + "</p>";
    }

    newElem.innerHTML = htmlText;
    myFieldset = document.getElementById("fieldset-order");
    myFieldset.appendChild(newElem);

    let elementsByClassName = myFieldset.getElementsByClassName("check-box");

    for (var i = 0; i < elementsByClassName.length; i++) {
        console.log(elementsByClassName[i])
        console.log(elementsByClassName[i].checked)
        elementsByClassName[i].addEventListener('change', (event) => {
            getPrice();
        })
        console.log(data[i])
    }

    document.getElementById("select-order").addEventListener('change', (event) => {
        getPrice();
    });
}

async function createOrder() {

    let options = [];
    let elementsByClassName = myFieldset.getElementsByClassName("check-box");

    for (var i = 0; i < elementsByClassName.length; i++) {
        let item = {'optionName': data[i].optionName, 'value': elementsByClassName[i].checked}
        options.push(item);
    }
    let requestData = {
        "addressFrom": document.getElementById('suggest1').value,
        "addressTo": document.getElementById('suggest').value,
        "distance": distance,
        "comment": document.getElementById('text-order-comment').value,
        // "tip": parseInt(document.getElementById('text-order-tip').value, 10),//parseInt(x, base);
        "otherNumber": document.getElementById('text-number-order').value,
        "type": document.getElementById('select-order').options[document.getElementById('select-order').selectedIndex].text
    };
    requestData.options = options;
    let url = "/order/create";

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
        window.open("/index", "_self");
    } else {
        alert("Ошибка: " + responseData.message);
    }
}

async function getPrice() {
    let options = [];
    let elementsByClassName = myFieldset.getElementsByClassName("check-box");

    for (var i = 0; i < elementsByClassName.length; i++) {
        let item = {'optionName': data[i].optionName, 'value': elementsByClassName[i].checked}
        options.push(item);
    }
    let requestData = {
        "addressFrom": document.getElementById('suggest1').value,
        "addressTo": document.getElementById('suggest').value,
        "distance": distance,
        "comment": document.getElementById('text-order-comment').value,
        // "tip": document.getElementById('text-order-tip').value,
        "otherNumber": document.getElementById('text-number-order').value,
        "type": document.getElementById('select-order').options[document.getElementById('select-order').selectedIndex].text
    };
    requestData.options = options;
    let url = "/order/getprice";

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
        document.getElementById('text-totalcost').innerText = "Стоимость: " + responseData.price + "p";

    } else {
        // alert("Ошибка: " + responseData.message);
    }
}
