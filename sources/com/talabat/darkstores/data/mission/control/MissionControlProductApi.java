package com.talabat.darkstores.data.mission.control;

import com.talabat.darkstores.data.mission.control.model.MissionControlProductsResponse;
import com.talabat.darkstores.data.search.model.SearchResultsRequest;
import com.talabat.darkstores.data.search.model.SearchResultsResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH'JV\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u000e2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0006H'¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/data/mission/control/MissionControlProductApi;", "", "getMissionControlProducts", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/data/search/model/SearchResultsResponse;", "countryCode", "", "missionCode", "request", "Lcom/talabat/darkstores/data/search/model/SearchResultsRequest;", "Lcom/talabat/darkstores/data/mission/control/model/MissionControlProductsResponse;", "swimlaneId", "vendorId", "talabatBranchId", "", "isDarkstore", "", "pageNumber", "filterCategoryId", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MissionControlProductApi {
    @NotNull
    @POST("v1/{country_code}/missions/{mission_code}/products")
    Single<SearchResultsResponse> getMissionControlProducts(@NotNull @Path("country_code") String str, @NotNull @Path("mission_code") String str2, @NotNull @Body SearchResultsRequest searchResultsRequest);

    @NotNull
    @GET("v1/{country_code}/missions/{swimlane_id}/products")
    Single<MissionControlProductsResponse> getMissionControlProducts(@NotNull @Path("country_code") String str, @NotNull @Path("swimlane_id") String str2, @NotNull @Query("vendorId") String str3, @Query("talabatBranchId") int i11, @Query("isDarkstore") boolean z11, @Query("pageNumber") int i12, @Nullable @Query("filterCategoryId") String str4);
}
