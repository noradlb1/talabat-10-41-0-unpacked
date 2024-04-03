package com.checkout.frames.component.cardnumber;

import androidx.compose.ui.text.input.OffsetMapping;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/checkout/frames/component/cardnumber/CardNumberTransformation$defaultCardNumberFormat$creditCardOffsetTranslator$1", "Landroidx/compose/ui/text/input/OffsetMapping;", "originalToTransformed", "", "offset", "transformedToOriginal", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardNumberTransformation$defaultCardNumberFormat$creditCardOffsetTranslator$1 implements OffsetMapping {
    final /* synthetic */ List<Integer> $pattern;

    public CardNumberTransformation$defaultCardNumberFormat$creditCardOffsetTranslator$1(List<Integer> list) {
        this.$pattern = list;
    }

    public int originalToTransformed(int i11) {
        int i12 = 0;
        for (Object next : this.$pattern) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (i11 < ((Number) next).intValue() - i12) {
                return i11 + i12;
            }
            i12 = i13;
        }
        return i11 + this.$pattern.size();
    }

    public int transformedToOriginal(int i11) {
        int i12 = 0;
        for (Object next : this.$pattern) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (i11 <= ((Number) next).intValue()) {
                return i11 - i12;
            }
            i12 = i13;
        }
        return i11 - this.$pattern.size();
    }
}
