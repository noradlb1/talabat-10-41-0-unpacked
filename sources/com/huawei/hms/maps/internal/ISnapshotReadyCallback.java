package com.huawei.hms.maps.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.feature.dynamic.IObjectWrapper;

public interface ISnapshotReadyCallback extends IInterface {

    public static abstract class Stub extends Binder implements ISnapshotReadyCallback {
        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.internal.ISnapshotReadyCallback");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface("com.huawei.hms.maps.internal.ISnapshotReadyCallback");
                onSnapshotReady(parcel.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(parcel) : null);
            } else if (i11 == 2) {
                parcel.enforceInterface("com.huawei.hms.maps.internal.ISnapshotReadyCallback");
                onSnapshotReadyWrapper(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString("com.huawei.hms.maps.internal.ISnapshotReadyCallback");
                return true;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onSnapshotReady(Bitmap bitmap);

    void onSnapshotReadyWrapper(IObjectWrapper iObjectWrapper);
}
