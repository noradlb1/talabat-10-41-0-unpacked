package com.talabat.growth.ui.loyalty.burn.burnOptionsDetails;

import com.talabat.talabatcommon.views.vouchers.models.ConfirmationDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class BurnOptionsDetailsFragment$observatory$1 extends FunctionReferenceImpl implements Function1<ConfirmationDisplayModel, Unit> {
    public BurnOptionsDetailsFragment$observatory$1(Object obj) {
        super(1, obj, BurnOptionsDetailsFragment.class, "optionRedeemedSuccess", "optionRedeemedSuccess(Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ConfirmationDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable ConfirmationDisplayModel confirmationDisplayModel) {
        ((BurnOptionsDetailsFragment) this.receiver).optionRedeemedSuccess(confirmationDisplayModel);
    }
}
