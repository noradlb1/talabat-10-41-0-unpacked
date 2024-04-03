package com.talabat.gem.adapters.presentation;

import android.graphics.Bitmap;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.talabat.gem.adapters.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0001\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0001\u001a\f\u0010\n\u001a\u00020\t*\u00020\u0002H\u0002\u001a\u001a\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f*\u00020\u0002H\u0002¨\u0006\u000f"}, d2 = {"drawThumbnail", "", "Landroid/widget/ImageView;", "url", "", "sizeMultiplier", "", "loadResource", "resource", "", "roundingPixels", "toRoundedCorners", "Lcom/bumptech/glide/load/MultiTransformation;", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ImageViewsKt {
    @ImageViewDsl
    public static final void drawThumbnail(@NotNull ImageView imageView, @Nullable String str, float f11) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Glide.with(imageView.getContext()).clear((View) imageView);
        ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with(imageView.getContext()).load(str).transform((Transformation<Bitmap>) toRoundedCorners(imageView))).thumbnail(f11).diskCacheStrategy(DiskCacheStrategy.ALL)).placeholder(R.drawable.glide_placeholder)).into(imageView);
    }

    public static /* synthetic */ void drawThumbnail$default(ImageView imageView, String str, float f11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f11 = 0.5f;
        }
        drawThumbnail(imageView, str, f11);
    }

    @ImageViewDsl
    public static final void loadResource(@NotNull ImageView imageView, int i11) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        ((RequestBuilder) Glide.with((View) imageView).load(Integer.valueOf(i11)).fitCenter()).into(imageView);
    }

    private static final int roundingPixels(ImageView imageView) {
        return (int) TypedValue.applyDimension(1, 8.0f, imageView.getContext().getResources().getDisplayMetrics());
    }

    private static final MultiTransformation<Bitmap> toRoundedCorners(ImageView imageView) {
        return new MultiTransformation<>((Transformation<T>[]) new Transformation[]{new CenterCrop(), new RoundedCorners(roundingPixels(imageView))});
    }
}
