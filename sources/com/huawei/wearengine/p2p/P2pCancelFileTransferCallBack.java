package com.huawei.wearengine.p2p;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface P2pCancelFileTransferCallBack extends IInterface {

    public static class Default implements P2pCancelFileTransferCallBack {
        public IBinder asBinder() {
            return null;
        }

        public void onCancelFileTransferResult(int i11, String str) {
        }
    }

    public static abstract class Stub extends Binder implements P2pCancelFileTransferCallBack {
        private static final String DESCRIPTOR = "com.huawei.wearengine.p2p.P2pCancelFileTransferCallBack";

        public static class Proxy implements P2pCancelFileTransferCallBack {
            public static P2pCancelFileTransferCallBack sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void onCancelFileTransferResult(int i11, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    obtain.writeString(str);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onCancelFileTransferResult(i11, str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static P2pCancelFileTransferCallBack asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof P2pCancelFileTransferCallBack)) ? new Proxy(iBinder) : (P2pCancelFileTransferCallBack) queryLocalInterface;
        }

        public static P2pCancelFileTransferCallBack getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(P2pCancelFileTransferCallBack p2pCancelFileTransferCallBack) {
            if (Proxy.sDefaultImpl != null || p2pCancelFileTransferCallBack == null) {
                return false;
            }
            Proxy.sDefaultImpl = p2pCancelFileTransferCallBack;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onCancelFileTransferResult(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void onCancelFileTransferResult(int i11, String str);
}
