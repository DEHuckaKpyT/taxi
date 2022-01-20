async function profileLoad() {
    let response = await fetch("/user/get");
    let data = await response.json();

    document.getElementById("text-profile-lastname").innerText = "Фамилия: " + data.lastname;
    document.getElementById("text-profile-firstname").innerText = "Имя: " + data.firstname;
    document.getElementById("text-profile-phone").innerText = "Телефон: " + data.number;
    document.getElementById("text-profile-email").innerText = "Почта: " + data.email;
    document.getElementById("text-profile-username").innerText = "Логин: " + data.username;

    response = await fetch("/user/auth");
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