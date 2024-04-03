package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafv  reason: invalid package */
public abstract class zzafv implements Iterable, Serializable {
    private static final Comparator zza = new zzafn();
    public static final zzafv zzb = new zzafs(zzahg.zzd);
    private static final zzafu zzd = new zzafu((zzaft) null);
    private int zzc = 0;

    static {
        int i11 = zzafh.zza;
    }

    public static int zzl(int i11, int i12, int i13) {
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

    public static zzafv zzn(byte[] bArr, int i11, int i12) {
        zzl(i11, i11 + i12, bArr.length);
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        return new zzafs(bArr2);
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
        return new zzafm(this);
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        if (zzd() <= 50) {
            str = zzajg.zza(this);
        } else {
            str = zzajg.zza(zzg(0, 47)).concat("...");
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i11);

    public abstract byte zzb(int i11);

    public abstract int zzd();

    public abstract void zze(byte[] bArr, int i11, int i12, int i13);

    public abstract int zzf(int i11, int i12, int i13);

    public abstract zzafv zzg(int i11, int i12);

    public abstract zzagb zzh();

    public abstract String zzi(Charset charset);

    public abstract void zzj(zzafl zzafl) throws IOException;

    public abstract boolean zzk();

    public final int zzm() {
        return this.zzc;
    }

    public final String zzo(Charset charset) {
        return zzd() == 0 ? "" : zzi(charset);
    }

    public final boolean zzp() {
        return zzd() == 0;
    }

    public final byte[] zzq() {
        int zzd2 = zzd();
        if (zzd2 == 0) {
            return zzahg.zzd;
        }
        byte[] bArr = new byte[zzd2];
        zze(bArr, 0, 0, zzd2);
        return bArr;
    }
}
