package com.talabat.talabatcommon.feature.vouchers.loyalty.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcommon.feature.vouchers.loyalty.LoyaltyUrlConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/network/MarketPlaceRedeemVoucherApi;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class MarketPlaceRedeemBurnOptionService$api$2 extends Lambda implements Function0<MarketPlaceRedeemVoucherApi> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TalabatAPIBuilder f61644g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarketPlaceRedeemBurnOptionService$api$2(TalabatAPIBuilder talabatAPIBuilder) {
        super(0);
        this.f61644g = talabatAPIBuilder;
    }

    @NotNull
    public final MarketPlaceRedeemVoucherApi invoke() {
        return (MarketPlaceRedeemVoucherApi) this.f61644g.createApi(LoyaltyUrlConstants.Companion.getBaseUrl(), MarketPlaceRedeemVoucherApi.class);
    }
}
