package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate;
import com.huawei.hms.maps.model.internal.mab;

public interface IStreetViewPanoramaViewDelegate extends IInterface {

    public static abstract class Stub extends Binder implements IStreetViewPanoramaViewDelegate {

        public static class Proxy implements IStreetViewPanoramaViewDelegate {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49394a;

            public Proxy(IBinder iBinder) {
                this.f49394a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49394a;
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.internal.IStreetViewPanoramaViewDelegate";
            }

            public IStreetViewPanoramaDelegate getStreetViewPanorama() {
                return IStreetViewPanoramaDelegate.Stub.asInterface(mab.j(this.f49394a, "com.huawei.hms.maps.internal.IStreetViewPanoramaViewDelegate", 1));
            }

            public void getStreetViewPanoramaAsync(IOnStreetViewPanoramaReadyCallback iOnStreetViewPanoramaReadyCallback) {
                mab.a(this.f49394a, "com.huawei.hms.maps.internal.IStreetViewPanoramaViewDelegate", 2, iOnStreetViewPanoramaReadyCallback != null ? iOnStreetViewPanoramaReadyCallback.asBinder() : null);
            }

            public IObjectWrapper getView() {
                return IObjectWrapper.Stub.asInterface(mab.j(this.f49394a, "com.huawei.hms.maps.internal.IStreetViewPanoramaViewDelegate", 3));
            }

            public void onCreate(Bundle bundle) {
                mab.a(this.f49394a, "com.huawei.hms.maps.internal.IStreetViewPanoramaViewDelegate", 4, bundle);
            }

            public void onDestroy() {
                mab.i(this.f49394a, "com.huawei.hms.maps.internal.IStreetViewPanoramaViewDelegate", 5);
            }

            public void onLowMemory() {
                mab.i(this.f49394a, "com.huawei.hms.maps.internal.IStreetViewPanoramaViewDelegate", 6);
            }

            public void onPause() {
                mab.i(this.f49394a, "com.huawei.hms.maps.internal.IStreetViewPanoramaViewDelegate", 7);
            }

            public void onResume() {
                mab.i(this.f49394a, "com.huawei.hms.maps.internal.IStreetViewPanoramaViewDelegate", 8);
            }

            public void onSaveInstanceState(Bundle bundle) {
                mab.a(this.f49394a, "com.huawei.hms.maps.internal.IStreetViewPanoramaViewDelegate", 9, bundle);
            }

            public void onStart() {
                mab.i(this.f49394a, "com.huawei.hms.maps.internal.IStreetViewPanoramaViewDelegate", 10);
            }

            public void onStop() {
                mab.i(this.f49394a, "com.huawei.hms.maps.internal.IStreetViewPanoramaViewDelegate", 11);
            }
        }

        public static IStreetViewPanoramaViewDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.internal.IStreetViewPanoramaViewDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IStreetViewPanoramaViewDelegate)) ? new Proxy(iBinder) : (IStreetViewPanoramaViewDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    IStreetViewPanoramaDelegate getStreetViewPanorama();

    void getStreetViewPanoramaAsync(IOnStreetViewPanoramaReadyCallback iOnStreetViewPanoramaReadyCallback);

    IObjectWrapper getView();

    void onCreate(Bundle bundle);

    void onDestroy();

    void onLowMemory();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();
}
