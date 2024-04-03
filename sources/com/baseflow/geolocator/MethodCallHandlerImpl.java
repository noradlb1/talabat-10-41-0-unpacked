package com.baseflow.geolocator;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.baseflow.geolocator.errors.PermissionUndefinedException;
import com.baseflow.geolocator.location.FlutterLocationServiceListener;
import com.baseflow.geolocator.location.GeolocationManager;
import com.baseflow.geolocator.location.LocationAccuracyManager;
import com.baseflow.geolocator.location.LocationAccuracyStatus;
import com.baseflow.geolocator.location.LocationClient;
import com.baseflow.geolocator.location.LocationMapper;
import com.baseflow.geolocator.location.LocationOptions;
import com.baseflow.geolocator.permission.PermissionManager;
import com.baseflow.geolocator.utils.Utils;
import com.visa.checkout.PurchaseInfo;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;

class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    private static final String TAG = "MethodCallHandlerImpl";
    @Nullable
    private Activity activity;
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, LocationClient> f43208b = new HashMap();
    @Nullable
    private MethodChannel channel;
    @Nullable
    private Context context;
    private final GeolocationManager geolocationManager;
    private final LocationAccuracyManager locationAccuracyManager;
    private final PermissionManager permissionManager;

    public MethodCallHandlerImpl(PermissionManager permissionManager2, GeolocationManager geolocationManager2, LocationAccuracyManager locationAccuracyManager2) {
        this.permissionManager = permissionManager2;
        this.geolocationManager = geolocationManager2;
        this.locationAccuracyManager = locationAccuracyManager2;
    }

    private void getLocationAccuracy(MethodChannel.Result result, Context context2) {
        LocationAccuracyStatus locationAccuracy = this.locationAccuracyManager.getLocationAccuracy(context2, new c(result));
        if (locationAccuracy != null) {
            result.success(Integer.valueOf(locationAccuracy.ordinal()));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onGetCurrentPosition$5(boolean[] zArr, LocationClient locationClient, String str, MethodChannel.Result result, Location location) {
        if (!zArr[0]) {
            zArr[0] = true;
            this.geolocationManager.stopPositionUpdates(locationClient);
            this.f43208b.remove(str);
            result.success(LocationMapper.toHashMap(location));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onGetCurrentPosition$6(boolean[] zArr, LocationClient locationClient, String str, MethodChannel.Result result, ErrorCodes errorCodes) {
        if (!zArr[0]) {
            zArr[0] = true;
            this.geolocationManager.stopPositionUpdates(locationClient);
            this.f43208b.remove(str);
            result.error(errorCodes.toString(), errorCodes.toDescription(), (Object) null);
        }
    }

    private void onCancelGetCurrentPosition(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) ((Map) methodCall.arguments).get(PurchaseInfo.REQUEST_ID);
        LocationClient locationClient = this.f43208b.get(str);
        if (locationClient != null) {
            locationClient.stopPositionUpdates();
        }
        this.f43208b.remove(str);
        result.success((Object) null);
    }

    private void onCheckPermission(MethodChannel.Result result) {
        try {
            result.success(Integer.valueOf(this.permissionManager.checkPermissionStatus(this.context).toInt()));
        } catch (PermissionUndefinedException unused) {
            ErrorCodes errorCodes = ErrorCodes.permissionDefinitionsNotFound;
            result.error(errorCodes.toString(), errorCodes.toDescription(), (Object) null);
        }
    }

    private void onGetCurrentPosition(MethodCall methodCall, MethodChannel.Result result) {
        boolean z11;
        try {
            if (!this.permissionManager.hasPermission(this.context)) {
                ErrorCodes errorCodes = ErrorCodes.permissionDenied;
                result.error(errorCodes.toString(), errorCodes.toDescription(), (Object) null);
                return;
            }
            Map map = (Map) methodCall.arguments;
            if (map.get("forceLocationManager") != null) {
                z11 = ((Boolean) map.get("forceLocationManager")).booleanValue();
            } else {
                z11 = false;
            }
            LocationOptions parseArguments = LocationOptions.parseArguments(map);
            String str = (String) map.get(PurchaseInfo.REQUEST_ID);
            LocationClient createLocationClient = this.geolocationManager.createLocationClient(this.context, z11, parseArguments);
            this.f43208b.put(str, createLocationClient);
            boolean[] zArr = {false};
            LocationClient locationClient = createLocationClient;
            String str2 = str;
            MethodChannel.Result result2 = result;
            this.geolocationManager.startPositionUpdates(createLocationClient, this.activity, new f(this, zArr, locationClient, str2, result2), new g(this, zArr, locationClient, str2, result2));
        } catch (PermissionUndefinedException unused) {
            ErrorCodes errorCodes2 = ErrorCodes.permissionDefinitionsNotFound;
            result.error(errorCodes2.toString(), errorCodes2.toDescription(), (Object) null);
        }
    }

    private void onGetLastKnownPosition(MethodCall methodCall, MethodChannel.Result result) {
        boolean z11;
        try {
            if (!this.permissionManager.hasPermission(this.context)) {
                ErrorCodes errorCodes = ErrorCodes.permissionDenied;
                result.error(errorCodes.toString(), errorCodes.toDescription(), (Object) null);
                return;
            }
            Boolean bool = (Boolean) methodCall.argument("forceLocationManager");
            GeolocationManager geolocationManager2 = this.geolocationManager;
            Context context2 = this.context;
            if (bool == null || !bool.booleanValue()) {
                z11 = false;
            } else {
                z11 = true;
            }
            geolocationManager2.getLastKnownPosition(context2, z11, new a(result), new b(result));
        } catch (PermissionUndefinedException unused) {
            ErrorCodes errorCodes2 = ErrorCodes.permissionDefinitionsNotFound;
            result.error(errorCodes2.toString(), errorCodes2.toDescription(), (Object) null);
        }
    }

    private void onIsLocationServiceEnabled(MethodChannel.Result result) {
        this.geolocationManager.isLocationServiceEnabled(this.context, new FlutterLocationServiceListener(result));
    }

    private void onRequestPermission(MethodChannel.Result result) {
        try {
            this.permissionManager.requestPermission(this.activity, new d(result), new e(result));
        } catch (PermissionUndefinedException unused) {
            ErrorCodes errorCodes = ErrorCodes.permissionDefinitionsNotFound;
            result.error(errorCodes.toString(), errorCodes.toDescription(), (Object) null);
        }
    }

    public void h(@Nullable Activity activity2) {
        this.activity = activity2;
    }

    public void i(Context context2, BinaryMessenger binaryMessenger) {
        if (this.channel != null) {
            Log.w(TAG, "Setting a method call handler before the last was disposed.");
            j();
        }
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "flutter.baseflow.com/geolocator_android");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.context = context2;
    }

    public void j() {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
            this.channel = null;
        }
    }

    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1757019252:
                if (str.equals("getCurrentPosition")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1156770336:
                if (str.equals("getLastKnownPosition")) {
                    c11 = 1;
                    break;
                }
                break;
            case -821636766:
                if (str.equals("openLocationSettings")) {
                    c11 = 2;
                    break;
                }
                break;
            case 347240634:
                if (str.equals("openAppSettings")) {
                    c11 = 3;
                    break;
                }
                break;
            case 356040619:
                if (str.equals("isLocationServiceEnabled")) {
                    c11 = 4;
                    break;
                }
                break;
            case 686218487:
                if (str.equals("checkPermission")) {
                    c11 = 5;
                    break;
                }
                break;
            case 746581438:
                if (str.equals("requestPermission")) {
                    c11 = 6;
                    break;
                }
                break;
            case 877043524:
                if (str.equals("getLocationAccuracy")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1774650278:
                if (str.equals("cancelGetCurrentPosition")) {
                    c11 = 8;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                onGetCurrentPosition(methodCall, result);
                return;
            case 1:
                onGetLastKnownPosition(methodCall, result);
                return;
            case 2:
                result.success(Boolean.valueOf(Utils.openLocationSettings(this.context)));
                return;
            case 3:
                result.success(Boolean.valueOf(Utils.openAppSettings(this.context)));
                return;
            case 4:
                onIsLocationServiceEnabled(result);
                return;
            case 5:
                onCheckPermission(result);
                return;
            case 6:
                onRequestPermission(result);
                return;
            case 7:
                getLocationAccuracy(result, this.context);
                return;
            case 8:
                onCancelGetCurrentPosition(methodCall, result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }
}
