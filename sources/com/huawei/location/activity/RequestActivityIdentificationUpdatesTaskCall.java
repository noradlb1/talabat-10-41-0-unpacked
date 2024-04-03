package com.huawei.location.activity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.ActivityIdentificationData;
import com.huawei.hms.location.ActivityIdentificationResponse;
import com.huawei.hms.location.api.request.BaseLocationReq;
import com.huawei.hms.location.api.request.RequestActivityIdentificationReq;
import com.huawei.hms.location.api.response.RequestActivityIdentificationResp;
import com.huawei.hms.location.entity.activity.ActivityRecognitionResult;
import com.huawei.hms.location.entity.activity.DetectedActivity;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.base.activity.permission.ARLocationPermissionManager;
import com.huawei.location.callback.LW;
import com.huawei.location.callback.yn;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.huawei.secure.android.common.intent.SafeBundle;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.List;

@Instrumented
public class RequestActivityIdentificationUpdatesTaskCall extends BaseApiTaskCall {
    private static final String KEY_RESPONSE = "KEY_RESPONSE";
    private static final String KEY_RESPONSE_RESULT = "com.huawei.hms.location.internal.EXTRA_ACTIVITY_RESULT";
    private static final String TAG = "RequestActivityIdentificationUpdatesAPI";
    private yn.C0076yn callBackInfo;
    /* access modifiers changed from: private */
    public ClientInfo clientInfo;
    /* access modifiers changed from: private */
    public PendingIntent pendingIntent;
    /* access modifiers changed from: private */
    public RequestActivityIdentificationReq requestActivityIdentificationReq = null;

    @Instrumented
    public class Vw implements ARCallback {
        private Vw() {
        }

        public void onActivityRecognition(ActivityRecognitionResult activityRecognitionResult) {
            String str;
            RequestActivityIdentificationUpdatesTaskCall.this.reportBuilder.yn("AR_activityStateCallback");
            if (RequestActivityIdentificationUpdatesTaskCall.this.pendingIntent == null) {
                RequestActivityIdentificationResp requestActivityIdentificationResp = new RequestActivityIdentificationResp();
                requestActivityIdentificationResp.setActivityRecognitionResult(activityRecognitionResult);
                Gson instance = GsonUtil.getInstance();
                String json = !(instance instanceof Gson) ? instance.toJson((Object) requestActivityIdentificationResp) : GsonInstrumentation.toJson(instance, (Object) requestActivityIdentificationResp);
                RequestActivityIdentificationUpdatesTaskCall requestActivityIdentificationUpdatesTaskCall = RequestActivityIdentificationUpdatesTaskCall.this;
                requestActivityIdentificationUpdatesTaskCall.doExecute(new RouterResponse(json, new StatusInfo(0, requestActivityIdentificationUpdatesTaskCall.errorCode, requestActivityIdentificationUpdatesTaskCall.errorReason)));
            } else if (!ARLocationPermissionManager.checkCPActivityRecognitionPermissionByException(RequestActivityIdentificationUpdatesTaskCall.this.getTAG(), "checkActivityRecognitionPermission", RequestActivityIdentificationUpdatesTaskCall.this.clientInfo.getClientPid(), RequestActivityIdentificationUpdatesTaskCall.this.clientInfo.getClientUid())) {
                RequestActivityIdentificationUpdatesTaskCall.this.removeActivityIdentificationUpdates();
                return;
            } else {
                try {
                    List<DetectedActivity> probableActivities = activityRecognitionResult.getProbableActivities();
                    ArrayList arrayList = new ArrayList();
                    for (DetectedActivity next : probableActivities) {
                        arrayList.add(new ActivityIdentificationData(next.getType() + 100, next.getConfidence()));
                    }
                    ActivityIdentificationResponse activityIdentificationResponse = new ActivityIdentificationResponse((List<ActivityIdentificationData>) arrayList, activityRecognitionResult.getTime(), activityRecognitionResult.getElapsedRealtimeMillis());
                    LogConsole.i(RequestActivityIdentificationUpdatesTaskCall.TAG, "sending recognition result:" + activityRecognitionResult);
                    Intent intent = new Intent();
                    SafeBundle safeBundle = new SafeBundle();
                    safeBundle.putParcelable(RequestActivityIdentificationUpdatesTaskCall.KEY_RESPONSE, activityIdentificationResponse);
                    intent.putExtra(RequestActivityIdentificationUpdatesTaskCall.KEY_RESPONSE_RESULT, safeBundle.getBundle());
                    RequestActivityIdentificationUpdatesTaskCall.this.pendingIntent.send(ContextUtil.getContext(), 0, intent);
                } catch (NullPointerException unused) {
                    str = "NullPointerException";
                } catch (ApiException unused2) {
                    str = "ApiException";
                } catch (PendingIntent.CanceledException unused3) {
                    str = "CanceledException";
                }
            }
            RequestActivityIdentificationUpdatesTaskCall requestActivityIdentificationUpdatesTaskCall2 = RequestActivityIdentificationUpdatesTaskCall.this;
            requestActivityIdentificationUpdatesTaskCall2.reportBuilder.yn((BaseLocationReq) requestActivityIdentificationUpdatesTaskCall2.requestActivityIdentificationReq);
            RequestActivityIdentificationUpdatesTaskCall.this.reportBuilder.yn().Vw(String.valueOf(RequestActivityIdentificationUpdatesTaskCall.this.errorCode));
            LogConsole.e(RequestActivityIdentificationUpdatesTaskCall.TAG, str, true);
            RequestActivityIdentificationUpdatesTaskCall.this.errorCode = 10000;
            RequestActivityIdentificationUpdatesTaskCall requestActivityIdentificationUpdatesTaskCall22 = RequestActivityIdentificationUpdatesTaskCall.this;
            requestActivityIdentificationUpdatesTaskCall22.reportBuilder.yn((BaseLocationReq) requestActivityIdentificationUpdatesTaskCall22.requestActivityIdentificationReq);
            RequestActivityIdentificationUpdatesTaskCall.this.reportBuilder.yn().Vw(String.valueOf(RequestActivityIdentificationUpdatesTaskCall.this.errorCode));
        }
    }

