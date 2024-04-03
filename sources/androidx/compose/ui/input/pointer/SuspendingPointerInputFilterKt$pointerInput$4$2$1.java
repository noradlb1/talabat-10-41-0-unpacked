package androidx.compose.ui.input.pointer;

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
@DebugMetadata(c = "androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$pointerInput$4$2$1", f = "SuspendingPointerInputFilter.kt", i = {}, l = {292}, m = "invokeSuspend", n = {}, s = {})
public final class SuspendingPointerInputFilterKt$pointerInput$4$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f9828h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SuspendingPointerInputFilter f9829i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<PointerInputScope, Continuation<? super Unit>, Object> f9830j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuspendingPointerInputFilterKt$pointerInput$4$2$1(SuspendingPointerInputFilter suspendingPointerInputFilter, Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super SuspendingPointerInputFilterKt$pointerInput$4$2$1> continuation) {
        super(2, continuation);
        this.f9829i = suspendingPointerInputFilter;
        this.f9830j = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SuspendingPointerInputFilterKt$pointerInput$4$2$1 suspendingPointerInputFilterKt$pointerInput$4$2$1 = new SuspendingPointerInputFilterKt$pointerInput$4$2$1(this.f9829i, this.f9830j, continuation);
        suspendingPointerInputFilterKt$pointerInput$4$2$1.L$0 = obj;
        return suspendingPointerInputFilterKt$pointerInput$4$2$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SuspendingPointerInputFilterKt$pointerInput$4$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f9828h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f9829i.setCoroutineScope((CoroutineScope) this.L$0);
            Function2<PointerInputScope, Continuation<? super Unit>, Object> function2 = this.f9830j;
            SuspendingPointerInputFilter suspendingPointerInputFilter = this.f9829i;
            this.f9828h = 1;
            if (function2.invoke(suspendingPointerInputFilter, this) == coroutine_suspended) {
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
