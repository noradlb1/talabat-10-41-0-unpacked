package io.flutter.plugins.googlemaps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.huawei.hms.flutter.map.constants.Param;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.CharUtils;
import xz.b;

final class GoogleMapController implements DefaultLifecycleObserver, ActivityPluginBinding.OnSaveInstanceStateListener, GoogleMapOptionsSink, MethodChannel.MethodCallHandler, OnMapReadyCallback, GoogleMapListener, PlatformView {
    private static final String TAG = "GoogleMapController";
    private boolean buildingsEnabled = true;
    private final CirclesController circlesController;
    private final Context context;
    private final float density;
    private boolean disposed = false;
    @Nullable
    private GoogleMap googleMap;

    /* renamed from: id  reason: collision with root package name */
    private final int f14329id;
    private boolean indoorEnabled = true;
    private List<Object> initialCircles;
    private List<Object> initialMarkers;
    private List<Object> initialPolygons;
    private List<Object> initialPolylines;
    private List<Map<String, ?>> initialTileOverlays;
    private final LifecycleProvider lifecycleProvider;
    private MethodChannel.Result mapReadyResult;
    @Nullable
    private MapView mapView;
    private final MarkersController markersController;
    private final MethodChannel methodChannel;
    private boolean myLocationButtonEnabled = false;
    private boolean myLocationEnabled = false;
    private final GoogleMapOptions options;
    private final PolygonsController polygonsController;
    private final PolylinesController polylinesController;
    private final TileOverlaysController tileOverlaysController;
    private boolean trackCameraPosition = false;
    private boolean trafficEnabled = false;
    private boolean zoomControlsEnabled = true;

    public GoogleMapController(int i11, Context context2, BinaryMessenger binaryMessenger, LifecycleProvider lifecycleProvider2, GoogleMapOptions googleMapOptions) {
        this.f14329id = i11;
        this.context = context2;
        this.options = googleMapOptions;
        this.mapView = new MapView(context2, googleMapOptions);
        float f11 = context2.getResources().getDisplayMetrics().density;
        this.density = f11;
        MethodChannel methodChannel2 = new MethodChannel(binaryMessenger, "plugins.flutter.io/google_maps_" + i11);
        this.methodChannel = methodChannel2;
        methodChannel2.setMethodCallHandler(this);
        this.lifecycleProvider = lifecycleProvider2;
        this.markersController = new MarkersController(methodChannel2);
        this.polygonsController = new PolygonsController(methodChannel2, f11);
        this.polylinesController = new PolylinesController(methodChannel2, f11);
        this.circlesController = new CirclesController(methodChannel2, f11);
        this.tileOverlaysController = new TileOverlaysController(methodChannel2);
    }

    private void animateCamera(CameraUpdate cameraUpdate) {
        this.googleMap.animateCamera(cameraUpdate);
    }

