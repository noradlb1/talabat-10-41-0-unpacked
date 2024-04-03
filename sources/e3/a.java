package e3;

import coil.size.Size;
import coil.size.SizeResolver;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class a {
    static {
        SizeResolver.Companion companion = SizeResolver.Companion;
    }

    @JvmStatic
    @NotNull
    @JvmName(name = "create")
    public static SizeResolver a(@NotNull Size size) {
        return SizeResolver.Companion.create(size);
    }
}
