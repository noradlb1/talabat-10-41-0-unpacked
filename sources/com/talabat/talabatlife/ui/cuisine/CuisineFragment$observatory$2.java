package com.talabat.talabatlife.ui.cuisine;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class CuisineFragment$observatory$2 extends FunctionReferenceImpl implements Function1<CuisineDisplayModel, Unit> {
    public CuisineFragment$observatory$2(Object obj) {
        super(1, obj, CuisineFragment.class, "updateSelectedCuisine", "updateSelectedCuisine(Lcom/talabat/talabatlife/ui/cuisine/CuisineDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CuisineDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable CuisineDisplayModel cuisineDisplayModel) {
        ((CuisineFragment) this.receiver).updateSelectedCuisine(cuisineDisplayModel);
    }
}
