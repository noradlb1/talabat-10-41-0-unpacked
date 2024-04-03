package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1", f = "SnapshotFlow.kt", i = {}, l = {65, 66}, m = "invokeSuspend", n = {}, s = {})
public final class SnapshotStateKt__SnapshotFlowKt$collectAsState$1 extends SuspendLambda implements Function2<ProduceStateScope<R>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f9239h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f9240i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Flow<T> f9241j;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$2", f = "SnapshotFlow.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f9243h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(flow2, produceStateScope, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f9243h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<T> flow = flow2;
                final ProduceStateScope<R> produceStateScope = produceStateScope;
                AnonymousClass1 r12 = new FlowCollector<T>() {
                    @Nullable
                    public final Object emit(T t11, @NotNull Continuation<? super Unit> continuation) {
                        produceStateScope.setValue(t11);
                        return Unit.INSTANCE;
                    }
                };
                this.f9243h = 1;
                if (flow.collect(r12, this) == coroutine_suspended) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnapshotStateKt__SnapshotFlowKt$collectAsState$1(CoroutineContext coroutineContext, Flow<? extends T> flow, Continuation<? super SnapshotStateKt__SnapshotFlowKt$collectAsState$1> continuation) {
        super(2, continuation);
        this.f9240i = coroutineContext;
        this.f9241j = flow;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SnapshotStateKt__SnapshotFlowKt$collectAsState$1 snapshotStateKt__SnapshotFlowKt$collectAsState$1 = new SnapshotStateKt__SnapshotFlowKt$collectAsState$1(this.f9240i, this.f9241j, continuation);
        snapshotStateKt__SnapshotFlowKt$collectAsState$1.L$0 = obj;
        return snapshotStateKt__SnapshotFlowKt$collectAsState$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProduceStateScope<R> produceStateScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SnapshotStateKt__SnapshotFlowKt$collectAsState$1) create(produceStateScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f9239h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final ProduceStateScope produceStateScope = (ProduceStateScope) this.L$0;
            if (Intrinsics.areEqual((Object) this.f9240i, (Object) EmptyCoroutineContext.INSTANCE)) {
                Flow<T> flow = this.f9241j;
                AnonymousClass1 r22 = new FlowCollector<T>() {
                    @Nullable
                    public final Object emit(T t11, @NotNull Continuation<? super Unit> continuation) {
                        produceStateScope.setValue(t11);
                        return Unit.INSTANCE;
                    }
                };
                this.f9239h = 1;
                if (flow.collect(r22, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                CoroutineContext coroutineContext = this.f9240i;
                final Flow<T> flow2 = this.f9241j;
                AnonymousClass2 r32 = new AnonymousClass2((Continuation<? super AnonymousClass2>) null);
                this.f9239h = 2;
                if (BuildersKt.withContext(coroutineContext, r32, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i11 == 1 || i11 == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
