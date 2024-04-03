package com.talabat.userandlocation.login.domain.usecase.business.impl;

import com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/userandlocation/login/domain/usecase/business/RefreshCustomerInformationUseCase$Result;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2$fetchCustomerInfoAsync$1", f = "RefreshCustomerInformationUseCaseImpl.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {})
public final class RefreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2$fetchCustomerInfoAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RefreshCustomerInformationUseCase.Result>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12360h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RefreshCustomerInformationUseCaseImpl f12361i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RefreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2$fetchCustomerInfoAsync$1(RefreshCustomerInformationUseCaseImpl refreshCustomerInformationUseCaseImpl, Continuation<? super RefreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2$fetchCustomerInfoAsync$1> continuation) {
        super(2, continuation);
        this.f12361i = refreshCustomerInformationUseCaseImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RefreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2$fetchCustomerInfoAsync$1(this.f12361i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super RefreshCustomerInformationUseCase.Result> continuation) {
        return ((RefreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2$fetchCustomerInfoAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12360h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            RefreshCustomerInformationUseCaseImpl refreshCustomerInformationUseCaseImpl = this.f12361i;
            this.f12360h = 1;
            obj = refreshCustomerInformationUseCaseImpl.fetchCustomerInfo(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
