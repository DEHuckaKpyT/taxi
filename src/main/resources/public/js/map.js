var myMap;
var multiRoute;
var distance;
var duration;
// Дождёмся загрузки API и готовности DOM.
ymaps.ready(init);

function init() {

    // Создание экземпляра карты и его привязка к контейнеру с
    // заданным id ("map").
    myMap = new ymaps.Map('map', {
        // При инициализации карты обязательно нужно указать
        // её центр и коэффициент масштабирования.
        center: [48.480229, 135.071917], // Хабаровск
        zoom: 12
    }, {
        searchControlProvider: 'yandex#search'
    });

    // Подключаем поисковые подсказки к полю ввода.
    var suggestView1 = new ymaps.SuggestView('suggest1'),
        placemark1;
    var suggestView2 = new ymaps.SuggestView('suggest'),
        placemark2;

    let address1 = '';
    let address2 = '';

    // При клике по кнопке запускаем верификацию введёных данных.
    $('#button1').bind('click', function (e) {
        geocode1();
    });
    $('#button2').bind('click', function (e) {
        geocode2();
    });

    function geocode1() {
        address1 = '';
        distance='';
        myMap.geoObjects.remove(multiRoute);
        // Забираем запрос из поля ввода.
        var request = $('#suggest1').val();
        // Геокодируем введённые данные.
        ymaps.geocode(request).then(function (res) {
            var obj = res.geoObjects.get(0),
                error, hint;

            if (obj) {
                // Об оценке точности ответа геокодера можно прочитать тут: https://tech.yandex.ru/maps/doc/geocoder/desc/reference/precision-docpage/
                switch (obj.properties.get('metaDataProperty.GeocoderMetaData.precision')) {
                    case 'exact':
                        break;
                    case 'number':
                    case 'near':
                    case 'range':
                        error = 'Неточный адрес, требуется уточнение';
                        hint = 'Уточните номер дома';
                        break;
                    case 'street':
                        error = 'Неполный адрес, требуется уточнение';
                        hint = 'Уточните номер дома';
                        break;
                    case 'other':
                    default:
                        error = 'Неточный адрес, требуется уточнение';
                        hint = 'Уточните адрес';
                }
            } else {
                error = 'Адрес не найден';
                hint = 'Уточните адрес';
            }

            // Если геокодер возвращает пустой массив или неточный результат, то показываем ошибку.
            if (error) {
                showError1(error);
                showMessage1(hint);
            } else {
                showResult1(obj);
            }
        }, function (e) {
            console.log(e)
        })

    }

    function showResult1(obj) {
        // Удаляем сообщение об ошибке, если найденный адрес совпадает с поисковым запросом.
        $('#suggest1').removeClass('input_error');
        $('#notice1').css('display', 'none');

        var mapContainer = $('#map'),
            bounds = obj.properties.get('boundedBy'),
            // Рассчитываем видимую область для текущего положения пользователя.
            mapState = ymaps.util.bounds.getCenterAndZoom(
                bounds,
                [mapContainer.width(), mapContainer.height()]
            ),
            // Сохраняем полный адрес для сообщения под картой.
            address = [obj.getCountry(), obj.getAddressLine()].join(', '),
            // Сохраняем укороченный адрес для подписи метки.
            shortAddress = [obj.getThoroughfare(), obj.getPremiseNumber(), obj.getPremise()].join(' ');
        // Убираем контролы с карты.
        mapState.controls = [];
        // Создаём карту.
        createMap1(mapState, shortAddress);
        // Выводим сообщение под картой.
        address1 = address;
        showMessage1(address);
        createRoute();
    }

    function showError1(message) {
        // $('#notice').text(message);
        // $('#suggest1').addClass('input_error');
        // $('#notice').css('display', 'block');
        // Удаляем карту.
        // if (map) {
        //     map.destroy();
        //     map = null;
        // }
    }

    function createMap1(state, caption) {
        // Если карта еще не была создана, то создадим ее и добавим метку с адресом.
        // if (!map) {
        //     map = new ymaps.Map('map', state);
        placemark1 = new ymaps.Placemark(
            myMap.getCenter(), {
                iconCaption: caption,
                balloonContent: caption
            }, {
                preset: 'islands#redDotIconWithCaption'
            });
        myMap.geoObjects.add(placemark1);
        //     // Если карта есть, то выставляем новый центр карты и меняем данные и позицию метки в соответствии с найденным адресом.
        // } else {
        myMap.setCenter(state.center, state.zoom);
        placemark1.geometry.setCoordinates(state.center);
        placemark1.properties.set({iconCaption: caption, balloonContent: caption});
        // }
    }

    function showMessage1(message) {
        // $('#messageHeader').text('Данные получены:');
        $('#message1').text(message);
    }

    function geocode2() {
        address2 = '';
        distance='';
        myMap.geoObjects.remove(multiRoute);
        // Забираем запрос из поля ввода.
        var request = $('#suggest').val();
        // Геокодируем введённые данные.
        ymaps.geocode(request).then(function (res) {
            var obj = res.geoObjects.get(0),
                error, hint;

            if (obj) {
                // Об оценке точности ответа геокодера можно прочитать тут: https://tech.yandex.ru/maps/doc/geocoder/desc/reference/precision-docpage/
                switch (obj.properties.get('metaDataProperty.GeocoderMetaData.precision')) {
                    case 'exact':
                        break;
                    case 'number':
                    case 'near':
                    case 'range':
                        error = 'Неточный адрес, требуется уточнение';
                        hint = 'Уточните номер дома';
                        break;
                    case 'street':
                        error = 'Неполный адрес, требуется уточнение';
                        hint = 'Уточните номер дома';
                        break;
                    case 'other':
                    default:
                        error = 'Неточный адрес, требуется уточнение';
                        hint = 'Уточните адрес';
                }
            } else {
                error = 'Адрес не найден';
                hint = 'Уточните адрес';
            }

            // Если геокодер возвращает пустой массив или неточный результат, то показываем ошибку.
            if (error) {
                showError2(error);
                showMessage2(hint);
            } else {
                showResult2(obj);
            }
        }, function (e) {
            console.log(e)
        })

    }

    function showResult2(obj) {
        // Удаляем сообщение об ошибке, если найденный адрес совпадает с поисковым запросом.
        $('#suggest').removeClass('input_error');
        $('#notice2').css('display', 'none');

        var mapContainer = $('#map'),
            bounds = obj.properties.get('boundedBy'),
            // Рассчитываем видимую область для текущего положения пользователя.
            mapState = ymaps.util.bounds.getCenterAndZoom(
                bounds,
                [mapContainer.width(), mapContainer.height()]
            ),
            // Сохраняем полный адрес для сообщения под картой.
            address = [obj.getCountry(), obj.getAddressLine()].join(', '),
            // Сохраняем укороченный адрес для подписи метки.
            shortAddress = [obj.getThoroughfare(), obj.getPremiseNumber(), obj.getPremise()].join(' ');
        // Убираем контролы с карты.
        mapState.controls = [];
        // Создаём карту.
        createMap2(mapState, shortAddress);
        // Выводим сообщение под картой.
        address2 = address;
        showMessage2(address);
        createRoute();
    }

    function showError2(message) {
        // $('#notice').text(message);
        // $('#suggest1').addClass('input_error');
        // $('#notice').css('display', 'block');
        // Удаляем карту.
        // if (map) {
        //     map.destroy();
        //     map = null;
        // }
    }

    function createMap2(state, caption) {
        // Если карта еще не была создана, то создадим ее и добавим метку с адресом.
        // if (!map) {
        //     map = new ymaps.Map('map', state);
        placemark2 = new ymaps.Placemark(
            myMap.getCenter(), {
                iconCaption: caption,
                balloonContent: caption
            }, {
                preset: 'islands#redDotIconWithCaption'
            });
        myMap.geoObjects.add(placemark2);
        //     // Если карта есть, то выставляем новый центр карты и меняем данные и позицию метки в соответствии с найденным адресом.
        // } else {
        myMap.setCenter(state.center, state.zoom);
        placemark2.geometry.setCoordinates(state.center);
        placemark2.properties.set({iconCaption: caption, balloonContent: caption});
        // }
    }

    function showMessage2(message) {
        // $('#messageHeader').text('Данные получены:');
        $('#message2').text(message);
    }

    function createRoute() {

        if (address1 === '' || address2 === '') return;

        myMap.geoObjects.remove(placemark1);
        myMap.geoObjects.remove(placemark2);

        // Построение маршрута.
        // По умолчанию строится автомобильный маршрут.
        multiRoute = new ymaps.multiRouter.MultiRoute({
            // Точки маршрута. Точки могут быть заданы как координатами, так и адресом.
            referencePoints: [
                address1,
                address2
            ],
            params: {
                avoidTrafficJams: true
            }
        }, {
            // Автоматически устанавливать границы карты так,
            // чтобы маршрут был виден целиком.
            boundsAutoApply: true
        });

// Добавление маршрута на карту.
        myMap.geoObjects.add(multiRoute);

        multiRoute.model.events.add('requestsuccess', function () {
            // Получение ссылки на активный маршрут.
            // В примере используется автомобильный маршрут,
            // поэтому метод getActiveRoute() вернет объект multiRouter.driving.Route.
            var activeRoute = multiRoute.getActiveRoute();
            // Вывод информации о маршруте.
            console.log("Длина: " + activeRoute.properties.get("distance").text);
            console.log("Время прохождения: " + activeRoute.properties.get("duration").text);
            distance = activeRoute.properties.get("distance").text;
            duration = activeRoute.properties.get("duration").text;
            document.getElementById("text-distance").innerText = "Длина: " + distance;
            document.getElementById("text-duration").innerText = "Время прохождения: " + duration;

            getPrice();
        });
        // Добавление маршрута на карту.
        myMap.geoObjects.add(multiRoute);
    }
}