    private int checkSelfPermission(String str) {
        if (str != null) {
            return this.context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    private void destroyMapViewIfNecessary() {
        MapView mapView2 = this.mapView;
        if (mapView2 != null) {
            mapView2.onDestroy();
            this.mapView = null;
        }
    }

    private CameraPosition getCameraPosition() {
        if (this.trackCameraPosition) {
            return this.googleMap.getCameraPosition();
        }
        return null;
    }

    private boolean hasLocationPermission() {
        if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    private void moveCamera(CameraUpdate cameraUpdate) {
        this.googleMap.moveCamera(cameraUpdate);
    }

    private void setGoogleMapListener(@Nullable GoogleMapListener googleMapListener) {
        GoogleMap googleMap2 = this.googleMap;
        if (googleMap2 != null) {
            googleMap2.setOnCameraMoveStartedListener(googleMapListener);
            this.googleMap.setOnCameraMoveListener(googleMapListener);
            this.googleMap.setOnCameraIdleListener(googleMapListener);
            this.googleMap.setOnMarkerClickListener(googleMapListener);
            this.googleMap.setOnMarkerDragListener(googleMapListener);
            this.googleMap.setOnPolygonClickListener(googleMapListener);
            this.googleMap.setOnPolylineClickListener(googleMapListener);
            this.googleMap.setOnCircleClickListener(googleMapListener);
            this.googleMap.setOnMapClickListener(googleMapListener);
            this.googleMap.setOnMapLongClickListener(googleMapListener);
        }
    }

    private void updateInitialCircles() {
        this.circlesController.a(this.initialCircles);
    }

    private void updateInitialMarkers() {
        this.markersController.a(this.initialMarkers);
    }

    private void updateInitialPolygons() {
        this.polygonsController.a(this.initialPolygons);
    }

    private void updateInitialPolylines() {
        this.polylinesController.a(this.initialPolylines);
    }

    private void updateInitialTileOverlays() {
        this.tileOverlaysController.a(this.initialTileOverlays);
    }

    @SuppressLint({"MissingPermission"})
    private void updateMyLocationSettings() {
        if (hasLocationPermission()) {
            this.googleMap.setMyLocationEnabled(this.myLocationEnabled);
            this.googleMap.getUiSettings().setMyLocationButtonEnabled(this.myLocationButtonEnabled);
            return;
        }
        Log.e(TAG, "Cannot enable MyLocation layer as location permissions are not granted");
    }

    public void a() {
        this.lifecycleProvider.getLifecycle().addObserver(this);
        this.mapView.getMapAsync(this);
    }

    public void dispose() {
        if (!this.disposed) {
            this.disposed = true;
            this.methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
            setGoogleMapListener((GoogleMapListener) null);
            destroyMapViewIfNecessary();
            Lifecycle lifecycle = this.lifecycleProvider.getLifecycle();
            if (lifecycle != null) {
                lifecycle.removeObserver(this);
            }
        }
    }

    public View getView() {
        return this.mapView;
    }

    public void onCameraIdle() {
        this.methodChannel.invokeMethod("camera#onIdle", Collections.singletonMap(Param.MAP, Integer.valueOf(this.f14329id)));
    }

    public void onCameraMove() {
        if (this.trackCameraPosition) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("position", Convert.a(this.googleMap.getCameraPosition()));
            this.methodChannel.invokeMethod("camera#onMove", hashMap);
        }
    }

    public void onCameraMoveStarted(int i11) {
        HashMap hashMap = new HashMap(2);
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        hashMap.put("isGesture", Boolean.valueOf(z11));
        this.methodChannel.invokeMethod("camera#onMoveStarted", hashMap);
    }

    public void onCircleClick(Circle circle) {
        this.circlesController.c(circle.getId());
    }

    public void onCreate(@NonNull LifecycleOwner lifecycleOwner) {
        if (!this.disposed) {
            this.mapView.onCreate((Bundle) null);
        }
    }

    public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
        lifecycleOwner.getLifecycle().removeObserver(this);
        if (!this.disposed) {
            destroyMapViewIfNecessary();
        }
    }

    public /* synthetic */ void onFlutterViewAttached(View view) {
        b.a(this, view);
    }

    public /* synthetic */ void onFlutterViewDetached() {
        b.b(this);
    }

    public void onInfoWindowClick(Marker marker) {
        this.markersController.e(marker.getId());
    }

    public void onInputConnectionLocked() {
    }

    public void onInputConnectionUnlocked() {
    }

    public void onMapClick(LatLng latLng) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("position", Convert.j(latLng));
        this.methodChannel.invokeMethod("map#onTap", hashMap);
    }

