package com.talabat.talabatcommon.extentions;

import android.content.Context;
import android.widget.ImageView;
import com.talabat.core.network.imageDownloader.ImageDownloadHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"setImageResizeUrl", "", "Landroid/widget/ImageView;", "url", "", "width", "", "height", "isCircle", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ImageViewForTalabatKt {
    public static final void setImageResizeUrl(@NotNull ImageView imageView, @NotNull String str, int i11, int i12, boolean z11) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(str, "url");
        ImageDownloadHelper.Companion companion = ImageDownloadHelper.Companion;
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion.downloadImage(context, str, imageView, i11, i12, z11);
    }

    public static /* synthetic */ void setImageResizeUrl$default(ImageView imageView, String str, int i11, int i12, boolean z11, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = 0;
        }
        if ((i13 & 8) != 0) {
            z11 = false;
        }
        setImageResizeUrl(imageView, str, i11, i12, z11);
    }
}
