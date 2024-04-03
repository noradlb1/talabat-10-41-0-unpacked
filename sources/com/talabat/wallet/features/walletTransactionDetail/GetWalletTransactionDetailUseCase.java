package com.talabat.wallet.features.walletTransactionDetail;

import com.talabat.wallet.features.walletTransactionDetail.repository.WalletTransactionDetailRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/wallet/features/walletTransactionDetail/GetWalletTransactionDetailUseCase;", "", "walletTransactionDetailRepository", "Lcom/talabat/wallet/features/walletTransactionDetail/repository/WalletTransactionDetailRepository;", "(Lcom/talabat/wallet/features/walletTransactionDetail/repository/WalletTransactionDetailRepository;)V", "invoke", "Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetail;", "walletTransactionDetailParam", "Lcom/talabat/wallet/features/walletTransactionDetail/WalletTransactionDetailParam;", "(Lcom/talabat/wallet/features/walletTransactionDetail/WalletTransactionDetailParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetWalletTransactionDetailUseCase {
    @NotNull
    private final WalletTransactionDetailRepository walletTransactionDetailRepository;

    public GetWalletTransactionDetailUseCase(@NotNull WalletTransactionDetailRepository walletTransactionDetailRepository2) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailRepository2, "walletTransactionDetailRepository");
        this.walletTransactionDetailRepository = walletTransactionDetailRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull com.talabat.wallet.features.walletTransactionDetail.WalletTransactionDetailParam r21, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetail> r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r22
            boolean r2 = r1 instanceof com.talabat.wallet.features.walletTransactionDetail.GetWalletTransactionDetailUseCase$invoke$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.talabat.wallet.features.walletTransactionDetail.GetWalletTransactionDetailUseCase$invoke$1 r2 = (com.talabat.wallet.features.walletTransactionDetail.GetWalletTransactionDetailUseCase$invoke$1) r2
            int r3 = r2.f12594j
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f12594j = r3
            goto L_0x001c
        L_0x0017:
            com.talabat.wallet.features.walletTransactionDetail.GetWalletTransactionDetailUseCase$invoke$1 r2 = new com.talabat.wallet.features.walletTransactionDetail.GetWalletTransactionDetailUseCase$invoke$1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f12592h
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.f12594j
            r5 = 1
            if (r4 == 0) goto L_0x0035
            if (r4 != r5) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x004b
        L_0x002d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r1)
            com.talabat.wallet.features.walletTransactionDetail.repository.WalletTransactionDetailRepository r1 = r0.walletTransactionDetailRepository
            int r4 = r21.getTransactionId()
            int r6 = r21.getTransactionType()
            r2.f12594j = r5
            java.lang.Object r1 = r1.getWalletTransactionDetail(r6, r4, r2)
            if (r1 != r3) goto L_0x004b
            return r3
        L_0x004b:
            com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetail r1 = (com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetail) r1
            if (r1 != 0) goto L_0x006a
            com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetail r1 = new com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetail
            r2 = r1
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 32767(0x7fff, float:4.5916E-41)
            r19 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
        L_0x006a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.features.walletTransactionDetail.GetWalletTransactionDetailUseCase.invoke(com.talabat.wallet.features.walletTransactionDetail.WalletTransactionDetailParam, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
