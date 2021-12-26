var myMap;

// Дождёмся загрузки API и готовности DOM.
ymaps.ready(init);

function init () {
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
    var suggestView1 = new ymaps.SuggestView('suggest1');
    var suggestView2 = new ymaps.SuggestView('suggest');
}