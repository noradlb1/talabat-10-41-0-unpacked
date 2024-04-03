package com.huawei.hms.feature.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IObjectWrapper extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.feature.dynamic.IObjectWrapper";

    public static class Default implements IObjectWrapper {
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IObjectWrapper {

        public static class Proxy implements IObjectWrapper {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f48739a;

            public Proxy(IBinder iBinder) {
                this.f48739a = iBinder;
            }

            public IBinder asBinder() {
                return this.f48739a;
            }

            public String getInterfaceDescriptor() {
                return IObjectWrapper.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IObjectWrapper.DESCRIPTOR);
        }

        public static IObjectWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IObjectWrapper.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IObjectWrapper)) ? new Proxy(iBinder) : (IObjectWrapper) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            }
            parcel2.writeString(IObjectWrapper.DESCRIPTOR);
            return true;
        }
    }
}
