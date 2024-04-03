package com.talabat.restaurants.v2.ui.fragments;

import android.content.Context;
import datamodels.Restaurant;
import datamodels.RestaurantListItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "", "Lkotlin/Pair;", "", "Ldatamodels/RestaurantListItemModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VendorsListFragment$trackShopListExpandedImpressions$1 extends Lambda implements Function1<List<? extends Pair<? extends Integer, ? extends RestaurantListItemModel>>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f61267g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f61268h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorsListFragment$trackShopListExpandedImpressions$1(VendorsListFragment vendorsListFragment, String str) {
        super(1);
        this.f61267g = vendorsListFragment;
        this.f61268h = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends Pair<Integer, ? extends RestaurantListItemModel>>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull List<? extends Pair<Integer, ? extends RestaurantListItemModel>> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        List<Pair<Integer, Restaurant>> updatePositionByVendorNaturalOrder = this.f61267g.updatePositionByVendorNaturalOrder(list);
        if (this.f61267g.getContext() != null) {
            VendorsListFragment vendorsListFragment = this.f61267g;
            String str = this.f61268h;
            TalabatGTM.Companion companion = TalabatGTM.Companion;
            Context requireContext = vendorsListFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            companion.onShopListExpanded(requireContext, str, updatePositionByVendorNaturalOrder);
        }
    }
}
