package com.talabat.userandlocation.compliance.status.presentation.viewmodel;

import com.talabat.userandlocation.compliance.status.domain.usecase.business.CheckUserIsAllowedToOrderUseCase;
import com.talabat.userandlocation.compliance.status.presentation.viewmodel.CheckUserAllowedToOrderViewModel;
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
@DebugMetadata(c = "com.talabat.userandlocation.compliance.status.presentation.viewmodel.CheckUserAllowedToOrderViewModel$onCreate$1", f = "CheckUserAllowedToOrderViewModel.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
public final class CheckUserAllowedToOrderViewModel$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12293h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CheckUserAllowedToOrderViewModel f12294i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CheckUserAllowedToOrderViewModel.Parameters f12295j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckUserAllowedToOrderViewModel$onCreate$1(CheckUserAllowedToOrderViewModel checkUserAllowedToOrderViewModel, CheckUserAllowedToOrderViewModel.Parameters parameters, Continuation<? super CheckUserAllowedToOrderViewModel$onCreate$1> continuation) {
        super(2, continuation);
        this.f12294i = checkUserAllowedToOrderViewModel;
        this.f12295j = parameters;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CheckUserAllowedToOrderViewModel$onCreate$1(this.f12294i, this.f12295j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CheckUserAllowedToOrderViewModel$onCreate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12293h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f12294i.getShowProgressDialog().postValue(Boxing.boxBoolean(true));
            CheckUserIsAllowedToOrderUseCase access$isAllowedToOrderUseCase$p = this.f12294i.isAllowedToOrderUseCase;
            String firstName = this.f12295j.getFirstName();
            String lastName = this.f12295j.getLastName();
            String dateOfBirth = this.f12295j.getDateOfBirth();
            this.f12293h = 1;
            obj = access$isAllowedToOrderUseCase$p.isUserAllowedToOrder(firstName, lastName, dateOfBirth, false, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f12294i.getShowProgressDialog().postValue(Boxing.boxBoolean(false));
        this.f12294i.handleUserStatus((CheckUserIsAllowedToOrderUseCase.Result) obj);
        return Unit.INSTANCE;
    }
}
