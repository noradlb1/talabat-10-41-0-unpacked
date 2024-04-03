package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H@"}, d2 = {"T", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.EitherFold$onFailure$1", f = "KotlinResult.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EitherFold$onFailure$1 extends SuspendLambda implements Function2<Throwable, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f46996h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f46997i;

    public EitherFold$onFailure$1(Continuation<? super EitherFold$onFailure$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        EitherFold$onFailure$1 eitherFold$onFailure$1 = new EitherFold$onFailure$1(continuation);
        eitherFold$onFailure$1.f46997i = obj;
        return eitherFold$onFailure$1;
    }

    @Nullable
    public final Object invoke(@NotNull Throwable th2, @Nullable Continuation<? super Unit> continuation) {
        return ((EitherFold$onFailure$1) create(th2, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f46996h == 0) {
            ResultKt.throwOnFailure(obj);
            ThrowablesKt.log((Throwable) this.f46997i);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
