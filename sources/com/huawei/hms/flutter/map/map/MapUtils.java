package com.huawei.hms.flutter.map.map;

import android.app.Application;
import com.huawei.hms.flutter.map.circle.CircleUtils;
import com.huawei.hms.flutter.map.constants.Method;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.flutter.map.groundoverlay.GroundOverlayUtils;
import com.huawei.hms.flutter.map.heatmap.HeatMapUtils;
import com.huawei.hms.flutter.map.logger.HMSLogger;
import com.huawei.hms.flutter.map.marker.MarkersUtils;
import com.huawei.hms.flutter.map.polygon.PolygonUtils;
import com.huawei.hms.flutter.map.polyline.PolylineUtils;
import com.huawei.hms.flutter.map.tileoverlay.TileOverlayUtils;
import com.huawei.hms.flutter.map.utils.Convert;
import com.huawei.hms.maps.CameraUpdate;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.model.CameraPosition;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.MapStyleOptions;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.CharUtils;

class MapUtils {
    private final CircleUtils circleUtils;
    private final float compactness;
    private final GroundOverlayUtils groundOverlayUtils;
    private final HeatMapUtils heatMapUtils;
    private HuaweiMap huaweiMap;
    private final HMSLogger logger;
    private final MarkersUtils markersUtils;
    private BinaryMessenger messenger;
    private final PolygonUtils polygonUtils;
    private final PolylineUtils polylineUtils;
    private final TileOverlayUtils tileOverlayUtils;

    public MapUtils(MethodChannel methodChannel, float f11, Application application) {
        this.logger = HMSLogger.getInstance(application);
        this.compactness = f11;
        this.markersUtils = new MarkersUtils(methodChannel, application);
        this.polylineUtils = new PolylineUtils(methodChannel, f11, application);
        this.polygonUtils = new PolygonUtils(methodChannel, f11, application);
        this.circleUtils = new CircleUtils(methodChannel, f11, application);
        this.groundOverlayUtils = new GroundOverlayUtils(methodChannel, application);
        this.tileOverlayUtils = new TileOverlayUtils(application);
        this.heatMapUtils = new HeatMapUtils(methodChannel, application);
    }

