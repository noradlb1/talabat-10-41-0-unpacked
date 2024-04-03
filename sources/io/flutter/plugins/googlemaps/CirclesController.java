package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.huawei.hms.flutter.map.constants.Param;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CirclesController {
    private final Map<String, CircleController> circleIdToController = new HashMap();
    private final float density;
    private GoogleMap googleMap;
    private final Map<String, String> googleMapsCircleIdToDartCircleId = new HashMap();
    private final MethodChannel methodChannel;

    public CirclesController(MethodChannel methodChannel2, float f11) {
        this.methodChannel = methodChannel2;
        this.density = f11;
    }

    private void addCircle(Object obj) {
        if (obj != null) {
            CircleBuilder circleBuilder = new CircleBuilder(this.density);
            addCircle(Convert.c(obj, circleBuilder), circleBuilder.a(), circleBuilder.b());
        }
    }

    private void changeCircle(Object obj) {
        CircleController circleController;
        if (obj != null && (circleController = this.circleIdToController.get(getCircleId(obj))) != null) {
            Convert.c(obj, circleController);
        }
    }

    private static String getCircleId(Object obj) {
        return (String) ((Map) obj).get(Param.CIRCLE_ID);
    }

    public void a(List<Object> list) {
        if (list != null) {
            for (Object addCircle : list) {
                addCircle(addCircle);
            }
        }
    }

    public void b(List<Object> list) {
        if (list != null) {
            for (Object changeCircle : list) {
                changeCircle(changeCircle);
            }
        }
    }

    public boolean c(String str) {
        String str2 = this.googleMapsCircleIdToDartCircleId.get(str);
        if (str2 == null) {
            return false;
        }
        this.methodChannel.invokeMethod("circle#onTap", Convert.b(str2));
        CircleController circleController = this.circleIdToController.get(str2);
        if (circleController != null) {
            return circleController.a();
        }
        return false;
    }

    public void d(List<Object> list) {
        CircleController remove;
        if (list != null) {
            for (Object next : list) {
                if (!(next == null || (remove = this.circleIdToController.remove((String) next)) == null)) {
                    remove.c();
                    this.googleMapsCircleIdToDartCircleId.remove(remove.b());
                }
            }
        }
    }

    public void e(GoogleMap googleMap2) {
        this.googleMap = googleMap2;
    }

    private void addCircle(String str, CircleOptions circleOptions, boolean z11) {
        Circle addCircle = this.googleMap.addCircle(circleOptions);
        this.circleIdToController.put(str, new CircleController(addCircle, z11, this.density));
        this.googleMapsCircleIdToDartCircleId.put(addCircle.getId(), str);
    }
}
