package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.huawei.hms.maps.model.StreetViewPanoramaOrientation;

public interface IOnStreetViewPanoramaClickListener extends IInterface {

    public static abstract class Stub extends Binder implements IOnStreetViewPanoramaClickListener {
        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.internal.IOnStreetViewPanoramaClickListener");
        }

        public IBinder asBinder() {
            return this;
        }
    }

    void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
}
