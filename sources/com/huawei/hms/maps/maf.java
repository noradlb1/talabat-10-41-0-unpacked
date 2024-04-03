package com.huawei.hms.maps;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface maf extends IInterface {

    public static abstract class maa extends Binder implements maf {

        /* renamed from: com.huawei.hms.maps.maf$maa$maa  reason: collision with other inner class name */
        public static class C0072maa implements maf {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49417a;

            public C0072maa(IBinder iBinder) {
                this.f49417a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49417a;
            }
        }

        public static maf a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.search.api.IPlaceDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof maf)) ? new C0072maa(iBinder) : (maf) queryLocalInterface;
        }
    }
}
