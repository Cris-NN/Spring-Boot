$(document).ready(function() {
});

async function registrarUsuario() {
    let datos = {};
    datos.name = document.getElementById('name').value;
    datos.username = document.getElementById('username').value;
    datos.password = document.getElementById('password').value;

    if(datos.password != document.getElementById('rp-password').value){
       alert("CONTRASEÑAs DISTINTAS");
       return;
    }

  const request = await fetch('api/usuarios/registrar', {
    method: 'POST',
    headers: {
        'Accept' : 'application/json',
        'Content-type' : 'application/json'
    },
    body : JSON.stringify(datos)
  })
  const response = await request.text();
  if(response != "FAIL"){
    alert("La cuenta fue creada");
    window.location.href = 'iniciarSesion.html'
    }
  else alert("El nombre de usuario ya esta en uso")
}
