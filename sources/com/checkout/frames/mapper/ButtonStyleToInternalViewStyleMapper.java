package com.checkout.frames.mapper;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.model.BorderStroke;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.utils.extensions.BorderStrokeExtensionsKt;
import com.checkout.frames.utils.extensions.PaddingExtensionsKt;
import com.checkout.frames.utils.extensions.ShapeExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B-\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/checkout/frames/mapper/ButtonStyleToInternalViewStyleMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/ButtonStyle;", "Lcom/checkout/frames/style/view/InternalButtonViewStyle;", "containerMapper", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "Landroidx/compose/ui/Modifier;", "textLabelMapper", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "(Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;)V", "map", "from", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ButtonStyleToInternalViewStyleMapper implements Mapper<ButtonStyle, InternalButtonViewStyle> {
    @NotNull
    private final Mapper<ContainerStyle, Modifier> containerMapper;
    @NotNull
    private final Mapper<TextLabelStyle, TextLabelViewStyle> textLabelMapper;

    public ButtonStyleToInternalViewStyleMapper(@NotNull Mapper<ContainerStyle, Modifier> mapper, @NotNull Mapper<TextLabelStyle, TextLabelViewStyle> mapper2) {
        Intrinsics.checkNotNullParameter(mapper, "containerMapper");
        Intrinsics.checkNotNullParameter(mapper2, "textLabelMapper");
        this.containerMapper = mapper;
        this.textLabelMapper = mapper2;
    }

    @NotNull
    public InternalButtonViewStyle map(@NotNull ButtonStyle buttonStyle) {
        Intrinsics.checkNotNullParameter(buttonStyle, "from");
        float r42 = Dp.m5478constructorimpl((float) buttonStyle.getButtonElevation().getDefaultElevation());
        float r52 = Dp.m5478constructorimpl((float) buttonStyle.getButtonElevation().getPressedElevation());
        float r62 = Dp.m5478constructorimpl((float) buttonStyle.getButtonElevation().getFocusedElevation());
        float r72 = Dp.m5478constructorimpl((float) buttonStyle.getButtonElevation().getHoveredElevation());
        float r82 = Dp.m5478constructorimpl((float) buttonStyle.getButtonElevation().getDisabledElevation());
        long Color = ColorKt.Color(buttonStyle.getContainerColor());
        long Color2 = ColorKt.Color(buttonStyle.getDisabledContainerColor());
        long Color3 = ColorKt.Color(buttonStyle.getContentColor());
        long Color4 = ColorKt.Color(buttonStyle.getDisabledContentColor());
        Modifier map = this.containerMapper.map(buttonStyle.getContainerStyle());
        Shape composeShape = ShapeExtensionsKt.toComposeShape(buttonStyle.getShape(), buttonStyle.getCornerRadius());
        BorderStroke borderStroke = buttonStyle.getBorderStroke();
        return new InternalButtonViewStyle(r42, r52, r62, r72, r82, Color, Color2, Color3, Color4, map, composeShape, borderStroke != null ? BorderStrokeExtensionsKt.toComposeStroke(borderStroke) : null, PaddingExtensionsKt.toPaddingValues(buttonStyle.getContentPadding()), this.textLabelMapper.map(buttonStyle.getTextStyle()), (DefaultConstructorMarker) null);
    }
}
