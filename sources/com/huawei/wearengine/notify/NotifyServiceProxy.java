package com.huawei.wearengine.notify;

import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.wearengine.NotifyManager;
import com.huawei.wearengine.WearEngineException;
import com.huawei.wearengine.b;
import com.huawei.wearengine.c;
import com.huawei.wearengine.d;
import com.huawei.wearengine.device.Device;
import java.lang.ref.WeakReference;

public class NotifyServiceProxy implements NotifyManager, c {
    private static final int NOTIFY_TYPE = 4;
    private static final String TAG = "NotifyServiceProxy";
    /* access modifiers changed from: private */
    public IBinder.DeathRecipient mDeathRecipient = new a();
    private final Object mLock = new Object();
    /* access modifiers changed from: private */
    public NotifyManager mNotifyManager = null;

    public class a implements IBinder.DeathRecipient {
        public a() {
        }

        public void binderDied() {
            if (NotifyServiceProxy.this.mNotifyManager != null) {
                NotifyServiceProxy.this.mNotifyManager.asBinder().unlinkToDeath(NotifyServiceProxy.this.mDeathRecipient, 0);
                NotifyManager unused = NotifyServiceProxy.this.mNotifyManager = null;
            }
        }
    }

    public NotifyServiceProxy() {
        registerReleaseConnectionCallback();
    }

    private void registerReleaseConnectionCallback() {
        d.g().a((d.b) new b(new WeakReference(this)));
    }

    private void syncCheckConnStatus() {
        synchronized (this.mLock) {
            if (this.mNotifyManager == null) {
                d.g().b();
                IBinder a11 = d.g().a(4);
                if (a11 != null) {
                    NotifyManager asInterface = NotifyManager.Stub.asInterface(a11);
                    this.mNotifyManager = asInterface;
                    asInterface.asBinder().linkToDeath(this.mDeathRecipient, 0);
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
        this.mNotifyManager = null;
    }

    public int notify(Device device, NotificationParcel notificationParcel, NotifySendCallback notifySendCallback) {
        try {
            syncCheckConnStatus();
            if (this.mNotifyManager == null) {
                return 6;
            }
            if (com.huawei.wearengine.utils.a.a("notify_notify")) {
                return this.mNotifyManager.notify(device, notificationParcel, notifySendCallback);
            }
            com.huawei.wearengine.common.a.a(TAG, "notify Health version is low");
            throw new WearEngineException(14);
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            com.huawei.wearengine.common.a.a(TAG, "notify RemoteException");
            return 12;
        }
    }
}
