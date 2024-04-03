package e3;

import android.view.View;
import coil.size.ViewSizeResolver;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class b<T extends View> {
    static {
        ViewSizeResolver.Companion companion = ViewSizeResolver.Companion;
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    @JvmName(name = "create")
    public static <T extends View> ViewSizeResolver<T> a(@NotNull T t11) {
        return ViewSizeResolver.Companion.create(t11);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    @JvmName(name = "create")
    public static <T extends View> ViewSizeResolver<T> b(@NotNull T t11, boolean z11) {
        return ViewSizeResolver.Companion.create(t11, z11);
    }
}
