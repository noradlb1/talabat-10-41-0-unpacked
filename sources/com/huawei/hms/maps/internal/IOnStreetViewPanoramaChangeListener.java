package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.huawei.hms.maps.model.StreetViewPanoramaLocation;

public interface IOnStreetViewPanoramaChangeListener extends IInterface {

    public static abstract class Stub extends Binder implements IOnStreetViewPanoramaChangeListener {
        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.internal.IOnStreetViewPanoramaChangeListener");
        }

        public IBinder asBinder() {
            return this;
        }
    }

    void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation);
}
