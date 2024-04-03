package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.maps.model.internal.IMarkerDelegate;

public interface IOnInfoWindowCloseListener extends IInterface {

    public static abstract class Stub extends Binder implements IOnInfoWindowCloseListener {
        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.internal.IOnInfoWindowCloseListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface("com.huawei.hms.maps.internal.IOnInfoWindowCloseListener");
                onInfoWindowClose(IMarkerDelegate.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString("com.huawei.hms.maps.internal.IOnInfoWindowCloseListener");
                return true;
            }
        }
    }

    void onInfoWindowClose(IMarkerDelegate iMarkerDelegate);
}
