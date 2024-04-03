package com.talabat.darkstores.data.swimlanes;

import com.talabat.darkstores.data.mission.control.model.MissionControlProductsResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001Jj\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\n2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0006H'¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/data/swimlanes/SwimlanseProductApi;", "", "getSwimlanesProducts", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/data/mission/control/model/MissionControlProductsResponse;", "countryCode", "", "swimlaneId", "vendorId", "talabatBranchId", "", "isDarkstore", "", "productId", "productSku", "pageNumber", "filterCategoryId", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SwimlanseProductApi {
    @NotNull
    @GET("v1/{country_code}/swimlanes/{swimlaneId}/products")
    Single<MissionControlProductsResponse> getSwimlanesProducts(@NotNull @Path("country_code") String str, @NotNull @Path("swimlaneId") String str2, @NotNull @Query("vendorId") String str3, @Query("talabatBranchId") int i11, @Query("isDarkstore") boolean z11, @NotNull @Query("productId") String str4, @NotNull @Query("productSku") String str5, @Query("pageNumber") int i12, @Nullable @Query("filterCategoryId") String str6);
}
