(function (ng) {
    var mod = ng.module('servicioModule', ['ngCrud']);

    mod.constant('servicioContext', 'servicios');

    mod.constant('servicioModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }], 
        childs: [{
                name: 'precios',
                displayName: 'Precios',
                //template: '', //override generic template
                ctrl: 'preciosCtrl'            }, {
                name: 'paquetes',
                displayName: 'Paquetes',
                //template: '', //override generic template
                ctrl: 'paquetesCtrl'            }        ]});
})(window.angular);
