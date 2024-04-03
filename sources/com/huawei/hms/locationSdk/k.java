package com.huawei.hms.locationSdk;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.location.NavigationRequest;
import com.huawei.hms.location.NavigationResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.enhance.RequestNavigationStateRequest;
import com.huawei.hms.support.api.entity.location.enhance.RequestReportLocationRequest;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.PermissionUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.utils.JsonUtil;

public class k extends HuaweiApi<w> implements i {

    /* renamed from: b  reason: collision with root package name */
    private static final j f49194b = new j();

    /* renamed from: c  reason: collision with root package name */
    private static final Api<w> f49195c = new Api<>("HmsLocation.API");

    /* renamed from: a  reason: collision with root package name */
    private f1 f49196a;

    public k(Activity activity, w wVar) {
        super(activity, f49195c, wVar, (AbstractClientBuilder) f49194b);
    }

    public k(Context context, w wVar) {
        super(context, f49195c, wVar, (AbstractClientBuilder) f49194b);
    }

    public Task<Void> a(Location location, String str) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RequestReportLocationRequest requestReportLocationRequest = new RequestReportLocationRequest(getContext());
        String tid = requestReportLocationRequest.getTid();
        if (!(location == null || str == null)) {
            try {
                if (!str.equals("")) {
                    requestReportLocationRequest.setReportType(str);
                    c1 c1Var = new c1("location.requestReportLocation", JsonUtil.createJsonString(requestReportLocationRequest), tid);
                    c1Var.setParcelable(location);
                    return doWrite(c1Var);
                }
            } catch (ApiException e11) {
                e = e11;
                HMSLocationLog.e("EnhanceClientImpl", tid, "requestReportLocation api exception:" + e.getMessage());
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            } catch (Exception unused) {
                HMSLocationLog.e("EnhanceClientImpl", tid, "requestReportLocation exception");
                e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            }
        }
        throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
    }

    public Task<NavigationResult> a(NavigationRequest navigationRequest) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RequestNavigationStateRequest requestNavigationStateRequest = new RequestNavigationStateRequest(getContext());
        String tid = requestNavigationStateRequest.getTid();
        if (navigationRequest != null) {
            try {
                if (PermissionUtil.isLocationPermissionAvailable(getContext())) {
                    requestNavigationStateRequest.setNavigationRequest(navigationRequest);
                    return doWrite(new q0("location.getNavigationContextState", JsonUtil.createJsonString(requestNavigationStateRequest), requestNavigationStateRequest.getTid()));
                }
                throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
            } catch (ApiException e11) {
                e = e11;
                HMSLocationLog.e("EnhanceClientImpl", tid, "getNavigationState api exception:" + e.getMessage());
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            } catch (Exception unused) {
                HMSLocationLog.e("EnhanceClientImpl", tid, "getNavigationState exception");
                e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            }
        } else {
            throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0023, code lost:
        r0 = r2.f49196a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <TResult, TClient extends com.huawei.hms.common.internal.AnyClient> com.huawei.hmf.tasks.Task<TResult> doWrite(com.huawei.hms.common.internal.TaskApiCall<TClient, TResult> r3) {
        /*
            r2 = this;
            com.huawei.hms.locationSdk.f1 r0 = r2.f49196a
            if (r0 != 0) goto L_0x0019
            android.content.Context r0 = r2.getContext()
            com.huawei.hms.locationSdk.j1 r1 = new com.huawei.hms.locationSdk.j1
            r1.<init>()
            java.lang.Object r0 = com.huawei.hms.locationSdk.i1.a(r0, r1)
            boolean r1 = r0 instanceof com.huawei.hms.locationSdk.f1
            if (r1 == 0) goto L_0x0019
            com.huawei.hms.locationSdk.f1 r0 = (com.huawei.hms.locationSdk.f1) r0
            r2.f49196a = r0
        L_0x0019:
            android.content.Context r0 = r2.getContext()
            boolean r0 = com.huawei.hms.locationSdk.j1.a(r0)
            if (r0 != 0) goto L_0x002f
            com.huawei.hms.locationSdk.f1 r0 = r2.f49196a
            if (r0 != 0) goto L_0x0028
            goto L_0x002f
        L_0x0028:
            com.huawei.hms.locationSdk.j r1 = f49194b
            com.huawei.hmf.tasks.Task r3 = r0.a(r2, r3, r1)
            return r3
        L_0x002f:
            com.huawei.hmf.tasks.Task r3 = super.doWrite(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.locationSdk.k.doWrite(com.huawei.hms.common.internal.TaskApiCall):com.huawei.hmf.tasks.Task");
    }

    public int getApiLevel() {
        return 2;
    }
}
