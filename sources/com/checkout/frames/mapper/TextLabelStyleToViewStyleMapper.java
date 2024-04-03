package com.checkout.frames.mapper;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.utils.extensions.FontExtensionsKt;
import com.checkout.frames.utils.extensions.FontStyleExtensionsKt;
import com.checkout.frames.utils.extensions.FontWeightExtensionsKt;
import com.checkout.frames.utils.extensions.TextAlignExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/checkout/frames/mapper/TextLabelStyleToViewStyleMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "containerMapper", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "Landroidx/compose/ui/Modifier;", "(Lcom/checkout/base/mapper/Mapper;)V", "map", "from", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextLabelStyleToViewStyleMapper implements Mapper<TextLabelStyle, TextLabelViewStyle> {
    @NotNull
    private final Mapper<ContainerStyle, Modifier> containerMapper;

    public TextLabelStyleToViewStyleMapper(@NotNull Mapper<ContainerStyle, Modifier> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "containerMapper");
        this.containerMapper = mapper;
    }

    @NotNull
    public TextLabelViewStyle map(@NotNull TextLabelStyle textLabelStyle) {
        Intrinsics.checkNotNullParameter(textLabelStyle, "from");
        Modifier map = this.containerMapper.map(textLabelStyle.getContainerStyle());
        long Color = ColorKt.Color(textLabelStyle.getTextStyle().getColor());
        long sp2 = TextUnitKt.getSp(textLabelStyle.getTextStyle().getSize());
        int composeTextAlign = TextAlignExtensionKt.toComposeTextAlign(textLabelStyle.getTextStyle().getTextAlign());
        FontFamily fontFamily = FontExtensionsKt.toFontFamily(textLabelStyle.getTextStyle().getFont());
        int composeFontStyle = FontStyleExtensionsKt.toComposeFontStyle(textLabelStyle.getTextStyle().getFontStyle());
        FontWeight composeFontWeight = FontWeightExtensionsKt.toComposeFontWeight(textLabelStyle.getTextStyle().getFontWeight());
        int maxLines = textLabelStyle.getTextStyle().getMaxLines();
        Integer lineHeight = textLabelStyle.getTextStyle().getLineHeight();
        return new TextLabelViewStyle(map, Color, sp2, FontStyle.m5121boximpl(composeFontStyle), composeFontWeight, fontFamily, 0, (TextDecoration) null, TextAlign.m5359boximpl(composeTextAlign), lineHeight != null ? TextUnitKt.getSp(lineHeight.intValue()) : TextUnit.Companion.m5670getUnspecifiedXSAIIZE(), 0, false, maxLines, (Function1) null, (TextStyle) null, false, 60608, (DefaultConstructorMarker) null);
    }
}
