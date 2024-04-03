package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public abstract class zzfh implements Serializable, Iterable<Byte> {
    public static final zzfh zzrx = new zzfr(zzgt.zzxc);
    private static final zzfn zzry;
    private static final Comparator<zzfh> zzrz = new zzfj();
    private int zzmi = 0;

    static {
        zzfn zzfn;
        if (zzfa.zzdr()) {
            zzfn = new zzfu((zzfk) null);
        } else {
            zzfn = new zzfl((zzfk) null);
        }
        zzry = zzfn;
    }

    /* access modifiers changed from: private */
    public static int zza(byte b11) {
        return b11 & 255;
    }

    public static zzfh zza(byte[] bArr, int i11, int i12) {
        zzc(i11, i11 + i12, bArr.length);
        return new zzfr(zzry.zzd(bArr, i11, i12));
    }

    public static zzfp zzap(int i11) {
        return new zzfp(i11, (zzfk) null);
    }

    public static zzfh zzb(byte[] bArr, int i11, int i12) {
        return new zzfo(bArr, i11, i12);
    }

    public static int zzc(int i11, int i12, int i13) {
        int i14 = i12 - i11;
        if ((i11 | i12 | i14 | (i13 - i12)) >= 0) {
            return i14;
        }
        if (i11 < 0) {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("Beginning index: ");
            sb2.append(i11);
            sb2.append(" < 0");
            throw new IndexOutOfBoundsException(sb2.toString());
        } else if (i12 < i11) {
            StringBuilder sb3 = new StringBuilder(66);
            sb3.append("Beginning index larger than ending index: ");
            sb3.append(i11);
            sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb3.append(i12);
            throw new IndexOutOfBoundsException(sb3.toString());
        } else {
            StringBuilder sb4 = new StringBuilder(37);
            sb4.append("End index: ");
            sb4.append(i12);
            sb4.append(" >= ");
            sb4.append(i13);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
    }

    public static zzfh zzd(byte[] bArr) {
        return new zzfr(bArr);
    }

    public static zzfh zzw(String str) {
        return new zzfr(str.getBytes(zzgt.UTF_8));
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i11 = this.zzmi;
        if (i11 == 0) {
            int size = size();
            i11 = zzb(size, 0, size);
            if (i11 == 0) {
                i11 = 1;
            }
            this.zzmi = i11;
        }
        return i11;
    }

    public /* synthetic */ Iterator iterator() {
        return new zzfk(this);
    }

    public abstract int size();

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        if (size() <= 50) {
            str = zzjf.zzd(this);
        } else {
            str = String.valueOf(zzjf.zzd(zzf(0, 47))).concat("...");
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract String zza(Charset charset);

    public abstract void zza(zzfi zzfi) throws IOException;

    public abstract void zza(byte[] bArr, int i11, int i12, int i13);

    public abstract byte zzan(int i11);

    public abstract byte zzao(int i11);

    public abstract int zzb(int i11, int i12, int i13);

    public final String zzer() {
        Charset charset = zzgt.UTF_8;
        if (size() == 0) {
            return "";
        }
        return zza(charset);
    }

    public abstract boolean zzes();

    public final int zzet() {
        return this.zzmi;
    }

    public abstract zzfh zzf(int i11, int i12);
}
