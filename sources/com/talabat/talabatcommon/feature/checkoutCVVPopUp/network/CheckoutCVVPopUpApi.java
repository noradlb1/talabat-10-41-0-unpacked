package com.talabat.talabatcommon.feature.checkoutCVVPopUp.network;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.talabatcommon.feature.checkoutCVVPopUp.model.CheckoutCVVPopUpResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J9\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/feature/checkoutCVVPopUp/network/CheckoutCVVPopUpApi;", "", "getCanRefundToBankStatus", "Lcom/talabat/talabatcommon/feature/checkoutCVVPopUp/model/CheckoutCVVPopUpResponse;", "version", "", "binNumber", "", "countryId", "orderAmount", "", "(ILjava/lang/String;IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CheckoutCVVPopUpApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getCanRefundToBankStatus$default(CheckoutCVVPopUpApi checkoutCVVPopUpApi, int i11, String str, int i12, float f11, Continuation continuation, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 1) != 0) {
                    i11 = 1;
                }
                int i14 = i11;
                if ((i13 & 4) != 0) {
                    i12 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
                }
                return checkoutCVVPopUpApi.getCanRefundToBankStatus(i14, str, i12, f11, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCanRefundToBankStatus");
        }
    }

    @Nullable
    @GET("v{version}/customer/bins/{bins}/countries/{countryId}/cvvPopup/{orderAmount}/")
    Object getCanRefundToBankStatus(@Path("version") int i11, @NotNull @Path("bins") String str, @Path("countryId") int i12, @Path("orderAmount") float f11, @NotNull Continuation<? super CheckoutCVVPopUpResponse> continuation);
}
