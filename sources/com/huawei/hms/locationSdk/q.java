package com.huawei.hms.locationSdk;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.api.CommonStatusCodes;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.location.GeofenceRequest;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import com.huawei.hms.support.api.entity.location.fence.AddGeofencesRequest;
import com.huawei.hms.support.api.entity.location.fence.RemoveGeofencesRequest;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.PermissionUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.utils.JsonUtil;
import java.util.List;

public class q extends HuaweiApi<w> implements o {

    /* renamed from: b  reason: collision with root package name */
    private static final p f49208b = new p();

    /* renamed from: c  reason: collision with root package name */
    private static final Api<w> f49209c = new Api<>("HmsLocation.API");

    /* renamed from: a  reason: collision with root package name */
    private f1 f49210a;

    public q(Activity activity, w wVar) {
        super(activity, f49209c, wVar, (AbstractClientBuilder) f49208b);
    }

    public q(Context context, w wVar) {
        super(context, f49209c, wVar, (AbstractClientBuilder) f49208b);
    }

    public Task<Void> a(PendingIntent pendingIntent) {
        long currentTimeMillis = System.currentTimeMillis();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        LocationBaseRequest locationBaseRequest = new LocationBaseRequest(getContext());
        String tid = locationBaseRequest.getTid();
        if (pendingIntent != null) {
            try {
                u0 u0Var = new u0("location.removeGeofences", JsonUtil.createJsonString(locationBaseRequest), tid);
                u0Var.setParcelable(pendingIntent);
                Task<Void> doWrite = doWrite(u0Var);
                long currentTimeMillis2 = System.currentTimeMillis();
                HMSLocationLog.i("LocationGeofenceClientImpl", tid, "removeGeofences sdk useTime:" + (currentTimeMillis2 - currentTimeMillis));
                return doWrite;
            } catch (ApiException e11) {
                HMSLocationLog.e("LocationGeofenceClientImpl", tid, "removeGeofences api exception:" + e11.getMessage());
                taskCompletionSource.setException(e11);
                long currentTimeMillis3 = System.currentTimeMillis();
                HMSLocationLog.i("LocationGeofenceClientImpl", tid, "removeGeofences sdk useTime:" + (currentTimeMillis3 - currentTimeMillis));
                return taskCompletionSource.getTask();
            }
        } else {
            throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        }
    }

    public Task<Void> a(GeofenceRequest geofenceRequest, PendingIntent pendingIntent) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        AddGeofencesRequest addGeofencesRequest = new AddGeofencesRequest(getContext());
        String tid = addGeofencesRequest.getTid();
        if (geofenceRequest == null || pendingIntent == null) {
            throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        }
        try {
            if (PermissionUtil.isGeofencePermissionAvailable(getContext())) {
                addGeofencesRequest.setGeofencingRequest(geofenceRequest);
                g0 g0Var = new g0("location.addGeofences", JsonUtil.createJsonString(addGeofencesRequest), tid);
                g0Var.setParcelable(pendingIntent);
                return doWrite(g0Var);
            }
            throw new ApiException(new Status(10204, CommonStatusCodes.getStatusCodeString(10204)));
        } catch (ApiException e11) {
            HMSLocationLog.e("LocationGeofenceClientImpl", tid, "addGeofences api exception:" + e11.getMessage());
            taskCompletionSource.setException(e11);
            return taskCompletionSource.getTask();
        }
    }

    public Task<Void> a(List<String> list) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RemoveGeofencesRequest removeGeofencesRequest = new RemoveGeofencesRequest(getContext());
        String tid = removeGeofencesRequest.getTid();
        if (list != null) {
            try {
                if (list.size() != 0) {
                    removeGeofencesRequest.setGeofenceRequestIds(list);
                    return doWrite(new u0("location.removeGeofences", JsonUtil.createJsonString(removeGeofencesRequest), tid));
                }
            } catch (ApiException e11) {
                HMSLocationLog.e("LocationGeofenceClientImpl", tid, "removeGeofences api exception:" + e11.getMessage());
                taskCompletionSource.setException(e11);
                return taskCompletionSource.getTask();
            }
        }
        throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0023, code lost:
        r0 = r2.f49210a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <TResult, TClient extends com.huawei.hms.common.internal.AnyClient> com.huawei.hmf.tasks.Task<TResult> doWrite(com.huawei.hms.common.internal.TaskApiCall<TClient, TResult> r3) {
        /*
            r2 = this;
            com.huawei.hms.locationSdk.f1 r0 = r2.f49210a
            if (r0 != 0) goto L_0x0019
            android.content.Context r0 = r2.getContext()
            com.huawei.hms.locationSdk.j1 r1 = new com.huawei.hms.locationSdk.j1
            r1.<init>()
            java.lang.Object r0 = com.huawei.hms.locationSdk.i1.a(r0, r1)
            boolean r1 = r0 instanceof com.huawei.hms.locationSdk.f1
            if (r1 == 0) goto L_0x0019
            com.huawei.hms.locationSdk.f1 r0 = (com.huawei.hms.locationSdk.f1) r0
            r2.f49210a = r0
        L_0x0019:
            android.content.Context r0 = r2.getContext()
            boolean r0 = com.huawei.hms.locationSdk.j1.a(r0)
            if (r0 != 0) goto L_0x002f
            com.huawei.hms.locationSdk.f1 r0 = r2.f49210a
            if (r0 != 0) goto L_0x0028
            goto L_0x002f
        L_0x0028:
            com.huawei.hms.locationSdk.p r1 = f49208b
            com.huawei.hmf.tasks.Task r3 = r0.a(r2, r3, r1)
            return r3
        L_0x002f:
            com.huawei.hmf.tasks.Task r3 = super.doWrite(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.locationSdk.q.doWrite(com.huawei.hms.common.internal.TaskApiCall):com.huawei.hmf.tasks.Task");
    }

    public int getKitSdkVersion() {
        return 60700300;
    }
}
