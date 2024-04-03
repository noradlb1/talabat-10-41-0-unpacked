package com.talabat.feature.darkstores.swimlanes.data.remote;

import com.talabat.feature.darkstores.swimlanes.data.remote.model.SwimlanesResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001JJ\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u0006H'¨\u0006\r"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/data/remote/SwimlanesApi;", "", "getSwimlanes", "Lio/reactivex/Single;", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/SwimlanesResponse;", "countryCode", "", "vendorId", "talabatBranchId", "isDarkstore", "", "productId", "productSku", "com_talabat_feature_darkstores-swimlanes_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SwimlanesApi {
    @NotNull
    @GET("v1/{country_code}/swimlanes/product-details-page")
    Single<SwimlanesResponse> getSwimlanes(@NotNull @Path("country_code") String str, @NotNull @Query("vendorId") String str2, @NotNull @Query("talabatBranchId") String str3, @Query("isDarkstore") boolean z11, @NotNull @Query("productId") String str4, @NotNull @Query("productSku") String str5);
}
