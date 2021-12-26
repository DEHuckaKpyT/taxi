var myFieldset = newElem = null;

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
    var data = await response.json();

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
        console.log(elementsByClassName[elem])
        console.log(elementsByClassName[elem].checked)
        console.log(data[elem])
    }
}

async function createOrder(){

}
