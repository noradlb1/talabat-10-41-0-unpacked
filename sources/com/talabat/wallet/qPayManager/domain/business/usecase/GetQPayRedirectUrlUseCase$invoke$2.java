package com.talabat.wallet.qPayManager.domain.business.usecase;

import com.talabat.wallet.qPayManager.data.remote.dto.QPayRedirectUrlRequest;
import com.talabat.wallet.qPayManager.domain.entity.QPayRedirectUrlResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/wallet/qPayManager/domain/entity/QPayRedirectUrlResult;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.qPayManager.domain.business.usecase.GetQPayRedirectUrlUseCase$invoke$2", f = "GetQPayRedirectUrlUseCase.kt", i = {0}, l = {23}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u2d2"}, s = {"L$1"})
public final class GetQPayRedirectUrlUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super QPayRedirectUrlResult>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f12660h;

    /* renamed from: i  reason: collision with root package name */
    public int f12661i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f12662j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ GetQPayRedirectUrlUseCase f12663k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ QPayRedirectUrlRequest f12664l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetQPayRedirectUrlUseCase$invoke$2(String str, GetQPayRedirectUrlUseCase getQPayRedirectUrlUseCase, QPayRedirectUrlRequest qPayRedirectUrlRequest, Continuation<? super GetQPayRedirectUrlUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f12662j = str;
        this.f12663k = getQPayRedirectUrlUseCase;
        this.f12664l = qPayRedirectUrlRequest;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GetQPayRedirectUrlUseCase$invoke$2 getQPayRedirectUrlUseCase$invoke$2 = new GetQPayRedirectUrlUseCase$invoke$2(this.f12662j, this.f12663k, this.f12664l, continuation);
        getQPayRedirectUrlUseCase$invoke$2.L$0 = obj;
        return getQPayRedirectUrlUseCase$invoke$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super QPayRedirectUrlResult> continuation) {
        return ((GetQPayRedirectUrlUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.f12661i
            r2 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            java.lang.Object r0 = r13.f12660h
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r0 = r13.L$0
            com.talabat.wallet.qPayManager.domain.business.usecase.GetQPayRedirectUrlUseCase r0 = (com.talabat.wallet.qPayManager.domain.business.usecase.GetQPayRedirectUrlUseCase) r0
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x005f }
            goto L_0x0041
        L_0x0017:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.Object r14 = r13.L$0
            kotlinx.coroutines.CoroutineScope r14 = (kotlinx.coroutines.CoroutineScope) r14
            java.lang.String r1 = r13.f12662j
            com.talabat.wallet.qPayManager.domain.business.usecase.GetQPayRedirectUrlUseCase r3 = r13.f12663k
            com.talabat.wallet.qPayManager.data.remote.dto.QPayRedirectUrlRequest r4 = r13.f12664l
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x005f }
            if (r1 == 0) goto L_0x004d
            com.talabat.wallet.qPayManager.domain.repository.QPayManagerRepository r5 = r3.qPayManagerRepository     // Catch:{ all -> 0x005f }
            r13.L$0 = r3     // Catch:{ all -> 0x005f }
            r13.f12660h = r14     // Catch:{ all -> 0x005f }
            r13.f12661i = r2     // Catch:{ all -> 0x005f }
            java.lang.Object r14 = r5.getQPayRedirectUrl(r1, r4, r13)     // Catch:{ all -> 0x005f }
            if (r14 != r0) goto L_0x0041
            return r0
        L_0x0041:
            com.talabat.wallet.qPayManager.domain.entity.QPayRedirectUrl r14 = (com.talabat.wallet.qPayManager.domain.entity.QPayRedirectUrl) r14     // Catch:{ all -> 0x005f }
            com.talabat.wallet.qPayManager.domain.entity.QPayRedirectUrlResult$RedirectToQPayThreeDSUrl r0 = new com.talabat.wallet.qPayManager.domain.entity.QPayRedirectUrlResult$RedirectToQPayThreeDSUrl     // Catch:{ all -> 0x005f }
            java.lang.String r14 = r14.getRedirectUrl()     // Catch:{ all -> 0x005f }
            r0.<init>(r14)     // Catch:{ all -> 0x005f }
            goto L_0x005a
        L_0x004d:
            com.talabat.core.observabilityNew.domain.IObservabilityManager r14 = r3.observabilityManager     // Catch:{ all -> 0x005f }
            java.lang.String r0 = "QPay payment url is null"
            r1 = 2
            r2 = 0
            com.talabat.core.observabilityNew.domain.IObservabilityManager.DefaultImpls.trackUnExpectedScenario$default(r14, r0, r2, r1, r2)     // Catch:{ all -> 0x005f }
            com.talabat.wallet.qPayManager.domain.entity.QPayRedirectUrlResult$Error r0 = com.talabat.wallet.qPayManager.domain.entity.QPayRedirectUrlResult.Error.INSTANCE     // Catch:{ all -> 0x005f }
        L_0x005a:
            java.lang.Object r14 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x005f }
            goto L_0x006a
        L_0x005f:
            r14 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r14 = kotlin.ResultKt.createFailure(r14)
            java.lang.Object r14 = kotlin.Result.m6329constructorimpl(r14)
        L_0x006a:
            com.talabat.wallet.qPayManager.domain.business.usecase.GetQPayRedirectUrlUseCase r0 = r13.f12663k
            java.lang.Throwable r1 = kotlin.Result.m6332exceptionOrNullimpl(r14)
            if (r1 != 0) goto L_0x0073
            goto L_0x009e
        L_0x0073:
            boolean r14 = r1 instanceof com.talabat.wallet.qPayManager.data.remote.dto.NoInternetException
            if (r14 == 0) goto L_0x008a
            com.talabat.core.observabilityNew.domain.IObservabilityManager r1 = r0.observabilityManager
            com.talabat.core.observabilityNew.domain.common.ApiStatus r14 = com.talabat.core.observabilityNew.domain.common.ApiStatus.NETWORK_FAILURE
            java.lang.String r3 = r14.getValue()
            java.lang.String r2 = "get QPay redirect URL"
            r4 = 0
            r5 = 4
            r6 = 0
            com.talabat.core.observabilityNew.domain.IObservabilityManager.DefaultImpls.trackEvent$default((com.talabat.core.observabilityNew.domain.IObservabilityManager) r1, (java.lang.String) r2, (java.lang.String) r3, (java.util.Map) r4, (int) r5, (java.lang.Object) r6)
            goto L_0x009c
        L_0x008a:
            com.talabat.core.observabilityNew.domain.IObservabilityManager r7 = r0.observabilityManager
            com.talabat.core.observabilityNew.domain.common.ApiStatus r14 = com.talabat.core.observabilityNew.domain.common.ApiStatus.FAILURE
            java.lang.String r9 = r14.getValue()
            java.lang.String r8 = "get QPay redirect URL"
            r10 = 0
            r11 = 4
            r12 = 0
            com.talabat.core.observabilityNew.domain.IObservabilityManager.DefaultImpls.trackEvent$default((com.talabat.core.observabilityNew.domain.IObservabilityManager) r7, (java.lang.String) r8, (java.lang.String) r9, (java.util.Map) r10, (int) r11, (java.lang.Object) r12)
        L_0x009c:
            com.talabat.wallet.qPayManager.domain.entity.QPayRedirectUrlResult$Error r14 = com.talabat.wallet.qPayManager.domain.entity.QPayRedirectUrlResult.Error.INSTANCE
        L_0x009e:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.qPayManager.domain.business.usecase.GetQPayRedirectUrlUseCase$invoke$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
