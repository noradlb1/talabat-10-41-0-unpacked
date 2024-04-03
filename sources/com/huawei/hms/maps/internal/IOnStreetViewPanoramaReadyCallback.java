package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface IOnStreetViewPanoramaReadyCallback extends IInterface {

    public static abstract class Stub extends Binder implements IOnStreetViewPanoramaReadyCallback {
        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.internal.IOnStreetViewPanoramaReadyCallback");
        }

        public IBinder asBinder() {
            return this;
        }
    }

    void onStreetViewPanoramaReadyCallback(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate);
}
