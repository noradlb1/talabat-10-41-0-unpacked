package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbgw extends zzaok implements zzbgx {
    public zzbgw() {
        super("com.google.android.gms.ads.internal.client.IAdListener");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        switch (i11) {
            case 1:
                zzd();
                break;
            case 2:
                zze(parcel.readInt());
                break;
            case 3:
                break;
            case 4:
                zzi();
                break;
            case 5:
                zzj();
                break;
            case 6:
                zzc();
                break;
            case 7:
                zzg();
                break;
            case 8:
                zzf((zzbew) zzaol.zza(parcel, zzbew.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
