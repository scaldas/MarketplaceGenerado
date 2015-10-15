(function(ng){
    var mod = ng.module('permisoModule');
    
    mod.service('permisoService', ['CrudCreator','permisoContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);
