package io.flutter.plugins.googlemaps;

import android.content.Context;
import com.huawei.hms.flutter.map.constants.Param;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import java.util.List;
import java.util.Map;

public class GoogleMapFactory extends PlatformViewFactory {
    private final BinaryMessenger binaryMessenger;
    private final LifecycleProvider lifecycleProvider;

    public GoogleMapFactory(BinaryMessenger binaryMessenger2, LifecycleProvider lifecycleProvider2) {
        super(StandardMessageCodec.INSTANCE);
        this.binaryMessenger = binaryMessenger2;
        this.lifecycleProvider = lifecycleProvider2;
    }

    public PlatformView create(Context context, int i11, Object obj) {
        Map map = (Map) obj;
        GoogleMapBuilder googleMapBuilder = new GoogleMapBuilder();
        Convert.d(map.get("options"), googleMapBuilder);
        if (map.containsKey(Param.INITIAL_CAMERA_POSITION)) {
            googleMapBuilder.b(Convert.q(map.get(Param.INITIAL_CAMERA_POSITION)));
        }
        if (map.containsKey(Param.MARKERS_TO_INSERT)) {
            googleMapBuilder.setInitialMarkers(map.get(Param.MARKERS_TO_INSERT));
        }
        if (map.containsKey(Param.POLYGONS_TO_INSERT)) {
            googleMapBuilder.setInitialPolygons(map.get(Param.POLYGONS_TO_INSERT));
        }
        if (map.containsKey(Param.POLYLINES_TO_INSERT)) {
            googleMapBuilder.setInitialPolylines(map.get(Param.POLYLINES_TO_INSERT));
        }
        if (map.containsKey(Param.CIRCLES_TO_INSERT)) {
            googleMapBuilder.setInitialCircles(map.get(Param.CIRCLES_TO_INSERT));
        }
        if (map.containsKey(Param.TILE_OVERLAYS_TO_INSERT)) {
            googleMapBuilder.setInitialTileOverlays((List) map.get(Param.TILE_OVERLAYS_TO_INSERT));
        }
        return googleMapBuilder.a(i11, context, this.binaryMessenger, this.lifecycleProvider);
    }
}
