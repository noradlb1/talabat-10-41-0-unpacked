package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.maps.HuaweiMapOptions;
import com.huawei.hms.maps.StreetViewPanoramaOptions;
import com.huawei.hms.maps.internal.IDistanceCalculatorDelegate;
import com.huawei.hms.maps.internal.IMapAuthToProvider;
import com.huawei.hms.maps.internal.IMapClientIdentity;
import com.huawei.hms.maps.internal.IMapFragmentDelegate;
import com.huawei.hms.maps.internal.IMapViewDelegate;
import com.huawei.hms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.huawei.hms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.huawei.hms.maps.maf;
import com.huawei.hms.maps.model.internal.mab;

public interface ICreator extends IInterface {

    public static abstract class Stub extends Binder implements ICreator {

        public static class Proxy implements ICreator {
            public static ICreator sDefaultImpl;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49383a;

            public Proxy(IBinder iBinder) {
                this.f49383a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49383a;
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.internal.ICreator";
            }

            public void init(IObjectWrapper iObjectWrapper, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.internal.ICreator");
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    obtain.writeInt(i11);
                    this.f49383a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void initAppContext(IObjectWrapper iObjectWrapper) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.internal.ICreator");
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    this.f49383a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IDistanceCalculatorDelegate newDistanceCalculatorDelegate(IObjectWrapper iObjectWrapper) {
                return IDistanceCalculatorDelegate.Stub.asInterface(mab.a(this.f49383a, "com.huawei.hms.maps.internal.ICreator", 6, iObjectWrapper != null ? iObjectWrapper.asBinder() : null));
            }

            public IMapAuthToProvider newMapAuthToProvider(IObjectWrapper iObjectWrapper) {
                return IMapAuthToProvider.Stub.asInterface(mab.a(this.f49383a, "com.huawei.hms.maps.internal.ICreator", 9, iObjectWrapper != null ? iObjectWrapper.asBinder() : null));
            }

            public IMapClientIdentity newMapClientIdentity(IObjectWrapper iObjectWrapper) {
                return IMapClientIdentity.Stub.asInterface(mab.a(this.f49383a, "com.huawei.hms.maps.internal.ICreator", 5, iObjectWrapper != null ? iObjectWrapper.asBinder() : null));
            }

            public IMapFragmentDelegate newMapFragmentDelegate(IObjectWrapper iObjectWrapper, HuaweiMapOptions huaweiMapOptions) {
                return IMapFragmentDelegate.Stub.asInterface(mab.a(this.f49383a, "com.huawei.hms.maps.internal.ICreator", 2, iObjectWrapper != null ? iObjectWrapper.asBinder() : null, (Parcelable) huaweiMapOptions));
            }

            public IMapViewDelegate newMapViewDelegate(IObjectWrapper iObjectWrapper, HuaweiMapOptions huaweiMapOptions) {
                return IMapViewDelegate.Stub.asInterface(mab.a(this.f49383a, "com.huawei.hms.maps.internal.ICreator", 3, iObjectWrapper != null ? iObjectWrapper.asBinder() : null, (Parcelable) huaweiMapOptions));
            }

            public maf newPlaceDelegate(IObjectWrapper iObjectWrapper) {
                return maf.maa.a(mab.a(this.f49383a, "com.huawei.hms.maps.internal.ICreator", 4, iObjectWrapper != null ? iObjectWrapper.asBinder() : null));
            }

            public IStreetViewPanoramaFragmentDelegate newStreetViewPanoramaFragmentDelegate(IObjectWrapper iObjectWrapper) {
                return IStreetViewPanoramaFragmentDelegate.Stub.asInterface(mab.a(this.f49383a, "com.huawei.hms.maps.internal.ICreator", 8, iObjectWrapper != null ? iObjectWrapper.asBinder() : null));
            }

            public IStreetViewPanoramaViewDelegate newStreetViewPanoramaViewDelegate(IObjectWrapper iObjectWrapper, StreetViewPanoramaOptions streetViewPanoramaOptions) {
                return IStreetViewPanoramaViewDelegate.Stub.asInterface(mab.a(this.f49383a, "com.huawei.hms.maps.internal.ICreator", 7, iObjectWrapper != null ? iObjectWrapper.asBinder() : null, (Parcelable) streetViewPanoramaOptions));
            }

            public IMapFragmentDelegate newTextureMapFragmentDelegate(IObjectWrapper iObjectWrapper, HuaweiMapOptions huaweiMapOptions) {
                return IMapFragmentDelegate.Stub.asInterface(mab.a(this.f49383a, "com.huawei.hms.maps.internal.ICreator", 11, iObjectWrapper != null ? iObjectWrapper.asBinder() : null, (Parcelable) huaweiMapOptions));
            }

            public IMapViewDelegate newTextureMapViewDelegate(IObjectWrapper iObjectWrapper, HuaweiMapOptions huaweiMapOptions) {
                return IMapViewDelegate.Stub.asInterface(mab.a(this.f49383a, "com.huawei.hms.maps.internal.ICreator", 12, iObjectWrapper != null ? iObjectWrapper.asBinder() : null, (Parcelable) huaweiMapOptions));
            }

            public IStreetViewPanoramaFragmentDelegate optStreetViewPanoramaFragmentDelegate(IObjectWrapper iObjectWrapper, StreetViewPanoramaOptions streetViewPanoramaOptions) {
                return IStreetViewPanoramaFragmentDelegate.Stub.asInterface(mab.a(this.f49383a, "com.huawei.hms.maps.internal.ICreator", 10, iObjectWrapper != null ? iObjectWrapper.asBinder() : null, (Parcelable) streetViewPanoramaOptions));
            }
        }

        public static ICreator asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.internal.ICreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ICreator)) ? new Proxy(iBinder) : (ICreator) queryLocalInterface;
        }

        public static ICreator getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICreator iCreator) {
            if (Proxy.sDefaultImpl != null || iCreator == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCreator;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    void init(IObjectWrapper iObjectWrapper, int i11);

    void initAppContext(IObjectWrapper iObjectWrapper);

    IDistanceCalculatorDelegate newDistanceCalculatorDelegate(IObjectWrapper iObjectWrapper);

    IMapAuthToProvider newMapAuthToProvider(IObjectWrapper iObjectWrapper);

    IMapClientIdentity newMapClientIdentity(IObjectWrapper iObjectWrapper);

    IMapFragmentDelegate newMapFragmentDelegate(IObjectWrapper iObjectWrapper, HuaweiMapOptions huaweiMapOptions);

    IMapViewDelegate newMapViewDelegate(IObjectWrapper iObjectWrapper, HuaweiMapOptions huaweiMapOptions);

    maf newPlaceDelegate(IObjectWrapper iObjectWrapper);

    IStreetViewPanoramaFragmentDelegate newStreetViewPanoramaFragmentDelegate(IObjectWrapper iObjectWrapper);

    IStreetViewPanoramaViewDelegate newStreetViewPanoramaViewDelegate(IObjectWrapper iObjectWrapper, StreetViewPanoramaOptions streetViewPanoramaOptions);

    IMapFragmentDelegate newTextureMapFragmentDelegate(IObjectWrapper iObjectWrapper, HuaweiMapOptions huaweiMapOptions);

    IMapViewDelegate newTextureMapViewDelegate(IObjectWrapper iObjectWrapper, HuaweiMapOptions huaweiMapOptions);

    IStreetViewPanoramaFragmentDelegate optStreetViewPanoramaFragmentDelegate(IObjectWrapper iObjectWrapper, StreetViewPanoramaOptions streetViewPanoramaOptions);
}
