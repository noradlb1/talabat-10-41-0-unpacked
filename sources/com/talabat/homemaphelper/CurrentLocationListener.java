package com.talabat.homemaphelper;

import com.google.android.gms.maps.model.LatLng;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\"\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\nH&¨\u0006\u0014"}, d2 = {"Lcom/talabat/homemaphelper/CurrentLocationListener;", "", "OnCurrentLocationPermissionStatus", "", "response", "Lcom/karumi/dexter/listener/PermissionDeniedResponse;", "deliverToCLRecived", "currentLatLng", "Lcom/google/android/gms/maps/model/LatLng;", "isRefreshMap", "", "mapCurrentLocReceived", "onCurrentLocationReceived", "location", "isShowLocationInAccurateAlert", "lococaccuracy", "", "onCurrentLocationReceivedWithLowAccuracy", "onGeoLocationDialogAccepted", "locationRequestStatus", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CurrentLocationListener {
    void OnCurrentLocationPermissionStatus(@NotNull PermissionDeniedResponse permissionDeniedResponse);

    void deliverToCLRecived(@NotNull LatLng latLng);

    void isRefreshMap(boolean z11, @NotNull LatLng latLng);

    void mapCurrentLocReceived(@NotNull LatLng latLng);

    void onCurrentLocationReceived(@Nullable LatLng latLng, boolean z11, float f11);

    void onCurrentLocationReceivedWithLowAccuracy(@NotNull LatLng latLng, float f11);

    void onGeoLocationDialogAccepted(boolean z11);
}
