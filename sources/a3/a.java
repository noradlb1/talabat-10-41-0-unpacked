package a3;

import coil.bitmap.BitmapPool;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class a {
    static {
        BitmapPool.Companion companion = BitmapPool.Companion;
    }

    @JvmStatic
    @NotNull
    @JvmName(name = "create")
    public static BitmapPool a(int i11) {
        return BitmapPool.Companion.create(i11);
    }
}
