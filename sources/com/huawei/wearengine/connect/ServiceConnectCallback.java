package com.huawei.wearengine.connect;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface ServiceConnectCallback extends IInterface {

    public static class Default implements ServiceConnectCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onServiceDisconnect() {
        }
    }

    public static abstract class Stub extends Binder implements ServiceConnectCallback {
        private static final String DESCRIPTOR = "com.huawei.wearengine.connect.ServiceConnectCallback";

        public static class Proxy implements ServiceConnectCallback {
            public static ServiceConnectCallback sDefaultImpl;
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

            public void onServiceDisconnect() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onServiceDisconnect();
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

        public static ServiceConnectCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ServiceConnectCallback)) ? new Proxy(iBinder) : (ServiceConnectCallback) queryLocalInterface;
        }

        public static ServiceConnectCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ServiceConnectCallback serviceConnectCallback) {
            if (Proxy.sDefaultImpl != null || serviceConnectCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = serviceConnectCallback;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onServiceDisconnect();
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

    void onServiceDisconnect();
}
