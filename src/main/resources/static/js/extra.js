function openCity(day) {
    var i;
    var x = document.getElementsByClassName("day");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";
       console.log("11");
    }
    document.getElementById(day).style.display = "block";
}

function showMenu() {

    console.log(" --");
    document.getElementById("special").style.display = "none";
    document.getElementById("menu").style.display = "block";

}

function showSpecial() {

    console.log(" --");
    document.getElementById("menu").style.display = "none";
    document.getElementById("special").style.display = "block";

}

$(document).ready(function() {

    $('#menu').show();
    $('#special').hide();
});

function configEditMenu(name, price, quantity,itemId){

    document.getElementById('editMenuName').value = name;
    document.getElementById('editMenuPrice').value = price;
    document.getElementById('editMenuQuantity').value = quantity;
    document.getElementById('editMenuId').value = itemId;
}

function configEditSpecial(name, price, quantity,till,dayOfWeek,itemId){

    document.getElementById('editSpecialName').value = name;
    document.getElementById('editSpecialPrice').value = price;
    document.getElementById('editSpecialQuantity').value = quantity;
    document.getElementById('editSpecialTillTime').value = till;
    document.getElementById('editSpecialDayOfWeek').value = dayOfWeek;
    document.getElementById('editSpecialId').value = itemId;
}

$('#btnTrigger').click()


