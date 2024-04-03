package com.huawei.hms.dtm.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.huawei.hms.dtm.core.a  reason: case insensitive filesystem */
public interface C0342a extends IInterface {

    /* renamed from: com.huawei.hms.dtm.core.a$a  reason: collision with other inner class name */
    public static abstract class C0065a extends Binder implements C0342a {

        /* renamed from: com.huawei.hms.dtm.core.a$a$a  reason: collision with other inner class name */
        public static class C0066a implements C0342a {

            /* renamed from: a  reason: collision with root package name */
            public static C0342a f48448a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f48449b;

            public C0066a(IBinder iBinder) {
                this.f48449b = iBinder;
            }

            public String a() throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.android.hms.ppskit.IPPSChannelInfoService");
                    if (this.f48449b.transact(1, obtain, obtain2, 0) || C0065a.b() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = C0065a.b().a();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f48449b;
            }
        }

        public static C0342a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.android.hms.ppskit.IPPSChannelInfoService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0342a)) ? new C0066a(iBinder) : (C0342a) queryLocalInterface;
        }

        public static C0342a b() {
            return C0066a.f48448a;
        }
    }

    String a() throws RemoteException;
}
