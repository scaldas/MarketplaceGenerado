(function(ng){
    var mod = ng.module('productoModule');
    
    mod.service('productoService', ['CrudCreator','productoContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);
