package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0012\u0010\"\u001a\u0004\u0018\u00010\u00012\u0006\u0010#\u001a\u00020\rH\u0016J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010%H\u0002J\b\u0010&\u001a\u00020'H\u0002R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0013R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0013R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0010¨\u0006("}, d2 = {"Landroidx/compose/runtime/SlotTableGroup;", "Landroidx/compose/runtime/tooling/CompositionGroup;", "", "table", "Landroidx/compose/runtime/SlotTable;", "group", "", "version", "(Landroidx/compose/runtime/SlotTable;II)V", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "data", "", "getData", "getGroup", "()I", "identity", "getIdentity", "()Ljava/lang/Object;", "isEmpty", "", "()Z", "key", "getKey", "node", "getNode", "sourceInfo", "", "getSourceInfo", "()Ljava/lang/String;", "getTable", "()Landroidx/compose/runtime/SlotTable;", "getVersion", "find", "identityToFind", "iterator", "", "validateRead", "", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class SlotTableGroup implements CompositionGroup, Iterable<CompositionGroup>, KMappedMarker {
    private final int group;
    @NotNull
    private final SlotTable table;
    private final int version;

    public SlotTableGroup(@NotNull SlotTable slotTable, int i11, int i12) {
        Intrinsics.checkNotNullParameter(slotTable, "table");
        this.table = slotTable;
        this.group = i11;
        this.version = i12;
    }

    private final void validateRead() {
        if (this.table.getVersion$runtime_release() != this.version) {
            throw new ConcurrentModificationException();
        }
    }

    @Nullable
    public CompositionGroup find(@NotNull Object obj) {
        Anchor anchor;
        int anchorIndex;
        int i11;
        Intrinsics.checkNotNullParameter(obj, "identityToFind");
        if (obj instanceof Anchor) {
            anchor = (Anchor) obj;
        } else {
            anchor = null;
        }
        if (anchor == null || !this.table.ownsAnchor(anchor) || (anchorIndex = this.table.anchorIndex(anchor)) < (i11 = this.group) || anchorIndex - i11 >= SlotTableKt.groupSize(this.table.getGroups(), this.group)) {
            return null;
        }
        return new SlotTableGroup(this.table, anchorIndex, this.version);
    }

    @NotNull
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }

    @NotNull
    public Iterable<Object> getData() {
        return new DataIterator(this.table, this.group);
    }

    public final int getGroup() {
        return this.group;
    }

    @NotNull
    public Object getIdentity() {
        validateRead();
        SlotReader openReader = this.table.openReader();
        try {
            return openReader.anchor(this.group);
        } finally {
            openReader.close();
        }
    }

    @NotNull
    public Object getKey() {
        if (!SlotTableKt.hasObjectKey(this.table.getGroups(), this.group)) {
            return Integer.valueOf(SlotTableKt.key(this.table.getGroups(), this.group));
        }
        Object obj = this.table.getSlots()[SlotTableKt.objectKeyIndex(this.table.getGroups(), this.group)];
        Intrinsics.checkNotNull(obj);
        return obj;
    }

    @Nullable
    public Object getNode() {
        if (SlotTableKt.isNode(this.table.getGroups(), this.group)) {
            return this.table.getSlots()[SlotTableKt.nodeIndex(this.table.getGroups(), this.group)];
        }
        return null;
    }

    @Nullable
    public String getSourceInfo() {
        if (!SlotTableKt.hasAux(this.table.getGroups(), this.group)) {
            return null;
        }
        Object obj = this.table.getSlots()[SlotTableKt.auxIndex(this.table.getGroups(), this.group)];
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    @NotNull
    public final SlotTable getTable() {
        return this.table;
    }

    public final int getVersion() {
        return this.version;
    }

    public boolean isEmpty() {
        return SlotTableKt.groupSize(this.table.getGroups(), this.group) == 0;
    }

    @NotNull
    public Iterator<CompositionGroup> iterator() {
        validateRead();
        SlotTable slotTable = this.table;
        int i11 = this.group;
        return new GroupIterator(slotTable, i11 + 1, i11 + SlotTableKt.groupSize(slotTable.getGroups(), this.group));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SlotTableGroup(SlotTable slotTable, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(slotTable, i11, (i13 & 4) != 0 ? slotTable.getVersion$runtime_release() : i12);
    }
}
