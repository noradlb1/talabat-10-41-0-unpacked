package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class zzuf extends zzdf {
    private final Resources zza;
    private final String zzb;
    @Nullable
    private Uri zzc;
    @Nullable
    private AssetFileDescriptor zzd;
    @Nullable
    private InputStream zze;
    private long zzf;
    private boolean zzg;

    public zzuf(Context context) {
        super(false);
        this.zza = context.getResources();
        this.zzb = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i11) {
        StringBuilder sb2 = new StringBuilder(26);
        sb2.append("rawresource:///");
        sb2.append(i11);
        return Uri.parse(sb2.toString());
    }

    public final int zzg(byte[] bArr, int i11, int i12) throws zzue {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.zzf;
        if (j11 == 0) {
            return -1;
        }
        if (j11 != -1) {
            try {
                i12 = (int) Math.min(j11, (long) i12);
            } catch (IOException e11) {
                throw new zzue((String) null, e11, 2000);
            }
        }
        InputStream inputStream = this.zze;
        int i13 = zzfn.zza;
        int read = inputStream.read(bArr, i11, i12);
        if (read != -1) {
            long j12 = this.zzf;
            if (j12 != -1) {
                this.zzf = j12 - ((long) read);
            }
            zzc(read);
            return read;
        } else if (this.zzf == -1) {
            return -1;
        } else {
            throw new zzue("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003c, code lost:
        if (r3.matches("\\d+") != false) goto L_0x00a8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0162  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzh(com.google.android.gms.internal.ads.zzdm r16) throws com.google.android.gms.internal.ads.zzue {
        /*
            r15 = this;
            r1 = r15
            r0 = r16
            android.net.Uri r2 = r0.zza
            r1.zzc = r2
            java.lang.String r3 = r2.getScheme()
            java.lang.String r4 = "rawresource"
            boolean r3 = android.text.TextUtils.equals(r4, r3)
            r4 = 2005(0x7d5, float:2.81E-42)
            r5 = 1004(0x3ec, float:1.407E-42)
            r6 = 1
            r7 = 0
            if (r3 != 0) goto L_0x00a8
            java.lang.String r3 = r2.getScheme()
            java.lang.String r8 = "android.resource"
            boolean r3 = android.text.TextUtils.equals(r8, r3)
            if (r3 == 0) goto L_0x003f
            java.util.List r3 = r2.getPathSegments()
            int r3 = r3.size()
            if (r3 != r6) goto L_0x003f
            java.lang.String r3 = r2.getLastPathSegment()
            r3.getClass()
            java.lang.String r9 = "\\d+"
            boolean r3 = r3.matches(r9)
            if (r3 == 0) goto L_0x003f
            goto L_0x00a8
        L_0x003f:
            java.lang.String r3 = r2.getScheme()
            boolean r3 = android.text.TextUtils.equals(r8, r3)
            if (r3 == 0) goto L_0x00a0
            java.lang.String r3 = r2.getPath()
            r3.getClass()
            java.lang.String r5 = "/"
            boolean r5 = r3.startsWith(r5)
            if (r5 == 0) goto L_0x005c
            java.lang.String r3 = r3.substring(r6)
        L_0x005c:
            java.lang.String r5 = r2.getHost()
            boolean r8 = android.text.TextUtils.isEmpty(r5)
            if (r8 == 0) goto L_0x0069
            java.lang.String r5 = ""
            goto L_0x0073
        L_0x0069:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r8 = ":"
            java.lang.String r5 = r5.concat(r8)
        L_0x0073:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r8 = r3.length()
            if (r8 == 0) goto L_0x0086
            java.lang.String r3 = r5.concat(r3)
            goto L_0x008b
        L_0x0086:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r5)
        L_0x008b:
            android.content.res.Resources r5 = r1.zza
            java.lang.String r8 = "raw"
            java.lang.String r9 = r1.zzb
            int r3 = r5.getIdentifier(r3, r8, r9)
            if (r3 == 0) goto L_0x0098
            goto L_0x00b3
        L_0x0098:
            com.google.android.gms.internal.ads.zzue r0 = new com.google.android.gms.internal.ads.zzue
            java.lang.String r2 = "Resource not found."
            r0.<init>(r2, r7, r4)
            throw r0
        L_0x00a0:
            com.google.android.gms.internal.ads.zzue r0 = new com.google.android.gms.internal.ads.zzue
            java.lang.String r2 = "URI must either use scheme rawresource or android.resource"
            r0.<init>(r2, r7, r5)
            throw r0
        L_0x00a8:
            java.lang.String r3 = r2.getLastPathSegment()     // Catch:{ NumberFormatException -> 0x017b }
            r3.getClass()
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x017b }
        L_0x00b3:
            r15.zze(r16)
            android.content.res.Resources r5 = r1.zza     // Catch:{ NotFoundException -> 0x0173 }
            android.content.res.AssetFileDescriptor r3 = r5.openRawResourceFd(r3)     // Catch:{ NotFoundException -> 0x0173 }
            r1.zzd = r3
            r4 = 2000(0x7d0, float:2.803E-42)
            if (r3 == 0) goto L_0x0162
            long r8 = r3.getLength()
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.FileDescriptor r5 = r3.getFileDescriptor()
            r2.<init>(r5)
            r1.zze = r2
            r10 = -1
            int r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            r12 = 2008(0x7d8, float:2.814E-42)
            if (r5 == 0) goto L_0x00e6
            long r13 = r0.zzf     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            int r13 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r13 > 0) goto L_0x00e0
            goto L_0x00e6
        L_0x00e0:
            com.google.android.gms.internal.ads.zzue r0 = new com.google.android.gms.internal.ads.zzue     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            r0.<init>(r7, r7, r12)     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            throw r0     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
        L_0x00e6:
            long r13 = r3.getStartOffset()     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            long r6 = r0.zzf     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            long r6 = r6 + r13
            long r6 = r2.skip(r6)     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            long r6 = r6 - r13
            long r13 = r0.zzf     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            int r13 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r13 != 0) goto L_0x0151
            r13 = 0
            if (r5 != 0) goto L_0x0123
            java.nio.channels.FileChannel r2 = r2.getChannel()     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            long r5 = r2.size()     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            int r5 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r5 != 0) goto L_0x010c
            r1.zzf = r10     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            r5 = r10
            goto L_0x012b
        L_0x010c:
            long r5 = r2.size()     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            long r7 = r2.position()     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            long r5 = r5 - r7
            r1.zzf = r5     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            int r2 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r2 < 0) goto L_0x011c
            goto L_0x012b
        L_0x011c:
            com.google.android.gms.internal.ads.zzue r0 = new com.google.android.gms.internal.ads.zzue     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            r2 = 0
            r0.<init>(r2, r2, r12)     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            throw r0     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
        L_0x0123:
            long r5 = r8 - r6
            r1.zzf = r5     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            int r2 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r2 < 0) goto L_0x014b
        L_0x012b:
            long r2 = r0.zzg
            int r4 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x013b
            int r4 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x0139
            long r2 = java.lang.Math.min(r5, r2)
        L_0x0139:
            r1.zzf = r2
        L_0x013b:
            r2 = 1
            r1.zzg = r2
            r15.zzf(r16)
            long r2 = r0.zzg
            int r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x0148
            return r2
        L_0x0148:
            long r2 = r1.zzf
            return r2
        L_0x014b:
            com.google.android.gms.internal.ads.zzdj r0 = new com.google.android.gms.internal.ads.zzdj     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            r0.<init>(r12)     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            throw r0     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
        L_0x0151:
            com.google.android.gms.internal.ads.zzue r0 = new com.google.android.gms.internal.ads.zzue     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            r2 = 0
            r0.<init>(r2, r2, r12)     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
            throw r0     // Catch:{ zzue -> 0x0160, IOException -> 0x0158 }
        L_0x0158:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzue r2 = new com.google.android.gms.internal.ads.zzue
            r3 = 0
            r2.<init>(r3, r0, r4)
            throw r2
        L_0x0160:
            r0 = move-exception
            throw r0
        L_0x0162:
            r3 = r7
            com.google.android.gms.internal.ads.zzue r0 = new com.google.android.gms.internal.ads.zzue
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r5 = "Resource is compressed: "
            java.lang.String r2 = r5.concat(r2)
            r0.<init>(r2, r3, r4)
            throw r0
        L_0x0173:
            r0 = move-exception
            r3 = r7
            com.google.android.gms.internal.ads.zzue r2 = new com.google.android.gms.internal.ads.zzue
            r2.<init>(r3, r0, r4)
            throw r2
        L_0x017b:
            r3 = r7
            com.google.android.gms.internal.ads.zzue r0 = new com.google.android.gms.internal.ads.zzue
            java.lang.String r2 = "Resource identifier must be an integer."
            r0.<init>(r2, r3, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuf.zzh(com.google.android.gms.internal.ads.zzdm):long");
    }

    @Nullable
    public final Uri zzi() {
        return this.zzc;
    }

    public final void zzj() throws zzue {
        this.zzc = null;
        try {
            InputStream inputStream = this.zze;
            if (inputStream != null) {
                inputStream.close();
            }
            this.zze = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.zzd;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.zzd = null;
                if (this.zzg) {
                    this.zzg = false;
                    zzd();
                }
            } catch (IOException e11) {
                throw new zzue((String) null, e11, 2000);
            } catch (Throwable th2) {
                this.zzd = null;
                if (this.zzg) {
                    this.zzg = false;
                    zzd();
                }
                throw th2;
            }
        } catch (IOException e12) {
            throw new zzue((String) null, e12, 2000);
        } catch (Throwable th3) {
            this.zze = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.zzd;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.zzd = null;
                if (this.zzg) {
                    this.zzg = false;
                    zzd();
                }
                throw th3;
            } catch (IOException e13) {
                throw new zzue((String) null, e13, 2000);
            } catch (Throwable th4) {
                this.zzd = null;
                if (this.zzg) {
                    this.zzg = false;
                    zzd();
                }
                throw th4;
            }
        }
    }
}
