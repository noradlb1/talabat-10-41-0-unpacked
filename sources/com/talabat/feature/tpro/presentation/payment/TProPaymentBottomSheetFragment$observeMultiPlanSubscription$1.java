package com.talabat.feature.tpro.presentation.payment;

import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "displayModel", "Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TProPaymentBottomSheetFragment$observeMultiPlanSubscription$1 extends Lambda implements Function1<TProPlanDisplayModel, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TProPaymentBottomSheetFragment f59358g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProPaymentBottomSheetFragment$observeMultiPlanSubscription$1(TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment) {
        super(1);
        this.f59358g = tProPaymentBottomSheetFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TProPlanDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable TProPlanDisplayModel tProPlanDisplayModel) {
        Unit unit;
        this.f59358g.showProgresses(false);
        if (tProPlanDisplayModel != null) {
            this.f59358g.updateUi(tProPlanDisplayModel);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.f59358g.dsBottomSheet.dismiss();
        }
    }
}
