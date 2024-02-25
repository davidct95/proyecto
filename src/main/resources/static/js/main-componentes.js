function openTab(tabName) {
  var i, tabcontent;
  // Ocultar todas las filas de datos
  tabcontent = document
    .getElementById("tabla")
    .getElementsByTagName("tbody")[0]
    .getElementsByTagName("tr");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  // Mostrar las filas de la sección seleccionada
  var sections = document.getElementsByClassName(tabName);
  for (i = 0; i < sections.length; i++) {
    sections[i].style.display = "table-row";
  }

  // Remarcar el tab seleccionado en rojo
  var tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].classList.remove("selected");
  }
  document.getElementById(tabName).classList.add("selected");
}


function getPropiedades(id) {
  var xhr = new XMLHttpRequest();

  xhr.open("GET", "http://localhost:8080/home/p/" + id, true);

  xhr.onload = function () {
    if (xhr.status >= 200 && xhr.status < 300) {
      var jsonResponse = JSON.parse(xhr.responseText);

      addValuesTable(jsonResponse);
      marcarRegistroSeleccionado(id);


    } else {
      console.error(
        "Error al realizar la solicitud. Código de estado:",
        xhr.status
      );
    }
  };

  // Manejar errores de red
  xhr.onerror = function () {
    console.error("Error de red al realizar la solicitud.");
  };

  // Enviar la solicitud
  xhr.send();
}

function addValuesTable(json){
  let tbody = document.getElementById('tabla').querySelector('tbody');
  let claves = Object.keys(json);

  if(tbody != null){
    while(tbody.firstChild){
      tbody.removeChild(tbody.firstChild);
    }
  }

  for(let i = 14; i < claves.length; i++){
    let tr = document.createElement("tr");
    tbody.appendChild(tr);

    if(i <= 22){
      tr.classList.add("seccion1")
    } else if (i > 22 && i <= 27) {
      tr.classList.add("seccion2")
    } else if (i > 27 && i <= 33){
      tr.classList.add("seccion3")
    } else if(i > 33 && i <= 40) {
      tr.classList.add("seccion4")
    } else if(i > 40 && i <= 46) {
      tr.classList.add("seccion5")
    }

    for(let c = 0; c < 4; c++){
      let td = document.createElement("td");
      tr.appendChild(td);
      if(c == 0){
        td.textContent = claves[i];
      } else if(c == 2){
        td.textContent = json[claves[i]];
      }
    }
  }

  openTab('seccion1');
}

function marcarRegistroSeleccionado(id){
  let componentes = document.getElementsByClassName('td-componente');

  for(let i = 0; i < componentes.length; i++){
    componentes[i].classList.remove("seleccionadoTabla1");
  }
  document.getElementById(id).classList.add("seleccionadoTabla1");
}

function abrirModal(id){
  let btnAbrirModal = document.getElementById('abrir-modal');
  let modal = document.getElementById('modal')

  modal.showModal();

}

function cerrarModal(){
  let btnCerrarModal = document.getElementById('cerrar-modal');
  let modal = document.getElementById('modal');

  modal.close();
}

function abrirModal(id) {

  var modal = document.getElementById('modal');
  var modalContent = document.getElementById('modalContent');

  // Fetch para obtener el contenido de la URL
  fetch('http://localhost:8080/home/edit/' + id)
      .then(response => response.text()) // Convertir la respuesta a texto
      .then(data => {
        // Insertar el contenido en el modal
        modalContent.innerHTML = data;
        // Mostrar el modal
        modal.showModal();
      })
      .catch(error => {
        console.error('Error al obtener el contenido:', error);
      });
}

function cerrarModal(){
  let modal = document.getElementById('modal')

  modal.close();
}

document.addEventListener("DOMContentLoaded", function() {
  const tbody = document.querySelector(".tbodytabla1");
  // Obtener todas las filas de la tabla
  const filas = Array.from(tbody.querySelectorAll("tr"));


  ordenarFilas(tbody, filas);

  separarFilas();
});



function ordenarFilas(tbody, filas){
  // Ordenar las filas alfabéticamente basándose en el contenido de la primera celda
  filas.sort(function(a, b) {
    const contenidoA = a.querySelector(".valor1-td").textContent.trim().toUpperCase();
    const contenidoB = b.querySelector(".valor1-td").textContent.trim().toUpperCase();
    return contenidoA.localeCompare(contenidoB);
  });

  // Vaciar el tbody actual
  tbody.innerHTML = '';

  // Insertar las filas ordenadas en el tbody nuevamente
  filas.forEach(function(fila) {
    tbody.appendChild(fila);
  });
}

function separarFilas() {
  const tbody = document.querySelector(".tbodytabla1");
  const filas = document.getElementsByClassName('td-componente')
  let contenedorbuttons = document.getElementById('navigationButtons');

  let array = [];
  let subArrayActual = [];
  let longitudSubArray = 5;


  //Agregando botones

   let cantidadBotones = Math.ceil(filas.length / longitudSubArray)

  for(let i = 0; i < cantidadBotones; i++){
    var button = document.createElement('button');

    button.innerText = i + 1;
    button.id = i + 1;
    button.className = 'lista-botones'
    contenedorbuttons.appendChild(button);

    console.log(button)
  }

  let listaBotones = document.getElementsByClassName('lista-botones')

  //Mostrando solo 4 elementos

  for(let i = 0; i < filas.length; i++){

    subArrayActual.push(filas[i]);

    if(subArrayActual.length == longitudSubArray || i == filas.length - 1){
      array.push(subArrayActual);

      subArrayActual = [];
    }
  }

  for(let c = 0; c < array[0].length; c++){
    array[0][c].style.display = 'table-row';
    listaBotones[0].style.backgroundColor = '#ff3547';
  }



  for(let i = 0; i <= listaBotones.length; i++){
    listaBotones[i].addEventListener('click', function(){

      //Reiniciando el color de los botones

      for (let v = 0; v < listaBotones.length; v++){
        listaBotones[v].style.backgroundColor = 'white';
      }

      //Ocultando las listas nuevamente al hacer click en otro botón

      for(let x = 0; x < array.length; x++){

        for(let y = 0; y < array[x].length; y++){
          array[x][y].style.display = 'none';
        }

      }

      let x = i;

        if(i == x){
          for(let c = 0; c < array[i].length; c++){
              array[i][c].style.display = 'table-row';
          }
          listaBotones[i].style.backgroundColor = '#ff3547';
        }

    });
  }
}










