package com.talabat.talabatcommon.helpers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.location.LocationListener;
import android.location.LocationManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import ev.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\bH\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\u0019J+\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00172\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020$¢\u0006\u0002\u0010%J\u0006\u0010&\u001a\u00020\u0019J\b\u0010'\u001a\u00020\u0019H\u0002J\u0006\u0010(\u001a\u00020\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017XD¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/talabat/talabatcommon/helpers/LocationHelper;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "askPermission", "", "getAskPermission", "()Z", "setAskPermission", "(Z)V", "value", "Landroid/location/LocationListener;", "locationListener", "getLocationListener", "()Landroid/location/LocationListener;", "setLocationListener", "(Landroid/location/LocationListener;)V", "locationManager", "Landroid/location/LocationManager;", "permissionRequestCode", "", "askForLocationPermission", "", "checkLocationPermission", "checkPermissionAndStartListening", "isAnyLocationPermissionGranted", "onPause", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "showLocationNeededReasonDialog", "stopLocationListening", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocationHelper {
    @NotNull
    private final Activity activity;
    private boolean askPermission;
    @Nullable
    private LocationListener locationListener;
    @NotNull
    private final LocationManager locationManager;
    private final int permissionRequestCode = 99;

    public LocationHelper(@NotNull Activity activity2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.activity = activity2;
        Object systemService = activity2.getSystemService("location");
        if (systemService != null) {
            this.locationManager = (LocationManager) systemService;
            this.askPermission = true;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
    }

    private final void askForLocationPermission() {
        ActivityCompat.requestPermissions(this.activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, this.permissionRequestCode);
    }

    private final boolean checkLocationPermission() {
        if (isAnyLocationPermissionGranted()) {
            return true;
        }
        if (this.askPermission) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this.activity, "android.permission.ACCESS_FINE_LOCATION")) {
                showLocationNeededReasonDialog();
            } else {
                askForLocationPermission();
            }
        }
        return false;
    }

    private final void checkPermissionAndStartListening() {
        LocationListener locationListener2;
        if (isAnyLocationPermissionGranted() && (locationListener2 = this.locationListener) != null) {
            this.locationManager.requestLocationUpdates(SDKCoreEvent.Network.TYPE_NETWORK, 0, 0.0f, locationListener2);
        }
    }

    private final void showLocationNeededReasonDialog() {
        new AlertDialog.Builder(this.activity).setTitle("R.string.title_location_permission").setMessage("R.string.text_location_permission").setPositiveButton(17039370, new a(this)).create().show();
    }

    /* access modifiers changed from: private */
    /* renamed from: showLocationNeededReasonDialog$lambda-2  reason: not valid java name */
    public static final void m10934showLocationNeededReasonDialog$lambda2(LocationHelper locationHelper, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(locationHelper, "this$0");
        locationHelper.askForLocationPermission();
    }

    @NotNull
    public final Activity getActivity() {
        return this.activity;
    }

    public final boolean getAskPermission() {
        return this.askPermission;
    }

    @Nullable
    public final LocationListener getLocationListener() {
        return this.locationListener;
    }

    public final boolean isAnyLocationPermissionGranted() {
        if (ContextCompat.checkSelfPermission(this.activity, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(this.activity, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    public final void onPause() {
        stopLocationListening();
    }

    public final void onRequestPermissionsResult(int i11, @NotNull String[] strArr, @NotNull int[] iArr) {
        boolean z11;
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        if (i11 == this.permissionRequestCode) {
            if (iArr.length == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if ((!z11) && iArr[0] == 0) {
                checkPermissionAndStartListening();
            }
        }
    }

    public final void onResume() {
        checkPermissionAndStartListening();
    }

    public final void setAskPermission(boolean z11) {
        this.askPermission = z11;
    }

    public final void setLocationListener(@Nullable LocationListener locationListener2) {
        LocationListener locationListener3;
        this.locationListener = locationListener2;
        if (checkLocationPermission() && (locationListener3 = this.locationListener) != null) {
            this.locationManager.requestLocationUpdates(SDKCoreEvent.Network.TYPE_NETWORK, 0, 0.0f, locationListener3);
        }
    }

    public final void stopLocationListening() {
        LocationListener locationListener2;
        if (ContextCompat.checkSelfPermission(this.activity, "android.permission.ACCESS_FINE_LOCATION") == 0 && (locationListener2 = this.locationListener) != null) {
            this.locationManager.removeUpdates(locationListener2);
        }
    }
}
