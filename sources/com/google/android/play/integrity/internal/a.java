package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f44571a;

    /* renamed from: b  reason: collision with root package name */
    private final String f44572b = "com.google.android.play.core.integrity.protocol.IIntegrityService";

    public a(IBinder iBinder, String str) {
        this.f44571a = iBinder;
    }

    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f44572b);
        return obtain;
    }

    public final IBinder asBinder() {
        return this.f44571a;
    }

    public final void b(int i11, Parcel parcel) throws RemoteException {
        try {
            this.f44571a.transact(2, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
