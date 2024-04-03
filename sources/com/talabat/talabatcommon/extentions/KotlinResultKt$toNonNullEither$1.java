package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0001\u001a\u0004\b\u00028\u0000\"\u0004\b\u0000\u0010\u0000H@"}, d2 = {"T", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.KotlinResultKt$toNonNullEither$1", f = "KotlinResult.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class KotlinResultKt$toNonNullEither$1 extends SuspendLambda implements Function1<Continuation<? super T>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f47060h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ T f47061i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinResultKt$toNonNullEither$1(T t11, Continuation<? super KotlinResultKt$toNonNullEither$1> continuation) {
        super(1, continuation);
        this.f47061i = t11;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new KotlinResultKt$toNonNullEither$1(this.f47061i, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super T> continuation) {
        return ((KotlinResultKt$toNonNullEither$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f47060h == 0) {
            ResultKt.throwOnFailure(obj);
            T t11 = this.f47061i;
            if (t11 != null) {
                return t11;
            }
            throw NullValueInEitherException.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
