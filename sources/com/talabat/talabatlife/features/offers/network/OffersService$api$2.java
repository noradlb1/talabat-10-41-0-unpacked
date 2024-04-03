package com.talabat.talabatlife.features.offers.network;

import com.talabat.core.network.endpoint.TLifeEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/talabatlife/features/offers/network/OffersApi;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OffersService$api$2 extends Lambda implements Function0<OffersApi> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TalabatAPIBuilder f12044g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OffersService$api$2(TalabatAPIBuilder talabatAPIBuilder) {
        super(0);
        this.f12044g = talabatAPIBuilder;
    }

    @NotNull
    public final OffersApi invoke() {
        return (OffersApi) this.f12044g.createApi(TLifeEndPointProvider.INSTANCE.getBaseUrl(), OffersApi.class);
    }
}
