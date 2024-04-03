package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;

final class zzyh extends zzym {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzyh(zzxt zzxt) {
        super(zzxt);
    }

    public final boolean zza(zzfd zzfd) throws zzyl {
        String str;
        if (!this.zzc) {
            int zzk = zzfd.zzk();
            int i11 = zzk >> 4;
            this.zze = i11;
            if (i11 == 2) {
                int i12 = zzb[(zzk >> 2) & 3];
                zzz zzz = new zzz();
                zzz.zzS(MimeTypes.AUDIO_MPEG);
                zzz.zzw(1);
                zzz.zzT(i12);
                this.zza.zzk(zzz.zzY());
                this.zzd = true;
            } else if (i11 == 7 || i11 == 8) {
                if (i11 == 7) {
                    str = MimeTypes.AUDIO_ALAW;
                } else {
                    str = MimeTypes.AUDIO_MLAW;
                }
                zzz zzz2 = new zzz();
                zzz2.zzS(str);
                zzz2.zzw(1);
                zzz2.zzT(8000);
                this.zza.zzk(zzz2.zzY());
                this.zzd = true;
            } else if (i11 != 10) {
                StringBuilder sb2 = new StringBuilder(39);
                sb2.append("Audio format not supported: ");
                sb2.append(i11);
                throw new zzyl(sb2.toString());
            }
            this.zzc = true;
        } else {
            zzfd.zzG(1);
        }
        return true;
    }

    public final boolean zzb(zzfd zzfd, long j11) throws zzbj {
        if (this.zze == 2) {
            int zza = zzfd.zza();
            this.zza.zzq(zzfd, zza);
            this.zza.zzs(j11, 1, zza, 0, (zzxs) null);
            return true;
        }
        int zzk = zzfd.zzk();
        if (zzk == 0 && !this.zzd) {
            int zza2 = zzfd.zza();
            byte[] bArr = new byte[zza2];
            zzfd.zzB(bArr, 0, zza2);
            zzvr zza3 = zzvs.zza(bArr);
            zzz zzz = new zzz();
            zzz.zzS(MimeTypes.AUDIO_AAC);
            zzz.zzx(zza3.zzc);
            zzz.zzw(zza3.zzb);
            zzz.zzT(zza3.zza);
            zzz.zzI(Collections.singletonList(bArr));
            this.zza.zzk(zzz.zzY());
            this.zzd = true;
            return false;
        } else if (this.zze == 10 && zzk != 1) {
            return false;
        } else {
            int zza4 = zzfd.zza();
            this.zza.zzq(zzfd, zza4);
            this.zza.zzs(j11, 1, zza4, 0, (zzxs) null);
            return true;
        }
    }
}
