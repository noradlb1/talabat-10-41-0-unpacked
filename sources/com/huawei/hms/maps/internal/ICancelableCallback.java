package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface ICancelableCallback extends IInterface {

    public static abstract class Stub extends Binder implements ICancelableCallback {
        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.internal.ICancelableCallback");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface("com.huawei.hms.maps.internal.ICancelableCallback");
                onFinish();
            } else if (i11 == 2) {
                parcel.enforceInterface("com.huawei.hms.maps.internal.ICancelableCallback");
                onCancel();
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString("com.huawei.hms.maps.internal.ICancelableCallback");
                return true;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onCancel();

    void onFinish();
}
