package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OneElementArrayMap<T> extends ArrayMap<T> {
    private final int index;
    @NotNull
    private final T value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OneElementArrayMap(@NotNull T t11, int i11) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(t11, "value");
        this.value = t11;
        this.index = i11;
    }

    @Nullable
    public T get(int i11) {
        if (i11 == this.index) {
            return this.value;
        }
        return null;
    }

    public final int getIndex() {
        return this.index;
    }

    public int getSize() {
        return 1;
    }

    @NotNull
    public final T getValue() {
        return this.value;
    }

    @NotNull
    public Iterator<T> iterator() {
        return new OneElementArrayMap$iterator$1(this);
    }

    public void set(int i11, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "value");
        throw new IllegalStateException();
    }
}
