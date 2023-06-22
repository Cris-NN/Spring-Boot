$(document).ready(function() {
});

async function verificar() {
  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
        'Accept' : 'application/json',
        'Content-type' : 'application/json',
        'auth' : localStorage.token
    },
    body : JSON.stringify(datos)
  })
    const response = await request.json();
    if(response != null){
        window.location.href = 'test.html'
        }
    else window.location.href = 'iniciarSesion.html'
}