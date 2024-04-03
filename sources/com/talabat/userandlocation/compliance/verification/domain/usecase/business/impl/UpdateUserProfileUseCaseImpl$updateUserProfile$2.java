package com.talabat.userandlocation.compliance.verification.domain.usecase.business.impl;

import com.talabat.userandlocation.compliance.verification.domain.usecase.business.UpdateUserProfileUseCase;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/UpdateUserProfileUseCase$Result;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.compliance.verification.domain.usecase.business.impl.UpdateUserProfileUseCaseImpl$updateUserProfile$2", f = "UpdateUserProfileUseCaseImpl.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
public final class UpdateUserProfileUseCaseImpl$updateUserProfile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UpdateUserProfileUseCase.Result>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12308h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ UpdateUserProfileUseCaseImpl f12309i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f12310j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f12311k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f12312l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UpdateUserProfileUseCaseImpl$updateUserProfile$2(UpdateUserProfileUseCaseImpl updateUserProfileUseCaseImpl, String str, String str2, String str3, Continuation<? super UpdateUserProfileUseCaseImpl$updateUserProfile$2> continuation) {
        super(2, continuation);
        this.f12309i = updateUserProfileUseCaseImpl;
        this.f12310j = str;
        this.f12311k = str2;
        this.f12312l = str3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UpdateUserProfileUseCaseImpl$updateUserProfile$2(this.f12309i, this.f12310j, this.f12311k, this.f12312l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super UpdateUserProfileUseCase.Result> continuation) {
        return ((UpdateUserProfileUseCaseImpl$updateUserProfile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12308h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            UpdateUserProfileUseCaseImpl updateUserProfileUseCaseImpl = this.f12309i;
            String str = this.f12310j;
            String str2 = this.f12311k;
            String str3 = this.f12312l;
            this.f12308h = 1;
            obj = updateUserProfileUseCaseImpl.updateDetails(str, str2, str3, this);
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
