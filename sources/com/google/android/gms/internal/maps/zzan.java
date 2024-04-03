package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

public final class zzan extends zza implements zzap {
    public zzan(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    public final Tile zzb(int i11, int i12, int i13) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i11);
        zza.writeInt(i12);
        zza.writeInt(i13);
        Parcel zzJ = zzJ(1, zza);
        Tile tile = (Tile) zzc.zza(zzJ, Tile.CREATOR);
        zzJ.recycle();
        return tile;
    }
}
