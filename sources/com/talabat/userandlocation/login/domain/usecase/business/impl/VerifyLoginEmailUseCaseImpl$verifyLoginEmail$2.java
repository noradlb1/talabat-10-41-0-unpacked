package com.talabat.userandlocation.login.domain.usecase.business.impl;

import com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginEmailUseCase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginEmailUseCaseImpl$verifyLoginEmail$2", f = "VerifyLoginEmailUseCaseImpl.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
public final class VerifyLoginEmailUseCaseImpl$verifyLoginEmail$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super VerifyLoginEmailUseCase.Result>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12369h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f12370i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ VerifyLoginEmailUseCaseImpl f12371j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerifyLoginEmailUseCaseImpl$verifyLoginEmail$2(String str, VerifyLoginEmailUseCaseImpl verifyLoginEmailUseCaseImpl, Continuation<? super VerifyLoginEmailUseCaseImpl$verifyLoginEmail$2> continuation) {
        super(2, continuation);
        this.f12370i = str;
        this.f12371j = verifyLoginEmailUseCaseImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VerifyLoginEmailUseCaseImpl$verifyLoginEmail$2(this.f12370i, this.f12371j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super VerifyLoginEmailUseCase.Result> continuation) {
        return ((VerifyLoginEmailUseCaseImpl$verifyLoginEmail$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12369h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f12370i.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return VerifyLoginEmailUseCase.Result.EmptyEmail.INSTANCE;
            }
            if (!VerifyLoginEmailUseCaseImpl.Companion.getEMAIL_PATTERN().matcher(this.f12370i).matches()) {
                return VerifyLoginEmailUseCase.Result.InvalidEmailFormat.INSTANCE;
            }
            VerifyLoginEmailUseCaseImpl verifyLoginEmailUseCaseImpl = this.f12371j;
            String str = this.f12370i;
            this.f12369h = 1;
            obj = verifyLoginEmailUseCaseImpl.checkEmailExists(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return (VerifyLoginEmailUseCase.Result) obj;
    }
}
