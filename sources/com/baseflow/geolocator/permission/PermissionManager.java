package com.baseflow.geolocator.permission;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.baseflow.geolocator.errors.PermissionUndefinedException;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PermissionManager implements PluginRegistry.RequestPermissionsResultListener {
    private static final int PERMISSION_REQUEST_CODE = 109;
    @Nullable
    private Activity activity;
    @Nullable
    private ErrorCallback errorCallback;
    @Nullable
    private PermissionResultCallback resultCallback;

    private static List<String> getLocationPermissionsFromManifest(Context context) throws PermissionUndefinedException {
        boolean hasPermissionInManifest = PermissionUtils.hasPermissionInManifest(context, "android.permission.ACCESS_FINE_LOCATION");
        boolean hasPermissionInManifest2 = PermissionUtils.hasPermissionInManifest(context, "android.permission.ACCESS_COARSE_LOCATION");
        if (hasPermissionInManifest || hasPermissionInManifest2) {
            ArrayList arrayList = new ArrayList();
            if (hasPermissionInManifest) {
                arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            }
            if (hasPermissionInManifest2) {
                arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
            }
            return arrayList;
        }
        throw new PermissionUndefinedException();
    }

    @RequiresApi(api = 29)
    private boolean hasBackgroundAccess(String[] strArr, int[] iArr) {
        int indexOf = indexOf(strArr, "android.permission.ACCESS_BACKGROUND_LOCATION");
        if (indexOf < 0 || iArr[indexOf] != 0) {
            return false;
        }
        return true;
    }

    private static <T> int indexOf(T[] tArr, T t11) {
        return Arrays.asList(tArr).indexOf(t11);
    }

    public LocationPermission checkPermissionStatus(Context context) throws PermissionUndefinedException {
        boolean z11;
        Iterator<String> it = getLocationPermissionsFromManifest(context).iterator();
        while (true) {
            if (it.hasNext()) {
                if (ContextCompat.checkSelfPermission(context, it.next()) == 0) {
                    z11 = false;
                    break;
                }
            } else {
                z11 = true;
                break;
            }
        }
        if (z11) {
            return LocationPermission.denied;
        }
        if (Build.VERSION.SDK_INT < 29) {
            return LocationPermission.always;
        }
        if (!PermissionUtils.hasPermissionInManifest(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            return LocationPermission.whileInUse;
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0) {
            return LocationPermission.always;
        }
        return LocationPermission.whileInUse;
    }

    public boolean hasPermission(Context context) throws PermissionUndefinedException {
        LocationPermission checkPermissionStatus = checkPermissionStatus(context);
        if (checkPermissionStatus == LocationPermission.whileInUse || checkPermissionStatus == LocationPermission.always) {
            return true;
        }
        return false;
    }

    public boolean onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        LocationPermission locationPermission;
        if (i11 != 109) {
            return false;
        }
        Activity activity2 = this.activity;
        if (activity2 == null) {
            Log.e("Geolocator", "Trying to process permission result without an valid Activity instance");
            ErrorCallback errorCallback2 = this.errorCallback;
            if (errorCallback2 != null) {
                errorCallback2.onError(ErrorCodes.activityMissing);
            }
            return false;
        }
        try {
            List<String> locationPermissionsFromManifest = getLocationPermissionsFromManifest(activity2);
            if (iArr.length == 0) {
                Log.i("Geolocator", "The grantResults array is empty. This can happen when the user cancels the permission request");
                return false;
            }
            LocationPermission locationPermission2 = LocationPermission.denied;
            char c11 = 65535;
            boolean z11 = false;
            boolean z12 = false;
            for (String next : locationPermissionsFromManifest) {
                int indexOf = indexOf(strArr, next);
                if (indexOf >= 0) {
                    z11 = true;
                }
                if (iArr[indexOf] == 0) {
                    c11 = 0;
                }
                if (ActivityCompat.shouldShowRequestPermissionRationale(this.activity, next)) {
                    z12 = true;
                }
            }
            if (!z11) {
                Log.w("Geolocator", "Location permissions not part of permissions send to onRequestPermissionsResult method.");
                return false;
            }
            if (c11 == 0) {
                if (Build.VERSION.SDK_INT < 29 || hasBackgroundAccess(strArr, iArr)) {
                    locationPermission = LocationPermission.always;
                } else {
                    locationPermission = LocationPermission.whileInUse;
                }
                locationPermission2 = locationPermission;
            } else if (!z12) {
                locationPermission2 = LocationPermission.deniedForever;
            }
            PermissionResultCallback permissionResultCallback = this.resultCallback;
            if (permissionResultCallback != null) {
                permissionResultCallback.onResult(locationPermission2);
            }
            return true;
        } catch (PermissionUndefinedException unused) {
            ErrorCallback errorCallback3 = this.errorCallback;
            if (errorCallback3 != null) {
                errorCallback3.onError(ErrorCodes.permissionDefinitionsNotFound);
            }
            return false;
        }
    }

    public void requestPermission(Activity activity2, PermissionResultCallback permissionResultCallback, ErrorCallback errorCallback2) throws PermissionUndefinedException {
        if (activity2 == null) {
            errorCallback2.onError(ErrorCodes.activityMissing);
            return;
        }
        int i11 = Build.VERSION.SDK_INT;
        List<String> locationPermissionsFromManifest = getLocationPermissionsFromManifest(activity2);
        if (i11 >= 29 && PermissionUtils.hasPermissionInManifest(activity2, "android.permission.ACCESS_BACKGROUND_LOCATION") && checkPermissionStatus(activity2) == LocationPermission.whileInUse) {
            locationPermissionsFromManifest.add("android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        this.errorCallback = errorCallback2;
        this.resultCallback = permissionResultCallback;
        this.activity = activity2;
        ActivityCompat.requestPermissions(activity2, (String[]) locationPermissionsFromManifest.toArray(new String[0]), 109);
    }
}
