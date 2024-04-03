package com.google.android.gms.internal.ads;

import android.os.Build;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzaxb {
    public static final int zza;
    public static final String zzb;
    public static final String zzc;
    public static final String zzd;
    public static final String zze;
    private static final Pattern zzf = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
    private static final Pattern zzg = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
    private static final Pattern zzh = Pattern.compile("%([A-Fa-f0-9]{2})");

    static {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') {
            i11 = 26;
        }
        zza = i11;
        String str = Build.DEVICE;
        zzb = str;
        String str2 = Build.MANUFACTURER;
        zzc = str2;
        String str3 = Build.MODEL;
        zzd = str3;
        int length = String.valueOf(str).length();
        StringBuilder sb2 = new StringBuilder(length + 17 + String.valueOf(str3).length() + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(str3);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(str2);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(i11);
        zze = sb2.toString();
    }

    public static float zza(float f11, float f12, float f13) {
        return Math.max(0.1f, Math.min(f11, 8.0f));
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzb(long[] r3, long r4, boolean r6, boolean r7) {
        /*
            int r0 = java.util.Arrays.binarySearch(r3, r4)
            if (r0 >= 0) goto L_0x0008
            int r4 = ~r0
            goto L_0x0019
        L_0x0008:
            int r0 = r0 + 1
            int r1 = r3.length
            if (r0 >= r1) goto L_0x0013
            r1 = r3[r0]
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0008
        L_0x0013:
            if (r6 == 0) goto L_0x0018
            int r4 = r0 + -1
            goto L_0x0019
        L_0x0018:
            r4 = r0
        L_0x0019:
            if (r7 == 0) goto L_0x0023
            int r3 = r3.length
            int r3 = r3 + -1
            int r3 = java.lang.Math.min(r3, r4)
            return r3
        L_0x0023:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxb.zzb(long[], long, boolean, boolean):int");
    }

    public static int zzc(long[] jArr, long j11, boolean z11, boolean z12) {
        int i11;
        int binarySearch = Arrays.binarySearch(jArr, j11);
        if (binarySearch < 0) {
            i11 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0 || jArr[binarySearch] != j11) {
                    i11 = binarySearch + 1;
                }
                binarySearch--;
                break;
            } while (jArr[binarySearch] != j11);
            i11 = binarySearch + 1;
        }
        if (z12) {
            return Math.max(0, i11);
        }
        return i11;
    }

    public static int zzd(int i11, int i12) {
        return ((i11 + i12) - 1) / i12;
    }

    public static int zze(int i11, int i12, int i13) {
        return Math.max(i12, Math.min(i11, i13));
    }

    public static int zzf(int i11) {
        return i11 != 1 ? 13107200 : 3538944;
    }

    public static int zzg(String str) {
        boolean z11;
        int length = str.length();
        if (length <= 4) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzawm.zzc(z11);
        char c11 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            c11 = (c11 << 8) | str.charAt(i11);
        }
        return c11;
    }

    public static int zzh(int i11) {
        if (i11 == 8) {
            return 3;
        }
        if (i11 == 16) {
            return 2;
        }
        if (i11 != 24) {
            return i11 != 32 ? 0 : 1073741824;
        }
        return Integer.MIN_VALUE;
    }

    public static int zzi(int i11, int i12) {
        if (i11 == Integer.MIN_VALUE) {
            return i12 * 3;
        }
        if (i11 == 1073741824) {
            return i12 * 4;
        }
        if (i11 == 2) {
            return i12 + i12;
        }
        if (i11 == 3) {
            return i12;
        }
        throw new IllegalArgumentException();
    }

    public static long zzj(long j11, long j12, long j13) {
        int i11 = (j13 > j12 ? 1 : (j13 == j12 ? 0 : -1));
        if (i11 >= 0 && j13 % j12 == 0) {
            return j11 / (j13 / j12);
        }
        if (i11 >= 0 || j12 % j13 != 0) {
            return (long) (((double) j11) * (((double) j12) / ((double) j13)));
        }
        return j11 * (j12 / j13);
    }

    public static String zzk(Object[] objArr) {
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        while (true) {
            int length = objArr.length;
            if (i11 >= length) {
                return sb2.toString();
            }
            sb2.append(objArr[i11].getClass().getSimpleName());
            if (i11 < length - 1) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            i11++;
        }
    }

    public static ExecutorService zzl(String str) {
        return Executors.newSingleThreadExecutor(new zzaxa("Loader:ExtractorMediaPeriod"));
    }

    public static void zzm(zzavw zzavw) {
        if (zzavw != null) {
            try {
                zzavw.zzd();
            } catch (IOException unused) {
            }
        }
    }

    public static void zzn(long[] jArr, long j11, long j12) {
        int i11 = (j12 > 1000000 ? 1 : (j12 == 1000000 ? 0 : -1));
        int i12 = 0;
        if (i11 >= 0 && j12 % 1000000 == 0) {
            long j13 = j12 / 1000000;
            while (i12 < jArr.length) {
                jArr[i12] = jArr[i12] / j13;
                i12++;
            }
        } else if (i11 >= 0 || 1000000 % j12 != 0) {
            double d11 = 1000000.0d / ((double) j12);
            while (i12 < jArr.length) {
                jArr[i12] = (long) (((double) jArr[i12]) * d11);
                i12++;
            }
        } else {
            long j14 = 1000000 / j12;
            while (i12 < jArr.length) {
                jArr[i12] = jArr[i12] * j14;
                i12++;
            }
        }
    }

    public static boolean zzo(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static byte[] zzp(String str) {
        byte[] bArr = new byte[38];
        for (int i11 = 0; i11 < 38; i11++) {
            int i12 = i11 + i11;
            bArr[i11] = (byte) ((Character.digit("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78".charAt(i12), 16) << 4) + Character.digit("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78".charAt(i12 + 1), 16));
        }
        return bArr;
    }

    public static byte[] zzq(String str) {
        return str.getBytes(Charset.defaultCharset());
    }
}
