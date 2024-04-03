package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

public interface IUnusedAppRestrictionsBackportService extends IInterface {
    public static final String DESCRIPTOR = "androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService";

    public static class Default implements IUnusedAppRestrictionsBackportService {
        public IBinder asBinder() {
            return null;
        }

        public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportService {
        static final int TRANSACTION_isPermissionRevocationEnabledForApp = 1;

        public static class Proxy implements IUnusedAppRestrictionsBackportService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IUnusedAppRestrictionsBackportService.DESCRIPTOR;
            }

            public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IUnusedAppRestrictionsBackportService.DESCRIPTOR);
                    obtain.writeStrongInterface(iUnusedAppRestrictionsBackportCallback);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IUnusedAppRestrictionsBackportService.DESCRIPTOR);
        }

        public static IUnusedAppRestrictionsBackportService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IUnusedAppRestrictionsBackportService.DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IUnusedAppRestrictionsBackportService)) {
                return new Proxy(iBinder);
            }
            return (IUnusedAppRestrictionsBackportService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(IUnusedAppRestrictionsBackportService.DESCRIPTOR);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(IUnusedAppRestrictionsBackportService.DESCRIPTOR);
                return true;
            } else if (i11 != 1) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            }
        }
    }

    void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) throws RemoteException;
}
