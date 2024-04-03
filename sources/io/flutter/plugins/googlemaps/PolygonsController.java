package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.huawei.hms.flutter.map.constants.Param;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PolygonsController {
    private final float density;
    private GoogleMap googleMap;
    private final Map<String, String> googleMapsPolygonIdToDartPolygonId = new HashMap();
    private final MethodChannel methodChannel;
    private final Map<String, PolygonController> polygonIdToController = new HashMap();

    public PolygonsController(MethodChannel methodChannel2, float f11) {
        this.methodChannel = methodChannel2;
        this.density = f11;
    }

    private void addPolygon(Object obj) {
        if (obj != null) {
            PolygonBuilder polygonBuilder = new PolygonBuilder(this.density);
            addPolygon(Convert.f(obj, polygonBuilder), polygonBuilder.a(), polygonBuilder.b());
        }
    }

    private void changePolygon(Object obj) {
        PolygonController polygonController;
        if (obj != null && (polygonController = this.polygonIdToController.get(getPolygonId(obj))) != null) {
            Convert.f(obj, polygonController);
        }
    }

    private static String getPolygonId(Object obj) {
        return (String) ((Map) obj).get(Param.POLYGON_ID);
    }

    public void a(List<Object> list) {
        if (list != null) {
            for (Object addPolygon : list) {
                addPolygon(addPolygon);
            }
        }
    }

    public void b(List<Object> list) {
        if (list != null) {
            for (Object changePolygon : list) {
                changePolygon(changePolygon);
            }
        }
    }

    public boolean c(String str) {
        String str2 = this.googleMapsPolygonIdToDartPolygonId.get(str);
        if (str2 == null) {
            return false;
        }
        this.methodChannel.invokeMethod("polygon#onTap", Convert.n(str2));
        PolygonController polygonController = this.polygonIdToController.get(str2);
        if (polygonController != null) {
            return polygonController.a();
        }
        return false;
    }

    public void d(List<Object> list) {
        PolygonController remove;
        if (list != null) {
            for (Object next : list) {
                if (!(next == null || (remove = this.polygonIdToController.remove((String) next)) == null)) {
                    remove.c();
                    this.googleMapsPolygonIdToDartPolygonId.remove(remove.b());
                }
            }
        }
    }

    public void e(GoogleMap googleMap2) {
        this.googleMap = googleMap2;
    }

    private void addPolygon(String str, PolygonOptions polygonOptions, boolean z11) {
        Polygon addPolygon = this.googleMap.addPolygon(polygonOptions);
        this.polygonIdToController.put(str, new PolygonController(addPolygon, z11, this.density));
        this.googleMapsPolygonIdToDartPolygonId.put(addPolygon.getId(), str);
    }
}
