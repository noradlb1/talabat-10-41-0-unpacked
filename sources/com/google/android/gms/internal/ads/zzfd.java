package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.common.base.Ascii;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;

public final class zzfd {
    private byte[] zza;
    private int zzb;
    private int zzc;

    public zzfd() {
        this.zza = zzfn.zzf;
    }

    public zzfd(byte[] bArr, int i11) {
        this.zza = bArr;
        this.zzc = i11;
    }

    public final void zzA(zzfc zzfc, int i11) {
        zzB(zzfc.zza, 0, i11);
        zzfc.zzh(0);
    }

    public final void zzB(byte[] bArr, int i11, int i12) {
        System.arraycopy(this.zza, this.zzb, bArr, i11, i12);
        this.zzb += i12;
    }

    public final void zzC(int i11) {
        byte[] bArr = this.zza;
        if (bArr.length < i11) {
            bArr = new byte[i11];
        }
        zzD(bArr, i11);
    }

    public final void zzD(byte[] bArr, int i11) {
        this.zza = bArr;
        this.zzc = i11;
        this.zzb = 0;
    }

    public final void zzE(int i11) {
        boolean z11 = false;
        if (i11 >= 0 && i11 <= this.zza.length) {
            z11 = true;
        }
        zzdy.zzd(z11);
        this.zzc = i11;
    }

    public final void zzF(int i11) {
        boolean z11 = false;
        if (i11 >= 0 && i11 <= this.zzc) {
            z11 = true;
        }
        zzdy.zzd(z11);
        this.zzb = i11;
    }

    public final void zzG(int i11) {
        zzF(this.zzb + i11);
    }

    public final byte[] zzH() {
        return this.zza;
    }

    public final int zza() {
        return this.zzc - this.zzb;
    }

    public final int zzb() {
        return this.zza.length;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final int zze() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        int i13 = i12 + 1;
        byte b12 = bArr[i12];
        int i14 = i13 + 1;
        byte b13 = bArr[i13];
        this.zzb = i14 + 1;
        return (bArr[i14] & 255) | ((b11 & 255) << Ascii.CAN) | ((b12 & 255) << Ascii.DLE) | ((b13 & 255) << 8);
    }

