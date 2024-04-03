package com.talabat.growth.ui.loyalty.burn.details;

import com.talabat.talabatcommon.views.vouchers.models.ConfirmationDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class BurnOptionsDetailsDialogFragment$setupObservers$2 extends FunctionReferenceImpl implements Function1<ConfirmationDisplayModel, Unit> {
    public BurnOptionsDetailsDialogFragment$setupObservers$2(Object obj) {
        super(1, obj, BurnOptionsDetailsDialogFragment.class, "showConfirmation", "showConfirmation(Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ConfirmationDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable ConfirmationDisplayModel confirmationDisplayModel) {
        ((BurnOptionsDetailsDialogFragment) this.receiver).showConfirmation(confirmationDisplayModel);
    }
}
