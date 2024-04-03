package com.instabug.apm.util;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public abstract class a {
    public static final void a(@NotNull Object[] objArr, Object obj) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        int length = objArr.length;
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 + 1;
            if (objArr[i11] == null) {
                objArr[i11] = obj;
            }
            i11 = i12;
        }
    }
}
