package com.checkout.frames.mapper;

import com.checkout.frames.model.request.ImageStyleToClickableImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ImageStyleToClickableComposableImageMapper$LabelImage$1$3$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ImageStyleToClickableImageRequest $request;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageStyleToClickableComposableImageMapper$LabelImage$1$3$1(ImageStyleToClickableImageRequest imageStyleToClickableImageRequest) {
        super(0);
        this.$request = imageStyleToClickableImageRequest;
    }

    public final void invoke() {
        this.$request.getOnImageClick().invoke();
    }
}
