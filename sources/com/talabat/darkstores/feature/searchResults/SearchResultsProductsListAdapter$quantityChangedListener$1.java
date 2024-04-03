package com.talabat.darkstores.feature.searchResults;

import com.talabat.darkstores.common.OnProductQuantityChangeListener;
import com.talabat.darkstores.common.OnProductQuantityChangeTrackingListener;
import com.talabat.darkstores.common.SwimlaneTrackingData;
import com.talabat.darkstores.feature.searchResults.SearchResultsType;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u000bJ5\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0002\u0010\u000fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"com/talabat/darkstores/feature/searchResults/SearchResultsProductsListAdapter$quantityChangedListener$1", "Lcom/talabat/darkstores/common/OnProductQuantityChangeListener;", "bannerId", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId$Banner;", "decreaseProductCount", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "count", "", "listPosition", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;)V", "increaseProductCount", "onFailure", "Lkotlin/Function0;", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchResultsProductsListAdapter$quantityChangedListener$1 implements OnProductQuantityChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchResultsProductsListAdapter f56620a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnProductQuantityChangeTrackingListener f56621b;
    @Nullable
    private final TrackingCategoryId.Banner bannerId;

    public SearchResultsProductsListAdapter$quantityChangedListener$1(SearchResultsProductsListAdapter searchResultsProductsListAdapter, OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener) {
        SearchResultsType.Banner banner;
        this.f56620a = searchResultsProductsListAdapter;
        this.f56621b = onProductQuantityChangeTrackingListener;
        SearchResultsType access$getResultsType$p = searchResultsProductsListAdapter.resultsType;
        TrackingCategoryId.Banner banner2 = null;
        if (access$getResultsType$p instanceof SearchResultsType.Banner) {
            banner = (SearchResultsType.Banner) access$getResultsType$p;
        } else {
            banner = null;
        }
        this.bannerId = banner != null ? new TrackingCategoryId.Banner(banner.getTag()) : banner2;
    }

    public void decreaseProductCount(@NotNull Product product, int i11, @Nullable Integer num) {
        boolean z11;
        Intrinsics.checkNotNullParameter(product, "product");
        OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener = this.f56621b;
        TrackingCategoryId.Banner banner = this.bannerId;
        if (this.f56620a.newQuantityListener == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        OnProductQuantityChangeTrackingListener.DefaultImpls.decreaseProductCount$default(onProductQuantityChangeTrackingListener, product, i11, num, banner, (SwimlaneTrackingData) null, (String) null, (String) null, z11, 112, (Object) null);
    }

    public void increaseProductCount(@NotNull Product product, int i11, @Nullable Integer num, @NotNull Function0<Unit> function0) {
        boolean z11;
        Product product2 = product;
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(function0, "onFailure");
        OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener = this.f56621b;
        TrackingCategoryId.Banner banner = this.bannerId;
        if (this.f56620a.newQuantityListener == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        OnProductQuantityChangeTrackingListener.DefaultImpls.increaseProductCount$default(onProductQuantityChangeTrackingListener, product, i11, num, banner, (SwimlaneTrackingData) null, (String) null, (String) null, z11, function0, 112, (Object) null);
    }
}
