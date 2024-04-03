package com.designsystem.ds_button_v2.composables;

import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.designsystem.semantics.SemanticsPropertiesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ButtonComposablesKt$isVisible$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f30824g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonComposablesKt$isVisible$1(boolean z11) {
        super(1);
        this.f30824g = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        if (!this.f30824g) {
            SemanticsPropertiesKt.invisible(semanticsPropertyReceiver);
        }
    }
}
