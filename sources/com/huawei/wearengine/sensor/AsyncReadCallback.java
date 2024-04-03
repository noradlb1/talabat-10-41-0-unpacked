package com.huawei.wearengine.sensor;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface AsyncReadCallback extends IInterface {

    public static class Default implements AsyncReadCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onReadResult(int i11, DataResult dataResult) {
        }
    }

    public static abstract class Stub extends Binder implements AsyncReadCallback {
        private static final String DESCRIPTOR = "com.huawei.wearengine.sensor.AsyncReadCallback";

        public static class Proxy implements AsyncReadCallback {
            public static AsyncReadCallback sDefaultImpl;
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

            public void onReadResult(int i11, DataResult dataResult) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    if (dataResult != null) {
                        obtain.writeInt(1);
                        dataResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            dataResult.readFromParcel(obtain2);
                        }
                    } else {
                        Stub.getDefaultImpl().onReadResult(i11, dataResult);
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

        public static AsyncReadCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof AsyncReadCallback)) ? new Proxy(iBinder) : (AsyncReadCallback) queryLocalInterface;
        }

        public static AsyncReadCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(AsyncReadCallback asyncReadCallback) {
            if (Proxy.sDefaultImpl != null || asyncReadCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = asyncReadCallback;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                int readInt = parcel.readInt();
                DataResult createFromParcel = parcel.readInt() != 0 ? DataResult.CREATOR.createFromParcel(parcel) : null;
                onReadResult(readInt, createFromParcel);
                parcel2.writeNoException();
                if (createFromParcel != null) {
                    parcel2.writeInt(1);
                    createFromParcel.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void onReadResult(int i11, DataResult dataResult);
}
