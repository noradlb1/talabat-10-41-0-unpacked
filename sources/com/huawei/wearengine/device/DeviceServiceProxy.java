package com.huawei.wearengine.device;

import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.wearengine.DeviceManager;
import com.huawei.wearengine.WearEngineException;
import com.huawei.wearengine.b;
import com.huawei.wearengine.c;
import com.huawei.wearengine.d;
import java.lang.ref.WeakReference;
import java.util.List;

public class DeviceServiceProxy implements DeviceManager, c {
    private static final int DEVICE_TYPE = 1;
    private static final String TAG = "DeviceServiceProxy";
    private static volatile DeviceServiceProxy sInstance;
    /* access modifiers changed from: private */
    public IBinder.DeathRecipient mDeathRecipient = new a();
    /* access modifiers changed from: private */
    public DeviceManager mDeviceManager = null;
    private final Object mLock = new Object();

    public class a implements IBinder.DeathRecipient {
        public a() {
        }

        public void binderDied() {
            if (DeviceServiceProxy.this.mDeviceManager != null) {
                DeviceServiceProxy.this.mDeviceManager.asBinder().unlinkToDeath(DeviceServiceProxy.this.mDeathRecipient, 0);
                DeviceManager unused = DeviceServiceProxy.this.mDeviceManager = null;
            }
        }
    }

    private DeviceServiceProxy() {
        registerReleaseConnectionCallback();
    }

    public static DeviceServiceProxy getInstance() {
        if (sInstance == null) {
            synchronized (DeviceServiceProxy.class) {
                if (sInstance == null) {
                    sInstance = new DeviceServiceProxy();
                }
            }
        }
        return sInstance;
    }

    private void registerReleaseConnectionCallback() {
        d.g().a((d.b) new b(new WeakReference(this)));
    }

    private void syncCheckConnStatus() {
        synchronized (this.mLock) {
            if (this.mDeviceManager == null) {
                d.g().b();
                IBinder a11 = d.g().a(1);
                if (a11 != null) {
                    DeviceManager asInterface = DeviceManager.Stub.asInterface(a11);
                    this.mDeviceManager = asInterface;
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
        this.mDeviceManager = null;
    }

    public List<Device> getBondedDeviceEx() {
        try {
            syncCheckConnStatus();
            DeviceManager deviceManager = this.mDeviceManager;
            if (deviceManager != null) {
                return deviceManager.getBondedDeviceEx();
            }
            throw new WearEngineException(6);
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            throw com.huawei.wearengine.a.a(TAG, "getBondedDeviceEx RemoteException", 12);
        }
    }

    public List<Device> getBondedDevices() {
        try {
            syncCheckConnStatus();
            if (this.mDeviceManager != null) {
                return com.huawei.wearengine.utils.a.a("device_get_bonded_device_ex") ? getBondedDeviceEx() : this.mDeviceManager.getBondedDevices();
            }
            throw new WearEngineException(6);
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            throw com.huawei.wearengine.a.a(TAG, "getBondedDevices RemoteException", 12);
        }
    }

    public String getHiLinkDeviceId(Device device) {
        try {
            syncCheckConnStatus();
            if (this.mDeviceManager == null) {
                throw new WearEngineException(6);
            } else if (com.huawei.wearengine.utils.a.a("device_get_hi_link_device_id")) {
                return this.mDeviceManager.getHiLinkDeviceId(device);
            } else {
                com.huawei.wearengine.common.a.a(TAG, "getHiLinkDeviceId Health version is low");
                throw new WearEngineException(14);
            }
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            throw com.huawei.wearengine.a.a(TAG, "getHiLinkDeviceId RemoteException", 12);
        }
    }

    public boolean hasAvailableDevices() {
        try {
            syncCheckConnStatus();
            DeviceManager deviceManager = this.mDeviceManager;
            if (deviceManager != null) {
                return deviceManager.hasAvailableDevices();
            }
            throw new WearEngineException(6);
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            throw com.huawei.wearengine.a.a(TAG, "hasAvailableDevices RemoteException", 12);
        }
    }
}
