package com.huawei.hms.common;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.RequestManager;
import com.huawei.hms.common.internal.ResolveClientBean;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.common.internal.TaskApiCallWrapper;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsInnerClient;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class HuaweiApi<TOption extends Api.ApiOptions> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f48091a;

    /* renamed from: b  reason: collision with root package name */
    private TOption f48092b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Context f48093c;

    /* renamed from: d  reason: collision with root package name */
    private AbstractClientBuilder<?, TOption> f48094d;

    /* renamed from: e  reason: collision with root package name */
    private String f48095e;

    /* renamed from: f  reason: collision with root package name */
    private String f48096f;

    /* renamed from: g  reason: collision with root package name */
    private SubAppInfo f48097g;

    /* renamed from: h  reason: collision with root package name */
    private WeakReference<Activity> f48098h;

    /* renamed from: i  reason: collision with root package name */
    private int f48099i;

    /* renamed from: j  reason: collision with root package name */
    private int f48100j = 1;

    /* renamed from: k  reason: collision with root package name */
    private boolean f48101k = false;

    /* renamed from: l  reason: collision with root package name */
    private String f48102l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f48103m;

    /* renamed from: n  reason: collision with root package name */
    private RequestManager f48104n;

    public static class RequestHandler<OptionsT extends Api.ApiOptions> implements BaseHmsClient.ConnectionCallbacks, BaseHmsClient.OnConnectionFailedListener {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Queue<TaskApiCallbackWrapper> f48108a = new LinkedList();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final AnyClient f48109b;

        /* renamed from: c  reason: collision with root package name */
        private ConnectionResult f48110c;
        public final Queue<TaskApiCallbackWrapper> callbackWaitQueue = new LinkedList();
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final HuaweiApi<OptionsT> f48111d;

        /* renamed from: e  reason: collision with root package name */
        private ResolveClientBean f48112e;

        public RequestHandler(HuaweiApi<OptionsT> huaweiApi) {
            this.f48111d = huaweiApi;
            this.f48109b = huaweiApi.getClient(RequestManager.getHandler().getLooper(), this);
            this.f48110c = null;
        }

        public AnyClient getClient() {
            return this.f48109b;
        }

        public void onConnected() {
            HMSLog.i("HuaweiApi", "onConnected");
            BindResolveClients.getInstance().unRegister(this.f48112e);
            this.f48112e = null;
            RequestManager.getHandler().post(new Runnable() {
                public void run() {
                    RequestHandler.this.b();
                }
            });
        }

        public void onConnectionFailed(final ConnectionResult connectionResult) {
            HMSLog.i("HuaweiApi", "onConnectionFailed");
            BindResolveClients.getInstance().unRegister(this.f48112e);
            this.f48112e = null;
            RequestManager.getHandler().post(new Runnable() {
                public void run() {
                    RequestHandler.this.b(connectionResult);
                }
            });
        }

        public void onConnectionSuspended(int i11) {
            HMSLog.i("HuaweiApi", "onConnectionSuspended");
            BindResolveClients.getInstance().unRegister(this.f48112e);
            this.f48112e = null;
            RequestManager.getHandler().post(new Runnable() {
                public void run() {
                    RequestHandler.this.c();
                }
            });
        }

        public void postMessage(final TaskApiCallbackWrapper taskApiCallbackWrapper) {
            Context context;
            RequestManager.addToConnectedReqMap(taskApiCallbackWrapper.a().getTaskApiCall().getTransactionId(), this);
            this.f48108a.add(taskApiCallbackWrapper);
            String uri = taskApiCallbackWrapper.a().getTaskApiCall().getUri();
            if (this.f48111d.f48093c == null) {
                context = this.f48111d.getContext();
            } else {
                context = this.f48111d.f48093c;
            }
            String packageName = context.getPackageName();
            if (this.f48111d.f48093c != null) {
                HuaweiApi<OptionsT> huaweiApi = this.f48111d;
                huaweiApi.b(huaweiApi.f48093c);
            }
            final RequestHeader requestHeader = new RequestHeader();
            requestHeader.setSrvName(uri.split("\\.")[0]);
            requestHeader.setApiName(uri);
            requestHeader.setAppID(this.f48111d.getAppID() + "|" + this.f48111d.getSubAppID());
            requestHeader.setPkgName(packageName);
            requestHeader.setSessionId(this.f48109b.getSessionId());
            TaskApiCall taskApiCall = taskApiCallbackWrapper.a().getTaskApiCall();
            requestHeader.setTransactionId(a(taskApiCall.getTransactionId(), uri));
            requestHeader.setParcelable(taskApiCall.getParcelable());
            requestHeader.setKitSdkVersion(this.f48111d.getKitSdkVersion());
            requestHeader.setApiLevel(Math.max(this.f48111d.getApiLevel(), taskApiCall.getApiLevel()));
            this.f48109b.post(requestHeader, taskApiCall.getRequestJson(), new AnyClient.CallBack() {
                public void onCallback(IMessageEntity iMessageEntity, String str) {
                    AnyClient.CallBack b11 = taskApiCallbackWrapper.b();
                    if (b11 != null) {
                        b11.onCallback(iMessageEntity, str);
                    }
                    RequestManager.removeReqByTransId(requestHeader.getTransactionId());
                    RequestManager.getHandler().post(new Runnable() {
                        public void run() {
                            RequestHandler.this.f48108a.remove(taskApiCallbackWrapper);
                        }
                    });
                }
            });
        }

        private TaskApiCallbackWrapper b(final TaskApiCallWrapper taskApiCallWrapper) {
            return new TaskApiCallbackWrapper(taskApiCallWrapper, new AnyClient.CallBack() {

                /* renamed from: a  reason: collision with root package name */
                private AtomicBoolean f48113a = new AtomicBoolean(true);

                public void onCallback(IMessageEntity iMessageEntity, String str) {
                    if (!(iMessageEntity instanceof ResponseHeader)) {
                        HMSLog.e("HuaweiApi", "header is not instance of ResponseHeader");
                        return;
                    }
                    ResponseHeader responseHeader = (ResponseHeader) iMessageEntity;
                    if (responseHeader.getErrorCode() == 11) {
                        RequestHandler.this.a();
                        HMSLog.i("HuaweiApi", "unbind service");
                    }
                    if (!TextUtils.isEmpty(responseHeader.getResolution())) {
                        HMSLog.e("HuaweiApi", "Response has resolution: " + responseHeader.getResolution());
                    }
                    if (this.f48113a.compareAndSet(true, false)) {
                        HiAnalyticsInnerClient.reportEntryExit(RequestHandler.this.f48111d.getContext(), responseHeader, String.valueOf(RequestHandler.this.f48111d.getKitSdkVersion()));
                    }
                    taskApiCallWrapper.getTaskApiCall().onResponse(RequestHandler.this.f48109b, responseHeader, str, taskApiCallWrapper.getTaskCompletionSource());
                }
            });
        }

        /* access modifiers changed from: private */
        public void c() {
            HMSLog.i("HuaweiApi", "wait queue size = " + this.callbackWaitQueue.size());
            HMSLog.i("HuaweiApi", "run queue size = " + this.f48108a.size());
            for (TaskApiCallbackWrapper a11 : this.callbackWaitQueue) {
                a(a11);
            }
            for (TaskApiCallbackWrapper a12 : this.f48108a) {
                a(a12);
            }
            this.callbackWaitQueue.clear();
            this.f48108a.clear();
            this.f48110c = null;
            this.f48109b.disconnect();
        }

        /* access modifiers changed from: private */
        public void b(ConnectionResult connectionResult) {
            this.f48110c = connectionResult;
            boolean z11 = true;
            for (TaskApiCallbackWrapper a11 : this.callbackWaitQueue) {
                TaskApiCallWrapper a12 = a11.a();
                ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Failed:" + a(connectionResult) + "(" + connectionResult.getErrorCode() + ")");
                responseHeader.setTransactionId(a12.getTaskApiCall().getTransactionId());
                HiAnalyticsInnerClient.reportEntryExit(this.f48111d.getContext(), responseHeader, String.valueOf(this.f48111d.getKitSdkVersion()));
                if (this.f48110c.getResolution() != null && z11) {
                    responseHeader.setParcelable(this.f48110c.getResolution());
                    if (Util.isAvailableLibExist(this.f48111d.getContext()) && this.f48110c.getErrorCode() == 26) {
                        responseHeader.setResolution(CommonCode.Resolution.HAS_RESOLUTION);
                    }
                    z11 = false;
                }
                int errorCode = this.f48110c.getErrorCode();
                if (errorCode == 30 || errorCode == 31) {
                    responseHeader.setErrorCode(errorCode);
                }
                a12.getTaskApiCall().onResponse(this.f48109b, responseHeader, (String) null, a12.getTaskCompletionSource());
            }
            this.callbackWaitQueue.clear();
            this.f48108a.clear();
            this.f48110c = null;
            this.f48109b.disconnect();
        }

        public void a(TaskApiCallWrapper taskApiCallWrapper) {
            HMSLog.i("HuaweiApi", "sendRequest");
            TaskApiCallbackWrapper b11 = b(taskApiCallWrapper);
            if (HMSPackageManager.getInstance(this.f48111d.getContext()).isUpdateHmsForThirdPartyDevice()) {
                this.f48109b.disconnect();
            }
            int hmsVersionCode = HMSPackageManager.getInstance(this.f48111d.f48091a).getHmsVersionCode();
            if ((hmsVersionCode < 40000000 && hmsVersionCode > 0) && this.f48109b.isConnected() && !this.f48111d.f48103m && ((BaseHmsClient) this.f48109b).getAdapter().getServiceAction().equals("com.huawei.hms.core.aidlservice")) {
                int requestHmsVersionCode = this.f48109b.getRequestHmsVersionCode();
                if (requestHmsVersionCode <= taskApiCallWrapper.getTaskApiCall().getMinApkVersion()) {
                    requestHmsVersionCode = taskApiCallWrapper.getTaskApiCall().getMinApkVersion();
                }
                if (requestHmsVersionCode > hmsVersionCode) {
                    this.f48109b.disconnect();
                }
            }
            if (this.f48109b.isConnected()) {
                HMSLog.i("HuaweiApi", "isConnected:true.");
                BinderAdapter adapter = ((BaseHmsClient) this.f48109b).getAdapter();
                adapter.updateDelayTask();
                ((HmsClient) this.f48109b).setService(IAIDLInvoke.Stub.asInterface(adapter.getServiceBinder()));
                postMessage(b11);
                return;
            }
            HMSLog.i("HuaweiApi", "isConnected:false.");
            this.callbackWaitQueue.add(b11);
            ConnectionResult connectionResult = this.f48110c;
            if (connectionResult == null || connectionResult.getErrorCode() == 0) {
                RequestManager.addRequestToQueue(this);
                AnyClient anyClient = this.f48109b;
                if (anyClient instanceof BaseHmsClient) {
                    ((BaseHmsClient) anyClient).setInternalRequest(this);
                }
                a(taskApiCallWrapper.getTaskApiCall().getMinApkVersion(), b11);
                return;
            }
            HMSLog.i("HuaweiApi", "onConnectionFailed, ErrorCode:" + this.f48110c.getErrorCode());
            onConnectionFailed(this.f48110c);
        }

        /* access modifiers changed from: private */
        public void b() {
            this.f48110c = null;
            this.f48108a.clear();
            for (TaskApiCallbackWrapper postMessage : this.callbackWaitQueue) {
                postMessage(postMessage);
            }
            this.callbackWaitQueue.clear();
        }

        private String a(String str, String str2) {
            return TextUtils.isEmpty(str) ? TransactionIdCreater.getId(this.f48111d.getAppID(), str2) : str;
        }

        public synchronized void a(int i11, TaskApiCallbackWrapper taskApiCallbackWrapper) {
            if (this.f48109b.isConnected()) {
                HMSLog.d("HuaweiApi", "client is connected");
            } else if (this.f48109b.isConnecting()) {
                HMSLog.d("HuaweiApi", "client is isConnecting");
            } else {
                if (this.f48111d.getActivity() != null) {
                    if (this.f48112e == null) {
                        this.f48112e = new ResolveClientBean(this.f48109b, i11);
                    }
                    if (BindResolveClients.getInstance().isClientRegistered(this.f48112e)) {
                        HMSLog.i("HuaweiApi", "mResolveClientBean has already register, return!");
                        return;
                    }
                    BindResolveClients.getInstance().register(this.f48112e);
                }
                this.f48109b.connect(i11);
            }
        }

        public void a() {
            this.f48109b.disconnect();
        }

        private void a(TaskApiCallbackWrapper taskApiCallbackWrapper) {
            TaskApiCallWrapper a11 = taskApiCallbackWrapper.a();
            ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Suspended");
            responseHeader.setTransactionId(a11.getTaskApiCall().getTransactionId());
            a11.getTaskApiCall().onResponse(this.f48109b, responseHeader, (String) null, a11.getTaskCompletionSource());
        }

        private String a(ConnectionResult connectionResult) {
            if (Util.isAvailableLibExist(this.f48111d.getContext())) {
                int errorCode = connectionResult.getErrorCode();
                if (errorCode != -1) {
                    if (errorCode == 3) {
                        return "HuaWei Mobile Service is disabled";
                    }
                    if (errorCode != 8) {
                        if (errorCode != 10) {
                            if (errorCode == 13) {
                                return "update cancelled";
                            }
                            if (errorCode == 21) {
                                return "device is too old to be support";
                            }
                            switch (errorCode) {
                                case 25:
                                    return "failed to get update result";
                                case 26:
                                    return "update failed, because no activity incoming, can't pop update page";
                                case 27:
                                    return "there is already an update popup at the front desk, but it hasn't been clicked or it is not effective for a while";
                                default:
                                    return "unknown errorReason";
                            }
                        }
                    }
                    return "internal error";
                }
                return "get update result, but has other error codes";
            }
            int errorCode2 = connectionResult.getErrorCode();
            if (errorCode2 != -1) {
                if (errorCode2 != 8) {
                    if (errorCode2 != 10) {
                        return "unknown errorReason";
                    }
                }
                return "internal error";
            }
            return "get update result, but has other error codes";
            return "application configuration error, please developer check configuration";
        }
    }

    public static class TaskApiCallbackWrapper {

        /* renamed from: a  reason: collision with root package name */
        private final TaskApiCallWrapper f48124a;

        /* renamed from: b  reason: collision with root package name */
        private final AnyClient.CallBack f48125b;

        public TaskApiCallbackWrapper(TaskApiCallWrapper taskApiCallWrapper, AnyClient.CallBack callBack) {
            this.f48124a = taskApiCallWrapper;
            this.f48125b = callBack;
        }

        public TaskApiCallWrapper a() {
            return this.f48124a;
        }

        public AnyClient.CallBack b() {
            return this.f48125b;
        }
    }

    @Instrumented
    public static class a<OptionsT extends Api.ApiOptions> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final HuaweiApi<OptionsT> f48126a;

        /* renamed from: b  reason: collision with root package name */
        private final TaskApiCallWrapper f48127b;

        public a(HuaweiApi<OptionsT> huaweiApi, TaskApiCallWrapper taskApiCallWrapper) {
            this.f48126a = huaweiApi;
            this.f48127b = taskApiCallWrapper;
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0066  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(com.huawei.hms.common.HuaweiApi.RequestHandler r9, java.lang.Throwable r10) {
            /*
                r8 = this;
                java.lang.String r0 = "HuaweiApi"
                r1 = 1
                r2 = 0
                com.huawei.hms.common.internal.AnyClient r9 = r9.getClient()     // Catch:{ all -> 0x0036 }
                com.huawei.hms.common.internal.ResponseHeader r3 = new com.huawei.hms.common.internal.ResponseHeader     // Catch:{ all -> 0x0033 }
                java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x0033 }
                r4 = 907135001(0x3611c819, float:2.1723156E-6)
                r3.<init>(r1, r4, r10)     // Catch:{ all -> 0x0033 }
                org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ all -> 0x002f }
                r10.<init>()     // Catch:{ all -> 0x002f }
                java.lang.String r10 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r10)     // Catch:{ all -> 0x002f }
                com.huawei.hms.common.internal.TaskApiCallWrapper r4 = r8.f48127b     // Catch:{ all -> 0x002c }
                com.huawei.hmf.tasks.TaskCompletionSource r4 = r4.getTaskCompletionSource()     // Catch:{ all -> 0x002c }
                com.huawei.hms.common.internal.TaskApiCallWrapper r5 = r8.f48127b     // Catch:{ all -> 0x002a }
                com.huawei.hms.common.internal.TaskApiCall r2 = r5.getTaskApiCall()     // Catch:{ all -> 0x002a }
                goto L_0x0054
            L_0x002a:
                r5 = move-exception
                goto L_0x003c
            L_0x002c:
                r5 = move-exception
                r4 = r2
                goto L_0x003c
            L_0x002f:
                r5 = move-exception
                r10 = r2
                r4 = r10
                goto L_0x003c
            L_0x0033:
                r10 = move-exception
                r5 = r10
                goto L_0x0039
            L_0x0036:
                r9 = move-exception
                r5 = r9
                r9 = r2
            L_0x0039:
                r10 = r2
                r3 = r10
                r4 = r3
            L_0x003c:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "<notifyCpException> "
                r6.append(r7)
                java.lang.String r5 = r5.getMessage()
                r6.append(r5)
                java.lang.String r5 = r6.toString()
                com.huawei.hms.support.log.HMSLog.e(r0, r5)
            L_0x0054:
                if (r9 == 0) goto L_0x005f
                if (r3 == 0) goto L_0x005f
                if (r10 == 0) goto L_0x005f
                if (r4 == 0) goto L_0x005f
                if (r2 == 0) goto L_0x005f
                goto L_0x0060
            L_0x005f:
                r1 = 0
            L_0x0060:
                if (r1 == 0) goto L_0x0066
                r2.onResponse(r9, r3, r10, r4)
                goto L_0x006b
            L_0x0066:
                java.lang.String r9 = "<notifyCpException> isNotify is false, Can not notify CP."
                com.huawei.hms.support.log.HMSLog.e(r0, r9)
            L_0x006b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.HuaweiApi.a.a(com.huawei.hms.common.HuaweiApi$RequestHandler, java.lang.Throwable):void");
        }

        public void run() {
            RequestHandler requestHandler = new RequestHandler(this.f48126a);
            try {
                requestHandler.a(this.f48127b);
            } catch (Throwable th2) {
                a(requestHandler, th2);
            }
        }
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i11) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f48098h = new WeakReference<>(activity);
        a(activity, api, toption, abstractClientBuilder, i11, (String) null);
    }

    @Deprecated
    public Task<Boolean> disconnectService() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RequestManager.getInstance();
        RequestManager.getHandler().post(new Runnable() {
            public void run() {
                HuaweiApi.this.a((HuaweiApi<?>) this, (TaskCompletionSource<Boolean>) taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public <TResult, TClient extends AnyClient> Task<TResult> doWrite(TaskApiCall<TClient, TResult> taskApiCall) {
        String str;
        this.f48101k = true;
        if (taskApiCall == null) {
            HMSLog.e("HuaweiApi", "in doWrite:taskApiCall is null");
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(new ApiException(Status.FAILURE));
            return taskCompletionSource.getTask();
        }
        if (TextUtils.isEmpty(this.f48097g.getSubAppID())) {
            str = this.f48096f;
        } else {
            str = this.f48097g.getSubAppID();
        }
        HiAnalyticsInnerClient.reportEntryClient(this.f48091a, taskApiCall.getUri(), str, taskApiCall.getTransactionId(), String.valueOf(getKitSdkVersion()));
        if (this.f48104n == null) {
            this.f48104n = RequestManager.getInstance();
        }
        return a(taskApiCall);
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.f48098h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getApiLevel() {
        return this.f48100j;
    }

    public String getAppID() {
        return this.f48096f;
    }

    public AnyClient getClient(Looper looper, RequestHandler requestHandler) {
        return this.f48094d.buildClient(this.f48091a, getClientSetting(), requestHandler, requestHandler);
    }

    public ClientSettings getClientSetting() {
        ClientSettings clientSettings = new ClientSettings(this.f48091a.getPackageName(), this.f48091a.getClass().getName(), getScopes(), this.f48095e, (List<String>) null, this.f48097g);
        if (!this.f48103m) {
            String hMSPackageNameForMultiService = HMSPackageManager.getInstance(this.f48091a).getHMSPackageNameForMultiService();
            if (TextUtils.isEmpty(hMSPackageNameForMultiService)) {
                hMSPackageNameForMultiService = "com.huawei.hwid";
            }
            this.f48102l = hMSPackageNameForMultiService;
            HMSLog.i("HuaweiApi", "No setInnerHms, hms pkg name is " + this.f48102l);
        }
        clientSettings.setInnerHmsPkg(this.f48102l);
        clientSettings.setUseInnerHms(this.f48103m);
        WeakReference<Activity> weakReference = this.f48098h;
        if (weakReference != null) {
            clientSettings.setCpActivity(weakReference.get());
        }
        return clientSettings;
    }

    public Context getContext() {
        return this.f48091a;
    }

    public int getKitSdkVersion() {
        return this.f48099i;
    }

    public TOption getOption() {
        return this.f48092b;
    }

    public List<Scope> getScopes() {
        return Collections.emptyList();
    }

    public String getSubAppID() {
        return this.f48097g.getSubAppID();
    }

    public void setApiLevel(int i11) {
        this.f48100j = i11;
    }

    public void setHostContext(Context context) {
        this.f48093c = context;
    }

    public void setInnerHms() {
        this.f48102l = this.f48091a.getPackageName();
        this.f48103m = true;
        HMSLog.i("HuaweiApi", "<setInnerHms> init inner hms pkg info:" + this.f48102l);
    }

    public void setKitSdkVersion(int i11) {
        this.f48099i = i11;
    }

    public void setSubAppId(String str) throws ApiException {
        if (!setSubAppInfo(new SubAppInfo(str))) {
            throw new ApiException(Status.FAILURE);
        }
    }

    @Deprecated
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        HMSLog.i("HuaweiApi", "Enter setSubAppInfo");
        SubAppInfo subAppInfo2 = this.f48097g;
        if (subAppInfo2 != null && !TextUtils.isEmpty(subAppInfo2.getSubAppID())) {
            HMSLog.e("HuaweiApi", "subAppInfo is already set");
            return false;
        } else if (subAppInfo == null) {
            HMSLog.e("HuaweiApi", "subAppInfo is null");
            return false;
        } else {
            String subAppID = subAppInfo.getSubAppID();
            if (TextUtils.isEmpty(subAppID)) {
                HMSLog.e("HuaweiApi", "subAppId is empty");
                return false;
            } else if (subAppID.equals(this.f48095e)) {
                HMSLog.e("HuaweiApi", "subAppId is host appid");
                return false;
            } else if (this.f48101k) {
                HMSLog.e("HuaweiApi", "Client has sent request to Huawei Mobile Services, setting subAppId is not allowed");
                return false;
            } else {
                this.f48097g = new SubAppInfo(subAppInfo);
                return true;
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(Context context) {
        String appId = Util.getAppId(context);
        this.f48095e = appId;
        this.f48096f = appId;
    }

    private void a(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i11, String str) {
        this.f48091a = context.getApplicationContext();
        this.f48092b = toption;
        this.f48094d = abstractClientBuilder;
        b(context);
        this.f48097g = new SubAppInfo("");
        this.f48099i = i11;
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(this.f48095e)) {
                HMSLog.e("HuaweiApi", "subAppId is host appid");
            } else {
                HMSLog.i("HuaweiApi", "subAppId is " + str);
                this.f48097g = new SubAppInfo(str);
            }
        }
        a(context);
        if (Util.isAvailableLibExist(context)) {
            AvailableUtil.asyncCheckHmsUpdateInfo(context);
        }
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i11, String str) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f48098h = new WeakReference<>(activity);
        a(activity, api, toption, abstractClientBuilder, i11, str);
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f48098h = new WeakReference<>(activity);
        a(activity, api, toption, abstractClientBuilder, 0, (String) null);
    }

    private void a(Context context) {
        HMSBIInitializer.getInstance(context).initBI();
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i11) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        a(context, api, toption, abstractClientBuilder, i11, (String) null);
    }

    /* access modifiers changed from: private */
    public void a(HuaweiApi<?> huaweiApi, TaskCompletionSource<Boolean> taskCompletionSource) {
        HMSLog.i("HuaweiApi", "innerDisconnect.");
        try {
            huaweiApi.getClient(RequestManager.getHandler().getLooper(), (RequestHandler) null).disconnect();
            taskCompletionSource.setResult(Boolean.TRUE);
        } catch (Exception e11) {
            HMSLog.w("HuaweiApi", "disconnect the binder failed for:" + e11.getMessage());
        }
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i11, String str) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        a(context, api, toption, abstractClientBuilder, i11, str);
    }

    private <TResult, TClient extends AnyClient> Task<TResult> a(TaskApiCall<TClient, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource;
        if (taskApiCall.getToken() == null) {
            taskCompletionSource = new TaskCompletionSource();
        } else {
            taskCompletionSource = new TaskCompletionSource(taskApiCall.getToken());
        }
        RequestManager.getHandler().post(new a(this, new TaskApiCallWrapper(taskApiCall, taskCompletionSource)));
        return taskCompletionSource.getTask();
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        a(context, api, toption, abstractClientBuilder, 0, (String) null);
    }
}
