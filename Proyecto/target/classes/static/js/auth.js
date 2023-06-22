async function funcion(){
    const request = await fetch('api/auth', {
        method: 'GET',
        headers: {
            'Accept' : 'application/json',
            'Content-type' : 'application/json',
            'auth' : localStorage.token
        },
      })
        const response = await request.text();
        if(response == "false"){
            window.location.href = 'iniciarSesion.html'
            }
}

async function logout(){
    localStorage.token = "";
    window.location.href = 'iniciarSesion.html'
}

