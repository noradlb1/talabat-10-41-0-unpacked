package com.google.android.gms.internal.places;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zzc implements IInterface {
    private final IBinder zzc;
    private final String zzd;

    public zzc(IBinder iBinder, String str) {
        this.zzc = iBinder;
        this.zzd = str;
    }

    public IBinder asBinder() {
        return this.zzc;
    }

    public final Parcel zzb() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzd);
        return obtain;
    }

    public final void zzb(int i11, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.zzc.transact(i11, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
