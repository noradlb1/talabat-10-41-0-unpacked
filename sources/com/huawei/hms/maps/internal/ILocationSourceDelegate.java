package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.maps.internal.IOnLocationChangeListener;

public interface ILocationSourceDelegate extends IInterface {

    public static abstract class Stub extends Binder implements ILocationSourceDelegate {
        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.internal.ILocationSourceDelegate");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface("com.huawei.hms.maps.internal.ILocationSourceDelegate");
                activate(IOnLocationChangeListener.Stub.asInterface(parcel.readStrongBinder()));
            } else if (i11 == 2) {
                parcel.enforceInterface("com.huawei.hms.maps.internal.ILocationSourceDelegate");
                deactivate();
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString("com.huawei.hms.maps.internal.ILocationSourceDelegate");
                return true;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void activate(IOnLocationChangeListener iOnLocationChangeListener);

    void deactivate();
}
