package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.huawei.hms.flutter.map.constants.Param;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MarkersController {
    private GoogleMap googleMap;
    private final Map<String, String> googleMapsMarkerIdToDartMarkerId = new HashMap();
    private final Map<String, MarkerController> markerIdToController = new HashMap();
    private final MethodChannel methodChannel;

    public MarkersController(MethodChannel methodChannel2) {
        this.methodChannel = methodChannel2;
    }

    private void addMarker(Object obj) {
        if (obj != null) {
            MarkerBuilder markerBuilder = new MarkerBuilder();
            addMarker(Convert.e(obj, markerBuilder), markerBuilder.a(), markerBuilder.b());
        }
    }

    private void changeMarker(Object obj) {
        MarkerController markerController;
        if (obj != null && (markerController = this.markerIdToController.get(getMarkerId(obj))) != null) {
            Convert.e(obj, markerController);
        }
    }

    private static String getMarkerId(Object obj) {
        return (String) ((Map) obj).get(Param.MARKER_ID);
    }

    public void a(List<Object> list) {
        if (list != null) {
            for (Object addMarker : list) {
                addMarker(addMarker);
            }
        }
    }

    public void b(List<Object> list) {
        if (list != null) {
            for (Object changeMarker : list) {
                changeMarker(changeMarker);
            }
        }
    }

    public void c(String str, MethodChannel.Result result) {
        MarkerController markerController = this.markerIdToController.get(str);
        if (markerController != null) {
            markerController.hideInfoWindow();
            result.success((Object) null);
            return;
        }
        result.error("Invalid markerId", "hideInfoWindow called with invalid markerId", (Object) null);
    }

    public void d(String str, MethodChannel.Result result) {
        MarkerController markerController = this.markerIdToController.get(str);
        if (markerController != null) {
            result.success(Boolean.valueOf(markerController.isInfoWindowShown()));
        } else {
            result.error("Invalid markerId", "isInfoWindowShown called with invalid markerId", (Object) null);
        }
    }

    public void e(String str) {
        String str2 = this.googleMapsMarkerIdToDartMarkerId.get(str);
        if (str2 != null) {
            this.methodChannel.invokeMethod("infoWindow#onTap", Convert.l(str2));
        }
    }

    public void f(String str, LatLng latLng) {
        String str2 = this.googleMapsMarkerIdToDartMarkerId.get(str);
        if (str2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Param.MARKER_ID, str2);
            hashMap.put("position", Convert.j(latLng));
            this.methodChannel.invokeMethod("marker#onDragEnd", hashMap);
        }
    }

    public boolean g(String str) {
        String str2 = this.googleMapsMarkerIdToDartMarkerId.get(str);
        if (str2 == null) {
            return false;
        }
        this.methodChannel.invokeMethod("marker#onTap", Convert.l(str2));
        MarkerController markerController = this.markerIdToController.get(str2);
        if (markerController != null) {
            return markerController.a();
        }
        return false;
    }

    public void h(List<Object> list) {
        MarkerController remove;
        if (list != null) {
            for (Object next : list) {
                if (!(next == null || (remove = this.markerIdToController.remove((String) next)) == null)) {
                    remove.c();
                    this.googleMapsMarkerIdToDartMarkerId.remove(remove.b());
                }
            }
        }
    }

    public void i(GoogleMap googleMap2) {
        this.googleMap = googleMap2;
    }

    public void j(String str, MethodChannel.Result result) {
        MarkerController markerController = this.markerIdToController.get(str);
        if (markerController != null) {
            markerController.showInfoWindow();
            result.success((Object) null);
            return;
        }
        result.error("Invalid markerId", "showInfoWindow called with invalid markerId", (Object) null);
    }

    private void addMarker(String str, MarkerOptions markerOptions, boolean z11) {
        Marker addMarker = this.googleMap.addMarker(markerOptions);
        this.markerIdToController.put(str, new MarkerController(addMarker, z11));
        this.googleMapsMarkerIdToDartMarkerId.put(addMarker.getId(), str);
    }
}
