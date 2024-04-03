package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

@RequiresApi(23)
final class zznw {
    @GuardedBy("MESSAGE_PARAMS_INSTANCE_POOL")
    private static final ArrayDeque<zznv> zza = new ArrayDeque<>();
    private static final Object zzb = new Object();
    private final MediaCodec zzc;
    private final HandlerThread zzd;
    private Handler zze;
    private final AtomicReference<RuntimeException> zzf = new AtomicReference<>();
    private final zzeb zzg;
    private boolean zzh;

    public zznw(MediaCodec mediaCodec, HandlerThread handlerThread) {
        zzeb zzeb = new zzeb(zzdz.zza);
        this.zzc = mediaCodec;
        this.zzd = handlerThread;
        this.zzg = zzeb;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.google.android.gms.internal.ads.zznv} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* bridge */ /* synthetic */ void zza(com.google.android.gms.internal.ads.zznw r10, android.os.Message r11) {
        /*
            int r0 = r11.what
            if (r0 == 0) goto L_0x0044
            r1 = 1
            if (r0 == r1) goto L_0x0022
            r1 = 2
            r2 = 0
            if (r0 == r1) goto L_0x001c
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            int r11 = r11.what
            java.lang.String r11 = java.lang.String.valueOf(r11)
            r0.<init>(r11)
            java.util.concurrent.atomic.AtomicReference<java.lang.RuntimeException> r10 = r10.zzf
            r10.set(r0)
            goto L_0x005e
        L_0x001c:
            com.google.android.gms.internal.ads.zzeb r10 = r10.zzg
            r10.zze()
            goto L_0x005e
        L_0x0022:
            java.lang.Object r11 = r11.obj
            r2 = r11
            com.google.android.gms.internal.ads.zznv r2 = (com.google.android.gms.internal.ads.zznv) r2
            int r4 = r2.zza
            android.media.MediaCodec$CryptoInfo r6 = r2.zzd
            long r7 = r2.zze
            int r9 = r2.zzf
            java.lang.Object r11 = zzb     // Catch:{ RuntimeException -> 0x003d }
            monitor-enter(r11)     // Catch:{ RuntimeException -> 0x003d }
            android.media.MediaCodec r3 = r10.zzc     // Catch:{ all -> 0x003a }
            r5 = 0
            r3.queueSecureInputBuffer(r4, r5, r6, r7, r9)     // Catch:{ all -> 0x003a }
            monitor-exit(r11)     // Catch:{ all -> 0x003a }
            goto L_0x005e
        L_0x003a:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x003a }
            throw r0     // Catch:{ RuntimeException -> 0x003d }
        L_0x003d:
            r11 = move-exception
            java.util.concurrent.atomic.AtomicReference<java.lang.RuntimeException> r10 = r10.zzf
            r10.set(r11)
            goto L_0x005e
        L_0x0044:
            java.lang.Object r11 = r11.obj
            r2 = r11
            com.google.android.gms.internal.ads.zznv r2 = (com.google.android.gms.internal.ads.zznv) r2
            int r4 = r2.zza
            int r6 = r2.zzc
            long r7 = r2.zze
            int r9 = r2.zzf
            android.media.MediaCodec r3 = r10.zzc     // Catch:{ RuntimeException -> 0x0058 }
            r5 = 0
            r3.queueInputBuffer(r4, r5, r6, r7, r9)     // Catch:{ RuntimeException -> 0x0058 }
            goto L_0x005e
        L_0x0058:
            r11 = move-exception
            java.util.concurrent.atomic.AtomicReference<java.lang.RuntimeException> r10 = r10.zzf
            r10.set(r11)
        L_0x005e:
            if (r2 == 0) goto L_0x006b
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zznv> r10 = zza
            monitor-enter(r10)
            r10.add(r2)     // Catch:{ all -> 0x0068 }
            monitor-exit(r10)     // Catch:{ all -> 0x0068 }
            return
        L_0x0068:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0068 }
            throw r11
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznw.zza(com.google.android.gms.internal.ads.zznw, android.os.Message):void");
    }

    private static zznv zzg() {
        ArrayDeque<zznv> arrayDeque = zza;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                zznv zznv = new zznv();
                return zznv;
            }
            zznv removeFirst = arrayDeque.removeFirst();
            return removeFirst;
        }
    }

    private final void zzh() {
        RuntimeException andSet = this.zzf.getAndSet((Object) null);
        if (andSet != null) {
            throw andSet;
        }
    }

    @Nullable
    private static byte[] zzi(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        int length;
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < (length = bArr.length)) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    @Nullable
    private static int[] zzj(@Nullable int[] iArr, @Nullable int[] iArr2) {
        int length;
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < (length = iArr.length)) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    public final void zzb() {
        if (this.zzh) {
            try {
                Handler handler = this.zze;
                int i11 = zzfn.zza;
                handler.removeCallbacksAndMessages((Object) null);
                this.zzg.zzc();
                this.zze.obtainMessage(2).sendToTarget();
                this.zzg.zza();
                zzh();
            } catch (InterruptedException e11) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e11);
            }
        }
    }

    public final void zzc(int i11, int i12, int i13, long j11, int i14) {
        zzh();
        zznv zzg2 = zzg();
        zzg2.zza(i11, 0, i13, j11, i14);
        Handler handler = this.zze;
        int i15 = zzfn.zza;
        handler.obtainMessage(0, zzg2).sendToTarget();
    }

    public final void zzd(int i11, int i12, zzcx zzcx, long j11, int i13) {
        zzh();
        zznv zzg2 = zzg();
        zzg2.zza(i11, 0, 0, j11, 0);
        MediaCodec.CryptoInfo cryptoInfo = zzg2.zzd;
        cryptoInfo.numSubSamples = zzcx.zzf;
        cryptoInfo.numBytesOfClearData = zzj(zzcx.zzd, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = zzj(zzcx.zze, cryptoInfo.numBytesOfEncryptedData);
        byte[] zzi = zzi(zzcx.zzb, cryptoInfo.key);
        zzi.getClass();
        cryptoInfo.key = zzi;
        byte[] zzi2 = zzi(zzcx.zza, cryptoInfo.iv);
        zzi2.getClass();
        cryptoInfo.iv = zzi2;
        cryptoInfo.mode = zzcx.zzc;
        if (zzfn.zza >= 24) {
            cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(zzcx.zzg, zzcx.zzh));
        }
        this.zze.obtainMessage(1, zzg2).sendToTarget();
    }

    public final void zze() {
        if (this.zzh) {
            zzb();
            this.zzd.quit();
        }
        this.zzh = false;
    }

    public final void zzf() {
        if (!this.zzh) {
            this.zzd.start();
            this.zze = new zznu(this, this.zzd.getLooper());
            this.zzh = true;
        }
    }
}
