package com.google.android.gms.internal.ads;

import androidx.annotation.CallSuper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class zzme implements zzlh {
    protected zzlf zzb;
    protected zzlf zzc;
    private zzlf zzd;
    private zzlf zze;
    private ByteBuffer zzf;
    private ByteBuffer zzg;
    private boolean zzh;

    public zzme() {
        ByteBuffer byteBuffer = zzlh.zza;
        this.zzf = byteBuffer;
        this.zzg = byteBuffer;
        zzlf zzlf = zzlf.zza;
        this.zzd = zzlf;
        this.zze = zzlf;
        this.zzb = zzlf;
        this.zzc = zzlf;
    }

    public final zzlf zza(zzlf zzlf) throws zzlg {
        this.zzd = zzlf;
        this.zze = zzi(zzlf);
        if (zzg()) {
            return this.zze;
        }
        return zzlf.zza;
    }

    @CallSuper
    public ByteBuffer zzb() {
        ByteBuffer byteBuffer = this.zzg;
        this.zzg = zzlh.zza;
        return byteBuffer;
    }

    public final void zzc() {
        this.zzg = zzlh.zza;
        this.zzh = false;
        this.zzb = this.zzd;
        this.zzc = this.zze;
        zzk();
    }

    public final void zzd() {
        this.zzh = true;
        zzl();
    }

    public final void zzf() {
        zzc();
        this.zzf = zzlh.zza;
        zzlf zzlf = zzlf.zza;
        this.zzd = zzlf;
        this.zze = zzlf;
        this.zzb = zzlf;
        this.zzc = zzlf;
        zzm();
    }

    public boolean zzg() {
        return this.zze != zzlf.zza;
    }

    @CallSuper
    public boolean zzh() {
        return this.zzh && this.zzg == zzlh.zza;
    }

    public zzlf zzi(zzlf zzlf) throws zzlg {
        throw null;
    }

    public final ByteBuffer zzj(int i11) {
        if (this.zzf.capacity() < i11) {
            this.zzf = ByteBuffer.allocateDirect(i11).order(ByteOrder.nativeOrder());
        } else {
            this.zzf.clear();
        }
        ByteBuffer byteBuffer = this.zzf;
        this.zzg = byteBuffer;
        return byteBuffer;
    }

    public void zzk() {
    }

    public void zzl() {
    }

    public void zzm() {
    }

    public final boolean zzn() {
        return this.zzg.hasRemaining();
    }
}
