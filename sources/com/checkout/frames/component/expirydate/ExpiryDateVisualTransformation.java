package com.checkout.frames.component.expirydate;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/checkout/frames/component/expirydate/ExpiryDateVisualTransformation;", "Landroidx/compose/ui/text/input/VisualTransformation;", "()V", "separator", "", "filter", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "performExpiryDateFilter", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExpiryDateVisualTransformation implements VisualTransformation {
    /* access modifiers changed from: private */
    @NotNull
    public final String separator = " / ";

    private final TransformedText performExpiryDateFilter(AnnotatedString annotatedString) {
        StringBuilder sb2 = new StringBuilder();
        int length = annotatedString.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (i11 == 0 && Intrinsics.compare((int) annotatedString.charAt(i11), 49) > 0) {
                sb2.append("0" + annotatedString.charAt(i11) + this.separator);
            } else if (i11 != 1 || StringsKt__StringsKt.contains$default((CharSequence) sb2, (CharSequence) this.separator, false, 2, (Object) null)) {
                sb2.append(annotatedString.charAt(i11));
            } else {
                sb2.append(annotatedString.charAt(i11) + this.separator);
            }
        }
        ExpiryDateVisualTransformation$performExpiryDateFilter$expiryDateOffsetTranslator$1 expiryDateVisualTransformation$performExpiryDateFilter$expiryDateOffsetTranslator$1 = new ExpiryDateVisualTransformation$performExpiryDateFilter$expiryDateOffsetTranslator$1(annotatedString, this);
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "stringBuilder.toString()");
        return new TransformedText(new AnnotatedString(sb3, (List) null, (List) null, 6, (DefaultConstructorMarker) null), expiryDateVisualTransformation$performExpiryDateFilter$expiryDateOffsetTranslator$1);
    }

    @NotNull
    public TransformedText filter(@NotNull AnnotatedString annotatedString) {
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        return performExpiryDateFilter(annotatedString);
    }
}
