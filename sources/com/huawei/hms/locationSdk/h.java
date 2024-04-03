package com.huawei.hms.locationSdk;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.Gson;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationSettingsRequest;
import com.huawei.hms.location.LocationSettingsResponse;
import com.huawei.hms.location.LogConfig;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.checksettings.CheckLocationSettingsRequest;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import com.huawei.hms.support.api.entity.location.common.LocationNaming;
import com.huawei.hms.support.api.entity.location.lastlocation.GetLastLocationRequest;
import com.huawei.hms.support.api.entity.location.mock.SetMockLocationRequest;
import com.huawei.hms.support.api.entity.location.mock.SetMockModeRequest;
import com.huawei.hms.support.api.entity.location.offlinelocation.OfflineLocationRequest;
import com.huawei.hms.support.api.entity.location.offlinelocation.OfflineLocationResponse;
import com.huawei.hms.support.api.entity.location.updates.RemoveLocationUpdatesRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import com.huawei.hms.support.api.location.common.LocationRequestHelper;
import com.huawei.hms.support.api.location.common.PermissionUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.logwrite.LogWriteApi;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.req.BackgroundReq;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.UUID;
import org.json.JSONObject;

@Instrumented
public class h extends HuaweiApi<w> implements f {

    /* renamed from: b  reason: collision with root package name */
    private static final g f49186b = new g();

    /* renamed from: c  reason: collision with root package name */
    private static final Api<w> f49187c = new Api<>("HmsLocation.API");

    /* renamed from: a  reason: collision with root package name */
    private f1 f49188a;

    public h(Activity activity, w wVar) {
        super(activity, f49187c, wVar, (AbstractClientBuilder) f49186b);
        a((Context) activity);
    }

    public h(Context context, w wVar) {
        super(context, f49187c, wVar, (AbstractClientBuilder) f49186b);
        a(context);
    }

