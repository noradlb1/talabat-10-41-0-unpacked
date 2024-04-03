package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayDeque;

@RequiresApi(23)
final class zzny extends MediaCodec.Callback {
    private final Object zza = new Object();
    private final HandlerThread zzb;
    private Handler zzc;
    @GuardedBy("lock")
    private final zzoc zzd;
    @GuardedBy("lock")
    private final zzoc zze;
    @GuardedBy("lock")
    private final ArrayDeque<MediaCodec.BufferInfo> zzf;
    @GuardedBy("lock")
    private final ArrayDeque<MediaFormat> zzg;
    @GuardedBy("lock")
    @Nullable
    private MediaFormat zzh;
    @GuardedBy("lock")
    @Nullable
    private MediaFormat zzi;
    @GuardedBy("lock")
    @Nullable
    private MediaCodec.CodecException zzj;
    @GuardedBy("lock")
    private long zzk;
    @GuardedBy("lock")
    private boolean zzl;
    @GuardedBy("lock")
    @Nullable
    private IllegalStateException zzm;

    public zzny(HandlerThread handlerThread) {
        this.zzb = handlerThread;
        this.zzd = new zzoc();
        this.zze = new zzoc();
        this.zzf = new ArrayDeque<>();
        this.zzg = new ArrayDeque<>();
    }

    @GuardedBy("lock")
    private final void zzh(MediaFormat mediaFormat) {
        this.zze.zzb(-2);
        this.zzg.add(mediaFormat);
    }

    @GuardedBy("lock")
    private final void zzi() {
        if (!this.zzg.isEmpty()) {
            this.zzi = this.zzg.getLast();
        }
        this.zzd.zzc();
        this.zze.zzc();
        this.zzf.clear();
        this.zzg.clear();
        this.zzj = null;
    }

    @GuardedBy("lock")
    private final void zzj() {
        IllegalStateException illegalStateException = this.zzm;
        if (illegalStateException != null) {
            this.zzm = null;
            throw illegalStateException;
        }
    }

    @GuardedBy("lock")
    private final void zzk() {
        MediaCodec.CodecException codecException = this.zzj;
        if (codecException != null) {
            this.zzj = null;
            throw codecException;
        }
    }

    private final void zzl(IllegalStateException illegalStateException) {
        synchronized (this.zza) {
            this.zzm = illegalStateException;
        }
    }

    @GuardedBy("lock")
    private final boolean zzm() {
        return this.zzk > 0 || this.zzl;
    }

    public final void onError(@NonNull MediaCodec mediaCodec, @NonNull MediaCodec.CodecException codecException) {
        synchronized (this.zza) {
            this.zzj = codecException;
        }
    }

    public final void onInputBufferAvailable(@NonNull MediaCodec mediaCodec, int i11) {
        synchronized (this.zza) {
            this.zzd.zzb(i11);
        }
    }

