package com.talabat.helpers;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0005H\u0007R$\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/talabat/helpers/LoggedInHelper;", "", "()V", "isTokenExists", "Lkotlin/Function0;", "", "()Lkotlin/jvm/functions/Function0;", "setTokenExists", "(Lkotlin/jvm/functions/Function0;)V", "isLoggedIn", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoggedInHelper {
    @NotNull
    public static final LoggedInHelper INSTANCE = new LoggedInHelper();
    @Nullable
    private static Function0<Boolean> isTokenExists = LoggedInHelper$isTokenExists$1.INSTANCE;

    private LoggedInHelper() {
    }

    @JvmStatic
    public static final boolean isLoggedIn() {
        if (GlobalDataModel.token == null) {
            Function0<Boolean> function0 = isTokenExists;
            return function0 != null ? Intrinsics.areEqual((Object) function0.invoke(), (Object) Boolean.TRUE) : false;
        }
    }

    @Nullable
    public final Function0<Boolean> isTokenExists() {
        return isTokenExists;
    }

    public final void setTokenExists(@Nullable Function0<Boolean> function0) {
        isTokenExists = function0;
    }
}
