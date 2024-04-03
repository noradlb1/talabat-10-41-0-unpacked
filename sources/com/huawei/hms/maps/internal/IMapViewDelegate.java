package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.maps.internal.IHuaweiMapDelegate;
import com.huawei.hms.maps.model.internal.mab;

public interface IMapViewDelegate extends IInterface {

    public static abstract class Stub extends Binder implements IMapViewDelegate {

        public static class Proxy implements IMapViewDelegate {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49389a;

            public Proxy(IBinder iBinder) {
                this.f49389a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49389a;
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.internal.IMapViewDelegate";
            }

            public IHuaweiMapDelegate getMap() {
                return IHuaweiMapDelegate.Stub.asInterface(mab.j(this.f49389a, "com.huawei.hms.maps.internal.IMapViewDelegate", 1));
            }

            public void getMapAsync(IOnMapReadyCallback iOnMapReadyCallback) {
                mab.a(this.f49389a, "com.huawei.hms.maps.internal.IMapViewDelegate", 13, iOnMapReadyCallback != null ? iOnMapReadyCallback.asBinder() : null);
            }

            public IObjectWrapper getView() {
                return IObjectWrapper.Stub.asInterface(mab.j(this.f49389a, "com.huawei.hms.maps.internal.IMapViewDelegate", 2));
            }

            public void onCreate(Bundle bundle) {
                mab.a(this.f49389a, "com.huawei.hms.maps.internal.IMapViewDelegate", 3, bundle);
            }

            public void onDestroy() {
                mab.i(this.f49389a, "com.huawei.hms.maps.internal.IMapViewDelegate", 4);
            }

            public void onEnterAmbient(Bundle bundle) {
                mab.a(this.f49389a, "com.huawei.hms.maps.internal.IMapViewDelegate", 5, bundle);
            }

            public void onExitAmbient() {
                mab.i(this.f49389a, "com.huawei.hms.maps.internal.IMapViewDelegate", 6);
            }

            public void onLowMemory() {
                mab.i(this.f49389a, "com.huawei.hms.maps.internal.IMapViewDelegate", 7);
            }

            public void onPause() {
                mab.i(this.f49389a, "com.huawei.hms.maps.internal.IMapViewDelegate", 8);
            }

            public void onResume() {
                mab.i(this.f49389a, "com.huawei.hms.maps.internal.IMapViewDelegate", 9);
            }

            public void onSaveInstanceState(Bundle bundle) {
                mab.a(this.f49389a, "com.huawei.hms.maps.internal.IMapViewDelegate", 10, bundle);
            }

            public void onStart() {
                mab.i(this.f49389a, "com.huawei.hms.maps.internal.IMapViewDelegate", 11);
            }

            public void onStop() {
                mab.i(this.f49389a, "com.huawei.hms.maps.internal.IMapViewDelegate", 12);
            }

            public void setActivity(IObjectWrapper iObjectWrapper) {
                mab.a(this.f49389a, "com.huawei.hms.maps.internal.IMapViewDelegate", 15, iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
            }

            public void zOrderOnTop(boolean z11) {
                mab.a(z11, this.f49389a, "com.huawei.hms.maps.internal.IMapViewDelegate", 14);
            }
        }

        public static IMapViewDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.internal.IMapViewDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IMapViewDelegate)) ? new Proxy(iBinder) : (IMapViewDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    IHuaweiMapDelegate getMap();

    void getMapAsync(IOnMapReadyCallback iOnMapReadyCallback);

    IObjectWrapper getView();

    void onCreate(Bundle bundle);

    void onDestroy();

    void onEnterAmbient(Bundle bundle);

    void onExitAmbient();

    void onLowMemory();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();

    void setActivity(IObjectWrapper iObjectWrapper);

    void zOrderOnTop(boolean z11);
}
