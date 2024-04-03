package com.google.android.gms.internal.icing;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

public abstract class zzcf implements Iterable<Byte>, Serializable {
    public static final zzcf zzb = new zzcd(zzdh.zzc);
    private static final Comparator<zzcf> zzc = new zzby();
    private static final zzce zzd = new zzce((zzbx) null);
    private int zza = 0;

    static {
        int i11 = zzbu.zza;
    }

    public static zzcf zzj(String str) {
        return new zzcd(str.getBytes(zzdh.zza));
    }

    public static int zzm(int i11, int i12, int i13) {
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

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i11 = this.zza;
        if (i11 == 0) {
            int zzc2 = zzc();
            i11 = zzi(zzc2, 0, zzc2);
            if (i11 == 0) {
                i11 = 1;
            }
            this.zza = i11;
        }
        return i11;
    }

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return new zzbx(this);
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzc());
        if (zzc() <= 50) {
            str = zzfb.zza(this);
        } else {
            str = String.valueOf(zzfb.zza(zze(0, 47))).concat("...");
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i11);

    public abstract byte zzb(int i11);

    public abstract int zzc();

    public abstract zzcf zze(int i11, int i12);

    public abstract void zzf(zzbw zzbw) throws IOException;

    public abstract String zzg(Charset charset);

    public abstract boolean zzh();

    public abstract int zzi(int i11, int i12, int i13);

    public final String zzk(Charset charset) {
        if (zzc() == 0) {
            return "";
        }
        return zzg(charset);
    }

    public final int zzl() {
        return this.zza;
    }
}
