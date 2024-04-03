package com.huawei.wearengine.p2p;

import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.wearengine.P2pManager;
import com.huawei.wearengine.WearEngineException;
import com.huawei.wearengine.b;
import com.huawei.wearengine.c;
import com.huawei.wearengine.d;
import com.huawei.wearengine.device.Device;
import java.lang.ref.WeakReference;

public class P2pServiceProxy implements P2pManager, c {
    private static final int P2P_TYPE = 2;
    private static final String TAG = "P2pServiceProxy";
    private static volatile P2pServiceProxy sInstance;
    /* access modifiers changed from: private */
    public IBinder.DeathRecipient mDeathRecipient = new a();
    private final Object mLock = new Object();
    /* access modifiers changed from: private */
    public P2pManager mP2pManager = null;

    public class a implements IBinder.DeathRecipient {
        public a() {
        }

        public void binderDied() {
            if (P2pServiceProxy.this.mP2pManager != null) {
                P2pServiceProxy.this.mP2pManager.asBinder().unlinkToDeath(P2pServiceProxy.this.mDeathRecipient, 0);
                P2pManager unused = P2pServiceProxy.this.mP2pManager = null;
            }
        }
    }

    private P2pServiceProxy() {
        registerReleaseConnectionCallback();
    }

    public static P2pServiceProxy getInstance() {
        if (sInstance == null) {
            synchronized (P2pServiceProxy.class) {
                if (sInstance == null) {
                    sInstance = new P2pServiceProxy();
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
            if (this.mP2pManager == null) {
                d.g().b();
                IBinder a11 = d.g().a(2);
                if (a11 != null) {
                    P2pManager asInterface = P2pManager.Stub.asInterface(a11);
                    this.mP2pManager = asInterface;
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

    public int cancelFileTransfer(Device device, FileIdentificationParcel fileIdentificationParcel, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pCancelFileTransferCallBack p2pCancelFileTransferCallBack) {
        try {
            syncCheckConnStatus();
            if (!com.huawei.wearengine.utils.a.a("p2p_cancel_file_transfer")) {
                com.huawei.wearengine.common.a.c(TAG, "cancelFileTransfer health not support");
                return 14;
            }
            P2pManager p2pManager = this.mP2pManager;
            if (p2pManager != null) {
                return p2pManager.cancelFileTransfer(device, fileIdentificationParcel, identityInfo, identityInfo2, p2pCancelFileTransferCallBack);
            }
            return 6;
        } catch (IllegalStateException e11) {
            com.huawei.wearengine.common.a.a(TAG, "cancelFileTransfer IllegalStateException");
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            com.huawei.wearengine.common.a.a(TAG, "cancelFileTransfer RemoteException");
            return 12;
        }
    }

    public void clearBinderProxy() {
        this.mP2pManager = null;
    }

    public int getDeviceAppVersionCode(Device device, String str, String str2) {
        com.huawei.wearengine.common.a.a(TAG, "getDeviceAppVersionCode");
        try {
            syncCheckConnStatus();
            if (this.mP2pManager == null) {
                throw new WearEngineException(6);
            } else if (com.huawei.wearengine.utils.a.a("p2p_get_device_app_version_code")) {
                return this.mP2pManager.getDeviceAppVersionCode(device, str, str2);
            } else {
                com.huawei.wearengine.common.a.a(TAG, "getDeviceAppVersionCode Health version is low");
                throw new WearEngineException(14);
            }
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            throw com.huawei.wearengine.a.a(TAG, "getDeviceAppVersionCode RemoteException", 12);
        }
    }

    public int ping(Device device, String str, String str2, P2pPingCallback p2pPingCallback) {
        try {
            syncCheckConnStatus();
            P2pManager p2pManager = this.mP2pManager;
            if (p2pManager != null) {
                return p2pManager.ping(device, str, str2, p2pPingCallback);
            }
            return 6;
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            com.huawei.wearengine.common.a.a(TAG, "ping RemoteException");
            return 12;
        }
    }

    public int registerReceiver(Device device, IdentityInfo identityInfo, IdentityInfo identityInfo2, ReceiverCallback receiverCallback, int i11) {
        try {
            syncCheckConnStatus();
            P2pManager p2pManager = this.mP2pManager;
            if (p2pManager != null) {
                return p2pManager.registerReceiver(device, identityInfo, identityInfo2, receiverCallback, i11);
            }
            return 6;
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            com.huawei.wearengine.common.a.a(TAG, "registerReceiver RemoteException");
            return 12;
        }
    }

    public int registerReceiverInternal(Device device, IdentityInfo identityInfo, IdentityInfo identityInfo2, ReceiverCallback receiverCallback, int i11) {
        try {
            syncCheckConnStatus();
            P2pManager p2pManager = this.mP2pManager;
            if (p2pManager != null) {
                return p2pManager.registerReceiverInternal(device, identityInfo, identityInfo2, receiverCallback, i11);
            }
            return 6;
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            com.huawei.wearengine.common.a.a(TAG, "registerReceiverInternal RemoteException");
            return 12;
        }
    }

    public int send(Device device, MessageParcel messageParcel, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pSendCallback p2pSendCallback) {
        try {
            syncCheckConnStatus();
            P2pManager p2pManager = this.mP2pManager;
            if (p2pManager != null) {
                return p2pManager.send(device, messageParcel, identityInfo, identityInfo2, p2pSendCallback);
            }
            return 6;
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            com.huawei.wearengine.common.a.a(TAG, "send RemoteException");
            return 12;
        }
    }

    public int sendExtra(Device device, MessageParcelExtra messageParcelExtra, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pSendCallback p2pSendCallback) {
        try {
            syncCheckConnStatus();
            if (!com.huawei.wearengine.utils.a.a("p2p_send_extra")) {
                com.huawei.wearengine.common.a.c(TAG, "sendExtra health not support");
                return 14;
            }
            P2pManager p2pManager = this.mP2pManager;
            if (p2pManager != null) {
                return p2pManager.sendExtra(device, messageParcelExtra, identityInfo, identityInfo2, p2pSendCallback);
            }
            return 6;
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            com.huawei.wearengine.common.a.a(TAG, "send RemoteException");
            return 12;
        }
    }

    public int sendInternal(Device device, MessageParcelExtra messageParcelExtra, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pSendCallback p2pSendCallback) {
        try {
            syncCheckConnStatus();
            P2pManager p2pManager = this.mP2pManager;
            if (p2pManager != null) {
                return p2pManager.sendInternal(device, messageParcelExtra, identityInfo, identityInfo2, p2pSendCallback);
            }
            return 6;
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            com.huawei.wearengine.common.a.a(TAG, "sendInternal RemoteException");
            return 12;
        }
    }

    public int unregisterReceiver(ReceiverCallback receiverCallback, int i11) {
        try {
            syncCheckConnStatus();
            P2pManager p2pManager = this.mP2pManager;
            if (p2pManager != null) {
                return p2pManager.unregisterReceiver(receiverCallback, i11);
            }
            return 6;
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            com.huawei.wearengine.common.a.a(TAG, "unregisterReceiver RemoteException");
            return 12;
        }
    }
}
