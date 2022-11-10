const portas = document.getElementsByClassName('portas');
var sensores = document.getElementById('nrSensores');
var entradas = document.getElementById('nrEntradas');
var saidas = document.getElementById('nrSaidas');
var maximo = document.getElementById('nrMax');
var atual = document.getElementById('nrAtual');
var statusOnibus = document.getElementById('dsStatus');
var add = document.getElementById('add');
var remove = document.getElementById('remove');

function getCurrentURL () {
    return window.location.pathname
  }

const url = getCurrentURL()

if (url == "/onibus/new") {
    statusOnibus.value = "NaoCheio"
}

const nrSensores = function() {
    sensores.value = +entradas.value + +saidas.value
};

for (var i = 0; i < portas.length; i++) {
    portas[i].addEventListener('input', nrSensores);
}

const status = function() {
    if (atual.value == maximo.value) {
        statusOnibus.value = "Cheio"
        document.querySelector('h3:nth-child(4)').innerHTML = "Status do Onibus: Cheio"
    }else{
        statusOnibus.value = "NaoCheio"
        document.querySelector('h3:nth-child(4)').innerHTML = "Status do Onibus: NaoCheio"
    }
};

const adicionar = function() {
    atual.value = +atual.value+1
    document.querySelector('h3:nth-child(6)').innerHTML = 'Numero Atual: ' + atual.value
    status();
} 
    
const remover = function() {
    atual.value = +atual.value-1
    document.querySelector('h3:nth-child(6)').innerHTML = 'Numero Atual: ' + atual.value
    status();
}
