package com.talabat.darkstores.common.bindingAdapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.request.BaseRequestOptions;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.extensions.ContextExtensionsKt;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zh.a;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001aM\u0010\b\u001a\u00020\t*\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0013\u001a\"\u0010\u0014\u001a\u00020\t*\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u0012\u0010\u0019\u001a\u00020\t*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"QUERY_QCOMMERCE", "", "QUERY_QCOMMERCE_VALUE", "QUERY_SIZE", "RETRY_DELAY_MILLIS", "", "THUMBNAIL_SIZE_DIVIDER", "", "loadImageWithGlide", "", "Landroid/widget/ImageView;", "maybeImageUrl", "placeholderResId", "resizeStrategy", "Lcom/talabat/darkstores/common/bindingAdapters/ResizeStrategy;", "transformation", "Lcom/bumptech/glide/load/Transformation;", "Landroid/graphics/Bitmap;", "overrideSize", "(Landroid/widget/ImageView;Ljava/lang/String;Ljava/lang/Integer;Lcom/talabat/darkstores/common/bindingAdapters/ResizeStrategy;Lcom/bumptech/glide/load/Transformation;Ljava/lang/Integer;)V", "retryOnFailureAndReportToObservabilityIfRetryFails", "glideAction", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "imageUrl", "setStrike", "Landroid/widget/TextView;", "strike", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BindingAdaptersKt {
    @NotNull
    private static final String QUERY_QCOMMERCE = "qcommerce";
    @NotNull
    private static final String QUERY_QCOMMERCE_VALUE = "true";
    @NotNull
    public static final String QUERY_SIZE = "size";
    private static final long RETRY_DELAY_MILLIS = 1000;
    public static final int THUMBNAIL_SIZE_DIVIDER = 10;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResizeStrategy.values().length];
            iArr[ResizeStrategy.CenterInside.ordinal()] = 1;
            iArr[ResizeStrategy.FitCenter.ordinal()] = 2;
            iArr[ResizeStrategy.Default.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void loadImageWithGlide(@NotNull ImageView imageView, @Nullable String str, @Nullable @DrawableRes Integer num, @NotNull ResizeStrategy resizeStrategy, @Nullable Transformation<Bitmap> transformation, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(resizeStrategy, "resizeStrategy");
        if (str == null) {
            str = "";
        }
        imageView.post(new a(imageView, str, num, resizeStrategy, transformation, num2));
    }

    public static /* synthetic */ void loadImageWithGlide$default(ImageView imageView, String str, Integer num, ResizeStrategy resizeStrategy, Transformation transformation, Integer num2, int i11, Object obj) {
        Transformation transformation2;
        Integer num3;
        if ((i11 & 4) != 0) {
            resizeStrategy = ResizeStrategy.FitCenter;
        }
        ResizeStrategy resizeStrategy2 = resizeStrategy;
        if ((i11 & 8) != 0) {
            transformation2 = null;
        } else {
            transformation2 = transformation;
        }
        if ((i11 & 16) != 0) {
            num3 = null;
        } else {
            num3 = num2;
        }
        loadImageWithGlide(imageView, str, num, resizeStrategy2, transformation2, num3);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadImageWithGlide$lambda-1  reason: not valid java name */
    public static final void m9633loadImageWithGlide$lambda1(ImageView imageView, String str, Integer num, ResizeStrategy resizeStrategy, Transformation transformation, Integer num2) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(imageView, "$this_loadImageWithGlide");
        Intrinsics.checkNotNullParameter(str, "$imageUrl");
        Intrinsics.checkNotNullParameter(resizeStrategy, "$resizeStrategy");
        int max = Math.max(imageView.getWidth(), imageView.getHeight());
        String builder = Uri.parse(str).buildUpon().appendQueryParameter(QUERY_SIZE, String.valueOf(max)).appendQueryParameter(QUERY_QCOMMERCE, "true").toString();
        Intrinsics.checkNotNullExpressionValue(builder, "parse(imageUrl)\n        …)\n            .toString()");
        String builder2 = Uri.parse(str).buildUpon().appendQueryParameter(QUERY_SIZE, String.valueOf(max / 10)).appendQueryParameter(QUERY_QCOMMERCE, "true").toString();
        Intrinsics.checkNotNullExpressionValue(builder2, "parse(imageUrl)\n        …OMMERCE_VALUE).toString()");
        if (num != null) {
            num.intValue();
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            drawable = ContextExtensionsKt.getDrawableCompat(context, num.intValue());
        } else {
            drawable = null;
        }
        Context context2 = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "this.context");
        if (ContextExtensionsKt.isValidForGlide(context2)) {
            RequestBuilder<Drawable> load = Glide.with(imageView.getContext()).load(builder2);
            Intrinsics.checkNotNullExpressionValue(load, "with(this.context).load(thumbnailUrl)");
            int[] iArr = WhenMappings.$EnumSwitchMapping$0;
            int i11 = iArr[resizeStrategy.ordinal()];
            if (i11 == 1) {
                BaseRequestOptions centerInside = load.centerInside();
                Intrinsics.checkNotNullExpressionValue(centerInside, "thumbnailGlideAction.centerInside()");
                load = (RequestBuilder) centerInside;
            } else if (i11 == 2) {
                BaseRequestOptions fitCenter = load.fitCenter();
                Intrinsics.checkNotNullExpressionValue(fitCenter, "thumbnailGlideAction.fitCenter()");
                load = (RequestBuilder) fitCenter;
            } else if (i11 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            Drawable drawable2 = imageView.getResources().getDrawable(R.drawable.no_image_fallback, (Resources.Theme) null);
            drawable2.setColorFilter(new LightingColorFilter(-7829368, -7829368));
            RequestBuilder<Drawable> thumbnail = ((RequestBuilder) ((RequestBuilder) Glide.with(imageView.getContext()).load(builder).placeholder(drawable)).error(drawable2)).thumbnail(load);
            Intrinsics.checkNotNullExpressionValue(thumbnail, "with(this.context)\n     …eAction\n                )");
            int i12 = iArr[resizeStrategy.ordinal()];
            if (i12 == 1) {
                BaseRequestOptions centerInside2 = thumbnail.centerInside();
                Intrinsics.checkNotNullExpressionValue(centerInside2, "glideAction.centerInside()");
                thumbnail = (RequestBuilder) centerInside2;
            } else if (i12 == 2) {
                BaseRequestOptions fitCenter2 = thumbnail.fitCenter();
                Intrinsics.checkNotNullExpressionValue(fitCenter2, "glideAction.fitCenter()");
                thumbnail = (RequestBuilder) fitCenter2;
            } else if (i12 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            if (transformation != null) {
                BaseRequestOptions transform = thumbnail.transform((Transformation<Bitmap>) transformation);
                Intrinsics.checkNotNullExpressionValue(transform, "{\n                glideA…sformation)\n            }");
                thumbnail = (RequestBuilder) transform;
            }
            if (num2 != null) {
                BaseRequestOptions override = thumbnail.override(num2.intValue());
                Intrinsics.checkNotNullExpressionValue(override, "{\n                glideA…errideSize)\n            }");
                thumbnail = (RequestBuilder) override;
            }
            retryOnFailureAndReportToObservabilityIfRetryFails(imageView, thumbnail, str);
            thumbnail.into(imageView);
        }
    }

    private static final void retryOnFailureAndReportToObservabilityIfRetryFails(ImageView imageView, RequestBuilder<Drawable> requestBuilder, String str) {
        requestBuilder.listener(new BindingAdaptersKt$retryOnFailureAndReportToObservabilityIfRetryFails$1(new Ref.BooleanRef(), str, new WeakReference(imageView), requestBuilder));
    }

    public static final void setStrike(@NotNull TextView textView, boolean z11) {
        int i11;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (z11) {
            i11 = textView.getPaintFlags() | 16;
        } else {
            i11 = textView.getPaintFlags() & -17;
        }
        textView.setPaintFlags(i11);
    }
}