    private Task<Void> a(LocationCallback locationCallback, PendingIntent pendingIntent, String str) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RemoveLocationUpdatesRequest removeLocationUpdatesRequest = new RemoveLocationUpdatesRequest(getContext());
        String tid = removeLocationUpdatesRequest.getTid();
        try {
            HMSLocationLog.i("LocationClientImpl", tid, str + " removeLocationUpdates  begin");
            return doWrite(LocationRequestHelper.createRemoveTaskApiCall(locationCallback, pendingIntent, str, tid, removeLocationUpdatesRequest));
        } catch (ApiException e11) {
            e = e11;
            HMSLocationLog.e("LocationClientImpl", tid, str + " remove location updates api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationClientImpl", tid, str + " remove location updates exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    private Task<Void> a(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper, PendingIntent pendingIntent, String str) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RequestLocationUpdatesRequest requestLocationUpdatesRequest = new RequestLocationUpdatesRequest(getContext());
        String tid = requestLocationUpdatesRequest.getTid();
        try {
            HMSLocationLog.i("LocationClientImpl", tid, str + " requestLocationUpdates begin");
            return doWrite(LocationRequestHelper.createRequestApiCall(str, locationRequest, locationCallback, looper, pendingIntent, requestLocationUpdatesRequest));
        } catch (ApiException e11) {
            e = e11;
            HMSLocationLog.e("LocationClientImpl", tid, str + " requestLocationUpdates api exception" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationClientImpl", tid, str + " requestLocationUpdates exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    private void a(Context context) {
        ContextUtil.setContext(context);
    }

    private void b(LocationRequest locationRequest) throws ApiException {
        if (locationRequest.getCoordinateType() != 0 && locationRequest.getCoordinateType() != 1) {
            throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
        }
    }

    private void e() throws ApiException {
        if (!PermissionUtil.isLocationPermissionAvailable(getContext())) {
            throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
        }
    }

    public Task<Void> a() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(new ApiException(new Status(10806, LocationStatusCode.getStatusCodeString(10806))));
        return taskCompletionSource.getTask();
    }

    public Task<Void> a(int i11, Notification notification) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (j1.a(getContext())) {
            e = new ApiException(new Status(10806, LocationStatusCode.getStatusCodeString(10806)));
        } else {
            BackgroundReq backgroundReq = new BackgroundReq(getContext());
            String tid = backgroundReq.getTid();
            try {
                HMSLocationLog.i("LocationClientImpl", tid, "enableBackgroundLocation");
                if (i11 == 0) {
                    throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
                } else if (notification != null) {
                    if (Build.VERSION.SDK_INT >= 28) {
                        if (!PermissionUtil.isPermissionAvailable(getContext(), "android.permission.FOREGROUND_SERVICE")) {
                            throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
                        }
                    }
                    backgroundReq.setNotificationId(i11);
                    k0 k0Var = new k0("location.enableBackgroundLocation", JsonUtil.createJsonString(backgroundReq), tid);
                    k0Var.setParcelable(notification);
                    return doWrite(k0Var);
                } else {
                    throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
                }
            } catch (ApiException e11) {
                e = e11;
                HMSLocationLog.e("LocationClientImpl", tid, "enable background location api exception:" + e.getMessage());
            }
        }
        taskCompletionSource.setException(e);
        return taskCompletionSource.getTask();
    }

    public Task<Void> a(PendingIntent pendingIntent) {
        return a((LocationCallback) null, pendingIntent, "Intent");
    }

    public Task<Void> a(Location location) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        SetMockLocationRequest setMockLocationRequest = new SetMockLocationRequest(getContext());
        String tid = setMockLocationRequest.getTid();
        try {
            HMSLocationLog.i("LocationClientImpl", tid, "set mock location begin");
            if (location == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            } else if (!PermissionUtil.isLocationPermissionAvailable(getContext()) || !PermissionUtil.canAccessMockLocation(getContext().getPackageName(), getContext())) {
                throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
            } else {
                setMockLocationRequest.setPackageName(getContext().getPackageName());
                setMockLocationRequest.setMockLocation(location);
                JSONObject createLocationJsonObject = LocationJsonUtil.createLocationJsonObject(setMockLocationRequest.getMockLocation());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mockLocation", (Object) createLocationJsonObject);
                jSONObject.put(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, (Object) setMockLocationRequest.getPackageName());
                jSONObject.put("locTransactionId", (Object) setMockLocationRequest.getTid());
                return doWrite(new d1("location.setMockLocation", JSONObjectInstrumentation.toString(jSONObject), tid));
            }
        } catch (ApiException e11) {
            e = e11;
            HMSLocationLog.e("LocationClientImpl", tid, "set mock location api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationClientImpl", tid, "set mock location exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    public Task<Void> a(LocationCallback locationCallback) {
        return a(locationCallback, (PendingIntent) null, "NORMAL Callback");
    }

    public Task<HWLocation> a(LocationRequest locationRequest) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GetLastLocationRequest getLastLocationRequest = new GetLastLocationRequest(getContext(), locationRequest.getNeedAddress(), locationRequest.getLanguage(), locationRequest.getCountryCode());
        String tid = getLastLocationRequest.getTid();
        try {
            HMSLocationLog.i("LocationClientImpl", tid, "get last location begin. Version Code = 60700300");
            e();
            b(locationRequest);
            return doWrite(new n0("location.getLastLocation", JsonUtil.createJsonString(getLastLocationRequest), getLastLocationRequest.getTid(), "", locationRequest.getCoordinateType()));
        } catch (ApiException e11) {
            e = e11;
            HMSLocationLog.e("LocationClientImpl", tid, "get last location with address api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationClientImpl", tid, "get last location with address exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    public Task<Void> a(LocationRequest locationRequest, PendingIntent pendingIntent) {
        return a(locationRequest, (LocationCallback) null, (Looper) null, pendingIntent, "Intent");
    }

    public Task<Void> a(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        return a(locationRequest, locationCallback, looper, (PendingIntent) null, "ExCallback");
    }

    public Task<LocationSettingsResponse> a(LocationSettingsRequest locationSettingsRequest) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        CheckLocationSettingsRequest checkLocationSettingsRequest = new CheckLocationSettingsRequest(getContext());
        String tid = checkLocationSettingsRequest.getTid();
        try {
            HMSLocationLog.i("LocationClientImpl", tid, "checkLocationSettings");
            if (locationSettingsRequest != null) {
                checkLocationSettingsRequest.setLocationSettingsRequest(locationSettingsRequest);
                return doWrite(new i0("location.checkLocationSettings", JsonUtil.createJsonString(checkLocationSettingsRequest), tid));
            }
            throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        } catch (ApiException e11) {
            e = e11;
            HMSLocationLog.e("LocationClientImpl", tid, "check location settings api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationClientImpl", tid, "check location settings exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    public Task<Void> a(LogConfig logConfig) {
        String uuid = UUID.randomUUID().toString();
        HMSLocationLog.i("LocationClientImpl", uuid, "setLogConfig start");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (logConfig != null) {
            try {
                HMSLocationLog.i("LocationClientImpl", uuid, "setLogConfig logConfig check");
                String logPath = logConfig.getLogPath();
                f0.a(getContext(), logPath, uuid);
                f0.a(logPath, uuid);
                LogWriteApi.init(f0.a(logConfig));
                if (f0.b()) {
                    LogWriteApi.i("LocationClientImpl", f0.a(getContext()), (Throwable) null);
                }
                return taskCompletionSource.getTask();
            } catch (ApiException e11) {
                e = e11;
                HMSLocationLog.e("LocationClientImpl", uuid, "setLogConfig apiException");
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            } catch (Exception unused) {
                HMSLocationLog.e("LocationClientImpl", uuid, "setLogConfig exception");
                e = new ApiException(new Status(LocationStatusCode.METHOD_INVOKE_ERROR, LocationStatusCode.getStatusCodeString(LocationStatusCode.METHOD_INVOKE_ERROR)));
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            }
        } else {
            throw new ApiException(new Status(10100, LocationStatusCode.getStatusCodeString(10100)));
        }
    }

    public Task<OfflineLocationResponse> a(OfflineLocationRequest offlineLocationRequest) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (offlineLocationRequest != null) {
            try {
                if (offlineLocationRequest.getRequestDataList() != null && !offlineLocationRequest.getRequestDataList().isEmpty()) {
                    String tid = offlineLocationRequest.getTid();
                    HMSLocationLog.i("LocationClientImpl", tid, "getOfflineLocation begin. Version Code = 60700300");
                    e();
                    Gson instance = GsonUtil.getInstance();
                    return doWrite(new r0(LocationNaming.GET_OFFLINE_LOCATION_NAME, !(instance instanceof Gson) ? instance.toJson((Object) offlineLocationRequest) : GsonInstrumentation.toJson(instance, (Object) offlineLocationRequest), tid));
                }
            } catch (ApiException e11) {
                e = e11;
                HMSLocationLog.e("LocationClientImpl", (String) null, "getOfflineLocation api exception:" + e.getMessage());
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            } catch (Exception unused) {
                HMSLocationLog.e("LocationClientImpl", (String) null, "getOfflineLocation exception");
                e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            }
        }
        throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
    }

    public Task<Void> a(boolean z11) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        String tid = new LocationBaseRequest(getContext()).getTid();
        try {
            HMSLocationLog.i("LocationClientImpl", tid, "set mock mode begin");
            if (!PermissionUtil.isLocationPermissionAvailable(getContext()) || !PermissionUtil.canAccessMockLocation(getContext().getPackageName(), getContext())) {
                HMSLocationLog.e("LocationClientImpl", tid, "setMockEnabled,Permission is false ");
                throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
            }
            SetMockModeRequest setMockModeRequest = new SetMockModeRequest(getContext());
            setMockModeRequest.setMockMode(z11);
            return doWrite(new e1("location.setMockMode", JsonUtil.createJsonString(setMockModeRequest), tid));
        } catch (ApiException e11) {
            e = e11;
            HMSLocationLog.e("LocationClientImpl", tid, "set mock mode api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationClientImpl", tid, "set mock mode exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    public Task<LocationAvailability> b() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        LocationBaseRequest locationBaseRequest = new LocationBaseRequest(getContext());
        String tid = locationBaseRequest.getTid();
        try {
            HMSLocationLog.i("LocationClientImpl", tid, "get location availability begin");
            e();
            return doWrite(new p0("location.getLocationAvailability", JsonUtil.createJsonString(locationBaseRequest), tid));
        } catch (ApiException e11) {
            HMSLocationLog.e("LocationClientImpl", tid, "getLocationAvailability ApiException:" + e11.getMessage());
            taskCompletionSource.setException(e11);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationClientImpl", tid, "getLocationAvailability exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
            return taskCompletionSource.getTask();
        }
    }

    public Task<Void> b(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        return a(locationRequest, locationCallback, looper, (PendingIntent) null, "NORMAL Callback");
    }

    public Task<Void> c() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (j1.a(getContext())) {
            taskCompletionSource.setException(new ApiException(new Status(10806, LocationStatusCode.getStatusCodeString(10806))));
            return taskCompletionSource.getTask();
        }
        String tid = new BackgroundReq(getContext()).getTid();
        HMSLocationLog.i("LocationClientImpl", tid, "disableBackgroundLocation");
        return doWrite(new j0("location.disableBackgroundLocation", "", tid));
    }

    public Task<Location> d() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        LocationBaseRequest locationBaseRequest = new LocationBaseRequest(getContext());
        String tid = locationBaseRequest.getTid();
        try {
            HMSLocationLog.i("LocationClientImpl", tid, "get last location begin. Version Code = 60700300");
            e();
            return doWrite(new o0("location.getLastLocation", JsonUtil.createJsonString(locationBaseRequest), locationBaseRequest.getTid(), ""));
        } catch (ApiException e11) {
            HMSLocationLog.e("LocationClientImpl", tid, "get last location api exception:" + e11.getMessage());
            taskCompletionSource.setException(e11);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationClientImpl", tid, "get last location exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
            return taskCompletionSource.getTask();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0023, code lost:
        r0 = r2.f49188a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <TResult, TClient extends com.huawei.hms.common.internal.AnyClient> com.huawei.hmf.tasks.Task<TResult> doWrite(com.huawei.hms.common.internal.TaskApiCall<TClient, TResult> r3) {
        /*
            r2 = this;
            com.huawei.hms.locationSdk.f1 r0 = r2.f49188a
            if (r0 != 0) goto L_0x0019
            android.content.Context r0 = r2.getContext()
            com.huawei.hms.locationSdk.j1 r1 = new com.huawei.hms.locationSdk.j1
            r1.<init>()
            java.lang.Object r0 = com.huawei.hms.locationSdk.i1.a(r0, r1)
            boolean r1 = r0 instanceof com.huawei.hms.locationSdk.f1
            if (r1 == 0) goto L_0x0019
            com.huawei.hms.locationSdk.f1 r0 = (com.huawei.hms.locationSdk.f1) r0
            r2.f49188a = r0
        L_0x0019:
            android.content.Context r0 = r2.getContext()
            boolean r0 = com.huawei.hms.locationSdk.j1.a(r0)
            if (r0 != 0) goto L_0x002f
            com.huawei.hms.locationSdk.f1 r0 = r2.f49188a
            if (r0 != 0) goto L_0x0028
            goto L_0x002f
        L_0x0028:
            com.huawei.hms.locationSdk.g r1 = f49186b
            com.huawei.hmf.tasks.Task r3 = r0.a(r2, r3, r1)
            return r3
        L_0x002f:
            com.huawei.hmf.tasks.Task r3 = super.doWrite(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.locationSdk.h.doWrite(com.huawei.hms.common.internal.TaskApiCall):com.huawei.hmf.tasks.Task");
    }

    public int getKitSdkVersion() {
        return 60700300;
    }
}
