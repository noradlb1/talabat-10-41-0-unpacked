package org.mockito.internal.matchers;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class ArrayEquals extends Equals {
    public ArrayEquals(Object obj) {
        super(obj);
    }

    private String appendArray(Object[] objArr) {
        StringBuilder sb2 = new StringBuilder("[");
        for (int i11 = 0; i11 < objArr.length; i11++) {
            sb2.append(new Equals(objArr[i11]));
            if (i11 != objArr.length - 1) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public static Object[] createObjectArray(Object obj) {
        if (obj instanceof Object[]) {
            return (Object[]) obj;
        }
        Object[] objArr = new Object[Array.getLength(obj)];
        for (int i11 = 0; i11 < Array.getLength(obj); i11++) {
            objArr[i11] = Array.get(obj, i11);
        }
        return objArr;
    }

    public boolean matches(Object obj) {
        Object wanted = getWanted();
        if (wanted == null || obj == null) {
            return super.matches(obj);
        }
        if ((wanted instanceof boolean[]) && (obj instanceof boolean[])) {
            return Arrays.equals((boolean[]) wanted, (boolean[]) obj);
        }
        if ((wanted instanceof byte[]) && (obj instanceof byte[])) {
            return Arrays.equals((byte[]) wanted, (byte[]) obj);
        }
        if ((wanted instanceof char[]) && (obj instanceof char[])) {
            return Arrays.equals((char[]) wanted, (char[]) obj);
        }
        if ((wanted instanceof double[]) && (obj instanceof double[])) {
            return Arrays.equals((double[]) wanted, (double[]) obj);
        }
        if ((wanted instanceof float[]) && (obj instanceof float[])) {
            return Arrays.equals((float[]) wanted, (float[]) obj);
        }
        if ((wanted instanceof int[]) && (obj instanceof int[])) {
            return Arrays.equals((int[]) wanted, (int[]) obj);
        }
        if ((wanted instanceof long[]) && (obj instanceof long[])) {
            return Arrays.equals((long[]) wanted, (long[]) obj);
        }
        if ((wanted instanceof short[]) && (obj instanceof short[])) {
            return Arrays.equals((short[]) wanted, (short[]) obj);
        }
        if (!(wanted instanceof Object[]) || !(obj instanceof Object[])) {
            return false;
        }
        return Arrays.equals((Object[]) wanted, (Object[]) obj);
    }

    public String toString() {
        if (getWanted() == null || !getWanted().getClass().isArray()) {
            return super.toString();
        }
        return appendArray(createObjectArray(getWanted()));
    }
}
