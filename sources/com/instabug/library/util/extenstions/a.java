package com.instabug.library.util.extenstions;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

public abstract class a {
    public static final int a(@Nullable Boolean bool) {
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
            return 1;
        }
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.FALSE)) {
            return 0;
        }
        if (bool == null) {
            return -1;
        }
        throw new NoWhenBranchMatchedException();
    }
}
