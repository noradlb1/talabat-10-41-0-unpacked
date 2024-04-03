package com.talabat.growth.features.loyaltyFAQ.network;

import com.talabat.core.network.endpoint.LoyaltyEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/growth/features/loyaltyFAQ/network/GetFaqApi;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetFaqService$api$2 extends Lambda implements Function0<GetFaqApi> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TalabatAPIBuilder f60568g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetFaqService$api$2(TalabatAPIBuilder talabatAPIBuilder) {
        super(0);
        this.f60568g = talabatAPIBuilder;
    }

    @NotNull
    public final GetFaqApi invoke() {
        return (GetFaqApi) this.f60568g.createApi(LoyaltyEndPointProvider.INSTANCE.getBaseUrl(), GetFaqApi.class);
    }
}
