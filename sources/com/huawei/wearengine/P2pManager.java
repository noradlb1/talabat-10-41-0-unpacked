package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.wearengine.device.Device;
import com.huawei.wearengine.p2p.FileIdentificationParcel;
import com.huawei.wearengine.p2p.IdentityInfo;
import com.huawei.wearengine.p2p.MessageParcel;
import com.huawei.wearengine.p2p.MessageParcelExtra;
import com.huawei.wearengine.p2p.P2pCancelFileTransferCallBack;
import com.huawei.wearengine.p2p.P2pPingCallback;
import com.huawei.wearengine.p2p.P2pSendCallback;
import com.huawei.wearengine.p2p.ReceiverCallback;

public interface P2pManager extends IInterface {

    public static class Default implements P2pManager {
        public IBinder asBinder() {
            return null;
        }

        public int cancelFileTransfer(Device device, FileIdentificationParcel fileIdentificationParcel, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pCancelFileTransferCallBack p2pCancelFileTransferCallBack) {
            return 0;
        }

        public int getDeviceAppVersionCode(Device device, String str, String str2) {
            return 0;
        }

        public int ping(Device device, String str, String str2, P2pPingCallback p2pPingCallback) {
            return 0;
        }

        public int registerReceiver(Device device, IdentityInfo identityInfo, IdentityInfo identityInfo2, ReceiverCallback receiverCallback, int i11) {
            return 0;
        }

        public int registerReceiverInternal(Device device, IdentityInfo identityInfo, IdentityInfo identityInfo2, ReceiverCallback receiverCallback, int i11) {
            return 0;
        }

        public int send(Device device, MessageParcel messageParcel, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pSendCallback p2pSendCallback) {
            return 0;
        }

        public int sendExtra(Device device, MessageParcelExtra messageParcelExtra, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pSendCallback p2pSendCallback) {
            return 0;
        }

        public int sendInternal(Device device, MessageParcelExtra messageParcelExtra, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pSendCallback p2pSendCallback) {
            return 0;
        }

