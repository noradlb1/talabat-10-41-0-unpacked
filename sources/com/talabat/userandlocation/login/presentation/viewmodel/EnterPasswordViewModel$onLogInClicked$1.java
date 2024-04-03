package com.talabat.userandlocation.login.presentation.viewmodel;

import com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.login.presentation.viewmodel.EnterPasswordViewModel$onLogInClicked$1", f = "EnterPasswordViewModel.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
public final class EnterPasswordViewModel$onLogInClicked$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12388h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ EnterPasswordViewModel f12389i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f12390j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnterPasswordViewModel$onLogInClicked$1(EnterPasswordViewModel enterPasswordViewModel, String str, Continuation<? super EnterPasswordViewModel$onLogInClicked$1> continuation) {
        super(1, continuation);
        this.f12389i = enterPasswordViewModel;
        this.f12390j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new EnterPasswordViewModel$onLogInClicked$1(this.f12389i, this.f12390j, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((EnterPasswordViewModel$onLogInClicked$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12388h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f12389i._showProgressDialog.postValue(Boxing.boxBoolean(true));
            VerifyLoginPasswordUseCase access$getVerifyLoginPasswordUseCase$p = this.f12389i.verifyLoginPasswordUseCase;
            String access$getUserEmail$p = this.f12389i.userEmail;
            String str = this.f12390j;
            this.f12388h = 1;
            obj = access$getVerifyLoginPasswordUseCase$p.verifyLoginPassword(access$getUserEmail$p, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f12389i._showProgressDialog.postValue(Boxing.boxBoolean(false));
        this.f12389i.handlePasswordVerificationResult((VerifyLoginPasswordUseCase.Result) obj);
        return Unit.INSTANCE;
    }
}
