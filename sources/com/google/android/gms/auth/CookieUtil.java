package com.google.android.gms.auth;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.common.internal.Preconditions;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public final class CookieUtil {
    private CookieUtil() {
    }

    @NonNull
    public static String getCookieUrl(@NonNull String str, @Nullable Boolean bool) {
        String str2;
        Preconditions.checkNotEmpty(str);
        if (true != zza(bool)) {
            str2 = ProxyConfig.MATCH_HTTP;
        } else {
            str2 = "https";
        }
        return str2 + "://" + str;
    }

    @NonNull
    public static String getCookieValue(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Long l11) {
        if (str == null) {
            str = "";
        }
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(SignatureVisitor.INSTANCEOF);
        if (!TextUtils.isEmpty(str2)) {
            sb2.append(str2);
        }
        if (zza(bool)) {
            sb2.append(";HttpOnly");
        }
        if (zza(bool2)) {
            sb2.append(";Secure");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb2.append(";Domain=");
            sb2.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb2.append(";Path=");
            sb2.append(str4);
        }
        if (l11 != null && l11.longValue() > 0) {
            sb2.append(";Max-Age=");
            sb2.append(l11);
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            sb2.append(";Priority=null");
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            sb2.append(";SameSite=null");
        }
        if (zza((Boolean) null)) {
            sb2.append(";SameParty");
        }
        return sb2.toString();
    }

    private static boolean zza(@Nullable Boolean bool) {
        return bool != null && bool.booleanValue();
    }
}
