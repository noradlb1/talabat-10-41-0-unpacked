package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public abstract class zzhb implements zzgz {
    public abstract zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr);

    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19 = true;
        if (zzfl != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        if (zzoaArr != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        zzoa<?>[] zzoaArr2 = new zzoa[zzoaArr.length];
        for (int i11 = 0; i11 < zzoaArr.length; i11++) {
            if (zzoaArr[i11] != null) {
                z13 = true;
            } else {
                z13 = false;
            }
            Preconditions.checkArgument(z13);
            zzog zzog = zzoaArr[i11];
            zzog zzog2 = zzog.zzauj;
            if (zzog != zzog2) {
                z14 = true;
            } else {
                z14 = false;
            }
            Preconditions.checkArgument(z14);
            zzog zzog3 = zzoaArr[i11];
            zzog zzog4 = zzog.zzauk;
            if (zzog3 != zzog4) {
                z15 = true;
            } else {
                z15 = false;
            }
            Preconditions.checkArgument(z15);
            zzoa<?> zza = zzoo.zza(zzfl, (zzoa) zzoaArr[i11]);
            zzoaArr2[i11] = zza;
            if (zza != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkArgument(z16);
            if (zzoaArr2[i11] != zzog2) {
                z17 = true;
            } else {
                z17 = false;
            }
            Preconditions.checkArgument(z17);
            if (zzoaArr2[i11] != zzog4) {
                z18 = true;
            } else {
                z18 = false;
            }
            Preconditions.checkArgument(z18);
        }
        zzoa<?> zza2 = zza(zzfl, zzoaArr2);
        if (zza2 == null) {
            z19 = false;
        }
        Preconditions.checkState(z19);
        return zza2;
    }
}
