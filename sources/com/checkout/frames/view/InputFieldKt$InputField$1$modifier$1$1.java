package com.checkout.frames.view;

import androidx.compose.ui.focus.FocusState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class InputFieldKt$InputField$1$modifier$1$1 extends Lambda implements Function1<FocusState, Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $onFocusChanged;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldKt$InputField$1$modifier$1$1(Function1<? super Boolean, Unit> function1) {
        super(1);
        this.$onFocusChanged = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "it");
        Function1<Boolean, Unit> function1 = this.$onFocusChanged;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(focusState.isFocused()));
        }
    }
}
