package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresOptIn;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;

public class BuildCompat {

    @RequiresOptIn
    public @interface PrereleaseSdkCheck {
    }

    private BuildCompat() {
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static boolean a(@NonNull String str, @NonNull String str2) {
        if ("REL".equals(str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        if (str2.toUpperCase(locale).compareTo(str.toUpperCase(locale)) >= 0) {
            return true;
        }
        return false;
    }

    @Deprecated
    @ChecksSdkIntAtLeast(api = 24)
    public static boolean isAtLeastN() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @Deprecated
    @ChecksSdkIntAtLeast(api = 25)
    public static boolean isAtLeastNMR1() {
        return Build.VERSION.SDK_INT >= 25;
    }

    @Deprecated
    @ChecksSdkIntAtLeast(api = 26)
    public static boolean isAtLeastO() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @Deprecated
    @ChecksSdkIntAtLeast(api = 27)
    public static boolean isAtLeastOMR1() {
        return Build.VERSION.SDK_INT >= 27;
    }

    @Deprecated
    @ChecksSdkIntAtLeast(api = 28)
    public static boolean isAtLeastP() {
        return Build.VERSION.SDK_INT >= 28;
    }

    @Deprecated
    @ChecksSdkIntAtLeast(api = 29)
    public static boolean isAtLeastQ() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Deprecated
    @ChecksSdkIntAtLeast(api = 30)
    public static boolean isAtLeastR() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @SuppressLint({"RestrictedApi"})
    @Deprecated
    @ChecksSdkIntAtLeast(api = 31, codename = "S")
    public static boolean isAtLeastS() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 31 || (i11 >= 30 && a(ExifInterface.LATITUDE_SOUTH, Build.VERSION.CODENAME))) {
            return true;
        }
        return false;
    }

    @Deprecated
    @ChecksSdkIntAtLeast(api = 32, codename = "Sv2")
    @PrereleaseSdkCheck
    public static boolean isAtLeastSv2() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 32 || (i11 >= 31 && a("Sv2", Build.VERSION.CODENAME))) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(api = 33, codename = "Tiramisu")
    @PrereleaseSdkCheck
    public static boolean isAtLeastT() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 33 || (i11 >= 32 && a("Tiramisu", Build.VERSION.CODENAME))) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(codename = "UpsideDownCake")
    @PrereleaseSdkCheck
    public static boolean isAtLeastU() {
        if (Build.VERSION.SDK_INT < 33 || !a("UpsideDownCake", Build.VERSION.CODENAME)) {
            return false;
        }
        return true;
    }
}
