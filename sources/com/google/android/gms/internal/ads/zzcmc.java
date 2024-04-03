package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

public final class zzcmc implements zzavw {
    @Nullable
    private final zzawl<zzavw> zza;
    private final Context zzb;
    private final zzavw zzc;
    private final String zzd;
    private final int zze;
    private final boolean zzf = ((Boolean) zzbgq.zzc().zzb(zzblj.zzbr)).booleanValue();
    private InputStream zzg;
    private boolean zzh;
    private Uri zzi;
    private volatile zzbak zzj;
    private boolean zzk = false;
    private boolean zzl = false;
    private boolean zzm = false;
    private boolean zzn = false;
    private long zzo = 0;
    private zzfxa<Long> zzp = null;
    private final AtomicLong zzq = new AtomicLong(-1);
    private final zzcml zzr;

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzavw, android.content.Context] */
    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.android.gms.internal.ads.zzavw, java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.String, int] */
    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.android.gms.internal.ads.zzawl<com.google.android.gms.internal.ads.zzavw>, int] */
    /* JADX WARNING: type inference failed for: r6v0, types: [com.google.android.gms.internal.ads.zzcml, com.google.android.gms.internal.ads.zzawl<com.google.android.gms.internal.ads.zzavw>] */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzcmc(android.content.Context r1, android.content.Context r2, com.google.android.gms.internal.ads.zzavw r3, java.lang.String r4, int r5, com.google.android.gms.internal.ads.zzawl<com.google.android.gms.internal.ads.zzavw> r6, com.google.android.gms.internal.ads.zzcml r7) {
        /*
            r0 = this;
            r0.<init>()
            r0.zzb = r1
            r0.zzc = r2
            r0.zza = r5
            r0.zzr = r6
            r0.zzd = r3
            r0.zze = r4
            r1 = 0
            r0.zzk = r1
            r0.zzl = r1
            r0.zzm = r1
            r0.zzn = r1
            r1 = 0
            r0.zzo = r1
            java.util.concurrent.atomic.AtomicLong r1 = new java.util.concurrent.atomic.AtomicLong
            r2 = -1
            r1.<init>(r2)
            r0.zzq = r1
            r1 = 0
            r0.zzp = r1
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzblj.zzbr
            com.google.android.gms.internal.ads.zzblh r2 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r1 = r2.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r0.zzf = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcmc.<init>(android.content.Context, com.google.android.gms.internal.ads.zzavw, java.lang.String, int, com.google.android.gms.internal.ads.zzawl, com.google.android.gms.internal.ads.zzcml, byte[]):void");
    }

    private final void zzl(zzavy zzavy) {
        zzawl<zzavw> zzawl = this.zza;
        if (zzawl != null) {
            ((zzcmn) zzawl).zzk(this, zzavy);
        }
    }

    private final boolean zzm() {
        if (!this.zzf) {
            return false;
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzcS)).booleanValue() && !this.zzm) {
            return true;
        }
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzcT)).booleanValue() || this.zzn) {
            return false;
        }
        return true;
    }

    public final int zza(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        zzawl<zzavw> zzawl;
        if (this.zzh) {
            InputStream inputStream = this.zzg;
            if (inputStream != null) {
                i13 = inputStream.read(bArr, i11, i12);
            } else {
                i13 = this.zzc.zza(bArr, i11, i12);
            }
            if ((!this.zzf || this.zzg != null) && (zzawl = this.zza) != null) {
                ((zzcmn) zzawl).zzW(this, i13);
            }
            return i13;
        }
        throw new IOException("Attempt to read closed CacheDataSource.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x01ea  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:39:0x0132=Splitter:B:39:0x0132, B:34:0x010f=Splitter:B:34:0x010f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzb(com.google.android.gms.internal.ads.zzavy r15) throws java.io.IOException {
        /*
            r14 = this;
            java.lang.String r0 = "ms"
            java.lang.String r1 = "Cache connection took "
            boolean r2 = r14.zzh
            if (r2 != 0) goto L_0x0209
            r2 = 1
            r14.zzh = r2
            android.net.Uri r3 = r15.zza
            r14.zzi = r3
            boolean r3 = r14.zzf
            if (r3 != 0) goto L_0x0016
            r14.zzl(r15)
        L_0x0016:
            android.net.Uri r3 = r15.zza
            com.google.android.gms.internal.ads.zzbak r3 = com.google.android.gms.internal.ads.zzbak.zza(r3)
            r14.zzj = r3
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzblj.zzcP
            com.google.android.gms.internal.ads.zzblh r4 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r3 = r4.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r4 = -1
            r6 = 0
            if (r3 == 0) goto L_0x0188
            com.google.android.gms.internal.ads.zzbak r3 = r14.zzj
            if (r3 == 0) goto L_0x01e4
            com.google.android.gms.internal.ads.zzbak r3 = r14.zzj
            long r7 = r15.zzc
            r3.zzh = r7
            com.google.android.gms.internal.ads.zzbak r3 = r14.zzj
            java.lang.String r7 = r14.zzd
            java.lang.String r7 = com.google.android.gms.internal.ads.zzfqr.zzc(r7)
            r3.zzi = r7
            com.google.android.gms.internal.ads.zzbak r3 = r14.zzj
            int r7 = r14.zze
            r3.zzj = r7
            com.google.android.gms.internal.ads.zzbak r3 = r14.zzj
            boolean r3 = r3.zzg
            if (r3 == 0) goto L_0x0060
            com.google.android.gms.internal.ads.zzblb<java.lang.Long> r3 = com.google.android.gms.internal.ads.zzblj.zzcR
            com.google.android.gms.internal.ads.zzblh r7 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r3 = r7.zzb(r3)
            java.lang.Long r3 = (java.lang.Long) r3
            goto L_0x006c
        L_0x0060:
            com.google.android.gms.internal.ads.zzblb<java.lang.Long> r3 = com.google.android.gms.internal.ads.zzblj.zzcQ
            com.google.android.gms.internal.ads.zzblh r7 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r3 = r7.zzb(r3)
            java.lang.Long r3 = (java.lang.Long) r3
        L_0x006c:
            long r7 = r3.longValue()
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzt.zzA()
            long r9 = r3.elapsedRealtime()
            com.google.android.gms.ads.internal.zzt.zzd()
            android.content.Context r3 = r14.zzb
            com.google.android.gms.internal.ads.zzbak r11 = r14.zzj
            java.util.concurrent.Future r3 = com.google.android.gms.internal.ads.zzbav.zza(r3, r11)
            r11 = 44
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException | TimeoutException -> 0x0131, InterruptedException -> 0x010e, all -> 0x010b }
            java.lang.Object r7 = r3.get(r7, r12)     // Catch:{ ExecutionException | TimeoutException -> 0x0131, InterruptedException -> 0x010e, all -> 0x010b }
            com.google.android.gms.internal.ads.zzbaw r7 = (com.google.android.gms.internal.ads.zzbaw) r7     // Catch:{ ExecutionException | TimeoutException -> 0x0131, InterruptedException -> 0x010e, all -> 0x010b }
            boolean r8 = r7.zzd()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.zzk = r8     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            boolean r8 = r7.zzf()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.zzm = r8     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            boolean r8 = r7.zze()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.zzn = r8     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            long r12 = r7.zza()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.zzo = r12     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            boolean r8 = r14.zzm()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            if (r8 != 0) goto L_0x00e0
            java.io.InputStream r7 = r7.zzc()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.zzg = r7     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            boolean r7 = r14.zzf     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            if (r7 == 0) goto L_0x00b8
            r14.zzl(r15)     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
        L_0x00b8:
            com.google.android.gms.common.util.Clock r15 = com.google.android.gms.ads.internal.zzt.zzA()
            long r6 = r15.elapsedRealtime()
            long r6 = r6 - r9
            com.google.android.gms.internal.ads.zzcml r15 = r14.zzr
            com.google.android.gms.internal.ads.zzcmn r15 = r15.zza
            r15.zzV(r2, r6)
            r14.zzl = r2
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r11)
            r15.append(r1)
            r15.append(r6)
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r15)
            return r4
        L_0x00e0:
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzt.zzA()
            long r3 = r3.elapsedRealtime()
            long r3 = r3 - r9
            com.google.android.gms.internal.ads.zzcml r5 = r14.zzr
            com.google.android.gms.internal.ads.zzcmn r5 = r5.zza
            r5.zzV(r2, r3)
            r14.zzl = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r11)
            r2.append(r1)
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            goto L_0x0159
        L_0x0105:
            r15 = move-exception
            goto L_0x0160
        L_0x0107:
            r4 = r2
            goto L_0x010f
        L_0x0109:
            r4 = r2
            goto L_0x0132
        L_0x010b:
            r15 = move-exception
            r2 = r6
            goto L_0x0160
        L_0x010e:
            r4 = r6
        L_0x010f:
            r3.cancel(r2)     // Catch:{ all -> 0x015e }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x015e }
            r2.interrupt()     // Catch:{ all -> 0x015e }
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzt.zzA()
            long r2 = r2.elapsedRealtime()
            long r2 = r2 - r9
            com.google.android.gms.internal.ads.zzcml r5 = r14.zzr
            com.google.android.gms.internal.ads.zzcmn r5 = r5.zza
            r5.zzV(r4, r2)
            r14.zzl = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r11)
            goto L_0x014c
        L_0x0131:
            r4 = r6
        L_0x0132:
            r3.cancel(r2)     // Catch:{ all -> 0x015e }
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzt.zzA()
            long r2 = r2.elapsedRealtime()
            long r2 = r2 - r9
            com.google.android.gms.internal.ads.zzcml r5 = r14.zzr
            com.google.android.gms.internal.ads.zzcmn r5 = r5.zza
            r5.zzV(r4, r2)
            r14.zzl = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r11)
        L_0x014c:
            r4.append(r1)
            r4.append(r2)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
        L_0x0159:
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            goto L_0x01e4
        L_0x015e:
            r15 = move-exception
            r2 = r4
        L_0x0160:
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzt.zzA()
            long r3 = r3.elapsedRealtime()
            long r3 = r3 - r9
            com.google.android.gms.internal.ads.zzcml r5 = r14.zzr
            com.google.android.gms.internal.ads.zzcmn r5 = r5.zza
            r5.zzV(r2, r3)
            r14.zzl = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r11)
            r2.append(r1)
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            throw r15
        L_0x0188:
            com.google.android.gms.internal.ads.zzbak r0 = r14.zzj
            if (r0 == 0) goto L_0x01ad
            com.google.android.gms.internal.ads.zzbak r0 = r14.zzj
            long r7 = r15.zzc
            r0.zzh = r7
            com.google.android.gms.internal.ads.zzbak r0 = r14.zzj
            java.lang.String r1 = r14.zzd
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfqr.zzc(r1)
            r0.zzi = r1
            com.google.android.gms.internal.ads.zzbak r0 = r14.zzj
            int r1 = r14.zze
            r0.zzj = r1
            com.google.android.gms.internal.ads.zzbag r0 = com.google.android.gms.ads.internal.zzt.zzc()
            com.google.android.gms.internal.ads.zzbak r1 = r14.zzj
            com.google.android.gms.internal.ads.zzbah r0 = r0.zzb(r1)
            goto L_0x01ae
        L_0x01ad:
            r0 = 0
        L_0x01ae:
            if (r0 == 0) goto L_0x01e4
            boolean r1 = r0.zze()
            if (r1 == 0) goto L_0x01e4
            boolean r1 = r0.zzd()
            r14.zzk = r1
            boolean r1 = r0.zzg()
            r14.zzm = r1
            boolean r1 = r0.zzf()
            r14.zzn = r1
            long r7 = r0.zza()
            r14.zzo = r7
            r14.zzl = r2
            boolean r1 = r14.zzm()
            if (r1 != 0) goto L_0x01e4
            java.io.InputStream r0 = r0.zzc()
            r14.zzg = r0
            boolean r0 = r14.zzf
            if (r0 == 0) goto L_0x01e3
            r14.zzl(r15)
        L_0x01e3:
            return r4
        L_0x01e4:
            r14.zzl = r6
            com.google.android.gms.internal.ads.zzbak r0 = r14.zzj
            if (r0 == 0) goto L_0x0202
            com.google.android.gms.internal.ads.zzavy r0 = new com.google.android.gms.internal.ads.zzavy
            com.google.android.gms.internal.ads.zzbak r1 = r14.zzj
            java.lang.String r1 = r1.zza
            android.net.Uri r2 = android.net.Uri.parse(r1)
            r3 = 0
            long r4 = r15.zzb
            long r6 = r15.zzc
            long r8 = r15.zzd
            r10 = 0
            r11 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r6, r8, r10, r11)
            r15 = r0
        L_0x0202:
            com.google.android.gms.internal.ads.zzavw r0 = r14.zzc
            long r0 = r0.zzb(r15)
            return r0
        L_0x0209:
            java.io.IOException r15 = new java.io.IOException
            java.lang.String r0 = "Attempt to open an already open CacheDataSource."
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcmc.zzb(com.google.android.gms.internal.ads.zzavy):long");
    }

    public final Uri zzc() {
        return this.zzi;
    }

    public final void zzd() throws IOException {
        if (this.zzh) {
            this.zzh = false;
            this.zzi = null;
            InputStream inputStream = this.zzg;
            if (inputStream != null) {
                IOUtils.closeQuietly((Closeable) inputStream);
                this.zzg = null;
                return;
            }
            this.zzc.zzd();
            return;
        }
        throw new IOException("Attempt to close an already closed CacheDataSource.");
    }

    public final long zze() {
        return this.zzo;
    }

    public final long zzf() {
        if (this.zzj == null) {
            return -1;
        }
        if (this.zzq.get() != -1) {
            return this.zzq.get();
        }
        synchronized (this) {
            if (this.zzp == null) {
                this.zzp = zzcjm.zza.zzb(new zzcmb(this));
            }
        }
        if (!this.zzp.isDone()) {
            return -1;
        }
        try {
            this.zzq.compareAndSet(-1, this.zzp.get().longValue());
            return this.zzq.get();
        } catch (InterruptedException | ExecutionException unused) {
            return -1;
        }
    }

    public final /* synthetic */ Long zzg() throws Exception {
        return Long.valueOf(zzt.zzc().zza(this.zzj));
    }

    public final boolean zzh() {
        return this.zzk;
    }

    public final boolean zzi() {
        return this.zzn;
    }

    public final boolean zzj() {
        return this.zzm;
    }

    public final boolean zzk() {
        return this.zzl;
    }
}
