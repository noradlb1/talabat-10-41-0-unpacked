package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.io.IOException;

public final class zzadm implements zzwp {
    public static final zzww zza = zzadl.zza;
    private final zzadn zzb;
    private final zzfd zzc;
    private final zzfd zzd;
    private final zzfc zze;
    private zzws zzf;
    private long zzg;
    private long zzh;
    private boolean zzi;
    private boolean zzj;

    public zzadm() {
        this(0);
    }

    public final int zza(zzwq zzwq, zzxm zzxm) throws IOException {
        zzdy.zzb(this.zzf);
        int zzg2 = zzwq.zzg(this.zzc.zzH(), 0, 2048);
        if (!this.zzj) {
            this.zzf.zzL(new zzxo(C.TIME_UNSET, 0));
            this.zzj = true;
        }
        if (zzg2 == -1) {
            return -1;
        }
        this.zzc.zzF(0);
        this.zzc.zzE(zzg2);
        if (!this.zzi) {
            this.zzb.zzd(this.zzg, 4);
            this.zzi = true;
        }
        this.zzb.zza(this.zzc);
        return 0;
    }

    public final void zzb(zzws zzws) {
        this.zzf = zzws;
        this.zzb.zzb(zzws, new zzafd(Integer.MIN_VALUE, 0, 1));
        zzws.zzB();
    }

    public final void zzc(long j11, long j12) {
        this.zzi = false;
        this.zzb.zze();
        this.zzg = j12;
    }

    public final boolean zzd(zzwq zzwq) throws IOException {
        int i11 = 0;
        while (true) {
            zzwk zzwk = (zzwk) zzwq;
            zzwk.zzm(this.zzd.zzH(), 0, 10, false);
            this.zzd.zzF(0);
            if (this.zzd.zzm() != 4801587) {
                break;
            }
            this.zzd.zzG(3);
            int zzj2 = this.zzd.zzj();
            i11 += zzj2 + 10;
            zzwk.zzl(zzj2, false);
        }
        zzwq.zzj();
        zzwk zzwk2 = (zzwk) zzwq;
        zzwk2.zzl(i11, false);
        if (this.zzh == -1) {
            this.zzh = (long) i11;
        }
        int i12 = 0;
        int i13 = 0;
        int i14 = i11;
        do {
            zzwk2.zzm(this.zzd.zzH(), 0, 2, false);
            this.zzd.zzF(0);
            if (!zzadn.zzf(this.zzd.zzo())) {
                i14++;
                zzwq.zzj();
                zzwk2.zzl(i14, false);
            } else {
                i12++;
                if (i12 >= 4 && i13 > 188) {
                    return true;
                }
                zzwk2.zzm(this.zzd.zzH(), 0, 4, false);
                this.zze.zzh(14);
                int zzc2 = this.zze.zzc(13);
                if (zzc2 <= 6) {
                    i14++;
                    zzwq.zzj();
                    zzwk2.zzl(i14, false);
                } else {
                    zzwk2.zzl(zzc2 - 6, false);
                    i13 += zzc2;
                }
            }
            i12 = 0;
            i13 = 0;
        } while (i14 - i11 < 8192);
        return false;
    }

    public zzadm(int i11) {
        this.zzb = new zzadn(true, (String) null);
        this.zzc = new zzfd(2048);
        this.zzh = -1;
        zzfd zzfd = new zzfd(10);
        this.zzd = zzfd;
        byte[] zzH = zzfd.zzH();
        this.zze = new zzfc(zzH, zzH.length);
    }
}
