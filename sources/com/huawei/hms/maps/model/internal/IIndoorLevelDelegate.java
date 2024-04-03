package com.huawei.hms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface IIndoorLevelDelegate extends IInterface {

    public static abstract class Stub extends Binder implements IIndoorLevelDelegate {

        public static class Proxy implements IIndoorLevelDelegate {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49595a;

            public Proxy(IBinder iBinder) {
                this.f49595a = iBinder;
            }

            public void activate() {
                mab.i(this.f49595a, "com.huawei.hms.maps.model.internal.IIndoorLevelDelegate", 1);
            }

            public IBinder asBinder() {
                return this.f49595a;
            }

            public boolean equalsRemote(IIndoorLevelDelegate iIndoorLevelDelegate) {
                return mab.a((IInterface) iIndoorLevelDelegate, this.f49595a, "com.huawei.hms.maps.model.internal.IIndoorLevelDelegate", 4);
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.model.internal.IIndoorLevelDelegate";
            }

            public String getName() {
                return mab.d(this.f49595a, "com.huawei.hms.maps.model.internal.IIndoorLevelDelegate", 2);
            }

            public String getShortName() {
                return mab.d(this.f49595a, "com.huawei.hms.maps.model.internal.IIndoorLevelDelegate", 3);
            }

            public int hashCodeRemote() {
                return mab.b(this.f49595a, "com.huawei.hms.maps.model.internal.IIndoorLevelDelegate", 5);
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.model.internal.IIndoorLevelDelegate");
        }

        public static IIndoorLevelDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.model.internal.IIndoorLevelDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IIndoorLevelDelegate)) ? new Proxy(iBinder) : (IIndoorLevelDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    void activate();

    boolean equalsRemote(IIndoorLevelDelegate iIndoorLevelDelegate);

    String getName();

    String getShortName();

    int hashCodeRemote();
}
