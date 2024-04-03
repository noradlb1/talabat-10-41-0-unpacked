package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class zzuk {
    private static final Comparator<zzuj> zza = zzug.zza;
    private static final Comparator<zzuj> zzb = zzuh.zza;
    private final ArrayList<zzuj> zzc = new ArrayList<>();
    private final zzuj[] zzd = new zzuj[5];
    private int zze = -1;
    private int zzf;
    private int zzg;
    private int zzh;

    public zzuk(int i11) {
    }

    public final float zza(float f11) {
        if (this.zze != 0) {
            Collections.sort(this.zzc, zzb);
            this.zze = 0;
        }
        float f12 = ((float) this.zzg) * 0.5f;
        int i11 = 0;
        for (int i12 = 0; i12 < this.zzc.size(); i12++) {
            zzuj zzuj = this.zzc.get(i12);
            i11 += zzuj.zzb;
            if (((float) i11) >= f12) {
                return zzuj.zzc;
            }
        }
        if (this.zzc.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<zzuj> arrayList = this.zzc;
        return arrayList.get(arrayList.size() - 1).zzc;
    }

    public final void zzb(int i11, float f11) {
        zzuj zzuj;
        if (this.zze != 1) {
            Collections.sort(this.zzc, zza);
            this.zze = 1;
        }
        int i12 = this.zzh;
        if (i12 > 0) {
            zzuj[] zzujArr = this.zzd;
            int i13 = i12 - 1;
            this.zzh = i13;
            zzuj = zzujArr[i13];
        } else {
            zzuj = new zzuj((zzui) null);
        }
        int i14 = this.zzf;
        this.zzf = i14 + 1;
        zzuj.zza = i14;
        zzuj.zzb = i11;
        zzuj.zzc = f11;
        this.zzc.add(zzuj);
        this.zzg += i11;
        while (true) {
            int i15 = this.zzg;
            if (i15 > 2000) {
                int i16 = i15 - 2000;
                zzuj zzuj2 = this.zzc.get(0);
                int i17 = zzuj2.zzb;
                if (i17 <= i16) {
                    this.zzg -= i17;
                    this.zzc.remove(0);
                    int i18 = this.zzh;
                    if (i18 < 5) {
                        zzuj[] zzujArr2 = this.zzd;
                        this.zzh = i18 + 1;
                        zzujArr2[i18] = zzuj2;
                    }
                } else {
                    zzuj2.zzb = i17 - i16;
                    this.zzg -= i16;
                }
            } else {
                return;
            }
        }
    }

    public final void zzc() {
        this.zzc.clear();
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
    }
}
