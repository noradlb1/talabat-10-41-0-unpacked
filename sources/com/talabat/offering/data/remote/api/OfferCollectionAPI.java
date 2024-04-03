package com.talabat.offering.data.remote.api;

import com.talabat.offering.data.remote.dtos.OTPCodeModelDto;
import com.talabat.offering.data.remote.dtos.OTPResponseDto;
import com.talabat.offering.data.remote.dtos.OfferCollectionDto;
import com.talabat.offering.data.remote.dtos.SendMobileOTPDto;
import com.talabat.talabatcommon.feature.TalabatCommonUrlConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ%\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ%\u0010\u0010\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u0011\u001a\u00020\u0012H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J/\u0010\u0014\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0015\u001a\u00020\u0016H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/talabat/offering/data/remote/api/OfferCollectionAPI;", "", "getOfferCollectionByCollectionId", "Lcom/talabat/offering/data/remote/dtos/OfferCollectionDto;", "collectionId", "", "latitude", "", "longitude", "(IDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resendMobileOTP", "Lcom/talabat/offering/data/remote/dtos/OTPResponseDto;", "organizationToken", "", "requestId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMobileOTP", "mobileOTPDto", "Lcom/talabat/offering/data/remote/dtos/SendMobileOTPDto;", "(Ljava/lang/String;Lcom/talabat/offering/data/remote/dtos/SendMobileOTPDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyOTP", "otpCodeModel", "Lcom/talabat/offering/data/remote/dtos/OTPCodeModelDto;", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/offering/data/remote/dtos/OTPCodeModelDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OfferCollectionAPI {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object resendMobileOTP$default(OfferCollectionAPI offerCollectionAPI, String str, String str2, Continuation continuation, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    str = TalabatCommonUrlConstants.Companion.getSubscriptionOrganizationToken("release");
                }
                return offerCollectionAPI.resendMobileOTP(str, str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resendMobileOTP");
        }

        public static /* synthetic */ Object sendMobileOTP$default(OfferCollectionAPI offerCollectionAPI, String str, SendMobileOTPDto sendMobileOTPDto, Continuation continuation, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    str = TalabatCommonUrlConstants.Companion.getSubscriptionOrganizationToken("release");
                }
                return offerCollectionAPI.sendMobileOTP(str, sendMobileOTPDto, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendMobileOTP");
        }

        public static /* synthetic */ Object verifyOTP$default(OfferCollectionAPI offerCollectionAPI, String str, String str2, OTPCodeModelDto oTPCodeModelDto, Continuation continuation, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    str = TalabatCommonUrlConstants.Companion.getSubscriptionOrganizationToken("release");
                }
                return offerCollectionAPI.verifyOTP(str, str2, oTPCodeModelDto, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verifyOTP");
        }
    }

    @Nullable
    @GET("v1/collections/{collectionId}/vendors")
    Object getOfferCollectionByCollectionId(@Path("collectionId") int i11, @Query("latitude") double d11, @Query("longitude") double d12, @NotNull Continuation<? super OfferCollectionDto> continuation);

    @POST("v1/otps/{requestId}/resend")
    @Nullable
    Object resendMobileOTP(@NotNull @Header("organization") String str, @NotNull @Path("requestId") String str2, @NotNull Continuation<? super OTPResponseDto> continuation);

    @POST("v1/otps/send")
    @Nullable
    Object sendMobileOTP(@NotNull @Header("organization") String str, @NotNull @Body SendMobileOTPDto sendMobileOTPDto, @NotNull Continuation<? super OTPResponseDto> continuation);

    @POST("v1/otps/{requestId}/verify")
    @Nullable
    Object verifyOTP(@NotNull @Header("organization") String str, @NotNull @Path("requestId") String str2, @NotNull @Body OTPCodeModelDto oTPCodeModelDto, @NotNull Continuation<? super OTPResponseDto> continuation);
}
