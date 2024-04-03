package com.huawei.wearengine.sensor;

import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.wearengine.SensorManager;
import com.huawei.wearengine.WearEngineException;
import com.huawei.wearengine.b;
import com.huawei.wearengine.c;
import com.huawei.wearengine.d;
import com.huawei.wearengine.device.Device;
import java.lang.ref.WeakReference;
import java.util.List;

public class SensorServiceProxy implements SensorManager, c {
    private static final int SENSOR_TYPE = 7;
    private static final String TAG = "SensorServiceProxy";
    private static volatile SensorServiceProxy sInstance;
    /* access modifiers changed from: private */
    public IBinder.DeathRecipient mDeathRecipient = new a();
    private final Object mLock = new Object();
    /* access modifiers changed from: private */
    public volatile SensorManager mSensorManager = null;

    public class a implements IBinder.DeathRecipient {
        public a() {
        }

        public void binderDied() {
            if (SensorServiceProxy.this.mSensorManager != null) {
                SensorServiceProxy.this.mSensorManager.asBinder().unlinkToDeath(SensorServiceProxy.this.mDeathRecipient, 0);
                SensorManager unused = SensorServiceProxy.this.mSensorManager = null;
            }
        }
    }

    private SensorServiceProxy() {
        registerReleaseConnectionCallback();
    }

    public static SensorServiceProxy getInstance() {
        if (sInstance == null) {
            synchronized (SensorServiceProxy.class) {
                if (sInstance == null) {
                    sInstance = new SensorServiceProxy();
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
            if (this.mSensorManager == null) {
                d.g().b();
                if (com.huawei.wearengine.utils.a.a("sensor")) {
                    IBinder a11 = d.g().a(7);
                    if (a11 != null) {
                        this.mSensorManager = SensorManager.Stub.asInterface(a11);
                        this.mSensorManager.asBinder().linkToDeath(this.mDeathRecipient, 0);
                    } else {
                        com.huawei.wearengine.common.a.c(TAG, "syncCheckConnStatusm binder is null.");
                        throw new WearEngineException(2);
                    }
                } else {
                    com.huawei.wearengine.common.a.a(TAG, "syncCheckConnStatusm health version is low");
                    throw new WearEngineException(14);
                }
            }
        }
    }

    public IBinder asBinder() {
        return null;
    }

    public int asyncRead(Device device, Sensor sensor, AsyncReadCallback asyncReadCallback) {
        try {
            syncCheckConnStatus();
            if (this.mSensorManager != null) {
                return this.mSensorManager.asyncRead(device, sensor, asyncReadCallback);
            }
            return 6;
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            return 12;
        }
    }

    public int asyncReadSensors(Device device, List<Sensor> list, AsyncReadCallback asyncReadCallback) {
        try {
            syncCheckConnStatus();
            if (this.mSensorManager != null) {
                return this.mSensorManager.asyncReadSensors(device, list, asyncReadCallback);
            }
            return 6;
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            return 12;
        }
    }

    public void clearBinderProxy() {
        this.mSensorManager = null;
    }

    public List<Sensor> getSensorList(Device device) {
        try {
            syncCheckConnStatus();
            if (this.mSensorManager != null) {
                return this.mSensorManager.getSensorList(device);
            }
            throw new WearEngineException(6);
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            throw new WearEngineException(12);
        }
    }

    public int stopAsyncRead(Device device, Sensor sensor, AsyncStopCallback asyncStopCallback) {
        try {
            syncCheckConnStatus();
            if (this.mSensorManager != null) {
                return this.mSensorManager.stopAsyncRead(device, sensor, asyncStopCallback);
            }
            return 6;
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            return 12;
        }
    }

    public int stopAsyncReadSensors(Device device, List<Sensor> list, AsyncStopCallback asyncStopCallback) {
        try {
            syncCheckConnStatus();
            if (this.mSensorManager != null) {
                return this.mSensorManager.stopAsyncReadSensors(device, list, asyncStopCallback);
            }
            return 6;
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            return 12;
        }
    }
}
