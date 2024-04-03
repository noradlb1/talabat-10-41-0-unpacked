package com.huawei.hms.flutter.map.map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.huawei.hms.flutter.map.constants.Method;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.flutter.map.logger.HMSLogger;
import com.huawei.hms.flutter.map.utils.Convert;
import com.huawei.hms.flutter.map.utils.ToJson;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.HuaweiMapOptions;
import com.huawei.hms.maps.LocationSource;
import com.huawei.hms.maps.MapView;
import com.huawei.hms.maps.OnMapReadyCallback;
import com.huawei.hms.maps.UiSettings;
import com.huawei.hms.maps.model.BitmapDescriptor;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.LatLngBounds;
import com.huawei.hms.maps.model.MyLocationStyle;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformView;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import xz.b;

final class MapController implements MapMethods, MethodChannel.MethodCallHandler, OnMapReadyCallback, DefaultLifecycleObserver, Application.ActivityLifecycleCallbacks, PlatformView, ActivityPluginBinding.OnSaveInstanceStateListener, LocationSource {
    private final int activityHashCode;
    private final AtomicInteger activityState;
    private Boolean allGesturesEnabled;
    private boolean buildingsEnabled = true;
    private Integer clusterMarkerColor;
    private Integer clusterMarkerTextColor;
    private final float compactness;
    private final Context context;
    private boolean disposed = false;
    private boolean gestureScaleByMapCenter = false;
    private HuaweiMap huaweiMap;
    private BitmapDescriptor iconDescriptor;
    private List<HashMap<String, Object>> initCircles;
    private List<HashMap<String, Object>> initGroundOverlays;
    private List<HashMap<String, Object>> initHeatMaps;
    private List<HashMap<String, Object>> initMarkers;
    private List<HashMap<String, Object>> initPolygons;
    private List<HashMap<String, Object>> initPolylines;
    private List<HashMap<String, Object>> initTileOverlays;
    private boolean isScrollGesturesEnabledDuringRotateOrZoom = true;
    private final Lifecycle lifecycle;
    private LocationSource.OnLocationChangedListener locationChangedListener;
    private final HMSLogger logger;
    private Rect logoPadding = new Rect(0, 0, 0, 0);
    private int logoPosition;
    private final Application mApplication;
    private final MapListenerHandler mapListenerHandler;
    private MethodChannel.Result mapReadyResult;
    private final MapUtils mapUtils;
    private final MapView mapView;
    private boolean markersClustering = false;
    private final BinaryMessenger messenger;
    private final MethodChannel methodChannel;
    private boolean myLocationButtonEnabled = false;
    private boolean myLocationEnabled = false;
    private MyLocationStyle myLocationStyle;
    private Rect padding = new Rect(0, 0, 0, 0);
    private Point pointToCenter;
    private final PluginRegistry.Registrar registrar;
    private boolean trackCameraPosition = false;
    private boolean trafficEnabled = false;
    private boolean zoomControlsEnabled = true;

    public MapController(int i11, Context context2, Activity activity, AtomicInteger atomicInteger, BinaryMessenger binaryMessenger, Application application, Lifecycle lifecycle2, PluginRegistry.Registrar registrar2, int i12, HuaweiMapOptions huaweiMapOptions) {
        this.context = context2;
        this.activityState = atomicInteger;
        this.mapView = new MapView((Context) activity, huaweiMapOptions);
        float f11 = context2.getResources().getDisplayMetrics().density;
        this.compactness = f11;
        this.messenger = binaryMessenger;
        MethodChannel methodChannel2 = new MethodChannel(binaryMessenger, "com.huawei.hms.flutter.map/map_" + i11);
        this.methodChannel = methodChannel2;
        methodChannel2.setMethodCallHandler(this);
        this.mApplication = application;
        this.lifecycle = lifecycle2;
        this.registrar = registrar2;
        this.activityHashCode = i12;
        MapUtils mapUtils2 = new MapUtils(methodChannel2, f11, application);
        this.mapUtils = mapUtils2;
        this.mapListenerHandler = new MapListenerHandler(i11, mapUtils2, methodChannel2, application);
        this.logger = HMSLogger.getInstance(application);
    }

    private int getActivityHashCode() {
        Activity activity;
        PluginRegistry.Registrar registrar2 = this.registrar;
        if (registrar2 == null || (activity = registrar2.activity()) == null) {
            return this.activityHashCode;
        }
        return activity.hashCode();
    }

