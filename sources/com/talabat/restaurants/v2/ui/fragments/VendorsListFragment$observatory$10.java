package com.talabat.restaurants.v2.ui.fragments;

import androidx.paging.CombinedLoadStates;
import androidx.paging.LoadState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/paging/CombinedLoadStates;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VendorsListFragment$observatory$10 extends Lambda implements Function1<CombinedLoadStates, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f61256g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorsListFragment$observatory$10(VendorsListFragment vendorsListFragment) {
        super(1);
        this.f61256g = vendorsListFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CombinedLoadStates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull CombinedLoadStates combinedLoadStates) {
        Intrinsics.checkNotNullParameter(combinedLoadStates, "it");
        boolean z11 = true;
        if (combinedLoadStates.getRefresh() instanceof LoadState.NotLoading) {
            this.f61256g.trackShopListExpandedImpressions(this.f61256g.getVendorsListAdapter().snapshot().getItems());
            this.f61256g.showLoading(Boolean.FALSE);
            VendorsListFragment vendorsListFragment = this.f61256g;
            vendorsListFragment.showNoResult(Boolean.valueOf(vendorsListFragment.getVendorsListAdapter().getItemCount() == 0));
        }
        if (combinedLoadStates.getRefresh() instanceof LoadState.Loading) {
            VendorsListFragment vendorsListFragment2 = this.f61256g;
            if (vendorsListFragment2.getVendorsListAdapter().getItemCount() != 0) {
                z11 = false;
            }
            vendorsListFragment2.showLoading(Boolean.valueOf(z11));
        }
    }
}
