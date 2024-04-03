package com.huawei.hms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

public interface IIndoorBuildingDelegate extends IInterface {

    public static abstract class Stub extends Binder implements IIndoorBuildingDelegate {

        public static class Proxy implements IIndoorBuildingDelegate {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49594a;

            public Proxy(IBinder iBinder) {
                this.f49594a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49594a;
            }

            public boolean equalsRemote(IIndoorBuildingDelegate iIndoorBuildingDelegate) {
                return mab.a((IInterface) iIndoorBuildingDelegate, this.f49594a, "com.huawei.hms.maps.model.internal.IIndoorBuildingDelegate", 5);
            }

            public int getActiveLevelIndex() {
                return mab.b(this.f49594a, "com.huawei.hms.maps.model.internal.IIndoorBuildingDelegate", 1);
            }

            public int getDefaultLevelIndex() {
                return mab.b(this.f49594a, "com.huawei.hms.maps.model.internal.IIndoorBuildingDelegate", 2);
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.model.internal.IIndoorBuildingDelegate";
            }

            public List<IBinder> getLevels() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.model.internal.IIndoorBuildingDelegate");
                    this.f49594a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createBinderArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int hashCodeRemote() {
                return mab.b(this.f49594a, "com.huawei.hms.maps.model.internal.IIndoorBuildingDelegate", 6);
            }

            public boolean isUnderground() {
                return mab.a(this.f49594a, "com.huawei.hms.maps.model.internal.IIndoorBuildingDelegate", 4);
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.model.internal.IIndoorBuildingDelegate");
        }

        public static IIndoorBuildingDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.model.internal.IIndoorBuildingDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IIndoorBuildingDelegate)) ? new Proxy(iBinder) : (IIndoorBuildingDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    boolean equalsRemote(IIndoorBuildingDelegate iIndoorBuildingDelegate);

    int getActiveLevelIndex();

    int getDefaultLevelIndex();

    List<IBinder> getLevels();

    int hashCodeRemote();

    boolean isUnderground();
}
