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
    filas.forEach(fila => {
        tabla.appendChild(fila);
    });
};


function openTab(tabName) {
    var i, tabcontent;
    // Ocultar todas las filas de datos
    tabcontent = document.getElementById("tabla").getElementsByTagName("tbody")[0].getElementsByTagName("tr");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    // Mostrar las filas de la sección seleccionada
    var sections = document.getElementsByClassName(tabName);
    for (i = 0; i < sections.length; i++) {
        sections[i].style.display = "table-row";
    }
}

document.addEventListener("DOMContentLoaded", function() {
    var table = document.querySelector('.tabla-box1');
    var tbody = table.querySelector('tbody');
    var rows = Array.from(tbody.querySelectorAll('tr'));
    var navigationButtonsContainer = document.getElementById('navigationButtons');
    var itemsPerPage = 4;
    var currentPage = 0;

    function showPage(page) {
      var start = page * itemsPerPage;
      var end = start + itemsPerPage;
      rows.forEach(function(row, index) {
        row.style.display = (index >= start && index < end) ? '' : 'none';
      });
    }

    function createNavigationButton(page) {
      var button = document.createElement('button');
      button.textContent = page + 1;
      button.addEventListener('click', function() {
        currentPage = page;
        showPage(page);
      });
      return button;
    }

    function createNavigationButtons(totalPages) {
      navigationButtonsContainer.innerHTML = '';
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