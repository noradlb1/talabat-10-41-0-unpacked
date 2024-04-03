package com.talabat.wallet.payproxymanager.domain.business;

import com.talabat.wallet.payproxymanager.data.remote.dto.request.PayProxyCVVRequestModel;
import com.talabat.wallet.payproxymanager.domain.PayProxyManagerRepository;
import com.talabat.wallet.payproxymanager.domain.application.usecase.GetPayProxyCVVFeatureFlagUseCase;
import com.talabat.wallet.payproxymanager.domain.entity.PayProxyCVVResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "Lcom/talabat/wallet/payproxymanager/domain/entity/PayProxyCVVResult;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.payproxymanager.domain.business.GetSendCVVToProxyUseCase$invoke$2", f = "GetSendCVVToProxyUseCase.kt", i = {}, l = {23, 24}, m = "invokeSuspend", n = {}, s = {})
public final class GetSendCVVToProxyUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends PayProxyCVVResult>>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f12642h;

    /* renamed from: i  reason: collision with root package name */
    public int f12643i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetSendCVVToProxyUseCase f12644j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ PayProxyCVVRequestModel f12645k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetSendCVVToProxyUseCase$invoke$2(GetSendCVVToProxyUseCase getSendCVVToProxyUseCase, PayProxyCVVRequestModel payProxyCVVRequestModel, Continuation<? super GetSendCVVToProxyUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f12644j = getSendCVVToProxyUseCase;
        this.f12645k = payProxyCVVRequestModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GetSendCVVToProxyUseCase$invoke$2 getSendCVVToProxyUseCase$invoke$2 = new GetSendCVVToProxyUseCase$invoke$2(this.f12644j, this.f12645k, continuation);
        getSendCVVToProxyUseCase$invoke$2.L$0 = obj;
        return getSendCVVToProxyUseCase$invoke$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Result<? extends PayProxyCVVResult>> continuation) {
        return ((GetSendCVVToProxyUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object obj3;
        GetSendCVVToProxyUseCase getSendCVVToProxyUseCase;
        PayProxyCVVRequestModel payProxyCVVRequestModel;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12643i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            GetSendCVVToProxyUseCase getSendCVVToProxyUseCase2 = this.f12644j;
            payProxyCVVRequestModel = this.f12645k;
            Result.Companion companion = Result.Companion;
            GetPayProxyCVVFeatureFlagUseCase access$getGetPayProxyCVVFeatureFlagUseCase$p = getSendCVVToProxyUseCase2.getPayProxyCVVFeatureFlagUseCase;
            this.L$0 = getSendCVVToProxyUseCase2;
            this.f12642h = payProxyCVVRequestModel;
            this.f12643i = 1;
            Object invoke = access$getGetPayProxyCVVFeatureFlagUseCase$p.invoke(this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj4 = invoke;
            getSendCVVToProxyUseCase = getSendCVVToProxyUseCase2;
            obj = obj4;
        } else if (i11 == 1) {
            payProxyCVVRequestModel = (PayProxyCVVRequestModel) this.f12642h;
            getSendCVVToProxyUseCase = (GetSendCVVToProxyUseCase) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            try {
                ResultKt.throwOnFailure(obj);
                obj3 = (PayProxyCVVResult) obj;
                obj2 = Result.m6329constructorimpl(obj3);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            return Result.m6328boximpl(obj2);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            PayProxyManagerRepository access$getPayProxyManagerRepository$p = getSendCVVToProxyUseCase.payProxyManagerRepository;
            this.L$0 = null;
            this.f12642h = null;
            this.f12643i = 2;
            obj = access$getPayProxyManagerRepository$p.sendCVVToPayProxy(payProxyCVVRequestModel, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj3 = (PayProxyCVVResult) obj;
            obj2 = Result.m6329constructorimpl(obj3);
            return Result.m6328boximpl(obj2);
        }
        obj3 = PayProxyCVVResult.CVVIsUnAvailable.INSTANCE;
        obj2 = Result.m6329constructorimpl(obj3);
        return Result.m6328boximpl(obj2);
    }
}
