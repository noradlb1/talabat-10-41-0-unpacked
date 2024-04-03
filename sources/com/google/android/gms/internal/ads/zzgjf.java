package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public abstract class zzgjf implements Iterable<Byte>, Serializable {
    private static final Comparator<zzgjf> zza = new zzgiw();
    public static final zzgjf zzb = new zzgjb(zzgkv.zzd);
    private static final zzgje zzd = new zzgje((zzgjd) null);
    private int zzc = 0;

    static {
        int i11 = zzgip.zza;
    }

    public static void zzB(int i11, int i12) {
        if (((i12 - (i11 + 1)) | i11) >= 0) {
            return;
        }
        if (i11 < 0) {
            StringBuilder sb2 = new StringBuilder(22);
            sb2.append("Index < 0: ");
            sb2.append(i11);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(40);
        sb3.append("Index > length: ");
        sb3.append(i11);
        sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb3.append(i12);
        throw new ArrayIndexOutOfBoundsException(sb3.toString());
    }

    private static zzgjf zzc(Iterator<zzgjf> it, int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i11)}));
        } else if (i11 == 1) {
            return it.next();
        } else {
            int i12 = i11 >>> 1;
            zzgjf zzc2 = zzc(it, i12);
            zzgjf zzc3 = zzc(it, i11 - i12);
            if (Integer.MAX_VALUE - zzc2.zzd() >= zzc3.zzd()) {
                return zzgmn.zzG(zzc2, zzc3);
            }
            int zzd2 = zzc2.zzd();
            int zzd3 = zzc3.zzd();
            StringBuilder sb2 = new StringBuilder(53);
            sb2.append("ByteString would be too long: ");
            sb2.append(zzd2);
            sb2.append("+");
            sb2.append(zzd3);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public static int zzq(int i11, int i12, int i13) {
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

    public static zzgjc zzt() {
        return new zzgjc(128);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Iterable<com.google.android.gms.internal.ads.zzgjf>, java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzgjf zzu(java.lang.Iterable<com.google.android.gms.internal.ads.zzgjf> r3) {
        /*
            boolean r0 = r3 instanceof java.util.Collection
            if (r0 != 0) goto L_0x0015
            java.util.Iterator r0 = r3.iterator()
            r1 = 0
        L_0x0009:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0019
            r0.next()
            int r1 = r1 + 1
            goto L_0x0009
        L_0x0015:
            int r1 = r3.size()
        L_0x0019:
            if (r1 != 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzgjf r3 = zzb
            return r3
        L_0x001e:
            java.util.Iterator r3 = r3.iterator()
            com.google.android.gms.internal.ads.zzgjf r3 = zzc(r3, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgjf.zzu(java.lang.Iterable):com.google.android.gms.internal.ads.zzgjf");
    }

    public static zzgjf zzv(byte[] bArr) {
        return zzw(bArr, 0, bArr.length);
    }

    public static zzgjf zzw(byte[] bArr, int i11, int i12) {
        zzq(i11, i11 + i12, bArr.length);
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        return new zzgjb(bArr2);
    }

    public static zzgjf zzx(String str) {
        return new zzgjb(str.getBytes(zzgkv.zzb));
    }

    public static zzgjf zzy(InputStream inputStream) throws IOException {
        zzgjf zzgjf;
        ArrayList arrayList = new ArrayList();
        int i11 = 256;
        while (true) {
            byte[] bArr = new byte[i11];
            int i12 = 0;
            while (i12 < i11) {
                int read = inputStream.read(bArr, i12, i11 - i12);
                if (read == -1) {
                    break;
                }
                i12 += read;
            }
            if (i12 == 0) {
                zzgjf = null;
            } else {
                zzgjf = zzw(bArr, 0, i12);
            }
            if (zzgjf == null) {
                return zzu(arrayList);
            }
            arrayList.add(zzgjf);
            i11 = Math.min(i11 + i11, 8192);
        }
    }

    public static zzgjf zzz(byte[] bArr) {
        return new zzgjb(bArr);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i11 = this.zzc;
        if (i11 == 0) {
            int zzd2 = zzd();
            i11 = zzi(zzd2, 0, zzd2);
            if (i11 == 0) {
                i11 = 1;
            }
            this.zzc = i11;
        }
        return i11;
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        if (zzd() <= 50) {
            str = zzgnd.zza(this);
        } else {
            str = zzgnd.zza(zzk(0, 47)).concat("...");
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public final String zzA(Charset charset) {
        return zzd() == 0 ? "" : zzm(charset);
    }

    @Deprecated
    public final void zzC(byte[] bArr, int i11, int i12, int i13) {
        zzq(0, i13, zzd());
        zzq(i12, i12 + i13, bArr.length);
        if (i13 > 0) {
            zze(bArr, 0, i12, i13);
        }
    }

    public final boolean zzD() {
        return zzd() == 0;
    }

    public final byte[] zzE() {
        int zzd2 = zzd();
        if (zzd2 == 0) {
            return zzgkv.zzd;
        }
        byte[] bArr = new byte[zzd2];
        zze(bArr, 0, 0, zzd2);
        return bArr;
    }

    public abstract byte zza(int i11);

    public abstract byte zzb(int i11);

    public abstract int zzd();

    public abstract void zze(byte[] bArr, int i11, int i12, int i13);

    public abstract int zzf();

    public abstract boolean zzh();

    public abstract int zzi(int i11, int i12, int i13);

    public abstract int zzj(int i11, int i12, int i13);

    public abstract zzgjf zzk(int i11, int i12);

    public abstract zzgjn zzl();

    public abstract String zzm(Charset charset);

    public abstract ByteBuffer zzn();

    public abstract void zzo(zzgit zzgit) throws IOException;

    public abstract boolean zzp();

    public final int zzr() {
        return this.zzc;
    }

    /* renamed from: zzs */
    public zzgiz iterator() {
        return new zzgiu(this);
    }
}
