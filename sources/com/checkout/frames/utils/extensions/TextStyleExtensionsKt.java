package com.checkout.frames.utils.extensions;

import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toComposeTextStyle", "Landroidx/compose/ui/text/TextStyle;", "Lcom/checkout/frames/style/component/base/TextStyle;", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TextStyleExtensionsKt {
    @NotNull
    public static final TextStyle toComposeTextStyle(@NotNull com.checkout.frames.style.component.base.TextStyle textStyle) {
        long j11;
        Intrinsics.checkNotNullParameter(textStyle, "<this>");
        long sp2 = TextUnitKt.getSp(textStyle.getSize());
        long Color = ColorKt.Color(textStyle.getColor());
        int composeTextAlign = TextAlignExtensionKt.toComposeTextAlign(textStyle.getTextAlign());
        FontFamily fontFamily = FontExtensionsKt.toFontFamily(textStyle.getFont());
        int composeFontStyle = FontStyleExtensionsKt.toComposeFontStyle(textStyle.getFontStyle());
        FontWeight composeFontWeight = FontWeightExtensionsKt.toComposeFontWeight(textStyle.getFontWeight());
        Integer lineHeight = textStyle.getLineHeight();
        if (lineHeight != null) {
            j11 = TextUnitKt.getSp(lineHeight.intValue());
        } else {
            j11 = TextUnit.Companion.m5670getUnspecifiedXSAIIZE();
        }
        return new TextStyle(Color, sp2, composeFontWeight, FontStyle.m5121boximpl(composeFontStyle), (FontSynthesis) null, fontFamily, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, TextAlign.m5359boximpl(composeTextAlign), (TextDirection) null, j11, (TextIndent) null, 180176, (DefaultConstructorMarker) null);
    }
}
