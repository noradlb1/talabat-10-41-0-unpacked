package com.designsystem.ds_branded_button.composables;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.designsystem.ds_button_v2.composables.Button;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSBrandedButtonContentKt$DSBrandedButtonContent$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    public static final DSBrandedButtonContentKt$DSBrandedButtonContent$1$1 INSTANCE = new DSBrandedButtonContentKt$DSBrandedButtonContent$1$1();

    public DSBrandedButtonContentKt$DSBrandedButtonContent$1$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setTestTag(semanticsPropertyReceiver, Button.ButtonLoadingAnimationTestTag);
    }
}
