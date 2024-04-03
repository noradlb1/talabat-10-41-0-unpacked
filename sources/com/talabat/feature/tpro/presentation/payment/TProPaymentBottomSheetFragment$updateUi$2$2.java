package com.talabat.feature.tpro.presentation.payment;

import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TProPaymentBottomSheetFragment$updateUi$2$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TProPaymentBottomSheetFragment f59369g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TProPlanDisplayModel f59370h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProPaymentBottomSheetFragment$updateUi$2$2(TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment, TProPlanDisplayModel tProPlanDisplayModel) {
        super(0);
        this.f59369g = tProPaymentBottomSheetFragment;
        this.f59370h = tProPlanDisplayModel;
    }

    public final void invoke() {
        this.f59369g.onActionButtonTapped(this.f59370h);
    }
}
