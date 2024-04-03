package com.huawei.hms.maps.internal;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.huawei.hms.maps.model.internal.mab;

public interface IOnLocationChangeListener extends IInterface {

    public static abstract class Stub extends Binder implements IOnLocationChangeListener {

        public static class Proxy implements IOnLocationChangeListener {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49390a;

            public Proxy(IBinder iBinder) {
                this.f49390a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49390a;
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.internal.IOnLocationChangeListener";
            }

            public void onLocationChange(Location location) {
                mab.a(this.f49390a, "com.huawei.hms.maps.internal.IOnLocationChangeListener", 1, location);
            }
        }

        public static IOnLocationChangeListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.internal.IOnLocationChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IOnLocationChangeListener)) ? new Proxy(iBinder) : (IOnLocationChangeListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    void onLocationChange(Location location);
}
