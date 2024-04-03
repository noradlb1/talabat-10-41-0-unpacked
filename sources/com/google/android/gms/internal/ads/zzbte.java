package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

public abstract class zzbte extends zzaok implements zzbtf {
    public zzbte() {
        super("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheCallback");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        zzb((ParcelFileDescriptor) zzaol.zza(parcel, ParcelFileDescriptor.CREATOR));
        return true;
    }
}
