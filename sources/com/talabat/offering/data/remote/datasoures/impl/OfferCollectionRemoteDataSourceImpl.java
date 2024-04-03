package com.talabat.offering.data.remote.datasoures.impl;

import com.talabat.offering.data.remote.api.OfferCollectionAPI;
import com.talabat.offering.data.remote.api.OfferCollectionSubscriptionAPI;
import com.talabat.offering.data.remote.datasoures.OfferCollectionRemoteDataSource;
import com.talabat.offering.data.remote.dtos.OTPCodeModelDto;
import com.talabat.offering.data.remote.dtos.OTPResponseDto;
import com.talabat.offering.data.remote.dtos.OfferCollectionDto;
import com.talabat.offering.data.remote.dtos.SendMobileOTPDto;
import com.talabat.offering.data.remote.dtos.UserOfferCollectionSubscriptionStatusDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ)\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lcom/talabat/offering/data/remote/datasoures/impl/OfferCollectionRemoteDataSourceImpl;", "Lcom/talabat/offering/data/remote/datasoures/OfferCollectionRemoteDataSource;", "offerCollectionAPI", "Lcom/talabat/offering/data/remote/api/OfferCollectionAPI;", "offerCollectionSubscriptionAPI", "Lcom/talabat/offering/data/remote/api/OfferCollectionSubscriptionAPI;", "(Lcom/talabat/offering/data/remote/api/OfferCollectionAPI;Lcom/talabat/offering/data/remote/api/OfferCollectionSubscriptionAPI;)V", "getIsOfferCollectionSubscribed", "Lcom/talabat/offering/data/remote/dtos/UserOfferCollectionSubscriptionStatusDto;", "productId", "", "subscriptionCountryCode", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOfferCollection", "Lcom/talabat/offering/data/remote/dtos/OfferCollectionDto;", "collectionId", "lat", "", "lon", "(IDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resendMobileOTP", "Lcom/talabat/offering/data/remote/dtos/OTPResponseDto;", "requestId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMobileOTP", "sendMobileOTPDto", "Lcom/talabat/offering/data/remote/dtos/SendMobileOTPDto;", "(Lcom/talabat/offering/data/remote/dtos/SendMobileOTPDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyOTP", "otpCode", "Lcom/talabat/offering/data/remote/dtos/OTPCodeModelDto;", "(Ljava/lang/String;Lcom/talabat/offering/data/remote/dtos/OTPCodeModelDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OfferCollectionRemoteDataSourceImpl implements OfferCollectionRemoteDataSource {
    @NotNull
    private final OfferCollectionAPI offerCollectionAPI;
    @NotNull
    private final OfferCollectionSubscriptionAPI offerCollectionSubscriptionAPI;

    public OfferCollectionRemoteDataSourceImpl(@NotNull OfferCollectionAPI offerCollectionAPI2, @NotNull OfferCollectionSubscriptionAPI offerCollectionSubscriptionAPI2) {
        Intrinsics.checkNotNullParameter(offerCollectionAPI2, "offerCollectionAPI");
        Intrinsics.checkNotNullParameter(offerCollectionSubscriptionAPI2, "offerCollectionSubscriptionAPI");
        this.offerCollectionAPI = offerCollectionAPI2;
        this.offerCollectionSubscriptionAPI = offerCollectionSubscriptionAPI2;
    }

    @Nullable
    public Object getIsOfferCollectionSubscribed(@NotNull String str, int i11, @NotNull Continuation<? super UserOfferCollectionSubscriptionStatusDto> continuation) {
        return OfferCollectionSubscriptionAPI.DefaultImpls.getIsOfferCollectionSubscribed$default(this.offerCollectionSubscriptionAPI, (String) null, str, i11, continuation, 1, (Object) null);
    }

    @Nullable
    public Object getOfferCollection(int i11, double d11, double d12, @NotNull Continuation<? super OfferCollectionDto> continuation) {
        return this.offerCollectionAPI.getOfferCollectionByCollectionId(i11, d11, d12, continuation);
    }

    @Nullable
    public Object resendMobileOTP(@NotNull String str, @NotNull Continuation<? super OTPResponseDto> continuation) {
        return OfferCollectionAPI.DefaultImpls.resendMobileOTP$default(this.offerCollectionAPI, (String) null, str, continuation, 1, (Object) null);
    }

    @Nullable
    public Object sendMobileOTP(@NotNull SendMobileOTPDto sendMobileOTPDto, @NotNull Continuation<? super OTPResponseDto> continuation) {
        return OfferCollectionAPI.DefaultImpls.sendMobileOTP$default(this.offerCollectionAPI, (String) null, sendMobileOTPDto, continuation, 1, (Object) null);
    }

    @Nullable
    public Object verifyOTP(@NotNull String str, @NotNull OTPCodeModelDto oTPCodeModelDto, @NotNull Continuation<? super OTPResponseDto> continuation) {
        return OfferCollectionAPI.DefaultImpls.verifyOTP$default(this.offerCollectionAPI, (String) null, str, oTPCodeModelDto, continuation, 1, (Object) null);
    }
}
