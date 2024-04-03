package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1 implements Flow<R> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow[] f25941b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function4 f25942c;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H@¨\u0006\u0006"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", "", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2", f = "Zip.kt", i = {}, l = {333, 333}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f25943h;

        /* renamed from: i  reason: collision with root package name */
        public /* synthetic */ Object f25944i;

        @Nullable
        public final Object invoke(@NotNull FlowCollector<? super R> flowCollector, @NotNull Object[] objArr, @Nullable Continuation<? super Unit> continuation) {
            AnonymousClass2 r02 = new AnonymousClass2(continuation, function4);
            r02.L$0 = flowCollector;
            r02.f25944i = objArr;
            return r02.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.FlowCollector} */
        /* JADX WARNING: Multi-variable type inference failed */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.f25943h
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0022
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                kotlin.ResultKt.throwOnFailure(r8)
                goto L_0x0056
            L_0x0012:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001a:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L_0x004a
            L_0x0022:
                kotlin.ResultKt.throwOnFailure(r8)
                java.lang.Object r8 = r7.L$0
                r1 = r8
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                java.lang.Object r8 = r7.f25944i
                java.lang.Object[] r8 = (java.lang.Object[]) r8
                kotlin.jvm.functions.Function4 r4 = r4
                r5 = 0
                r5 = r8[r5]
                r6 = r8[r3]
                r8 = r8[r2]
                r7.L$0 = r1
                r7.f25943h = r3
                r3 = 6
                kotlin.jvm.internal.InlineMarker.mark((int) r3)
                java.lang.Object r8 = r4.invoke(r5, r6, r8, r7)
                r3 = 7
                kotlin.jvm.internal.InlineMarker.mark((int) r3)
                if (r8 != r0) goto L_0x004a
                return r0
            L_0x004a:
                r3 = 0
                r7.L$0 = r3
                r7.f25943h = r2
                java.lang.Object r8 = r1.emit(r8, r7)
                if (r8 != r0) goto L_0x0056
                return r0
            L_0x0056:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1(Flow[] flowArr, Function4 function4) {
        this.f25941b = flowArr;
        this.f25942c = function4;
    }

    @Nullable
    public Object collect(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
        Flow[] flowArr = this.f25941b;
        Function0 access$nullArrayFactory = FlowKt__ZipKt.nullArrayFactory$FlowKt__ZipKt();
        final Function4 function4 = this.f25942c;
        Object combineInternal = CombineKt.combineInternal(flowCollector, flowArr, access$nullArrayFactory, new AnonymousClass2((Continuation) null), continuation);
        if (combineInternal == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return combineInternal;
        }
        return Unit.INSTANCE;
    }
}
