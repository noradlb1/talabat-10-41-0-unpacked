package androidx.core.content.res;

import java.lang.reflect.Array;

final class GrowingArrayUtils {
    private GrowingArrayUtils() {
    }

    public static <T> T[] append(T[] tArr, int i11, T t11) {
        if (i11 + 1 > tArr.length) {
            T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i11));
            System.arraycopy(tArr, 0, tArr2, 0, i11);
            tArr = tArr2;
        }
        tArr[i11] = t11;
        return tArr;
    }

    public static int growSize(int i11) {
        if (i11 <= 4) {
            return 8;
        }
        return i11 * 2;
    }

    public static <T> T[] insert(T[] tArr, int i11, int i12, T t11) {
        if (i11 + 1 <= tArr.length) {
            System.arraycopy(tArr, i12, tArr, i12 + 1, i11 - i12);
            tArr[i12] = t11;
            return tArr;
        }
        T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i11));
        System.arraycopy(tArr, 0, tArr2, 0, i12);
        tArr2[i12] = t11;
        System.arraycopy(tArr, i12, tArr2, i12 + 1, tArr.length - i12);
        return tArr2;
    }

    public static int[] append(int[] iArr, int i11, int i12) {
        if (i11 + 1 > iArr.length) {
            int[] iArr2 = new int[growSize(i11)];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            iArr = iArr2;
        }
        iArr[i11] = i12;
        return iArr;
    }

    public static int[] insert(int[] iArr, int i11, int i12, int i13) {
        if (i11 + 1 <= iArr.length) {
            System.arraycopy(iArr, i12, iArr, i12 + 1, i11 - i12);
            iArr[i12] = i13;
            return iArr;
        }
        int[] iArr2 = new int[growSize(i11)];
        System.arraycopy(iArr, 0, iArr2, 0, i12);
        iArr2[i12] = i13;
        System.arraycopy(iArr, i12, iArr2, i12 + 1, iArr.length - i12);
        return iArr2;
    }

    public static long[] append(long[] jArr, int i11, long j11) {
        if (i11 + 1 > jArr.length) {
            long[] jArr2 = new long[growSize(i11)];
            System.arraycopy(jArr, 0, jArr2, 0, i11);
            jArr = jArr2;
        }
        jArr[i11] = j11;
        return jArr;
    }

    public static boolean[] append(boolean[] zArr, int i11, boolean z11) {
        if (i11 + 1 > zArr.length) {
            boolean[] zArr2 = new boolean[growSize(i11)];
            System.arraycopy(zArr, 0, zArr2, 0, i11);
            zArr = zArr2;
        }
        zArr[i11] = z11;
        return zArr;
    }

    public static long[] insert(long[] jArr, int i11, int i12, long j11) {
        if (i11 + 1 <= jArr.length) {
            System.arraycopy(jArr, i12, jArr, i12 + 1, i11 - i12);
            jArr[i12] = j11;
            return jArr;
        }
        long[] jArr2 = new long[growSize(i11)];
        System.arraycopy(jArr, 0, jArr2, 0, i12);
        jArr2[i12] = j11;
        System.arraycopy(jArr, i12, jArr2, i12 + 1, jArr.length - i12);
        return jArr2;
    }

    public static boolean[] insert(boolean[] zArr, int i11, int i12, boolean z11) {
        if (i11 + 1 <= zArr.length) {
            System.arraycopy(zArr, i12, zArr, i12 + 1, i11 - i12);
            zArr[i12] = z11;
            return zArr;
        }
        boolean[] zArr2 = new boolean[growSize(i11)];
        System.arraycopy(zArr, 0, zArr2, 0, i12);
        zArr2[i12] = z11;
        System.arraycopy(zArr, i12, zArr2, i12 + 1, zArr.length - i12);
        return zArr2;
    }
}
