package com.talabat.wallet.checkoutbinvoucher.domain.business.usecase;

import buisnessmodels.Cart;
import com.talabat.wallet.checkoutbinvoucher.domain.application.usecase.GetBNPLBinVoucherFeatureUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0002J?\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHBø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/talabat/wallet/checkoutbinvoucher/domain/business/usecase/GetOrderVoucherUseCase;", "", "getBinVoucherCheckEligibility", "Lcom/talabat/wallet/checkoutbinvoucher/domain/business/usecase/GetBinVoucherCheckEligibility;", "getBNPLBinVoucherFeatureUseCase", "Lcom/talabat/wallet/checkoutbinvoucher/domain/application/usecase/GetBNPLBinVoucherFeatureUseCase;", "(Lcom/talabat/wallet/checkoutbinvoucher/domain/business/usecase/GetBinVoucherCheckEligibility;Lcom/talabat/wallet/checkoutbinvoucher/domain/application/usecase/GetBNPLBinVoucherFeatureUseCase;)V", "getVoucherCode", "", "cart", "Lbuisnessmodels/Cart;", "getVoucherDiscount", "", "invoke", "Lcom/talabat/wallet/checkoutbinvoucher/domain/entity/OrderBinNumberVoucherStatus;", "binVoucherCheckEligibilityModel", "Lcom/talabat/wallet/checkoutbinvoucher/domain/entity/BinVoucherCheckEligibilityModel;", "mobileNumber", "selectedAreaId", "", "binNumber", "(Lcom/talabat/wallet/checkoutbinvoucher/domain/entity/BinVoucherCheckEligibilityModel;Ljava/lang/String;ILjava/lang/String;Lbuisnessmodels/Cart;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetOrderVoucherUseCase {
    @NotNull
    private final GetBNPLBinVoucherFeatureUseCase getBNPLBinVoucherFeatureUseCase;
    @NotNull
    private final GetBinVoucherCheckEligibility getBinVoucherCheckEligibility;

    public GetOrderVoucherUseCase(@NotNull GetBinVoucherCheckEligibility getBinVoucherCheckEligibility2, @NotNull GetBNPLBinVoucherFeatureUseCase getBNPLBinVoucherFeatureUseCase2) {
        Intrinsics.checkNotNullParameter(getBinVoucherCheckEligibility2, "getBinVoucherCheckEligibility");
        Intrinsics.checkNotNullParameter(getBNPLBinVoucherFeatureUseCase2, "getBNPLBinVoucherFeatureUseCase");
        this.getBinVoucherCheckEligibility = getBinVoucherCheckEligibility2;
        this.getBNPLBinVoucherFeatureUseCase = getBNPLBinVoucherFeatureUseCase2;
    }

    private final String getVoucherCode(Cart cart) {
        if (!cart.hasBinVoucher()) {
            return "";
        }
        String voucherCode = cart.getVoucherCode();
        Intrinsics.checkNotNullExpressionValue(voucherCode, "cart.voucherCode");
        return voucherCode;
    }

    private final float getVoucherDiscount(Cart cart) {
        if (cart.hasBinVoucher()) {
            return cart.getVoucherDiscount();
        }
        return 0.0f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull com.talabat.wallet.checkoutbinvoucher.domain.entity.BinVoucherCheckEligibilityModel r25, @org.jetbrains.annotations.Nullable java.lang.String r26, int r27, @org.jetbrains.annotations.Nullable java.lang.String r28, @org.jetbrains.annotations.Nullable buisnessmodels.Cart r29, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.wallet.checkoutbinvoucher.domain.entity.OrderBinNumberVoucherStatus> r30) {
        /*
            r24 = this;
            r0 = r24
            r1 = r30
            boolean r2 = r1 instanceof com.talabat.wallet.checkoutbinvoucher.domain.business.usecase.GetOrderVoucherUseCase$invoke$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.talabat.wallet.checkoutbinvoucher.domain.business.usecase.GetOrderVoucherUseCase$invoke$1 r2 = (com.talabat.wallet.checkoutbinvoucher.domain.business.usecase.GetOrderVoucherUseCase$invoke$1) r2
            int r3 = r2.f12526q
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f12526q = r3
            goto L_0x001c
        L_0x0017:
            com.talabat.wallet.checkoutbinvoucher.domain.business.usecase.GetOrderVoucherUseCase$invoke$1 r2 = new com.talabat.wallet.checkoutbinvoucher.domain.business.usecase.GetOrderVoucherUseCase$invoke$1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f12524o
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.f12526q
            r5 = 1
            if (r4 == 0) goto L_0x0055
            if (r4 != r5) goto L_0x004d
            int r3 = r2.f12523n
            java.lang.Object r4 = r2.f12522m
            com.talabat.wallet.checkoutbinvoucher.domain.entity.OrderBinNumberVoucherStatus r4 = (com.talabat.wallet.checkoutbinvoucher.domain.entity.OrderBinNumberVoucherStatus) r4
            java.lang.Object r6 = r2.f12521l
            buisnessmodels.Cart r6 = (buisnessmodels.Cart) r6
            java.lang.Object r7 = r2.f12520k
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r2.f12519j
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r2.f12518i
            com.talabat.wallet.checkoutbinvoucher.domain.entity.BinVoucherCheckEligibilityModel r9 = (com.talabat.wallet.checkoutbinvoucher.domain.entity.BinVoucherCheckEligibilityModel) r9
            java.lang.Object r2 = r2.f12517h
            com.talabat.wallet.checkoutbinvoucher.domain.business.usecase.GetOrderVoucherUseCase r2 = (com.talabat.wallet.checkoutbinvoucher.domain.business.usecase.GetOrderVoucherUseCase) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r21 = r3
            r18 = r7
            r17 = r8
            goto L_0x008e
        L_0x004d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0055:
            kotlin.ResultKt.throwOnFailure(r1)
            com.talabat.wallet.checkoutbinvoucher.domain.entity.OrderBinNumberVoucherStatus r4 = new com.talabat.wallet.checkoutbinvoucher.domain.entity.OrderBinNumberVoucherStatus
            r1 = 0
            r6 = 0
            r4.<init>(r1, r6)
            com.talabat.wallet.checkoutbinvoucher.domain.application.usecase.GetBNPLBinVoucherFeatureUseCase r1 = r0.getBNPLBinVoucherFeatureUseCase
            r2.f12517h = r0
            r6 = r25
            r2.f12518i = r6
            r7 = r26
            r2.f12519j = r7
            r8 = r28
            r2.f12520k = r8
            r9 = r29
            r2.f12521l = r9
            r2.f12522m = r4
            r10 = r27
            r2.f12523n = r10
            r2.f12526q = r5
            java.lang.Object r1 = r1.invoke(r2)
            if (r1 != r3) goto L_0x0082
            return r3
        L_0x0082:
            r2 = r0
            r17 = r7
            r18 = r8
            r21 = r10
            r23 = r9
            r9 = r6
            r6 = r23
        L_0x008e:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0097
            goto L_0x00d9
        L_0x0097:
            if (r6 != 0) goto L_0x009a
            goto L_0x00d9
        L_0x009a:
            com.talabat.wallet.checkoutbinvoucher.domain.business.usecase.GetBinVoucherCheckEligibility r1 = r2.getBinVoucherCheckEligibility
            boolean r1 = r1.invoke(r9)
            if (r1 == 0) goto L_0x00d9
            JsonModels.Request.BIN.BinRequest r1 = new JsonModels.Request.BIN.BinRequest
            float r11 = r6.getSubtotalForVoucher()
            datamodels.Restaurant r3 = r6.getRestaurant()
            int r12 = r3.getId()
            float r13 = r6.getDeliveryChargeForVoucher()
            boolean r14 = r6.isPromotionApplied()
            boolean r15 = r6.isFreeItemAdded()
            boolean r16 = r6.isCouponApplied()
            java.lang.String r19 = r2.getVoucherCode(r6)
            float r20 = r2.getVoucherDiscount(r6)
            datamodels.Restaurant r2 = r6.getRestaurant()
            int r22 = r2.getBranchId()
            r10 = r1
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            com.talabat.wallet.checkoutbinvoucher.domain.entity.OrderBinNumberVoucherStatus r4 = new com.talabat.wallet.checkoutbinvoucher.domain.entity.OrderBinNumberVoucherStatus
            r4.<init>(r5, r1)
        L_0x00d9:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.checkoutbinvoucher.domain.business.usecase.GetOrderVoucherUseCase.invoke(com.talabat.wallet.checkoutbinvoucher.domain.entity.BinVoucherCheckEligibilityModel, java.lang.String, int, java.lang.String, buisnessmodels.Cart, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
