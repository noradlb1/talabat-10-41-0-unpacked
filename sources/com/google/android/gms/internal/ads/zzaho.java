package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class zzaho implements zzagc {
    private final Map<String, zzahl> zza = new LinkedHashMap(16, 0.75f, true);
    private long zzb = 0;
    private final zzahn zzc;
    private final int zzd;

    public zzaho(zzahn zzahn, int i11) {
        this.zzc = zzahn;
        this.zzd = 5242880;
    }

    public static int zze(InputStream inputStream) throws IOException {
        return (zzn(inputStream) << 24) | zzn(inputStream) | (zzn(inputStream) << 8) | (zzn(inputStream) << 16);
    }

    public static long zzf(InputStream inputStream) throws IOException {
        return (((long) zzn(inputStream)) & 255) | ((((long) zzn(inputStream)) & 255) << 8) | ((((long) zzn(inputStream)) & 255) << 16) | ((((long) zzn(inputStream)) & 255) << 24) | ((((long) zzn(inputStream)) & 255) << 32) | ((((long) zzn(inputStream)) & 255) << 40) | ((((long) zzn(inputStream)) & 255) << 48) | ((255 & ((long) zzn(inputStream))) << 56);
    }

    public static String zzh(zzahm zzahm) throws IOException {
        return new String(zzm(zzahm, zzf(zzahm)), "UTF-8");
    }

    public static void zzj(OutputStream outputStream, int i11) throws IOException {
        outputStream.write(i11 & 255);
        outputStream.write((i11 >> 8) & 255);
        outputStream.write((i11 >> 16) & 255);
        outputStream.write((i11 >> 24) & 255);
    }

    public static void zzk(OutputStream outputStream, long j11) throws IOException {
        outputStream.write((byte) ((int) j11));
        outputStream.write((byte) ((int) (j11 >>> 8)));
        outputStream.write((byte) ((int) (j11 >>> 16)));
        outputStream.write((byte) ((int) (j11 >>> 24)));
        outputStream.write((byte) ((int) (j11 >>> 32)));
        outputStream.write((byte) ((int) (j11 >>> 40)));
        outputStream.write((byte) ((int) (j11 >>> 48)));
        outputStream.write((byte) ((int) (j11 >>> 56)));
    }

    public static void zzl(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        int length = bytes.length;
        zzk(outputStream, (long) length);
        outputStream.write(bytes, 0, length);
    }

    @VisibleForTesting
    public static byte[] zzm(zzahm zzahm, long j11) throws IOException {
        long zza2 = zzahm.zza();
        if (j11 >= 0 && j11 <= zza2) {
            int i11 = (int) j11;
            if (((long) i11) == j11) {
                byte[] bArr = new byte[i11];
                new DataInputStream(zzahm).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb2 = new StringBuilder(73);
        sb2.append("streamToBytes length=");
        sb2.append(j11);
        sb2.append(", maxLength=");
        sb2.append(zza2);
        throw new IOException(sb2.toString());
    }

    private static int zzn(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private final void zzo(String str, zzahl zzahl) {
        if (!this.zza.containsKey(str)) {
            this.zzb += zzahl.zza;
        } else {
            this.zzb += zzahl.zza - this.zza.get(str).zza;
        }
        this.zza.put(str, zzahl);
    }

    private final void zzp(String str) {
        zzahl remove = this.zza.remove(str);
        if (remove != null) {
            this.zzb -= remove.zza;
        }
    }

    private static final String zzq(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        if (valueOf2.length() != 0) {
            return valueOf.concat(valueOf2);
        }
        return new String(valueOf);
    }

    public final synchronized zzagb zza(String str) {
        zzahm zzahm;
        zzahl zzahl = this.zza.get(str);
        if (zzahl == null) {
            return null;
        }
        File zzg = zzg(str);
        try {
            zzahm = new zzahm(new BufferedInputStream(new FileInputStream(zzg)), zzg.length());
            zzahl zza2 = zzahl.zza(zzahm);
            if (!TextUtils.equals(str, zza2.zzb)) {
                zzahe.zza("%s: key=%s, found=%s", zzg.getAbsolutePath(), str, zza2.zzb);
                zzp(str);
                zzahm.close();
                return null;
            }
            byte[] zzm = zzm(zzahm, zzahm.zza());
            zzagb zzagb = new zzagb();
            zzagb.zza = zzm;
            zzagb.zzb = zzahl.zzc;
            zzagb.zzc = zzahl.zzd;
            zzagb.zzd = zzahl.zze;
            zzagb.zze = zzahl.zzf;
            zzagb.zzf = zzahl.zzg;
            List<zzagk> list = zzahl.zzh;
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (zzagk next : list) {
                treeMap.put(next.zza(), next.zzb());
            }
            zzagb.zzg = treeMap;
            zzagb.zzh = Collections.unmodifiableList(zzahl.zzh);
            zzahm.close();
            return zzagb;
        } catch (IOException e11) {
            zzahe.zza("%s: %s", zzg.getAbsolutePath(), e11.toString());
            zzi(str);
            return null;
        } catch (Throwable th2) {
            zzahm.close();
            throw th2;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x005a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb() {
        /*
            r9 = this;
            monitor-enter(r9)
            com.google.android.gms.internal.ads.zzahn r0 = r9.zzc     // Catch:{ all -> 0x0062 }
            java.io.File r0 = r0.zza()     // Catch:{ all -> 0x0062 }
            boolean r1 = r0.exists()     // Catch:{ all -> 0x0062 }
            r2 = 0
            if (r1 != 0) goto L_0x0026
            boolean r1 = r0.mkdirs()     // Catch:{ all -> 0x0062 }
            if (r1 != 0) goto L_0x0024
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0062 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0062 }
            r1[r2] = r0     // Catch:{ all -> 0x0062 }
            java.lang.String r0 = "Unable to create cache dir %s"
            com.google.android.gms.internal.ads.zzahe.zzb(r0, r1)     // Catch:{ all -> 0x0062 }
            monitor-exit(r9)
            return
        L_0x0024:
            monitor-exit(r9)
            return
        L_0x0026:
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x0062 }
            if (r0 != 0) goto L_0x002e
            monitor-exit(r9)
            return
        L_0x002e:
            int r1 = r0.length     // Catch:{ all -> 0x0062 }
        L_0x002f:
            if (r2 >= r1) goto L_0x0060
            r3 = r0[r2]     // Catch:{ all -> 0x0062 }
            long r4 = r3.length()     // Catch:{ IOException -> 0x005a }
            com.google.android.gms.internal.ads.zzahm r6 = new com.google.android.gms.internal.ads.zzahm     // Catch:{ IOException -> 0x005a }
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x005a }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ IOException -> 0x005a }
            r8.<init>(r3)     // Catch:{ IOException -> 0x005a }
            r7.<init>(r8)     // Catch:{ IOException -> 0x005a }
            r6.<init>(r7, r4)     // Catch:{ IOException -> 0x005a }
            com.google.android.gms.internal.ads.zzahl r7 = com.google.android.gms.internal.ads.zzahl.zza(r6)     // Catch:{ all -> 0x0055 }
            r7.zza = r4     // Catch:{ all -> 0x0055 }
            java.lang.String r4 = r7.zzb     // Catch:{ all -> 0x0055 }
            r9.zzo(r4, r7)     // Catch:{ all -> 0x0055 }
            r6.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005d
        L_0x0055:
            r4 = move-exception
            r6.close()     // Catch:{ IOException -> 0x005a }
            throw r4     // Catch:{ IOException -> 0x005a }
        L_0x005a:
            r3.delete()     // Catch:{ all -> 0x0062 }
        L_0x005d:
            int r2 = r2 + 1
            goto L_0x002f
        L_0x0060:
            monitor-exit(r9)
            return
        L_0x0062:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaho.zzb():void");
    }

    public final synchronized void zzc(String str, boolean z11) {
        zzagb zza2 = zza(str);
        if (zza2 != null) {
            zza2.zzf = 0;
            zza2.zze = 0;
            zzd(str, zza2);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0163 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzd(java.lang.String r16, com.google.android.gms.internal.ads.zzagb r17) {
        /*
            r15 = this;
            r1 = r15
            r0 = r16
            r2 = r17
            monitor-enter(r15)
            long r3 = r1.zzb     // Catch:{ all -> 0x019a }
            byte[] r5 = r2.zza     // Catch:{ all -> 0x019a }
            int r5 = r5.length     // Catch:{ all -> 0x019a }
            int r6 = r1.zzd     // Catch:{ all -> 0x019a }
            long r7 = (long) r5
            long r3 = r3 + r7
            long r7 = (long) r6
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            r4 = 1063675494(0x3f666666, float:0.9)
            if (r3 <= 0) goto L_0x0021
            float r3 = (float) r5
            float r5 = (float) r6
            float r5 = r5 * r4
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            monitor-exit(r15)
            return
        L_0x0021:
            java.io.File r3 = r15.zzg(r16)     // Catch:{ all -> 0x019a }
            r6 = 0
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0163 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0163 }
            r8.<init>(r3)     // Catch:{ IOException -> 0x0163 }
            r7.<init>(r8)     // Catch:{ IOException -> 0x0163 }
            com.google.android.gms.internal.ads.zzahl r8 = new com.google.android.gms.internal.ads.zzahl     // Catch:{ IOException -> 0x0163 }
            r8.<init>(r0, r2)     // Catch:{ IOException -> 0x0163 }
            r9 = 538247942(0x20150306, float:1.2621791E-19)
            zzj(r7, r9)     // Catch:{ IOException -> 0x013d }
            java.lang.String r9 = r8.zzb     // Catch:{ IOException -> 0x013d }
            zzl(r7, r9)     // Catch:{ IOException -> 0x013d }
            java.lang.String r9 = r8.zzc     // Catch:{ IOException -> 0x013d }
            if (r9 != 0) goto L_0x0046
            java.lang.String r9 = ""
        L_0x0046:
            zzl(r7, r9)     // Catch:{ IOException -> 0x013d }
            long r9 = r8.zzd     // Catch:{ IOException -> 0x013d }
            zzk(r7, r9)     // Catch:{ IOException -> 0x013d }
            long r9 = r8.zze     // Catch:{ IOException -> 0x013d }
            zzk(r7, r9)     // Catch:{ IOException -> 0x013d }
            long r9 = r8.zzf     // Catch:{ IOException -> 0x013d }
            zzk(r7, r9)     // Catch:{ IOException -> 0x013d }
            long r9 = r8.zzg     // Catch:{ IOException -> 0x013d }
            zzk(r7, r9)     // Catch:{ IOException -> 0x013d }
            java.util.List<com.google.android.gms.internal.ads.zzagk> r9 = r8.zzh     // Catch:{ IOException -> 0x013d }
            if (r9 == 0) goto L_0x0087
            int r10 = r9.size()     // Catch:{ IOException -> 0x013d }
            zzj(r7, r10)     // Catch:{ IOException -> 0x013d }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ IOException -> 0x013d }
        L_0x006c:
            boolean r10 = r9.hasNext()     // Catch:{ IOException -> 0x013d }
            if (r10 == 0) goto L_0x008a
            java.lang.Object r10 = r9.next()     // Catch:{ IOException -> 0x013d }
            com.google.android.gms.internal.ads.zzagk r10 = (com.google.android.gms.internal.ads.zzagk) r10     // Catch:{ IOException -> 0x013d }
            java.lang.String r11 = r10.zza()     // Catch:{ IOException -> 0x013d }
            zzl(r7, r11)     // Catch:{ IOException -> 0x013d }
            java.lang.String r10 = r10.zzb()     // Catch:{ IOException -> 0x013d }
            zzl(r7, r10)     // Catch:{ IOException -> 0x013d }
            goto L_0x006c
        L_0x0087:
            zzj(r7, r6)     // Catch:{ IOException -> 0x013d }
        L_0x008a:
            r7.flush()     // Catch:{ IOException -> 0x013d }
            byte[] r2 = r2.zza     // Catch:{ IOException -> 0x0163 }
            r7.write(r2)     // Catch:{ IOException -> 0x0163 }
            r7.close()     // Catch:{ IOException -> 0x0163 }
            long r9 = r3.length()     // Catch:{ IOException -> 0x0163 }
            r8.zza = r9     // Catch:{ IOException -> 0x0163 }
            r15.zzo(r0, r8)     // Catch:{ IOException -> 0x0163 }
            long r7 = r1.zzb     // Catch:{ IOException -> 0x0163 }
            int r0 = r1.zzd     // Catch:{ IOException -> 0x0163 }
            long r9 = (long) r0     // Catch:{ IOException -> 0x0163 }
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 >= 0) goto L_0x00a9
            goto L_0x0198
        L_0x00a9:
            boolean r0 = com.google.android.gms.internal.ads.zzahe.zzb     // Catch:{ IOException -> 0x0163 }
            if (r0 == 0) goto L_0x00b4
            java.lang.String r0 = "Pruning old cache entries."
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ IOException -> 0x0163 }
            com.google.android.gms.internal.ads.zzahe.zzd(r0, r2)     // Catch:{ IOException -> 0x0163 }
        L_0x00b4:
            long r7 = r1.zzb     // Catch:{ IOException -> 0x0163 }
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0163 }
            java.util.Map<java.lang.String, com.google.android.gms.internal.ads.zzahl> r0 = r1.zza     // Catch:{ IOException -> 0x0163 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ IOException -> 0x0163 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x0163 }
            r2 = r6
        L_0x00c5:
            boolean r11 = r0.hasNext()     // Catch:{ IOException -> 0x0163 }
            r12 = 2
            if (r11 == 0) goto L_0x0114
            java.lang.Object r11 = r0.next()     // Catch:{ IOException -> 0x0163 }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ IOException -> 0x0163 }
            java.lang.Object r11 = r11.getValue()     // Catch:{ IOException -> 0x0163 }
            com.google.android.gms.internal.ads.zzahl r11 = (com.google.android.gms.internal.ads.zzahl) r11     // Catch:{ IOException -> 0x0163 }
            java.lang.String r13 = r11.zzb     // Catch:{ IOException -> 0x0163 }
            java.io.File r13 = r15.zzg(r13)     // Catch:{ IOException -> 0x0163 }
            boolean r13 = r13.delete()     // Catch:{ IOException -> 0x0163 }
            if (r13 == 0) goto L_0x00ec
            long r13 = r1.zzb     // Catch:{ IOException -> 0x0163 }
            long r4 = r11.zza     // Catch:{ IOException -> 0x0163 }
            long r13 = r13 - r4
            r1.zzb = r13     // Catch:{ IOException -> 0x0163 }
            goto L_0x00fe
        L_0x00ec:
            java.lang.String r4 = "Could not delete cache entry for key=%s, filename=%s"
            java.lang.Object[] r5 = new java.lang.Object[r12]     // Catch:{ IOException -> 0x0163 }
            java.lang.String r11 = r11.zzb     // Catch:{ IOException -> 0x0163 }
            r5[r6] = r11     // Catch:{ IOException -> 0x0163 }
            java.lang.String r11 = zzq(r11)     // Catch:{ IOException -> 0x0163 }
            r13 = 1
            r5[r13] = r11     // Catch:{ IOException -> 0x0163 }
            com.google.android.gms.internal.ads.zzahe.zza(r4, r5)     // Catch:{ IOException -> 0x0163 }
        L_0x00fe:
            r0.remove()     // Catch:{ IOException -> 0x0163 }
            int r2 = r2 + 1
            long r4 = r1.zzb     // Catch:{ IOException -> 0x0163 }
            float r4 = (float) r4     // Catch:{ IOException -> 0x0163 }
            int r5 = r1.zzd     // Catch:{ IOException -> 0x0163 }
            float r5 = (float) r5     // Catch:{ IOException -> 0x0163 }
            r11 = 1063675494(0x3f666666, float:0.9)
            float r5 = r5 * r11
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0112
            goto L_0x0114
        L_0x0112:
            r4 = r11
            goto L_0x00c5
        L_0x0114:
            boolean r0 = com.google.android.gms.internal.ads.zzahe.zzb     // Catch:{ IOException -> 0x0163 }
            if (r0 == 0) goto L_0x0198
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ IOException -> 0x0163 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x0163 }
            r0[r6] = r2     // Catch:{ IOException -> 0x0163 }
            long r4 = r1.zzb     // Catch:{ IOException -> 0x0163 }
            long r4 = r4 - r7
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ IOException -> 0x0163 }
            r4 = 1
            r0[r4] = r2     // Catch:{ IOException -> 0x0163 }
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0163 }
            long r4 = r4 - r9
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ IOException -> 0x0163 }
            r0[r12] = r2     // Catch:{ IOException -> 0x0163 }
            java.lang.String r2 = "pruned %d files, %d bytes, %d ms"
            com.google.android.gms.internal.ads.zzahe.zzd(r2, r0)     // Catch:{ IOException -> 0x0163 }
            monitor-exit(r15)
            return
        L_0x013d:
            r0 = move-exception
            r2 = 1
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x0163 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0163 }
            r4[r6] = r0     // Catch:{ IOException -> 0x0163 }
            java.lang.String r0 = "%s"
            com.google.android.gms.internal.ads.zzahe.zza(r0, r4)     // Catch:{ IOException -> 0x0163 }
            r7.close()     // Catch:{ IOException -> 0x0163 }
            java.lang.String r0 = "Failed to write header for %s"
            r2 = 1
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x0163 }
            java.lang.String r2 = r3.getAbsolutePath()     // Catch:{ IOException -> 0x0163 }
            r4[r6] = r2     // Catch:{ IOException -> 0x0163 }
            com.google.android.gms.internal.ads.zzahe.zza(r0, r4)     // Catch:{ IOException -> 0x0163 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0163 }
            r0.<init>()     // Catch:{ IOException -> 0x0163 }
            throw r0     // Catch:{ IOException -> 0x0163 }
        L_0x0163:
            boolean r0 = r3.delete()     // Catch:{ all -> 0x019a }
            if (r0 != 0) goto L_0x0177
            r2 = 1
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x019a }
            java.lang.String r2 = r3.getAbsolutePath()     // Catch:{ all -> 0x019a }
            r0[r6] = r2     // Catch:{ all -> 0x019a }
            java.lang.String r2 = "Could not clean up file %s"
            com.google.android.gms.internal.ads.zzahe.zza(r2, r0)     // Catch:{ all -> 0x019a }
        L_0x0177:
            com.google.android.gms.internal.ads.zzahn r0 = r1.zzc     // Catch:{ all -> 0x019a }
            java.io.File r0 = r0.zza()     // Catch:{ all -> 0x019a }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x019a }
            if (r0 != 0) goto L_0x0198
            java.lang.String r0 = "Re-initializing cache after external clearing."
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x019a }
            com.google.android.gms.internal.ads.zzahe.zza(r0, r2)     // Catch:{ all -> 0x019a }
            java.util.Map<java.lang.String, com.google.android.gms.internal.ads.zzahl> r0 = r1.zza     // Catch:{ all -> 0x019a }
            r0.clear()     // Catch:{ all -> 0x019a }
            r2 = 0
            r1.zzb = r2     // Catch:{ all -> 0x019a }
            r15.zzb()     // Catch:{ all -> 0x019a }
            monitor-exit(r15)
            return
        L_0x0198:
            monitor-exit(r15)
            return
        L_0x019a:
            r0 = move-exception
            monitor-exit(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaho.zzd(java.lang.String, com.google.android.gms.internal.ads.zzagb):void");
    }

    public final File zzg(String str) {
        return new File(this.zzc.zza(), zzq(str));
    }

    public final synchronized void zzi(String str) {
        boolean delete = zzg(str).delete();
        zzp(str);
        if (!delete) {
            zzahe.zza("Could not delete cache entry for key=%s, filename=%s", str, zzq(str));
        }
    }

    public zzaho(File file, int i11) {
        this.zzc = new zzahk(this, file);
        this.zzd = 20971520;
    }
}
