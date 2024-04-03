package com.talabat.restaurants.v2.domain.vendors;

import com.talabat.restaurants.v2.domain.vendors.GetVendorsUseCase;
import datamodels.Restaurant;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.RestaurantListResponsePaginated;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"com/talabat/restaurants/v2/domain/vendors/PagedUsedCaseImpl$getVendors$1", "Lcom/talabat/restaurants/v2/domain/vendors/VendorsUseCase;", "invoke", "Lio/reactivex/Single;", "", "Ldatamodels/Restaurant;", "p1", "Lcom/talabat/restaurants/v2/domain/vendors/GetVendorsUseCase$Params;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PagedUsedCaseImpl$getVendors$1 implements VendorsUseCase {
    @NotNull
    public Single<List<Restaurant>> invoke(@NotNull GetVendorsUseCase.Params params) {
        Intrinsics.checkNotNullParameter(params, "p1");
        RestaurantListResponsePaginated access$getFirstPageResponseNoFiltrationCache$cp = PagedUsedCaseImpl.firstPageResponseNoFiltrationCache;
        List<Restaurant> vendors = access$getFirstPageResponseNoFiltrationCache$cp != null ? access$getFirstPageResponseNoFiltrationCache$cp.getVendors() : null;
        if (vendors != null) {
            Single<T> just = Single.just(vendors);
            Intrinsics.checkNotNullExpressionValue(just, "{\n                Single…st(vendors)\n            }");
            return just;
        }
        Single<List<Restaurant>> just2 = Single.just(CollectionsKt__CollectionsKt.emptyList());
        Intrinsics.checkNotNullExpressionValue(just2, "{\n                Single…t(listOf())\n            }");
        return just2;
    }
}
