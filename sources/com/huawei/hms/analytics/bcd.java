package com.huawei.hms.analytics;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

public interface bcd extends IInterface {

    public static abstract class lmn extends Binder implements bcd {

        /* renamed from: com.huawei.hms.analytics.bcd$lmn$lmn  reason: collision with other inner class name */
        public static class C0061lmn implements bcd {
            public static bcd lmn;
            private IBinder klm;

            public C0061lmn(IBinder iBinder) {
                this.klm = iBinder;
            }

            public final IBinder asBinder() {
                return this.klm;
            }

            public final int lmn(List<CustomEvent> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.analytics.IHiAnalyticsCallback");
                    obtain.writeTypedList(list);
                    if (!this.klm.transact(1, obtain, obtain2, 0) && lmn.lmn() != null) {
                        return lmn.lmn().lmn(list);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public lmn() {
            attachInterface(this, "com.huawei.hms.analytics.IHiAnalyticsCallback");
        }

        public static bcd lmn() {
            return C0061lmn.lmn;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1598968902) {
                parcel2.writeString("com.huawei.hms.analytics.IHiAnalyticsCallback");
                return true;
            } else if (i11 != 1) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel.enforceInterface("com.huawei.hms.analytics.IHiAnalyticsCallback");
                int lmn = lmn(parcel.createTypedArrayList(CustomEvent.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(lmn);
                return true;
            }
        }
    }

    int lmn(List<CustomEvent> list);
}
