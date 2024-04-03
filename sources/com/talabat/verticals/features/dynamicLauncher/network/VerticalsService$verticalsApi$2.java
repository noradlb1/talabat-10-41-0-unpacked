package com.talabat.verticals.features.dynamicLauncher.network;

import com.talabat.core.network.endpoint.VendorEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/verticals/features/dynamicLauncher/network/VerticalsApi;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VerticalsService$verticalsApi$2 extends Lambda implements Function0<VerticalsApi> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TalabatAPIBuilder f12451g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerticalsService$verticalsApi$2(TalabatAPIBuilder talabatAPIBuilder) {
        super(0);
        this.f12451g = talabatAPIBuilder;
    }

    @NotNull
    public final VerticalsApi invoke() {
        return (VerticalsApi) this.f12451g.createApi(VendorEndPointProvider.INSTANCE.getBaseUrl(), VerticalsApi.class);
    }
}
