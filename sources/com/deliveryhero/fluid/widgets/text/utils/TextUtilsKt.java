package com.deliveryhero.fluid.widgets.text.utils;

import android.text.Html;
import android.widget.TextView;
import androidx.core.text.HtmlCompat;
import com.deliveryhero.fluid.widgets.text.TextSubstitutor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a<\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\tH\u0000\u001a:\u0010\n\u001a\u00020\u0001*\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\t2\b\b\u0002\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"updateRichOrPlainText", "", "Landroid/widget/TextView;", "richText", "", "plainText", "metadata", "", "", "Lcom/deliveryhero/fluid/template/data/TemplateMetadata;", "updateText", "value", "", "isAttributedString", "", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TextUtilsKt {
    public static final void updateRichOrPlainText(@NotNull TextView textView, @Nullable String str, @Nullable String str2, @Nullable Map<String, ? extends Object> map) {
        boolean z11;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            updateText(textView, str, map, true);
        } else {
            updateText$default(textView, str2, map, false, 4, (Object) null);
        }
    }

    public static final void updateText(@NotNull TextView textView, @Nullable CharSequence charSequence, @Nullable Map<String, ? extends Object> map, boolean z11) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        CharSequence substitute = TextSubstitutor.INSTANCE.substitute(charSequence, map);
        if (z11) {
            substitute = HtmlCompat.fromHtml(String.valueOf(substitute), 0, (Html.ImageGetter) null, (Html.TagHandler) null);
            Intrinsics.checkNotNullExpressionValue(substitute, "fromHtml(this, flags, imageGetter, tagHandler)");
        }
        textView.setText(substitute);
    }

    public static /* synthetic */ void updateText$default(TextView textView, CharSequence charSequence, Map map, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        updateText(textView, charSequence, map, z11);
    }
}
