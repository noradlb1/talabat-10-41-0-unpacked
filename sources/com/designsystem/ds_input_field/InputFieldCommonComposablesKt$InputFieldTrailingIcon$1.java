package com.designsystem.ds_input_field;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class InputFieldCommonComposablesKt$InputFieldTrailingIcon$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    public static final InputFieldCommonComposablesKt$InputFieldTrailingIcon$1 INSTANCE = new InputFieldCommonComposablesKt$InputFieldTrailingIcon$1();

    public InputFieldCommonComposablesKt$InputFieldTrailingIcon$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setTestTag(semanticsPropertyReceiver, InputFieldCommon.InputFieldTrailingIconTestTag);
    }
}
