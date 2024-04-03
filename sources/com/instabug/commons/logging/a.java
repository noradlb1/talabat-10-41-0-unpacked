package com.instabug.commons.logging;

import com.instabug.library.util.InstabugSDKLogger;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public abstract class a {
    public static /* synthetic */ Object a(Object obj, Object obj2, String str, boolean z11, int i11, Object obj3) {
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        return a(obj, obj2, str, z11);
    }

    public static final void b(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        InstabugSDKLogger.v("IBG-CR", str);
    }

    public static final Object a(@NotNull Object obj, Object obj2, @NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "message");
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        if (r02 == null) {
            return obj;
        }
        Boolean valueOf = Boolean.valueOf(z11);
        Unit unit = null;
        if (!valueOf.booleanValue()) {
            valueOf = null;
        }
        if (valueOf != null) {
            valueOf.booleanValue();
            InstabugSDKLogger.e("IBG-CR", str, r02);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            Result.m6328boximpl(obj).m6338unboximpl();
            InstabugSDKLogger.e("IBG-CR", str);
        }
        return obj2;
    }

    public static /* synthetic */ void a(Object obj, String str, boolean z11, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        a(obj, str, z11);
    }

    public static final void a(@NotNull Object obj, @NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "message");
        a(obj, Unit.INSTANCE, str, z11);
    }

    public static final void a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        InstabugSDKLogger.e("IBG-CR", str);
    }
}
