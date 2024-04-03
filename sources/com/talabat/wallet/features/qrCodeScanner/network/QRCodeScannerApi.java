package com.talabat.wallet.features.qrCodeScanner.network;

import com.talabat.wallet.features.qrCodeScanner.model.request.WalletPaymentRequestModel;
import com.talabat.wallet.features.qrCodeScanner.model.response.WalletPaymentResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/features/qrCodeScanner/network/QRCodeScannerApi;", "", "fetchWalletPaymentResponse", "Lretrofit2/Call;", "Lcom/talabat/wallet/features/qrCodeScanner/model/response/WalletPaymentResponse;", "walletPaymentRequestModel", "Lcom/talabat/wallet/features/qrCodeScanner/model/request/WalletPaymentRequestModel;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface QRCodeScannerApi {
    @NotNull
    @POST("/api/v1/wallet/payment")
    Call<WalletPaymentResponse> fetchWalletPaymentResponse(@NotNull @Body WalletPaymentRequestModel walletPaymentRequestModel);
}
