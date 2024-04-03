package com.instabug.library.networkv2;

import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BodyBufferHelper {
    @NotNull
    public static final BodyBufferHelper INSTANCE = new BodyBufferHelper();
    private static final long MAX_SIZE = 1048576;
    @NotNull
    public static final String MAX_SIZE_ALERT = "body omitted due to its large size > 1MB";
    @NotNull
    public static final String MULTIPART_ALERT = "multipart body was omitted";
    @NotNull
    public static final String MULTIPART_REQUEST_PREFIX = "multipart";

    private BodyBufferHelper() {
    }

    @JvmStatic
    public static final void clear(@NotNull StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(stringBuffer, "<this>");
        stringBuffer.setLength(0);
    }

    @JvmStatic
    @NotNull
    public static final String generateBodyMsg(boolean z11, long j11, @NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "fallback");
        if (z11) {
            return MULTIPART_ALERT;
        }
        if (!isBodySizeAllowed$default(j11, 0, 2, (Object) null)) {
            return MAX_SIZE_ALERT;
        }
        return function0.invoke();
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean isBodySizeAllowed(long j11) {
        return isBodySizeAllowed$default(j11, 0, 2, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean isBodySizeAllowed(long j11, long j12) {
        return j11 <= j12;
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean isBodySizeAllowed(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "body");
        return isBodySizeAllowed$default(str, 0, 2, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean isBodySizeAllowed(@NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "body");
        if (((long) StringsKt__StringsJVMKt.encodeToByteArray(str).length) <= j11) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean isBodySizeAllowed$default(long j11, long j12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j12 = 1048576;
        }
        return isBodySizeAllowed(j11, j12);
    }

    @JvmStatic
    public static final boolean isMultipartType(@Nullable String str) {
        if (str == null || !StringsKt__StringsJVMKt.startsWith$default(str, MULTIPART_REQUEST_PREFIX, false, 2, (Object) null)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean isBodySizeAllowed$default(String str, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 1048576;
        }
        return isBodySizeAllowed(str, j11);
    }
}
