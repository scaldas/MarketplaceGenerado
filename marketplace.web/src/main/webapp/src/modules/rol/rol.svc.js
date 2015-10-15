(function(ng){
    var mod = ng.module('rolModule');
    
    mod.service('rolService', ['CrudCreator','rolContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);
