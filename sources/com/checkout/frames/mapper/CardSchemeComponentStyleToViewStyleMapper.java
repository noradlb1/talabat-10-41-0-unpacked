package com.checkout.frames.mapper;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.CardSchemeComponentStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.ImageContainerStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.view.CardSchemeComponentViewStyle;
import com.checkout.frames.style.view.FlowRowViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B-\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/checkout/frames/mapper/CardSchemeComponentStyleToViewStyleMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/CardSchemeComponentStyle;", "Lcom/checkout/frames/style/view/CardSchemeComponentViewStyle;", "textLabelStyleMapper", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "containerMapper", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "Landroidx/compose/ui/Modifier;", "(Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;)V", "map", "from", "provideFlowRowViewStyle", "Lcom/checkout/frames/style/view/FlowRowViewStyle;", "imageContainerStyle", "Lcom/checkout/frames/style/component/base/ImageContainerStyle;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardSchemeComponentStyleToViewStyleMapper implements Mapper<CardSchemeComponentStyle, CardSchemeComponentViewStyle> {
    @NotNull
    private final Mapper<ContainerStyle, Modifier> containerMapper;
    @NotNull
    private final Mapper<TextLabelStyle, TextLabelViewStyle> textLabelStyleMapper;

    public CardSchemeComponentStyleToViewStyleMapper(@NotNull Mapper<TextLabelStyle, TextLabelViewStyle> mapper, @NotNull Mapper<ContainerStyle, Modifier> mapper2) {
        Intrinsics.checkNotNullParameter(mapper, "textLabelStyleMapper");
        Intrinsics.checkNotNullParameter(mapper2, "containerMapper");
        this.textLabelStyleMapper = mapper;
        this.containerMapper = mapper2;
    }

    private final FlowRowViewStyle provideFlowRowViewStyle(ImageContainerStyle imageContainerStyle) {
        return new FlowRowViewStyle(Dp.m5478constructorimpl((float) imageContainerStyle.getMainAxisSpacing()), Dp.m5478constructorimpl((float) imageContainerStyle.getCrossAxisSpacing()), SizeKt.fillMaxWidth$default(this.containerMapper.map(imageContainerStyle.getContainerStyle()), 0.0f, 1, (Object) null), (DefaultConstructorMarker) null);
    }

    @NotNull
    public CardSchemeComponentViewStyle map(@NotNull CardSchemeComponentStyle cardSchemeComponentStyle) {
        Intrinsics.checkNotNullParameter(cardSchemeComponentStyle, "from");
        return new CardSchemeComponentViewStyle(this.textLabelStyleMapper.map(cardSchemeComponentStyle.getTitleStyle()), SizeKt.fillMaxWidth$default(this.containerMapper.map(cardSchemeComponentStyle.getContainerStyle()), 0.0f, 1, (Object) null), provideFlowRowViewStyle(cardSchemeComponentStyle.getImageContainerStyle()));
    }
}
