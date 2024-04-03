package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IUnusedAppRestrictionsBackportCallback extends IInterface {
    public static final String DESCRIPTOR = "androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback";

    public static class Default implements IUnusedAppRestrictionsBackportCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onIsPermissionRevocationEnabledForAppResult(boolean z11, boolean z12) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportCallback {
        static final int TRANSACTION_onIsPermissionRevocationEnabledForAppResult = 1;

        public static class Proxy implements IUnusedAppRestrictionsBackportCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IUnusedAppRestrictionsBackportCallback.DESCRIPTOR;
            }

            public void onIsPermissionRevocationEnabledForAppResult(boolean z11, boolean z12) throws RemoteException {
                int i11;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IUnusedAppRestrictionsBackportCallback.DESCRIPTOR);
                    int i12 = 0;
                    if (z11) {
                        i11 = 1;
                    } else {
                        i11 = 0;
                    }
                    obtain.writeInt(i11);
                    if (z12) {
                        i12 = 1;
                    }
                    obtain.writeInt(i12);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IUnusedAppRestrictionsBackportCallback.DESCRIPTOR);
        }

        public static IUnusedAppRestrictionsBackportCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IUnusedAppRestrictionsBackportCallback.DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IUnusedAppRestrictionsBackportCallback)) {
                return new Proxy(iBinder);
            }
            return (IUnusedAppRestrictionsBackportCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            boolean z11;
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(IUnusedAppRestrictionsBackportCallback.DESCRIPTOR);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(IUnusedAppRestrictionsBackportCallback.DESCRIPTOR);
                return true;
            } else if (i11 != 1) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                boolean z12 = false;
                if (parcel.readInt() != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (parcel.readInt() != 0) {
                    z12 = true;
                }
                onIsPermissionRevocationEnabledForAppResult(z11, z12);
                return true;
            }
        }
    }

    void onIsPermissionRevocationEnabledForAppResult(boolean z11, boolean z12) throws RemoteException;
}
