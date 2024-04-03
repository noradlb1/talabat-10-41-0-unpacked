package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.FileInputStream;
import java.io.IOException;

public final class zzti extends zzdf {
    private final ContentResolver zza;
    @Nullable
    private Uri zzb;
    @Nullable
    private AssetFileDescriptor zzc;
    @Nullable
    private FileInputStream zzd;
    private long zze;
    private boolean zzf;

    public zzti(Context context) {
        super(false);
        this.zza = context.getContentResolver();
    }

    public final int zzg(byte[] bArr, int i11, int i12) throws zzth {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.zze;
        if (j11 == 0) {
            return -1;
        }
        if (j11 != -1) {
            try {
                i12 = (int) Math.min(j11, (long) i12);
            } catch (IOException e11) {
                throw new zzth(e11, 2000);
            }
        }
        FileInputStream fileInputStream = this.zzd;
        int i13 = zzfn.zza;
        int read = fileInputStream.read(bArr, i11, i12);
        if (read == -1) {
            return -1;
        }
        long j12 = this.zze;
        if (j12 != -1) {
            this.zze = j12 - ((long) read);
        }
        zzc(read);
        return read;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0101, code lost:
        r3 = com.google.android.exoplayer2.PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0107, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0108, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0107 A[ExcHandler: zzth (r0v1 'e' com.google.android.gms.internal.ads.zzth A[CUSTOM_DECLARE]), Splitter:B:1:0x0003] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzh(com.google.android.gms.internal.ads.zzdm r16) throws com.google.android.gms.internal.ads.zzth {
        /*
            r15 = this;
            r1 = r15
            r0 = r16
            android.net.Uri r4 = r0.zza     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            r1.zzb = r4     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            r15.zze(r16)     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            java.lang.String r5 = "content"
            android.net.Uri r6 = r0.zza     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            java.lang.String r6 = r6.getScheme()     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            boolean r5 = r5.equals(r6)     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            if (r5 == 0) goto L_0x002f
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            r5.<init>()     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            int r6 = com.google.android.gms.internal.ads.zzfn.zza     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            r7 = 31
            if (r6 < r7) goto L_0x0026
            com.google.android.gms.internal.ads.zztg.zza(r5)     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
        L_0x0026:
            android.content.ContentResolver r6 = r1.zza     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            java.lang.String r7 = "*/*"
            android.content.res.AssetFileDescriptor r5 = r6.openTypedAssetFileDescriptor(r4, r7, r5)     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            goto L_0x0037
        L_0x002f:
            android.content.ContentResolver r5 = r1.zza     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            java.lang.String r6 = "r"
            android.content.res.AssetFileDescriptor r5 = r5.openAssetFileDescriptor(r4, r6)     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
        L_0x0037:
            r1.zzc = r5     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            if (r5 == 0) goto L_0x00cc
            long r6 = r5.getLength()     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            java.io.FileDescriptor r8 = r5.getFileDescriptor()     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            r4.<init>(r8)     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            r1.zzd = r4     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            r8 = -1
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            r11 = 2008(0x7d8, float:2.814E-42)
            r12 = 0
            if (r10 == 0) goto L_0x0060
            long r13 = r0.zzf     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            int r13 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r13 > 0) goto L_0x005a
            goto L_0x0060
        L_0x005a:
            com.google.android.gms.internal.ads.zzth r0 = new com.google.android.gms.internal.ads.zzth     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            r0.<init>(r12, r11)     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            throw r0     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
        L_0x0060:
            long r13 = r5.getStartOffset()     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            long r2 = r0.zzf     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            long r2 = r2 + r13
            long r2 = r4.skip(r2)     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            long r2 = r2 - r13
            long r13 = r0.zzf     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            int r13 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r13 != 0) goto L_0x00c6
            r13 = 0
            if (r10 != 0) goto L_0x0098
            java.nio.channels.FileChannel r2 = r4.getChannel()     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            long r3 = r2.size()     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            int r6 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r6 != 0) goto L_0x0086
            r1.zze = r8     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            r3 = r8
            goto L_0x00a0
        L_0x0086:
            long r6 = r2.position()     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            long r3 = r3 - r6
            r1.zze = r3     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            int r2 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r2 < 0) goto L_0x0092
            goto L_0x00a0
        L_0x0092:
            com.google.android.gms.internal.ads.zzth r0 = new com.google.android.gms.internal.ads.zzth     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            r0.<init>(r12, r11)     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            throw r0     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
        L_0x0098:
            long r3 = r6 - r2
            r1.zze = r3     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            int r2 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r2 < 0) goto L_0x00c0
        L_0x00a0:
            long r5 = r0.zzg
            int r2 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x00b0
            int r2 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x00ae
            long r5 = java.lang.Math.min(r3, r5)
        L_0x00ae:
            r1.zze = r5
        L_0x00b0:
            r2 = 1
            r1.zzf = r2
            r15.zzf(r16)
            long r2 = r0.zzg
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x00bd
            return r2
        L_0x00bd:
            long r2 = r1.zze
            return r2
        L_0x00c0:
            com.google.android.gms.internal.ads.zzth r0 = new com.google.android.gms.internal.ads.zzth     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            r0.<init>(r12, r11)     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            throw r0     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
        L_0x00c6:
            com.google.android.gms.internal.ads.zzth r0 = new com.google.android.gms.internal.ads.zzth     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            r0.<init>(r12, r11)     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            throw r0     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
        L_0x00cc:
            com.google.android.gms.internal.ads.zzth r0 = new com.google.android.gms.internal.ads.zzth     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            java.lang.String r3 = java.lang.String.valueOf(r4)     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            int r4 = r3.length()     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            int r4 = r4 + 36
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            r6.<init>(r4)     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            java.lang.String r4 = "Could not open file descriptor for: "
            r6.append(r4)     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            r6.append(r3)     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            java.lang.String r3 = r6.toString()     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            r2.<init>(r3)     // Catch:{ zzth -> 0x0107, IOException -> 0x00f6 }
            r3 = 2000(0x7d0, float:2.803E-42)
            r0.<init>(r2, r3)     // Catch:{ zzth -> 0x0107, IOException -> 0x00f4 }
            throw r0     // Catch:{ zzth -> 0x0107, IOException -> 0x00f4 }
        L_0x00f4:
            r0 = move-exception
            goto L_0x00f9
        L_0x00f6:
            r0 = move-exception
            r3 = 2000(0x7d0, float:2.803E-42)
        L_0x00f9:
            com.google.android.gms.internal.ads.zzth r2 = new com.google.android.gms.internal.ads.zzth
            boolean r4 = r0 instanceof java.io.FileNotFoundException
            r5 = 1
            if (r5 == r4) goto L_0x0101
            goto L_0x0103
        L_0x0101:
            r3 = 2005(0x7d5, float:2.81E-42)
        L_0x0103:
            r2.<init>(r0, r3)
            throw r2
        L_0x0107:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzti.zzh(com.google.android.gms.internal.ads.zzdm):long");
    }

    @Nullable
    public final Uri zzi() {
        return this.zzb;
    }

    public final void zzj() throws zzth {
        this.zzb = null;
        try {
            FileInputStream fileInputStream = this.zzd;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.zzd = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.zzc;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzd();
                }
            } catch (IOException e11) {
                throw new zzth(e11, 2000);
            } catch (Throwable th2) {
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzd();
                }
                throw th2;
            }
        } catch (IOException e12) {
            throw new zzth(e12, 2000);
        } catch (Throwable th3) {
            this.zzd = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.zzc;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzd();
                }
                throw th3;
            } catch (IOException e13) {
                throw new zzth(e13, 2000);
            } catch (Throwable th4) {
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzd();
                }
                throw th4;
            }
        }
    }
}
