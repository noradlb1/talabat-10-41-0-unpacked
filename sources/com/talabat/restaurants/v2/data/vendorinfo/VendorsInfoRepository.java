package com.talabat.restaurants.v2.data.vendorinfo;

import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import library.talabat.com.talabatlib.RestuarntListResponse;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¨\u0006\u000b"}, d2 = {"Lcom/talabat/restaurants/v2/data/vendorinfo/VendorsInfoRepository;", "", "getVendorsInfo", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/RestuarntListResponse;", "latitude", "", "longitude", "verticalIds", "", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorsInfoRepository {
    @NotNull
    Single<RestuarntListResponse> getVendorsInfo(@NotNull String str, @NotNull String str2, @NotNull List<Integer> list);
}
