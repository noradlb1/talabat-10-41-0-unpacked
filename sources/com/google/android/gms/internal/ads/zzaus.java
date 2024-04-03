package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public final class zzaus implements zzauo {
    private final zzauo[] zza;
    private final ArrayList<zzauo> zzb;
    private final zzapq zzc = new zzapq();
    private zzaun zzd;
    private zzapr zze;
    private int zzf = -1;
    private zzaur zzg;

    public zzaus(zzauo... zzauoArr) {
        this.zza = zzauoArr;
        this.zzb = new ArrayList<>(Arrays.asList(zzauoArr));
    }

    public static /* bridge */ /* synthetic */ void zze(zzaus zzaus, int i11, zzapr zzapr, Object obj) {
        zzaur zzaur;
        if (zzaus.zzg == null) {
            for (int i12 = 0; i12 <= 0; i12++) {
                zzapr.zzg(i12, zzaus.zzc, false);
            }
            int i13 = zzaus.zzf;
            if (i13 == -1) {
                zzaus.zzf = 1;
            } else if (i13 != 1) {
                zzaur = new zzaur(1);
                zzaus.zzg = zzaur;
            }
            zzaur = null;
            zzaus.zzg = zzaur;
        }
        if (zzaus.zzg == null) {
            zzaus.zzb.remove(zzaus.zza[i11]);
            if (i11 == 0) {
                zzaus.zze = zzapr;
            }
            if (zzaus.zzb.isEmpty()) {
                zzaus.zzd.zze(zzaus.zze, (Object) null);
            }
        }
    }

    public final void zza() throws IOException {
        zzaur zzaur = this.zzg;
        if (zzaur == null) {
            for (zzauo zza2 : this.zza) {
                zza2.zza();
            }
            return;
        }
        throw zzaur;
    }

    public final void zzb(zzaow zzaow, boolean z11, zzaun zzaun) {
        this.zzd = zzaun;
        int i11 = 0;
        while (true) {
            zzauo[] zzauoArr = this.zza;
            if (i11 < zzauoArr.length) {
                zzauoArr[i11].zzb(zzaow, false, new zzauq(this, i11));
                i11++;
            } else {
                return;
            }
        }
    }

    public final void zzc(zzaum zzaum) {
        zzaup zzaup = (zzaup) zzaum;
        int i11 = 0;
        while (true) {
            zzauo[] zzauoArr = this.zza;
            if (i11 < zzauoArr.length) {
                zzauoArr[i11].zzc(zzaup.zza[i11]);
                i11++;
            } else {
                return;
            }
        }
    }

    public final void zzd() {
        for (zzauo zzd2 : this.zza) {
            zzd2.zzd();
        }
    }

    public final zzaum zzf(int i11, zzavz zzavz) {
        int length = this.zza.length;
        zzaum[] zzaumArr = new zzaum[length];
        for (int i12 = 0; i12 < length; i12++) {
            zzaumArr[i12] = this.zza[i12].zzf(i11, zzavz);
        }
        return new zzaup(zzaumArr);
    }
}
