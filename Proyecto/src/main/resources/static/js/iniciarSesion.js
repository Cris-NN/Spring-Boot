async function iniciarSesion(event) {
    event.preventDefault();
    let datos = {};
    datos.name = document.getElementById('name').value;
    datos.password = document.getElementById('password').value;
  const request = await fetch('api/usuarios/iniciarSesion', {
    method: 'POST',
    headers: {
        'Accept' : 'application/json',
        'Content-type' : 'application/json'
    },
    body : JSON.stringify(datos)
  })
    const response = await request.text();
    if(response != "FAIL"){
        //alert("INICIADO")
        localStorage.token = response;
        window.location.href = 'inicio.html'
        }
    else alert("Las credenciales son incorrectas")
}

async function auth(){
    const request = await fetch('api/auth', {
        method: 'GET',
        headers: {
            'Accept' : 'application/json',
            'Content-type' : 'application/json',
            'auth' : localStorage.token
        },
      })
        const response = await request.text();
        if(response == "true"){
            window.location.href = 'inicio.html'
            }
}
