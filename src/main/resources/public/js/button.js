function myFunction() {



 fetch("http://localhost:5433/login", {
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





    // 1. Создаём новый XMLHttpRequest-объект
//    let xhr = new XMLHttpRequest();

    // 2. Настраиваем его: GET-запрос по URL /article/.../load
    // xhr.open('GET', 'http://google.com');
//    xhr.open('GET', '/test');
    // xhr.open('GET', 'http://127.0.0.1:3002/test.html');
    // xhr.setRequestHeader('Authorization', 'Basic Zm47bG47cGFzcw==')
    // xhr.responseType = "document";

    // 3. Отсылаем запрос
//    xhr.send();
    // window.location = "http://127.0.0.1:5433/test";
//    window.open("/test");
    // window.location.href = xhr.responseText;

    // 4. Этот код сработает после того, как мы получим ответ сервера
    // xhr.onload = function () {
    //     if (xhr.status != 200) { // анализируем HTTP-статус ответа, если статус не 200, то произошла ошибка
    //         alert(`Ошибка ${xhr.status}: ${xhr.statusText}`); // Например, 404: Not Found
    //     } else { // если всё прошло гладко, выводим результат
    //         alert(`Готово, получили ${xhr.response.length} байт`); // response -- это ответ сервера
    //     }
    // };

    // xhr.onprogress = function (event) {
    //     if (event.lengthComputable) {
    //         alert(`Получено ${event.loaded} из ${event.total} байт`);
    //     } else {
    //         alert(`Получено ${event.loaded} байт`); // если в ответе нет заголовка Content-Length
    //     }

    // };

    // xhr.onerror = function () {
    //     alert("Запрос не удался");
    // };

}