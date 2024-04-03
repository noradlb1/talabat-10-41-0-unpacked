package com.talabat.growth.features.loyalty.network;

import com.talabat.growth.features.loyalty.models.responses.LoyaltyPointsHistoryResponseModel;
import com.talabat.growth.features.loyalty.models.responses.LoyaltySummaryResponseModel;
import com.talabat.growth.features.loyalty.models.responses.RewardsPointsBannerModel;
import com.talabat.growth.features.loyalty.models.responses.isUserEnabled.IsUserEnabledRootResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JJ\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\tH'J\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0006H'J\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0006H'J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0006H'¨\u0006\u0013"}, d2 = {"Lcom/talabat/growth/features/loyalty/network/GetPointsApi;", "", "getPointsList", "Lretrofit2/Call;", "Lcom/talabat/growth/features/loyalty/models/responses/LoyaltyPointsHistoryResponseModel;", "countryId", "", "apiVersion", "filterId", "", "pageNumber", "pageSize", "languageCode", "getPointsSummary", "Lcom/talabat/growth/features/loyalty/models/responses/LoyaltySummaryResponseModel;", "isRewardsPointsBannerVisible", "Lcom/talabat/growth/features/loyalty/models/responses/RewardsPointsBannerModel;", "isUserEnabled", "Lcom/talabat/growth/features/loyalty/models/responses/isUserEnabled/IsUserEnabledRootResponse;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GetPointsApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call getPointsList$default(GetPointsApi getPointsApi, int i11, int i12, String str, int i13, int i14, String str2, int i15, Object obj) {
            if (obj == null) {
                if ((i15 & 2) != 0) {
                    i12 = 3;
                }
                return getPointsApi.getPointsList(i11, i12, str, i13, i14, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPointsList");
        }

        public static /* synthetic */ Call getPointsSummary$default(GetPointsApi getPointsApi, int i11, int i12, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 2) != 0) {
                    i12 = 3;
                }
                return getPointsApi.getPointsSummary(i11, i12);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPointsSummary");
        }

        public static /* synthetic */ Call isRewardsPointsBannerVisible$default(GetPointsApi getPointsApi, int i11, int i12, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 2) != 0) {
                    i12 = 3;
                }
                return getPointsApi.isRewardsPointsBannerVisible(i11, i12);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isRewardsPointsBannerVisible");
        }

        public static /* synthetic */ Call isUserEnabled$default(GetPointsApi getPointsApi, int i11, int i12, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 2) != 0) {
                    i12 = 3;
                }
                return getPointsApi.isUserEnabled(i11, i12);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isUserEnabled");
        }
    }

    @NotNull
    @GET("/api/v{version}/points/customer/me/{transactionType}")
    Call<LoyaltyPointsHistoryResponseModel> getPointsList(@Header("Country") int i11, @Path("version") int i12, @NotNull @Path("transactionType") String str, @Query("Page") int i13, @Query("Size") int i14, @NotNull @Query("culture") String str2);

    @NotNull
    @GET("/api/v{version}/points/customer/me/summary")
    Call<LoyaltySummaryResponseModel> getPointsSummary(@Header("Country") int i11, @Path("version") int i12);

    @NotNull
    @GET("/api/v{version}/me/rewards-points-banner")
    Call<RewardsPointsBannerModel> isRewardsPointsBannerVisible(@Header("Country") int i11, @Path("version") int i12);

    @NotNull
    @GET("/api/v{version}/me/enabled")
    Call<IsUserEnabledRootResponse> isUserEnabled(@Header("Country") int i11, @Path("version") int i12);
}
