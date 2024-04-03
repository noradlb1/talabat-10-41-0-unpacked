package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0015\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0013\u0010\u001b\u001a\u0004\u0018\u00018\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u001cR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/reactive/ReactiveSubscriber;", "T", "", "Lorg/reactivestreams/Subscriber;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "requestSize", "", "(ILkotlinx/coroutines/channels/BufferOverflow;J)V", "channel", "Lkotlinx/coroutines/channels/Channel;", "subscription", "Lorg/reactivestreams/Subscription;", "cancel", "", "makeRequest", "onComplete", "onError", "t", "", "onNext", "value", "(Ljava/lang/Object;)V", "onSubscribe", "s", "takeNextOrNull", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class ReactiveSubscriber<T> implements Subscriber<T> {
    @NotNull
    private final Channel<T> channel;
    private final long requestSize;
    private Subscription subscription;

    public ReactiveSubscriber(int i11, @NotNull BufferOverflow bufferOverflow, long j11) {
        this.requestSize = j11;
        this.channel = ChannelKt.Channel$default(i11 == 0 ? 1 : i11, bufferOverflow, (Function1) null, 4, (Object) null);
    }

    public final void cancel() {
        Subscription subscription2 = this.subscription;
        if (subscription2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscription");
            subscription2 = null;
        }
        subscription2.cancel();
    }

    public final void makeRequest() {
        Subscription subscription2 = this.subscription;
        if (subscription2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscription");
            subscription2 = null;
        }
        subscription2.request(this.requestSize);
    }

    public void onComplete() {
        SendChannel.DefaultImpls.close$default(this.channel, (Throwable) null, 1, (Object) null);
    }

    public void onError(@Nullable Throwable th2) {
        this.channel.close(th2);
    }

    public void onNext(@NotNull T t11) {
        if (!ChannelResult.m7809isSuccessimpl(this.channel.m7820trySendJP2dKIU(t11))) {
            throw new IllegalArgumentException(("Element " + t11 + " was not added to channel because it was full, " + this.channel).toString());
        }
    }

    public void onSubscribe(@NotNull Subscription subscription2) {
        this.subscription = subscription2;
        makeRequest();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object takeNextOrNull(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.reactive.ReactiveSubscriber$takeNextOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.reactive.ReactiveSubscriber$takeNextOrNull$1 r0 = (kotlinx.coroutines.reactive.ReactiveSubscriber$takeNextOrNull$1) r0
            int r1 = r0.f26263j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26263j = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.reactive.ReactiveSubscriber$takeNextOrNull$1 r0 = new kotlinx.coroutines.reactive.ReactiveSubscriber$takeNextOrNull$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f26261h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f26263j
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r5)
            kotlinx.coroutines.channels.ChannelResult r5 = (kotlinx.coroutines.channels.ChannelResult) r5
            java.lang.Object r5 = r5.m7811unboximpl()
            goto L_0x0045
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlinx.coroutines.channels.Channel<T> r5 = r4.channel
            r0.f26263j = r3
            java.lang.Object r5 = r5.m7817receiveCatchingJP2dKIU(r0)
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            java.lang.Throwable r0 = kotlinx.coroutines.channels.ChannelResult.m7803exceptionOrNullimpl(r5)
            if (r0 != 0) goto L_0x0054
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.ChannelResult.Failed
            if (r0 == 0) goto L_0x0053
            kotlinx.coroutines.channels.ChannelResult.m7803exceptionOrNullimpl(r5)
            r5 = 0
        L_0x0053:
            return r5
        L_0x0054:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.ReactiveSubscriber.takeNextOrNull(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
