package com.talabat.userandlocation.login.presentation.viewmodel;

import com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginEmailUseCase;
import com.talabat.userandlocation.login.presentation.viewmodel.EnterEmailViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.login.presentation.viewmodel.EnterEmailViewModel$onNextButtonClicked$1", f = "EnterEmailViewModel.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
public final class EnterEmailViewModel$onNextButtonClicked$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12384h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ EnterEmailViewModel f12385i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f12386j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnterEmailViewModel$onNextButtonClicked$1(EnterEmailViewModel enterEmailViewModel, String str, Continuation<? super EnterEmailViewModel$onNextButtonClicked$1> continuation) {
        super(1, continuation);
        this.f12385i = enterEmailViewModel;
        this.f12386j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new EnterEmailViewModel$onNextButtonClicked$1(this.f12385i, this.f12386j, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((EnterEmailViewModel$onNextButtonClicked$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12384h;
        boolean z11 = true;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f12385i._showProgressDialog.postValue(Boxing.boxBoolean(true));
            VerifyLoginEmailUseCase access$getVerifyLoginEmailUseCase$p = this.f12385i.verifyLoginEmailUseCase;
            String str = this.f12386j;
            this.f12384h = 1;
            obj = access$getVerifyLoginEmailUseCase$p.verifyLoginEmail(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        VerifyLoginEmailUseCase.Result result = (VerifyLoginEmailUseCase.Result) obj;
        this.f12385i._showProgressDialog.postValue(Boxing.boxBoolean(false));
        if (Intrinsics.areEqual((Object) result, (Object) VerifyLoginEmailUseCase.Result.EmptyEmail.INSTANCE)) {
            EnterEmailViewModel enterEmailViewModel = this.f12385i;
            enterEmailViewModel.showEmailFieldError(enterEmailViewModel.enterEmailStringProvider.getEmailIsRequired());
        } else {
            if (!Intrinsics.areEqual((Object) result, (Object) VerifyLoginEmailUseCase.Result.InvalidEmail.INSTANCE)) {
                z11 = Intrinsics.areEqual((Object) result, (Object) VerifyLoginEmailUseCase.Result.InvalidEmailFormat.INSTANCE);
            }
            if (z11) {
                EnterEmailViewModel enterEmailViewModel2 = this.f12385i;
                enterEmailViewModel2.showEmailFieldError(enterEmailViewModel2.enterEmailStringProvider.getEmailFormatIsInvalid());
            } else if (Intrinsics.areEqual((Object) result, (Object) VerifyLoginEmailUseCase.Result.RegisteredUser.INSTANCE)) {
                this.f12385i.showEmailFieldValue(this.f12386j);
                this.f12385i._moveToNextScreen.postValue(this.f12386j);
            } else if (Intrinsics.areEqual((Object) result, (Object) VerifyLoginEmailUseCase.Result.UnregisteredUser.INSTANCE)) {
                this.f12385i.showEmailFieldValue(this.f12386j);
                this.f12385i._moveToRegistrationScreen.postValue(this.f12386j);
            } else if (result instanceof VerifyLoginEmailUseCase.Result.UnhandledError) {
                this.f12385i.onErrorHandler.invoke(new EnterEmailViewModel.UnhandledViewModelError(((VerifyLoginEmailUseCase.Result.UnhandledError) result).getMessage()));
            }
        }
        return Unit.INSTANCE;
    }
}
