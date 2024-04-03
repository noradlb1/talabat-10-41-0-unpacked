package com.checkout.frames.view;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class InternalButtonKt$InternalButton$1$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    final /* synthetic */ InternalButtonState $state;
    final /* synthetic */ InternalButtonViewStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InternalButtonKt$InternalButton$1$1(InternalButtonViewStyle internalButtonViewStyle, InternalButtonState internalButtonState) {
        super(3);
        this.$style = internalButtonViewStyle;
        this.$state = internalButtonState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull RowScope rowScope, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$Button");
        if ((i11 & 81) != 16 || !composer.getSkipping()) {
            TextLabelKt.TextLabel(this.$style.getTextStyle(), this.$state.getTextState(), composer, 8);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
