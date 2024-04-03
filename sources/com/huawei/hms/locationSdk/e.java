package com.huawei.hms.locationSdk;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.Gson;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.location.ActivityConversionInfo;
import com.huawei.hms.location.ActivityConversionRequest;
import com.huawei.hms.location.ActivityIdentificationData;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.activityrecognition.RequestActivityConversionRequest;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import com.huawei.hms.support.api.location.common.CollectionsUtil;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.PermissionUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.location.lite.common.util.GsonUtil;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

@Instrumented
public class e extends HuaweiApi<w> implements c {

    /* renamed from: b  reason: collision with root package name */
    private static final d f49163b = new d();

    /* renamed from: c  reason: collision with root package name */
    private static final Api<w> f49164c = new Api<>("HmsLocation.API");

    /* renamed from: a  reason: collision with root package name */
    private f1 f49165a;

    public e(Activity activity, w wVar) {
        super(activity, f49164c, wVar, (AbstractClientBuilder) f49163b);
    }

    public e(Context context, w wVar) {
        super(context, f49164c, wVar, (AbstractClientBuilder) f49163b);
    }

    private void a(String str) throws ApiException {
        if (Build.VERSION.SDK_INT <= 28) {
            if (j1.a(getContext()) && !PermissionUtil.isPermissionAvailable(getContext(), "com.huawei.hms.permission.ACTIVITY_RECOGNITION")) {
                HMSLocationLog.e("LocationArClientImpl", str, "requestActivityUpdates isPermissionAvailable is false ");
                throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
            }
        } else if (!PermissionUtil.isPermissionAvailable(getContext(), "android.permission.ACTIVITY_RECOGNITION")) {
            HMSLocationLog.e("LocationArClientImpl", str, "android Q requestActivityUpdates isPermissionAvailable is false ");
            throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
        }
    }

    public Task<Void> a(long j11, PendingIntent pendingIntent) {
        String uuid = UUID.randomUUID().toString();
        HMSLocationLog.i("LocationArClientImpl", uuid, "createActivityIdentificationUpdates begin");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (pendingIntent != null) {
            try {
                a(uuid);
                if (j11 >= 0) {
                    z zVar = new z();
                    zVar.a(pendingIntent);
                    zVar.a(uuid);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("detectionIntervalMillis", j11);
                    jSONObject.put("locTransactionId", (Object) uuid);
                    jSONObject.put(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, (Object) getContext().getPackageName());
                    x0 x0Var = new x0("location.requestActivityIdentificationUpdates", JSONObjectInstrumentation.toString(jSONObject), zVar);
                    x0Var.setParcelable(pendingIntent);
                    return doWrite(x0Var);
                }
                throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
            } catch (ApiException e11) {
                e = e11;
                HMSLocationLog.e("LocationArClientImpl", uuid, "createActivityIdentificationUpdates api exception:" + e.getMessage());
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            } catch (Exception unused) {
                HMSLocationLog.e("LocationArClientImpl", uuid, "createActivityIdentificationUpdates exception");
                e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            }
        } else {
            throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        }
    }

    public Task<Void> a(PendingIntent pendingIntent) {
        LocationBaseRequest locationBaseRequest = new LocationBaseRequest(getContext());
        String tid = locationBaseRequest.getTid();
        HMSLocationLog.i("LocationArClientImpl", tid, "deleteActivityIdentificationUpdates begin");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (pendingIntent != null) {
            try {
                z zVar = new z();
                zVar.a(pendingIntent);
                z zVar2 = (z) a0.b().b(zVar);
                if (zVar2 != null) {
                    HMSLocationLog.e("LocationArClientImpl", tid, "deleteActivityIdentificationUpdates cannot find cache");
                    tid = zVar2.a();
                }
                locationBaseRequest.setTid(tid);
                zVar.a(tid);
                t0 t0Var = new t0("location.removeActivityIdentificationUpdates", JsonUtil.createJsonString(locationBaseRequest), zVar);
                t0Var.setParcelable(pendingIntent);
                return doWrite(t0Var);
            } catch (ApiException e11) {
                e = e11;
                HMSLocationLog.e("LocationArClientImpl", tid, "deleteActivityIdentificationUpdates api exception:" + e.getMessage());
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            } catch (Exception unused) {
                HMSLocationLog.e("LocationArClientImpl", tid, "deleteActivityIdentificationUpdates exception");
                e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            }
        } else {
            throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        }
    }

