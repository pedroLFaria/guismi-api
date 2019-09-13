function abrirCaracteristicas() {
    document.getElementsByClassName('character-main-chracteristcs')[0].style.display = 'block';
    document.getElementsByClassName('character-main-inventario')[0].style.display = 'none';
    document.getElementsByClassName('character-main-antecedentes')[0].style.display = 'none'; 
}
function abrirAntecedentes(){
    document.getElementsByClassName('character-main-chracteristcs')[0].style.display = 'none';
    document.getElementsByClassName('character-main-inventario')[0].style.display = 'none';
    document.getElementsByClassName('character-main-antecedentes')[0].style.display = 'block';

}
function abrirInventario(){
    document.getElementsByClassName('character-main-chracteristcs')[0].style.display = 'none';
    document.getElementsByClassName('character-main-inventario')[0].style.display = 'block';
    document.getElementsByClassName('character-main-antecedentes')[0].style.display = 'none';
}
function modalTextBox(node) {
    node.style.display = "none";
    node.nextElementSibling.style.display = "inline-block";
    node.nextElementSibling.focus();
}
function modalInputBox(node) {
    if(node.value!="")
        node.previousElementSibling.innerHTML = node.value;
    node.previousElementSibling.style.display = "inline-block";
    node.style.display = "none";
    
}
function habilidadeDropdown(node) {
    console.log("dropdown");
    node.nextElementSibling.classList.toggle("show");
}
function abrirModalAtributos() {
    document.getElementsByClassName("modal-habilidades")[0].style.display = "block";
}
window.onclick = function (event) {
    if (event.target == document.getElementsByClassName("modal-habilidades")[0]) {
        document.getElementsByClassName("modal-habilidades")[0].style.display = "none";
    }
}