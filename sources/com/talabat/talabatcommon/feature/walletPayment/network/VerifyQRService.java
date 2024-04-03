package com.talabat.talabatcommon.feature.walletPayment.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletVerifyQRCodeRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletVerifyQRCodeResponse;
import com.talabat.talabatcommon.feature.walletPayment.network.VerifyQRAPI;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPayment/network/VerifyQRService;", "Lcom/talabat/talabatcommon/feature/walletPayment/network/VerifyQRAPI;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "verifyQRAPI", "getVerifyQRAPI", "()Lcom/talabat/talabatcommon/feature/walletPayment/network/VerifyQRAPI;", "verifyQRAPI$delegate", "Lkotlin/Lazy;", "verifyQRCode", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletVerifyQRCodeResponse;", "walletVerifyQRCodeRequestModel", "Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletVerifyQRCodeRequestModel;", "version", "", "countryQueryId", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerifyQRService implements VerifyQRAPI {
    @NotNull
    private final Lazy verifyQRAPI$delegate;

    public VerifyQRService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.verifyQRAPI$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new VerifyQRService$verifyQRAPI$2(talabatAPIBuilder));
    }

    private final VerifyQRAPI getVerifyQRAPI() {
        return (VerifyQRAPI) this.verifyQRAPI$delegate.getValue();
    }

    @NotNull
    public Call<WalletVerifyQRCodeResponse> verifyQRCode(@NotNull WalletVerifyQRCodeRequestModel walletVerifyQRCodeRequestModel, int i11, int i12) {
        Intrinsics.checkNotNullParameter(walletVerifyQRCodeRequestModel, "walletVerifyQRCodeRequestModel");
        return VerifyQRAPI.DefaultImpls.verifyQRCode$default(getVerifyQRAPI(), walletVerifyQRCodeRequestModel, i11, 0, 4, (Object) null);
    }
}
