package com.checkout.frames.mapper;

import android.annotation.SuppressLint;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.model.BorderStroke;
import com.checkout.frames.model.Margin;
import com.checkout.frames.model.Padding;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.utils.extensions.BorderStrokeExtensionsKt;
import com.checkout.frames.utils.extensions.ShapeExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0017¨\u0006\u0007"}, d2 = {"Lcom/checkout/frames/mapper/ContainerStyleToModifierMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "Landroidx/compose/ui/Modifier;", "()V", "map", "from", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ContainerStyleToModifierMapper implements Mapper<ContainerStyle, Modifier> {
    @NotNull
    @SuppressLint({"ModifierFactoryExtensionFunction"})
    public Modifier map(@NotNull ContainerStyle containerStyle) {
        Intrinsics.checkNotNullParameter(containerStyle, "from");
        Shape composeShape = ShapeExtensionsKt.toComposeShape(containerStyle.getShape(), containerStyle.getCornerRadius());
        Modifier r12 = BackgroundKt.m177backgroundbw27NRU$default(Modifier.Companion, Color.Companion.m2954getTransparent0d7_KjU(), (Shape) null, 2, (Object) null);
        Integer height = containerStyle.getHeight();
        if (height != null) {
            r12 = SizeKt.m544height3ABfNKs(r12, Dp.m5478constructorimpl((float) height.intValue()));
        }
        Integer width = containerStyle.getWidth();
        if (width != null) {
            r12 = SizeKt.m563width3ABfNKs(r12, Dp.m5478constructorimpl((float) width.intValue()));
        }
        Margin margin = containerStyle.getMargin();
        if (margin != null) {
            r12 = PaddingKt.m489paddingqDBjuR0(r12, Dp.m5478constructorimpl((float) margin.getStart()), Dp.m5478constructorimpl((float) margin.getTop()), Dp.m5478constructorimpl((float) margin.getEnd()), Dp.m5478constructorimpl((float) margin.getBottom()));
        }
        Modifier r13 = BackgroundKt.m176backgroundbw27NRU(r12, ColorKt.Color(containerStyle.getColor()), composeShape);
        BorderStroke borderStroke = containerStyle.getBorderStroke();
        if (borderStroke != null) {
            r13 = BorderKt.border(r13, BorderStrokeExtensionsKt.toComposeStroke(borderStroke), composeShape);
        }
        Padding padding = containerStyle.getPadding();
        return padding != null ? PaddingKt.m489paddingqDBjuR0(r13, Dp.m5478constructorimpl((float) padding.getStart()), Dp.m5478constructorimpl((float) padding.getTop()), Dp.m5478constructorimpl((float) padding.getEnd()), Dp.m5478constructorimpl((float) padding.getBottom())) : r13;
    }
}
