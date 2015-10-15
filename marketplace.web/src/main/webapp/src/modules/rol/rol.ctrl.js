(function (ng) {
    var mod = ng.module('rolModule');

    mod.controller('rolCtrl', ['CrudCreator', '$scope', 'rolService', 'rolModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'rol', 'Rol');
            this.fetchRecords();
        }]);

    mod.controller('permisosCtrl', ['CrudCreator', '$scope', 'permisoModel', 'permisoService', function (CrudCreator, $scope, model, svc) {
            CrudCreator.extendAggChildCtrl(this, $scope, model, 'permisos', svc);
        }]);

    mod.controller('usuariosCtrl', ['CrudCreator', '$scope', 'usuarioModel', 'usuarioService', function (CrudCreator, $scope, model, svc) {
            CrudCreator.extendAggChildCtrl(this, $scope, model, 'usuarios', svc);
        }]);
})(window.angular);
