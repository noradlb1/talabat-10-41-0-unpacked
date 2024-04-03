package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.CoroutinesKt$asyncCatching$2", f = "Coroutines.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
public final class CoroutinesKt$asyncCatching$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f46978h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f46979i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ T f46980j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super T>, Object> f46981k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutinesKt$asyncCatching$2(Function1<? super Throwable, Unit> function1, T t11, Function1<? super Continuation<? super T>, ? extends Object> function12, Continuation<? super CoroutinesKt$asyncCatching$2> continuation) {
        super(2, continuation);
        this.f46979i = function1;
        this.f46980j = t11;
        this.f46981k = function12;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CoroutinesKt$asyncCatching$2(this.f46979i, this.f46980j, this.f46981k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super T> continuation) {
        return ((CoroutinesKt$asyncCatching$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f46978h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Throwable, Unit> function1 = this.f46979i;
            T t11 = this.f46980j;
            Function1<Continuation<? super T>, Object> function12 = this.f46981k;
            this.f46978h = 1;
            obj = CoroutinesKt.returnSuspended(function1, t11, function12, this);
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
