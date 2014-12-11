window.onload = initialize;
var long=document.getElementById("longitude"),la=document.getElementById("latitude");
var map;
var markers = [];
// Add a marker to the map and push to the array.
function addMarker(location) {
	  var marker = new google.maps.Marker({
	    position: location,
	    map: map
	  });
	  markers.push(marker);
	}
function setAllMap(map) {
	  for (var i = 0; i < markers.length; i++) {
		    markers[i].setMap(map);
		  }
		}

		// Removes the markers from the map, but keeps them in the array.
		function clearMarkers() {
		  setAllMap(null);
		}

		// Shows any markers currently in the array.
		function showMarkers() {
		  setAllMap(map);
		}

		// Deletes all markers in the array by removing references to them.
		function deleteMarkers() {
		  clearMarkers();
		  markers = [];
		}
function initialize() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var coords = position.coords;
            var latlng = new google.maps.LatLng(coords.latitude, coords.longitude);
            var myOptions = {
                zoom: 15, 
                center: latlng,  
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            map = new google.maps.Map(document.getElementById("map"), myOptions);
            
            google.maps.event.addListener(map, 'click', function(event) {
            	deleteMarkers();
            	addMarker(event.latLng)
                long.value = event.latLng.lng(), la.value = event.latLng.lat();
              });
        },
        function (error) {
            switch (error.code) {
                case 1:
                    alert("位置服务被拒绝。");
                    break;
                case 2:
                    alert("暂时获取不到位置信息。");
                    break;
                case 3:
                    alert("获取信息超时。");
                    break;
                default:
                    alert("未知错误。");
                    break;
            }
        });
    } else {
        alert("你的浏览器不支持HTML5来获取地理位置信息。");
    }
}