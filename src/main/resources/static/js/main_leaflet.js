var map = L.map('map').setView([0, 0], 2);

L.tileLayer('http://www.google.cn/maps/vt?lyrs=s@189&gl=cn&x={x}&y={y}&z={z}', {
    maxZoom: 19,
    attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
}).addTo(map);


// Define la proyección EPSG:32717

var crs = new L.Proj.CRS('EPSG:32717', '+proj=utm +zone=17 +south +datum=WGS84 +units=m +no_defs', {
    resolutions: [
        8192, 4096, 2048, 1024, 512, 256, 128
    ],
    origin: [0, 0]
});

let geoJsonResponse

var cnt = new XMLHttpRequest();

cnt.open("GET", "http://localhost:8080/home/allJson", true);

cnt.onload = function() {
    if(cnt.status >=200 && cnt.status < 300){

        let geoJsonResponse = JSON.parse(cnt.responseText);
        getPoligonos(geoJsonResponse);

    } else {
        console.error(
            "Error al realizar la solicitud. Código de estado ", cnt.status
        );
    }
};

cnt.onerror = function(){
    console.error("Error de red al realizar solicitud")
}

cnt.send();


function getPoligonos(geoJsonResponse){
    var geoJsonLayer = L.geoJSON(geoJsonResponse, {
        // Convierte las coordenadas al sistema de referencia de Leaflet (WGS84)
        coordsToLatLng: function (coords) {
            // Convierte las coordenadas EPSG:32717 a WGS84
            var point = proj4('EPSG:32717', 'EPSG:4326', [coords[0], coords[1]]);
            // Retorna las coordenadas convertidas y la tercera dimensión
            return new L.LatLng(point[1], point[0], coords[2]);
        },
        // Utiliza el nuevo sistema de referencia
        crs: crs,

        onEachFeature: function(feature, layer) {
            // Obtener la información de la característica
            var properties = feature.properties;

            var componente = properties.COMPONENTE;
            var nombre = properties.NOMBRE;
            var sector = properties.SECTOR;
            var paquete = properties.PAQUETE;


            // Crear el contenido del popup
            var popupContent = "<div class='popup-title' style='font-weight: bold; text-align: center'><b>Detalles</b></div>" +
                "<div class='popup-content' >" +
                "<b>Nombre:</b> " + nombre + "<br>" +
                "<b>Componente:</b> " + componente  + "<br>" +
                "<b>Sector:</b> " + sector  + "<br>" +
                "<b>Paquete:</b> " + paquete + "<br>"
            "</div>";

            // Asociar evento de clic para abrir el popup
            layer.on('click', function(e) {
                L.popup()
                    .setLatLng(e.latlng)
                    .setContent(popupContent)
                    .openOn(map);
            });
        }
    }).addTo(map);

    var bounds = geoJsonLayer.getBounds();

    map.fitBounds(bounds);

    //Seleccionando un poligono especifico

    let trTabla1 = document.getElementsByClassName('td-componente');

    for(let i = 0; i < trTabla1.length; i++){
        trTabla1[i].addEventListener('click', function(){

            let id = parseInt(trTabla1[i].id)

            for(let c = 0; c < geoJsonResponse.length; c++){
                var geoJsonSeleccionado = null;
                var boundsSeleccionado = null

                if(id === geoJsonResponse[c].features[0].properties.gid){

                    console.log('Hola ' + id);
                    console.log(geoJsonResponse[c]);

                    geoJsonSeleccionado = L.geoJSON(geoJsonResponse[c], {
                        // Convierte las coordenadas al sistema de referencia de Leaflet (WGS84)
                        coordsToLatLng: function (coords) {
                            // Convierte las coordenadas EPSG:32717 a WGS84
                            var point = proj4('EPSG:32717', 'EPSG:4326', [coords[0], coords[1]]);
                            // Retorna las coordenadas convertidas y la tercera dimensión
                            return new L.LatLng(point[1], point[0], coords[2]);
                        },
                        // Utiliza el nuevo sistema de referencia
                        crs: crs
                    }).addTo(map);

                    boundsSeleccionado = geoJsonSeleccionado.getBounds();

                    map.fitBounds(boundsSeleccionado)

                    map.removeLayer(geoJsonSeleccionado)
                }
            }
        })
    }
}





