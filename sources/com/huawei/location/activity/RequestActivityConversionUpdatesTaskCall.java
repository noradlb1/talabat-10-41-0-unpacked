package com.huawei.location.activity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hms.location.ActivityConversionData;
import com.huawei.hms.location.ActivityConversionInfo;
import com.huawei.hms.location.ActivityConversionResponse;
import com.huawei.hms.location.api.request.BaseLocationReq;
import com.huawei.hms.location.api.request.RequestActivityConversionReq;
import com.huawei.hms.location.api.response.RequestActivityConversionResp;
import com.huawei.hms.location.entity.activity.ActivityTransition;
import com.huawei.hms.location.entity.activity.ActivityTransitionEvent;
import com.huawei.hms.location.entity.activity.ActivityTransitionRequest;
import com.huawei.hms.location.entity.activity.ActivityTransitionResult;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.base.activity.permission.ARLocationPermissionManager;
import com.huawei.location.callback.LW;
import com.huawei.location.callback.Vw;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.APKUtil;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.ObjectCheckUtils;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.huawei.secure.android.common.intent.SafeBundle;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.List;

@Instrumented
public class RequestActivityConversionUpdatesTaskCall extends BaseApiTaskCall {
    private static final String KEY_RESPONSE = "KEY_RESPONSE";
    private static final String KEY_RESPONSE_RESULT = "com.huawei.hms.location.internal.EXTRA_ACTIVITY_CONVERSION_RESULT";
    private static final String TAG = "RequestActivityConversionUpdatesAPI";
    private Vw.yn callBackInfo;
    /* access modifiers changed from: private */
    public ClientInfo clientInfo;
    private String moduleName;
    /* access modifiers changed from: private */
    public PendingIntent pendingIntent;
    /* access modifiers changed from: private */
    public RequestActivityConversionReq requestActivityConversionReq = null;

    @Instrumented
    public class Vw implements ATCallback {
        private Vw() {
        }

        public void onActivityTransition(ActivityTransitionResult activityTransitionResult) {
            String str;
            RequestActivityConversionUpdatesTaskCall.this.reportBuilder.yn("AR_activityTransitionCallback");
            if (RequestActivityConversionUpdatesTaskCall.this.pendingIntent == null) {
                RequestActivityConversionResp requestActivityConversionResp = new RequestActivityConversionResp();
                requestActivityConversionResp.setActivityTransitionResult(activityTransitionResult);
                Gson instance = GsonUtil.getInstance();
                String json = !(instance instanceof Gson) ? instance.toJson((Object) requestActivityConversionResp) : GsonInstrumentation.toJson(instance, (Object) requestActivityConversionResp);
                RequestActivityConversionUpdatesTaskCall requestActivityConversionUpdatesTaskCall = RequestActivityConversionUpdatesTaskCall.this;
                requestActivityConversionUpdatesTaskCall.doExecute(new RouterResponse(json, new StatusInfo(0, requestActivityConversionUpdatesTaskCall.errorCode, requestActivityConversionUpdatesTaskCall.errorReason)));
            } else if (!ARLocationPermissionManager.checkCPActivityRecognitionPermissionByException(RequestActivityConversionUpdatesTaskCall.this.getTAG(), "checkActivityRecognitionPermission", RequestActivityConversionUpdatesTaskCall.this.clientInfo.getClientPid(), RequestActivityConversionUpdatesTaskCall.this.clientInfo.getClientUid())) {
                RequestActivityConversionUpdatesTaskCall.this.removeActivityConversionUpdates();
                return;
            } else {
                try {
                    List<ActivityTransitionEvent> transitionEvents = activityTransitionResult.getTransitionEvents();
                    ArrayList arrayList = new ArrayList();
                    for (ActivityTransitionEvent next : transitionEvents) {
                        arrayList.add(new ActivityConversionData(next.getActivityType() + 100, next.getTransitionType(), next.getElapsedRealTimeNanos()));
                    }
                    ActivityConversionResponse activityConversionResponse = new ActivityConversionResponse((List<ActivityConversionData>) arrayList);
                    LogConsole.i(RequestActivityConversionUpdatesTaskCall.TAG, "sending transition result:" + activityTransitionResult);
                    Intent intent = new Intent();
                    SafeBundle safeBundle = new SafeBundle();
                    safeBundle.putParcelable(RequestActivityConversionUpdatesTaskCall.KEY_RESPONSE, activityConversionResponse);
                    intent.putExtra(RequestActivityConversionUpdatesTaskCall.KEY_RESPONSE_RESULT, safeBundle.getBundle());
                    RequestActivityConversionUpdatesTaskCall.this.pendingIntent.send(ContextUtil.getContext(), 0, intent);
                } catch (NullPointerException unused) {
                    str = "NullPointerException";
                } catch (PendingIntent.CanceledException unused2) {
                    str = "CanceledException";
                }
            }
            RequestActivityConversionUpdatesTaskCall requestActivityConversionUpdatesTaskCall2 = RequestActivityConversionUpdatesTaskCall.this;
            requestActivityConversionUpdatesTaskCall2.reportBuilder.yn((BaseLocationReq) requestActivityConversionUpdatesTaskCall2.requestActivityConversionReq);
            RequestActivityConversionUpdatesTaskCall.this.reportBuilder.yn().Vw(String.valueOf(RequestActivityConversionUpdatesTaskCall.this.errorCode));
            LogConsole.e(RequestActivityConversionUpdatesTaskCall.TAG, str, true);
            RequestActivityConversionUpdatesTaskCall.this.errorCode = 10000;
            RequestActivityConversionUpdatesTaskCall requestActivityConversionUpdatesTaskCall22 = RequestActivityConversionUpdatesTaskCall.this;
            requestActivityConversionUpdatesTaskCall22.reportBuilder.yn((BaseLocationReq) requestActivityConversionUpdatesTaskCall22.requestActivityConversionReq);
            RequestActivityConversionUpdatesTaskCall.this.reportBuilder.yn().Vw(String.valueOf(RequestActivityConversionUpdatesTaskCall.this.errorCode));
        }
    }

