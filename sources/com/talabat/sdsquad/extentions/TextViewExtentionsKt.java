package com.talabat.sdsquad.extentions;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001a\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0002¨\u0006\t"}, d2 = {"deleteLine", "", "Landroid/widget/TextView;", "setColorOfSubstring", "substring", "", "color", "", "underLine", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TextViewExtentionsKt {
    public static final void deleteLine(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.getPaint().setFlags(textView.getPaint().getFlags() | 16);
        textView.getPaint().setAntiAlias(true);
    }

    public static final void setColorOfSubstring(@NotNull TextView textView, @NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(str, "substring");
        try {
            SpannableString spannableString = new SpannableString(textView.getText());
            CharSequence text = textView.getText();
            Intrinsics.checkNotNullExpressionValue(text, "text");
            int indexOf$default = StringsKt__StringsKt.indexOf$default(text, str, 0, false, 6, (Object) null);
            spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(textView.getContext(), i11)), indexOf$default, str.length() + indexOf$default, 33);
            textView.setText(spannableString);
        } catch (Exception unused) {
            CharSequence text2 = textView.getText();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("exception in setColorOfSubstring, text=");
            sb2.append(text2);
            sb2.append(", substring=");
            sb2.append(str);
        }
    }

    public static final void underLine(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.getPaint().setFlags(textView.getPaint().getFlags() | 8);
        textView.getPaint().setAntiAlias(true);
    }
}
