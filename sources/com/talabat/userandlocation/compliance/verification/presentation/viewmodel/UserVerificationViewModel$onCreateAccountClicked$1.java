package com.talabat.userandlocation.compliance.verification.presentation.viewmodel;

import com.talabat.userandlocation.compliance.verification.domain.usecase.business.VerifyUserDetailsForComplianceUseCase;
import com.talabat.userandlocation.compliance.verification.presentation.viewmodel.UserVerificationViewModel;
import com.talabat.userandlocation.compliance.verification.ui.fragment.ComplianceUserVerificationExtras;
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
@DebugMetadata(c = "com.talabat.userandlocation.compliance.verification.presentation.viewmodel.UserVerificationViewModel$onCreateAccountClicked$1", f = "UserVerificationViewModel.kt", i = {}, l = {109, 120}, m = "invokeSuspend", n = {}, s = {})
public final class UserVerificationViewModel$onCreateAccountClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12316h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ UserVerificationViewModel f12317i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ UserVerificationViewModel.Data f12318j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserVerificationViewModel$onCreateAccountClicked$1(UserVerificationViewModel userVerificationViewModel, UserVerificationViewModel.Data data, Continuation<? super UserVerificationViewModel$onCreateAccountClicked$1> continuation) {
        super(2, continuation);
        this.f12317i = userVerificationViewModel;
        this.f12318j = data;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UserVerificationViewModel$onCreateAccountClicked$1(this.f12317i, this.f12318j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UserVerificationViewModel$onCreateAccountClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12316h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            VerifyUserDetailsForComplianceUseCase access$getVerifyUserDetailsForComplianceUseCase$p = this.f12317i.verifyUserDetailsForComplianceUseCase;
            VerifyUserDetailsForComplianceUseCase.Arguments access$toVerificationUseCaseArguments = this.f12317i.toVerificationUseCaseArguments(this.f12318j);
            this.f12316h = 1;
            obj = access$getVerifyUserDetailsForComplianceUseCase$p.verifyUserDetailsForCompliance(access$toVerificationUseCaseArguments, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        VerifyUserDetailsForComplianceUseCase.UserVerificationForComplianceResult userVerificationForComplianceResult = (VerifyUserDetailsForComplianceUseCase.UserVerificationForComplianceResult) obj;
        if (userVerificationForComplianceResult instanceof VerifyUserDetailsForComplianceUseCase.UserVerificationForComplianceResult.VerificationFailed) {
            this.f12317i.showValidationError(((VerifyUserDetailsForComplianceUseCase.UserVerificationForComplianceResult.VerificationFailed) userVerificationForComplianceResult).getInvalidFields());
        } else if (Intrinsics.areEqual((Object) userVerificationForComplianceResult, (Object) VerifyUserDetailsForComplianceUseCase.UserVerificationForComplianceResult.VerificationSuccess.INSTANCE)) {
            ComplianceUserVerificationExtras access$getExtras$p = this.f12317i.extras;
            if (access$getExtras$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("extras");
                access$getExtras$p = null;
            }
            if (access$getExtras$p.getUpdateUserInfoAfterVerification()) {
                this.f12317i.getShowLoadingDialog().postValue(Boxing.boxBoolean(true));
                UserVerificationViewModel userVerificationViewModel = this.f12317i;
                UserVerificationViewModel.Data data = this.f12318j;
                this.f12316h = 2;
                if (userVerificationViewModel.updateUserProfile(data, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.f12317i.dismissScreenWithSuccess(this.f12318j);
            }
        }
        return Unit.INSTANCE;
    }
}
