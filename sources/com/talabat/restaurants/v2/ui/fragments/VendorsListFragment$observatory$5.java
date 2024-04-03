package com.talabat.restaurants.v2.ui.fragments;

import datamodels.RestaurantListItemModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class VendorsListFragment$observatory$5 extends FunctionReferenceImpl implements Function1<Pair<? extends RestaurantListItemModel, ? extends Integer>, Unit> {
    public VendorsListFragment$observatory$5(Object obj) {
        super(1, obj, VendorsListFragment.class, "addInlineAd", "addInlineAd(Lkotlin/Pair;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<? extends RestaurantListItemModel, Integer>) (Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Pair<? extends RestaurantListItemModel, Integer> pair) {
        ((VendorsListFragment) this.receiver).addInlineAd(pair);
    }
}