        public int unregisterReceiver(ReceiverCallback receiverCallback, int i11) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements P2pManager {
        private static final String DESCRIPTOR = "com.huawei.wearengine.P2pManager";

        public static class Proxy implements P2pManager {
            public static P2pManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public int cancelFileTransfer(Device device, FileIdentificationParcel fileIdentificationParcel, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pCancelFileTransferCallBack p2pCancelFileTransferCallBack) {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (fileIdentificationParcel != null) {
                        obtain.writeInt(1);
                        fileIdentificationParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (identityInfo != null) {
                        obtain.writeInt(1);
                        identityInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (identityInfo2 != null) {
                        obtain.writeInt(1);
                        identityInfo2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(p2pCancelFileTransferCallBack != null ? p2pCancelFileTransferCallBack.asBinder() : null);
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().cancelFileTransfer(device, fileIdentificationParcel, identityInfo, identityInfo2, p2pCancelFileTransferCallBack);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getDeviceAppVersionCode(Device device, String str, String str2) {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().getDeviceAppVersionCode(device, str, str2);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public int ping(Device device, String str, String str2, P2pPingCallback p2pPingCallback) {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(p2pPingCallback != null ? p2pPingCallback.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().ping(device, str, str2, p2pPingCallback);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int registerReceiver(Device device, IdentityInfo identityInfo, IdentityInfo identityInfo2, ReceiverCallback receiverCallback, int i11) {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (identityInfo != null) {
                        obtain.writeInt(1);
                        identityInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (identityInfo2 != null) {
                        obtain.writeInt(1);
                        identityInfo2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(receiverCallback != null ? receiverCallback.asBinder() : null);
                    obtain.writeInt(i11);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().registerReceiver(device, identityInfo, identityInfo2, receiverCallback, i11);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int registerReceiverInternal(Device device, IdentityInfo identityInfo, IdentityInfo identityInfo2, ReceiverCallback receiverCallback, int i11) {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (identityInfo != null) {
                        obtain.writeInt(1);
                        identityInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (identityInfo2 != null) {
                        obtain.writeInt(1);
                        identityInfo2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(receiverCallback != null ? receiverCallback.asBinder() : null);
                    obtain.writeInt(i11);
                    if (this.mRemote.transact(8, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().registerReceiverInternal(device, identityInfo, identityInfo2, receiverCallback, i11);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int send(Device device, MessageParcel messageParcel, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pSendCallback p2pSendCallback) {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (messageParcel != null) {
                        obtain.writeInt(1);
                        messageParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (identityInfo != null) {
                        obtain.writeInt(1);
                        identityInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (identityInfo2 != null) {
                        obtain.writeInt(1);
                        identityInfo2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(p2pSendCallback != null ? p2pSendCallback.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().send(device, messageParcel, identityInfo, identityInfo2, p2pSendCallback);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int sendExtra(Device device, MessageParcelExtra messageParcelExtra, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pSendCallback p2pSendCallback) {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (messageParcelExtra != null) {
                        obtain.writeInt(1);
                        messageParcelExtra.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (identityInfo != null) {
                        obtain.writeInt(1);
                        identityInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (identityInfo2 != null) {
                        obtain.writeInt(1);
                        identityInfo2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(p2pSendCallback != null ? p2pSendCallback.asBinder() : null);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().sendExtra(device, messageParcelExtra, identityInfo, identityInfo2, p2pSendCallback);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int sendInternal(Device device, MessageParcelExtra messageParcelExtra, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pSendCallback p2pSendCallback) {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (messageParcelExtra != null) {
                        obtain.writeInt(1);
                        messageParcelExtra.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (identityInfo != null) {
                        obtain.writeInt(1);
                        identityInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (identityInfo2 != null) {
                        obtain.writeInt(1);
                        identityInfo2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(p2pSendCallback != null ? p2pSendCallback.asBinder() : null);
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().sendInternal(device, messageParcelExtra, identityInfo, identityInfo2, p2pSendCallback);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int unregisterReceiver(ReceiverCallback receiverCallback, int i11) {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(receiverCallback != null ? receiverCallback.asBinder() : null);
                    obtain.writeInt(i11);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().unregisterReceiver(receiverCallback, i11);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static P2pManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof P2pManager)) ? new Proxy(iBinder) : (P2pManager) queryLocalInterface;
        }

        public static P2pManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(P2pManager p2pManager) {
            if (Proxy.sDefaultImpl != null || p2pManager == null) {
                return false;
            }
            Proxy.sDefaultImpl = p2pManager;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.huawei.wearengine.p2p.IdentityInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.huawei.wearengine.p2p.IdentityInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: com.huawei.wearengine.p2p.IdentityInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: com.huawei.wearengine.p2p.IdentityInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: com.huawei.wearengine.p2p.IdentityInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: com.huawei.wearengine.p2p.IdentityInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v30, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v31, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX WARNING: type inference failed for: r0v7, types: [com.huawei.wearengine.p2p.IdentityInfo] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.huawei.wearengine.p2p.IdentityInfo] */
        /* JADX WARNING: type inference failed for: r0v13, types: [com.huawei.wearengine.p2p.IdentityInfo] */
        /* JADX WARNING: type inference failed for: r0v19, types: [com.huawei.wearengine.p2p.IdentityInfo] */
        /* JADX WARNING: type inference failed for: r0v22, types: [com.huawei.wearengine.p2p.IdentityInfo] */
        /* JADX WARNING: type inference failed for: r0v25, types: [com.huawei.wearengine.p2p.IdentityInfo] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) {
            /*
                r8 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                java.lang.String r2 = "com.huawei.wearengine.P2pManager"
                if (r9 == r0) goto L_0x0256
                r0 = 0
                switch(r9) {
                    case 1: goto L_0x022e;
                    case 2: goto L_0x01d9;
                    case 3: goto L_0x0191;
                    case 4: goto L_0x017c;
                    case 5: goto L_0x0127;
                    case 6: goto L_0x0107;
                    case 7: goto L_0x00b2;
                    case 8: goto L_0x006b;
                    case 9: goto L_0x0011;
                    default: goto L_0x000c;
                }
            L_0x000c:
                boolean r9 = super.onTransact(r9, r10, r11, r12)
                return r9
            L_0x0011:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x0024
                android.os.Parcelable$Creator<com.huawei.wearengine.device.Device> r9 = com.huawei.wearengine.device.Device.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                com.huawei.wearengine.device.Device r9 = (com.huawei.wearengine.device.Device) r9
                r3 = r9
                goto L_0x0025
            L_0x0024:
                r3 = r0
            L_0x0025:
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x0035
                android.os.Parcelable$Creator<com.huawei.wearengine.p2p.FileIdentificationParcel> r9 = com.huawei.wearengine.p2p.FileIdentificationParcel.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                com.huawei.wearengine.p2p.FileIdentificationParcel r9 = (com.huawei.wearengine.p2p.FileIdentificationParcel) r9
                r4 = r9
                goto L_0x0036
            L_0x0035:
                r4 = r0
            L_0x0036:
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x0046
                android.os.Parcelable$Creator<com.huawei.wearengine.p2p.IdentityInfo> r9 = com.huawei.wearengine.p2p.IdentityInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                com.huawei.wearengine.p2p.IdentityInfo r9 = (com.huawei.wearengine.p2p.IdentityInfo) r9
                r5 = r9
                goto L_0x0047
            L_0x0046:
                r5 = r0
            L_0x0047:
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x0056
                android.os.Parcelable$Creator<com.huawei.wearengine.p2p.IdentityInfo> r9 = com.huawei.wearengine.p2p.IdentityInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r0 = r9
                com.huawei.wearengine.p2p.IdentityInfo r0 = (com.huawei.wearengine.p2p.IdentityInfo) r0
            L_0x0056:
                r6 = r0
                android.os.IBinder r9 = r10.readStrongBinder()
                com.huawei.wearengine.p2p.P2pCancelFileTransferCallBack r7 = com.huawei.wearengine.p2p.P2pCancelFileTransferCallBack.Stub.asInterface(r9)
                r2 = r8
                int r9 = r2.cancelFileTransfer(r3, r4, r5, r6, r7)
            L_0x0064:
                r11.writeNoException()
                r11.writeInt(r9)
                return r1
            L_0x006b:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x007e
                android.os.Parcelable$Creator<com.huawei.wearengine.device.Device> r9 = com.huawei.wearengine.device.Device.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                com.huawei.wearengine.device.Device r9 = (com.huawei.wearengine.device.Device) r9
                r3 = r9
                goto L_0x007f
            L_0x007e:
                r3 = r0
            L_0x007f:
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x008f
                android.os.Parcelable$Creator<com.huawei.wearengine.p2p.IdentityInfo> r9 = com.huawei.wearengine.p2p.IdentityInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                com.huawei.wearengine.p2p.IdentityInfo r9 = (com.huawei.wearengine.p2p.IdentityInfo) r9
                r4 = r9
                goto L_0x0090
            L_0x008f:
                r4 = r0
            L_0x0090:
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x009f
                android.os.Parcelable$Creator<com.huawei.wearengine.p2p.IdentityInfo> r9 = com.huawei.wearengine.p2p.IdentityInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r0 = r9
                com.huawei.wearengine.p2p.IdentityInfo r0 = (com.huawei.wearengine.p2p.IdentityInfo) r0
            L_0x009f:
                r5 = r0
                android.os.IBinder r9 = r10.readStrongBinder()
                com.huawei.wearengine.p2p.ReceiverCallback r6 = com.huawei.wearengine.p2p.ReceiverCallback.Stub.asInterface(r9)
                int r7 = r10.readInt()
                r2 = r8
                int r9 = r2.registerReceiverInternal(r3, r4, r5, r6, r7)
                goto L_0x0064
            L_0x00b2:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x00c5
                android.os.Parcelable$Creator<com.huawei.wearengine.device.Device> r9 = com.huawei.wearengine.device.Device.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                com.huawei.wearengine.device.Device r9 = (com.huawei.wearengine.device.Device) r9
                r3 = r9
                goto L_0x00c6
            L_0x00c5:
                r3 = r0
            L_0x00c6:
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x00d6
                android.os.Parcelable$Creator<com.huawei.wearengine.p2p.MessageParcelExtra> r9 = com.huawei.wearengine.p2p.MessageParcelExtra.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                com.huawei.wearengine.p2p.MessageParcelExtra r9 = (com.huawei.wearengine.p2p.MessageParcelExtra) r9
                r4 = r9
                goto L_0x00d7
            L_0x00d6:
                r4 = r0
            L_0x00d7:
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x00e7
                android.os.Parcelable$Creator<com.huawei.wearengine.p2p.IdentityInfo> r9 = com.huawei.wearengine.p2p.IdentityInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                com.huawei.wearengine.p2p.IdentityInfo r9 = (com.huawei.wearengine.p2p.IdentityInfo) r9
                r5 = r9
                goto L_0x00e8
            L_0x00e7:
                r5 = r0
            L_0x00e8:
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x00f7
                android.os.Parcelable$Creator<com.huawei.wearengine.p2p.IdentityInfo> r9 = com.huawei.wearengine.p2p.IdentityInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r0 = r9
                com.huawei.wearengine.p2p.IdentityInfo r0 = (com.huawei.wearengine.p2p.IdentityInfo) r0
            L_0x00f7:
                r6 = r0
                android.os.IBinder r9 = r10.readStrongBinder()
                com.huawei.wearengine.p2p.P2pSendCallback r7 = com.huawei.wearengine.p2p.P2pSendCallback.Stub.asInterface(r9)
                r2 = r8
                int r9 = r2.sendInternal(r3, r4, r5, r6, r7)
                goto L_0x0064
            L_0x0107:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x0119
                android.os.Parcelable$Creator<com.huawei.wearengine.device.Device> r9 = com.huawei.wearengine.device.Device.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r0 = r9
                com.huawei.wearengine.device.Device r0 = (com.huawei.wearengine.device.Device) r0
            L_0x0119:
                java.lang.String r9 = r10.readString()
                java.lang.String r10 = r10.readString()
                int r9 = r8.getDeviceAppVersionCode(r0, r9, r10)
                goto L_0x0064
            L_0x0127:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x013a
                android.os.Parcelable$Creator<com.huawei.wearengine.device.Device> r9 = com.huawei.wearengine.device.Device.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                com.huawei.wearengine.device.Device r9 = (com.huawei.wearengine.device.Device) r9
                r3 = r9
                goto L_0x013b
            L_0x013a:
                r3 = r0
            L_0x013b:
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x014b
                android.os.Parcelable$Creator<com.huawei.wearengine.p2p.MessageParcelExtra> r9 = com.huawei.wearengine.p2p.MessageParcelExtra.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                com.huawei.wearengine.p2p.MessageParcelExtra r9 = (com.huawei.wearengine.p2p.MessageParcelExtra) r9
                r4 = r9
                goto L_0x014c
            L_0x014b:
                r4 = r0
            L_0x014c:
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x015c
                android.os.Parcelable$Creator<com.huawei.wearengine.p2p.IdentityInfo> r9 = com.huawei.wearengine.p2p.IdentityInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                com.huawei.wearengine.p2p.IdentityInfo r9 = (com.huawei.wearengine.p2p.IdentityInfo) r9
                r5 = r9
                goto L_0x015d
            L_0x015c:
                r5 = r0
            L_0x015d:
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x016c
                android.os.Parcelable$Creator<com.huawei.wearengine.p2p.IdentityInfo> r9 = com.huawei.wearengine.p2p.IdentityInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r0 = r9
                com.huawei.wearengine.p2p.IdentityInfo r0 = (com.huawei.wearengine.p2p.IdentityInfo) r0
            L_0x016c:
                r6 = r0
                android.os.IBinder r9 = r10.readStrongBinder()
                com.huawei.wearengine.p2p.P2pSendCallback r7 = com.huawei.wearengine.p2p.P2pSendCallback.Stub.asInterface(r9)
                r2 = r8
                int r9 = r2.sendExtra(r3, r4, r5, r6, r7)
                goto L_0x0064
            L_0x017c:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.huawei.wearengine.p2p.ReceiverCallback r9 = com.huawei.wearengine.p2p.ReceiverCallback.Stub.asInterface(r9)
                int r10 = r10.readInt()
                int r9 = r8.unregisterReceiver(r9, r10)
                goto L_0x0064
            L_0x0191:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x01a4
                android.os.Parcelable$Creator<com.huawei.wearengine.device.Device> r9 = com.huawei.wearengine.device.Device.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                com.huawei.wearengine.device.Device r9 = (com.huawei.wearengine.device.Device) r9
                r3 = r9
                goto L_0x01a5
            L_0x01a4:
                r3 = r0
            L_0x01a5:
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x01b5
                android.os.Parcelable$Creator<com.huawei.wearengine.p2p.IdentityInfo> r9 = com.huawei.wearengine.p2p.IdentityInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                com.huawei.wearengine.p2p.IdentityInfo r9 = (com.huawei.wearengine.p2p.IdentityInfo) r9
                r4 = r9
                goto L_0x01b6
            L_0x01b5:
                r4 = r0
            L_0x01b6:
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x01c5
                android.os.Parcelable$Creator<com.huawei.wearengine.p2p.IdentityInfo> r9 = com.huawei.wearengine.p2p.IdentityInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r0 = r9
                com.huawei.wearengine.p2p.IdentityInfo r0 = (com.huawei.wearengine.p2p.IdentityInfo) r0
            L_0x01c5:
                r5 = r0
                android.os.IBinder r9 = r10.readStrongBinder()
                com.huawei.wearengine.p2p.ReceiverCallback r6 = com.huawei.wearengine.p2p.ReceiverCallback.Stub.asInterface(r9)
                int r7 = r10.readInt()
                r2 = r8
                int r9 = r2.registerReceiver(r3, r4, r5, r6, r7)
                goto L_0x0064
            L_0x01d9:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x01ec
                android.os.Parcelable$Creator<com.huawei.wearengine.device.Device> r9 = com.huawei.wearengine.device.Device.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                com.huawei.wearengine.device.Device r9 = (com.huawei.wearengine.device.Device) r9
                r3 = r9
                goto L_0x01ed
            L_0x01ec:
                r3 = r0
            L_0x01ed:
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x01fd
                android.os.Parcelable$Creator<com.huawei.wearengine.p2p.MessageParcel> r9 = com.huawei.wearengine.p2p.MessageParcel.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                com.huawei.wearengine.p2p.MessageParcel r9 = (com.huawei.wearengine.p2p.MessageParcel) r9
                r4 = r9
                goto L_0x01fe
            L_0x01fd:
                r4 = r0
            L_0x01fe:
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x020e
                android.os.Parcelable$Creator<com.huawei.wearengine.p2p.IdentityInfo> r9 = com.huawei.wearengine.p2p.IdentityInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                com.huawei.wearengine.p2p.IdentityInfo r9 = (com.huawei.wearengine.p2p.IdentityInfo) r9
                r5 = r9
                goto L_0x020f
            L_0x020e:
                r5 = r0
            L_0x020f:
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x021e
                android.os.Parcelable$Creator<com.huawei.wearengine.p2p.IdentityInfo> r9 = com.huawei.wearengine.p2p.IdentityInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r0 = r9
                com.huawei.wearengine.p2p.IdentityInfo r0 = (com.huawei.wearengine.p2p.IdentityInfo) r0
            L_0x021e:
                r6 = r0
                android.os.IBinder r9 = r10.readStrongBinder()
                com.huawei.wearengine.p2p.P2pSendCallback r7 = com.huawei.wearengine.p2p.P2pSendCallback.Stub.asInterface(r9)
                r2 = r8
                int r9 = r2.send(r3, r4, r5, r6, r7)
                goto L_0x0064
            L_0x022e:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x0240
                android.os.Parcelable$Creator<com.huawei.wearengine.device.Device> r9 = com.huawei.wearengine.device.Device.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r0 = r9
                com.huawei.wearengine.device.Device r0 = (com.huawei.wearengine.device.Device) r0
            L_0x0240:
                java.lang.String r9 = r10.readString()
                java.lang.String r12 = r10.readString()
                android.os.IBinder r10 = r10.readStrongBinder()
                com.huawei.wearengine.p2p.P2pPingCallback r10 = com.huawei.wearengine.p2p.P2pPingCallback.Stub.asInterface(r10)
                int r9 = r8.ping(r0, r9, r12, r10)
                goto L_0x0064
            L_0x0256:
                r11.writeString(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.wearengine.P2pManager.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    int cancelFileTransfer(Device device, FileIdentificationParcel fileIdentificationParcel, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pCancelFileTransferCallBack p2pCancelFileTransferCallBack);

    int getDeviceAppVersionCode(Device device, String str, String str2);

    int ping(Device device, String str, String str2, P2pPingCallback p2pPingCallback);

    int registerReceiver(Device device, IdentityInfo identityInfo, IdentityInfo identityInfo2, ReceiverCallback receiverCallback, int i11);

    int registerReceiverInternal(Device device, IdentityInfo identityInfo, IdentityInfo identityInfo2, ReceiverCallback receiverCallback, int i11);

    int send(Device device, MessageParcel messageParcel, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pSendCallback p2pSendCallback);

    int sendExtra(Device device, MessageParcelExtra messageParcelExtra, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pSendCallback p2pSendCallback);

    int sendInternal(Device device, MessageParcelExtra messageParcelExtra, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pSendCallback p2pSendCallback);

    int unregisterReceiver(ReceiverCallback receiverCallback, int i11);
}
