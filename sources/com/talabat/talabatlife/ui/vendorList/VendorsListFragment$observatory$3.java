package com.talabat.talabatlife.ui.vendorList;

import com.talabat.talabatlife.domain.entity.Filter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class VendorsListFragment$observatory$3 extends FunctionReferenceImpl implements Function1<Filter, Unit> {
    public VendorsListFragment$observatory$3(Object obj) {
        super(1, obj, VendorsListFragment.class, "updateFilterButton", "updateFilterButton(Lcom/talabat/talabatlife/domain/entity/Filter;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Filter) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Filter filter) {
        ((VendorsListFragment) this.receiver).updateFilterButton(filter);
    }
}
