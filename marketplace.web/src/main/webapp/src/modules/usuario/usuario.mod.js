(function (ng) {
    var mod = ng.module('usuarioModule', ['ngCrud']);

    mod.constant('usuarioContext', 'usuarios');

    mod.constant('usuarioModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }, {
                name: 'correoElectronico',
                displayName: 'CorreoElectronico',
                type: 'String',
                required: true
            }, {
                name: 'contrasenia',
                displayName: 'Contrasenia',
                type: 'String',
                required: true
            }, {
                name: 'cargo',
                displayName: 'Cargo',
                type: 'String',
                required: true
            }, {
                name: 'nombresContacto',
                displayName: 'NombresContacto',
                type: 'String',
                required: true
            }, {
                name: 'apellidosContacto',
                displayName: 'ApellidosContacto',
                type: 'String',
                required: true
            }], 
        childs: [{
                name: 'roles',
                displayName: 'Roles',
                //template: '', //override generic template
                ctrl: 'rolesCtrl'            }, {
                name: 'empresas',
                displayName: 'Empresas',
                //template: '', //override generic template
                ctrl: 'empresasCtrl'            }        ]});
})(window.angular);
