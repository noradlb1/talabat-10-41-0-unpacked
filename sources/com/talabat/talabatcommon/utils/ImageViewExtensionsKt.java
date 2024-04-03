package com.talabat.talabatcommon.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.target.ViewTarget;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import com.talabat.talabatcommon.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001aU\u0010\u0000\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u00040\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062%\b\u0002\u0010\u0007\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\b¢\u0006\u0002\b\n\u001a\"\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u001a\u0012\u0010\u000f\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a&\u0010\u000f\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u0011\u001a\u0012\u0010\u0013\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0014"}, d2 = {"loadImage", "Lcom/bumptech/glide/request/target/ViewTarget;", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "Landroid/graphics/drawable/Drawable;", "imageUrl", "", "builder", "Lkotlin/Function1;", "Lcom/bumptech/glide/RequestBuilder;", "Lkotlin/ExtensionFunctionType;", "loadImageUrl", "", "onLoadFailed", "Lkotlin/Function0;", "loadImageUrlWithRoundedCorners", "placeHolderRes", "", "errorRes", "loadImageUrlWithRoundedCornersNoCrop", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ImageViewExtensionsKt {
    @NotNull
    public static final ViewTarget<ImageView, Drawable> loadImage(@NotNull ImageView imageView, @NotNull String str, @NotNull Function1<? super RequestBuilder<Drawable>, ? extends RequestBuilder<Drawable>> function1) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(function1, "builder");
        RequestBuilder<Drawable> load = Glide.with(imageView.getContext()).load(str);
        Intrinsics.checkNotNullExpressionValue(load, "with(context).load(imageUrl)");
        ViewTarget<ImageView, Drawable> into = ((RequestBuilder) function1.invoke(load)).into(imageView);
        Intrinsics.checkNotNullExpressionValue(into, "with(context).load(imageUrl).builder().into(this)");
        return into;
    }

    public static /* synthetic */ ViewTarget loadImage$default(ImageView imageView, String str, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = ImageViewExtensionsKt$loadImage$1.INSTANCE;
        }
        return loadImage(imageView, str, function1);
    }

    public static final void loadImageUrl(@NotNull ImageView imageView, @NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(function0, "onLoadFailed");
        if (imageView.getContext() != null) {
            ((RequestBuilder) Glide.with(imageView.getContext()).load(str).listener(new ImageViewExtensionsKt$loadImageUrl$2(function0)).centerCrop()).into(imageView);
        }
    }

    public static /* synthetic */ void loadImageUrl$default(ImageView imageView, String str, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = ImageViewExtensionsKt$loadImageUrl$1.INSTANCE;
        }
        loadImageUrl(imageView, str, function0);
    }

    public static final void loadImageUrlWithRoundedCorners(@NotNull ImageView imageView, @NotNull String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        if (imageView.getContext() != null) {
            RequestBuilder<Drawable> load = Glide.with((View) imageView).load(str);
            Transformation[] transformationArr = {new CenterCrop(), new RoundedCorners(imageView.getResources().getDimensionPixelOffset(R.dimen.padding_8dp))};
            int i11 = R.drawable.placeholder_round_corners;
            ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) load.transform((Transformation<Bitmap>[]) transformationArr)).placeholder(i11)).error(i11)).into(imageView);
        }
    }

    public static final void loadImageUrlWithRoundedCornersNoCrop(@NotNull ImageView imageView, @NotNull String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        if (imageView.getContext() != null) {
            int i11 = R.drawable.placeholder_round_corners;
            ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with((View) imageView).load(str).transform((Transformation<Bitmap>) new RoundedCorners(imageView.getResources().getDimensionPixelOffset(R.dimen.padding_8dp)))).placeholder(i11)).error(i11)).into(imageView);
        }
    }

    public static final void loadImageUrlWithRoundedCorners(@NotNull ImageView imageView, @NotNull String str, @DrawableRes int i11, @DrawableRes int i12) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with((View) imageView).load(str).transform((Transformation<Bitmap>[]) new Transformation[]{new CenterCrop(), new RoundedCorners(imageView.getResources().getDimensionPixelOffset(R.dimen.padding_8dp))})).placeholder(i11)).error(i12)).into(imageView);
    }
}
