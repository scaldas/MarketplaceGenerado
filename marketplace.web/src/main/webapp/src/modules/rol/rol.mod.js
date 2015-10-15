(function (ng) {
    var mod = ng.module('rolModule', ['ngCrud']);

    mod.constant('rolContext', 'rols');

    mod.constant('rolModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }], 
        childs: [{
                name: 'permisos',
                displayName: 'Permisos',
                //template: '', //override generic template
                ctrl: 'permisosCtrl'            }, {
                name: 'usuarios',
                displayName: 'Usuarios',
                //template: '', //override generic template
                ctrl: 'usuariosCtrl'            }        ]});
})(window.angular);
