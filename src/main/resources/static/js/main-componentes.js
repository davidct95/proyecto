window.onload = function () {
  let tabla = document.getElementById("componentesTable");
  let filas = Array.from(tabla.rows).slice(1); // Excluimos la primera fila (cabecera)
  filas.sort((a, b) => {
    let valorA = a.cells[0].textContent.trim();
    let valorB = b.cells[0].textContent.trim();
    return valorA.localeCompare(valorB, undefined, { numeric: true });
  });
  // Vaciamos la tabla
  while (tabla.rows.length > 1) {
    tabla.deleteRow(1);
  }
  // Agregamos las filas ordenadas
  filas.forEach((fila) => {
    tabla.appendChild(fila);
  });
};

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

document.addEventListener("DOMContentLoaded", function () {
  var table = document.querySelector(".tabla-box1");
  var tbody = table.querySelector("tbody");
  var rows = Array.from(tbody.querySelectorAll("tr"));
  var navigationButtonsContainer = document.getElementById("navigationButtons");
  var itemsPerPage = 4;
  var currentPage = 0;

  function showPage(page) {
    var start = page * itemsPerPage;
    var end = start + itemsPerPage;
    rows.forEach(function (row, index) {
      row.style.display = index >= start && index < end ? "" : "none";
    });
  }

  function createNavigationButton(page) {
    var button = document.createElement("button");
    button.textContent = page + 1;
    button.addEventListener("click", function () {
      currentPage = page;
      showPage(page);
    });
    return button;
  }

  function createNavigationButtons(totalPages) {
    navigationButtonsContainer.innerHTML = "";
    for (var i = 0; i < totalPages; i++) {
      var button = createNavigationButton(i);
      navigationButtonsContainer.appendChild(button);
    }
  }

  function updateNavigationButtons() {
    var totalPages = Math.ceil(rows.length / itemsPerPage);
    createNavigationButtons(totalPages);
  }

  showPage(currentPage);
  updateNavigationButtons();
});

$(document).ready(function () {
  // Manejar clic en los elementos de la primera tabla
  $("#componentesTable tbody").on("click", "tr", function () {
    // Obtener el valor de la primera celda del registro seleccionado
    var id = $(this).find("td:first").text();

    // Realizar una solicitud AJAX para obtener los datos de la segunda tabla
    $.ajax({
      url: "http://localhost:8080/home/p/" + id,
      method: "GET",
      success: function (data) {
        // Limpiar la segunda tabla
        $("#tabla").empty();

        // Llenar la segunda tabla con los nuevos datos
        $("#tabla").append(data);
      },
      error: function () {
        console.log("Error al obtener los datos de la segunda tabla");
      },
    });
  });
});

function getPropiedades(id) {
  var xhr = new XMLHttpRequest();

  xhr.open("GET", "http://localhost:8080/home/p/" + id, true);

  xhr.onload = function () {
    if (xhr.status >= 200 && xhr.status < 300) {
      var jsonResponse = JSON.parse(xhr.responseText);
      console.log(Object.keys(jsonResponse));
      console.log(jsonResponse)

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

function modificarRegistro(id){

// Seleccionar el elemento <td> por su clase "th-botones"
  var tdElement = document.getElementById('td' + id);
  console.log(tdElement)

// Verificar si se encontró el elemento <td>
  if (tdElement) {
    // Mientras haya hijos en el <td>, eliminar el primer hijo
    while (tdElement.firstChild) {
      tdElement.removeChild(tdElement.firstChild);
    }
  } else {
    console.log('No se encontró ningún elemento <td> con la clase "th-botones".');
  }
}

