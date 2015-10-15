(function (ng) {
    var mod = ng.module('paqueteModule');

    mod.controller('paqueteCtrl', ['CrudCreator', '$scope', 'paqueteService', 'paqueteModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'paquete', 'Paquete');
            this.fetchRecords();
        }]);

    mod.controller('ordenesCtrl', ['CrudCreator', '$scope', 'ordenModel', 'ordenService', function (CrudCreator, $scope, model, svc) {
            CrudCreator.extendAggChildCtrl(this, $scope, model, 'ordenes', svc);
        }]);

    mod.controller('serviciosCtrl', ['CrudCreator', '$scope', 'servicioModel', 'servicioService', function (CrudCreator, $scope, model, svc) {
            CrudCreator.extendAggChildCtrl(this, $scope, model, 'servicios', svc);
        }]);
})(window.angular);
