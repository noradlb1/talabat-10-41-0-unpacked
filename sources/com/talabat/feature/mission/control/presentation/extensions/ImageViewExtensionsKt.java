package com.talabat.feature.mission.control.presentation.extensions;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.BaseRequestOptions;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.feature.mission.control.presentation.R;
import en.a;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001\u001a\"\u0010\u000e\u001a\u00020\u000b*\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"QUERY_QCOMMERCE", "", "QUERY_QCOMMERCE_VALUE", "RETRY_DELAY_MILLIS", "", "THUMBNAIL_SIZE_DIVIDER", "", "isValidForGlide", "", "Landroid/content/Context;", "loadCenterInsideWithGlide", "", "Landroid/widget/ImageView;", "maybeImageUrl", "setupRetry", "glideAction", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "imageUrl", "com_talabat_feature_mission-control_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ImageViewExtensionsKt {
    @NotNull
    private static final String QUERY_QCOMMERCE = "qcommerce";
    @NotNull
    private static final String QUERY_QCOMMERCE_VALUE = "true";
    private static final long RETRY_DELAY_MILLIS = 1000;
    public static final int THUMBNAIL_SIZE_DIVIDER = 10;

    public static final boolean isValidForGlide(@NotNull Context context) {
        boolean z11;
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isDestroyed() || activity.isFinishing()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static final void loadCenterInsideWithGlide(@NotNull ImageView imageView, @Nullable String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        imageView.post(new a(str, imageView));
    }

    /* access modifiers changed from: private */
    /* renamed from: loadCenterInsideWithGlide$lambda-0  reason: not valid java name */
    public static final void m10229loadCenterInsideWithGlide$lambda0(String str, ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "$this_loadCenterInsideWithGlide");
        if (str == null) {
            str = "";
        }
        int max = Math.max(imageView.getWidth(), imageView.getHeight());
        String builder = Uri.parse(str).buildUpon().appendQueryParameter(BindingAdaptersKt.QUERY_SIZE, String.valueOf(max)).appendQueryParameter(QUERY_QCOMMERCE, "true").toString();
        Intrinsics.checkNotNullExpressionValue(builder, "parse(imageUrl)\n        …\n            ).toString()");
        String builder2 = Uri.parse(str).buildUpon().appendQueryParameter(BindingAdaptersKt.QUERY_SIZE, String.valueOf(max / 10)).appendQueryParameter(QUERY_QCOMMERCE, "true").toString();
        Intrinsics.checkNotNullExpressionValue(builder2, "parse(imageUrl)\n        …\n            ).toString()");
        Context context = imageView.getContext();
        boolean z11 = false;
        if (context != null && isValidForGlide(context)) {
            z11 = true;
        }
        if (z11) {
            Drawable drawable = imageView.getResources().getDrawable(R.drawable.no_image_fallback, (Resources.Theme) null);
            drawable.setColorFilter(new LightingColorFilter(-7829368, -7829368));
            BaseRequestOptions centerInside = ((RequestBuilder) Glide.with(imageView.getContext()).load(builder).error(drawable)).thumbnail((RequestBuilder) Glide.with(imageView.getContext()).load(builder2).centerInside()).centerInside();
            Intrinsics.checkNotNullExpressionValue(centerInside, "with(context)\n          …          .centerInside()");
            RequestBuilder requestBuilder = (RequestBuilder) centerInside;
            setupRetry(imageView, requestBuilder, str);
            requestBuilder.into(imageView);
        }
    }

    private static final void setupRetry(ImageView imageView, RequestBuilder<Drawable> requestBuilder, String str) {
        requestBuilder.listener(new ImageViewExtensionsKt$setupRetry$1(new Ref.BooleanRef(), new WeakReference(imageView), requestBuilder, str));
    }
}
