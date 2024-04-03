package com.huawei.wearengine.sensor;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface AsyncStopCallback extends IInterface {

    public static class Default implements AsyncStopCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onStopResult(int i11) {
        }
    }

    public static abstract class Stub extends Binder implements AsyncStopCallback {
        private static final String DESCRIPTOR = "com.huawei.wearengine.sensor.AsyncStopCallback";

        public static class Proxy implements AsyncStopCallback {
            public static AsyncStopCallback sDefaultImpl;
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

            public void onStopResult(int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onStopResult(i11);
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

        public static AsyncStopCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof AsyncStopCallback)) ? new Proxy(iBinder) : (AsyncStopCallback) queryLocalInterface;
        }

        public static AsyncStopCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(AsyncStopCallback asyncStopCallback) {
            if (Proxy.sDefaultImpl != null || asyncStopCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = asyncStopCallback;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onStopResult(parcel.readInt());
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

    void onStopResult(int i11);
}