    public void onMapLongClick(LatLng latLng) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("position", Convert.j(latLng));
        this.methodChannel.invokeMethod("map#onLongPress", hashMap);
    }

    public void onMapReady(GoogleMap googleMap2) {
        this.googleMap = googleMap2;
        googleMap2.setIndoorEnabled(this.indoorEnabled);
        this.googleMap.setTrafficEnabled(this.trafficEnabled);
        this.googleMap.setBuildingsEnabled(this.buildingsEnabled);
        googleMap2.setOnInfoWindowClickListener(this);
        MethodChannel.Result result = this.mapReadyResult;
        if (result != null) {
            result.success((Object) null);
            this.mapReadyResult = null;
        }
        setGoogleMapListener(this);
        updateMyLocationSettings();
        this.markersController.i(googleMap2);
        this.polygonsController.e(googleMap2);
        this.polylinesController.e(googleMap2);
        this.circlesController.e(googleMap2);
        this.tileOverlaysController.f(googleMap2);
        updateInitialMarkers();
        updateInitialPolygons();
        updateInitialPolylines();
        updateInitialCircles();
        updateInitialTileOverlays();
    }

    public boolean onMarkerClick(Marker marker) {
        return this.markersController.g(marker.getId());
    }

    public void onMarkerDrag(Marker marker) {
    }

    public void onMarkerDragEnd(Marker marker) {
        this.markersController.f(marker.getId(), marker.getPosition());
    }

    public void onMarkerDragStart(Marker marker) {
    }

    public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
        boolean z11;
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2068530537:
                if (str.equals("map#getVisibleRegion")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1753225255:
                if (str.equals("map#isScrollGesturesEnabled")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1675017333:
                if (str.equals("map#isRotateGesturesEnabled")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1389285936:
                if (str.equals("map#update")) {
                    c11 = 3;
                    break;
                }
                break;
            case -1366519597:
                if (str.equals("map#getScreenCoordinate")) {
                    c11 = 4;
                    break;
                }
                break;
            case -1264573565:
                if (str.equals("camera#animate")) {
                    c11 = 5;
                    break;
                }
                break;
            case -1255039905:
                if (str.equals("markers#isInfoWindowShown")) {
                    c11 = 6;
                    break;
                }
                break;
            case -1253612063:
                if (str.equals("map#getTileOverlayInfo")) {
                    c11 = 7;
                    break;
                }
                break;
            case -1102318061:
                if (str.equals("polygons#update")) {
                    c11 = 8;
                    break;
                }
                break;
            case -596474455:
                if (str.equals("map#isTiltGesturesEnabled")) {
                    c11 = 9;
                    break;
                }
                break;
            case -577075523:
                if (str.equals("map#isMyLocationButtonEnabled")) {
                    c11 = 10;
                    break;
                }
                break;
            case -508357782:
                if (str.equals("markers#hideInfoWindow")) {
                    c11 = 11;
                    break;
                }
                break;
            case -451921790:
                if (str.equals("map#getZoomLevel")) {
                    c11 = 12;
                    break;
                }
                break;
            case 262112323:
                if (str.equals("map#getMinMaxZoomLevels")) {
                    c11 = CharUtils.CR;
                    break;
                }
                break;
            case 282895827:
                if (str.equals("map#isZoomGesturesEnabled")) {
                    c11 = 14;
                    break;
                }
                break;
            case 295004975:
                if (str.equals("map#waitForMap")) {
                    c11 = 15;
                    break;
                }
                break;
            case 390939153:
                if (str.equals("map#isMapToolbarEnabled")) {
                    c11 = 16;
                    break;
                }
                break;
            case 434031410:
                if (str.equals("map#takeSnapshot")) {
                    c11 = 17;
                    break;
                }
                break;
            case 622947733:
                if (str.equals("map#getLatLng")) {
                    c11 = 18;
                    break;
                }
                break;
            case 643972249:
                if (str.equals("polylines#update")) {
                    c11 = 19;
                    break;
                }
                break;
            case 712945078:
                if (str.equals("map#setStyle")) {
                    c11 = 20;
                    break;
                }
                break;
            case 972868051:
                if (str.equals("map#isBuildingsEnabled")) {
                    c11 = 21;
                    break;
                }
                break;
            case 1098288608:
                if (str.equals("map#isCompassEnabled")) {
                    c11 = 22;
                    break;
                }
                break;
            case 1172199911:
                if (str.equals("map#isZoomControlsEnabled")) {
                    c11 = 23;
                    break;
                }
                break;
            case 1322988819:
                if (str.equals("markers#update")) {
                    c11 = 24;
                    break;
                }
                break;
            case 1546082965:
                if (str.equals("map#isTrafficEnabled")) {
                    c11 = 25;
                    break;
                }
                break;
            case 1564959387:
                if (str.equals("tileOverlays#update")) {
                    c11 = 26;
                    break;
                }
                break;
            case 1708609913:
                if (str.equals("tileOverlays#clearTileCache")) {
                    c11 = 27;
                    break;
                }
                break;
            case 1873569705:
                if (str.equals("circles#update")) {
                    c11 = 28;
                    break;
                }
                break;
            case 1915657375:
                if (str.equals("map#isLiteModeEnabled")) {
                    c11 = 29;
                    break;
                }
                break;
            case 1953391461:
                if (str.equals("markers#showInfoWindow")) {
                    c11 = 30;
                    break;
                }
                break;
            case 2003557999:
                if (str.equals("camera#move")) {
                    c11 = 31;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                GoogleMap googleMap2 = this.googleMap;
                if (googleMap2 != null) {
                    result.success(Convert.k(googleMap2.getProjection().getVisibleRegion().latLngBounds));
                    return;
                } else {
                    result.error("GoogleMap uninitialized", "getVisibleRegion called prior to map initialization", (Object) null);
                    return;
                }
            case 1:
                result.success(Boolean.valueOf(this.googleMap.getUiSettings().isScrollGesturesEnabled()));
                return;
            case 2:
                result.success(Boolean.valueOf(this.googleMap.getUiSettings().isRotateGesturesEnabled()));
                return;
            case 3:
                Convert.d(methodCall.argument("options"), this);
                result.success(Convert.a(getCameraPosition()));
                return;
            case 4:
                if (this.googleMap != null) {
                    result.success(Convert.m(this.googleMap.getProjection().toScreenLocation(Convert.s(methodCall.arguments))));
                    return;
                }
                result.error("GoogleMap uninitialized", "getScreenCoordinate called prior to map initialization", (Object) null);
                return;
            case 5:
                animateCamera(Convert.r(methodCall.argument(Param.CAMERA_UPDATE), this.density));
                result.success((Object) null);
                return;
            case 6:
                this.markersController.d((String) methodCall.argument(Param.MARKER_ID), result);
                return;
            case 7:
                result.success(this.tileOverlaysController.d((String) methodCall.argument(Param.TILE_OVERLAY_ID)));
                return;
            case 8:
                this.polygonsController.a((List) methodCall.argument(Param.POLYGONS_TO_INSERT));
                this.polygonsController.b((List) methodCall.argument(Param.POLYGONS_TO_UPDATE));
                this.polygonsController.d((List) methodCall.argument(Param.POLYGONS_TO_DELETE));
                result.success((Object) null);
                return;
            case 9:
                result.success(Boolean.valueOf(this.googleMap.getUiSettings().isTiltGesturesEnabled()));
                return;
            case 10:
                result.success(Boolean.valueOf(this.googleMap.getUiSettings().isMyLocationButtonEnabled()));
                return;
            case 11:
                this.markersController.c((String) methodCall.argument(Param.MARKER_ID), result);
                return;
            case 12:
                result.success(Float.valueOf(this.googleMap.getCameraPosition().zoom));
                return;
            case 13:
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(Float.valueOf(this.googleMap.getMinZoomLevel()));
                arrayList.add(Float.valueOf(this.googleMap.getMaxZoomLevel()));
                result.success(arrayList);
                return;
            case 14:
                result.success(Boolean.valueOf(this.googleMap.getUiSettings().isZoomGesturesEnabled()));
                return;
            case 15:
                if (this.googleMap != null) {
                    result.success((Object) null);
                    return;
                } else {
                    this.mapReadyResult = result;
                    return;
                }
            case 16:
                result.success(Boolean.valueOf(this.googleMap.getUiSettings().isMapToolbarEnabled()));
                return;
            case 17:
                GoogleMap googleMap3 = this.googleMap;
                if (googleMap3 != null) {
                    googleMap3.snapshot(new GoogleMap.SnapshotReadyCallback() {
                        public void onSnapshotReady(Bitmap bitmap) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            bitmap.recycle();
                            result.success(byteArray);
                        }
                    });
                    return;
                } else {
                    result.error("GoogleMap uninitialized", "takeSnapshot", (Object) null);
                    return;
                }
            case 18:
                if (this.googleMap != null) {
                    result.success(Convert.j(this.googleMap.getProjection().fromScreenLocation(Convert.t(methodCall.arguments))));
                    return;
                }
                result.error("GoogleMap uninitialized", "getLatLng called prior to map initialization", (Object) null);
                return;
            case 19:
                this.polylinesController.a((List) methodCall.argument(Param.POLYLINES_TO_INSERT));
                this.polylinesController.b((List) methodCall.argument(Param.POLYLINES_TO_UPDATE));
                this.polylinesController.d((List) methodCall.argument(Param.POLYLINES_TO_DELETE));
                result.success((Object) null);
                return;
            case 20:
                String str2 = (String) methodCall.arguments;
                if (str2 == null) {
                    z11 = this.googleMap.setMapStyle((MapStyleOptions) null);
                } else {
                    z11 = this.googleMap.setMapStyle(new MapStyleOptions(str2));
                }
                ArrayList arrayList2 = new ArrayList(2);
                arrayList2.add(Boolean.valueOf(z11));
                if (!z11) {
                    arrayList2.add("Unable to set the map style. Please check console logs for errors.");
                }
                result.success(arrayList2);
                return;
            case 21:
                result.success(Boolean.valueOf(this.googleMap.isBuildingsEnabled()));
                return;
            case 22:
                result.success(Boolean.valueOf(this.googleMap.getUiSettings().isCompassEnabled()));
                return;
            case 23:
                result.success(Boolean.valueOf(this.googleMap.getUiSettings().isZoomControlsEnabled()));
                return;
            case 24:
                this.markersController.a((List) methodCall.argument(Param.MARKERS_TO_INSERT));
                this.markersController.b((List) methodCall.argument(Param.MARKERS_TO_UPDATE));
                this.markersController.h((List) methodCall.argument(Param.MARKERS_TO_DELETE));
                result.success((Object) null);
                return;
            case 25:
                result.success(Boolean.valueOf(this.googleMap.isTrafficEnabled()));
                return;
            case 26:
                this.tileOverlaysController.a((List) methodCall.argument(Param.TILE_OVERLAYS_TO_INSERT));
                this.tileOverlaysController.b((List) methodCall.argument(Param.TILE_OVERLAYS_TO_UPDATE));
                this.tileOverlaysController.e((List) methodCall.argument(Param.TILE_OVERLAYS_TO_DELETE));
                result.success((Object) null);
                return;
            case 27:
                this.tileOverlaysController.c((String) methodCall.argument(Param.TILE_OVERLAY_ID));
                result.success((Object) null);
                return;
            case 28:
                this.circlesController.a((List) methodCall.argument(Param.CIRCLES_TO_INSERT));
                this.circlesController.b((List) methodCall.argument(Param.CIRCLES_TO_UPDATE));
                this.circlesController.d((List) methodCall.argument(Param.CIRCLES_TO_DELETE));
                result.success((Object) null);
                return;
            case 29:
                result.success(this.options.getLiteMode());
                return;
            case 30:
                this.markersController.j((String) methodCall.argument(Param.MARKER_ID), result);
                return;
            case 31:
                moveCamera(Convert.r(methodCall.argument(Param.CAMERA_UPDATE), this.density));
                result.success((Object) null);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    public void onPause(@NonNull LifecycleOwner lifecycleOwner) {
        if (!this.disposed) {
            this.mapView.onResume();
        }
    }

    public void onPolygonClick(Polygon polygon) {
        this.polygonsController.c(polygon.getId());
    }

    public void onPolylineClick(Polyline polyline) {
        this.polylinesController.c(polyline.getId());
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

    public void onSaveInstanceState(Bundle bundle) {
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

    public void setBuildingsEnabled(boolean z11) {
        this.buildingsEnabled = z11;
    }

    public void setCameraTargetBounds(LatLngBounds latLngBounds) {
        this.googleMap.setLatLngBoundsForCameraTarget(latLngBounds);
    }

    public void setCompassEnabled(boolean z11) {
        this.googleMap.getUiSettings().setCompassEnabled(z11);
    }

    public void setIndoorEnabled(boolean z11) {
        this.indoorEnabled = z11;
    }

    public void setInitialCircles(Object obj) {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) obj;
        if (arrayList2 != null) {
            arrayList = new ArrayList(arrayList2);
        } else {
            arrayList = null;
        }
        this.initialCircles = arrayList;
        if (this.googleMap != null) {
            updateInitialCircles();
        }
    }

    public void setInitialMarkers(Object obj) {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) obj;
        if (arrayList2 != null) {
            arrayList = new ArrayList(arrayList2);
        } else {
            arrayList = null;
        }
        this.initialMarkers = arrayList;
        if (this.googleMap != null) {
            updateInitialMarkers();
        }
    }

    public void setInitialPolygons(Object obj) {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) obj;
        if (arrayList2 != null) {
            arrayList = new ArrayList(arrayList2);
        } else {
            arrayList = null;
        }
        this.initialPolygons = arrayList;
        if (this.googleMap != null) {
            updateInitialPolygons();
        }
    }

    public void setInitialPolylines(Object obj) {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) obj;
        if (arrayList2 != null) {
            arrayList = new ArrayList(arrayList2);
        } else {
            arrayList = null;
        }
        this.initialPolylines = arrayList;
        if (this.googleMap != null) {
            updateInitialPolylines();
        }
    }

    public void setInitialTileOverlays(List<Map<String, ?>> list) {
        this.initialTileOverlays = list;
        if (this.googleMap != null) {
            updateInitialTileOverlays();
        }
    }

    public void setLiteModeEnabled(boolean z11) {
        this.options.liteMode(z11);
    }

    public void setMapToolbarEnabled(boolean z11) {
        this.googleMap.getUiSettings().setMapToolbarEnabled(z11);
    }

    public void setMapType(int i11) {
        this.googleMap.setMapType(i11);
    }

    public void setMinMaxZoomPreference(Float f11, Float f12) {
        this.googleMap.resetMinMaxZoomPreference();
        if (f11 != null) {
            this.googleMap.setMinZoomPreference(f11.floatValue());
        }
        if (f12 != null) {
            this.googleMap.setMaxZoomPreference(f12.floatValue());
        }
    }

    public void setMyLocationButtonEnabled(boolean z11) {
        if (this.myLocationButtonEnabled != z11) {
            this.myLocationButtonEnabled = z11;
            if (this.googleMap != null) {
                updateMyLocationSettings();
            }
        }
    }

    public void setMyLocationEnabled(boolean z11) {
        if (this.myLocationEnabled != z11) {
            this.myLocationEnabled = z11;
            if (this.googleMap != null) {
                updateMyLocationSettings();
            }
        }
    }

    public void setPadding(float f11, float f12, float f13, float f14) {
        GoogleMap googleMap2 = this.googleMap;
        if (googleMap2 != null) {
            float f15 = this.density;
            googleMap2.setPadding((int) (f12 * f15), (int) (f11 * f15), (int) (f14 * f15), (int) (f13 * f15));
        }
    }

    public void setRotateGesturesEnabled(boolean z11) {
        this.googleMap.getUiSettings().setRotateGesturesEnabled(z11);
    }

    public void setScrollGesturesEnabled(boolean z11) {
        this.googleMap.getUiSettings().setScrollGesturesEnabled(z11);
    }

    public void setTiltGesturesEnabled(boolean z11) {
        this.googleMap.getUiSettings().setTiltGesturesEnabled(z11);
    }

    public void setTrackCameraPosition(boolean z11) {
        this.trackCameraPosition = z11;
    }

    public void setTrafficEnabled(boolean z11) {
        this.trafficEnabled = z11;
        GoogleMap googleMap2 = this.googleMap;
        if (googleMap2 != null) {
            googleMap2.setTrafficEnabled(z11);
        }
    }

    public void setZoomControlsEnabled(boolean z11) {
        if (this.zoomControlsEnabled != z11) {
            this.zoomControlsEnabled = z11;
            GoogleMap googleMap2 = this.googleMap;
            if (googleMap2 != null) {
                googleMap2.getUiSettings().setZoomControlsEnabled(z11);
            }
        }
    }

    public void setZoomGesturesEnabled(boolean z11) {
        this.googleMap.getUiSettings().setZoomGesturesEnabled(z11);
    }
}
