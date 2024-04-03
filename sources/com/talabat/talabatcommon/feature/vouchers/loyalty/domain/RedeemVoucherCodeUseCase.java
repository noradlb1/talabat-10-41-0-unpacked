package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import buisnessmodels.Cart;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import datamodels.RedeemedVoucher;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJQ\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\fHBø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/RedeemVoucherCodeUseCase;", "", "voucherRepository", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;", "growthTracker", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/GrowthTracker;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/GrowthTracker;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "invoke", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/RedeemVoucherCodeDomainModel;", "voucherCode", "", "brandId", "countryCode", "", "areaId", "screenName", "screenType", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveVoucherData", "", "voucherData", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemVoucherCodeUseCase {
    @NotNull
    private final GrowthTracker growthTracker;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;
    @NotNull
    private final VoucherRepository voucherRepository;

    @Inject
    public RedeemVoucherCodeUseCase(@NotNull VoucherRepository voucherRepository2, @NotNull GrowthTracker growthTracker2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(voucherRepository2, "voucherRepository");
        Intrinsics.checkNotNullParameter(growthTracker2, "growthTracker");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.voucherRepository = voucherRepository2;
        this.growthTracker = growthTracker2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public static /* synthetic */ Object invoke$default(RedeemVoucherCodeUseCase redeemVoucherCodeUseCase, String str, String str2, int i11, Integer num, String str3, String str4, Continuation continuation, int i12, Object obj) {
        return redeemVoucherCodeUseCase.invoke(str, (i12 & 2) != 0 ? null : str2, i11, (i12 & 8) != 0 ? null : num, (i12 & 16) != 0 ? null : str3, (i12 & 32) != 0 ? null : str4, continuation);
    }

    private final void saveVoucherData(VoucherData voucherData) {
        String id2 = voucherData.getId();
        String title = voucherData.getTitle();
        String voucherCode = voucherData.getVoucherCode();
        float discountValue = voucherData.getDiscountValue();
        String upperCase = voucherData.getDiscountType().getValue().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        float maxDiscountCap = voucherData.getMaxDiscountCap();
        float minOrderValue = voucherData.getMinOrderValue();
        String tag = voucherData.getTag();
        String validTil = voucherData.getValidTil();
        String termsAndConditions = voucherData.getTermsAndConditions();
        String deepLink = voucherData.getDeepLink();
        String description = voucherData.getDescription();
        String campaignReferenceId = voucherData.getCampaignReferenceId();
        Integer redeemedVouchersCount = voucherData.getRedeemedVouchersCount();
        Cart.getInstance().setRedeemedVoucher(new RedeemedVoucher(id2, title, Float.valueOf(discountValue), upperCase, Float.valueOf(maxDiscountCap), Float.valueOf(minOrderValue), tag, validTil, termsAndConditions, deepLink, description, voucherCode, campaignReferenceId, redeemedVouchersCount));
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0033  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:38:0x00d2=Splitter:B:38:0x00d2, B:30:0x00ad=Splitter:B:30:0x00ad} */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.Nullable java.lang.String r20, int r21, @org.jetbrains.annotations.Nullable java.lang.Integer r22, @org.jetbrains.annotations.Nullable java.lang.String r23, @org.jetbrains.annotations.Nullable java.lang.String r24, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModel> r25) {
        /*
            r18 = this;
            r1 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r11 = r23
            r12 = r24
            r0 = r25
            boolean r2 = r0 instanceof com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase$invoke$1
            if (r2 == 0) goto L_0x0021
            r2 = r0
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase$invoke$1 r2 = (com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase$invoke$1) r2
            int r3 = r2.f61635p
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0021
            int r3 = r3 - r4
            r2.f61635p = r3
            goto L_0x0026
        L_0x0021:
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase$invoke$1 r2 = new com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase$invoke$1
            r2.<init>(r1, r0)
        L_0x0026:
            r7 = r2
            java.lang.Object r0 = r7.f61633n
            java.lang.Object r13 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.f61635p
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0085
            if (r2 == r4) goto L_0x005f
            if (r2 != r3) goto L_0x0057
            int r2 = r7.f61632m
            java.lang.Object r3 = r7.f61631l
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r7.f61630k
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r7.f61629j
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r7.f61628i
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r7.f61627h
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase r7 = (com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase) r7
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x007e }
            r10 = r2
            r12 = r3
            r11 = r4
            r9 = r5
            r8 = r6
            goto L_0x00d2
        L_0x0057:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x005f:
            int r2 = r7.f61632m
            java.lang.Object r3 = r7.f61631l
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r7.f61630k
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r7.f61629j
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r7.f61628i
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r7.f61627h
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase r7 = (com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase) r7
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x007e }
            r10 = r2
            r12 = r3
            r11 = r4
            r9 = r5
            r8 = r6
            goto L_0x00ad
        L_0x007e:
            r0 = move-exception
            r10 = r2
            r12 = r3
            r11 = r4
            r9 = r5
            r8 = r6
            goto L_0x00db
        L_0x0085:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00d9 }
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r0 = r1.talabatFeatureFlag     // Catch:{ all -> 0x00d9 }
            com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageFeatureFlagsKeys r2 = com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageFeatureFlagsKeys.INCENTIVES_REFER_A_FRIEND     // Catch:{ all -> 0x00d9 }
            r5 = 0
            boolean r0 = r0.getFeatureFlag(r2, r5)     // Catch:{ all -> 0x00d9 }
            if (r0 == 0) goto L_0x00b2
            com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository r0 = r1.voucherRepository     // Catch:{ all -> 0x00d9 }
            r7.f61627h = r1     // Catch:{ all -> 0x00d9 }
            r7.f61628i = r8     // Catch:{ all -> 0x00d9 }
            r7.f61629j = r9     // Catch:{ all -> 0x00d9 }
            r7.f61630k = r11     // Catch:{ all -> 0x00d9 }
            r7.f61631l = r12     // Catch:{ all -> 0x00d9 }
            r7.f61632m = r10     // Catch:{ all -> 0x00d9 }
            r7.f61635p = r4     // Catch:{ all -> 0x00d9 }
            java.lang.Object r0 = r0.redeemPromoCode(r8, r10, r7)     // Catch:{ all -> 0x00d9 }
            if (r0 != r13) goto L_0x00ac
            return r13
        L_0x00ac:
            r7 = r1
        L_0x00ad:
            com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModel r0 = (com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModel) r0     // Catch:{ all -> 0x00b0 }
            goto L_0x00d4
        L_0x00b0:
            r0 = move-exception
            goto L_0x00db
        L_0x00b2:
            com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository r2 = r1.voucherRepository     // Catch:{ all -> 0x00d9 }
            r7.f61627h = r1     // Catch:{ all -> 0x00d9 }
            r7.f61628i = r8     // Catch:{ all -> 0x00d9 }
            r7.f61629j = r9     // Catch:{ all -> 0x00d9 }
            r7.f61630k = r11     // Catch:{ all -> 0x00d9 }
            r7.f61631l = r12     // Catch:{ all -> 0x00d9 }
            r7.f61632m = r10     // Catch:{ all -> 0x00d9 }
            r7.f61635p = r3     // Catch:{ all -> 0x00d9 }
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            java.lang.Object r0 = r2.redeemVoucherCode(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00d9 }
            if (r0 != r13) goto L_0x00d1
            return r13
        L_0x00d1:
            r7 = r1
        L_0x00d2:
            com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModel r0 = (com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModel) r0     // Catch:{ all -> 0x00b0 }
        L_0x00d4:
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x00b0 }
            goto L_0x00e5
        L_0x00d9:
            r0 = move-exception
            r7 = r1
        L_0x00db:
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x00e5:
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r15 = r12
            boolean r6 = kotlin.Result.m6336isSuccessimpl(r0)
            if (r6 == 0) goto L_0x00ff
            r6 = r0
            com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModel r6 = (com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModel) r6
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData r6 = com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModelKt.voucherData(r6, r2)
            com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker r8 = r7.growthTracker
            r8.onVoucherRedeemed(r6, r5, r15)
            r7.saveVoucherData(r6)
        L_0x00ff:
            java.lang.Throwable r6 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            if (r6 == 0) goto L_0x0148
            com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker r8 = r7.growthTracker
            r9 = 0
            java.lang.String r0 = r6.getMessage()
            if (r0 != 0) goto L_0x0114
            kotlin.jvm.internal.StringCompanionObject r0 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r0 = com.talabat.talabatcommon.extentions.StringUtils.empty(r0)
        L_0x0114:
            r11 = r0
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType r0 = com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType.VOUCHER_CODE
            java.lang.String r12 = r0.name()
            r13 = 0
            r16 = 17
            r17 = 0
            r10 = r2
            r14 = r5
            com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker.voucherFailToApply$default(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            java.lang.String r0 = r6.getMessage()
            if (r0 != 0) goto L_0x0131
            kotlin.jvm.internal.StringCompanionObject r0 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r0 = com.talabat.talabatcommon.extentions.StringUtils.empty(r0)
        L_0x0131:
            if (r3 != 0) goto L_0x0135
            java.lang.String r3 = "N/A"
        L_0x0135:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            if (r5 != 0) goto L_0x013d
            java.lang.String r5 = "Basket Screen"
        L_0x013d:
            com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.ObservabilityManagerUtilKt.observeFailToRedeemVoucherCode(r0, r2, r3, r4, r5)
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures$FailToAddVoucherCode r0 = new com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures$FailToAddVoucherCode
            com.talabat.talabatcore.exception.Failure r6 = (com.talabat.talabatcore.exception.Failure) r6
            r0.<init>(r6)
            throw r0
        L_0x0148:
            kotlin.ResultKt.throwOnFailure(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase.invoke(java.lang.String, java.lang.String, int, java.lang.Integer, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedeemVoucherCodeUseCase(VoucherRepository voucherRepository2, GrowthTracker growthTracker2, ITalabatFeatureFlag iTalabatFeatureFlag, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(voucherRepository2, (i11 & 2) != 0 ? GrowthTracker.INSTANCE : growthTracker2, iTalabatFeatureFlag);
    }
}
