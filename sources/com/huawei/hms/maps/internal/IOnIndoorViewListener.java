package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.maps.model.IndoorBuilding;

public interface IOnIndoorViewListener extends IInterface {

    public static abstract class Stub extends Binder implements IOnIndoorViewListener {
        public static final String DESCRIPTOR = "com.huawei.hms.maps.internal.IOnIndoorViewListener";

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 != 1598968902) {
                if (i11 == 1) {
                    parcel.enforceInterface(DESCRIPTOR);
                    onIndoorFocus(parcel.readInt() != 0 ? IndoorBuilding.CREATOR.createFromParcel(parcel) : null);
                } else if (i11 != 2) {
                    return super.onTransact(i11, parcel, parcel2, i12);
                } else {
                    parcel.enforceInterface(DESCRIPTOR);
                    onIndoorLeave();
                }
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onIndoorFocus(IndoorBuilding indoorBuilding);

    void onIndoorLeave();
}
