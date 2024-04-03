package com.checkout.frames.utils.extensions;

import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import com.checkout.frames.model.font.Font;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "Lcom/checkout/frames/model/font/Font;", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FontExtensionsKt {
    @NotNull
    public static final FontFamily toFontFamily(@NotNull Font font) {
        Intrinsics.checkNotNullParameter(font, "<this>");
        if (font instanceof Font.Default) {
            return FontFamily.Companion.getDefault();
        }
        if (font instanceof Font.Serif) {
            return FontFamily.Companion.getSerif();
        }
        if (font instanceof Font.SansSerif) {
            return FontFamily.Companion.getSansSerif();
        }
        if (font instanceof Font.Monospace) {
            return FontFamily.Companion.getMonospace();
        }
        if (font instanceof Font.Cursive) {
            return FontFamily.Companion.getCursive();
        }
        if (font instanceof Font.Custom) {
            ArrayList arrayList = new ArrayList();
            Font.Custom custom = (Font.Custom) font;
            int normalFont = custom.getNormalFont();
            FontWeight.Companion companion = FontWeight.Companion;
            arrayList.add(FontKt.m5107FontYpTlLL0$default(normalFont, companion.getNormal(), 0, 0, 12, (Object) null));
            Integer normalItalicFont = custom.getNormalItalicFont();
            if (normalItalicFont != null) {
                arrayList.add(FontKt.m5107FontYpTlLL0$default(normalItalicFont.intValue(), companion.getNormal(), FontStyle.Companion.m5128getItalic_LCdwA(), 0, 8, (Object) null));
            }
            Integer lightFont = custom.getLightFont();
            if (lightFont != null) {
                arrayList.add(FontKt.m5107FontYpTlLL0$default(lightFont.intValue(), companion.getLight(), 0, 0, 12, (Object) null));
            }
            Integer mediumFont = custom.getMediumFont();
            if (mediumFont != null) {
                arrayList.add(FontKt.m5107FontYpTlLL0$default(mediumFont.intValue(), companion.getMedium(), 0, 0, 12, (Object) null));
            }
            Integer semiBold = custom.getSemiBold();
            if (semiBold != null) {
                arrayList.add(FontKt.m5107FontYpTlLL0$default(semiBold.intValue(), companion.getSemiBold(), 0, 0, 12, (Object) null));
            }
            Integer boldFont = custom.getBoldFont();
            if (boldFont != null) {
                arrayList.add(FontKt.m5107FontYpTlLL0$default(boldFont.intValue(), companion.getBold(), 0, 0, 12, (Object) null));
            }
            Integer extraBoldFont = custom.getExtraBoldFont();
            if (extraBoldFont != null) {
                arrayList.add(FontKt.m5107FontYpTlLL0$default(extraBoldFont.intValue(), companion.getExtraBold(), 0, 0, 12, (Object) null));
            }
            return FontFamilyKt.FontFamily((List<? extends androidx.compose.ui.text.font.Font>) arrayList);
        }
        throw new NoWhenBranchMatchedException();
    }
}
