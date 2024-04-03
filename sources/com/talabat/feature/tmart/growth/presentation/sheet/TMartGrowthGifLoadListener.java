package com.talabat.feature.tmart.growth.presentation.sheet;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J4\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J<\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/sheet/TMartGrowthGifLoadListener;", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "animationEndCallback", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "AnimationEndCallback", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthGifLoadListener implements RequestListener<Drawable> {
    /* access modifiers changed from: private */
    @NotNull
    public final Function0<Unit> animationEndCallback;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/sheet/TMartGrowthGifLoadListener$AnimationEndCallback;", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "(Lcom/talabat/feature/tmart/growth/presentation/sheet/TMartGrowthGifLoadListener;)V", "onAnimationEnd", "", "drawable", "Landroid/graphics/drawable/Drawable;", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class AnimationEndCallback extends Animatable2Compat.AnimationCallback {
        public AnimationEndCallback() {
        }

        public void onAnimationEnd(@Nullable Drawable drawable) {
            super.onAnimationEnd(drawable);
            TMartGrowthGifLoadListener.this.animationEndCallback.invoke();
        }
    }

    public TMartGrowthGifLoadListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "animationEndCallback");
        this.animationEndCallback = function0;
    }

    public boolean onLoadFailed(@Nullable GlideException glideException, @Nullable Object obj, @Nullable Target<Drawable> target, boolean z11) {
        this.animationEndCallback.invoke();
        return false;
    }

    public boolean onResourceReady(@NotNull Drawable drawable, @Nullable Object obj, @Nullable Target<Drawable> target, @Nullable DataSource dataSource, boolean z11) {
        Intrinsics.checkNotNullParameter(drawable, "resource");
        if (drawable instanceof GifDrawable) {
            GifDrawable gifDrawable = (GifDrawable) drawable;
            gifDrawable.setLoopCount(0);
            gifDrawable.registerAnimationCallback(new AnimationEndCallback());
        }
        return false;
    }
}
