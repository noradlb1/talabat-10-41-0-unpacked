package com.talabat.darkstores.common.extensions;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"setTextColorRes", "", "Landroid/widget/TextView;", "colorResId", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TextViewExtensionsKt {
    public static final void setTextColorRes(@NotNull TextView textView, @ColorRes int i11) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setTextColor(ContextExtensionsKt.getColorCompat(context, i11));
    }
}
