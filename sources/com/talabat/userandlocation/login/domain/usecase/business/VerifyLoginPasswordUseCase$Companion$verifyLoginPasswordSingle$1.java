package com.talabat.userandlocation.login.domain.usecase.business;

import com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase$Companion$verifyLoginPasswordSingle$1", f = "VerifyLoginPasswordUseCase.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
public final class VerifyLoginPasswordUseCase$Companion$verifyLoginPasswordSingle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super VerifyLoginPasswordUseCase.Result>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12344h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ VerifyLoginPasswordUseCase f12345i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f12346j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f12347k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerifyLoginPasswordUseCase$Companion$verifyLoginPasswordSingle$1(VerifyLoginPasswordUseCase verifyLoginPasswordUseCase, String str, String str2, Continuation<? super VerifyLoginPasswordUseCase$Companion$verifyLoginPasswordSingle$1> continuation) {
        super(2, continuation);
        this.f12345i = verifyLoginPasswordUseCase;
        this.f12346j = str;
        this.f12347k = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VerifyLoginPasswordUseCase$Companion$verifyLoginPasswordSingle$1(this.f12345i, this.f12346j, this.f12347k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super VerifyLoginPasswordUseCase.Result> continuation) {
        return ((VerifyLoginPasswordUseCase$Companion$verifyLoginPasswordSingle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12344h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            VerifyLoginPasswordUseCase verifyLoginPasswordUseCase = this.f12345i;
            String str = this.f12346j;
            String str2 = this.f12347k;
            this.f12344h = 1;
            obj = verifyLoginPasswordUseCase.verifyLoginPassword(str, str2, this);
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
