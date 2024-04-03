package j$.util;

import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class L implements Iterator, Consumer {

    /* renamed from: a  reason: collision with root package name */
    boolean f28552a = false;

    /* renamed from: b  reason: collision with root package name */
    Object f28553b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Spliterator f28554c;

    L(Spliterator spliterator) {
        this.f28554c = spliterator;
    }

    public final void accept(Object obj) {
        this.f28552a = true;
        this.f28553b = obj;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final boolean hasNext() {
        if (!this.f28552a) {
            this.f28554c.a(this);
        }
        return this.f28552a;
    }

    public final Object next() {
        if (this.f28552a || hasNext()) {
            this.f28552a = false;
            return this.f28553b;
        }
        throw new NoSuchElementException();
    }
}
