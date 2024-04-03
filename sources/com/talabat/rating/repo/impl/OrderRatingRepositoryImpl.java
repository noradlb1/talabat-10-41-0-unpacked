package com.talabat.rating.repo.impl;

import JsonModels.Response.OrderRatingDetailsError;
import JsonModels.Response.OrderRatingDetailsResponse;
import JsonModels.Response.RateOrderResponse;
import JsonModels.Response.rateOrders.RateReasonResponse;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.BASEURLS;
import com.talabat.rating.domain.model.OrderRatingDetails;
import com.talabat.rating.domain.repository.OrderRatingRepository;
import datamodels.RateOrderReq;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import service.ApiHandler;
import zs.a;
import zs.b;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0014H\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/rating/repo/impl/OrderRatingRepositoryImpl;", "Lcom/talabat/rating/domain/repository/OrderRatingRepository;", "service", "Lservice/ApiHandler$Services;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lservice/ApiHandler$Services;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "getOrderRatingReasons", "Lio/reactivex/Single;", "LJsonModels/Response/rateOrders/RateReasonResponse;", "encryptedOrderId", "", "getRatingStatus", "Lcom/talabat/rating/domain/model/OrderRatingDetails;", "getVendorLogoUrl", "response", "LJsonModels/Response/RateOrderResponse;", "isNewOrderRatingDetailsApiEnabled", "", "mapToOrderRatingDetailsDomain", "LJsonModels/Response/OrderRatingDetailsResponse;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderRatingRepositoryImpl implements OrderRatingRepository {
    @NotNull

    /* renamed from: service  reason: collision with root package name */
    private final ApiHandler.Services f61191service;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public OrderRatingRepositoryImpl(@NotNull ApiHandler.Services services, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(services, "service");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.f61191service = services;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    /* access modifiers changed from: private */
    /* renamed from: getRatingStatus$lambda-0  reason: not valid java name */
    public static final OrderRatingDetails m10713getRatingStatus$lambda0(OrderRatingRepositoryImpl orderRatingRepositoryImpl, OrderRatingDetailsResponse orderRatingDetailsResponse) {
        Intrinsics.checkNotNullParameter(orderRatingRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(orderRatingDetailsResponse, "response");
        return orderRatingRepositoryImpl.mapToOrderRatingDetailsDomain(orderRatingDetailsResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: getRatingStatus$lambda-1  reason: not valid java name */
    public static final OrderRatingDetails m10714getRatingStatus$lambda1(OrderRatingRepositoryImpl orderRatingRepositoryImpl, RateOrderResponse rateOrderResponse) {
        Intrinsics.checkNotNullParameter(orderRatingRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(rateOrderResponse, "response");
        return orderRatingRepositoryImpl.mapToOrderRatingDetailsDomain(rateOrderResponse);
    }

    private final String getVendorLogoUrl(RateOrderResponse rateOrderResponse) {
        boolean z11;
        RateOrderReq rateOrderReq;
        String str;
        String str2 = rateOrderResponse.baseUrl;
        boolean z12 = false;
        if (str2 == null || str2.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 || (rateOrderReq = rateOrderResponse.result) == null) {
            return "";
        }
        String str3 = rateOrderReq.restLogo;
        if (str3 == null || str3.length() == 0) {
            z12 = true;
        }
        if (z12) {
            return "";
        }
        String str4 = rateOrderResponse.baseUrl;
        RateOrderReq rateOrderReq2 = rateOrderResponse.result;
        if (rateOrderReq2 != null) {
            str = rateOrderReq2.restLogo;
        } else {
            str = null;
        }
        return str4 + str;
    }

    private final boolean isNewOrderRatingDetailsApiEnabled() {
        return this.talabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_NEW_ORDER_RATING_DETAILS_API, false);
    }

    private final OrderRatingDetails mapToOrderRatingDetailsDomain(OrderRatingDetailsResponse orderRatingDetailsResponse) {
        String str;
        String str2;
        String str3;
        String str4;
        String message;
        Boolean canRate = orderRatingDetailsResponse.getResult().getCanRate();
        boolean booleanValue = canRate != null ? canRate.booleanValue() : false;
        Boolean showReasons = orderRatingDetailsResponse.getResult().getShowReasons();
        boolean booleanValue2 = showReasons != null ? showReasons.booleanValue() : false;
        String vendorExperienceRatingTitle = orderRatingDetailsResponse.getResult().getVendorExperienceRatingTitle();
        String str5 = vendorExperienceRatingTitle == null ? "" : vendorExperienceRatingTitle;
        String deliveryExperienceRatingTitle = orderRatingDetailsResponse.getResult().getDeliveryExperienceRatingTitle();
        if (deliveryExperienceRatingTitle == null) {
            str = "";
        } else {
            str = deliveryExperienceRatingTitle;
        }
        String orderId = orderRatingDetailsResponse.getResult().getOrderId();
        if (orderId == null) {
            str2 = "";
        } else {
            str2 = orderId;
        }
        String vendorName = orderRatingDetailsResponse.getResult().getVendorName();
        if (vendorName == null) {
            str3 = "";
        } else {
            str3 = vendorName;
        }
        Integer branchId = orderRatingDetailsResponse.getResult().getBranchId();
        int intValue = branchId != null ? branchId.intValue() : 0;
        Integer vendorId = orderRatingDetailsResponse.getResult().getVendorId();
        int intValue2 = vendorId != null ? vendorId.intValue() : 0;
        OrderRatingDetailsError error = orderRatingDetailsResponse.getError();
        if (error == null || (message = error.getMessage()) == null) {
            str4 = "";
        } else {
            str4 = message;
        }
        String vendorLogoUrl = orderRatingDetailsResponse.getResult().getVendorLogoUrl();
        if (vendorLogoUrl == null) {
            vendorLogoUrl = "";
        }
        return new OrderRatingDetails(booleanValue, booleanValue2, str5, str, str2, str3, intValue, intValue2, str4, vendorLogoUrl);
    }

    @NotNull
    public Single<RateReasonResponse> getOrderRatingReasons(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encryptedOrderId");
        ApiHandler.Services services = this.f61191service;
        String str2 = AppUrls.RATE_BASE_URL;
        Single<RateReasonResponse> singleOrError = services.getRatingReason(str2 + "/api/rating/" + str + "/basicinfo").singleOrError();
        Intrinsics.checkNotNullExpressionValue(singleOrError, "service.getRatingReason(…         .singleOrError()");
        return singleOrError;
    }

    @NotNull
    public Single<OrderRatingDetails> getRatingStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encryptedOrderId");
        if (isNewOrderRatingDetailsApiEnabled()) {
            ApiHandler.Services services = this.f61191service;
            String str2 = AppUrls.RATE_BASE_URL;
            Single<R> singleOrError = services.getOrderRatingDetails(str2 + "/api/rating/" + str + "/canRate").map(new a(this)).singleOrError();
            Intrinsics.checkNotNullExpressionValue(singleOrError, "{\n            service.ge…singleOrError()\n        }");
            return singleOrError;
        }
        ApiHandler.Services services2 = this.f61191service;
        String baseurl = BASEURLS.getBaseurl();
        Single<R> singleOrError2 = services2.getRatingStatus(baseurl + "v1/orders/" + str + "/ratings").map(new b(this)).singleOrError();
        Intrinsics.checkNotNullExpressionValue(singleOrError2, "{\n            service.ge…singleOrError()\n        }");
        return singleOrError2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderRatingRepositoryImpl(service.ApiHandler.Services r1, com.talabat.core.featureflag.domain.ITalabatFeatureFlag r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 1
            if (r3 == 0) goto L_0x0011
            service.ApiHandler r1 = service.ApiHandler.getInstance()
            service.ApiHandler$Services r1 = r1.getServices()
            java.lang.String r3 = "getInstance().services"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
        L_0x0011:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.rating.repo.impl.OrderRatingRepositoryImpl.<init>(service.ApiHandler$Services, com.talabat.core.featureflag.domain.ITalabatFeatureFlag, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private final OrderRatingDetails mapToOrderRatingDetailsDomain(RateOrderResponse rateOrderResponse) {
        String str;
        RateOrderReq rateOrderReq = rateOrderResponse.result;
        boolean z11 = rateOrderReq.canRate;
        String str2 = rateOrderReq.orderID;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = rateOrderReq.restName;
        if (str3 == null) {
            str3 = "";
        }
        int i11 = rateOrderReq.branchId;
        String str4 = rateOrderReq.restId;
        int parseInt = str4 != null ? Integer.parseInt(str4) : 0;
        RateOrderReq rateOrderReq2 = rateOrderResponse.result;
        String str5 = rateOrderReq2 != null ? rateOrderReq2.errorMessage : null;
        if (str5 == null) {
            str = "";
        } else {
            str = str5;
        }
        return new OrderRatingDetails(z11, false, (String) null, (String) null, str2, str3, i11, parseInt, str, getVendorLogoUrl(rateOrderResponse), 14, (DefaultConstructorMarker) null);
    }
}
