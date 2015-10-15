(function(ng){
    var mod = ng.module('empresaModule');
    
    mod.service('empresaService', ['CrudCreator','empresaContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);
