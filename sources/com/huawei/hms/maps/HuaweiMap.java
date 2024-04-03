package com.huawei.hms.maps;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import androidx.core.content.PermissionChecker;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.maps.internal.ICancelableCallback;
import com.huawei.hms.maps.internal.IHuaweiMapDelegate;
import com.huawei.hms.maps.internal.IInfoWindowAdapter;
import com.huawei.hms.maps.internal.ILocationSourceDelegate;
import com.huawei.hms.maps.internal.IOnCameraChangeListener;
import com.huawei.hms.maps.internal.IOnCameraIdleListener;
import com.huawei.hms.maps.internal.IOnCameraMoveCanceledListener;
import com.huawei.hms.maps.internal.IOnCameraMoveListener;
import com.huawei.hms.maps.internal.IOnCameraMoveStartedListener;
import com.huawei.hms.maps.internal.IOnCircleClickListener;
import com.huawei.hms.maps.internal.IOnGroundOverlayClickListener;
import com.huawei.hms.maps.internal.IOnIndoorViewListener;
import com.huawei.hms.maps.internal.IOnInfoWindowClickListener;
import com.huawei.hms.maps.internal.IOnInfoWindowCloseListener;
import com.huawei.hms.maps.internal.IOnInfoWindowLongClickListener;
import com.huawei.hms.maps.internal.IOnMapClickListener;
import com.huawei.hms.maps.internal.IOnMapLoadedCallback;
import com.huawei.hms.maps.internal.IOnMapLongClickListener;
import com.huawei.hms.maps.internal.IOnMarkerClickListener;
import com.huawei.hms.maps.internal.IOnMarkerDragListener;
import com.huawei.hms.maps.internal.IOnMyLocationButtonClickListener;
import com.huawei.hms.maps.internal.IOnMyLocationClickListener;
import com.huawei.hms.maps.internal.IOnPoiClickListener;
import com.huawei.hms.maps.internal.IOnPolygonClickListener;
import com.huawei.hms.maps.internal.IOnPolylineClickListener;
import com.huawei.hms.maps.internal.ISnapshotReadyCallback;
import com.huawei.hms.maps.internal.maa;
import com.huawei.hms.maps.model.BitmapDescriptorFactory;
import com.huawei.hms.maps.model.CameraPosition;
import com.huawei.hms.maps.model.Circle;
import com.huawei.hms.maps.model.CircleOptions;
import com.huawei.hms.maps.model.GroundOverlay;
import com.huawei.hms.maps.model.GroundOverlayOptions;
import com.huawei.hms.maps.model.HeatMap;
import com.huawei.hms.maps.model.HeatMapOptions;
import com.huawei.hms.maps.model.IndoorBuilding;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.LatLngBounds;
import com.huawei.hms.maps.model.MapStyleOptions;
import com.huawei.hms.maps.model.Marker;
import com.huawei.hms.maps.model.MarkerOptions;
import com.huawei.hms.maps.model.MyLocationStyle;
import com.huawei.hms.maps.model.PointOfInterest;
import com.huawei.hms.maps.model.Polygon;
import com.huawei.hms.maps.model.PolygonOptions;
import com.huawei.hms.maps.model.Polyline;
import com.huawei.hms.maps.model.PolylineOptions;
import com.huawei.hms.maps.model.TileOverlay;
import com.huawei.hms.maps.model.TileOverlayOptions;
import com.huawei.hms.maps.model.internal.ICircleDelegate;
import com.huawei.hms.maps.model.internal.IGroundOverlayDelegate;
import com.huawei.hms.maps.model.internal.IMarkerDelegate;
import com.huawei.hms.maps.model.internal.IPolygonDelegate;
import com.huawei.hms.maps.model.internal.IPolylineDelegate;
import com.huawei.hms.maps.utils.LogM;
import com.instabug.commons.snapshot.StateSnapshotCaptor;

