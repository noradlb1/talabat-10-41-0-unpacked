package com.google.android.gms.flags;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.flags.zza;
import com.google.android.gms.internal.flags.zzc;

public final class zze extends zza implements zzc {
    public zze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.flags.IFlagProvider");
    }

    public final boolean getBooleanFlagValue(String str, boolean z11, int i11) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.writeBoolean(zza, z11);
        zza.writeInt(i11);
        Parcel zza2 = zza(2, zza);
        boolean zza3 = zzc.zza(zza2);
        zza2.recycle();
        return zza3;
    }

    public final int getIntFlagValue(String str, int i11, int i12) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i11);
        zza.writeInt(i12);
        Parcel zza2 = zza(3, zza);
        int readInt = zza2.readInt();
        zza2.recycle();
        return readInt;
    }

    public final long getLongFlagValue(String str, long j11, int i11) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j11);
        zza.writeInt(i11);
        Parcel zza2 = zza(4, zza);
        long readLong = zza2.readLong();
        zza2.recycle();
        return readLong;
    }

    public final String getStringFlagValue(String str, String str2, int i11) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeInt(i11);
        Parcel zza2 = zza(5, zza);
        String readString = zza2.readString();
        zza2.recycle();
        return readString;
    }

    public final void init(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, iObjectWrapper);
        zzb(1, zza);
    }
}
