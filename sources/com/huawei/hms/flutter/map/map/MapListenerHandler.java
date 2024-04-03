package com.huawei.hms.flutter.map.map;

import android.app.Application;
import android.location.Location;
import androidx.annotation.Nullable;
import com.huawei.hms.flutter.map.constants.Method;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.flutter.map.logger.HMSLogger;
import com.huawei.hms.flutter.map.utils.ToJson;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.model.Circle;
import com.huawei.hms.maps.model.GroundOverlay;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.Marker;
import com.huawei.hms.maps.model.PointOfInterest;
import com.huawei.hms.maps.model.Polygon;
import com.huawei.hms.maps.model.Polyline;
import io.flutter.plugin.common.MethodChannel;
import java.util.Collections;
import java.util.HashMap;

public class MapListenerHandler implements MapListener {
    private HuaweiMap huaweiMap;

    /* renamed from: id  reason: collision with root package name */
    private final int f48816id;
    private final HMSLogger logger;
    private final MethodChannel mChannel;
    private final MapUtils mapUtils;
    private boolean trackCameraPosition = false;

    public MapListenerHandler(int i11, MapUtils mapUtils2, MethodChannel methodChannel, Application application) {
        this.f48816id = i11;
        this.mChannel = methodChannel;
        this.mapUtils = mapUtils2;
        this.logger = HMSLogger.getInstance(application);
    }

    public void init(HuaweiMap huaweiMap2) {
        this.huaweiMap = huaweiMap2;
        setMapListener(this);
    }

    public void onCameraIdle() {
        this.logger.startMethodExecutionTimer(Method.CAMERA_ON_IDLE);
        this.mChannel.invokeMethod(Method.CAMERA_ON_IDLE, Collections.singletonMap(Param.MAP, Integer.valueOf(this.f48816id)));
        this.logger.sendPeriodicEvent(Method.CAMERA_ON_IDLE);
    }

    public void onCameraMove() {
        if (this.trackCameraPosition) {
            this.logger.startMethodExecutionTimer(Method.CAMERA_ON_MOVE);
            HashMap hashMap = new HashMap();
            hashMap.put("position", ToJson.cameraPosition(this.huaweiMap.getCameraPosition()));
            this.mChannel.invokeMethod(Method.CAMERA_ON_MOVE, hashMap);
            this.logger.sendPeriodicEvent(Method.CAMERA_ON_MOVE);
        }
    }

    public void onCameraMoveCanceled() {
        this.logger.startMethodExecutionTimer(Method.CAMERA_ON_MOVE_CANCELED);
        this.mChannel.invokeMethod(Method.CAMERA_ON_MOVE_CANCELED, Collections.singletonMap(Param.MAP, Integer.valueOf(this.f48816id)));
        this.logger.sendPeriodicEvent(Method.CAMERA_ON_MOVE_CANCELED);
    }

    public void onCameraMoveStarted(int i11) {
        this.logger.startMethodExecutionTimer(Method.CAMERA_ON_MOVE_STARTED);
        HashMap hashMap = new HashMap();
        hashMap.put("reason", Integer.valueOf(i11));
        this.mChannel.invokeMethod(Method.CAMERA_ON_MOVE_STARTED, hashMap);
        this.logger.sendSingleEvent(Method.CAMERA_ON_MOVE_STARTED);
    }

    public void onCircleClick(Circle circle) {
        this.mapUtils.onCircleClick(circle.getId());
    }

    public void onGroundOverlayClick(GroundOverlay groundOverlay) {
        this.mapUtils.onGroundOverlayClick(groundOverlay.getId());
    }

    public void onInfoWindowClick(Marker marker) {
        this.mapUtils.onInfoWindowClick(marker.getId());
    }

    public void onInfoWindowClose(Marker marker) {
        this.mapUtils.onInfoWindowClose(marker.getId());
    }

    public void onInfoWindowLongClick(Marker marker) {
        this.mapUtils.onInfoWindowLongClick(marker.getId());
    }

    public void onMapClick(LatLng latLng) {
        this.logger.startMethodExecutionTimer(Method.MAP_CLICK);
        HashMap hashMap = new HashMap();
        hashMap.put("position", ToJson.latLng(latLng));
        this.mChannel.invokeMethod(Method.MAP_CLICK, hashMap);
        this.logger.sendSingleEvent(Method.MAP_CLICK);
    }

    public void onMapLongClick(LatLng latLng) {
        this.logger.startMethodExecutionTimer(Method.MAP_ON_LONG_PRESS);
        HashMap hashMap = new HashMap();
        hashMap.put("position", ToJson.latLng(latLng));
        this.mChannel.invokeMethod(Method.MAP_ON_LONG_PRESS, hashMap);
        this.logger.sendSingleEvent(Method.MAP_ON_LONG_PRESS);
    }

    public boolean onMarkerClick(Marker marker) {
        return this.mapUtils.onMarkerClick(marker.getId());
    }

    public void onMarkerDrag(Marker marker) {
        this.mapUtils.onMarkerDrag(marker.getId(), marker.getPosition());
    }

    public void onMarkerDragEnd(Marker marker) {
        this.mapUtils.onMarkerDragEnd(marker.getId(), marker.getPosition());
    }

    public void onMarkerDragStart(Marker marker) {
        this.mapUtils.onMarkerDragStart(marker.getId(), marker.getPosition());
    }

    public boolean onMyLocationButtonClick() {
        this.logger.startMethodExecutionTimer(Method.MAP_ON_MY_LOCATION_BUTTON_CLICK);
        this.mChannel.invokeMethod(Method.MAP_ON_MY_LOCATION_BUTTON_CLICK, Boolean.FALSE);
        this.logger.sendSingleEvent(Method.MAP_ON_MY_LOCATION_BUTTON_CLICK);
        return false;
    }

