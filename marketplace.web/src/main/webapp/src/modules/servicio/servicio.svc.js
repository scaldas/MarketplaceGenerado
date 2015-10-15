(function(ng){
    var mod = ng.module('servicioModule');
    
    mod.service('servicioService', ['CrudCreator','servicioContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);
