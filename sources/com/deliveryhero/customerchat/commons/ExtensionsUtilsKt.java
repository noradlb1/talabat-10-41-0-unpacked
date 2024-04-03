package com.deliveryhero.customerchat.commons;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0002\u001a(\u0010\u0005\u001a\u0004\u0018\u0001H\u0006\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\b¢\u0006\u0002\u0010\n\u001a\u001e\u0010\u000b\u001a\u00020\u0002*\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r¨\u0006\u000e"}, d2 = {"countCharacters", "", "", "countWords", "getOrderIDFromChannelID", "parcelable", "T", "Landroid/os/Parcelable;", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Parcelable;", "requireNotNullOrEmpty", "message", "Lkotlin/Function0;", "customerchat_basicRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ExtensionsUtilsKt {
    public static final int countCharacters(@Nullable String str) {
        if (str != null) {
            return str.length();
        }
        return 0;
    }

    public static final int countWords(@Nullable String str) {
        List split$default;
        if (str == null || (split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null)) == null) {
            return 0;
        }
        return split$default.size();
    }

    @Nullable
    public static final String getOrderIDFromChannelID(@Nullable String str) {
        if (str != null) {
            return StringsKt__StringsKt.substringAfter$default(str, "dh_", (String) null, 2, (Object) null);
        }
        return null;
    }

    public static final /* synthetic */ <T extends Parcelable> T parcelable(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker(4, "T");
            return (Parcelable) bundle.getParcelable(str, Parcelable.class);
        }
        T parcelable = bundle.getParcelable(str);
        Intrinsics.reifiedOperationMarker(2, "T");
        return parcelable;
    }

    @NotNull
    public static final String requireNotNullOrEmpty(@Nullable String str, @Nullable Function0<String> function0) {
        boolean z11;
        String str2;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return str;
        }
        if (function0 == null || (str2 = function0.invoke()) == null) {
            str2 = "Required value was null or empty.";
        }
        throw new IllegalArgumentException(str2);
    }

    public static /* synthetic */ String requireNotNullOrEmpty$default(String str, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function0 = null;
        }
        return requireNotNullOrEmpty(str, function0);
    }
}
