package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ArrayMapImpl<T> extends ArrayMap<T> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public Object[] data;
    private int size;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private ArrayMapImpl(Object[] objArr, int i11) {
        super((DefaultConstructorMarker) null);
        this.data = objArr;
        this.size = i11;
    }

    private final void ensureCapacity(int i11) {
        Object[] objArr = this.data;
        if (objArr.length <= i11) {
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.data = copyOf;
        }
    }

    @Nullable
    public T get(int i11) {
        return ArraysKt___ArraysKt.getOrNull((T[]) this.data, i11);
    }

    public int getSize() {
        return this.size;
    }

    @NotNull
    public Iterator<T> iterator() {
        return new ArrayMapImpl$iterator$1(this);
    }

    public void set(int i11, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "value");
        ensureCapacity(i11);
        if (this.data[i11] == null) {
            this.size = getSize() + 1;
        }
        this.data[i11] = t11;
    }

    public ArrayMapImpl() {
        this(new Object[20], 0);
    }
}
