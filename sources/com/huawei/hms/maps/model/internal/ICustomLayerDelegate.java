package com.huawei.hms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface ICustomLayerDelegate extends IInterface {

    public static class Default implements ICustomLayerDelegate {
        public IBinder asBinder() {
            return null;
        }

        public void remove() {
        }
    }

    public static abstract class Stub extends Binder implements ICustomLayerDelegate {

        public static class Proxy implements ICustomLayerDelegate {
            public static ICustomLayerDelegate sDefaultImpl;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49591a;

            public Proxy(IBinder iBinder) {
                this.f49591a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49591a;
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.model.internal.ICustomLayerDelegate";
            }

            public void remove() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.model.internal.ICustomLayerDelegate");
                    if (this.f49591a.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().remove();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.model.internal.ICustomLayerDelegate");
        }

        public static ICustomLayerDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.model.internal.ICustomLayerDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ICustomLayerDelegate)) ? new Proxy(iBinder) : (ICustomLayerDelegate) queryLocalInterface;
        }

        public static ICustomLayerDelegate getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICustomLayerDelegate iCustomLayerDelegate) {
            if (Proxy.sDefaultImpl != null || iCustomLayerDelegate == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCustomLayerDelegate;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface("com.huawei.hms.maps.model.internal.ICustomLayerDelegate");
                remove();
                parcel2.writeNoException();
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString("com.huawei.hms.maps.model.internal.ICustomLayerDelegate");
                return true;
            }
        }
    }

    void remove();
}
