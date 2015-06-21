
function formatar_mascara(src, mascara) {
    var campo = src.value.length;
    var saida = mascara.substring(0,1);
    var texto = mascara.substring(campo);
    if(texto.substring(0,1) != saida) {
        src.value += texto.substring(0,1);
    }
        
    function erro() {
        alert ("Somente a equipe da GTI pode executar essa Função!")
    }
}
