package com.huawei.wearengine.client;

import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.wearengine.WearEngineException;
import com.huawei.wearengine.WearEngineManager;
import com.huawei.wearengine.b;
import com.huawei.wearengine.c;
import com.huawei.wearengine.connect.ServiceConnectCallback;
import com.huawei.wearengine.d;
import java.lang.ref.WeakReference;

public class WearEngineProxy implements WearEngineManager, c {
    private static final String TAG = "WearEngineProxy";
    private static final int WEAR_ENGINE_CLIENT_TYPE = 6;
    /* access modifiers changed from: private */
    public IBinder.DeathRecipient mDeathRecipient = new a();
    private final Object mLock = new Object();
    /* access modifiers changed from: private */
    public volatile WearEngineManager mWearEngineManager = null;

    public class a implements IBinder.DeathRecipient {
        public a() {
        }

        public void binderDied() {
            if (WearEngineProxy.this.mWearEngineManager != null) {
                WearEngineProxy.this.mWearEngineManager.asBinder().unlinkToDeath(WearEngineProxy.this.mDeathRecipient, 0);
                WearEngineManager unused = WearEngineProxy.this.mWearEngineManager = null;
            }
        }
    }

    public WearEngineProxy() {
        registerReleaseConnectionCallback();
    }

    private void registerReleaseConnectionCallback() {
        d.g().a((d.b) new b(new WeakReference(this)));
    }

    private void syncCheckConnStatus() {
        synchronized (this.mLock) {
            if (this.mWearEngineManager == null) {
                d.g().b();
                IBinder a11 = d.g().a(6);
                if (a11 != null) {
                    this.mWearEngineManager = WearEngineManager.Stub.asInterface(a11);
                    this.mWearEngineManager.asBinder().linkToDeath(this.mDeathRecipient, 0);
                } else {
                    throw new WearEngineException(2);
                }
            }
        }
    }

    public IBinder asBinder() {
        return null;
    }

    public void clearBinderProxy() {
        this.mWearEngineManager = null;
    }

    public int getClientApiLevel() {
        int a11 = com.huawei.wearengine.utils.a.a();
        com.huawei.wearengine.common.a.b(TAG, "getClientApiLevel: " + a11);
        return a11;
    }

    public int getServiceApiLevel() {
        try {
            syncCheckConnStatus();
            int b11 = com.huawei.wearengine.utils.a.b();
            com.huawei.wearengine.common.a.b(TAG, "getServiceApiLevel: " + b11);
            return b11;
        } catch (RemoteException unused) {
            throw com.huawei.wearengine.a.a(TAG, "getServiceApiLevel RemoteException", 12);
        }
    }

    public int registerConnectCallback(ServiceConnectCallback serviceConnectCallback) {
        try {
            syncCheckConnStatus();
            if (this.mWearEngineManager != null) {
                return this.mWearEngineManager.registerConnectCallback(serviceConnectCallback);
            }
            throw new WearEngineException(6);
        } catch (RemoteException unused) {
            throw com.huawei.wearengine.a.a(TAG, "registerConnectCallback RemoteException", 12);
        }
    }

    public int releaseConnection() {
        try {
            syncCheckConnStatus();
            if (this.mWearEngineManager != null) {
                int releaseConnection = this.mWearEngineManager.releaseConnection();
                if (releaseConnection == 0) {
                    return d.g().a();
                }
                com.huawei.wearengine.common.a.a(TAG, "releaseConnection failed, ret: " + releaseConnection);
                return releaseConnection;
            }
            throw new WearEngineException(6);
        } catch (RemoteException unused) {
            throw com.huawei.wearengine.a.a(TAG, "releaseConnection RemoteException", 12);
        }
    }

    public int unregisterConnectCallback(ServiceConnectCallback serviceConnectCallback) {
        try {
            syncCheckConnStatus();
            if (this.mWearEngineManager != null) {
                return this.mWearEngineManager.unregisterConnectCallback(serviceConnectCallback);
            }
            throw new WearEngineException(6);
        } catch (RemoteException unused) {
            throw com.huawei.wearengine.a.a(TAG, "unregisterConnectCallback RemoteException", 12);
        }
    }
}
