package com.talabat.restaurants.v2.domain.vendors;

import com.talabat.restaurants.v2.data.vendors.FilterParams;
import datamodels.Swimlane;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function6;
import library.talabat.com.talabatlib.RestaurantListResponsePaginated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JC\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0017RH\u0010\u0002\u001a8\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/talabat/restaurants/v2/domain/vendors/PagedUsedCase;", "", "getSwimlanes", "Lkotlin/Function6;", "", "", "", "Lio/reactivex/Single;", "", "Ldatamodels/Swimlane;", "getGetSwimlanes", "()Lkotlin/jvm/functions/Function6;", "getVendors", "Lcom/talabat/restaurants/v2/domain/vendors/VendorsUseCase;", "getGetVendors", "()Lcom/talabat/restaurants/v2/domain/vendors/VendorsUseCase;", "getAllVendorsPaginated", "Llibrary/talabat/com/talabatlib/RestaurantListResponsePaginated;", "isForceUpdate", "filterParams", "Lcom/talabat/restaurants/v2/data/vendors/FilterParams;", "verticalIds", "page", "(ZLcom/talabat/restaurants/v2/data/vendors/FilterParams;Ljava/util/List;Ljava/lang/Integer;)Lio/reactivex/Single;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PagedUsedCase {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Single getAllVendorsPaginated$default(PagedUsedCase pagedUsedCase, boolean z11, FilterParams filterParams, List list, Integer num, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    z11 = false;
                }
                if ((i11 & 2) != 0) {
                    filterParams = null;
                }
                return pagedUsedCase.getAllVendorsPaginated(z11, filterParams, list, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllVendorsPaginated");
        }
    }

    @NotNull
    Single<RestaurantListResponsePaginated> getAllVendorsPaginated(boolean z11, @Nullable FilterParams filterParams, @Nullable List<Integer> list, @Nullable Integer num);

    @NotNull
    Function6<Boolean, String, String, Integer, Integer, Integer, Single<List<Swimlane>>> getGetSwimlanes();

    @NotNull
    VendorsUseCase getGetVendors();
}
