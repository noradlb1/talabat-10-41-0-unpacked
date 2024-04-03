package com.talabat.restaurants.v2.ui.viewmodels;

import androidx.paging.PagingSource;
import com.talabat.restaurants.v2.data.vendors.VendorsPagingDataSource;
import datamodels.RestaurantListItemModel;
import io.reactivex.Scheduler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/paging/PagingSource;", "", "Ldatamodels/RestaurantListItemModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VendorListFragmentViewModelPaged$source$1 extends Lambda implements Function0<PagingSource<Integer, RestaurantListItemModel>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VendorListFragmentViewModelPaged f61285g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorListFragmentViewModelPaged$source$1(VendorListFragmentViewModelPaged vendorListFragmentViewModelPaged) {
        super(0);
        this.f61285g = vendorListFragmentViewModelPaged;
    }

    @NotNull
    public final PagingSource<Integer, RestaurantListItemModel> invoke() {
        return new VendorsPagingDataSource(this.f61285g.getFilterParamsRepository(), this.f61285g.getPagedUsedCase(), CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(this.f61285g.getVerticalId())), (Scheduler) null, 8, (DefaultConstructorMarker) null);
    }
}
