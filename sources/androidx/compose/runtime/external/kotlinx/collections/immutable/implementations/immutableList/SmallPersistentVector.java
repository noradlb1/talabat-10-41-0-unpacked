package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import com.apptimize.c;
import java.util.Arrays;
import java.util.Collection;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010*\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 (*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001(B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001b\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J#\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0011\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016J\u001d\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0016\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\"\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020%0$H\u0016J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016J#\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006)"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractPersistentList;", "buffer", "", "", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "size", "", "getSize", "()I", "add", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "index", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "addAll", "c", "", "elements", "bufferOfSize", "(I)[Ljava/lang/Object;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList$Builder;", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "listIterator", "", "removeAll", "predicate", "Lkotlin/Function1;", "", "removeAt", "set", "Companion", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SmallPersistentVector<E> extends AbstractPersistentList<E> implements ImmutableList<E> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final SmallPersistentVector EMPTY = new SmallPersistentVector(new Object[0]);
    @NotNull
    private final Object[] buffer;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector;", "", "getEMPTY", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SmallPersistentVector getEMPTY() {
            return SmallPersistentVector.EMPTY;
        }
    }

    public SmallPersistentVector(@NotNull Object[] objArr) {
        boolean z11;
        Intrinsics.checkNotNullParameter(objArr, "buffer");
        this.buffer = objArr;
        if (objArr.length <= 32) {
            z11 = true;
        } else {
            z11 = false;
        }
        CommonFunctionsKt.m2551assert(z11);
    }

    private final Object[] bufferOfSize(int i11) {
        return new Object[i11];
    }

    public E get(int i11) {
        ListImplementation.checkElementIndex$runtime_release(i11, size());
        return this.buffer[i11];
    }

    public int getSize() {
        return this.buffer.length;
    }

    public int indexOf(Object obj) {
        return ArraysKt___ArraysKt.indexOf((T[]) this.buffer, obj);
    }

    public int lastIndexOf(Object obj) {
        return ArraysKt___ArraysKt.lastIndexOf((T[]) this.buffer, obj);
    }

    @NotNull
    public ListIterator<E> listIterator(int i11) {
        ListImplementation.checkPositionIndex$runtime_release(i11, size());
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr, "null cannot be cast to non-null type kotlin.Array<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.SmallPersistentVector>");
        return new BufferIterator(objArr, i11, size());
    }

    @NotNull
    public PersistentList<E> removeAt(int i11) {
        ListImplementation.checkElementIndex$runtime_release(i11, size());
        if (size() == 1) {
            return EMPTY;
        }
        Object[] copyOf = Arrays.copyOf(this.buffer, size() - 1);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) this.buffer, (T[]) copyOf, i11, i11 + 1, size());
        return new SmallPersistentVector(copyOf);
    }

    @NotNull
    public PersistentList<E> set(int i11, E e11) {
        ListImplementation.checkElementIndex$runtime_release(i11, size());
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[i11] = e11;
        return new SmallPersistentVector(copyOf);
    }

    @NotNull
    public PersistentList<E> add(E e11) {
        if (size() < 32) {
            Object[] copyOf = Arrays.copyOf(this.buffer, size() + 1);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            copyOf[size()] = e11;
            return new SmallPersistentVector(copyOf);
        }
        return new PersistentVector(this.buffer, UtilsKt.presizedBufferWith(e11), size() + 1, 0);
    }

    @NotNull
    public PersistentList<E> addAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        if (size() + collection.size() <= 32) {
            Object[] copyOf = Arrays.copyOf(this.buffer, size() + collection.size());
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            int size = size();
            for (Object obj : collection) {
                copyOf[size] = obj;
                size++;
            }
            return new SmallPersistentVector(copyOf);
        }
        PersistentList.Builder builder = builder();
        builder.addAll(collection);
        return builder.build();
    }

    @NotNull
    public PersistentList.Builder<E> builder() {
        return new PersistentVectorBuilder(this, (Object[]) null, this.buffer, 0);
    }

    @NotNull
    public PersistentList<E> removeAll(@NotNull Function1<? super E, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Object[] objArr = this.buffer;
        int size = size();
        int size2 = size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size2; i11++) {
            Object obj = this.buffer[i11];
            if (function1.invoke(obj).booleanValue()) {
                if (!z11) {
                    Object[] objArr2 = this.buffer;
                    objArr = Arrays.copyOf(objArr2, objArr2.length);
                    Intrinsics.checkNotNullExpressionValue(objArr, "copyOf(this, size)");
                    z11 = true;
                    size = i11;
                }
            } else if (z11) {
                objArr[size] = obj;
                size++;
            }
        }
        if (size == size()) {
            return this;
        }
        if (size == 0) {
            return EMPTY;
        }
        return new SmallPersistentVector(ArraysKt___ArraysJvmKt.copyOfRange((T[]) objArr, 0, size));
    }

    @NotNull
    public PersistentList<E> add(int i11, E e11) {
        ListImplementation.checkPositionIndex$runtime_release(i11, size());
        if (i11 == size()) {
            return add((Object) e11);
        }
        if (size() < 32) {
            Object[] bufferOfSize = bufferOfSize(size() + 1);
            Object[] unused = ArraysKt___ArraysJvmKt.copyInto$default(this.buffer, bufferOfSize, 0, 0, i11, 6, (Object) null);
            Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) this.buffer, (T[]) bufferOfSize, i11 + 1, i11, size());
            bufferOfSize[i11] = e11;
            return new SmallPersistentVector(bufferOfSize);
        }
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        Object[] unused3 = ArraysKt___ArraysJvmKt.copyInto((T[]) this.buffer, (T[]) copyOf, i11 + 1, i11, size() - 1);
        copyOf[i11] = e11;
        return new PersistentVector(copyOf, UtilsKt.presizedBufferWith(this.buffer[31]), size() + 1, 0);
    }

    @NotNull
    public PersistentList<E> addAll(int i11, @NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, c.f41585a);
        ListImplementation.checkPositionIndex$runtime_release(i11, size());
        if (size() + collection.size() <= 32) {
            Object[] bufferOfSize = bufferOfSize(size() + collection.size());
            Object[] unused = ArraysKt___ArraysJvmKt.copyInto$default(this.buffer, bufferOfSize, 0, 0, i11, 6, (Object) null);
            Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) this.buffer, (T[]) bufferOfSize, collection.size() + i11, i11, size());
            for (Object obj : collection) {
                bufferOfSize[i11] = obj;
                i11++;
            }
            return new SmallPersistentVector(bufferOfSize);
        }
        PersistentList.Builder builder = builder();
        builder.addAll(i11, collection);
        return builder.build();
    }
}
