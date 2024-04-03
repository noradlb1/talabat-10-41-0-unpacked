package com.talabat.homemaphelper;

import com.huawei.hms.push.AttributionReporter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.homemaphelper.CurrentLocationFetchRefactor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/talabat/homemaphelper/CurrentLocationFetchRefactor$fetchCurrentGpsLocation$1", "Lcom/karumi/dexter/listener/single/PermissionListener;", "onPermissionDenied", "", "response", "Lcom/karumi/dexter/listener/PermissionDeniedResponse;", "onPermissionGranted", "Lcom/karumi/dexter/listener/PermissionGrantedResponse;", "onPermissionRationaleShouldBeShown", "permission", "Lcom/karumi/dexter/listener/PermissionRequest;", "token", "Lcom/karumi/dexter/PermissionToken;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CurrentLocationFetchRefactor$fetchCurrentGpsLocation$1 implements PermissionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CurrentLocationFetchRefactor f60954a;

    public CurrentLocationFetchRefactor$fetchCurrentGpsLocation$1(CurrentLocationFetchRefactor currentLocationFetchRefactor) {
        this.f60954a = currentLocationFetchRefactor;
    }

    public void onPermissionDenied(@NotNull PermissionDeniedResponse permissionDeniedResponse) {
        CurrentLocationFetchRefactor.onLocationListener listener;
        Intrinsics.checkNotNullParameter(permissionDeniedResponse, "response");
        if (this.f60954a.getActivity() != null && (listener = this.f60954a.getListener()) != null) {
            listener.OnCurrentLocationPermissionStatus(permissionDeniedResponse);
        }
    }

    public void onPermissionGranted(@NotNull PermissionGrantedResponse permissionGrantedResponse) {
        Intrinsics.checkNotNullParameter(permissionGrantedResponse, "response");
        CurrentLocationFetchRefactor currentLocationFetchRefactor = this.f60954a;
        currentLocationFetchRefactor.startLocationUpdates(currentLocationFetchRefactor.getActivity());
    }

    public void onPermissionRationaleShouldBeShown(@NotNull PermissionRequest permissionRequest, @NotNull PermissionToken permissionToken) {
        Intrinsics.checkNotNullParameter(permissionRequest, AttributionReporter.SYSTEM_PERMISSION);
        Intrinsics.checkNotNullParameter(permissionToken, LegacyTokenLocalDataSourceImpl.KEY);
        permissionToken.continuePermissionRequest();
    }
}
