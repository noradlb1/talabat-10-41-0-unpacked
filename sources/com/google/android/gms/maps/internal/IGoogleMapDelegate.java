package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zzaa;
import com.google.android.gms.internal.maps.zzad;
import com.google.android.gms.internal.maps.zzag;
import com.google.android.gms.internal.maps.zzaj;
import com.google.android.gms.internal.maps.zzam;
import com.google.android.gms.internal.maps.zzl;
import com.google.android.gms.internal.maps.zzo;
import com.google.android.gms.internal.maps.zzr;
import com.google.android.gms.internal.maps.zzu;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.zzd;
import javax.annotation.Nullable;

public interface IGoogleMapDelegate extends IInterface {
    zzl addCircle(CircleOptions circleOptions) throws RemoteException;

    zzr addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException;

    zzad addMarker(MarkerOptions markerOptions) throws RemoteException;

    void addOnMapCapabilitiesChangedListener(zzal zzal) throws RemoteException;

    zzag addPolygon(PolygonOptions polygonOptions) throws RemoteException;

    zzaj addPolyline(PolylineOptions polylineOptions) throws RemoteException;

    zzam addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException;

    void animateCamera(@NonNull IObjectWrapper iObjectWrapper) throws RemoteException;

    void animateCameraWithCallback(IObjectWrapper iObjectWrapper, @Nullable zzd zzd) throws RemoteException;

    void animateCameraWithDurationAndCallback(IObjectWrapper iObjectWrapper, int i11, @Nullable zzd zzd) throws RemoteException;

    void clear() throws RemoteException;

    @NonNull
    CameraPosition getCameraPosition() throws RemoteException;

    zzo getFeatureLayer(zzd zzd) throws RemoteException;

    zzu getFocusedBuilding() throws RemoteException;

    void getMapAsync(zzat zzat) throws RemoteException;

    zzaa getMapCapabilities() throws RemoteException;

    int getMapType() throws RemoteException;

    float getMaxZoomLevel() throws RemoteException;

    float getMinZoomLevel() throws RemoteException;

    @NonNull
    Location getMyLocation() throws RemoteException;

    @NonNull
    IProjectionDelegate getProjection() throws RemoteException;

    @NonNull
    IUiSettingsDelegate getUiSettings() throws RemoteException;

    boolean isBuildingsEnabled() throws RemoteException;

    boolean isIndoorEnabled() throws RemoteException;

    boolean isMyLocationEnabled() throws RemoteException;

    boolean isTrafficEnabled() throws RemoteException;

    void moveCamera(@NonNull IObjectWrapper iObjectWrapper) throws RemoteException;

    void onCreate(@NonNull Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onEnterAmbient(@NonNull Bundle bundle) throws RemoteException;

    void onExitAmbient() throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(@NonNull Bundle bundle) throws RemoteException;

    void onStart() throws RemoteException;

    void onStop() throws RemoteException;

    void removeOnMapCapabilitiesChangedListener(zzal zzal) throws RemoteException;

    void resetMinMaxZoomPreference() throws RemoteException;

    void setBuildingsEnabled(boolean z11) throws RemoteException;

    void setContentDescription(@Nullable String str) throws RemoteException;

    boolean setIndoorEnabled(boolean z11) throws RemoteException;

    void setInfoWindowAdapter(@Nullable zzi zzi) throws RemoteException;

    void setLatLngBoundsForCameraTarget(@Nullable LatLngBounds latLngBounds) throws RemoteException;

    void setLocationSource(@Nullable ILocationSourceDelegate iLocationSourceDelegate) throws RemoteException;

    boolean setMapStyle(@Nullable MapStyleOptions mapStyleOptions) throws RemoteException;

    void setMapType(int i11) throws RemoteException;

    void setMaxZoomPreference(float f11) throws RemoteException;

    void setMinZoomPreference(float f11) throws RemoteException;

    void setMyLocationEnabled(boolean z11) throws RemoteException;

    void setOnCameraChangeListener(@Nullable zzn zzn) throws RemoteException;

    void setOnCameraIdleListener(@Nullable zzp zzp) throws RemoteException;

    void setOnCameraMoveCanceledListener(@Nullable zzr zzr) throws RemoteException;

    void setOnCameraMoveListener(@Nullable zzt zzt) throws RemoteException;

    void setOnCameraMoveStartedListener(@Nullable zzv zzv) throws RemoteException;

    void setOnCircleClickListener(@Nullable zzx zzx) throws RemoteException;

    void setOnGroundOverlayClickListener(@Nullable zzz zzz) throws RemoteException;

    void setOnIndoorStateChangeListener(@Nullable zzab zzab) throws RemoteException;

    void setOnInfoWindowClickListener(@Nullable zzad zzad) throws RemoteException;

    void setOnInfoWindowCloseListener(@Nullable zzaf zzaf) throws RemoteException;

    void setOnInfoWindowLongClickListener(@Nullable zzah zzah) throws RemoteException;

    void setOnMapClickListener(@Nullable zzan zzan) throws RemoteException;

    void setOnMapLoadedCallback(@Nullable zzap zzap) throws RemoteException;

    void setOnMapLongClickListener(@Nullable zzar zzar) throws RemoteException;

    void setOnMarkerClickListener(@Nullable zzav zzav) throws RemoteException;

    void setOnMarkerDragListener(@Nullable zzax zzax) throws RemoteException;

    void setOnMyLocationButtonClickListener(@Nullable zzaz zzaz) throws RemoteException;

    void setOnMyLocationChangeListener(@Nullable zzbb zzbb) throws RemoteException;

    void setOnMyLocationClickListener(@Nullable zzbd zzbd) throws RemoteException;

    void setOnPoiClickListener(@Nullable zzbf zzbf) throws RemoteException;

    void setOnPolygonClickListener(@Nullable zzbh zzbh) throws RemoteException;

    void setOnPolylineClickListener(@Nullable zzbj zzbj) throws RemoteException;

    void setPadding(int i11, int i12, int i13, int i14) throws RemoteException;

    void setTrafficEnabled(boolean z11) throws RemoteException;

    void setWatermarkEnabled(boolean z11) throws RemoteException;

    void snapshot(zzbw zzbw, @Nullable IObjectWrapper iObjectWrapper) throws RemoteException;

    void snapshotForTest(zzbw zzbw) throws RemoteException;

    void stopAnimation() throws RemoteException;

    boolean useViewLifecycleWhenInFragment() throws RemoteException;
}
