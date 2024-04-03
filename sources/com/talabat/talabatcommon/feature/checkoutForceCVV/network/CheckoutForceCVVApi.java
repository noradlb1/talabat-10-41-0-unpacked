package com.talabat.talabatcommon.feature.checkoutForceCVV.network;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.talabatcommon.feature.checkoutForceCVV.model.CheckoutCVVPopUpResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JC\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/talabat/talabatcommon/feature/checkoutForceCVV/network/CheckoutForceCVVApi;", "", "getCanRefundToBankStatus", "Lcom/talabat/talabatcommon/feature/checkoutForceCVV/model/CheckoutCVVPopUpResponse;", "version", "", "binNumber", "", "countryId", "orderAmount", "", "countryQueryId", "(ILjava/lang/String;IFILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CheckoutForceCVVApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getCanRefundToBankStatus$default(CheckoutForceCVVApi checkoutForceCVVApi, int i11, String str, int i12, float f11, int i13, Continuation continuation, int i14, Object obj) {
            if (obj == null) {
                if ((i14 & 1) != 0) {
                    i11 = 1;
                }
                int i15 = i11;
                if ((i14 & 4) != 0) {
                    i12 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
                }
                int i16 = i12;
                if ((i14 & 16) != 0) {
                    i13 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
                }
                return checkoutForceCVVApi.getCanRefundToBankStatus(i15, str, i16, f11, i13, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCanRefundToBankStatus");
        }
    }

    @Nullable
    @GET("v{version}/customer/bins/{bins}/countries/{countryId}/cvvPopup/{orderAmount}/")
    Object getCanRefundToBankStatus(@Path("version") int i11, @NotNull @Path("bins") String str, @Path("countryId") int i12, @Path("orderAmount") float f11, @Query("country_id") int i13, @NotNull Continuation<? super CheckoutCVVPopUpResponse> continuation);
}
