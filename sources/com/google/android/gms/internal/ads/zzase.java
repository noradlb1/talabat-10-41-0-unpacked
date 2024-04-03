package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class zzase extends zzasg {
    public final long zza;
    public final List<zzasf> zzb = new ArrayList();
    public final List<zzase> zzc = new ArrayList();

    public zzase(int i11, long j11) {
        super(i11);
        this.zza = j11;
    }

    public final String toString() {
        String zzg = zzasg.zzg(this.zzaR);
        String arrays = Arrays.toString(this.zzb.toArray());
        String arrays2 = Arrays.toString(this.zzc.toArray());
        int length = String.valueOf(arrays).length();
        StringBuilder sb2 = new StringBuilder(zzg.length() + 22 + length + String.valueOf(arrays2).length());
        sb2.append(zzg);
        sb2.append(" leaves: ");
        sb2.append(arrays);
        sb2.append(" containers: ");
        sb2.append(arrays2);
        return sb2.toString();
    }

    public final zzase zza(int i11) {
        int size = this.zzc.size();
        for (int i12 = 0; i12 < size; i12++) {
            zzase zzase = this.zzc.get(i12);
            if (zzase.zzaR == i11) {
                return zzase;
            }
        }
        return null;
    }

    public final zzasf zzb(int i11) {
        int size = this.zzb.size();
        for (int i12 = 0; i12 < size; i12++) {
            zzasf zzasf = this.zzb.get(i12);
            if (zzasf.zzaR == i11) {
                return zzasf;
            }
        }
        return null;
    }

    public final void zzc(zzase zzase) {
        this.zzc.add(zzase);
    }

    public final void zzd(zzasf zzasf) {
        this.zzb.add(zzasf);
    }
}
