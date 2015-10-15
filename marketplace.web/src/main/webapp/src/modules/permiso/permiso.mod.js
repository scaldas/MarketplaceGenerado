(function (ng) {
    var mod = ng.module('permisoModule', ['ngCrud']);

    mod.constant('permisoContext', 'permisos');

    mod.constant('permisoModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }, {
                name: 'url',
                displayName: 'Url',
                type: 'String',
                required: true
            }, {
                name: 'metodoRest',
                displayName: 'MetodoRest',
                type: 'String',
                required: true
            }], 
        childs: [{
                name: 'roles',
                displayName: 'Roles',
                //template: '', //override generic template
                ctrl: 'rolesCtrl'            }        ]});
})(window.angular);
