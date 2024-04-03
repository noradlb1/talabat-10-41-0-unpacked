package com.talabat.userandlocation.compliance.status.presentation.viewmodel;

import com.talabat.userandlocation.compliance.status.domain.usecase.business.CheckUserIsAllowedToOrderUseCase;
import com.talabat.userandlocation.compliance.status.presentation.viewmodel.CheckUserAllowedToOrderViewModel;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.TrackContinueToCheckoutUseCase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.compliance.status.presentation.viewmodel.CheckUserAllowedToOrderViewModel$onUserInfoVerificationResult$1", f = "CheckUserAllowedToOrderViewModel.kt", i = {1}, l = {65, 74}, m = "invokeSuspend", n = {"userAllowedToOrder"}, s = {"L$0"})
public final class CheckUserAllowedToOrderViewModel$onUserInfoVerificationResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12296h;

    /* renamed from: i  reason: collision with root package name */
    public int f12297i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CheckUserAllowedToOrderViewModel f12298j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ CheckUserAllowedToOrderViewModel.UserInfoVerificationResult f12299k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckUserAllowedToOrderViewModel$onUserInfoVerificationResult$1(CheckUserAllowedToOrderViewModel checkUserAllowedToOrderViewModel, CheckUserAllowedToOrderViewModel.UserInfoVerificationResult userInfoVerificationResult, Continuation<? super CheckUserAllowedToOrderViewModel$onUserInfoVerificationResult$1> continuation) {
        super(2, continuation);
        this.f12298j = checkUserAllowedToOrderViewModel;
        this.f12299k = userInfoVerificationResult;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CheckUserAllowedToOrderViewModel$onUserInfoVerificationResult$1(this.f12298j, this.f12299k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CheckUserAllowedToOrderViewModel$onUserInfoVerificationResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CheckUserIsAllowedToOrderUseCase.Result result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12297i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f12298j.getShowProgressDialog().postValue(Boxing.boxBoolean(true));
            CheckUserIsAllowedToOrderUseCase access$isAllowedToOrderUseCase$p = this.f12298j.isAllowedToOrderUseCase;
            String firstName = this.f12299k.getFirstName();
            String lastName = this.f12299k.getLastName();
            String dateOfBirth = this.f12299k.getDateOfBirth();
            this.f12297i = 1;
            obj = access$isAllowedToOrderUseCase$p.isUserAllowedToOrder(firstName, lastName, dateOfBirth, true, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            result = (CheckUserIsAllowedToOrderUseCase.Result) this.f12296h;
            ResultKt.throwOnFailure(obj);
            this.f12298j.handleUserStatus(result);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CheckUserIsAllowedToOrderUseCase.Result result2 = (CheckUserIsAllowedToOrderUseCase.Result) obj;
        this.f12298j.getShowProgressDialog().postValue(Boxing.boxBoolean(false));
        TrackContinueToCheckoutUseCase access$getTrackContinueToCheckoutUseCase$p = this.f12298j.trackContinueToCheckoutUseCase;
        this.f12296h = result2;
        this.f12297i = 2;
        if (access$getTrackContinueToCheckoutUseCase$p.trackContinueToCheckout(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        result = result2;
        this.f12298j.handleUserStatus(result);
        return Unit.INSTANCE;
    }
}
