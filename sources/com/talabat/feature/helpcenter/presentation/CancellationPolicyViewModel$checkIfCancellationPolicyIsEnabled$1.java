package com.talabat.feature.helpcenter.presentation;

import com.talabat.feature.cancellationpolicy.domain.model.CancellationPolicyData;
import com.talabat.feature.cancellationpolicy.domain.repo.ICancellationPolicyRepository;
import com.talabat.talabatcore.logger.LogManager;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.helpcenter.presentation.CancellationPolicyViewModel$checkIfCancellationPolicyIsEnabled$1", f = "CancellationPolicyViewModel.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
public final class CancellationPolicyViewModel$checkIfCancellationPolicyIsEnabled$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f58555h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CancellationPolicyViewModel f58556i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CancellationPolicyViewModel$checkIfCancellationPolicyIsEnabled$1(CancellationPolicyViewModel cancellationPolicyViewModel, Continuation<? super CancellationPolicyViewModel$checkIfCancellationPolicyIsEnabled$1> continuation) {
        super(2, continuation);
        this.f58556i = cancellationPolicyViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CancellationPolicyViewModel$checkIfCancellationPolicyIsEnabled$1 cancellationPolicyViewModel$checkIfCancellationPolicyIsEnabled$1 = new CancellationPolicyViewModel$checkIfCancellationPolicyIsEnabled$1(this.f58556i, continuation);
        cancellationPolicyViewModel$checkIfCancellationPolicyIsEnabled$1.L$0 = obj;
        return cancellationPolicyViewModel$checkIfCancellationPolicyIsEnabled$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CancellationPolicyViewModel$checkIfCancellationPolicyIsEnabled$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        ICancellationPolicyItemDisplayMapper iCancellationPolicyItemDisplayMapper;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f58555h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            CancellationPolicyViewModel cancellationPolicyViewModel = this.f58556i;
            Result.Companion companion = Result.Companion;
            ICancellationPolicyItemDisplayMapper access$getCancellationPolicyItemDisplayMapper$p = cancellationPolicyViewModel.cancellationPolicyItemDisplayMapper;
            ICancellationPolicyRepository access$getCancellationPolicyRepository$p = cancellationPolicyViewModel.cancellationPolicyRepository;
            this.L$0 = access$getCancellationPolicyItemDisplayMapper$p;
            this.f58555h = 1;
            obj = access$getCancellationPolicyRepository$p.getCancellationContent(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            iCancellationPolicyItemDisplayMapper = access$getCancellationPolicyItemDisplayMapper$p;
        } else if (i11 == 1) {
            iCancellationPolicyItemDisplayMapper = (ICancellationPolicyItemDisplayMapper) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl(iCancellationPolicyItemDisplayMapper.map((CancellationPolicyData) obj));
        CancellationPolicyViewModel cancellationPolicyViewModel2 = this.f58556i;
        if (Result.m6336isSuccessimpl(obj2)) {
            cancellationPolicyViewModel2._cancellationPolicyContent.postValue((CancellationPolicyDisplayModel) obj2);
        }
        Throwable r42 = Result.m6332exceptionOrNullimpl(obj2);
        if (r42 != null) {
            LogManager.logException(r42);
        }
        return Unit.INSTANCE;
    }
}
