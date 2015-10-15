(function(ng){
    var mod = ng.module('paqueteModule');
    
    mod.service('paqueteService', ['CrudCreator','paqueteContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);
