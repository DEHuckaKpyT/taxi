async function onLoadBodyHistory() {

    var newTd;
    var newTh;
    var myTable = document.getElementById("table-history");
    var newElem = document.createElement("caption");
    newElem.id = "table-caption";
    newElem.innerText = "История заказов";
    myTable.appendChild(newElem);

    var newTr = document.createElement("tr");

    newTh = document.createElement("th");
    newTh.innerText = "Дата, время";
    newTr.appendChild(newTh);

    newTh = document.createElement("th");
    newTh.innerText = "Стоимость";
    newTr.appendChild(newTh);

    newTh = document.createElement("th");
    newTh.innerText = "Тип автомобиля";
    newTr.appendChild(newTh);

    newTh = document.createElement("th");
    newTh.innerText = "Комментарий";
    newTr.appendChild(newTh);

    myTable.appendChild(newTr);


    var response = await fetch("http://localhost:5433/order/history");
    data = await response.json();


    for (let i = 0; i < data.length; i++) {
        newTr = document.createElement("tr");
        newTr.id = data[i].id;
        newTr.addEventListener('click', function (ev) {
            openOrderById(ev.target.parentElement.id);
        })

        newTd = document.createElement("td");
        newTd.innerText = data[i].createDateTime;
        newTr.appendChild(newTd);

        newTd = document.createElement("td");
        newTd.innerText = data[i].price + "p";
        newTr.appendChild(newTd);

        newTd = document.createElement("td");
        newTd.innerText = data[i].type;
        newTr.appendChild(newTd);

        newTd = document.createElement("td");
        newTd.innerText = data[i].comment;
        newTr.appendChild(newTd);

        myTable.appendChild(newTr);
    }
}

async function openOrderById(orderId) {
    var myTable = document.getElementById("table-history");
    myTable.style.display = "none";

    var newDiv = document.createElement("div");
    newDiv.id = "div-history-order";


    var response = await fetch("http://localhost:5433/order/" + orderId);
    data = await response.json();

    var newP;

    newP = document.createElement("p");
    newP.id = "history-order-createDateTime";
    newP.class = "history-order-text";
    newP.innerText = "Время создания заказа: " + data.createDateTime.replace("T", " ");
    newDiv.appendChild(newP);

    newP = document.createElement("p");
    newP.id = "history-order-points";
    newP.class = "history-order-text";
    newP.innerText = "От: " + data.points.replace(" ; ", "\nДо: ");
    newDiv.appendChild(newP);

    newP = document.createElement("p");
    newP.id = "history-order-price";
    newP.class = "history-order-text";
    newP.innerText = "Стоимость: " + data.price + "р";
    newDiv.appendChild(newP);

    newP = document.createElement("p");
    newP.id = "history-order-comment";
    newP.class = "history-order-text";
    newP.innerText = "Комментарий: " + data.comment;
    newDiv.appendChild(newP);

    newP = document.createElement("p");
    newP.id = "history-order-otherNumber";
    newP.class = "history-order-text";
    if (data.otherNumber != null)
        newP.innerText = "Запасной номер: " + data.otherNumber;
    else
        newP.innerText = "Запасной номер: не указан";
    newDiv.appendChild(newP);

    newP = document.createElement("p");
    newP.id = "history-order-type";
    newP.class = "history-order-text";
    newP.innerText = "Тип автомобиля: " + data.type.typeName;
    newDiv.appendChild(newP);

    var newButton = document.createElement("button");
    newButton.id = "button-history-order";
    newButton.class = "button";
    newButton.innerText = "Закрыть";
    newButton.onclick = buttonClose;

    newDiv.appendChild(newButton);

    var parentForm = document.getElementById("form-history");
    parentForm.appendChild(newDiv);
}

function buttonClose(){

    let div = document.getElementById("div-history-order");
    div.remove();

    var myTable = document.getElementById("table-history");
    myTable.style.display = "block";
    
}

