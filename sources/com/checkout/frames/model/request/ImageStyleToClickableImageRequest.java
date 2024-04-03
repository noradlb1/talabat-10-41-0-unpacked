package com.checkout.frames.model.request;

import com.checkout.frames.style.component.base.ImageStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/checkout/frames/model/request/ImageStyleToClickableImageRequest;", "", "style", "Lcom/checkout/frames/style/component/base/ImageStyle;", "onImageClick", "Lkotlin/Function0;", "", "(Lcom/checkout/frames/style/component/base/ImageStyle;Lkotlin/jvm/functions/Function0;)V", "getOnImageClick", "()Lkotlin/jvm/functions/Function0;", "getStyle", "()Lcom/checkout/frames/style/component/base/ImageStyle;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ImageStyleToClickableImageRequest {
    @NotNull
    private final Function0<Unit> onImageClick;
    @Nullable
    private final ImageStyle style;

    public ImageStyleToClickableImageRequest(@Nullable ImageStyle imageStyle, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onImageClick");
        this.style = imageStyle;
        this.onImageClick = function0;
    }

    public static /* synthetic */ ImageStyleToClickableImageRequest copy$default(ImageStyleToClickableImageRequest imageStyleToClickableImageRequest, ImageStyle imageStyle, Function0<Unit> function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            imageStyle = imageStyleToClickableImageRequest.style;
        }
        if ((i11 & 2) != 0) {
            function0 = imageStyleToClickableImageRequest.onImageClick;
        }
        return imageStyleToClickableImageRequest.copy(imageStyle, function0);
    }

    @Nullable
    public final ImageStyle component1() {
        return this.style;
    }

    @NotNull
    public final Function0<Unit> component2() {
        return this.onImageClick;
    }

    @NotNull
    public final ImageStyleToClickableImageRequest copy(@Nullable ImageStyle imageStyle, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onImageClick");
        return new ImageStyleToClickableImageRequest(imageStyle, function0);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageStyleToClickableImageRequest)) {
            return false;
        }
        ImageStyleToClickableImageRequest imageStyleToClickableImageRequest = (ImageStyleToClickableImageRequest) obj;
        return Intrinsics.areEqual((Object) this.style, (Object) imageStyleToClickableImageRequest.style) && Intrinsics.areEqual((Object) this.onImageClick, (Object) imageStyleToClickableImageRequest.onImageClick);
    }

    @NotNull
    public final Function0<Unit> getOnImageClick() {
        return this.onImageClick;
    }

    @Nullable
    public final ImageStyle getStyle() {
        return this.style;
    }

    public int hashCode() {
        ImageStyle imageStyle = this.style;
        return ((imageStyle == null ? 0 : imageStyle.hashCode()) * 31) + this.onImageClick.hashCode();
    }

    @NotNull
    public String toString() {
        ImageStyle imageStyle = this.style;
        Function0<Unit> function0 = this.onImageClick;
        return "ImageStyleToClickableImageRequest(style=" + imageStyle + ", onImageClick=" + function0 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageStyleToClickableImageRequest(ImageStyle imageStyle, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageStyle, (i11 & 2) != 0 ? AnonymousClass1.INSTANCE : function0);
    }
}
