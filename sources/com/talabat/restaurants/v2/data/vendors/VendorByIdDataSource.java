package com.talabat.restaurants.v2.data.vendors;

import datamodels.Restaurant;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JR\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/restaurants/v2/data/vendors/VendorByIdDataSource;", "", "getVendorById", "Lio/reactivex/Single;", "", "Ldatamodels/Restaurant;", "areaParams", "Lcom/talabat/restaurants/v2/data/vendors/AreaParams;", "vendorIds", "", "externalExperiments", "", "deviceEntrypoint", "deviceCTA", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorByIdDataSource {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Single getVendorById$default(VendorByIdDataSource vendorByIdDataSource, AreaParams areaParams, List list, String str, String str2, String str3, int i11, Object obj) {
            if (obj == null) {
                return vendorByIdDataSource.getVendorById(areaParams, (i11 & 2) != 0 ? null : list, (i11 & 4) != 0 ? null : str, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? null : str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVendorById");
        }
    }

    @NotNull
    Single<List<Restaurant>> getVendorById(@NotNull AreaParams areaParams, @Nullable List<Integer> list, @Nullable String str, @Nullable String str2, @Nullable String str3);
}
