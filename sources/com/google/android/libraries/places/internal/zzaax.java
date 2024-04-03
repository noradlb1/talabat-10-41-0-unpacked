package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

public abstract class zzaax implements Iterable<Byte>, Serializable {
    private static final Comparator<zzaax> zza = new zzaap();
    public static final zzaax zzb = new zzaau(zzaca.zzc);
    private static final zzaaw zzd = new zzaaw((zzaav) null);
    private int zzc = 0;

    static {
        int i11 = zzaal.zza;
    }

    public static int zzj(int i11, int i12, int i13) {
        if (((i13 - i12) | i12) >= 0) {
            return i12;
        }
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("End index: ");
        sb2.append(i12);
        sb2.append(" >= ");
        sb2.append(i13);
        throw new IndexOutOfBoundsException(sb2.toString());
    }

    public static zzaax zzl(String str) {
        return new zzaau(str.getBytes(zzaca.zza));
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i11 = this.zzc;
        if (i11 == 0) {
            int zzd2 = zzd();
            i11 = zze(zzd2, 0, zzd2);
            if (i11 == 0) {
                i11 = 1;
            }
            this.zzc = i11;
        }
        return i11;
    }

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return new zzaan(this);
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        if (zzd() <= 50) {
            str = zzadz.zza(this);
        } else {
            str = String.valueOf(zzadz.zza(zzf(0, 47))).concat("...");
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i11);

    public abstract byte zzb(int i11);

    public abstract int zzd();

    public abstract int zze(int i11, int i12, int i13);

    public abstract zzaax zzf(int i11, int i12);

    public abstract String zzg(Charset charset);

    public abstract void zzh(zzaam zzaam) throws IOException;

    public abstract boolean zzi();

    public final int zzk() {
        return this.zzc;
    }

    public final String zzm(Charset charset) {
        return zzd() == 0 ? "" : zzg(charset);
    }
}
