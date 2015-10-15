(function(ng){
    var mod = ng.module('ordenModule');
    
    mod.service('ordenService', ['CrudCreator','ordenContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);
