package androidx.datastore.preferences.protobuf;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {
    /* access modifiers changed from: private */
    public final LazyStringList list;

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.list = lazyStringList;
    }

    public void add(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public boolean addAllByteArray(Collection<byte[]> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean addAllByteString(Collection<? extends ByteString> collection) {
        throw new UnsupportedOperationException();
    }

    public List<byte[]> asByteArrayList() {
        return Collections.unmodifiableList(this.list.asByteArrayList());
    }

    public List<ByteString> asByteStringList() {
        return Collections.unmodifiableList(this.list.asByteStringList());
    }

    public byte[] getByteArray(int i11) {
        return this.list.getByteArray(i11);
    }

    public ByteString getByteString(int i11) {
        return this.list.getByteString(i11);
    }

    public Object getRaw(int i11) {
        return this.list.getRaw(i11);
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
            public Iterator<String> f35838b;

            {
                this.f35838b = UnmodifiableLazyStringList.this.list.iterator();
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            public boolean hasNext() {
                return this.f35838b.hasNext();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public String next() {
                return this.f35838b.next();
            }
        };
    }

    public ListIterator<String> listIterator(int i11) {
        return new Object(i11) {

            /* renamed from: b  reason: collision with root package name */
            public ListIterator<String> f35835b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f35836c;

            {
                this.f35836c = r2;
                this.f35835b = UnmodifiableLazyStringList.this.list.listIterator(r2);
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            public boolean hasNext() {
                return this.f35835b.hasNext();
            }

            public boolean hasPrevious() {
                return this.f35835b.hasPrevious();
            }

            public int nextIndex() {
                return this.f35835b.nextIndex();
            }

            public int previousIndex() {
                return this.f35835b.previousIndex();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public void add(String str) {
                throw new UnsupportedOperationException();
            }

            public String next() {
                return this.f35835b.next();
            }

            public String previous() {
                return this.f35835b.previous();
            }

            public void set(String str) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public void mergeFrom(LazyStringList lazyStringList) {
        throw new UnsupportedOperationException();
    }

    public void set(int i11, ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.list.size();
    }

    public void add(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public String get(int i11) {
        return (String) this.list.get(i11);
    }

    public void set(int i11, byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
