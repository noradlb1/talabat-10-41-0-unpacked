package com.huawei.hms.flutter.map.map;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.lifecycle.Lifecycle;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.flutter.map.utils.Convert;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MapFactory extends PlatformViewFactory {
    private final int activityHashCode;
    private final Application application;
    private final BinaryMessenger binaryMessenger;
    private final Lifecycle lifecycle;
    private final Activity mActivity;
    private final AtomicInteger mActivityState;
    private final PluginRegistry.Registrar registrar;

    public MapFactory(AtomicInteger atomicInteger, BinaryMessenger binaryMessenger2, Activity activity, Lifecycle lifecycle2, PluginRegistry.Registrar registrar2, int i11) {
        super(StandardMessageCodec.INSTANCE);
        this.mActivityState = atomicInteger;
        this.binaryMessenger = binaryMessenger2;
        this.application = activity.getApplication();
        this.activityHashCode = i11;
        this.lifecycle = lifecycle2;
        this.registrar = registrar2;
        this.mActivity = activity;
    }

    public PlatformView create(Context context, int i11, Object obj) {
        Map map;
        if (obj != null) {
            map = (Map) obj;
        } else {
            map = new HashMap();
        }
        MapBuilder mapBuilder = new MapBuilder(this.application);
        Convert.processHuaweiMapOptions(map.get("options"), mapBuilder);
        if (map.containsKey(Param.INITIAL_CAMERA_POSITION)) {
            mapBuilder.setInitialCameraPosition(Convert.toCameraPosition(map.get(Param.INITIAL_CAMERA_POSITION)));
        }
        if (map.containsKey(Param.MARKERS_TO_INSERT)) {
            mapBuilder.setMarkers((List) map.get(Param.MARKERS_TO_INSERT));
        }
        if (map.containsKey(Param.POLYGONS_TO_INSERT)) {
            mapBuilder.setPolygons((List) map.get(Param.POLYGONS_TO_INSERT));
        }
        if (map.containsKey(Param.POLYLINES_TO_INSERT)) {
            mapBuilder.setPolylines((List) map.get(Param.POLYLINES_TO_INSERT));
        }
        if (map.containsKey(Param.CIRCLES_TO_INSERT)) {
            mapBuilder.setCircles((List) map.get(Param.CIRCLES_TO_INSERT));
        }
        if (map.containsKey(Param.GROUND_OVERLAYS_TO_INSERT)) {
            mapBuilder.setGroundOverlays((List) map.get(Param.GROUND_OVERLAYS_TO_INSERT));
        }
        if (map.containsKey(Param.TILE_OVERLAYS_TO_INSERT)) {
            mapBuilder.setTileOverlays((List) map.get(Param.TILE_OVERLAYS_TO_INSERT));
        }
        if (map.containsKey(Param.HEAT_MAPS_TO_INSERT)) {
            mapBuilder.setHeatMaps((List) map.get(Param.HEAT_MAPS_TO_INSERT));
        }
        return mapBuilder.build(i11, context, this.mActivity, this.mActivityState, this.binaryMessenger, this.application, this.lifecycle, this.registrar, this.activityHashCode);
    }
}
