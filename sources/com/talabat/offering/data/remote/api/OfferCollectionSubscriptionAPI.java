package com.talabat.offering.data.remote.api;

import com.talabat.offering.data.remote.dtos.UserOfferCollectionSubscriptionStatusDto;
import com.talabat.talabatcommon.feature.TalabatCommonUrlConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/offering/data/remote/api/OfferCollectionSubscriptionAPI;", "", "getIsOfferCollectionSubscribed", "Lcom/talabat/offering/data/remote/dtos/UserOfferCollectionSubscriptionStatusDto;", "organizationToken", "", "productId", "subscriptionCountryCode", "", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OfferCollectionSubscriptionAPI {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getIsOfferCollectionSubscribed$default(OfferCollectionSubscriptionAPI offerCollectionSubscriptionAPI, String str, String str2, int i11, Continuation continuation, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    str = TalabatCommonUrlConstants.Companion.getSubscriptionOrganizationToken("release");
                }
                return offerCollectionSubscriptionAPI.getIsOfferCollectionSubscribed(str, str2, i11, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getIsOfferCollectionSubscribed");
        }
    }

    @Nullable
    @GET("api/v1/customer/products/{productId}/countries/{countryCode}/is-subscribed")
    Object getIsOfferCollectionSubscribed(@NotNull @Header("organization") String str, @NotNull @Path("productId") String str2, @Path("countryCode") int i11, @NotNull Continuation<? super UserOfferCollectionSubscriptionStatusDto> continuation);
}
