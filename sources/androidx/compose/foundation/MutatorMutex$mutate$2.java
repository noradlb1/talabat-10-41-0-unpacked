package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"R", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.MutatorMutex$mutate$2", f = "MutatorMutex.kt", i = {0, 0, 1, 1}, l = {173, 119}, m = "invokeSuspend", n = {"mutator", "$this$withLock_u24default$iv", "mutator", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class MutatorMutex$mutate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f1766h;

    /* renamed from: i  reason: collision with root package name */
    public Object f1767i;

    /* renamed from: j  reason: collision with root package name */
    public Object f1768j;

    /* renamed from: k  reason: collision with root package name */
    public int f1769k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutatePriority f1770l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutatorMutex f1771m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super R>, Object> f1772n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutatorMutex$mutate$2(MutatePriority mutatePriority, MutatorMutex mutatorMutex, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super MutatorMutex$mutate$2> continuation) {
        super(2, continuation);
        this.f1770l = mutatePriority;
        this.f1771m = mutatorMutex;
        this.f1772n = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MutatorMutex$mutate$2 mutatorMutex$mutate$2 = new MutatorMutex$mutate$2(this.f1770l, this.f1771m, this.f1772n, continuation);
        mutatorMutex$mutate$2.L$0 = obj;
        return mutatorMutex$mutate$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super R> continuation) {
        return ((MutatorMutex$mutate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x0096=Splitter:B:20:0x0096, B:26:0x00a7=Splitter:B:26:0x00a7} */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.f1769k
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0040
            if (r1 == r3) goto L_0x002b
            if (r1 != r2) goto L_0x0023
            java.lang.Object r0 = r8.f1767i
            androidx.compose.foundation.MutatorMutex r0 = (androidx.compose.foundation.MutatorMutex) r0
            java.lang.Object r1 = r8.f1766h
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r2 = r8.L$0
            androidx.compose.foundation.MutatorMutex$Mutator r2 = (androidx.compose.foundation.MutatorMutex.Mutator) r2
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0020 }
            goto L_0x0096
        L_0x0020:
            r9 = move-exception
            goto L_0x00a7
        L_0x0023:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x002b:
            java.lang.Object r1 = r8.f1768j
            androidx.compose.foundation.MutatorMutex r1 = (androidx.compose.foundation.MutatorMutex) r1
            java.lang.Object r3 = r8.f1767i
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            java.lang.Object r5 = r8.f1766h
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            java.lang.Object r6 = r8.L$0
            androidx.compose.foundation.MutatorMutex$Mutator r6 = (androidx.compose.foundation.MutatorMutex.Mutator) r6
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r5
            goto L_0x0081
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            androidx.compose.foundation.MutatorMutex$Mutator r1 = new androidx.compose.foundation.MutatorMutex$Mutator
            androidx.compose.foundation.MutatePriority r5 = r8.f1770l
            kotlin.coroutines.CoroutineContext r9 = r9.getCoroutineContext()
            kotlinx.coroutines.Job$Key r6 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Element r9 = r9.get(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            kotlinx.coroutines.Job r9 = (kotlinx.coroutines.Job) r9
            r1.<init>(r5, r9)
            androidx.compose.foundation.MutatorMutex r9 = r8.f1771m
            r9.tryMutateOrCancel(r1)
            androidx.compose.foundation.MutatorMutex r9 = r8.f1771m
            kotlinx.coroutines.sync.Mutex r9 = r9.mutex
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super R>, java.lang.Object> r5 = r8.f1772n
            androidx.compose.foundation.MutatorMutex r6 = r8.f1771m
            r8.L$0 = r1
            r8.f1766h = r9
            r8.f1767i = r5
            r8.f1768j = r6
            r8.f1769k = r3
            java.lang.Object r3 = r9.lock(r4, r8)
            if (r3 != r0) goto L_0x007d
            return r0
        L_0x007d:
            r3 = r5
            r7 = r6
            r6 = r1
            r1 = r7
        L_0x0081:
            r8.L$0 = r6     // Catch:{ all -> 0x00a1 }
            r8.f1766h = r9     // Catch:{ all -> 0x00a1 }
            r8.f1767i = r1     // Catch:{ all -> 0x00a1 }
            r8.f1768j = r4     // Catch:{ all -> 0x00a1 }
            r8.f1769k = r2     // Catch:{ all -> 0x00a1 }
            java.lang.Object r2 = r3.invoke(r8)     // Catch:{ all -> 0x00a1 }
            if (r2 != r0) goto L_0x0092
            return r0
        L_0x0092:
            r0 = r1
            r1 = r9
            r9 = r2
            r2 = r6
        L_0x0096:
            java.util.concurrent.atomic.AtomicReference r0 = r0.currentMutator     // Catch:{ all -> 0x00af }
            i.b.a(r0, r2, r4)     // Catch:{ all -> 0x00af }
            r1.unlock(r4)
            return r9
        L_0x00a1:
            r0 = move-exception
            r2 = r6
            r7 = r1
            r1 = r9
            r9 = r0
            r0 = r7
        L_0x00a7:
            java.util.concurrent.atomic.AtomicReference r0 = r0.currentMutator     // Catch:{ all -> 0x00af }
            i.b.a(r0, r2, r4)     // Catch:{ all -> 0x00af }
            throw r9     // Catch:{ all -> 0x00af }
        L_0x00af:
            r9 = move-exception
            r1.unlock(r4)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MutatorMutex$mutate$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
