package com.talabat.userandlocation.login.domain.usecase.business.impl;

import com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginPasswordUseCaseImpl$verifyLoginPassword$2", f = "VerifyLoginPasswordUseCaseImpl.kt", i = {}, l = {30, 31}, m = "invokeSuspend", n = {}, s = {})
public final class VerifyLoginPasswordUseCaseImpl$verifyLoginPassword$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super VerifyLoginPasswordUseCase.Result>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12378h;

    /* renamed from: i  reason: collision with root package name */
    public int f12379i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f12380j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ VerifyLoginPasswordUseCaseImpl f12381k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f12382l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerifyLoginPasswordUseCaseImpl$verifyLoginPassword$2(String str, VerifyLoginPasswordUseCaseImpl verifyLoginPasswordUseCaseImpl, String str2, Continuation<? super VerifyLoginPasswordUseCaseImpl$verifyLoginPassword$2> continuation) {
        super(2, continuation);
        this.f12380j = str;
        this.f12381k = verifyLoginPasswordUseCaseImpl;
        this.f12382l = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VerifyLoginPasswordUseCaseImpl$verifyLoginPassword$2(this.f12380j, this.f12381k, this.f12382l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super VerifyLoginPasswordUseCase.Result> continuation) {
        return ((VerifyLoginPasswordUseCaseImpl$verifyLoginPassword$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        boolean z11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12379i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f12380j.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return VerifyLoginPasswordUseCase.Result.PasswordIsEmpty.INSTANCE;
            }
            if (this.f12380j.length() < 6) {
                return VerifyLoginPasswordUseCase.Result.PasswordLengthIsInvalid.INSTANCE;
            }
            VerifyLoginPasswordUseCaseImpl verifyLoginPasswordUseCaseImpl = this.f12381k;
            String str = this.f12382l;
            String str2 = this.f12380j;
            this.f12379i = 1;
            obj = verifyLoginPasswordUseCaseImpl.tryAuthenticateWithPassword(str, str2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            obj2 = this.f12378h;
            ResultKt.throwOnFailure(obj);
            obj = obj2;
            return (VerifyLoginPasswordUseCase.Result) obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        VerifyLoginPasswordUseCaseImpl verifyLoginPasswordUseCaseImpl2 = this.f12381k;
        if (Intrinsics.areEqual((Object) (VerifyLoginPasswordUseCase.Result) obj, (Object) VerifyLoginPasswordUseCase.Result.Success.INSTANCE)) {
            this.f12378h = obj;
            this.f12379i = 2;
            if (verifyLoginPasswordUseCaseImpl2.refreshCustomerInfo(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj2 = obj;
            obj = obj2;
        }
        return (VerifyLoginPasswordUseCase.Result) obj;
    }
}
