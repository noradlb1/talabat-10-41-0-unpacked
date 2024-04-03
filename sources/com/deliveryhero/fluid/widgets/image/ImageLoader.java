package com.deliveryhero.fluid.widgets.image;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.deliveryhero.fluid.widgets.image.ImageLocator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/fluid/widgets/image/ImageLoader;", "", "load", "", "widget", "Landroid/widget/ImageView;", "image", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Local;", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Remote;", "loadingPlaceholder", "errorPlaceholder", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ImageLoader {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void load(@NotNull ImageLoader imageLoader, @NotNull ImageView imageView, @NotNull ImageLocator.Local local) {
            Drawable drawable;
            Intrinsics.checkNotNullParameter(imageView, "widget");
            Intrinsics.checkNotNullParameter(local, "image");
            ImageAsset asset = local.getAsset();
            if (asset != null) {
                drawable = asset.getDrawable();
            } else {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
        }
    }

    void load(@NotNull ImageView imageView, @NotNull ImageLocator.Local local);

    void load(@NotNull ImageView imageView, @NotNull ImageLocator.Remote remote, @Nullable ImageLocator.Local local, @Nullable ImageLocator.Local local2);
}
