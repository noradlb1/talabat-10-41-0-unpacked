package com.checkout.frames.utils.extensions;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toComposeStroke", "Landroidx/compose/foundation/BorderStroke;", "Lcom/checkout/frames/model/BorderStroke;", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BorderStrokeExtensionsKt {
    @NotNull
    public static final BorderStroke toComposeStroke(@NotNull com.checkout.frames.model.BorderStroke borderStroke) {
        Intrinsics.checkNotNullParameter(borderStroke, "<this>");
        return BorderStrokeKt.m191BorderStrokecXLIe8U(Dp.m5478constructorimpl((float) borderStroke.getWidth()), ColorKt.Color(borderStroke.getColor()));
    }
}
