package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IOnMyLocationButtonClickListener extends IInterface {

    public static abstract class Stub extends Binder implements IOnMyLocationButtonClickListener {
        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.internal.IOnMyLocationButtonClickListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface("com.huawei.hms.maps.internal.IOnMyLocationButtonClickListener");
                boolean onMyLocationButtonClick = onMyLocationButtonClick();
                parcel2.writeNoException();
                parcel2.writeInt(onMyLocationButtonClick ? 1 : 0);
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString("com.huawei.hms.maps.internal.IOnMyLocationButtonClickListener");
                return true;
            }
        }
    }

    boolean onMyLocationButtonClick();
}
