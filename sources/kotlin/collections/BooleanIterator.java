package kotlin.collections;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0002H&¨\u0006\u0007"}, d2 = {"Lkotlin/collections/BooleanIterator;", "", "", "()V", "next", "()Ljava/lang/Boolean;", "nextBoolean", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class BooleanIterator implements Iterator<Boolean>, KMappedMarker, j$.util.Iterator {
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public abstract boolean nextBoolean();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @NotNull
    public final Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }
}
