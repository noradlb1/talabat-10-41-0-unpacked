package kotlin.reflect.jvm.internal.impl.utils;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;

public class SmartList<E> extends AbstractList<E> implements RandomAccess {
    /* access modifiers changed from: private */
    public Object myElem;
    private int mySize;

    public static class EmptyIterator<T> implements Iterator<T>, j$.util.Iterator {
        private static final EmptyIterator INSTANCE = new EmptyIterator();

        private EmptyIterator() {
        }

        public static <T> EmptyIterator<T> getInstance() {
            return INSTANCE;
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            return false;
        }

        public T next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new IllegalStateException();
        }
    }

    public class SingletonIterator extends SingletonIteratorBase<E> implements j$.util.Iterator {
        private final int myInitialModCount;

        public SingletonIterator() {
            super();
            this.myInitialModCount = SmartList.this.modCount;
        }

        public void a() {
            if (SmartList.this.modCount != this.myInitialModCount) {
                throw new ConcurrentModificationException("ModCount: " + SmartList.this.modCount + "; expected: " + this.myInitialModCount);
            }
        }

        public E b() {
            return SmartList.this.myElem;
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public void remove() {
            a();
            SmartList.this.clear();
        }
    }

    public static abstract class SingletonIteratorBase<T> implements java.util.Iterator<T> {
        private boolean myVisited;

        private SingletonIteratorBase() {
        }

        public abstract void a();

        public abstract T b();

        public final boolean hasNext() {
            return !this.myVisited;
        }

        public final T next() {
            if (!this.myVisited) {
                this.myVisited = true;
                a();
                return b();
            }
            throw new NoSuchElementException();
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        String str = (i11 == 2 || i11 == 3 || i11 == 5 || i11 == 6 || i11 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i11 == 2 || i11 == 3 || i11 == 5 || i11 == 6 || i11 == 7) ? 2 : 3)];
        switch (i11) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = "a";
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i11 == 2 || i11 == 3) {
            objArr[1] = "iterator";
        } else if (i11 == 5 || i11 == 6 || i11 == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i11) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String format = String.format(str, objArr);
        throw ((i11 == 2 || i11 == 3 || i11 == 5 || i11 == 6 || i11 == 7) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public boolean add(E e11) {
        int i11 = this.mySize;
        if (i11 == 0) {
            this.myElem = e11;
        } else if (i11 == 1) {
            this.myElem = new Object[]{this.myElem, e11};
        } else {
            Object[] objArr = (Object[]) this.myElem;
            int length = objArr.length;
            if (i11 >= length) {
                int i12 = ((length * 3) / 2) + 1;
                int i13 = i11 + 1;
                if (i12 < i13) {
                    i12 = i13;
                }
                Object[] objArr2 = new Object[i12];
                this.myElem = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.mySize] = e11;
        }
        this.mySize++;
        this.modCount++;
        return true;
    }

    public void clear() {
        this.myElem = null;
        this.mySize = 0;
        this.modCount++;
    }

    public E get(int i11) {
        int i12;
        if (i11 < 0 || i11 >= (i12 = this.mySize)) {
            throw new IndexOutOfBoundsException("Index: " + i11 + ", Size: " + this.mySize);
        } else if (i12 == 1) {
            return this.myElem;
        } else {
            return ((Object[]) this.myElem)[i11];
        }
    }

    @NotNull
    public java.util.Iterator<E> iterator() {
        int i11 = this.mySize;
        if (i11 == 0) {
            EmptyIterator instance = EmptyIterator.getInstance();
            if (instance == null) {
                $$$reportNull$$$0(2);
            }
            return instance;
        } else if (i11 == 1) {
            return new SingletonIterator();
        } else {
            java.util.Iterator<E> it = super.iterator();
            if (it == null) {
                $$$reportNull$$$0(3);
            }
            return it;
        }
    }

    public E remove(int i11) {
        int i12;
        E e11;
        if (i11 < 0 || i11 >= (i12 = this.mySize)) {
            throw new IndexOutOfBoundsException("Index: " + i11 + ", Size: " + this.mySize);
        }
        if (i12 == 1) {
            e11 = this.myElem;
            this.myElem = null;
        } else {
            E[] eArr = (Object[]) this.myElem;
            E e12 = eArr[i11];
            if (i12 == 2) {
                this.myElem = eArr[1 - i11];
            } else {
                int i13 = (i12 - i11) - 1;
                if (i13 > 0) {
                    System.arraycopy(eArr, i11 + 1, eArr, i11, i13);
                }
                eArr[this.mySize - 1] = null;
            }
            e11 = e12;
        }
        this.mySize--;
        this.modCount++;
        return e11;
    }

    public E set(int i11, E e11) {
        int i12;
        if (i11 < 0 || i11 >= (i12 = this.mySize)) {
            throw new IndexOutOfBoundsException("Index: " + i11 + ", Size: " + this.mySize);
        } else if (i12 == 1) {
            E e12 = this.myElem;
            this.myElem = e11;
            return e12;
        } else {
            E[] eArr = (Object[]) this.myElem;
            E e13 = eArr[i11];
            eArr[i11] = e11;
            return e13;
        }
    }

    public int size() {
        return this.mySize;
    }

    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        if (tArr == null) {
            $$$reportNull$$$0(4);
        }
        int length = tArr.length;
        int i11 = this.mySize;
        if (i11 == 1) {
            if (length != 0) {
                tArr[0] = this.myElem;
            } else {
                T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1);
                tArr2[0] = this.myElem;
                return tArr2;
            }
        } else if (length < i11) {
            T[] copyOf = Arrays.copyOf((Object[]) this.myElem, i11, tArr.getClass());
            if (copyOf == null) {
                $$$reportNull$$$0(6);
            }
            return copyOf;
        } else if (i11 != 0) {
            System.arraycopy(this.myElem, 0, tArr, 0, i11);
        }
        int i12 = this.mySize;
        if (length > i12) {
            tArr[i12] = null;
        }
        return tArr;
    }

    public void add(int i11, E e11) {
        int i12;
        if (i11 < 0 || i11 > (i12 = this.mySize)) {
            throw new IndexOutOfBoundsException("Index: " + i11 + ", Size: " + this.mySize);
        }
        if (i12 == 0) {
            this.myElem = e11;
        } else if (i12 == 1 && i11 == 0) {
            this.myElem = new Object[]{e11, this.myElem};
        } else {
            Object[] objArr = new Object[(i12 + 1)];
            if (i12 == 1) {
                objArr[0] = this.myElem;
            } else {
                Object[] objArr2 = (Object[]) this.myElem;
                System.arraycopy(objArr2, 0, objArr, 0, i11);
                System.arraycopy(objArr2, i11, objArr, i11 + 1, this.mySize - i11);
            }
            objArr[i11] = e11;
            this.myElem = objArr;
        }
        this.mySize++;
        this.modCount++;
    }
}
