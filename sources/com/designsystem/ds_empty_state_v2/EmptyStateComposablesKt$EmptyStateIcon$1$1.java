package com.designsystem.ds_empty_state_v2;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class EmptyStateComposablesKt$EmptyStateIcon$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    public static final EmptyStateComposablesKt$EmptyStateIcon$1$1 INSTANCE = new EmptyStateComposablesKt$EmptyStateIcon$1$1();

    public EmptyStateComposablesKt$EmptyStateIcon$1$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setTestTag(semanticsPropertyReceiver, EmptyStateComposablesKt.EmptyStateIconTestTag);
    }
}
