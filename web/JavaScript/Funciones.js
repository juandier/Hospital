/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validarContraseñaPaciente(){
    var contraseña1= document.getElementById("contraseñaPaciente").value;
    var contraseña2= document.getElementById("repitaContraseña").value;
    if(contraseña1!==contraseña2){
            alert("Las contraseñas no coinciden");
    }    
    else{
        
        var xhr = new XMLHttpRequest();
        
        xhr.open("POST", "RegistroPacienteServlet");
        xhr.onreadystatechange = function(){
            if(this.status == 200 && this.readyState ==4){
                //var response = JSON.parse(this.response);
                
                alert("LEONARDO the best");
                alert("prueba jd");
                //hablame
                location.href = this.response;
            }
        }
        
        xhr.send();
        
    }
    
    
}
