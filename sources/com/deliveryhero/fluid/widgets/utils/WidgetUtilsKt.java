package com.deliveryhero.fluid.widgets.utils;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a$\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000\u001a\u0016\u0010\u0007\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\b\u001a\u00020\t\u001a@\u0010\n\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\n\u0010\u000b\u001a\u00060\fj\u0002`\r2\n\u0010\u000e\u001a\u00060\fj\u0002`\r2\n\u0010\u000f\u001a\u00060\fj\u0002`\r2\n\u0010\u0010\u001a\u00060\fj\u0002`\rH\u0000\u001a\u0016\u0010\u0011\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\b\u001a\u00020\t¨\u0006\u0012"}, d2 = {"updateAccessibility", "", "Landroid/view/View;", "Lcom/deliveryhero/fluid/widgets/Widget;", "accessibilityLabel", "", "accessibilityId", "updateClipToBounds", "value", "", "updatePaddings", "leading", "", "Lcom/deliveryhero/fluid/values/PixelInt;", "top", "trailing", "bottom", "updateVisibility", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class WidgetUtilsKt {
    public static final void updateAccessibility(@NotNull View view, @Nullable String str, @Nullable String str2) {
        WidgetTags widgetTags;
        boolean z11;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag();
        if (tag instanceof WidgetTags) {
            widgetTags = (WidgetTags) tag;
        } else {
            widgetTags = null;
        }
        if (widgetTags == null) {
            widgetTags = WidgetTagsKt.initWidgetTags(view);
        }
        widgetTags.setAccessibilityId(str2);
        view.setContentDescription(str);
        int i11 = 1;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = 2;
        }
        view.setImportantForAccessibility(i11);
    }

    public static final void updateClipToBounds(@NotNull View view, boolean z11) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            viewGroup.setClipChildren(z11);
            viewGroup.setClipToPadding(z11);
        }
    }

    public static final void updatePaddings(@NotNull View view, int i11, int i12, int i13, int i14) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (i11 != view.getPaddingStart() || i12 != view.getPaddingTop() || i13 != view.getPaddingEnd() || i14 != view.getPaddingBottom()) {
            view.setPaddingRelative(i11, i12, i13, i14);
        }
    }

    public static final void updateVisibility(@NotNull View view, boolean z11) {
        boolean z12;
        Intrinsics.checkNotNullParameter(view, "<this>");
        int i11 = 0;
        if (view.getVisibility() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12 != z11) {
            if (!z11) {
                i11 = 8;
            }
            view.setVisibility(i11);
        }
    }
}
