package com.instabug.library.invocation.util;

import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReferenceArray;

public abstract class a {
    @Nullable
    public static Object[] a(@Nullable AtomicReferenceArray atomicReferenceArray, Class cls) {
        if (atomicReferenceArray == null) {
            return null;
        }
        Object[] objArr = (Object[]) Array.newInstance(cls, atomicReferenceArray.length());
        for (int i11 = 0; i11 < atomicReferenceArray.length(); i11++) {
            objArr[i11] = atomicReferenceArray.get(i11);
        }
        return objArr;
    }
}