    private Application getApplication() {
        Activity activity;
        PluginRegistry.Registrar registrar2 = this.registrar;
        if (registrar2 == null || (activity = registrar2.activity()) == null) {
            return this.mApplication;
        }
        return activity.getApplication();
    }

    private Location getLocation(LatLng latLng) {
        Location location = new Location("Provider");
        location.setLatitude(latLng.latitude);
        location.setLongitude(latLng.longitude);
        location.setAccuracy(200.0f);
        return location;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onMethodCall$0(MethodChannel.Result result, Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 85, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        bitmap.recycle();
        result.success(byteArray);
    }

    @SuppressLint({"MissingPermission"})
    private void updateMyLocationSettings() {
        if (MapLocation.hasLocationPermission(this.context)) {
            this.logger.startMethodExecutionTimer("MapController-setMyLocationEnabled");
            this.huaweiMap.setMyLocationEnabled(this.myLocationEnabled);
            this.logger.sendSingleEvent("MapController-setMyLocationEnabled");
            this.logger.startMethodExecutionTimer("MapController-setMyLocationButtonEnabled");
            this.huaweiMap.getUiSettings().setMyLocationButtonEnabled(this.myLocationButtonEnabled);
            this.logger.sendSingleEvent("MapController-setMyLocationButtonEnabled");
        }
    }

    public void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        this.locationChangedListener = onLocationChangedListener;
        Log.i("locationSource", "Activate");
    }

    public void deactivate() {
        Log.i("locationSource", "Deactivate");
        this.locationChangedListener = null;
    }

