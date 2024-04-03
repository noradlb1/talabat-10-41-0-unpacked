package com.talabat.growth.ui.loyalty.burn.list;

import com.talabat.growth.ui.loyalty.burn.models.BurnItemCategoryDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class FeaturedListFragment$observatory$1 extends FunctionReferenceImpl implements Function1<BurnItemCategoryDisplayModel, Unit> {
    public FeaturedListFragment$observatory$1(Object obj) {
        super(1, obj, FeaturedListFragment.class, "populateFeaturedList", "populateFeaturedList(Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BurnItemCategoryDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable BurnItemCategoryDisplayModel burnItemCategoryDisplayModel) {
        ((FeaturedListFragment) this.receiver).populateFeaturedList(burnItemCategoryDisplayModel);
    }
}
