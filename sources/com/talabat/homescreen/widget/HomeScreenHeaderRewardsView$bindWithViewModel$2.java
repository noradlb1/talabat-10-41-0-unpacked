package com.talabat.homescreen.widget;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class HomeScreenHeaderRewardsView$bindWithViewModel$2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public HomeScreenHeaderRewardsView$bindWithViewModel$2(Object obj) {
        super(1, obj, HomeScreenHeaderRewardsView.class, "showPoints", "showPoints(Ljava/lang/Integer;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Integer num) {
        ((HomeScreenHeaderRewardsView) this.receiver).showPoints(num);
    }
}
