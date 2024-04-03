package com.checkout.frames.utils.extensions;

import com.checkout.frames.model.font.FontStyle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"toComposeFontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "Lcom/checkout/frames/model/font/FontStyle;", "(Lcom/checkout/frames/model/font/FontStyle;)I", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FontStyleExtensionsKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FontStyle.values().length];
            iArr[FontStyle.Normal.ordinal()] = 1;
            iArr[FontStyle.Italic.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int toComposeFontStyle(@NotNull FontStyle fontStyle) {
        Intrinsics.checkNotNullParameter(fontStyle, "<this>");
        int i11 = WhenMappings.$EnumSwitchMapping$0[fontStyle.ordinal()];
        if (i11 == 1) {
            return androidx.compose.ui.text.font.FontStyle.Companion.m5129getNormal_LCdwA();
        }
        if (i11 == 2) {
            return androidx.compose.ui.text.font.FontStyle.Companion.m5128getItalic_LCdwA();
        }
        throw new NoWhenBranchMatchedException();
    }
}
