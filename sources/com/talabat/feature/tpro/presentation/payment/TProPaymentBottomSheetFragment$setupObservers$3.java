package com.talabat.feature.tpro.presentation.payment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(Lkotlin/Unit;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TProPaymentBottomSheetFragment$setupObservers$3 extends Lambda implements Function1<Unit, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TProPaymentBottomSheetFragment f59364g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProPaymentBottomSheetFragment$setupObservers$3(TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment) {
        super(1);
        this.f59364g = tProPaymentBottomSheetFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Unit) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Unit unit) {
        this.f59364g.handleFailure();
    }
}