    private void onMethodCallComponents(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1666066482:
                if (str.equals(Method.POLYLINES_UPDATE)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1377699598:
                if (str.equals(Method.POLYGONS_UPDATE)) {
                    c11 = 1;
                    break;
                }
                break;
            case -1044627007:
                if (str.equals(Method.GROUND_OVERLAYS_UPDATE)) {
                    c11 = 2;
                    break;
                }
                break;
            case -866956193:
                if (str.equals(Method.MARKERS_HIDE_INFO_WINDOW)) {
                    c11 = 3;
                    break;
                }
                break;
            case -850924484:
                if (str.equals(Method.MARKER_START_ANIMATION)) {
                    c11 = 4;
                    break;
                }
                break;
            case -89404678:
                if (str.equals(Method.TILE_OVERLAYS_UPDATE)) {
                    c11 = 5;
                    break;
                }
                break;
            case 4862728:
                if (str.equals(Method.MARKERS_UPDATE)) {
                    c11 = 6;
                    break;
                }
                break;
            case 321792469:
                if (str.equals(Method.HEAT_MAPS_UPDATE)) {
                    c11 = 7;
                    break;
                }
                break;
            case 555443614:
                if (str.equals(Method.CIRCLES_UPDATE)) {
                    c11 = 8;
                    break;
                }
                break;
            case 775091665:
                if (str.equals(Method.MARKER_IS_CLUSTERABLE)) {
                    c11 = 9;
                    break;
                }
                break;
            case 1137858130:
                if (str.equals(Method.CIRCLE_START_ANIMATION)) {
                    c11 = 10;
                    break;
                }
                break;
            case 1594793050:
                if (str.equals(Method.MARKERS_SHOW_INFO_WINDOW)) {
                    c11 = 11;
                    break;
                }
                break;
            case 1618330442:
                if (str.equals(Method.MARKERS_IS_INFO_WINDOW_SHOWN)) {
                    c11 = 12;
                    break;
                }
                break;
            case 2007374247:
                if (str.equals(Method.CLEAR_TILE_CACHE)) {
                    c11 = CharUtils.CR;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                this.polylineUtils.insertMulti((List) methodCall.argument(Param.POLYLINES_TO_INSERT));
                this.polylineUtils.updateMulti((List) methodCall.argument(Param.POLYLINES_TO_UPDATE));
                this.polylineUtils.deleteMulti((List) methodCall.argument(Param.POLYLINES_TO_DELETE));
                result.success(Boolean.TRUE);
                return;
            case 1:
                this.polygonUtils.insertMulti((List) methodCall.argument(Param.POLYGONS_TO_INSERT));
                this.polygonUtils.updateMulti((List) methodCall.argument(Param.POLYGONS_TO_UPDATE));
                this.polygonUtils.deleteMulti((List) methodCall.argument(Param.POLYGONS_TO_DELETE));
                result.success(Boolean.TRUE);
                return;
            case 2:
                this.groundOverlayUtils.insertMulti((List) methodCall.argument(Param.GROUND_OVERLAYS_TO_INSERT));
                this.groundOverlayUtils.updateMulti((List) methodCall.argument(Param.GROUND_OVERLAYS_TO_UPDATE));
                this.groundOverlayUtils.deleteMulti((List) methodCall.argument(Param.GROUND_OVERLAYS_TO_DELETE));
                result.success(Boolean.TRUE);
                return;
            case 3:
                Object argument = methodCall.argument(Param.MARKER_ID);
                this.logger.startMethodExecutionTimer(Method.MARKERS_HIDE_INFO_WINDOW);
                this.markersUtils.hideInfoWindow((String) argument, result);
                this.logger.sendSingleEvent(Method.MARKERS_HIDE_INFO_WINDOW);
                return;
            case 4:
                Object argument2 = methodCall.argument(Param.MARKER_ID);
                this.logger.startMethodExecutionTimer(Method.MARKER_START_ANIMATION);
                this.markersUtils.startAnimation((String) argument2);
                this.logger.sendSingleEvent(Method.MARKER_START_ANIMATION);
                return;
            case 5:
                this.tileOverlayUtils.insertMulti((List) methodCall.argument(Param.TILE_OVERLAYS_TO_INSERT));
                this.tileOverlayUtils.updateMulti((List) methodCall.argument(Param.TILE_OVERLAYS_TO_UPDATE));
                this.tileOverlayUtils.deleteMulti((List) methodCall.argument(Param.TILE_OVERLAYS_TO_DELETE));
                result.success(Boolean.TRUE);
                return;
            case 6:
                this.markersUtils.insertMulti((List) methodCall.argument(Param.MARKERS_TO_INSERT), this.messenger);
                this.markersUtils.updateMulti((List) methodCall.argument(Param.MARKERS_TO_UPDATE));
                this.markersUtils.deleteMulti((List) methodCall.argument(Param.MARKERS_TO_DELETE));
                result.success(Boolean.TRUE);
                return;
            case 7:
                this.heatMapUtils.insertMulti((List) methodCall.argument(Param.HEAT_MAPS_TO_INSERT));
                this.heatMapUtils.updateMulti((List) methodCall.argument(Param.HEAT_MAPS_TO_UPDATE));
                this.heatMapUtils.deleteMulti((List) methodCall.argument(Param.HEAT_MAPS_TO_DELETE));
                result.success(Boolean.TRUE);
                return;
            case 8:
                this.circleUtils.insertMulti((List) methodCall.argument(Param.CIRCLES_TO_INSERT), this.messenger);
                this.circleUtils.updateMulti((List) methodCall.argument(Param.CIRCLES_TO_UPDATE));
                this.circleUtils.deleteMulti((List) methodCall.argument(Param.CIRCLES_TO_DELETE));
                result.success(Boolean.TRUE);
                return;
            case 9:
                Object argument3 = methodCall.argument(Param.MARKER_ID);
                this.logger.startMethodExecutionTimer(Method.MARKER_IS_CLUSTERABLE);
                this.markersUtils.isMarkerClusterable((String) argument3, result);
                this.logger.sendSingleEvent(Method.MARKER_IS_CLUSTERABLE);
                return;
            case 10:
                Object argument4 = methodCall.argument(Param.CIRCLE_ID);
                this.logger.startMethodExecutionTimer(Method.CIRCLE_START_ANIMATION);
                this.circleUtils.startAnimation((String) argument4);
                this.logger.sendSingleEvent(Method.CIRCLE_START_ANIMATION);
                return;
            case 11:
                Object argument5 = methodCall.argument(Param.MARKER_ID);
                this.logger.startMethodExecutionTimer(Method.MARKERS_SHOW_INFO_WINDOW);
                this.markersUtils.showInfoWindow((String) argument5, result);
                this.logger.sendSingleEvent(Method.MARKERS_SHOW_INFO_WINDOW);
                return;
            case 12:
                Object argument6 = methodCall.argument(Param.MARKER_ID);
                this.logger.startMethodExecutionTimer(Method.MARKERS_IS_INFO_WINDOW_SHOWN);
                this.markersUtils.isInfoWindowShown((String) argument6, result);
                this.logger.sendSingleEvent(Method.MARKERS_IS_INFO_WINDOW_SHOWN);
                return;
            case 13:
                this.tileOverlayUtils.clearTileCache((String) methodCall.argument(Param.TILE_OVERLAY_ID));
                result.success((Object) null);
                return;
            default:
                onMethodCallGetters(methodCall, result);
                return;
        }
    }

    private void onMethodCallGetters(MethodCall methodCall, MethodChannel.Result result) {
        MethodChannel.Result result2 = result;
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1386227266:
                if (str.equals(Method.MAP_IS_ZOOM_GESTURES_ENABLED)) {
                    c11 = 0;
                    break;
                }
                break;
            case -660293906:
                if (str.equals(Method.MAP_GET_MIN_MAX_ZOOM_LEVELS)) {
                    c11 = 1;
                    break;
                }
                break;
            case -531467076:
                if (str.equals(Method.MAP_IS_MAP_TOOLBAR_ENABLED)) {
                    c11 = 2;
                    break;
                }
                break;
            case -496923182:
                if (str.equals(Method.MAP_IS_ZOOM_CONTROLS_ENABLED)) {
                    c11 = 3;
                    break;
                }
                break;
            case -115764164:
                if (str.equals(Method.MAP_IS_DARK)) {
                    c11 = 4;
                    break;
                }
                break;
            case 236409621:
                if (str.equals(Method.MAP_IS_COMPASS_ENABLED)) {
                    c11 = 5;
                    break;
                }
                break;
            case 537251076:
                if (str.equals(Method.MAP_IS_SCROLL_GESTURES_ENABLED)) {
                    c11 = 6;
                    break;
                }
                break;
            case 615458998:
                if (str.equals(Method.MAP_IS_ROTATE_GESTURES_ENABLED)) {
                    c11 = 7;
                    break;
                }
                break;
            case 684203978:
                if (str.equals(Method.MAP_IS_TRAFFIC_ENABLED)) {
                    c11 = 8;
                    break;
                }
                break;
            case 1547423016:
                if (str.equals(Method.MAP_IS_MY_LOCATION_BUTTON_ENABLED)) {
                    c11 = 9;
                    break;
                }
                break;
            case 1635849672:
                if (str.equals(Method.MAP_IS_BUILDINGS_ENABLED)) {
                    c11 = 10;
                    break;
                }
                break;
            case 1759895607:
                if (str.equals(Method.MAP_GET_ZOOM_LEVEL)) {
                    c11 = 11;
                    break;
                }
                break;
            case 2029369748:
                if (str.equals(Method.MAP_IS_TILT_GESTURES_ENABLED)) {
                    c11 = 12;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                String str2 = Method.MAP_IS_ZOOM_GESTURES_ENABLED;
                this.logger.startMethodExecutionTimer(str2);
                result.success(Boolean.valueOf(this.huaweiMap.getUiSettings().isZoomGesturesEnabled()));
                this.logger.sendSingleEvent(str2);
                return;
            case 1:
                this.logger.startMethodExecutionTimer(Method.MAP_GET_MIN_MAX_ZOOM_LEVELS);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(this.huaweiMap.getMinZoomLevel()));
                arrayList.add(Float.valueOf(this.huaweiMap.getMaxZoomLevel()));
                result.success(arrayList);
                this.logger.sendSingleEvent(Method.MAP_GET_MIN_MAX_ZOOM_LEVELS);
                return;
            case 2:
                this.logger.startMethodExecutionTimer(Method.MAP_IS_MAP_TOOLBAR_ENABLED);
                result.success(Boolean.valueOf(this.huaweiMap.getUiSettings().isMapToolbarEnabled()));
                this.logger.sendSingleEvent(Method.MAP_IS_MAP_TOOLBAR_ENABLED);
                return;
            case 3:
                this.logger.startMethodExecutionTimer(Method.MAP_IS_ZOOM_CONTROLS_ENABLED);
                result.success(Boolean.valueOf(this.huaweiMap.getUiSettings().isZoomControlsEnabled()));
                this.logger.sendSingleEvent(Method.MAP_IS_ZOOM_CONTROLS_ENABLED);
                return;
            case 4:
                this.logger.startMethodExecutionTimer(Method.MAP_IS_DARK);
                result.success(Boolean.valueOf(this.huaweiMap.isDark()));
                this.logger.sendSingleEvent(Method.MAP_IS_DARK);
                return;
            case 5:
                this.logger.startMethodExecutionTimer(Method.MAP_IS_COMPASS_ENABLED);
                result.success(Boolean.valueOf(this.huaweiMap.getUiSettings().isCompassEnabled()));
                this.logger.sendSingleEvent(Method.MAP_IS_COMPASS_ENABLED);
                return;
            case 6:
                this.logger.startMethodExecutionTimer(Method.MAP_IS_SCROLL_GESTURES_ENABLED);
                result.success(Boolean.valueOf(this.huaweiMap.getUiSettings().isScrollGesturesEnabled()));
                this.logger.sendSingleEvent(Method.MAP_IS_SCROLL_GESTURES_ENABLED);
                return;
            case 7:
                this.logger.startMethodExecutionTimer(Method.MAP_IS_ROTATE_GESTURES_ENABLED);
                result.success(Boolean.valueOf(this.huaweiMap.getUiSettings().isRotateGesturesEnabled()));
                this.logger.sendSingleEvent(Method.MAP_IS_ROTATE_GESTURES_ENABLED);
                return;
            case 8:
                this.logger.startMethodExecutionTimer(Method.MAP_IS_TRAFFIC_ENABLED);
                result.success(Boolean.valueOf(this.huaweiMap.isTrafficEnabled()));
                this.logger.sendSingleEvent(Method.MAP_IS_TRAFFIC_ENABLED);
                return;
            case 9:
                this.logger.startMethodExecutionTimer(Method.MAP_IS_MY_LOCATION_BUTTON_ENABLED);
                result.success(Boolean.valueOf(this.huaweiMap.getUiSettings().isMyLocationButtonEnabled()));
                this.logger.sendSingleEvent(Method.MAP_IS_MY_LOCATION_BUTTON_ENABLED);
                return;
            case 10:
                this.logger.startMethodExecutionTimer(Method.MAP_IS_BUILDINGS_ENABLED);
                result.success(Boolean.valueOf(this.huaweiMap.isBuildingsEnabled()));
                this.logger.sendSingleEvent(Method.MAP_IS_BUILDINGS_ENABLED);
                return;
            case 11:
                this.logger.startMethodExecutionTimer(Method.MAP_GET_ZOOM_LEVEL);
                result.success(Float.valueOf(this.huaweiMap.getCameraPosition().zoom));
                this.logger.sendSingleEvent(Method.MAP_GET_ZOOM_LEVEL);
                return;
            case 12:
                this.logger.startMethodExecutionTimer(Method.MAP_IS_TILT_GESTURES_ENABLED);
                result.success(Boolean.valueOf(this.huaweiMap.getUiSettings().isTiltGesturesEnabled()));
                this.logger.sendSingleEvent(Method.MAP_IS_TILT_GESTURES_ENABLED);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    public void animateCamera(CameraUpdate cameraUpdate) {
        this.logger.startMethodExecutionTimer("animateCamera");
        this.huaweiMap.animateCamera(cameraUpdate);
        this.logger.sendSingleEvent("animateCamera");
    }

    public CameraPosition getCameraPosition(boolean z11) {
        if (z11) {
            return this.huaweiMap.getCameraPosition();
        }
        return null;
    }

    public void init(HuaweiMap huaweiMap2, List<HashMap<String, Object>> list, List<HashMap<String, Object>> list2, List<HashMap<String, Object>> list3, List<HashMap<String, Object>> list4, List<HashMap<String, Object>> list5, List<HashMap<String, Object>> list6, List<HashMap<String, Object>> list7, boolean z11, BinaryMessenger binaryMessenger) {
        this.huaweiMap = huaweiMap2;
        this.markersUtils.setMap(huaweiMap2);
        this.polylineUtils.setMap(huaweiMap2);
        this.polygonUtils.setMap(huaweiMap2);
        this.circleUtils.setMap(huaweiMap2);
        this.groundOverlayUtils.setMap(huaweiMap2);
        this.tileOverlayUtils.setMap(huaweiMap2);
        this.heatMapUtils.setMap(huaweiMap2);
        huaweiMap2.setMarkersClustering(z11);
        initComponents(list, list2, list3, list4, list5, list6, list7, binaryMessenger);
    }

    public void initCircles(List<HashMap<String, Object>> list) {
        this.circleUtils.insertMulti(list, this.messenger);
    }

    public void initComponents(List<HashMap<String, Object>> list, List<HashMap<String, Object>> list2, List<HashMap<String, Object>> list3, List<HashMap<String, Object>> list4, List<HashMap<String, Object>> list5, List<HashMap<String, Object>> list6, List<HashMap<String, Object>> list7, BinaryMessenger binaryMessenger) {
        this.messenger = binaryMessenger;
        initMarkers(list);
        initPolylines(list2);
        initPolygons(list3);
        initCircles(list4);
        initGroundOverlays(list5);
        initTileOverlays(list6);
        initHeatMaps(list7);
    }

    public void initGroundOverlays(List<HashMap<String, Object>> list) {
        this.groundOverlayUtils.insertMulti(list);
    }

    public void initHeatMaps(List<HashMap<String, Object>> list) {
        this.heatMapUtils.insertMulti(list);
    }

    public void initMarkers(List<HashMap<String, Object>> list) {
        this.markersUtils.insertMulti(list, this.messenger);
    }

    public void initPolygons(List<HashMap<String, Object>> list) {
        this.polygonUtils.insertMulti(list);
    }

    public void initPolylines(List<HashMap<String, Object>> list) {
        this.polylineUtils.insertMulti(list);
    }

    public void initTileOverlays(List<HashMap<String, Object>> list) {
        this.tileOverlayUtils.insertMulti(list);
    }

    public void moveCamera(CameraUpdate cameraUpdate) {
        this.logger.startMethodExecutionTimer("moveCamera");
        this.huaweiMap.moveCamera(cameraUpdate);
        this.logger.sendSingleEvent("moveCamera");
    }

    public void onCircleClick(String str) {
        this.logger.startMethodExecutionTimer("onCircleClick");
        this.circleUtils.onCircleClick(str);
        this.logger.sendSingleEvent("onCircleClick");
    }

    public void onGroundOverlayClick(String str) {
        this.logger.startMethodExecutionTimer("onGroundOverlayClick");
        this.groundOverlayUtils.onGroundOverlayClick(str);
        this.logger.sendSingleEvent("onGroundOverlayClick");
    }

    public void onInfoWindowClick(String str) {
        this.logger.startMethodExecutionTimer("onInfoWindowClick");
        this.markersUtils.onInfoWindowClick(str);
        this.logger.sendSingleEvent("onInfoWindowClick");
    }

    public void onInfoWindowClose(String str) {
        this.logger.startMethodExecutionTimer("onInfoWindowClose");
        this.markersUtils.onInfoWindowClose(str);
        this.logger.sendSingleEvent("onInfoWindowClose");
    }

    public void onInfoWindowLongClick(String str) {
        this.logger.startMethodExecutionTimer("onInfoWindowLongClick");
        this.markersUtils.onInfoWindowLongClick(str);
        this.logger.sendSingleEvent("onInfoWindowLongClick");
    }

    public boolean onMarkerClick(String str) {
        return this.markersUtils.onMarkerClick(str);
    }

    public void onMarkerDrag(String str, LatLng latLng) {
        this.logger.startMethodExecutionTimer("onMarkerDrag");
        this.markersUtils.onMarkerDrag(str, latLng);
        this.logger.sendSingleEvent("onMarkerDrag");
    }

    public void onMarkerDragEnd(String str, LatLng latLng) {
        this.logger.startMethodExecutionTimer("onMarkerDragEnd");
        this.markersUtils.onMarkerDragEnd(str, latLng);
        this.logger.sendSingleEvent("onMarkerDragEnd");
    }

    public void onMarkerDragStart(String str, LatLng latLng) {
        this.logger.startMethodExecutionTimer("onMarkerDragStart");
        this.markersUtils.onMarkerDragStart(str, latLng);
        this.logger.sendSingleEvent("onMarkerDragStart");
    }

    public void onMethodCallCamera(MethodCall methodCall, MethodChannel.Result result) {
        boolean z11;
        String str = methodCall.method;
        str.hashCode();
        if (str.equals(Method.MAP_SET_STYLE)) {
            String str2 = (String) methodCall.arguments;
            this.logger.startMethodExecutionTimer(Method.MAP_SET_STYLE);
            if (str2 == null) {
                z11 = this.huaweiMap.setMapStyle((MapStyleOptions) null);
            } else {
                z11 = this.huaweiMap.setMapStyle(new MapStyleOptions(str2));
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Boolean.valueOf(z11));
            if (!z11) {
                arrayList.add(Param.ERROR);
            }
            result.success(arrayList);
            this.logger.sendSingleEvent(Method.MAP_SET_STYLE);
        } else if (!str.equals(Method.CAMERA_ANIMATE)) {
            onMethodCallComponents(methodCall, result);
        } else {
            animateCamera(Convert.toCameraUpdate(methodCall.argument(Param.CAMERA_UPDATE), this.compactness));
            result.success(Boolean.TRUE);
        }
    }

    public void onPolygonClick(String str) {
        this.logger.startMethodExecutionTimer("onPolygonClick");
        this.polygonUtils.onPolygonClick(str);
        this.logger.sendSingleEvent("onPolygonClick");
    }

    public void onPolylineClick(String str) {
        this.logger.startMethodExecutionTimer("onPolylineClick");
        this.polylineUtils.onPolylineClick(str);
        this.logger.sendSingleEvent("onPolylineClick");
    }
}
