package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public abstract class zzcdh extends zzaok implements zzcdi {
    public zzcdh() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        zzcdm zzcdm = null;
        if (i11 == 1) {
            zzcdc zzcdc = (zzcdc) zzaol.zza(parcel, zzcdc.CREATOR);
            parcel2.writeNoException();
            zzaol.zze(parcel2, (Parcelable) null);
        } else if (i11 == 2) {
            zzcdc zzcdc2 = (zzcdc) zzaol.zza(parcel, zzcdc.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                if (queryLocalInterface instanceof zzcdj) {
                    zzcdj zzcdj = (zzcdj) queryLocalInterface;
                }
            }
            parcel2.writeNoException();
        } else if (i11 == 4) {
            zzcdq zzcdq = (zzcdq) zzaol.zza(parcel, zzcdq.CREATOR);
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            if (readStrongBinder2 != null) {
                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface2 instanceof zzcdm) {
                    zzcdm = (zzcdm) queryLocalInterface2;
                } else {
                    zzcdm = new zzcdk(readStrongBinder2);
                }
            }
            zzg(zzcdq, zzcdm);
            parcel2.writeNoException();
        } else if (i11 == 5) {
            zzcdq zzcdq2 = (zzcdq) zzaol.zza(parcel, zzcdq.CREATOR);
            IBinder readStrongBinder3 = parcel.readStrongBinder();
            if (readStrongBinder3 != null) {
                IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface3 instanceof zzcdm) {
                    zzcdm = (zzcdm) queryLocalInterface3;
                } else {
                    zzcdm = new zzcdk(readStrongBinder3);
                }
            }
            zzf(zzcdq2, zzcdm);
            parcel2.writeNoException();
        } else if (i11 == 6) {
            zzcdq zzcdq3 = (zzcdq) zzaol.zza(parcel, zzcdq.CREATOR);
            IBinder readStrongBinder4 = parcel.readStrongBinder();
            if (readStrongBinder4 != null) {
                IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface4 instanceof zzcdm) {
                    zzcdm = (zzcdm) queryLocalInterface4;
                } else {
                    zzcdm = new zzcdk(readStrongBinder4);
                }
            }
            zze(zzcdq3, zzcdm);
            parcel2.writeNoException();
        } else if (i11 != 7) {
            return false;
        } else {
            String readString = parcel.readString();
            IBinder readStrongBinder5 = parcel.readStrongBinder();
            if (readStrongBinder5 != null) {
                IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface5 instanceof zzcdm) {
                    zzcdm = (zzcdm) queryLocalInterface5;
                } else {
                    zzcdm = new zzcdk(readStrongBinder5);
                }
            }
            zzh(readString, zzcdm);
            parcel2.writeNoException();
        }
        return true;
    }
}
