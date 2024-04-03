package com.google.android.gms.internal.gtm;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.commons.lang3.StringUtils;

@Instrumented
final class zzck extends zzan {
    /* access modifiers changed from: private */
    public static final byte[] zzabr = StringUtils.LF.getBytes();
    private final String zzabp = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{"GoogleAnalytics", zzao.VERSION, Build.VERSION.RELEASE, zzcz.zza(Locale.getDefault()), Build.MODEL, Build.ID});
    private final zzcv zzabq;

    public zzck(zzap zzap) {
        super(zzap);
        this.zzabq = new zzcv(zzap.zzcn());
    }

    private final int zza(URL url) {
        Preconditions.checkNotNull(url);
        zzb("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection zzb = zzb(url);
            zzb.connect();
            zza(zzb);
            int responseCode = zzb.getResponseCode();
            if (responseCode == 200) {
                zzcs().zzcl();
            }
            zzb("GET status", Integer.valueOf(responseCode));
            zzb.disconnect();
            return responseCode;
        } catch (IOException e11) {
            zzd("Network GET connection error", e11);
            if (httpURLConnection == null) {
                return 0;
            }
            httpURLConnection.disconnect();
            return 0;
        } catch (Throwable th2) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th2;
        }
    }

    private final URL zzd(zzcd zzcd) {
        String str;
        String str2;
        if (zzcd.zzfj()) {
            String valueOf = String.valueOf(zzbq.zzet());
            String valueOf2 = String.valueOf(zzbq.zzev());
            if (valueOf2.length() != 0) {
                str = valueOf.concat(valueOf2);
                return new URL(str);
            }
            str2 = new String(valueOf);
        } else {
            String valueOf3 = String.valueOf(zzbq.zzeu());
            String valueOf4 = String.valueOf(zzbq.zzev());
            if (valueOf4.length() != 0) {
                str = valueOf3.concat(valueOf4);
                return new URL(str);
            }
            str2 = new String(valueOf3);
        }
        str = str2;
        try {
            return new URL(str);
        } catch (MalformedURLException e11) {
            zze("Error trying to parse the hardcoded host url", e11);
            return null;
        }
    }

    private final URL zzfs() {
        String str;
        String valueOf = String.valueOf(zzbq.zzet());
        String valueOf2 = String.valueOf(zzby.zzzs.get());
        if (valueOf2.length() != 0) {
            str = valueOf.concat(valueOf2);
        } else {
            str = new String(valueOf);
        }
        try {
            return new URL(str);
        } catch (MalformedURLException e11) {
            zze("Error trying to parse the hardcoded host url", e11);
            return null;
        }
    }

    public final void zzaw() {
        zza("Network initialized. User agent", this.zzabp);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0157, code lost:
        if (zza(r5) == 200) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0199, code lost:
        if (zza(r6, r5) == 200) goto L_0x0132;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01b3 A[EDGE_INSN: B:71:0x01b3->B:67:0x01b3 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.Long> zzb(java.util.List<com.google.android.gms.internal.gtm.zzcd> r9) {
        /*
            r8 = this;
            com.google.android.gms.analytics.zzk.zzav()
            r8.zzdb()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)
            com.google.android.gms.internal.gtm.zzbq r0 = r8.zzcp()
            java.util.Set r0 = r0.zzew()
            boolean r0 = r0.isEmpty()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0057
            com.google.android.gms.internal.gtm.zzcv r0 = r8.zzabq
            com.google.android.gms.internal.gtm.zzbz<java.lang.Integer> r3 = com.google.android.gms.internal.gtm.zzby.zzaab
            java.lang.Object r3 = r3.get()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            long r3 = (long) r3
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r5
            boolean r0 = r0.zzj(r3)
            if (r0 != 0) goto L_0x0032
            goto L_0x0057
        L_0x0032:
            com.google.android.gms.internal.gtm.zzbz<java.lang.String> r0 = com.google.android.gms.internal.gtm.zzby.zzzu
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            com.google.android.gms.internal.gtm.zzbg r0 = com.google.android.gms.internal.gtm.zzbg.zzz(r0)
            com.google.android.gms.internal.gtm.zzbg r3 = com.google.android.gms.internal.gtm.zzbg.zzya
            if (r0 == r3) goto L_0x0044
            r0 = r2
            goto L_0x0045
        L_0x0044:
            r0 = r1
        L_0x0045:
            com.google.android.gms.internal.gtm.zzbz<java.lang.String> r3 = com.google.android.gms.internal.gtm.zzby.zzzv
            java.lang.Object r3 = r3.get()
            java.lang.String r3 = (java.lang.String) r3
            com.google.android.gms.internal.gtm.zzbm r3 = com.google.android.gms.internal.gtm.zzbm.zzaa(r3)
            com.google.android.gms.internal.gtm.zzbm r4 = com.google.android.gms.internal.gtm.zzbm.GZIP
            if (r3 != r4) goto L_0x0058
            r3 = r2
            goto L_0x0059
        L_0x0057:
            r0 = r1
        L_0x0058:
            r3 = r1
        L_0x0059:
            r4 = 200(0xc8, float:2.8E-43)
            if (r0 == 0) goto L_0x0102
            boolean r0 = r9.isEmpty()
            r0 = r0 ^ r2
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
            int r1 = r9.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "Uploading batched hits. compression, count"
            r8.zza(r2, r0, r1)
            com.google.android.gms.internal.gtm.zzcl r0 = new com.google.android.gms.internal.gtm.zzcl
            r0.<init>(r8)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r9 = r9.iterator()
        L_0x0084:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x00a2
            java.lang.Object r2 = r9.next()
            com.google.android.gms.internal.gtm.zzcd r2 = (com.google.android.gms.internal.gtm.zzcd) r2
            boolean r5 = r0.zze(r2)
            if (r5 == 0) goto L_0x00a2
            long r5 = r2.zzfg()
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            r1.add(r2)
            goto L_0x0084
        L_0x00a2:
            int r9 = r0.zzfu()
            if (r9 != 0) goto L_0x00a9
            return r1
        L_0x00a9:
            java.net.URL r9 = r8.zzfs()
            if (r9 != 0) goto L_0x00b5
            java.lang.String r9 = "Failed to build batching endpoint url"
            r8.zzu(r9)
            goto L_0x00fd
        L_0x00b5:
            if (r3 == 0) goto L_0x00c0
            byte[] r2 = r0.getPayload()
            int r9 = r8.zzb((java.net.URL) r9, (byte[]) r2)
            goto L_0x00c8
        L_0x00c0:
            byte[] r2 = r0.getPayload()
            int r9 = r8.zza((java.net.URL) r9, (byte[]) r2)
        L_0x00c8:
            if (r4 != r9) goto L_0x00d8
            int r9 = r0.zzfu()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r0 = "Batched upload completed. Hits batched"
            r8.zza(r0, r9)
            return r1
        L_0x00d8:
            java.lang.String r0 = "Network error uploading hits. status code"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            r8.zza(r0, r1)
            com.google.android.gms.internal.gtm.zzbq r0 = r8.zzcp()
            java.util.Set r0 = r0.zzew()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            boolean r9 = r0.contains(r9)
            if (r9 == 0) goto L_0x00fd
            java.lang.String r9 = "Server instructed the client to stop batching"
            r8.zzt(r9)
            com.google.android.gms.internal.gtm.zzcv r9 = r8.zzabq
            r9.start()
        L_0x00fd:
            java.util.List r9 = java.util.Collections.emptyList()
            return r9
        L_0x0102:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r3 = r9.size()
            r0.<init>(r3)
            java.util.Iterator r9 = r9.iterator()
        L_0x010f:
            boolean r3 = r9.hasNext()
            if (r3 == 0) goto L_0x01b3
            java.lang.Object r3 = r9.next()
            com.google.android.gms.internal.gtm.zzcd r3 = (com.google.android.gms.internal.gtm.zzcd) r3
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            boolean r5 = r3.zzfj()
            r5 = r5 ^ r2
            java.lang.String r5 = r8.zza((com.google.android.gms.internal.gtm.zzcd) r3, (boolean) r5)
            if (r5 != 0) goto L_0x0135
            com.google.android.gms.internal.gtm.zzci r5 = r8.zzco()
            java.lang.String r6 = "Error formatting hit for upload"
            r5.zza((com.google.android.gms.internal.gtm.zzcd) r3, (java.lang.String) r6)
        L_0x0132:
            r5 = r2
            goto L_0x019c
        L_0x0135:
            int r6 = r5.length()
            com.google.android.gms.internal.gtm.zzbz<java.lang.Integer> r7 = com.google.android.gms.internal.gtm.zzby.zzzt
            java.lang.Object r7 = r7.get()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            if (r6 > r7) goto L_0x015c
            java.net.URL r5 = r8.zzb((com.google.android.gms.internal.gtm.zzcd) r3, (java.lang.String) r5)
            if (r5 != 0) goto L_0x0153
            java.lang.String r5 = "Failed to build collect GET endpoint url"
            r8.zzu(r5)
            goto L_0x015a
        L_0x0153:
            int r5 = r8.zza((java.net.URL) r5)
            if (r5 != r4) goto L_0x015a
        L_0x0159:
            goto L_0x0132
        L_0x015a:
            r5 = r1
            goto L_0x019c
        L_0x015c:
            java.lang.String r5 = r8.zza((com.google.android.gms.internal.gtm.zzcd) r3, (boolean) r1)
            if (r5 != 0) goto L_0x016c
            com.google.android.gms.internal.gtm.zzci r5 = r8.zzco()
            java.lang.String r6 = "Error formatting hit for POST upload"
            r5.zza((com.google.android.gms.internal.gtm.zzcd) r3, (java.lang.String) r6)
            goto L_0x0132
        L_0x016c:
            byte[] r5 = r5.getBytes()
            int r6 = r5.length
            com.google.android.gms.internal.gtm.zzbz<java.lang.Integer> r7 = com.google.android.gms.internal.gtm.zzby.zzzy
            java.lang.Object r7 = r7.get()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            if (r6 <= r7) goto L_0x0189
            com.google.android.gms.internal.gtm.zzci r5 = r8.zzco()
            java.lang.String r6 = "Hit payload exceeds size limit"
            r5.zza((com.google.android.gms.internal.gtm.zzcd) r3, (java.lang.String) r6)
            goto L_0x0132
        L_0x0189:
            java.net.URL r6 = r8.zzd(r3)
            if (r6 != 0) goto L_0x0195
            java.lang.String r5 = "Failed to build collect POST endpoint url"
            r8.zzu(r5)
            goto L_0x015a
        L_0x0195:
            int r5 = r8.zza((java.net.URL) r6, (byte[]) r5)
            if (r5 != r4) goto L_0x015a
            goto L_0x0159
        L_0x019c:
            if (r5 == 0) goto L_0x01b3
            long r5 = r3.zzfg()
            java.lang.Long r3 = java.lang.Long.valueOf(r5)
            r0.add(r3)
            int r3 = r0.size()
            int r5 = com.google.android.gms.internal.gtm.zzbq.zzer()
            if (r3 < r5) goto L_0x010f
        L_0x01b3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzck.zzb(java.util.List):java.util.List");
    }

    public final boolean zzfr() {
        NetworkInfo networkInfo;
        zzk.zzav();
        zzdb();
        try {
            networkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        zzq("No network connectivity");
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.net.HttpURLConnection} */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r5v2, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0075 A[SYNTHETIC, Splitter:B:27:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0087 A[SYNTHETIC, Splitter:B:35:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(java.net.URL r5, byte[] r6) {
        /*
            r4 = this;
            java.lang.String r0 = "Error closing http post connection output stream"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)
            int r1 = r6.length
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "POST bytes, url"
            r4.zzb(r2, r1, r5)
            boolean r1 = com.google.android.gms.internal.gtm.zzam.zzda()
            if (r1 == 0) goto L_0x0022
            java.lang.String r1 = new java.lang.String
            r1.<init>(r6)
            java.lang.String r2 = "Post payload\n"
            r4.zza(r2, r1)
        L_0x0022:
            r1 = 0
            android.content.Context r2 = r4.getContext()     // Catch:{ IOException -> 0x006c, all -> 0x0069 }
            r2.getPackageName()     // Catch:{ IOException -> 0x006c, all -> 0x0069 }
            java.net.HttpURLConnection r5 = r4.zzb((java.net.URL) r5)     // Catch:{ IOException -> 0x006c, all -> 0x0069 }
            r2 = 1
            r5.setDoOutput(r2)     // Catch:{ IOException -> 0x0067 }
            int r2 = r6.length     // Catch:{ IOException -> 0x0067 }
            r5.setFixedLengthStreamingMode(r2)     // Catch:{ IOException -> 0x0067 }
            r5.connect()     // Catch:{ IOException -> 0x0067 }
            java.io.OutputStream r1 = r5.getOutputStream()     // Catch:{ IOException -> 0x0067 }
            r1.write(r6)     // Catch:{ IOException -> 0x0067 }
            r4.zza((java.net.HttpURLConnection) r5)     // Catch:{ IOException -> 0x0067 }
            int r6 = r5.getResponseCode()     // Catch:{ IOException -> 0x0067 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r6 != r2) goto L_0x0052
            com.google.android.gms.internal.gtm.zzae r2 = r4.zzcs()     // Catch:{ IOException -> 0x0067 }
            r2.zzcl()     // Catch:{ IOException -> 0x0067 }
        L_0x0052:
            java.lang.String r2 = "POST status"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x0067 }
            r4.zzb(r2, r3)     // Catch:{ IOException -> 0x0067 }
            r1.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r1 = move-exception
            r4.zze(r0, r1)
        L_0x0063:
            r5.disconnect()
            return r6
        L_0x0067:
            r6 = move-exception
            goto L_0x006e
        L_0x0069:
            r6 = move-exception
            r5 = r1
            goto L_0x0085
        L_0x006c:
            r6 = move-exception
            r5 = r1
        L_0x006e:
            java.lang.String r2 = "Network POST connection error"
            r4.zzd(r2, r6)     // Catch:{ all -> 0x0084 }
            if (r1 == 0) goto L_0x007d
            r1.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007d
        L_0x0079:
            r6 = move-exception
            r4.zze(r0, r6)
        L_0x007d:
            if (r5 == 0) goto L_0x0082
            r5.disconnect()
        L_0x0082:
            r5 = 0
            return r5
        L_0x0084:
            r6 = move-exception
        L_0x0085:
            if (r1 == 0) goto L_0x008f
            r1.close()     // Catch:{ IOException -> 0x008b }
            goto L_0x008f
        L_0x008b:
            r1 = move-exception
            r4.zze(r0, r1)
        L_0x008f:
            if (r5 == 0) goto L_0x0094
            r5.disconnect()
        L_0x0094:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzck.zza(java.net.URL, byte[]):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x001f A[SYNTHETIC, Splitter:B:18:0x001f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.net.HttpURLConnection r4) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "Error closing http connection input stream"
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ all -> 0x001b }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x0019 }
        L_0x000a:
            int r2 = r4.read(r1)     // Catch:{ all -> 0x0019 }
            if (r2 > 0) goto L_0x000a
            r4.close()     // Catch:{ IOException -> 0x0014 }
            return
        L_0x0014:
            r4 = move-exception
            r3.zze(r0, r4)
            return
        L_0x0019:
            r1 = move-exception
            goto L_0x001d
        L_0x001b:
            r1 = move-exception
            r4 = 0
        L_0x001d:
            if (r4 == 0) goto L_0x0027
            r4.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r4 = move-exception
            r3.zze(r0, r4)
        L_0x0027:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzck.zza(java.net.HttpURLConnection):void");
    }

    @VisibleForTesting
    public final String zza(zzcd zzcd, boolean z11) {
        String str;
        Preconditions.checkNotNull(zzcd);
        StringBuilder sb2 = new StringBuilder();
        try {
            for (Map.Entry next : zzcd.zzdm().entrySet()) {
                String str2 = (String) next.getKey();
                if (!"ht".equals(str2) && !"qt".equals(str2) && !"AppUID".equals(str2) && !CompressorStreamFactory.Z.equals(str2) && !"_gmsv".equals(str2)) {
                    zza(sb2, str2, (String) next.getValue());
                }
            }
            zza(sb2, "ht", String.valueOf(zzcd.zzfh()));
            zza(sb2, "qt", String.valueOf(zzcn().currentTimeMillis() - zzcd.zzfh()));
            if (z11) {
                long zzfk = zzcd.zzfk();
                if (zzfk != 0) {
                    str = String.valueOf(zzfk);
                } else {
                    str = String.valueOf(zzcd.zzfg());
                }
                zza(sb2, CompressorStreamFactory.Z, str);
            }
            return sb2.toString();
        } catch (UnsupportedEncodingException e11) {
            zze("Failed to encode name or value", e11);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d3 A[SYNTHETIC, Splitter:B:41:0x00d3] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e5 A[SYNTHETIC, Splitter:B:49:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzb(java.net.URL r11, byte[] r12) {
        /*
            r10 = this;
            java.lang.String r0 = "Error closing http compressed post connection output stream"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r12)
            r1 = 0
            android.content.Context r2 = r10.getContext()     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            r2.getPackageName()     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            r2.<init>()     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            java.util.zip.GZIPOutputStream r3 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            r3.write(r12)     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            r3.close()     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            r2.close()     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            byte[] r2 = r2.toByteArray()     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            java.lang.String r3 = "POST compressed size, ratio %, url"
            int r4 = r2.length     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            int r5 = r2.length     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            long r5 = (long) r5     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            r7 = 100
            long r5 = r5 * r7
            int r7 = r12.length     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            long r7 = (long) r7     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            long r5 = r5 / r7
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            r10.zza(r3, r4, r5, r11)     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            int r3 = r2.length     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            int r4 = r12.length     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            if (r3 <= r4) goto L_0x0050
            java.lang.String r3 = "Compressed payload is larger then uncompressed. compressed, uncompressed"
            int r4 = r2.length     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            int r5 = r12.length     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            r10.zzc(r3, r4, r5)     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
        L_0x0050:
            boolean r3 = com.google.android.gms.internal.gtm.zzam.zzda()     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            if (r3 == 0) goto L_0x0072
            java.lang.String r3 = "Post payload"
            java.lang.String r4 = "\n"
            java.lang.String r5 = new java.lang.String     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            r5.<init>(r12)     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            int r12 = r5.length()     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            if (r12 == 0) goto L_0x006a
            java.lang.String r12 = r4.concat(r5)     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            goto L_0x006f
        L_0x006a:
            java.lang.String r12 = new java.lang.String     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            r12.<init>(r4)     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
        L_0x006f:
            r10.zza(r3, r12)     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
        L_0x0072:
            java.net.HttpURLConnection r11 = r10.zzb((java.net.URL) r11)     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            r12 = 1
            r11.setDoOutput(r12)     // Catch:{ IOException -> 0x00c2, all -> 0x00bd }
            java.lang.String r12 = "Content-Encoding"
            java.lang.String r3 = "gzip"
            r11.addRequestProperty(r12, r3)     // Catch:{ IOException -> 0x00c2, all -> 0x00bd }
            int r12 = r2.length     // Catch:{ IOException -> 0x00c2, all -> 0x00bd }
            r11.setFixedLengthStreamingMode(r12)     // Catch:{ IOException -> 0x00c2, all -> 0x00bd }
            r11.connect()     // Catch:{ IOException -> 0x00c2, all -> 0x00bd }
            java.io.OutputStream r12 = r11.getOutputStream()     // Catch:{ IOException -> 0x00c2, all -> 0x00bd }
            r12.write(r2)     // Catch:{ IOException -> 0x00b7, all -> 0x00b1 }
            r12.close()     // Catch:{ IOException -> 0x00b7, all -> 0x00b1 }
            r10.zza((java.net.HttpURLConnection) r11)     // Catch:{ IOException -> 0x00c2, all -> 0x00bd }
            int r12 = r11.getResponseCode()     // Catch:{ IOException -> 0x00c2, all -> 0x00bd }
            r2 = 200(0xc8, float:2.8E-43)
            if (r12 != r2) goto L_0x00a4
            com.google.android.gms.internal.gtm.zzae r2 = r10.zzcs()     // Catch:{ IOException -> 0x00c2, all -> 0x00bd }
            r2.zzcl()     // Catch:{ IOException -> 0x00c2, all -> 0x00bd }
        L_0x00a4:
            java.lang.String r2 = "POST status"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)     // Catch:{ IOException -> 0x00c2, all -> 0x00bd }
            r10.zzb(r2, r3)     // Catch:{ IOException -> 0x00c2, all -> 0x00bd }
            r11.disconnect()
            return r12
        L_0x00b1:
            r1 = move-exception
            r9 = r12
            r12 = r11
            r11 = r1
            r1 = r9
            goto L_0x00e3
        L_0x00b7:
            r1 = move-exception
            r9 = r12
            r12 = r11
            r11 = r1
            r1 = r9
            goto L_0x00cc
        L_0x00bd:
            r12 = move-exception
            r9 = r12
            r12 = r11
            r11 = r9
            goto L_0x00e3
        L_0x00c2:
            r12 = move-exception
            r9 = r12
            r12 = r11
            r11 = r9
            goto L_0x00cc
        L_0x00c7:
            r11 = move-exception
            r12 = r1
            goto L_0x00e3
        L_0x00ca:
            r11 = move-exception
            r12 = r1
        L_0x00cc:
            java.lang.String r2 = "Network compressed POST connection error"
            r10.zzd(r2, r11)     // Catch:{ all -> 0x00e2 }
            if (r1 == 0) goto L_0x00db
            r1.close()     // Catch:{ IOException -> 0x00d7 }
            goto L_0x00db
        L_0x00d7:
            r11 = move-exception
            r10.zze(r0, r11)
        L_0x00db:
            if (r12 == 0) goto L_0x00e0
            r12.disconnect()
        L_0x00e0:
            r11 = 0
            return r11
        L_0x00e2:
            r11 = move-exception
        L_0x00e3:
            if (r1 == 0) goto L_0x00ed
            r1.close()     // Catch:{ IOException -> 0x00e9 }
            goto L_0x00ed
        L_0x00e9:
            r1 = move-exception
            r10.zze(r0, r1)
        L_0x00ed:
            if (r12 == 0) goto L_0x00f2
            r12.disconnect()
        L_0x00f2:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzck.zzb(java.net.URL, byte[]):int");
    }

    private static void zza(StringBuilder sb2, String str, String str2) throws UnsupportedEncodingException {
        if (sb2.length() != 0) {
            sb2.append(Typography.amp);
        }
        sb2.append(URLEncoder.encode(str, "UTF-8"));
        sb2.append(SignatureVisitor.INSTANCEOF);
        sb2.append(URLEncoder.encode(str2, "UTF-8"));
    }

    @VisibleForTesting
    private final HttpURLConnection zzb(URL url) throws IOException {
        URLConnection openConnection = URLConnectionInstrumentation.openConnection(url.openConnection());
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(zzby.zzaad.get().intValue());
            httpURLConnection.setReadTimeout(zzby.zzaae.get().intValue());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("User-Agent", this.zzabp);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    private final URL zzb(zzcd zzcd, String str) {
        String str2;
        if (zzcd.zzfj()) {
            String zzet = zzbq.zzet();
            String zzev = zzbq.zzev();
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzet).length() + 1 + String.valueOf(zzev).length() + String.valueOf(str).length());
            sb2.append(zzet);
            sb2.append(zzev);
            sb2.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
            sb2.append(str);
            str2 = sb2.toString();
        } else {
            String zzeu = zzbq.zzeu();
            String zzev2 = zzbq.zzev();
            StringBuilder sb3 = new StringBuilder(String.valueOf(zzeu).length() + 1 + String.valueOf(zzev2).length() + String.valueOf(str).length());
            sb3.append(zzeu);
            sb3.append(zzev2);
            sb3.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
            sb3.append(str);
            str2 = sb3.toString();
        }
        try {
            return new URL(str2);
        } catch (MalformedURLException e11) {
            zze("Error trying to parse the hardcoded host url", e11);
            return null;
        }
    }
}
