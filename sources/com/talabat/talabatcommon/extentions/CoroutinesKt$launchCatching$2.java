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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.CoroutinesKt$launchCatching$2", f = "Coroutines.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
public final class CoroutinesKt$launchCatching$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f46985h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f46986i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super Unit>, Object> f46987j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutinesKt$launchCatching$2(Function1<? super Throwable, Unit> function1, Function1<? super Continuation<? super Unit>, ? extends Object> function12, Continuation<? super CoroutinesKt$launchCatching$2> continuation) {
        super(2, continuation);
        this.f46986i = function1;
        this.f46987j = function12;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CoroutinesKt$launchCatching$2(this.f46986i, this.f46987j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CoroutinesKt$launchCatching$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f46985h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Throwable, Unit> function1 = this.f46986i;
            Function1<Continuation<? super Unit>, Object> function12 = this.f46987j;
            this.f46985h = 1;
            if (CoroutinesKt.runSuspended(function1, function12, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
