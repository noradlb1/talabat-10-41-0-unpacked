package com.talabat.growth.features.loyalty.network;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.growth.features.loyalty.models.responses.LoyaltyPointsHistoryResponseModel;
import com.talabat.growth.features.loyalty.models.responses.LoyaltySummaryResponseModel;
import com.talabat.growth.features.loyalty.models.responses.RewardsPointsBannerModel;
import com.talabat.growth.features.loyalty.models.responses.isUserEnabled.IsUserEnabledRootResponse;
import com.talabat.growth.features.loyalty.network.GetPointsApi;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J6\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0011J\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fR\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/talabat/growth/features/loyalty/network/GetPointsService;", "", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "api", "Lcom/talabat/growth/features/loyalty/network/GetPointsApi;", "getApi", "()Lcom/talabat/growth/features/loyalty/network/GetPointsApi;", "api$delegate", "Lkotlin/Lazy;", "getPointsList", "Lretrofit2/Call;", "Lcom/talabat/growth/features/loyalty/models/responses/LoyaltyPointsHistoryResponseModel;", "countryId", "", "filterId", "", "pageNumber", "pageSize", "languageCode", "getPointsSummary", "Lcom/talabat/growth/features/loyalty/models/responses/LoyaltySummaryResponseModel;", "isRewardsPointsBannerVisible", "Lcom/talabat/growth/features/loyalty/models/responses/RewardsPointsBannerModel;", "isUserEnabled", "Lcom/talabat/growth/features/loyalty/models/responses/isUserEnabled/IsUserEnabledRootResponse;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetPointsService {
    @NotNull
    private final Lazy api$delegate;

    public GetPointsService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.api$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new GetPointsService$api$2(talabatAPIBuilder));
    }

    private final GetPointsApi getApi() {
        return (GetPointsApi) this.api$delegate.getValue();
    }

    @Nullable
    public final Call<LoyaltyPointsHistoryResponseModel> getPointsList(int i11, @NotNull String str, int i12, int i13, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "filterId");
        Intrinsics.checkNotNullParameter(str2, RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
        GetPointsApi api = getApi();
        if (api != null) {
            return GetPointsApi.DefaultImpls.getPointsList$default(api, i11, 0, str, i12, i13, str2, 2, (Object) null);
        }
        return null;
    }

    @Nullable
    public final Call<LoyaltySummaryResponseModel> getPointsSummary(int i11) {
        GetPointsApi api = getApi();
        if (api != null) {
            return GetPointsApi.DefaultImpls.getPointsSummary$default(api, i11, 0, 2, (Object) null);
        }
        return null;
    }

    @Nullable
    public final Call<RewardsPointsBannerModel> isRewardsPointsBannerVisible(int i11) {
        GetPointsApi api = getApi();
        if (api != null) {
            return GetPointsApi.DefaultImpls.isRewardsPointsBannerVisible$default(api, i11, 0, 2, (Object) null);
        }
        return null;
    }

    @Nullable
    public final Call<IsUserEnabledRootResponse> isUserEnabled(int i11) {
        GetPointsApi api = getApi();
        if (api != null) {
            return GetPointsApi.DefaultImpls.isUserEnabled$default(api, i11, 0, 2, (Object) null);
        }
        return null;
    }
}
