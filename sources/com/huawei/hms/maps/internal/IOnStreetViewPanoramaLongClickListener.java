package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.huawei.hms.maps.model.StreetViewPanoramaOrientation;

public interface IOnStreetViewPanoramaLongClickListener extends IInterface {

    public static abstract class Stub extends Binder implements IOnStreetViewPanoramaLongClickListener {
        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.internal.IOnStreetViewPanoramaLongClickListener");
        }

        public IBinder asBinder() {
            return this;
        }
    }

    void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
}
