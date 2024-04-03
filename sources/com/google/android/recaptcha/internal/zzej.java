package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.math.RoundingMode;
import javax.annotation.CheckForNull;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

class zzej extends zzek {
    final zzef zzb;
    @CheckForNull
    final Character zzc;

    /* JADX WARNING: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzej(com.google.android.recaptcha.internal.zzef r4, @javax.annotation.CheckForNull java.lang.Character r5) {
        /*
            r3 = this;
            r3.<init>()
            r3.zzb = r4
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L_0x0017
            r5.charValue()
            r2 = 61
            boolean r4 = r4.zzd(r2)
            if (r4 != 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r4 = r0
            goto L_0x0018
        L_0x0017:
            r4 = r1
        L_0x0018:
            if (r4 == 0) goto L_0x001d
            r3.zzc = r5
            return
        L_0x001d:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r5
            java.lang.String r5 = "Padding character %s was already in alphabet"
            java.lang.String r5 = com.google.android.recaptcha.internal.zzdu.zza(r5, r1)
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzej.<init>(com.google.android.recaptcha.internal.zzef, java.lang.Character):void");
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzej) {
            zzej zzej = (zzej) obj;
            if (this.zzb.equals(zzej.zzb)) {
                Character ch2 = this.zzc;
                Character ch3 = zzej.zzc;
                if (ch2 == ch3) {
                    return true;
                }
                if (ch2 == null || !ch2.equals(ch3)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int hashCode = this.zzb.hashCode();
        Character ch2 = this.zzc;
        if (ch2 == null) {
            i11 = 0;
        } else {
            i11 = ch2.hashCode();
        }
        return hashCode ^ i11;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BaseEncoding.");
        sb2.append(this.zzb);
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

    public int zza(byte[] bArr, CharSequence charSequence) throws zzei {
        zzef zzef;
        bArr.getClass();
        CharSequence zze = zze(charSequence);
        if (this.zzb.zzc(zze.length())) {
            int i11 = 0;
            int i12 = 0;
            while (i11 < zze.length()) {
                long j11 = 0;
                int i13 = 0;
                int i14 = 0;
                while (true) {
                    zzef = this.zzb;
                    if (i13 >= zzef.zzc) {
                        break;
                    }
                    j11 <<= zzef.zzb;
                    if (i11 + i13 < zze.length()) {
                        j11 |= (long) this.zzb.zzb(zze.charAt(i14 + i11));
                        i14++;
                    }
                    i13++;
                }
                int i15 = zzef.zzd;
                int i16 = i15 * 8;
                int i17 = i14 * zzef.zzb;
                int i18 = (i15 - 1) * 8;
                while (i18 >= i16 - i17) {
                    bArr[i12] = (byte) ((int) ((j11 >>> i18) & 255));
                    i18 -= 8;
                    i12++;
                }
                i11 += this.zzb.zzc;
            }
            return i12;
        }
        throw new zzei("Invalid input length " + zze.length());
    }

    public void zzb(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
        int i13 = 0;
        zzdr.zzd(0, i12, bArr.length);
        while (i13 < i12) {
            zzf(appendable, bArr, i13, Math.min(this.zzb.zzd, i12 - i13));
            i13 += this.zzb.zzd;
        }
    }

    public final int zzc(int i11) {
        return (int) (((((long) this.zzb.zzb) * ((long) i11)) + 7) / 8);
    }

    public final int zzd(int i11) {
        zzef zzef = this.zzb;
        return zzef.zzc * zzem.zza(i11, zzef.zzd, RoundingMode.CEILING);
    }

    public final CharSequence zze(CharSequence charSequence) {
        charSequence.getClass();
        Character ch2 = this.zzc;
        if (ch2 == null) {
            return charSequence;
        }
        ch2.charValue();
        int length = charSequence.length();
        do {
            length--;
            if (length < 0 || charSequence.charAt(length) != '=') {
            }
            length--;
            break;
        } while (charSequence.charAt(length) != '=');
        return charSequence.subSequence(0, length + 1);
    }

    public final void zzf(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
        boolean z11;
        zzdr.zzd(i11, i11 + i12, bArr.length);
        int i13 = 0;
        if (i12 <= this.zzb.zzd) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdr.zza(z11);
        long j11 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            j11 = (j11 | ((long) (bArr[i11 + i14] & 255))) << 8;
        }
        int i15 = ((i12 + 1) * 8) - this.zzb.zzb;
        while (i13 < i12 * 8) {
            zzef zzef = this.zzb;
            appendable.append(zzef.zza(zzef.zza & ((int) (j11 >>> (i15 - i13)))));
            i13 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i13 < this.zzb.zzd * 8) {
                this.zzc.charValue();
                appendable.append(SignatureVisitor.INSTANCEOF);
                i13 += this.zzb.zzb;
            }
        }
    }

    public zzej(String str, String str2, @CheckForNull Character ch2) {
        this(new zzef(str, str2.toCharArray()), ch2);
    }
}
