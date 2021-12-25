async function profileLoad() {
    let response = await fetch("http://localhost:5433/user/get");
    let data = await response.json();

    document.getElementById("text-profile-lastname").innerText = "Фамилия: " + data.lastname;
    document.getElementById("text-profile-firstname").innerText = "Имя: " + data.firstname;
    document.getElementById("text-profile-phone").innerText = "Телефон: " + data.number;
    document.getElementById("text-profile-email").innerText = "Почта: " + data.email;
    document.getElementById("text-profile-username").innerText = "Логин: " + data.username;








}