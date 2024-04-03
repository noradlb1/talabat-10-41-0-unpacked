package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\u0018\u0002\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u000605j\u0002`6B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\tJ.\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u00002\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\f0\u000bH\b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0005J2\u0010\u0015\u001a\u0004\u0018\u00018\u00002!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u001fH\u0001¢\u0006\u0004\b!\u0010\"J&\u0010#\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000bH\b¢\u0006\u0004\b#\u0010\u0016J\u000f\u0010$\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b$\u0010\u0018J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001fH\u0010¢\u0006\u0004\b&\u0010'J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001fH\u0010¢\u0006\u0004\b(\u0010'J\u001f\u0010*\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001fH\u0002¢\u0006\u0004\b*\u0010+R \u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0011\u0010.\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b.\u0010/R$\u00103\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u001f8F@BX\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u0010'¨\u00064"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "<init>", "()V", "node", "", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "Lkotlin/Function1;", "", "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "clear", "Lkotlin/ParameterName;", "name", "value", "predicate", "find", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "", "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstIf", "removeFirstOrNull", "i", "siftDownFrom", "(I)V", "siftUpFrom", "j", "swap", "(II)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "()Z", "getSize", "()I", "setSize", "size", "kotlinx-coroutines-core", "", "Lkotlinx/coroutines/internal/SynchronizedObject;"}, k = 1, mv = {1, 6, 0}, xi = 48)
@InternalCoroutinesApi
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    @NotNull
    private volatile /* synthetic */ int _size = 0;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private T[] f26201a;

    private final T[] realloc() {
        T[] tArr = this.f26201a;
        if (tArr == null) {
            T[] tArr2 = new ThreadSafeHeapNode[4];
            this.f26201a = tArr2;
            return tArr2;
        } else if (getSize() < tArr.length) {
            return tArr;
        } else {
            T[] copyOf = Arrays.copyOf(tArr, getSize() * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            T[] tArr3 = (ThreadSafeHeapNode[]) copyOf;
            this.f26201a = tArr3;
            return tArr3;
        }
    }

    private final void setSize(int i11) {
        this._size = i11;
    }

    private final void siftDownFrom(int i11) {
        while (true) {
            int i12 = (i11 * 2) + 1;
            if (i12 < getSize()) {
                T[] tArr = this.f26201a;
                Intrinsics.checkNotNull(tArr);
                int i13 = i12 + 1;
                if (i13 < getSize()) {
                    T t11 = tArr[i13];
                    Intrinsics.checkNotNull(t11);
                    T t12 = tArr[i12];
                    Intrinsics.checkNotNull(t12);
                    if (((Comparable) t11).compareTo(t12) < 0) {
                        i12 = i13;
                    }
                }
                T t13 = tArr[i11];
                Intrinsics.checkNotNull(t13);
                T t14 = tArr[i12];
                Intrinsics.checkNotNull(t14);
                if (((Comparable) t13).compareTo(t14) > 0) {
                    swap(i11, i12);
                    i11 = i12;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final void siftUpFrom(int i11) {
        while (i11 > 0) {
            T[] tArr = this.f26201a;
            Intrinsics.checkNotNull(tArr);
            int i12 = (i11 - 1) / 2;
            T t11 = tArr[i12];
            Intrinsics.checkNotNull(t11);
            T t12 = tArr[i11];
            Intrinsics.checkNotNull(t12);
            if (((Comparable) t11).compareTo(t12) > 0) {
                swap(i11, i12);
                i11 = i12;
            } else {
                return;
            }
        }
    }

    private final void swap(int i11, int i12) {
        T[] tArr = this.f26201a;
        Intrinsics.checkNotNull(tArr);
        T t11 = tArr[i12];
        Intrinsics.checkNotNull(t11);
        T t12 = tArr[i11];
        Intrinsics.checkNotNull(t12);
        tArr[i11] = t11;
        tArr[i12] = t12;
        t11.setIndex(i11);
        t12.setIndex(i12);
    }

    @PublishedApi
    public final void addImpl(@NotNull T t11) {
        t11.setHeap(this);
        ThreadSafeHeapNode[] realloc = realloc();
        int size = getSize();
        setSize(size + 1);
        realloc[size] = t11;
        t11.setIndex(size);
        siftUpFrom(size);
    }

    public final void addLast(@NotNull T t11) {
        synchronized (this) {
            addImpl(t11);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean addLastIf(@NotNull T t11, @NotNull Function1<? super T, Boolean> function1) {
        boolean z11;
        synchronized (this) {
            try {
                if (function1.invoke(firstImpl()).booleanValue()) {
                    addImpl(t11);
                    z11 = true;
                } else {
                    z11 = false;
                }
                InlineMarker.finallyStart(1);
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
        InlineMarker.finallyEnd(1);
        return z11;
    }

    public final void clear() {
        synchronized (this) {
            T[] tArr = this.f26201a;
            if (tArr != null) {
                ArraysKt___ArraysJvmKt.fill$default((Object[]) tArr, (Object) null, 0, 0, 6, (Object) null);
            }
            this._size = 0;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Nullable
    public final T find(@NotNull Function1<? super T, Boolean> function1) {
        T t11;
        synchronized (this) {
            int size = getSize();
            int i11 = 0;
            while (true) {
                t11 = null;
                if (i11 >= size) {
                    break;
                }
                T[] tArr = this.f26201a;
                if (tArr != null) {
                    t11 = tArr[i11];
                }
                Intrinsics.checkNotNull(t11);
                if (function1.invoke(t11).booleanValue()) {
                    break;
                }
                i11++;
            }
        }
        return t11;
    }

    @Nullable
    @PublishedApi
    public final T firstImpl() {
        T[] tArr = this.f26201a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int getSize() {
        return this._size;
    }

    public final boolean isEmpty() {
        return getSize() == 0;
    }

    @Nullable
    public final T peek() {
        T firstImpl;
        synchronized (this) {
            firstImpl = firstImpl();
        }
        return firstImpl;
    }

    public final boolean remove(@NotNull T t11) {
        boolean z11;
        synchronized (this) {
            if (t11.getHeap() == null) {
                z11 = false;
            } else {
                removeAtImpl(t11.getIndex());
                z11 = true;
            }
        }
        return z11;
    }

    @NotNull
    @PublishedApi
    public final T removeAtImpl(int i11) {
        T[] tArr = this.f26201a;
        Intrinsics.checkNotNull(tArr);
        setSize(getSize() - 1);
        if (i11 < getSize()) {
            swap(i11, getSize());
            int i12 = (i11 - 1) / 2;
            if (i11 > 0) {
                T t11 = tArr[i11];
                Intrinsics.checkNotNull(t11);
                T t12 = tArr[i12];
                Intrinsics.checkNotNull(t12);
                if (((Comparable) t11).compareTo(t12) < 0) {
                    swap(i11, i12);
                    siftUpFrom(i12);
                }
            }
            siftDownFrom(i11);
        }
        T t13 = tArr[getSize()];
        Intrinsics.checkNotNull(t13);
        t13.setHeap((ThreadSafeHeap<?>) null);
        t13.setIndex(-1);
        tArr[getSize()] = null;
        return t13;
    }

    @Nullable
    public final T removeFirstIf(@NotNull Function1<? super T, Boolean> function1) {
        synchronized (this) {
            try {
                ThreadSafeHeapNode firstImpl = firstImpl();
                T t11 = null;
                if (firstImpl == null) {
                    InlineMarker.finallyStart(2);
                    InlineMarker.finallyEnd(2);
                    return null;
                }
                if (function1.invoke(firstImpl).booleanValue()) {
                    t11 = removeAtImpl(0);
                }
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                return t11;
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
    }

    @Nullable
    public final T removeFirstOrNull() {
        T t11;
        synchronized (this) {
            if (getSize() > 0) {
                t11 = removeAtImpl(0);
            } else {
                t11 = null;
            }
        }
        return t11;
    }
}
