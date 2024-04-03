package g7;

import android.annotation.SuppressLint;
import com.google.android.exoplayer2.RendererCapabilities;

public final /* synthetic */ class c1 {
    public static int a(int i11) {
        return b(i11, 0, 0);
    }

    public static int b(int i11, int i12, int i13) {
        return c(i11, i12, i13, 0, 128);
    }

    @SuppressLint({"WrongConstant"})
    public static int c(int i11, int i12, int i13, int i14, int i15) {
        return i11 | i12 | i13 | i14 | i15;
    }

    @SuppressLint({"WrongConstant"})
    public static int d(int i11) {
        return i11 & 24;
    }

    @SuppressLint({"WrongConstant"})
    public static int e(int i11) {
        return i11 & RendererCapabilities.MODE_SUPPORT_MASK;
    }

    @SuppressLint({"WrongConstant"})
    public static int f(int i11) {
        return i11 & 7;
    }

    @SuppressLint({"WrongConstant"})
    public static int g(int i11) {
        return i11 & 64;
    }

    @SuppressLint({"WrongConstant"})
    public static int h(int i11) {
        return i11 & 32;
    }
}
