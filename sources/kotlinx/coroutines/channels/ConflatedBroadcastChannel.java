package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v0.a;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\b\u0007\u0018\u0000 B*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000G:\u0004CBDEB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004B\u0007¢\u0006\u0004\b\u0003\u0010\u0005J?\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00062\u0014\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0017¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u000f\u001a\u00020\u00132\u000e\u0010\r\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012H\u0016¢\u0006\u0004\b\u000f\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0010J\u001d\u0010\u0016\u001a\u00020\u00132\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001b\u001a\u00020\u00132\u0018\u0010\u001a\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00130\u0018j\u0002`\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016¢\u0006\u0004\b$\u0010%JX\u0010.\u001a\u00020\u0013\"\u0004\b\u0001\u0010&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'2\u0006\u0010\u001f\u001a\u00028\u00002(\u0010-\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000*\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010+\u0012\u0006\u0012\u0004\u0018\u00010,0)H\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010/J?\u00100\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0018\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b0\u0010\u000bJ\u001b\u00101\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b1\u00102J&\u00106\u001a\b\u0012\u0004\u0012\u00020\u0013032\u0006\u0010\u001f\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b4\u00105R\u0014\u00107\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R&\u0010<\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000*098VX\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0017\u0010\u0002\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b?\u0010\u0005\u001a\u0004\b=\u0010>R\u0013\u0010A\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b@\u0010>\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006F"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "E", "value", "<init>", "(Ljava/lang/Object;)V", "()V", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "list", "subscriber", "addSubscriber", "([Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "close", "closeSubscriber", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "element", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "offerInternal", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "removeSubscriber", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "isClosedForSend", "()Z", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "getValue", "()Ljava/lang/Object;", "getValue$annotations", "getValueOrNull", "valueOrNull", "Companion", "Closed", "State", "Subscriber", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/BroadcastChannel;"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ObsoleteCoroutinesApi
public final class ConflatedBroadcastChannel<E> implements BroadcastChannel<E> {
    @NotNull
    @Deprecated
    private static final Closed CLOSED = new Closed((Throwable) null);
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    private static final State<Object> INITIAL_STATE;
    @NotNull
    @Deprecated
    private static final Symbol UNDEFINED;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU;
    private static final /* synthetic */ AtomicIntegerFieldUpdater _updating$FU;
    private static final /* synthetic */ AtomicReferenceFieldUpdater onCloseHandler$FU;
    @NotNull
    private volatile /* synthetic */ Object _state;
    @NotNull
    private volatile /* synthetic */ int _updating;
    @NotNull
    private volatile /* synthetic */ Object onCloseHandler;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "", "closeCause", "", "(Ljava/lang/Throwable;)V", "sendException", "getSendException", "()Ljava/lang/Throwable;", "valueException", "getValueException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Closed {
        @Nullable
        @JvmField
        public final Throwable closeCause;

        public Closed(@Nullable Throwable th2) {
            this.closeCause = th2;
        }

        @NotNull
        public final Throwable getSendException() {
            Throwable th2 = this.closeCause;
            return th2 == null ? new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE) : th2;
        }

        @NotNull
        public final Throwable getValueException() {
            Throwable th2 = this.closeCause;
            return th2 == null ? new IllegalStateException(ChannelsKt.DEFAULT_CLOSE_MESSAGE) : th2;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Companion;", "", "()V", "CLOSED", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "INITIAL_STATE", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", "UNDEFINED", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R \u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", "E", "", "value", "subscribers", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "(Ljava/lang/Object;[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class State<E> {
        @Nullable
        @JvmField
        public final Subscriber<E>[] subscribers;
        @Nullable
        @JvmField
        public final Object value;

        public State(@Nullable Object obj, @Nullable Subscriber<E>[] subscriberArr) {
            this.value = obj;
            this.subscribers = subscriberArr;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/channels/ConflatedChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "wasClosed", "", "t", "element", "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "broadcastChannel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "<init>", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class Subscriber<E> extends ConflatedChannel<E> implements ReceiveChannel<E> {
        @NotNull
        private final ConflatedBroadcastChannel<E> broadcastChannel;

        public Subscriber(@NotNull ConflatedBroadcastChannel<E> conflatedBroadcastChannel) {
            super((Function1) null);
            this.broadcastChannel = conflatedBroadcastChannel;
        }

        @NotNull
        public Object offerInternal(E e11) {
            return super.offerInternal(e11);
        }

        public void t(boolean z11) {
            if (z11) {
                this.broadcastChannel.closeSubscriber(this);
            }
        }
    }

    static {
        Symbol symbol = new Symbol("UNDEFINED");
        UNDEFINED = symbol;
        INITIAL_STATE = new State<>(symbol, (Subscriber<E>[]) null);
        Class<ConflatedBroadcastChannel> cls = ConflatedBroadcastChannel.class;
        Class<Object> cls2 = Object.class;
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state");
        _updating$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "_updating");
        onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "onCloseHandler");
    }

    public ConflatedBroadcastChannel() {
        this._state = INITIAL_STATE;
        this._updating = 0;
        this.onCloseHandler = null;
    }

    private final Subscriber<E>[] addSubscriber(Subscriber<E>[] subscriberArr, Subscriber<E> subscriber) {
        if (subscriberArr != null) {
            return (Subscriber[]) ArraysKt___ArraysJvmKt.plus((T[]) subscriberArr, subscriber);
        }
        return new Subscriber[]{subscriber};
    }

    /* access modifiers changed from: private */
    public final void closeSubscriber(Subscriber<E> subscriber) {
        Object obj;
        Object obj2;
        Subscriber<E>[] subscriberArr;
        do {
            obj = this._state;
            if (!(obj instanceof Closed)) {
                if (obj instanceof State) {
                    State state = (State) obj;
                    obj2 = state.value;
                    subscriberArr = state.subscribers;
                    Intrinsics.checkNotNull(subscriberArr);
                } else {
                    throw new IllegalStateException(("Invalid state " + obj).toString());
                }
            } else {
                return;
            }
        } while (!a.a(_state$FU, this, obj, new State(obj2, removeSubscriber(subscriberArr, subscriber))));
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    private final void invokeOnCloseHandler(Throwable th2) {
        Symbol symbol;
        Object obj = this.onCloseHandler;
        if (obj != null && obj != (symbol = AbstractChannelKt.HANDLER_INVOKED) && a.a(onCloseHandler$FU, this, obj, symbol)) {
            ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1)).invoke(th2);
        }
    }

    private final Closed offerInternal(E e11) {
        Object obj;
        if (!_updating$FU.compareAndSet(this, 0, 1)) {
            return null;
        }
        do {
            try {
                obj = this._state;
                if (obj instanceof Closed) {
                    Closed closed = (Closed) obj;
                    this._updating = 0;
                    return closed;
                } else if (obj instanceof State) {
                } else {
                    throw new IllegalStateException(("Invalid state " + obj).toString());
                }
            } finally {
                this._updating = 0;
            }
        } while (!a.a(_state$FU, this, obj, new State(e11, ((State) obj).subscribers)));
        Subscriber<E>[] subscriberArr = ((State) obj).subscribers;
        if (subscriberArr != null) {
            for (Subscriber<E> offerInternal : subscriberArr) {
                offerInternal.offerInternal(e11);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final <R> void registerSelectSend(SelectInstance<? super R> selectInstance, E e11, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
        if (selectInstance.trySelect()) {
            Closed offerInternal = offerInternal(e11);
            if (offerInternal != null) {
                selectInstance.resumeSelectWithException(offerInternal.getSendException());
            } else {
                UndispatchedKt.startCoroutineUnintercepted(function2, this, selectInstance.getCompletion());
            }
        }
    }

    private final Subscriber<E>[] removeSubscriber(Subscriber<E>[] subscriberArr, Subscriber<E> subscriber) {
        int length = subscriberArr.length;
        int indexOf = ArraysKt___ArraysKt.indexOf((T[]) subscriberArr, subscriber);
        if (length == 1) {
            return null;
        }
        Subscriber<E>[] subscriberArr2 = new Subscriber[(length - 1)];
        Subscriber<E>[] subscriberArr3 = subscriberArr;
        Subscriber<E>[] subscriberArr4 = subscriberArr2;
        Object[] unused = ArraysKt___ArraysJvmKt.copyInto$default((Object[]) subscriberArr3, (Object[]) subscriberArr4, 0, 0, indexOf, 6, (Object) null);
        Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto$default((Object[]) subscriberArr3, (Object[]) subscriberArr4, indexOf, indexOf + 1, 0, 8, (Object) null);
        return subscriberArr2;
    }

    /* renamed from: close */
    public boolean cancel(@Nullable Throwable th2) {
        Object obj;
        int i11;
        Closed closed;
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                return false;
            }
            if (!(obj instanceof State)) {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            } else if (th2 == null) {
                closed = CLOSED;
            } else {
                closed = new Closed(th2);
            }
        } while (!a.a(_state$FU, this, obj, closed));
        Subscriber<E>[] subscriberArr = ((State) obj).subscribers;
        if (subscriberArr != null) {
            for (Subscriber<E> close : subscriberArr) {
                close.close(th2);
            }
        }
        invokeOnCloseHandler(th2);
        return true;
    }

    @NotNull
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return new ConflatedBroadcastChannel$onSend$1(this);
    }

    public final E getValue() {
        Object obj = this._state;
        if (obj instanceof Closed) {
            throw ((Closed) obj).getValueException();
        } else if (obj instanceof State) {
            E e11 = ((State) obj).value;
            if (e11 != UNDEFINED) {
                return e11;
            }
            throw new IllegalStateException("No value");
        } else {
            throw new IllegalStateException(("Invalid state " + obj).toString());
        }
    }

    @Nullable
    public final E getValueOrNull() {
        Object obj = this._state;
        if (obj instanceof Closed) {
            return null;
        }
        if (obj instanceof State) {
            E e11 = UNDEFINED;
            E e12 = ((State) obj).value;
            if (e12 == e11) {
                return null;
            }
            return e12;
        }
        throw new IllegalStateException(("Invalid state " + obj).toString());
    }

    public void invokeOnClose(@NotNull Function1<? super Throwable, Unit> function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = onCloseHandler$FU;
        if (!a.a(atomicReferenceFieldUpdater, this, (Object) null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj == AbstractChannelKt.HANDLER_INVOKED) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        Object obj2 = this._state;
        if ((obj2 instanceof Closed) && a.a(atomicReferenceFieldUpdater, this, function1, AbstractChannelKt.HANDLER_INVOKED)) {
            function1.invoke(((Closed) obj2).closeCause);
        }
    }

    public boolean isClosedForSend() {
        return this._state instanceof Closed;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e11) {
        return BroadcastChannel.DefaultImpls.offer(this, e11);
    }

    @NotNull
    public ReceiveChannel<E> openSubscription() {
        Object obj;
        State state;
        Subscriber subscriber = new Subscriber(this);
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                subscriber.close(((Closed) obj).closeCause);
                return subscriber;
            } else if (obj instanceof State) {
                state = (State) obj;
                Object obj2 = state.value;
                if (obj2 != UNDEFINED) {
                    subscriber.offerInternal(obj2);
                }
            } else {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
        } while (!a.a(_state$FU, this, obj, new State(state.value, addSubscriber(state.subscribers, subscriber))));
        return subscriber;
    }

    @Nullable
    public Object send(E e11, @NotNull Continuation<? super Unit> continuation) {
        Closed offerInternal = offerInternal(e11);
        if (offerInternal != null) {
            throw offerInternal.getSendException();
        } else if (IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() == null) {
            return null;
        } else {
            return Unit.INSTANCE;
        }
    }

    @NotNull
    /* renamed from: trySend-JP2dKIU  reason: not valid java name */
    public Object m7815trySendJP2dKIU(E e11) {
        Closed offerInternal = offerInternal(e11);
        if (offerInternal != null) {
            return ChannelResult.Companion.m7812closedJP2dKIU(offerInternal.getSendException());
        }
        return ChannelResult.Companion.m7814successJP2dKIU(Unit.INSTANCE);
    }

    public void cancel(@Nullable CancellationException cancellationException) {
        cancel(cancellationException);
    }

    public ConflatedBroadcastChannel(E e11) {
        this();
        _state$FU.lazySet(this, new State(e11, (Subscriber<E>[]) null));
    }
}
