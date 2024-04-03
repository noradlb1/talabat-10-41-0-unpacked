package com.talabat.feature.pharmacy.extensions;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.designsystem.marshmallow.R;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ln.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"THUMBNAIL_SIZE_DIVIDER", "", "loadImageWithGlide", "", "Landroid/widget/ImageView;", "imageUrl", "", "com_talabat_feature_pharmacy_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ViewExtensionsKt {
    public static final int THUMBNAIL_SIZE_DIVIDER = 10;

    public static final void loadImageWithGlide(@NotNull ImageView imageView, @NotNull String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        imageView.post(new a(imageView, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: loadImageWithGlide$lambda-0  reason: not valid java name */
    public static final void m10235loadImageWithGlide$lambda0(ImageView imageView, String str) {
        Intrinsics.checkNotNullParameter(imageView, "$this_loadImageWithGlide");
        Intrinsics.checkNotNullParameter(str, "$imageUrl");
        int max = Math.max(imageView.getWidth(), imageView.getHeight());
        String builder = Uri.parse(str).buildUpon().appendQueryParameter(BindingAdaptersKt.QUERY_SIZE, String.valueOf(max)).toString();
        Intrinsics.checkNotNullExpressionValue(builder, "parse(imageUrl)\n        …)\n            .toString()");
        String builder2 = Uri.parse(str).buildUpon().appendQueryParameter(BindingAdaptersKt.QUERY_SIZE, String.valueOf(max / 10)).toString();
        Intrinsics.checkNotNullExpressionValue(builder2, "parse(imageUrl)\n        …\n            ).toString()");
        try {
            ((RequestBuilder) Glide.with((View) imageView).load(builder).error(R.drawable.ds_no_image)).thumbnail(Glide.with(imageView.getContext()).load(builder2)).into(imageView);
        } catch (Throwable unused) {
        }
    }
}
