package com.huawei.wearengine.p2p;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface P2pSendCallback extends IInterface {

    public static class Default implements P2pSendCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onSendProgress(long j11) {
        }

        public void onSendResult(int i11) {
        }
    }

    public static abstract class Stub extends Binder implements P2pSendCallback {
        private static final String DESCRIPTOR = "com.huawei.wearengine.p2p.P2pSendCallback";

        public static class Proxy implements P2pSendCallback {
            public static P2pSendCallback sDefaultImpl;
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

            public void onSendProgress(long j11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j11);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onSendProgress(j11);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSendResult(int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onSendResult(i11);
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

        public static P2pSendCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof P2pSendCallback)) ? new Proxy(iBinder) : (P2pSendCallback) queryLocalInterface;
        }

        public static P2pSendCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(P2pSendCallback p2pSendCallback) {
            if (Proxy.sDefaultImpl != null || p2pSendCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = p2pSendCallback;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onSendResult(parcel.readInt());
            } else if (i11 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onSendProgress(parcel.readLong());
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onSendProgress(long j11);

    void onSendResult(int i11);
}
