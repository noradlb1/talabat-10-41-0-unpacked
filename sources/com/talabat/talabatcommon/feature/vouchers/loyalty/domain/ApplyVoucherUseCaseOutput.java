package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.ObservabilityManagerUtilKt;
import com.talabat.talabatcommon.feature.vouchers.monolith.GetMenuItemDetailsUseCase;
import com.talabat.talabatcommon.feature.vouchers.monolith.model.requestModel.GetVoucherItemsRequestModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures;
import com.talabat.talabatcore.exception.Failure;
import datamodels.CartMenuItem;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJZ\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u0013H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J.\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0011H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b \u0010!Jg\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u001e0#2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u0013HBø\u0001\u0000¢\u0006\u0002\u0010%J&\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00182\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\u0006\u0010)\u001a\u00020\rH\u0002J\u0018\u0010*\u001a\u00020+2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001e\u0010,\u001a\u00020+2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/ApplyVoucherUseCaseOutput;", "", "voucherRepository", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;", "getMenuItemDetailsUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/GetMenuItemDetailsUseCase;", "growthTracker", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/GrowthTracker;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;Lcom/talabat/talabatcommon/feature/vouchers/monolith/GetMenuItemDetailsUseCase;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/GrowthTracker;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "applyVoucher", "Lkotlin/Result;", "", "voucherData", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;", "brandId", "", "areaId", "", "orderTotalAmount", "", "cartItems", "", "Ldatamodels/CartMenuItem;", "verticalId", "applyVoucher-bMdYcbs", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;Ljava/lang/String;IFLjava/util/List;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductIds", "getVoucherTargetedItemDetails", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherItemsDisplayModel;", "branchId", "getVoucherTargetedItemDetails-gIAlu-s", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;Ljava/lang/String;)Ljava/lang/Object;", "invoke", "Lkotlin/Pair;", "groceryVendorId", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isItemMatchingVoucherCategories", "item", "categoryIds", "excludeCategories", "isMinimumOrderValueSatisfied", "", "isTargetedProductItemsInTheBasket", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApplyVoucherUseCaseOutput {
    @NotNull
    private final ITalabatFeatureFlag featureFlagRepo;
    @NotNull
    private final GetMenuItemDetailsUseCase getMenuItemDetailsUseCase;
    @NotNull
    private final GrowthTracker growthTracker;
    @NotNull
    private final VoucherRepository voucherRepository;

    public ApplyVoucherUseCaseOutput(@NotNull VoucherRepository voucherRepository2, @NotNull GetMenuItemDetailsUseCase getMenuItemDetailsUseCase2, @NotNull GrowthTracker growthTracker2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(voucherRepository2, "voucherRepository");
        Intrinsics.checkNotNullParameter(getMenuItemDetailsUseCase2, "getMenuItemDetailsUseCase");
        Intrinsics.checkNotNullParameter(growthTracker2, "growthTracker");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        this.voucherRepository = voucherRepository2;
        this.getMenuItemDetailsUseCase = getMenuItemDetailsUseCase2;
        this.growthTracker = growthTracker2;
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b7 A[SYNTHETIC, Splitter:B:47:0x00b7] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c4 A[Catch:{ all -> 0x0090 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0158 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: applyVoucher-bMdYcbs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m10932applyVoucherbMdYcbs(com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData r22, java.lang.String r23, int r24, float r25, java.util.List<? extends datamodels.CartMenuItem> r26, int r27, kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.Boolean>> r28) {
        /*
            r21 = this;
            r1 = r21
            r0 = r28
            boolean r2 = r0 instanceof com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput$applyVoucher$1
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput$applyVoucher$1 r2 = (com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput$applyVoucher$1) r2
            int r3 = r2.f61602n
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f61602n = r3
            goto L_0x001c
        L_0x0017:
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput$applyVoucher$1 r2 = new com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput$applyVoucher$1
            r2.<init>(r1, r0)
        L_0x001c:
            r8 = r2
            java.lang.Object r0 = r8.f61600l
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r8.f61602n
            r4 = 1
            r9 = 0
            if (r3 == 0) goto L_0x004e
            if (r3 != r4) goto L_0x0046
            float r2 = r8.f61599k
            java.lang.Object r3 = r8.f61598j
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r4 = r8.f61597i
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData r4 = (com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData) r4
            java.lang.Object r5 = r8.f61596h
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput r5 = (com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput) r5
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0040 }
            r12 = r2
            r11 = r3
            r10 = r4
            goto L_0x0085
        L_0x0040:
            r0 = move-exception
            r12 = r2
            r11 = r3
            r10 = r4
            goto L_0x00e5
        L_0x0046:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00dd }
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r0 = r1.featureFlagRepo     // Catch:{ all -> 0x00dd }
            com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageFeatureFlagsKeys r3 = com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageFeatureFlagsKeys.INCENTIVES_REFER_A_FRIEND     // Catch:{ all -> 0x00dd }
            r5 = 0
            boolean r0 = r0.getFeatureFlag(r3, r5)     // Catch:{ all -> 0x00dd }
            if (r0 == 0) goto L_0x0098
            com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository r3 = r1.voucherRepository     // Catch:{ all -> 0x00dd }
            java.lang.String r0 = r22.getId()     // Catch:{ all -> 0x00dd }
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r24)     // Catch:{ all -> 0x00dd }
            r8.f61596h = r1     // Catch:{ all -> 0x00dd }
            r10 = r22
            r8.f61597i = r10     // Catch:{ all -> 0x0096 }
            r11 = r26
            r8.f61598j = r11     // Catch:{ all -> 0x0092 }
            r12 = r25
            r8.f61599k = r12     // Catch:{ all -> 0x00db }
            r8.f61602n = r4     // Catch:{ all -> 0x00db }
            r4 = r0
            r5 = r23
            r7 = r27
            java.lang.Object r0 = r3.applyPromoCode(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00db }
            if (r0 != r2) goto L_0x0084
            return r2
        L_0x0084:
            r5 = r1
        L_0x0085:
            com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.BinRestrictedVoucherModel r0 = (com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.BinRestrictedVoucherModel) r0     // Catch:{ all -> 0x0090 }
            boolean r0 = r0.isApplied()     // Catch:{ all -> 0x0090 }
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)     // Catch:{ all -> 0x0090 }
            goto L_0x00b5
        L_0x0090:
            r0 = move-exception
            goto L_0x00e5
        L_0x0092:
            r0 = move-exception
            r12 = r25
            goto L_0x00e4
        L_0x0096:
            r0 = move-exception
            goto L_0x00e0
        L_0x0098:
            r10 = r22
            r12 = r25
            r11 = r26
            com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository r0 = r1.voucherRepository     // Catch:{ all -> 0x00db }
            java.lang.String r2 = r22.getId()     // Catch:{ all -> 0x00db }
            boolean r0 = r0.applyVoucher(r2)     // Catch:{ all -> 0x00db }
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)     // Catch:{ all -> 0x00db }
            boolean r2 = r0.booleanValue()     // Catch:{ all -> 0x00db }
            r5 = r1
            if (r2 == 0) goto L_0x00b4
            goto L_0x00b5
        L_0x00b4:
            r0 = r9
        L_0x00b5:
            if (r0 == 0) goto L_0x00c4
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0090 }
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)     // Catch:{ all -> 0x0090 }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x0090 }
            goto L_0x00ef
        L_0x00c4:
            com.talabat.talabatcore.exception.ServerError r0 = new com.talabat.talabatcore.exception.ServerError     // Catch:{ all -> 0x0090 }
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 7
            r7 = 0
            r22 = r0
            r23 = r2
            r24 = r3
            r25 = r4
            r26 = r6
            r27 = r7
            r22.<init>(r23, r24, r25, r26, r27)     // Catch:{ all -> 0x0090 }
            throw r0     // Catch:{ all -> 0x0090 }
        L_0x00db:
            r0 = move-exception
            goto L_0x00e4
        L_0x00dd:
            r0 = move-exception
            r10 = r22
        L_0x00e0:
            r12 = r25
            r11 = r26
        L_0x00e4:
            r5 = r1
        L_0x00e5:
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x00ef:
            boolean r2 = kotlin.Result.m6336isSuccessimpl(r0)
            if (r2 == 0) goto L_0x0104
            r2 = r0
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            r2.booleanValue()
            com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker r2 = r5.growthTracker
            float r3 = com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTrackerUtilKt.getDiscountPrice(r10, r12, r11)
            r2.voucherSuccessToApply(r3, r10)
        L_0x0104:
            java.lang.Throwable r2 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            if (r2 == 0) goto L_0x0158
            com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker r11 = r5.growthTracker
            java.lang.String r12 = r10.getId()
            java.lang.String r13 = r10.getTitle()
            java.lang.String r0 = r2.getMessage()
            if (r0 != 0) goto L_0x0120
            kotlin.jvm.internal.StringCompanionObject r0 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r0 = com.talabat.talabatcommon.extentions.StringUtils.empty(r0)
        L_0x0120:
            r14 = r0
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType r0 = r10.getVoucherOptionType()
            java.lang.String r15 = r0.name()
            float r0 = r10.getDiscountValue()
            java.lang.Float r16 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r0)
            r17 = 0
            r18 = 0
            r19 = 96
            r20 = 0
            com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker.voucherFailToApply$default(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            java.lang.String r0 = r2.getMessage()
            if (r0 != 0) goto L_0x0144
            java.lang.String r0 = ""
        L_0x0144:
            java.lang.String r3 = r10.getTitle()
            java.lang.String r4 = r10.getId()
            com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.ObservabilityManagerUtilKt.observeFailToApplyVoucherCode(r0, r3, r4)
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures$FailToApplyVoucher r0 = new com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures$FailToApplyVoucher
            com.talabat.talabatcore.exception.Failure r2 = (com.talabat.talabatcore.exception.Failure) r2
            r3 = 2
            r0.<init>(r2, r9, r3, r9)
            throw r0
        L_0x0158:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput.m10932applyVoucherbMdYcbs(com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData, java.lang.String, int, float, java.util.List, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getProductIds(VoucherData voucherData) {
        return CollectionsKt___CollectionsKt.joinToString$default(voucherData.getBounds().getProductIds(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    /* renamed from: getVoucherTargetedItemDetails-gIAlu-s  reason: not valid java name */
    private final Object m10933getVoucherTargetedItemDetailsgIAlus(VoucherData voucherData, String str) {
        Object obj;
        VoucherFailures voucherFailures;
        String str2;
        Failure dataFailure;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(this.getMenuItemDetailsUseCase.ofFoodItem(new GetVoucherItemsRequestModel(getProductIds(voucherData), str)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        if (r02 != null) {
            this.voucherRepository.unApplyAllVouchers();
            if (r02 instanceof VoucherFailures) {
                voucherFailures = (VoucherFailures) r02;
            } else {
                voucherFailures = null;
            }
            if ((voucherFailures == null || (dataFailure = voucherFailures.getDataFailure()) == null || (str2 = dataFailure.getMessage()) == null) && (str2 = r02.getMessage()) == null) {
                str2 = "";
            }
            ObservabilityManagerUtilKt.observeFailToApplyVoucherCode(str2, voucherData.getTitle(), voucherData.getId());
        }
        return obj;
    }

    private final boolean isItemMatchingVoucherCategories(CartMenuItem cartMenuItem, List<String> list, boolean z11) {
        boolean z12;
        boolean z13;
        Iterable iterable = list;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                List<String> list2 = cartMenuItem.qcCategoryIds;
                if (list2 == null || !list2.contains(str)) {
                    z13 = false;
                    continue;
                } else {
                    z13 = true;
                    continue;
                }
                if (z13) {
                    z12 = true;
                    break;
                }
            }
        }
        z12 = false;
        if (!z11) {
            return z12;
        }
        if (!z12) {
            return true;
        }
        return false;
    }

    private final void isMinimumOrderValueSatisfied(VoucherData voucherData, float f11) {
        if (f11 < voucherData.getMinOrderValue()) {
            float minOrderValue = voucherData.getMinOrderValue();
            ObservabilityManagerUtilKt.observeFailToApplyVoucherCode("orderTotalAmount is : " + f11 + " lower than voucher minOrderValue : " + minOrderValue, voucherData.getTitle(), voucherData.getId());
            throw new VoucherFailures.OrderLowerThanMinAcceptedAmount(voucherData.getMinOrderValue() - f11);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0088 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void isTargetedProductItemsInTheBasket(com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData r14, java.util.List<? extends datamodels.CartMenuItem> r15) {
        /*
            r13 = this;
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds r0 = r14.getBounds()
            boolean r1 = com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDataKt.skuIdsNotEmpty(r14)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0051
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            boolean r1 = r15 instanceof java.util.Collection
            if (r1 == 0) goto L_0x001d
            r1 = r15
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x001d
            goto L_0x0086
        L_0x001d:
            java.util.Iterator r15 = r15.iterator()
        L_0x0021:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L_0x0086
            java.lang.Object r1 = r15.next()
            datamodels.CartMenuItem r1 = (datamodels.CartMenuItem) r1
            java.lang.String r4 = r1.sku
            if (r4 == 0) goto L_0x003a
            int r4 = r4.length()
            if (r4 != 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r4 = r2
            goto L_0x003b
        L_0x003a:
            r4 = r3
        L_0x003b:
            if (r4 != 0) goto L_0x004d
            java.util.List r4 = r0.getSkuIds()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.lang.String r1 = r1.sku
            boolean r1 = kotlin.collections.CollectionsKt___CollectionsKt.contains(r4, r1)
            if (r1 == 0) goto L_0x004d
            r1 = r3
            goto L_0x004e
        L_0x004d:
            r1 = r2
        L_0x004e:
            if (r1 == 0) goto L_0x0021
            goto L_0x0085
        L_0x0051:
            boolean r1 = com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDataKt.categoryIdsNotEmpty(r14)
            if (r1 == 0) goto L_0x0085
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            boolean r1 = r15 instanceof java.util.Collection
            if (r1 == 0) goto L_0x0067
            r1 = r15
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0067
            goto L_0x0086
        L_0x0067:
            java.util.Iterator r15 = r15.iterator()
        L_0x006b:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L_0x0086
            java.lang.Object r1 = r15.next()
            datamodels.CartMenuItem r1 = (datamodels.CartMenuItem) r1
            java.util.List r4 = r0.getCategoryIds()
            boolean r5 = r0.getExcludeCategories()
            boolean r1 = r13.isItemMatchingVoucherCategories(r1, r4, r5)
            if (r1 == 0) goto L_0x006b
        L_0x0085:
            r2 = r3
        L_0x0086:
            if (r2 == 0) goto L_0x0089
            return
        L_0x0089:
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds r15 = r14.getBounds()
            java.util.List r15 = r15.getCategoryIds()
            r4 = r15
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.lang.String r5 = ","
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 62
            r12 = 0
            java.lang.String r15 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds r0 = r14.getBounds()
            java.util.List r0 = r0.getProductIds()
            r4 = r0
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.lang.String r5 = ","
            java.lang.String r0 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds r1 = r14.getBounds()
            java.util.List r1 = r1.getSkuIds()
            r4 = r1
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.lang.String r5 = ","
            java.lang.String r1 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds r2 = r14.getBounds()
            boolean r2 = r2.getExcludeCategories()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "restricted by categoryIds=["
            r4.append(r5)
            r4.append(r15)
            java.lang.String r15 = "] productIds=["
            r4.append(r15)
            r4.append(r0)
            java.lang.String r15 = "] skuIds=["
            r4.append(r15)
            r4.append(r1)
            java.lang.String r15 = "] excludeCategories="
            r4.append(r15)
            r4.append(r2)
            java.lang.String r15 = r4.toString()
            java.lang.String r0 = r14.getTitle()
            java.lang.String r14 = r14.getId()
            com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.ObservabilityManagerUtilKt.observeFailToApplyVoucherCode(r15, r0, r14)
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures$TargetedItemMissed r14 = new com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures$TargetedItemMissed
            r15 = 0
            r14.<init>(r15, r3, r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput.isTargetedProductItemsInTheBasket(com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData, java.util.List):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData r14, float r15, @org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.NotNull java.lang.String r17, @org.jetbrains.annotations.NotNull java.lang.String r18, int r19, @org.jetbrains.annotations.Nullable java.util.List<? extends datamodels.CartMenuItem> r20, int r21, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Pair<com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherItemsDisplayModel>> r22) {
        /*
            r13 = this;
            r8 = r13
            r9 = r14
            r0 = r22
            boolean r1 = r0 instanceof com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput$invoke$1
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput$invoke$1 r1 = (com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput$invoke$1) r1
            int r2 = r1.f61608m
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.f61608m = r2
            goto L_0x001c
        L_0x0017:
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput$invoke$1 r1 = new com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput$invoke$1
            r1.<init>(r13, r0)
        L_0x001c:
            r7 = r1
            java.lang.Object r0 = r7.f61606k
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.f61608m
            r11 = 1
            if (r1 == 0) goto L_0x004a
            if (r1 != r11) goto L_0x0042
            java.lang.Object r1 = r7.f61605j
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r7.f61604i
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData r2 = (com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData) r2
            java.lang.Object r3 = r7.f61603h
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput r3 = (com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput) r3
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Result r0 = (kotlin.Result) r0
            java.lang.Object r0 = r0.m6338unboximpl()
            r12 = r1
            r9 = r2
            goto L_0x0079
        L_0x0042:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r0)
            if (r20 != 0) goto L_0x0054
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x0056
        L_0x0054:
            r0 = r20
        L_0x0056:
            r13.isTargetedProductItemsInTheBasket(r14, r0)
            r13.isMinimumOrderValueSatisfied(r14, r15)
            r7.f61603h = r8
            r7.f61604i = r9
            r12 = r17
            r7.f61605j = r12
            r7.f61608m = r11
            r0 = r13
            r1 = r14
            r2 = r16
            r3 = r19
            r4 = r15
            r5 = r20
            r6 = r21
            java.lang.Object r0 = r0.m10932applyVoucherbMdYcbs(r1, r2, r3, r4, r5, r6, r7)
            if (r0 != r10) goto L_0x0078
            return r10
        L_0x0078:
            r3 = r8
        L_0x0079:
            kotlin.ResultKt.throwOnFailure(r0)
            r1 = r0
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            r1.booleanValue()
            boolean r1 = com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDataKt.isVoucherFreeItem(r9)
            if (r1 == 0) goto L_0x008f
            boolean r1 = com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDataKt.productIdsNotEmpty(r9)
            if (r1 == 0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r11 = 0
        L_0x0090:
            r1 = 0
            if (r11 == 0) goto L_0x0094
            goto L_0x0095
        L_0x0094:
            r0 = r1
        L_0x0095:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            if (r0 == 0) goto L_0x00ad
            r0.booleanValue()
            java.lang.Object r0 = r3.m10933getVoucherTargetedItemDetailsgIAlus(r9, r12)
            kotlin.ResultKt.throwOnFailure(r0)
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherItemsDisplayModel r0 = (com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherItemsDisplayModel) r0
            if (r0 == 0) goto L_0x00ad
            kotlin.Pair r1 = new kotlin.Pair
            r1.<init>(r9, r0)
            goto L_0x00b3
        L_0x00ad:
            kotlin.Pair r0 = new kotlin.Pair
            r0.<init>(r9, r1)
            r1 = r0
        L_0x00b3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput.invoke(com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData, float, java.lang.String, java.lang.String, java.lang.String, int, java.util.List, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ApplyVoucherUseCaseOutput(VoucherRepository voucherRepository2, GetMenuItemDetailsUseCase getMenuItemDetailsUseCase2, GrowthTracker growthTracker2, ITalabatFeatureFlag iTalabatFeatureFlag, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(voucherRepository2, getMenuItemDetailsUseCase2, (i11 & 4) != 0 ? GrowthTracker.INSTANCE : growthTracker2, iTalabatFeatureFlag);
    }
}
