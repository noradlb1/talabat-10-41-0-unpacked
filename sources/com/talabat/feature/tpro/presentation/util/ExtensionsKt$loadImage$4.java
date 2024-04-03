package com.talabat.feature.tpro.presentation.util;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0010\u0010\b\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/talabat/feature/tpro/presentation/util/ExtensionsKt$loadImage$4", "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/drawable/Drawable;", "onLoadCleared", "", "placeholder", "onResourceReady", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExtensionsKt$loadImage$4 extends CustomTarget<Drawable> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageView f59424b;

    public ExtensionsKt$loadImage$4(ImageView imageView) {
        this.f59424b = imageView;
    }

    public void onLoadCleared(@Nullable Drawable drawable) {
    }

    public void onResourceReady(@NotNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
        Intrinsics.checkNotNullParameter(drawable, "resource");
        this.f59424b.setImageDrawable(drawable);
    }
}
