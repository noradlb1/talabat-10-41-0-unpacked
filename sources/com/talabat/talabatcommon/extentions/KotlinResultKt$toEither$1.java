package com.talabat.talabatcommon.extentions;

import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000\"\u0004\b\u0000\u0010\u0000H@"}, d2 = {"T", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.KotlinResultKt$toEither$1", f = "KotlinResult.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class KotlinResultKt$toEither$1 extends SuspendLambda implements Function1<Continuation<? super T>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f47056h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Single<T> f47057i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinResultKt$toEither$1(Single<T> single, Continuation<? super KotlinResultKt$toEither$1> continuation) {
        super(1, continuation);
        this.f47057i = single;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new KotlinResultKt$toEither$1(this.f47057i, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super T> continuation) {
        return ((KotlinResultKt$toEither$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f47056h == 0) {
            ResultKt.throwOnFailure(obj);
            return this.f47057i.blockingGet();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
