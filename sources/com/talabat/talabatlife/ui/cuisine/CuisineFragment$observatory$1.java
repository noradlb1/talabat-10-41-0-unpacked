package com.talabat.talabatlife.ui.cuisine;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class CuisineFragment$observatory$1 extends FunctionReferenceImpl implements Function1<List<? extends CuisineDisplayModel>, Unit> {
    public CuisineFragment$observatory$1(Object obj) {
        super(1, obj, CuisineFragment.class, "updateCuisineList", "updateCuisineList(Ljava/util/List;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<CuisineDisplayModel>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable List<CuisineDisplayModel> list) {
        ((CuisineFragment) this.receiver).updateCuisineList(list);
    }
}
