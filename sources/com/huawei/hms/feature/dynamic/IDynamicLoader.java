package com.huawei.hms.feature.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;

public interface IDynamicLoader extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.feature.dynamic.IDynamicLoader";

    public static class Default implements IDynamicLoader {
        public IBinder asBinder() {
            return null;
        }

        public IObjectWrapper load(IObjectWrapper iObjectWrapper, String str, int i11, IObjectWrapper iObjectWrapper2) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IDynamicLoader {

        /* renamed from: a  reason: collision with root package name */
        public static final int f48737a = 1;

        public static class Proxy implements IDynamicLoader {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f48738a;

            public Proxy(IBinder iBinder) {
                this.f48738a = iBinder;
            }

            public IBinder asBinder() {
                return this.f48738a;
            }

            public String getInterfaceDescriptor() {
                return IDynamicLoader.DESCRIPTOR;
            }

            public IObjectWrapper load(IObjectWrapper iObjectWrapper, String str, int i11, IObjectWrapper iObjectWrapper2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDynamicLoader.DESCRIPTOR);
                    obtain.writeStrongInterface(iObjectWrapper);
                    obtain.writeString(str);
                    obtain.writeInt(i11);
                    obtain.writeStrongInterface(iObjectWrapper2);
                    this.f48738a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDynamicLoader.DESCRIPTOR);
        }

        public static IDynamicLoader asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDynamicLoader.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDynamicLoader)) ? new Proxy(iBinder) : (IDynamicLoader) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(IDynamicLoader.DESCRIPTOR);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(IDynamicLoader.DESCRIPTOR);
                return true;
            } else if (i11 != 1) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                IObjectWrapper load = load(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeStrongInterface(load);
                return true;
            }
        }
    }

    IObjectWrapper load(IObjectWrapper iObjectWrapper, String str, int i11, IObjectWrapper iObjectWrapper2) throws RemoteException;
}
