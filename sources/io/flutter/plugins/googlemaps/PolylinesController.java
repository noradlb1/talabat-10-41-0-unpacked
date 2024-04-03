package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.huawei.hms.flutter.map.constants.Param;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PolylinesController {
    private final float density;
    private GoogleMap googleMap;
    private final Map<String, String> googleMapsPolylineIdToDartPolylineId = new HashMap();
    private final MethodChannel methodChannel;
    private final Map<String, PolylineController> polylineIdToController = new HashMap();

    public PolylinesController(MethodChannel methodChannel2, float f11) {
        this.methodChannel = methodChannel2;
        this.density = f11;
    }

    private void addPolyline(Object obj) {
        if (obj != null) {
            PolylineBuilder polylineBuilder = new PolylineBuilder(this.density);
            addPolyline(Convert.g(obj, polylineBuilder), polylineBuilder.a(), polylineBuilder.b());
        }
    }

    private void changePolyline(Object obj) {
        PolylineController polylineController;
        if (obj != null && (polylineController = this.polylineIdToController.get(getPolylineId(obj))) != null) {
            Convert.g(obj, polylineController);
        }
    }

    private static String getPolylineId(Object obj) {
        return (String) ((Map) obj).get(Param.POLYLINE_ID);
    }

    public void a(List<Object> list) {
        if (list != null) {
            for (Object addPolyline : list) {
                addPolyline(addPolyline);
            }
        }
    }

    public void b(List<Object> list) {
        if (list != null) {
            for (Object changePolyline : list) {
                changePolyline(changePolyline);
            }
        }
    }

    public boolean c(String str) {
        String str2 = this.googleMapsPolylineIdToDartPolylineId.get(str);
        if (str2 == null) {
            return false;
        }
        this.methodChannel.invokeMethod("polyline#onTap", Convert.o(str2));
        PolylineController polylineController = this.polylineIdToController.get(str2);
        if (polylineController != null) {
            return polylineController.a();
        }
        return false;
    }

    public void d(List<Object> list) {
        PolylineController remove;
        if (list != null) {
            for (Object next : list) {
                if (!(next == null || (remove = this.polylineIdToController.remove((String) next)) == null)) {
                    remove.c();
                    this.googleMapsPolylineIdToDartPolylineId.remove(remove.b());
                }
            }
        }
    }

    public void e(GoogleMap googleMap2) {
        this.googleMap = googleMap2;
    }

    private void addPolyline(String str, PolylineOptions polylineOptions, boolean z11) {
        Polyline addPolyline = this.googleMap.addPolyline(polylineOptions);
        this.polylineIdToController.put(str, new PolylineController(addPolyline, z11, this.density));
        this.googleMapsPolylineIdToDartPolylineId.put(addPolyline.getId(), str);
    }
}
