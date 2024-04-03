package com.talabat.talabatlife.ui.onBoarding;

import com.talabat.talabatlife.ui.onBoarding.model.TLifeOnBoardingWaitListDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class TLifeOnBoardingFragment$observatory$5 extends FunctionReferenceImpl implements Function1<TLifeOnBoardingWaitListDisplayModel, Unit> {
    public TLifeOnBoardingFragment$observatory$5(Object obj) {
        super(1, obj, TLifeOnBoardingFragment.class, "updateWaitListJoined", "updateWaitListJoined(Lcom/talabat/talabatlife/ui/onBoarding/model/TLifeOnBoardingWaitListDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TLifeOnBoardingWaitListDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable TLifeOnBoardingWaitListDisplayModel tLifeOnBoardingWaitListDisplayModel) {
        ((TLifeOnBoardingFragment) this.receiver).updateWaitListJoined(tLifeOnBoardingWaitListDisplayModel);
    }
}
