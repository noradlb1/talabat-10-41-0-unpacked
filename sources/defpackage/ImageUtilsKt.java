package defpackage;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.ViewTarget;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aU\u0010\u0000\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u00040\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062%\b\u0002\u0010\u0007\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\b¢\u0006\u0002\b\n\u001ac\u0010\u000b\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u00040\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062%\b\u0002\u0010\u0007\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\b¢\u0006\u0002\b\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r¨\u0006\u000e"}, d2 = {"showImage", "Lcom/bumptech/glide/request/target/ViewTarget;", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "Landroid/graphics/drawable/Drawable;", "imageUrl", "", "builder", "Lkotlin/Function1;", "Lcom/bumptech/glide/RequestBuilder;", "Lkotlin/ExtensionFunctionType;", "showImageWithCallback", "callBack", "Lcom/bumptech/glide/request/RequestListener;", "com_talabat_feature_tpro_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* renamed from: ImageUtilsKt  reason: default package */
public final class ImageUtilsKt {
    @NotNull
    public static final ViewTarget<ImageView, Drawable> showImage(@NotNull ImageView imageView, @NotNull String str, @NotNull Function1<? super RequestBuilder<Drawable>, ? extends RequestBuilder<Drawable>> function1) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(function1, "builder");
        RequestBuilder<Drawable> load = Glide.with(imageView.getContext()).load(str);
        Intrinsics.checkNotNullExpressionValue(load, "with(context).load(imageUrl)");
        ViewTarget<ImageView, Drawable> into = ((RequestBuilder) function1.invoke(load)).into(imageView);
        Intrinsics.checkNotNullExpressionValue(into, "with(context).load(imageUrl).builder().into(this)");
        return into;
    }

    public static /* synthetic */ ViewTarget showImage$default(ImageView imageView, String str, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = ImageUtilsKt$showImage$1.INSTANCE;
        }
        return showImage(imageView, str, function1);
    }

    @NotNull
    public static final ViewTarget<ImageView, Drawable> showImageWithCallback(@NotNull ImageView imageView, @NotNull String str, @NotNull Function1<? super RequestBuilder<Drawable>, ? extends RequestBuilder<Drawable>> function1, @NotNull RequestListener<Drawable> requestListener) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(function1, "builder");
        Intrinsics.checkNotNullParameter(requestListener, "callBack");
        RequestBuilder<Drawable> load = Glide.with((View) imageView).load(str);
        Intrinsics.checkNotNullExpressionValue(load, "with(this)\n    .load(imageUrl)");
        ViewTarget<ImageView, TranscodeType> into = ((RequestBuilder) function1.invoke(load)).listener(requestListener).into(imageView);
        Intrinsics.checkNotNullExpressionValue(into, "with(this)\n    .load(ima…callBack)\n    .into(this)");
        return into;
    }

    public static /* synthetic */ ViewTarget showImageWithCallback$default(ImageView imageView, String str, Function1 function1, RequestListener requestListener, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = ImageUtilsKt$showImageWithCallback$1.INSTANCE;
        }
        return showImageWithCallback(imageView, str, function1, requestListener);
    }
}
