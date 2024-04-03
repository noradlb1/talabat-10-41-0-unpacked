package com.talabat.wallet.knetStatusManager.domain.business.usecase;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.wallet.knetStatusManager.domain.application.usecase.IsKNetStatusCheckEnabledUseCase;
import com.talabat.wallet.knetStatusManager.domain.entity.KNetStatusResult;
import com.talabat.wallet.knetStatusManager.domain.repository.KNetStatusManagerRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eHBø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/knetStatusManager/domain/business/usecase/GetKNetStatusUseCase;", "", "isKNetStatusCheckEnabled", "Lcom/talabat/wallet/knetStatusManager/domain/application/usecase/IsKNetStatusCheckEnabledUseCase;", "kNetStatusManagerRepository", "Lcom/talabat/wallet/knetStatusManager/domain/repository/KNetStatusManagerRepository;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/wallet/knetStatusManager/domain/application/usecase/IsKNetStatusCheckEnabledUseCase;Lcom/talabat/wallet/knetStatusManager/domain/repository/KNetStatusManagerRepository;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "getKNetServiceStatus", "Lcom/talabat/wallet/knetStatusManager/domain/entity/KNetStatusResult;", "(Lcom/talabat/wallet/knetStatusManager/domain/repository/KNetStatusManagerRepository;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "isDebitCardAccepted", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetKNetStatusUseCase {
    @NotNull
    private final IsKNetStatusCheckEnabledUseCase isKNetStatusCheckEnabled;
    @NotNull
    private final KNetStatusManagerRepository kNetStatusManagerRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final IObservabilityManager observabilityManager;

    public GetKNetStatusUseCase(@NotNull IsKNetStatusCheckEnabledUseCase isKNetStatusCheckEnabledUseCase, @NotNull KNetStatusManagerRepository kNetStatusManagerRepository2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(isKNetStatusCheckEnabledUseCase, "isKNetStatusCheckEnabled");
        Intrinsics.checkNotNullParameter(kNetStatusManagerRepository2, "kNetStatusManagerRepository");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.isKNetStatusCheckEnabled = isKNetStatusCheckEnabledUseCase;
        this.kNetStatusManagerRepository = kNetStatusManagerRepository2;
        this.observabilityManager = iObservabilityManager;
    }

    @Nullable
    public final Object getKNetServiceStatus(@NotNull KNetStatusManagerRepository kNetStatusManagerRepository2, @NotNull Continuation<? super KNetStatusResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GetKNetStatusUseCase$getKNetServiceStatus$2(kNetStatusManagerRepository2, this, (Continuation<? super GetKNetStatusUseCase$getKNetServiceStatus$2>) null), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(boolean r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.wallet.knetStatusManager.domain.entity.KNetStatusResult> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.talabat.wallet.knetStatusManager.domain.business.usecase.GetKNetStatusUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.wallet.knetStatusManager.domain.business.usecase.GetKNetStatusUseCase$invoke$1 r0 = (com.talabat.wallet.knetStatusManager.domain.business.usecase.GetKNetStatusUseCase$invoke$1) r0
            int r1 = r0.f12628k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12628k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.wallet.knetStatusManager.domain.business.usecase.GetKNetStatusUseCase$invoke$1 r0 = new com.talabat.wallet.knetStatusManager.domain.business.usecase.GetKNetStatusUseCase$invoke$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f12626i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12628k
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0068
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.f12625h
            com.talabat.wallet.knetStatusManager.domain.business.usecase.GetKNetStatusUseCase r6 = (com.talabat.wallet.knetStatusManager.domain.business.usecase.GetKNetStatusUseCase) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0052
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r7)
            if (r6 != 0) goto L_0x0044
            com.talabat.wallet.knetStatusManager.domain.entity.KNetStatusResult$UnAvailableKNetCheck r6 = com.talabat.wallet.knetStatusManager.domain.entity.KNetStatusResult.UnAvailableKNetCheck.INSTANCE
            goto L_0x006b
        L_0x0044:
            com.talabat.wallet.knetStatusManager.domain.application.usecase.IsKNetStatusCheckEnabledUseCase r6 = r5.isKNetStatusCheckEnabled
            r0.f12625h = r5
            r0.f12628k = r4
            java.lang.Object r7 = r6.invoke(r0)
            if (r7 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r6 = r5
        L_0x0052:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0069
            com.talabat.wallet.knetStatusManager.domain.repository.KNetStatusManagerRepository r7 = r6.kNetStatusManagerRepository
            r2 = 0
            r0.f12625h = r2
            r0.f12628k = r3
            java.lang.Object r7 = r6.getKNetServiceStatus(r7, r0)
            if (r7 != r1) goto L_0x0068
            return r1
        L_0x0068:
            return r7
        L_0x0069:
            com.talabat.wallet.knetStatusManager.domain.entity.KNetStatusResult$UnAvailableKNetCheck r6 = com.talabat.wallet.knetStatusManager.domain.entity.KNetStatusResult.UnAvailableKNetCheck.INSTANCE
        L_0x006b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.knetStatusManager.domain.business.usecase.GetKNetStatusUseCase.invoke(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
