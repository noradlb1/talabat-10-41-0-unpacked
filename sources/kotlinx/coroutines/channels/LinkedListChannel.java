package kotlinx.coroutines.channels;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.AbstractSendChannel;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010\u001f\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u001e¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0011\u001a\u00020\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138DX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00138DX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00138DX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00138DX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Lkotlinx/coroutines/channels/LinkedListChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "element", "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "j", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "list", "Lkotlinx/coroutines/channels/Closed;", "closed", "", "u", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "", "q", "()Z", "isBufferAlwaysEmpty", "r", "isBufferEmpty", "h", "isBufferAlwaysFull", "i", "isBufferFull", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class LinkedListChannel<E> extends AbstractChannel<E> {
    public LinkedListChannel(@Nullable Function1<? super E, Unit> function1) {
        super(function1);
    }

    public final boolean h() {
        return false;
    }

    public final boolean i() {
        return false;
    }

    @NotNull
    public Object j(E e11, @NotNull SelectInstance<?> selectInstance) {
        Object obj;
        while (true) {
            if (p()) {
                obj = super.j(e11, selectInstance);
            } else {
                obj = selectInstance.performAtomicTrySelect(a(e11));
                if (obj == null) {
                    obj = AbstractChannelKt.OFFER_SUCCESS;
                }
            }
            if (obj == SelectKt.getALREADY_SELECTED()) {
                return SelectKt.getALREADY_SELECTED();
            }
            Symbol symbol = AbstractChannelKt.OFFER_SUCCESS;
            if (obj == symbol) {
                return symbol;
            }
            if (obj != AbstractChannelKt.OFFER_FAILED && obj != AtomicKt.RETRY_ATOMIC) {
                if (obj instanceof Closed) {
                    return obj;
                }
                throw new IllegalStateException(("Invalid result " + obj).toString());
            }
        }
    }

    @NotNull
    public Object offerInternal(E e11) {
        ReceiveOrClosed<?> k11;
        do {
            Object offerInternal = super.offerInternal(e11);
            Symbol symbol = AbstractChannelKt.OFFER_SUCCESS;
            if (offerInternal == symbol) {
                return symbol;
            }
            if (offerInternal == AbstractChannelKt.OFFER_FAILED) {
                k11 = k(e11);
                if (k11 == null) {
                    return symbol;
                }
            } else if (offerInternal instanceof Closed) {
                return offerInternal;
            } else {
                throw new IllegalStateException(("Invalid offerInternal result " + offerInternal).toString());
            }
        } while (!(k11 instanceof Closed));
        return k11;
    }

    public final boolean q() {
        return true;
    }

    public final boolean r() {
        return true;
    }

    public void u(@NotNull Object obj, @NotNull Closed<?> closed) {
        UndeliveredElementException undeliveredElementException = null;
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                Send send = (Send) obj;
                if (send instanceof AbstractSendChannel.SendBuffered) {
                    Function1<E, Unit> function1 = this.f25156b;
                    if (function1 != null) {
                        undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, ((AbstractSendChannel.SendBuffered) send).element, (UndeliveredElementException) null);
                    }
                } else {
                    send.resumeSendClosed(closed);
                }
            } else {
                ArrayList arrayList = (ArrayList) obj;
                UndeliveredElementException undeliveredElementException2 = null;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    Send send2 = (Send) arrayList.get(size);
                    if (send2 instanceof AbstractSendChannel.SendBuffered) {
                        Function1<E, Unit> function12 = this.f25156b;
                        if (function12 != null) {
                            undeliveredElementException2 = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function12, ((AbstractSendChannel.SendBuffered) send2).element, undeliveredElementException2);
                        } else {
                            undeliveredElementException2 = null;
                        }
                    } else {
                        send2.resumeSendClosed(closed);
                    }
                }
                undeliveredElementException = undeliveredElementException2;
            }
        }
        if (undeliveredElementException != null) {
            throw undeliveredElementException;
        }
    }
}
