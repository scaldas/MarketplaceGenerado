(function (ng) {
    var mod = ng.module('iVAModule');

    mod.controller('iVACtrl', ['CrudCreator', '$scope', 'iVAService', 'iVAModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'iVA', 'IVA');
            this.fetchRecords();
        }]);
})(window.angular);
