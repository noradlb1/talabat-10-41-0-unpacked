package com.deliveryhero.fluid.widgets.image;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/fluid/widgets/image/ImageAsset;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageAsset {
    @NotNull
    private final Drawable drawable;

    public ImageAsset(@NotNull Drawable drawable2) {
        Intrinsics.checkNotNullParameter(drawable2, "drawable");
        this.drawable = drawable2;
    }

    @NotNull
    public final Drawable getDrawable() {
        return this.drawable;
    }
}
