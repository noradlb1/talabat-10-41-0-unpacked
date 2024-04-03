package com.checkout.frames.component.cardnumber;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import com.checkout.base.model.CardScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/checkout/frames/component/cardnumber/CardNumberTransformation;", "Landroidx/compose/ui/text/input/VisualTransformation;", "separator", "", "cardScheme", "Landroidx/compose/runtime/MutableState;", "Lcom/checkout/base/model/CardScheme;", "(CLandroidx/compose/runtime/MutableState;)V", "defaultCardNumberFormat", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "filter", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardNumberTransformation implements VisualTransformation {
    @NotNull
    private final MutableState<CardScheme> cardScheme;
    private final char separator;

    public CardNumberTransformation(char c11, @NotNull MutableState<CardScheme> mutableState) {
        Intrinsics.checkNotNullParameter(mutableState, "cardScheme");
        this.separator = c11;
        this.cardScheme = mutableState;
    }

    private final TransformedText defaultCardNumberFormat(AnnotatedString annotatedString) {
        List<Integer> numberSeparatorPattern = this.cardScheme.getValue().getNumberSeparatorPattern();
        StringBuilder sb2 = new StringBuilder();
        int length = annotatedString.length();
        for (int i11 = 0; i11 < length; i11++) {
            sb2.append(annotatedString.charAt(i11));
            if (numberSeparatorPattern.contains(Integer.valueOf(sb2.length()))) {
                sb2.append(this.separator);
            }
        }
        CardNumberTransformation$defaultCardNumberFormat$creditCardOffsetTranslator$1 cardNumberTransformation$defaultCardNumberFormat$creditCardOffsetTranslator$1 = new CardNumberTransformation$defaultCardNumberFormat$creditCardOffsetTranslator$1(numberSeparatorPattern);
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "strBuilder.toString()");
        return new TransformedText(new AnnotatedString(sb3, (List) null, (List) null, 6, (DefaultConstructorMarker) null), cardNumberTransformation$defaultCardNumberFormat$creditCardOffsetTranslator$1);
    }

    @NotNull
    public TransformedText filter(@NotNull AnnotatedString annotatedString) {
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        return defaultCardNumberFormat(annotatedString);
    }
}
