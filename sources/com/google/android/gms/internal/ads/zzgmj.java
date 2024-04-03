package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

final class zzgmj {
    private final ArrayDeque<zzgjf> zza = new ArrayDeque<>();

    private zzgmj() {
    }

    public static /* bridge */ /* synthetic */ zzgjf zza(zzgmj zzgmj, zzgjf zzgjf, zzgjf zzgjf2) {
        zzgmj.zzb(zzgjf);
        zzgmj.zzb(zzgjf2);
        zzgjf pop = zzgmj.zza.pop();
        while (!zzgmj.zza.isEmpty()) {
            pop = new zzgmn(zzgmj.zza.pop(), pop);
        }
        return pop;
    }

    private final void zzb(zzgjf zzgjf) {
        if (zzgjf.zzh()) {
            int zzc = zzc(zzgjf.zzd());
            int zzc2 = zzgmn.zzc(zzc + 1);
            if (this.zza.isEmpty() || this.zza.peek().zzd() >= zzc2) {
                this.zza.push(zzgjf);
                return;
            }
            int zzc3 = zzgmn.zzc(zzc);
            zzgjf pop = this.zza.pop();
            while (!this.zza.isEmpty() && this.zza.peek().zzd() < zzc3) {
                pop = new zzgmn(this.zza.pop(), pop);
            }
            zzgmn zzgmn = new zzgmn(pop, zzgjf);
            while (!this.zza.isEmpty() && this.zza.peek().zzd() < zzgmn.zzc(zzc(zzgmn.zzd()) + 1)) {
                zzgmn = new zzgmn(this.zza.pop(), zzgmn);
            }
            this.zza.push(zzgmn);
        } else if (zzgjf instanceof zzgmn) {
            zzgmn zzgmn2 = (zzgmn) zzgjf;
            zzb(zzgmn2.zzd);
            zzb(zzgmn2.zze);
        } else {
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(zzgjf.getClass())));
        }
    }

    private static final int zzc(int i11) {
        int binarySearch = Arrays.binarySearch(zzgmn.zza, i11);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    public /* synthetic */ zzgmj(zzgmi zzgmi) {
    }
}
