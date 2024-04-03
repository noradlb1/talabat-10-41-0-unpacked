package com.checkout.frames.view;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class InputFieldKt$CircleOutlineInputFieldPreview$1$1$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ MutableState<String> $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldKt$CircleOutlineInputFieldPreview$1$1$1(MutableState<String> mutableState) {
        super(1);
        this.$text = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        this.$text.setValue(str);
    }
}
