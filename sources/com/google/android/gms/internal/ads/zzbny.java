package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public final class zzbny extends zzaoj implements zzboa {
    public zzbny(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public final String zzg() throws RemoteException {
        Parcel zzbs = zzbs(2, zza());
        String readString = zzbs.readString();
        zzbs.recycle();
        return readString;
    }

    public final List<zzboi> zzh() throws RemoteException {
        Parcel zzbs = zzbs(3, zza());
        ArrayList zzb = zzaol.zzb(zzbs);
        zzbs.recycle();
        return zzb;
    }
}
