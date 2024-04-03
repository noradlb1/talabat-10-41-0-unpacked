package kotlin.sequences;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\t\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"kotlin/sequences/GeneratorSequence$iterator$1", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GeneratorSequence$iterator$1 implements Iterator<T>, KMappedMarker, j$.util.Iterator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GeneratorSequence<T> f24991b;
    @Nullable
    private T nextItem;
    private int nextState = -2;

    public GeneratorSequence$iterator$1(GeneratorSequence<T> generatorSequence) {
        this.f24991b = generatorSequence;
    }

    private final void calcNext() {
        T t11;
        int i11;
        if (this.nextState == -2) {
            t11 = this.f24991b.getInitialValue.invoke();
        } else {
            Function1 access$getGetNextValue$p = this.f24991b.getNextValue;
            T t12 = this.nextItem;
            Intrinsics.checkNotNull(t12);
            t11 = access$getGetNextValue$p.invoke(t12);
        }
        this.nextItem = t11;
        if (t11 == null) {
            i11 = 0;
        } else {
            i11 = 1;
        }
        this.nextState = i11;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    @Nullable
    public final T getNextItem() {
        return this.nextItem;
    }

    public final int getNextState() {
        return this.nextState;
    }

    public boolean hasNext() {
        if (this.nextState < 0) {
            calcNext();
        }
        if (this.nextState == 1) {
            return true;
        }
        return false;
    }

    @NotNull
    public T next() {
        if (this.nextState < 0) {
            calcNext();
        }
        if (this.nextState != 0) {
            T t11 = this.nextItem;
            Intrinsics.checkNotNull(t11, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.nextState = -1;
            return t11;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setNextItem(@Nullable T t11) {
        this.nextItem = t11;
    }

    public final void setNextState(int i11) {
        this.nextState = i11;
    }
}