public class HuaweiMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;

    /* renamed from: a  reason: collision with root package name */
    private boolean f49228a = false;

    /* renamed from: b  reason: collision with root package name */
    private MyLocationStyle f49229b = null;

    /* renamed from: c  reason: collision with root package name */
    private IHuaweiMapDelegate f49230c;

    /* renamed from: d  reason: collision with root package name */
    private UiSettings f49231d;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface IndoorViewListener {
        void onIndoorFocus(IndoorBuilding indoorBuilding);

        void onIndoorLeave();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnCameraIdleListener {
        void onCameraIdle();
    }

    public interface OnCameraMoveCanceledListener {
        void onCameraMoveCanceled();
    }

    public interface OnCameraMoveListener {
        void onCameraMove();
    }

    public interface OnCameraMoveStartedListener {
        public static final int REASON_API_ANIMATION = 2;
        public static final int REASON_DEVELOPER_ANIMATION = 3;
        public static final int REASON_GESTURE = 1;

        void onCameraMoveStarted(int i11);
    }

    public interface OnCircleClickListener {
        void onCircleClick(Circle circle);
    }

    public interface OnGroundOverlayClickListener {
        void onGroundOverlayClick(GroundOverlay groundOverlay);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnInfoWindowCloseListener {
        void onInfoWindowClose(Marker marker);
    }

    public interface OnInfoWindowLongClickListener {
        void onInfoWindowLongClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    public interface OnMyLocationClickListener {
        void onMyLocationClick(Location location);
    }

    public interface OnPoiClickListener {
        void onPoiClick(PointOfInterest pointOfInterest);
    }

    public interface OnPolygonClickListener {
        void onPolygonClick(Polygon polygon);
    }

    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline polyline);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    public HuaweiMap(IHuaweiMapDelegate iHuaweiMapDelegate) {
        this.f49230c = iHuaweiMapDelegate;
        try {
            BitmapDescriptorFactory.setIBitmapDescriptorDelegate(iHuaweiMapDelegate.getBitmapDescriptor());
        } catch (RemoteException unused) {
            LogM.e("HuaweiMap", "getBitmapDescriptor RemoteException: ");
        }
    }

    public Circle addCircle(CircleOptions circleOptions) {
        try {
            return new Circle(this.f49230c.addCircle(circleOptions));
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "addCircle RemoteException: " + e11.toString());
            return null;
        }
    }

    public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        if (groundOverlayOptions.getImage() != null) {
            try {
                IGroundOverlayDelegate addGroundOverlay = this.f49230c.addGroundOverlay(groundOverlayOptions);
                if (addGroundOverlay != null) {
                    return new GroundOverlay(addGroundOverlay);
                }
                return null;
            } catch (RemoteException e11) {
                LogM.d("HuaweiMap", "addGroundOverlay RemoteException: " + e11.toString());
                return null;
            }
        } else {
            throw new IllegalArgumentException("GroundOverlayOptions image must not be null");
        }
    }

    public HeatMap addHeatMap(String str, HeatMapOptions heatMapOptions) {
        try {
            return new HeatMap(this.f49230c.addHeatMap(str, heatMapOptions));
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "RemoteException: " + e11.toString());
            return null;
        }
    }

    public Marker addMarker(MarkerOptions markerOptions) {
        try {
            return new Marker(this.f49230c.addMarker(markerOptions));
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "RemoteException: " + e11.toString());
            return null;
        }
    }

    public Polygon addPolygon(PolygonOptions polygonOptions) {
        try {
            return new Polygon(this.f49230c.addPolygon(polygonOptions));
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "addPolygon RemoteException: " + e11.toString());
            return null;
        }
    }

    public Polyline addPolyline(PolylineOptions polylineOptions) {
        try {
            return new Polyline(this.f49230c.addPolyline(polylineOptions));
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "addPolyline RemoteException: " + e11.toString());
            return null;
        }
    }

    public TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        if (tileOverlayOptions.getTileProvider() != null) {
            try {
                return new TileOverlay(this.f49230c.addTileOverlay(tileOverlayOptions));
            } catch (RemoteException e11) {
                LogM.e("HuaweiMap", "addTileOverlay RemoteException: " + e11.toString());
                return null;
            }
        } else {
            throw new IllegalArgumentException("TileProvider must not be null");
        }
    }

    public void animateCamera(CameraUpdate cameraUpdate) {
        try {
            LogM.d("HuaweiMap", "animateCamera begin");
            this.f49230c.animateCamera(cameraUpdate.getCameraUpdate());
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "RemoteException: " + e11.toString());
        }
    }

    public void animateCamera(CameraUpdate cameraUpdate, int i11, final CancelableCallback cancelableCallback) {
        try {
            this.f49230c.animateCameraWithDurationAndCallback(cameraUpdate.getCameraUpdate(), i11, cancelableCallback == null ? null : new ICancelableCallback.Stub() {
                public void onCancel() {
                    cancelableCallback.onCancel();
                }

                public void onFinish() {
                    cancelableCallback.onFinish();
                }
            });
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "RemoteException" + e11.toString());
        }
    }

    public void animateCamera(CameraUpdate cameraUpdate, final CancelableCallback cancelableCallback) {
        LogM.d("HuaweiMap", "animateCamera(update,callback)");
        try {
            this.f49230c.animateCameraWithCallback(cameraUpdate.getCameraUpdate(), cancelableCallback == null ? null : new ICancelableCallback.Stub() {
                public void onCancel() {
                    cancelableCallback.onCancel();
                }

                public void onFinish() {
                    cancelableCallback.onFinish();
                }
            });
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "RemoteException" + e11.toString());
        }
    }

    public void clear() {
        try {
            this.f49230c.clear();
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "clear RemoteException: " + e11.toString());
        }
    }

    public CameraPosition getCameraPosition() {
        try {
            LogM.v("HuaweiMap", "getCameraPosition begin");
            return this.f49230c.getCameraPosition();
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "RemoteException: " + e11.toString());
            return null;
        }
    }

    public String getCurrentFloor() {
        try {
            return this.f49230c.getCurrentFloor();
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "getCurrentFloor RemoteException: " + e11.toString());
            return "CLOSE";
        }
    }

    public int getMapType() {
        try {
            return this.f49230c.getMapType();
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "getMapType RemoteException: " + e11.toString());
            return 0;
        }
    }

    public float getMaxZoomLevel() {
        try {
            return this.f49230c.getMaxZoomLevel();
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "getMaxZoomLevel RemoteException: " + e11.toString());
            return 0.0f;
        }
    }

    public float getMinZoomLevel() {
        try {
            return this.f49230c.getMinZoomLevel();
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "getMinZoomLevel RemoteException: " + e11.toString());
            return 0.0f;
        }
    }

    public MyLocationStyle getMyLocationStyle() {
        return this.f49229b;
    }

    public Projection getProjection() {
        try {
            return new Projection(this.f49230c.getProjection());
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "getProjection: " + e11.getMessage());
            return null;
        }
    }

    public float getScalePerPixel() {
        try {
            return this.f49230c.getScalePerPixel();
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "getScalePerPixel RemoteException: " + e11.toString());
            return 0.0f;
        }
    }

    public UiSettings getUiSettings() {
        try {
            UiSettings uiSettings = new UiSettings(this.f49230c.getUiSettings());
            this.f49231d = uiSettings;
            return uiSettings;
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "getUiSettings RemoteException: " + e11.toString());
            return null;
        }
    }

    public boolean isBuildingsEnabled() {
        try {
            return this.f49230c.isBuildingsEnabled();
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "isBuildingsEnabled RemoteException: " + e11.toString());
            return false;
        }
    }

    public boolean isDark() {
        try {
            return this.f49230c.isDark();
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "isDark RemoteException: " + e11.toString());
            return false;
        }
    }

    public boolean isIndoorEnabled() {
        try {
            return this.f49230c.isIndoorEnabled();
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "isIndoorEnabled RemoteException: " + e11.toString());
            return false;
        }
    }

    public boolean isMyLocationEnabled() {
        try {
            return this.f49230c.isMyLocationEnabled();
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "isMyLocationEnabled RemoteException: " + e11.toString());
            return false;
        }
    }

    public boolean isTrafficEnabled() {
        try {
            return this.f49230c.isTrafficEnabled();
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "isTrafficEnabled RemoteException: " + e11.toString());
            return false;
        }
    }

    public void moveCamera(CameraUpdate cameraUpdate) {
        try {
            LogM.d("HuaweiMap", "moveCamera begin");
            this.f49230c.moveCamera(cameraUpdate.getCameraUpdate());
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "RemoteException: " + e11.toString());
        }
    }

    public void previewId(String str) {
        try {
            this.f49230c.previewId(str);
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "previewId RemoteException = " + e11.getMessage());
        }
    }

    public void resetMinMaxZoomPreference() {
        try {
            this.f49230c.resetMinMaxZoomPreference();
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "resetMinMaxZoomPreference RemoteException: " + e11.toString());
        }
    }

    public void setBuildingsEnabled(boolean z11) {
        try {
            this.f49230c.setBuildingsEnabled(z11);
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "setBuildingsEnabled RemoteException: " + e11.toString());
        }
    }

    public void setCommonDir(int i11, String str) {
        try {
            this.f49230c.setCommonDir(i11, str);
        } catch (Exception e11) {
            LogM.d("HuaweiMap", "setCommonDir RemoteException: " + e11.toString());
        }
    }

    public void setContentDescription(String str) {
        try {
            this.f49230c.setContentDescription(str);
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "setContentDescription RemoteException: " + e11.toString());
        }
    }

    public void setDark(boolean z11) {
        try {
            this.f49230c.setDark(z11);
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "setDark RemoteException = " + e11.getMessage());
        }
    }

    public void setFrameTime(int i11) {
        if (i11 <= 0) {
            try {
                LogM.i("HuaweiMap", "frameTime cannot be less than 0");
            } catch (Exception e11) {
                LogM.d("HuaweiMap", "setFrameTime RemoteException: " + e11.toString());
            }
        } else {
            this.f49230c.setFrameTime(i11);
        }
    }

    public void setGcj02CoordinateEnabled(boolean z11) {
        try {
            this.f49230c.setGcj02CoordinateEnabled(z11);
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "setGcj02CoordinateEnabled RemoteException: " + e11.toString());
        }
    }

    @Deprecated
    public void setGeoPoliticalView(String str) {
        try {
            LogM.i("HuaweiMap", "setGeoPoliticalView : " + str);
            this.f49230c.setGeoPoliticalView(str);
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "setGeoPoliticalView RemoteException: " + e11.toString());
        }
    }

    public boolean setIndoorEnabled(boolean z11) {
        try {
            return this.f49230c.setIndoorEnabled(z11);
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "setIndoorEnabled RemoteException: " + e11.toString());
            return false;
        }
    }

    public void setIndoorViewListener(final IndoorViewListener indoorViewListener) {
        try {
            this.f49230c.setIndoorViewListener(indoorViewListener == null ? null : new IOnIndoorViewListener.Stub() {
                public void onIndoorFocus(IndoorBuilding indoorBuilding) {
                    LogM.d("HuaweiMap", "onIndoorFocus callback start: ");
                    indoorViewListener.onIndoorFocus(indoorBuilding);
                }

                public void onIndoorLeave() {
                    LogM.d("HuaweiMap", "onIndoorLeave callback start: ");
                    indoorViewListener.onIndoorLeave();
                }
            });
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "setIndoorViewListener RemoteException: " + e11.toString());
        }
    }

    public void setInfoWindowAdapter(final InfoWindowAdapter infoWindowAdapter) {
        if (infoWindowAdapter == null) {
            try {
                this.f49230c.setInfoWindowAdapter((IInfoWindowAdapter) null);
            } catch (RemoteException e11) {
                LogM.e("HuaweiMap", "RemoteException: " + e11.toString());
            }
        } else {
            this.f49230c.setInfoWindowAdapter(new IInfoWindowAdapter.Stub() {
                public IObjectWrapper getInfoContents(IMarkerDelegate iMarkerDelegate) {
                    InfoWindowAdapter infoWindowAdapter = infoWindowAdapter;
                    if (infoWindowAdapter == null) {
                        return null;
                    }
                    return ObjectWrapper.wrap(infoWindowAdapter.getInfoContents(new Marker(iMarkerDelegate)));
                }

                public IObjectWrapper getInfoWindow(IMarkerDelegate iMarkerDelegate) {
                    InfoWindowAdapter infoWindowAdapter = infoWindowAdapter;
                    if (infoWindowAdapter == null) {
                        return null;
                    }
                    return ObjectWrapper.wrap(infoWindowAdapter.getInfoWindow(new Marker(iMarkerDelegate)));
                }
            });
        }
    }

    public void setLanguage(String str) {
        try {
            LogM.i("HuaweiMap", "setLanguage : " + str);
            this.f49230c.setLanguage(str);
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "setLanguage RemoteException: " + e11.toString());
        }
    }

    public void setLatLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        try {
            this.f49230c.setLatLngBoundsForCameraTarget(latLngBounds);
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "RemoteException: " + e11.toString());
        }
    }

    public void setLocationSource(LocationSource locationSource) {
        if (locationSource == null) {
            try {
                this.f49228a = false;
                this.f49230c.setLocationSource((ILocationSourceDelegate) null);
            } catch (RemoteException e11) {
                LogM.e("HuaweiMap", "RemoteException: " + e11.toString());
            }
        } else {
            this.f49228a = true;
            this.f49230c.setLocationSource(new maa(locationSource));
        }
    }

    public final boolean setMapStyle(MapStyleOptions mapStyleOptions) {
        try {
            return this.f49230c.setMapStyle(mapStyleOptions);
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "RemoteException: " + e11.toString());
            return false;
        }
    }

    public void setMapType(int i11) {
        try {
            this.f49230c.setMapType(i11);
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "setMapType RemoteException: " + e11.toString());
        }
    }

    public void setMarkersClustering(boolean z11) {
        try {
            this.f49230c.setMarkersClustering(z11);
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "RemoteException: " + e11.toString());
        }
    }

    public void setMaxZoomPreference(float f11) {
        try {
            this.f49230c.setMaxZoomPreference(f11);
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "setMaxZoomPreference RemoteException: " + e11.toString());
        }
    }

    public void setMinZoomPreference(float f11) {
        try {
            this.f49230c.setMinZoomPreference(f11);
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "setMinZoomPreference RemoteException: " + e11.toString());
        }
    }

    public void setMyLocationEnabled(boolean z11) {
        Context appContext;
        if (!z11 || this.f49228a || (appContext = MapClientIdentify.getAppContext()) == null || PermissionChecker.checkSelfPermission(appContext, "android.permission.ACCESS_FINE_LOCATION") == 0 || PermissionChecker.checkSelfPermission(appContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            try {
                this.f49230c.setMyLocationEnabled(z11);
            } catch (RemoteException e11) {
                LogM.d("HuaweiMap", "setMyLocationEnabled RemoteException: " + e11.toString());
            }
        } else {
            throw new SecurityException("the permission is not granted, my location requires permission ACCESS_FINE_LOCATION or ACCESS_COARSE_LOCATION.");
        }
    }

    public void setMyLocationStyle(MyLocationStyle myLocationStyle) {
        try {
            LogM.d("HuaweiMap", "set my location style");
            this.f49230c.setMyLocationStyle(myLocationStyle);
            this.f49229b = myLocationStyle;
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "setMyLocationStyle RemoteException: " + e11.toString());
        }
    }

    public void setOnCameraChangeListener(final OnCameraChangeListener onCameraChangeListener) {
        try {
            this.f49230c.setOnCameraChangeListener(onCameraChangeListener == null ? null : new IOnCameraChangeListener.Stub() {
                public void onCameraChange(CameraPosition cameraPosition) {
                    LogM.d("HuaweiMap", "onCameraChange");
                    onCameraChangeListener.onCameraChange(cameraPosition);
                }
            });
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "RemoteException: " + e11.toString());
        }
    }

    public void setOnCameraIdleListener(final OnCameraIdleListener onCameraIdleListener) {
        LogM.d("HuaweiMap", "setOnCameraIdleListener: ");
        try {
            this.f49230c.setCameraIdleListener(onCameraIdleListener == null ? null : new IOnCameraIdleListener.Stub() {
                public void onCameraIdle() {
                    LogM.d("HuaweiMap", "onCameraIdle: ");
                    onCameraIdleListener.onCameraIdle();
                }
            });
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "RemoteException: " + e11.toString());
        }
    }

    public void setOnCameraMoveCanceledListener(final OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        LogM.d("HuaweiMap", "HuaweiMap does not support ");
        try {
            this.f49230c.setCameraMoveCanceledListener(onCameraMoveCanceledListener == null ? null : new IOnCameraMoveCanceledListener.Stub() {
                public void onCameraMoveCanceled() {
                    LogM.d("HuaweiMap", "onCameraMoveCanceled");
                    onCameraMoveCanceledListener.onCameraMoveCanceled();
                }
            });
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "RemoteException: " + e11.toString());
        }
    }

    public void setOnCameraMoveListener(final OnCameraMoveListener onCameraMoveListener) {
        LogM.d("HuaweiMap", "setCameraMoveListener: ");
        try {
            this.f49230c.setCameraMoveListener(onCameraMoveListener == null ? null : new IOnCameraMoveListener.Stub() {
                public void onCameraMove() {
                    LogM.v("HuaweiMap", "onCameraMove: ");
                    onCameraMoveListener.onCameraMove();
                }
            });
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "RemoteException: " + e11.toString());
        }
    }

    public void setOnCameraMoveStartedListener(final OnCameraMoveStartedListener onCameraMoveStartedListener) {
        LogM.d("HuaweiMap", "setOnCameraMoveStartedListener: ");
        try {
            this.f49230c.setCameraMoveStartedListener(onCameraMoveStartedListener == null ? null : new IOnCameraMoveStartedListener.Stub() {
                public void onCameraMoveStarted(int i11) {
                    LogM.d("HuaweiMap", "onCameraMoveStarted: " + i11);
                    onCameraMoveStartedListener.onCameraMoveStarted(i11);
                }
            });
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "RemoteException: " + e11.toString());
        }
    }

    public void setOnCircleClickListener(final OnCircleClickListener onCircleClickListener) {
        LogM.d("HuaweiMap", "onCircleClick setListener start: ");
        try {
            this.f49230c.setCircleClickListener(onCircleClickListener == null ? null : new IOnCircleClickListener.Stub() {
                public void onCircleClick(ICircleDelegate iCircleDelegate) {
                    LogM.i("HuaweiMap", "onCircleClick callback start: ");
                    Circle circle = new Circle(iCircleDelegate);
                    OnCircleClickListener onCircleClickListener = onCircleClickListener;
                    if (onCircleClickListener != null) {
                        onCircleClickListener.onCircleClick(circle);
                    }
                }
            });
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "RemoteException: " + e11.toString());
        }
    }

    public void setOnGroundOverlayClickListener(final OnGroundOverlayClickListener onGroundOverlayClickListener) {
        try {
            this.f49230c.setOnGroundOverlayClickListener(onGroundOverlayClickListener == null ? null : new IOnGroundOverlayClickListener.Stub() {
                public void onGroundOverlayClick(IGroundOverlayDelegate iGroundOverlayDelegate) {
                    onGroundOverlayClickListener.onGroundOverlayClick(new GroundOverlay(iGroundOverlayDelegate));
                }
            });
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "setOnGroundOverlayClickListener RemoteException: " + e11.toString());
        }
    }

    public void setOnInfoWindowClickListener(final OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            this.f49230c.setOnInfoWindowClickListener(onInfoWindowClickListener == null ? null : new IOnInfoWindowClickListener.Stub() {
                public void onInfoWindowClick(IMarkerDelegate iMarkerDelegate) {
                    LogM.i("HuaweiMap", "onInfoWindowClick callback start: ");
                    onInfoWindowClickListener.onInfoWindowClick(new Marker(iMarkerDelegate));
                }
            });
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "RemoteException: " + e11.toString());
        }
    }

    public void setOnInfoWindowCloseListener(final OnInfoWindowCloseListener onInfoWindowCloseListener) {
        try {
            this.f49230c.setOnInfoWindowCloseListener(onInfoWindowCloseListener == null ? null : new IOnInfoWindowCloseListener.Stub() {
                public void onInfoWindowClose(IMarkerDelegate iMarkerDelegate) {
                    onInfoWindowCloseListener.onInfoWindowClose(new Marker(iMarkerDelegate));
                }
            });
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "setOnInfoWindowCloseListener RemoteException: " + e11.toString());
        }
    }

    public void setOnInfoWindowLongClickListener(final OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
        try {
            this.f49230c.setOnInfoWindowLongClickListener(onInfoWindowLongClickListener == null ? null : new IOnInfoWindowLongClickListener.Stub() {
                public void onInfoWindowLongClick(IMarkerDelegate iMarkerDelegate) {
                    onInfoWindowLongClickListener.onInfoWindowLongClick(new Marker(iMarkerDelegate));
                }
            });
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "setOnInfoWindowLongClickListener RemoteException: " + e11.toString());
        }
    }

    public void setOnMapClickListener(final OnMapClickListener onMapClickListener) {
        LogM.d("HuaweiMap", "setOnMapClickListener: ");
        try {
            this.f49230c.setOnMapClickListener(onMapClickListener == null ? null : new IOnMapClickListener.Stub() {
                public void onMapClick(LatLng latLng) {
                    onMapClickListener.onMapClick(latLng);
                }
            });
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "RemoteException: " + e11.toString());
        }
    }

    public void setOnMapLoadedCallback(final OnMapLoadedCallback onMapLoadedCallback) {
        try {
            this.f49230c.setOnMapLoadedCallback(new IOnMapLoadedCallback.Stub() {
                public void onMapLoaded() {
                    OnMapLoadedCallback onMapLoadedCallback = onMapLoadedCallback;
                    if (onMapLoadedCallback != null) {
                        onMapLoadedCallback.onMapLoaded();
                    }
                }
            });
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "setOnMapLoadedCallback: " + e11.getMessage());
        }
    }

    public void setOnMapLongClickListener(final OnMapLongClickListener onMapLongClickListener) {
        LogM.d("HuaweiMap", "setOnMapLongClickListener");
        try {
            this.f49230c.setOnMapLongClickListener(onMapLongClickListener == null ? null : new IOnMapLongClickListener.Stub() {
                public void onMapLongClick(LatLng latLng) {
                    LogM.d("HuaweiMap", "onMapLongClick");
                    onMapLongClickListener.onMapLongClick(latLng);
                }
            });
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "RemoteException: " + e11.toString());
        }
    }

    public void setOnMarkerClickListener(final OnMarkerClickListener onMarkerClickListener) {
        try {
            this.f49230c.setMarkerClickListener(onMarkerClickListener == null ? null : new IOnMarkerClickListener.Stub() {
                public boolean onMarkerClick(IMarkerDelegate iMarkerDelegate) {
                    Marker marker = new Marker(iMarkerDelegate);
                    OnMarkerClickListener onMarkerClickListener = onMarkerClickListener;
                    if (onMarkerClickListener != null) {
                        return onMarkerClickListener.onMarkerClick(marker);
                    }
                    return false;
                }
            });
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "RemoteException: " + e11.toString());
        }
    }

    public void setOnMarkerDragListener(final OnMarkerDragListener onMarkerDragListener) {
        LogM.d("HuaweiMap", "onMarkerDrag setListener start: ");
        try {
            this.f49230c.setMarkerDragListener(onMarkerDragListener == null ? null : new IOnMarkerDragListener.Stub() {
                public void onMarkerDrag(IMarkerDelegate iMarkerDelegate) {
                    LogM.i("HuaweiMap", "onMarkerDrag callback start: ");
                    onMarkerDragListener.onMarkerDrag(new Marker(iMarkerDelegate));
                }

                public void onMarkerDragEnd(IMarkerDelegate iMarkerDelegate) {
                    LogM.i("HuaweiMap", "onMarkerDrag callback start: ");
                    onMarkerDragListener.onMarkerDragEnd(new Marker(iMarkerDelegate));
                }

                public void onMarkerDragStart(IMarkerDelegate iMarkerDelegate) {
                    LogM.i("HuaweiMap", "onMarkerDrag callback start: ");
                    onMarkerDragListener.onMarkerDragStart(new Marker(iMarkerDelegate));
                }
            });
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "RemoteException: " + e11.toString());
        }
    }

    public void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        LogM.d("HuaweiMap", "setOnMyLocationButtonClickListener: ");
        try {
            this.f49230c.setOnMyLocationButtonClickListener(onMyLocationButtonClickListener == null ? null : new IOnMyLocationButtonClickListener.Stub() {
                public boolean onMyLocationButtonClick() {
                    return onMyLocationButtonClickListener.onMyLocationButtonClick();
                }
            });
        } catch (RemoteException unused) {
            LogM.e("HuaweiMap", "RemoteException: ");
        }
    }

    public void setOnMyLocationClickListener(final OnMyLocationClickListener onMyLocationClickListener) {
        try {
            this.f49230c.setOnMyLocationClickListener(onMyLocationClickListener == null ? null : new IOnMyLocationClickListener.Stub() {
                public void onMyLocationClick(Location location) {
                    onMyLocationClickListener.onMyLocationClick(location);
                }
            });
        } catch (RemoteException unused) {
            LogM.e("HuaweiMap", "setOnMyLocationClickListener RemoteException");
        }
    }

    public void setOnPoiClickListener(final OnPoiClickListener onPoiClickListener) {
        try {
            this.f49230c.setOnPoiClickListener(onPoiClickListener == null ? null : new IOnPoiClickListener.Stub() {
                public void onPoiClick(PointOfInterest pointOfInterest) {
                    onPoiClickListener.onPoiClick(pointOfInterest);
                }
            });
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "setOnPoiClickListener" + e11);
        }
    }

    public void setOnPolygonClickListener(final OnPolygonClickListener onPolygonClickListener) {
        LogM.d("HuaweiMap", "setOnPolygonClickListener: ");
        try {
            this.f49230c.setPolygonClickListener(onPolygonClickListener == null ? null : new IOnPolygonClickListener.Stub() {
                public void onPolygonClick(IPolygonDelegate iPolygonDelegate) {
                    LogM.i("HuaweiMap", "onPolygonClick entrance: ");
                    Polygon polygon = new Polygon(iPolygonDelegate);
                    OnPolygonClickListener onPolygonClickListener = onPolygonClickListener;
                    if (onPolygonClickListener != null) {
                        onPolygonClickListener.onPolygonClick(polygon);
                    }
                }
            });
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "RemoteException: " + e11.toString());
        }
    }

    public void setOnPolylineClickListener(final OnPolylineClickListener onPolylineClickListener) {
        LogM.d("HuaweiMap", "setOnPolylineClickListener: ");
        try {
            this.f49230c.setPolylineClickListener(onPolylineClickListener == null ? null : new IOnPolylineClickListener.Stub() {
                public void onPolylineClick(IPolylineDelegate iPolylineDelegate) {
                    LogM.i("HuaweiMap", "onPolylineClick first: ");
                    Polyline polyline = new Polyline(iPolylineDelegate);
                    OnPolylineClickListener onPolylineClickListener = onPolylineClickListener;
                    if (onPolylineClickListener != null) {
                        onPolylineClickListener.onPolylineClick(polyline);
                    }
                }
            });
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "RemoteException: " + e11.toString());
        }
    }

    public void setPadding(int i11, int i12, int i13, int i14) {
        try {
            this.f49230c.setPadding(i11, i12, i13, i14);
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "setPadding RemoteException: " + e11.toString());
        }
    }

    public void setPointToCenter(int i11, int i12) {
        try {
            this.f49230c.setPointToCenter(i11, i12);
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "setPointToCenter RemoteException: " + e11.toString());
        }
    }

    public void setStyleId(String str) {
        try {
            this.f49230c.setStyleId(str);
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "setStyleId RemoteException = " + e11.getMessage());
        }
    }

    public void setTrafficEnabled(boolean z11) {
        try {
            this.f49230c.setTrafficEnabled(z11);
        } catch (RemoteException e11) {
            LogM.d("HuaweiMap", "setTrafficEnabled RemoteException: " + e11.toString());
        }
    }

    public void setWatermarkEnabled(boolean z11) {
        try {
            this.f49230c.setWatermarkEnabled(z11);
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "setWatermarkEnabled RemoteException: " + e11.toString());
        }
    }

    public void snapshot(final SnapshotReadyCallback snapshotReadyCallback) {
        try {
            this.f49230c.snapshotForTest(new ISnapshotReadyCallback.Stub() {
                public void onSnapshotReady(Bitmap bitmap) {
                    SnapshotReadyCallback snapshotReadyCallback = snapshotReadyCallback;
                    if (snapshotReadyCallback != null) {
                        snapshotReadyCallback.onSnapshotReady(bitmap);
                    }
                }

                public void onSnapshotReadyWrapper(IObjectWrapper iObjectWrapper) {
                }
            });
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME + e11);
        }
    }

    public void snapshot(final SnapshotReadyCallback snapshotReadyCallback, Bitmap bitmap) {
        try {
            this.f49230c.snapshot(new ISnapshotReadyCallback.Stub() {
                public void onSnapshotReady(Bitmap bitmap) {
                    SnapshotReadyCallback snapshotReadyCallback = snapshotReadyCallback;
                    if (snapshotReadyCallback != null) {
                        snapshotReadyCallback.onSnapshotReady(bitmap);
                    }
                }

                public void onSnapshotReadyWrapper(IObjectWrapper iObjectWrapper) {
                }
            }, ObjectWrapper.wrap(bitmap));
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME + e11);
        }
    }

    public void stopAnimation() {
        try {
            this.f49230c.stopAnimation();
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "stopAnimation" + e11);
        }
    }

    public void switchIndoorFloor(String str, String str2) {
        try {
            this.f49230c.switchIndoorFloor(str, str2);
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "switchIndoorFloor RemoteException: " + e11.toString());
        }
    }

    public boolean useViewLifecycleWhenInFragment() {
        try {
            return this.f49230c.useViewLifecycleWhenInFragment();
        } catch (RemoteException e11) {
            LogM.e("HuaweiMap", "useViewLifecycleWhenInFragment RemoteException: " + e11.toString());
            return true;
        }
    }
}
