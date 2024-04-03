package com.checkout.frames.utils.extensions;

import com.checkout.frames.model.font.FontWeight;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toComposeFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "Lcom/checkout/frames/model/font/FontWeight;", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FontWeightExtensionsKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FontWeight.values().length];
            iArr[FontWeight.Light.ordinal()] = 1;
            iArr[FontWeight.Normal.ordinal()] = 2;
            iArr[FontWeight.Medium.ordinal()] = 3;
            iArr[FontWeight.SemiBold.ordinal()] = 4;
            iArr[FontWeight.Bold.ordinal()] = 5;
            iArr[FontWeight.ExtraBold.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public static final androidx.compose.ui.text.font.FontWeight toComposeFontWeight(@NotNull FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(fontWeight, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[fontWeight.ordinal()]) {
            case 1:
                return androidx.compose.ui.text.font.FontWeight.Companion.getLight();
            case 2:
                return androidx.compose.ui.text.font.FontWeight.Companion.getNormal();
            case 3:
                return androidx.compose.ui.text.font.FontWeight.Companion.getMedium();
            case 4:
                return androidx.compose.ui.text.font.FontWeight.Companion.getSemiBold();
            case 5:
                return androidx.compose.ui.text.font.FontWeight.Companion.getBold();
            case 6:
                return androidx.compose.ui.text.font.FontWeight.Companion.getExtraBold();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
