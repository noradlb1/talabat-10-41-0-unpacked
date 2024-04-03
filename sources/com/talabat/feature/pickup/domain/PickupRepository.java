package com.talabat.feature.pickup.domain;

import com.talabat.feature.pickup.domain.entity.PickupSwimlane;
import com.talabat.feature.pickup.domain.entity.PickupVendor;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import library.talabat.com.talabatlib.VendorTagsResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H&J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\b0\u000bH&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003H&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0006H&J\b\u0010\u0015\u001a\u00020\u0010H&J\b\u0010\u0016\u001a\u00020\u0006H&¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/pickup/domain/PickupRepository;", "", "getPickupVendors", "Lio/reactivex/Single;", "Lcom/talabat/feature/pickup/domain/entity/PickupVendor;", "pageNumber", "", "cuisineIds", "", "apiVersion", "getSwimlanes", "Lio/reactivex/Observable;", "Lcom/talabat/feature/pickup/domain/entity/PickupSwimlane;", "getVendorTags", "Llibrary/talabat/com/talabatlib/VendorTagsResponse;", "incrementPickupVlScreenVisits", "", "incrementValuePropBannerVisits", "isFirstPickupOrder", "", "pickupVlScreenVisits", "setIsFirstPickupOrder", "valuePropBannerVisits", "com_talabat_feature_pickup_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PickupRepository {
    @NotNull
    Single<PickupVendor> getPickupVendors(int i11, @Nullable List<Integer> list, int i12);

    @NotNull
    Observable<List<PickupSwimlane>> getSwimlanes();

    @NotNull
    Single<VendorTagsResponse> getVendorTags();

    void incrementPickupVlScreenVisits();

    void incrementValuePropBannerVisits();

    boolean isFirstPickupOrder();

    int pickupVlScreenVisits();

    void setIsFirstPickupOrder();

    int valuePropBannerVisits();
}
