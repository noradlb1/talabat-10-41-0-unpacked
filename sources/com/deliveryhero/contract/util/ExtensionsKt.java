package com.deliveryhero.contract.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"requireNotNullOrEmpty", "", "message", "Lkotlin/Function0;", "customerchat_basicRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ExtensionsKt {
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