    public final void onOutputBufferAvailable(@NonNull MediaCodec mediaCodec, int i11, @NonNull MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.zza) {
            MediaFormat mediaFormat = this.zzi;
            if (mediaFormat != null) {
                zzh(mediaFormat);
                this.zzi = null;
            }
            this.zze.zzb(i11);
            this.zzf.add(bufferInfo);
        }
    }

    public final void onOutputFormatChanged(@NonNull MediaCodec mediaCodec, @NonNull MediaFormat mediaFormat) {
        synchronized (this.zza) {
            zzh(mediaFormat);
            this.zzi = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zza
            monitor-enter(r0)
            boolean r1 = r3.zzm()     // Catch:{ all -> 0x0023 }
            r2 = -1
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return r2
        L_0x000c:
            r3.zzj()     // Catch:{ all -> 0x0023 }
            r3.zzk()     // Catch:{ all -> 0x0023 }
            com.google.android.gms.internal.ads.zzoc r1 = r3.zzd     // Catch:{ all -> 0x0023 }
            boolean r1 = r1.zzd()     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x001b
            goto L_0x0021
        L_0x001b:
            com.google.android.gms.internal.ads.zzoc r1 = r3.zzd     // Catch:{ all -> 0x0023 }
            int r2 = r1.zza()     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return r2
        L_0x0023:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzny.zza():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004d, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(android.media.MediaCodec.BufferInfo r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.zza
            monitor-enter(r0)
            boolean r1 = r9.zzm()     // Catch:{ all -> 0x004e }
            r2 = -1
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            return r2
        L_0x000c:
            r9.zzj()     // Catch:{ all -> 0x004e }
            r9.zzk()     // Catch:{ all -> 0x004e }
            com.google.android.gms.internal.ads.zzoc r1 = r9.zze     // Catch:{ all -> 0x004e }
            boolean r1 = r1.zzd()     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x001c
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            return r2
        L_0x001c:
            com.google.android.gms.internal.ads.zzoc r1 = r9.zze     // Catch:{ all -> 0x004e }
            int r1 = r1.zza()     // Catch:{ all -> 0x004e }
            if (r1 < 0) goto L_0x003e
            android.media.MediaFormat r2 = r9.zzh     // Catch:{ all -> 0x004e }
            com.google.android.gms.internal.ads.zzdy.zzb(r2)     // Catch:{ all -> 0x004e }
            java.util.ArrayDeque<android.media.MediaCodec$BufferInfo> r2 = r9.zzf     // Catch:{ all -> 0x004e }
            java.lang.Object r2 = r2.remove()     // Catch:{ all -> 0x004e }
            android.media.MediaCodec$BufferInfo r2 = (android.media.MediaCodec.BufferInfo) r2     // Catch:{ all -> 0x004e }
            int r4 = r2.offset     // Catch:{ all -> 0x004e }
            int r5 = r2.size     // Catch:{ all -> 0x004e }
            long r6 = r2.presentationTimeUs     // Catch:{ all -> 0x004e }
            int r8 = r2.flags     // Catch:{ all -> 0x004e }
            r3 = r10
            r3.set(r4, r5, r6, r8)     // Catch:{ all -> 0x004e }
            goto L_0x004c
        L_0x003e:
            r10 = -2
            if (r1 != r10) goto L_0x004c
            java.util.ArrayDeque<android.media.MediaFormat> r1 = r9.zzg     // Catch:{ all -> 0x004e }
            java.lang.Object r1 = r1.remove()     // Catch:{ all -> 0x004e }
            android.media.MediaFormat r1 = (android.media.MediaFormat) r1     // Catch:{ all -> 0x004e }
            r9.zzh = r1     // Catch:{ all -> 0x004e }
            r1 = r10
        L_0x004c:
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            return r1
        L_0x004e:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzny.zzb(android.media.MediaCodec$BufferInfo):int");
    }

    public final MediaFormat zzc() {
        MediaFormat mediaFormat;
        synchronized (this.zza) {
            mediaFormat = this.zzh;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public final void zzd(Runnable runnable) {
        synchronized (this.zza) {
            this.zzk++;
            Handler handler = this.zzc;
            int i11 = zzfn.zza;
            handler.post(new zznx(this, runnable));
        }
    }

    public final void zze(MediaCodec mediaCodec) {
        boolean z11;
        if (this.zzc == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzf(z11);
        this.zzb.start();
        Handler handler = new Handler(this.zzb.getLooper());
        mediaCodec.setCallback(this, handler);
        this.zzc = handler;
    }

    public final /* synthetic */ void zzf(Runnable runnable) {
        synchronized (this.zza) {
            if (!this.zzl) {
                long j11 = this.zzk - 1;
                this.zzk = j11;
                int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
                if (i11 <= 0) {
                    if (i11 < 0) {
                        zzl(new IllegalStateException());
                    } else {
                        zzi();
                        try {
                            ((zzno) runnable).zza.start();
                        } catch (IllegalStateException e11) {
                            zzl(e11);
                        } catch (Exception e12) {
                            zzl(new IllegalStateException(e12));
                        }
                    }
                }
            }
        }
    }

    public final void zzg() {
        synchronized (this.zza) {
            this.zzl = true;
            this.zzb.quit();
            zzi();
        }
    }
}
