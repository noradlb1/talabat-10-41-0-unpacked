package com.talabat.core.network.imageDownloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.huawei.hms.framework.common.ContainerUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/core/network/imageDownloader/ImageDownloadHelper;", "", "()V", "Companion", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageDownloadHelper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J<\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013J>\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J6\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c¨\u0006\u001d"}, d2 = {"Lcom/talabat/core/network/imageDownloader/ImageDownloadHelper$Companion;", "", "()V", "addResizeApiParams", "", "url", "width", "", "height", "downloadImage", "", "context", "Landroid/content/Context;", "imageView", "Landroid/widget/ImageView;", "isCircle", "", "downloadImageAsBackground", "layout", "Landroid/view/ViewGroup;", "downloadImageSpecificTransform", "transform", "Lcom/talabat/core/network/imageDownloader/TransformType;", "downloadUsingGlide", "finalUrl", "requestOptions", "Lcom/bumptech/glide/request/RequestOptions;", "errorPlaceholder", "Landroid/graphics/drawable/Drawable;", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TransformType.values().length];
                iArr[TransformType.FIT_CENTER.ordinal()] = 1;
                iArr[TransformType.CENTER_INSIDE.ordinal()] = 2;
                iArr[TransformType.CENTER_CROP.ordinal()] = 3;
                iArr[TransformType.CIRCLE_CROP.ordinal()] = 4;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String addResizeApiParams(String str, int i11, int i12) {
            if (i11 == 0 && i12 == 0) {
                return str;
            }
            String str2 = str + TypeDescription.Generic.OfWildcardType.SYMBOL;
            if (i11 != 0) {
                str2 = str2 + "width=" + i11;
            }
            if (i12 == 0) {
                return str2;
            }
            if (StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "width", false, 2, (Object) null)) {
                str2 = str2 + ContainerUtils.FIELD_DELIMITER;
            }
            return str2 + "height=" + i12;
        }

        public static /* synthetic */ void downloadImage$default(Companion companion, Context context, String str, ImageView imageView, int i11, int i12, boolean z11, int i13, Object obj) {
            companion.downloadImage(context, str, imageView, (i13 & 8) != 0 ? 0 : i11, (i13 & 16) != 0 ? 0 : i12, (i13 & 32) != 0 ? false : z11);
        }

        public static /* synthetic */ void downloadImageSpecificTransform$default(Companion companion, Context context, String str, ImageView imageView, int i11, int i12, TransformType transformType, int i13, Object obj) {
            companion.downloadImageSpecificTransform(context, str, imageView, (i13 & 8) != 0 ? 0 : i11, (i13 & 16) != 0 ? 0 : i12, (i13 & 32) != 0 ? null : transformType);
        }

        public static /* synthetic */ void downloadUsingGlide$default(Companion companion, Context context, String str, ImageView imageView, RequestOptions requestOptions, Drawable drawable, int i11, Object obj) {
            companion.downloadUsingGlide(context, str, imageView, (i11 & 8) != 0 ? null : requestOptions, (i11 & 16) != 0 ? null : drawable);
        }

        public final void downloadImage(@NotNull Context context, @NotNull String str, @NotNull ImageView imageView, int i11, int i12, boolean z11) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            String addResizeApiParams = addResizeApiParams(str, i11, i12);
            if (z11) {
                downloadUsingGlide$default(this, context, addResizeApiParams, imageView, RequestOptions.circleCropTransform(), (Drawable) null, 16, (Object) null);
                return;
            }
            downloadUsingGlide$default(this, context, addResizeApiParams, imageView, (RequestOptions) null, (Drawable) null, 24, (Object) null);
        }

        public final void downloadImageAsBackground(@NotNull Context context, @NotNull String str, @NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(viewGroup, TtmlNode.TAG_LAYOUT);
            Glide.with(context.getApplicationContext()).load(str).into(new ImageDownloadHelper$Companion$downloadImageAsBackground$1(viewGroup));
        }

        public final void downloadImageSpecificTransform(@NotNull Context context, @NotNull String str, @NotNull ImageView imageView, int i11, int i12, @Nullable TransformType transformType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            String addResizeApiParams = addResizeApiParams(str, i11, i12);
            RequestOptions requestOptions = new RequestOptions();
            if (transformType != null) {
                int i13 = WhenMappings.$EnumSwitchMapping$0[transformType.ordinal()];
                if (i13 == 1) {
                    RequestOptions requestOptions2 = (RequestOptions) requestOptions.fitCenter();
                } else if (i13 == 2) {
                    RequestOptions requestOptions3 = (RequestOptions) requestOptions.centerInside();
                } else if (i13 == 3) {
                    RequestOptions requestOptions4 = (RequestOptions) requestOptions.centerCrop();
                } else if (i13 == 4) {
                    RequestOptions requestOptions5 = (RequestOptions) requestOptions.circleCrop();
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            downloadUsingGlide$default(this, context, addResizeApiParams, imageView, requestOptions, (Drawable) null, 16, (Object) null);
        }

        public final void downloadUsingGlide(@NotNull Context context, @NotNull String str, @NotNull ImageView imageView, @Nullable RequestOptions requestOptions, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "finalUrl");
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            RequestBuilder<Drawable> load = Glide.with(context.getApplicationContext()).load(str);
            Intrinsics.checkNotNullExpressionValue(load, "with(context.application…          .load(finalUrl)");
            if (drawable != null) {
                RequestBuilder requestBuilder = (RequestBuilder) load.error(drawable);
            }
            if (requestOptions != null) {
                load.apply((BaseRequestOptions<?>) requestOptions);
            }
            load.into(imageView);
        }
    }
}
