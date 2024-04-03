package com.talabat.feature.subscriptions.data;

import com.talabat.feature.subscriptions.data.model.ProVendorMovModelMapper;
import com.talabat.feature.subscriptions.data.model.SubscriptionCancellationReasonModelMapper;
import com.talabat.feature.subscriptions.data.model.SubscriptionMultiPlanModelMapper;
import com.talabat.feature.subscriptions.data.model.SubscriptionOTPPaymentStatusMapper;
import com.talabat.feature.subscriptions.data.model.SubscriptionPaymentStatusModelMapper;
import com.talabat.feature.subscriptions.data.model.SubscriptionSavingsModelMapper;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingBannerAndPlansMapper;
import com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource;
import com.talabat.feature.subscriptions.data.remote.model.ProCentralizationResponseResult;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionResponseModel;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.model.ProCentralization;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.mapper.ModelMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001Bo\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJA\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u001d2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\u001d2\b\u0010'\u001a\u0004\u0018\u00010\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010(JA\u0010)\u001a\u00020*2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u001d2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\u001d2\b\u0010'\u001a\u0004\u0018\u00010\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0019\u0010+\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0019\u00100\u001a\u0002012\u0006\u0010!\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020403H@ø\u0001\u0000¢\u0006\u0002\u00105J\u0019\u00106\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u001f\u00107\u001a\b\u0012\u0004\u0012\u00020\t032\u0006\u0010!\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010,J9\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010?JA\u0010@\u001a\u00020A2\u0006\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010EJA\u0010F\u001a\u00020A2\u0006\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010EJ)\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010JJ)\u0010K\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010JJ)\u0010L\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020%H@ø\u0001\u0000¢\u0006\u0002\u0010OJ)\u0010P\u001a\u00020A2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010Q\u001a\u00020\u001d2\u0006\u0010R\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010JR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006S"}, d2 = {"Lcom/talabat/feature/subscriptions/data/SubscriptionsRepositoryImpl;", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "subscriptionsDataSource", "Lcom/talabat/feature/subscriptions/data/remote/SubscriptionsDataSource;", "paymentStatusModelMapper", "Lcom/talabat/feature/subscriptions/data/model/SubscriptionPaymentStatusModelMapper;", "subscriptionModelMapper", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "proCentralizationModelMapper", "Lcom/talabat/feature/subscriptions/data/remote/model/ProCentralizationResponseResult;", "Lcom/talabat/feature/subscriptions/domain/model/ProCentralization;", "multiPlanModelMapper", "Lcom/talabat/feature/subscriptions/data/model/SubscriptionMultiPlanModelMapper;", "proVendorMovModelMapper", "Lcom/talabat/feature/subscriptions/data/model/ProVendorMovModelMapper;", "savingsInfoModelMapper", "Lcom/talabat/feature/subscriptions/data/model/SubscriptionSavingsModelMapper;", "subscriptionCancellationReasonModelMapper", "Lcom/talabat/feature/subscriptions/data/model/SubscriptionCancellationReasonModelMapper;", "subscriptionOTPPaymentStatusMapper", "Lcom/talabat/feature/subscriptions/data/model/SubscriptionOTPPaymentStatusMapper;", "tProOnBoardingBannerAndPlansMapper", "Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingBannerAndPlansMapper;", "(Lcom/talabat/feature/subscriptions/data/remote/SubscriptionsDataSource;Lcom/talabat/feature/subscriptions/data/model/SubscriptionPaymentStatusModelMapper;Lcom/talabat/mapper/ModelMapper;Lcom/talabat/mapper/ModelMapper;Lcom/talabat/feature/subscriptions/data/model/SubscriptionMultiPlanModelMapper;Lcom/talabat/feature/subscriptions/data/model/ProVendorMovModelMapper;Lcom/talabat/feature/subscriptions/data/model/SubscriptionSavingsModelMapper;Lcom/talabat/feature/subscriptions/data/model/SubscriptionCancellationReasonModelMapper;Lcom/talabat/feature/subscriptions/data/model/SubscriptionOTPPaymentStatusMapper;Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingBannerAndPlansMapper;)V", "cancelFreeTrial", "", "membershipId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchTProOnBoardingBannerAndPlans", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingBannerAndPlanModel;", "countryId", "", "duration", "freeCoffee", "", "voucherCode", "requestingPage", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMultiPlan", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionMultiPlan;", "getProCentralizationStatusForCountry", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProVendorMov", "Lcom/talabat/feature/subscriptions/domain/model/ProVendorMov;", "branchId", "getSavingsInfo", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;", "getSubscriptionCancellationReasons", "", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationReason;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSubscriptionDetails", "getSubscriptionsForCountry", "payForSubscriptionOTP", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionOTPPaymentStatus;", "planId", "paymentMethod", "cardTokenId", "deliveryFee", "orderId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payForSubscriptionPlan", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPaymentStatus;", "card4Digits", "cardType", "cardExpiryDate", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payForSubscriptionPlanWithErrorHandling", "sendCancellationFeedback", "reasonId", "other", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "subscribeWithB2BVoucher", "updateAutoRenew", "autoRenewal", "isImmediateCancelDisable", "(Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upgradeSubscriptionPlan", "currentPlanId", "upgradeablePlanId", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionsRepositoryImpl implements ISubscriptionsRepository {
    @NotNull
    private final SubscriptionMultiPlanModelMapper multiPlanModelMapper;
    @NotNull
    private final SubscriptionPaymentStatusModelMapper paymentStatusModelMapper;
    @NotNull
    private final ModelMapper<ProCentralizationResponseResult, ProCentralization> proCentralizationModelMapper;
    @NotNull
    private final ProVendorMovModelMapper proVendorMovModelMapper;
    @NotNull
    private final SubscriptionSavingsModelMapper savingsInfoModelMapper;
    @NotNull
    private final SubscriptionCancellationReasonModelMapper subscriptionCancellationReasonModelMapper;
    @NotNull
    private final ModelMapper<SubscriptionResponseModel, Subscription> subscriptionModelMapper;
    @NotNull
    private final SubscriptionOTPPaymentStatusMapper subscriptionOTPPaymentStatusMapper;
    @NotNull
    private final SubscriptionsDataSource subscriptionsDataSource;
    @NotNull
    private final TProOnBoardingBannerAndPlansMapper tProOnBoardingBannerAndPlansMapper;

    @Inject
    public SubscriptionsRepositoryImpl(@NotNull SubscriptionsDataSource subscriptionsDataSource2, @NotNull SubscriptionPaymentStatusModelMapper subscriptionPaymentStatusModelMapper, @NotNull ModelMapper<SubscriptionResponseModel, Subscription> modelMapper, @NotNull ModelMapper<ProCentralizationResponseResult, ProCentralization> modelMapper2, @NotNull SubscriptionMultiPlanModelMapper subscriptionMultiPlanModelMapper, @NotNull ProVendorMovModelMapper proVendorMovModelMapper2, @NotNull SubscriptionSavingsModelMapper subscriptionSavingsModelMapper, @NotNull SubscriptionCancellationReasonModelMapper subscriptionCancellationReasonModelMapper2, @NotNull SubscriptionOTPPaymentStatusMapper subscriptionOTPPaymentStatusMapper2, @NotNull TProOnBoardingBannerAndPlansMapper tProOnBoardingBannerAndPlansMapper2) {
        Intrinsics.checkNotNullParameter(subscriptionsDataSource2, "subscriptionsDataSource");
        Intrinsics.checkNotNullParameter(subscriptionPaymentStatusModelMapper, "paymentStatusModelMapper");
        Intrinsics.checkNotNullParameter(modelMapper, "subscriptionModelMapper");
        Intrinsics.checkNotNullParameter(modelMapper2, "proCentralizationModelMapper");
        Intrinsics.checkNotNullParameter(subscriptionMultiPlanModelMapper, "multiPlanModelMapper");
        Intrinsics.checkNotNullParameter(proVendorMovModelMapper2, "proVendorMovModelMapper");
        Intrinsics.checkNotNullParameter(subscriptionSavingsModelMapper, "savingsInfoModelMapper");
        Intrinsics.checkNotNullParameter(subscriptionCancellationReasonModelMapper2, "subscriptionCancellationReasonModelMapper");
        Intrinsics.checkNotNullParameter(subscriptionOTPPaymentStatusMapper2, "subscriptionOTPPaymentStatusMapper");
        Intrinsics.checkNotNullParameter(tProOnBoardingBannerAndPlansMapper2, "tProOnBoardingBannerAndPlansMapper");
        this.subscriptionsDataSource = subscriptionsDataSource2;
        this.paymentStatusModelMapper = subscriptionPaymentStatusModelMapper;
        this.subscriptionModelMapper = modelMapper;
        this.proCentralizationModelMapper = modelMapper2;
        this.multiPlanModelMapper = subscriptionMultiPlanModelMapper;
        this.proVendorMovModelMapper = proVendorMovModelMapper2;
        this.savingsInfoModelMapper = subscriptionSavingsModelMapper;
        this.subscriptionCancellationReasonModelMapper = subscriptionCancellationReasonModelMapper2;
        this.subscriptionOTPPaymentStatusMapper = subscriptionOTPPaymentStatusMapper2;
        this.tProOnBoardingBannerAndPlansMapper = tProOnBoardingBannerAndPlansMapper2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object cancelFreeTrial(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$cancelFreeTrial$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$cancelFreeTrial$1 r0 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$cancelFreeTrial$1) r0
            int r1 = r0.f58892j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58892j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$cancelFreeTrial$1 r0 = new com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$cancelFreeTrial$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f58890h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58892j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0048 }
            goto L_0x0041
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0048 }
            com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource r6 = r4.subscriptionsDataSource     // Catch:{ all -> 0x0048 }
            r0.f58892j = r3     // Catch:{ all -> 0x0048 }
            java.lang.Object r6 = r6.cancelFreeTrial(r5, r0)     // Catch:{ all -> 0x0048 }
            if (r6 != r1) goto L_0x0041
            return r1
        L_0x0041:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionsAutoRenewUpdateRootResponse r6 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionsAutoRenewUpdateRootResponse) r6     // Catch:{ all -> 0x0048 }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x0048 }
            goto L_0x0053
        L_0x0048:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0053:
            java.lang.Throwable r6 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            if (r6 != 0) goto L_0x007b
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionsAutoRenewUpdateRootResponse r5 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionsAutoRenewUpdateRootResponse) r5
            java.util.List r5 = r5.getErrors()
            java.util.Collection r5 = (java.util.Collection) r5
            if (r5 == 0) goto L_0x006b
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r3 = 0
        L_0x006b:
            if (r3 == 0) goto L_0x0070
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0070:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r5 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure
            java.lang.Throwable r6 = new java.lang.Throwable
            r6.<init>()
            r5.<init>(r6)
            throw r5
        L_0x007b:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r5 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl.cancelFreeTrial(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e A[Catch:{ all -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0063 A[Catch:{ all -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object fetchTProOnBoardingBannerAndPlans(int r9, @org.jetbrains.annotations.Nullable java.lang.String r10, @org.jetbrains.annotations.Nullable java.lang.Boolean r11, @org.jetbrains.annotations.Nullable java.lang.String r12, @org.jetbrains.annotations.Nullable java.lang.String r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.subscriptions.domain.model.TProOnBoardingBannerAndPlanModel> r14) {
        /*
            r8 = this;
            boolean r0 = r14 instanceof com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$fetchTProOnBoardingBannerAndPlans$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$fetchTProOnBoardingBannerAndPlans$1 r0 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$fetchTProOnBoardingBannerAndPlans$1) r0
            int r1 = r0.f58896k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58896k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$fetchTProOnBoardingBannerAndPlans$1 r0 = new com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$fetchTProOnBoardingBannerAndPlans$1
            r0.<init>(r8, r14)
        L_0x0018:
            r7 = r0
            java.lang.Object r14 = r7.f58894i
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.f58896k
            r2 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 != r2) goto L_0x002e
            java.lang.Object r9 = r7.f58893h
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl r9 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl) r9
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0070 }
            goto L_0x004e
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.Result$Companion r14 = kotlin.Result.Companion     // Catch:{ all -> 0x0070 }
            com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource r1 = r8.subscriptionsDataSource     // Catch:{ all -> 0x0070 }
            r7.f58893h = r8     // Catch:{ all -> 0x0070 }
            r7.f58896k = r2     // Catch:{ all -> 0x0070 }
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            java.lang.Object r14 = r1.getMultiPlanWithHeroBanner(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0070 }
            if (r14 != r0) goto L_0x004d
            return r0
        L_0x004d:
            r9 = r8
        L_0x004e:
            com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingBannerAndPlansRootResponseModel r14 = (com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingBannerAndPlansRootResponseModel) r14     // Catch:{ all -> 0x0070 }
            com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingBannerAndPlanResponseModel r10 = r14.getResult()     // Catch:{ all -> 0x0070 }
            if (r10 == 0) goto L_0x0063
            com.talabat.feature.subscriptions.data.model.TProOnBoardingBannerAndPlansMapper r9 = r9.tProOnBoardingBannerAndPlansMapper     // Catch:{ all -> 0x0070 }
            com.talabat.feature.subscriptions.domain.model.TProOnBoardingBannerAndPlanModel r9 = r9.apply((com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingBannerAndPlanResponseModel) r10)     // Catch:{ all -> 0x0070 }
            if (r9 == 0) goto L_0x0063
            java.lang.Object r9 = kotlin.Result.m6329constructorimpl(r9)     // Catch:{ all -> 0x0070 }
            goto L_0x007b
        L_0x0063:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r9 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure     // Catch:{ all -> 0x0070 }
            java.lang.Throwable r10 = new java.lang.Throwable     // Catch:{ all -> 0x0070 }
            java.lang.String r11 = "Parsing failed"
            r10.<init>(r11)     // Catch:{ all -> 0x0070 }
            r9.<init>(r10)     // Catch:{ all -> 0x0070 }
            throw r9     // Catch:{ all -> 0x0070 }
        L_0x0070:
            r9 = move-exception
            kotlin.Result$Companion r10 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m6329constructorimpl(r9)
        L_0x007b:
            java.lang.Throwable r10 = kotlin.Result.m6332exceptionOrNullimpl(r9)
            if (r10 != 0) goto L_0x0082
            return r9
        L_0x0082:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r9 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl.fetchTProOnBoardingBannerAndPlans(int, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getMultiPlan(int r9, @org.jetbrains.annotations.Nullable java.lang.String r10, @org.jetbrains.annotations.Nullable java.lang.Boolean r11, @org.jetbrains.annotations.Nullable java.lang.String r12, @org.jetbrains.annotations.Nullable java.lang.String r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.subscriptions.domain.model.SubscriptionMultiPlan> r14) {
        /*
            r8 = this;
            boolean r0 = r14 instanceof com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getMultiPlan$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getMultiPlan$1 r0 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getMultiPlan$1) r0
            int r1 = r0.f58900k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58900k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getMultiPlan$1 r0 = new com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getMultiPlan$1
            r0.<init>(r8, r14)
        L_0x0018:
            r7 = r0
            java.lang.Object r14 = r7.f58898i
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.f58900k
            r2 = 1
            if (r1 == 0) goto L_0x0038
            if (r1 != r2) goto L_0x0030
            java.lang.Object r9 = r7.f58897h
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl r9 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl) r9
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x002e }
            goto L_0x0050
        L_0x002e:
            r10 = move-exception
            goto L_0x0059
        L_0x0030:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.Result$Companion r14 = kotlin.Result.Companion     // Catch:{ all -> 0x0057 }
            com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource r1 = r8.subscriptionsDataSource     // Catch:{ all -> 0x0057 }
            r7.f58897h = r8     // Catch:{ all -> 0x0057 }
            r7.f58900k = r2     // Catch:{ all -> 0x0057 }
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            java.lang.Object r14 = r1.getSubscriptionMultiPlan(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0057 }
            if (r14 != r0) goto L_0x004f
            return r0
        L_0x004f:
            r9 = r8
        L_0x0050:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionMultiPlanRootResponse r14 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionMultiPlanRootResponse) r14     // Catch:{ all -> 0x002e }
            java.lang.Object r10 = kotlin.Result.m6329constructorimpl(r14)     // Catch:{ all -> 0x002e }
            goto L_0x0063
        L_0x0057:
            r10 = move-exception
            r9 = r8
        L_0x0059:
            kotlin.Result$Companion r11 = kotlin.Result.Companion
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m6329constructorimpl(r10)
        L_0x0063:
            java.lang.Throwable r11 = kotlin.Result.m6332exceptionOrNullimpl(r10)
            r12 = 0
            if (r11 != 0) goto L_0x006b
            goto L_0x00a0
        L_0x006b:
            r10 = r11
            retrofit2.HttpException r10 = (retrofit2.HttpException) r10     // Catch:{ Exception -> 0x00d6 }
            retrofit2.Response r10 = r10.response()     // Catch:{ Exception -> 0x00d6 }
            if (r10 == 0) goto L_0x007f
            okhttp3.ResponseBody r10 = r10.errorBody()     // Catch:{ Exception -> 0x00d6 }
            if (r10 == 0) goto L_0x007f
            java.lang.String r10 = r10.string()     // Catch:{ Exception -> 0x00d6 }
            goto L_0x0080
        L_0x007f:
            r10 = r12
        L_0x0080:
            if (r10 == 0) goto L_0x00d0
            com.squareup.moshi.Moshi$Builder r13 = new com.squareup.moshi.Moshi$Builder     // Catch:{ Exception -> 0x00d6 }
            r13.<init>()     // Catch:{ Exception -> 0x00d6 }
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory r14 = new com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory     // Catch:{ Exception -> 0x00d6 }
            r14.<init>()     // Catch:{ Exception -> 0x00d6 }
            com.squareup.moshi.Moshi$Builder r13 = r13.add((com.squareup.moshi.JsonAdapter.Factory) r14)     // Catch:{ Exception -> 0x00d6 }
            com.squareup.moshi.Moshi r13 = r13.build()     // Catch:{ Exception -> 0x00d6 }
            java.lang.Class<com.talabat.feature.subscriptions.data.remote.model.SubscriptionMultiPlanRootResponse> r14 = com.talabat.feature.subscriptions.data.remote.model.SubscriptionMultiPlanRootResponse.class
            com.squareup.moshi.JsonAdapter r13 = r13.adapter(r14)     // Catch:{ Exception -> 0x00d6 }
            java.lang.Object r10 = r13.fromJson((java.lang.String) r10)     // Catch:{ Exception -> 0x00d6 }
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionMultiPlanRootResponse r10 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionMultiPlanRootResponse) r10     // Catch:{ Exception -> 0x00d6 }
        L_0x00a0:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionMultiPlanRootResponse r10 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionMultiPlanRootResponse) r10
            if (r10 == 0) goto L_0x00a9
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionMultiPlanResponseModel r11 = r10.getResult()
            goto L_0x00aa
        L_0x00a9:
            r11 = r12
        L_0x00aa:
            if (r11 != 0) goto L_0x00c5
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsErrorMessage r9 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsErrorMessage
            java.lang.Throwable r11 = new java.lang.Throwable
            r11.<init>()
            if (r10 == 0) goto L_0x00ba
            java.lang.String r13 = r10.getErrorCode()
            goto L_0x00bb
        L_0x00ba:
            r13 = r12
        L_0x00bb:
            if (r10 == 0) goto L_0x00c1
            java.util.List r12 = r10.getErrors()
        L_0x00c1:
            r9.<init>(r11, r13, r12)
            throw r9
        L_0x00c5:
            com.talabat.feature.subscriptions.data.model.SubscriptionMultiPlanModelMapper r9 = r9.multiPlanModelMapper
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionMultiPlanResponseModel r10 = r10.getResult()
            com.talabat.feature.subscriptions.domain.model.SubscriptionMultiPlan r9 = r9.apply((com.talabat.feature.subscriptions.data.remote.model.SubscriptionMultiPlanResponseModel) r10)
            return r9
        L_0x00d0:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r9 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure     // Catch:{ Exception -> 0x00d6 }
            r9.<init>(r11)     // Catch:{ Exception -> 0x00d6 }
            throw r9     // Catch:{ Exception -> 0x00d6 }
        L_0x00d6:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r9 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure
            r9.<init>(r11)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl.getMultiPlan(int, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getProCentralizationStatusForCountry(int r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.subscriptions.domain.model.ProCentralization> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getProCentralizationStatusForCountry$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getProCentralizationStatusForCountry$1 r0 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getProCentralizationStatusForCountry$1) r0
            int r1 = r0.f58904k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58904k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getProCentralizationStatusForCountry$1 r0 = new com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getProCentralizationStatusForCountry$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f58902i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58904k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r9 = r0.f58901h
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl r9 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x002d }
            goto L_0x004a
        L_0x002d:
            r10 = move-exception
            goto L_0x0053
        L_0x002f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result$Companion r10 = kotlin.Result.Companion     // Catch:{ all -> 0x0051 }
            com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource r10 = r8.subscriptionsDataSource     // Catch:{ all -> 0x0051 }
            r0.f58901h = r8     // Catch:{ all -> 0x0051 }
            r0.f58904k = r3     // Catch:{ all -> 0x0051 }
            java.lang.Object r10 = r10.getProCentralizationStatusForCountry(r9, r0)     // Catch:{ all -> 0x0051 }
            if (r10 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r9 = r8
        L_0x004a:
            com.talabat.feature.subscriptions.data.remote.model.ProCentralizationRootResponse r10 = (com.talabat.feature.subscriptions.data.remote.model.ProCentralizationRootResponse) r10     // Catch:{ all -> 0x002d }
            java.lang.Object r10 = kotlin.Result.m6329constructorimpl(r10)     // Catch:{ all -> 0x002d }
            goto L_0x005d
        L_0x0051:
            r10 = move-exception
            r9 = r8
        L_0x0053:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m6329constructorimpl(r10)
        L_0x005d:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r10)
            r1 = 0
            if (r0 != 0) goto L_0x0065
            goto L_0x006a
        L_0x0065:
            com.talabat.feature.subscriptions.data.remote.model.ProCentralizationRootResponse r10 = new com.talabat.feature.subscriptions.data.remote.model.ProCentralizationRootResponse
            r10.<init>(r1, r3, r1)
        L_0x006a:
            com.talabat.feature.subscriptions.data.remote.model.ProCentralizationRootResponse r10 = (com.talabat.feature.subscriptions.data.remote.model.ProCentralizationRootResponse) r10
            com.talabat.feature.subscriptions.data.remote.model.ProCentralizationResponseResult r10 = r10.getResult()
            if (r10 == 0) goto L_0x007b
            com.talabat.mapper.ModelMapper<com.talabat.feature.subscriptions.data.remote.model.ProCentralizationResponseResult, com.talabat.feature.subscriptions.domain.model.ProCentralization> r9 = r9.proCentralizationModelMapper
            java.lang.Object r9 = r9.apply(r10)
            r1 = r9
            com.talabat.feature.subscriptions.domain.model.ProCentralization r1 = (com.talabat.feature.subscriptions.domain.model.ProCentralization) r1
        L_0x007b:
            if (r1 != 0) goto L_0x0088
            com.talabat.feature.subscriptions.domain.model.ProCentralization r1 = new com.talabat.feature.subscriptions.domain.model.ProCentralization
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 7
            r7 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
        L_0x0088:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl.getProCentralizationStatusForCountry(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getProVendorMov(int r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.subscriptions.domain.model.ProVendorMov> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getProVendorMov$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getProVendorMov$1 r0 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getProVendorMov$1) r0
            int r1 = r0.f58908k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58908k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getProVendorMov$1 r0 = new com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getProVendorMov$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f58906i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58908k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r7 = r0.f58905h
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl r7 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x002d }
            goto L_0x004a
        L_0x002d:
            r8 = move-exception
            goto L_0x0053
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x0051 }
            com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource r8 = r6.subscriptionsDataSource     // Catch:{ all -> 0x0051 }
            r0.f58905h = r6     // Catch:{ all -> 0x0051 }
            r0.f58908k = r3     // Catch:{ all -> 0x0051 }
            java.lang.Object r8 = r8.getProVendorMov(r7, r0)     // Catch:{ all -> 0x0051 }
            if (r8 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r7 = r6
        L_0x004a:
            com.talabat.feature.subscriptions.data.remote.model.ProVendorMovRootResponse r8 = (com.talabat.feature.subscriptions.data.remote.model.ProVendorMovRootResponse) r8     // Catch:{ all -> 0x002d }
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r8)     // Catch:{ all -> 0x002d }
            goto L_0x005d
        L_0x0051:
            r8 = move-exception
            r7 = r6
        L_0x0053:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r8)
        L_0x005d:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r8)
            if (r0 != 0) goto L_0x007d
            com.talabat.feature.subscriptions.data.remote.model.ProVendorMovRootResponse r8 = (com.talabat.feature.subscriptions.data.remote.model.ProVendorMovRootResponse) r8
            com.talabat.feature.subscriptions.data.model.ProVendorMovModelMapper r7 = r7.proVendorMovModelMapper
            com.talabat.feature.subscriptions.data.remote.model.ProVendorMovResponseModel r8 = r8.getResult()
            if (r8 != 0) goto L_0x0078
            com.talabat.feature.subscriptions.data.remote.model.ProVendorMovResponseModel r8 = new com.talabat.feature.subscriptions.data.remote.model.ProVendorMovResponseModel
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 7
            r5 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x0078:
            com.talabat.feature.subscriptions.domain.model.ProVendorMov r7 = r7.apply((com.talabat.feature.subscriptions.data.remote.model.ProVendorMovResponseModel) r8)
            return r7
        L_0x007d:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r7 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl.getProVendorMov(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getSavingsInfo(int r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSavingsInfo$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSavingsInfo$1 r0 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSavingsInfo$1) r0
            int r1 = r0.f58912k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58912k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSavingsInfo$1 r0 = new com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSavingsInfo$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f58910i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58912k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.f58909h
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl r5 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x002d }
            goto L_0x004a
        L_0x002d:
            r6 = move-exception
            goto L_0x0053
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0051 }
            com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource r6 = r4.subscriptionsDataSource     // Catch:{ all -> 0x0051 }
            r0.f58909h = r4     // Catch:{ all -> 0x0051 }
            r0.f58912k = r3     // Catch:{ all -> 0x0051 }
            java.lang.Object r6 = r6.getSavingsInfo(r5, r0)     // Catch:{ all -> 0x0051 }
            if (r6 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r5 = r4
        L_0x004a:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionSavingsInfoRootResponse r6 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionSavingsInfoRootResponse) r6     // Catch:{ all -> 0x002d }
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x002d }
            goto L_0x005d
        L_0x0051:
            r6 = move-exception
            r5 = r4
        L_0x0053:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)
        L_0x005d:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r6)
            if (r0 != 0) goto L_0x0079
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionSavingsInfoRootResponse r6 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionSavingsInfoRootResponse) r6
            com.talabat.feature.subscriptions.data.model.SubscriptionSavingsModelMapper r5 = r5.savingsInfoModelMapper
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionSavingsInfoResponseResult r6 = r6.getResult()
            if (r6 != 0) goto L_0x0074
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionSavingsInfoResponseResult r6 = new com.talabat.feature.subscriptions.data.remote.model.SubscriptionSavingsInfoResponseResult
            r0 = 3
            r1 = 0
            r6.<init>(r1, r1, r0, r1)
        L_0x0074:
            com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo r5 = r5.apply((com.talabat.feature.subscriptions.data.remote.model.SubscriptionSavingsInfoResponseResult) r6)
            return r5
        L_0x0079:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r5 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl.getSavingsInfo(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getSubscriptionCancellationReasons(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationReason>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSubscriptionCancellationReasons$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSubscriptionCancellationReasons$1 r0 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSubscriptionCancellationReasons$1) r0
            int r1 = r0.f58916k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58916k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSubscriptionCancellationReasons$1 r0 = new com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSubscriptionCancellationReasons$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f58914i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58916k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.f58913h
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl r0 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x002d }
            goto L_0x004a
        L_0x002d:
            r5 = move-exception
            goto L_0x0053
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x0051 }
            com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource r5 = r4.subscriptionsDataSource     // Catch:{ all -> 0x0051 }
            r0.f58913h = r4     // Catch:{ all -> 0x0051 }
            r0.f58916k = r3     // Catch:{ all -> 0x0051 }
            java.lang.Object r5 = r5.getSubscriptionCancellationReasons(r0)     // Catch:{ all -> 0x0051 }
            if (r5 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r0 = r4
        L_0x004a:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionCancellationReasonsRootResponse r5 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionCancellationReasonsRootResponse) r5     // Catch:{ all -> 0x002d }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x002d }
            goto L_0x005d
        L_0x0051:
            r5 = move-exception
            r0 = r4
        L_0x0053:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x005d:
            java.lang.Throwable r1 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            if (r1 != 0) goto L_0x009f
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionCancellationReasonsRootResponse r5 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionCancellationReasonsRootResponse) r5
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionCancellationReasonsResult r5 = r5.getResult()
            if (r5 == 0) goto L_0x0070
            java.util.List r5 = r5.getReasons()
            goto L_0x0071
        L_0x0070:
            r5 = 0
        L_0x0071:
            if (r5 == 0) goto L_0x009a
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r5, r2)
            r1.<init>(r2)
            java.util.Iterator r5 = r5.iterator()
        L_0x0084:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x009e
            java.lang.Object r2 = r5.next()
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionCancellationReasonsResponseModel r2 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionCancellationReasonsResponseModel) r2
            com.talabat.feature.subscriptions.data.model.SubscriptionCancellationReasonModelMapper r3 = r0.subscriptionCancellationReasonModelMapper
            com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationReason r2 = r3.apply((com.talabat.feature.subscriptions.data.remote.model.SubscriptionCancellationReasonsResponseModel) r2)
            r1.add(r2)
            goto L_0x0084
        L_0x009a:
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x009e:
            return r1
        L_0x009f:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r5 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure
            r5.<init>(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl.getSubscriptionCancellationReasons(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getSubscriptionDetails(@org.jetbrains.annotations.NotNull java.lang.String r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.subscriptions.domain.model.Subscription> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSubscriptionDetails$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSubscriptionDetails$1 r0 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSubscriptionDetails$1) r0
            int r1 = r0.f58920k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58920k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSubscriptionDetails$1 r0 = new com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSubscriptionDetails$1
            r0.<init>(r12, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f58918i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58920k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r13 = r0.f58917h
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl r13 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl) r13
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x002d }
            goto L_0x004a
        L_0x002d:
            r14 = move-exception
            goto L_0x0053
        L_0x002f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.Result$Companion r14 = kotlin.Result.Companion     // Catch:{ all -> 0x0051 }
            com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource r14 = r12.subscriptionsDataSource     // Catch:{ all -> 0x0051 }
            r0.f58917h = r12     // Catch:{ all -> 0x0051 }
            r0.f58920k = r3     // Catch:{ all -> 0x0051 }
            java.lang.Object r14 = r14.getSubscriptionDetails(r13, r0)     // Catch:{ all -> 0x0051 }
            if (r14 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r13 = r12
        L_0x004a:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionDetailsRootResponse r14 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionDetailsRootResponse) r14     // Catch:{ all -> 0x002d }
            java.lang.Object r14 = kotlin.Result.m6329constructorimpl(r14)     // Catch:{ all -> 0x002d }
            goto L_0x005d
        L_0x0051:
            r14 = move-exception
            r13 = r12
        L_0x0053:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r14 = kotlin.ResultKt.createFailure(r14)
            java.lang.Object r14 = kotlin.Result.m6329constructorimpl(r14)
        L_0x005d:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r14)
            if (r0 != 0) goto L_0x0089
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionDetailsRootResponse r14 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionDetailsRootResponse) r14
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionResponseModel r14 = r14.getResult()
            com.talabat.mapper.ModelMapper<com.talabat.feature.subscriptions.data.remote.model.SubscriptionResponseModel, com.talabat.feature.subscriptions.domain.model.Subscription> r13 = r13.subscriptionModelMapper
            if (r14 != 0) goto L_0x007f
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionResponseModel r14 = new com.talabat.feature.subscriptions.data.remote.model.SubscriptionResponseModel
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 511(0x1ff, float:7.16E-43)
            r11 = 0
            r0 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L_0x007f:
            java.lang.Object r13 = r13.apply(r14)
            java.lang.String r14 = "subscriptionModelMapper.…scriptionResponseModel())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            return r13
        L_0x0089:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r13 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl.getSubscriptionDetails(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getSubscriptionsForCountry(int r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.talabat.feature.subscriptions.domain.model.Subscription>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSubscriptionsForCountry$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSubscriptionsForCountry$1 r0 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSubscriptionsForCountry$1) r0
            int r1 = r0.f58924k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58924k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSubscriptionsForCountry$1 r0 = new com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$getSubscriptionsForCountry$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f58922i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58924k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.f58921h
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl r5 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x002d }
            goto L_0x004a
        L_0x002d:
            r6 = move-exception
            goto L_0x0053
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0051 }
            com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource r6 = r4.subscriptionsDataSource     // Catch:{ all -> 0x0051 }
            r0.f58921h = r4     // Catch:{ all -> 0x0051 }
            r0.f58924k = r3     // Catch:{ all -> 0x0051 }
            java.lang.Object r6 = r6.getSubscriptionsForCountry(r5, r0)     // Catch:{ all -> 0x0051 }
            if (r6 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r5 = r4
        L_0x004a:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionsRootResponse r6 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionsRootResponse) r6     // Catch:{ all -> 0x002d }
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x002d }
            goto L_0x005d
        L_0x0051:
            r6 = move-exception
            r5 = r4
        L_0x0053:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)
        L_0x005d:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r6)
            r1 = 0
            if (r0 != 0) goto L_0x0065
            goto L_0x006a
        L_0x0065:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionsRootResponse r6 = new com.talabat.feature.subscriptions.data.remote.model.SubscriptionsRootResponse
            r6.<init>(r1, r3, r1)
        L_0x006a:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionsRootResponse r6 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionsRootResponse) r6
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionResponseResult r6 = r6.getResult()
            if (r6 == 0) goto L_0x0076
            java.util.List r1 = r6.getSubscriptions()
        L_0x0076:
            if (r1 == 0) goto L_0x00a1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r6 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r1, r0)
            r6.<init>(r0)
            java.util.Iterator r0 = r1.iterator()
        L_0x0089:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00a5
            java.lang.Object r1 = r0.next()
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionResponseModel r1 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionResponseModel) r1
            com.talabat.mapper.ModelMapper<com.talabat.feature.subscriptions.data.remote.model.SubscriptionResponseModel, com.talabat.feature.subscriptions.domain.model.Subscription> r2 = r5.subscriptionModelMapper
            java.lang.Object r1 = r2.apply(r1)
            com.talabat.feature.subscriptions.domain.model.Subscription r1 = (com.talabat.feature.subscriptions.domain.model.Subscription) r1
            r6.add(r1)
            goto L_0x0089
        L_0x00a1:
            java.util.List r6 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x00a5:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl.getSubscriptionsForCountry(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0068 A[Catch:{ all -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d A[Catch:{ all -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object payForSubscriptionOTP(@org.jetbrains.annotations.NotNull java.lang.String r13, int r14, @org.jetbrains.annotations.NotNull java.lang.String r15, @org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.NotNull java.lang.String r17, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.subscriptions.domain.model.SubscriptionOTPPaymentStatus> r18) {
        /*
            r12 = this;
            r1 = r12
            r0 = r18
            boolean r2 = r0 instanceof com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$payForSubscriptionOTP$1
            if (r2 == 0) goto L_0x0016
            r2 = r0
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$payForSubscriptionOTP$1 r2 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$payForSubscriptionOTP$1) r2
            int r3 = r2.f58928k
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0016
            int r3 = r3 - r4
            r2.f58928k = r3
            goto L_0x001b
        L_0x0016:
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$payForSubscriptionOTP$1 r2 = new com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$payForSubscriptionOTP$1
            r2.<init>(r12, r0)
        L_0x001b:
            java.lang.Object r0 = r2.f58926i
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.f58928k
            r5 = 1
            if (r4 == 0) goto L_0x0038
            if (r4 != r5) goto L_0x0030
            java.lang.Object r2 = r2.f58925h
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl r2 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0078 }
            goto L_0x0058
        L_0x0030:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0078 }
            com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource r0 = r1.subscriptionsDataSource     // Catch:{ all -> 0x0078 }
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentOTPRequestModel r4 = new com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentOTPRequestModel     // Catch:{ all -> 0x0078 }
            r6 = r4
            r7 = r13
            r8 = r15
            r9 = r14
            r10 = r16
            r11 = r17
            r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0078 }
            r2.f58925h = r1     // Catch:{ all -> 0x0078 }
            r2.f58928k = r5     // Catch:{ all -> 0x0078 }
            java.lang.Object r0 = r0.payForSubscriptionPlanOTP(r4, r2)     // Catch:{ all -> 0x0078 }
            if (r0 != r3) goto L_0x0057
            return r3
        L_0x0057:
            r2 = r1
        L_0x0058:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentOTPRootResponseModel r0 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentOTPRootResponseModel) r0     // Catch:{ all -> 0x0078 }
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentOTPPointResponseModel r0 = r0.getResult()     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x006d
            com.talabat.feature.subscriptions.data.model.SubscriptionOTPPaymentStatusMapper r2 = r2.subscriptionOTPPaymentStatusMapper     // Catch:{ all -> 0x0078 }
            com.talabat.feature.subscriptions.domain.model.SubscriptionOTPPaymentStatus r0 = r2.apply((com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentOTPPointResponseModel) r0)     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x006d
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x0078 }
            goto L_0x0083
        L_0x006d:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r0 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure     // Catch:{ all -> 0x0078 }
            java.lang.Throwable r2 = new java.lang.Throwable     // Catch:{ all -> 0x0078 }
            r2.<init>()     // Catch:{ all -> 0x0078 }
            r0.<init>(r2)     // Catch:{ all -> 0x0078 }
            throw r0     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x0083:
            java.lang.Throwable r2 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            if (r2 != 0) goto L_0x008a
            return r0
        L_0x008a:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r0 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl.payForSubscriptionOTP(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object payForSubscriptionPlan(@org.jetbrains.annotations.NotNull java.lang.String r14, int r15, @org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.NotNull java.lang.String r17, @org.jetbrains.annotations.NotNull java.lang.String r18, @org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.subscriptions.domain.model.SubscriptionPaymentStatus> r20) {
        /*
            r13 = this;
            r1 = r13
            r0 = r20
            boolean r2 = r0 instanceof com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$payForSubscriptionPlan$1
            if (r2 == 0) goto L_0x0016
            r2 = r0
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$payForSubscriptionPlan$1 r2 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$payForSubscriptionPlan$1) r2
            int r3 = r2.f58932k
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0016
            int r3 = r3 - r4
            r2.f58932k = r3
            goto L_0x001b
        L_0x0016:
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$payForSubscriptionPlan$1 r2 = new com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$payForSubscriptionPlan$1
            r2.<init>(r13, r0)
        L_0x001b:
            java.lang.Object r0 = r2.f58930i
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.f58932k
            r5 = 1
            if (r4 == 0) goto L_0x003a
            if (r4 != r5) goto L_0x0032
            java.lang.Object r2 = r2.f58929h
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl r2 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0030 }
            goto L_0x005d
        L_0x0030:
            r0 = move-exception
            goto L_0x0066
        L_0x0032:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0064 }
            com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource r0 = r1.subscriptionsDataSource     // Catch:{ all -> 0x0064 }
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRequestModel r4 = new com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRequestModel     // Catch:{ all -> 0x0064 }
            r6 = r4
            r7 = r14
            r8 = r16
            r9 = r17
            r10 = r18
            r11 = r15
            r12 = r19
            r6.<init>(r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0064 }
            r2.f58929h = r1     // Catch:{ all -> 0x0064 }
            r2.f58932k = r5     // Catch:{ all -> 0x0064 }
            java.lang.Object r0 = r0.payForSubscriptionPlan(r4, r2)     // Catch:{ all -> 0x0064 }
            if (r0 != r3) goto L_0x005c
            return r3
        L_0x005c:
            r2 = r1
        L_0x005d:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse r0 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse) r0     // Catch:{ all -> 0x0030 }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x0030 }
            goto L_0x0070
        L_0x0064:
            r0 = move-exception
            r2 = r1
        L_0x0066:
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x0070:
            java.lang.Throwable r3 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            if (r3 != 0) goto L_0x0077
            goto L_0x007e
        L_0x0077:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse r0 = new com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse
            r3 = 3
            r4 = 0
            r0.<init>(r4, r4, r3, r4)
        L_0x007e:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse r0 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse) r0
            com.talabat.feature.subscriptions.data.model.SubscriptionPaymentStatusModelMapper r2 = r2.paymentStatusModelMapper
            com.talabat.feature.subscriptions.domain.model.SubscriptionPaymentStatus r0 = r2.apply((com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse) r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl.payForSubscriptionPlan(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object payForSubscriptionPlanWithErrorHandling(@org.jetbrains.annotations.NotNull java.lang.String r14, int r15, @org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.NotNull java.lang.String r17, @org.jetbrains.annotations.NotNull java.lang.String r18, @org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.subscriptions.domain.model.SubscriptionPaymentStatus> r20) {
        /*
            r13 = this;
            r1 = r13
            r0 = r20
            boolean r2 = r0 instanceof com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$payForSubscriptionPlanWithErrorHandling$1
            if (r2 == 0) goto L_0x0016
            r2 = r0
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$payForSubscriptionPlanWithErrorHandling$1 r2 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$payForSubscriptionPlanWithErrorHandling$1) r2
            int r3 = r2.f58936k
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0016
            int r3 = r3 - r4
            r2.f58936k = r3
            goto L_0x001b
        L_0x0016:
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$payForSubscriptionPlanWithErrorHandling$1 r2 = new com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$payForSubscriptionPlanWithErrorHandling$1
            r2.<init>(r13, r0)
        L_0x001b:
            java.lang.Object r0 = r2.f58934i
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.f58936k
            r5 = 1
            if (r4 == 0) goto L_0x003a
            if (r4 != r5) goto L_0x0032
            java.lang.Object r2 = r2.f58933h
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl r2 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0030 }
            goto L_0x005d
        L_0x0030:
            r0 = move-exception
            goto L_0x0066
        L_0x0032:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0064 }
            com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource r0 = r1.subscriptionsDataSource     // Catch:{ all -> 0x0064 }
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRequestModel r4 = new com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRequestModel     // Catch:{ all -> 0x0064 }
            r6 = r4
            r7 = r14
            r8 = r16
            r9 = r17
            r10 = r18
            r11 = r15
            r12 = r19
            r6.<init>(r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0064 }
            r2.f58933h = r1     // Catch:{ all -> 0x0064 }
            r2.f58936k = r5     // Catch:{ all -> 0x0064 }
            java.lang.Object r0 = r0.payForSubscriptionPlan(r4, r2)     // Catch:{ all -> 0x0064 }
            if (r0 != r3) goto L_0x005c
            return r3
        L_0x005c:
            r2 = r1
        L_0x005d:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse r0 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse) r0     // Catch:{ all -> 0x0030 }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x0030 }
            goto L_0x0070
        L_0x0064:
            r0 = move-exception
            r2 = r1
        L_0x0066:
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x0070:
            java.lang.Throwable r3 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            r4 = 0
            if (r3 != 0) goto L_0x0078
            goto L_0x00ad
        L_0x0078:
            r0 = r3
            retrofit2.HttpException r0 = (retrofit2.HttpException) r0     // Catch:{ Exception -> 0x00da }
            retrofit2.Response r0 = r0.response()     // Catch:{ Exception -> 0x00da }
            if (r0 == 0) goto L_0x008c
            okhttp3.ResponseBody r0 = r0.errorBody()     // Catch:{ Exception -> 0x00da }
            if (r0 == 0) goto L_0x008c
            java.lang.String r0 = r0.string()     // Catch:{ Exception -> 0x00da }
            goto L_0x008d
        L_0x008c:
            r0 = r4
        L_0x008d:
            if (r0 == 0) goto L_0x00d4
            com.squareup.moshi.Moshi$Builder r6 = new com.squareup.moshi.Moshi$Builder     // Catch:{ Exception -> 0x00da }
            r6.<init>()     // Catch:{ Exception -> 0x00da }
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory r7 = new com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory     // Catch:{ Exception -> 0x00da }
            r7.<init>()     // Catch:{ Exception -> 0x00da }
            com.squareup.moshi.Moshi$Builder r6 = r6.add((com.squareup.moshi.JsonAdapter.Factory) r7)     // Catch:{ Exception -> 0x00da }
            com.squareup.moshi.Moshi r6 = r6.build()     // Catch:{ Exception -> 0x00da }
            java.lang.Class<com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse> r7 = com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse.class
            com.squareup.moshi.JsonAdapter r6 = r6.adapter(r7)     // Catch:{ Exception -> 0x00da }
            java.lang.Object r0 = r6.fromJson((java.lang.String) r0)     // Catch:{ Exception -> 0x00da }
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse r0 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse) r0     // Catch:{ Exception -> 0x00da }
        L_0x00ad:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse r0 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse) r0
            if (r0 == 0) goto L_0x00b6
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse$SubscriptionPaymentResult r3 = r0.getResult()
            goto L_0x00b7
        L_0x00b6:
            r3 = r4
        L_0x00b7:
            if (r3 != 0) goto L_0x00cd
            com.talabat.feature.subscriptions.data.model.SubscriptionPaymentStatusModelMapper r2 = r2.paymentStatusModelMapper
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse r3 = new com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse
            if (r0 == 0) goto L_0x00c4
            java.util.List r0 = r0.getErrors()
            goto L_0x00c5
        L_0x00c4:
            r0 = r4
        L_0x00c5:
            r3.<init>(r4, r0, r5, r4)
            com.talabat.feature.subscriptions.domain.model.SubscriptionPaymentStatus r0 = r2.apply((com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse) r3)
            return r0
        L_0x00cd:
            com.talabat.feature.subscriptions.data.model.SubscriptionPaymentStatusModelMapper r2 = r2.paymentStatusModelMapper
            com.talabat.feature.subscriptions.domain.model.SubscriptionPaymentStatus r0 = r2.apply((com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse) r0)
            return r0
        L_0x00d4:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r0 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure     // Catch:{ Exception -> 0x00da }
            r0.<init>(r3)     // Catch:{ Exception -> 0x00da }
            throw r0     // Catch:{ Exception -> 0x00da }
        L_0x00da:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r0 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl.payForSubscriptionPlanWithErrorHandling(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object sendCancellationFeedback(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$sendCancellationFeedback$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$sendCancellationFeedback$1 r0 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$sendCancellationFeedback$1) r0
            int r1 = r0.f58939j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58939j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$sendCancellationFeedback$1 r0 = new com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$sendCancellationFeedback$1
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f58937h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58939j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x004d }
            goto L_0x0046
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x004d }
            com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource r8 = r4.subscriptionsDataSource     // Catch:{ all -> 0x004d }
            com.talabat.feature.subscriptions.data.remote.model.CancellationFeedbackRequestModel r2 = new com.talabat.feature.subscriptions.data.remote.model.CancellationFeedbackRequestModel     // Catch:{ all -> 0x004d }
            r2.<init>(r5, r6, r7)     // Catch:{ all -> 0x004d }
            r0.f58939j = r3     // Catch:{ all -> 0x004d }
            java.lang.Object r8 = r8.sendCancellationFeedback(r2, r0)     // Catch:{ all -> 0x004d }
            if (r8 != r1) goto L_0x0046
            return r1
        L_0x0046:
            com.talabat.feature.subscriptions.data.remote.model.SendCancellationFeedbackRootResponse r8 = (com.talabat.feature.subscriptions.data.remote.model.SendCancellationFeedbackRootResponse) r8     // Catch:{ all -> 0x004d }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r8)     // Catch:{ all -> 0x004d }
            goto L_0x0058
        L_0x004d:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0058:
            java.lang.Throwable r6 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            if (r6 != 0) goto L_0x007c
            com.talabat.feature.subscriptions.data.remote.model.SendCancellationFeedbackRootResponse r5 = (com.talabat.feature.subscriptions.data.remote.model.SendCancellationFeedbackRootResponse) r5
            java.lang.Boolean r5 = r5.getHasError()
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 != 0) goto L_0x0071
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0071:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r5 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure
            java.lang.Throwable r6 = new java.lang.Throwable
            r6.<init>()
            r5.<init>(r6)
            throw r5
        L_0x007c:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r5 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl.sendCancellationFeedback(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object subscribeWithB2BVoucher(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$subscribeWithB2BVoucher$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$subscribeWithB2BVoucher$1 r0 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$subscribeWithB2BVoucher$1) r0
            int r1 = r0.f58942j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58942j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$subscribeWithB2BVoucher$1 r0 = new com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$subscribeWithB2BVoucher$1
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f58940h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58942j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x004d }
            goto L_0x0046
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x004d }
            com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource r8 = r4.subscriptionsDataSource     // Catch:{ all -> 0x004d }
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionB2BVoucherRequestModel r2 = new com.talabat.feature.subscriptions.data.remote.model.SubscriptionB2BVoucherRequestModel     // Catch:{ all -> 0x004d }
            r2.<init>(r5, r6, r7)     // Catch:{ all -> 0x004d }
            r0.f58942j = r3     // Catch:{ all -> 0x004d }
            java.lang.Object r8 = r8.subscribeWithB2BVoucher(r2, r0)     // Catch:{ all -> 0x004d }
            if (r8 != r1) goto L_0x0046
            return r1
        L_0x0046:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionB2BVoucherRootResponse r8 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionB2BVoucherRootResponse) r8     // Catch:{ all -> 0x004d }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r8)     // Catch:{ all -> 0x004d }
            goto L_0x0058
        L_0x004d:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0058:
            java.lang.Throwable r6 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            r7 = 0
            if (r6 != 0) goto L_0x0060
            goto L_0x0095
        L_0x0060:
            r5 = r6
            retrofit2.HttpException r5 = (retrofit2.HttpException) r5     // Catch:{ Exception -> 0x00cd }
            retrofit2.Response r5 = r5.response()     // Catch:{ Exception -> 0x00cd }
            if (r5 == 0) goto L_0x0074
            okhttp3.ResponseBody r5 = r5.errorBody()     // Catch:{ Exception -> 0x00cd }
            if (r5 == 0) goto L_0x0074
            java.lang.String r5 = r5.string()     // Catch:{ Exception -> 0x00cd }
            goto L_0x0075
        L_0x0074:
            r5 = r7
        L_0x0075:
            if (r5 == 0) goto L_0x00c7
            com.squareup.moshi.Moshi$Builder r8 = new com.squareup.moshi.Moshi$Builder     // Catch:{ Exception -> 0x00cd }
            r8.<init>()     // Catch:{ Exception -> 0x00cd }
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory r0 = new com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory     // Catch:{ Exception -> 0x00cd }
            r0.<init>()     // Catch:{ Exception -> 0x00cd }
            com.squareup.moshi.Moshi$Builder r8 = r8.add((com.squareup.moshi.JsonAdapter.Factory) r0)     // Catch:{ Exception -> 0x00cd }
            com.squareup.moshi.Moshi r8 = r8.build()     // Catch:{ Exception -> 0x00cd }
            java.lang.Class<com.talabat.feature.subscriptions.data.remote.model.SubscriptionB2BVoucherRootResponse> r0 = com.talabat.feature.subscriptions.data.remote.model.SubscriptionB2BVoucherRootResponse.class
            com.squareup.moshi.JsonAdapter r8 = r8.adapter(r0)     // Catch:{ Exception -> 0x00cd }
            java.lang.Object r5 = r8.fromJson((java.lang.String) r5)     // Catch:{ Exception -> 0x00cd }
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionB2BVoucherRootResponse r5 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionB2BVoucherRootResponse) r5     // Catch:{ Exception -> 0x00cd }
        L_0x0095:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionB2BVoucherRootResponse r5 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionB2BVoucherRootResponse) r5
            if (r5 == 0) goto L_0x009e
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionB2BVoucherResponseModel r6 = r5.getResult()
            goto L_0x009f
        L_0x009e:
            r6 = r7
        L_0x009f:
            if (r6 != 0) goto L_0x00ba
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsErrorMessage r6 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsErrorMessage
            java.lang.Throwable r8 = new java.lang.Throwable
            r8.<init>()
            if (r5 == 0) goto L_0x00af
            java.lang.String r0 = r5.getErrorCode()
            goto L_0x00b0
        L_0x00af:
            r0 = r7
        L_0x00b0:
            if (r5 == 0) goto L_0x00b6
            java.util.List r7 = r5.getErrors()
        L_0x00b6:
            r6.<init>(r8, r0, r7)
            throw r6
        L_0x00ba:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionB2BVoucherResponseModel r5 = r5.getResult()
            java.lang.String r5 = r5.getPlanId()
            if (r5 != 0) goto L_0x00c6
            java.lang.String r5 = ""
        L_0x00c6:
            return r5
        L_0x00c7:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r5 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure     // Catch:{ Exception -> 0x00cd }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00cd }
            throw r5     // Catch:{ Exception -> 0x00cd }
        L_0x00cd:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r5 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl.subscribeWithB2BVoucher(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object updateAutoRenew(@org.jetbrains.annotations.NotNull java.lang.String r6, boolean r7, boolean r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$updateAutoRenew$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$updateAutoRenew$1 r0 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$updateAutoRenew$1) r0
            int r1 = r0.f58945j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58945j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$updateAutoRenew$1 r0 = new com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$updateAutoRenew$1
            r0.<init>(r5, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f58943h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58945j
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r4) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0060 }
            goto L_0x0059
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.Result$Companion r9 = kotlin.Result.Companion     // Catch:{ all -> 0x0060 }
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionAutoRenewRequestModel r9 = new com.talabat.feature.subscriptions.data.remote.model.SubscriptionAutoRenewRequestModel     // Catch:{ all -> 0x0060 }
            if (r7 == 0) goto L_0x003d
            r7 = r4
            goto L_0x003e
        L_0x003d:
            r7 = r3
        L_0x003e:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)     // Catch:{ all -> 0x0060 }
            if (r8 == 0) goto L_0x0046
            r8 = r4
            goto L_0x0047
        L_0x0046:
            r8 = r3
        L_0x0047:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)     // Catch:{ all -> 0x0060 }
            r9.<init>(r7, r8)     // Catch:{ all -> 0x0060 }
            com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource r7 = r5.subscriptionsDataSource     // Catch:{ all -> 0x0060 }
            r0.f58945j = r4     // Catch:{ all -> 0x0060 }
            java.lang.Object r9 = r7.updateAutoRenew(r6, r9, r0)     // Catch:{ all -> 0x0060 }
            if (r9 != r1) goto L_0x0059
            return r1
        L_0x0059:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionsAutoRenewUpdateRootResponse r9 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionsAutoRenewUpdateRootResponse) r9     // Catch:{ all -> 0x0060 }
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r9)     // Catch:{ all -> 0x0060 }
            goto L_0x006b
        L_0x0060:
            r6 = move-exception
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)
        L_0x006b:
            java.lang.Throwable r7 = kotlin.Result.m6332exceptionOrNullimpl(r6)
            if (r7 != 0) goto L_0x0092
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionsAutoRenewUpdateRootResponse r6 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionsAutoRenewUpdateRootResponse) r6
            java.util.List r6 = r6.getErrors()
            java.util.Collection r6 = (java.util.Collection) r6
            if (r6 == 0) goto L_0x0081
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x0082
        L_0x0081:
            r3 = r4
        L_0x0082:
            if (r3 == 0) goto L_0x0087
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0087:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r6 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure
            java.lang.Throwable r7 = new java.lang.Throwable
            r7.<init>()
            r6.<init>(r7)
            throw r6
        L_0x0092:
            com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure r6 = new com.talabat.feature.subscriptions.domain.exception.SubscriptionsRequestFailure
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl.updateAutoRenew(java.lang.String, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object upgradeSubscriptionPlan(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.subscriptions.domain.model.SubscriptionPaymentStatus> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$upgradeSubscriptionPlan$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$upgradeSubscriptionPlan$1 r0 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$upgradeSubscriptionPlan$1) r0
            int r1 = r0.f58949k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58949k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$upgradeSubscriptionPlan$1 r0 = new com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl$upgradeSubscriptionPlan$1
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f58947i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58949k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.f58946h
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl r5 = (com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl) r5
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x002d }
            goto L_0x004f
        L_0x002d:
            r6 = move-exception
            goto L_0x0058
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x0056 }
            com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource r8 = r4.subscriptionsDataSource     // Catch:{ all -> 0x0056 }
            com.talabat.feature.subscriptions.data.remote.model.UpgradePlanRequestModel r2 = new com.talabat.feature.subscriptions.data.remote.model.UpgradePlanRequestModel     // Catch:{ all -> 0x0056 }
            r2.<init>(r6, r7)     // Catch:{ all -> 0x0056 }
            r0.f58946h = r4     // Catch:{ all -> 0x0056 }
            r0.f58949k = r3     // Catch:{ all -> 0x0056 }
            java.lang.Object r8 = r8.upgradeSubscriptionPlan(r2, r5, r0)     // Catch:{ all -> 0x0056 }
            if (r8 != r1) goto L_0x004e
            return r1
        L_0x004e:
            r5 = r4
        L_0x004f:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse r8 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse) r8     // Catch:{ all -> 0x002d }
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r8)     // Catch:{ all -> 0x002d }
            goto L_0x0062
        L_0x0056:
            r6 = move-exception
            r5 = r4
        L_0x0058:
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)
        L_0x0062:
            java.lang.Throwable r7 = kotlin.Result.m6332exceptionOrNullimpl(r6)
            if (r7 != 0) goto L_0x0069
            goto L_0x0070
        L_0x0069:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse r6 = new com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse
            r7 = 3
            r8 = 0
            r6.<init>(r8, r8, r7, r8)
        L_0x0070:
            com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse r6 = (com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse) r6
            com.talabat.feature.subscriptions.data.model.SubscriptionPaymentStatusModelMapper r5 = r5.paymentStatusModelMapper
            com.talabat.feature.subscriptions.domain.model.SubscriptionPaymentStatus r5 = r5.apply((com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse) r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl.upgradeSubscriptionPlan(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
