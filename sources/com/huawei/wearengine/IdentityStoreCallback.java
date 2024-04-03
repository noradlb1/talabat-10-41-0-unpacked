package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IdentityStoreCallback extends IInterface {

    public static class Default implements IdentityStoreCallback {
        public IBinder asBinder() {
            return null;
        }

        public void storePermissionIdentity(String str) {
        }
    }

    public static abstract class Stub extends Binder implements IdentityStoreCallback {
        private static final String DESCRIPTOR = "com.huawei.wearengine.IdentityStoreCallback";

        public static class Proxy implements IdentityStoreCallback {
            public static IdentityStoreCallback sDefaultImpl;
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

            public void storePermissionIdentity(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().storePermissionIdentity(str);
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

        public static IdentityStoreCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IdentityStoreCallback)) ? new Proxy(iBinder) : (IdentityStoreCallback) queryLocalInterface;
        }

        public static IdentityStoreCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IdentityStoreCallback identityStoreCallback) {
            if (Proxy.sDefaultImpl != null || identityStoreCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = identityStoreCallback;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                storePermissionIdentity(parcel.readString());
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

    void storePermissionIdentity(String str);
}
