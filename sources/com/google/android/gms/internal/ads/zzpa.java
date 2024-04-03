package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

public final class zzpa implements zzof {
    private final MediaCodec zza;
    @Nullable
    private ByteBuffer[] zzb;
    @Nullable
    private ByteBuffer[] zzc;

    public /* synthetic */ zzpa(MediaCodec mediaCodec, Surface surface, zzoz zzoz) {
        this.zza = mediaCodec;
        if (zzfn.zza < 21) {
            this.zzb = mediaCodec.getInputBuffers();
            this.zzc = mediaCodec.getOutputBuffers();
        }
    }

    public final int zza() {
        return this.zza.dequeueInputBuffer(0);
    }

    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.zza.dequeueOutputBuffer(bufferInfo, 0);
            if (dequeueOutputBuffer == -3) {
                if (zzfn.zza < 21) {
                    this.zzc = this.zza.getOutputBuffers();
                }
                dequeueOutputBuffer = -3;
                continue;
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    public final MediaFormat zzc() {
        return this.zza.getOutputFormat();
    }

    @Nullable
    public final ByteBuffer zzf(int i11) {
        if (zzfn.zza >= 21) {
            return this.zza.getInputBuffer(i11);
        }
        return ((ByteBuffer[]) zzfn.zzC(this.zzb))[i11];
    }

    @Nullable
    public final ByteBuffer zzg(int i11) {
        if (zzfn.zza >= 21) {
            return this.zza.getOutputBuffer(i11);
        }
        return ((ByteBuffer[]) zzfn.zzC(this.zzc))[i11];
    }

    public final void zzi() {
        this.zza.flush();
    }

    public final void zzj(int i11, int i12, int i13, long j11, int i14) {
        this.zza.queueInputBuffer(i11, 0, i13, j11, i14);
    }

    public final void zzk(int i11, int i12, zzcx zzcx, long j11, int i13) {
        this.zza.queueSecureInputBuffer(i11, 0, zzcx.zza(), j11, 0);
    }

    public final void zzl() {
        this.zzb = null;
        this.zzc = null;
        this.zza.release();
    }

    @RequiresApi(21)
    public final void zzm(int i11, long j11) {
        this.zza.releaseOutputBuffer(i11, j11);
    }

    public final void zzn(int i11, boolean z11) {
        this.zza.releaseOutputBuffer(i11, z11);
    }

    @RequiresApi(23)
    public final void zzo(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

    @RequiresApi(19)
    public final void zzp(Bundle bundle) {
        this.zza.setParameters(bundle);
    }

    public final void zzq(int i11) {
        this.zza.setVideoScalingMode(i11);
    }

    public final boolean zzr() {
        return false;
    }
}
