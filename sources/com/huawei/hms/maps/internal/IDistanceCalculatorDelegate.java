package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.internal.mab;

public interface IDistanceCalculatorDelegate extends IInterface {

    public static abstract class Stub extends Binder implements IDistanceCalculatorDelegate {

        public static class Proxy implements IDistanceCalculatorDelegate {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49384a;

            public Proxy(IBinder iBinder) {
                this.f49384a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49384a;
            }

            public double computeDistanceBetween(LatLng latLng, LatLng latLng2) {
                return mab.a(this.f49384a, "com.huawei.hms.maps.internal.IDistanceCalculatorDelegate", 1, 2, latLng, latLng2).doubleValue();
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.internal.IDistanceCalculatorDelegate";
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.internal.IDistanceCalculatorDelegate");
        }

        public static IDistanceCalculatorDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.internal.IDistanceCalculatorDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDistanceCalculatorDelegate)) ? new Proxy(iBinder) : (IDistanceCalculatorDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    double computeDistanceBetween(LatLng latLng, LatLng latLng2);
}
