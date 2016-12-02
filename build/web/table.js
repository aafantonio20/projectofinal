$(document).on('ready',funcPrincipal);

function funcPrincipal(){
    $("#btnNuevoFila").on('click', funcNuevoFila);
}

function funcNuevoFila(){
    $("#tablaPrincipal").append($('Hola'));
}