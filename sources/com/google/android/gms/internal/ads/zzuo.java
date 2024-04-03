package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.Nullable;

final class zzuo extends HandlerThread implements Handler.Callback {
    private zzeg zza;
    private Handler zzb;
    @Nullable
    private Error zzc;
    @Nullable
    private RuntimeException zzd;
    @Nullable
    private zzuq zze;

    public zzuo() {
        super("ExoPlayer:DummySurface");
    }

    public final boolean handleMessage(Message message) {
        boolean z11;
        int i11 = message.what;
        if (i11 == 1) {
            try {
                int i12 = message.arg1;
                zzeg zzeg = this.zza;
                zzeg.getClass();
                zzeg.zzb(i12);
                SurfaceTexture zza2 = this.zza.zza();
                if (i12 != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                this.zze = new zzuq(this, zza2, z11, (zzup) null);
                synchronized (this) {
                    notify();
                }
            } catch (RuntimeException e11) {
                zzep.zza("DummySurface", "Failed to initialize dummy surface", e11);
                this.zzd = e11;
                synchronized (this) {
                    notify();
                }
            } catch (Error e12) {
                try {
                    zzep.zza("DummySurface", "Failed to initialize dummy surface", e12);
                    this.zzc = e12;
                    synchronized (this) {
                        notify();
                    }
                } catch (Throwable th2) {
                    synchronized (this) {
                        notify();
                        throw th2;
                    }
                }
            }
            return true;
        } else if (i11 != 2) {
            return true;
        } else {
            try {
                zzeg zzeg2 = this.zza;
                zzeg2.getClass();
                zzeg2.zzc();
            } catch (Throwable th3) {
                quit();
                throw th3;
            }
            quit();
            return true;
        }
    }

    public final zzuq zza(int i11) {
        boolean z11;
        start();
        this.zzb = new Handler(getLooper(), this);
        this.zza = new zzeg(this.zzb, (zzef) null);
        synchronized (this) {
            z11 = false;
            this.zzb.obtainMessage(1, i11, 0).sendToTarget();
            while (this.zze == null && this.zzd == null && this.zzc == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z11 = true;
                }
            }
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zzd;
        if (runtimeException == null) {
            Error error = this.zzc;
            if (error == null) {
                zzuq zzuq = this.zze;
                zzuq.getClass();
                return zzuq;
            }
            throw error;
        }
        throw runtimeException;
    }

    public final void zzb() {
        Handler handler = this.zzb;
        handler.getClass();
        handler.sendEmptyMessage(2);
    }
}
