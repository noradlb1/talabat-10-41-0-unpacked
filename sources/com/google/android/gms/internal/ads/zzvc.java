package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import com.google.android.exoplayer2.C;

final class zzvc implements Choreographer.FrameCallback, Handler.Callback {
    private static final zzvc zzb = new zzvc();
    public volatile long zza = C.TIME_UNSET;
    private final Handler zzc;
    private final HandlerThread zzd;
    private Choreographer zze;
    private int zzf;

    private zzvc() {
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
        this.zzd = handlerThread;
        handlerThread.start();
        Handler zzy = zzfn.zzy(handlerThread.getLooper(), this);
        this.zzc = zzy;
        zzy.sendEmptyMessage(0);
    }

    public static zzvc zza() {
        return zzb;
    }

    public final void doFrame(long j11) {
        this.zza = j11;
        Choreographer choreographer = this.zze;
        choreographer.getClass();
        choreographer.postFrameCallbackDelayed(this, 500);
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
                Choreographer choreographer = this.zze;
                choreographer.getClass();
                choreographer.postFrameCallback(this);
            }
            return true;
        } else if (i11 != 2) {
            return false;
        } else {
            int i13 = this.zzf - 1;
            this.zzf = i13;
            if (i13 == 0) {
                Choreographer choreographer2 = this.zze;
                choreographer2.getClass();
                choreographer2.removeFrameCallback(this);
                this.zza = C.TIME_UNSET;
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
