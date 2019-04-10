// On initialise la latitude et la longitude de Bourk (centre de la carte)
var lat = 46.215083;
var lng = 5.241825;
var osmap = null;
var marker = null;

// Fonction d'initialisation de la carte
function initMap() {

    // Créer l'objet "osmap" et l'insèrer dans l'élément HTML qui a l'ID "map"
    osmap = L.map('map', {
        center: [lat, lng],
        zoom: 12
    }).addEventListener('click', (event) => {
        osmap.removeLayer(marker);
        let _lat = event.latlng.lat.toFixed(6);
        let _lng = event.latlng.lng.toFixed(6);
        marker = L.marker([_lat, _lng]).addTo(osmap).bindPopup('lat : '+ _lat +'<br/>lng : '+ _lng).openPopup();
    }).addEventListener('move', () => {
        osmap.invalidateSize();
    }).addEventListener('resize', () => {
        osmap.invalidateSize();
    });
    // Leaflet ne récupère pas les cartes (tiles) sur un serveur par défaut. Nous devons lui préciser où nous souhaitons les récupérer. Ici, openstreetmap.fr
    L.tileLayer('https://{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png', {
        // Il est toujours bien de laisser le lien vers la source des données
        attribution: "données © <a href='//osm.org/copyright'>OpenStreetMap</a>/ODbL - rendu <a href='//openstreetmap.fr'>OSM France</a>",
        minZoom: 3,
        maxZoom: 20
    }).addTo(osmap);

    setTimeout(function() {
        osmap.invalidateSize();
        console.log('lat : '+ lat +'; lng : '+ lng);
        marker = L.marker([lat, lng]).addTo(osmap).bindPopup('Choisissez la position de votre capteur sur la carte !').openPopup();
    }, 500);

}

initMap();