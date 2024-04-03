package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;

final class zzyn extends zzym {
    private final zzfd zzb = new zzfd(zzeu.zza);
    private final zzfd zzc = new zzfd(4);
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzyn(zzxt zzxt) {
        super(zzxt);
    }

    public final boolean zza(zzfd zzfd) throws zzyl {
        int zzk = zzfd.zzk();
        int i11 = zzk >> 4;
        int i12 = zzk & 15;
        if (i12 == 7) {
            this.zzg = i11;
            if (i11 != 5) {
                return true;
            }
            return false;
        }
        StringBuilder sb2 = new StringBuilder(39);
        sb2.append("Video format not supported: ");
        sb2.append(i12);
        throw new zzyl(sb2.toString());
    }

    public final boolean zzb(zzfd zzfd, long j11) throws zzbj {
        int i11;
        int zzk = zzfd.zzk();
        long zzf2 = j11 + (((long) zzfd.zzf()) * 1000);
        if (zzk == 0) {
            if (!this.zze) {
                zzfd zzfd2 = new zzfd(new byte[zzfd.zza()]);
                zzfd.zzB(zzfd2.zzH(), 0, zzfd.zza());
                zzvz zza = zzvz.zza(zzfd2);
                this.zzd = zza.zzb;
                zzz zzz = new zzz();
                zzz.zzS(MimeTypes.VIDEO_H264);
                zzz.zzx(zza.zzf);
                zzz.zzX(zza.zzc);
                zzz.zzF(zza.zzd);
                zzz.zzP(zza.zze);
                zzz.zzI(zza.zza);
                this.zza.zzk(zzz.zzY());
                this.zze = true;
                return false;
            }
        } else if (zzk == 1 && this.zze) {
            if (this.zzg == 1) {
                i11 = 1;
            } else {
                i11 = 0;
            }
            if (!this.zzf && i11 == 0) {
                return false;
            }
            byte[] zzH = this.zzc.zzH();
            zzH[0] = 0;
            zzH[1] = 0;
            zzH[2] = 0;
            int i12 = 4 - this.zzd;
            int i13 = 0;
            while (zzfd.zza() > 0) {
                zzfd.zzB(this.zzc.zzH(), i12, this.zzd);
                this.zzc.zzF(0);
                int zzn = this.zzc.zzn();
                this.zzb.zzF(0);
                this.zza.zzq(this.zzb, 4);
                this.zza.zzq(zzfd, zzn);
                i13 = i13 + 4 + zzn;
            }
            this.zza.zzs(zzf2, i11, i13, 0, (zzxs) null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}
