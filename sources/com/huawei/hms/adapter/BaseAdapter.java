package com.huawei.hms.adapter;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.ApkResolutionFailedManager;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.adapter.ui.BaseResolutionAdapter;
import com.huawei.hms.adapter.ui.UpdateAdapter;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.ResponseWrap;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IntentUtil;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.ResolutionFlagUtil;
import com.huawei.hms.utils.Util;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.lang.ref.WeakReference;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<ApiClient> f47769a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<Activity> f47770b;

    /* renamed from: c  reason: collision with root package name */
    private BaseCallBack f47771c;

    /* renamed from: d  reason: collision with root package name */
    private String f47772d;

    /* renamed from: e  reason: collision with root package name */
    private String f47773e;

    /* renamed from: f  reason: collision with root package name */
    private Parcelable f47774f;

    /* renamed from: g  reason: collision with root package name */
    private BaseCallBack f47775g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f47776h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Context f47777i;

    /* renamed from: j  reason: collision with root package name */
    private RequestHeader f47778j = new RequestHeader();
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public ResponseHeader f47779k = new ResponseHeader();
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public SystemObserver f47780l;

    public interface BaseCallBack {
        void onComplete(String str, String str2, Parcelable parcelable);

        void onError(String str);
    }

    public class BaseRequestResultCallback implements ResultCallback<ResolveResult<CoreBaseResponse>> {

        /* renamed from: a  reason: collision with root package name */
        private AtomicBoolean f47784a = new AtomicBoolean(true);

        public BaseRequestResultCallback() {
        }

        private void a(String str, BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse, int i11) {
            if (CommonCode.Resolution.HAS_RESOLUTION_FROM_APK.equals(str)) {
                Activity g11 = BaseAdapter.this.c();
                HMSLog.i("BaseAdapter", "activity is: " + g11);
                if (g11 == null || g11.isFinishing()) {
                    HMSLog.e("BaseAdapter", "activity null");
                    BaseAdapter.this.a(baseCallBack, coreBaseResponse);
                    return;
                }
                PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
                if (pendingIntent == null) {
                    Intent intent = coreBaseResponse.getIntent();
                    if (intent != null) {
                        if (Util.isAvailableLibExist(BaseAdapter.this.f47777i)) {
                            BaseAdapter.this.a(g11, (Parcelable) intent, coreBaseResponse);
                        } else {
                            baseCallBack.onError(BaseAdapter.this.b(-9));
                        }
                    } else if (i11 == 2) {
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseCallBack.onError(baseAdapter.b(baseAdapter.f47779k.getErrorCode()));
                    } else {
                        HMSLog.e("BaseAdapter", "hasResolution is true but NO_SOLUTION");
                        baseCallBack.onError(BaseAdapter.this.b(-4));
                    }
                } else if (Util.isAvailableLibExist(BaseAdapter.this.f47777i)) {
                    BaseAdapter.this.a(g11, (Parcelable) pendingIntent, coreBaseResponse);
                } else {
                    baseCallBack.onError(BaseAdapter.this.b(-9));
                }
            } else if ("installHMS".equals(str)) {
                HMSLog.i("BaseAdapter", "has resolutin: installHMS");
                a(baseCallBack, coreBaseResponse);
            } else {
                BaseAdapter.this.a(baseCallBack, coreBaseResponse);
            }
        }

        public void onResult(ResolveResult<CoreBaseResponse> resolveResult) {
            HMSLog.i("BaseAdapter", "BaseRequestResultCallback onResult");
            BaseCallBack a11 = BaseAdapter.this.b();
            if (a11 == null) {
                HMSLog.e("BaseAdapter", "onResult baseCallBack null");
            } else if (resolveResult == null) {
                HMSLog.e("BaseAdapter", "result null");
                a11.onError(BaseAdapter.this.b(-1));
            } else {
                CoreBaseResponse value = resolveResult.getValue();
                if (value == null) {
                    HMSLog.e("BaseAdapter", "response null");
                    a11.onError(BaseAdapter.this.b(-1));
                } else if (TextUtils.isEmpty(value.getJsonHeader())) {
                    HMSLog.e("BaseAdapter", "jsonHeader null");
                    a11.onError(BaseAdapter.this.b(-1));
                } else {
                    JsonUtil.jsonToEntity(value.getJsonHeader(), BaseAdapter.this.f47779k);
                    if (this.f47784a.compareAndSet(true, false)) {
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseAdapter.a(baseAdapter.f47777i, BaseAdapter.this.f47779k);
                    }
                    String resolution = BaseAdapter.this.f47779k.getResolution();
                    int statusCode = BaseAdapter.this.f47779k.getStatusCode();
                    HMSLog.i("BaseAdapter", "api is: " + BaseAdapter.this.f47779k.getApiName() + ", resolution: " + resolution + ", status_code: " + statusCode);
                    a(resolution, a11, value, statusCode);
                }
            }
        }

        private void a(final BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse) {
            if (!Util.isAvailableLibExist(BaseAdapter.this.f47777i)) {
                HMSLog.i("BaseAdapter", "handleSolutionForHms: no Available lib exist");
                baseCallBack.onError(BaseAdapter.this.b(-9));
                return;
            }
            Activity g11 = BaseAdapter.this.c();
            if (g11 == null || g11.isFinishing()) {
                HMSLog.e("BaseAdapter", "activity is null");
                try {
                    if (BaseAdapter.this.f47777i == null || !AvailableUtil.isInstallerLibExist(BaseAdapter.this.f47777i)) {
                        HMSLog.i("BaseAdapter", "pass ACTIVITY_NULL error");
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseCallBack.onError(baseAdapter.a(-3, baseAdapter.a(-3)).toJson());
                        return;
                    }
                    HMSLog.i("BaseAdapter", "pass installHMS intent");
                    Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(BaseAdapter.this.f47777i, UpdateAdapter.class.getName());
                    intentStartBridgeActivity.putExtra(CommonCode.MapKey.UPDATE_VERSION, ExceptionCode.CRASH_EXCEPTION);
                    intentStartBridgeActivity.putExtra("installHMS", "installHMS");
                    coreBaseResponse.setIntent(intentStartBridgeActivity);
                    BaseAdapter.this.a(baseCallBack, coreBaseResponse);
                } catch (RuntimeException unused) {
                    HMSLog.e("BaseAdapter", "handleSolutionForHms pass result failed");
                }
            } else {
                HMSLog.i("BaseAdapter", "start handleSolutionForHMS");
                AvailableAdapter availableAdapter = new AvailableAdapter(ExceptionCode.CRASH_EXCEPTION);
                availableAdapter.setCalledBySolutionInstallHms(true);
                availableAdapter.startResolution(g11, new AvailableAdapter.AvailableCallBack() {
                    public void onComplete(int i11) {
                        HMSLog.i("BaseAdapter", "complete handleSolutionForHMS, result: " + i11);
                        if (i11 == 0) {
                            HMSPackageManager.getInstance(BaseAdapter.this.f47777i).resetMultiServiceState();
                            BaseAdapter baseAdapter = BaseAdapter.this;
                            baseCallBack.onError(baseAdapter.a(11, baseAdapter.a(11)).toJson());
                            BaseAdapter.this.i();
                            return;
                        }
                        BaseAdapter baseAdapter2 = BaseAdapter.this;
                        baseCallBack.onError(baseAdapter2.a(i11, baseAdapter2.a(i11)).toJson());
                    }
                });
            }
        }
    }

    public static class a extends PendingResultImpl<ResolveResult<CoreBaseResponse>, CoreBaseResponse> {
        public a(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        /* renamed from: a */
        public ResolveResult<CoreBaseResponse> onComplete(CoreBaseResponse coreBaseResponse) {
            ResolveResult<CoreBaseResponse> resolveResult = new ResolveResult<>(coreBaseResponse);
            resolveResult.setStatus(Status.SUCCESS);
            return resolveResult;
        }
    }

    public BaseAdapter(ApiClient apiClient) {
        this.f47769a = new WeakReference<>(apiClient);
        if (apiClient == null) {
            HMSLog.w("BaseAdapter", "BaseAdapter constructor client is null");
            return;
        }
        this.f47777i = apiClient.getContext().getApplicationContext();
        HMSLog.i("BaseAdapter", "In constructor, WeakReference is " + this.f47769a);
    }

    private void h() {
        if (this.f47772d != null && this.f47775g != null) {
            this.f47779k = null;
            this.f47779k = new ResponseHeader();
            baseRequest(d(), e(), f(), a());
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        if (this.f47777i == null) {
            HMSLog.e("BaseAdapter", "sendBroadcastAfterResolutionHms, context is null");
            return;
        }
        Intent intent = new Intent("com.huawei.hms.core.action.SESSION_INVALID");
        try {
            intent.setPackage(this.f47777i.getPackageName());
            this.f47777i.sendBroadcast(intent);
        } catch (IllegalArgumentException unused) {
            HMSLog.e("BaseAdapter", "IllegalArgumentException when sendBroadcastAfterResolutionHms intent.setPackage");
        }
    }

    public void baseRequest(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        a(str, str2, parcelable, baseCallBack);
        if (this.f47769a == null) {
            HMSLog.e("BaseAdapter", "client is null");
            baseCallBack.onError(b(-2));
            return;
        }
        this.f47771c = baseCallBack;
        JsonUtil.jsonToEntity(str, this.f47778j);
        CoreBaseRequest coreBaseRequest = new CoreBaseRequest();
        coreBaseRequest.setJsonObject(str2);
        coreBaseRequest.setJsonHeader(str);
        coreBaseRequest.setParcelable(parcelable);
        String apiName = this.f47778j.getApiName();
        if (TextUtils.isEmpty(apiName)) {
            HMSLog.e("BaseAdapter", "get uri null");
            baseCallBack.onError(b(-5));
            return;
        }
        String transactionId = this.f47778j.getTransactionId();
        this.f47776h = transactionId;
        if (TextUtils.isEmpty(transactionId)) {
            HMSLog.e("BaseAdapter", "get transactionId null");
            baseCallBack.onError(b(-6));
            return;
        }
        HMSLog.i("BaseAdapter", "in baseRequest + uri is :" + apiName + ", transactionId is : " + this.f47776h);
        a(this.f47777i, this.f47778j);
        a(this.f47769a.get(), apiName, coreBaseRequest).setResultCallback(new BaseRequestResultCallback());
    }

    private String d() {
        return this.f47772d;
    }

    private String e() {
        return this.f47773e;
    }

    private Parcelable f() {
        return this.f47774f;
    }

    private void g() {
        this.f47780l = new SystemObserver() {
            public boolean onNoticeResult(int i11) {
                return false;
            }

            public boolean onSolutionResult(Intent intent, String str) {
                if (TextUtils.isEmpty(str)) {
                    HMSLog.e("BaseAdapter", "onSolutionResult but id is null");
                    BaseCallBack a11 = BaseAdapter.this.b();
                    if (a11 == null) {
                        HMSLog.e("BaseAdapter", "onSolutionResult baseCallBack null");
                        return true;
                    }
                    a11.onError(BaseAdapter.this.b(-6));
                    return true;
                } else if (!str.equals(BaseAdapter.this.f47776h)) {
                    return false;
                } else {
                    HMSLog.i("BaseAdapter", "onSolutionResult + id is :" + str);
                    BaseCallBack a12 = BaseAdapter.this.b();
                    if (a12 == null) {
                        HMSLog.e("BaseAdapter", "onResult baseCallBack null");
                        return true;
                    } else if (intent == null) {
                        HMSLog.e("BaseAdapter", "onSolutionResult but data is null");
                        String a13 = BaseAdapter.this.b(-7);
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseAdapter.a(baseAdapter.f47777i, BaseAdapter.this.f47779k, 0);
                        a12.onError(a13);
                        return true;
                    } else if (BaseAdapter.this.b(intent, a12) || BaseAdapter.this.a(intent, a12)) {
                        return true;
                    } else {
                        HMSLog.e("BaseAdapter", "onComplete for on activity result");
                        BaseAdapter.this.c(intent, a12);
                        return true;
                    }
                }
            }

            public boolean onUpdateResult(int i11) {
                return false;
            }
        };
    }

    /* access modifiers changed from: private */
    public Activity c() {
        if (this.f47770b == null) {
            HMSLog.i("BaseAdapter", "activityWeakReference is " + this.f47770b);
            return null;
        }
        ApiClient apiClient = this.f47769a.get();
        if (apiClient == null) {
            HMSLog.i("BaseAdapter", "tmpApi is null");
            return null;
        }
        HMSLog.i("BaseAdapter", "activityWeakReference has " + this.f47770b.get());
        return Util.getActiveActivity(this.f47770b.get(), apiClient.getContext());
    }

    /* access modifiers changed from: private */
    public BaseCallBack b() {
        BaseCallBack baseCallBack = this.f47771c;
        if (baseCallBack != null) {
            return baseCallBack;
        }
        HMSLog.e("BaseAdapter", "callback null");
        return null;
    }

    private void b(Context context, RequestHeader requestHeader) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    public BaseAdapter(ApiClient apiClient, Activity activity) {
        this.f47769a = new WeakReference<>(apiClient);
        this.f47770b = new WeakReference<>(activity);
        if (activity == null) {
            HMSLog.w("BaseAdapter", "BaseAdapter constructor activity is null");
            return;
        }
        this.f47777i = activity.getApplicationContext();
        HMSLog.i("BaseAdapter", "In constructor, activityWeakReference is " + this.f47770b + ", activity is " + this.f47770b.get());
    }

    private PendingResult<ResolveResult<CoreBaseResponse>> a(ApiClient apiClient, String str, CoreBaseRequest coreBaseRequest) {
        return new a(apiClient, str, coreBaseRequest);
    }

    private void c(int i11) {
        this.f47779k.setTransactionId(this.f47778j.getTransactionId());
        this.f47779k.setAppID(this.f47778j.getAppID());
        this.f47779k.setApiName(this.f47778j.getApiName());
        this.f47779k.setSrvName(this.f47778j.getSrvName());
        this.f47779k.setPkgName(this.f47778j.getPkgName());
        this.f47779k.setStatusCode(1);
        this.f47779k.setErrorCode(i11);
        this.f47779k.setErrorReason("Core error");
    }

    /* access modifiers changed from: private */
    public void a(BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse) {
        HMSLog.i("BaseAdapter", "baseCallBack.onComplete");
        PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
        if (pendingIntent != null) {
            baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), pendingIntent);
            return;
        }
        Intent modifyIntentBehaviorsSafe = IntentUtil.modifyIntentBehaviorsSafe(coreBaseResponse.getIntent());
        if (modifyIntentBehaviorsSafe != null) {
            baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), modifyIntentBehaviorsSafe);
        } else {
            baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), (Parcelable) null);
        }
    }

    /* access modifiers changed from: private */
    public String b(int i11) {
        c(i11);
        return this.f47779k.toJson();
    }

    private void b(String str) {
        this.f47773e = str;
    }

    /* access modifiers changed from: private */
    public boolean b(Intent intent, BaseCallBack baseCallBack) {
        if (!intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT)) {
            return false;
        }
        int intExtra = intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0);
        HMSLog.i("BaseAdapter", "kit_update_result is " + intExtra);
        if (intExtra == 1) {
            HMSLog.e("BaseAdapter", "kit update success,replay request");
            h();
        } else {
            HMSLog.e("BaseAdapter", "kit update failed");
            baseCallBack.onError(a(-10, a(intExtra)).toJson());
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void a(Activity activity, Parcelable parcelable, CoreBaseResponse coreBaseResponse) {
        HMSLog.i("BaseAdapter", "startResolution");
        RequestHeader requestHeader = this.f47778j;
        if (requestHeader != null) {
            b(this.f47777i, requestHeader);
        }
        if (this.f47780l == null) {
            g();
        }
        SystemManager.getSystemNotifier().registerObserver(this.f47780l);
        if (Build.VERSION.SDK_INT >= 29) {
            a(coreBaseResponse);
        }
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, BaseResolutionAdapter.class.getName());
        Bundle bundle = new Bundle();
        bundle.putParcelable("resolution", parcelable);
        intentStartBridgeActivity.putExtras(bundle);
        intentStartBridgeActivity.putExtra("transaction_id", this.f47776h);
        long time = new Timestamp(System.currentTimeMillis()).getTime();
        intentStartBridgeActivity.putExtra(CommonCode.MapKey.RESOLUTION_FLAG, time);
        ResolutionFlagUtil.getInstance().saveResolutionFlag(this.f47776h, time);
        activity.startActivity(intentStartBridgeActivity);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(android.content.Intent r7, com.huawei.hms.adapter.BaseAdapter.BaseCallBack r8) {
        /*
            r6 = this;
            java.lang.String r0 = "json_header"
            java.lang.String r0 = r7.getStringExtra(r0)
            java.lang.String r1 = "json_body"
            java.lang.String r1 = r7.getStringExtra(r1)
            java.lang.String r2 = "status_code"
            java.lang.Object r2 = com.huawei.hms.utils.JsonUtil.getInfoFromJsonobject(r0, r2)
            java.lang.String r3 = "error_code"
            java.lang.Object r3 = com.huawei.hms.utils.JsonUtil.getInfoFromJsonobject(r0, r3)
            java.lang.String r4 = "HMS_FOREGROUND_RES_UI"
            boolean r5 = r7.hasExtra(r4)
            if (r5 == 0) goto L_0x0035
            java.lang.String r7 = r7.getStringExtra(r4)
            java.lang.String r4 = "uiDuration"
            java.lang.Object r7 = com.huawei.hms.utils.JsonUtil.getInfoFromJsonobject(r7, r4)
            boolean r4 = r7 instanceof java.lang.Long
            if (r4 == 0) goto L_0x0035
            java.lang.Long r7 = (java.lang.Long) r7
            long r4 = r7.longValue()
            goto L_0x0037
        L_0x0035:
            r4 = 0
        L_0x0037:
            boolean r7 = r2 instanceof java.lang.Integer
            if (r7 == 0) goto L_0x005b
            boolean r7 = r3 instanceof java.lang.Integer
            if (r7 == 0) goto L_0x005b
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r7 = r2.intValue()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r2 = r3.intValue()
            r6.b((int) r2)
            com.huawei.hms.common.internal.ResponseHeader r2 = r6.f47779k
            r2.setStatusCode(r7)
            android.content.Context r7 = r6.f47777i
            com.huawei.hms.common.internal.ResponseHeader r2 = r6.f47779k
            r6.a((android.content.Context) r7, (com.huawei.hms.common.internal.ResponseHeader) r2, (long) r4)
            goto L_0x0066
        L_0x005b:
            r7 = -8
            r6.b((int) r7)
            android.content.Context r7 = r6.f47777i
            com.huawei.hms.common.internal.ResponseHeader r2 = r6.f47779k
            r6.a((android.content.Context) r7, (com.huawei.hms.common.internal.ResponseHeader) r2, (long) r4)
        L_0x0066:
            r7 = 0
            r8.onComplete(r0, r1, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.adapter.BaseAdapter.c(android.content.Intent, com.huawei.hms.adapter.BaseAdapter$BaseCallBack):void");
    }

    private void a(final CoreBaseResponse coreBaseResponse) {
        HMSLog.i("BaseAdapter", "postResolutionTimeoutHandle");
        ApkResolutionFailedManager.getInstance().postTask(this.f47776h, new Runnable() {
            public void run() {
                HMSLog.i("BaseAdapter", "postResolutionTimeoutHandle handle");
                SystemManager.getSystemNotifier().unRegisterObserver(BaseAdapter.this.f47780l);
                ApkResolutionFailedManager.getInstance().removeValueOnly(BaseAdapter.this.f47776h);
                BaseCallBack a11 = BaseAdapter.this.b();
                if (a11 == null) {
                    HMSLog.e("BaseAdapter", "timeoutRunnable callBack is null");
                } else {
                    BaseAdapter.this.a(a11, coreBaseResponse);
                }
            }
        });
    }

    private void a(Context context, RequestHeader requestHeader) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    /* access modifiers changed from: private */
    public void a(Context context, ResponseHeader responseHeader) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f47778j.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    /* access modifiers changed from: private */
    public void a(Context context, ResponseHeader responseHeader, long j11) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, String.valueOf(j11));
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f47778j.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    /* access modifiers changed from: private */
    public ResponseWrap a(int i11, String str) {
        c(i11);
        ResponseWrap responseWrap = new ResponseWrap(this.f47779k);
        responseWrap.setBody(str);
        return responseWrap;
    }

    /* access modifiers changed from: private */
    public String a(int i11) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i11);
        } catch (JSONException e11) {
            HMSLog.e("BaseAdapter", "buildBodyStr failed: " + e11.getMessage());
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    private void a(String str) {
        this.f47772d = str;
    }

    private void a(Parcelable parcelable) {
        this.f47774f = parcelable;
    }

    private BaseCallBack a() {
        return this.f47775g;
    }

    private void a(BaseCallBack baseCallBack) {
        this.f47775g = baseCallBack;
    }

    private void a(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        a(str);
        b(str2);
        a(parcelable);
        a(baseCallBack);
    }

    /* access modifiers changed from: private */
    public boolean a(Intent intent, BaseCallBack baseCallBack) {
        if (!intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            return false;
        }
        int intExtra = intent.getIntExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, 1001);
        if (intExtra == 1001) {
            HMSLog.i("BaseAdapter", "privacy_statement_confirm_result agreed: " + intExtra + ", replay request");
            h();
            return true;
        }
        HMSLog.i("BaseAdapter", "privacy_statement_confirm_result rejected: " + intExtra);
        baseCallBack.onError(a((int) CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE, a((int) CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE)).toJson());
        return true;
    }
}
