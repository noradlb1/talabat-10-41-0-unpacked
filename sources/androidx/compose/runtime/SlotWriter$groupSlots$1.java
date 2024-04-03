package androidx.compose.runtime;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\t\u0010\t\u001a\u00020\nH\u0002J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"androidx/compose/runtime/SlotWriter$groupSlots$1", "", "", "current", "", "getCurrent", "()I", "setCurrent", "(I)V", "hasNext", "", "next", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SlotWriter$groupSlots$1 implements Iterator<Object>, KMappedMarker, j$.util.Iterator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f9221b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SlotWriter f9222c;
    private int current;

    public SlotWriter$groupSlots$1(int i11, int i12, SlotWriter slotWriter) {
        this.f9221b = i12;
        this.f9222c = slotWriter;
        this.current = i11;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final int getCurrent() {
        return this.current;
    }

    public boolean hasNext() {
        return this.current < this.f9221b;
    }

    @Nullable
    public Object next() {
        if (!hasNext()) {
            return null;
        }
        Object[] access$getSlots$p = this.f9222c.slots;
        SlotWriter slotWriter = this.f9222c;
        int i11 = this.current;
        this.current = i11 + 1;
        return access$getSlots$p[slotWriter.dataIndexToDataAddress(i11)];
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setCurrent(int i11) {
        this.current = i11;
    }
}
