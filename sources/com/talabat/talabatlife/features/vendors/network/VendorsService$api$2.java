package com.talabat.talabatlife.features.vendors.network;

import com.talabat.core.network.endpoint.TLifeEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/talabatlife/features/vendors/network/VendorsApi;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VendorsService$api$2 extends Lambda implements Function0<VendorsApi> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TalabatAPIBuilder f12054g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorsService$api$2(TalabatAPIBuilder talabatAPIBuilder) {
        super(0);
        this.f12054g = talabatAPIBuilder;
    }

    @NotNull
    public final VendorsApi invoke() {
        return (VendorsApi) this.f12054g.createApi(TLifeEndPointProvider.INSTANCE.getBaseUrl(), VendorsApi.class);
    }
}
