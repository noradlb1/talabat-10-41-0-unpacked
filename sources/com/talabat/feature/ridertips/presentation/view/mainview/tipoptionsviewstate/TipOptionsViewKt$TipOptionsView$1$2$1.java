package com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TipOptionsViewKt$TipOptionsView$1$2$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    public static final TipOptionsViewKt$TipOptionsView$1$2$1 INSTANCE = new TipOptionsViewKt$TipOptionsView$1$2$1();

    public TipOptionsViewKt$TipOptionsView$1$2$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, "saveRiderTipCheckBox");
    }
}
