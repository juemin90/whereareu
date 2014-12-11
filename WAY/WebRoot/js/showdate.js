window.onload = initialize;
var long=document.getElementById("longitude"),la=document.getElementById("latitude");
var map;
var markers = [];
var paths = [];
var createuserid;
var latlngHere;
function calDistanceAndTime(p1, p2) {
	var distance = Math.round(google.maps.geometry.spherical.computeDistanceBetween (p1, p2));
	var time = Math.round(distance/1.5);
	return distance + "m, " + time + " seconds";
	
}
// Add a marker to the map and push to the array.
function addMyMarker(location) {
	var marker = new google.maps.Marker({
	    position: location,
	    map: map
	});
    var infoWindow = new google.maps.InfoWindow({
        content: "I:"+calDistanceAndTime(location, latlngHere)
    });
    infoWindow.open(map, marker);
    
    var flightPlanCoordinates = [location, latlngHere];
    var flightPath = new google.maps.Polyline({
	    path: flightPlanCoordinates,
        geodesic: true,
	    strokeColor: '#FF0000',
	    strokeOpacity: 1.0,
	    strokeWeight: 2
	});
    markers.push(marker);
    paths.push(flightPath);
    flightPath.setMap(map);
    
    //打开提示窗口
//  ajax, upload and update my recent location

    if(userid==createuserid) {
        $.ajax( {
	        type : "GET",
	        url : "uploadLoc.do",
	        data : "dateid="+dateid+"&longone="+location.lng()+"&latone="+location.lat(),
	        dataType: "text",
            success : function(msg) {
	        }
        });
    } else {
	    $.ajax( {
            type : "GET",
            url : "uploadLoc.do",
            data : "dateid="+dateid+"&longtwo="+location.lng()+"&lattwo="+location.lat(),
            dataType: "text",
            success : function(msg) {
            }
	    });
    }
} 

function addFriendMarker() {
	$.ajax( {
        type : "GET",
        url : "getLoc.do",
        data : "dateid="+dateid,
        dataType: "text",
        success : function(msg) {
        	var latlng = eval("("+msg+")");
//        	console.log(calDistanceAndTime(longitude, latitude, latlng.longtwo, latlng.lattwo));
//        	console.log(calDistanceAndTime(longitude, latitude, latlng.longone, latlng.latone));
        	if(userid==createuserid && latlng.lattwo) {
            	var friendPos = new google.maps.LatLng(latlng.lattwo, latlng.longtwo)
        		var marker = new google.maps.Marker({
        		    position: friendPos,
        		    map: map
        		});
            	var infoWindow = new google.maps.InfoWindow({
                    content: "Friend:"+calDistanceAndTime(friendPos, latlngHere)    //提示窗体内的提示信息
                });
                infoWindow.open(map, marker);
//                sh(marker);
                
                var flightPlanCoordinates = [friendPos, latlngHere];
                var flightPath = new google.maps.Polyline({
            	    path: flightPlanCoordinates,
                    geodesic: true,
            	    strokeColor: '#FF0000',
            	    strokeOpacity: 1.0,
            	    strokeWeight: 2
            	});
                markers.push(marker);
                paths.push(flightPath);
                flightPath.setMap(map);
        	} else if(userid==withuserid && latlng.latone) {
            	var friendPos = new google.maps.LatLng(latlng.latone, latlng.longone)
        		var marker = new google.maps.Marker({
        		    position: friendPos,
        		    map: map
        		});
            	var infoWindow = new google.maps.InfoWindow({
            		content: "Friend:"+calDistanceAndTime(friendPos, latlngHere)    //提示窗体内的提示信息
                    });
                infoWindow.open(map, marker);
                var flightPlanCoordinates = [friendPos, latlngHere];
                var flightPath = new google.maps.Polyline({
            	    path: flightPlanCoordinates,
                    geodesic: true,
            	    strokeColor: '#FF0000',
            	    strokeOpacity: 1.0,
            	    strokeWeight: 2
            	});
                markers.push(marker);
                paths.push(flightPath);
                flightPath.setMap(map);
        	}
            //打开提示窗口
        }
    });
}
function setAllMap(map) {
    for (var i = 0; i < markers.length; i++) {
	     markers[i].setMap(map);
	     paths[i].setMap(map);
	}
}

// Removes the markers from the map, but keeps them in the array.
function clearMarkers() {
    setAllMap(null);
}

// Shows any markers currently in the array.
//function showMarkers() {
//    setAllMap(map);
//}

// Deletes all markers in the array by removing references to them.
function deleteMarkers() {
    clearMarkers();
    markers = [];
    paths = [];
}
function update() {
	//获得自己的坐标
	navigator.geolocation.getCurrentPosition(function(position) {
	    var pos = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
	    deleteMarkers();
	    addMyMarker(pos);
	    addFriendMarker();
	})
}
var r = {
	    protocol: /([^\/]+:)\/\/(.*)/i,
	    host: /(^[^\:\/]+)((?:\/|:|$)?.*)/,
	    port: /\:?([^\/]*)(\/?.*)/,
	    pathname: /([^\?#]+)(\??[^#]*)(#?.*)/
	};

function parseUrl(url) {
    var tmp, res = {};
    res["href"] = url;
    for (p in r) {
        tmp = r[p].exec(url);
        res[p] = tmp[1];
        url = tmp[2];
        if (url === "") {
            url = "/";
        }
        if (p === "pathname") {
            res["pathname"] = tmp[1];
            res["search"] = tmp[2];
            res["hash"] = tmp[3];
        }
    }
    return res;
};
function initialize() {
	var params = parseUrl(window.location.href).search.split("&");
	dateid=params[0].split("=")[1];
	userid=params[1].split("=")[1];
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
            var i = 0;
            $.ajax( {
                type : "GET",
                url : "getLoc.do",
                data : "dateid="+dateid,
                dataType: "text",
                success : function(msg) {
                	var latlng = eval("("+msg+")");
                	createuserid = latlng.createuserid;
                	latitude = latlng.latitude;
                	longitude = latlng.longitude;
                	latlngHere = new google.maps.LatLng(latlng.latitude, latlng.longitude);
                	withuserid = latlng.withuserid;
                	var marker = new google.maps.Marker({
                	    position: latlngHere,
                	    map: map
                	});
                	
                	var infoWindow = new google.maps.InfoWindow({
                        content: "Meet Place"   //提示窗体内的提示信息
                    });
                    //打开提示窗口
                    infoWindow.open(map, marker);
                	
                }
            });
            sh=setInterval(update,1000);
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