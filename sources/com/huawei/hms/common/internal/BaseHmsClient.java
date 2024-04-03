package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.adapter.InnerBinderAdapter;
import com.huawei.hms.adapter.OuterBinderAdapter;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.FailedBinderCallBack;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.IPCTransport;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseHmsClient implements AidlApiClient {
    protected static final int TIMEOUT_DISCONNECTED = 6;

    /* renamed from: i  reason: collision with root package name */
    private static final Object f48138i = new Object();

    /* renamed from: j  reason: collision with root package name */
    private static final AtomicInteger f48139j = new AtomicInteger(1);

    /* renamed from: k  reason: collision with root package name */
    private static final AtomicInteger f48140k = new AtomicInteger(1);

    /* renamed from: l  reason: collision with root package name */
    private static BinderAdapter f48141l;

    /* renamed from: m  reason: collision with root package name */
    private static BinderAdapter f48142m;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f48143a;

    /* renamed from: b  reason: collision with root package name */
    private String f48144b;

    /* renamed from: c  reason: collision with root package name */
    private final ClientSettings f48145c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public volatile IAIDLInvoke f48146d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ConnectionCallbacks f48147e;

    /* renamed from: f  reason: collision with root package name */
    private final OnConnectionFailedListener f48148f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f48149g = null;

    /* renamed from: h  reason: collision with root package name */
    private HuaweiApi.RequestHandler f48150h;
    protected String sessionId;

    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i11);
    }

    public static final class ConnectionResultWrapper {

        /* renamed from: a  reason: collision with root package name */
        private HuaweiApi.RequestHandler f48155a;

        /* renamed from: b  reason: collision with root package name */
        private ConnectionResult f48156b;

        public ConnectionResultWrapper(HuaweiApi.RequestHandler requestHandler, ConnectionResult connectionResult) {
            this.f48155a = requestHandler;
            this.f48156b = connectionResult;
        }

        public ConnectionResult getConnectionResult() {
            return this.f48156b;
        }

        public HuaweiApi.RequestHandler getRequest() {
            return this.f48155a;
        }
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public BaseHmsClient(Context context, ClientSettings clientSettings, OnConnectionFailedListener onConnectionFailedListener, ConnectionCallbacks connectionCallbacks) {
        this.f48143a = context;
        this.f48145c = clientSettings;
        if (clientSettings != null) {
            this.f48144b = clientSettings.getAppID();
        }
        this.f48148f = onConnectionFailedListener;
        this.f48147e = connectionCallbacks;
    }

    private BinderAdapter.BinderCallBack d() {
        return new BinderAdapter.BinderCallBack() {
            public void onBinderFailed(int i11) {
                onBinderFailed(i11, (Intent) null);
            }

            public void onNullBinding(ComponentName componentName) {
                BaseHmsClient.this.b(1);
                BaseHmsClient.this.a(10);
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                HMSLog.i("BaseHmsClient", "Enter onServiceConnected.");
                BaseHmsClient.this.connectedInternal(iBinder);
            }

            public void onServiceDisconnected(ComponentName componentName) {
                HMSLog.i("BaseHmsClient", "Enter onServiceDisconnected.");
                BaseHmsClient.this.b(1);
                RequestManager.getHandler().sendEmptyMessage(RequestManager.NOTIFY_CONNECT_SUSPENDED);
                if (BaseHmsClient.this.f48147e != null && !(BaseHmsClient.this.f48147e instanceof HuaweiApi.RequestHandler)) {
                    BaseHmsClient.this.f48147e.onConnectionSuspended(1);
                }
            }

            public void onTimedDisconnected() {
                BaseHmsClient.this.b(6);
                if (BaseHmsClient.this.f48147e != null && !(BaseHmsClient.this.f48147e instanceof HuaweiApi.RequestHandler)) {
                    BaseHmsClient.this.f48147e.onConnectionSuspended(1);
                }
            }

            public void onBinderFailed(int i11, Intent intent) {
                if (intent != null) {
                    Activity activeActivity = Util.getActiveActivity(BaseHmsClient.this.getClientSettings().getCpActivity(), BaseHmsClient.this.getContext());
                    if (activeActivity != null) {
                        HMSLog.i("BaseHmsClient", "onBinderFailed: SDK try to resolve and reConnect!");
                        long time = new Timestamp(System.currentTimeMillis()).getTime();
                        FailedBinderCallBack.getInstance().setCallBack(Long.valueOf(time), new FailedBinderCallBack.BinderCallBack() {
                            public void binderCallBack(int i11) {
                                if (i11 != 0) {
                                    BaseHmsClient.this.a(new ConnectionResult(10, (PendingIntent) null));
                                    IAIDLInvoke unused = BaseHmsClient.this.f48146d = null;
                                }
                            }
                        });
                        intent.putExtra(FailedBinderCallBack.CALLER_ID, time);
                        activeActivity.startActivity(intent);
                        return;
                    }
                    HMSLog.i("BaseHmsClient", "onBinderFailed: return pendingIntent to kit and cp");
                    BaseHmsClient.this.a(new ConnectionResult(10, PendingIntent.getActivity(BaseHmsClient.this.f48143a, 11, intent, 67108864)));
                    IAIDLInvoke unused = BaseHmsClient.this.f48146d = null;
                    return;
                }
                HMSLog.i("BaseHmsClient", "onBinderFailed: intent is null!");
                BaseHmsClient.this.a(new ConnectionResult(10, (PendingIntent) null));
                IAIDLInvoke unused2 = BaseHmsClient.this.f48146d = null;
            }
        };
    }

    private void e() {
        HMSLog.w("BaseHmsClient", "Failed to get service as interface, trying to unbind.");
        if (this.f48145c.isUseInnerHms()) {
            BinderAdapter binderAdapter = f48142m;
            if (binderAdapter == null) {
                HMSLog.w("BaseHmsClient", "mInnerBinderAdapter is null.");
                return;
            }
            binderAdapter.unBind();
        } else {
            BinderAdapter binderAdapter2 = f48141l;
            if (binderAdapter2 == null) {
                HMSLog.w("BaseHmsClient", "mOuterBinderAdapter is null.");
                return;
            }
            binderAdapter2.unBind();
        }
        b(1);
        a(10);
    }

    private void f() {
        if (this.f48145c.isUseInnerHms()) {
            BinderAdapter binderAdapter = f48142m;
            if (binderAdapter != null) {
                binderAdapter.unBind();
                return;
            }
            return;
        }
        BinderAdapter binderAdapter2 = f48141l;
        if (binderAdapter2 != null) {
            binderAdapter2.unBind();
        }
    }

    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(int i11) {
        a(i11, false);
    }

    public void connectedInternal(IBinder iBinder) {
        this.f48146d = IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.f48146d == null) {
            HMSLog.e("BaseHmsClient", "mService is null, try to unBind.");
            e();
            return;
        }
        onConnecting();
    }

    public final void connectionConnected() {
        b(3);
        RequestManager.getHandler().sendEmptyMessage(RequestManager.NOTIFY_CONNECT_SUCCESS);
        ConnectionCallbacks connectionCallbacks = this.f48147e;
        if (connectionCallbacks != null && !(connectionCallbacks instanceof HuaweiApi.RequestHandler)) {
            connectionCallbacks.onConnected();
        }
    }

    public void disconnect() {
        AtomicInteger atomicInteger;
        if (this.f48145c.isUseInnerHms()) {
            atomicInteger = f48140k;
        } else {
            atomicInteger = f48139j;
        }
        int i11 = atomicInteger.get();
        HMSLog.i("BaseHmsClient", "Enter disconnect, Connection Status: " + i11);
        if (i11 == 3) {
            f();
            b(1);
        } else if (i11 == 5) {
            b();
            b(1);
        }
    }

    public BinderAdapter getAdapter() {
        HMSLog.i("BaseHmsClient", "getAdapter:isInner:" + this.f48145c.isUseInnerHms() + ", mInnerBinderAdapter:" + f48142m + ", mOuterBinderAdapter:" + f48141l);
        if (this.f48145c.isUseInnerHms()) {
            return f48142m;
        }
        return f48141l;
    }

    public List<String> getApiNameList() {
        return this.f48145c.getApiName();
    }

    public String getAppID() {
        return this.f48144b;
    }

    public ClientSettings getClientSettings() {
        return this.f48145c;
    }

    public int getConnectionStatus() {
        return (this.f48145c.isUseInnerHms() ? f48140k : f48139j).get();
    }

    public Context getContext() {
        return this.f48143a;
    }

    public String getCpID() {
        return this.f48145c.getCpID();
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    public String getPackageName() {
        return this.f48145c.getClientPackageName();
    }

    public int getRequestHmsVersionCode() {
        return getMinApkVersion();
    }

    public IAIDLInvoke getService() {
        return this.f48146d;
    }

    public String getServiceAction() {
        HMSPackageManager instance = HMSPackageManager.getInstance(this.f48143a);
        if (this.f48145c.isUseInnerHms()) {
            return instance.getInnerServiceAction();
        }
        return instance.getServiceAction();
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public SubAppInfo getSubAppInfo() {
        return this.f48145c.getSubAppID();
    }

    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    public boolean isConnected() {
        if (!this.f48145c.isUseInnerHms() ? f48139j.get() != 3 : f48140k.get() != 3) {
            return false;
        }
        return true;
    }

    public boolean isConnecting() {
        return (this.f48145c.isUseInnerHms() ? f48140k : f48139j).get() == 5;
    }

    public void onConnecting() {
        connectionConnected();
    }

    public final void setInternalRequest(HuaweiApi.RequestHandler requestHandler) {
        this.f48150h = requestHandler;
    }

    public void setService(IAIDLInvoke iAIDLInvoke) {
        this.f48146d = iAIDLInvoke;
    }

    /* access modifiers changed from: private */
    public boolean c() {
        return HMSPackageManager.getInstance(this.f48143a).getHMSPackageStatesForMultiService() == PackageManagerHelper.PackageStates.ENABLED;
    }

    public void b(int i11) {
        if (this.f48145c.isUseInnerHms()) {
            f48140k.set(i11);
        } else {
            f48139j.set(i11);
        }
    }

    public void connect(int i11, boolean z11) {
        a(i11, z11);
    }

    private void b() {
        synchronized (f48138i) {
            Handler handler = this.f48149g;
            if (handler != null) {
                handler.removeMessages(2);
                this.f48149g = null;
            }
        }
    }

    public void a() {
        String innerHmsPkg = this.f48145c.getInnerHmsPkg();
        String serviceAction = getServiceAction();
        HMSLog.i("BaseHmsClient", "enter bindCoreService, packageName is " + innerHmsPkg + ", serviceAction is " + serviceAction);
        a(innerHmsPkg, serviceAction);
    }

    private void a(String str, String str2) {
        if (this.f48145c.isUseInnerHms()) {
            f48142m = InnerBinderAdapter.getInstance(this.f48143a, str2, str);
            if (isConnected()) {
                HMSLog.i("BaseHmsClient", "The binder is already connected.");
                getAdapter().updateDelayTask();
                connectedInternal(getAdapter().getServiceBinder());
                return;
            }
            b(5);
            f48142m.binder(d());
            return;
        }
        f48141l = OuterBinderAdapter.getInstance(this.f48143a, str2, str);
        if (isConnected()) {
            HMSLog.i("BaseHmsClient", "The binder is already connected.");
            getAdapter().updateDelayTask();
            connectedInternal(getAdapter().getServiceBinder());
            return;
        }
        b(5);
        f48141l.binder(d());
    }

    private void b(AvailableAdapter availableAdapter, int i11) {
        HMSLog.i("BaseHmsClient", "enter HmsCore resolution");
        if (!getClientSettings().isHasActivity()) {
            a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.f48143a, i11, 0)));
            return;
        }
        Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
        if (activeActivity != null) {
            availableAdapter.startResolution(activeActivity, new AvailableAdapter.AvailableCallBack() {
                public void onComplete(int i11) {
                    if (i11 != 0 || !BaseHmsClient.this.c()) {
                        BaseHmsClient.this.a(i11);
                    } else {
                        BaseHmsClient.this.a();
                    }
                }
            });
        } else {
            a(26);
        }
    }

    private void a(int i11, boolean z11) {
        HMSLog.i("BaseHmsClient", "====== HMSSDK version: 61100302 ======");
        int i12 = (this.f48145c.isUseInnerHms() ? f48140k : f48139j).get();
        HMSLog.i("BaseHmsClient", "Enter connect, Connection Status: " + i12);
        if (z11 || !(i12 == 3 || i12 == 5)) {
            if (getMinApkVersion() > i11) {
                i11 = getMinApkVersion();
            }
            HMSLog.i("BaseHmsClient", "connect minVersion:" + i11 + " packageName:" + this.f48145c.getInnerHmsPkg());
            if (this.f48143a.getPackageName().equals(this.f48145c.getInnerHmsPkg())) {
                HMSLog.i("BaseHmsClient", "service packageName is same, bind core service return");
                a();
            } else if (Util.isAvailableLibExist(this.f48143a)) {
                AvailableAdapter availableAdapter = new AvailableAdapter(i11);
                int isHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(this.f48143a);
                HMSLog.i("BaseHmsClient", "check available result: " + isHuaweiMobileServicesAvailable);
                if (isHuaweiMobileServicesAvailable == 0) {
                    a();
                } else if (availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
                    HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail, start resolution now.");
                    b(availableAdapter, isHuaweiMobileServicesAvailable);
                } else if (availableAdapter.isUserNoticeError(isHuaweiMobileServicesAvailable)) {
                    HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail, start notice now.");
                    a(availableAdapter, isHuaweiMobileServicesAvailable);
                } else {
                    HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail: " + isHuaweiMobileServicesAvailable + " is not resolvable.");
                    a(isHuaweiMobileServicesAvailable);
                }
            } else {
                int isHuaweiMobileServicesAvailable2 = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.f48143a, i11);
                HMSLog.i("BaseHmsClient", "HuaweiApiAvailability check available result: " + isHuaweiMobileServicesAvailable2);
                if (isHuaweiMobileServicesAvailable2 == 0) {
                    a();
                } else {
                    a(isHuaweiMobileServicesAvailable2);
                }
            }
        }
    }

    private void a(AvailableAdapter availableAdapter, int i11) {
        HMSLog.i("BaseHmsClient", "enter notice");
        if (!getClientSettings().isHasActivity()) {
            if (i11 == 29) {
                i11 = 9;
            }
            a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.f48143a, i11, 0)));
            return;
        }
        Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
        if (activeActivity != null) {
            availableAdapter.startNotice(activeActivity, new AvailableAdapter.AvailableCallBack() {
                public void onComplete(int i11) {
                    BaseHmsClient.this.a(i11);
                }
            });
        } else {
            a(26);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i11) {
        HMSLog.i("BaseHmsClient", "notifyFailed result: " + i11);
        Message message = new Message();
        message.what = RequestManager.NOTIFY_CONNECT_FAILED;
        message.obj = new ConnectionResultWrapper(this.f48150h, new ConnectionResult(i11));
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.f48148f;
        if (onConnectionFailedListener != null && !(onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            onConnectionFailedListener.onConnectionFailed(new ConnectionResult(i11));
        }
    }

    /* access modifiers changed from: private */
    public void a(ConnectionResult connectionResult) {
        HMSLog.i("BaseHmsClient", "notifyFailed result: " + connectionResult.getErrorCode());
        Message message = new Message();
        message.what = RequestManager.NOTIFY_CONNECT_FAILED;
        HuaweiApi.RequestHandler requestHandler = this.f48150h;
        this.f48150h = null;
        message.obj = new ConnectionResultWrapper(requestHandler, connectionResult);
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.f48148f;
        if (onConnectionFailedListener != null && !(onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            onConnectionFailedListener.onConnectionFailed(connectionResult);
        }
    }
}