    public void dispose() {
        if (!this.disposed) {
            this.disposed = true;
            this.methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
            this.mapListenerHandler.setMapListener((MapListener) null);
            getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    public View getView() {
        return this.mapView;
    }

    public void init() {
        switch (this.activityState.get()) {
            case 1:
                Log.i("MapController init", "HmsMap.Created");
                this.mapView.onCreate((Bundle) null);
                break;
            case 2:
                Log.i("MapController init", "HmsMap.Started");
                this.mapView.onCreate((Bundle) null);
                this.mapView.onStart();
                break;
            case 3:
                Log.i("MapController init", "HmsMap.Resumed");
                this.mapView.onCreate((Bundle) null);
                this.mapView.onStart();
                this.mapView.onResume();
                break;
            case 4:
                Log.i("MapController init", "HmsMap.Paused");
                this.mapView.onCreate((Bundle) null);
                this.mapView.onStart();
                this.mapView.onResume();
                this.mapView.onPause();
                break;
            case 5:
                Log.i("MapController init", "HmsMap.Stopped");
                this.mapView.onCreate((Bundle) null);
                this.mapView.onStart();
                this.mapView.onResume();
                this.mapView.onPause();
                this.mapView.onStop();
                break;
            case 6:
                Log.i("MapController init", "HmsMap.Destroyed");
                break;
            default:
                throw new IllegalArgumentException("Cannot interpret " + this.activityState.get() + " as an activity state");
        }
        Lifecycle lifecycle2 = this.lifecycle;
        if (lifecycle2 != null) {
            lifecycle2.addObserver(this);
        } else {
            getApplication().registerActivityLifecycleCallbacks(this);
        }
        this.mapView.getMapAsync(this);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!this.disposed && activity.hashCode() == getActivityHashCode()) {
            this.mapView.onCreate(bundle);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (!this.disposed && activity.hashCode() == getActivityHashCode()) {
            this.mapView.onDestroy();
        }
    }

    public void onActivityPaused(Activity activity) {
        if (!this.disposed && activity.hashCode() == getActivityHashCode()) {
            this.mapView.onPause();
        }
    }

    public void onActivityResumed(Activity activity) {
        if (!this.disposed && activity.hashCode() == getActivityHashCode()) {
            this.mapView.onResume();
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (!this.disposed && activity.hashCode() == getActivityHashCode()) {
            this.mapView.onSaveInstanceState(bundle);
        }
    }

    public void onActivityStarted(Activity activity) {
        if (!this.disposed && activity.hashCode() == getActivityHashCode()) {
            this.mapView.onStart();
        }
    }

    public void onActivityStopped(Activity activity) {
        if (!this.disposed && activity.hashCode() == getActivityHashCode()) {
            this.mapView.onStop();
        }
    }

    public void onCreate(@NonNull LifecycleOwner lifecycleOwner) {
        if (!this.disposed) {
            this.mapView.onCreate((Bundle) null);
        }
    }

    public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
        if (!this.disposed) {
            this.mapView.onDestroy();
        }
    }

    public /* synthetic */ void onFlutterViewAttached(View view) {
        b.a(this, view);
    }

    public /* synthetic */ void onFlutterViewDetached() {
        b.b(this);
    }

    public void onInputConnectionLocked() {
    }

    public void onInputConnectionUnlocked() {
    }

    public void onMapReady(HuaweiMap huaweiMap2) {
        this.huaweiMap = huaweiMap2;
        if (this.allGesturesEnabled != null) {
            this.logger.startMethodExecutionTimer("MapController-setAllGesturesEnabled");
            this.huaweiMap.getUiSettings().setAllGesturesEnabled(this.allGesturesEnabled.booleanValue());
            this.logger.sendSingleEvent("MapController-setAllGesturesEnabled");
        }
        this.logger.startMethodExecutionTimer("MapController-setTrafficEnabled");
        this.huaweiMap.setTrafficEnabled(this.trafficEnabled);
        this.logger.sendSingleEvent("MapController-setTrafficEnabled");
        this.logger.startMethodExecutionTimer("MapController-setBuildingsEnabled");
        this.huaweiMap.setBuildingsEnabled(this.buildingsEnabled);
        this.logger.sendSingleEvent("MapController-setBuildingsEnabled");
        this.logger.startMethodExecutionTimer("MapController-setMarkersClustering");
        this.huaweiMap.setMarkersClustering(this.markersClustering);
        this.logger.sendSingleEvent("MapController-setMarkersClustering");
        this.logger.startMethodExecutionTimer("MapController-setPadding");
        HuaweiMap huaweiMap3 = this.huaweiMap;
        Rect rect = this.padding;
        float f11 = this.compactness;
        huaweiMap3.setPadding((int) (((float) rect.left) * f11), (int) (((float) rect.top) * f11), (int) (((float) rect.right) * f11), (int) (((float) rect.bottom) * f11));
        this.logger.sendSingleEvent("MapController-setPadding");
        this.logger.startMethodExecutionTimer("MapController-setScrollGesturesEnabledDuringRotateOrZoom");
        this.huaweiMap.getUiSettings().setScrollGesturesEnabledDuringRotateOrZoom(this.isScrollGesturesEnabledDuringRotateOrZoom);
        this.logger.sendSingleEvent("MapController-setScrollGesturesEnabledDuringRotateOrZoom");
        this.logger.startMethodExecutionTimer("MapController-setGestureScaleByMapCenter");
        this.huaweiMap.getUiSettings().setGestureScaleByMapCenter(this.gestureScaleByMapCenter);
        this.logger.sendSingleEvent("MapController-setGestureScaleByMapCenter");
        this.logger.startMethodExecutionTimer("MapController-setMarkerClusterIcon");
        this.huaweiMap.getUiSettings().setMarkerClusterIcon(this.iconDescriptor);
        this.logger.sendSingleEvent("MapController-setMarkerClusterIcon");
        if (this.clusterMarkerTextColor != null) {
            this.logger.startMethodExecutionTimer("MapController-setMarkerClusterTextColor");
            this.huaweiMap.getUiSettings().setMarkerClusterTextColor(this.clusterMarkerTextColor.intValue());
            this.logger.sendSingleEvent("MapController-setMarkerClusterTextColor");
        }
        if (this.clusterMarkerColor != null) {
            this.logger.startMethodExecutionTimer("MapController-setMarkerClusterColor");
            this.huaweiMap.getUiSettings().setMarkerClusterColor(this.clusterMarkerColor.intValue());
            this.logger.sendSingleEvent("MapController-setMarkerClusterColor");
        }
        if (this.pointToCenter != null) {
            this.logger.startMethodExecutionTimer("MapController-setPointToCenter");
            HuaweiMap huaweiMap4 = this.huaweiMap;
            Point point = this.pointToCenter;
            huaweiMap4.setPointToCenter(point.x, point.y);
            this.logger.sendSingleEvent("MapController-setPointToCenter");
        }
        Log.e("TAG", "setMyLocationStyle dis", (Throwable) null);
        if (this.myLocationStyle != null) {
            this.logger.startMethodExecutionTimer("MapController-setMyLocationStyle");
            this.huaweiMap.setMyLocationStyle(this.myLocationStyle);
            Log.e("TAG", "setMyLocationStyle ic", (Throwable) null);
            this.logger.sendSingleEvent("MapController-setMyLocationStyle");
        }
        this.logger.startMethodExecutionTimer("MapController-setLogoPosition");
        huaweiMap2.getUiSettings().setLogoPosition(this.logoPosition);
        this.logger.sendSingleEvent("MapController-setLogoPosition");
        this.logger.startMethodExecutionTimer("MapController-setLogoPadding");
        UiSettings uiSettings = huaweiMap2.getUiSettings();
        Rect rect2 = this.logoPadding;
        float f12 = this.compactness;
        uiSettings.setLogoPadding((int) (((float) rect2.left) * f12), (int) (((float) rect2.top) * f12), (int) (((float) rect2.right) * f12), (int) (((float) rect2.bottom) * f12));
        this.logger.sendSingleEvent("MapController-setLogoPadding");
        MethodChannel.Result result = this.mapReadyResult;
        if (result != null) {
            result.success((Object) null);
            this.mapReadyResult = null;
        }
        this.mapListenerHandler.init(huaweiMap2);
        this.mapUtils.init(huaweiMap2, this.initMarkers, this.initPolylines, this.initPolygons, this.initCircles, this.initGroundOverlays, this.initTileOverlays, this.initHeatMaps, this.markersClustering, this.messenger);
        updateMyLocationSettings();
    }

    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2102690780:
                if (str.equals(Method.MAP_WAIT_FOR_MAP)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1708350898:
                if (str.equals(Method.CAMERA_MOVE)) {
                    c11 = 1;
                    break;
                }
                break;
            case -1649118489:
                if (str.equals(Method.MAP_TAKE_SNAPSHOT)) {
                    c11 = 2;
                    break;
                }
                break;
            case -1014232666:
                if (str.equals(Method.STOP_ANIMATION)) {
                    c11 = 3;
                    break;
                }
                break;
            case -677354693:
                if (str.equals(Method.SET_LOCATION)) {
                    c11 = 4;
                    break;
                }
                break;
            case -147133952:
                if (str.equals(Method.MAP_GET_LAT_LNG)) {
                    c11 = 5;
                    break;
                }
                break;
            case 225968453:
                if (str.equals(Method.MAP_UPDATE)) {
                    c11 = 6;
                    break;
                }
                break;
            case 368671552:
                if (str.equals(Method.DEACTIVATE_LOC_SOURCE)) {
                    c11 = 7;
                    break;
                }
                break;
            case 1364557772:
                if (str.equals(Method.MAP_GET_VISIBLE_REGION)) {
                    c11 = 8;
                    break;
                }
                break;
            case 1376450713:
                if (str.equals(Method.MAP_GET_SCALEPERPIXEL)) {
                    c11 = 9;
                    break;
                }
                break;
            case 1838096182:
                if (str.equals(Method.SET_LOCATION_SOURCE)) {
                    c11 = 10;
                    break;
                }
                break;
            case 2006041470:
                if (str.equals(Method.MAP_GET_SCREEN_COORDINATE)) {
                    c11 = 11;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                if (this.huaweiMap != null) {
                    result.success((Object) null);
                    return;
                } else {
                    this.mapReadyResult = result;
                    return;
                }
            case 1:
                this.mapUtils.moveCamera(Convert.toCameraUpdate(methodCall.argument(Param.CAMERA_UPDATE), this.compactness));
                result.success((Object) null);
                return;
            case 2:
                this.logger.startMethodExecutionTimer(Method.MAP_TAKE_SNAPSHOT);
                HuaweiMap huaweiMap2 = this.huaweiMap;
                if (huaweiMap2 != null) {
                    huaweiMap2.snapshot(new a(result));
                    this.logger.sendSingleEvent(Method.MAP_TAKE_SNAPSHOT);
                    return;
                }
                result.error(Param.ERROR, Method.MAP_TAKE_SNAPSHOT, (Object) null);
                this.logger.sendSingleEvent(Method.MAP_TAKE_SNAPSHOT, "snapshotError");
                return;
            case 3:
                this.logger.startMethodExecutionTimer(Method.STOP_ANIMATION);
                this.huaweiMap.stopAnimation();
                this.logger.sendSingleEvent(Method.STOP_ANIMATION);
                return;
            case 4:
                this.logger.startMethodExecutionTimer(Method.SET_LOCATION);
                if (this.locationChangedListener != null) {
                    this.locationChangedListener.onLocationChanged(getLocation(Convert.toLatLng(methodCall.arguments)));
                    this.logger.sendSingleEvent(Method.SET_LOCATION);
                    return;
                }
                result.error(Param.ERROR, "Please set location source first.", (Object) null);
                this.logger.sendSingleEvent(Method.SET_LOCATION, "locationSourceError");
                return;
            case 5:
                this.logger.startMethodExecutionTimer(Method.MAP_GET_LAT_LNG);
                if (this.huaweiMap != null) {
                    result.success(ToJson.latLng(this.huaweiMap.getProjection().fromScreenLocation(Convert.toPoint(methodCall.arguments))));
                    this.logger.sendSingleEvent(Method.MAP_GET_LAT_LNG);
                    return;
                }
                result.error(Param.ERROR, Method.MAP_GET_LAT_LNG, (Object) null);
                this.logger.sendSingleEvent(Method.MAP_GET_LAT_LNG, "getProjection.fromScreenLocation error");
                return;
            case 6:
                Convert.processHuaweiMapOptions(methodCall.argument("options"), this);
                this.logger.startMethodExecutionTimer("getCameraPosition");
                result.success(ToJson.cameraPosition(this.mapUtils.getCameraPosition(this.trackCameraPosition)));
                this.logger.sendSingleEvent("getCameraPosition");
                return;
            case 7:
                this.logger.startMethodExecutionTimer(Method.DEACTIVATE_LOC_SOURCE);
                deactivate();
                this.logger.sendSingleEvent(Method.DEACTIVATE_LOC_SOURCE);
                return;
            case 8:
                this.logger.startMethodExecutionTimer(Method.MAP_GET_VISIBLE_REGION);
                HuaweiMap huaweiMap3 = this.huaweiMap;
                if (huaweiMap3 != null) {
                    result.success(ToJson.latlngBounds(huaweiMap3.getProjection().getVisibleRegion().latLngBounds));
                    this.logger.sendSingleEvent(Method.MAP_GET_VISIBLE_REGION);
                    return;
                }
                result.error(Param.ERROR, Method.MAP_GET_VISIBLE_REGION, (Object) null);
                this.logger.sendSingleEvent(Method.MAP_GET_VISIBLE_REGION, "getProjection.getVisibleRegion error");
                return;
            case 9:
                this.logger.startMethodExecutionTimer(Method.MAP_GET_SCALEPERPIXEL);
                HuaweiMap huaweiMap4 = this.huaweiMap;
                if (huaweiMap4 != null) {
                    result.success(Float.valueOf(huaweiMap4.getScalePerPixel()));
                    this.logger.sendSingleEvent(Method.MAP_GET_SCALEPERPIXEL);
                    return;
                }
                result.error(Param.ERROR, Method.MAP_GET_SCALEPERPIXEL, (Object) null);
                this.logger.sendSingleEvent(Method.MAP_GET_SCALEPERPIXEL, "Couldn't get scale per pixel.");
                return;
            case 10:
                this.logger.startMethodExecutionTimer(Method.SET_LOCATION_SOURCE);
                this.huaweiMap.setLocationSource(this);
                this.logger.sendSingleEvent(Method.SET_LOCATION_SOURCE);
                return;
            case 11:
                this.logger.startMethodExecutionTimer(Method.MAP_GET_SCREEN_COORDINATE);
                if (this.huaweiMap != null) {
                    result.success(ToJson.point(this.huaweiMap.getProjection().toScreenLocation(Convert.toLatLng(methodCall.arguments))));
                    this.logger.sendSingleEvent(Method.MAP_GET_SCREEN_COORDINATE);
                    return;
                }
                result.error(Param.ERROR, Method.MAP_GET_SCREEN_COORDINATE, (Object) null);
                this.logger.sendSingleEvent(Method.MAP_GET_SCREEN_COORDINATE, "getProjection.toScreenLocation error");
                return;
            default:
                this.mapUtils.onMethodCallCamera(methodCall, result);
                return;
        }
    }

    public void onPause(@NonNull LifecycleOwner lifecycleOwner) {
        if (!this.disposed) {
            this.mapView.onResume();
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        if (!this.disposed) {
            this.mapView.onCreate(bundle);
        }
    }

    public void onResume(@NonNull LifecycleOwner lifecycleOwner) {
        if (!this.disposed) {
            this.mapView.onResume();
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        if (!this.disposed) {
            this.mapView.onSaveInstanceState(bundle);
        }
    }

    public void onStart(@NonNull LifecycleOwner lifecycleOwner) {
        if (!this.disposed) {
            this.mapView.onStart();
        }
    }

    public void onStop(@NonNull LifecycleOwner lifecycleOwner) {
        if (!this.disposed) {
            this.mapView.onStop();
        }
    }

    public void setAllGesturesEnabled(@Nullable Boolean bool) {
        this.allGesturesEnabled = bool;
        if (this.huaweiMap != null && bool != null) {
            this.logger.startMethodExecutionTimer("MapController-setAllGesturesEnabled");
            this.huaweiMap.getUiSettings().setAllGesturesEnabled(bool.booleanValue());
            this.logger.sendSingleEvent("MapController-setAllGesturesEnabled");
        }
    }

    public void setBuildingsEnabled(boolean z11) {
        this.buildingsEnabled = z11;
    }

    public void setCameraTargetBounds(LatLngBounds latLngBounds) {
        this.logger.startMethodExecutionTimer("MapController-setLatLngBoundsForCameraTarget");
        this.huaweiMap.setLatLngBoundsForCameraTarget(latLngBounds);
        this.logger.sendSingleEvent("MapController-setLatLngBoundsForCameraTarget");
    }

    public void setCircles(List<HashMap<String, Object>> list) {
        this.initCircles = list;
        if (this.huaweiMap != null) {
            this.mapUtils.initCircles(list);
        }
    }

    public void setClusterMarkerColor(Integer num) {
        if (num != null) {
            this.clusterMarkerColor = num;
            if (this.huaweiMap != null) {
                this.logger.startMethodExecutionTimer("MapController-setMarkerClusterColor");
                this.huaweiMap.getUiSettings().setMarkerClusterColor(num.intValue());
                this.logger.sendSingleEvent("MapController-setMarkerClusterColor");
            }
        }
    }

    public void setClusterMarkerIcon(BitmapDescriptor bitmapDescriptor) {
        this.iconDescriptor = bitmapDescriptor;
        if (this.huaweiMap != null) {
            this.logger.startMethodExecutionTimer("MapController-setMarkerClusterIcon");
            this.huaweiMap.getUiSettings().setMarkerClusterIcon(bitmapDescriptor);
            this.logger.sendSingleEvent("MapController-setMarkerClusterIcon");
        }
    }

    public void setClusterMarkerTextColor(Integer num) {
        if (num != null) {
            this.clusterMarkerTextColor = num;
            if (this.huaweiMap != null) {
                this.logger.startMethodExecutionTimer("MapController-setMarkerClusterTextColor");
                this.huaweiMap.getUiSettings().setMarkerClusterTextColor(num.intValue());
                this.logger.sendSingleEvent("MapController-setMarkerClusterTextColor");
            }
        }
    }

    public void setCompassEnabled(boolean z11) {
        this.logger.startMethodExecutionTimer("MapController-setCompassEnabled");
        this.huaweiMap.getUiSettings().setCompassEnabled(z11);
        this.logger.sendSingleEvent("MapController-setCompassEnabled");
    }

    public void setDark(boolean z11) {
        this.logger.startMethodExecutionTimer("MapController-setDark");
        this.huaweiMap.setDark(z11);
        this.logger.sendSingleEvent("MapController-setDark");
    }

    public void setGestureScaleByMapCenter(boolean z11) {
        this.gestureScaleByMapCenter = z11;
        if (this.huaweiMap != null) {
            this.logger.startMethodExecutionTimer("MapController-setGestureScaleByMapCenter");
            this.huaweiMap.getUiSettings().setGestureScaleByMapCenter(z11);
            this.logger.sendSingleEvent("MapController-setGestureScaleByMapCenter");
        }
    }

    public void setGroundOverlays(List<HashMap<String, Object>> list) {
        this.initGroundOverlays = list;
        if (this.huaweiMap != null) {
            this.mapUtils.initGroundOverlays(list);
        }
    }

    public void setHeatMaps(List<HashMap<String, Object>> list) {
        this.initHeatMaps = list;
        if (this.huaweiMap != null) {
            this.mapUtils.initHeatMaps(list);
        }
    }

    public void setLiteMode(Boolean bool) {
    }

    public void setLogoPadding(int i11, int i12, int i13, int i14) {
        this.logoPadding = new Rect(i11, i12, i13, i14);
        if (this.huaweiMap != null) {
            this.logger.startMethodExecutionTimer("MapController-setLogoPadding");
            UiSettings uiSettings = this.huaweiMap.getUiSettings();
            float f11 = this.compactness;
            uiSettings.setLogoPadding((int) (((float) i11) * f11), (int) (((float) i12) * f11), (int) (((float) i13) * f11), (int) (((float) i14) * f11));
            this.logger.sendSingleEvent("MapController-setLogoPadding");
        }
    }

    public void setLogoPosition(int i11) {
        this.logoPosition = i11;
        if (this.huaweiMap != null) {
            this.logger.startMethodExecutionTimer("MapController-setLogoPosition");
            this.huaweiMap.getUiSettings().setLogoPosition(i11);
            this.logger.sendSingleEvent("MapController-setLogoPosition");
        }
    }

    public void setMapToolbarEnabled(boolean z11) {
        this.logger.startMethodExecutionTimer("MapController-setMapToolbarEnabled");
        this.huaweiMap.getUiSettings().setMapToolbarEnabled(z11);
        this.logger.sendSingleEvent("MapController-setMapToolbarEnabled");
    }

    public void setMapType(int i11) {
        this.logger.startMethodExecutionTimer("MapController-setMapType");
        this.huaweiMap.setMapType(i11);
        this.logger.sendSingleEvent("MapController-setMapType");
    }

    public void setMarkers(List<HashMap<String, Object>> list) {
        this.initMarkers = list;
        if (this.huaweiMap != null) {
            this.mapUtils.initMarkers(list);
        }
    }

    public void setMarkersClustering(boolean z11) {
        this.markersClustering = z11;
        if (this.huaweiMap != null) {
            this.logger.startMethodExecutionTimer("MapController-setMarkersClustering");
            this.huaweiMap.setMarkersClustering(z11);
            this.logger.sendSingleEvent("MapController-setMarkersClustering");
        }
    }

    public void setMinMaxZoomPreference(Float f11, Float f12) {
        this.logger.startMethodExecutionTimer("resetMinMaxZoomPreference");
        this.huaweiMap.resetMinMaxZoomPreference();
        this.logger.sendSingleEvent("resetMinMaxZoomPreference");
        if (f11 != null) {
            this.logger.startMethodExecutionTimer("MapController-setMinZoomPreference");
            this.huaweiMap.setMinZoomPreference(f11.floatValue());
            this.logger.sendSingleEvent("MapController-setMinZoomPreference");
        }
        if (f12 != null) {
            this.logger.startMethodExecutionTimer("MapController-setMaxZoomPreference");
            this.huaweiMap.setMaxZoomPreference(f12.floatValue());
            this.logger.sendSingleEvent("MapController-setMaxZoomPreference");
        }
    }

    public void setMyLocationButtonEnabled(boolean z11) {
        if (this.myLocationButtonEnabled != z11) {
            this.myLocationButtonEnabled = z11;
            if (this.huaweiMap != null) {
                updateMyLocationSettings();
            }
        }
    }

    public void setMyLocationEnabled(boolean z11) {
        if (this.myLocationEnabled != z11) {
            this.myLocationEnabled = z11;
            if (this.huaweiMap != null) {
                updateMyLocationSettings();
            }
        }
    }

    public void setMyLocationStyle(MyLocationStyle myLocationStyle2) {
        if (myLocationStyle2 != null) {
            this.myLocationStyle = myLocationStyle2;
            if (this.huaweiMap != null) {
                this.logger.startMethodExecutionTimer("MapController-setMyLocationStyle");
                this.huaweiMap.setMyLocationStyle(myLocationStyle2);
                this.logger.sendSingleEvent("MapController-setMyLocationStyle");
            }
        }
    }

    public void setPadding(float f11, float f12, float f13, float f14) {
        this.padding = new Rect((int) f12, (int) f11, (int) f14, (int) f13);
        if (this.huaweiMap != null) {
            this.logger.startMethodExecutionTimer("MapController-setPadding");
            HuaweiMap huaweiMap2 = this.huaweiMap;
            float f15 = this.compactness;
            huaweiMap2.setPadding((int) (f12 * f15), (int) (f11 * f15), (int) (f14 * f15), (int) (f13 * f15));
            this.logger.sendSingleEvent("MapController-setPadding");
        }
    }

    public void setPointToCenter(Point point) {
        if (point != null) {
            this.pointToCenter = point;
            if (this.huaweiMap != null) {
                this.logger.startMethodExecutionTimer("MapController-setPointToCenter");
                this.huaweiMap.setPointToCenter(point.x, point.y);
                this.logger.sendSingleEvent("MapController-setPointToCenter");
            }
        }
    }

    public void setPolygons(List<HashMap<String, Object>> list) {
        this.initPolygons = list;
        if (this.huaweiMap != null) {
            this.mapUtils.initPolygons(list);
        }
    }

    public void setPolylines(List<HashMap<String, Object>> list) {
        this.initPolylines = list;
        if (this.huaweiMap != null) {
            this.mapUtils.initPolylines(list);
        }
    }

    public void setPreviewId(String str) {
        if (str != null && this.huaweiMap != null) {
            this.logger.startMethodExecutionTimer("MapController-setPreviewId");
            this.huaweiMap.previewId(str);
            this.logger.sendSingleEvent("MapController-setPreviewId");
        }
    }

    public void setRotateGesturesEnabled(boolean z11) {
        this.logger.startMethodExecutionTimer("MapController-setRotateGesturesEnabled");
        this.huaweiMap.getUiSettings().setRotateGesturesEnabled(z11);
        this.logger.sendSingleEvent("MapController-setRotateGesturesEnabled");
    }

    public void setScrollGesturesEnabled(boolean z11) {
        this.logger.startMethodExecutionTimer("MapController-setScrollGesturesEnabled");
        this.huaweiMap.getUiSettings().setScrollGesturesEnabled(z11);
        this.logger.sendSingleEvent("MapController-setScrollGesturesEnabled");
    }

    public void setScrollGesturesEnabledDuringRotateOrZoom(boolean z11) {
        this.isScrollGesturesEnabledDuringRotateOrZoom = z11;
        if (this.huaweiMap != null) {
            this.logger.startMethodExecutionTimer("MapController-setScrollGesturesEnabledDuringRotateOrZoom");
            this.huaweiMap.getUiSettings().setScrollGesturesEnabledDuringRotateOrZoom(z11);
            this.logger.sendSingleEvent("MapController-setScrollGesturesEnabledDuringRotateOrZoom");
        }
    }

    public void setStyleId(String str) {
        if (str != null && this.huaweiMap != null) {
            this.logger.startMethodExecutionTimer("MapController-setStyleId");
            this.huaweiMap.setStyleId(str);
            this.logger.sendSingleEvent("MapController-setStyleId");
        }
    }

    public void setTileOverlays(List<HashMap<String, Object>> list) {
        this.initTileOverlays = list;
        if (this.huaweiMap != null) {
            this.mapUtils.initTileOverlays(list);
        }
    }

    public void setTiltGesturesEnabled(boolean z11) {
        this.logger.startMethodExecutionTimer("MapController-setTiltGesturesEnabled");
        this.huaweiMap.getUiSettings().setTiltGesturesEnabled(z11);
        this.logger.sendSingleEvent("MapController-setTiltGesturesEnabled");
    }

    public void setTrackCameraPosition(boolean z11) {
        this.trackCameraPosition = z11;
        this.mapListenerHandler.setTrackCameraPosition(z11);
    }

    public void setTrafficEnabled(boolean z11) {
        this.trafficEnabled = z11;
        if (this.huaweiMap != null) {
            this.logger.startMethodExecutionTimer("MapController-setTrafficEnabled");
            this.huaweiMap.setTrafficEnabled(z11);
            this.logger.sendSingleEvent("MapController-setTrafficEnabled");
        }
    }

    public void setZoomControlsEnabled(boolean z11) {
        if (this.zoomControlsEnabled != z11) {
            this.zoomControlsEnabled = z11;
            if (this.huaweiMap != null) {
                this.logger.startMethodExecutionTimer("MapController-setZoomControlsEnabled");
                this.huaweiMap.getUiSettings().setZoomControlsEnabled(z11);
                this.logger.sendSingleEvent("MapController-setZoomControlsEnabled");
            }
        }
    }

    public void setZoomGesturesEnabled(boolean z11) {
        this.logger.startMethodExecutionTimer("MapController-setZoomGesturesEnabled");
        this.huaweiMap.getUiSettings().setZoomGesturesEnabled(z11);
        this.logger.sendSingleEvent("MapController-setZoomGesturesEnabled");
    }
}
