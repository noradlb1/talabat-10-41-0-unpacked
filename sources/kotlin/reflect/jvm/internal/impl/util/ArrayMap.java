package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ArrayMap<T> implements Iterable<T>, KMappedMarker {
    private ArrayMap() {
    }

    public /* synthetic */ ArrayMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Nullable
    public abstract T get(int i11);

    public abstract int getSize();

    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract void set(int i11, @NotNull T t11);
}
