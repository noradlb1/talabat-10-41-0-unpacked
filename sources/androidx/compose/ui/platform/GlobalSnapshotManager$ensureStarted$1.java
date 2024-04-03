package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1", f = "GlobalSnapshotManager.android.kt", i = {0}, l = {63}, m = "invokeSuspend", n = {"$this$consume$iv$iv"}, s = {"L$0"})
public final class GlobalSnapshotManager$ensureStarted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f10034h;

    /* renamed from: i  reason: collision with root package name */
    public Object f10035i;

    /* renamed from: j  reason: collision with root package name */
    public int f10036j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Channel<Unit> f10037k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalSnapshotManager$ensureStarted$1(Channel<Unit> channel, Continuation<? super GlobalSnapshotManager$ensureStarted$1> continuation) {
        super(2, continuation);
        this.f10037k = channel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlobalSnapshotManager$ensureStarted$1(this.f10037k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlobalSnapshotManager$ensureStarted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049 A[Catch:{ all -> 0x0060 }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f10036j
            r2 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 != r2) goto L_0x001b
            java.lang.Object r1 = r6.f10035i
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r3 = r6.f10034h
            kotlinx.coroutines.channels.ReceiveChannel r3 = (kotlinx.coroutines.channels.ReceiveChannel) r3
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0063 }
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
            goto L_0x0041
        L_0x001b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r3 = r6.f10037k
            kotlinx.coroutines.channels.ChannelIterator r7 = r3.iterator()     // Catch:{ all -> 0x0063 }
            r1 = r7
            r7 = r6
        L_0x002e:
            r7.f10034h = r3     // Catch:{ all -> 0x0063 }
            r7.f10035i = r1     // Catch:{ all -> 0x0063 }
            r7.f10036j = r2     // Catch:{ all -> 0x0063 }
            java.lang.Object r4 = r1.hasNext(r7)     // Catch:{ all -> 0x0063 }
            if (r4 != r0) goto L_0x003b
            return r0
        L_0x003b:
            r5 = r0
            r0 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r5
        L_0x0041:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0060 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0060 }
            if (r7 == 0) goto L_0x0059
            java.lang.Object r7 = r3.next()     // Catch:{ all -> 0x0060 }
            kotlin.Unit r7 = (kotlin.Unit) r7     // Catch:{ all -> 0x0060 }
            androidx.compose.runtime.snapshots.Snapshot$Companion r7 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0060 }
            r7.sendApplyNotifications()     // Catch:{ all -> 0x0060 }
            r7 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L_0x002e
        L_0x0059:
            r7 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0060:
            r7 = move-exception
            r3 = r4
            goto L_0x0064
        L_0x0063:
            r7 = move-exception
        L_0x0064:
            throw r7     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r3, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
