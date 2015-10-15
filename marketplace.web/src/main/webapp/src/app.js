(function (ng) {

    var mainApp = ng.module('mainApp', [
        //'ngCrudMock',
        'authModule',
        'empresaModule',
        'iVAModule',
        'ordenModule',
        'paqueteModule',
        'permisoModule',
        'precioUnitarioModule',
        'productoModule',
        'rolModule',
        'servicioModule',
        'usuarioModule',
        'ngRoute',
        'ngCrud'
    ]);

    mainApp.config(['$routeProvider', 'CrudTemplateURL', 'CrudCtrlAlias', function ($routeProvider, tplUrl, alias) {
            $routeProvider
                .when('/iVA', {
                    templateUrl: tplUrl,
                    controller: 'iVACtrl',
                    controllerAs: alias
                })
                .when('/paquete', {
                    templateUrl: tplUrl,
                    controller: 'paqueteCtrl',
                    controllerAs: alias
                })
                .when('/permiso', {
                    templateUrl: tplUrl,
                    controller: 'permisoCtrl',
                    controllerAs: alias
                })
                .when('/producto', {
                    templateUrl: tplUrl,
                    controller: 'productoCtrl',
                    controllerAs: alias
                })
                .when('/rol', {
                    templateUrl: tplUrl,
                    controller: 'rolCtrl',
                    controllerAs: alias
                })
                .when('/servicio', {
                    templateUrl: tplUrl,
                    controller: 'servicioCtrl',
                    controllerAs: alias
                })
                .when('/usuario', {
                    templateUrl: tplUrl,
                    controller: 'usuarioCtrl',
                    controllerAs: alias
                })
                .otherwise('/');
        }]);
})(window.angular);
