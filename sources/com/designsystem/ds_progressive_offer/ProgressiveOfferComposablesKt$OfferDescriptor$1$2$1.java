package com.designsystem.ds_progressive_offer;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ProgressiveOfferComposablesKt$OfferDescriptor$1$2$1 extends Lambda implements Function1<TextLayoutResult, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<Alignment.Vertical> f32491g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressiveOfferComposablesKt$OfferDescriptor$1$2$1(MutableState<Alignment.Vertical> mutableState) {
        super(1);
        this.f32491g = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextLayoutResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TextLayoutResult textLayoutResult) {
        Alignment.Vertical vertical;
        Intrinsics.checkNotNullParameter(textLayoutResult, "it");
        MutableState<Alignment.Vertical> mutableState = this.f32491g;
        if (textLayoutResult.getLineCount() == 1) {
            vertical = Alignment.Companion.getCenterVertically();
        } else {
            vertical = Alignment.Companion.getTop();
        }
        ProgressiveOfferComposablesKt.m8516OfferDescriptor$lambda30(mutableState, vertical);
    }
}
