package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.CheckForNull;

class zzjm extends zzjn {
    final zzjj zzb;
    @CheckForNull
    final Character zzc;

    public zzjm(zzjj zzjj, @CheckForNull Character ch2) {
        this.zzb = zzjj;
        if (ch2 == null || !zzjj.zzb(ch2.charValue())) {
            this.zzc = ch2;
            return;
        }
        throw new IllegalArgumentException(zzfr.zza("Padding character %s was already in alphabet", ch2));
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzjm) {
            zzjm zzjm = (zzjm) obj;
            if (!this.zzb.equals(zzjm.zzb) || !zzfi.zza(this.zzc, zzjm.zzc)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode() ^ Arrays.hashCode(new Object[]{this.zzc});
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BaseEncoding.");
        sb2.append(this.zzb.toString());
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                sb2.append(".omitPadding()");
            } else {
                sb2.append(".withPadChar('");
                sb2.append(this.zzc);
                sb2.append("')");
            }
        }
        return sb2.toString();
    }

    public void zza(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
        int i13 = 0;
        zzfm.zzg(0, i12, bArr.length);
        while (i13 < i12) {
            zzc(appendable, bArr, i13, Math.min(this.zzb.zzd, i12 - i13));
            i13 += this.zzb.zzd;
        }
    }

    public final int zzb(int i11) {
        zzjj zzjj = this.zzb;
        return zzjj.zzc * zzze.zza(i11, zzjj.zzd, RoundingMode.CEILING);
    }

    public final void zzc(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
        boolean z11;
        zzfm.zzg(i11, i11 + i12, bArr.length);
        int i13 = 0;
        if (i12 <= this.zzb.zzd) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzfm.zzd(z11);
        long j11 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            j11 = (j11 | ((long) (bArr[i11 + i14] & 255))) << 8;
        }
        int i15 = ((i12 + 1) * 8) - this.zzb.zzb;
        while (i13 < i12 * 8) {
            zzjj zzjj = this.zzb;
            appendable.append(zzjj.zza(((int) (j11 >>> (i15 - i13))) & zzjj.zza));
            i13 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i13 < this.zzb.zzd * 8) {
                appendable.append(this.zzc.charValue());
                i13 += this.zzb.zzb;
            }
        }
    }

    public zzjm(String str, String str2, @CheckForNull Character ch2) {
        this(new zzjj(str, str2.toCharArray()), ch2);
    }
}
