package com.talabat.wallet.features.qrCodeScanner.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.wallet.features.qrCodeScanner.model.request.WalletPaymentRequestModel;
import com.talabat.wallet.features.qrCodeScanner.model.response.WalletPaymentResponse;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/features/qrCodeScanner/network/QRCodeScannerService;", "Lcom/talabat/wallet/features/qrCodeScanner/network/QRCodeScannerApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "qrCodeScannerApi", "getQrCodeScannerApi", "()Lcom/talabat/wallet/features/qrCodeScanner/network/QRCodeScannerApi;", "qrCodeScannerApi$delegate", "Lkotlin/Lazy;", "fetchWalletPaymentResponse", "Lretrofit2/Call;", "Lcom/talabat/wallet/features/qrCodeScanner/model/response/WalletPaymentResponse;", "walletPaymentRequestModel", "Lcom/talabat/wallet/features/qrCodeScanner/model/request/WalletPaymentRequestModel;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QRCodeScannerService implements QRCodeScannerApi {
    @NotNull
    private final Lazy qrCodeScannerApi$delegate;

    public QRCodeScannerService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.qrCodeScannerApi$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new QRCodeScannerService$qrCodeScannerApi$2(talabatAPIBuilder));
    }

    private final QRCodeScannerApi getQrCodeScannerApi() {
        return (QRCodeScannerApi) this.qrCodeScannerApi$delegate.getValue();
    }

    @NotNull
    public Call<WalletPaymentResponse> fetchWalletPaymentResponse(@NotNull WalletPaymentRequestModel walletPaymentRequestModel) {
        Intrinsics.checkNotNullParameter(walletPaymentRequestModel, "walletPaymentRequestModel");
        return getQrCodeScannerApi().fetchWalletPaymentResponse(walletPaymentRequestModel);
    }
}
