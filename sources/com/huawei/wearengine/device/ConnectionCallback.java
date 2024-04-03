package com.huawei.wearengine.device;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface ConnectionCallback extends IInterface {

    public static class Default implements ConnectionCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onConnected(String str) {
        }

        public void onDisconnected(String str) {
        }
    }

    public static abstract class Stub extends Binder implements ConnectionCallback {
        private static final String DESCRIPTOR = "com.huawei.wearengine.device.ConnectionCallback";

        public static class Proxy implements ConnectionCallback {
            public static ConnectionCallback sDefaultImpl;
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

            public void onConnected(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onConnected(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDisconnected(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDisconnected(str);
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

        public static ConnectionCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ConnectionCallback)) ? new Proxy(iBinder) : (ConnectionCallback) queryLocalInterface;
        }

        public static ConnectionCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ConnectionCallback connectionCallback) {
            if (Proxy.sDefaultImpl != null || connectionCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = connectionCallback;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onConnected(parcel.readString());
            } else if (i11 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onDisconnected(parcel.readString());
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

    void onConnected(String str);

    void onDisconnected(String str);
}
