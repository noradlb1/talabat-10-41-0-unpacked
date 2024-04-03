package com.checkout.frames.mapper;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.model.Margin;
import com.checkout.frames.style.component.base.DividerStyle;
import com.checkout.frames.style.view.DividerViewStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\u00020\b*\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¨\u0006\u000b"}, d2 = {"Lcom/checkout/frames/mapper/DividerStyleToViewStyleMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/DividerStyle;", "Lcom/checkout/frames/style/view/DividerViewStyle;", "()V", "map", "from", "withMargin", "Landroidx/compose/ui/Modifier;", "margin", "Lcom/checkout/frames/model/Margin;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DividerStyleToViewStyleMapper implements Mapper<DividerStyle, DividerViewStyle> {
    private final Modifier withMargin(Modifier modifier, Margin margin) {
        if (margin != null) {
            PaddingKt.m489paddingqDBjuR0(modifier, Dp.m5478constructorimpl((float) margin.getStart()), Dp.m5478constructorimpl((float) margin.getTop()), Dp.m5478constructorimpl((float) margin.getEnd()), Dp.m5478constructorimpl((float) margin.getBottom()));
        }
        return modifier;
    }

    @NotNull
    public DividerViewStyle map(@NotNull DividerStyle dividerStyle) {
        Intrinsics.checkNotNullParameter(dividerStyle, "from");
        return new DividerViewStyle(Dp.m5478constructorimpl((float) dividerStyle.getThickness()), ColorKt.Color(dividerStyle.getColor()), SizeKt.fillMaxWidth$default(withMargin(Modifier.Companion, dividerStyle.getMargin()), 0.0f, 1, (Object) null), (DefaultConstructorMarker) null);
    }
}
