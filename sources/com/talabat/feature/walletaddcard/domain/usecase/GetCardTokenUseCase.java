package com.talabat.feature.walletaddcard.domain.usecase;

import com.talabat.feature.walletaddcard.domain.WalletAddCardRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\b\u001a\u00020\tHBø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/walletaddcard/domain/usecase/GetCardTokenUseCase;", "", "repository", "Lcom/talabat/feature/walletaddcard/domain/WalletAddCardRepository;", "(Lcom/talabat/feature/walletaddcard/domain/WalletAddCardRepository;)V", "invoke", "", "", "card", "Lcom/talabat/feature/walletaddcard/domain/model/BankCard;", "(Lcom/talabat/feature/walletaddcard/domain/model/BankCard;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_wallet-add-card_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetCardTokenUseCase {
    @NotNull
    private final WalletAddCardRepository repository;

    @Inject
    public GetCardTokenUseCase(@NotNull WalletAddCardRepository walletAddCardRepository) {
        Intrinsics.checkNotNullParameter(walletAddCardRepository, "repository");
        this.repository = walletAddCardRepository;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull com.talabat.feature.walletaddcard.domain.model.BankCard r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.talabat.feature.walletaddcard.domain.usecase.GetCardTokenUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.talabat.feature.walletaddcard.domain.usecase.GetCardTokenUseCase$invoke$1 r0 = (com.talabat.feature.walletaddcard.domain.usecase.GetCardTokenUseCase$invoke$1) r0
            int r1 = r0.f59432j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59432j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.walletaddcard.domain.usecase.GetCardTokenUseCase$invoke$1 r0 = new com.talabat.feature.walletaddcard.domain.usecase.GetCardTokenUseCase$invoke$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f59430h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59432j
            java.lang.String r3 = "cardToken"
            java.lang.String r4 = "hasError"
            r5 = 2
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r7) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ Exception -> 0x005e }
            goto L_0x0045
        L_0x002f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r10)
            com.talabat.feature.walletaddcard.domain.WalletAddCardRepository r10 = r8.repository     // Catch:{ Exception -> 0x005e }
            r0.f59432j = r7     // Catch:{ Exception -> 0x005e }
            java.lang.Object r10 = r10.generateCardToken(r9, r0)     // Catch:{ Exception -> 0x005e }
            if (r10 != r1) goto L_0x0045
            return r1
        L_0x0045:
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x005e }
            kotlin.Pair[] r9 = new kotlin.Pair[r5]     // Catch:{ Exception -> 0x005e }
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)     // Catch:{ Exception -> 0x005e }
            kotlin.Pair r0 = kotlin.TuplesKt.to(r4, r0)     // Catch:{ Exception -> 0x005e }
            r9[r6] = r0     // Catch:{ Exception -> 0x005e }
            kotlin.Pair r10 = kotlin.TuplesKt.to(r3, r10)     // Catch:{ Exception -> 0x005e }
            r9[r7] = r10     // Catch:{ Exception -> 0x005e }
            java.util.Map r9 = kotlin.collections.MapsKt__MapsKt.mapOf(r9)     // Catch:{ Exception -> 0x005e }
            goto L_0x0076
        L_0x005e:
            kotlin.Pair[] r9 = new kotlin.Pair[r5]
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            kotlin.Pair r10 = kotlin.TuplesKt.to(r4, r10)
            r9[r6] = r10
            java.lang.String r10 = ""
            kotlin.Pair r10 = kotlin.TuplesKt.to(r3, r10)
            r9[r7] = r10
            java.util.Map r9 = kotlin.collections.MapsKt__MapsKt.mapOf(r9)
        L_0x0076:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.walletaddcard.domain.usecase.GetCardTokenUseCase.invoke(com.talabat.feature.walletaddcard.domain.model.BankCard, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
