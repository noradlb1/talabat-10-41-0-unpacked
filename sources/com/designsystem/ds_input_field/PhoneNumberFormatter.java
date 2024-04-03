package com.designsystem.ds_input_field;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import com.google.i18n.phonenumbers.AsYouTypeFormatter;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/designsystem/ds_input_field/PhoneNumberFormatter;", "Landroidx/compose/ui/text/input/VisualTransformation;", "regionCode", "", "prefix", "(Ljava/lang/String;Ljava/lang/String;)V", "filter", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PhoneNumberFormatter implements VisualTransformation {
    @NotNull
    private final String prefix;
    @NotNull
    private final String regionCode;

    public PhoneNumberFormatter(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "regionCode");
        Intrinsics.checkNotNullParameter(str2, "prefix");
        this.regionCode = str;
        this.prefix = str2;
    }

    @NotNull
    public TransformedText filter(@NotNull AnnotatedString annotatedString) {
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        String str = this.prefix;
        StringBuilder sb2 = new StringBuilder();
        int length = annotatedString.length();
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = annotatedString.charAt(i11);
            if (Character.isDigit(charAt)) {
                sb2.append(charAt);
            }
        }
        String stringPlus = Intrinsics.stringPlus(str, sb2);
        AsYouTypeFormatter asYouTypeFormatter = PhoneNumberUtil.getInstance().getAsYouTypeFormatter(this.regionCode);
        String str2 = "";
        for (int i12 = 0; i12 < stringPlus.length(); i12++) {
            str2 = asYouTypeFormatter.inputDigitAndRememberPosition(stringPlus.charAt(i12));
            Intrinsics.checkNotNullExpressionValue(str2, "formatter.inputDigitAndRememberPosition(it)");
        }
        String removePrefix = StringsKt__StringsKt.removePrefix(str2, (CharSequence) this.prefix);
        if (removePrefix != null) {
            String obj = StringsKt__StringsKt.trim((CharSequence) removePrefix).toString();
            return new TransformedText(new AnnotatedString(obj, (List) null, (List) null, 6, (DefaultConstructorMarker) null), new PhoneNumberOffsetMapping(obj));
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }
}
