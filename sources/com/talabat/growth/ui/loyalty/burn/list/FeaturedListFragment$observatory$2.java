package com.talabat.growth.ui.loyalty.burn.list;

import com.talabat.growth.features.loyalty.BurnOptionDetailsNavigator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class FeaturedListFragment$observatory$2 extends FunctionReferenceImpl implements Function1<BurnOptionDetailsNavigator.BurnOptionDetailsTarget, Unit> {
    public FeaturedListFragment$observatory$2(Object obj) {
        super(1, obj, FeaturedListFragment.class, "showBurnOptionDetails", "showBurnOptionDetails(Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetailsTarget;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BurnOptionDetailsNavigator.BurnOptionDetailsTarget) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable BurnOptionDetailsNavigator.BurnOptionDetailsTarget burnOptionDetailsTarget) {
        ((FeaturedListFragment) this.receiver).showBurnOptionDetails(burnOptionDetailsTarget);
    }
}
