package com.talabat.verticals.features.dynamicLauncher.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.verticals.features.dynamicLauncher.model.response.VerticalsResponse;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/verticals/features/dynamicLauncher/network/VerticalsService;", "Lcom/talabat/verticals/features/dynamicLauncher/network/VerticalsApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "verticalsApi", "getVerticalsApi", "()Lcom/talabat/verticals/features/dynamicLauncher/network/VerticalsApi;", "verticalsApi$delegate", "Lkotlin/Lazy;", "getVerticals", "Lretrofit2/Call;", "Lcom/talabat/verticals/features/dynamicLauncher/model/response/VerticalsResponse;", "countryId", "", "lat", "", "lng", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerticalsService implements VerticalsApi {
    @NotNull
    private final Lazy verticalsApi$delegate;

    public VerticalsService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.verticalsApi$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new VerticalsService$verticalsApi$2(talabatAPIBuilder));
    }

    private final VerticalsApi getVerticalsApi() {
        return (VerticalsApi) this.verticalsApi$delegate.getValue();
    }

    @NotNull
    public Call<VerticalsResponse> getVerticals(int i11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "lat");
        Intrinsics.checkNotNullParameter(str2, "lng");
        return getVerticalsApi().getVerticals(i11, str, str2);
    }
}
