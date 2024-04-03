package com.huawei.wearengine;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.wearengine.BinderService;
import com.huawei.wearengine.client.ServiceConnectionListener;
import com.huawei.wearengine.common.Constants;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class d {

    /* renamed from: h  reason: collision with root package name */
    private static final Object f35138h = new Object();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final Object f35139i = new Object();

    /* renamed from: j  reason: collision with root package name */
    private static volatile d f35140j;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public BinderService f35141a = null;

    /* renamed from: b  reason: collision with root package name */
    private List<b> f35142b = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f35143c = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public volatile ServiceConnectionListener f35144d;

    /* renamed from: e  reason: collision with root package name */
    private ExecutorService f35145e = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f35146f = false;

    /* renamed from: g  reason: collision with root package name */
    private ServiceConnection f35147g = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BinderService unused = d.this.f35141a = BinderService.Stub.asInterface(iBinder);
            d.this.f35143c.getAndSet(true);
            d.f(d.this);
            d.g(d.this);
            d.this.f();
            synchronized (d.f35139i) {
                boolean unused2 = d.this.f35146f = true;
                d.f35139i.notifyAll();
            }
            d.d(d.this, 1);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            BinderService unused = d.this.f35141a = null;
            d.this.f35143c.getAndSet(false);
            synchronized (d.f35139i) {
                boolean unused2 = d.this.f35146f = true;
                d.f35139i.notifyAll();
            }
            d.d(d.this, 2);
        }
    }

    public interface b {
    }

    private d() {
    }

    private Intent a(Intent intent) {
        PackageManager packageManager = com.huawei.wearengine.utils.b.a().getPackageManager();
        if (packageManager == null) {
            com.huawei.wearengine.common.a.a("WearEngineClientInner", "getPackageManager is null");
            return null;
        }
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            com.huawei.wearengine.common.a.c("WearEngineClientInner", "implicitIntent List are null");
            return null;
        }
        ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
        ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        return intent2;
    }

    public static /* synthetic */ void d(d dVar, int i11) {
        if (dVar.f35144d == null) {
            com.huawei.wearengine.common.a.c("WearEngineClientInner", "executeConnectionListener mServiceConnectionListener is null");
        } else {
            dVar.f35145e.submit(new e(dVar, i11));
        }
    }

    private void e() {
        synchronized (f35138h) {
            Intent intent = new Intent();
            intent.setPackage("com.huawei.health");
            intent.setClassName("com.huawei.health", "com.huawei.wearengine.service.WearEngineService");
            Intent a11 = a(intent);
            if (a11 != null) {
                synchronized (f35139i) {
                    this.f35146f = false;
                    if (com.huawei.wearengine.utils.b.a().bindService(a11, this.f35147g, 1)) {
                        while (!this.f35146f) {
                            try {
                                f35139i.wait(30000);
                                this.f35146f = true;
                            } catch (InterruptedException unused) {
                                com.huawei.wearengine.common.a.a("WearEngineClientInner", "bindToService wait error");
                            }
                        }
                    } else {
                        com.huawei.wearengine.common.a.a("WearEngineClientInner", "bindToService do not has permission");
                        throw new WearEngineException(15);
                    }
                }
            } else {
                throw new WearEngineException(2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        String str;
        com.huawei.wearengine.common.a.b("WearEngineClientInner", "exchangeApiLevel enter");
        if (this.f35141a != null) {
            try {
                int exchangeApiLevel = this.f35141a.exchangeApiLevel(com.huawei.wearengine.utils.a.a());
                com.huawei.wearengine.common.a.b("WearEngineClientInner", "exchangeApiLevel serviceApiLevel:" + exchangeApiLevel);
                com.huawei.wearengine.utils.a.a(exchangeApiLevel);
            } catch (RemoteException unused) {
                str = "exchangeApiLevel failed";
            }
        } else {
            str = "exchangeApiLevel mBinderService is null";
            com.huawei.wearengine.common.a.c("WearEngineClientInner", str);
        }
    }

    public static /* synthetic */ void f(d dVar) {
        if (dVar.f35141a != null) {
            WearEngineClientInner$3 wearEngineClientInner$3 = new WearEngineClientInner$3(dVar);
            Context a11 = com.huawei.wearengine.utils.b.a();
            String str = "";
            if (a11 != null) {
                str = a11.getSharedPreferences(Constants.WEAR_ENGINE_PERMISSION_IDENTITY_STORE, 0).getString(Constants.WEAR_ENGINE_PERMISSION_IDENTITY, str);
            }
            try {
                dVar.f35141a.checkPermissionIdentity(com.huawei.wearengine.utils.b.a().getPackageName(), str, wearEngineClientInner$3);
            } catch (RemoteException unused) {
                com.huawei.wearengine.common.a.a("WearEngineClientInner", "clearPermissionData failed");
            }
        }
    }

    public static d g() {
        if (f35140j == null) {
            synchronized (d.class) {
                if (f35140j == null) {
                    f35140j = new d();
                }
            }
        }
        return f35140j;
    }

    public static /* synthetic */ void g(d dVar) {
        if (dVar.f35141a != null) {
            WearEngineClientInner$2 wearEngineClientInner$2 = new WearEngineClientInner$2(dVar);
            try {
                dVar.f35141a.registerToken(com.huawei.wearengine.utils.b.a().getPackageName(), wearEngineClientInner$2);
            } catch (RemoteException unused) {
                com.huawei.wearengine.common.a.c("WearEngineClientInner", "setClientToken failed");
            }
        }
    }

    private int h() {
        synchronized (f35138h) {
            if (this.f35143c.get()) {
                com.huawei.wearengine.common.a.b("WearEngineClientInner", "begin unbind WearEngineService");
                try {
                    com.huawei.wearengine.utils.b.a().unbindService(this.f35147g);
                    this.f35143c.getAndSet(false);
                    this.f35141a = null;
                    Iterator<b> it = this.f35142b.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).a();
                    }
                } catch (IllegalArgumentException unused) {
                    com.huawei.wearengine.common.a.a("WearEngineClientInner", "unBindService catch IllegalArgumentException");
                    return 12;
                }
            }
        }
        return 0;
    }

    public int a() {
        return h();
    }

    public IBinder a(int i11) {
        if (this.f35141a != null) {
            try {
                return this.f35141a.getBinder(i11);
            } catch (RemoteException unused) {
                com.huawei.wearengine.common.a.c("WearEngineClientInner", "queryBinder query failed");
                this.f35143c.getAndSet(false);
            }
        }
        com.huawei.wearengine.common.a.c("WearEngineClientInner", "queryBinder failed something happened");
        return null;
    }

    public void a(ServiceConnectionListener serviceConnectionListener) {
        this.f35144d = serviceConnectionListener;
    }

    public void a(b bVar) {
        this.f35142b.add(bVar);
    }

    public void b() {
        synchronized (f35138h) {
            if (this.f35141a == null) {
                e();
            }
        }
    }

    public void c() {
        this.f35144d = null;
    }
}
