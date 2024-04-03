package com.huawei.location.activity;

import android.app.PendingIntent;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.huawei.hms.location.api.request.RemoveActivityConversionReq;
import com.huawei.hms.location.api.response.RequestActivityConversionResp;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.callback.LW;
import com.huawei.location.callback.Vw;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.ObjectCheckUtils;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class RemoveActivityConversionUpdatesTaskCall extends BaseApiTaskCall {
    private static final String TAG = "RemoveActivityConversionUpdatesAPI";

    private boolean checkRequest(RemoveActivityConversionReq removeActivityConversionReq) {
        if (removeActivityConversionReq == null || removeActivityConversionReq.getPackageName() == null || removeActivityConversionReq.getLocTransactionId() == null) {
            dealRequest();
            return false;
        } else if (!removeActivityConversionReq.getPackageName().isEmpty() && !removeActivityConversionReq.getLocTransactionId().isEmpty()) {
            return true;
        } else {
            dealRequest();
            return false;
        }
    }

    private void dealRequest() {
        Gson instance = GsonUtil.getInstance();
        RequestActivityConversionResp requestActivityConversionResp = new RequestActivityConversionResp();
        onComplete(new RouterResponse(!(instance instanceof Gson) ? instance.toJson((Object) requestActivityConversionResp) : GsonInstrumentation.toJson(instance, (Object) requestActivityConversionResp), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101))));
        this.errorCode = 10101;
    }

    private LW getBaseCallbackMapping(PendingIntent pendingIntent) {
        if (pendingIntent == null) {
            return Vw.Vw().yn(getRouterCallback());
        }
        LW yn2 = Vw.Vw().yn(pendingIntent);
        ObjectCheckUtils.checkNullObject(TAG, (Object) yn2, (int) ActivityErrorCode.NO_MATCHED_INTENT, "NO_MATCHED_INTENT");
        return yn2;
    }

    private PendingIntent getPendingIntent() {
        Parcelable parcelable = getParcelable();
        if (parcelable instanceof PendingIntent) {
            return (PendingIntent) parcelable;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequest(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.Class<com.huawei.location.callback.Vw$yn> r0 = com.huawei.location.callback.Vw.yn.class
            java.lang.String r1 = "onRequest removeActivityConversionUpdates exception"
            java.lang.String r2 = "onRequest start"
            java.lang.String r3 = "RemoveActivityConversionUpdatesAPI"
            com.huawei.location.lite.common.log.LogConsole.i(r3, r2)
            com.huawei.location.util.yn$yn r2 = r9.reportBuilder
            java.lang.String r4 = "AR_removeActivityTransition"
            r2.yn((java.lang.String) r4)
            r2 = 0
            r4 = 10000(0x2710, float:1.4013E-41)
            r5 = 0
            com.huawei.location.lite.common.util.ObjectCheckUtils.checkEmptyString(r3, r10)     // Catch:{ LocationServiceException -> 0x00ac, JsonSyntaxException -> 0x00a2, Exception -> 0x00a7 }
            com.google.gson.Gson r6 = com.huawei.location.lite.common.util.GsonUtil.getInstance()     // Catch:{ LocationServiceException -> 0x00ac, JsonSyntaxException -> 0x00a2, Exception -> 0x00a7 }
            java.lang.Class<com.huawei.hms.location.api.request.RemoveActivityConversionReq> r7 = com.huawei.hms.location.api.request.RemoveActivityConversionReq.class
            boolean r8 = r6 instanceof com.google.gson.Gson     // Catch:{ LocationServiceException -> 0x00ac, JsonSyntaxException -> 0x00a2, Exception -> 0x00a7 }
            if (r8 != 0) goto L_0x0028
            java.lang.Object r10 = r6.fromJson((java.lang.String) r10, r7)     // Catch:{ LocationServiceException -> 0x00ac, JsonSyntaxException -> 0x00a2, Exception -> 0x00a7 }
            goto L_0x002c
        L_0x0028:
            java.lang.Object r10 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r6, (java.lang.String) r10, r7)     // Catch:{ LocationServiceException -> 0x00ac, JsonSyntaxException -> 0x00a2, Exception -> 0x00a7 }
        L_0x002c:
            com.huawei.hms.location.api.request.RemoveActivityConversionReq r10 = (com.huawei.hms.location.api.request.RemoveActivityConversionReq) r10     // Catch:{ LocationServiceException -> 0x00ac, JsonSyntaxException -> 0x00a2, Exception -> 0x00a7 }
            boolean r5 = r9.checkRequest(r10)     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            if (r5 != 0) goto L_0x0049
            com.huawei.location.util.yn$yn r0 = r9.reportBuilder     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            r0.yn((com.huawei.hms.location.api.request.BaseLocationReq) r10)     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            com.huawei.location.util.yn$yn r0 = r9.reportBuilder     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            com.huawei.location.util.yn r0 = r0.yn()     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            int r5 = r9.errorCode     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            r0.yn(r5)     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            return
        L_0x0049:
            java.lang.String r5 = "Location"
            r10.setModuleName(r5)     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            java.lang.String r5 = r10.getLocTransactionId()     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            java.lang.String r6 = r10.getPackageName()     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            int r7 = com.huawei.location.lite.common.util.APKUtil.getUidByPackageName(r6)     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            com.huawei.location.base.activity.entity.ClientInfo r8 = new com.huawei.location.base.activity.entity.ClientInfo     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            r8.<init>(r6, r7, r2, r5)     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            android.app.PendingIntent r5 = r9.getPendingIntent()     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            com.huawei.location.callback.LW r5 = r9.getBaseCallbackMapping(r5)     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            com.huawei.location.callback.Vw$yn r6 = new com.huawei.location.callback.Vw$yn     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            r6.<init>()     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            boolean r7 = r5 instanceof com.huawei.location.callback.Vw.yn     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            if (r7 == 0) goto L_0x0073
            r6 = r5
            com.huawei.location.callback.Vw$yn r6 = (com.huawei.location.callback.Vw.yn) r6     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
        L_0x0073:
            com.huawei.location.lite.common.util.ObjectCheckUtils.checkNullObject((java.lang.String) r3, (java.lang.Object) r6, (java.lang.Class) r0)     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            com.huawei.location.base.activity.callback.ATCallback r5 = r6.FB()     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            com.huawei.location.lite.common.util.ObjectCheckUtils.checkNullObject((java.lang.String) r3, (java.lang.Object) r5, (java.lang.Class) r0)     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            java.lang.String r0 = r10.getModuleName()     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            com.huawei.location.logic.FB r5 = com.huawei.location.logic.Vw.yn()     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            com.huawei.location.base.activity.callback.ATCallback r7 = r6.FB()     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            com.huawei.location.logic.Vw r5 = (com.huawei.location.logic.Vw) r5     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            r5.yn((java.lang.String) r0, (com.huawei.location.base.activity.callback.ATCallback) r7, (com.huawei.location.base.activity.entity.ClientInfo) r8)     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            com.huawei.location.callback.Vw r0 = com.huawei.location.callback.Vw.Vw()     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            r0.yn(r6)     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            java.lang.String r0 = "removeActivityConversionUpdates success"
            r9.errorReason = r0     // Catch:{ LocationServiceException -> 0x009e, JsonSyntaxException -> 0x009c, Exception -> 0x009a }
            goto L_0x00cb
        L_0x009a:
            r5 = r10
            goto L_0x00a7
        L_0x009c:
            r5 = r10
            goto L_0x00a2
        L_0x009e:
            r0 = move-exception
            r5 = r10
            r10 = r0
            goto L_0x00ad
        L_0x00a2:
            java.lang.String r10 = "removeActivityConversionUpdatesTaskCall json parse failed"
            com.huawei.location.lite.common.log.LogConsole.i(r3, r10)
        L_0x00a7:
            r9.errorCode = r4
            r9.errorReason = r1
            goto L_0x00ca
        L_0x00ac:
            r10 = move-exception
        L_0x00ad:
            int r0 = r10.getExceptionCode()
            r9.errorCode = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onRequest removeActivityConversionUpdates LocationServiceException:"
            r0.append(r1)
            java.lang.String r10 = r10.getMessage()
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            r9.errorReason = r10
        L_0x00ca:
            r10 = r5
        L_0x00cb:
            com.huawei.location.util.yn$yn r0 = r9.reportBuilder
            r0.yn((com.huawei.hms.location.api.request.BaseLocationReq) r10)
            com.huawei.location.util.yn$yn r10 = r9.reportBuilder
            com.huawei.location.util.yn r10 = r10.yn()
            int r0 = r9.errorCode
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r10.yn(r0)
            com.huawei.location.router.RouterResponse r10 = new com.huawei.location.router.RouterResponse
            com.google.gson.Gson r0 = com.huawei.location.lite.common.util.GsonUtil.getInstance()
            com.huawei.hms.location.api.response.RequestActivityConversionResp r1 = new com.huawei.hms.location.api.response.RequestActivityConversionResp
            r1.<init>()
            boolean r3 = r0 instanceof com.google.gson.Gson
            if (r3 != 0) goto L_0x00f3
            java.lang.String r0 = r0.toJson((java.lang.Object) r1)
            goto L_0x00f7
        L_0x00f3:
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.toJson((com.google.gson.Gson) r0, (java.lang.Object) r1)
        L_0x00f7:
            com.huawei.location.router.entity.StatusInfo r1 = new com.huawei.location.router.entity.StatusInfo
            int r3 = r9.errorCode
            java.lang.String r4 = r9.errorReason
            r1.<init>(r2, r3, r4)
            r10.<init>(r0, r1)
            r9.doExecute(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.activity.RemoveActivityConversionUpdatesTaskCall.onRequest(java.lang.String):void");
    }
}
