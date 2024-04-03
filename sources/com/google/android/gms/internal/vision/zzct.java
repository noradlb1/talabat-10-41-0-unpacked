package com.google.android.gms.internal.vision;

import com.google.firebase.analytics.FirebaseAnalytics;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzct {
    public static void checkArgument(boolean z11, @NullableDecl Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t11) {
        t11.getClass();
        return t11;
    }

    private static String zza(int i11, int i12, @NullableDecl String str) {
        if (i11 < 0) {
            return zzcv.zza("%s (%s) must not be negative", str, Integer.valueOf(i11));
        } else if (i12 >= 0) {
            return zzcv.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i11), Integer.valueOf(i12));
        } else {
            StringBuilder sb2 = new StringBuilder(26);
            sb2.append("negative size: ");
            sb2.append(i12);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public static int zzc(int i11, int i12) {
        String str;
        if (i11 >= 0 && i11 < i12) {
            return i11;
        }
        if (i11 < 0) {
            str = zzcv.zza("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i11));
        } else if (i12 < 0) {
            StringBuilder sb2 = new StringBuilder(26);
            sb2.append("negative size: ");
            sb2.append(i12);
            throw new IllegalArgumentException(sb2.toString());
        } else {
            str = zzcv.zza("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i11), Integer.valueOf(i12));
        }
        throw new IndexOutOfBoundsException(str);
    }

    public static int zzd(int i11, int i12) {
        if (i11 >= 0 && i11 <= i12) {
            return i11;
        }
        throw new IndexOutOfBoundsException(zza(i11, i12, FirebaseAnalytics.Param.INDEX));
    }

    public static void zza(int i11, int i12, int i13) {
        String str;
        if (i11 < 0 || i12 < i11 || i12 > i13) {
            if (i11 < 0 || i11 > i13) {
                str = zza(i11, i13, "start index");
            } else if (i12 < 0 || i12 > i13) {
                str = zza(i12, i13, "end index");
            } else {
                str = zzcv.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i12), Integer.valueOf(i11));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }
}
