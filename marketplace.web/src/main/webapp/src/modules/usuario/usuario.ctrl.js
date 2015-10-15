(function (ng) {
    var mod = ng.module('usuarioModule');

    mod.controller('usuarioCtrl', ['CrudCreator', '$scope', 'usuarioService', 'usuarioModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'usuario', 'Usuario');
            this.fetchRecords();
        }]);

    mod.controller('empresasCtrl', ['CrudCreator', '$scope', 'empresaModel', function (CrudCreator, $scope, model) {
            CrudCreator.extendCompChildCtrl(this, $scope, model, 'empresas', 'usuario');
        }]);

    mod.controller('rolesCtrl', ['CrudCreator', '$scope', 'rolModel', 'rolService', function (CrudCreator, $scope, model, svc) {
            CrudCreator.extendAggChildCtrl(this, $scope, model, 'roles', svc);
        }]);
})(window.angular);
