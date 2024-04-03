package com.designsystem.ds_button_v2.composables;

import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ButtonComposablesKt$ButtonTitleText$1 extends Lambda implements Function1<TextLayoutResult, Unit> {
    public static final ButtonComposablesKt$ButtonTitleText$1 INSTANCE = new ButtonComposablesKt$ButtonTitleText$1();

    public ButtonComposablesKt$ButtonTitleText$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextLayoutResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "it");
    }
}
