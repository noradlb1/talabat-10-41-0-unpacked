package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

public final class zzcnt extends zzdf {
    private final Context zza;
    private final zzdi zzb;
    private final String zzc;
    private final int zzd;
    private final boolean zze = ((Boolean) zzbgq.zzc().zzb(zzblj.zzbr)).booleanValue();
    private InputStream zzf;
    private boolean zzg;
    private Uri zzh;
    private volatile zzbak zzi;
    private boolean zzj = false;
    private boolean zzk = false;
    private boolean zzl = false;
    private boolean zzm = false;
    private long zzn = 0;
    private zzfxa<Long> zzo = null;
    private final AtomicLong zzp = new AtomicLong(-1);
    private final zzcod zzq;

    public zzcnt(Context context, zzdi zzdi, String str, int i11, zzdx zzdx, zzcod zzcod, byte[] bArr) {
        super(false);
        this.zza = context;
        this.zzb = zzdi;
        this.zzq = zzcod;
        this.zzc = str;
        this.zzd = i11;
        zzb(zzdx);
    }

    private final boolean zzr() {
        if (!this.zze) {
            return false;
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzcS)).booleanValue() && !this.zzl) {
            return true;
        }
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzcT)).booleanValue() || this.zzm) {
            return false;
        }
        return true;
    }

    public final int zzg(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        if (this.zzg) {
            InputStream inputStream = this.zzf;
            if (inputStream != null) {
                i13 = inputStream.read(bArr, i11, i12);
            } else {
                i13 = this.zzb.zzg(bArr, i11, i12);
            }
            if (!this.zze || this.zzf != null) {
                zzc(i13);
            }
            return i13;
        }
        throw new IOException("Attempt to read closed GcacheDataSource.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x01ea  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:39:0x0132=Splitter:B:39:0x0132, B:34:0x010f=Splitter:B:34:0x010f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzh(com.google.android.gms.internal.ads.zzdm r15) throws java.io.IOException {
        /*
            r14 = this;
            java.lang.String r0 = "ms"
            java.lang.String r1 = "Cache connection took "
            boolean r2 = r14.zzg
            if (r2 != 0) goto L_0x020a
            r2 = 1
            r14.zzg = r2
            android.net.Uri r3 = r15.zza
            r14.zzh = r3
            boolean r3 = r14.zze
            if (r3 != 0) goto L_0x0016
            r14.zzf(r15)
        L_0x0016:
            android.net.Uri r3 = r15.zza
            com.google.android.gms.internal.ads.zzbak r3 = com.google.android.gms.internal.ads.zzbak.zza(r3)
            r14.zzi = r3
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzblj.zzcP
            com.google.android.gms.internal.ads.zzblh r4 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r3 = r4.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r4 = -1
            r6 = 0
            if (r3 == 0) goto L_0x0188
            com.google.android.gms.internal.ads.zzbak r3 = r14.zzi
            if (r3 == 0) goto L_0x01e4
            com.google.android.gms.internal.ads.zzbak r3 = r14.zzi
            long r7 = r15.zzf
            r3.zzh = r7
            com.google.android.gms.internal.ads.zzbak r3 = r14.zzi
            java.lang.String r7 = r14.zzc
            java.lang.String r7 = com.google.android.gms.internal.ads.zzfqr.zzc(r7)
            r3.zzi = r7
            com.google.android.gms.internal.ads.zzbak r3 = r14.zzi
            int r7 = r14.zzd
            r3.zzj = r7
            com.google.android.gms.internal.ads.zzbak r3 = r14.zzi
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
            android.content.Context r3 = r14.zza
            com.google.android.gms.internal.ads.zzbak r11 = r14.zzi
            java.util.concurrent.Future r3 = com.google.android.gms.internal.ads.zzbav.zza(r3, r11)
            r11 = 44
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException | TimeoutException -> 0x0131, InterruptedException -> 0x010e, all -> 0x010b }
            java.lang.Object r7 = r3.get(r7, r12)     // Catch:{ ExecutionException | TimeoutException -> 0x0131, InterruptedException -> 0x010e, all -> 0x010b }
            com.google.android.gms.internal.ads.zzbaw r7 = (com.google.android.gms.internal.ads.zzbaw) r7     // Catch:{ ExecutionException | TimeoutException -> 0x0131, InterruptedException -> 0x010e, all -> 0x010b }
            boolean r8 = r7.zzd()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.zzj = r8     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            boolean r8 = r7.zzf()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.zzl = r8     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            boolean r8 = r7.zze()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.zzm = r8     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            long r12 = r7.zza()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.zzn = r12     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            boolean r8 = r14.zzr()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            if (r8 != 0) goto L_0x00e0
            java.io.InputStream r7 = r7.zzc()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.zzf = r7     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            boolean r7 = r14.zze     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            if (r7 == 0) goto L_0x00b8
            r14.zzf(r15)     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
        L_0x00b8:
            com.google.android.gms.common.util.Clock r15 = com.google.android.gms.ads.internal.zzt.zzA()
            long r6 = r15.elapsedRealtime()
            long r6 = r6 - r9
            com.google.android.gms.internal.ads.zzcod r15 = r14.zzq
            com.google.android.gms.internal.ads.zzcof r15 = r15.zza
            r15.zzS(r2, r6)
            r14.zzk = r2
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
            com.google.android.gms.internal.ads.zzcod r5 = r14.zzq
            com.google.android.gms.internal.ads.zzcof r5 = r5.zza
            r5.zzS(r2, r3)
            r14.zzk = r2
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
            com.google.android.gms.internal.ads.zzcod r5 = r14.zzq
            com.google.android.gms.internal.ads.zzcof r5 = r5.zza
            r5.zzS(r4, r2)
            r14.zzk = r4
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
            com.google.android.gms.internal.ads.zzcod r5 = r14.zzq
            com.google.android.gms.internal.ads.zzcof r5 = r5.zza
            r5.zzS(r4, r2)
            r14.zzk = r4
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
            com.google.android.gms.internal.ads.zzcod r5 = r14.zzq
            com.google.android.gms.internal.ads.zzcof r5 = r5.zza
            r5.zzS(r2, r3)
            r14.zzk = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r11)
            r2.append(r1)
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            throw r15
        L_0x0188:
            com.google.android.gms.internal.ads.zzbak r0 = r14.zzi
            if (r0 == 0) goto L_0x01ad
            com.google.android.gms.internal.ads.zzbak r0 = r14.zzi
            long r7 = r15.zzf
            r0.zzh = r7
            com.google.android.gms.internal.ads.zzbak r0 = r14.zzi
            java.lang.String r1 = r14.zzc
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfqr.zzc(r1)
            r0.zzi = r1
            com.google.android.gms.internal.ads.zzbak r0 = r14.zzi
            int r1 = r14.zzd
            r0.zzj = r1
            com.google.android.gms.internal.ads.zzbag r0 = com.google.android.gms.ads.internal.zzt.zzc()
            com.google.android.gms.internal.ads.zzbak r1 = r14.zzi
            com.google.android.gms.internal.ads.zzbah r0 = r0.zzb(r1)
            goto L_0x01ae
        L_0x01ad:
            r0 = 0
        L_0x01ae:
            if (r0 == 0) goto L_0x01e4
            boolean r1 = r0.zze()
            if (r1 == 0) goto L_0x01e4
            boolean r1 = r0.zzd()
            r14.zzj = r1
            boolean r1 = r0.zzg()
            r14.zzl = r1
            boolean r1 = r0.zzf()
            r14.zzm = r1
            long r7 = r0.zza()
            r14.zzn = r7
            r14.zzk = r2
            boolean r1 = r14.zzr()
            if (r1 != 0) goto L_0x01e4
            java.io.InputStream r0 = r0.zzc()
            r14.zzf = r0
            boolean r0 = r14.zze
            if (r0 == 0) goto L_0x01e3
            r14.zzf(r15)
        L_0x01e3:
            return r4
        L_0x01e4:
            r14.zzk = r6
            com.google.android.gms.internal.ads.zzbak r0 = r14.zzi
            if (r0 == 0) goto L_0x0203
            com.google.android.gms.internal.ads.zzdm r0 = new com.google.android.gms.internal.ads.zzdm
            com.google.android.gms.internal.ads.zzbak r1 = r14.zzi
            java.lang.String r1 = r1.zza
            android.net.Uri r2 = android.net.Uri.parse(r1)
            long r4 = r15.zze
            long r6 = r15.zzf
            long r8 = r15.zzg
            r3 = 0
            r10 = 0
            int r11 = r15.zzi
            r1 = r0
            r1.<init>(r2, r3, r4, r6, r8, r10, r11)
            r15 = r0
        L_0x0203:
            com.google.android.gms.internal.ads.zzdi r0 = r14.zzb
            long r0 = r0.zzh(r15)
            return r0
        L_0x020a:
            java.io.IOException r15 = new java.io.IOException
            java.lang.String r0 = "Attempt to open an already open GcacheDataSource."
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcnt.zzh(com.google.android.gms.internal.ads.zzdm):long");
    }

    public final Uri zzi() {
        return this.zzh;
    }

    public final void zzj() throws IOException {
        if (this.zzg) {
            boolean z11 = false;
            this.zzg = false;
            this.zzh = null;
            if (!this.zze || this.zzf != null) {
                z11 = true;
            }
            InputStream inputStream = this.zzf;
            if (inputStream != null) {
                IOUtils.closeQuietly((Closeable) inputStream);
                this.zzf = null;
            } else {
                this.zzb.zzj();
            }
            if (z11) {
                zzd();
                return;
            }
            return;
        }
        throw new IOException("Attempt to close an already closed GcacheDataSource.");
    }

    public final long zzk() {
        return this.zzn;
    }

    public final long zzl() {
        if (this.zzi == null) {
            return -1;
        }
        if (this.zzp.get() != -1) {
            return this.zzp.get();
        }
        synchronized (this) {
            if (this.zzo == null) {
                this.zzo = zzcjm.zza.zzb(new zzcns(this));
            }
        }
        if (!this.zzo.isDone()) {
            return -1;
        }
        try {
            this.zzp.compareAndSet(-1, this.zzo.get().longValue());
            return this.zzp.get();
        } catch (InterruptedException | ExecutionException unused) {
            return -1;
        }
    }

    public final /* synthetic */ Long zzm() throws Exception {
        return Long.valueOf(zzt.zzc().zza(this.zzi));
    }

    public final boolean zzn() {
        return this.zzj;
    }

    public final boolean zzo() {
        return this.zzm;
    }

    public final boolean zzp() {
        return this.zzl;
    }

    public final boolean zzq() {
        return this.zzk;
    }
}
