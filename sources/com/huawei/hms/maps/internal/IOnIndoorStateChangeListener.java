package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.maps.model.internal.IIndoorBuildingDelegate;

public interface IOnIndoorStateChangeListener extends IInterface {

    public static abstract class Stub extends Binder implements IOnIndoorStateChangeListener {
        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.internal.IOnIndoorStateChangeListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface("com.huawei.hms.maps.internal.IOnIndoorStateChangeListener");
                onIndoorBuildingFocused();
            } else if (i11 == 2) {
                parcel.enforceInterface("com.huawei.hms.maps.internal.IOnIndoorStateChangeListener");
                onIndoorLevelActivated(IIndoorBuildingDelegate.Stub.asInterface(parcel.readStrongBinder()));
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString("com.huawei.hms.maps.internal.IOnIndoorStateChangeListener");
                return true;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onIndoorBuildingFocused();

    void onIndoorLevelActivated(IIndoorBuildingDelegate iIndoorBuildingDelegate);
}
