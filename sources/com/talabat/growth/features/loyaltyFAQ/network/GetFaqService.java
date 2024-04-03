package com.talabat.growth.features.loyaltyFAQ.network;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.growth.features.loyaltyFAQ.models.howItWorks.HowItWorksRootResponse;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/growth/features/loyaltyFAQ/network/GetFaqService;", "Lcom/talabat/growth/features/loyaltyFAQ/network/GetFaqApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "api", "getApi", "()Lcom/talabat/growth/features/loyaltyFAQ/network/GetFaqApi;", "api$delegate", "Lkotlin/Lazy;", "getHowItWorksTips", "Lretrofit2/Call;", "Lcom/talabat/growth/features/loyaltyFAQ/models/howItWorks/HowItWorksRootResponse;", "apiVersion", "", "languageCode", "", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetFaqService implements GetFaqApi {
    @NotNull
    private final Lazy api$delegate;

    public GetFaqService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.api$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new GetFaqService$api$2(talabatAPIBuilder));
    }

    private final GetFaqApi getApi() {
        return (GetFaqApi) this.api$delegate.getValue();
    }

    @NotNull
    public Call<HowItWorksRootResponse> getHowItWorksTips(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
        return getApi().getHowItWorksTips(i11, str);
    }
}
