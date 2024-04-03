package com.huawei.hms.analytics;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.analytics.core.log.HiLog;

public final class ai implements IInterface, m {
    private final IBinder ikl;
    private final String klm;
    private final int lmn = 1;

    public ai(String str, IBinder iBinder) {
        this.klm = str;
        this.ikl = iBinder;
    }

    public final IBinder asBinder() {
        return this.ikl;
    }

    public final boolean klm() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.klm);
            boolean z11 = false;
            this.ikl.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z11 = true;
            }
            return z11;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    /* JADX INFO: finally extract failed */
    public final String lmn(String... strArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.klm);
            for (String writeString : strArr) {
                obtain.writeString(writeString);
            }
            this.ikl.transact(this.lmn, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            obtain2.recycle();
            obtain.recycle();
            return readString;
        } catch (Exception unused) {
            HiLog.w("OaidService", "getId, Exception");
            obtain2.recycle();
            obtain.recycle();
            return null;
        } catch (Throwable th2) {
            obtain2.recycle();
            obtain.recycle();
            throw th2;
        }
    }

    public final boolean lmn() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        boolean z11 = false;
        try {
            obtain.writeInterfaceToken(this.klm);
            obtain.writeInt(1);
            this.ikl.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z11 = true;
            }
        } catch (Exception unused) {
            HiLog.w("OaidService", "isOaidTrackLimited, Exception");
        } catch (Throwable th2) {
            obtain2.recycle();
            obtain.recycle();
            throw th2;
        }
        obtain2.recycle();
        obtain.recycle();
        return z11;
    }
}
