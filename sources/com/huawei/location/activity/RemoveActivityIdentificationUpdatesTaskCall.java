package com.huawei.location.activity;

import android.app.PendingIntent;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.huawei.hms.location.api.request.BaseLocationReq;
import com.huawei.hms.location.api.response.RequestActivityIdentificationResp;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class RemoveActivityIdentificationUpdatesTaskCall extends BaseApiTaskCall {
    private static final String TAG = "RemoveActivityIdentificationUpdatesAPI";

    private boolean checkRequest(BaseLocationReq baseLocationReq) {
        if (!baseLocationReq.getLocTransactionId().isEmpty() && !baseLocationReq.getPackageName().isEmpty()) {
            return true;
        }
        LogConsole.e(TAG, "tid or packageName is invalid");
        Gson instance = GsonUtil.getInstance();
        RequestActivityIdentificationResp requestActivityIdentificationResp = new RequestActivityIdentificationResp();
        onComplete(new RouterResponse(!(instance instanceof Gson) ? instance.toJson((Object) requestActivityIdentificationResp) : GsonInstrumentation.toJson(instance, (Object) requestActivityIdentificationResp), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101))));
        return false;
    }

    private PendingIntent getPendingIntent() {
        Parcelable parcelable = getParcelable();
        if (parcelable instanceof PendingIntent) {
            return (PendingIntent) parcelable;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequest(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.Class<com.huawei.location.callback.yn$yn> r0 = com.huawei.location.callback.yn.C0076yn.class
            java.lang.String r1 = "onRequest removeActivityIdentificationUpdates exception"
            java.lang.String r2 = "onRequest start"
            java.lang.String r3 = "RemoveActivityIdentificationUpdatesAPI"
            com.huawei.location.lite.common.log.LogConsole.i(r3, r2)
            com.huawei.location.util.yn$yn r2 = r9.reportBuilder
            java.lang.String r4 = "AR_removeActivityState"
            r2.yn((java.lang.String) r4)
            r2 = 0
            r4 = 10000(0x2710, float:1.4013E-41)
            r5 = 0
            com.huawei.location.lite.common.util.ObjectCheckUtils.checkEmptyString(r3, r10)     // Catch:{ JsonSyntaxException -> 0x00d3, LocationServiceException -> 0x00b3, Exception -> 0x00d8 }
            com.google.gson.Gson r6 = com.huawei.location.lite.common.util.GsonUtil.getInstance()     // Catch:{ JsonSyntaxException -> 0x00d3, LocationServiceException -> 0x00b3, Exception -> 0x00d8 }
            java.lang.Class<com.huawei.hms.location.api.request.BaseLocationReq> r7 = com.huawei.hms.location.api.request.BaseLocationReq.class
            boolean r8 = r6 instanceof com.google.gson.Gson     // Catch:{ JsonSyntaxException -> 0x00d3, LocationServiceException -> 0x00b3, Exception -> 0x00d8 }
            if (r8 != 0) goto L_0x0028
            java.lang.Object r10 = r6.fromJson((java.lang.String) r10, r7)     // Catch:{ JsonSyntaxException -> 0x00d3, LocationServiceException -> 0x00b3, Exception -> 0x00d8 }
            goto L_0x002c
        L_0x0028:
            java.lang.Object r10 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r6, (java.lang.String) r10, r7)     // Catch:{ JsonSyntaxException -> 0x00d3, LocationServiceException -> 0x00b3, Exception -> 0x00d8 }
        L_0x002c:
            com.huawei.hms.location.api.request.BaseLocationReq r10 = (com.huawei.hms.location.api.request.BaseLocationReq) r10     // Catch:{ JsonSyntaxException -> 0x00d3, LocationServiceException -> 0x00b3, Exception -> 0x00d8 }
            boolean r5 = r9.checkRequest(r10)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            if (r5 != 0) goto L_0x0049
            com.huawei.location.util.yn$yn r0 = r9.reportBuilder     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            r0.yn((com.huawei.hms.location.api.request.BaseLocationReq) r10)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            com.huawei.location.util.yn$yn r0 = r9.reportBuilder     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            com.huawei.location.util.yn r0 = r0.yn()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            int r5 = r9.errorCode     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            r0.yn(r5)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            return
        L_0x0049:
            java.lang.String r5 = r10.getLocTransactionId()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            java.lang.String r6 = r10.getPackageName()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            int r7 = com.huawei.location.lite.common.util.APKUtil.getUidByPackageName(r6)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            com.huawei.location.base.activity.entity.ClientInfo r8 = new com.huawei.location.base.activity.entity.ClientInfo     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            r8.<init>(r6, r7, r2, r5)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            android.app.PendingIntent r5 = r9.getPendingIntent()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            if (r5 == 0) goto L_0x0070
            com.huawei.location.callback.yn r6 = com.huawei.location.callback.yn.Vw()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            com.huawei.location.callback.LW r5 = r6.yn((android.app.PendingIntent) r5)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            java.lang.String r6 = "NO_MATCHED_INTENT"
            r7 = 10108(0x277c, float:1.4164E-41)
            com.huawei.location.lite.common.util.ObjectCheckUtils.checkNullObject((java.lang.String) r3, (java.lang.Object) r5, (int) r7, (java.lang.String) r6)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            goto L_0x007c
        L_0x0070:
            com.huawei.location.callback.yn r5 = com.huawei.location.callback.yn.Vw()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            com.huawei.location.router.interfaces.IRouterCallback r6 = r9.getRouterCallback()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            com.huawei.location.callback.LW r5 = r5.yn((com.huawei.location.router.interfaces.IRouterCallback) r6)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
        L_0x007c:
            com.huawei.location.callback.yn$yn r6 = new com.huawei.location.callback.yn$yn     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            r6.<init>()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            boolean r7 = r5 instanceof com.huawei.location.callback.yn.C0076yn     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            if (r7 == 0) goto L_0x0088
            r6 = r5
            com.huawei.location.callback.yn$yn r6 = (com.huawei.location.callback.yn.C0076yn) r6     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
        L_0x0088:
            com.huawei.location.lite.common.util.ObjectCheckUtils.checkNullObject((java.lang.String) r3, (java.lang.Object) r6, (java.lang.Class) r0)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            com.huawei.location.base.activity.callback.ARCallback r5 = r6.FB()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            com.huawei.location.lite.common.util.ObjectCheckUtils.checkNullObject((java.lang.String) r3, (java.lang.Object) r5, (java.lang.Class) r0)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            com.huawei.location.logic.FB r0 = com.huawei.location.logic.Vw.yn()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            com.huawei.location.base.activity.callback.ARCallback r5 = r6.FB()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            com.huawei.location.logic.Vw r0 = (com.huawei.location.logic.Vw) r0     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            r0.yn(r5, r8)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            com.huawei.location.callback.yn r0 = com.huawei.location.callback.yn.Vw()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            r0.yn(r6)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            java.lang.String r0 = "removeActivityIdentificationUpdates success"
            r9.errorReason = r0     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x00ad, Exception -> 0x00ab }
            goto L_0x00dd
        L_0x00ab:
            r5 = r10
            goto L_0x00d8
        L_0x00ad:
            r0 = move-exception
            r5 = r10
            r10 = r0
            goto L_0x00b4
        L_0x00b1:
            r5 = r10
            goto L_0x00d3
        L_0x00b3:
            r10 = move-exception
        L_0x00b4:
            int r0 = r10.getExceptionCode()
            r9.errorCode = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onRequest removeActivityIdentificationUpdates LocationServiceException:"
            r0.append(r1)
            java.lang.String r10 = r10.getMessage()
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            r9.errorReason = r10
        L_0x00d1:
            r10 = r5
            goto L_0x00dd
        L_0x00d3:
            java.lang.String r10 = "removeActivityIdentificationUpdatesTaskCall json parse failed"
            com.huawei.location.lite.common.log.LogConsole.i(r3, r10)
        L_0x00d8:
            r9.errorCode = r4
            r9.errorReason = r1
            goto L_0x00d1
        L_0x00dd:
            com.huawei.location.util.yn$yn r0 = r9.reportBuilder
            r0.yn((com.huawei.hms.location.api.request.BaseLocationReq) r10)
            com.huawei.location.util.yn$yn r10 = r9.reportBuilder
            com.huawei.location.util.yn r10 = r10.yn()
            int r0 = r9.errorCode
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r10.yn(r0)
            com.huawei.location.router.RouterResponse r10 = new com.huawei.location.router.RouterResponse
            com.google.gson.Gson r0 = com.huawei.location.lite.common.util.GsonUtil.getInstance()
            com.huawei.hms.location.api.response.RequestActivityIdentificationResp r1 = new com.huawei.hms.location.api.response.RequestActivityIdentificationResp
            r1.<init>()
            boolean r3 = r0 instanceof com.google.gson.Gson
            if (r3 != 0) goto L_0x0105
            java.lang.String r0 = r0.toJson((java.lang.Object) r1)
            goto L_0x0109
        L_0x0105:
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.toJson((com.google.gson.Gson) r0, (java.lang.Object) r1)
        L_0x0109:
            com.huawei.location.router.entity.StatusInfo r1 = new com.huawei.location.router.entity.StatusInfo
            int r3 = r9.errorCode
            java.lang.String r4 = r9.errorReason
            r1.<init>(r2, r3, r4)
            r10.<init>(r0, r1)
            r9.doExecute(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.activity.RemoveActivityIdentificationUpdatesTaskCall.onRequest(java.lang.String):void");
    }
}
