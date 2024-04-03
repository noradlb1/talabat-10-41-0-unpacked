package com.talabat.talabatcommon.feature.vouchers.loyalty.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.RedeemItemRootResponse;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J@\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/network/MarketPlaceRedeemBurnOptionService;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/network/MarketPlaceRedeemVoucherApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "api", "getApi", "()Lcom/talabat/talabatcommon/feature/vouchers/loyalty/network/MarketPlaceRedeemVoucherApi;", "api$delegate", "Lkotlin/Lazy;", "redeemItem", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/RedeemItemRootResponse;", "countryId", "", "apiVersion", "itemId", "", "burnOptionType", "source", "voucherOptionType", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class MarketPlaceRedeemBurnOptionService implements MarketPlaceRedeemVoucherApi {
    @NotNull
    private final Lazy api$delegate;

    public MarketPlaceRedeemBurnOptionService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.api$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new MarketPlaceRedeemBurnOptionService$api$2(talabatAPIBuilder));
    }

    private final MarketPlaceRedeemVoucherApi getApi() {
        return (MarketPlaceRedeemVoucherApi) this.api$delegate.getValue();
    }

    @NotNull
    public Call<RedeemItemRootResponse> redeemItem(int i11, int i12, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, "burnOptionType");
        Intrinsics.checkNotNullParameter(str3, "source");
        return getApi().redeemItem(i11, i12, str, str2, str3, str4);
    }
}
