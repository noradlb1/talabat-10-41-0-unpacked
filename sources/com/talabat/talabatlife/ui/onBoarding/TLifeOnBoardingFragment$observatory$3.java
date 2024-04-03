package com.talabat.talabatlife.ui.onBoarding;

import com.talabat.talabatlife.ui.onBoarding.model.TLifeOnBoardingPlanDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class TLifeOnBoardingFragment$observatory$3 extends FunctionReferenceImpl implements Function1<TLifeOnBoardingPlanDisplayModel, Unit> {
    public TLifeOnBoardingFragment$observatory$3(Object obj) {
        super(1, obj, TLifeOnBoardingFragment.class, "updatePlans", "updatePlans(Lcom/talabat/talabatlife/ui/onBoarding/model/TLifeOnBoardingPlanDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TLifeOnBoardingPlanDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable TLifeOnBoardingPlanDisplayModel tLifeOnBoardingPlanDisplayModel) {
        ((TLifeOnBoardingFragment) this.receiver).updatePlans(tLifeOnBoardingPlanDisplayModel);
    }
}
