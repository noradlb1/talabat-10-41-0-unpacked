package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

final class zzna extends zzme {
    private int zzd;
    private int zze;
    private boolean zzf;
    private int zzg;
    private byte[] zzh = zzfn.zzf;
    private int zzi;
    private long zzj;

    public final ByteBuffer zzb() {
        int i11;
        if (super.zzh() && (i11 = this.zzi) > 0) {
            zzj(i11).put(this.zzh, 0, this.zzi).flip();
            this.zzi = 0;
        }
        return super.zzb();
    }

    public final void zze(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i11 = limit - position;
        if (i11 != 0) {
            int min = Math.min(i11, this.zzg);
            this.zzj += (long) (min / this.zzb.zze);
            this.zzg -= min;
            byteBuffer.position(position + min);
            if (this.zzg <= 0) {
                int i12 = i11 - min;
                int length = (this.zzi + i12) - this.zzh.length;
                ByteBuffer zzj2 = zzj(length);
                int zzf2 = zzfn.zzf(length, 0, this.zzi);
                zzj2.put(this.zzh, 0, zzf2);
                int zzf3 = zzfn.zzf(length - zzf2, 0, i12);
                byteBuffer.limit(byteBuffer.position() + zzf3);
                zzj2.put(byteBuffer);
                byteBuffer.limit(limit);
                int i13 = i12 - zzf3;
                int i14 = this.zzi - zzf2;
                this.zzi = i14;
                byte[] bArr = this.zzh;
                System.arraycopy(bArr, zzf2, bArr, 0, i14);
                byteBuffer.get(this.zzh, this.zzi, i13);
                this.zzi += i13;
                zzj2.flip();
            }
        }
    }

    public final boolean zzh() {
        return super.zzh() && this.zzi == 0;
    }

    public final zzlf zzi(zzlf zzlf) throws zzlg {
        if (zzlf.zzd == 2) {
            this.zzf = true;
            if (this.zzd == 0 && this.zze == 0) {
                return zzlf.zza;
            }
            return zzlf;
        }
        throw new zzlg(zzlf);
    }

    public final void zzk() {
        if (this.zzf) {
            this.zzf = false;
            int i11 = this.zze;
            int i12 = this.zzb.zze;
            this.zzh = new byte[(i11 * i12)];
            this.zzg = this.zzd * i12;
        }
        this.zzi = 0;
    }

    public final void zzl() {
        if (this.zzf) {
            int i11 = this.zzi;
            if (i11 > 0) {
                this.zzj += (long) (i11 / this.zzb.zze);
            }
            this.zzi = 0;
        }
    }

    public final void zzm() {
        this.zzh = zzfn.zzf;
    }

    public final long zzo() {
        return this.zzj;
    }

    public final void zzp() {
        this.zzj = 0;
    }

    public final void zzq(int i11, int i12) {
        this.zzd = i11;
        this.zze = i12;
    }
}
