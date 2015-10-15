(function(ng){
    var mod = ng.module('precioUnitarioModule');
    
    mod.service('precioUnitarioService', ['CrudCreator','precioUnitarioContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);
