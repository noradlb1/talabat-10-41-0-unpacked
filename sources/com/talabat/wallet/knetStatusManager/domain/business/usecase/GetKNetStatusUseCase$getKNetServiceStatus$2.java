package com.talabat.wallet.knetStatusManager.domain.business.usecase;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.wallet.knetStatusManager.domain.entity.KNetStatus;
import com.talabat.wallet.knetStatusManager.domain.entity.KNetStatusResult;
import com.talabat.wallet.knetStatusManager.domain.repository.KNetStatusManagerRepository;
import java.util.Map;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/wallet/knetStatusManager/domain/entity/KNetStatusResult;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.knetStatusManager.domain.business.usecase.GetKNetStatusUseCase$getKNetServiceStatus$2", f = "GetKNetStatusUseCase.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
public final class GetKNetStatusUseCase$getKNetServiceStatus$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super KNetStatusResult>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f12622h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ KNetStatusManagerRepository f12623i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetKNetStatusUseCase f12624j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetKNetStatusUseCase$getKNetServiceStatus$2(KNetStatusManagerRepository kNetStatusManagerRepository, GetKNetStatusUseCase getKNetStatusUseCase, Continuation<? super GetKNetStatusUseCase$getKNetServiceStatus$2> continuation) {
        super(2, continuation);
        this.f12623i = kNetStatusManagerRepository;
        this.f12624j = getKNetStatusUseCase;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GetKNetStatusUseCase$getKNetServiceStatus$2 getKNetStatusUseCase$getKNetServiceStatus$2 = new GetKNetStatusUseCase$getKNetServiceStatus$2(this.f12623i, this.f12624j, continuation);
        getKNetStatusUseCase$getKNetServiceStatus$2.L$0 = obj;
        return getKNetStatusUseCase$getKNetServiceStatus$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super KNetStatusResult> continuation) {
        return ((GetKNetStatusUseCase$getKNetServiceStatus$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object obj3;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12622h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            KNetStatusManagerRepository kNetStatusManagerRepository = this.f12623i;
            Result.Companion companion = Result.Companion;
            this.f12622h = 1;
            obj = kNetStatusManagerRepository.getKNetStatus(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((KNetStatus) obj).isServiceDown()) {
            obj3 = KNetStatusResult.KNetIsUnAvailable.INSTANCE;
        } else {
            obj3 = KNetStatusResult.KNetIsAvailable.INSTANCE;
        }
        obj2 = Result.m6329constructorimpl(obj3);
        GetKNetStatusUseCase getKNetStatusUseCase = this.f12624j;
        if (Result.m6332exceptionOrNullimpl(obj2) == null) {
            return obj2;
        }
        IObservabilityManager.DefaultImpls.trackUnExpectedScenario$default(getKNetStatusUseCase.observabilityManager, "get KNet status API failed", (Map) null, 2, (Object) null);
        return KNetStatusResult.UnAvailableKNetCheck.INSTANCE;
    }
}
