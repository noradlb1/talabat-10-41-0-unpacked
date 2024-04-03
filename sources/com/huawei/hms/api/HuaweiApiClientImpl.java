package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.core.aidl.CodecLookup;
import com.huawei.hms.core.aidl.DataBuffer;
import com.huawei.hms.core.aidl.IAIDLCallback;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.MessageCodec;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.core.ConnectService;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
public class HuaweiApiClientImpl extends HuaweiApiClient implements InnerApiClient, ServiceConnection {
    private static final Object A = new Object();
    private static final Object B = new Object();
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;

    /* renamed from: a  reason: collision with root package name */
    private int f48021a = -1;

    /* renamed from: b  reason: collision with root package name */
    private final Context f48022b;

    /* renamed from: c  reason: collision with root package name */
    private final String f48023c;

    /* renamed from: d  reason: collision with root package name */
    private String f48024d;

    /* renamed from: e  reason: collision with root package name */
    private String f48025e;

    /* renamed from: f  reason: collision with root package name */
    private volatile IAIDLInvoke f48026f;

    /* renamed from: g  reason: collision with root package name */
    private String f48027g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public WeakReference<Activity> f48028h;

    /* renamed from: i  reason: collision with root package name */
    private WeakReference<Activity> f48029i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f48030j = false;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public AtomicInteger f48031k = new AtomicInteger(1);

    /* renamed from: l  reason: collision with root package name */
    private List<Scope> f48032l;

    /* renamed from: m  reason: collision with root package name */
    private List<PermissionInfo> f48033m;

    /* renamed from: n  reason: collision with root package name */
    private Map<Api<?>, Api.ApiOptions> f48034n;

    /* renamed from: o  reason: collision with root package name */
    private SubAppInfo f48035o;

    /* renamed from: p  reason: collision with root package name */
    private long f48036p = 0;

    /* renamed from: q  reason: collision with root package name */
    private int f48037q = 0;

    /* renamed from: r  reason: collision with root package name */
    private final Object f48038r = new Object();

    /* renamed from: s  reason: collision with root package name */
    private final ReentrantLock f48039s;

    /* renamed from: t  reason: collision with root package name */
    private final Condition f48040t;

    /* renamed from: u  reason: collision with root package name */
    private ConnectionResult f48041u;

    /* renamed from: v  reason: collision with root package name */
    private HuaweiApiClient.ConnectionCallbacks f48042v;

    /* renamed from: w  reason: collision with root package name */
    private HuaweiApiClient.OnConnectionFailedListener f48043w;

    /* renamed from: x  reason: collision with root package name */
    private Handler f48044x;

    /* renamed from: y  reason: collision with root package name */
    private Handler f48045y;

    /* renamed from: z  reason: collision with root package name */
    private CheckUpdatelistener f48046z;

