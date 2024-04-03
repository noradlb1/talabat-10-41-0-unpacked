package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import datamodels.TypesAliasesKt;
import java.util.Arrays;
import java.util.HashSet;

public final class zzfnj {
    public static boolean zza(int i11) {
        int i12 = i11 - 1;
        return i12 == 2 || i12 == 4 || i12 == 5 || i12 == 6;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00a2 */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x011d  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x0060=Splitter:B:17:0x0060, B:39:0x00a2=Splitter:B:39:0x00a2} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int zzb(android.content.Context r13, com.google.android.gms.internal.ads.zzfmh r14) {
        /*
            java.io.File r0 = new java.io.File
            java.io.File r1 = new java.io.File
            android.content.pm.ApplicationInfo r2 = r13.getApplicationInfo()
            java.lang.String r2 = r2.dataDir
            r1.<init>(r2)
            java.lang.String r2 = "lib"
            r0.<init>(r1, r2)
            boolean r1 = r0.exists()
            r2 = 5017(0x1399, float:7.03E-42)
            r3 = 7
            r4 = 6
            r5 = 1000(0x3e8, float:1.401E-42)
            r6 = 0
            r7 = 5
            r8 = 3
            r9 = 1
            if (r1 != 0) goto L_0x002a
            java.lang.String r0 = "No lib/"
            r14.zzb(r2, r0)
        L_0x0027:
            r0 = r5
            goto L_0x00b4
        L_0x002a:
            com.google.android.gms.internal.ads.zzfuy r1 = new com.google.android.gms.internal.ads.zzfuy
            java.lang.String r10 = ".*\\.so$"
            r11 = 2
            java.util.regex.Pattern r10 = java.util.regex.Pattern.compile(r10, r11)
            r1.<init>(r10)
            java.io.File[] r0 = r0.listFiles(r1)
            if (r0 == 0) goto L_0x00ad
            int r1 = r0.length
            if (r1 != 0) goto L_0x0041
            goto L_0x00ad
        L_0x0041:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00a3 }
            r2 = 0
            r0 = r0[r2]     // Catch:{ IOException -> 0x00a3 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x00a3 }
            r0 = 20
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x009e }
            int r12 = r1.read(r10)     // Catch:{ all -> 0x009e }
            if (r12 != r0) goto L_0x0060
            byte[] r0 = new byte[r11]     // Catch:{ all -> 0x009e }
            r0[r2] = r2     // Catch:{ all -> 0x009e }
            r0[r9] = r2     // Catch:{ all -> 0x009e }
            byte r12 = r10[r7]     // Catch:{ all -> 0x009e }
            if (r12 != r11) goto L_0x0064
            zzd(r10, r6, r13, r14)     // Catch:{ all -> 0x009e }
        L_0x0060:
            r1.close()     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00ab
        L_0x0064:
            r11 = 19
            byte r11 = r10[r11]     // Catch:{ all -> 0x009e }
            r0[r2] = r11     // Catch:{ all -> 0x009e }
            r2 = 18
            byte r2 = r10[r2]     // Catch:{ all -> 0x009e }
            r0[r9] = r2     // Catch:{ all -> 0x009e }
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r0)     // Catch:{ all -> 0x009e }
            short r0 = r0.getShort()     // Catch:{ all -> 0x009e }
            if (r0 == r8) goto L_0x0099
            r2 = 40
            if (r0 == r2) goto L_0x0094
            r2 = 62
            if (r0 == r2) goto L_0x008f
            r2 = 183(0xb7, float:2.56E-43)
            if (r0 == r2) goto L_0x008a
            zzd(r10, r6, r13, r14)     // Catch:{ all -> 0x009e }
            goto L_0x0060
        L_0x008a:
            r1.close()     // Catch:{ IOException -> 0x00a3 }
            r0 = r4
            goto L_0x00b4
        L_0x008f:
            r1.close()     // Catch:{ IOException -> 0x00a3 }
            r0 = r3
            goto L_0x00b4
        L_0x0094:
            r1.close()     // Catch:{ IOException -> 0x00a3 }
            r0 = r8
            goto L_0x00b4
        L_0x0099:
            r1.close()     // Catch:{ IOException -> 0x00a3 }
            r0 = r7
            goto L_0x00b4
        L_0x009e:
            r0 = move-exception
            r1.close()     // Catch:{ all -> 0x00a2 }
        L_0x00a2:
            throw r0     // Catch:{ IOException -> 0x00a3 }
        L_0x00a3:
            r0 = move-exception
            java.lang.String r0 = r0.toString()
            zzd(r6, r0, r13, r14)
        L_0x00ab:
            r0 = r9
            goto L_0x00b4
        L_0x00ad:
            java.lang.String r0 = "No .so"
            r14.zzb(r2, r0)
            goto L_0x0027
        L_0x00b4:
            if (r0 != r5) goto L_0x0104
            java.lang.String r0 = zzc(r13, r14)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x00c7
            java.lang.String r0 = "Empty dev arch"
            zzd(r6, r0, r13, r14)
        L_0x00c5:
            r0 = r9
            goto L_0x0104
        L_0x00c7:
            java.lang.String r1 = "i686"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x0103
            java.lang.String r1 = "x86"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00d8
            goto L_0x0103
        L_0x00d8:
            java.lang.String r1 = "x86_64"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00e2
            r0 = r3
            goto L_0x0104
        L_0x00e2:
            java.lang.String r1 = "arm64-v8a"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00ec
            r0 = r4
            goto L_0x0104
        L_0x00ec:
            java.lang.String r1 = "armeabi-v7a"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x0101
            java.lang.String r1 = "armv71"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00fd
            goto L_0x0101
        L_0x00fd:
            zzd(r6, r0, r13, r14)
            goto L_0x00c5
        L_0x0101:
            r0 = r8
            goto L_0x0104
        L_0x0103:
            r0 = r7
        L_0x0104:
            if (r0 == r9) goto L_0x011d
            if (r0 == r8) goto L_0x011a
            if (r0 == r7) goto L_0x0117
            if (r0 == r4) goto L_0x0114
            if (r0 == r3) goto L_0x0111
            java.lang.String r13 = "null"
            goto L_0x011f
        L_0x0111:
            java.lang.String r13 = "X86_64"
            goto L_0x011f
        L_0x0114:
            java.lang.String r13 = "ARM64"
            goto L_0x011f
        L_0x0117:
            java.lang.String r13 = "X86"
            goto L_0x011f
        L_0x011a:
            java.lang.String r13 = "ARM7"
            goto L_0x011f
        L_0x011d:
            java.lang.String r13 = "UNSUPPORTED"
        L_0x011f:
            r1 = 5018(0x139a, float:7.032E-42)
            r14.zzb(r1, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfnj.zzb(android.content.Context, com.google.android.gms.internal.ads.zzfmh):int");
    }

    private static final String zzc(Context context, zzfmh zzfmh) {
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"i686", "armv71"}));
        String zza = zzfqq.OS_ARCH.zza();
        if (!TextUtils.isEmpty(zza) && hashSet.contains(zza)) {
            return zza;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (NoSuchFieldException e11) {
            zzfmh.zzc(2024, 0, e11);
        } catch (IllegalAccessException e12) {
            zzfmh.zzc(2024, 0, e12);
        }
        String str = Build.CPU_ABI;
        if (str != null) {
            return str;
        }
        return Build.CPU_ABI2;
    }

    private static final void zzd(byte[] bArr, String str, Context context, zzfmh zzfmh) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("os.arch:");
        sb2.append(zzfqq.OS_ARCH.zza());
        sb2.append(TypesAliasesKt.separator);
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
            if (strArr != null) {
                sb2.append("supported_abis:");
                sb2.append(Arrays.toString(strArr));
                sb2.append(TypesAliasesKt.separator);
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        sb2.append("CPU_ABI:");
        sb2.append(Build.CPU_ABI);
        sb2.append(";CPU_ABI2:");
        sb2.append(Build.CPU_ABI2);
        sb2.append(TypesAliasesKt.separator);
        if (bArr != null) {
            sb2.append("ELF:");
            sb2.append(Arrays.toString(bArr));
            sb2.append(TypesAliasesKt.separator);
        }
        if (str != null) {
            sb2.append("dbg:");
            sb2.append(str);
            sb2.append(TypesAliasesKt.separator);
        }
        zzfmh.zzb(4007, sb2.toString());
    }
}
