(function(ng){
    var mod = ng.module('iVAModule');
    
    mod.service('iVAService', ['CrudCreator','iVAContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);
