package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006Jo\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u0011HBø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/AddVoucherCodeUseCase;", "", "redeemVoucherCodeUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/RedeemVoucherCodeUseCase;", "applyVoucherUseCaseOutput", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/ApplyVoucherUseCaseOutput;", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/RedeemVoucherCodeUseCase;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/ApplyVoucherUseCaseOutput;)V", "invoke", "Lkotlin/Pair;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherItemsDisplayModel;", "orderTotalAmount", "", "voucherCode", "", "brandId", "countryCode", "", "areaId", "branchId", "groceryVendorId", "cartItems", "", "Ldatamodels/CartMenuItem;", "verticalId", "(FLjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/util/List;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddVoucherCodeUseCase {
    @NotNull
    private final ApplyVoucherUseCaseOutput applyVoucherUseCaseOutput;
    @NotNull
    private final RedeemVoucherCodeUseCase redeemVoucherCodeUseCase;

    public AddVoucherCodeUseCase(@NotNull RedeemVoucherCodeUseCase redeemVoucherCodeUseCase2, @NotNull ApplyVoucherUseCaseOutput applyVoucherUseCaseOutput2) {
        Intrinsics.checkNotNullParameter(redeemVoucherCodeUseCase2, "redeemVoucherCodeUseCase");
        Intrinsics.checkNotNullParameter(applyVoucherUseCaseOutput2, "applyVoucherUseCaseOutput");
        this.redeemVoucherCodeUseCase = redeemVoucherCodeUseCase2;
        this.applyVoucherUseCaseOutput = applyVoucherUseCaseOutput2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e1 A[Catch:{ all -> 0x0031 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(float r17, @org.jetbrains.annotations.NotNull java.lang.String r18, @org.jetbrains.annotations.NotNull java.lang.String r19, int r20, int r21, @org.jetbrains.annotations.NotNull java.lang.String r22, @org.jetbrains.annotations.NotNull java.lang.String r23, @org.jetbrains.annotations.Nullable java.util.List<? extends datamodels.CartMenuItem> r24, int r25, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Pair<com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherItemsDisplayModel>> r26) {
        /*
            r16 = this;
            r1 = r16
            r0 = r26
            boolean r2 = r0 instanceof com.talabat.talabatcommon.feature.vouchers.loyalty.domain.AddVoucherCodeUseCase$invoke$1
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.AddVoucherCodeUseCase$invoke$1 r2 = (com.talabat.talabatcommon.feature.vouchers.loyalty.domain.AddVoucherCodeUseCase$invoke$1) r2
            int r3 = r2.f61595s
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f61595s = r3
            goto L_0x001c
        L_0x0017:
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.AddVoucherCodeUseCase$invoke$1 r2 = new com.talabat.talabatcommon.feature.vouchers.loyalty.domain.AddVoucherCodeUseCase$invoke$1
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.f61593q
            java.lang.Object r13 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.f61595s
            r14 = 2
            r4 = 1
            if (r3 == 0) goto L_0x005e
            if (r3 == r4) goto L_0x003c
            if (r3 != r14) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0031 }
            goto L_0x00e2
        L_0x0031:
            r0 = move-exception
            goto L_0x00e9
        L_0x0034:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x003c:
            int r3 = r2.f61592p
            int r4 = r2.f61591o
            float r5 = r2.f61590n
            java.lang.Object r6 = r2.f61589m
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r2.f61588l
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r2.f61587k
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r2.f61586j
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r2.f61585i
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r2.f61584h
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.AddVoucherCodeUseCase r11 = (com.talabat.talabatcommon.feature.vouchers.loyalty.domain.AddVoucherCodeUseCase) r11
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00ad
        L_0x005e:
            kotlin.ResultKt.throwOnFailure(r0)
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase r3 = r1.redeemVoucherCodeUseCase
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r21)
            r8 = 0
            r9 = 0
            r11 = 48
            r2.f61584h = r1
            r0 = r18
            r2.f61585i = r0
            r15 = r19
            r2.f61586j = r15
            r10 = r22
            r2.f61587k = r10
            r6 = r23
            r2.f61588l = r6
            r5 = r24
            r2.f61589m = r5
            r14 = r17
            r2.f61590n = r14
            r12 = r21
            r2.f61591o = r12
            r12 = r25
            r2.f61592p = r12
            r2.f61595s = r4
            r4 = r18
            r5 = r19
            r6 = r20
            r10 = r2
            r12 = 0
            java.lang.Object r3 = com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase.invoke$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            if (r3 != r13) goto L_0x009e
            return r13
        L_0x009e:
            r4 = r21
            r8 = r22
            r7 = r23
            r6 = r24
            r10 = r0
            r11 = r1
            r0 = r3
            r5 = r14
            r9 = r15
            r3 = r25
        L_0x00ad:
            com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModel r0 = (com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModel) r0
            kotlin.Result$Companion r12 = kotlin.Result.Companion     // Catch:{ all -> 0x0031 }
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput r11 = r11.applyVoucherUseCaseOutput     // Catch:{ all -> 0x0031 }
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData r0 = com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModelKt.voucherData(r0, r10)     // Catch:{ all -> 0x0031 }
            r10 = 0
            r2.f61584h = r10     // Catch:{ all -> 0x0031 }
            r2.f61585i = r10     // Catch:{ all -> 0x0031 }
            r2.f61586j = r10     // Catch:{ all -> 0x0031 }
            r2.f61587k = r10     // Catch:{ all -> 0x0031 }
            r2.f61588l = r10     // Catch:{ all -> 0x0031 }
            r2.f61589m = r10     // Catch:{ all -> 0x0031 }
            r10 = 2
            r2.f61595s = r10     // Catch:{ all -> 0x0031 }
            r17 = r11
            r18 = r0
            r19 = r5
            r20 = r9
            r21 = r8
            r22 = r7
            r23 = r4
            r24 = r6
            r25 = r3
            r26 = r2
            java.lang.Object r0 = r17.invoke(r18, r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ all -> 0x0031 }
            if (r0 != r13) goto L_0x00e2
            return r13
        L_0x00e2:
            kotlin.Pair r0 = (kotlin.Pair) r0     // Catch:{ all -> 0x0031 }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x0031 }
            goto L_0x00f3
        L_0x00e9:
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x00f3:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Pair r0 = (kotlin.Pair) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.vouchers.loyalty.domain.AddVoucherCodeUseCase.invoke(float, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, java.util.List, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
