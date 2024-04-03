package com.talabat.feature.tpro.presentation.payment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TProPaymentBottomSheetFragment$setupObservers$4 extends Lambda implements Function1<String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TProPaymentBottomSheetFragment f59365g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProPaymentBottomSheetFragment$setupObservers$4(TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment) {
        super(1);
        this.f59365g = tProPaymentBottomSheetFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable String str) {
        Unit unit;
        if (str != null) {
            TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment = this.f59365g;
            tProPaymentBottomSheetFragment.showProgresses(false);
            tProPaymentBottomSheetFragment.handle3DSVerification(str);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.f59365g.handleFailure();
        }
    }
}