    public void onMyLocationClick(Location location) {
        this.logger.startMethodExecutionTimer(Method.MAP_ON_MY_LOCATION_CLICK);
        HashMap hashMap = new HashMap();
        hashMap.put("location", ToJson.location(location));
        this.mChannel.invokeMethod(Method.MAP_ON_MY_LOCATION_CLICK, hashMap);
        this.logger.sendSingleEvent(Method.MAP_ON_MY_LOCATION_CLICK);
    }

    public void onPoiClick(PointOfInterest pointOfInterest) {
        this.logger.startMethodExecutionTimer(Method.MAP_ON_POI_CLICK);
        HashMap hashMap = new HashMap();
        hashMap.put(Param.POINT_OF_INTEREST, ToJson.pointOfInterest(pointOfInterest));
        this.mChannel.invokeMethod(Method.MAP_ON_POI_CLICK, hashMap);
        this.logger.sendSingleEvent(Method.MAP_ON_POI_CLICK);
    }

    public void onPolygonClick(Polygon polygon) {
        this.mapUtils.onPolygonClick(polygon.getId());
    }

    public void onPolylineClick(Polyline polyline) {
        this.mapUtils.onPolylineClick(polyline.getId());
    }

    public void setMapListener(@Nullable MapListener mapListener) {
        this.logger.startMethodExecutionTimer("setOnInfoWindowClickListener");
        this.huaweiMap.setOnInfoWindowClickListener(this);
        this.logger.sendSingleEvent("setOnInfoWindowClickListener");
        this.logger.startMethodExecutionTimer("setOnCameraMoveListener");
        this.huaweiMap.setOnCameraMoveListener(mapListener);
        this.logger.sendSingleEvent("setOnCameraMoveListener");
        this.logger.startMethodExecutionTimer("setOnCameraMoveStartedListener");
        this.huaweiMap.setOnCameraMoveStartedListener(mapListener);
        this.logger.sendSingleEvent("setOnCameraMoveStartedListener");
        this.logger.startMethodExecutionTimer("setOnCameraIdleListener");
        this.huaweiMap.setOnCameraIdleListener(mapListener);
        this.logger.sendSingleEvent("setOnCameraIdleListener");
        this.logger.startMethodExecutionTimer("setOnCameraMoveCanceledListener");
        this.huaweiMap.setOnCameraMoveCanceledListener(mapListener);
        this.logger.sendSingleEvent("setOnCameraMoveCanceledListener");
        this.logger.startMethodExecutionTimer("setOnMarkerClickListener");
        this.huaweiMap.setOnMarkerClickListener(mapListener);
        this.logger.sendSingleEvent("setOnMarkerClickListener");
        this.logger.startMethodExecutionTimer("setOnMarkerDragListener");
        this.huaweiMap.setOnMarkerDragListener(mapListener);
        this.logger.sendSingleEvent("setOnMarkerDragListener");
        this.logger.startMethodExecutionTimer("setOnPolygonClickListener");
        this.huaweiMap.setOnPolygonClickListener(mapListener);
        this.logger.sendSingleEvent("setOnPolygonClickListener");
        this.logger.startMethodExecutionTimer("setOnPolylineClickListener");
        this.huaweiMap.setOnPolylineClickListener(mapListener);
        this.logger.sendSingleEvent("setOnPolylineClickListener");
        this.logger.startMethodExecutionTimer("setOnCircleClickListener");
        this.huaweiMap.setOnCircleClickListener(mapListener);
        this.logger.sendSingleEvent("setOnCircleClickListener");
        this.logger.startMethodExecutionTimer("setOnMapClickListener");
        this.huaweiMap.setOnMapClickListener(mapListener);
        this.logger.sendSingleEvent("setOnMapClickListener");
        this.logger.startMethodExecutionTimer("setOnMapLongClickListener");
        this.huaweiMap.setOnMapLongClickListener(mapListener);
        this.logger.sendSingleEvent("setOnMapLongClickListener");
        this.logger.startMethodExecutionTimer("setOnGroundOverlayClickListener");
        this.huaweiMap.setOnGroundOverlayClickListener(mapListener);
        this.logger.sendSingleEvent("setOnGroundOverlayClickListener");
        this.logger.startMethodExecutionTimer("setOnPoiClickListener");
        this.huaweiMap.setOnPoiClickListener(mapListener);
        this.logger.sendSingleEvent("setOnPoiClickListener");
        this.logger.startMethodExecutionTimer("setOnMyLocationClickListener");
        this.huaweiMap.setOnMyLocationClickListener(mapListener);
        this.logger.sendSingleEvent("setOnMyLocationClickListener");
        this.logger.startMethodExecutionTimer("setOnMyLocationButtonClickListener");
        this.huaweiMap.setOnMyLocationButtonClickListener(mapListener);
        this.logger.sendSingleEvent("setOnMyLocationButtonClickListener");
        this.logger.startMethodExecutionTimer("setOnInfoWindowLongClickListener");
        this.huaweiMap.setOnInfoWindowLongClickListener(mapListener);
        this.logger.sendSingleEvent("setOnInfoWindowLongClickListener");
        this.logger.startMethodExecutionTimer("setOnInfoWindowCloseListener");
        this.huaweiMap.setOnInfoWindowCloseListener(mapListener);
        this.logger.sendSingleEvent("setOnInfoWindowCloseListener");
    }

    public void setTrackCameraPosition(boolean z11) {
        this.trackCameraPosition = z11;
    }
}
