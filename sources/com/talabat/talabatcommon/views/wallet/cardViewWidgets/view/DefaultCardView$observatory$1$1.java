package com.talabat.talabatcommon.views.wallet.cardViewWidgets.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class DefaultCardView$observatory$1$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public DefaultCardView$observatory$1$1(Object obj) {
        super(1, obj, DefaultCardView.class, "updateCardView", "updateCardView(Ljava/lang/Boolean;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Boolean bool) {
        ((DefaultCardView) this.receiver).updateCardView(bool);
    }
}
