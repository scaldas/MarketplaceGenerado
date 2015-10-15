(function (ng) {
    var mod = ng.module('servicioModule');

    mod.controller('servicioCtrl', ['CrudCreator', '$scope', 'servicioService', 'servicioModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'servicio', 'Servicio');
            this.fetchRecords();
        }]);

    mod.controller('preciosCtrl', ['CrudCreator', '$scope', 'precioUnitarioModel', function (CrudCreator, $scope, model) {
            CrudCreator.extendCompChildCtrl(this, $scope, model, 'precios', 'paquete');
        }]);

    mod.controller('paquetesCtrl', ['CrudCreator', '$scope', 'paqueteModel', 'paqueteService', function (CrudCreator, $scope, model, svc) {
            CrudCreator.extendAggChildCtrl(this, $scope, model, 'paquetes', svc);
        }]);
})(window.angular);
