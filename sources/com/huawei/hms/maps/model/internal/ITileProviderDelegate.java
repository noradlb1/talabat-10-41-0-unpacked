package com.huawei.hms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.maps.model.Tile;

public interface ITileProviderDelegate extends IInterface {

    public static abstract class Stub extends Binder implements ITileProviderDelegate {

        public static class Proxy implements ITileProviderDelegate {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49600a;

            public Proxy(IBinder iBinder) {
                this.f49600a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49600a;
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.model.internal.ITileProviderDelegate";
            }

            public Tile getTile(int i11, int i12, int i13) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.model.internal.ITileProviderDelegate");
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    obtain.writeInt(i13);
                    this.f49600a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Tile.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.model.internal.ITileProviderDelegate");
        }

        public static ITileProviderDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.model.internal.ITileProviderDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITileProviderDelegate)) ? new Proxy(iBinder) : (ITileProviderDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface("com.huawei.hms.maps.model.internal.ITileProviderDelegate");
                Tile tile = getTile(parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                if (tile != null) {
                    parcel2.writeInt(1);
                    tile.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString("com.huawei.hms.maps.model.internal.ITileProviderDelegate");
                return true;
            }
        }
    }

    Tile getTile(int i11, int i12, int i13);
}
