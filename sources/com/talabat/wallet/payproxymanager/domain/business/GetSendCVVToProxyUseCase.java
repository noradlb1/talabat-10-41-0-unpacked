package com.talabat.wallet.payproxymanager.domain.business;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.wallet.payproxymanager.domain.PayProxyManagerRepository;
import com.talabat.wallet.payproxymanager.domain.application.usecase.GetPayProxyCVVFeatureFlagUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eHBø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/payproxymanager/domain/business/GetSendCVVToProxyUseCase;", "", "getPayProxyCVVFeatureFlagUseCase", "Lcom/talabat/wallet/payproxymanager/domain/application/usecase/GetPayProxyCVVFeatureFlagUseCase;", "payProxyManagerRepository", "Lcom/talabat/wallet/payproxymanager/domain/PayProxyManagerRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/wallet/payproxymanager/domain/application/usecase/GetPayProxyCVVFeatureFlagUseCase;Lcom/talabat/wallet/payproxymanager/domain/PayProxyManagerRepository;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "invoke", "Lcom/talabat/wallet/payproxymanager/domain/entity/PayProxyCVVResult;", "payProxyCVVRequestModel", "Lcom/talabat/wallet/payproxymanager/data/remote/dto/request/PayProxyCVVRequestModel;", "(Lcom/talabat/wallet/payproxymanager/data/remote/dto/request/PayProxyCVVRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetSendCVVToProxyUseCase {
    @NotNull
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final GetPayProxyCVVFeatureFlagUseCase getPayProxyCVVFeatureFlagUseCase;
    @NotNull
    private final IObservabilityManager observabilityManager;
    /* access modifiers changed from: private */
    @NotNull
    public final PayProxyManagerRepository payProxyManagerRepository;

    public GetSendCVVToProxyUseCase(@NotNull GetPayProxyCVVFeatureFlagUseCase getPayProxyCVVFeatureFlagUseCase2, @NotNull PayProxyManagerRepository payProxyManagerRepository2, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(getPayProxyCVVFeatureFlagUseCase2, "getPayProxyCVVFeatureFlagUseCase");
        Intrinsics.checkNotNullParameter(payProxyManagerRepository2, "payProxyManagerRepository");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.getPayProxyCVVFeatureFlagUseCase = getPayProxyCVVFeatureFlagUseCase2;
        this.payProxyManagerRepository = payProxyManagerRepository2;
        this.dispatcher = coroutineDispatcher;
        this.observabilityManager = iObservabilityManager;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull com.talabat.wallet.payproxymanager.data.remote.dto.request.PayProxyCVVRequestModel r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.wallet.payproxymanager.domain.entity.PayProxyCVVResult> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.talabat.wallet.payproxymanager.domain.business.GetSendCVVToProxyUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.wallet.payproxymanager.domain.business.GetSendCVVToProxyUseCase$invoke$1 r0 = (com.talabat.wallet.payproxymanager.domain.business.GetSendCVVToProxyUseCase$invoke$1) r0
            int r1 = r0.f12641k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12641k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.wallet.payproxymanager.domain.business.GetSendCVVToProxyUseCase$invoke$1 r0 = new com.talabat.wallet.payproxymanager.domain.business.GetSendCVVToProxyUseCase$invoke$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f12639i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12641k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r6 = r0.f12638h
            com.talabat.wallet.payproxymanager.domain.business.GetSendCVVToProxyUseCase r6 = (com.talabat.wallet.payproxymanager.domain.business.GetSendCVVToProxyUseCase) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004c
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = r5.dispatcher
            com.talabat.wallet.payproxymanager.domain.business.GetSendCVVToProxyUseCase$invoke$2 r2 = new com.talabat.wallet.payproxymanager.domain.business.GetSendCVVToProxyUseCase$invoke$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.f12638h = r5
            r0.f12641k = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)
            if (r7 != r1) goto L_0x004b
            return r1
        L_0x004b:
            r6 = r5
        L_0x004c:
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r7 = r7.m6338unboximpl()
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r7)
            if (r0 != 0) goto L_0x0059
            goto L_0x0079
        L_0x0059:
            com.talabat.core.observabilityNew.domain.IObservabilityManager r6 = r6.observabilityManager
            kotlin.Pair[] r7 = new kotlin.Pair[r3]
            java.lang.String r0 = r0.getMessage()
            if (r0 != 0) goto L_0x0065
            java.lang.String r0 = ""
        L_0x0065:
            java.lang.String r1 = "errorMessage"
            kotlin.Pair r0 = kotlin.TuplesKt.to(r1, r0)
            r1 = 0
            r7[r1] = r0
            java.util.Map r7 = kotlin.collections.MapsKt__MapsKt.mutableMapOf(r7)
            java.lang.String r0 = "send cvv to proxy server failed"
            r6.trackUnExpectedScenario(r0, r7)
            com.talabat.wallet.payproxymanager.domain.entity.PayProxyCVVResult$CVVServerError r7 = com.talabat.wallet.payproxymanager.domain.entity.PayProxyCVVResult.CVVServerError.INSTANCE
        L_0x0079:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.payproxymanager.domain.business.GetSendCVVToProxyUseCase.invoke(com.talabat.wallet.payproxymanager.data.remote.dto.request.PayProxyCVVRequestModel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetSendCVVToProxyUseCase(GetPayProxyCVVFeatureFlagUseCase getPayProxyCVVFeatureFlagUseCase2, PayProxyManagerRepository payProxyManagerRepository2, CoroutineDispatcher coroutineDispatcher, IObservabilityManager iObservabilityManager, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(getPayProxyCVVFeatureFlagUseCase2, payProxyManagerRepository2, (i11 & 4) != 0 ? Dispatchers.getIO() : coroutineDispatcher, iObservabilityManager);
    }
}
