package kotlin.reflect.jvm.internal.impl.protobuf;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList extends AbstractList<String> implements RandomAccess, LazyStringList {
    /* access modifiers changed from: private */
    public final LazyStringList list;

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.list = lazyStringList;
    }

    public void add(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public ByteString getByteString(int i11) {
        return this.list.getByteString(i11);
    }

    public List<?> getUnderlyingElements() {
        return this.list.getUnderlyingElements();
    }

    public LazyStringList getUnmodifiableView() {
        return this;
    }

    public Iterator<String> iterator() {
        return new Object() {

            /* renamed from: b  reason: collision with root package name */
            public Iterator<String> f24775b;

            {
                this.f24775b = UnmodifiableLazyStringList.this.list.iterator();
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            public boolean hasNext() {
                return this.f24775b.hasNext();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public String next() {
                return this.f24775b.next();
            }
        };
    }

    public ListIterator<String> listIterator(int i11) {
        return new Object(i11) {

            /* renamed from: b  reason: collision with root package name */
            public ListIterator<String> f24772b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f24773c;

            {
                this.f24773c = r2;
                this.f24772b = UnmodifiableLazyStringList.this.list.listIterator(r2);
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            public boolean hasNext() {
                return this.f24772b.hasNext();
            }

            public boolean hasPrevious() {
                return this.f24772b.hasPrevious();
            }

            public int nextIndex() {
                return this.f24772b.nextIndex();
            }

            public int previousIndex() {
                return this.f24772b.previousIndex();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public void add(String str) {
                throw new UnsupportedOperationException();
            }

            public String next() {
                return this.f24772b.next();
            }

            public String previous() {
                return this.f24772b.previous();
            }

            public void set(String str) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public int size() {
        return this.list.size();
    }

    public String get(int i11) {
        return (String) this.list.get(i11);
    }
}
