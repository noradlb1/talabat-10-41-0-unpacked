package com.checkout.frames.utils.extensions;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Dp;
import com.checkout.frames.model.Padding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toPaddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "Lcom/checkout/frames/model/Padding;", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PaddingExtensionsKt {
    @NotNull
    public static final PaddingValues toPaddingValues(@NotNull Padding padding) {
        Intrinsics.checkNotNullParameter(padding, "<this>");
        return PaddingKt.m482PaddingValuesa9UjIt4(Dp.m5478constructorimpl((float) padding.getStart()), Dp.m5478constructorimpl((float) padding.getTop()), Dp.m5478constructorimpl((float) padding.getEnd()), Dp.m5478constructorimpl((float) padding.getBottom()));
    }
}
