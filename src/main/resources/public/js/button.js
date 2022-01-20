function myFunction() {

 fetch("/login", {
        credentials: 'include',
        method: 'POST',
        headers: {
            "Accept": "*/*",
            "Accept-Language": "en-US,en;q=0.5",
            "content-type": "application/x-www-form-urlencoded"
        },
        body: new URLSearchParams({
            'username': 'fn;ln',
            'password': 'pass',
        }),
        mode: 'cors',
    });
}

async function onLoadLogin(){

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