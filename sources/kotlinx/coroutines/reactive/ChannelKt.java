package kotlinx.coroutines.reactive;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a(\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a(\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nH\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"collect", "", "T", "Lorg/reactivestreams/Publisher;", "action", "Lkotlin/Function1;", "(Lorg/reactivestreams/Publisher;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "request", "", "toChannel", "kotlinx-coroutines-reactive"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ChannelKt {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006f A[Catch:{ all -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object collect(@org.jetbrains.annotations.NotNull org.reactivestreams.Publisher<T> r6, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.reactive.ChannelKt$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.reactive.ChannelKt$collect$1 r0 = (kotlinx.coroutines.reactive.ChannelKt$collect$1) r0
            int r1 = r0.f26224l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26224l = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.reactive.ChannelKt$collect$1 r0 = new kotlinx.coroutines.reactive.ChannelKt$collect$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.f26223k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f26224l
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 != r4) goto L_0x003d
            java.lang.Object r6 = r0.f26222j
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.f26221i
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.f26220h
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x003b }
            r5 = r0
            r0 = r7
            r7 = r2
        L_0x0038:
            r2 = r1
            r1 = r5
            goto L_0x0067
        L_0x003b:
            r6 = move-exception
            goto L_0x0090
        L_0x003d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = 0
            kotlinx.coroutines.channels.ReceiveChannel r6 = toChannel$default(r6, r8, r4, r3)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x008c }
            r5 = r8
            r8 = r6
            r6 = r5
        L_0x0054:
            r0.f26220h = r7     // Catch:{ all -> 0x0089 }
            r0.f26221i = r8     // Catch:{ all -> 0x0089 }
            r0.f26222j = r6     // Catch:{ all -> 0x0089 }
            r0.f26224l = r4     // Catch:{ all -> 0x0089 }
            java.lang.Object r2 = r6.hasNext(r0)     // Catch:{ all -> 0x0089 }
            if (r2 != r1) goto L_0x0063
            return r1
        L_0x0063:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L_0x0038
        L_0x0067:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0086 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0086 }
            if (r8 == 0) goto L_0x007a
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x0086 }
            r7.invoke(r8)     // Catch:{ all -> 0x0086 }
            r8 = r0
            r0 = r1
            r1 = r2
            goto L_0x0054
        L_0x007a:
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r0, r3)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0086:
            r6 = move-exception
            r7 = r0
            goto L_0x0090
        L_0x0089:
            r6 = move-exception
            r7 = r8
            goto L_0x0090
        L_0x008c:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x0090:
            throw r6     // Catch:{ all -> 0x0091 }
        L_0x0091:
            r8 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r6)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.ChannelKt.collect(org.reactivestreams.Publisher, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r5);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> java.lang.Object collect$$forInline(org.reactivestreams.Publisher<T> r4, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r6 = 0
            r0 = 1
            r1 = 0
            kotlinx.coroutines.channels.ReceiveChannel r4 = toChannel$default(r4, r6, r0, r1)
            kotlinx.coroutines.channels.ChannelIterator r2 = r4.iterator()     // Catch:{ all -> 0x0037 }
        L_0x000b:
            r3 = 3
            kotlin.jvm.internal.InlineMarker.mark((int) r3)     // Catch:{ all -> 0x0037 }
            kotlin.jvm.internal.InlineMarker.mark((int) r6)     // Catch:{ all -> 0x0037 }
            java.lang.Object r3 = r2.hasNext(r1)     // Catch:{ all -> 0x0037 }
            kotlin.jvm.internal.InlineMarker.mark((int) r0)     // Catch:{ all -> 0x0037 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0037 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0037 }
            if (r3 == 0) goto L_0x0029
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0037 }
            r5.invoke(r3)     // Catch:{ all -> 0x0037 }
            goto L_0x000b
        L_0x0029:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0037 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r1)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x0037:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r6 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.ChannelKt.collect$$forInline(org.reactivestreams.Publisher, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Transforming publisher to channel is deprecated, use asFlow() instead")
    public static final /* synthetic */ ReceiveChannel openSubscription(Publisher publisher, int i11) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel(i11);
        publisher.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }

    public static /* synthetic */ ReceiveChannel openSubscription$default(Publisher publisher, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 1;
        }
        return openSubscription(publisher, i11);
    }

    @NotNull
    @PublishedApi
    public static final <T> ReceiveChannel<T> toChannel(@NotNull Publisher<T> publisher, int i11) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel(i11);
        publisher.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }

    public static /* synthetic */ ReceiveChannel toChannel$default(Publisher publisher, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 1;
        }
        return toChannel(publisher, i11);
    }
}
