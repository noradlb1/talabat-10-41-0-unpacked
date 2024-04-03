package com.designsystem.ds_list_item_v2.composables;

import android.content.Context;
import android.util.AttributeSet;
import com.designsystem.ds_selection_indicator.DSSelectionIndicator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class SelectableListItemComposablesKt$SelectionIndicator$2 extends Lambda implements Function1<Context, DSSelectionIndicator> {
    public static final SelectableListItemComposablesKt$SelectionIndicator$2 INSTANCE = new SelectableListItemComposablesKt$SelectionIndicator$2();

    public SelectableListItemComposablesKt$SelectionIndicator$2() {
        super(1);
    }

    @NotNull
    public final DSSelectionIndicator invoke(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DSSelectionIndicator dSSelectionIndicator = new DSSelectionIndicator(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        dSSelectionIndicator.setAxisType(DSSelectionIndicator.DSSelectionIndicatorAxisType.VERTICAL);
        return dSSelectionIndicator;
    }
}
