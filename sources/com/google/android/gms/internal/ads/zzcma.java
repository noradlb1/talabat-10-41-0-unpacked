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
final class zzcma implements zzawf {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzc = new AtomicReference<>();
    private final SSLSocketFactory zzd = new zzclz(this);
    private final int zze;
    private final int zzf;
    private final String zzg;
    private final zzawe zzh;
    private final zzawl<? super zzcma> zzi;
    private zzavy zzj;
    private HttpURLConnection zzk;
    private InputStream zzl;
    private boolean zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    /* access modifiers changed from: private */
    public int zzr;
    private final Set<Socket> zzs = new HashSet();

    public zzcma(String str, zzawl<? super zzcma> zzawl, int i11, int i12, int i13) {
        zzawm.zzb(str);
        this.zzg = str;
        this.zzi = zzawl;
        this.zzh = new zzawe();
        this.zze = i11;
        this.zzf = i12;
        this.zzr = i13;
    }

    private final void zzi() {
        HttpURLConnection httpURLConnection = this.zzk;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e11) {
                zzciz.zzh("Unexpected error while disconnecting", e11);
            }
            this.zzk = null;
        }
    }

    public final int zza(byte[] bArr, int i11, int i12) throws zzawc {
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
                    int read = this.zzl.read(andSet, 0, (int) Math.min(j12 - j11, (long) andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.zzp += (long) read;
                        zzawl<? super zzcma> zzawl = this.zzi;
                        if (zzawl != null) {
                            ((zzcmn) zzawl).zzW(this, read);
                        }
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
            int read2 = this.zzl.read(bArr, i11, i12);
            if (read2 != -1) {
                this.zzq += (long) read2;
                zzawl<? super zzcma> zzawl2 = this.zzi;
                if (zzawl2 == null) {
                    return read2;
                }
                ((zzcmn) zzawl2).zzW(this, read2);
                return read2;
            } else if (this.zzo == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e11) {
            throw new zzawc(e11, this.zzj, 2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0101, code lost:
        if (r3 != 0) goto L_0x0106;
     */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzb(com.google.android.gms.internal.ads.zzavy r22) throws com.google.android.gms.internal.ads.zzawc {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            java.lang.String r3 = "Unable to connect to "
            r1.zzj = r2
            r4 = 0
            r1.zzq = r4
            r1.zzp = r4
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x02b6 }
            android.net.Uri r7 = r2.zza     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x02b6 }
            r0.<init>(r7)     // Catch:{ IOException -> 0x02b6 }
            long r7 = r2.zzc     // Catch:{ IOException -> 0x02b6 }
            long r9 = r2.zzd     // Catch:{ IOException -> 0x02b6 }
            r12 = 0
        L_0x001e:
            int r13 = r12 + 1
            r14 = 20
            if (r12 > r14) goto L_0x029d
            java.net.URLConnection r12 = r0.openConnection()     // Catch:{ IOException -> 0x02b6 }
            java.net.URLConnection r12 = com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation.openConnection(r12)     // Catch:{ IOException -> 0x02b6 }
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ IOException -> 0x02b6 }
            boolean r15 = r12 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ IOException -> 0x02b6 }
            if (r15 == 0) goto L_0x003a
            r15 = r12
            javax.net.ssl.HttpsURLConnection r15 = (javax.net.ssl.HttpsURLConnection) r15     // Catch:{ IOException -> 0x02b6 }
            javax.net.ssl.SSLSocketFactory r6 = r1.zzd     // Catch:{ IOException -> 0x02b6 }
            r15.setSSLSocketFactory(r6)     // Catch:{ IOException -> 0x02b6 }
        L_0x003a:
            int r6 = r1.zze     // Catch:{ IOException -> 0x02b6 }
            r12.setConnectTimeout(r6)     // Catch:{ IOException -> 0x02b6 }
            int r6 = r1.zzf     // Catch:{ IOException -> 0x02b6 }
            r12.setReadTimeout(r6)     // Catch:{ IOException -> 0x02b6 }
            com.google.android.gms.internal.ads.zzawe r6 = r1.zzh     // Catch:{ IOException -> 0x02b6 }
            java.util.Map r6 = r6.zza()     // Catch:{ IOException -> 0x02b6 }
            java.util.Set r6 = r6.entrySet()     // Catch:{ IOException -> 0x02b6 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IOException -> 0x02b6 }
        L_0x0052:
            boolean r15 = r6.hasNext()     // Catch:{ IOException -> 0x02b6 }
            if (r15 == 0) goto L_0x0070
            java.lang.Object r15 = r6.next()     // Catch:{ IOException -> 0x02b6 }
            java.util.Map$Entry r15 = (java.util.Map.Entry) r15     // Catch:{ IOException -> 0x02b6 }
            java.lang.Object r16 = r15.getKey()     // Catch:{ IOException -> 0x02b6 }
            r11 = r16
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ IOException -> 0x02b6 }
            java.lang.Object r15 = r15.getValue()     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ IOException -> 0x02b6 }
            r12.setRequestProperty(r11, r15)     // Catch:{ IOException -> 0x02b6 }
            goto L_0x0052
        L_0x0070:
            int r6 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            r11 = 27
            r17 = -1
            if (r6 != 0) goto L_0x007c
            int r6 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r6 == 0) goto L_0x00b3
        L_0x007c:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02b6 }
            r6.<init>(r11)     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r15 = "bytes="
            r6.append(r15)     // Catch:{ IOException -> 0x02b6 }
            r6.append(r7)     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r15 = "-"
            r6.append(r15)     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x02b6 }
            int r15 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r15 == 0) goto L_0x00ae
            long r19 = r7 + r9
            long r4 = r19 + r17
            int r15 = r6.length()     // Catch:{ IOException -> 0x02b6 }
            int r15 = r15 + r14
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02b6 }
            r14.<init>(r15)     // Catch:{ IOException -> 0x02b6 }
            r14.append(r6)     // Catch:{ IOException -> 0x02b6 }
            r14.append(r4)     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r6 = r14.toString()     // Catch:{ IOException -> 0x02b6 }
        L_0x00ae:
            java.lang.String r4 = "Range"
            r12.setRequestProperty(r4, r6)     // Catch:{ IOException -> 0x02b6 }
        L_0x00b3:
            java.lang.String r4 = "User-Agent"
            java.lang.String r5 = r1.zzg     // Catch:{ IOException -> 0x02b6 }
            r12.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r4 = "Accept-Encoding"
            java.lang.String r5 = "identity"
            r12.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x02b6 }
            r4 = 0
            r12.setInstanceFollowRedirects(r4)     // Catch:{ IOException -> 0x02b6 }
            r12.setDoOutput(r4)     // Catch:{ IOException -> 0x02b6 }
            r12.connect()     // Catch:{ IOException -> 0x02b6 }
            int r4 = r12.getResponseCode()     // Catch:{ IOException -> 0x02b6 }
            r5 = 300(0x12c, float:4.2E-43)
            if (r4 == r5) goto L_0x024d
            r5 = 301(0x12d, float:4.22E-43)
            if (r4 == r5) goto L_0x024d
            r5 = 302(0x12e, float:4.23E-43)
            if (r4 == r5) goto L_0x024d
            r5 = 303(0x12f, float:4.25E-43)
            if (r4 == r5) goto L_0x024d
            r5 = 307(0x133, float:4.3E-43)
            if (r4 == r5) goto L_0x024d
            r5 = 308(0x134, float:4.32E-43)
            if (r4 != r5) goto L_0x00e9
            goto L_0x024d
        L_0x00e9:
            r1.zzk = r12     // Catch:{ IOException -> 0x02b6 }
            int r0 = r12.getResponseCode()     // Catch:{ IOException -> 0x0226 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 < r3) goto L_0x020a
            r4 = 299(0x12b, float:4.19E-43)
            if (r0 <= r4) goto L_0x00f9
            goto L_0x020a
        L_0x00f9:
            if (r0 != r3) goto L_0x0104
            long r3 = r2.zzc
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0104
            goto L_0x0106
        L_0x0104:
            r3 = 0
        L_0x0106:
            r1.zzn = r3
            long r3 = r2.zzd
            int r0 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x0112
            r1.zzo = r3
            goto L_0x01e8
        L_0x0112:
            java.net.HttpURLConnection r0 = r1.zzk
            java.lang.String r3 = "Content-Length"
            java.lang.String r3 = r0.getHeaderField(r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r5 = "]"
            if (r4 != 0) goto L_0x0148
            long r6 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x0127 }
            goto L_0x014a
        L_0x0127:
            java.lang.String r4 = java.lang.String.valueOf(r3)
            int r4 = r4.length()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            int r4 = r4 + 28
            r6.<init>(r4)
            java.lang.String r4 = "Unexpected Content-Length ["
            r6.append(r4)
            r6.append(r3)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
            com.google.android.gms.internal.ads.zzciz.zzg(r4)
        L_0x0148:
            r6 = r17
        L_0x014a:
            java.lang.String r4 = "Content-Range"
            java.lang.String r0 = r0.getHeaderField(r4)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x01dc
            java.util.regex.Pattern r4 = zzb
            java.util.regex.Matcher r4 = r4.matcher(r0)
            boolean r8 = r4.find()
            if (r8 == 0) goto L_0x01dc
            r8 = 2
            java.lang.String r8 = r4.group(r8)     // Catch:{ NumberFormatException -> 0x01bc }
            long r8 = java.lang.Long.parseLong(r8)     // Catch:{ NumberFormatException -> 0x01bc }
            r10 = 1
            java.lang.String r4 = r4.group(r10)     // Catch:{ NumberFormatException -> 0x01bc }
            long r12 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException -> 0x01bc }
            long r8 = r8 - r12
            r12 = 1
            long r8 = r8 + r12
            r14 = 0
            int r4 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r4 >= 0) goto L_0x0180
            r6 = r8
            goto L_0x01dc
        L_0x0180:
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x01dc
            java.lang.String r4 = java.lang.String.valueOf(r3)     // Catch:{ NumberFormatException -> 0x01bc }
            int r4 = r4.length()     // Catch:{ NumberFormatException -> 0x01bc }
            int r4 = r4 + 26
            java.lang.String r10 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x01bc }
            int r10 = r10.length()     // Catch:{ NumberFormatException -> 0x01bc }
            int r4 = r4 + r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x01bc }
            r10.<init>(r4)     // Catch:{ NumberFormatException -> 0x01bc }
            java.lang.String r4 = "Inconsistent headers ["
            r10.append(r4)     // Catch:{ NumberFormatException -> 0x01bc }
            r10.append(r3)     // Catch:{ NumberFormatException -> 0x01bc }
            java.lang.String r3 = "] ["
            r10.append(r3)     // Catch:{ NumberFormatException -> 0x01bc }
            r10.append(r0)     // Catch:{ NumberFormatException -> 0x01bc }
            r10.append(r5)     // Catch:{ NumberFormatException -> 0x01bc }
            java.lang.String r3 = r10.toString()     // Catch:{ NumberFormatException -> 0x01bc }
            com.google.android.gms.internal.ads.zzciz.zzj(r3)     // Catch:{ NumberFormatException -> 0x01bc }
            long r3 = java.lang.Math.max(r6, r8)     // Catch:{ NumberFormatException -> 0x01bc }
            r6 = r3
            goto L_0x01dc
        L_0x01bc:
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r3 = r3 + r11
            r4.<init>(r3)
            java.lang.String r3 = "Unexpected Content-Range ["
            r4.append(r3)
            r4.append(r0)
            r4.append(r5)
            java.lang.String r0 = r4.toString()
            com.google.android.gms.internal.ads.zzciz.zzg(r0)
        L_0x01dc:
            int r0 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x01e4
            long r3 = r1.zzn
            long r17 = r6 - r3
        L_0x01e4:
            r3 = r17
            r1.zzo = r3
        L_0x01e8:
            java.net.HttpURLConnection r0 = r1.zzk     // Catch:{ IOException -> 0x01ff }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x01ff }
            r1.zzl = r0     // Catch:{ IOException -> 0x01ff }
            r3 = 1
            r1.zzm = r3
            com.google.android.gms.internal.ads.zzawl<? super com.google.android.gms.internal.ads.zzcma> r0 = r1.zzi
            if (r0 == 0) goto L_0x01fc
            com.google.android.gms.internal.ads.zzcmn r0 = (com.google.android.gms.internal.ads.zzcmn) r0
            r0.zzk(r1, r2)
        L_0x01fc:
            long r2 = r1.zzo
            return r2
        L_0x01ff:
            r0 = move-exception
            r21.zzi()
            com.google.android.gms.internal.ads.zzawc r3 = new com.google.android.gms.internal.ads.zzawc
            r4 = 1
            r3.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzavy) r2, (int) r4)
            throw r3
        L_0x020a:
            java.net.HttpURLConnection r3 = r1.zzk
            java.util.Map r3 = r3.getHeaderFields()
            r21.zzi()
            com.google.android.gms.internal.ads.zzawd r4 = new com.google.android.gms.internal.ads.zzawd
            r4.<init>(r0, r3, r2)
            r2 = 416(0x1a0, float:5.83E-43)
            if (r0 != r2) goto L_0x0225
            com.google.android.gms.internal.ads.zzavx r0 = new com.google.android.gms.internal.ads.zzavx
            r5 = 0
            r0.<init>(r5)
            r4.initCause(r0)
        L_0x0225:
            throw r4
        L_0x0226:
            r0 = move-exception
            r4 = r0
            r21.zzi()
            com.google.android.gms.internal.ads.zzawc r0 = new com.google.android.gms.internal.ads.zzawc
            android.net.Uri r5 = r2.zza
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x0242
            java.lang.String r3 = r3.concat(r5)
            goto L_0x0248
        L_0x0242:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r3)
            r3 = r5
        L_0x0248:
            r5 = 1
            r0.<init>(r3, r4, r2, r5)
            throw r0
        L_0x024d:
            r5 = 0
            r14 = 0
            java.lang.String r4 = "Location"
            java.lang.String r4 = r12.getHeaderField(r4)     // Catch:{ IOException -> 0x02b6 }
            r12.disconnect()     // Catch:{ IOException -> 0x02b6 }
            if (r4 == 0) goto L_0x0295
            java.net.URL r6 = new java.net.URL     // Catch:{ IOException -> 0x02b6 }
            r6.<init>(r0, r4)     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r0 = r6.getProtocol()     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r4 = "https"
            boolean r4 = r4.equals(r0)     // Catch:{ IOException -> 0x02b6 }
            if (r4 != 0) goto L_0x0290
            java.lang.String r4 = "http"
            boolean r4 = r4.equals(r0)     // Catch:{ IOException -> 0x02b6 }
            if (r4 != 0) goto L_0x0290
            java.net.ProtocolException r4 = new java.net.ProtocolException     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r5 = "Unsupported protocol redirect: "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x02b6 }
            int r6 = r0.length()     // Catch:{ IOException -> 0x02b6 }
            if (r6 == 0) goto L_0x0287
            java.lang.String r0 = r5.concat(r0)     // Catch:{ IOException -> 0x02b6 }
            goto L_0x028c
        L_0x0287:
            java.lang.String r0 = new java.lang.String     // Catch:{ IOException -> 0x02b6 }
            r0.<init>(r5)     // Catch:{ IOException -> 0x02b6 }
        L_0x028c:
            r4.<init>(r0)     // Catch:{ IOException -> 0x02b6 }
            throw r4     // Catch:{ IOException -> 0x02b6 }
        L_0x0290:
            r0 = r6
            r12 = r13
            r4 = r14
            goto L_0x001e
        L_0x0295:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r4 = "Null location redirect"
            r0.<init>(r4)     // Catch:{ IOException -> 0x02b6 }
            throw r0     // Catch:{ IOException -> 0x02b6 }
        L_0x029d:
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x02b6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02b6 }
            r5 = 31
            r4.<init>(r5)     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r5 = "Too many redirects: "
            r4.append(r5)     // Catch:{ IOException -> 0x02b6 }
            r4.append(r13)     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x02b6 }
            r0.<init>(r4)     // Catch:{ IOException -> 0x02b6 }
            throw r0     // Catch:{ IOException -> 0x02b6 }
        L_0x02b6:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzawc r4 = new com.google.android.gms.internal.ads.zzawc
            android.net.Uri r5 = r2.zza
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x02ce
            java.lang.String r3 = r3.concat(r5)
            goto L_0x02d4
        L_0x02ce:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r3)
            r3 = r5
        L_0x02d4:
            r5 = 1
            r4.<init>(r3, r0, r2, r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcma.zzb(com.google.android.gms.internal.ads.zzavy):long");
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzk;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:4|(1:6)(1:7)|8|9|(5:13|14|(2:16|(1:18))(2:19|(1:21))|22|(1:26))|27|28) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0067 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd() throws com.google.android.gms.internal.ads.zzawc {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.zzl     // Catch:{ all -> 0x0088 }
            if (r2 == 0) goto L_0x0077
            java.net.HttpURLConnection r2 = r9.zzk     // Catch:{ all -> 0x0088 }
            long r3 = r9.zzo     // Catch:{ all -> 0x0088 }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            long r7 = r9.zzq     // Catch:{ all -> 0x0088 }
            long r3 = r3 - r7
        L_0x0014:
            int r7 = com.google.android.gms.internal.ads.zzaxb.zza     // Catch:{ all -> 0x0088 }
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
            java.io.InputStream r2 = r9.zzl     // Catch:{ IOException -> 0x006d }
            r2.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0077
        L_0x006d:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzawc r3 = new com.google.android.gms.internal.ads.zzawc     // Catch:{ all -> 0x0088 }
            com.google.android.gms.internal.ads.zzavy r4 = r9.zzj     // Catch:{ all -> 0x0088 }
            r5 = 3
            r3.<init>((java.io.IOException) r2, (com.google.android.gms.internal.ads.zzavy) r4, (int) r5)     // Catch:{ all -> 0x0088 }
            throw r3     // Catch:{ all -> 0x0088 }
        L_0x0077:
            r9.zzl = r0
            r9.zzi()
            boolean r0 = r9.zzm
            if (r0 == 0) goto L_0x0082
            r9.zzm = r1
        L_0x0082:
            java.util.Set<java.net.Socket> r0 = r9.zzs
            r0.clear()
            return
        L_0x0088:
            r2 = move-exception
            r9.zzl = r0
            r9.zzi()
            boolean r0 = r9.zzm
            if (r0 == 0) goto L_0x0094
            r9.zzm = r1
        L_0x0094:
            java.util.Set<java.net.Socket> r0 = r9.zzs
            r0.clear()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcma.zzd():void");
    }

    public final Map<String, List<String>> zze() {
        HttpURLConnection httpURLConnection = this.zzk;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    public final void zzh(int i11) {
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
