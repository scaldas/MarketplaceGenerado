(function (ng) {
    var mod = ng.module('productoModule', ['ngCrud']);

    mod.constant('productoContext', 'productos');

    mod.constant('productoModel', {
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
            }], 
        childs: [{
                name: 'servicios',
                displayName: 'Servicios',
                //template: '', //override generic template
                ctrl: 'serviciosCtrl'            }        ]});
})(window.angular);
