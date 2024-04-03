package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.maps.internal.IProjectionDelegate;
import com.huawei.hms.maps.internal.IUiSettingsDelegate;
import com.huawei.hms.maps.model.CameraPosition;
import com.huawei.hms.maps.model.CameraUpdateParam;
import com.huawei.hms.maps.model.CircleOptions;
import com.huawei.hms.maps.model.GroundOverlayOptions;
import com.huawei.hms.maps.model.HeatMapOptions;
import com.huawei.hms.maps.model.LatLngBounds;
import com.huawei.hms.maps.model.MapStyleOptions;
import com.huawei.hms.maps.model.MarkerOptions;
import com.huawei.hms.maps.model.MyLocationStyle;
import com.huawei.hms.maps.model.PolygonOptions;
import com.huawei.hms.maps.model.PolylineOptions;
import com.huawei.hms.maps.model.TileOverlayOptions;
import com.huawei.hms.maps.model.internal.IBitmapDescriptorDelegate;
import com.huawei.hms.maps.model.internal.ICircleDelegate;
import com.huawei.hms.maps.model.internal.IGroundOverlayDelegate;
import com.huawei.hms.maps.model.internal.IHeatMapDelegate;
import com.huawei.hms.maps.model.internal.IIndoorBuildingDelegate;
import com.huawei.hms.maps.model.internal.IMarkerDelegate;
import com.huawei.hms.maps.model.internal.IPolygonDelegate;
import com.huawei.hms.maps.model.internal.IPolylineDelegate;
import com.huawei.hms.maps.model.internal.ITileOverlayDelegate;
import com.huawei.hms.maps.model.internal.mab;

public interface IHuaweiMapDelegate extends IInterface {

    public static abstract class Stub extends Binder implements IHuaweiMapDelegate {

        public static class Proxy implements IHuaweiMapDelegate {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49385a;

            public Proxy(IBinder iBinder) {
                this.f49385a = iBinder;
            }

            public ICircleDelegate addCircle(CircleOptions circleOptions) {
                return ICircleDelegate.Stub.asInterface(mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 25, (Parcelable) circleOptions));
            }

