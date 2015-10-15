(function (ng) {
    var mod = ng.module('paqueteModule', ['ngCrud']);

    mod.constant('paqueteContext', 'paquetes');

    mod.constant('paqueteModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }, {
                name: 'descripcion',
                displayName: 'Descripcion',
                type: 'String',
                required: true
            }, {
                name: 'activo',
                displayName: 'Activo',
                type: 'Boolean',
                required: true
            }], 
        childs: [{
                name: 'ordenes',
                displayName: 'Ordenes',
                //template: '', //override generic template
                ctrl: 'ordenesCtrl'            }, {
                name: 'servicios',
                displayName: 'Servicios',
                //template: '', //override generic template
                ctrl: 'serviciosCtrl'            }        ]});
})(window.angular);
