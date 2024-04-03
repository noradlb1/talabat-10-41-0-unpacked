package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import javax.annotation.CheckForNull;

public final class zzfqg {
    public static int zza(int i11, int i12, String str) {
        String str2;
        if (i11 >= 0 && i11 < i12) {
            return i11;
        }
        if (i11 < 0) {
            str2 = zzfqr.zzb("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i11));
        } else if (i12 < 0) {
            StringBuilder sb2 = new StringBuilder(26);
            sb2.append("negative size: ");
            sb2.append(i12);
            throw new IllegalArgumentException(sb2.toString());
        } else {
            str2 = zzfqr.zzb("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i11), Integer.valueOf(i12));
        }
        throw new IndexOutOfBoundsException(str2);
    }

    public static int zzb(int i11, int i12, String str) {
        if (i11 >= 0 && i11 <= i12) {
            return i11;
        }
        throw new IndexOutOfBoundsException(zzh(i11, i12, FirebaseAnalytics.Param.INDEX));
    }

    public static <T> T zzc(@CheckForNull T t11, @CheckForNull Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException((String) obj);
    }

    public static <T> T zzd(@CheckForNull T t11, String str, @CheckForNull Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(zzfqr.zzb(str, obj));
    }

    public static void zze(boolean z11, @CheckForNull Object obj) {
        if (!z11) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void zzf(int i11, int i12, int i13) {
        String str;
        if (i11 < 0 || i12 < i11 || i12 > i13) {
            if (i11 < 0 || i11 > i13) {
                str = zzh(i11, i13, "start index");
            } else if (i12 < 0 || i12 > i13) {
                str = zzh(i12, i13, "end index");
            } else {
                str = zzfqr.zzb("end index (%s) must not be less than start index (%s)", Integer.valueOf(i12), Integer.valueOf(i11));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    public static void zzg(boolean z11, @CheckForNull Object obj) {
        if (!z11) {
            throw new IllegalStateException((String) obj);
        }
    }

    private static String zzh(int i11, int i12, String str) {
        if (i11 < 0) {
            return zzfqr.zzb("%s (%s) must not be negative", str, Integer.valueOf(i11));
        } else if (i12 >= 0) {
            return zzfqr.zzb("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i11), Integer.valueOf(i12));
        } else {
            StringBuilder sb2 = new StringBuilder(26);
            sb2.append("negative size: ");
            sb2.append(i12);
            throw new IllegalArgumentException(sb2.toString());
        }
    }
}
