function enviarFormulario(event) {
  event.preventDefault();

  const url = "http://localhost:8080/api/upload";
  const archivo = document.querySelector('input[type="file"]').files[0];
  const texto = document.querySelector('input[name="texto"]').value;

  const formData = new FormData();
  formData.append("file", archivo);
  formData.append("texto", texto);
  formData.append("auth", localStorage.token);

  /*const headers = new Headers();
  headers.append("auth", "auth");
  headers.append("Mi-Encabezado", "Valor de mi encabezado");*/

  fetch(url, {
      method: "POST",
      body: formData,
      mode: "no-cors",
  })
  .then(response => {
      if (response.ok) {
          console.log("Envío exitoso");
          // Aquí puedes realizar acciones adicionales después de enviar el formulario exitosamente
      } else {
          console.error("Error al enviar el formulario");
          // Aquí puedes manejar el error en caso de que la respuesta no sea exitosa
      }
  })
  .catch(error => {
      console.error("Error de red:", error);
      // Aquí puedes manejar los errores de red, como problemas de conexión
  });
}