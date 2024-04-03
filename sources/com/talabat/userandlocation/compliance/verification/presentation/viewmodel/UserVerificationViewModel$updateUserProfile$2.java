package com.talabat.userandlocation.compliance.verification.presentation.viewmodel;

import com.talabat.userandlocation.compliance.verification.domain.usecase.business.UpdateUserProfileUseCase;
import com.talabat.userandlocation.compliance.verification.presentation.viewmodel.UserVerificationViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.compliance.verification.presentation.viewmodel.UserVerificationViewModel$updateUserProfile$2", f = "UserVerificationViewModel.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
public final class UserVerificationViewModel$updateUserProfile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12322h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ UserVerificationViewModel f12323i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ UserVerificationViewModel.Data f12324j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserVerificationViewModel$updateUserProfile$2(UserVerificationViewModel userVerificationViewModel, UserVerificationViewModel.Data data, Continuation<? super UserVerificationViewModel$updateUserProfile$2> continuation) {
        super(2, continuation);
        this.f12323i = userVerificationViewModel;
        this.f12324j = data;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UserVerificationViewModel$updateUserProfile$2(this.f12323i, this.f12324j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UserVerificationViewModel$updateUserProfile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12322h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            UpdateUserProfileUseCase access$getUpdateUserProfileUseCase$p = this.f12323i.updateUserProfileUseCase;
            String firstName = this.f12324j.getFirstName();
            String lastName = this.f12324j.getLastName();
            String dateOfBirth = this.f12324j.getDateOfBirth();
            this.f12322h = 1;
            obj = access$getUpdateUserProfileUseCase$p.updateUserProfile(firstName, lastName, dateOfBirth, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        UpdateUserProfileUseCase.Result result = (UpdateUserProfileUseCase.Result) obj;
        this.f12323i.getShowLoadingDialog().postValue(Boxing.boxBoolean(false));
        if (Intrinsics.areEqual((Object) result, (Object) UpdateUserProfileUseCase.Result.Success.INSTANCE)) {
            this.f12323i.dismissScreenWithSuccess(this.f12324j);
        } else if (result instanceof UpdateUserProfileUseCase.Result.InvalidCharacterError) {
            this.f12323i.getValidationErrorDialogMessage().postValue(((UpdateUserProfileUseCase.Result.InvalidCharacterError) result).getMessage());
        }
        return Unit.INSTANCE;
    }
}
