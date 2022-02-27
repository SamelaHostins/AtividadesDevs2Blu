$(document).ready(function(){
    console.log('JQuery load!')

    // Esconderá as caixas abaixo de cep e só aparecerá pós informar o cep
    $('#retornoCEP').hide();

    // "on" faz com que envie uma informação, ele dispara o evento q vc mandar
    $('#cep').on('blur', function(){
        var inputCep = $('#cep');
        console.log(inputCep.val());

        buscaCEP(inputCep.val()).then(
         (response) => {
            console.log(response);
            if(response && response.cep!==''){
                $('#retornoCEP').show();
                $('#rua').val(response.logradouro);
                $('#bairro').val(response.bairro);
                $('#cidade').val(response.localidade);
                $('#uf').val(response.uf);
            }
         }   
        );
    });
});

function buscaCEP(cep){
    var urlAPI = `https://viacep.com.br/ws/${cep}/json/`;

    return fetch(urlAPI).then(resp => resp.json());
}