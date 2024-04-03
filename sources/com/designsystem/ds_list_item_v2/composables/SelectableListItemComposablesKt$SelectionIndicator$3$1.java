package com.designsystem.ds_list_item_v2.composables;

import com.designsystem.ds_selection_indicator.DSSelectionIndicator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class SelectableListItemComposablesKt$SelectionIndicator$3$1 extends Lambda implements Function1<DSSelectionIndicator, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f32311g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectableListItemComposablesKt$SelectionIndicator$3$1(boolean z11) {
        super(1);
        this.f32311g = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DSSelectionIndicator) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DSSelectionIndicator dSSelectionIndicator) {
        Intrinsics.checkNotNullParameter(dSSelectionIndicator, "it");
        dSSelectionIndicator.setEnabled(this.f32311g);
    }
}