    private boolean checkRequest(RequestActivityConversionReq requestActivityConversionReq2) {
        RouterResponse routerResponse;
        if (requestActivityConversionReq2.getPackageName().isEmpty()) {
            LogConsole.e(TAG, "packageName is invalid");
            Gson instance = GsonUtil.getInstance();
            RequestActivityConversionResp requestActivityConversionResp = new RequestActivityConversionResp();
            routerResponse = new RouterResponse(!(instance instanceof Gson) ? instance.toJson((Object) requestActivityConversionResp) : GsonInstrumentation.toJson(instance, (Object) requestActivityConversionResp), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101)));
        } else if (requestActivityConversionReq2.getLocTransactionId().isEmpty()) {
            LogConsole.e(TAG, "tid is invalid");
            Gson instance2 = GsonUtil.getInstance();
            RequestActivityConversionResp requestActivityConversionResp2 = new RequestActivityConversionResp();
            routerResponse = new RouterResponse(!(instance2 instanceof Gson) ? instance2.toJson((Object) requestActivityConversionResp2) : GsonInstrumentation.toJson(instance2, (Object) requestActivityConversionResp2), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101)));
        } else if (!requestActivityConversionReq2.getModuleName().isEmpty()) {
            return true;
        } else {
            LogConsole.e(TAG, "ModuleName is invalid");
            Gson instance3 = GsonUtil.getInstance();
            RequestActivityConversionResp requestActivityConversionResp3 = new RequestActivityConversionResp();
            routerResponse = new RouterResponse(!(instance3 instanceof Gson) ? instance3.toJson((Object) requestActivityConversionResp3) : GsonInstrumentation.toJson(instance3, (Object) requestActivityConversionResp3), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101)));
        }
        onComplete(routerResponse);
        return false;
    }

    private void getCallback() {
        LW yn2 = this.pendingIntent != null ? com.huawei.location.callback.Vw.Vw().yn(this.pendingIntent) : com.huawei.location.callback.yn.Vw().yn(getRouterCallback());
        if (yn2 instanceof Vw.yn) {
            this.callBackInfo = (Vw.yn) yn2;
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

    private List<ActivityTransition> getTransitionLists() {
        List<ActivityConversionInfo> activityConversions = this.requestActivityConversionReq.getActivityConversions();
        ArrayList arrayList = new ArrayList();
        for (ActivityConversionInfo next : activityConversions) {
            ActivityTransition activityTransition = new ActivityTransition();
            activityTransition.setActivityType(next.getActivityType() - 100);
            activityTransition.setTransitionType(next.getConversionType());
            arrayList.add(activityTransition);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void removeActivityConversionUpdates() {
        int i11;
        LogConsole.i(TAG, "removeActivityConversionUpdates start");
        if (this.callBackInfo != null) {
            try {
                ((com.huawei.location.logic.Vw) com.huawei.location.logic.Vw.yn()).yn(this.moduleName, this.callBackInfo.FB(), this.clientInfo);
                com.huawei.location.callback.Vw.Vw().yn(this.callBackInfo);
            } catch (LocationServiceException e11) {
                int exceptionCode = e11.getExceptionCode();
                this.errorReason = "removeActivityConversionUpdates in request api LocationServiceException:" + e11.getMessage();
                i11 = exceptionCode;
            } catch (Exception unused) {
                this.errorReason = "removeActivityConversionUpdates in request api exception";
                i11 = 10000;
            }
        }
        i11 = 0;
        this.reportBuilder.yn((BaseLocationReq) this.requestActivityConversionReq);
        this.reportBuilder.yn("AR_removeActivityTransition");
        this.reportBuilder.yn().Vw(String.valueOf(i11));
    }

    private void saveCallbackInfo() {
        if (this.callBackInfo == null) {
            Vw.yn ynVar = new Vw.yn();
            this.callBackInfo = ynVar;
            ynVar.yn(new Vw());
            this.callBackInfo.yn(this.pendingIntent);
            this.callBackInfo.yn(getRouterCallback());
            com.huawei.location.callback.Vw.Vw().Vw(this.callBackInfo);
        }
    }

    public void onRequest(String str) {
        LogConsole.i(TAG, "onRequest start");
        this.reportBuilder.yn("AR_requestActivityTransition");
        try {
            ObjectCheckUtils.checkEmptyString(TAG, str);
            Gson instance = GsonUtil.getInstance();
            Class cls = RequestActivityConversionReq.class;
            RequestActivityConversionReq requestActivityConversionReq2 = (RequestActivityConversionReq) (!(instance instanceof Gson) ? instance.fromJson(str, cls) : GsonInstrumentation.fromJson(instance, str, cls));
            this.requestActivityConversionReq = requestActivityConversionReq2;
            if (requestActivityConversionReq2.getModuleName() == null || this.requestActivityConversionReq.getModuleName().isEmpty()) {
                this.requestActivityConversionReq.setModuleName("Location");
            }
            if (!checkRequest(this.requestActivityConversionReq)) {
                this.reportBuilder.yn((BaseLocationReq) this.requestActivityConversionReq);
                this.reportBuilder.yn().yn(String.valueOf(this.errorCode));
                return;
            }
            String locTransactionId = this.requestActivityConversionReq.getLocTransactionId();
            String packageName = this.requestActivityConversionReq.getPackageName();
            this.clientInfo = new ClientInfo(packageName, APKUtil.getUidByPackageName(packageName), 0, locTransactionId);
            this.pendingIntent = getPendingIntent();
            getCallback();
            saveCallbackInfo();
            List<ActivityTransition> transitionLists = getTransitionLists();
            ActivityTransitionRequest activityTransitionRequest = new ActivityTransitionRequest();
            activityTransitionRequest.setTransitions(transitionLists);
            this.moduleName = this.requestActivityConversionReq.getModuleName();
            ((com.huawei.location.logic.Vw) com.huawei.location.logic.Vw.yn()).yn(this.moduleName, activityTransitionRequest, this.callBackInfo.FB(), this.clientInfo);
            this.errorReason = "requestActivityConversionUpdates success";
            if (!(this.errorCode == 0 && this.callBackInfo.yn() == null)) {
                Gson instance2 = GsonUtil.getInstance();
                RequestActivityConversionResp requestActivityConversionResp = new RequestActivityConversionResp();
                doExecute(new RouterResponse(!(instance2 instanceof Gson) ? instance2.toJson((Object) requestActivityConversionResp) : GsonInstrumentation.toJson(instance2, (Object) requestActivityConversionResp), new StatusInfo(0, this.errorCode, this.errorReason)));
            }
            this.reportBuilder.yn((BaseLocationReq) this.requestActivityConversionReq);
            this.reportBuilder.yn().yn(String.valueOf(this.errorCode));
        } catch (LocationServiceException e11) {
            this.errorCode = e11.getExceptionCode();
            this.errorReason = "onRequest requestActivityConversionUpdates LocationServiceException:" + e11.getMessage();
        } catch (JsonSyntaxException unused) {
            LogConsole.i(TAG, "requestActivityConversionUpdatesTaskCall json parse failed");
            this.errorCode = 10000;
            this.errorReason = "onRequest requestActivityConversionUpdates exception";
        } catch (Exception unused2) {
            this.errorCode = 10000;
            this.errorReason = "onRequest requestActivityConversionUpdates exception";
        }
    }
}
