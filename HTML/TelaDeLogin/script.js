var user = {
    login: '',
    senha: '',
    logado: false
}



$(document).ready(function(){
    console.log('JQuery load!')   
    verificaLogin();
});

function realizarLogin(){
    console.log('Login Realizado');
    createDestroyLoading();
    var login = $('#login').val();
    var senha = $('#senha').val();

    if(login && senha){
        user = {login, senha, logado: true};
        console.log(user);
        inserir('user', JSON.stringify(user));
    }

    setTimeout(() => createDestroyLoading(true), 5000);
    
}

function createDestroyLoading(destroy = false){
    if(!destroy){
    var loadingDiv = document.createElement('div');
    var imgLoading = document.createElement('img');

    $(imgLoading).attr('src', 'img/loading.gif');
    $(loadingDiv).append(imgLoading);
    $(loadingDiv).attr('class', 'loading');

    $('body').append(loadingDiv);   
    console.log(loadingDiv);
    }else{
        setTimeout(() => $('.loading').remove(),5000);
    }
}

function verificaLogin(){
    if(get('user')){
        $('#formLoginDiv').hide();
    }
}

// #- Storage Functions

function inserir(key,value){
    if(localStorage.getItem(key)){
        localStorage.removeItem(key);
        localStorage.setItem(key, value);
    }else{
        localStorage.setItem(key, value);
    }
}

function remover(key){
    localStorage.removeItem(key);
}

function get(key){
    localStorage.getItem(key);
}