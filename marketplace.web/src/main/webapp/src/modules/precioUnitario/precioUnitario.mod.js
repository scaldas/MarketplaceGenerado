(function (ng) {
    var mod = ng.module('precioUnitarioModule', ['ngCrud']);

    mod.constant('precioUnitarioContext', 'precioUnitarios');

    mod.constant('precioUnitarioModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }, {
                name: 'precioUnidad',
                displayName: 'PrecioUnidad',
                type: 'Double',
                required: true
            }, {
                name: 'rangoInicial',
                displayName: 'RangoInicial',
                type: 'Integer',
                required: true
            }, {
                name: 'rangoFinal',
                displayName: 'RangoFinal',
                type: 'Integer',
                required: true
            }, {
                name: 'fechaInicioValidez',
                displayName: 'FechaInicioValidez',
                type: 'Date',
                required: true
            }, {
                name: 'fechaFinValidez',
                displayName: 'FechaFinValidez',
                type: 'Date',
                required: true
            }]});
})(window.angular);
