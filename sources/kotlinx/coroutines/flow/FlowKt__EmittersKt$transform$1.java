package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H@"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1", f = "Emitters.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__EmittersKt$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f25608h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Flow<T> f25609i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> f25610j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__EmittersKt$transform$1(Flow<? extends T> flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super FlowKt__EmittersKt$transform$1> continuation) {
        super(2, continuation);
        this.f25609i = flow;
        this.f25610j = function3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__EmittersKt$transform$1 flowKt__EmittersKt$transform$1 = new FlowKt__EmittersKt$transform$1(this.f25609i, this.f25610j, continuation);
        flowKt__EmittersKt$transform$1.L$0 = obj;
        return flowKt__EmittersKt$transform$1;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super R> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__EmittersKt$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f25608h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final FlowCollector flowCollector = (FlowCollector) this.L$0;
            Flow<T> flow = this.f25609i;
            final Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> function3 = this.f25610j;
            AnonymousClass1 r32 = new FlowCollector() {
                /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
                @org.jetbrains.annotations.Nullable
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object emit(T r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1
                        if (r0 == 0) goto L_0x0013
                        r0 = r6
                        kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1) r0
                        int r1 = r0.f25615j
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.f25615j = r1
                        goto L_0x0018
                    L_0x0013:
                        kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1
                        r0.<init>(r4, r6)
                    L_0x0018:
                        java.lang.Object r6 = r0.f25613h
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.f25615j
                        r3 = 1
                        if (r2 == 0) goto L_0x0031
                        if (r2 != r3) goto L_0x0029
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L_0x0041
                    L_0x0029:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L_0x0031:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlin.jvm.functions.Function3<kotlinx.coroutines.flow.FlowCollector<? super R>, T, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r6 = r2
                        kotlinx.coroutines.flow.FlowCollector<R> r2 = r4
                        r0.f25615j = r3
                        java.lang.Object r5 = r6.invoke(r2, r5, r0)
                        if (r5 != r1) goto L_0x0041
                        return r1
                    L_0x0041:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }

                @Nullable
                public final Object emit$$forInline(T t11, @NotNull Continuation<? super Unit> continuation) {
                    InlineMarker.mark(4);
                    new FlowKt__EmittersKt$transform$1$1$emit$1(this, continuation);
                    InlineMarker.mark(5);
                    r2.invoke(r4, t11, continuation);
                    return Unit.INSTANCE;
                }
            };
            this.f25608h = 1;
            if (flow.collect(r32, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        final FlowCollector flowCollector = (FlowCollector) this.L$0;
        Flow<T> flow = this.f25609i;
        final Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> function3 = this.f25610j;
        AnonymousClass1 r12 = new FlowCollector() {
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(T r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1) r0
                    int r1 = r0.f25615j
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f25615j = r1
                    goto L_0x0018
                L_0x0013:
                    kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.f25613h
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.f25615j
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L_0x0041
                L_0x0029:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0031:
                    kotlin.ResultKt.throwOnFailure(r6)
                    kotlin.jvm.functions.Function3<kotlinx.coroutines.flow.FlowCollector<? super R>, T, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r6 = r2
                    kotlinx.coroutines.flow.FlowCollector<R> r2 = r4
                    r0.f25615j = r3
                    java.lang.Object r5 = r6.invoke(r2, r5, r0)
                    if (r5 != r1) goto L_0x0041
                    return r1
                L_0x0041:
                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Nullable
            public final Object emit$$forInline(T t11, @NotNull Continuation<? super Unit> continuation) {
                InlineMarker.mark(4);
                new FlowKt__EmittersKt$transform$1$1$emit$1(this, continuation);
                InlineMarker.mark(5);
                function3.invoke(flowCollector, t11, continuation);
                return Unit.INSTANCE;
            }
        };
        InlineMarker.mark(0);
        flow.collect(r12, this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
