package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.List;
import okio.Utf8;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class zzacy extends zzadc {
    private static final byte[] zza = {79, 112, 117, 115, 72, 101, 97, 100};
    private boolean zzb;

    public static boolean zzd(zzfd zzfd) {
        if (zzfd.zza() < 8) {
            return false;
        }
        byte[] bArr = new byte[8];
        zzfd.zzB(bArr, 0, 8);
        return Arrays.equals(bArr, zza);
    }

    public final long zza(zzfd zzfd) {
        byte b11;
        int i11;
        byte[] zzH = zzfd.zzH();
        byte b12 = zzH[0] & 255;
        byte b13 = b12 & 3;
        if (b13 != 0) {
            b11 = 2;
            if (!(b13 == 1 || b13 == 2)) {
                b11 = zzH[1] & Utf8.REPLACEMENT_BYTE;
            }
        } else {
            b11 = 1;
        }
        int i12 = b12 >> 3;
        int i13 = i12 & 3;
        if (i12 >= 16) {
            i11 = 2500 << i13;
        } else if (i12 >= 12) {
            i11 = 10000 << (i13 & 1);
        } else if (i13 == 3) {
            i11 = 60000;
        } else {
            i11 = 10000 << i13;
        }
        return zzg(((long) b11) * ((long) i11));
    }

    public final void zzb(boolean z11) {
        super.zzb(z11);
        if (z11) {
            this.zzb = false;
        }
    }

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean zzc(zzfd zzfd, long j11, zzacz zzacz) {
        boolean z11 = true;
        if (!this.zzb) {
            byte[] copyOf = Arrays.copyOf(zzfd.zzH(), zzfd.zzd());
            byte b11 = copyOf[9];
            List<byte[]> zza2 = zzxl.zza(copyOf);
            zzz zzz = new zzz();
            zzz.zzS(MimeTypes.AUDIO_OPUS);
            zzz.zzw(b11 & 255);
            zzz.zzT(OpusUtil.SAMPLE_RATE);
            zzz.zzI(zza2);
            zzacz.zza = zzz.zzY();
            this.zzb = true;
            return true;
        }
        zzacz.zza.getClass();
        if (zzfd.zze() != 1332770163) {
            z11 = false;
        }
        zzfd.zzF(0);
        return z11;
    }
}
