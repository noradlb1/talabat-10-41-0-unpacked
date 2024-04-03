package z2;

import android.content.Context;
import coil.ImageLoader;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class c {
    static {
        ImageLoader.Companion companion = ImageLoader.Companion;
    }

    @JvmStatic
    @NotNull
    @JvmName(name = "create")
    public static ImageLoader a(@NotNull Context context) {
        return ImageLoader.Companion.create(context);
    }
}
