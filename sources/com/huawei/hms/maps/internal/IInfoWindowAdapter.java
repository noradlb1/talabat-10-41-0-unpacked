package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.maps.model.internal.IMarkerDelegate;

public interface IInfoWindowAdapter extends IInterface {

    public static abstract class Stub extends Binder implements IInfoWindowAdapter {
        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.internal.IInfoWindowAdapter");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            IBinder iBinder = null;
            if (i11 == 1) {
                parcel.enforceInterface("com.huawei.hms.maps.internal.IInfoWindowAdapter");
                IObjectWrapper infoWindow = getInfoWindow(IMarkerDelegate.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (infoWindow != null) {
                    iBinder = infoWindow.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            } else if (i11 == 2) {
                parcel.enforceInterface("com.huawei.hms.maps.internal.IInfoWindowAdapter");
                IObjectWrapper infoContents = getInfoContents(IMarkerDelegate.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (infoContents != null) {
                    iBinder = infoContents.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString("com.huawei.hms.maps.internal.IInfoWindowAdapter");
                return true;
            }
        }
    }

    IObjectWrapper getInfoContents(IMarkerDelegate iMarkerDelegate);

    IObjectWrapper getInfoWindow(IMarkerDelegate iMarkerDelegate);
}
