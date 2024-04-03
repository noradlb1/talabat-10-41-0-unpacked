package com.designsystem.ds_input_field;

import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/designsystem/ds_input_field/PhoneNumberOffsetMapping;", "Landroidx/compose/ui/text/input/OffsetMapping;", "transformedText", "", "(Ljava/lang/String;)V", "calculateOriginalOffset", "", "transformedOffset", "calculateTransformedOffset", "originalOffset", "originalToTransformed", "offset", "transformedToOriginal", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PhoneNumberOffsetMapping implements OffsetMapping {
    @NotNull
    private final String transformedText;

    public PhoneNumberOffsetMapping(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "transformedText");
        this.transformedText = str;
    }

    private final int calculateOriginalOffset(String str, int i11) {
        boolean z11;
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return 0;
        }
        String take = StringsKt___StringsKt.take(str, i11);
        StringBuilder sb2 = new StringBuilder();
        int length = take.length();
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = take.charAt(i12);
            if (!Character.isDigit(charAt)) {
                sb2.append(charAt);
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "filterTo(StringBuilder(), predicate).toString()");
        return i11 - sb3.length();
    }

    private final int calculateTransformedOffset(String str, int i11) {
        boolean z11;
        boolean z12;
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return 0;
        }
        int i12 = i11;
        int i13 = 0;
        int i14 = 0;
        do {
            Character orNull = StringsKt___StringsKt.getOrNull(str, i13);
            if (orNull != null && !Character.isDigit(orNull.charValue())) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                i14++;
                i12++;
            }
            i13++;
        } while (i13 < i12);
        return i11 + i14;
    }

    public int originalToTransformed(int i11) {
        return calculateTransformedOffset(this.transformedText, i11);
    }

    public int transformedToOriginal(int i11) {
        return calculateOriginalOffset(this.transformedText, i11);
    }
}
