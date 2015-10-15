(function (ng) {
    var mod = ng.module('permisoModule');

    mod.controller('permisoCtrl', ['CrudCreator', '$scope', 'permisoService', 'permisoModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'permiso', 'Permiso');
            this.fetchRecords();
        }]);

    mod.controller('rolesCtrl', ['CrudCreator', '$scope', 'rolModel', 'rolService', function (CrudCreator, $scope, model, svc) {
            CrudCreator.extendAggChildCtrl(this, $scope, model, 'roles', svc);
        }]);
})(window.angular);
