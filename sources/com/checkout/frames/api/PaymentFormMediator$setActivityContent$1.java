package com.checkout.frames.api;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormMediator$setActivityContent$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ PaymentFormMediator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentFormMediator$setActivityContent$1(PaymentFormMediator paymentFormMediator) {
        super(2);
        this.this$0 = paymentFormMediator;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            this.this$0.PaymentForm(composer, 8);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
