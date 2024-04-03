package com.talabat.authentication.natives;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "e", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$tokenData$1$1", f = "JwtTokenManagerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class JwtTokenManagerImpl$doRefreshToken$tokenData$1$1 extends SuspendLambda implements Function2<Throwable, Continuation<? super Boolean>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f55469h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f55470i;

    public JwtTokenManagerImpl$doRefreshToken$tokenData$1$1(Continuation<? super JwtTokenManagerImpl$doRefreshToken$tokenData$1$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        JwtTokenManagerImpl$doRefreshToken$tokenData$1$1 jwtTokenManagerImpl$doRefreshToken$tokenData$1$1 = new JwtTokenManagerImpl$doRefreshToken$tokenData$1$1(continuation);
        jwtTokenManagerImpl$doRefreshToken$tokenData$1$1.f55470i = obj;
        return jwtTokenManagerImpl$doRefreshToken$tokenData$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull Throwable th2, @Nullable Continuation<? super Boolean> continuation) {
        return ((JwtTokenManagerImpl$doRefreshToken$tokenData$1$1) create(th2, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z11;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f55469h == 0) {
            ResultKt.throwOnFailure(obj);
            Throwable th2 = (Throwable) this.f55470i;
            if (!(th2 instanceof HttpException) || ((HttpException) th2).code() < 500) {
                z11 = false;
            } else {
                z11 = true;
            }
            return Boxing.boxBoolean(z11);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
