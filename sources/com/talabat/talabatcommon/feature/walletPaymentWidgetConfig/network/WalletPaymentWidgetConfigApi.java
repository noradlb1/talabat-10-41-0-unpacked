package com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.network;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.model.WalletPaymentWidgetConfigResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H'¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/network/WalletPaymentWidgetConfigApi;", "", "getWalletPaymentWidgetConfig", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigResponse;", "country", "", "componentId", "featureId", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletPaymentWidgetConfigApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call getWalletPaymentWidgetConfig$default(WalletPaymentWidgetConfigApi walletPaymentWidgetConfigApi, int i11, int i12, int i13, int i14, Object obj) {
            if (obj == null) {
                if ((i14 & 1) != 0) {
                    i11 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
                }
                return walletPaymentWidgetConfigApi.getWalletPaymentWidgetConfig(i11, i12, i13);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWalletPaymentWidgetConfig");
        }
    }

    @NotNull
    @GET("/api/v1/wallet/paymentmethodsconfig/{countryId}/{componentId}/{featrueId}")
    Call<WalletPaymentWidgetConfigResponse> getWalletPaymentWidgetConfig(@Path("countryId") int i11, @Path("componentId") int i12, @Path("featrueId") int i13);
}
