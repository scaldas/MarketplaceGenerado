(function (ng) {
    var mod = ng.module('iVAModule', ['ngCrud']);

    mod.constant('iVAContext', 'iVAs');

    mod.constant('iVAModel', {
        fields: [{
                name: 'porcentajeIVA',
                displayName: 'PorcentajeIVA',
                type: 'Double',
                required: true
            }, {
                name: 'fechaInicioVigencia',
                displayName: 'FechaInicioVigencia',
                type: 'Date',
                required: true
            }, {
                name: 'fechaFinVigencia',
                displayName: 'FechaFinVigencia',
                type: 'Date',
                required: true
            }, {
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }]});
})(window.angular);
