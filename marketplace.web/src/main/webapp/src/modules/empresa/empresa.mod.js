(function (ng) {
    var mod = ng.module('empresaModule', ['ngCrud']);

    mod.constant('empresaContext', 'empresas');

    mod.constant('empresaModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }, {
                name: 'nit',
                displayName: 'Nit',
                type: 'String',
                required: true
            }, {
                name: 'actividadEconomica',
                displayName: 'ActividadEconomica',
                type: 'Integer',
                required: true
            }, {
                name: 'direccion',
                displayName: 'Direccion',
                type: 'String',
                required: true
            }, {
                name: 'ciudad',
                displayName: 'Ciudad',
                type: 'String',
                required: true
            }, {
                name: 'telefono',
                displayName: 'Telefono',
                type: 'String',
                required: true
            }, {
                name: 'fax',
                displayName: 'Fax',
                type: 'String',
                required: true
            }, {
                name: 'paginaWeb',
                displayName: 'PaginaWeb',
                type: 'String',
                required: true
            }, {
                name: 'nombresRepresentateLegal',
                displayName: 'NombresRepresentateLegal',
                type: 'String',
                required: true
            }, {
                name: 'apellidosRepresentanteLegal',
                displayName: 'ApellidosRepresentanteLegal',
                type: 'String',
                required: true
            }, {
                name: 'tipoEmpresa',
                displayName: 'TipoEmpresa',
                type: 'String',
                required: true
            }, {
                name: 'vigiladaSuperfinanciera',
                displayName: 'VigiladaSuperfinanciera',
                type: 'Boolean',
                required: true
            }, {
                name: 'vigiliadaSupersolidaria',
                displayName: 'VigiliadaSupersolidaria',
                type: 'Boolean',
                required: true
            }], 
        childs: [{
                name: 'ordenes',
                displayName: 'Ordenes',
                //template: '', //override generic template
                ctrl: 'ordenesCtrl'            }        ]});
})(window.angular);
