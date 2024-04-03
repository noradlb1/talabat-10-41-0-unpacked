package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class zzaqv implements zzapv {
    private int zzb = -1;
    private int zzc = -1;
    private zzaqu zzd;
    private float zze = 1.0f;
    private float zzf = 1.0f;
    private ByteBuffer zzg;
    private ShortBuffer zzh;
    private ByteBuffer zzi;
    private long zzj;
    private long zzk;
    private boolean zzl;

    public zzaqv() {
        ByteBuffer byteBuffer = zzapv.zza;
        this.zzg = byteBuffer;
        this.zzh = byteBuffer.asShortBuffer();
        this.zzi = byteBuffer;
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return 2;
    }

    public final ByteBuffer zzc() {
        ByteBuffer byteBuffer = this.zzi;
        this.zzi = zzapv.zza;
        return byteBuffer;
    }

    public final void zzd() {
        zzaqu zzaqu = new zzaqu(this.zzc, this.zzb);
        this.zzd = zzaqu;
        zzaqu.zzf(this.zze);
        this.zzd.zze(this.zzf);
        this.zzi = zzapv.zza;
        this.zzj = 0;
        this.zzk = 0;
        this.zzl = false;
    }

    public final void zze() {
        this.zzd.zzc();
        this.zzl = true;
    }

    public final void zzf(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.zzj += (long) remaining;
            this.zzd.zzd(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int zza = this.zzd.zza() * this.zzb;
        int i11 = zza + zza;
        if (i11 > 0) {
            if (this.zzg.capacity() < i11) {
                ByteBuffer order = ByteBuffer.allocateDirect(i11).order(ByteOrder.nativeOrder());
                this.zzg = order;
                this.zzh = order.asShortBuffer();
            } else {
                this.zzg.clear();
                this.zzh.clear();
            }
            this.zzd.zzb(this.zzh);
            this.zzk += (long) i11;
            this.zzg.limit(i11);
            this.zzi = this.zzg;
        }
    }

    public final void zzg() {
        this.zzd = null;
        ByteBuffer byteBuffer = zzapv.zza;
        this.zzg = byteBuffer;
        this.zzh = byteBuffer.asShortBuffer();
        this.zzi = byteBuffer;
        this.zzb = -1;
        this.zzc = -1;
        this.zzj = 0;
        this.zzk = 0;
        this.zzl = false;
    }

    public final boolean zzh(int i11, int i12, int i13) throws zzapu {
        if (i13 != 2) {
            throw new zzapu(i11, i12, i13);
        } else if (this.zzc == i11 && this.zzb == i12) {
            return false;
        } else {
            this.zzc = i11;
            this.zzb = i12;
            return true;
        }
    }

    public final boolean zzi() {
        return Math.abs(this.zze + -1.0f) >= 0.01f || Math.abs(this.zzf + -1.0f) >= 0.01f;
    }

    public final boolean zzj() {
        if (!this.zzl) {
            return false;
        }
        zzaqu zzaqu = this.zzd;
        if (zzaqu != null) {
            return zzaqu.zza() == 0;
        }
        return true;
    }

    public final float zzk(float f11) {
        this.zzf = zzaxb.zza(1.0f, 0.1f, 8.0f);
        return 1.0f;
    }

    public final float zzl(float f11) {
        float zza = zzaxb.zza(f11, 0.1f, 8.0f);
        this.zze = zza;
        return zza;
    }

    public final long zzm() {
        return this.zzj;
    }

    public final long zzn() {
        return this.zzk;
    }
}
