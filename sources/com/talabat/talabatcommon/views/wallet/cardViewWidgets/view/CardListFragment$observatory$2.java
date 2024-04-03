package com.talabat.talabatcommon.views.wallet.cardViewWidgets.view;

import com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class CardListFragment$observatory$2 extends FunctionReferenceImpl implements Function1<DeflectionInfoDisplayModel, Unit> {
    public CardListFragment$observatory$2(Object obj) {
        super(1, obj, CardListFragment.class, "updateInfoDescriptorMessage", "updateInfoDescriptorMessage(Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/DeflectionInfoDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DeflectionInfoDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable DeflectionInfoDisplayModel deflectionInfoDisplayModel) {
        ((CardListFragment) this.receiver).updateInfoDescriptorMessage(deflectionInfoDisplayModel);
    }
}
