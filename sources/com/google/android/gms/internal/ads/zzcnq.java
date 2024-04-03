package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

@Instrumented
final class zzcnq extends zzdf implements zzdv {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzc = new AtomicReference<>();
    private final SSLSocketFactory zzd = new zzcnp(this);
    private final int zze;
    private final int zzf;
    private final String zzg;
    private final zzdu zzh;
    private zzdm zzi;
    private HttpURLConnection zzj;
    private InputStream zzk;
    private boolean zzl;
    private int zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    /* access modifiers changed from: private */
    public int zzr;
    private final Set<Socket> zzs = new HashSet();

    public zzcnq(String str, zzdx zzdx, int i11, int i12, int i13) {
        super(true);
        zzdy.zzc(str);
        this.zzg = str;
        this.zzh = new zzdu();
        this.zze = i11;
        this.zzf = i12;
        this.zzr = i13;
        if (zzdx != null) {
            zzb(zzdx);
        }
    }

    private final void zzn() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e11) {
                zzciz.zzh("Unexpected error while disconnecting", e11);
            }
            this.zzj = null;
        }
    }

    public final Map<String, List<String>> zza() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    public final int zzg(byte[] bArr, int i11, int i12) throws zzds {
        try {
            if (this.zzp != this.zzn) {
                byte[] andSet = zzc.getAndSet((Object) null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (true) {
                    long j11 = this.zzp;
                    long j12 = this.zzn;
                    if (j11 == j12) {
                        zzc.set(andSet);
                        break;
                    }
                    int read = this.zzk.read(andSet, 0, (int) Math.min(j12 - j11, (long) andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.zzp += (long) read;
                        zzc(read);
                    } else {
                        throw new EOFException();
                    }
                }
            }
            if (i12 == 0) {
                return 0;
            }
            long j13 = this.zzo;
            if (j13 != -1) {
                long j14 = j13 - this.zzq;
                if (j14 != 0) {
                    i12 = (int) Math.min((long) i12, j14);
                }
                return -1;
            }
            int read2 = this.zzk.read(bArr, i11, i12);
            if (read2 != -1) {
                this.zzq += (long) read2;
                zzc(read2);
                return read2;
            } else if (this.zzo == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e11) {
            throw new zzds(e11, this.zzi, 2000, 2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x010f, code lost:
        if (r2 != 0) goto L_0x0114;
     */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzh(com.google.android.gms.internal.ads.zzdm r22) throws com.google.android.gms.internal.ads.zzds {
        /*
            r21 = this;
            r1 = r21
            r7 = r22
            java.lang.String r2 = "Unable to connect to "
            r1.zzi = r7
            r3 = 0
            r1.zzq = r3
            r1.zzp = r3
            r5 = 1
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x02da }
            android.net.Uri r6 = r7.zza     // Catch:{ IOException -> 0x02da }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x02da }
            r0.<init>(r6)     // Catch:{ IOException -> 0x02da }
            long r8 = r7.zzf     // Catch:{ IOException -> 0x02da }
            long r10 = r7.zzg     // Catch:{ IOException -> 0x02da }
            boolean r6 = r7.zzb(r5)     // Catch:{ IOException -> 0x02da }
            r13 = 0
        L_0x0023:
            int r14 = r13 + 1
            r15 = 20
            if (r13 > r15) goto L_0x02c1
            java.net.URLConnection r13 = r0.openConnection()     // Catch:{ IOException -> 0x02da }
            java.net.URLConnection r13 = com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation.openConnection(r13)     // Catch:{ IOException -> 0x02da }
            java.net.HttpURLConnection r13 = (java.net.HttpURLConnection) r13     // Catch:{ IOException -> 0x02da }
            boolean r5 = r13 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ IOException -> 0x02da }
            if (r5 == 0) goto L_0x003f
            r5 = r13
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch:{ IOException -> 0x02da }
            javax.net.ssl.SSLSocketFactory r12 = r1.zzd     // Catch:{ IOException -> 0x02da }
            r5.setSSLSocketFactory(r12)     // Catch:{ IOException -> 0x02da }
        L_0x003f:
            int r5 = r1.zze     // Catch:{ IOException -> 0x02da }
            r13.setConnectTimeout(r5)     // Catch:{ IOException -> 0x02da }
            int r5 = r1.zzf     // Catch:{ IOException -> 0x02da }
            r13.setReadTimeout(r5)     // Catch:{ IOException -> 0x02da }
            com.google.android.gms.internal.ads.zzdu r5 = r1.zzh     // Catch:{ IOException -> 0x02da }
            java.util.Map r5 = r5.zza()     // Catch:{ IOException -> 0x02da }
            java.util.Set r5 = r5.entrySet()     // Catch:{ IOException -> 0x02da }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x02da }
        L_0x0057:
            boolean r12 = r5.hasNext()     // Catch:{ IOException -> 0x02da }
            if (r12 == 0) goto L_0x0077
            java.lang.Object r12 = r5.next()     // Catch:{ IOException -> 0x02da }
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12     // Catch:{ IOException -> 0x02da }
            java.lang.Object r16 = r12.getKey()     // Catch:{ IOException -> 0x02da }
            r15 = r16
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ IOException -> 0x02da }
            java.lang.Object r12 = r12.getValue()     // Catch:{ IOException -> 0x02da }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ IOException -> 0x02da }
            r13.setRequestProperty(r15, r12)     // Catch:{ IOException -> 0x02da }
            r15 = 20
            goto L_0x0057
        L_0x0077:
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            r12 = 27
            r17 = -1
            if (r5 != 0) goto L_0x0083
            int r5 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r5 == 0) goto L_0x00bd
        L_0x0083:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02da }
            r5.<init>(r12)     // Catch:{ IOException -> 0x02da }
            java.lang.String r15 = "bytes="
            r5.append(r15)     // Catch:{ IOException -> 0x02da }
            r5.append(r8)     // Catch:{ IOException -> 0x02da }
            java.lang.String r15 = "-"
            r5.append(r15)     // Catch:{ IOException -> 0x02da }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x02da }
            int r15 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r15 == 0) goto L_0x00b8
            long r19 = r8 + r10
            long r3 = r19 + r17
            int r15 = r5.length()     // Catch:{ IOException -> 0x02da }
            r16 = 20
            int r15 = r15 + 20
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02da }
            r12.<init>(r15)     // Catch:{ IOException -> 0x02da }
            r12.append(r5)     // Catch:{ IOException -> 0x02da }
            r12.append(r3)     // Catch:{ IOException -> 0x02da }
            java.lang.String r5 = r12.toString()     // Catch:{ IOException -> 0x02da }
        L_0x00b8:
            java.lang.String r3 = "Range"
            r13.setRequestProperty(r3, r5)     // Catch:{ IOException -> 0x02da }
        L_0x00bd:
            java.lang.String r3 = "User-Agent"
            java.lang.String r4 = r1.zzg     // Catch:{ IOException -> 0x02da }
            r13.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x02da }
            if (r6 != 0) goto L_0x00cd
            java.lang.String r3 = "Accept-Encoding"
            java.lang.String r4 = "identity"
            r13.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x02da }
        L_0x00cd:
            r3 = 0
            r13.setInstanceFollowRedirects(r3)     // Catch:{ IOException -> 0x02da }
            r13.setDoOutput(r3)     // Catch:{ IOException -> 0x02da }
            r13.connect()     // Catch:{ IOException -> 0x02da }
            int r4 = r13.getResponseCode()     // Catch:{ IOException -> 0x02da }
            r5 = 300(0x12c, float:4.2E-43)
            if (r4 == r5) goto L_0x0270
            r5 = 301(0x12d, float:4.22E-43)
            if (r4 == r5) goto L_0x0270
            r5 = 302(0x12e, float:4.23E-43)
            if (r4 == r5) goto L_0x0270
            r5 = 303(0x12f, float:4.25E-43)
            if (r4 == r5) goto L_0x0270
            r5 = 307(0x133, float:4.3E-43)
            if (r4 == r5) goto L_0x0270
            r5 = 308(0x134, float:4.32E-43)
            if (r4 != r5) goto L_0x00f5
            goto L_0x0270
        L_0x00f5:
            r1.zzj = r13     // Catch:{ IOException -> 0x02da }
            int r0 = r13.getResponseCode()     // Catch:{ IOException -> 0x024a }
            r1.zzm = r0     // Catch:{ IOException -> 0x024a }
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 < r2) goto L_0x0222
            r3 = 299(0x12b, float:4.19E-43)
            if (r0 <= r3) goto L_0x0107
            goto L_0x0222
        L_0x0107:
            if (r0 != r2) goto L_0x0112
            long r2 = r7.zzf
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0112
            goto L_0x0114
        L_0x0112:
            r2 = 0
        L_0x0114:
            r1.zzn = r2
            r2 = 1
            boolean r0 = r7.zzb(r2)
            if (r0 != 0) goto L_0x0200
            long r2 = r7.zzg
            int r0 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x0127
            r1.zzo = r2
            goto L_0x0204
        L_0x0127:
            java.net.HttpURLConnection r0 = r1.zzj
            java.lang.String r2 = "Content-Length"
            java.lang.String r2 = r0.getHeaderField(r2)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r4 = "]"
            if (r3 != 0) goto L_0x015d
            long r5 = java.lang.Long.parseLong(r2)     // Catch:{ NumberFormatException -> 0x013c }
            goto L_0x015f
        L_0x013c:
            java.lang.String r3 = java.lang.String.valueOf(r2)
            int r3 = r3.length()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r3 = r3 + 28
            r5.<init>(r3)
            java.lang.String r3 = "Unexpected Content-Length ["
            r5.append(r3)
            r5.append(r2)
            r5.append(r4)
            java.lang.String r3 = r5.toString()
            com.google.android.gms.internal.ads.zzciz.zzg(r3)
        L_0x015d:
            r5 = r17
        L_0x015f:
            java.lang.String r3 = "Content-Range"
            java.lang.String r0 = r0.getHeaderField(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x01f3
            java.util.regex.Pattern r3 = zzb
            java.util.regex.Matcher r3 = r3.matcher(r0)
            boolean r8 = r3.find()
            if (r8 == 0) goto L_0x01f3
            r8 = 2
            java.lang.String r8 = r3.group(r8)     // Catch:{ NumberFormatException -> 0x01d1 }
            long r8 = java.lang.Long.parseLong(r8)     // Catch:{ NumberFormatException -> 0x01d1 }
            r10 = 1
            java.lang.String r3 = r3.group(r10)     // Catch:{ NumberFormatException -> 0x01d1 }
            long r10 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x01d1 }
            long r8 = r8 - r10
            r10 = 1
            long r8 = r8 + r10
            r19 = 0
            int r3 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r3 >= 0) goto L_0x0195
            r5 = r8
            goto L_0x01f3
        L_0x0195:
            int r3 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x01f3
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ NumberFormatException -> 0x01d1 }
            int r3 = r3.length()     // Catch:{ NumberFormatException -> 0x01d1 }
            int r3 = r3 + 26
            java.lang.String r10 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x01d1 }
            int r10 = r10.length()     // Catch:{ NumberFormatException -> 0x01d1 }
            int r3 = r3 + r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x01d1 }
            r10.<init>(r3)     // Catch:{ NumberFormatException -> 0x01d1 }
            java.lang.String r3 = "Inconsistent headers ["
            r10.append(r3)     // Catch:{ NumberFormatException -> 0x01d1 }
            r10.append(r2)     // Catch:{ NumberFormatException -> 0x01d1 }
            java.lang.String r2 = "] ["
            r10.append(r2)     // Catch:{ NumberFormatException -> 0x01d1 }
            r10.append(r0)     // Catch:{ NumberFormatException -> 0x01d1 }
            r10.append(r4)     // Catch:{ NumberFormatException -> 0x01d1 }
            java.lang.String r2 = r10.toString()     // Catch:{ NumberFormatException -> 0x01d1 }
            com.google.android.gms.internal.ads.zzciz.zzj(r2)     // Catch:{ NumberFormatException -> 0x01d1 }
            long r2 = java.lang.Math.max(r5, r8)     // Catch:{ NumberFormatException -> 0x01d1 }
            r5 = r2
            goto L_0x01f3
        L_0x01d1:
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r8 = 27
            int r2 = r2 + r8
            r3.<init>(r2)
            java.lang.String r2 = "Unexpected Content-Range ["
            r3.append(r2)
            r3.append(r0)
            r3.append(r4)
            java.lang.String r0 = r3.toString()
            com.google.android.gms.internal.ads.zzciz.zzg(r0)
        L_0x01f3:
            int r0 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x01fb
            long r2 = r1.zzn
            long r17 = r5 - r2
        L_0x01fb:
            r2 = r17
            r1.zzo = r2
            goto L_0x0204
        L_0x0200:
            long r2 = r7.zzg
            r1.zzo = r2
        L_0x0204:
            java.net.HttpURLConnection r0 = r1.zzj     // Catch:{ IOException -> 0x0215 }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x0215 }
            r1.zzk = r0     // Catch:{ IOException -> 0x0215 }
            r2 = 1
            r1.zzl = r2
            r21.zzf(r22)
            long r2 = r1.zzo
            return r2
        L_0x0215:
            r0 = move-exception
            r21.zzn()
            com.google.android.gms.internal.ads.zzds r2 = new com.google.android.gms.internal.ads.zzds
            r3 = 2000(0x7d0, float:2.803E-42)
            r4 = 1
            r2.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzdm) r7, (int) r3, (int) r4)
            throw r2
        L_0x0222:
            java.net.HttpURLConnection r0 = r1.zzj
            java.util.Map r6 = r0.getHeaderFields()
            r21.zzn()
            com.google.android.gms.internal.ads.zzdt r0 = new com.google.android.gms.internal.ads.zzdt
            int r3 = r1.zzm
            r4 = 0
            r5 = 0
            byte[] r8 = com.google.android.gms.internal.ads.zzfn.zzf
            r2 = r0
            r7 = r22
            r2.<init>(r3, r4, r5, r6, r7, r8)
            int r2 = r1.zzm
            r3 = 416(0x1a0, float:5.83E-43)
            if (r2 != r3) goto L_0x0249
            com.google.android.gms.internal.ads.zzdj r2 = new com.google.android.gms.internal.ads.zzdj
            r3 = 2008(0x7d8, float:2.814E-42)
            r2.<init>(r3)
            r0.initCause(r2)
        L_0x0249:
            throw r0
        L_0x024a:
            r0 = move-exception
            r21.zzn()
            com.google.android.gms.internal.ads.zzds r3 = new com.google.android.gms.internal.ads.zzds
            android.net.Uri r4 = r7.zza
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r5 = r4.length()
            if (r5 == 0) goto L_0x0265
            java.lang.String r2 = r2.concat(r4)
            goto L_0x026b
        L_0x0265:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r2)
            r2 = r4
        L_0x026b:
            r4 = 1
            r3.<init>((java.lang.String) r2, (java.io.IOException) r0, (com.google.android.gms.internal.ads.zzdm) r7, (int) r4)
            throw r3
        L_0x0270:
            r19 = 0
            java.lang.String r4 = "Location"
            java.lang.String r4 = r13.getHeaderField(r4)     // Catch:{ IOException -> 0x02da }
            r13.disconnect()     // Catch:{ IOException -> 0x02da }
            if (r4 == 0) goto L_0x02b9
            java.net.URL r5 = new java.net.URL     // Catch:{ IOException -> 0x02da }
            r5.<init>(r0, r4)     // Catch:{ IOException -> 0x02da }
            java.lang.String r0 = r5.getProtocol()     // Catch:{ IOException -> 0x02da }
            java.lang.String r4 = "https"
            boolean r4 = r4.equals(r0)     // Catch:{ IOException -> 0x02da }
            if (r4 != 0) goto L_0x02b2
            java.lang.String r4 = "http"
            boolean r4 = r4.equals(r0)     // Catch:{ IOException -> 0x02da }
            if (r4 != 0) goto L_0x02b2
            java.net.ProtocolException r3 = new java.net.ProtocolException     // Catch:{ IOException -> 0x02da }
            java.lang.String r4 = "Unsupported protocol redirect: "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x02da }
            int r5 = r0.length()     // Catch:{ IOException -> 0x02da }
            if (r5 == 0) goto L_0x02a9
            java.lang.String r0 = r4.concat(r0)     // Catch:{ IOException -> 0x02da }
            goto L_0x02ae
        L_0x02a9:
            java.lang.String r0 = new java.lang.String     // Catch:{ IOException -> 0x02da }
            r0.<init>(r4)     // Catch:{ IOException -> 0x02da }
        L_0x02ae:
            r3.<init>(r0)     // Catch:{ IOException -> 0x02da }
            throw r3     // Catch:{ IOException -> 0x02da }
        L_0x02b2:
            r0 = r5
            r13 = r14
            r3 = r19
            r5 = 1
            goto L_0x0023
        L_0x02b9:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x02da }
            java.lang.String r3 = "Null location redirect"
            r0.<init>(r3)     // Catch:{ IOException -> 0x02da }
            throw r0     // Catch:{ IOException -> 0x02da }
        L_0x02c1:
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x02da }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02da }
            r4 = 31
            r3.<init>(r4)     // Catch:{ IOException -> 0x02da }
            java.lang.String r4 = "Too many redirects: "
            r3.append(r4)     // Catch:{ IOException -> 0x02da }
            r3.append(r14)     // Catch:{ IOException -> 0x02da }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x02da }
            r0.<init>(r3)     // Catch:{ IOException -> 0x02da }
            throw r0     // Catch:{ IOException -> 0x02da }
        L_0x02da:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzds r3 = new com.google.android.gms.internal.ads.zzds
            android.net.Uri r4 = r7.zza
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r5 = r4.length()
            if (r5 == 0) goto L_0x02f2
            java.lang.String r2 = r2.concat(r4)
            goto L_0x02f8
        L_0x02f2:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r2)
            r2 = r4
        L_0x02f8:
            r4 = 1
            r3.<init>((java.lang.String) r2, (java.io.IOException) r0, (com.google.android.gms.internal.ads.zzdm) r7, (int) r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcnq.zzh(com.google.android.gms.internal.ads.zzdm):long");
    }

    public final Uri zzi() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:4|(1:6)(1:7)|8|9|(5:13|14|(2:16|(1:18))(2:19|(1:21))|22|(1:26))|27|28) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0067 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj() throws com.google.android.gms.internal.ads.zzds {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.zzk     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x0079
            java.net.HttpURLConnection r2 = r9.zzj     // Catch:{ all -> 0x008d }
            long r3 = r9.zzo     // Catch:{ all -> 0x008d }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            long r7 = r9.zzq     // Catch:{ all -> 0x008d }
            long r3 = r3 - r7
        L_0x0014:
            int r7 = com.google.android.gms.internal.ads.zzfn.zza     // Catch:{ all -> 0x008d }
            r8 = 19
            if (r7 == r8) goto L_0x001f
            r8 = 20
            if (r7 == r8) goto L_0x001f
            goto L_0x0067
        L_0x001f:
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x0067 }
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x002f
            int r3 = r2.read()     // Catch:{ Exception -> 0x0067 }
            r4 = -1
            if (r3 == r4) goto L_0x0067
            goto L_0x0036
        L_0x002f:
            r5 = 2048(0x800, double:1.0118E-320)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x0036
            goto L_0x0067
        L_0x0036:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x0067 }
            if (r4 != 0) goto L_0x004e
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x0067 }
            if (r3 == 0) goto L_0x0067
        L_0x004e:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x0067 }
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0067 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x0067 }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x0067 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0067 }
            r3.invoke(r2, r4)     // Catch:{ Exception -> 0x0067 }
        L_0x0067:
            java.io.InputStream r2 = r9.zzk     // Catch:{ IOException -> 0x006d }
            r2.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0079
        L_0x006d:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzds r3 = new com.google.android.gms.internal.ads.zzds     // Catch:{ all -> 0x008d }
            com.google.android.gms.internal.ads.zzdm r4 = r9.zzi     // Catch:{ all -> 0x008d }
            r5 = 2000(0x7d0, float:2.803E-42)
            r6 = 3
            r3.<init>((java.io.IOException) r2, (com.google.android.gms.internal.ads.zzdm) r4, (int) r5, (int) r6)     // Catch:{ all -> 0x008d }
            throw r3     // Catch:{ all -> 0x008d }
        L_0x0079:
            r9.zzk = r0
            r9.zzn()
            boolean r0 = r9.zzl
            if (r0 == 0) goto L_0x0087
            r9.zzl = r1
            r9.zzd()
        L_0x0087:
            java.util.Set<java.net.Socket> r0 = r9.zzs
            r0.clear()
            return
        L_0x008d:
            r2 = move-exception
            r9.zzk = r0
            r9.zzn()
            boolean r0 = r9.zzl
            if (r0 == 0) goto L_0x009c
            r9.zzl = r1
            r9.zzd()
        L_0x009c:
            java.util.Set<java.net.Socket> r0 = r9.zzs
            r0.clear()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcnq.zzj():void");
    }

    public final void zzm(int i11) {
        this.zzr = i11;
        for (Socket next : this.zzs) {
            if (!next.isClosed()) {
                try {
                    next.setReceiveBufferSize(this.zzr);
                } catch (SocketException e11) {
                    zzciz.zzk("Failed to update receive buffer size.", e11);
                }
            }
        }
    }
}
