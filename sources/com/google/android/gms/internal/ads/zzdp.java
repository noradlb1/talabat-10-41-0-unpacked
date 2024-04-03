package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.webkit.ProxyConfig;
import com.google.common.net.HttpHeaders;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import com.newrelic.agent.android.util.Constants;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Instrumented
public final class zzdp extends zzdf implements zzdv {
    private final boolean zzb;
    private final int zzc;
    private final int zzd;
    @Nullable
    private final String zze;
    @Nullable
    private final zzdu zzf;
    private final zzdu zzg;
    @Nullable
    private zzdm zzh;
    @Nullable
    private HttpURLConnection zzi;
    @Nullable
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;

    @Deprecated
    public zzdp() {
        this((String) null, 8000, 8000, false, (zzdu) null, (zzfqh<String>) null, false);
    }

    public /* synthetic */ zzdp(String str, int i11, int i12, boolean z11, zzdu zzdu, zzfqh zzfqh, boolean z12, zzdo zzdo) {
        this(str, i11, i12, z11, zzdu, (zzfqh<String>) null, false);
    }

    private final HttpURLConnection zzk(URL url, int i11, @Nullable byte[] bArr, long j11, long j12, boolean z11, boolean z12, Map<String, String> map) throws IOException {
        String str;
        String str2;
        HttpURLConnection httpURLConnection = (HttpURLConnection) URLConnectionInstrumentation.openConnection(url.openConnection());
        httpURLConnection.setConnectTimeout(this.zzc);
        httpURLConnection.setReadTimeout(this.zzd);
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.zzf.zza());
        hashMap.putAll(this.zzg.zza());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        if (j11 == 0 && j12 == -1) {
            str = null;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("bytes=");
            sb2.append(j11);
            sb2.append(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
            if (j12 != -1) {
                sb2.append((j11 + j12) - 1);
            }
            str = sb2.toString();
        }
        if (str != null) {
            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, str);
        }
        String str3 = this.zze;
        if (str3 != null) {
            httpURLConnection.setRequestProperty("User-Agent", str3);
        }
        if (true != z11) {
            str2 = Constants.Network.ContentType.IDENTITY;
        } else {
            str2 = Constants.Network.ContentType.GZIP;
        }
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, str2);
        httpURLConnection.setInstanceFollowRedirects(z12);
        httpURLConnection.setDoOutput(false);
        httpURLConnection.setRequestMethod(zzdm.zza(1));
        httpURLConnection.connect();
        return httpURLConnection;
    }

    private final URL zzl(URL url, @Nullable String str, zzdm zzdm) throws zzds {
        String str2;
        if (str != null) {
            try {
                URL url2 = new URL(url, str);
                String protocol = url2.getProtocol();
                if (!"https".equals(protocol) && !ProxyConfig.MATCH_HTTP.equals(protocol)) {
                    String valueOf = String.valueOf(protocol);
                    if (valueOf.length() != 0) {
                        str2 = "Unsupported protocol redirect: ".concat(valueOf);
                    } else {
                        str2 = new String("Unsupported protocol redirect: ");
                    }
                    throw new zzds(str2, zzdm, 2001, 1);
                } else if (this.zzb || protocol.equals(url.getProtocol())) {
                    return url2;
                } else {
                    String protocol2 = url.getProtocol();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(protocol2).length() + 41 + protocol.length());
                    sb2.append("Disallowed cross-protocol redirect (");
                    sb2.append(protocol2);
                    sb2.append(" to ");
                    sb2.append(protocol);
                    sb2.append(")");
                    throw new zzds(sb2.toString(), zzdm, 2001, 1);
                }
            } catch (MalformedURLException e11) {
                throw new zzds((IOException) e11, zzdm, 2001, 1);
            }
        } else {
            throw new zzds("Null location redirect", zzdm, 2001, 1);
        }
    }

    private final void zzm() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e11) {
                zzep.zza("DefaultHttpDataSource", "Unexpected error while disconnecting", e11);
            }
            this.zzi = null;
        }
    }

    public final Map<String, List<String>> zza() {
        HttpURLConnection httpURLConnection = this.zzi;
        return httpURLConnection == null ? Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }

    public final int zzg(byte[] bArr, int i11, int i12) throws zzds {
        if (i12 == 0) {
            return 0;
        }
        try {
            long j11 = this.zzm;
            if (j11 != -1) {
                long j12 = j11 - this.zzn;
                if (j12 != 0) {
                    i12 = (int) Math.min((long) i12, j12);
                }
                return -1;
            }
            InputStream inputStream = this.zzj;
            int i13 = zzfn.zza;
            int read = inputStream.read(bArr, i11, i12);
            if (read == -1) {
                return -1;
            }
            this.zzn += (long) read;
            zzc(read);
            return read;
        } catch (IOException e11) {
            zzdm zzdm = this.zzh;
            int i14 = zzfn.zza;
            throw zzds.zza(e11, zzdm, 2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
        if (r8 != 0) goto L_0x00b8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzh(com.google.android.gms.internal.ads.zzdm r25) throws com.google.android.gms.internal.ads.zzds {
        /*
            r24 = this;
            r12 = r24
            r13 = r25
            r12.zzh = r13
            r14 = 0
            r12.zzn = r14
            r12.zzm = r14
            r24.zze(r25)
            r11 = 1
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x01f5 }
            android.net.Uri r0 = r13.zza     // Catch:{ IOException -> 0x01f5 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x01f5 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x01f5 }
            long r9 = r13.zzf     // Catch:{ IOException -> 0x01f5 }
            long r7 = r13.zzg     // Catch:{ IOException -> 0x01f5 }
            boolean r0 = r13.zzb(r11)     // Catch:{ IOException -> 0x01f5 }
            boolean r1 = r12.zzb     // Catch:{ IOException -> 0x01f5 }
            r5 = 0
            if (r1 != 0) goto L_0x0041
            r3 = 1
            r4 = 0
            r16 = 1
            java.util.Map<java.lang.String, java.lang.String> r6 = r13.zzd     // Catch:{ IOException -> 0x01f5 }
            r1 = r24
            r17 = r6
            r5 = r9
            r9 = r0
            r10 = r16
            r11 = r17
            java.net.HttpURLConnection r0 = r1.zzk(r2, r3, r4, r5, r7, r9, r10, r11)     // Catch:{ IOException -> 0x003d }
            goto L_0x008b
        L_0x003d:
            r0 = move-exception
            r5 = 1
            goto L_0x01f7
        L_0x0041:
            r11 = r2
            r5 = 0
        L_0x0043:
            int r6 = r5 + 1
            r1 = 20
            if (r5 > r1) goto L_0x01ce
            r3 = 1
            r4 = 0
            r16 = 0
            java.util.Map<java.lang.String, java.lang.String> r5 = r13.zzd     // Catch:{ IOException -> 0x003d }
            r1 = r24
            r2 = r11
            r17 = r5
            r18 = r6
            r5 = r9
            r19 = r7
            r21 = r9
            r9 = r0
            r10 = r16
            r23 = r11
            r11 = r17
            java.net.HttpURLConnection r1 = r1.zzk(r2, r3, r4, r5, r7, r9, r10, r11)     // Catch:{ IOException -> 0x003d }
            int r2 = r1.getResponseCode()     // Catch:{ IOException -> 0x003d }
            java.lang.String r3 = "Location"
            java.lang.String r3 = r1.getHeaderField(r3)     // Catch:{ IOException -> 0x003d }
            r4 = 300(0x12c, float:4.2E-43)
            if (r2 == r4) goto L_0x01bb
            r4 = 301(0x12d, float:4.22E-43)
            if (r2 == r4) goto L_0x01bb
            r4 = 302(0x12e, float:4.23E-43)
            if (r2 == r4) goto L_0x01bb
            r4 = 303(0x12f, float:4.25E-43)
            if (r2 == r4) goto L_0x01bb
            r4 = 307(0x133, float:4.3E-43)
            if (r2 == r4) goto L_0x01bb
            r4 = 308(0x134, float:4.32E-43)
            if (r2 != r4) goto L_0x008a
            goto L_0x01bb
        L_0x008a:
            r0 = r1
        L_0x008b:
            r12.zzi = r0     // Catch:{ IOException -> 0x003d }
            int r1 = r0.getResponseCode()     // Catch:{ IOException -> 0x003d }
            r12.zzl = r1     // Catch:{ IOException -> 0x003d }
            java.lang.String r3 = r0.getResponseMessage()     // Catch:{ IOException -> 0x003d }
            int r1 = r12.zzl
            r2 = 2008(0x7d8, float:2.814E-42)
            java.lang.String r4 = "Content-Range"
            r5 = 200(0xc8, float:2.8E-43)
            r6 = -1
            if (r1 < r5) goto L_0x0163
            r8 = 299(0x12b, float:4.19E-43)
            if (r1 <= r8) goto L_0x00a9
            goto L_0x0163
        L_0x00a9:
            r0.getContentType()
            int r1 = r12.zzl
            if (r1 != r5) goto L_0x00b7
            long r8 = r13.zzf
            int r1 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r1 == 0) goto L_0x00b7
            goto L_0x00b8
        L_0x00b7:
            r8 = r14
        L_0x00b8:
            java.lang.String r1 = "Content-Encoding"
            java.lang.String r1 = r0.getHeaderField(r1)
            java.lang.String r3 = "gzip"
            boolean r1 = r3.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x00e6
            long r10 = r13.zzg
            int r3 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x00cf
            r12.zzm = r10
            goto L_0x00ea
        L_0x00cf:
            java.lang.String r3 = "Content-Length"
            java.lang.String r3 = r0.getHeaderField(r3)
            java.lang.String r4 = r0.getHeaderField(r4)
            long r3 = com.google.android.gms.internal.ads.zzdw.zza(r3, r4)
            int r5 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r5 == 0) goto L_0x00e3
            long r6 = r3 - r8
        L_0x00e3:
            r12.zzm = r6
            goto L_0x00ea
        L_0x00e6:
            long r3 = r13.zzg
            r12.zzm = r3
        L_0x00ea:
            r3 = 2000(0x7d0, float:2.803E-42)
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x0158 }
            r12.zzj = r0     // Catch:{ IOException -> 0x0158 }
            if (r1 == 0) goto L_0x00fd
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0158 }
            java.io.InputStream r1 = r12.zzj     // Catch:{ IOException -> 0x0158 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0158 }
            r12.zzj = r0     // Catch:{ IOException -> 0x0158 }
        L_0x00fd:
            r5 = 1
            r12.zzk = r5
            r24.zzf(r25)
            int r0 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r0 != 0) goto L_0x0108
            goto L_0x0144
        L_0x0108:
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x0147 }
        L_0x010c:
            int r1 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r1 <= 0) goto L_0x0144
            r6 = 4096(0x1000, double:2.0237E-320)
            long r6 = java.lang.Math.min(r8, r6)     // Catch:{ IOException -> 0x0147 }
            int r1 = (int) r6     // Catch:{ IOException -> 0x0147 }
            java.io.InputStream r4 = r12.zzj     // Catch:{ IOException -> 0x0147 }
            int r6 = com.google.android.gms.internal.ads.zzfn.zza     // Catch:{ IOException -> 0x0147 }
            r6 = 0
            int r1 = r4.read(r0, r6, r1)     // Catch:{ IOException -> 0x0147 }
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ IOException -> 0x0147 }
            boolean r4 = r4.isInterrupted()     // Catch:{ IOException -> 0x0147 }
            if (r4 != 0) goto L_0x0139
            r4 = -1
            if (r1 == r4) goto L_0x0133
            long r10 = (long) r1     // Catch:{ IOException -> 0x0147 }
            long r8 = r8 - r10
            r12.zzc(r1)     // Catch:{ IOException -> 0x0147 }
            goto L_0x010c
        L_0x0133:
            com.google.android.gms.internal.ads.zzds r0 = new com.google.android.gms.internal.ads.zzds     // Catch:{ IOException -> 0x0147 }
            r0.<init>(r13, r2, r5)     // Catch:{ IOException -> 0x0147 }
            throw r0     // Catch:{ IOException -> 0x0147 }
        L_0x0139:
            com.google.android.gms.internal.ads.zzds r0 = new com.google.android.gms.internal.ads.zzds     // Catch:{ IOException -> 0x0147 }
            java.io.InterruptedIOException r1 = new java.io.InterruptedIOException     // Catch:{ IOException -> 0x0147 }
            r1.<init>()     // Catch:{ IOException -> 0x0147 }
            r0.<init>((java.io.IOException) r1, (com.google.android.gms.internal.ads.zzdm) r13, (int) r3, (int) r5)     // Catch:{ IOException -> 0x0147 }
            throw r0     // Catch:{ IOException -> 0x0147 }
        L_0x0144:
            long r0 = r12.zzm
            return r0
        L_0x0147:
            r0 = move-exception
            r24.zzm()
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzds
            if (r1 == 0) goto L_0x0152
            com.google.android.gms.internal.ads.zzds r0 = (com.google.android.gms.internal.ads.zzds) r0
            throw r0
        L_0x0152:
            com.google.android.gms.internal.ads.zzds r1 = new com.google.android.gms.internal.ads.zzds
            r1.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzdm) r13, (int) r3, (int) r5)
            throw r1
        L_0x0158:
            r0 = move-exception
            r5 = 1
            r24.zzm()
            com.google.android.gms.internal.ads.zzds r1 = new com.google.android.gms.internal.ads.zzds
            r1.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzdm) r13, (int) r3, (int) r5)
            throw r1
        L_0x0163:
            r5 = 1
            java.util.Map r8 = r0.getHeaderFields()
            int r1 = r12.zzl
            r9 = 416(0x1a0, float:5.83E-43)
            if (r1 != r9) goto L_0x018a
            java.lang.String r1 = r0.getHeaderField(r4)
            long r10 = com.google.android.gms.internal.ads.zzdw.zzb(r1)
            r4 = r3
            long r2 = r13.zzf
            int r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r2 != 0) goto L_0x018b
            r12.zzk = r5
            r24.zzf(r25)
            long r0 = r13.zzg
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x0189
            return r0
        L_0x0189:
            return r14
        L_0x018a:
            r4 = r3
        L_0x018b:
            java.io.InputStream r0 = r0.getErrorStream()
            if (r0 == 0) goto L_0x0196
            byte[] r0 = com.google.android.gms.internal.ads.zzfn.zzX(r0)     // Catch:{ IOException -> 0x019a }
            goto L_0x0198
        L_0x0196:
            byte[] r0 = com.google.android.gms.internal.ads.zzfn.zzf     // Catch:{ IOException -> 0x019a }
        L_0x0198:
            r7 = r0
            goto L_0x019d
        L_0x019a:
            byte[] r0 = com.google.android.gms.internal.ads.zzfn.zzf
            goto L_0x0198
        L_0x019d:
            r24.zzm()
            int r0 = r12.zzl
            if (r0 != r9) goto L_0x01ac
            com.google.android.gms.internal.ads.zzdj r0 = new com.google.android.gms.internal.ads.zzdj
            r1 = 2008(0x7d8, float:2.814E-42)
            r0.<init>(r1)
            goto L_0x01ad
        L_0x01ac:
            r0 = 0
        L_0x01ad:
            com.google.android.gms.internal.ads.zzdt r9 = new com.google.android.gms.internal.ads.zzdt
            int r2 = r12.zzl
            r1 = r9
            r3 = r4
            r4 = r0
            r5 = r8
            r6 = r25
            r1.<init>(r2, r3, r4, r5, r6, r7)
            throw r9
        L_0x01bb:
            r5 = 1
            r6 = 0
            r1.disconnect()     // Catch:{ IOException -> 0x01f3 }
            r2 = r23
            java.net.URL r11 = r12.zzl(r2, r3, r13)     // Catch:{ IOException -> 0x01f3 }
            r5 = r18
            r7 = r19
            r9 = r21
            goto L_0x0043
        L_0x01ce:
            r18 = r6
            r5 = 1
            com.google.android.gms.internal.ads.zzds r0 = new com.google.android.gms.internal.ads.zzds     // Catch:{ IOException -> 0x01f3 }
            java.net.NoRouteToHostException r1 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x01f3 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01f3 }
            r3 = 31
            r2.<init>(r3)     // Catch:{ IOException -> 0x01f3 }
            java.lang.String r3 = "Too many redirects: "
            r2.append(r3)     // Catch:{ IOException -> 0x01f3 }
            r3 = r18
            r2.append(r3)     // Catch:{ IOException -> 0x01f3 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x01f3 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x01f3 }
            r2 = 2001(0x7d1, float:2.804E-42)
            r0.<init>((java.io.IOException) r1, (com.google.android.gms.internal.ads.zzdm) r13, (int) r2, (int) r5)     // Catch:{ IOException -> 0x01f3 }
            throw r0     // Catch:{ IOException -> 0x01f3 }
        L_0x01f3:
            r0 = move-exception
            goto L_0x01f7
        L_0x01f5:
            r0 = move-exception
            r5 = r11
        L_0x01f7:
            r24.zzm()
            com.google.android.gms.internal.ads.zzds r0 = com.google.android.gms.internal.ads.zzds.zza(r0, r13, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdp.zzh(com.google.android.gms.internal.ads.zzdm):long");
    }

    @Nullable
    public final Uri zzi() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|(1:6)(1:7)|8|(3:10|11|(5:15|16|(2:18|(1:20))(2:21|(1:23))|24|(4:28|29|30|31)))|32|33) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x006d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj() throws com.google.android.gms.internal.ads.zzds {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r10.zzj     // Catch:{ all -> 0x008e }
            if (r2 == 0) goto L_0x007f
            long r3 = r10.zzm     // Catch:{ all -> 0x008e }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0010
            r3 = r5
            goto L_0x0013
        L_0x0010:
            long r7 = r10.zzn     // Catch:{ all -> 0x008e }
            long r3 = r3 - r7
        L_0x0013:
            java.net.HttpURLConnection r7 = r10.zzi     // Catch:{ all -> 0x008e }
            if (r7 == 0) goto L_0x006d
            int r8 = com.google.android.gms.internal.ads.zzfn.zza     // Catch:{ all -> 0x008e }
            r9 = 19
            if (r8 < r9) goto L_0x006d
            r9 = 20
            if (r8 <= r9) goto L_0x0022
            goto L_0x006d
        L_0x0022:
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ Exception -> 0x006d }
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x0032
            int r3 = r7.read()     // Catch:{ Exception -> 0x006d }
            r4 = -1
            if (r3 == r4) goto L_0x006d
            goto L_0x0039
        L_0x0032:
            r5 = 2048(0x800, double:1.0118E-320)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x0039
            goto L_0x006d
        L_0x0039:
            java.lang.Class r3 = r7.getClass()     // Catch:{ Exception -> 0x006d }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x006d }
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x006d }
            if (r4 != 0) goto L_0x0051
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r4.equals(r3)     // Catch:{ Exception -> 0x006d }
            if (r3 == 0) goto L_0x006d
        L_0x0051:
            java.lang.Class r3 = r7.getClass()     // Catch:{ Exception -> 0x006d }
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ Exception -> 0x006d }
            r3.getClass()
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x006d }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x006d }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x006d }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x006d }
            r3.invoke(r7, r4)     // Catch:{ Exception -> 0x006d }
        L_0x006d:
            r2.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x007f
        L_0x0071:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzds r3 = new com.google.android.gms.internal.ads.zzds     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzdm r4 = r10.zzh     // Catch:{ all -> 0x008e }
            int r5 = com.google.android.gms.internal.ads.zzfn.zza     // Catch:{ all -> 0x008e }
            r5 = 2000(0x7d0, float:2.803E-42)
            r6 = 3
            r3.<init>((java.io.IOException) r2, (com.google.android.gms.internal.ads.zzdm) r4, (int) r5, (int) r6)     // Catch:{ all -> 0x008e }
            throw r3     // Catch:{ all -> 0x008e }
        L_0x007f:
            r10.zzj = r0
            r10.zzm()
            boolean r0 = r10.zzk
            if (r0 == 0) goto L_0x008d
            r10.zzk = r1
            r10.zzd()
        L_0x008d:
            return
        L_0x008e:
            r2 = move-exception
            r10.zzj = r0
            r10.zzm()
            boolean r0 = r10.zzk
            if (r0 == 0) goto L_0x009d
            r10.zzk = r1
            r10.zzd()
        L_0x009d:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdp.zzj():void");
    }

    private zzdp(@Nullable String str, int i11, int i12, boolean z11, @Nullable zzdu zzdu, @Nullable zzfqh<String> zzfqh, boolean z12) {
        super(true);
        this.zze = str;
        this.zzc = i11;
        this.zzd = i12;
        this.zzb = z11;
        this.zzf = zzdu;
        this.zzg = new zzdu();
    }
}
