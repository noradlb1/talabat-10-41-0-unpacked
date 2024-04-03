package com.huawei.wearengine.auth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface AuthListener extends IInterface {

    public static class Default implements AuthListener {
        public IBinder asBinder() {
            return null;
        }

        public void onCancel() {
        }

        public void onOk(Permission[] permissionArr) {
        }
    }

    public static abstract class Stub extends Binder implements AuthListener {
        private static final String DESCRIPTOR = "com.huawei.wearengine.auth.AuthListener";

        public static class Proxy implements AuthListener {
            public static AuthListener sDefaultImpl;
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

            public void onCancel() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onCancel();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onOk(Permission[] permissionArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeTypedArray(permissionArr, 0);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onOk(permissionArr);
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

        public static AuthListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof AuthListener)) ? new Proxy(iBinder) : (AuthListener) queryLocalInterface;
        }

        public static AuthListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(AuthListener authListener) {
            if (Proxy.sDefaultImpl != null || authListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = authListener;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onOk((Permission[]) parcel.createTypedArray(Permission.CREATOR));
            } else if (i11 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onCancel();
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

    void onCancel();

    void onOk(Permission[] permissionArr);
}
