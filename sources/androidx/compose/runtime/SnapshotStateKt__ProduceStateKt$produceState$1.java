package androidx.compose.runtime;

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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$1", f = "ProduceState.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
public final class SnapshotStateKt__ProduceStateKt$produceState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f9224h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<ProduceStateScope<T>, Continuation<? super Unit>, Object> f9225i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<T> f9226j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnapshotStateKt__ProduceStateKt$produceState$1(Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, MutableState<T> mutableState, Continuation<? super SnapshotStateKt__ProduceStateKt$produceState$1> continuation) {
        super(2, continuation);
        this.f9225i = function2;
        this.f9226j = mutableState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SnapshotStateKt__ProduceStateKt$produceState$1 snapshotStateKt__ProduceStateKt$produceState$1 = new SnapshotStateKt__ProduceStateKt$produceState$1(this.f9225i, this.f9226j, continuation);
        snapshotStateKt__ProduceStateKt$produceState$1.L$0 = obj;
        return snapshotStateKt__ProduceStateKt$produceState$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SnapshotStateKt__ProduceStateKt$produceState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f9224h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<ProduceStateScope<T>, Continuation<? super Unit>, Object> function2 = this.f9225i;
            ProduceStateScopeImpl produceStateScopeImpl = new ProduceStateScopeImpl(this.f9226j, ((CoroutineScope) this.L$0).getCoroutineContext());
            this.f9224h = 1;
            if (function2.invoke(produceStateScopeImpl, this) == coroutine_suspended) {
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
