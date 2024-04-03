package com.google.android.gms.internal.gtm;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zzm implements IInterface {
    private final IBinder zzqx;
    private final String zzqy;

    public zzm(IBinder iBinder, String str) {
        this.zzqx = iBinder;
        this.zzqy = str;
    }

    public IBinder asBinder() {
        return this.zzqx;
    }

    public final Parcel obtainAndWriteInterfaceToken() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzqy);
        return obtain;
    }

    public final Parcel transactAndReadException(int i11, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.zzqx.transact(i11, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e11) {
            throw e11;
        } finally {
            parcel.recycle();
        }
    }

    public final void zza(int i11, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.zzqx.transact(i11, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public final void zzb(int i11, Parcel parcel) throws RemoteException {
        try {
            this.zzqx.transact(1, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
