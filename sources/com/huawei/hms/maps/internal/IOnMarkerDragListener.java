package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.maps.model.internal.IMarkerDelegate;

public interface IOnMarkerDragListener extends IInterface {

    public static abstract class Stub extends Binder implements IOnMarkerDragListener {
        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.internal.IOnMarkerDragListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface("com.huawei.hms.maps.internal.IOnMarkerDragListener");
                onMarkerDragStart(IMarkerDelegate.Stub.asInterface(parcel.readStrongBinder()));
            } else if (i11 == 2) {
                parcel.enforceInterface("com.huawei.hms.maps.internal.IOnMarkerDragListener");
                onMarkerDrag(IMarkerDelegate.Stub.asInterface(parcel.readStrongBinder()));
            } else if (i11 == 3) {
                parcel.enforceInterface("com.huawei.hms.maps.internal.IOnMarkerDragListener");
                onMarkerDragEnd(IMarkerDelegate.Stub.asInterface(parcel.readStrongBinder()));
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString("com.huawei.hms.maps.internal.IOnMarkerDragListener");
                return true;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onMarkerDrag(IMarkerDelegate iMarkerDelegate);

    void onMarkerDragEnd(IMarkerDelegate iMarkerDelegate);

    void onMarkerDragStart(IMarkerDelegate iMarkerDelegate);
}
