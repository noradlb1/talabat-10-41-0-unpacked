package com.google.android.gms.internal.ads;

import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class zzahh implements zzagl {
    protected final zzahj zza;
    @Deprecated
    protected final zzahg zzb;
    private final zzahg zzc;

    public zzahh(zzahg zzahg) {
        zzahj zzahj = new zzahj(4096);
        this.zzc = zzahg;
        this.zzb = zzahg;
        this.zza = zzahj;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:100:0x0223 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:92:0x020f */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0281 A[Catch:{ IOException -> 0x029d }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0297 A[Catch:{ IOException -> 0x029d }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02b9 A[SYNTHETIC, Splitter:B:138:0x02b9] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02c9  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x02bc A[EDGE_INSN: B:187:0x02bc->B:140:0x02bc ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzago zza(com.google.android.gms.internal.ads.zzags<?> r24) throws com.google.android.gms.internal.ads.zzahb {
        /*
            r23 = this;
            r1 = r24
            java.lang.String r2 = "Error occurred when closing InputStream"
            java.lang.String r3 = "Content-Type"
            long r4 = android.os.SystemClock.elapsedRealtime()
        L_0x000a:
            java.util.Collections.emptyList()
            r7 = 1
            r8 = 0
            r9 = 0
            com.google.android.gms.internal.ads.zzagb r0 = r24.zzd()     // Catch:{ IOException -> 0x02bf }
            if (r0 != 0) goto L_0x001b
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ IOException -> 0x02bf }
            goto L_0x003b
        L_0x001b:
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ IOException -> 0x02bf }
            r10.<init>()     // Catch:{ IOException -> 0x02bf }
            java.lang.String r11 = r0.zzb     // Catch:{ IOException -> 0x02bf }
            if (r11 == 0) goto L_0x0029
            java.lang.String r12 = "If-None-Match"
            r10.put(r12, r11)     // Catch:{ IOException -> 0x02bf }
        L_0x0029:
            long r11 = r0.zzd     // Catch:{ IOException -> 0x02bf }
            r13 = 0
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x003a
            java.lang.String r0 = "If-Modified-Since"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzahp.zzc(r11)     // Catch:{ IOException -> 0x02bf }
            r10.put(r0, r11)     // Catch:{ IOException -> 0x02bf }
        L_0x003a:
            r0 = r10
        L_0x003b:
            java.lang.String r10 = "application/x-www-form-urlencoded; charset=UTF-8"
            java.lang.String r11 = r24.zzk()     // Catch:{ IOException -> 0x02bf }
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ IOException -> 0x02bf }
            r12.<init>()     // Catch:{ IOException -> 0x02bf }
            r12.putAll(r0)     // Catch:{ IOException -> 0x02bf }
            java.util.Map r0 = r24.zzl()     // Catch:{ IOException -> 0x02bf }
            r12.putAll(r0)     // Catch:{ IOException -> 0x02bf }
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x02bf }
            r0.<init>(r11)     // Catch:{ IOException -> 0x02bf }
            java.net.URLConnection r11 = r0.openConnection()     // Catch:{ IOException -> 0x02bf }
            java.net.URLConnection r11 = com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation.openConnection(r11)     // Catch:{ IOException -> 0x02bf }
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ IOException -> 0x02bf }
            boolean r13 = java.net.HttpURLConnection.getFollowRedirects()     // Catch:{ IOException -> 0x02bf }
            r11.setInstanceFollowRedirects(r13)     // Catch:{ IOException -> 0x02bf }
            int r13 = r24.zzb()     // Catch:{ IOException -> 0x02bf }
            r11.setConnectTimeout(r13)     // Catch:{ IOException -> 0x02bf }
            r11.setReadTimeout(r13)     // Catch:{ IOException -> 0x02bf }
            r11.setUseCaches(r9)     // Catch:{ IOException -> 0x02bf }
            r11.setDoInput(r7)     // Catch:{ IOException -> 0x02bf }
            java.lang.String r13 = "https"
            java.lang.String r0 = r0.getProtocol()     // Catch:{ IOException -> 0x02bf }
            r13.equals(r0)     // Catch:{ IOException -> 0x02bf }
            java.util.Set r0 = r12.keySet()     // Catch:{ all -> 0x02b3 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x02b3 }
        L_0x0087:
            boolean r13 = r0.hasNext()     // Catch:{ all -> 0x02b3 }
            if (r13 == 0) goto L_0x009d
            java.lang.Object r13 = r0.next()     // Catch:{ all -> 0x02b3 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x02b3 }
            java.lang.Object r14 = r12.get(r13)     // Catch:{ all -> 0x02b3 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x02b3 }
            r11.setRequestProperty(r13, r14)     // Catch:{ all -> 0x02b3 }
            goto L_0x0087
        L_0x009d:
            int r0 = r24.zza()     // Catch:{ all -> 0x02b3 }
            if (r0 == 0) goto L_0x00ce
            java.lang.String r0 = "POST"
            r11.setRequestMethod(r0)     // Catch:{ all -> 0x02b3 }
            byte[] r0 = r24.zzx()     // Catch:{ all -> 0x02b3 }
            if (r0 == 0) goto L_0x00d3
            r11.setDoOutput(r7)     // Catch:{ all -> 0x02b3 }
            java.util.Map r12 = r11.getRequestProperties()     // Catch:{ all -> 0x02b3 }
            boolean r12 = r12.containsKey(r3)     // Catch:{ all -> 0x02b3 }
            if (r12 != 0) goto L_0x00be
            r11.setRequestProperty(r3, r10)     // Catch:{ all -> 0x02b3 }
        L_0x00be:
            java.io.DataOutputStream r10 = new java.io.DataOutputStream     // Catch:{ all -> 0x02b3 }
            java.io.OutputStream r12 = r11.getOutputStream()     // Catch:{ all -> 0x02b3 }
            r10.<init>(r12)     // Catch:{ all -> 0x02b3 }
            r10.write(r0)     // Catch:{ all -> 0x02b3 }
            r10.close()     // Catch:{ all -> 0x02b3 }
            goto L_0x00d3
        L_0x00ce:
            java.lang.String r0 = "GET"
            r11.setRequestMethod(r0)     // Catch:{ all -> 0x02b3 }
        L_0x00d3:
            int r0 = r11.getResponseCode()     // Catch:{ all -> 0x02b3 }
            r10 = -1
            if (r0 == r10) goto L_0x02a7
            r24.zza()     // Catch:{ all -> 0x02b3 }
            r12 = 100
            r13 = 304(0x130, float:4.26E-43)
            r14 = 200(0xc8, float:2.8E-43)
            if (r0 < r12) goto L_0x00e7
            if (r0 < r14) goto L_0x0109
        L_0x00e7:
            r12 = 204(0xcc, float:2.86E-43)
            if (r0 == r12) goto L_0x0109
            if (r0 == r13) goto L_0x0109
            com.google.android.gms.internal.ads.zzahq r12 = new com.google.android.gms.internal.ads.zzahq     // Catch:{ all -> 0x0104 }
            java.util.Map r15 = r11.getHeaderFields()     // Catch:{ all -> 0x0104 }
            java.util.List r15 = com.google.android.gms.internal.ads.zzaht.zza(r15)     // Catch:{ all -> 0x0104 }
            int r14 = r11.getContentLength()     // Catch:{ all -> 0x0104 }
            com.google.android.gms.internal.ads.zzahr r6 = new com.google.android.gms.internal.ads.zzahr     // Catch:{ all -> 0x0104 }
            r6.<init>(r11)     // Catch:{ all -> 0x0104 }
            r12.<init>(r0, r15, r14, r6)     // Catch:{ all -> 0x0104 }
            goto L_0x0119
        L_0x0104:
            r0 = move-exception
            r14 = r23
            goto L_0x02b7
        L_0x0109:
            com.google.android.gms.internal.ads.zzahq r12 = new com.google.android.gms.internal.ads.zzahq     // Catch:{ all -> 0x02b3 }
            java.util.Map r6 = r11.getHeaderFields()     // Catch:{ all -> 0x02b3 }
            java.util.List r6 = com.google.android.gms.internal.ads.zzaht.zza(r6)     // Catch:{ all -> 0x02b3 }
            r12.<init>(r0, r6, r10, r8)     // Catch:{ all -> 0x02b3 }
            r11.disconnect()     // Catch:{ IOException -> 0x02bf }
        L_0x0119:
            int r0 = r12.zzb()     // Catch:{ IOException -> 0x02a3 }
            java.util.List r6 = r12.zzd()     // Catch:{ IOException -> 0x02a3 }
            if (r0 != r13) goto L_0x01e4
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x02a3 }
            long r20 = r10 - r4
            com.google.android.gms.internal.ads.zzagb r0 = r24.zzd()     // Catch:{ IOException -> 0x02a3 }
            if (r0 != 0) goto L_0x0140
            com.google.android.gms.internal.ads.zzago r0 = new com.google.android.gms.internal.ads.zzago     // Catch:{ IOException -> 0x02a3 }
            r17 = 304(0x130, float:4.26E-43)
            r18 = 0
            r19 = 1
            r16 = r0
            r22 = r6
            r16.<init>((int) r17, (byte[]) r18, (boolean) r19, (long) r20, (java.util.List<com.google.android.gms.internal.ads.zzagk>) r22)     // Catch:{ IOException -> 0x02a3 }
            goto L_0x01e3
        L_0x0140:
            java.util.TreeSet r10 = new java.util.TreeSet     // Catch:{ IOException -> 0x02a3 }
            java.util.Comparator r11 = java.lang.String.CASE_INSENSITIVE_ORDER     // Catch:{ IOException -> 0x02a3 }
            r10.<init>(r11)     // Catch:{ IOException -> 0x02a3 }
            boolean r11 = r6.isEmpty()     // Catch:{ IOException -> 0x02a3 }
            if (r11 != 0) goto L_0x0165
            java.util.Iterator r11 = r6.iterator()     // Catch:{ IOException -> 0x02a3 }
        L_0x0151:
            boolean r13 = r11.hasNext()     // Catch:{ IOException -> 0x02a3 }
            if (r13 == 0) goto L_0x0165
            java.lang.Object r13 = r11.next()     // Catch:{ IOException -> 0x02a3 }
            com.google.android.gms.internal.ads.zzagk r13 = (com.google.android.gms.internal.ads.zzagk) r13     // Catch:{ IOException -> 0x02a3 }
            java.lang.String r13 = r13.zza()     // Catch:{ IOException -> 0x02a3 }
            r10.add(r13)     // Catch:{ IOException -> 0x02a3 }
            goto L_0x0151
        L_0x0165:
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ IOException -> 0x02a3 }
            r11.<init>(r6)     // Catch:{ IOException -> 0x02a3 }
            java.util.List<com.google.android.gms.internal.ads.zzagk> r6 = r0.zzh     // Catch:{ IOException -> 0x02a3 }
            if (r6 == 0) goto L_0x0194
            boolean r6 = r6.isEmpty()     // Catch:{ IOException -> 0x02a3 }
            if (r6 != 0) goto L_0x01d1
            java.util.List<com.google.android.gms.internal.ads.zzagk> r6 = r0.zzh     // Catch:{ IOException -> 0x02a3 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IOException -> 0x02a3 }
        L_0x017a:
            boolean r13 = r6.hasNext()     // Catch:{ IOException -> 0x02a3 }
            if (r13 == 0) goto L_0x01d1
            java.lang.Object r13 = r6.next()     // Catch:{ IOException -> 0x02a3 }
            com.google.android.gms.internal.ads.zzagk r13 = (com.google.android.gms.internal.ads.zzagk) r13     // Catch:{ IOException -> 0x02a3 }
            java.lang.String r14 = r13.zza()     // Catch:{ IOException -> 0x02a3 }
            boolean r14 = r10.contains(r14)     // Catch:{ IOException -> 0x02a3 }
            if (r14 != 0) goto L_0x017a
            r11.add(r13)     // Catch:{ IOException -> 0x02a3 }
            goto L_0x017a
        L_0x0194:
            java.util.Map<java.lang.String, java.lang.String> r6 = r0.zzg     // Catch:{ IOException -> 0x02a3 }
            boolean r6 = r6.isEmpty()     // Catch:{ IOException -> 0x02a3 }
            if (r6 != 0) goto L_0x01d1
            java.util.Map<java.lang.String, java.lang.String> r6 = r0.zzg     // Catch:{ IOException -> 0x02a3 }
            java.util.Set r6 = r6.entrySet()     // Catch:{ IOException -> 0x02a3 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IOException -> 0x02a3 }
        L_0x01a6:
            boolean r13 = r6.hasNext()     // Catch:{ IOException -> 0x02a3 }
            if (r13 == 0) goto L_0x01d1
            java.lang.Object r13 = r6.next()     // Catch:{ IOException -> 0x02a3 }
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13     // Catch:{ IOException -> 0x02a3 }
            java.lang.Object r14 = r13.getKey()     // Catch:{ IOException -> 0x02a3 }
            boolean r14 = r10.contains(r14)     // Catch:{ IOException -> 0x02a3 }
            if (r14 != 0) goto L_0x01a6
            com.google.android.gms.internal.ads.zzagk r14 = new com.google.android.gms.internal.ads.zzagk     // Catch:{ IOException -> 0x02a3 }
            java.lang.Object r15 = r13.getKey()     // Catch:{ IOException -> 0x02a3 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ IOException -> 0x02a3 }
            java.lang.Object r13 = r13.getValue()     // Catch:{ IOException -> 0x02a3 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ IOException -> 0x02a3 }
            r14.<init>(r15, r13)     // Catch:{ IOException -> 0x02a3 }
            r11.add(r14)     // Catch:{ IOException -> 0x02a3 }
            goto L_0x01a6
        L_0x01d1:
            com.google.android.gms.internal.ads.zzago r6 = new com.google.android.gms.internal.ads.zzago     // Catch:{ IOException -> 0x02a3 }
            r17 = 304(0x130, float:4.26E-43)
            byte[] r0 = r0.zza     // Catch:{ IOException -> 0x02a3 }
            r19 = 1
            r16 = r6
            r18 = r0
            r22 = r11
            r16.<init>((int) r17, (byte[]) r18, (boolean) r19, (long) r20, (java.util.List<com.google.android.gms.internal.ads.zzagk>) r22)     // Catch:{ IOException -> 0x02a3 }
            r0 = r6
        L_0x01e3:
            return r0
        L_0x01e4:
            java.io.InputStream r11 = r12.zzc()     // Catch:{ IOException -> 0x02a3 }
            if (r11 == 0) goto L_0x022f
            int r13 = r12.zza()     // Catch:{ IOException -> 0x02a3 }
            r14 = r23
            com.google.android.gms.internal.ads.zzahj r15 = r14.zza     // Catch:{ IOException -> 0x02a1 }
            com.google.android.gms.internal.ads.zzahw r8 = new com.google.android.gms.internal.ads.zzahw     // Catch:{ IOException -> 0x02a1 }
            r8.<init>(r15, r13)     // Catch:{ IOException -> 0x02a1 }
            r13 = 1024(0x400, float:1.435E-42)
            byte[] r13 = r15.zzb(r13)     // Catch:{ all -> 0x021d }
        L_0x01fd:
            int r7 = r11.read(r13)     // Catch:{ all -> 0x021b }
            if (r7 == r10) goto L_0x0207
            r8.write(r13, r9, r7)     // Catch:{ all -> 0x021b }
            goto L_0x01fd
        L_0x0207:
            byte[] r7 = r8.toByteArray()     // Catch:{ all -> 0x021b }
            r11.close()     // Catch:{ IOException -> 0x020f }
            goto L_0x0214
        L_0x020f:
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ IOException -> 0x02a1 }
            com.google.android.gms.internal.ads.zzahe.zzd(r2, r10)     // Catch:{ IOException -> 0x02a1 }
        L_0x0214:
            r15.zza(r13)     // Catch:{ IOException -> 0x02a1 }
            r8.close()     // Catch:{ IOException -> 0x02a1 }
            goto L_0x0233
        L_0x021b:
            r0 = move-exception
            goto L_0x021f
        L_0x021d:
            r0 = move-exception
            r13 = 0
        L_0x021f:
            r11.close()     // Catch:{ IOException -> 0x0223 }
            goto L_0x0228
        L_0x0223:
            java.lang.Object[] r6 = new java.lang.Object[r9]     // Catch:{ IOException -> 0x02a1 }
            com.google.android.gms.internal.ads.zzahe.zzd(r2, r6)     // Catch:{ IOException -> 0x02a1 }
        L_0x0228:
            r15.zza(r13)     // Catch:{ IOException -> 0x02a1 }
            r8.close()     // Catch:{ IOException -> 0x02a1 }
            throw r0     // Catch:{ IOException -> 0x02a1 }
        L_0x022f:
            r14 = r23
            byte[] r7 = new byte[r9]     // Catch:{ IOException -> 0x02a1 }
        L_0x0233:
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x029d }
            long r10 = r10 - r4
            boolean r8 = com.google.android.gms.internal.ads.zzahe.zzb     // Catch:{ IOException -> 0x029d }
            if (r8 != 0) goto L_0x0246
            r16 = 3000(0xbb8, double:1.482E-320)
            int r8 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r8 <= 0) goto L_0x0243
            goto L_0x0246
        L_0x0243:
            r8 = 200(0xc8, float:2.8E-43)
            goto L_0x027b
        L_0x0246:
            java.lang.String r8 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]"
            r13 = 5
            java.lang.Object[] r13 = new java.lang.Object[r13]     // Catch:{ IOException -> 0x029d }
            r13[r9] = r1     // Catch:{ IOException -> 0x029d }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ IOException -> 0x029d }
            r11 = 1
            r13[r11] = r10     // Catch:{ IOException -> 0x029d }
            if (r7 == 0) goto L_0x025c
            int r10 = r7.length     // Catch:{ IOException -> 0x029d }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ IOException -> 0x029d }
            goto L_0x025e
        L_0x025c:
            java.lang.String r10 = "null"
        L_0x025e:
            r11 = 2
            r13[r11] = r10     // Catch:{ IOException -> 0x029d }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x029d }
            r11 = 3
            r13[r11] = r10     // Catch:{ IOException -> 0x029d }
            com.google.android.gms.internal.ads.zzagg r10 = r24.zzy()     // Catch:{ IOException -> 0x029d }
            int r10 = r10.zza()     // Catch:{ IOException -> 0x029d }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ IOException -> 0x029d }
            r11 = 4
            r13[r11] = r10     // Catch:{ IOException -> 0x029d }
            com.google.android.gms.internal.ads.zzahe.zza(r8, r13)     // Catch:{ IOException -> 0x029d }
            goto L_0x0243
        L_0x027b:
            if (r0 < r8) goto L_0x0297
            r8 = 299(0x12b, float:4.19E-43)
            if (r0 > r8) goto L_0x0297
            com.google.android.gms.internal.ads.zzago r8 = new com.google.android.gms.internal.ads.zzago     // Catch:{ IOException -> 0x029d }
            r19 = 0
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x029d }
            long r20 = r10 - r4
            r16 = r8
            r17 = r0
            r18 = r7
            r22 = r6
            r16.<init>((int) r17, (byte[]) r18, (boolean) r19, (long) r20, (java.util.List<com.google.android.gms.internal.ads.zzagk>) r22)     // Catch:{ IOException -> 0x029d }
            return r8
        L_0x0297:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x029d }
            r0.<init>()     // Catch:{ IOException -> 0x029d }
            throw r0     // Catch:{ IOException -> 0x029d }
        L_0x029d:
            r0 = move-exception
            r18 = r7
            goto L_0x02c5
        L_0x02a1:
            r0 = move-exception
            goto L_0x02c3
        L_0x02a3:
            r0 = move-exception
            r14 = r23
            goto L_0x02c3
        L_0x02a7:
            r14 = r23
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x02b1 }
            java.lang.String r6 = "Could not retrieve response code from HttpUrlConnection."
            r0.<init>(r6)     // Catch:{ all -> 0x02b1 }
            throw r0     // Catch:{ all -> 0x02b1 }
        L_0x02b1:
            r0 = move-exception
            goto L_0x02b6
        L_0x02b3:
            r0 = move-exception
            r14 = r23
        L_0x02b6:
            r7 = r9
        L_0x02b7:
            if (r7 != 0) goto L_0x02bc
            r11.disconnect()     // Catch:{ IOException -> 0x02bd }
        L_0x02bc:
            throw r0     // Catch:{ IOException -> 0x02bd }
        L_0x02bd:
            r0 = move-exception
            goto L_0x02c2
        L_0x02bf:
            r0 = move-exception
            r14 = r23
        L_0x02c2:
            r12 = 0
        L_0x02c3:
            r18 = 0
        L_0x02c5:
            boolean r6 = r0 instanceof java.net.SocketTimeoutException
            if (r6 == 0) goto L_0x02d9
            com.google.android.gms.internal.ads.zzahv r0 = new com.google.android.gms.internal.ads.zzahv
            com.google.android.gms.internal.ads.zzaha r6 = new com.google.android.gms.internal.ads.zzaha
            r6.<init>()
            java.lang.String r7 = "socket"
            r8 = 0
            r0.<init>(r7, r6, r8)
        L_0x02d6:
            r6 = r0
            goto L_0x036a
        L_0x02d9:
            boolean r6 = r0 instanceof java.net.MalformedURLException
            if (r6 == 0) goto L_0x02fd
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r1 = r24.zzk()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r3 = r1.length()
            java.lang.String r4 = "Bad URL "
            if (r3 == 0) goto L_0x02f4
            java.lang.String r1 = r4.concat(r1)
            goto L_0x02f9
        L_0x02f4:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r4)
        L_0x02f9:
            r2.<init>(r1, r0)
            throw r2
        L_0x02fd:
            if (r12 == 0) goto L_0x03af
            int r0 = r12.zzb()
            r6 = 2
            java.lang.Object[] r7 = new java.lang.Object[r6]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
            r7[r9] = r6
            java.lang.String r6 = r24.zzk()
            r8 = 1
            r7[r8] = r6
            java.lang.String r6 = "Unexpected response code %d for %s"
            com.google.android.gms.internal.ads.zzahe.zzb(r6, r7)
            if (r18 == 0) goto L_0x035b
            java.util.List r22 = r12.zzd()
            com.google.android.gms.internal.ads.zzago r6 = new com.google.android.gms.internal.ads.zzago
            r19 = 0
            long r7 = android.os.SystemClock.elapsedRealtime()
            long r20 = r7 - r4
            r16 = r6
            r17 = r0
            r16.<init>((int) r17, (byte[]) r18, (boolean) r19, (long) r20, (java.util.List<com.google.android.gms.internal.ads.zzagk>) r22)
            r7 = 401(0x191, float:5.62E-43)
            if (r0 == r7) goto L_0x034c
            r7 = 403(0x193, float:5.65E-43)
            if (r0 != r7) goto L_0x0338
            goto L_0x034c
        L_0x0338:
            r1 = 400(0x190, float:5.6E-43)
            if (r0 < r1) goto L_0x0346
            r1 = 499(0x1f3, float:6.99E-43)
            if (r0 > r1) goto L_0x0346
            com.google.android.gms.internal.ads.zzagf r0 = new com.google.android.gms.internal.ads.zzagf
            r0.<init>(r6)
            throw r0
        L_0x0346:
            com.google.android.gms.internal.ads.zzagz r0 = new com.google.android.gms.internal.ads.zzagz
            r0.<init>(r6)
            throw r0
        L_0x034c:
            com.google.android.gms.internal.ads.zzahv r0 = new com.google.android.gms.internal.ads.zzahv
            com.google.android.gms.internal.ads.zzaga r7 = new com.google.android.gms.internal.ads.zzaga
            r7.<init>(r6)
            java.lang.String r6 = "auth"
            r8 = 0
            r0.<init>(r6, r7, r8)
            goto L_0x02d6
        L_0x035b:
            r8 = 0
            com.google.android.gms.internal.ads.zzahv r0 = new com.google.android.gms.internal.ads.zzahv
            com.google.android.gms.internal.ads.zzagn r6 = new com.google.android.gms.internal.ads.zzagn
            r6.<init>()
            java.lang.String r7 = "network"
            r0.<init>(r7, r6, r8)
            goto L_0x02d6
        L_0x036a:
            com.google.android.gms.internal.ads.zzagg r0 = r24.zzy()
            int r7 = r24.zzb()
            com.google.android.gms.internal.ads.zzahb r8 = r6.zzb     // Catch:{ zzahb -> 0x0394 }
            r0.zzc(r8)     // Catch:{ zzahb -> 0x0394 }
            r8 = 2
            java.lang.Object[] r0 = new java.lang.Object[r8]
            java.lang.String r6 = r6.zza
            r0[r9] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            r7 = 1
            r0[r7] = r6
            java.lang.String r6 = "%s-retry [timeout=%s]"
            java.lang.String r0 = java.lang.String.format(r6, r0)
            r1.zzm(r0)
            goto L_0x000a
        L_0x0394:
            r0 = move-exception
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = r6.zza
            r2[r9] = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            r4 = 1
            r2[r4] = r3
            java.lang.String r3 = "%s-timeout-giveup [timeout=%s]"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r1.zzm(r2)
            throw r0
        L_0x03af:
            com.google.android.gms.internal.ads.zzagp r1 = new com.google.android.gms.internal.ads.zzagp
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahh.zza(com.google.android.gms.internal.ads.zzags):com.google.android.gms.internal.ads.zzago");
    }
}
