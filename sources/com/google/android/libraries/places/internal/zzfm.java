package com.google.android.libraries.places.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import javax.annotation.CheckForNull;

public final class zzfm {
    public static int zza(int i11, int i12, String str) {
        String str2;
        if (i11 >= 0 && i11 < i12) {
            return i11;
        }
        if (i11 < 0) {
            str2 = zzfr.zza("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i11));
        } else if (i12 < 0) {
            StringBuilder sb2 = new StringBuilder(26);
            sb2.append("negative size: ");
            sb2.append(i12);
            throw new IllegalArgumentException(sb2.toString());
        } else {
            str2 = zzfr.zza("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i11), Integer.valueOf(i12));
        }
        throw new IndexOutOfBoundsException(str2);
    }

    public static int zzb(int i11, int i12, String str) {
        if (i11 >= 0 && i11 <= i12) {
            return i11;
        }
        throw new IndexOutOfBoundsException(zzl(i11, i12, FirebaseAnalytics.Param.INDEX));
    }

    public static <T> T zzc(@CheckForNull T t11, @CheckForNull Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException((String) obj);
    }

    public static void zzd(boolean z11) {
        if (!z11) {
            throw new IllegalArgumentException();
        }
    }

    public static void zze(boolean z11, @CheckForNull Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void zzf(boolean z11, String str, char c11) {
        if (!z11) {
            throw new IllegalArgumentException(zzfr.zza(str, Character.valueOf(c11)));
        }
    }

    public static void zzg(int i11, int i12, int i13) {
        String str;
        if (i11 < 0 || i12 < i11 || i12 > i13) {
            if (i11 < 0 || i11 > i13) {
                str = zzl(i11, i13, "start index");
            } else if (i12 < 0 || i12 > i13) {
                str = zzl(i12, i13, "end index");
            } else {
                str = zzfr.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i12), Integer.valueOf(i11));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    public static void zzh(boolean z11) {
        if (!z11) {
            throw new IllegalStateException();
        }
    }

    public static void zzi(boolean z11, @CheckForNull Object obj) {
        if (!z11) {
            throw new IllegalStateException((String) obj);
        }
    }

    public static void zzj(boolean z11, String str, int i11) {
        if (!z11) {
            throw new IllegalStateException(zzfr.zza(str, Integer.valueOf(i11)));
        }
    }

    public static void zzk(boolean z11, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z11) {
            throw new IllegalStateException(zzfr.zza(str, obj, obj2, obj3));
        }
    }

    private static String zzl(int i11, int i12, String str) {
        if (i11 < 0) {
            return zzfr.zza("%s (%s) must not be negative", str, Integer.valueOf(i11));
        } else if (i12 >= 0) {
            return zzfr.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i11), Integer.valueOf(i12));
        } else {
            StringBuilder sb2 = new StringBuilder(26);
            sb2.append("negative size: ");
            sb2.append(i12);
            throw new IllegalArgumentException(sb2.toString());
        }
    }
}
