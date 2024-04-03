package org.mockito.internal.invocation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.mockito.ArgumentMatcher;
import org.mockito.internal.matchers.ArrayEquals;
import org.mockito.internal.matchers.Equals;

public final class ArgumentsProcessor {
    private ArgumentsProcessor() {
    }

    public static List<ArgumentMatcher> argumentsToMatchers(Object[] objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            if (obj == null || !obj.getClass().isArray()) {
                arrayList.add(new Equals(obj));
            } else {
                arrayList.add(new ArrayEquals(obj));
            }
        }
        return arrayList;
    }

    public static Object[] expandArgs(MockitoMethod mockitoMethod, Object[] objArr) {
        int length = mockitoMethod.getParameterTypes().length;
        if (objArr != null && objArr.length > length) {
            objArr = Arrays.copyOf(objArr, length);
        }
        return expandVarArgs(mockitoMethod.isVarArgs(), objArr);
    }

    private static Object[] expandVarArgs(boolean z11, Object[] objArr) {
        if (z11 && !isNullOrEmpty(objArr) && (objArr[objArr.length - 1] == null || objArr[objArr.length - 1].getClass().isArray())) {
            int length = objArr.length - 1;
            Object obj = objArr[length];
            Object[] createObjectArray = obj == null ? new Object[]{null} : ArrayEquals.createObjectArray(obj);
            int length2 = createObjectArray.length;
            Object[] objArr2 = new Object[(length + length2)];
            System.arraycopy(objArr, 0, objArr2, 0, length);
            System.arraycopy(createObjectArray, 0, objArr2, length, length2);
            return objArr2;
        } else if (objArr == null) {
            return new Object[0];
        } else {
            return objArr;
        }
    }

    private static <T> boolean isNullOrEmpty(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }
}
