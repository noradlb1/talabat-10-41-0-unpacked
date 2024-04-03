package com.talabat.growth.ui.loyalty.howItWorks;

import com.talabat.growth.ui.loyalty.howItWorks.model.HowItWorksDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class HowItWorksFragment$observatory$1 extends FunctionReferenceImpl implements Function1<HowItWorksDisplayModel, Unit> {
    public HowItWorksFragment$observatory$1(Object obj) {
        super(1, obj, HowItWorksFragment.class, "updateHowItWorksTips", "updateHowItWorksTips(Lcom/talabat/growth/ui/loyalty/howItWorks/model/HowItWorksDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HowItWorksDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable HowItWorksDisplayModel howItWorksDisplayModel) {
        ((HowItWorksFragment) this.receiver).updateHowItWorksTips(howItWorksDisplayModel);
    }
}
