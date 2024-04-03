package com.huawei.hms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.feature.dynamic.IObjectWrapper;

public interface IBitmapDescriptorDelegate extends IInterface {

    public static abstract class Stub extends Binder implements IBitmapDescriptorDelegate {

        public static class Proxy implements IBitmapDescriptorDelegate {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49589a;

            public Proxy(IBinder iBinder) {
                this.f49589a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49589a;
            }

            public IObjectWrapper defaultMarker() {
                return IObjectWrapper.Stub.asInterface(mab.j(this.f49589a, "com.huawei.hms.maps.model.internal.IBitmapDescriptorDelegate", 1));
            }

            public IObjectWrapper defaultMarkerWithHue(float f11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.model.internal.IBitmapDescriptorDelegate");
                    obtain.writeFloat(f11);
                    this.f49589a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.model.internal.IBitmapDescriptorDelegate";
            }
        }

        public static IBitmapDescriptorDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.model.internal.IBitmapDescriptorDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IBitmapDescriptorDelegate)) ? new Proxy(iBinder) : (IBitmapDescriptorDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    IObjectWrapper defaultMarker();

    IObjectWrapper defaultMarkerWithHue(float f11);
}
