package com.google.android.gms.internal.ads;

import android.content.Context;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public final class zzefl implements zzfhh<zzefj, zzefk> {
    protected final Context zza;
    protected final String zzb;
    protected final zzcec zzc;

    public zzefl(Context context, String str, zzcec zzcec, int i11, byte[] bArr) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzcec;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r2 = new java.io.InputStreamReader(r7.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        com.google.android.gms.ads.internal.zzt.zzp();
        r0 = new java.lang.StringBuilder(8192);
        r3 = new char[2048];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0154, code lost:
        r6 = r2.read(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0159, code lost:
        if (r6 == -1) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x015b, code lost:
        r0.append(r3, 0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0160, code lost:
        r0 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2);
        r4.zzg(r0);
        r5.zzc = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0170, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0182, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzbgq.zzc().zzb(com.google.android.gms.internal.ads.zzblj.zzdU)).booleanValue() == false) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x018b, code lost:
        throw new com.google.android.gms.internal.ads.zzecd(3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x018c, code lost:
        r5.zzd = com.google.android.gms.ads.internal.zzt.zzA().elapsedRealtime() - r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x019c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x021e, code lost:
        throw new com.google.android.gms.internal.ads.zzecd(r1, r4.toString());
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0245 A[Catch:{ all -> 0x0254 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0253 A[Catch:{ all -> 0x0254 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:116:0x0255=Splitter:B:116:0x0255, B:71:0x0197=Splitter:B:71:0x0197} */
    /* renamed from: zzb */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzefk zza(com.google.android.gms.internal.ads.zzefj r21) throws com.google.android.gms.internal.ads.zzecd {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            java.lang.String r2 = "Received error HTTP response code: "
            java.lang.String r3 = r0.zza
            int r11 = r0.zzb
            java.util.Map<java.lang.String, java.lang.String> r12 = r0.zzc
            byte[] r13 = r0.zzd
            java.lang.String r0 = r0.zze
            com.google.android.gms.common.util.Clock r4 = com.google.android.gms.ads.internal.zzt.zzA()
            long r14 = r4.elapsedRealtime()
            r10 = 1
            com.google.android.gms.internal.ads.zzefk r9 = new com.google.android.gms.internal.ads.zzefk     // Catch:{ IOException -> 0x025b }
            r9.<init>()     // Catch:{ IOException -> 0x025b }
            java.lang.String r4 = "SDK version: "
            java.lang.String r5 = r1.zzb     // Catch:{ IOException -> 0x025b }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ IOException -> 0x025b }
            int r6 = r5.length()     // Catch:{ IOException -> 0x025b }
            if (r6 == 0) goto L_0x0031
            java.lang.String r4 = r4.concat(r5)     // Catch:{ IOException -> 0x025b }
            goto L_0x0037
        L_0x0031:
            java.lang.String r5 = new java.lang.String     // Catch:{ IOException -> 0x025b }
            r5.<init>(r4)     // Catch:{ IOException -> 0x025b }
            r4 = r5
        L_0x0037:
            com.google.android.gms.internal.ads.zzciz.zzi(r4)     // Catch:{ IOException -> 0x025b }
            java.lang.String r4 = "AdRequestServiceImpl: Sending request: "
            java.lang.String r5 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x025b }
            int r6 = r5.length()     // Catch:{ IOException -> 0x025b }
            if (r6 == 0) goto L_0x004b
            java.lang.String r4 = r4.concat(r5)     // Catch:{ IOException -> 0x025b }
            goto L_0x0051
        L_0x004b:
            java.lang.String r5 = new java.lang.String     // Catch:{ IOException -> 0x025b }
            r5.<init>(r4)     // Catch:{ IOException -> 0x025b }
            r4 = r5
        L_0x0051:
            com.google.android.gms.internal.ads.zzciz.zze(r4)     // Catch:{ IOException -> 0x025b }
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x025b }
            r4.<init>(r3)     // Catch:{ IOException -> 0x025b }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ IOException -> 0x025b }
            r3.<init>()     // Catch:{ IOException -> 0x025b }
            r8 = 0
            r16 = r8
        L_0x0061:
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IOException -> 0x025b }
            java.net.URLConnection r4 = com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation.openConnection(r4)     // Catch:{ IOException -> 0x025b }
            r7 = r4
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ IOException -> 0x025b }
            com.google.android.gms.ads.internal.util.zzt r4 = com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ zzecd -> 0x0230, all -> 0x022d }
            android.content.Context r5 = r1.zza     // Catch:{ zzecd -> 0x0230, all -> 0x022d }
            java.lang.String r6 = r1.zzb     // Catch:{ zzecd -> 0x0230, all -> 0x022d }
            r17 = 0
            r18 = 0
            r21 = r7
            r7 = r17
            r8 = r21
            r19 = r9
            r9 = r18
            r1 = r10
            r10 = r11
            r4.zzk(r5, r6, r7, r8, r9, r10)     // Catch:{ zzecd -> 0x0227, all -> 0x0223 }
            java.util.Set r4 = r12.entrySet()     // Catch:{ zzecd -> 0x0227, all -> 0x0223 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ zzecd -> 0x0227, all -> 0x0223 }
        L_0x008f:
            boolean r5 = r4.hasNext()     // Catch:{ zzecd -> 0x0227, all -> 0x0223 }
            if (r5 == 0) goto L_0x00af
            java.lang.Object r5 = r4.next()     // Catch:{ zzecd -> 0x0227, all -> 0x0223 }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ zzecd -> 0x0227, all -> 0x0223 }
            java.lang.Object r6 = r5.getKey()     // Catch:{ zzecd -> 0x0227, all -> 0x0223 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ zzecd -> 0x0227, all -> 0x0223 }
            java.lang.Object r5 = r5.getValue()     // Catch:{ zzecd -> 0x0227, all -> 0x0223 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ zzecd -> 0x0227, all -> 0x0223 }
            r7 = r21
            r7.addRequestProperty(r6, r5)     // Catch:{ zzecd -> 0x0221 }
            r21 = r7
            goto L_0x008f
        L_0x00af:
            r7 = r21
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ zzecd -> 0x0221 }
            if (r4 != 0) goto L_0x00bc
            java.lang.String r4 = "Content-Type"
            r7.setRequestProperty(r4, r0)     // Catch:{ zzecd -> 0x0221 }
        L_0x00bc:
            int r4 = r13.length     // Catch:{ zzecd -> 0x0221 }
            r5 = 0
            if (r4 <= 0) goto L_0x00de
            r7.setDoOutput(r1)     // Catch:{ zzecd -> 0x0221 }
            r7.setFixedLengthStreamingMode(r4)     // Catch:{ zzecd -> 0x0221 }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00d9 }
            java.io.OutputStream r6 = r7.getOutputStream()     // Catch:{ all -> 0x00d9 }
            r4.<init>(r6)     // Catch:{ all -> 0x00d9 }
            r4.write(r13)     // Catch:{ all -> 0x00d6 }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r4)     // Catch:{ zzecd -> 0x0221 }
            goto L_0x00de
        L_0x00d6:
            r0 = move-exception
            r5 = r4
            goto L_0x00da
        L_0x00d9:
            r0 = move-exception
        L_0x00da:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r5)     // Catch:{ zzecd -> 0x0221 }
            throw r0     // Catch:{ zzecd -> 0x0221 }
        L_0x00de:
            com.google.android.gms.internal.ads.zzciy r4 = new com.google.android.gms.internal.ads.zzciy     // Catch:{ zzecd -> 0x0221 }
            r4.<init>(r5)     // Catch:{ zzecd -> 0x0221 }
            r4.zzc(r7, r13)     // Catch:{ zzecd -> 0x0221 }
            int r6 = r7.getResponseCode()     // Catch:{ zzecd -> 0x0221 }
            java.util.Map r8 = r7.getHeaderFields()     // Catch:{ zzecd -> 0x0221 }
            java.util.Set r8 = r8.entrySet()     // Catch:{ zzecd -> 0x0221 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ zzecd -> 0x0221 }
        L_0x00f6:
            boolean r9 = r8.hasNext()     // Catch:{ zzecd -> 0x0221 }
            if (r9 == 0) goto L_0x0128
            java.lang.Object r9 = r8.next()     // Catch:{ zzecd -> 0x0221 }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ zzecd -> 0x0221 }
            java.lang.Object r10 = r9.getKey()     // Catch:{ zzecd -> 0x0221 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ zzecd -> 0x0221 }
            java.lang.Object r9 = r9.getValue()     // Catch:{ zzecd -> 0x0221 }
            java.util.List r9 = (java.util.List) r9     // Catch:{ zzecd -> 0x0221 }
            boolean r17 = r3.containsKey(r10)     // Catch:{ zzecd -> 0x0221 }
            if (r17 == 0) goto L_0x011e
            java.lang.Object r10 = r3.get(r10)     // Catch:{ zzecd -> 0x0221 }
            java.util.List r10 = (java.util.List) r10     // Catch:{ zzecd -> 0x0221 }
            r10.addAll(r9)     // Catch:{ zzecd -> 0x0221 }
            goto L_0x00f6
        L_0x011e:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ zzecd -> 0x0221 }
            r5.<init>(r9)     // Catch:{ zzecd -> 0x0221 }
            r3.put(r10, r5)     // Catch:{ zzecd -> 0x0221 }
            r5 = 0
            goto L_0x00f6
        L_0x0128:
            r4.zze(r7, r6)     // Catch:{ zzecd -> 0x0221 }
            r5 = r19
            r5.zza = r6     // Catch:{ zzecd -> 0x021f }
            r5.zzb = r3     // Catch:{ zzecd -> 0x021f }
            java.lang.String r8 = ""
            r5.zzc = r8     // Catch:{ zzecd -> 0x021f }
            r8 = 200(0xc8, float:2.8E-43)
            r9 = 300(0x12c, float:4.2E-43)
            if (r6 < r8) goto L_0x01a4
            if (r6 >= r9) goto L_0x01a4
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x019e }
            java.io.InputStream r0 = r7.getInputStream()     // Catch:{ all -> 0x019e }
            r2.<init>(r0)     // Catch:{ all -> 0x019e }
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x019c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x019c }
            r3 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r3)     // Catch:{ all -> 0x019c }
            r3 = 2048(0x800, float:2.87E-42)
            char[] r3 = new char[r3]     // Catch:{ all -> 0x019c }
        L_0x0154:
            int r6 = r2.read(r3)     // Catch:{ all -> 0x019c }
            r8 = -1
            if (r6 == r8) goto L_0x0160
            r8 = 0
            r0.append(r3, r8, r6)     // Catch:{ all -> 0x019c }
            goto L_0x0154
        L_0x0160:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x019c }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)     // Catch:{ zzecd -> 0x021f }
            r4.zzg(r0)     // Catch:{ zzecd -> 0x021f }
            r5.zzc = r0     // Catch:{ zzecd -> 0x021f }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ zzecd -> 0x021f }
            if (r0 == 0) goto L_0x018c
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzblj.zzdU     // Catch:{ zzecd -> 0x021f }
            com.google.android.gms.internal.ads.zzblh r2 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ zzecd -> 0x021f }
            java.lang.Object r0 = r2.zzb(r0)     // Catch:{ zzecd -> 0x021f }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ zzecd -> 0x021f }
            boolean r0 = r0.booleanValue()     // Catch:{ zzecd -> 0x021f }
            if (r0 == 0) goto L_0x0185
            goto L_0x018c
        L_0x0185:
            com.google.android.gms.internal.ads.zzecd r0 = new com.google.android.gms.internal.ads.zzecd     // Catch:{ zzecd -> 0x021f }
            r2 = 3
            r0.<init>(r2)     // Catch:{ zzecd -> 0x021f }
            throw r0     // Catch:{ zzecd -> 0x021f }
        L_0x018c:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzt.zzA()     // Catch:{ zzecd -> 0x021f }
            long r2 = r0.elapsedRealtime()     // Catch:{ zzecd -> 0x021f }
            long r2 = r2 - r14
            r5.zzd = r2     // Catch:{ zzecd -> 0x021f }
        L_0x0197:
            r7.disconnect()     // Catch:{ IOException -> 0x0259 }
            goto L_0x0252
        L_0x019c:
            r0 = move-exception
            goto L_0x01a0
        L_0x019e:
            r0 = move-exception
            r2 = 0
        L_0x01a0:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)     // Catch:{ zzecd -> 0x021f }
            throw r0     // Catch:{ zzecd -> 0x021f }
        L_0x01a4:
            r8 = 0
            if (r6 < r9) goto L_0x01f6
            r4 = 400(0x190, float:5.6E-43)
            if (r6 >= r4) goto L_0x01f6
            java.lang.String r4 = "Location"
            java.lang.String r4 = r7.getHeaderField(r4)     // Catch:{ zzecd -> 0x021f }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ zzecd -> 0x021f }
            if (r6 != 0) goto L_0x01e9
            java.net.URL r6 = new java.net.URL     // Catch:{ zzecd -> 0x021f }
            r6.<init>(r4)     // Catch:{ zzecd -> 0x021f }
            int r4 = r16 + 1
            com.google.android.gms.internal.ads.zzblb<java.lang.Integer> r9 = com.google.android.gms.internal.ads.zzblj.zzdA     // Catch:{ zzecd -> 0x021f }
            com.google.android.gms.internal.ads.zzblh r10 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ zzecd -> 0x021f }
            java.lang.Object r9 = r10.zzb(r9)     // Catch:{ zzecd -> 0x021f }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ zzecd -> 0x021f }
            int r9 = r9.intValue()     // Catch:{ zzecd -> 0x021f }
            if (r4 > r9) goto L_0x01dc
            r7.disconnect()     // Catch:{ IOException -> 0x0259 }
            r10 = r1
            r16 = r4
            r9 = r5
            r4 = r6
            r1 = r20
            goto L_0x0061
        L_0x01dc:
            java.lang.String r0 = "Too many redirects."
            com.google.android.gms.internal.ads.zzciz.zzj(r0)     // Catch:{ zzecd -> 0x021f }
            com.google.android.gms.internal.ads.zzecd r0 = new com.google.android.gms.internal.ads.zzecd     // Catch:{ zzecd -> 0x021f }
            java.lang.String r2 = "Too many redirects"
            r0.<init>(r1, r2)     // Catch:{ zzecd -> 0x021f }
            throw r0     // Catch:{ zzecd -> 0x021f }
        L_0x01e9:
            java.lang.String r0 = "No location header to follow redirect."
            com.google.android.gms.internal.ads.zzciz.zzj(r0)     // Catch:{ zzecd -> 0x021f }
            com.google.android.gms.internal.ads.zzecd r0 = new com.google.android.gms.internal.ads.zzecd     // Catch:{ zzecd -> 0x021f }
            java.lang.String r2 = "No location header to follow redirect"
            r0.<init>(r1, r2)     // Catch:{ zzecd -> 0x021f }
            throw r0     // Catch:{ zzecd -> 0x021f }
        L_0x01f6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ zzecd -> 0x021f }
            r3 = 46
            r0.<init>(r3)     // Catch:{ zzecd -> 0x021f }
            r0.append(r2)     // Catch:{ zzecd -> 0x021f }
            r0.append(r6)     // Catch:{ zzecd -> 0x021f }
            java.lang.String r0 = r0.toString()     // Catch:{ zzecd -> 0x021f }
            com.google.android.gms.internal.ads.zzciz.zzj(r0)     // Catch:{ zzecd -> 0x021f }
            com.google.android.gms.internal.ads.zzecd r0 = new com.google.android.gms.internal.ads.zzecd     // Catch:{ zzecd -> 0x021f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ zzecd -> 0x021f }
            r4.<init>(r3)     // Catch:{ zzecd -> 0x021f }
            r4.append(r2)     // Catch:{ zzecd -> 0x021f }
            r4.append(r6)     // Catch:{ zzecd -> 0x021f }
            java.lang.String r2 = r4.toString()     // Catch:{ zzecd -> 0x021f }
            r0.<init>(r1, r2)     // Catch:{ zzecd -> 0x021f }
            throw r0     // Catch:{ zzecd -> 0x021f }
        L_0x021f:
            r0 = move-exception
            goto L_0x0233
        L_0x0221:
            r0 = move-exception
            goto L_0x022a
        L_0x0223:
            r0 = move-exception
            r7 = r21
            goto L_0x0255
        L_0x0227:
            r0 = move-exception
            r7 = r21
        L_0x022a:
            r5 = r19
            goto L_0x0233
        L_0x022d:
            r0 = move-exception
            r1 = r10
            goto L_0x0255
        L_0x0230:
            r0 = move-exception
            r5 = r9
            r1 = r10
        L_0x0233:
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzblj.zzgd     // Catch:{ all -> 0x0254 }
            com.google.android.gms.internal.ads.zzblh r3 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ all -> 0x0254 }
            java.lang.Object r2 = r3.zzb(r2)     // Catch:{ all -> 0x0254 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x0254 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0254 }
            if (r2 == 0) goto L_0x0253
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzt.zzA()     // Catch:{ all -> 0x0254 }
            long r2 = r0.elapsedRealtime()     // Catch:{ all -> 0x0254 }
            long r2 = r2 - r14
            r5.zzd = r2     // Catch:{ all -> 0x0254 }
            goto L_0x0197
        L_0x0252:
            return r5
        L_0x0253:
            throw r0     // Catch:{ all -> 0x0254 }
        L_0x0254:
            r0 = move-exception
        L_0x0255:
            r7.disconnect()     // Catch:{ IOException -> 0x0259 }
            throw r0     // Catch:{ IOException -> 0x0259 }
        L_0x0259:
            r0 = move-exception
            goto L_0x025d
        L_0x025b:
            r0 = move-exception
            r1 = r10
        L_0x025d:
            java.lang.String r2 = r0.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r3 = r2.length()
            java.lang.String r4 = "Error while connecting to ad server: "
            if (r3 == 0) goto L_0x0272
            java.lang.String r2 = r4.concat(r2)
            goto L_0x0277
        L_0x0272:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r4)
        L_0x0277:
            com.google.android.gms.internal.ads.zzciz.zzj(r2)
            com.google.android.gms.internal.ads.zzecd r3 = new com.google.android.gms.internal.ads.zzecd
            r3.<init>(r1, r2, r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefl.zza(com.google.android.gms.internal.ads.zzefj):com.google.android.gms.internal.ads.zzefk");
    }
}
