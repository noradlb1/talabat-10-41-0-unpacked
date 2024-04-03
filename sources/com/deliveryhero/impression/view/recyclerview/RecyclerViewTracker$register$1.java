package com.deliveryhero.impression.view.recyclerview;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.deliveryhero.impression.view.recyclerview.RecyclerViewTracker$register$1", f = "RecyclerViewTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RecyclerViewTracker$register$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f30341h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RecyclerViewTracker f30342i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerViewTracker$register$1(RecyclerViewTracker recyclerViewTracker, Continuation<? super RecyclerViewTracker$register$1> continuation) {
        super(2, continuation);
        this.f30342i = recyclerViewTracker;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RecyclerViewTracker$register$1 recyclerViewTracker$register$1 = new RecyclerViewTracker$register$1(this.f30342i, continuation);
        recyclerViewTracker$register$1.L$0 = obj;
        return recyclerViewTracker$register$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecyclerViewTracker$register$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f30341h == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            RecyclerViewTracker recyclerViewTracker = this.f30342i;
            try {
                Result.Companion companion = Result.Companion;
                RecyclerView access$getRecyclerView$p = recyclerViewTracker.recyclerView;
                Unit unit = null;
                if (access$getRecyclerView$p != null) {
                    RecyclerView.Adapter adapter = access$getRecyclerView$p.getAdapter();
                    if (adapter != null) {
                        adapter.registerAdapterDataObserver(recyclerViewTracker.dataObserver);
                        unit = Unit.INSTANCE;
                    }
                }
                Result.m6329constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            RecyclerView access$getRecyclerView$p2 = this.f30342i.recyclerView;
            if (access$getRecyclerView$p2 != null) {
                access$getRecyclerView$p2.addOnScrollListener(this.f30342i.onScrollListener);
            }
            if (!(this.f30342i.getParentPosition() != null || (lifecycleOwner = this.f30342i.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null)) {
                lifecycle.addObserver(this.f30342i.lifecycleObserver);
            }
            RecyclerView access$getRecyclerView$p3 = this.f30342i.recyclerView;
            if (access$getRecyclerView$p3 != null) {
                access$getRecyclerView$p3.addOnLayoutChangeListener(new RecyclerViewTracker$register$1$invokeSuspend$$inlined$doOnNextLayout$1(this.f30342i));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
