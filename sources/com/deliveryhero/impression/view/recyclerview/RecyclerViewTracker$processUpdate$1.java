package com.deliveryhero.impression.view.recyclerview;

import com.deliveryhero.impression.view.Tracker;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.deliveryhero.impression.view.recyclerview.RecyclerViewTracker$processUpdate$1", f = "RecyclerViewTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RecyclerViewTracker$processUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f30338h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RecyclerViewTracker f30339i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Tracker.ListState f30340j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerViewTracker$processUpdate$1(RecyclerViewTracker recyclerViewTracker, Tracker.ListState listState, Continuation<? super RecyclerViewTracker$processUpdate$1> continuation) {
        super(2, continuation);
        this.f30339i = recyclerViewTracker;
        this.f30340j = listState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecyclerViewTracker$processUpdate$1(this.f30339i, this.f30340j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecyclerViewTracker$processUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f30338h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f30339i.onListStateUpdate(this.f30340j);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
