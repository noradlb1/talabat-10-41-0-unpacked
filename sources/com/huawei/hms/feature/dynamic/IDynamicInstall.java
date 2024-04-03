package com.huawei.hms.feature.dynamic;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;

public interface IDynamicInstall extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.feature.dynamic.IDynamicInstall";

    public static class Default implements IDynamicInstall {
        public IBinder asBinder() {
            return null;
        }

        public Bundle install(IObjectWrapper iObjectWrapper, Bundle bundle) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IDynamicInstall {

        /* renamed from: a  reason: collision with root package name */
        public static final int f48735a = 1;

        public static class Proxy implements IDynamicInstall {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f48736a;

            public Proxy(IBinder iBinder) {
                this.f48736a = iBinder;
            }

            public IBinder asBinder() {
                return this.f48736a;
            }

            public String getInterfaceDescriptor() {
                return IDynamicInstall.DESCRIPTOR;
            }

            public Bundle install(IObjectWrapper iObjectWrapper, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDynamicInstall.DESCRIPTOR);
                    obtain.writeStrongInterface(iObjectWrapper);
                    _Parcel.b(obtain, bundle, 0);
                    this.f48736a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) _Parcel.b(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDynamicInstall.DESCRIPTOR);
        }

        public static IDynamicInstall asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDynamicInstall.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDynamicInstall)) ? new Proxy(iBinder) : (IDynamicInstall) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(IDynamicInstall.DESCRIPTOR);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(IDynamicInstall.DESCRIPTOR);
                return true;
            } else if (i11 != 1) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                Bundle install = install(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (Bundle) _Parcel.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                _Parcel.b(parcel2, install, 1);
                return true;
            }
        }
    }

    public static class _Parcel {
        /* access modifiers changed from: private */
        public static <T> T b(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public static <T extends Parcelable> void b(Parcel parcel, T t11, int i11) {
            if (t11 != null) {
                parcel.writeInt(1);
                t11.writeToParcel(parcel, i11);
                return;
            }
            parcel.writeInt(0);
        }
    }

    Bundle install(IObjectWrapper iObjectWrapper, Bundle bundle) throws RemoteException;
}