    public final int zzf() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        int i13 = i12 + 1;
        byte b12 = bArr[i12];
        this.zzb = i13 + 1;
        return (bArr[i13] & 255) | (((b11 & 255) << Ascii.CAN) >> 8) | ((b12 & 255) << 8);
    }

    public final int zzg() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        int i13 = i12 + 1;
        byte b12 = bArr[i12];
        int i14 = i13 + 1;
        byte b13 = bArr[i13];
        this.zzb = i14 + 1;
        return ((bArr[i14] & 255) << Ascii.CAN) | (b11 & 255) | ((b12 & 255) << 8) | ((b13 & 255) << Ascii.DLE);
    }

    public final int zzh() {
        int zzg = zzg();
        if (zzg >= 0) {
            return zzg;
        }
        StringBuilder sb2 = new StringBuilder(29);
        sb2.append("Top bit not zero: ");
        sb2.append(zzg);
        throw new IllegalStateException(sb2.toString());
    }

    public final int zzi() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        this.zzb = i12 + 1;
        return ((bArr[i12] & 255) << 8) | (b11 & 255);
    }

    public final int zzj() {
        return (zzk() << 21) | (zzk() << 14) | (zzk() << 7) | zzk();
    }

    public final int zzk() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        this.zzb = i11 + 1;
        return bArr[i11] & 255;
    }

    public final int zzl() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        byte b12 = bArr[i12];
        this.zzb = i12 + 1 + 2;
        return (b12 & 255) | ((b11 & 255) << 8);
    }

    public final int zzm() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        int i13 = i12 + 1;
        byte b12 = bArr[i12];
        this.zzb = i13 + 1;
        return (bArr[i13] & 255) | ((b11 & 255) << Ascii.DLE) | ((b12 & 255) << 8);
    }

    public final int zzn() {
        int zze = zze();
        if (zze >= 0) {
            return zze;
        }
        StringBuilder sb2 = new StringBuilder(29);
        sb2.append("Top bit not zero: ");
        sb2.append(zze);
        throw new IllegalStateException(sb2.toString());
    }

    public final int zzo() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        this.zzb = i12 + 1;
        return (bArr[i12] & 255) | ((b11 & 255) << 8);
    }

    public final long zzp() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        int i13 = i12 + 1;
        byte b12 = bArr[i12];
        int i14 = i13 + 1;
        byte b13 = bArr[i13];
        int i15 = i14 + 1;
        byte b14 = bArr[i14];
        int i16 = i15 + 1;
        byte b15 = bArr[i15];
        int i17 = i16 + 1;
        byte b16 = bArr[i16];
        int i18 = i17 + 1;
        byte b17 = bArr[i17];
        this.zzb = i18 + 1;
        return ((((long) b12) & 255) << 8) | (((long) b11) & 255) | ((((long) b13) & 255) << 16) | ((((long) b14) & 255) << 24) | ((((long) b15) & 255) << 32) | ((((long) b16) & 255) << 40) | ((((long) b17) & 255) << 48) | ((((long) bArr[i18]) & 255) << 56);
    }

    public final long zzq() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        int i13 = i12 + 1;
        byte b12 = bArr[i12];
        int i14 = i13 + 1;
        byte b13 = bArr[i13];
        this.zzb = i14 + 1;
        return ((((long) b12) & 255) << 8) | (((long) b11) & 255) | ((((long) b13) & 255) << 16) | ((((long) bArr[i14]) & 255) << 24);
    }

    public final long zzr() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        int i13 = i12 + 1;
        byte b12 = bArr[i12];
        int i14 = i13 + 1;
        byte b13 = bArr[i13];
        int i15 = i14 + 1;
        byte b14 = bArr[i14];
        int i16 = i15 + 1;
        byte b15 = bArr[i15];
        int i17 = i16 + 1;
        byte b16 = bArr[i16];
        int i18 = i17 + 1;
        byte b17 = bArr[i17];
        this.zzb = i18 + 1;
        return ((((long) b12) & 255) << 48) | ((((long) b11) & 255) << 56) | ((((long) b13) & 255) << 40) | ((((long) b14) & 255) << 32) | ((((long) b15) & 255) << 24) | ((((long) b16) & 255) << 16) | ((((long) b17) & 255) << 8) | (((long) bArr[i18]) & 255);
    }

    public final long zzs() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        int i13 = i12 + 1;
        byte b12 = bArr[i12];
        int i14 = i13 + 1;
        byte b13 = bArr[i13];
        this.zzb = i14 + 1;
        return ((((long) b12) & 255) << 16) | ((((long) b11) & 255) << 24) | ((((long) b13) & 255) << 8) | (((long) bArr[i14]) & 255);
    }

    public final long zzt() {
        long zzr = zzr();
        if (zzr >= 0) {
            return zzr;
        }
        StringBuilder sb2 = new StringBuilder(38);
        sb2.append("Top bit not zero: ");
        sb2.append(zzr);
        throw new IllegalStateException(sb2.toString());
    }

    public final long zzu() {
        int i11;
        int i12;
        long j11 = (long) this.zza[this.zzb];
        int i13 = 7;
        while (true) {
            i11 = 0;
            i12 = 1;
            if (i13 < 0) {
                break;
            }
            int i14 = 1 << i13;
            if ((((long) i14) & j11) != 0) {
                i13--;
            } else if (i13 < 6) {
                j11 &= (long) (i14 - 1);
                i11 = 7 - i13;
            } else if (i13 == 7) {
                i11 = 1;
            }
        }
        if (i11 != 0) {
            while (i12 < i11) {
                byte b11 = this.zza[this.zzb + i12];
                if ((b11 & 192) == 128) {
                    j11 = (j11 << 6) | ((long) (b11 & Utf8.REPLACEMENT_BYTE));
                    i12++;
                } else {
                    StringBuilder sb2 = new StringBuilder(62);
                    sb2.append("Invalid UTF-8 sequence continuation byte: ");
                    sb2.append(j11);
                    throw new NumberFormatException(sb2.toString());
                }
            }
            this.zzb += i11;
            return j11;
        }
        StringBuilder sb3 = new StringBuilder(55);
        sb3.append("Invalid UTF-8 sequence first byte: ");
        sb3.append(j11);
        throw new NumberFormatException(sb3.toString());
    }

    @Nullable
    public final String zzv(char c11) {
        int i11 = this.zzc;
        int i12 = this.zzb;
        if (i11 - i12 == 0) {
            return null;
        }
        while (i12 < this.zzc && this.zza[i12] != 0) {
            i12++;
        }
        byte[] bArr = this.zza;
        int i13 = this.zzb;
        String zzE = zzfn.zzE(bArr, i13, i12 - i13);
        this.zzb = i12;
        if (i12 < this.zzc) {
            this.zzb = i12 + 1;
        }
        return zzE;
    }

    public final String zzw(int i11) {
        int i12;
        if (i11 == 0) {
            return "";
        }
        int i13 = this.zzb;
        int i14 = (i13 + i11) - 1;
        if (i14 >= this.zzc || this.zza[i14] != 0) {
            i12 = i11;
        } else {
            i12 = i11 - 1;
        }
        String zzE = zzfn.zzE(this.zza, i13, i12);
        this.zzb += i11;
        return zzE;
    }

    public final String zzx(int i11, Charset charset) {
        String str = new String(this.zza, this.zzb, i11, charset);
        this.zzb += i11;
        return str;
    }

    public final short zzy() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        this.zzb = i12 + 1;
        return (short) ((bArr[i12] & 255) | ((b11 & 255) << 8));
    }

    public final void zzz(int i11) {
        byte[] bArr = this.zza;
        if (i11 > bArr.length) {
            this.zza = Arrays.copyOf(bArr, i11);
        }
    }

    public zzfd(int i11) {
        this.zza = new byte[i11];
        this.zzc = i11;
    }

    public zzfd(byte[] bArr) {
        this.zza = bArr;
        this.zzc = bArr.length;
    }
}
