package com.huawei.hms.maps.internal;

import android.graphics.Point;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.VisibleRegion;

public interface IProjectionDelegate extends IInterface {

    public static abstract class Stub extends Binder implements IProjectionDelegate {

        public static class Proxy implements IProjectionDelegate {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49391a;

            public Proxy(IBinder iBinder) {
                this.f49391a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49391a;
            }

            public LatLng fromScreenLocation(Point point) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.internal.IProjectionDelegate");
                    if (point != null) {
                        obtain.writeInt(1);
                        point.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f49391a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? LatLng.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.internal.IProjectionDelegate";
            }

            public VisibleRegion getVisibleRegion() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.internal.IProjectionDelegate");
                    this.f49391a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? VisibleRegion.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Point toScreenLocation(LatLng latLng) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.internal.IProjectionDelegate");
                    if (latLng != null) {
                        obtain.writeInt(1);
                        latLng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f49391a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Point) Point.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IProjectionDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.internal.IProjectionDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IProjectionDelegate)) ? new Proxy(iBinder) : (IProjectionDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    LatLng fromScreenLocation(Point point);

    VisibleRegion getVisibleRegion();

    Point toScreenLocation(LatLng latLng);
}