            public IGroundOverlayDelegate addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
                return IGroundOverlayDelegate.Stub.asInterface(mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 28, (Parcelable) groundOverlayOptions));
            }

            public IHeatMapDelegate addHeatMap(String str, HeatMapOptions heatMapOptions) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.internal.IHuaweiMapDelegate");
                    obtain.writeString(str);
                    if (heatMapOptions != null) {
                        obtain.writeInt(1);
                        heatMapOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f49385a.transact(74, obtain, obtain2, 0);
                    obtain2.readException();
                    return IHeatMapDelegate.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IMarkerDelegate addMarker(MarkerOptions markerOptions) {
                return IMarkerDelegate.Stub.asInterface(mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 24, (Parcelable) markerOptions));
            }

            public IPolygonDelegate addPolygon(PolygonOptions polygonOptions) {
                return IPolygonDelegate.Stub.asInterface(mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 26, (Parcelable) polygonOptions));
            }

            public IPolylineDelegate addPolyline(PolylineOptions polylineOptions) {
                return IPolylineDelegate.Stub.asInterface(mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 27, (Parcelable) polylineOptions));
            }

            public ITileOverlayDelegate addTileOverlay(TileOverlayOptions tileOverlayOptions) {
                return ITileOverlayDelegate.Stub.asInterface(mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 1, (Parcelable) tileOverlayOptions));
            }

            public void animateCamera(CameraUpdateParam cameraUpdateParam) {
                mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 33, cameraUpdateParam);
            }

            public void animateCameraWithCallback(CameraUpdateParam cameraUpdateParam, ICancelableCallback iCancelableCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.internal.IHuaweiMapDelegate");
                    if (cameraUpdateParam != null) {
                        obtain.writeInt(1);
                        cameraUpdateParam.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iCancelableCallback != null ? iCancelableCallback.asBinder() : null);
                    this.f49385a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void animateCameraWithDurationAndCallback(CameraUpdateParam cameraUpdateParam, int i11, ICancelableCallback iCancelableCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.internal.IHuaweiMapDelegate");
                    if (cameraUpdateParam != null) {
                        obtain.writeInt(1);
                        cameraUpdateParam.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i11);
                    obtain.writeStrongBinder(iCancelableCallback != null ? iCancelableCallback.asBinder() : null);
                    this.f49385a.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f49385a;
            }

            public void clear() {
                mab.i(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 32);
            }

            public IBitmapDescriptorDelegate getBitmapDescriptor() {
                return IBitmapDescriptorDelegate.Stub.asInterface(mab.j(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 68));
            }

            public CameraPosition getCameraPosition() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.internal.IHuaweiMapDelegate");
                    this.f49385a.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? CameraPosition.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getCurrentFloor() {
                return mab.d(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 75);
            }

            public IIndoorBuildingDelegate getFocusedBuilding() {
                return IIndoorBuildingDelegate.Stub.asInterface(mab.j(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 2));
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.internal.IHuaweiMapDelegate";
            }

            public int getMapType() {
                return mab.b(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 10);
            }

            public float getMaxZoomLevel() {
                return mab.c(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 3);
            }

            public float getMinZoomLevel() {
                return mab.c(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 4);
            }

            public IProjectionDelegate getProjection() {
                return IProjectionDelegate.Stub.asInterface(mab.j(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 29));
            }

            public float getScalePerPixel() {
                return mab.c(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 80);
            }

            public IUiSettingsDelegate getUiSettings() {
                return IUiSettingsDelegate.Stub.asInterface(mab.j(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 22));
            }

            public boolean isBuildingsEnabled() {
                return mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 5);
            }

            public boolean isDark() {
                return mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 79);
            }

            public boolean isIndoorEnabled() {
                return mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 11);
            }

            public boolean isMyLocationEnabled() {
                return mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 9);
            }

            public boolean isTrafficEnabled() {
                return mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 12);
            }

            public void moveCamera(CameraUpdateParam cameraUpdateParam) {
                mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 34, cameraUpdateParam);
            }

            public void previewId(String str) {
                mab.a(str, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 72);
            }

            public void resetMinMaxZoomPreference() {
                mab.i(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 13);
            }

            public void setBuildingsEnabled(boolean z11) {
                mab.a(z11, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 6);
            }

            public void setCameraIdleListener(IOnCameraIdleListener iOnCameraIdleListener) {
                mab.a(iOnCameraIdleListener != null ? iOnCameraIdleListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 40);
            }

            public void setCameraMoveCanceledListener(IOnCameraMoveCanceledListener iOnCameraMoveCanceledListener) {
                mab.a(iOnCameraMoveCanceledListener != null ? iOnCameraMoveCanceledListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 39);
            }

            public void setCameraMoveListener(IOnCameraMoveListener iOnCameraMoveListener) {
                mab.a(iOnCameraMoveListener != null ? iOnCameraMoveListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 38);
            }

            public void setCameraMoveStartedListener(IOnCameraMoveStartedListener iOnCameraMoveStartedListener) {
                mab.a(iOnCameraMoveStartedListener != null ? iOnCameraMoveStartedListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 37);
            }

            public void setCircleClickListener(IOnCircleClickListener iOnCircleClickListener) {
                mab.a(iOnCircleClickListener != null ? iOnCircleClickListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 42);
            }

            public void setCommonDir(int i11, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.internal.IHuaweiMapDelegate");
                    obtain.writeInt(i11);
                    obtain.writeString(str);
                    this.f49385a.transact(82, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setContentDescription(String str) {
                mab.a(str, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 14);
            }

            public void setDark(boolean z11) {
                mab.a(z11, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 78);
            }

            public void setFrameTime(int i11) {
                mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 83, Integer.valueOf(i11));
            }

            public void setGcj02CoordinateEnabled(boolean z11) {
                mab.a(z11, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 73);
            }

            public void setGeoPoliticalView(String str) {
                mab.a(str, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 67);
            }

            public boolean setIndoorEnabled(boolean z11) {
                return mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 15, z11);
            }

            public void setIndoorViewListener(IOnIndoorViewListener iOnIndoorViewListener) {
                mab.a(iOnIndoorViewListener != null ? iOnIndoorViewListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 77);
            }

            public void setInfoWindowAdapter(IInfoWindowAdapter iInfoWindowAdapter) {
                mab.a(iInfoWindowAdapter != null ? iInfoWindowAdapter.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 45);
            }

            public void setLanguage(String str) {
                mab.a(str, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 69);
            }

            public void setLatLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
                mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 23, latLngBounds);
            }

            public void setLiteMode(boolean z11) {
                mab.a(z11, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 31);
            }

            public void setLocationSource(ILocationSourceDelegate iLocationSourceDelegate) {
                mab.a(iLocationSourceDelegate != null ? iLocationSourceDelegate.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 58);
            }

            public boolean setMapStyle(MapStyleOptions mapStyleOptions) {
                return mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 59, 0, mapStyleOptions).intValue() != 0;
            }

            public void setMapType(int i11) {
                mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 7, Integer.valueOf(i11));
            }

            public void setMarkerClickListener(IOnMarkerClickListener iOnMarkerClickListener) {
                mab.a(iOnMarkerClickListener != null ? iOnMarkerClickListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 51);
            }

            public void setMarkerDragListener(IOnMarkerDragListener iOnMarkerDragListener) {
                mab.a(iOnMarkerDragListener != null ? iOnMarkerDragListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 52);
            }

            public void setMarkersClustering(boolean z11) {
                mab.a(z11, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 60);
            }

            public void setMaxZoomPreference(float f11) {
                mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 16, Float.valueOf(f11));
            }

            public void setMinZoomPreference(float f11) {
                mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 17, Float.valueOf(f11));
            }

            public void setMyLocationEnabled(boolean z11) {
                mab.a(z11, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 8);
            }

            public void setMyLocationStyle(MyLocationStyle myLocationStyle) {
                mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 81, (Parcelable) myLocationStyle);
            }

            public void setOnCameraChangeListener(IOnCameraChangeListener iOnCameraChangeListener) {
                mab.a(iOnCameraChangeListener != null ? iOnCameraChangeListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 84);
            }

            public void setOnGroundOverlayClickListener(IOnGroundOverlayClickListener iOnGroundOverlayClickListener) {
                mab.a(iOnGroundOverlayClickListener != null ? iOnGroundOverlayClickListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 47);
            }

            public void setOnIndoorStateChangeListener(IOnIndoorStateChangeListener iOnIndoorStateChangeListener) {
                mab.a(iOnIndoorStateChangeListener != null ? iOnIndoorStateChangeListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 48);
            }

            public void setOnInfoWindowClickListener(IOnInfoWindowClickListener iOnInfoWindowClickListener) {
                mab.a(iOnInfoWindowClickListener != null ? iOnInfoWindowClickListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 46);
            }

            public void setOnInfoWindowCloseListener(IOnInfoWindowCloseListener iOnInfoWindowCloseListener) {
                mab.a(iOnInfoWindowCloseListener != null ? iOnInfoWindowCloseListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 49);
            }

            public void setOnInfoWindowLongClickListener(IOnInfoWindowLongClickListener iOnInfoWindowLongClickListener) {
                mab.a(iOnInfoWindowLongClickListener != null ? iOnInfoWindowLongClickListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 50);
            }

            public void setOnMapClickListener(IOnMapClickListener iOnMapClickListener) {
                mab.a(iOnMapClickListener != null ? iOnMapClickListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 54);
            }

            public void setOnMapLoadedCallback(IOnMapLoadedCallback iOnMapLoadedCallback) {
                mab.a(iOnMapLoadedCallback != null ? iOnMapLoadedCallback.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 30);
            }

            public void setOnMapLongClickListener(IOnMapLongClickListener iOnMapLongClickListener) {
                mab.a(iOnMapLongClickListener != null ? iOnMapLongClickListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 53);
            }

            public void setOnMyLocationButtonClickListener(IOnMyLocationButtonClickListener iOnMyLocationButtonClickListener) {
                mab.a(iOnMyLocationButtonClickListener != null ? iOnMyLocationButtonClickListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 55);
            }

            public void setOnMyLocationChangeListener(IOnMyLocationChangeListener iOnMyLocationChangeListener) {
                mab.a(iOnMyLocationChangeListener != null ? iOnMyLocationChangeListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 56);
            }

            public void setOnMyLocationClickListener(IOnMyLocationClickListener iOnMyLocationClickListener) {
                mab.a(iOnMyLocationClickListener != null ? iOnMyLocationClickListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 57);
            }

            public void setOnPoiClickListener(IOnPoiClickListener iOnPoiClickListener) {
                mab.a(iOnPoiClickListener != null ? iOnPoiClickListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 61);
            }

            public void setOnPolygonClickListener(IOnPolygonClickListener iOnPolygonClickListener) {
                mab.a(iOnPolygonClickListener != null ? iOnPolygonClickListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 62);
            }

            public void setOnPolylineClickListener(IOnPolylineClickListener iOnPolylineClickListener) {
                mab.a(iOnPolylineClickListener != null ? iOnPolylineClickListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 63);
            }

            public void setPadding(int i11, int i12, int i13, int i14) {
                mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 18, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14));
            }

            public void setPointToCenter(int i11, int i12) {
                mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 70, Integer.valueOf(i11), Integer.valueOf(i12));
            }

            public void setPolygonClickListener(IOnPolygonClickListener iOnPolygonClickListener) {
                mab.a(iOnPolygonClickListener != null ? iOnPolygonClickListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 43);
            }

            public void setPolylineClickListener(IOnPolylineClickListener iOnPolylineClickListener) {
                mab.a(iOnPolylineClickListener != null ? iOnPolylineClickListener.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 44);
            }

            public void setStyleId(String str) {
                mab.a(str, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 71);
            }

            public void setTrafficEnabled(boolean z11) {
                mab.a(z11, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 19);
            }

            public void setWatermarkEnabled(boolean z11) {
                mab.a(z11, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 20);
            }

            public void snapshot(ISnapshotReadyCallback iSnapshotReadyCallback, IObjectWrapper iObjectWrapper) {
                IBinder iBinder = null;
                IBinder asBinder = iSnapshotReadyCallback != null ? iSnapshotReadyCallback.asBinder() : null;
                if (iObjectWrapper != null) {
                    iBinder = iObjectWrapper.asBinder();
                }
                mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 64, asBinder, iBinder);
            }

            public void snapshotForTest(ISnapshotReadyCallback iSnapshotReadyCallback) {
                mab.a(iSnapshotReadyCallback != null ? iSnapshotReadyCallback.asBinder() : null, this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 65);
            }

            public void stopAnimation() {
                mab.i(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 66);
            }

            public void switchIndoorFloor(String str, String str2) {
                mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 76, str, str2);
            }

            public boolean useViewLifecycleWhenInFragment() {
                return mab.a(this.f49385a, "com.huawei.hms.maps.internal.IHuaweiMapDelegate", 21);
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.internal.IHuaweiMapDelegate");
        }

        public static IHuaweiMapDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.internal.IHuaweiMapDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IHuaweiMapDelegate)) ? new Proxy(iBinder) : (IHuaweiMapDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    ICircleDelegate addCircle(CircleOptions circleOptions);

    IGroundOverlayDelegate addGroundOverlay(GroundOverlayOptions groundOverlayOptions);

    IHeatMapDelegate addHeatMap(String str, HeatMapOptions heatMapOptions);

    IMarkerDelegate addMarker(MarkerOptions markerOptions);

    IPolygonDelegate addPolygon(PolygonOptions polygonOptions);

    IPolylineDelegate addPolyline(PolylineOptions polylineOptions);

    ITileOverlayDelegate addTileOverlay(TileOverlayOptions tileOverlayOptions);

    void animateCamera(CameraUpdateParam cameraUpdateParam);

    void animateCameraWithCallback(CameraUpdateParam cameraUpdateParam, ICancelableCallback iCancelableCallback);

    void animateCameraWithDurationAndCallback(CameraUpdateParam cameraUpdateParam, int i11, ICancelableCallback iCancelableCallback);

    void clear();

    IBitmapDescriptorDelegate getBitmapDescriptor();

    CameraPosition getCameraPosition();

    String getCurrentFloor();

    IIndoorBuildingDelegate getFocusedBuilding();

    int getMapType();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    IProjectionDelegate getProjection();

    float getScalePerPixel();

    IUiSettingsDelegate getUiSettings();

    boolean isBuildingsEnabled();

    boolean isDark();

    boolean isIndoorEnabled();

    boolean isMyLocationEnabled();

    boolean isTrafficEnabled();

    void moveCamera(CameraUpdateParam cameraUpdateParam);

    void previewId(String str);

    void resetMinMaxZoomPreference();

    void setBuildingsEnabled(boolean z11);

    void setCameraIdleListener(IOnCameraIdleListener iOnCameraIdleListener);

    void setCameraMoveCanceledListener(IOnCameraMoveCanceledListener iOnCameraMoveCanceledListener);

    void setCameraMoveListener(IOnCameraMoveListener iOnCameraMoveListener);

    void setCameraMoveStartedListener(IOnCameraMoveStartedListener iOnCameraMoveStartedListener);

    void setCircleClickListener(IOnCircleClickListener iOnCircleClickListener);

    void setCommonDir(int i11, String str);

    void setContentDescription(String str);

    void setDark(boolean z11);

    void setFrameTime(int i11);

    void setGcj02CoordinateEnabled(boolean z11);

    void setGeoPoliticalView(String str);

    boolean setIndoorEnabled(boolean z11);

    void setIndoorViewListener(IOnIndoorViewListener iOnIndoorViewListener);

    void setInfoWindowAdapter(IInfoWindowAdapter iInfoWindowAdapter);

    void setLanguage(String str);

    void setLatLngBoundsForCameraTarget(LatLngBounds latLngBounds);

    void setLiteMode(boolean z11);

    void setLocationSource(ILocationSourceDelegate iLocationSourceDelegate);

    boolean setMapStyle(MapStyleOptions mapStyleOptions);

    void setMapType(int i11);

    void setMarkerClickListener(IOnMarkerClickListener iOnMarkerClickListener);

    void setMarkerDragListener(IOnMarkerDragListener iOnMarkerDragListener);

    void setMarkersClustering(boolean z11);

    void setMaxZoomPreference(float f11);

    void setMinZoomPreference(float f11);

    void setMyLocationEnabled(boolean z11);

    void setMyLocationStyle(MyLocationStyle myLocationStyle);

    void setOnCameraChangeListener(IOnCameraChangeListener iOnCameraChangeListener);

    void setOnGroundOverlayClickListener(IOnGroundOverlayClickListener iOnGroundOverlayClickListener);

    void setOnIndoorStateChangeListener(IOnIndoorStateChangeListener iOnIndoorStateChangeListener);

    void setOnInfoWindowClickListener(IOnInfoWindowClickListener iOnInfoWindowClickListener);

    void setOnInfoWindowCloseListener(IOnInfoWindowCloseListener iOnInfoWindowCloseListener);

    void setOnInfoWindowLongClickListener(IOnInfoWindowLongClickListener iOnInfoWindowLongClickListener);

    void setOnMapClickListener(IOnMapClickListener iOnMapClickListener);

    void setOnMapLoadedCallback(IOnMapLoadedCallback iOnMapLoadedCallback);

    void setOnMapLongClickListener(IOnMapLongClickListener iOnMapLongClickListener);

    void setOnMyLocationButtonClickListener(IOnMyLocationButtonClickListener iOnMyLocationButtonClickListener);

    void setOnMyLocationChangeListener(IOnMyLocationChangeListener iOnMyLocationChangeListener);

    void setOnMyLocationClickListener(IOnMyLocationClickListener iOnMyLocationClickListener);

    void setOnPoiClickListener(IOnPoiClickListener iOnPoiClickListener);

    void setOnPolygonClickListener(IOnPolygonClickListener iOnPolygonClickListener);

    void setOnPolylineClickListener(IOnPolylineClickListener iOnPolylineClickListener);

    void setPadding(int i11, int i12, int i13, int i14);

    void setPointToCenter(int i11, int i12);

    void setPolygonClickListener(IOnPolygonClickListener iOnPolygonClickListener);

    void setPolylineClickListener(IOnPolylineClickListener iOnPolylineClickListener);

    void setStyleId(String str);

    void setTrafficEnabled(boolean z11);

    void setWatermarkEnabled(boolean z11);

    void snapshot(ISnapshotReadyCallback iSnapshotReadyCallback, IObjectWrapper iObjectWrapper);

    void snapshotForTest(ISnapshotReadyCallback iSnapshotReadyCallback);

    void stopAnimation();

    void switchIndoorFloor(String str, String str2);

    boolean useViewLifecycleWhenInFragment();
}
