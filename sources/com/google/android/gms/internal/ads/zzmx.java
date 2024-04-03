package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import java.nio.ByteBuffer;

public final class zzmx extends zzme {
    private int zzd;
    private boolean zze;
    private byte[] zzf;
    private byte[] zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;
    private long zzl;

    public zzmx() {
        byte[] bArr = zzfn.zzf;
        this.zzf = bArr;
        this.zzg = bArr;
    }

    private final int zzq(long j11) {
        return (int) ((j11 * ((long) this.zzb.zzb)) / 1000000);
    }

    private final int zzr(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position(); position < byteBuffer.limit(); position += 2) {
            if (Math.abs(byteBuffer.getShort(position)) > 1024) {
                int i11 = this.zzd;
                return i11 * (position / i11);
            }
        }
        return byteBuffer.limit();
    }

    private final void zzs(byte[] bArr, int i11) {
        zzj(i11).put(bArr, 0, i11).flip();
        if (i11 > 0) {
            this.zzk = true;
        }
    }

    private final void zzt(ByteBuffer byteBuffer, byte[] bArr, int i11) {
        int min = Math.min(byteBuffer.remaining(), this.zzj);
        int i12 = this.zzj - min;
        System.arraycopy(bArr, i11 - i12, this.zzg, 0, i12);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.zzg, i12, min);
    }

    public final void zze(ByteBuffer byteBuffer) {
        int position;
        while (byteBuffer.hasRemaining() && !zzn()) {
            int i11 = this.zzh;
            if (i11 == 0) {
                int limit = byteBuffer.limit();
                byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.zzf.length));
                int limit2 = byteBuffer.limit();
                while (true) {
                    limit2 -= 2;
                    if (limit2 >= byteBuffer.position()) {
                        if (Math.abs(byteBuffer.getShort(limit2)) > 1024) {
                            int i12 = this.zzd;
                            position = ((limit2 / i12) * i12) + i12;
                            break;
                        }
                    } else {
                        position = byteBuffer.position();
                        break;
                    }
                }
                if (position == byteBuffer.position()) {
                    this.zzh = 1;
                } else {
                    byteBuffer.limit(position);
                    int remaining = byteBuffer.remaining();
                    zzj(remaining).put(byteBuffer).flip();
                    if (remaining > 0) {
                        this.zzk = true;
                    }
                }
                byteBuffer.limit(limit);
            } else if (i11 != 1) {
                int limit3 = byteBuffer.limit();
                int zzr = zzr(byteBuffer);
                byteBuffer.limit(zzr);
                this.zzl += (long) (byteBuffer.remaining() / this.zzd);
                zzt(byteBuffer, this.zzg, this.zzj);
                if (zzr < limit3) {
                    zzs(this.zzg, this.zzj);
                    this.zzh = 0;
                    byteBuffer.limit(limit3);
                }
            } else {
                int limit4 = byteBuffer.limit();
                int zzr2 = zzr(byteBuffer);
                int position2 = zzr2 - byteBuffer.position();
                byte[] bArr = this.zzf;
                int length = bArr.length;
                int i13 = this.zzi;
                int i14 = length - i13;
                if (zzr2 >= limit4 || position2 >= i14) {
                    int min = Math.min(position2, i14);
                    byteBuffer.limit(byteBuffer.position() + min);
                    byteBuffer.get(this.zzf, this.zzi, min);
                    int i15 = this.zzi + min;
                    this.zzi = i15;
                    byte[] bArr2 = this.zzf;
                    if (i15 == bArr2.length) {
                        if (this.zzk) {
                            zzs(bArr2, this.zzj);
                            long j11 = this.zzl;
                            int i16 = this.zzi;
                            int i17 = this.zzj;
                            this.zzl = j11 + ((long) ((i16 - (i17 + i17)) / this.zzd));
                            i15 = i16;
                        } else {
                            this.zzl += (long) ((i15 - this.zzj) / this.zzd);
                        }
                        zzt(byteBuffer, this.zzf, i15);
                        this.zzi = 0;
                        this.zzh = 2;
                    }
                    byteBuffer.limit(limit4);
                } else {
                    zzs(bArr, i13);
                    this.zzi = 0;
                    this.zzh = 0;
                }
            }
        }
    }

    public final boolean zzg() {
        return this.zze;
    }

    public final zzlf zzi(zzlf zzlf) throws zzlg {
        if (zzlf.zzd != 2) {
            throw new zzlg(zzlf);
        } else if (this.zze) {
            return zzlf;
        } else {
            return zzlf.zza;
        }
    }

    public final void zzk() {
        if (this.zze) {
            this.zzd = this.zzb.zze;
            int zzq = zzq(SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) * this.zzd;
            if (this.zzf.length != zzq) {
                this.zzf = new byte[zzq];
            }
            int zzq2 = zzq(20000) * this.zzd;
            this.zzj = zzq2;
            if (this.zzg.length != zzq2) {
                this.zzg = new byte[zzq2];
            }
        }
        this.zzh = 0;
        this.zzl = 0;
        this.zzi = 0;
        this.zzk = false;
    }

    public final void zzl() {
        int i11 = this.zzi;
        if (i11 > 0) {
            zzs(this.zzf, i11);
        }
        if (!this.zzk) {
            this.zzl += (long) (this.zzj / this.zzd);
        }
    }

    public final void zzm() {
        this.zze = false;
        this.zzj = 0;
        byte[] bArr = zzfn.zzf;
        this.zzf = bArr;
        this.zzg = bArr;
    }

    public final long zzo() {
        return this.zzl;
    }

    public final void zzp(boolean z11) {
        this.zze = z11;
    }
}
