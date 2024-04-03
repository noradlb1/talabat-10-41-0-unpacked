package com.talabat.wallet.features.qrCodeScanner.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.wallet.features.qrCodeScanner.model.request.ValidateQRCodeRequestModel;
import com.talabat.wallet.features.qrCodeScanner.model.response.ValidateQRCodeResponse;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/features/qrCodeScanner/network/ValidateQRService;", "Lcom/talabat/wallet/features/qrCodeScanner/network/ValidateQRAPI;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "validateQRApi", "getValidateQRApi", "()Lcom/talabat/wallet/features/qrCodeScanner/network/ValidateQRAPI;", "validateQRApi$delegate", "Lkotlin/Lazy;", "getValidateQRCodeServiceResponse", "Lretrofit2/Call;", "Lcom/talabat/wallet/features/qrCodeScanner/model/response/ValidateQRCodeResponse;", "validateQRCodeRequestModel", "Lcom/talabat/wallet/features/qrCodeScanner/model/request/ValidateQRCodeRequestModel;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ValidateQRService implements ValidateQRAPI {
    @NotNull
    private final Lazy validateQRApi$delegate;

    public ValidateQRService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.validateQRApi$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new ValidateQRService$validateQRApi$2(talabatAPIBuilder));
    }

    private final ValidateQRAPI getValidateQRApi() {
        return (ValidateQRAPI) this.validateQRApi$delegate.getValue();
    }

    @NotNull
    public Call<ValidateQRCodeResponse> getValidateQRCodeServiceResponse(@NotNull ValidateQRCodeRequestModel validateQRCodeRequestModel) {
        Intrinsics.checkNotNullParameter(validateQRCodeRequestModel, "validateQRCodeRequestModel");
        return getValidateQRApi().getValidateQRCodeServiceResponse(validateQRCodeRequestModel);
    }
}
