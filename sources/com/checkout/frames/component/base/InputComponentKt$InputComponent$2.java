package com.checkout.frames.component.base;

import androidx.compose.runtime.Composer;
import com.checkout.frames.style.view.InputComponentViewStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class InputComponentKt$InputComponent$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function1<Boolean, Unit> $onFocusChanged;
    final /* synthetic */ Function1<String, Unit> $onValueChange;
    final /* synthetic */ InputComponentState $state;
    final /* synthetic */ InputComponentViewStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputComponentKt$InputComponent$2(InputComponentViewStyle inputComponentViewStyle, InputComponentState inputComponentState, Function1<? super Boolean, Unit> function1, Function1<? super String, Unit> function12, int i11, int i12) {
        super(2);
        this.$style = inputComponentViewStyle;
        this.$state = inputComponentState;
        this.$onFocusChanged = function1;
        this.$onValueChange = function12;
        this.$$changed = i11;
        this.$$default = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        InputComponentKt.InputComponent(this.$style, this.$state, this.$onFocusChanged, this.$onValueChange, composer, this.$$changed | 1, this.$$default);
    }
}
