package com.huawei.hms.analytics;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.analytics.bcd;

public interface abc extends IInterface {

    public static abstract class lmn extends Binder implements abc {

        /* renamed from: com.huawei.hms.analytics.abc$lmn$lmn  reason: collision with other inner class name */
        public static class C0060lmn implements abc {
            public static abc lmn;
            private IBinder klm;

            public C0060lmn(IBinder iBinder) {
                this.klm = iBinder;
            }

            public final IBinder asBinder() {
                return this.klm;
            }

            public final String lmn() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.analytics.IHiAnalyticsService");
                    if (!this.klm.transact(2, obtain, obtain2, 0) && lmn.klm() != null) {
                        return lmn.klm().lmn();
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

            public final void lmn(bcd bcd, UploadInfo uploadInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.analytics.IHiAnalyticsService");
                    obtain.writeStrongBinder(bcd != null ? bcd.asBinder() : null);
                    if (uploadInfo != null) {
                        obtain.writeInt(1);
                        uploadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.klm.transact(1, obtain, obtain2, 0) || lmn.klm() == null) {
                        obtain2.readException();
                    } else {
                        lmn.klm().lmn(bcd, uploadInfo);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static abc klm() {
            return C0060lmn.lmn;
        }

        public static abc lmn(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.analytics.IHiAnalyticsService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof abc)) ? new C0060lmn(iBinder) : (abc) queryLocalInterface;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            bcd bcd;
            if (i11 == 1598968902) {
                parcel2.writeString("com.huawei.hms.analytics.IHiAnalyticsService");
                return true;
            } else if (i11 == 1) {
                parcel.enforceInterface("com.huawei.hms.analytics.IHiAnalyticsService");
                IBinder readStrongBinder = parcel.readStrongBinder();
                UploadInfo uploadInfo = null;
                if (readStrongBinder == null) {
                    bcd = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.huawei.hms.analytics.IHiAnalyticsCallback");
                    bcd = (queryLocalInterface == null || !(queryLocalInterface instanceof bcd)) ? new bcd.lmn.C0061lmn(readStrongBinder) : (bcd) queryLocalInterface;
                }
                if (parcel.readInt() != 0) {
                    uploadInfo = UploadInfo.CREATOR.createFromParcel(parcel);
                }
                lmn(bcd, uploadInfo);
                parcel2.writeNoException();
                return true;
            } else if (i11 != 2) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel.enforceInterface("com.huawei.hms.analytics.IHiAnalyticsService");
                String lmn = lmn();
                parcel2.writeNoException();
                parcel2.writeString(lmn);
                return true;
            }
        }
    }

    String lmn();

    void lmn(bcd bcd, UploadInfo uploadInfo);
}
