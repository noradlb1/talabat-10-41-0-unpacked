package com.talabat.offering.data.remote.datasoures;

import com.talabat.offering.data.remote.dtos.OTPCodeModelDto;
import com.talabat.offering.data.remote.dtos.OTPResponseDto;
import com.talabat.offering.data.remote.dtos.OfferCollectionDto;
import com.talabat.offering.data.remote.dtos.SendMobileOTPDto;
import com.talabat.offering.data.remote.dtos.UserOfferCollectionSubscriptionStatusDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ)\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J!\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/talabat/offering/data/remote/datasoures/OfferCollectionRemoteDataSource;", "", "getIsOfferCollectionSubscribed", "Lcom/talabat/offering/data/remote/dtos/UserOfferCollectionSubscriptionStatusDto;", "productId", "", "subscriptionCountryCode", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOfferCollection", "Lcom/talabat/offering/data/remote/dtos/OfferCollectionDto;", "collectionId", "lat", "", "lon", "(IDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resendMobileOTP", "Lcom/talabat/offering/data/remote/dtos/OTPResponseDto;", "requestId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMobileOTP", "sendMobileOTPDto", "Lcom/talabat/offering/data/remote/dtos/SendMobileOTPDto;", "(Lcom/talabat/offering/data/remote/dtos/SendMobileOTPDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyOTP", "otpCode", "Lcom/talabat/offering/data/remote/dtos/OTPCodeModelDto;", "(Ljava/lang/String;Lcom/talabat/offering/data/remote/dtos/OTPCodeModelDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OfferCollectionRemoteDataSource {
    @Nullable
    Object getIsOfferCollectionSubscribed(@NotNull String str, int i11, @NotNull Continuation<? super UserOfferCollectionSubscriptionStatusDto> continuation);

    @Nullable
    Object getOfferCollection(int i11, double d11, double d12, @NotNull Continuation<? super OfferCollectionDto> continuation);

    @Nullable
    Object resendMobileOTP(@NotNull String str, @NotNull Continuation<? super OTPResponseDto> continuation);

    @Nullable
    Object sendMobileOTP(@NotNull SendMobileOTPDto sendMobileOTPDto, @NotNull Continuation<? super OTPResponseDto> continuation);

    @Nullable
    Object verifyOTP(@NotNull String str, @NotNull OTPCodeModelDto oTPCodeModelDto, @NotNull Continuation<? super OTPResponseDto> continuation);
}
