package com.talabat.feature.tmart.growth.presentation.widget.views;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003B\r\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0014J\"\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0002¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/widget/views/BackgroundDrawableTarget;", "Type", "Landroid/view/View;", "Lcom/bumptech/glide/request/target/CustomViewTarget;", "Landroid/graphics/drawable/Drawable;", "view", "(Landroid/view/View;)V", "onLoadFailed", "", "errorDrawable", "onResourceCleared", "placeholder", "onResourceReady", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "setBackground", "drawable", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BackgroundDrawableTarget<Type extends View> extends CustomViewTarget<Type, Drawable> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackgroundDrawableTarget(@NotNull Type type) {
        super(type);
        Intrinsics.checkNotNullParameter(type, "view");
    }

    private final void setBackground(Drawable drawable) {
        this.view.setBackground(drawable);
    }

    public void onLoadFailed(@Nullable Drawable drawable) {
        setBackground(drawable);
    }

    public void onResourceCleared(@Nullable Drawable drawable) {
        setBackground(drawable);
    }

    public void onResourceReady(@NotNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
        Intrinsics.checkNotNullParameter(drawable, "resource");
        setBackground(drawable);
    }
}
