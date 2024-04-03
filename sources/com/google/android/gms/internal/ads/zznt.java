package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

@RequiresApi(23)
final class zznt implements zzof {
    private final MediaCodec zza;
    private final zzny zzb;
    private final zznw zzc;
    private boolean zzd;
    private int zze = 0;

    public /* synthetic */ zznt(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z11, zzns zzns) {
        this.zza = mediaCodec;
        this.zzb = new zzny(handlerThread);
        this.zzc = new zznw(mediaCodec, handlerThread2);
    }

    public static /* bridge */ /* synthetic */ void zzh(zznt zznt, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i11, boolean z11) {
        zznt.zzb.zze(zznt.zza);
        zzfl.zza("configureCodec");
        zznt.zza.configure(mediaFormat, surface, (MediaCrypto) null, 0);
        zzfl.zzb();
        zznt.zzc.zzf();
        zzfl.zza("startCodec");
        zznt.zza.start();
        zzfl.zzb();
        zznt.zze = 1;
    }

    /* access modifiers changed from: private */
    public static String zzs(int i11, String str) {
        StringBuilder sb2 = new StringBuilder(str);
        if (i11 == 1) {
            sb2.append("Audio");
        } else if (i11 == 2) {
            sb2.append("Video");
        } else {
            sb2.append("Unknown(");
            sb2.append(i11);
            sb2.append(")");
        }
        return sb2.toString();
    }

    public final int zza() {
        return this.zzb.zza();
    }

    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        return this.zzb.zzb(bufferInfo);
    }

    public final MediaFormat zzc() {
        return this.zzb.zzc();
    }

    @Nullable
    public final ByteBuffer zzf(int i11) {
        return this.zza.getInputBuffer(i11);
    }

    @Nullable
    public final ByteBuffer zzg(int i11) {
        return this.zza.getOutputBuffer(i11);
    }

    public final void zzi() {
        this.zzc.zzb();
        this.zza.flush();
        zzny zzny = this.zzb;
        MediaCodec mediaCodec = this.zza;
        mediaCodec.getClass();
        zzny.zzd(new zzno(mediaCodec));
    }

    public final void zzj(int i11, int i12, int i13, long j11, int i14) {
        this.zzc.zzc(i11, 0, i13, j11, i14);
    }

    public final void zzk(int i11, int i12, zzcx zzcx, long j11, int i13) {
        this.zzc.zzd(i11, 0, zzcx, j11, 0);
    }

    public final void zzl() {
        try {
            if (this.zze == 1) {
                this.zzc.zze();
                this.zzb.zzg();
            }
            this.zze = 2;
            if (!this.zzd) {
                this.zza.release();
                this.zzd = true;
            }
        } catch (Throwable th2) {
            if (!this.zzd) {
                this.zza.release();
                this.zzd = true;
            }
            throw th2;
        }
    }

    public final void zzm(int i11, long j11) {
        this.zza.releaseOutputBuffer(i11, j11);
    }

    public final void zzn(int i11, boolean z11) {
        this.zza.releaseOutputBuffer(i11, z11);
    }

    public final void zzo(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

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
