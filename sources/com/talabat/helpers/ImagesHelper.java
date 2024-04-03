package com.talabat.helpers;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.talabat.R;
import com.talabat.designhelpers.GlideActivityExceptionHandler;
import com.talabat.talabatcommon.helpers.GlideApp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/helpers/ImagesHelper;", "", "()V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImagesHelper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/helpers/ImagesHelper$Companion;", "", "()V", "getItemThumbnail", "", "thumbnail", "loadImageWithRadius", "", "context", "Landroid/content/Context;", "url", "imageView", "Landroid/widget/ImageView;", "radius", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getItemThumbnail(@Nullable String str) {
            int i11;
            boolean z11;
            if (str == null) {
                return "";
            }
            int length = str.length() - 1;
            int i12 = 0;
            boolean z12 = false;
            while (i12 <= length) {
                if (!z12) {
                    i11 = i12;
                } else {
                    i11 = length;
                }
                if (Intrinsics.compare((int) str.charAt(i11), 32) <= 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z12) {
                    if (!z11) {
                        z12 = true;
                    } else {
                        i12++;
                    }
                } else if (!z11) {
                    break;
                } else {
                    length--;
                }
            }
            if (TalabatUtils.isNullOrEmpty(str.subSequence(i12, length + 1).toString())) {
                return "";
            }
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "menuitems/", false, 2, (Object) null)) {
                return str;
            }
            String encode = Uri.encode(str);
            return StringsKt__StringsJVMKt.replace$default(GlobalDataModel.imageBaseUrl + "menuitems/" + encode, " ", "%20", false, 4, (Object) null);
        }

        public final void loadImageWithRadius(@NotNull Context context, @NotNull String str, @NotNull ImageView imageView, float f11) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            if (GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(context)) {
                Resources resources = context.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
                float applyDimension = TypedValue.applyDimension(1, f11, resources.getDisplayMetrics());
                GlideApp.with(context).clear((View) imageView);
                GlideApp.with(context).load(str).transform((Transformation) new MultiTransformation((Transformation<T>[]) new Transformation[]{new CenterCrop(), new RoundedCorners((int) applyDimension)})).placeholder((int) R.drawable.glide_placeholder).into(imageView);
            }
        }
    }
}
