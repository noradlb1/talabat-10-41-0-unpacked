package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public abstract class zzps implements Serializable, Iterable<Byte> {
    public static final zzps zzavx = new zzqc(zzre.zzbbh);
    private static final zzpy zzavy;
    private static final Comparator<zzps> zzavz = new zzpu();
    private int zzavn = 0;

    static {
        zzpy zzpy;
        if (zzpp.zzna()) {
            zzpy = new zzqd((zzpt) null);
        } else {
            zzpy = new zzpw((zzpt) null);
        }
        zzavy = zzpy;
    }

    /* access modifiers changed from: private */
    public static int zza(byte b11) {
        return b11 & 255;
    }

    public static zzqa zzam(int i11) {
        return new zzqa(i11, (zzpt) null);
    }

    public static zzps zzb(byte[] bArr, int i11, int i12) {
        zzb(i11, i11 + i12, bArr.length);
        return new zzqc(zzavy.zzc(bArr, i11, i12));
    }

    public static zzps zzcy(String str) {
        return new zzqc(str.getBytes(zzre.UTF_8));
    }

    public static zzps zzf(byte[] bArr) {
        return new zzqc(bArr);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i11 = this.zzavn;
        if (i11 == 0) {
            int size = size();
            i11 = zza(size, 0, size);
            if (i11 == 0) {
                i11 = 1;
            }
            this.zzavn = i11;
        }
        return i11;
    }

    public /* synthetic */ Iterator iterator() {
        return new zzpt(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public abstract int zza(int i11, int i12, int i13);

    public abstract String zza(Charset charset);

    public abstract void zza(zzpr zzpr) throws IOException;

    public abstract byte zzak(int i11);

    public abstract byte zzal(int i11);

    public abstract zzps zzc(int i11, int i12);

    public final String zznc() {
        Charset charset = zzre.UTF_8;
        if (size() == 0) {
            return "";
        }
        return zza(charset);
    }

    public abstract boolean zznd();

    public final int zzne() {
        return this.zzavn;
    }

    public static int zzb(int i11, int i12, int i13) {
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
}
