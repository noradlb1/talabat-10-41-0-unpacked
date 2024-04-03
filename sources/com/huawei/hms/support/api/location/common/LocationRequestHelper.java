package com.huawei.hms.support.api.location.common;

import android.app.PendingIntent;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.locationSdk.e0;
import com.huawei.hms.locationSdk.h0;
import com.huawei.hms.locationSdk.j1;
import com.huawei.hms.locationSdk.v0;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.updates.RemoveLocationUpdatesRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.ReflectionUtils;
import java.util.Map;

public class LocationRequestHelper {
    private static final String TAG = "LocationRequestHelper";
    private static final String VDR_ENABLE = "1";
    private static final String VDR_GNSS_OPTION = "vdrEnable";

    public static void assertNoNull(Object obj) throws ApiException {
        if (obj == null) {
            throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        }
    }

    private static void buildRequestEntity(String str, LocationRequest locationRequest, LocationCallback locationCallback, RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        requestLocationUpdatesRequest.setLocationRequest(locationRequest);
        if (!TextUtils.equals(str, "Intent")) {
            requestLocationUpdatesRequest.setUuid(locationCallback.getUuid());
        }
        if (TextUtils.equals(str, "ExCallback")) {
            locationRequest.putExtras("productId", getProductId());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: com.huawei.hms.locationSdk.a1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: com.huawei.hms.locationSdk.a1} */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b2  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.huawei.hms.locationSdk.h0 buildTaskApiCall(java.lang.String r15, com.huawei.hms.location.LocationCallback r16, android.os.Looper r17, android.app.PendingIntent r18, com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest r19, com.huawei.hms.locationSdk.e0 r20, java.lang.String r21) throws com.huawei.hms.common.ApiException {
        /*
            r0 = r15
            java.lang.String r8 = r19.getTid()
            int r1 = r15.hashCode()
            r2 = -2099895620(0xffffffff82d622bc, float:-3.146441E-37)
            r3 = 1
            if (r1 == r2) goto L_0x002e
            r2 = -1598699650(0xffffffffa0b5c77e, float:-3.0794606E-19)
            if (r1 == r2) goto L_0x0024
            r2 = 1366690360(0x51760a38, float:6.6045837E10)
            if (r1 == r2) goto L_0x001a
            goto L_0x0038
        L_0x001a:
            java.lang.String r1 = "ExCallback"
            boolean r0 = r15.equals(r1)
            if (r0 == 0) goto L_0x0038
            r0 = 0
            goto L_0x0039
        L_0x0024:
            java.lang.String r1 = "NORMAL Callback"
            boolean r0 = r15.equals(r1)
            if (r0 == 0) goto L_0x0038
            r0 = 2
            goto L_0x0039
        L_0x002e:
            java.lang.String r1 = "Intent"
            boolean r0 = r15.equals(r1)
            if (r0 == 0) goto L_0x0038
            r0 = r3
            goto L_0x0039
        L_0x0038:
            r0 = -1
        L_0x0039:
            java.lang.String r9 = ", Version Code = "
            java.lang.String r10 = ", tid="
            java.lang.String r11 = "requestLocationUpdates with callback uuid="
            java.lang.String r12 = "LocationRequestHelper"
            r13 = 60700300(0x39e368c, float:9.298929E-37)
            if (r0 == 0) goto L_0x00b2
            if (r0 == r3) goto L_0x007d
            com.huawei.hms.locationSdk.a1 r7 = new com.huawei.hms.locationSdk.a1
            java.lang.String r1 = "location.requestLocationUpdates"
            java.lang.String r6 = ""
            r0 = r7
            r2 = r21
            r3 = r8
            r4 = r20
            r5 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6)
            android.os.Bundle r0 = com.huawei.hms.support.api.entity.location.binder.InnerBinder.getInnerBinder()
            r7.setParcelable(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x0065:
            r0.append(r11)
            java.lang.String r1 = r16.getUuid()
            r0.append(r1)
            r0.append(r10)
            java.lang.String r1 = r19.getTid()
            r0.append(r1)
            r0.append(r9)
            goto L_0x00a7
        L_0x007d:
            com.huawei.hms.locationSdk.b1 r7 = new com.huawei.hms.locationSdk.b1
            java.lang.String r1 = "location.requestLocationUpdates"
            java.lang.String r5 = ""
            r0 = r7
            r2 = r21
            r3 = r8
            r4 = r20
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = r18
            r7.setParcelable(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "requestLocationUpdates with intent tid = "
            r0.append(r1)
            java.lang.String r1 = r19.getTid()
            r0.append(r1)
            java.lang.String r1 = " Version Code = "
            r0.append(r1)
        L_0x00a7:
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            com.huawei.hms.support.api.location.common.HMSLocationLog.i(r12, r8, r0)
            goto L_0x00ee
        L_0x00b2:
            boolean r0 = isVdrEnable(r19)
            if (r0 == 0) goto L_0x00cf
            com.huawei.hms.locationSdk.z0 r14 = new com.huawei.hms.locationSdk.z0
            java.lang.String r7 = r19.getPackageName()
            java.lang.String r1 = "location.requestLocationUpdatesEx"
            java.lang.String r6 = ""
            r0 = r14
            r2 = r21
            r3 = r8
            r4 = r20
            r5 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r7 = r14
            goto L_0x00e0
        L_0x00cf:
            com.huawei.hms.locationSdk.y0 r7 = new com.huawei.hms.locationSdk.y0
            java.lang.String r1 = "location.requestLocationUpdatesEx"
            java.lang.String r6 = ""
            r0 = r7
            r2 = r21
            r3 = r8
            r4 = r20
            r5 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6)
        L_0x00e0:
            android.os.Bundle r0 = com.huawei.hms.support.api.entity.location.binder.InnerBinder.getInnerBinder()
            r7.setParcelable(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x0065
        L_0x00ee:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.api.location.common.LocationRequestHelper.buildTaskApiCall(java.lang.String, com.huawei.hms.location.LocationCallback, android.os.Looper, android.app.PendingIntent, com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest, com.huawei.hms.locationSdk.e0, java.lang.String):com.huawei.hms.locationSdk.h0");
    }

    private static void checkLocationPermission() throws ApiException {
        if (!PermissionUtil.isLocationPermissionAvailable(ContextUtil.getContext())) {
            throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
        }
    }

    private static void checkMethodSupport(String str) throws ApiException {
        if (TextUtils.equals(str, "Intent") && !j1.a(ContextUtil.getContext())) {
            throw new ApiException(new Status(10806, LocationStatusCode.getStatusCodeString(10806)));
        }
    }

    private static void checkPriority(String str, LocationRequest locationRequest) throws ApiException {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2099895620:
                if (str.equals("Intent")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1598699650:
                if (str.equals("NORMAL Callback")) {
                    c11 = 1;
                    break;
                }
                break;
            case 1366690360:
                if (str.equals("ExCallback")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
                if (locationRequest.getPriority() == 200 || locationRequest.getPriority() == 300) {
                    throw new ApiException(new Status(LocationStatusCode.METHOD_INVOKE_ERROR, LocationStatusCode.getStatusCodeString(LocationStatusCode.METHOD_INVOKE_ERROR)));
                }
                return;
            case 2:
                if (locationRequest.getPriority() == 200) {
                    locationRequest.setNeedAddress(false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void checkRemoveRequestParam(com.huawei.hms.location.LocationCallback r2, android.app.PendingIntent r3, java.lang.String r4) throws com.huawei.hms.common.ApiException {
        /*
            int r0 = r4.hashCode()
            r1 = -2099895620(0xffffffff82d622bc, float:-3.146441E-37)
            if (r0 == r1) goto L_0x0019
            r1 = -1598699650(0xffffffffa0b5c77e, float:-3.0794606E-19)
            if (r0 == r1) goto L_0x000f
            goto L_0x0023
        L_0x000f:
            java.lang.String r0 = "NORMAL Callback"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0023
            r4 = 1
            goto L_0x0024
        L_0x0019:
            java.lang.String r0 = "Intent"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0023
            r4 = 0
            goto L_0x0024
        L_0x0023:
            r4 = -1
        L_0x0024:
            if (r4 == 0) goto L_0x002a
            assertNoNull(r2)
            goto L_0x002d
        L_0x002a:
            assertNoNull(r3)
        L_0x002d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.api.location.common.LocationRequestHelper.checkRemoveRequestParam(com.huawei.hms.location.LocationCallback, android.app.PendingIntent, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void checkRequestParam(java.lang.String r3, com.huawei.hms.location.LocationRequest r4, com.huawei.hms.location.LocationCallback r5, android.os.Looper r6, android.app.PendingIntent r7) throws com.huawei.hms.common.ApiException {
        /*
            assertNoNull(r4)
            int r0 = r3.hashCode()
            r1 = -2099895620(0xffffffff82d622bc, float:-3.146441E-37)
            r2 = 1
            if (r0 == r1) goto L_0x002c
            r1 = -1598699650(0xffffffffa0b5c77e, float:-3.0794606E-19)
            if (r0 == r1) goto L_0x0022
            r1 = 1366690360(0x51760a38, float:6.6045837E10)
            if (r0 == r1) goto L_0x0018
            goto L_0x0036
        L_0x0018:
            java.lang.String r0 = "ExCallback"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0036
            r3 = 2
            goto L_0x0037
        L_0x0022:
            java.lang.String r0 = "NORMAL Callback"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0036
            r3 = r2
            goto L_0x0037
        L_0x002c:
            java.lang.String r0 = "Intent"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0036
            r3 = 0
            goto L_0x0037
        L_0x0036:
            r3 = -1
        L_0x0037:
            if (r3 == 0) goto L_0x0040
            assertNoNull(r5)
            assertNoNull(r6)
            goto L_0x0043
        L_0x0040:
            assertNoNull(r7)
        L_0x0043:
            int r3 = r4.getNumUpdates()
            r5 = 10802(0x2a32, float:1.5137E-41)
            if (r3 <= 0) goto L_0x0068
            int r3 = r4.getCoordinateType()
            if (r3 == 0) goto L_0x0067
            int r3 = r4.getCoordinateType()
            if (r3 != r2) goto L_0x0058
            goto L_0x0067
        L_0x0058:
            com.huawei.hms.common.ApiException r3 = new com.huawei.hms.common.ApiException
            com.huawei.hms.support.api.client.Status r4 = new com.huawei.hms.support.api.client.Status
            java.lang.String r6 = com.huawei.hms.support.api.location.common.exception.LocationStatusCode.getStatusCodeString(r5)
            r4.<init>(r5, r6)
            r3.<init>(r4)
            throw r3
        L_0x0067:
            return
        L_0x0068:
            com.huawei.hms.common.ApiException r3 = new com.huawei.hms.common.ApiException
            com.huawei.hms.support.api.client.Status r4 = new com.huawei.hms.support.api.client.Status
            java.lang.String r6 = com.huawei.hms.support.api.location.common.exception.LocationStatusCode.getStatusCodeString(r5)
            r4.<init>(r5, r6)
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.api.location.common.LocationRequestHelper.checkRequestParam(java.lang.String, com.huawei.hms.location.LocationRequest, com.huawei.hms.location.LocationCallback, android.os.Looper, android.app.PendingIntent):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0059  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.huawei.hms.locationSdk.e0 createRemoveLocationUpdatesCache(com.huawei.hms.location.LocationCallback r8, android.app.PendingIntent r9, java.lang.String r10, java.lang.String r11) throws com.huawei.hms.common.ApiException {
        /*
            checkRemoveRequestParam(r8, r9, r10)
            com.huawei.hms.locationSdk.e0 r7 = new com.huawei.hms.locationSdk.e0
            r1 = 0
            r4 = 0
            r0 = r7
            r2 = r9
            r3 = r8
            r5 = r11
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            com.huawei.hms.locationSdk.d0 r8 = com.huawei.hms.locationSdk.d0.b()
            com.huawei.hms.locationSdk.b0 r8 = r8.b(r7)
            com.huawei.hms.locationSdk.e0 r8 = (com.huawei.hms.locationSdk.e0) r8
            if (r8 != 0) goto L_0x006f
            int r8 = r10.hashCode()
            r9 = -2099895620(0xffffffff82d622bc, float:-3.146441E-37)
            if (r8 == r9) goto L_0x0034
            r9 = -1598699650(0xffffffffa0b5c77e, float:-3.0794606E-19)
            if (r8 == r9) goto L_0x002a
            goto L_0x003e
        L_0x002a:
            java.lang.String r8 = "NORMAL Callback"
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto L_0x003e
            r8 = 1
            goto L_0x003f
        L_0x0034:
            java.lang.String r8 = "Intent"
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto L_0x003e
            r8 = 0
            goto L_0x003f
        L_0x003e:
            r8 = -1
        L_0x003f:
            java.lang.String r9 = "LocationRequestHelper"
            if (r8 == 0) goto L_0x0059
            java.lang.String r8 = "remove location updates with callback cannot find callback"
            com.huawei.hms.support.api.location.common.HMSLocationLog.e(r9, r11, r8)
            com.huawei.hms.common.ApiException r8 = new com.huawei.hms.common.ApiException
            com.huawei.hms.support.api.client.Status r9 = new com.huawei.hms.support.api.client.Status
            r10 = 10804(0x2a34, float:1.514E-41)
            java.lang.String r11 = com.huawei.hms.support.api.location.common.exception.LocationStatusCode.getStatusCodeString(r10)
            r9.<init>(r10, r11)
            r8.<init>(r9)
            throw r8
        L_0x0059:
            java.lang.String r8 = "remove location updates with intent cannot find intent"
            com.huawei.hms.support.api.location.common.HMSLocationLog.e(r9, r11, r8)
            com.huawei.hms.common.ApiException r8 = new com.huawei.hms.common.ApiException
            com.huawei.hms.support.api.client.Status r9 = new com.huawei.hms.support.api.client.Status
            r10 = 10805(0x2a35, float:1.5141E-41)
            java.lang.String r11 = com.huawei.hms.support.api.location.common.exception.LocationStatusCode.getStatusCodeString(r10)
            r9.<init>(r10, r11)
            r8.<init>(r9)
            throw r8
        L_0x006f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.api.location.common.LocationRequestHelper.createRemoveLocationUpdatesCache(com.huawei.hms.location.LocationCallback, android.app.PendingIntent, java.lang.String, java.lang.String):com.huawei.hms.locationSdk.e0");
    }

    public static h0 createRemoveTaskApiCall(LocationCallback locationCallback, PendingIntent pendingIntent, String str, String str2, RemoveLocationUpdatesRequest removeLocationUpdatesRequest) throws ApiException {
        e0 createRemoveLocationUpdatesCache = createRemoveLocationUpdatesCache(locationCallback, pendingIntent, str, str2);
        String a11 = createRemoveLocationUpdatesCache.a();
        removeLocationUpdatesRequest.setTid(a11);
        if (TextUtils.equals(str, "NORMAL Callback")) {
            removeLocationUpdatesRequest.setUuid(locationCallback.getUuid());
        }
        v0 v0Var = new v0("location.removeLocationUpdates", JsonUtil.createJsonString(removeLocationUpdatesRequest), a11, createRemoveLocationUpdatesCache, "");
        if (TextUtils.equals(str, "Intent")) {
            v0Var.setParcelable(pendingIntent);
        }
        HMSLocationLog.i(TAG, a11, str + " removeLocationUpdates tid =" + a11 + " Version Code = " + 60700300);
        return v0Var;
    }

    public static h0 createRequestApiCall(String str, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper, PendingIntent pendingIntent, RequestLocationUpdatesRequest requestLocationUpdatesRequest) throws ApiException {
        checkMethodSupport(str);
        checkRequestParam(str, locationRequest, locationCallback, looper, pendingIntent);
        checkLocationPermission();
        checkPriority(str, locationRequest);
        buildRequestEntity(str, locationRequest, locationCallback, requestLocationUpdatesRequest);
        e0 e0Var = new e0(locationRequest, pendingIntent, locationCallback, looper, requestLocationUpdatesRequest.getTid(), str);
        return buildTaskApiCall(str, locationCallback, looper, pendingIntent, requestLocationUpdatesRequest, e0Var, JsonUtil.createJsonString(requestLocationUpdatesRequest));
    }

    private static String getOption(RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        Map<String, String> extras = requestLocationUpdatesRequest.getLocationRequest().getExtras();
        String str = extras != null ? extras.get("vdrEnable") : "";
        LogConsole.i(TAG, "vdrEnable is: " + str);
        return str;
    }

    private static String getProductId() {
        try {
            return AGConnectServicesConfig.fromContext(ContextUtil.getContext()).getString("client/product_id");
        } catch (Exception unused) {
            HMSLog.e(TAG, "get agc productId by exception");
            return "";
        }
    }

    private static boolean isVdrEnable(RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        String str;
        if (requestLocationUpdatesRequest.getLocationRequest().getPriority() != 200) {
            str = "do not support vdr, priority is: " + requestLocationUpdatesRequest.getLocationRequest().getPriority();
        } else if (!ReflectionUtils.isSupportClass("com.huawei.location.vdr.VdrManager")) {
            str = "no vdr module, do not support vdr";
        } else if (Build.VERSION.SDK_INT >= 24) {
            return TextUtils.equals(getOption(requestLocationUpdatesRequest), "1");
        } else {
            str = "SDK_INT less than N, do not support vdr";
        }
        LogConsole.i(TAG, str);
        return false;
    }
}
