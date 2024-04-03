package kotlinx.coroutines.flow;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
public final class StartedLazily$command$1 extends SuspendLambda implements Function2<FlowCollector<? super SharingCommand>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f26047h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ StateFlow<Integer> f26048i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StartedLazily$command$1(StateFlow<Integer> stateFlow, Continuation<? super StartedLazily$command$1> continuation) {
        super(2, continuation);
        this.f26048i = stateFlow;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        StartedLazily$command$1 startedLazily$command$1 = new StartedLazily$command$1(this.f26048i, continuation);
        startedLazily$command$1.L$0 = obj;
        return startedLazily$command$1;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super SharingCommand> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((StartedLazily$command$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f26047h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final FlowCollector flowCollector = (FlowCollector) this.L$0;
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            StateFlow<Integer> stateFlow = this.f26048i;
            AnonymousClass1 r42 = new FlowCollector() {
                /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
                @org.jetbrains.annotations.Nullable
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object emit(int r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1
                        if (r0 == 0) goto L_0x0013
                        r0 = r6
                        kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1 r0 = (kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1) r0
                        int r1 = r0.f26053j
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.f26053j = r1
                        goto L_0x0018
                    L_0x0013:
                        kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1 r0 = new kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1
                        r0.<init>(r4, r6)
                    L_0x0018:
                        java.lang.Object r6 = r0.f26051h
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.f26053j
                        r3 = 1
                        if (r2 == 0) goto L_0x0031
                        if (r2 != r3) goto L_0x0029
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L_0x004b
                    L_0x0029:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L_0x0031:
                        kotlin.ResultKt.throwOnFailure(r6)
                        if (r5 <= 0) goto L_0x004e
                        kotlin.jvm.internal.Ref$BooleanRef r5 = r1
                        boolean r6 = r5.element
                        if (r6 != 0) goto L_0x004e
                        r5.element = r3
                        kotlinx.coroutines.flow.FlowCollector<kotlinx.coroutines.flow.SharingCommand> r5 = r6
                        kotlinx.coroutines.flow.SharingCommand r6 = kotlinx.coroutines.flow.SharingCommand.START
                        r0.f26053j = r3
                        java.lang.Object r5 = r5.emit(r6, r0)
                        if (r5 != r1) goto L_0x004b
                        return r1
                    L_0x004b:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    L_0x004e:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedLazily$command$1.AnonymousClass1.emit(int, kotlin.coroutines.Continuation):java.lang.Object");
                }

                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return emit(((Number) obj).intValue(), (Continuation<? super Unit>) continuation);
                }
            };
            this.f26047h = 1;
            if (stateFlow.collect(r42, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
