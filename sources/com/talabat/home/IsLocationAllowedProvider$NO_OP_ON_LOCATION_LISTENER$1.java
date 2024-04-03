package com.talabat.home;

import android.location.Location;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.talabat.homemaphelper.CurrentLocationFetchRefactor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/talabat/home/IsLocationAllowedProvider$NO_OP_ON_LOCATION_LISTENER$1", "Lcom/talabat/homemaphelper/CurrentLocationFetchRefactor$onLocationListener;", "OnCurrentLocationPermissionStatus", "", "response", "Lcom/karumi/dexter/listener/PermissionDeniedResponse;", "onCurrentLocationReceived", "isLocationFetchSuccess", "", "mCurrentLocation", "Landroid/location/Location;", "accuracy", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsLocationAllowedProvider$NO_OP_ON_LOCATION_LISTENER$1 implements CurrentLocationFetchRefactor.onLocationListener {
    public void OnCurrentLocationPermissionStatus(@NotNull PermissionDeniedResponse permissionDeniedResponse) {
        Intrinsics.checkNotNullParameter(permissionDeniedResponse, "response");
    }

    public void onCurrentLocationReceived(boolean z11, @Nullable Location location, float f11) {
    }
}