    public class a implements Handler.Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            if (message == null || message.what != 2) {
                return false;
            }
            HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service time out");
            if (HuaweiApiClientImpl.this.f48031k.get() == 5) {
                HuaweiApiClientImpl.this.c(1);
                HuaweiApiClientImpl.this.b();
            }
            return true;
        }
    }

    public class b implements Handler.Callback {
        public b() {
        }

        public boolean handleMessage(Message message) {
            if (message == null || message.what != 3) {
                return false;
            }
            HMSLog.e("HuaweiApiClientImpl", "In connect, process time out");
            if (HuaweiApiClientImpl.this.f48031k.get() == 2) {
                HuaweiApiClientImpl.this.c(1);
                HuaweiApiClientImpl.this.b();
            }
            return true;
        }
    }

    public class c extends IAIDLCallback.Stub {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ResultCallback f48049a;

        public c(ResultCallback resultCallback) {
            this.f48049a = resultCallback;
        }

        public void call(DataBuffer dataBuffer) {
            if (dataBuffer != null) {
                MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
                ResponseHeader responseHeader = new ResponseHeader();
                find.decode(dataBuffer.header, responseHeader);
                BundleResult bundleResult = new BundleResult(responseHeader.getStatusCode(), dataBuffer.getBody());
                HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult");
                this.f48049a.onResult(bundleResult);
                return;
            }
            HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult -1");
            this.f48049a.onResult(new BundleResult(-1, (Bundle) null));
        }
    }

    public static class d extends PendingResultImpl<Status, IMessageEntity> {
        public d(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        /* renamed from: a */
        public Status onComplete(IMessageEntity iMessageEntity) {
            return new Status(0);
        }
    }

    public class e implements ResultCallback<ResolveResult<ConnectResp>> {

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ResolveResult f48052a;

            public a(ResolveResult resolveResult) {
                this.f48052a = resolveResult;
            }

            public void run() {
                HuaweiApiClientImpl.this.a((ResolveResult<ConnectResp>) this.f48052a);
            }
        }

        private e() {
        }

        /* renamed from: a */
        public void onResult(ResolveResult<ConnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new a(resolveResult));
        }

        public /* synthetic */ e(HuaweiApiClientImpl huaweiApiClientImpl, a aVar) {
            this();
        }
    }

    public class f implements ResultCallback<ResolveResult<DisconnectResp>> {

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ResolveResult f48055a;

            public a(ResolveResult resolveResult) {
                this.f48055a = resolveResult;
            }

            public void run() {
                HuaweiApiClientImpl.this.b((ResolveResult<DisconnectResp>) this.f48055a);
            }
        }

        private f() {
        }

        /* renamed from: a */
        public void onResult(ResolveResult<DisconnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new a(resolveResult));
        }

        public /* synthetic */ f(HuaweiApiClientImpl huaweiApiClientImpl, a aVar) {
            this();
        }
    }

    public class g implements ResultCallback<ResolveResult<JosGetNoticeResp>> {
        private g() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
            r4 = r4.getValue();
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onResult(com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.JosGetNoticeResp> r4) {
            /*
                r3 = this;
                if (r4 == 0) goto L_0x004c
                com.huawei.hms.support.api.client.Status r0 = r4.getStatus()
                boolean r0 = r0.isSuccess()
                if (r0 == 0) goto L_0x004c
                java.lang.Object r4 = r4.getValue()
                com.huawei.hms.support.api.entity.core.JosGetNoticeResp r4 = (com.huawei.hms.support.api.entity.core.JosGetNoticeResp) r4
                android.content.Intent r0 = r4.getNoticeIntent()
                if (r0 == 0) goto L_0x004c
                int r4 = r4.getStatusCode()
                if (r4 != 0) goto L_0x004c
                java.lang.String r4 = "get notice has intent."
                java.lang.String r1 = "HuaweiApiClientImpl"
                com.huawei.hms.support.log.HMSLog.i(r1, r4)
                com.huawei.hms.api.HuaweiApiClientImpl r4 = com.huawei.hms.api.HuaweiApiClientImpl.this
                java.lang.ref.WeakReference r4 = r4.f48028h
                java.lang.Object r4 = r4.get()
                android.app.Activity r4 = (android.app.Activity) r4
                com.huawei.hms.api.HuaweiApiClientImpl r2 = com.huawei.hms.api.HuaweiApiClientImpl.this
                android.app.Activity r2 = r2.getTopActivity()
                android.app.Activity r4 = com.huawei.hms.utils.Util.getValidActivity(r4, r2)
                if (r4 != 0) goto L_0x0043
                java.lang.String r4 = "showNotice no valid activity!"
                com.huawei.hms.support.log.HMSLog.e(r1, r4)
                return
            L_0x0043:
                com.huawei.hms.api.HuaweiApiClientImpl r1 = com.huawei.hms.api.HuaweiApiClientImpl.this
                r2 = 1
                boolean unused = r1.f48030j = r2
                r4.startActivity(r0)
            L_0x004c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.api.HuaweiApiClientImpl.g.onResult(com.huawei.hms.support.api.ResolveResult):void");
        }

        public /* synthetic */ g(HuaweiApiClientImpl huaweiApiClientImpl, a aVar) {
            this();
        }
    }

    public HuaweiApiClientImpl(Context context) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f48039s = reentrantLock;
        this.f48040t = reentrantLock.newCondition();
        this.f48044x = null;
        this.f48045y = null;
        this.f48046z = null;
        this.f48022b = context;
        String appId = Util.getAppId(context);
        this.f48023c = appId;
        this.f48024d = appId;
        this.f48025e = Util.getCpId(context);
    }

    private DisconnectInfo d() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.f48034n;
        if (map != null) {
            for (Api<?> apiName : map.keySet()) {
                arrayList.add(apiName.getApiName());
            }
        }
        return new DisconnectInfo(this.f48032l, arrayList);
    }

    private int e() {
        int hmsVersion = Util.getHmsVersion(this.f48022b);
        if (hmsVersion != 0 && hmsVersion >= 20503000) {
            return hmsVersion;
        }
        int f11 = f();
        if (g()) {
            if (f11 < 20503000) {
                return 20503000;
            }
            return f11;
        } else if (f11 < 20600000) {
            return 20600000;
        } else {
            return f11;
        }
    }

    private int f() {
        Integer num;
        int intValue;
        Map<Api<?>, Api.ApiOptions> apiMap = getApiMap();
        int i11 = 0;
        if (apiMap == null) {
            return 0;
        }
        for (Api<?> apiName : apiMap.keySet()) {
            String apiName2 = apiName.getApiName();
            if (!TextUtils.isEmpty(apiName2) && (num = HuaweiApiAvailability.getApiMap().get(apiName2)) != null && (intValue = num.intValue()) > i11) {
                i11 = intValue;
            }
        }
        return i11;
    }

    private boolean g() {
        Map<Api<?>, Api.ApiOptions> map = this.f48034n;
        if (map == null) {
            return false;
        }
        for (Api<?> apiName : map.keySet()) {
            if (HuaweiApiAvailability.HMS_API_NAME_GAME.equals(apiName.getApiName())) {
                return true;
            }
        }
        return false;
    }

    private void h() {
        Handler handler = this.f48044x;
        if (handler != null) {
            handler.removeMessages(2);
        } else {
            this.f48044x = new Handler(Looper.getMainLooper(), new a());
        }
        this.f48044x.sendEmptyMessageDelayed(2, 5000);
    }

    private void i() {
        synchronized (B) {
            Handler handler = this.f48045y;
            if (handler != null) {
                handler.removeMessages(3);
            } else {
                this.f48045y = new Handler(Looper.getMainLooper(), new b());
            }
            boolean sendEmptyMessageDelayed = this.f48045y.sendEmptyMessageDelayed(3, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
            HMSLog.d("HuaweiApiClientImpl", "sendEmptyMessageDelayed for onConnectionResult 3 seconds. the result is : " + sendEmptyMessageDelayed);
        }
    }

    private void j() {
        HMSLog.i("HuaweiApiClientImpl", "Enter sendConnectApiServceRequest.");
        ConnectService.connect(this, c()).setResultCallback(new e(this, (a) null));
    }

    private void k() {
        ConnectService.disconnect(this, d()).setResultCallback(new f(this, (a) null));
    }

    private void l() {
        HMSLog.i("HuaweiApiClientImpl", "Enter sendForceConnectApiServceRequest.");
        ConnectService.forceConnect(this, c()).setResultCallback(new e(this, (a) null));
    }

    private void m() {
        if (this.f48030j) {
            HMSLog.i("HuaweiApiClientImpl", "Connect notice has been shown.");
        } else if (HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.f48022b) == 0) {
            ConnectService.getNotice(this, 0, "6.11.0.302").setResultCallback(new g(this, (a) null));
        }
    }

    private void n() {
        Util.unBindServiceCatchException(this.f48022b, this);
        this.f48026f = null;
    }

    public int asyncRequest(Bundle bundle, String str, int i11, ResultCallback<BundleResult> resultCallback) {
        HMSLog.i("HuaweiApiClientImpl", "Enter asyncRequest.");
        if (resultCallback == null || str == null || bundle == null) {
            HMSLog.e("HuaweiApiClientImpl", "arguments is invalid.");
            return CommonCode.ErrorCode.ARGUMENTS_INVALID;
        } else if (!innerIsConnected()) {
            HMSLog.e("HuaweiApiClientImpl", "client is unConnect.");
            return CommonCode.ErrorCode.CLIENT_API_INVALID;
        } else {
            DataBuffer dataBuffer = new DataBuffer(str, i11);
            MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
            dataBuffer.addBody(bundle);
            RequestHeader requestHeader = new RequestHeader(getAppID(), getPackageName(), 61100302, getSessionId());
            requestHeader.setApiNameList(getApiNameList());
            dataBuffer.header = find.encode(requestHeader, new Bundle());
            try {
                getService().asyncCall(dataBuffer, new c(resultCallback));
                return 0;
            } catch (RemoteException e11) {
                HMSLog.e("HuaweiApiClientImpl", "remote exception:" + e11.getMessage());
                return CommonCode.ErrorCode.INTERNAL_ERROR;
            }
        }
    }

    public void checkUpdate(Activity activity, CheckUpdatelistener checkUpdatelistener) {
        if (checkUpdatelistener == null) {
            HMSLog.e("HuaweiApiClientImpl", "listener is null!");
        } else if (activity == null || activity.isFinishing()) {
            HMSLog.e("HuaweiApiClientImpl", "checkUpdate, activity is illegal: " + activity);
            checkUpdatelistener.onResult(-1);
        } else {
            this.f48046z = checkUpdatelistener;
            try {
                Class<?> cls = Class.forName("com.huawei.hms.update.manager.CheckUpdateLegacy");
                Object newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                cls.getMethod("initCheckUpdateCallBack", new Class[]{Object.class, Activity.class}).invoke(newInstance, new Object[]{this, activity});
            } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e11) {
                HMSLog.e("HuaweiApiClientImpl", "invoke CheckUpdateLegacy.initCheckUpdateCallBack fail. " + e11.getMessage());
                checkUpdatelistener.onResult(-1);
            }
        }
    }

    public void connect(Activity activity) {
        HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 61100302 ======");
        int i11 = this.f48031k.get();
        HMSLog.i("HuaweiApiClientImpl", "Enter connect, Connection Status: " + i11);
        if (i11 != 3 && i11 != 5 && i11 != 2 && i11 != 4) {
            if (activity != null) {
                this.f48028h = new WeakReference<>(activity);
                this.f48029i = new WeakReference<>(activity);
            }
            this.f48024d = TextUtils.isEmpty(this.f48023c) ? Util.getAppId(this.f48022b) : this.f48023c;
            int e11 = e();
            HMSLog.i("HuaweiApiClientImpl", "connect minVersion:" + e11);
            HuaweiApiAvailability.setServicesVersionCode(e11);
            int isHuaweiMobileServicesAvailable = HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(this.f48022b, e11);
            HMSLog.i("HuaweiApiClientImpl", "In connect, isHuaweiMobileServicesAvailable result: " + isHuaweiMobileServicesAvailable);
            this.f48037q = HMSPackageManager.getInstance(this.f48022b).getHmsMultiServiceVersion();
            if (isHuaweiMobileServicesAvailable == 0) {
                c(5);
                if (this.f48026f == null) {
                    a();
                    return;
                }
                c(2);
                j();
                i();
            } else if (this.f48043w != null) {
                b(isHuaweiMobileServicesAvailable);
            }
        }
    }

    public void connectForeground() {
        String str;
        HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 61100302 ======");
        int i11 = this.f48031k.get();
        HMSLog.i("HuaweiApiClientImpl", "Enter forceConnect, Connection Status: " + i11);
        if (i11 != 3 && i11 != 5 && i11 != 2 && i11 != 4) {
            if (TextUtils.isEmpty(this.f48023c)) {
                str = Util.getAppId(this.f48022b);
            } else {
                str = this.f48023c;
            }
            this.f48024d = str;
            l();
        }
    }

    public void disableLifeCycleManagement(Activity activity) {
        if (this.f48021a >= 0) {
            AutoLifecycleFragment.getInstance(activity).stopAutoManage(this.f48021a);
            return;
        }
        throw new IllegalStateException("disableLifeCycleManagement failed");
    }

    public PendingResult<Status> discardAndReconnect() {
        return new d(this, (String) null, (IMessageEntity) null);
    }

    public void disconnect() {
        int i11 = this.f48031k.get();
        HMSLog.i("HuaweiApiClientImpl", "Enter disconnect, Connection Status: " + i11);
        if (i11 == 2) {
            c(4);
        } else if (i11 == 3) {
            c(4);
            k();
        } else if (i11 == 5) {
            a(2);
            c(4);
        }
    }

    public Map<Api<?>, Api.ApiOptions> getApiMap() {
        return this.f48034n;
    }

    public List<String> getApiNameList() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.f48034n;
        if (map != null) {
            for (Api<?> apiName : map.keySet()) {
                arrayList.add(apiName.getApiName());
            }
        }
        return arrayList;
    }

    public String getAppID() {
        return this.f48024d;
    }

    public ConnectionResult getConnectionResult(Api<?> api) {
        if (isConnected()) {
            this.f48041u = null;
            return new ConnectionResult(0, (PendingIntent) null);
        }
        ConnectionResult connectionResult = this.f48041u;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, (PendingIntent) null);
    }

    public Context getContext() {
        return this.f48022b;
    }

    public String getCpID() {
        return this.f48025e;
    }

    public String getPackageName() {
        return this.f48022b.getPackageName();
    }

    public List<PermissionInfo> getPermissionInfos() {
        return this.f48033m;
    }

    public List<Scope> getScopes() {
        return this.f48032l;
    }

    public IAIDLInvoke getService() {
        return this.f48026f;
    }

    public String getSessionId() {
        return this.f48027g;
    }

    public final SubAppInfo getSubAppInfo() {
        return this.f48035o;
    }

    public Activity getTopActivity() {
        WeakReference<Activity> weakReference = this.f48029i;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    public boolean hasConnectedApi(Api<?> api) {
        return isConnected();
    }

    public boolean hasConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.f48038r) {
            if (this.f48043w == onConnectionFailedListener) {
                return true;
            }
            return false;
        }
    }

    public boolean hasConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.f48038r) {
            if (this.f48042v == connectionCallbacks) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|11|12|5) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.api.ConnectionResult holdUpConnect() {
        /*
            r3 = this;
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L_0x0065
            java.util.concurrent.locks.ReentrantLock r0 = r3.f48039s
            r0.lock()
            r0 = 0
            r3.connect((android.app.Activity) r0)     // Catch:{ all -> 0x005e }
        L_0x0013:
            boolean r1 = r3.isConnecting()     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x0033
            java.util.concurrent.locks.Condition r1 = r3.f48040t     // Catch:{ InterruptedException -> 0x001f }
            r1.await()     // Catch:{ InterruptedException -> 0x001f }
            goto L_0x0013
        L_0x001f:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x005e }
            r1.interrupt()     // Catch:{ all -> 0x005e }
            com.huawei.hms.api.ConnectionResult r1 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x005e }
            r2 = 15
            r1.<init>((int) r2, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x005e }
            java.util.concurrent.locks.ReentrantLock r0 = r3.f48039s
            r0.unlock()
            return r1
        L_0x0033:
            boolean r1 = r3.isConnected()     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x0047
            r3.f48041u = r0     // Catch:{ all -> 0x005e }
            com.huawei.hms.api.ConnectionResult r1 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x005e }
            r2 = 0
            r1.<init>((int) r2, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x005e }
            java.util.concurrent.locks.ReentrantLock r0 = r3.f48039s
            r0.unlock()
            return r1
        L_0x0047:
            com.huawei.hms.api.ConnectionResult r1 = r3.f48041u     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x0051
            java.util.concurrent.locks.ReentrantLock r0 = r3.f48039s
            r0.unlock()
            return r1
        L_0x0051:
            com.huawei.hms.api.ConnectionResult r1 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x005e }
            r2 = 13
            r1.<init>((int) r2, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x005e }
            java.util.concurrent.locks.ReentrantLock r0 = r3.f48039s
            r0.unlock()
            return r1
        L_0x005e:
            r0 = move-exception
            java.util.concurrent.locks.ReentrantLock r1 = r3.f48039s
            r1.unlock()
            throw r0
        L_0x0065:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "blockingConnect must not be called on the UI thread"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.api.HuaweiApiClientImpl.holdUpConnect():com.huawei.hms.api.ConnectionResult");
    }

    public boolean innerIsConnected() {
        return this.f48031k.get() == 3 || this.f48031k.get() == 4;
    }

    public boolean isConnected() {
        if (this.f48037q == 0) {
            this.f48037q = HMSPackageManager.getInstance(this.f48022b).getHmsMultiServiceVersion();
        }
        if (this.f48037q >= 20504000) {
            return innerIsConnected();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f48036p;
        if (currentTimeMillis > 0 && currentTimeMillis < 300000) {
            return innerIsConnected();
        }
        if (!innerIsConnected()) {
            return false;
        }
        Status status = ConnectService.checkconnect(this, new CheckConnectInfo()).awaitOnAnyThread(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS).getStatus();
        if (status.isSuccess()) {
            this.f48036p = System.currentTimeMillis();
            return true;
        }
        int statusCode = status.getStatusCode();
        HMSLog.i("HuaweiApiClientImpl", "isConnected is false, statuscode:" + statusCode);
        if (statusCode == 907135004) {
            return false;
        }
        n();
        c(1);
        this.f48036p = System.currentTimeMillis();
        return false;
    }

    public boolean isConnecting() {
        int i11 = this.f48031k.get();
        return i11 == 2 || i11 == 5;
    }

    public void onPause(Activity activity) {
        HMSLog.i("HuaweiApiClientImpl", "onPause");
    }

    public void onResult(int i11) {
        this.f48046z.onResult(i11);
    }

    public void onResume(Activity activity) {
        if (activity != null) {
            HMSLog.i("HuaweiApiClientImpl", "onResume");
            this.f48029i = new WeakReference<>(activity);
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        PendingIntent pendingIntent;
        HMSLog.i("HuaweiApiClientImpl", "HuaweiApiClientImpl Enter onServiceConnected.");
        a(2);
        this.f48026f = IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.f48026f == null) {
            HMSLog.e("HuaweiApiClientImpl", "In onServiceConnected, mCoreService must not be null.");
            n();
            c(1);
            if (this.f48043w != null) {
                WeakReference<Activity> weakReference = this.f48028h;
                if (weakReference == null || weakReference.get() == null) {
                    pendingIntent = null;
                } else {
                    pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f48028h.get(), 10);
                }
                ConnectionResult connectionResult = new ConnectionResult(10, pendingIntent);
                this.f48043w.onConnectionFailed(connectionResult);
                this.f48041u = connectionResult;
            }
        } else if (this.f48031k.get() == 5) {
            c(2);
            j();
            i();
        } else if (this.f48031k.get() != 3) {
            n();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onServiceDisconnected.");
        this.f48026f = null;
        c(1);
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f48042v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnectionSuspended(1);
        }
    }

    public void print(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public void reconnect() {
        disconnect();
        connect((Activity) null);
    }

    public void removeConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.f48038r) {
            if (this.f48043w != onConnectionFailedListener) {
                HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionFailedListener: this onConnectionFailedListener has not been registered");
            } else {
                this.f48043w = null;
            }
        }
    }

    public void removeConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.f48038r) {
            if (this.f48042v != connectionCallbacks) {
                HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionCallback: this connectionCallbacksListener has not been registered");
            } else {
                this.f48042v = null;
            }
        }
    }

    public void resetListener() {
        this.f48046z = null;
    }

    public void setApiMap(Map<Api<?>, Api.ApiOptions> map) {
        this.f48034n = map;
    }

    public void setAutoLifecycleClientId(int i11) {
        this.f48021a = i11;
    }

    public void setConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f48042v = connectionCallbacks;
    }

    public void setConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f48043w = onConnectionFailedListener;
    }

    public void setHasShowNotice(boolean z11) {
        this.f48030j = z11;
    }

    public void setPermissionInfos(List<PermissionInfo> list) {
        this.f48033m = list;
    }

    public void setScopes(List<Scope> list) {
        this.f48032l = list;
    }

    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        String str;
        HMSLog.i("HuaweiApiClientImpl", "Enter setSubAppInfo");
        if (subAppInfo == null) {
            HMSLog.e("HuaweiApiClientImpl", "subAppInfo is null");
            return false;
        }
        String subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            HMSLog.e("HuaweiApiClientImpl", "subAppId is empty");
            return false;
        }
        if (TextUtils.isEmpty(this.f48023c)) {
            str = Util.getAppId(this.f48022b);
        } else {
            str = this.f48023c;
        }
        if (subAppID.equals(str)) {
            HMSLog.e("HuaweiApiClientImpl", "subAppId is host appid");
            return false;
        }
        this.f48035o = new SubAppInfo(subAppInfo);
        return true;
    }

    /* access modifiers changed from: private */
    public void c(int i11) {
        this.f48031k.set(i11);
        if (i11 == 1 || i11 == 3 || i11 == 2) {
            this.f48039s.lock();
            try {
                this.f48040t.signalAll();
            } finally {
                this.f48039s.unlock();
            }
        }
    }

    private void b(int i11) {
        PendingIntent pendingIntent;
        WeakReference<Activity> weakReference = this.f48028h;
        if (weakReference == null || weakReference.get() == null) {
            pendingIntent = null;
        } else {
            pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f48028h.get(), i11);
            HMSLog.i("HuaweiApiClientImpl", "connect 2.0 fail: " + i11);
        }
        ConnectionResult connectionResult = new ConnectionResult(i11, pendingIntent);
        this.f48043w.onConnectionFailed(connectionResult);
        this.f48041u = connectionResult;
    }

    private void a() {
        Intent intent = new Intent(HMSPackageManager.getInstance(this.f48022b).getServiceAction());
        HMSPackageManager.getInstance(this.f48022b).refreshForMultiService();
        try {
            String hMSPackageNameForMultiService = HMSPackageManager.getInstance(this.f48022b).getHMSPackageNameForMultiService();
            if (TextUtils.isEmpty(hMSPackageNameForMultiService)) {
                HMSLog.e("HuaweiApiClientImpl", "servicePackageName is empty, Service is invalid, bind core service fail.");
                c(1);
                b();
                return;
            }
            intent.setPackage(hMSPackageNameForMultiService);
            synchronized (A) {
                if (this.f48022b.bindService(intent, this, 1)) {
                    h();
                    return;
                }
                c(1);
                HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service fail");
                b();
            }
        } catch (IllegalArgumentException unused) {
            HMSLog.e("HuaweiApiClientImpl", "IllegalArgumentException when bindCoreService intent.setPackage");
            c(1);
            HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service fail");
            b();
        }
    }

    private ConnectInfo c() {
        String packageSignature = new PackageManagerHelper(this.f48022b).getPackageSignature(this.f48022b.getPackageName());
        if (packageSignature == null) {
            packageSignature = "";
        }
        SubAppInfo subAppInfo = this.f48035o;
        return new ConnectInfo(getApiNameList(), this.f48032l, packageSignature, subAppInfo == null ? null : subAppInfo.getSubAppID());
    }

    /* access modifiers changed from: private */
    public void b() {
        n();
        if (this.f48043w != null) {
            int i11 = UIUtil.isBackground(this.f48022b) ? 7 : 6;
            WeakReference<Activity> weakReference = this.f48028h;
            ConnectionResult connectionResult = new ConnectionResult(i11, (weakReference == null || weakReference.get() == null) ? null : HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f48028h.get(), i11));
            this.f48043w.onConnectionFailed(connectionResult);
            this.f48041u = connectionResult;
        }
    }

    private void c(ResolveResult<ConnectResp> resolveResult) {
        if (resolveResult.getValue() != null) {
            ProtocolNegotiate.getInstance().negotiate(resolveResult.getValue().protocolVersion);
        }
        c(3);
        this.f48041u = null;
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f48042v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnected();
        }
        if (this.f48028h != null) {
            m();
        }
        for (Map.Entry next : getApiMap().entrySet()) {
            if (((Api) next.getKey()).getmConnetctPostList() != null && !((Api) next.getKey()).getmConnetctPostList().isEmpty()) {
                HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, get the ConnetctPostList ");
                for (ConnectionPostProcessor run : ((Api) next.getKey()).getmConnetctPostList()) {
                    HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, processor.run");
                    run.run(this, this.f48028h);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(ResolveResult<DisconnectResp> resolveResult) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onDisconnectionResult, disconnect from server result: " + resolveResult.getStatus().getStatusCode());
        n();
        c(1);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:14|15|16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        return new com.huawei.hms.api.ConnectionResult(15, (android.app.PendingIntent) null);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.api.ConnectionResult holdUpConnect(long r4, java.util.concurrent.TimeUnit r6) {
        /*
            r3 = this;
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L_0x0080
            java.util.concurrent.locks.ReentrantLock r0 = r3.f48039s
            r0.lock()
            r0 = 0
            r3.connect((android.app.Activity) r0)     // Catch:{ all -> 0x0079 }
            long r4 = r6.toNanos(r4)     // Catch:{ all -> 0x0079 }
        L_0x0017:
            boolean r6 = r3.isConnecting()     // Catch:{ all -> 0x0079 }
            if (r6 == 0) goto L_0x004e
            r1 = 0
            int r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r6 > 0) goto L_0x0033
            r3.disconnect()     // Catch:{ all -> 0x0079 }
            com.huawei.hms.api.ConnectionResult r4 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x0079 }
            r5 = 14
            r4.<init>((int) r5, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x0079 }
            java.util.concurrent.locks.ReentrantLock r5 = r3.f48039s
            r5.unlock()
            return r4
        L_0x0033:
            java.util.concurrent.locks.Condition r6 = r3.f48040t     // Catch:{ InterruptedException -> 0x003a }
            long r4 = r6.awaitNanos(r4)     // Catch:{ InterruptedException -> 0x003a }
            goto L_0x0017
        L_0x003a:
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0079 }
            r4.interrupt()     // Catch:{ all -> 0x0079 }
            com.huawei.hms.api.ConnectionResult r4 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x0079 }
            r5 = 15
            r4.<init>((int) r5, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x0079 }
            java.util.concurrent.locks.ReentrantLock r5 = r3.f48039s
            r5.unlock()
            return r4
        L_0x004e:
            boolean r4 = r3.isConnected()     // Catch:{ all -> 0x0079 }
            if (r4 == 0) goto L_0x0062
            r3.f48041u = r0     // Catch:{ all -> 0x0079 }
            com.huawei.hms.api.ConnectionResult r4 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x0079 }
            r5 = 0
            r4.<init>((int) r5, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x0079 }
            java.util.concurrent.locks.ReentrantLock r5 = r3.f48039s
            r5.unlock()
            return r4
        L_0x0062:
            com.huawei.hms.api.ConnectionResult r4 = r3.f48041u     // Catch:{ all -> 0x0079 }
            if (r4 == 0) goto L_0x006c
            java.util.concurrent.locks.ReentrantLock r5 = r3.f48039s
            r5.unlock()
            return r4
        L_0x006c:
            com.huawei.hms.api.ConnectionResult r4 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x0079 }
            r5 = 13
            r4.<init>((int) r5, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x0079 }
            java.util.concurrent.locks.ReentrantLock r5 = r3.f48039s
            r5.unlock()
            return r4
        L_0x0079:
            r4 = move-exception
            java.util.concurrent.locks.ReentrantLock r5 = r3.f48039s
            r5.unlock()
            throw r4
        L_0x0080:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "blockingConnect must not be called on the UI thread"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.api.HuaweiApiClientImpl.holdUpConnect(long, java.util.concurrent.TimeUnit):com.huawei.hms.api.ConnectionResult");
    }

    public void connect(int i11) {
        connect((Activity) null);
    }

    private void a(int i11) {
        if (i11 == 2) {
            synchronized (A) {
                Handler handler = this.f48044x;
                if (handler != null) {
                    handler.removeMessages(i11);
                    this.f48044x = null;
                }
            }
        }
        if (i11 == 3) {
            synchronized (B) {
                Handler handler2 = this.f48045y;
                if (handler2 != null) {
                    handler2.removeMessages(i11);
                    this.f48045y = null;
                }
            }
        }
        synchronized (A) {
            Handler handler3 = this.f48044x;
            if (handler3 != null) {
                handler3.removeMessages(2);
                this.f48044x = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(ResolveResult<ConnectResp> resolveResult) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult");
        if (this.f48026f == null || this.f48031k.get() != 2) {
            HMSLog.e("HuaweiApiClientImpl", "Invalid onConnectionResult");
            return;
        }
        a(3);
        ConnectResp value = resolveResult.getValue();
        if (value != null) {
            this.f48027g = value.sessionId;
        }
        SubAppInfo subAppInfo = this.f48035o;
        PendingIntent pendingIntent = null;
        String subAppID = subAppInfo == null ? null : subAppInfo.getSubAppID();
        if (!TextUtils.isEmpty(subAppID)) {
            this.f48024d = subAppID;
        }
        int statusCode = resolveResult.getStatus().getStatusCode();
        HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, connect to server result: " + statusCode);
        if (Status.SUCCESS.equals(resolveResult.getStatus())) {
            c(resolveResult);
        } else if (resolveResult.getStatus() == null || resolveResult.getStatus().getStatusCode() != 1001) {
            n();
            c(1);
            if (this.f48043w != null) {
                WeakReference<Activity> weakReference = this.f48028h;
                if (!(weakReference == null || weakReference.get() == null)) {
                    pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f48028h.get(), statusCode);
                }
                ConnectionResult connectionResult = new ConnectionResult(statusCode, pendingIntent);
                this.f48043w.onConnectionFailed(connectionResult);
                this.f48041u = connectionResult;
            }
        } else {
            n();
            c(1);
            HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f48042v;
            if (connectionCallbacks != null) {
                connectionCallbacks.onConnectionSuspended(3);
            }
        }
    }
}