    public Task<Void> a(ActivityConversionRequest activityConversionRequest, PendingIntent pendingIntent) {
        String str;
        RequestActivityConversionRequest requestActivityConversionRequest = new RequestActivityConversionRequest(getContext());
        String tid = requestActivityConversionRequest.getTid();
        HMSLocationLog.i("LocationArClientImpl", tid, "createActivityConversionUpdates begin");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (activityConversionRequest == null || pendingIntent == null) {
            throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        }
        try {
            a(tid);
            List<ActivityConversionInfo> activityConversions = activityConversionRequest.getActivityConversions();
            if (!CollectionsUtil.isEmpty((Collection<?>) activityConversions)) {
                for (ActivityConversionInfo next : activityConversions) {
                    int conversionType = next.getConversionType();
                    int activityType = next.getActivityType();
                    if (conversionType != 0) {
                        if (conversionType != 1) {
                            throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
                        }
                    }
                    if (!ActivityIdentificationData.isValidType(activityType)) {
                        throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
                    }
                }
            }
            x xVar = new x();
            xVar.a(pendingIntent);
            xVar.a(tid);
            requestActivityConversionRequest.setActivityConversions(activityConversionRequest.getActivityConversions());
            if (j1.a(getContext())) {
                str = JsonUtil.createJsonString(requestActivityConversionRequest);
            } else {
                Gson instance = GsonUtil.getInstance();
                str = !(instance instanceof Gson) ? instance.toJson((Object) requestActivityConversionRequest) : GsonInstrumentation.toJson(instance, (Object) requestActivityConversionRequest);
            }
            w0 w0Var = new w0("location.requestActivityConversionUpdates", str, xVar);
            w0Var.setParcelable(pendingIntent);
            return doWrite(w0Var);
        } catch (ApiException e11) {
            e = e11;
            HMSLocationLog.e("LocationArClientImpl", tid, "createActivityConversionUpdates api exception");
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationArClientImpl", tid, "createActivityConversionUpdates exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    public Task<Void> b(PendingIntent pendingIntent) {
        LocationBaseRequest locationBaseRequest = new LocationBaseRequest(getContext());
        String tid = locationBaseRequest.getTid();
        HMSLocationLog.i("LocationArClientImpl", tid, "deleteActivityConversionUpdates begin");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (pendingIntent != null) {
            try {
                x xVar = new x();
                xVar.a(pendingIntent);
                x xVar2 = (x) y.b().b(xVar);
                if (xVar2 != null) {
                    HMSLocationLog.e("LocationArClientImpl", tid, "deleteActivityConversionUpdates cannot find cache");
                    tid = xVar2.a();
                }
                locationBaseRequest.setTid(tid);
                xVar.a(tid);
                s0 s0Var = new s0("location.removeActivityConversionUpdates", JsonUtil.createJsonString(locationBaseRequest), xVar);
                s0Var.setParcelable(pendingIntent);
                return doWrite(s0Var);
            } catch (ApiException e11) {
                e = e11;
                HMSLocationLog.e("LocationArClientImpl", tid, "deleteActivityConversionUpdates api exception:" + e.getMessage());
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            } catch (Exception unused) {
                HMSLocationLog.e("LocationArClientImpl", tid, "deleteActivityConversionUpdates exception");
                e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            }
        } else {
            throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0023, code lost:
        r0 = r2.f49165a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <TResult, TClient extends com.huawei.hms.common.internal.AnyClient> com.huawei.hmf.tasks.Task<TResult> doWrite(com.huawei.hms.common.internal.TaskApiCall<TClient, TResult> r3) {
        /*
            r2 = this;
            com.huawei.hms.locationSdk.f1 r0 = r2.f49165a
            if (r0 != 0) goto L_0x0019
            android.content.Context r0 = r2.getContext()
            com.huawei.hms.locationSdk.j1 r1 = new com.huawei.hms.locationSdk.j1
            r1.<init>()
            java.lang.Object r0 = com.huawei.hms.locationSdk.i1.a(r0, r1)
            boolean r1 = r0 instanceof com.huawei.hms.locationSdk.f1
            if (r1 == 0) goto L_0x0019
            com.huawei.hms.locationSdk.f1 r0 = (com.huawei.hms.locationSdk.f1) r0
            r2.f49165a = r0
        L_0x0019:
            android.content.Context r0 = r2.getContext()
            boolean r0 = com.huawei.hms.locationSdk.j1.a(r0)
            if (r0 != 0) goto L_0x002f
            com.huawei.hms.locationSdk.f1 r0 = r2.f49165a
            if (r0 != 0) goto L_0x0028
            goto L_0x002f
        L_0x0028:
            com.huawei.hms.locationSdk.d r1 = f49163b
            com.huawei.hmf.tasks.Task r3 = r0.a(r2, r3, r1)
            return r3
        L_0x002f:
            com.huawei.hmf.tasks.Task r3 = super.doWrite(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.locationSdk.e.doWrite(com.huawei.hms.common.internal.TaskApiCall):com.huawei.hmf.tasks.Task");
    }

    public int getKitSdkVersion() {
        return 60700300;
    }
}
