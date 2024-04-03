package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 6, 0}, xi = 176)
public final class FlowKt__TransformKt$filterIsInstance$$inlined$filter$1 implements Flow<Object> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow f25852b;

    public FlowKt__TransformKt$filterIsInstance$$inlined$filter$1(Flow flow) {
        this.f25852b = flow;
    }

    @Nullable
    public Object collect(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        Flow flow = this.f25852b;
        Intrinsics.needClassReification();
        Object collect = flow.collect(new FlowCollector() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r7
                    kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.f25858i
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f25858i = r1
                    goto L_0x0018
                L_0x0013:
                    kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1
                    r0.<init>(r5, r7)
                L_0x0018:
                    java.lang.Object r7 = r0.f25857h
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.f25858i
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L_0x0049
                L_0x0029:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L_0x0031:
                    kotlin.ResultKt.throwOnFailure(r7)
                    kotlinx.coroutines.flow.FlowCollector r7 = r3
                    r2 = 3
                    java.lang.String r4 = "R"
                    kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r2, r4)
                    boolean r2 = r6 instanceof java.lang.Object
                    if (r2 == 0) goto L_0x0049
                    r0.f25858i = r3
                    java.lang.Object r6 = r7.emit(r6, r0)
                    if (r6 != r1) goto L_0x0049
                    return r1
                L_0x0049:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Nullable
            public final Object emit$$forInline(Object obj, @NotNull Continuation continuation) {
                InlineMarker.mark(4);
                new ContinuationImpl(this, continuation) {

                    /* renamed from: h  reason: collision with root package name */
                    public /* synthetic */ Object f25857h;

                    /* renamed from: i  reason: collision with root package name */
                    public int f25858i;

                    /* renamed from: j  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass2 f25859j;

                    {
                        this.f25859j = r1;
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.f25857h = obj;
                        this.f25858i |= Integer.MIN_VALUE;
                        return this.f25859j.emit((Object) null, this);
                    }
                };
                InlineMarker.mark(5);
                FlowCollector flowCollector = r3;
                Intrinsics.reifiedOperationMarker(3, "R");
                if (obj instanceof Object) {
                    InlineMarker.mark(0);
                    flowCollector.emit(obj, continuation);
                    InlineMarker.mark(1);
                }
                return Unit.INSTANCE;
            }
        }, continuation);
        if (collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public Object collect$$forInline(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(this, continuation) {

            /* renamed from: h  reason: collision with root package name */
            public /* synthetic */ Object f25853h;

            /* renamed from: i  reason: collision with root package name */
            public int f25854i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ FlowKt__TransformKt$filterIsInstance$$inlined$filter$1 f25855j;

            {
                this.f25855j = r1;
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f25853h = obj;
                this.f25854i |= Integer.MIN_VALUE;
                return this.f25855j.collect((FlowCollector) null, this);
            }
        };
        InlineMarker.mark(5);
        Flow flow = this.f25852b;
        Intrinsics.needClassReification();
        AnonymousClass2 r12 = new FlowCollector() {
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r7
                    kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.f25858i
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f25858i = r1
                    goto L_0x0018
                L_0x0013:
                    kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1
                    r0.<init>(r5, r7)
                L_0x0018:
                    java.lang.Object r7 = r0.f25857h
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.f25858i
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L_0x0049
                L_0x0029:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L_0x0031:
                    kotlin.ResultKt.throwOnFailure(r7)
                    kotlinx.coroutines.flow.FlowCollector r7 = r3
                    r2 = 3
                    java.lang.String r4 = "R"
                    kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r2, r4)
                    boolean r2 = r6 instanceof java.lang.Object
                    if (r2 == 0) goto L_0x0049
                    r0.f25858i = r3
                    java.lang.Object r6 = r7.emit(r6, r0)
                    if (r6 != r1) goto L_0x0049
                    return r1
                L_0x0049:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Nullable
            public final Object emit$$forInline(Object obj, @NotNull Continuation continuation) {
                InlineMarker.mark(4);
                new ContinuationImpl(this, continuation) {

                    /* renamed from: h  reason: collision with root package name */
                    public /* synthetic */ Object f25857h;

                    /* renamed from: i  reason: collision with root package name */
                    public int f25858i;

                    /* renamed from: j  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass2 f25859j;

                    {
                        this.f25859j = r1;
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.f25857h = obj;
                        this.f25858i |= Integer.MIN_VALUE;
                        return this.f25859j.emit((Object) null, this);
                    }
                };
                InlineMarker.mark(5);
                FlowCollector flowCollector = flowCollector;
                Intrinsics.reifiedOperationMarker(3, "R");
                if (obj instanceof Object) {
                    InlineMarker.mark(0);
                    flowCollector.emit(obj, continuation);
                    InlineMarker.mark(1);
                }
                return Unit.INSTANCE;
            }
        };
        InlineMarker.mark(0);
        flow.collect(r12, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
