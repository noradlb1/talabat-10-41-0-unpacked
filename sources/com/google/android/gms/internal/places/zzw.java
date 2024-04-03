package com.google.android.gms.internal.places;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public abstract class zzw implements Serializable, Iterable<Byte> {
    public static final zzw zzeg = new zzag(zzbd.zziz);
    private static final zzac zzeh;
    private static final Comparator<zzw> zzej = new zzy();
    private int zzei = 0;

    static {
        zzac zzac;
        if (zzp.zzy()) {
            zzac = new zzaf((zzv) null);
        } else {
            zzac = new zzaa((zzv) null);
        }
        zzeh = zzac;
    }

    /* access modifiers changed from: private */
    public static int zzb(byte b11) {
        return b11 & 255;
    }

    public static zzw zzc(byte[] bArr, int i11, int i12) {
        zzc(i11, i11 + i12, bArr.length);
        return new zzag(zzeh.zzd(bArr, i11, i12));
    }

    public static zzw zzi(String str) {
        return new zzag(str.getBytes(zzbd.UTF_8));
    }

    public static zzae zzk(int i11) {
        return new zzae(i11, (zzv) null);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i11 = this.zzei;
        if (i11 == 0) {
            int size = size();
            i11 = zzb(size, 0, size);
            if (i11 == 0) {
                i11 = 1;
            }
            this.zzei = i11;
        }
        return i11;
    }

    public /* synthetic */ Iterator iterator() {
        return new zzv(this);
    }

    public abstract int size();

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return zzbd.zziz;
        }
        byte[] bArr = new byte[size];
        zzb(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public final String zzad() {
        Charset charset = zzbd.UTF_8;
        if (size() == 0) {
            return "";
        }
        return zzb(charset);
    }

    public abstract boolean zzae();

    public final int zzaf() {
        return this.zzei;
    }

    public abstract int zzb(int i11, int i12, int i13);

    public abstract zzw zzb(int i11, int i12);

    public abstract String zzb(Charset charset);

    public abstract void zzb(zzt zzt) throws IOException;

    public abstract void zzb(byte[] bArr, int i11, int i12, int i13);

    public abstract byte zzi(int i11);

    public abstract byte zzj(int i11);

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
}
