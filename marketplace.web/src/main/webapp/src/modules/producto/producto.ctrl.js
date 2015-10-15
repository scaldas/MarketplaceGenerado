(function (ng) {
    var mod = ng.module('productoModule');

    mod.controller('productoCtrl', ['CrudCreator', '$scope', 'productoService', 'productoModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'producto', 'Producto');
            this.fetchRecords();
        }]);

    mod.controller('serviciosCtrl', ['CrudCreator', '$scope', 'servicioModel', 'servicioService', function (CrudCreator, $scope, model, svc) {
            CrudCreator.extendAggChildCtrl(this, $scope, model, 'servicios', svc);
        }]);
})(window.angular);
