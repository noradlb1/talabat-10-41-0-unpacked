package com.checkout.frames.component.expirydate;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/checkout/frames/component/expirydate/ExpiryDateVisualTransformation$performExpiryDateFilter$expiryDateOffsetTranslator$1", "Landroidx/compose/ui/text/input/OffsetMapping;", "originalToTransformed", "", "offset", "transformedToOriginal", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExpiryDateVisualTransformation$performExpiryDateFilter$expiryDateOffsetTranslator$1 implements OffsetMapping {
    final /* synthetic */ AnnotatedString $text;
    final /* synthetic */ ExpiryDateVisualTransformation this$0;

    public ExpiryDateVisualTransformation$performExpiryDateFilter$expiryDateOffsetTranslator$1(AnnotatedString annotatedString, ExpiryDateVisualTransformation expiryDateVisualTransformation) {
        this.$text = annotatedString;
        this.this$0 = expiryDateVisualTransformation;
    }

    public int originalToTransformed(int i11) {
        boolean z11;
        int i12 = 1;
        if (this.$text.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || Intrinsics.compare((int) this.$text.charAt(0), 49) <= 0) {
            i12 = 0;
        }
        if (i11 == 0) {
            return i11;
        }
        if (i12 != 0 || i11 >= 2) {
            return i11 + this.this$0.separator.length() + i12;
        }
        return i11;
    }

    public int transformedToOriginal(int i11) {
        boolean z11;
        int i12 = 1;
        if (this.$text.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || Intrinsics.compare((int) this.$text.charAt(0), 49) <= 0) {
            i12 = 0;
        }
        if (i11 == 0) {
            return i11;
        }
        if (i12 != 0 || i11 >= 2) {
            return (i11 - this.this$0.separator.length()) - i12;
        }
        return i11;
    }
}
