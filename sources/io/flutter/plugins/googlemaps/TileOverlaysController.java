package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import com.huawei.hms.flutter.map.constants.Param;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TileOverlaysController {
    private GoogleMap googleMap;
    private final MethodChannel methodChannel;
    private final Map<String, TileOverlayController> tileOverlayIdToController = new HashMap();

    public TileOverlaysController(MethodChannel methodChannel2) {
        this.methodChannel = methodChannel2;
    }

    private void addTileOverlay(Map<String, ?> map) {
        if (map != null) {
            TileOverlayBuilder tileOverlayBuilder = new TileOverlayBuilder();
            String i11 = Convert.i(map, tileOverlayBuilder);
            tileOverlayBuilder.setTileProvider(new TileProviderController(this.methodChannel, i11));
            this.tileOverlayIdToController.put(i11, new TileOverlayController(this.googleMap.addTileOverlay(tileOverlayBuilder.a())));
        }
    }

    private void changeTileOverlay(Map<String, ?> map) {
        TileOverlayController tileOverlayController;
        if (map != null && (tileOverlayController = this.tileOverlayIdToController.get(getTileOverlayId(map))) != null) {
            Convert.i(map, tileOverlayController);
        }
    }

    private static String getTileOverlayId(Map<String, ?> map) {
        return (String) map.get(Param.TILE_OVERLAY_ID);
    }

    private void removeTileOverlay(String str) {
        TileOverlayController tileOverlayController = this.tileOverlayIdToController.get(str);
        if (tileOverlayController != null) {
            tileOverlayController.c();
            this.tileOverlayIdToController.remove(str);
        }
    }

    public void a(List<Map<String, ?>> list) {
        if (list != null) {
            for (Map<String, ?> addTileOverlay : list) {
                addTileOverlay(addTileOverlay);
            }
        }
    }

    public void b(List<Map<String, ?>> list) {
        if (list != null) {
            for (Map<String, ?> changeTileOverlay : list) {
                changeTileOverlay(changeTileOverlay);
            }
        }
    }

    public void c(String str) {
        TileOverlayController tileOverlayController;
        if (str != null && (tileOverlayController = this.tileOverlayIdToController.get(str)) != null) {
            tileOverlayController.a();
        }
    }

    public Map<String, Object> d(String str) {
        TileOverlayController tileOverlayController;
        if (str == null || (tileOverlayController = this.tileOverlayIdToController.get(str)) == null) {
            return null;
        }
        return tileOverlayController.b();
    }

    public void e(List<String> list) {
        if (list != null) {
            for (String next : list) {
                if (next != null) {
                    removeTileOverlay(next);
                }
            }
        }
    }

    public void f(GoogleMap googleMap2) {
        this.googleMap = googleMap2;
    }
}
