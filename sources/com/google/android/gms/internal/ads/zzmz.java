package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class zzmz implements zzlh {
    private int zzb;
    private float zzc = 1.0f;
    private float zzd = 1.0f;
    private zzlf zze;
    private zzlf zzf;
    private zzlf zzg;
    private zzlf zzh;
    private boolean zzi;
    @Nullable
    private zzmy zzj;
    private ByteBuffer zzk;
    private ShortBuffer zzl;
    private ByteBuffer zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;

    public zzmz() {
        zzlf zzlf = zzlf.zza;
        this.zze = zzlf;
        this.zzf = zzlf;
        this.zzg = zzlf;
        this.zzh = zzlf;
        ByteBuffer byteBuffer = zzlh.zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = byteBuffer;
        this.zzb = -1;
    }

    public final zzlf zza(zzlf zzlf) throws zzlg {
        if (zzlf.zzd == 2) {
            int i11 = this.zzb;
            if (i11 == -1) {
                i11 = zzlf.zzb;
            }
            this.zze = zzlf;
            zzlf zzlf2 = new zzlf(i11, zzlf.zzc, 2);
            this.zzf = zzlf2;
            this.zzi = true;
            return zzlf2;
        }
        throw new zzlg(zzlf);
    }

    public final ByteBuffer zzb() {
        int zza;
        zzmy zzmy = this.zzj;
        if (zzmy != null && (zza = zzmy.zza()) > 0) {
            if (this.zzk.capacity() < zza) {
                ByteBuffer order = ByteBuffer.allocateDirect(zza).order(ByteOrder.nativeOrder());
                this.zzk = order;
                this.zzl = order.asShortBuffer();
            } else {
                this.zzk.clear();
                this.zzl.clear();
            }
            zzmy.zzd(this.zzl);
            this.zzo += (long) zza;
            this.zzk.limit(zza);
            this.zzm = this.zzk;
        }
        ByteBuffer byteBuffer = this.zzm;
        this.zzm = zzlh.zza;
        return byteBuffer;
    }

    public final void zzc() {
        if (zzg()) {
            zzlf zzlf = this.zze;
            this.zzg = zzlf;
            zzlf zzlf2 = this.zzf;
            this.zzh = zzlf2;
            if (this.zzi) {
                this.zzj = new zzmy(zzlf.zzb, zzlf.zzc, this.zzc, this.zzd, zzlf2.zzb);
            } else {
                zzmy zzmy = this.zzj;
                if (zzmy != null) {
                    zzmy.zzc();
                }
            }
        }
        this.zzm = zzlh.zza;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = false;
    }

    public final void zzd() {
        zzmy zzmy = this.zzj;
        if (zzmy != null) {
            zzmy.zze();
        }
        this.zzp = true;
    }

    public final void zze(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            zzmy zzmy = this.zzj;
            zzmy.getClass();
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.zzn += (long) remaining;
            zzmy.zzf(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    public final void zzf() {
        this.zzc = 1.0f;
        this.zzd = 1.0f;
        zzlf zzlf = zzlf.zza;
        this.zze = zzlf;
        this.zzf = zzlf;
        this.zzg = zzlf;
        this.zzh = zzlf;
        ByteBuffer byteBuffer = zzlh.zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = byteBuffer;
        this.zzb = -1;
        this.zzi = false;
        this.zzj = null;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = false;
    }

    public final boolean zzg() {
        if (this.zzf.zzb == -1) {
            return false;
        }
        if (Math.abs(this.zzc - 4.0f) >= 1.0E-4f || Math.abs(this.zzd - 4.0f) >= 1.0E-4f) {
            return true;
        }
        if (this.zzf.zzb == this.zze.zzb) {
            return false;
        }
        return true;
    }

    public final boolean zzh() {
        if (!this.zzp) {
            return false;
        }
        zzmy zzmy = this.zzj;
        if (zzmy != null) {
            return zzmy.zza() == 0;
        }
        return true;
    }

    public final long zzi(long j11) {
        if (this.zzo < 1024) {
            return (long) (((double) this.zzc) * ((double) j11));
        }
        long j12 = this.zzn;
        zzmy zzmy = this.zzj;
        zzmy.getClass();
        long zzb2 = j12 - ((long) zzmy.zzb());
        int i11 = this.zzh.zzb;
        int i12 = this.zzg.zzb;
        if (i11 == i12) {
            return zzfn.zzt(j11, zzb2, this.zzo);
        }
        return zzfn.zzt(j11, zzb2 * ((long) i11), this.zzo * ((long) i12));
    }

    public final void zzj(float f11) {
        if (this.zzd != f11) {
            this.zzd = f11;
            this.zzi = true;
        }
    }

    public final void zzk(float f11) {
        if (this.zzc != f11) {
            this.zzc = f11;
            this.zzi = true;
        }
    }
}
