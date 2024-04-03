package androidx.compose.ui.graphics.vector;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0002J\t\u0010\b\u001a\u00020\u0002H\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"androidx/compose/ui/graphics/vector/VectorGroup$iterator$1", "", "Landroidx/compose/ui/graphics/vector/VectorNode;", "it", "getIt", "()Ljava/util/Iterator;", "hasNext", "", "next", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class VectorGroup$iterator$1 implements Iterator<VectorNode>, KMappedMarker, j$.util.Iterator {
    @NotNull
    private final Iterator<VectorNode> it;

    public VectorGroup$iterator$1(VectorGroup vectorGroup) {
        this.it = vectorGroup.children.iterator();
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    @NotNull
    public final java.util.Iterator<VectorNode> getIt() {
        return this.it;
    }

    public boolean hasNext() {
        return this.it.hasNext();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @NotNull
    public VectorNode next() {
        return this.it.next();
    }
}
