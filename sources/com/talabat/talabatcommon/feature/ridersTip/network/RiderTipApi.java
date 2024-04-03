package com.talabat.talabatcommon.feature.ridersTip.network;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.talabatcommon.feature.ridersTip.model.RiderPaymentRequestModel;
import com.talabat.talabatcommon.feature.ridersTip.model.RiderTipPaymentResponse;
import com.talabat.talabatcommon.feature.ridersTip.model.RiderTipSuggestedAmountResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u0006H'J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\b\u001a\u00020\u0006H'¨\u0006\r"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/network/RiderTipApi;", "", "getRiderTipSuggestedAmount", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderTipSuggestedAmountResponse;", "country", "", "version", "countryQueryId", "payRiderTip", "Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderTipPaymentResponse;", "riderPaymentRequestModel", "Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderPaymentRequestModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RiderTipApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call getRiderTipSuggestedAmount$default(RiderTipApi riderTipApi, int i11, int i12, int i13, int i14, Object obj) {
            if (obj == null) {
                if ((i14 & 1) != 0) {
                    i11 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
                }
                if ((i14 & 2) != 0) {
                    i12 = 1;
                }
                if ((i14 & 4) != 0) {
                    i13 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
                }
                return riderTipApi.getRiderTipSuggestedAmount(i11, i12, i13);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRiderTipSuggestedAmount");
        }

        public static /* synthetic */ Call payRiderTip$default(RiderTipApi riderTipApi, RiderPaymentRequestModel riderPaymentRequestModel, int i11, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    i11 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
                }
                return riderTipApi.payRiderTip(riderPaymentRequestModel, i11);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: payRiderTip");
        }
    }

    @NotNull
    @GET("/trackapi/v{version}/rider/tipSuggestions/{countryId}")
    Call<RiderTipSuggestedAmountResponse> getRiderTipSuggestedAmount(@Path("countryId") int i11, @Path("version") int i12, @Query("country_id") int i13);

    @NotNull
    @POST("/trackapi/api/v1/wallet/payment")
    Call<RiderTipPaymentResponse> payRiderTip(@NotNull @Body RiderPaymentRequestModel riderPaymentRequestModel, @Query("country_id") int i11);
}
