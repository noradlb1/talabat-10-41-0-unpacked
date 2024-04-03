package com.huawei.wearengine.client;

import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.wearengine.WearEngineException;
import com.huawei.wearengine.connect.ServiceConnectCallback;
import java.util.concurrent.Callable;

public class WearEngineClient {

    /* renamed from: d  reason: collision with root package name */
    private static volatile WearEngineClient f35126d;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public WearEngineProxy f35127a = new WearEngineProxy();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public volatile ServiceConnectionListener f35128b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public volatile ServiceConnectCallback f35129c = new ServiceConnectCallback.Stub() {
        public void onServiceDisconnect() {
            if (WearEngineClient.this.f35128b != null) {
                WearEngineClient.this.f35128b.onServiceDisconnect();
            }
        }
    };

    public class a implements Callable<Void> {
        public a() {
        }

        public Object call() {
            int registerConnectCallback = WearEngineClient.this.f35127a.registerConnectCallback(WearEngineClient.this.f35129c);
            if (registerConnectCallback == 0) {
                return null;
            }
            throw new WearEngineException(registerConnectCallback);
        }
    }

    public class b implements Callable<Void> {
        public b() {
        }

        public Object call() {
            int unregisterConnectCallback = WearEngineClient.this.f35127a.unregisterConnectCallback(WearEngineClient.this.f35129c);
            if (unregisterConnectCallback == 0) {
                return null;
            }
            throw new WearEngineException(unregisterConnectCallback);
        }
    }

    public class c implements Callable<Void> {
        public c() {
        }

        public Object call() {
            int releaseConnection = WearEngineClient.this.f35127a.releaseConnection();
            if (releaseConnection == 0) {
                return null;
            }
            throw new WearEngineException(releaseConnection);
        }
    }

    public class d implements Callable<Integer> {
        public d() {
        }

        public Object call() {
            return Integer.valueOf(WearEngineClient.this.f35127a.getClientApiLevel());
        }
    }

    public class e implements Callable<Integer> {
        public e() {
        }

        public Object call() {
            return Integer.valueOf(WearEngineClient.this.f35127a.getServiceApiLevel());
        }
    }

    private WearEngineClient(ServiceConnectionListener serviceConnectionListener) {
        this.f35128b = serviceConnectionListener;
    }

    public static WearEngineClient getInstance(ServiceConnectionListener serviceConnectionListener) {
        if (f35126d == null) {
            synchronized (WearEngineClient.class) {
                if (f35126d == null) {
                    f35126d = new WearEngineClient(serviceConnectionListener);
                }
            }
        }
        return f35126d;
    }

    public Task<Integer> getClientApiLevel() {
        return Tasks.callInBackground(new d());
    }

    public Task<Integer> getServiceApiLevel() {
        return Tasks.callInBackground(new e());
    }

    public Task<Void> registerServiceConnectionListener() {
        com.huawei.wearengine.d.g().a(this.f35128b);
        return Tasks.callInBackground(new a());
    }

    public Task<Void> releaseConnection() {
        return Tasks.callInBackground(new c());
    }

    public Task<Void> unregisterServiceConnectionListener() {
        com.huawei.wearengine.d.g().c();
        return Tasks.callInBackground(new b());
    }
}
