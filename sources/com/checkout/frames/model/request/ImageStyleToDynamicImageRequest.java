package com.checkout.frames.model.request;

import com.checkout.frames.style.component.base.ImageStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u0005HÆ\u0003J?\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/checkout/frames/model/request/ImageStyleToDynamicImageRequest;", "", "style", "Lcom/checkout/frames/style/component/base/ImageStyle;", "dynamicImageId", "Lkotlinx/coroutines/flow/Flow;", "", "onImageClick", "Lkotlin/Function0;", "", "(Lcom/checkout/frames/style/component/base/ImageStyle;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;)V", "getDynamicImageId", "()Lkotlinx/coroutines/flow/Flow;", "getOnImageClick", "getStyle", "()Lcom/checkout/frames/style/component/base/ImageStyle;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ImageStyleToDynamicImageRequest {
    @NotNull
    private final Flow<Integer> dynamicImageId;
    @NotNull
    private final Flow<Function0<Unit>> onImageClick;
    @Nullable
    private final ImageStyle style;

    public ImageStyleToDynamicImageRequest(@Nullable ImageStyle imageStyle, @NotNull Flow<Integer> flow, @NotNull Flow<? extends Function0<Unit>> flow2) {
        Intrinsics.checkNotNullParameter(flow, "dynamicImageId");
        Intrinsics.checkNotNullParameter(flow2, "onImageClick");
        this.style = imageStyle;
        this.dynamicImageId = flow;
        this.onImageClick = flow2;
    }

    public static /* synthetic */ ImageStyleToDynamicImageRequest copy$default(ImageStyleToDynamicImageRequest imageStyleToDynamicImageRequest, ImageStyle imageStyle, Flow<Integer> flow, Flow<Function0<Unit>> flow2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            imageStyle = imageStyleToDynamicImageRequest.style;
        }
        if ((i11 & 2) != 0) {
            flow = imageStyleToDynamicImageRequest.dynamicImageId;
        }
        if ((i11 & 4) != 0) {
            flow2 = imageStyleToDynamicImageRequest.onImageClick;
        }
        return imageStyleToDynamicImageRequest.copy(imageStyle, flow, flow2);
    }

    @Nullable
    public final ImageStyle component1() {
        return this.style;
    }

    @NotNull
    public final Flow<Integer> component2() {
        return this.dynamicImageId;
    }

    @NotNull
    public final Flow<Function0<Unit>> component3() {
        return this.onImageClick;
    }

    @NotNull
    public final ImageStyleToDynamicImageRequest copy(@Nullable ImageStyle imageStyle, @NotNull Flow<Integer> flow, @NotNull Flow<? extends Function0<Unit>> flow2) {
        Intrinsics.checkNotNullParameter(flow, "dynamicImageId");
        Intrinsics.checkNotNullParameter(flow2, "onImageClick");
        return new ImageStyleToDynamicImageRequest(imageStyle, flow, flow2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageStyleToDynamicImageRequest)) {
            return false;
        }
        ImageStyleToDynamicImageRequest imageStyleToDynamicImageRequest = (ImageStyleToDynamicImageRequest) obj;
        return Intrinsics.areEqual((Object) this.style, (Object) imageStyleToDynamicImageRequest.style) && Intrinsics.areEqual((Object) this.dynamicImageId, (Object) imageStyleToDynamicImageRequest.dynamicImageId) && Intrinsics.areEqual((Object) this.onImageClick, (Object) imageStyleToDynamicImageRequest.onImageClick);
    }

    @NotNull
    public final Flow<Integer> getDynamicImageId() {
        return this.dynamicImageId;
    }

    @NotNull
    public final Flow<Function0<Unit>> getOnImageClick() {
        return this.onImageClick;
    }

    @Nullable
    public final ImageStyle getStyle() {
        return this.style;
    }

    public int hashCode() {
        ImageStyle imageStyle = this.style;
        return ((((imageStyle == null ? 0 : imageStyle.hashCode()) * 31) + this.dynamicImageId.hashCode()) * 31) + this.onImageClick.hashCode();
    }

    @NotNull
    public String toString() {
        ImageStyle imageStyle = this.style;
        Flow<Integer> flow = this.dynamicImageId;
        Flow<Function0<Unit>> flow2 = this.onImageClick;
        return "ImageStyleToDynamicImageRequest(style=" + imageStyle + ", dynamicImageId=" + flow + ", onImageClick=" + flow2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageStyleToDynamicImageRequest(ImageStyle imageStyle, Flow flow, Flow flow2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageStyle, flow, (i11 & 4) != 0 ? FlowKt.flowOf(null) : flow2);
    }
}
