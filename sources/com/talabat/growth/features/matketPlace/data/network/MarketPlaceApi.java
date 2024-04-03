package com.talabat.growth.features.matketPlace.data.network;

import com.talabat.growth.features.matketPlace.model.response.BurnOptionCategoryResponse;
import com.talabat.growth.features.matketPlace.model.response.MarketPlaceBurnOptionDetailsResponse;
import com.talabat.growth.features.matketPlace.model.response.MarketPlaceBurnOptionsResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\u0006H'J6\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\bH'J^\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010\u0013\u001a\u00020\u00062\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0015\u001a\u00020\b2\b\b\u0001\u0010\u0016\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\u0006H'¨\u0006\u0017"}, d2 = {"Lcom/talabat/growth/features/matketPlace/data/network/MarketPlaceApi;", "", "getCategoryDetails", "Lretrofit2/Call;", "Lcom/talabat/growth/features/matketPlace/model/response/BurnOptionCategoryResponse;", "apiVersion", "", "categoryID", "", "country", "burnCategoryType", "areaId", "getItemDetails", "Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnOptionDetailsResponse;", "itemId", "languageCode", "burnOptionType", "getItems", "Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnOptionsResponse;", "page", "size", "voucherOptionType", "burnTypes", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MarketPlaceApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call getCategoryDetails$default(MarketPlaceApi marketPlaceApi, int i11, String str, String str2, String str3, int i12, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 1) != 0) {
                    i11 = 3;
                }
                return marketPlaceApi.getCategoryDetails(i11, str, str2, str3, i12);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCategoryDetails");
        }

        public static /* synthetic */ Call getItemDetails$default(MarketPlaceApi marketPlaceApi, int i11, String str, String str2, String str3, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 3;
                }
                return marketPlaceApi.getItemDetails(i11, str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getItemDetails");
        }

        public static /* synthetic */ Call getItems$default(MarketPlaceApi marketPlaceApi, int i11, String str, String str2, int i12, int i13, String str3, String str4, int i14, int i15, Object obj) {
            if (obj == null) {
                return marketPlaceApi.getItems((i15 & 1) != 0 ? 3 : i11, str, str2, i12, i13, str3, str4, i14);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getItems");
        }
    }

    @NotNull
    @GET("/api/v{version}/marketplace/categories/{id}")
    Call<BurnOptionCategoryResponse> getCategoryDetails(@Path("version") int i11, @NotNull @Path("id") String str, @NotNull @Query("country") String str2, @NotNull @Query("type") String str3, @Query("areaId") int i12);

    @NotNull
    @GET("/api/v{version}/marketplace/{id}")
    Call<MarketPlaceBurnOptionDetailsResponse> getItemDetails(@Path("version") int i11, @NotNull @Path("id") String str, @NotNull @Query("culture") String str2, @NotNull @Query("burnOptionType") String str3);

    @NotNull
    @GET("/api/v{version}/marketplace/country/{country}")
    Call<MarketPlaceBurnOptionsResponse> getItems(@Path("version") int i11, @NotNull @Path("country") String str, @NotNull @Query("culture") String str2, @Query("Page") int i12, @Query("Size") int i13, @NotNull @Query("voucherOptionTypes") String str3, @NotNull @Query("burnTypes") String str4, @Query("areaId") int i14);
}
