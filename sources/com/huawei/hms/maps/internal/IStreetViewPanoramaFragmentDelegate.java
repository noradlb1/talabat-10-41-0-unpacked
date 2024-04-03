package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.maps.StreetViewPanoramaOptions;
import com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate;
import com.huawei.hms.maps.model.internal.mab;

public interface IStreetViewPanoramaFragmentDelegate extends IInterface {

    public static abstract class Stub extends Binder implements IStreetViewPanoramaFragmentDelegate {

        public static class Proxy implements IStreetViewPanoramaFragmentDelegate {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49393a;

            public Proxy(IBinder iBinder) {
                this.f49393a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49393a;
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.internal.IStreetViewPanoramaFragmentDelegate";
            }

            public IStreetViewPanoramaDelegate getStreetViewPanorama() {
                return IStreetViewPanoramaDelegate.Stub.asInterface(mab.j(this.f49393a, "com.huawei.hms.maps.internal.IStreetViewPanoramaFragmentDelegate", 1));
            }

            public void getStreetViewPanoramaAsync(IOnStreetViewPanoramaReadyCallback iOnStreetViewPanoramaReadyCallback) {
                mab.a(this.f49393a, "com.huawei.hms.maps.internal.IStreetViewPanoramaFragmentDelegate", 2, iOnStreetViewPanoramaReadyCallback != null ? iOnStreetViewPanoramaReadyCallback.asBinder() : null);
            }

            public boolean isReady() {
                return mab.a(this.f49393a, "com.huawei.hms.maps.internal.IStreetViewPanoramaFragmentDelegate", 3);
            }

            public void onCreate(Bundle bundle) {
                mab.a(this.f49393a, "com.huawei.hms.maps.internal.IStreetViewPanoramaFragmentDelegate", 4, bundle);
            }

            public IObjectWrapper onCreateView(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.internal.IStreetViewPanoramaFragmentDelegate");
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (iObjectWrapper2 != null) {
                        iBinder = iObjectWrapper2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f49393a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDestroy() {
                mab.i(this.f49393a, "com.huawei.hms.maps.internal.IStreetViewPanoramaFragmentDelegate", 6);
            }

            public void onDestroyView() {
                mab.i(this.f49393a, "com.huawei.hms.maps.internal.IStreetViewPanoramaFragmentDelegate", 7);
            }

            public void onInflate(IObjectWrapper iObjectWrapper, StreetViewPanoramaOptions streetViewPanoramaOptions, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.internal.IStreetViewPanoramaFragmentDelegate");
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (streetViewPanoramaOptions != null) {
                        obtain.writeInt(1);
                        streetViewPanoramaOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f49393a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onLowMemory() {
                mab.i(this.f49393a, "com.huawei.hms.maps.internal.IStreetViewPanoramaFragmentDelegate", 9);
            }

            public void onPause() {
                mab.i(this.f49393a, "com.huawei.hms.maps.internal.IStreetViewPanoramaFragmentDelegate", 10);
            }

            public void onResume() {
                mab.i(this.f49393a, "com.huawei.hms.maps.internal.IStreetViewPanoramaFragmentDelegate", 11);
            }

            public void onSaveInstanceState(Bundle bundle) {
                mab.a(this.f49393a, "com.huawei.hms.maps.internal.IStreetViewPanoramaFragmentDelegate", 12, bundle);
            }

            public void onStart() {
                mab.i(this.f49393a, "com.huawei.hms.maps.internal.IStreetViewPanoramaFragmentDelegate", 13);
            }

            public void onStop() {
                mab.i(this.f49393a, "com.huawei.hms.maps.internal.IStreetViewPanoramaFragmentDelegate", 14);
            }
        }

        public static IStreetViewPanoramaFragmentDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.internal.IStreetViewPanoramaFragmentDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IStreetViewPanoramaFragmentDelegate)) ? new Proxy(iBinder) : (IStreetViewPanoramaFragmentDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    IStreetViewPanoramaDelegate getStreetViewPanorama();

    void getStreetViewPanoramaAsync(IOnStreetViewPanoramaReadyCallback iOnStreetViewPanoramaReadyCallback);

    boolean isReady();

    void onCreate(Bundle bundle);

    IObjectWrapper onCreateView(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, Bundle bundle);

    void onDestroy();

    void onDestroyView();

    void onInflate(IObjectWrapper iObjectWrapper, StreetViewPanoramaOptions streetViewPanoramaOptions, Bundle bundle);

    void onLowMemory();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();
}
