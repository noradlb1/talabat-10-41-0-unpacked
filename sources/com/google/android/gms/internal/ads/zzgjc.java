package com.google.android.gms.internal.ads;

import java.io.OutputStream;
import java.util.ArrayList;

public final class zzgjc extends OutputStream {
    private static final byte[] zza = new byte[0];
    private final int zzb = 128;
    private final ArrayList<zzgjf> zzc = new ArrayList<>();
    private int zzd;
    private byte[] zze = new byte[128];
    private int zzf;

    public zzgjc(int i11) {
    }

    private final void zzc(int i11) {
        this.zzc.add(new zzgjb(this.zze));
        int length = this.zzd + this.zze.length;
        this.zzd = length;
        this.zze = new byte[Math.max(this.zzb, Math.max(i11, length >>> 1))];
        this.zzf = 0;
    }

    public final String toString() {
        return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zza())});
    }

    public final synchronized void write(int i11) {
        if (this.zzf == this.zze.length) {
            zzc(1);
        }
        byte[] bArr = this.zze;
        int i12 = this.zzf;
        this.zzf = i12 + 1;
        bArr[i12] = (byte) i11;
    }

    public final synchronized int zza() {
        return this.zzd + this.zzf;
    }

    public final synchronized zzgjf zzb() {
        int i11 = this.zzf;
        byte[] bArr = this.zze;
        int length = bArr.length;
        if (i11 >= length) {
            this.zzc.add(new zzgjb(bArr));
            this.zze = zza;
        } else if (i11 > 0) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(length, i11));
            this.zzc.add(new zzgjb(bArr2));
        }
        this.zzd += this.zzf;
        this.zzf = 0;
        return zzgjf.zzu(this.zzc);
    }

    public final synchronized void write(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = this.zze;
        int length = bArr2.length;
        int i13 = this.zzf;
        int i14 = length - i13;
        if (i12 <= i14) {
            System.arraycopy(bArr, i11, bArr2, i13, i12);
            this.zzf += i12;
            return;
        }
        System.arraycopy(bArr, i11, bArr2, i13, i14);
        int i15 = i12 - i14;
        zzc(i15);
        System.arraycopy(bArr, i11 + i14, this.zze, 0, i15);
        this.zzf = i15;
    }
}
