package com.deliveryhero.fluid.utils;

import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/deliveryhero/fluid/utils/AndroidVersion;", "", "()V", "isAtLeastLollipop", "", "()Z", "isAtLeastMarshmallow", "isAtLeastNougat", "isAtLeastOreo", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AndroidVersion {
    @NotNull
    public static final AndroidVersion INSTANCE = new AndroidVersion();
    @ChecksSdkIntAtLeast(api = 21)
    private static final boolean isAtLeastLollipop = true;
    @ChecksSdkIntAtLeast(api = 23)
    private static final boolean isAtLeastMarshmallow = true;
    @ChecksSdkIntAtLeast(api = 24)
    private static final boolean isAtLeastNougat;
    @ChecksSdkIntAtLeast(api = 26)
    private static final boolean isAtLeastOreo;

    static {
        boolean z11;
        int i11 = Build.VERSION.SDK_INT;
        boolean z12 = true;
        if (i11 >= 24) {
            z11 = true;
        } else {
            z11 = false;
        }
        isAtLeastNougat = z11;
        if (i11 < 26) {
            z12 = false;
        }
        isAtLeastOreo = z12;
    }

    private AndroidVersion() {
    }

    public final boolean isAtLeastLollipop() {
        return isAtLeastLollipop;
    }

    public final boolean isAtLeastMarshmallow() {
        return isAtLeastMarshmallow;
    }

    public final boolean isAtLeastNougat() {
        return isAtLeastNougat;
    }

    public final boolean isAtLeastOreo() {
        return isAtLeastOreo;
    }
}
