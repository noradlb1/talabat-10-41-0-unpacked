package com.talabat.talabatcommon.feature.vendorTags.data;

import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import library.talabat.com.talabatlib.VendorTagsResponse;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\u000b\u001a\u00020\nH'¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/feature/vendorTags/data/VendorTagsApi;", "", "getSmartVendorTags", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/VendorTagsResponse;", "latitude", "", "longitude", "verticalIds", "", "", "countryId", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorTagsApi {
    @NotNull
    @GET("/vendor-list/v1/vendor-tags/{latitude}/{longitude}")
    Single<VendorTagsResponse> getSmartVendorTags(@NotNull @Path("latitude") String str, @NotNull @Path("longitude") String str2, @NotNull @Query("verticalIds") List<Integer> list, @Query("countrycode") int i11);
}
