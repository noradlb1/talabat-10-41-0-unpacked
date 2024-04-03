package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", i = {}, l = {122, 122}, m = "invokeSuspend", n = {}, s = {})
public final class SimpleActor$offer$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f35626h;

    /* renamed from: i  reason: collision with root package name */
    public int f35627i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SimpleActor<T> f35628j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleActor$offer$2(SimpleActor<T> simpleActor, Continuation<? super SimpleActor$offer$2> continuation) {
        super(2, continuation);
        this.f35628j = simpleActor;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SimpleActor$offer$2(this.f35628j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SimpleActor$offer$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.f35627i
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0026
            if (r1 == r3) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r7
            goto L_0x006e
        L_0x0013:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001b:
            java.lang.Object r1 = r7.f35626h
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            kotlin.ResultKt.throwOnFailure(r8)
            r4 = r1
            r1 = r0
            r0 = r7
            goto L_0x0060
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.datastore.core.SimpleActor<T> r8 = r7.f35628j
            java.util.concurrent.atomic.AtomicInteger r8 = r8.remainingMessages
            int r8 = r8.get()
            if (r8 <= 0) goto L_0x0037
            r8 = r3
            goto L_0x0038
        L_0x0037:
            r8 = 0
        L_0x0038:
            if (r8 == 0) goto L_0x007d
            r8 = r7
        L_0x003b:
            androidx.datastore.core.SimpleActor<T> r1 = r8.f35628j
            kotlinx.coroutines.CoroutineScope r1 = r1.scope
            kotlinx.coroutines.CoroutineScopeKt.ensureActive(r1)
            androidx.datastore.core.SimpleActor<T> r1 = r8.f35628j
            kotlin.jvm.functions.Function2 r1 = r1.consumeMessage
            androidx.datastore.core.SimpleActor<T> r4 = r8.f35628j
            kotlinx.coroutines.channels.Channel r4 = r4.messageQueue
            r8.f35626h = r1
            r8.f35627i = r3
            java.lang.Object r4 = r4.receive(r8)
            if (r4 != r0) goto L_0x005b
            return r0
        L_0x005b:
            r6 = r0
            r0 = r8
            r8 = r4
            r4 = r1
            r1 = r6
        L_0x0060:
            r5 = 0
            r0.f35626h = r5
            r0.f35627i = r2
            java.lang.Object r8 = r4.invoke(r8, r0)
            if (r8 != r1) goto L_0x006c
            return r1
        L_0x006c:
            r8 = r0
            r0 = r1
        L_0x006e:
            androidx.datastore.core.SimpleActor<T> r1 = r8.f35628j
            java.util.concurrent.atomic.AtomicInteger r1 = r1.remainingMessages
            int r1 = r1.decrementAndGet()
            if (r1 != 0) goto L_0x003b
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x007d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor$offer$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
