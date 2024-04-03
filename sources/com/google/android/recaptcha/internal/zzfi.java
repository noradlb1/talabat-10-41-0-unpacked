package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public abstract class zzfi implements Iterable, Serializable {
    private static final Comparator zza = new zzfa();
    public static final zzfi zzb = new zzff(zzhn.zzd);
    private static final zzfh zzd = new zzfh((zzfg) null);
    private int zzc = 0;

    static {
        int i11 = zzeu.zza;
    }

    public static int zzk(int i11, int i12, int i13) {
        int i14 = i12 - i11;
        if ((i11 | i12 | i14 | (i13 - i12)) >= 0) {
            return i14;
        }
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i11 + " < 0");
        } else if (i12 < i11) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i12);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i12 + " >= " + i13);
        }
    }

    public static zzfi zzm(byte[] bArr, int i11, int i12) {
        zzk(i11, i11 + i12, bArr.length);
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        return new zzff(bArr2);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i11 = this.zzc;
        if (i11 == 0) {
            int zzd2 = zzd();
            i11 = zzf(zzd2, 0, zzd2);
            if (i11 == 0) {
                i11 = 1;
            }
            this.zzc = i11;
        }
        return i11;
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzez(this);
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        if (zzd() <= 50) {
            str = zzjr.zza(this);
        } else {
            str = zzjr.zza(zzg(0, 47)).concat("...");
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i11);

    public abstract byte zzb(int i11);

    public abstract int zzd();

    public abstract void zze(byte[] bArr, int i11, int i12, int i13);

    public abstract int zzf(int i11, int i12, int i13);

    public abstract zzfi zzg(int i11, int i12);

    public abstract String zzh(Charset charset);

    public abstract void zzi(zzey zzey) throws IOException;

    public abstract boolean zzj();

    public final int zzl() {
        return this.zzc;
    }

    public final String zzn(Charset charset) {
        return zzd() == 0 ? "" : zzh(charset);
    }

    public final byte[] zzo() {
        int zzd2 = zzd();
        if (zzd2 == 0) {
            return zzhn.zzd;
        }
        byte[] bArr = new byte[zzd2];
        zze(bArr, 0, 0, zzd2);
        return bArr;
    }
}
