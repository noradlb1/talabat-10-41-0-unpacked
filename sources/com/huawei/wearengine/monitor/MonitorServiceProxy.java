package com.huawei.wearengine.monitor;

import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.wearengine.MonitorManager;
import com.huawei.wearengine.WearEngineException;
import com.huawei.wearengine.b;
import com.huawei.wearengine.c;
import com.huawei.wearengine.d;
import com.huawei.wearengine.device.Device;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MonitorServiceProxy implements MonitorManager, c {
    private static final int MONITOR_TYPE = 3;
    private static final String TAG = "MonitorServiceProxy";
    /* access modifiers changed from: private */
    public IBinder.DeathRecipient mDeathRecipient = new a();
    private final Object mLock = new Object();
    /* access modifiers changed from: private */
    public MonitorManager mMonitorManager = null;

    public class a implements IBinder.DeathRecipient {
        public a() {
        }

        public void binderDied() {
            if (MonitorServiceProxy.this.mMonitorManager != null) {
                MonitorServiceProxy.this.mMonitorManager.asBinder().unlinkToDeath(MonitorServiceProxy.this.mDeathRecipient, 0);
                MonitorManager unused = MonitorServiceProxy.this.mMonitorManager = null;
            }
        }
    }

    public MonitorServiceProxy() {
        registerReleaseConnectionCallback();
    }

    private void checkServiceSupportMonitorStatus(List<MonitorItem> list) {
        if (list == null || list.isEmpty()) {
            throw com.huawei.wearengine.a.a(TAG, "checkServiceSupportMonitorStatus monitorItemList == null or monitorItemList.isEmpty()", 5);
        }
        for (MonitorItem next : list) {
            if (!MonitorItem.MONITOR_ITEM_CONNECTION.getName().equals(next.getName()) && !com.huawei.wearengine.utils.a.a(next.getName())) {
                throw com.huawei.wearengine.a.a(TAG, "checkServiceSupportMonitorStatus Health version is low", 14);
            }
        }
    }

    private void registerReleaseConnectionCallback() {
        d.g().a((d.b) new b(new WeakReference(this)));
    }

    private void syncCheckConnStatus() {
        synchronized (this.mLock) {
            if (this.mMonitorManager == null) {
                d.g().b();
                IBinder a11 = d.g().a(3);
                if (a11 != null) {
                    MonitorManager asInterface = MonitorManager.Stub.asInterface(a11);
                    this.mMonitorManager = asInterface;
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
        this.mMonitorManager = null;
    }

    public MonitorData query(Device device, MonitorItem monitorItem) {
        try {
            syncCheckConnStatus();
            if (this.mMonitorManager == null) {
                throw new WearEngineException(6);
            } else if (com.huawei.wearengine.utils.a.a("monitor_query")) {
                return this.mMonitorManager.query(device, monitorItem);
            } else {
                com.huawei.wearengine.common.a.a(TAG, "query Health version is low");
                throw new WearEngineException(14);
            }
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            throw com.huawei.wearengine.a.a(TAG, "send RemoteException", 12);
        }
    }

    public int registerListListener(Device device, String str, List<MonitorItem> list, MonitorDataCallback monitorDataCallback, int i11) {
        try {
            syncCheckConnStatus();
            if (this.mMonitorManager == null) {
                return 6;
            }
            checkServiceSupportMonitorStatus(list);
            return this.mMonitorManager.registerListListener(device, str, list, monitorDataCallback, i11);
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            com.huawei.wearengine.common.a.a(TAG, "registerListListener RemoteException");
            return 12;
        }
    }

    public int registerListener(Device device, String str, MonitorItem monitorItem, MonitorDataCallback monitorDataCallback, int i11) {
        try {
            syncCheckConnStatus();
            if (this.mMonitorManager == null) {
                return 6;
            }
            checkServiceSupportMonitorStatus(new ArrayList(Collections.singleton(monitorItem)));
            return this.mMonitorManager.registerListener(device, str, monitorItem, monitorDataCallback, i11);
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            com.huawei.wearengine.common.a.a(TAG, "registerListener RemoteException");
            return 12;
        }
    }

    public int unregisterListener(MonitorDataCallback monitorDataCallback, int i11) {
        try {
            syncCheckConnStatus();
            MonitorManager monitorManager = this.mMonitorManager;
            if (monitorManager != null) {
                return monitorManager.unregisterListener(monitorDataCallback, i11);
            }
            return 6;
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            com.huawei.wearengine.common.a.a(TAG, "unregisterListener RemoteException");
            return 12;
        }
    }
}
