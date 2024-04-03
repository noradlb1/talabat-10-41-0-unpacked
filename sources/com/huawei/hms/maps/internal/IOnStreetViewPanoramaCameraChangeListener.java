package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.huawei.hms.maps.model.StreetViewPanoramaCamera;

public interface IOnStreetViewPanoramaCameraChangeListener extends IInterface {

    public static abstract class Stub extends Binder implements IOnStreetViewPanoramaCameraChangeListener {
        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
        }

        public IBinder asBinder() {
            return this;
        }
    }

    void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera);
}
