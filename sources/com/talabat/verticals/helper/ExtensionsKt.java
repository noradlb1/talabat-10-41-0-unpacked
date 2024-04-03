package com.talabat.verticals.helper;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"getString", "", "Landroid/view/View;", "id", "", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ExtensionsKt {
    @NotNull
    public static final String getString(@NotNull View view, int i11) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        String string = view.getContext().getString(i11);
        Intrinsics.checkNotNullExpressionValue(string, "this.context.getString(id)");
        return string;
    }
}
