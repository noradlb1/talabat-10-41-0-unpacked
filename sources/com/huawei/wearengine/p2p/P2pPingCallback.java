package com.huawei.wearengine.p2p;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface P2pPingCallback extends IInterface {

    public static class Default implements P2pPingCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onResult(int i11) {
        }
    }

    public static abstract class Stub extends Binder implements P2pPingCallback {
        private static final String DESCRIPTOR = "com.huawei.wearengine.p2p.P2pPingCallback";

        public static class Proxy implements P2pPingCallback {
            public static P2pPingCallback sDefaultImpl;
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

            public void onResult(int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onResult(i11);
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

        public static P2pPingCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof P2pPingCallback)) ? new Proxy(iBinder) : (P2pPingCallback) queryLocalInterface;
        }

        public static P2pPingCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(P2pPingCallback p2pPingCallback) {
            if (Proxy.sDefaultImpl != null || p2pPingCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = p2pPingCallback;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onResult(parcel.readInt());
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

    void onResult(int i11);
}
