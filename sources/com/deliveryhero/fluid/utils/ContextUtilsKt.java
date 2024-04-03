package com.deliveryhero.fluid.utils;

import android.content.Context;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0016\u0010\u0005\u001a\u00020\u0001*\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0001H\u0000¨\u0006\u0007"}, d2 = {"dpToPx", "", "", "context", "Landroid/content/Context;", "getThemeAttributeResourceId", "attributeId", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ContextUtilsKt {
    public static final int dpToPx(float f11, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (f11 * context.getResources().getDisplayMetrics().density);
    }

    public static final int getThemeAttributeResourceId(@NotNull Context context, @AttrRes int i11) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.resourceId;
    }
}
