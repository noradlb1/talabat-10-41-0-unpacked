package com.talabat.growth.features.matketPlace.data.network;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.talabat.core.network.endpoint.LoyaltyEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.growth.features.LoyaltyUrlConstantsKt;
import com.talabat.growth.features.loyalty.BurnOptionDetailsNavigator;
import com.talabat.growth.features.matketPlace.model.response.BurnOptionCategoryResponse;
import com.talabat.growth.features.matketPlace.model.response.MarketPlaceBurnOptionDetailsResponse;
import com.talabat.growth.features.matketPlace.model.response.MarketPlaceBurnOptionsResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J6\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bH\u0016J.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0016JN\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/growth/features/matketPlace/data/network/MarketPlaceService;", "Lcom/talabat/growth/features/matketPlace/data/network/MarketPlaceApi;", "api", "(Lcom/talabat/growth/features/matketPlace/data/network/MarketPlaceApi;)V", "getCategoryDetails", "Lretrofit2/Call;", "Lcom/talabat/growth/features/matketPlace/model/response/BurnOptionCategoryResponse;", "apiVersion", "", "itemId", "", "country", "burnCategoryType", "areaId", "getItemDetails", "Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnOptionDetailsResponse;", "languageCode", "burnOptionType", "getItems", "Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnOptionsResponse;", "page", "size", "voucherOptionType", "burnTypes", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MarketPlaceService implements MarketPlaceApi {
    @NotNull
    private final MarketPlaceApi api;

    public MarketPlaceService() {
        this((MarketPlaceApi) null, 1, (DefaultConstructorMarker) null);
    }

    public MarketPlaceService(@NotNull MarketPlaceApi marketPlaceApi) {
        Intrinsics.checkNotNullParameter(marketPlaceApi, "api");
        this.api = marketPlaceApi;
    }

    @NotNull
    public Call<BurnOptionCategoryResponse> getCategoryDetails(int i11, @NotNull String str, @NotNull String str2, @NotNull String str3, int i12) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, "country");
        Intrinsics.checkNotNullParameter(str3, "burnCategoryType");
        return this.api.getCategoryDetails(i11, str, str2, str3, i12);
    }

    @NotNull
    public Call<MarketPlaceBurnOptionDetailsResponse> getItemDetails(int i11, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
        Intrinsics.checkNotNullParameter(str3, "burnOptionType");
        return this.api.getItemDetails(i11, str, str2, str3);
    }

    @NotNull
    public Call<MarketPlaceBurnOptionsResponse> getItems(int i11, @NotNull String str, @NotNull String str2, int i12, int i13, @NotNull String str3, @NotNull String str4, int i14) {
        Intrinsics.checkNotNullParameter(str, "country");
        Intrinsics.checkNotNullParameter(str2, RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
        String str5 = str3;
        Intrinsics.checkNotNullParameter(str5, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        String str6 = str4;
        Intrinsics.checkNotNullParameter(str6, LoyaltyUrlConstantsKt.BURN_TYPES);
        return this.api.getItems(i11, str, str2, i12, i13, str5, str6, i14);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MarketPlaceService(MarketPlaceApi marketPlaceApi, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? (MarketPlaceApi) new TalabatAPIBuilder().createApi(LoyaltyEndPointProvider.INSTANCE.getBaseUrl(), MarketPlaceApi.class) : marketPlaceApi);
    }
}
