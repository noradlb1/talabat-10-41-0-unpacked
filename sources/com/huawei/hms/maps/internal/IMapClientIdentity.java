package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.huawei.hms.maps.model.internal.mab;
import com.huawei.hms.maps.model.maa;

public interface IMapClientIdentity extends IInterface {

    public static abstract class Stub extends Binder implements IMapClientIdentity {

        public static class Proxy implements IMapClientIdentity {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49387a;

            public Proxy(IBinder iBinder) {
                this.f49387a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49387a;
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.internal.IMapClientIdentity";
            }

            public void regestToProvierIdentity(maa maa) {
                mab.a(this.f49387a, "com.huawei.hms.maps.internal.IMapClientIdentity", 1, maa);
            }
        }

        public static IMapClientIdentity asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.internal.IMapClientIdentity");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IMapClientIdentity)) ? new Proxy(iBinder) : (IMapClientIdentity) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    void regestToProvierIdentity(maa maa);
}