    private boolean checkRequest(RequestActivityIdentificationReq requestActivityIdentificationReq2) {
        RouterResponse routerResponse;
        if (requestActivityIdentificationReq2.getPackageName().isEmpty()) {
            LogConsole.e(TAG, "packageName is invalid");
            Gson instance = GsonUtil.getInstance();
            RequestActivityIdentificationResp requestActivityIdentificationResp = new RequestActivityIdentificationResp();
            routerResponse = new RouterResponse(!(instance instanceof Gson) ? instance.toJson((Object) requestActivityIdentificationResp) : GsonInstrumentation.toJson(instance, (Object) requestActivityIdentificationResp), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101)));
        } else if (!requestActivityIdentificationReq2.getLocTransactionId().isEmpty()) {
            return true;
        } else {
            LogConsole.e(TAG, "tid is invalid");
            Gson instance2 = GsonUtil.getInstance();
            RequestActivityIdentificationResp requestActivityIdentificationResp2 = new RequestActivityIdentificationResp();
            routerResponse = new RouterResponse(!(instance2 instanceof Gson) ? instance2.toJson((Object) requestActivityIdentificationResp2) : GsonInstrumentation.toJson(instance2, (Object) requestActivityIdentificationResp2), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101)));
        }
        onComplete(routerResponse);
        return false;
    }

    private void getCallback() {
        LW yn2 = this.pendingIntent != null ? com.huawei.location.callback.yn.Vw().yn(this.pendingIntent) : com.huawei.location.callback.yn.Vw().yn(getRouterCallback());
        if (yn2 instanceof yn.C0076yn) {
            this.callBackInfo = (yn.C0076yn) yn2;
        }
    }

    private PendingIntent getPendingIntent() {
        Parcelable parcelable = getParcelable();
        if (parcelable instanceof PendingIntent) {
            this.pendingIntent = (PendingIntent) parcelable;
        }
        return this.pendingIntent;
    }

    /* access modifiers changed from: private */
    public String getTAG() {
        return TAG;
    }

    /* access modifiers changed from: private */
    public void removeActivityIdentificationUpdates() {
        int i11;
        LogConsole.i(TAG, "removeActivityIdentificationUpdates start");
        if (this.callBackInfo != null) {
            try {
                ((com.huawei.location.logic.Vw) com.huawei.location.logic.Vw.yn()).yn(this.callBackInfo.FB(), this.clientInfo);
                com.huawei.location.callback.yn.Vw().yn(this.callBackInfo);
            } catch (LocationServiceException e11) {
                int exceptionCode = e11.getExceptionCode();
                this.errorReason = "removeActivityUpdates in request api LocationServiceException:" + e11.getMessage();
                i11 = exceptionCode;
            } catch (Exception unused) {
                this.errorReason = "removeActivityUpdates in request api exception";
                i11 = 10000;
            }
        }
        i11 = 0;
        this.reportBuilder.yn((BaseLocationReq) this.requestActivityIdentificationReq);
        this.reportBuilder.yn("AR_removeActivityState");
        this.reportBuilder.yn().Vw(String.valueOf(i11));
    }

    private void saveCallbackInfo() {
        if (this.callBackInfo == null) {
            yn.C0076yn ynVar = new yn.C0076yn();
            this.callBackInfo = ynVar;
            ynVar.yn(new Vw());
            this.callBackInfo.yn(this.pendingIntent);
            this.callBackInfo.yn(getRouterCallback());
            com.huawei.location.callback.yn.Vw().Vw(this.callBackInfo);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequest(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "onRequest start"
            java.lang.String r1 = "RequestActivityIdentificationUpdatesAPI"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r0)
            com.huawei.location.util.yn$yn r0 = r7.reportBuilder
            java.lang.String r2 = "AR_requestActivityState"
            r0.yn((java.lang.String) r2)
            r0 = 0
            r2 = 10000(0x2710, float:1.4013E-41)
            com.huawei.location.lite.common.util.ObjectCheckUtils.checkEmptyString(r1, r8)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            com.google.gson.Gson r3 = com.huawei.location.lite.common.util.GsonUtil.getInstance()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            java.lang.Class<com.huawei.hms.location.api.request.RequestActivityIdentificationReq> r4 = com.huawei.hms.location.api.request.RequestActivityIdentificationReq.class
            boolean r5 = r3 instanceof com.google.gson.Gson     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            if (r5 != 0) goto L_0x0023
            java.lang.Object r8 = r3.fromJson((java.lang.String) r8, r4)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            goto L_0x0027
        L_0x0023:
            java.lang.Object r8 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r3, (java.lang.String) r8, r4)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
        L_0x0027:
            com.huawei.hms.location.api.request.RequestActivityIdentificationReq r8 = (com.huawei.hms.location.api.request.RequestActivityIdentificationReq) r8     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            r7.requestActivityIdentificationReq = r8     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            boolean r8 = r7.checkRequest(r8)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            if (r8 != 0) goto L_0x0048
            com.huawei.location.util.yn$yn r8 = r7.reportBuilder     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            com.huawei.hms.location.api.request.RequestActivityIdentificationReq r3 = r7.requestActivityIdentificationReq     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            r8.yn((com.huawei.hms.location.api.request.BaseLocationReq) r3)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            com.huawei.location.util.yn$yn r8 = r7.reportBuilder     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            com.huawei.location.util.yn r8 = r8.yn()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            int r3 = r7.errorCode     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            r8.yn(r3)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            return
        L_0x0048:
            com.huawei.hms.location.api.request.RequestActivityIdentificationReq r8 = r7.requestActivityIdentificationReq     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            java.lang.String r8 = r8.getLocTransactionId()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            com.huawei.hms.location.api.request.RequestActivityIdentificationReq r3 = r7.requestActivityIdentificationReq     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            int r4 = com.huawei.location.lite.common.util.APKUtil.getUidByPackageName(r3)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            com.huawei.location.base.activity.entity.ClientInfo r5 = new com.huawei.location.base.activity.entity.ClientInfo     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            r5.<init>(r3, r4, r0, r8)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            r7.clientInfo = r5     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            com.huawei.hms.location.api.request.RequestActivityIdentificationReq r8 = r7.requestActivityIdentificationReq     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            long r3 = r8.getDetectionIntervalMillis()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            r5 = 0
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 > 0) goto L_0x006d
            r3 = 30000(0x7530, double:1.4822E-319)
        L_0x006d:
            android.app.PendingIntent r8 = r7.getPendingIntent()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            r7.pendingIntent = r8     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            r7.getCallback()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            r7.saveCallbackInfo()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            com.huawei.location.logic.FB r8 = com.huawei.location.logic.Vw.yn()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            com.huawei.location.callback.yn$yn r5 = r7.callBackInfo     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            com.huawei.location.base.activity.callback.ARCallback r5 = r5.FB()     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            com.huawei.location.base.activity.entity.ClientInfo r6 = r7.clientInfo     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            com.huawei.location.logic.Vw r8 = (com.huawei.location.logic.Vw) r8     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            r8.yn((long) r3, (com.huawei.location.base.activity.callback.ARCallback) r5, (com.huawei.location.base.activity.entity.ClientInfo) r6)     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            java.lang.String r8 = "requestActivityIdentificationUpdates success"
            r7.errorReason = r8     // Catch:{ JsonSyntaxException -> 0x00b1, LocationServiceException -> 0x0094, Exception -> 0x008f }
            goto L_0x00bc
        L_0x008f:
            r7.errorCode = r2
            java.lang.String r8 = "onRequest requestActivityIdentificationUpdates exception"
            goto L_0x00ba
        L_0x0094:
            r8 = move-exception
            int r1 = r8.getExceptionCode()
            r7.errorCode = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onRequest requestActivityIdentificationUpdates LocationServiceException:"
            r1.append(r2)
            java.lang.String r8 = r8.getMessage()
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            goto L_0x00ba
        L_0x00b1:
            java.lang.String r8 = "requestActivityIdentificationUpdatesTaskCall json parse failed"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r8)
            r7.errorCode = r2
            java.lang.String r8 = "onRequest requestActivityIdentificationUpdates json parse exception"
        L_0x00ba:
            r7.errorReason = r8
        L_0x00bc:
            int r8 = r7.errorCode
            if (r8 != 0) goto L_0x00c8
            com.huawei.location.callback.yn$yn r8 = r7.callBackInfo
            android.app.PendingIntent r8 = r8.yn()
            if (r8 == 0) goto L_0x00ef
        L_0x00c8:
            com.huawei.location.router.RouterResponse r8 = new com.huawei.location.router.RouterResponse
            com.google.gson.Gson r1 = com.huawei.location.lite.common.util.GsonUtil.getInstance()
            com.huawei.hms.location.api.response.RequestActivityIdentificationResp r2 = new com.huawei.hms.location.api.response.RequestActivityIdentificationResp
            r2.<init>()
            boolean r3 = r1 instanceof com.google.gson.Gson
            if (r3 != 0) goto L_0x00dc
            java.lang.String r1 = r1.toJson((java.lang.Object) r2)
            goto L_0x00e0
        L_0x00dc:
            java.lang.String r1 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.toJson((com.google.gson.Gson) r1, (java.lang.Object) r2)
        L_0x00e0:
            com.huawei.location.router.entity.StatusInfo r2 = new com.huawei.location.router.entity.StatusInfo
            int r3 = r7.errorCode
            java.lang.String r4 = r7.errorReason
            r2.<init>(r0, r3, r4)
            r8.<init>(r1, r2)
            r7.doExecute(r8)
        L_0x00ef:
            com.huawei.location.util.yn$yn r8 = r7.reportBuilder
            com.huawei.hms.location.api.request.RequestActivityIdentificationReq r0 = r7.requestActivityIdentificationReq
            r8.yn((com.huawei.hms.location.api.request.BaseLocationReq) r0)
            com.huawei.location.util.yn$yn r8 = r7.reportBuilder
            com.huawei.location.util.yn r8 = r8.yn()
            int r0 = r7.errorCode
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r8.yn(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.activity.RequestActivityIdentificationUpdatesTaskCall.onRequest(java.lang.String):void");
    }
}
