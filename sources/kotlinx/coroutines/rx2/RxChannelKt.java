package kotlinx.coroutines.rx2;

import io.reactivex.MaybeSource;
import io.reactivex.ObservableSource;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a5\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0007\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0001\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"collect", "", "T", "Lio/reactivex/MaybeSource;", "action", "Lkotlin/Function1;", "(Lio/reactivex/MaybeSource;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/reactivex/ObservableSource;", "(Lio/reactivex/ObservableSource;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "toChannel", "kotlinx-coroutines-rx2"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RxChannelKt {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object collect(@org.jetbrains.annotations.NotNull io.reactivex.MaybeSource<T> r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.rx2.RxChannelKt$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.rx2.RxChannelKt$collect$1 r0 = (kotlinx.coroutines.rx2.RxChannelKt$collect$1) r0
            int r1 = r0.f26297l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26297l = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx2.RxChannelKt$collect$1 r0 = new kotlinx.coroutines.rx2.RxChannelKt$collect$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.f26296k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f26297l
            r3 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r5 = r0.f26295j
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r0.f26294i
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r2 = r0.f26293h
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x003a }
            r4 = r0
            r0 = r6
            r6 = r2
        L_0x0037:
            r2 = r1
            r1 = r4
            goto L_0x0065
        L_0x003a:
            r5 = move-exception
            goto L_0x008f
        L_0x003c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.channels.ReceiveChannel r5 = toChannel(r5)
            kotlinx.coroutines.channels.ChannelIterator r7 = r5.iterator()     // Catch:{ all -> 0x008b }
            r4 = r7
            r7 = r5
            r5 = r4
        L_0x0052:
            r0.f26293h = r6     // Catch:{ all -> 0x0088 }
            r0.f26294i = r7     // Catch:{ all -> 0x0088 }
            r0.f26295j = r5     // Catch:{ all -> 0x0088 }
            r0.f26297l = r3     // Catch:{ all -> 0x0088 }
            java.lang.Object r2 = r5.hasNext(r0)     // Catch:{ all -> 0x0088 }
            if (r2 != r1) goto L_0x0061
            return r1
        L_0x0061:
            r4 = r0
            r0 = r7
            r7 = r2
            goto L_0x0037
        L_0x0065:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0085 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0085 }
            if (r7 == 0) goto L_0x0078
            java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x0085 }
            r6.invoke(r7)     // Catch:{ all -> 0x0085 }
            r7 = r0
            r0 = r1
            r1 = r2
            goto L_0x0052
        L_0x0078:
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            r5 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r0, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0085:
            r5 = move-exception
            r6 = r0
            goto L_0x008f
        L_0x0088:
            r5 = move-exception
            r6 = r7
            goto L_0x008f
        L_0x008b:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L_0x008f:
            throw r5     // Catch:{ all -> 0x0090 }
        L_0x0090:
            r7 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxChannelKt.collect(io.reactivex.MaybeSource, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r3, r4);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> java.lang.Object collect$$forInline(io.reactivex.MaybeSource<T> r3, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r4, kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            kotlinx.coroutines.channels.ReceiveChannel r3 = toChannel(r3)
            r5 = 1
            kotlinx.coroutines.channels.ChannelIterator r0 = r3.iterator()     // Catch:{ all -> 0x0037 }
        L_0x0009:
            r1 = 3
            kotlin.jvm.internal.InlineMarker.mark((int) r1)     // Catch:{ all -> 0x0037 }
            r1 = 0
            kotlin.jvm.internal.InlineMarker.mark((int) r1)     // Catch:{ all -> 0x0037 }
            r1 = 0
            java.lang.Object r2 = r0.hasNext(r1)     // Catch:{ all -> 0x0037 }
            kotlin.jvm.internal.InlineMarker.mark((int) r5)     // Catch:{ all -> 0x0037 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x0037 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0037 }
            if (r2 == 0) goto L_0x0029
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0037 }
            r4.invoke(r1)     // Catch:{ all -> 0x0037 }
            goto L_0x0009
        L_0x0029:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0037 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r3, r1)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        L_0x0037:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r0 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r3, r4)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxChannelKt.collect$$forInline(io.reactivex.MaybeSource, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of Flow")
    public static final /* synthetic */ ReceiveChannel openSubscription(ObservableSource observableSource) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel();
        observableSource.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }

    @NotNull
    @PublishedApi
    public static final <T> ReceiveChannel<T> toChannel(@NotNull MaybeSource<T> maybeSource) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel();
        maybeSource.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of Flow")
    public static final /* synthetic */ ReceiveChannel openSubscription(MaybeSource maybeSource) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel();
        maybeSource.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }

    @NotNull
    @PublishedApi
    public static final <T> ReceiveChannel<T> toChannel(@NotNull ObservableSource<T> observableSource) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel();
        observableSource.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r3, r4);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> java.lang.Object collect$$forInline(io.reactivex.ObservableSource<T> r3, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r4, kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            kotlinx.coroutines.channels.ReceiveChannel r3 = toChannel(r3)
            r5 = 1
            kotlinx.coroutines.channels.ChannelIterator r0 = r3.iterator()     // Catch:{ all -> 0x0037 }
        L_0x0009:
            r1 = 3
            kotlin.jvm.internal.InlineMarker.mark((int) r1)     // Catch:{ all -> 0x0037 }
            r1 = 0
            kotlin.jvm.internal.InlineMarker.mark((int) r1)     // Catch:{ all -> 0x0037 }
            r1 = 0
            java.lang.Object r2 = r0.hasNext(r1)     // Catch:{ all -> 0x0037 }
            kotlin.jvm.internal.InlineMarker.mark((int) r5)     // Catch:{ all -> 0x0037 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x0037 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0037 }
            if (r2 == 0) goto L_0x0029
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0037 }
            r4.invoke(r1)     // Catch:{ all -> 0x0037 }
            goto L_0x0009
        L_0x0029:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0037 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r3, r1)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        L_0x0037:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r0 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r3, r4)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxChannelKt.collect$$forInline(io.reactivex.ObservableSource, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object collect(@org.jetbrains.annotations.NotNull io.reactivex.ObservableSource<T> r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.rx2.RxChannelKt$collect$2
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.rx2.RxChannelKt$collect$2 r0 = (kotlinx.coroutines.rx2.RxChannelKt$collect$2) r0
            int r1 = r0.f26302l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26302l = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx2.RxChannelKt$collect$2 r0 = new kotlinx.coroutines.rx2.RxChannelKt$collect$2
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.f26301k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f26302l
            r3 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r5 = r0.f26300j
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r0.f26299i
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r2 = r0.f26298h
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x003a }
            r4 = r0
            r0 = r6
            r6 = r2
        L_0x0037:
            r2 = r1
            r1 = r4
            goto L_0x0065
        L_0x003a:
            r5 = move-exception
            goto L_0x008f
        L_0x003c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.channels.ReceiveChannel r5 = toChannel(r5)
            kotlinx.coroutines.channels.ChannelIterator r7 = r5.iterator()     // Catch:{ all -> 0x008b }
            r4 = r7
            r7 = r5
            r5 = r4
        L_0x0052:
            r0.f26298h = r6     // Catch:{ all -> 0x0088 }
            r0.f26299i = r7     // Catch:{ all -> 0x0088 }
            r0.f26300j = r5     // Catch:{ all -> 0x0088 }
            r0.f26302l = r3     // Catch:{ all -> 0x0088 }
            java.lang.Object r2 = r5.hasNext(r0)     // Catch:{ all -> 0x0088 }
            if (r2 != r1) goto L_0x0061
            return r1
        L_0x0061:
            r4 = r0
            r0 = r7
            r7 = r2
            goto L_0x0037
        L_0x0065:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0085 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0085 }
            if (r7 == 0) goto L_0x0078
            java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x0085 }
            r6.invoke(r7)     // Catch:{ all -> 0x0085 }
            r7 = r0
            r0 = r1
            r1 = r2
            goto L_0x0052
        L_0x0078:
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            r5 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r0, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0085:
            r5 = move-exception
            r6 = r0
            goto L_0x008f
        L_0x0088:
            r5 = move-exception
            r6 = r7
            goto L_0x008f
        L_0x008b:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L_0x008f:
            throw r5     // Catch:{ all -> 0x0090 }
        L_0x0090:
            r7 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxChannelKt.collect(io.reactivex.ObservableSource, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
