(function(ng){
    var mod = ng.module('usuarioModule');
    
    mod.service('usuarioService', ['CrudCreator','usuarioContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);
