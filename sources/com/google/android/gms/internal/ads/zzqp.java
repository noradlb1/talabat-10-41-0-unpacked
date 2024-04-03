package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzqp extends zzpk<Integer> {
    private static final zzaz zza;
    private final zzqb[] zzb;
    private final zzcd[] zzc;
    private final ArrayList<zzqb> zzd;
    private final Map<Object, Long> zze;
    private final zzfts<Object, zzpg> zzf;
    private int zzg = -1;
    private long[][] zzh;
    @Nullable
    private zzqo zzi;
    private final zzpm zzj;

    static {
        zzaf zzaf = new zzaf();
        zzaf.zza("MergingMediaSource");
        zza = zzaf.zzc();
    }

    public zzqp(boolean z11, boolean z12, zzqb... zzqbArr) {
        zzpm zzpm = new zzpm();
        this.zzb = zzqbArr;
        this.zzj = zzpm;
        this.zzd = new ArrayList<>(Arrays.asList(zzqbArr));
        this.zzc = new zzcd[zzqbArr.length];
        this.zzh = new long[0][];
        this.zze = new HashMap();
        this.zzf = zzfua.zzb(8).zzb(2).zza();
    }

    public final void zzA(zzpy zzpy) {
        zzqn zzqn = (zzqn) zzpy;
        int i11 = 0;
        while (true) {
            zzqb[] zzqbArr = this.zzb;
            if (i11 < zzqbArr.length) {
                zzqbArr[i11].zzA(zzqn.zzm(i11));
                i11++;
            } else {
                return;
            }
        }
    }

    public final zzpy zzC(zzpz zzpz, zztk zztk, long j11) {
        int length = this.zzb.length;
        zzpy[] zzpyArr = new zzpy[length];
        int zza2 = this.zzc[0].zza(zzpz.zza);
        for (int i11 = 0; i11 < length; i11++) {
            zzpyArr[i11] = this.zzb[i11].zzC(zzpz.zzc(this.zzc[i11].zzf(zza2)), zztk, j11 - this.zzh[zza2][i11]);
        }
        return new zzqn(this.zzj, this.zzh[zza2], zzpyArr, (byte[]) null);
    }

    public final void zzm(@Nullable zzdx zzdx) {
        super.zzm(zzdx);
        for (int i11 = 0; i11 < this.zzb.length; i11++) {
            zzx(Integer.valueOf(i11), this.zzb[i11]);
        }
    }

    public final void zzp() {
        super.zzp();
        Arrays.fill(this.zzc, (Object) null);
        this.zzg = -1;
        this.zzi = null;
        this.zzd.clear();
        Collections.addAll(this.zzd, this.zzb);
    }

    @Nullable
    public final /* bridge */ /* synthetic */ zzpz zzu(Object obj, zzpz zzpz) {
        if (((Integer) obj).intValue() == 0) {
            return zzpz;
        }
        return null;
    }

    public final void zzv() throws IOException {
        zzqo zzqo = this.zzi;
        if (zzqo == null) {
            super.zzv();
            return;
        }
        throw zzqo;
    }

    public final /* bridge */ /* synthetic */ void zzw(Object obj, zzqb zzqb, zzcd zzcd) {
        int i11;
        if (this.zzi == null) {
            if (this.zzg == -1) {
                i11 = zzcd.zzb();
                this.zzg = i11;
            } else {
                int zzb2 = zzcd.zzb();
                int i12 = this.zzg;
                if (zzb2 == i12) {
                    i11 = i12;
                } else {
                    this.zzi = new zzqo(0);
                    return;
                }
            }
            if (this.zzh.length == 0) {
                int[] iArr = new int[2];
                iArr[1] = this.zzc.length;
                iArr[0] = i11;
                this.zzh = (long[][]) Array.newInstance(Long.TYPE, iArr);
            }
            this.zzd.remove(zzqb);
            this.zzc[((Integer) obj).intValue()] = zzcd;
            if (this.zzd.isEmpty()) {
                zzn(this.zzc[0]);
            }
        }
    }

    public final zzaz zzy() {
        zzqb[] zzqbArr = this.zzb;
        return zzqbArr.length > 0 ? zzqbArr[0].zzy() : zza;
    }
}
