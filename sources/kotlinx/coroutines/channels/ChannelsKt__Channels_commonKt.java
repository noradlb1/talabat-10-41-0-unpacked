package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0001\u001aC\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\t0\n2\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0004\u0012\u0004\u0012\u0002H\b0\f¢\u0006\u0002\b\rH\b¢\u0006\u0002\u0010\u000e\u001aP\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\t0\u00042\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0004\u0012\u0004\u0012\u0002H\b0\f¢\u0006\u0002\b\rH\b\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000f\u001a5\u0010\u0010\u001a\u00020\u0003\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00030\fHHø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a5\u0010\u0010\u001a\u00020\u0003\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00030\fHHø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a$\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\t0\u0015\"\b\b\u0000\u0010\t*\u00020\u0016*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0007\u001a'\u0010\u0017\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\u0016*\b\u0012\u0004\u0012\u0002H\t0\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a'\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\t0\u001a\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"DEFAULT_CLOSE_MESSAGE", "", "cancelConsumed", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "cause", "", "consume", "R", "E", "Lkotlinx/coroutines/channels/BroadcastChannel;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", "action", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause1;", "", "receiveOrNull", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toList", "", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
final /* synthetic */ class ChannelsKt__Channels_commonKt {
    @PublishedApi
    public static final void cancelConsumed(@NotNull ReceiveChannel<?> receiveChannel, @Nullable Throwable th2) {
        CancellationException cancellationException = null;
        if (th2 != null) {
            if (th2 instanceof CancellationException) {
                cancellationException = (CancellationException) th2;
            }
            if (cancellationException == null) {
                cancellationException = ExceptionsKt.CancellationException("Channel was consumed, consumer had failed", th2);
            }
        }
        receiveChannel.cancel(cancellationException);
    }

    @ObsoleteCoroutinesApi
    public static final <E, R> R consume(@NotNull BroadcastChannel<E> broadcastChannel, @NotNull Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
        try {
            return function1.invoke(openSubscription);
        } finally {
            InlineMarker.finallyStart(1);
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) openSubscription, (CancellationException) null, 1, (Object) null);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object consumeEach(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, kotlin.Unit> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1) r0
            int r1 = r0.f25177l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25177l = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.f25176k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f25177l
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r5 = r0.f25175j
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r0.f25174i
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r2 = r0.f25173h
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0035 }
            goto L_0x005c
        L_0x0035:
            r5 = move-exception
            goto L_0x0080
        L_0x0037:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.channels.ChannelIterator r7 = r5.iterator()     // Catch:{ all -> 0x007c }
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L_0x004a:
            r0.f25173h = r7     // Catch:{ all -> 0x0035 }
            r0.f25174i = r6     // Catch:{ all -> 0x0035 }
            r0.f25175j = r5     // Catch:{ all -> 0x0035 }
            r0.f25177l = r3     // Catch:{ all -> 0x0035 }
            java.lang.Object r2 = r5.hasNext(r0)     // Catch:{ all -> 0x0035 }
            if (r2 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r4 = r2
            r2 = r7
            r7 = r4
        L_0x005c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0035 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0035 }
            if (r7 == 0) goto L_0x006d
            java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x0035 }
            r2.invoke(r7)     // Catch:{ all -> 0x0035 }
            r7 = r2
            goto L_0x004a
        L_0x006d:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0035 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            r5 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x007c:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L_0x0080:
            throw r5     // Catch:{ all -> 0x0081 }
        L_0x0081:
            r7 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.consumeEach(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r3, r4);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <E> java.lang.Object consumeEach$$forInline(kotlinx.coroutines.channels.ReceiveChannel<? extends E> r3, kotlin.jvm.functions.Function1<? super E, kotlin.Unit> r4, kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r5 = 1
            kotlinx.coroutines.channels.ChannelIterator r0 = r3.iterator()     // Catch:{ all -> 0x0033 }
        L_0x0005:
            r1 = 3
            kotlin.jvm.internal.InlineMarker.mark((int) r1)     // Catch:{ all -> 0x0033 }
            r1 = 0
            kotlin.jvm.internal.InlineMarker.mark((int) r1)     // Catch:{ all -> 0x0033 }
            r1 = 0
            java.lang.Object r2 = r0.hasNext(r1)     // Catch:{ all -> 0x0033 }
            kotlin.jvm.internal.InlineMarker.mark((int) r5)     // Catch:{ all -> 0x0033 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x0033 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x0025
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0033 }
            r4.invoke(r1)     // Catch:{ all -> 0x0033 }
            goto L_0x0005
        L_0x0025:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0033 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r3, r1)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        L_0x0033:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0035 }
        L_0x0035:
            r0 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r3, r4)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.consumeEach$$forInline(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'onReceiveCatching'")
    public static final <E> SelectClause1<E> onReceiveOrNull(@NotNull ReceiveChannel<? extends E> receiveChannel) {
        return receiveChannel.getOnReceiveOrNull();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @Nullable
    public static final <E> Object receiveOrNull(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super E> continuation) {
        return receiveChannel.receiveOrNull(continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006f A[Catch:{ all -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object toList(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends E>> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1) r0
            int r1 = r0.f25188m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25188m = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.f25187l
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f25188m
            r3 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r7 = r0.f25186k
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r2 = r0.f25185j
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            java.lang.Object r4 = r0.f25184i
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r0.f25183h
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0039 }
            goto L_0x0067
        L_0x0039:
            r7 = move-exception
            r8 = r2
            goto L_0x0089
        L_0x003c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.List r8 = kotlin.collections.CollectionsKt__CollectionsJVMKt.createListBuilder()
            kotlinx.coroutines.channels.ChannelIterator r2 = r7.iterator()     // Catch:{ all -> 0x0085 }
            r4 = r8
            r5 = r4
            r8 = r7
            r7 = r2
        L_0x0053:
            r0.f25183h = r5     // Catch:{ all -> 0x0083 }
            r0.f25184i = r4     // Catch:{ all -> 0x0083 }
            r0.f25185j = r8     // Catch:{ all -> 0x0083 }
            r0.f25186k = r7     // Catch:{ all -> 0x0083 }
            r0.f25188m = r3     // Catch:{ all -> 0x0083 }
            java.lang.Object r2 = r7.hasNext(r0)     // Catch:{ all -> 0x0083 }
            if (r2 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r6 = r2
            r2 = r8
            r8 = r6
        L_0x0067:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0039 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0039 }
            if (r8 == 0) goto L_0x0078
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x0039 }
            r4.add(r8)     // Catch:{ all -> 0x0039 }
            r8 = r2
            goto L_0x0053
        L_0x0078:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0039 }
            r7 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r2, r7)
            java.util.List r7 = kotlin.collections.CollectionsKt__CollectionsJVMKt.build(r5)
            return r7
        L_0x0083:
            r7 = move-exception
            goto L_0x0089
        L_0x0085:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x0089:
            throw r7     // Catch:{ all -> 0x008a }
        L_0x008a:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r8, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.toList(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r2, r3);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, R> R consume(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlinx.coroutines.channels.ReceiveChannel<? extends E>, ? extends R> r3) {
        /*
            r0 = 1
            java.lang.Object r3 = r3.invoke(r2)     // Catch:{ all -> 0x0010 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            r1 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r2, r1)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            return r3
        L_0x0010:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0012 }
        L_0x0012:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r2, r3)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.consume(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    @ObsoleteCoroutinesApi
    private static final <E> Object consumeEach$$forInline(BroadcastChannel<E> broadcastChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
        try {
            ChannelIterator<E> it = openSubscription.iterator();
            while (true) {
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                Object hasNext = it.hasNext((Continuation<? super Boolean>) null);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    function1.invoke(it.next());
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) openSubscription, (CancellationException) null, 1, (Object) null);
                    InlineMarker.finallyEnd(1);
                    return Unit.INSTANCE;
                }
            }
        } catch (Throwable th2) {
            InlineMarker.finallyStart(1);
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) openSubscription, (CancellationException) null, 1, (Object) null);
            InlineMarker.finallyEnd(1);
            throw th2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006e A[Catch:{ all -> 0x0087 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    @kotlinx.coroutines.ObsoleteCoroutinesApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object consumeEach(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.BroadcastChannel<E> r6, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, kotlin.Unit> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3) r0
            int r1 = r0.f25182l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25182l = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3 r0 = new kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.f25181k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f25182l
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 != r4) goto L_0x003d
            java.lang.Object r6 = r0.f25180j
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.f25179i
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.f25178h
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x003b }
            r5 = r0
            r0 = r7
            r7 = r2
        L_0x0038:
            r2 = r1
            r1 = r5
            goto L_0x0066
        L_0x003b:
            r6 = move-exception
            goto L_0x0091
        L_0x003d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.channels.ReceiveChannel r6 = r6.openSubscription()
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x008d }
            r5 = r8
            r8 = r6
            r6 = r5
        L_0x0053:
            r0.f25178h = r7     // Catch:{ all -> 0x008a }
            r0.f25179i = r8     // Catch:{ all -> 0x008a }
            r0.f25180j = r6     // Catch:{ all -> 0x008a }
            r0.f25182l = r4     // Catch:{ all -> 0x008a }
            java.lang.Object r2 = r6.hasNext(r0)     // Catch:{ all -> 0x008a }
            if (r2 != r1) goto L_0x0062
            return r1
        L_0x0062:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L_0x0038
        L_0x0066:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0087 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0087 }
            if (r8 == 0) goto L_0x0079
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x0087 }
            r7.invoke(r8)     // Catch:{ all -> 0x0087 }
            r8 = r0
            r0 = r1
            r1 = r2
            goto L_0x0053
        L_0x0079:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0087 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default((kotlinx.coroutines.channels.ReceiveChannel) r0, (java.util.concurrent.CancellationException) r3, (int) r4, (java.lang.Object) r3)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0087:
            r6 = move-exception
            r7 = r0
            goto L_0x0091
        L_0x008a:
            r6 = move-exception
            r7 = r8
            goto L_0x0091
        L_0x008d:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x0091:
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default((kotlinx.coroutines.channels.ReceiveChannel) r7, (java.util.concurrent.CancellationException) r3, (int) r4, (java.lang.Object) r3)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.consumeEach(kotlinx.coroutines.channels.BroadcastChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
