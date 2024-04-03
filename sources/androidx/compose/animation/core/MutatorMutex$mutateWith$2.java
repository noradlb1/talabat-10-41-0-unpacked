package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H@"}, d2 = {"T", "R", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.compose.animation.core.MutatorMutex$mutateWith$2", f = "InternalMutatorMutex.kt", i = {0, 0, 1, 1}, l = {171, 158}, m = "invokeSuspend", n = {"mutator", "$this$withLock_u24default$iv", "mutator", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class MutatorMutex$mutateWith$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f1352h;

    /* renamed from: i  reason: collision with root package name */
    public Object f1353i;

    /* renamed from: j  reason: collision with root package name */
    public Object f1354j;

    /* renamed from: k  reason: collision with root package name */
    public Object f1355k;

    /* renamed from: l  reason: collision with root package name */
    public int f1356l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutatePriority f1357m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ MutatorMutex f1358n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<T, Continuation<? super R>, Object> f1359o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ T f1360p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutatorMutex$mutateWith$2(MutatePriority mutatePriority, MutatorMutex mutatorMutex, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, T t11, Continuation<? super MutatorMutex$mutateWith$2> continuation) {
        super(2, continuation);
        this.f1357m = mutatePriority;
        this.f1358n = mutatorMutex;
        this.f1359o = function2;
        this.f1360p = t11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MutatorMutex$mutateWith$2 mutatorMutex$mutateWith$2 = new MutatorMutex$mutateWith$2(this.f1357m, this.f1358n, this.f1359o, this.f1360p, continuation);
        mutatorMutex$mutateWith$2.L$0 = obj;
        return mutatorMutex$mutateWith$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super R> continuation) {
        return ((MutatorMutex$mutateWith$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x009e=Splitter:B:20:0x009e, B:26:0x00af=Splitter:B:26:0x00af} */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.f1356l
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0042
            if (r1 == r3) goto L_0x002b
            if (r1 != r2) goto L_0x0023
            java.lang.Object r0 = r9.f1353i
            androidx.compose.animation.core.MutatorMutex r0 = (androidx.compose.animation.core.MutatorMutex) r0
            java.lang.Object r1 = r9.f1352h
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r2 = r9.L$0
            androidx.compose.animation.core.MutatorMutex$Mutator r2 = (androidx.compose.animation.core.MutatorMutex.Mutator) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0020 }
            goto L_0x009e
        L_0x0020:
            r10 = move-exception
            goto L_0x00af
        L_0x0023:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x002b:
            java.lang.Object r1 = r9.f1355k
            androidx.compose.animation.core.MutatorMutex r1 = (androidx.compose.animation.core.MutatorMutex) r1
            java.lang.Object r3 = r9.f1354j
            java.lang.Object r5 = r9.f1353i
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            java.lang.Object r6 = r9.f1352h
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r7 = r9.L$0
            androidx.compose.animation.core.MutatorMutex$Mutator r7 = (androidx.compose.animation.core.MutatorMutex.Mutator) r7
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r6
            goto L_0x0087
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            androidx.compose.animation.core.MutatorMutex$Mutator r1 = new androidx.compose.animation.core.MutatorMutex$Mutator
            androidx.compose.animation.core.MutatePriority r5 = r9.f1357m
            kotlin.coroutines.CoroutineContext r10 = r10.getCoroutineContext()
            kotlinx.coroutines.Job$Key r6 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Element r10 = r10.get(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            kotlinx.coroutines.Job r10 = (kotlinx.coroutines.Job) r10
            r1.<init>(r5, r10)
            androidx.compose.animation.core.MutatorMutex r10 = r9.f1358n
            r10.tryMutateOrCancel(r1)
            androidx.compose.animation.core.MutatorMutex r10 = r9.f1358n
            kotlinx.coroutines.sync.Mutex r10 = r10.mutex
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r5 = r9.f1359o
            T r6 = r9.f1360p
            androidx.compose.animation.core.MutatorMutex r7 = r9.f1358n
            r9.L$0 = r1
            r9.f1352h = r10
            r9.f1353i = r5
            r9.f1354j = r6
            r9.f1355k = r7
            r9.f1356l = r3
            java.lang.Object r3 = r10.lock(r4, r9)
            if (r3 != r0) goto L_0x0083
            return r0
        L_0x0083:
            r3 = r6
            r8 = r7
            r7 = r1
            r1 = r8
        L_0x0087:
            r9.L$0 = r7     // Catch:{ all -> 0x00a9 }
            r9.f1352h = r10     // Catch:{ all -> 0x00a9 }
            r9.f1353i = r1     // Catch:{ all -> 0x00a9 }
            r9.f1354j = r4     // Catch:{ all -> 0x00a9 }
            r9.f1355k = r4     // Catch:{ all -> 0x00a9 }
            r9.f1356l = r2     // Catch:{ all -> 0x00a9 }
            java.lang.Object r2 = r5.invoke(r3, r9)     // Catch:{ all -> 0x00a9 }
            if (r2 != r0) goto L_0x009a
            return r0
        L_0x009a:
            r0 = r1
            r1 = r10
            r10 = r2
            r2 = r7
        L_0x009e:
            java.util.concurrent.atomic.AtomicReference r0 = r0.currentMutator     // Catch:{ all -> 0x00b7 }
            i.b.a(r0, r2, r4)     // Catch:{ all -> 0x00b7 }
            r1.unlock(r4)
            return r10
        L_0x00a9:
            r0 = move-exception
            r2 = r7
            r8 = r1
            r1 = r10
            r10 = r0
            r0 = r8
        L_0x00af:
            java.util.concurrent.atomic.AtomicReference r0 = r0.currentMutator     // Catch:{ all -> 0x00b7 }
            i.b.a(r0, r2, r4)     // Catch:{ all -> 0x00b7 }
            throw r10     // Catch:{ all -> 0x00b7 }
        L_0x00b7:
            r10 = move-exception
            r1.unlock(r4)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.MutatorMutex$mutateWith$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
