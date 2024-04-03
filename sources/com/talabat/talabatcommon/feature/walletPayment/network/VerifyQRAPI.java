package com.talabat.talabatcommon.feature.walletPayment.network;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletVerifyQRCodeRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletVerifyQRCodeResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\bH'¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPayment/network/VerifyQRAPI;", "", "verifyQRCode", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletVerifyQRCodeResponse;", "walletVerifyQRCodeRequestModel", "Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletVerifyQRCodeRequestModel;", "version", "", "countryQueryId", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VerifyQRAPI {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call verifyQRCode$default(VerifyQRAPI verifyQRAPI, WalletVerifyQRCodeRequestModel walletVerifyQRCodeRequestModel, int i11, int i12, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 2) != 0) {
                    i11 = 1;
                }
                if ((i13 & 4) != 0) {
                    i12 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
                }
                return verifyQRAPI.verifyQRCode(walletVerifyQRCodeRequestModel, i11, i12);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verifyQRCode");
        }
    }

    @NotNull
    @POST("/api/v{version}/merchant/transactions/mark-transaction-processing")
    Call<WalletVerifyQRCodeResponse> verifyQRCode(@NotNull @Body WalletVerifyQRCodeRequestModel walletVerifyQRCodeRequestModel, @Path("version") int i11, @Query("country_id") int i12);
}
