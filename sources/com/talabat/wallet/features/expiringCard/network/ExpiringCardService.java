package com.talabat.wallet.features.expiringCard.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.wallet.features.expiringCard.model.ExpiringCardResponse;
import com.talabat.wallet.features.expiringCard.network.ExpiringCardApi;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/features/expiringCard/network/ExpiringCardService;", "Lcom/talabat/wallet/features/expiringCard/network/ExpiringCardApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "expiringCardApi", "getExpiringCardApi", "()Lcom/talabat/wallet/features/expiringCard/network/ExpiringCardApi;", "expiringCardApi$delegate", "Lkotlin/Lazy;", "getExpiringCardDetail", "Lretrofit2/Call;", "Lcom/talabat/wallet/features/expiringCard/model/ExpiringCardResponse;", "countryId", "", "version", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExpiringCardService implements ExpiringCardApi {
    @NotNull
    private final Lazy expiringCardApi$delegate;

    public ExpiringCardService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.expiringCardApi$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new ExpiringCardService$expiringCardApi$2(talabatAPIBuilder));
    }

    private final ExpiringCardApi getExpiringCardApi() {
        return (ExpiringCardApi) this.expiringCardApi$delegate.getValue();
    }

    @NotNull
    public Call<ExpiringCardResponse> getExpiringCardDetail(int i11, int i12) {
        return ExpiringCardApi.DefaultImpls.getExpiringCardDetail$default(getExpiringCardApi(), i11, 0, 2, (Object) null);
    }
}
