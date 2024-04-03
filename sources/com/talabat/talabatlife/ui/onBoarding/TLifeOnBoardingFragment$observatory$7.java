package com.talabat.talabatlife.ui.onBoarding;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class TLifeOnBoardingFragment$observatory$7 extends FunctionReferenceImpl implements Function1<Pair<? extends String, ? extends HashMap<String, String>>, Unit> {
    public TLifeOnBoardingFragment$observatory$7(Object obj) {
        super(1, obj, TLifeOnBoardingFragment.class, "sendFireBaseEvent", "sendFireBaseEvent(Lkotlin/Pair;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<String, ? extends HashMap<String, String>>) (Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Pair<String, ? extends HashMap<String, String>> pair) {
        ((TLifeOnBoardingFragment) this.receiver).sendFireBaseEvent(pair);
    }
}
