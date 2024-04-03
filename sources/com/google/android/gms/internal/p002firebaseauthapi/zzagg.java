package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagg  reason: invalid package */
final class zzagg extends zzagd {
    private final OutputStream zzg;

    public zzagg(OutputStream outputStream, int i11) {
        super(i11);
        this.zzg = outputStream;
    }

    private final void zzG() throws IOException {
        this.zzg.write(this.zza, 0, this.zzc);
        this.zzc = 0;
    }

    private final void zzH(int i11) throws IOException {
        if (this.zzb - this.zzc < i11) {
            zzG();
        }
    }

    public final void zzI() throws IOException {
        if (this.zzc > 0) {
            zzG();
        }
    }

    public final void zzJ(byte b11) throws IOException {
        if (this.zzc == this.zzb) {
            zzG();
        }
        zzc(b11);
    }

    public final void zzK(int i11, boolean z11) throws IOException {
        zzH(11);
        zzf(i11 << 3);
        zzc(z11 ? (byte) 1 : 0);
    }

    public final void zzL(int i11, zzafv zzafv) throws IOException {
        zzs((i11 << 3) | 2);
        zzs(zzafv.zzd());
        zzafv.zzj(this);
    }

    public final void zza(byte[] bArr, int i11, int i12) throws IOException {
        zzp(bArr, 0, i12);
    }

    public final void zzh(int i11, int i12) throws IOException {
        zzH(14);
        zzf((i11 << 3) | 5);
        zzd(i12);
    }

    public final void zzi(int i11) throws IOException {
        zzH(4);
        zzd(i11);
    }

    public final void zzj(int i11, long j11) throws IOException {
        zzH(18);
        zzf((i11 << 3) | 1);
        zze(j11);
    }

    public final void zzk(long j11) throws IOException {
        zzH(8);
        zze(j11);
    }

    public final void zzl(int i11, int i12) throws IOException {
        zzH(20);
        zzf(i11 << 3);
        if (i12 >= 0) {
            zzf(i12);
        } else {
            zzg((long) i12);
        }
    }

    public final void zzm(int i11) throws IOException {
        if (i11 >= 0) {
            zzs(i11);
        } else {
            zzu((long) i11);
        }
    }

    public final void zzn(int i11, zzaif zzaif, zzair zzair) throws IOException {
        zzs((i11 << 3) | 2);
        zzs(((zzaff) zzaif).zzn(zzair));
        zzair.zzm(zzaif, this.zze);
    }

    public final void zzo(int i11, String str) throws IOException {
        zzs((i11 << 3) | 2);
        zzv(str);
    }

    public final void zzp(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = this.zzb;
        int i14 = this.zzc;
        int i15 = i13 - i14;
        if (i15 >= i12) {
            System.arraycopy(bArr, 0, this.zza, i14, i12);
            this.zzc += i12;
            this.zzd += i12;
            return;
        }
        System.arraycopy(bArr, 0, this.zza, i14, i15);
        this.zzc = this.zzb;
        this.zzd += i15;
        zzG();
        int i16 = i12 - i15;
        if (i16 <= this.zzb) {
            System.arraycopy(bArr, i15, this.zza, 0, i16);
            this.zzc = i16;
        } else {
            this.zzg.write(bArr, i15, i16);
        }
        this.zzd += i16;
    }

    public final void zzq(int i11, int i12) throws IOException {
        zzs((i11 << 3) | i12);
    }

    public final void zzr(int i11, int i12) throws IOException {
        zzH(20);
        zzf(i11 << 3);
        zzf(i12);
    }

    public final void zzs(int i11) throws IOException {
        zzH(5);
        zzf(i11);
    }

    public final void zzt(int i11, long j11) throws IOException {
        zzH(20);
        zzf(i11 << 3);
        zzg(j11);
    }

    public final void zzu(long j11) throws IOException {
        zzH(10);
        zzg(j11);
    }

    public final void zzv(String str) throws IOException {
        int i11;
        int i12;
        try {
            int length = str.length() * 3;
            int zzA = zzagi.zzA(length);
            int i13 = zzA + length;
            int i14 = this.zzb;
            if (i13 > i14) {
                byte[] bArr = new byte[length];
                int zzb = zzaka.zzb(str, bArr, 0, length);
                zzs(zzb);
                zzp(bArr, 0, zzb);
                return;
            }
            if (i13 > i14 - this.zzc) {
                zzG();
            }
            int zzA2 = zzagi.zzA(str.length());
            i11 = this.zzc;
            if (zzA2 == zzA) {
                int i15 = i11 + zzA2;
                this.zzc = i15;
                int zzb2 = zzaka.zzb(str, this.zza, i15, this.zzb - i15);
                this.zzc = i11;
                i12 = (zzb2 - i11) - zzA2;
                zzf(i12);
                this.zzc = zzb2;
            } else {
                i12 = zzaka.zzc(str);
                zzf(i12);
                this.zzc = zzaka.zzb(str, this.zza, this.zzc, i12);
            }
            this.zzd += i12;
        } catch (zzajz e11) {
            this.zzd -= this.zzc - i11;
            this.zzc = i11;
            throw e11;
        } catch (ArrayIndexOutOfBoundsException e12) {
            throw new zzagf(e12);
        } catch (zzajz e13) {
            zzE(str, e13);
        }
    }
}
