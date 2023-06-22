document.addEventListener("DOMContentLoaded", cargar);

async function cargar() {
  var element = document.getElementById("imagenes");

  const id = await fetch('api/auth', {
          method: 'GET',
          headers: {
              'Accept' : 'application/json',
              'Content-type' : 'application/json',
              'auth' : localStorage.token
          },
        })
          const userID = await id.text();

  const request = await fetch(`api/album/${userID}`, {
    method: 'GET',
    headers: {
        'Accept' : 'application/json',
        'Content-type' : 'application/json'
    }
  })
  const response = JSON.stringify(await request.json());

  JSON.parse(response).map( lg => element.innerHTML += `<div class="col-2 shadow columna align-self-center"><img src="http://localhost:8080/api/imagen/${lg.img}" class="img img-thumbnail img-fluid" alt="test" >  <p class="lead"> ${lg.texto || ""} </p> </div>`)
}