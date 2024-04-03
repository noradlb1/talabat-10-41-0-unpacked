package com.huawei.hms.analytics;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface lmn extends IInterface {

    /* renamed from: com.huawei.hms.analytics.lmn$lmn  reason: collision with other inner class name */
    public static abstract class C0063lmn extends Binder implements lmn {

        /* renamed from: com.huawei.hms.analytics.lmn$lmn$lmn  reason: collision with other inner class name */
        public static class C0064lmn implements lmn {
            public static lmn lmn;
            private IBinder klm;

            public C0064lmn(IBinder iBinder) {
                this.klm = iBinder;
            }

            public final IBinder asBinder() {
                return this.klm;
            }

            public final String lmn() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.android.hms.ppskit.IPPSChannelInfoService");
                    if (!this.klm.transact(1, obtain, obtain2, 0) && C0063lmn.klm() != null) {
                        return C0063lmn.klm().lmn();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static lmn klm() {
            return C0064lmn.lmn;
        }

        public static lmn lmn(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.android.hms.ppskit.IPPSChannelInfoService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof lmn)) ? new C0064lmn(iBinder) : (lmn) queryLocalInterface;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1598968902) {
                parcel2.writeString("com.huawei.android.hms.ppskit.IPPSChannelInfoService");
                return true;
            } else if (i11 != 1) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel.enforceInterface("com.huawei.android.hms.ppskit.IPPSChannelInfoService");
                String lmn = lmn();
                parcel2.writeNoException();
                parcel2.writeString(lmn);
                return true;
            }
        }
    }

    String lmn();
}
