package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class zzabl extends zzabn {
    public final long zza;
    public final List<zzabm> zzb = new ArrayList();
    public final List<zzabl> zzc = new ArrayList();

    public zzabl(int i11, long j11) {
        super(i11);
        this.zza = j11;
    }

    public final String toString() {
        String zzf = zzabn.zzf(this.zzd);
        String arrays = Arrays.toString(this.zzb.toArray());
        String arrays2 = Arrays.toString(this.zzc.toArray());
        int length = String.valueOf(arrays).length();
        StringBuilder sb2 = new StringBuilder(zzf.length() + 22 + length + String.valueOf(arrays2).length());
        sb2.append(zzf);
        sb2.append(" leaves: ");
        sb2.append(arrays);
        sb2.append(" containers: ");
        sb2.append(arrays2);
        return sb2.toString();
    }

    @Nullable
    public final zzabl zza(int i11) {
        int size = this.zzc.size();
        for (int i12 = 0; i12 < size; i12++) {
            zzabl zzabl = this.zzc.get(i12);
            if (zzabl.zzd == i11) {
                return zzabl;
            }
        }
        return null;
    }

    @Nullable
    public final zzabm zzb(int i11) {
        int size = this.zzb.size();
        for (int i12 = 0; i12 < size; i12++) {
            zzabm zzabm = this.zzb.get(i12);
            if (zzabm.zzd == i11) {
                return zzabm;
            }
        }
        return null;
    }

    public final void zzc(zzabl zzabl) {
        this.zzc.add(zzabl);
    }

    public final void zzd(zzabm zzabm) {
        this.zzb.add(zzabm);
    }
}
