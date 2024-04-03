package com.huawei.hms.flutter.map.map;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import com.huawei.hms.flutter.map.logger.HMSLogger;
import com.huawei.hms.maps.HuaweiMapOptions;
import com.huawei.hms.maps.model.BitmapDescriptor;
import com.huawei.hms.maps.model.CameraPosition;
import com.huawei.hms.maps.model.LatLngBounds;
import com.huawei.hms.maps.model.MyLocationStyle;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class MapBuilder implements MapMethods {
    private Boolean allGesturesEnabled;
    private boolean buildingsEnabled = true;
    private List<HashMap<String, Object>> circles;
    private Integer clusterMarkerColor;
    private Integer clusterMarkerTextColor;
    private boolean gestureScaleByMapCenter = false;
    private List<HashMap<String, Object>> groundOverlays;
    private List<HashMap<String, Object>> heatMaps;
    private BitmapDescriptor iconDescriptor;
    private final HMSLogger logger;
    private Rect logoPadding = new Rect(0, 0, 0, 0);
    private int logoPosition;
    private List<HashMap<String, Object>> markers;
    private boolean markersClustering = false;
    private boolean myLocationButtonEnabled = false;
    private boolean myLocationEnabled = false;
    private MyLocationStyle myLocationStyle;
    private final HuaweiMapOptions options = new HuaweiMapOptions();
    private Rect padding = new Rect(0, 0, 0, 0);
    private Point pointToCenter;
    private List<HashMap<String, Object>> polygons;
    private List<HashMap<String, Object>> polylines;
    private boolean scrollGesturesEnabledDuringRotateOrZoom = true;
    private List<HashMap<String, Object>> tileOverlays;
    private boolean trackCameraPosition = false;
    private boolean trafficEnabled = false;

    public MapBuilder(Application application) {
        this.logger = HMSLogger.getInstance(application);
    }

    public MapController build(int i11, @NonNull Context context, Activity activity, AtomicInteger atomicInteger, BinaryMessenger binaryMessenger, Application application, Lifecycle lifecycle, PluginRegistry.Registrar registrar, int i12) {
        MapController mapController = new MapController(i11, context, activity, atomicInteger, binaryMessenger, application, lifecycle, registrar, i12, this.options);
        mapController.init();
        mapController.setAllGesturesEnabled(this.allGesturesEnabled);
        mapController.setScrollGesturesEnabledDuringRotateOrZoom(this.scrollGesturesEnabledDuringRotateOrZoom);
        mapController.setGestureScaleByMapCenter(this.gestureScaleByMapCenter);
        mapController.setMyLocationEnabled(this.myLocationEnabled);
        mapController.setMyLocationButtonEnabled(this.myLocationButtonEnabled);
        mapController.setTrafficEnabled(this.trafficEnabled);
        mapController.setBuildingsEnabled(this.buildingsEnabled);
        mapController.setTrackCameraPosition(this.trackCameraPosition);
        mapController.setMarkers(this.markers);
        mapController.setPolygons(this.polygons);
        mapController.setPolylines(this.polylines);
        mapController.setCircles(this.circles);
        mapController.setHeatMaps(this.heatMaps);
        Rect rect = this.padding;
        mapController.setPadding((float) rect.top, (float) rect.left, (float) rect.bottom, (float) rect.right);
        mapController.setPointToCenter(this.pointToCenter);
        mapController.setGroundOverlays(this.groundOverlays);
        mapController.setMarkersClustering(this.markersClustering);
        mapController.setTileOverlays(this.tileOverlays);
        mapController.setClusterMarkerColor(this.clusterMarkerColor);
        mapController.setClusterMarkerTextColor(this.clusterMarkerTextColor);
        mapController.setClusterMarkerIcon(this.iconDescriptor);
        mapController.setMyLocationStyle(this.myLocationStyle);
        mapController.setLogoPosition(this.logoPosition);
        Rect rect2 = this.logoPadding;
        mapController.setLogoPadding(rect2.left, rect2.top, rect2.right, rect2.bottom);
        return mapController;
    }

    public void setAllGesturesEnabled(Boolean bool) {
        this.allGesturesEnabled = bool;
    }

    public void setBuildingsEnabled(boolean z11) {
        this.buildingsEnabled = z11;
    }

    public void setCameraTargetBounds(LatLngBounds latLngBounds) {
        this.logger.startMethodExecutionTimer("setCameraTargetBounds");
        this.options.latLngBoundsForCameraTarget(latLngBounds);
        this.logger.sendSingleEvent("setCameraTargetBounds");
    }

    public void setCircles(List<HashMap<String, Object>> list) {
        this.circles = list;
    }

    public void setClusterMarkerColor(Integer num) {
        this.clusterMarkerColor = num;
    }

    public void setClusterMarkerIcon(BitmapDescriptor bitmapDescriptor) {
        this.iconDescriptor = bitmapDescriptor;
    }

    public void setClusterMarkerTextColor(Integer num) {
        this.clusterMarkerTextColor = num;
    }

    public void setCompassEnabled(boolean z11) {
        this.logger.startMethodExecutionTimer("setCompassEnabled");
        this.options.compassEnabled(z11);
        this.logger.sendSingleEvent("setCompassEnabled");
    }

    public void setDark(boolean z11) {
        this.logger.startMethodExecutionTimer("setDark");
        this.options.dark(z11);
        this.logger.sendSingleEvent("setDark");
    }

    public void setGestureScaleByMapCenter(boolean z11) {
        this.gestureScaleByMapCenter = z11;
    }

    public void setGroundOverlays(List<HashMap<String, Object>> list) {
        this.groundOverlays = list;
    }

    public void setHeatMaps(List<HashMap<String, Object>> list) {
        this.heatMaps = list;
    }

    public void setInitialCameraPosition(CameraPosition cameraPosition) {
        this.logger.startMethodExecutionTimer("setInitialCameraPosition");
        this.options.camera(cameraPosition);
        this.logger.sendSingleEvent("setInitialCameraPosition");
    }

    public void setLiteMode(Boolean bool) {
        this.logger.startMethodExecutionTimer("setLiteMode");
        this.options.liteMode(bool.booleanValue());
        this.logger.sendSingleEvent("setLiteMode");
    }

    public void setLogoPadding(int i11, int i12, int i13, int i14) {
        this.logoPadding = new Rect(i11, i12, i13, i14);
    }

    public void setLogoPosition(int i11) {
        this.logoPosition = i11;
    }

    public void setMapToolbarEnabled(boolean z11) {
        this.logger.startMethodExecutionTimer("setMapToolbarEnabled");
        this.options.mapToolbarEnabled(z11);
        this.logger.sendSingleEvent("setMapToolbarEnabled");
    }

    public void setMapType(int i11) {
        this.logger.startMethodExecutionTimer("setMapType");
        this.options.mapType(i11);
        this.logger.sendSingleEvent("setMapType");
    }

    public void setMarkers(List<HashMap<String, Object>> list) {
        this.markers = list;
    }

    public void setMarkersClustering(boolean z11) {
        this.markersClustering = z11;
    }

    public void setMinMaxZoomPreference(Float f11, Float f12) {
        if (f11 != null) {
            this.logger.startMethodExecutionTimer("setMinZoomPreference");
            this.options.minZoomPreference(f11.floatValue());
            this.logger.sendSingleEvent("setMinZoomPreference");
        }
        if (f12 != null) {
            this.logger.startMethodExecutionTimer("setMaxZoomPreference");
            this.options.maxZoomPreference(f12.floatValue());
            this.logger.sendSingleEvent("setMaxZoomPreference");
        }
    }

    public void setMyLocationButtonEnabled(boolean z11) {
        this.myLocationButtonEnabled = z11;
    }

    public void setMyLocationEnabled(boolean z11) {
        this.myLocationEnabled = z11;
    }

    public void setMyLocationStyle(MyLocationStyle myLocationStyle2) {
        this.myLocationStyle = myLocationStyle2;
    }

    public void setPadding(float f11, float f12, float f13, float f14) {
        this.padding = new Rect((int) f12, (int) f11, (int) f14, (int) f13);
    }

    public void setPointToCenter(Point point) {
        this.pointToCenter = point;
    }

    public void setPolygons(List<HashMap<String, Object>> list) {
        this.polygons = list;
    }

    public void setPolylines(List<HashMap<String, Object>> list) {
        this.polylines = list;
    }

    public void setPreviewId(String str) {
        this.logger.startMethodExecutionTimer("setPreviewId");
        this.options.previewId(str);
        this.logger.sendSingleEvent("setPreviewId");
    }

    public void setRotateGesturesEnabled(boolean z11) {
        this.logger.startMethodExecutionTimer("setRotateGesturesEnabled");
        this.options.rotateGesturesEnabled(z11);
        this.logger.startMethodExecutionTimer("setRotateGesturesEnabled");
    }

    public void setScrollGesturesEnabled(boolean z11) {
        this.logger.startMethodExecutionTimer("setScrollGesturesEnabled");
        this.options.scrollGesturesEnabled(z11);
        this.logger.sendSingleEvent("setScrollGesturesEnabled");
    }

    public void setScrollGesturesEnabledDuringRotateOrZoom(boolean z11) {
        this.scrollGesturesEnabledDuringRotateOrZoom = z11;
    }

    public void setStyleId(String str) {
        this.logger.startMethodExecutionTimer("setStyleId");
        this.options.styleId(str);
        this.logger.sendSingleEvent("setStyleId");
    }

    public void setTileOverlays(List<HashMap<String, Object>> list) {
        this.tileOverlays = list;
    }

    public void setTiltGesturesEnabled(boolean z11) {
        this.logger.startMethodExecutionTimer("setTiltGesturesEnabled");
        this.options.tiltGesturesEnabled(z11);
        this.logger.sendSingleEvent("setTiltGesturesEnabled");
    }

    public void setTrackCameraPosition(boolean z11) {
        this.trackCameraPosition = z11;
    }

    public void setTrafficEnabled(boolean z11) {
        this.trafficEnabled = z11;
    }

    public void setZoomControlsEnabled(boolean z11) {
        this.logger.startMethodExecutionTimer("setZoomControlsEnabled");
        this.options.zoomControlsEnabled(z11);
        this.logger.sendSingleEvent("setZoomControlsEnabled");
    }

    public void setZoomGesturesEnabled(boolean z11) {
        this.logger.startMethodExecutionTimer("setZoomGesturesEnabled");
        this.options.zoomGesturesEnabled(z11);
        this.logger.sendSingleEvent("setZoomGesturesEnabled");
    }
}
