package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

final class zzaxl implements Choreographer.FrameCallback, Handler.Callback {
    private static final zzaxl zzb = new zzaxl();
    public volatile long zza;
    private final Handler zzc;
    private final HandlerThread zzd;
    private Choreographer zze;
    private int zzf;

    private zzaxl() {
        HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
        this.zzd = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.zzc = handler;
        handler.sendEmptyMessage(0);
    }

    public static zzaxl zza() {
        return zzb;
    }

    public final void doFrame(long j11) {
        this.zza = j11;
        this.zze.postFrameCallbackDelayed(this, 500);
    }

    public final boolean handleMessage(Message message) {
        int i11 = message.what;
        if (i11 == 0) {
            this.zze = Choreographer.getInstance();
            return true;
        } else if (i11 == 1) {
            int i12 = this.zzf + 1;
            this.zzf = i12;
            if (i12 == 1) {
                this.zze.postFrameCallback(this);
            }
            return true;
        } else if (i11 != 2) {
            return false;
        } else {
            int i13 = this.zzf - 1;
            this.zzf = i13;
            if (i13 == 0) {
                this.zze.removeFrameCallback(this);
                this.zza = 0;
            }
            return true;
        }
    }

    public final void zzb() {
        this.zzc.sendEmptyMessage(1);
    }

    public final void zzc() {
        this.zzc.sendEmptyMessage(2);
    }
}
