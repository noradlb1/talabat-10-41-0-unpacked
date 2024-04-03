package com.talabat.restaurants.v2.ui.fragments;

import datamodels.RestaurantListItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class VendorsListFragment$observatory$2 extends FunctionReferenceImpl implements Function1<List<? extends RestaurantListItemModel>, Unit> {
    public VendorsListFragment$observatory$2(Object obj) {
        super(1, obj, VendorsListFragment.class, "showVendors", "showVendors(Ljava/util/List;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends RestaurantListItemModel>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable List<? extends RestaurantListItemModel> list) {
        ((VendorsListFragment) this.receiver).showVendors(list);
    }
}
