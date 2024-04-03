package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.maps.HuaweiMapOptions;
import com.huawei.hms.maps.internal.IHuaweiMapDelegate;
import com.huawei.hms.maps.model.internal.mab;

public interface IMapFragmentDelegate extends IInterface {

    public static abstract class Stub extends Binder implements IMapFragmentDelegate {

        public static class Proxy implements IMapFragmentDelegate {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49388a;

            public Proxy(IBinder iBinder) {
                this.f49388a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49388a;
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.internal.IMapFragmentDelegate";
            }

            public IHuaweiMapDelegate getMap() {
                return IHuaweiMapDelegate.Stub.asInterface(mab.j(this.f49388a, "com.huawei.hms.maps.internal.IMapFragmentDelegate", 1));
            }

            public void getMapAsync(IOnMapReadyCallback iOnMapReadyCallback) {
                mab.a(this.f49388a, "com.huawei.hms.maps.internal.IMapFragmentDelegate", 11, iOnMapReadyCallback != null ? iOnMapReadyCallback.asBinder() : null);
            }

            public boolean isReady() {
                return mab.a(this.f49388a, "com.huawei.hms.maps.internal.IMapFragmentDelegate", 13);
            }

            public void onAttach(IObjectWrapper iObjectWrapper) {
                mab.a(this.f49388a, "com.huawei.hms.maps.internal.IMapFragmentDelegate", 7, iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
            }

            public void onCreate(Bundle bundle) {
                mab.a(this.f49388a, "com.huawei.hms.maps.internal.IMapFragmentDelegate", 3, new Parcelable[0]);
            }

            public IObjectWrapper onCreateView(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.internal.IMapFragmentDelegate");
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
                    this.f49388a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDestroy() {
                mab.i(this.f49388a, "com.huawei.hms.maps.internal.IMapFragmentDelegate", 9);
            }

            public void onDestroyView() {
                mab.i(this.f49388a, "com.huawei.hms.maps.internal.IMapFragmentDelegate", 8);
            }

            public void onEnterAmbient(Bundle bundle) {
                mab.a(this.f49388a, "com.huawei.hms.maps.internal.IMapFragmentDelegate", 14, bundle);
            }

            public void onExitAmbient() {
                mab.i(this.f49388a, "com.huawei.hms.maps.internal.IMapFragmentDelegate", 15);
            }

            public void onInflate(IObjectWrapper iObjectWrapper, HuaweiMapOptions huaweiMapOptions, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.internal.IMapFragmentDelegate");
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (huaweiMapOptions != null) {
                        obtain.writeInt(1);
                        huaweiMapOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f49388a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onLowMemory() {
                mab.i(this.f49388a, "com.huawei.hms.maps.internal.IMapFragmentDelegate", 10);
            }

            public void onPause() {
                mab.i(this.f49388a, "com.huawei.hms.maps.internal.IMapFragmentDelegate", 6);
            }

            public void onResume() {
                mab.i(this.f49388a, "com.huawei.hms.maps.internal.IMapFragmentDelegate", 5);
            }

            public void onSaveInstanceState(Bundle bundle) {
                mab.a(this.f49388a, "com.huawei.hms.maps.internal.IMapFragmentDelegate", 12, bundle);
            }

            public void onStart() {
                mab.i(this.f49388a, "com.huawei.hms.maps.internal.IMapFragmentDelegate", 16);
            }

            public void onStop() {
                mab.i(this.f49388a, "com.huawei.hms.maps.internal.IMapFragmentDelegate", 17);
            }

            public void zOrderOnTop(boolean z11) {
                mab.a(z11, this.f49388a, "com.huawei.hms.maps.internal.IMapFragmentDelegate", 18);
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.internal.IMapFragmentDelegate");
        }

        public static IMapFragmentDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.internal.IMapFragmentDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IMapFragmentDelegate)) ? new Proxy(iBinder) : (IMapFragmentDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    IHuaweiMapDelegate getMap();

    void getMapAsync(IOnMapReadyCallback iOnMapReadyCallback);

    boolean isReady();

    void onAttach(IObjectWrapper iObjectWrapper);

    void onCreate(Bundle bundle);

    IObjectWrapper onCreateView(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, Bundle bundle);

    void onDestroy();

    void onDestroyView();

    void onEnterAmbient(Bundle bundle);

    void onExitAmbient();

    void onInflate(IObjectWrapper iObjectWrapper, HuaweiMapOptions huaweiMapOptions, Bundle bundle);

    void onLowMemory();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();

    void zOrderOnTop(boolean z11);
}
