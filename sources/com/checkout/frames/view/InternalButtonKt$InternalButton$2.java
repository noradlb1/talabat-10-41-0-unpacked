package com.checkout.frames.view;

import androidx.compose.runtime.Composer;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class InternalButtonKt$InternalButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ InternalButtonState $state;
    final /* synthetic */ InternalButtonViewStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InternalButtonKt$InternalButton$2(InternalButtonViewStyle internalButtonViewStyle, InternalButtonState internalButtonState, Function0<Unit> function0, int i11) {
        super(2);
        this.$style = internalButtonViewStyle;
        this.$state = internalButtonState;
        this.$onClick = function0;
        this.$$changed = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        InternalButtonKt.InternalButton(this.$style, this.$state, this.$onClick, composer, this.$$changed | 1);
    }
}
