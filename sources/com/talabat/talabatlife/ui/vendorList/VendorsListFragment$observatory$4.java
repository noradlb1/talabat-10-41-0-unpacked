package com.talabat.talabatlife.ui.vendorList;

import com.talabat.talabatlife.domain.entity.Cuisine;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class VendorsListFragment$observatory$4 extends FunctionReferenceImpl implements Function1<List<? extends Cuisine>, Unit> {
    public VendorsListFragment$observatory$4(Object obj) {
        super(1, obj, VendorsListFragment.class, "updateCuisineButton", "updateCuisineButton(Ljava/util/List;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<Cuisine>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable List<Cuisine> list) {
        ((VendorsListFragment) this.receiver).updateCuisineButton(list);
    }
}
