package org.mockito.internal.creation;

import java.util.Arrays;

public final class SuspendMethod {
    private static final String KOTLIN_CONTINUATION = "kotlin.coroutines.Continuation";
    private static final String KOTLIN_EXPERIMENTAL_CONTINUATION = "kotlin.coroutines.experimental.Continuation";

    private SuspendMethod() {
    }

    private static boolean isContinuationType(Class<?> cls) {
        String name2 = cls.getName();
        if (name2.equals(KOTLIN_CONTINUATION) || name2.equals(KOTLIN_EXPERIMENTAL_CONTINUATION)) {
            return true;
        }
        return false;
    }

    public static Class<?>[] trimSuspendParameterTypes(Class<?>[] clsArr) {
        int length = clsArr.length;
        if (length <= 0) {
            return clsArr;
        }
        int i11 = length - 1;
        if (isContinuationType(clsArr[i11])) {
            return (Class[]) Arrays.copyOf(clsArr, i11);
        }
        return clsArr;
    }
}
