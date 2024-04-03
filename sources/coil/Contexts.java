package coil;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0004"}, d2 = {"imageLoader", "Lcoil/ImageLoader;", "Landroid/content/Context;", "(Landroid/content/Context;)Lcoil/ImageLoader;", "coil-singleton_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
@JvmName(name = "Contexts")
public final class Contexts {
    @NotNull
    @JvmName(name = "imageLoader")
    public static final ImageLoader imageLoader(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return Coil.imageLoader(context);
    }
}
