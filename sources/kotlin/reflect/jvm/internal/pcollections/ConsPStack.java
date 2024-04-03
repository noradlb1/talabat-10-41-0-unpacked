package kotlin.reflect.jvm.internal.pcollections;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class ConsPStack<E> implements Iterable<E> {
    private static final ConsPStack<Object> EMPTY = new ConsPStack<>();

    /* renamed from: b  reason: collision with root package name */
    public final E f24985b;

    /* renamed from: c  reason: collision with root package name */
    public final ConsPStack<E> f24986c;
    /* access modifiers changed from: private */
    public final int size;

    public static class Itr<E> implements Iterator<E>, j$.util.Iterator {
        private ConsPStack<E> next;

        public Itr(ConsPStack<E> consPStack) {
            this.next = consPStack;
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            return this.next.size > 0;
        }

        public E next() {
            ConsPStack<E> consPStack = this.next;
            E e11 = consPStack.f24985b;
            this.next = consPStack.f24986c;
            return e11;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private ConsPStack() {
        this.size = 0;
        this.f24985b = null;
        this.f24986c = null;
    }

    public static <E> ConsPStack<E> empty() {
        return EMPTY;
    }

    private ConsPStack<E> minus(Object obj) {
        if (this.size == 0) {
            return this;
        }
        if (this.f24985b.equals(obj)) {
            return this.f24986c;
        }
        ConsPStack<E> minus = this.f24986c.minus(obj);
        if (minus == this.f24986c) {
            return this;
        }
        return new ConsPStack<>(this.f24985b, minus);
    }

    private ConsPStack<E> subList(int i11) {
        if (i11 < 0 || i11 > this.size) {
            throw new IndexOutOfBoundsException();
        } else if (i11 == 0) {
            return this;
        } else {
            return this.f24986c.subList(i11 - 1);
        }
    }

    public E get(int i11) {
        if (i11 < 0 || i11 > this.size) {
            throw new IndexOutOfBoundsException();
        }
        try {
            return iterator(i11).next();
        } catch (NoSuchElementException unused) {
            throw new IndexOutOfBoundsException("Index: " + i11);
        }
    }

    public java.util.Iterator<E> iterator() {
        return iterator(0);
    }

    public ConsPStack<E> plus(E e11) {
        return new ConsPStack<>(e11, this);
    }

    public int size() {
        return this.size;
    }

    private java.util.Iterator<E> iterator(int i11) {
        return new Itr(subList(i11));
    }

    private ConsPStack(E e11, ConsPStack<E> consPStack) {
        this.f24985b = e11;
        this.f24986c = consPStack;
        this.size = consPStack.size + 1;
    }

    public ConsPStack<E> minus(int i11) {
        return minus(get(i11));
    }
}
