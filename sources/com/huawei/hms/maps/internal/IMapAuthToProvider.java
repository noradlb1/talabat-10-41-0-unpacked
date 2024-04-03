package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.huawei.hms.maps.model.MapAuthInfo;
import com.huawei.hms.maps.model.internal.mab;

public interface IMapAuthToProvider extends IInterface {

    public static abstract class Stub extends Binder implements IMapAuthToProvider {

        public static class Proxy implements IMapAuthToProvider {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49386a;

            public Proxy(IBinder iBinder) {
                this.f49386a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49386a;
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.internal.IMapAuthToProvider";
            }

            public void notifyProvierAuthInfo(MapAuthInfo mapAuthInfo) {
                mab.a(this.f49386a, "com.huawei.hms.maps.internal.IMapAuthToProvider", 1, mapAuthInfo);
            }
        }

        public static IMapAuthToProvider asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.internal.IMapAuthToProvider");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IMapAuthToProvider)) ? new Proxy(iBinder) : (IMapAuthToProvider) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    void notifyProvierAuthInfo(MapAuthInfo mapAuthInfo);
}
