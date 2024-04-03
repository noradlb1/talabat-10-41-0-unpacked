package androidx.compose.runtime;

import com.huawei.hms.flutter.map.constants.Param;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020\nJ\u0006\u0010>\u001a\u00020?J\u0006\u0010@\u001a\u00020?J\u000e\u0010A\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\nJ\u0006\u0010B\u001a\u00020?J\u0006\u0010C\u001a\u00020?J\f\u0010D\u001a\b\u0012\u0004\u0012\u00020F0EJO\u0010G\u001a\u00020?2\u0006\u0010H\u001a\u00020\n28\u0010I\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(=\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020?0JH\u0000¢\u0006\u0002\bNJ\u0010\u0010O\u001a\u0004\u0018\u00010\u00012\u0006\u0010=\u001a\u00020\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010=\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u0010\u0010P\u001a\u0004\u0018\u00010\u00012\u0006\u0010=\u001a\u00020\nJ\u0018\u0010P\u001a\u0004\u0018\u00010\u00012\u0006\u0010H\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010;\u001a\u00020<J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0006\u0010=\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010Q\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\nJ\u000e\u0010R\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\nJ\u000e\u0010*\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\nJ\b\u0010S\u001a\u0004\u0018\u00010\u0001J\u0010\u0010T\u001a\u0004\u0018\u00010\u00012\u0006\u0010=\u001a\u00020\nJ\u000e\u0010+\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010-\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010U\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010V\u001a\u00020?2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010W\u001a\u00020?2\u0006\u0010=\u001a\u00020\nJ\u0006\u0010X\u001a\u00020\nJ\u0006\u0010Y\u001a\u00020?J\u0006\u0010Z\u001a\u00020?J\u0006\u0010[\u001a\u00020?J\b\u0010\\\u001a\u00020]H\u0016J\u0016\u0010^\u001a\u0004\u0018\u00010\u0001*\u00020%2\u0006\u0010=\u001a\u00020\nH\u0002J\u0016\u0010T\u001a\u0004\u0018\u00010\u0001*\u00020%2\u0006\u0010=\u001a\u00020\nH\u0002J\u0016\u0010_\u001a\u0004\u0018\u00010\u0001*\u00020%2\u0006\u0010=\u001a\u00020\nH\u0002R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0018\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u001e\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\rR\u0011\u0010 \u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b!\u0010\rR\u0011\u0010\"\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b#\u0010\rR\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b(\u0010\tR\u0011\u0010)\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b)\u0010\tR\u0011\u0010*\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b*\u0010\tR\u0011\u0010+\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b,\u0010\rR\u001e\u0010-\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\rR\u0011\u0010/\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b0\u0010\rR\u0011\u00101\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b2\u0010\rR\u0011\u00103\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b4\u0010\rR\u0018\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000106X\u0004¢\u0006\u0004\n\u0002\u00107R\u000e\u00108\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:¨\u0006`"}, d2 = {"Landroidx/compose/runtime/SlotReader;", "", "table", "Landroidx/compose/runtime/SlotTable;", "(Landroidx/compose/runtime/SlotTable;)V", "<set-?>", "", "closed", "getClosed", "()Z", "", "currentEnd", "getCurrentEnd", "()I", "currentGroup", "getCurrentGroup", "currentSlot", "currentSlotEnd", "emptyCount", "groupAux", "getGroupAux", "()Ljava/lang/Object;", "groupEnd", "getGroupEnd", "groupKey", "getGroupKey", "groupNode", "getGroupNode", "groupObjectKey", "getGroupObjectKey", "groupSize", "getGroupSize", "groupSlotCount", "getGroupSlotCount", "groupSlotIndex", "getGroupSlotIndex", "groups", "", "groupsSize", "inEmpty", "getInEmpty", "isGroupEnd", "isNode", "nodeCount", "getNodeCount", "parent", "getParent", "parentNodes", "getParentNodes", "size", "getSize", "slot", "getSlot", "slots", "", "[Ljava/lang/Object;", "slotsSize", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "anchor", "Landroidx/compose/runtime/Anchor;", "index", "beginEmpty", "", "close", "containsMark", "endEmpty", "endGroup", "extractKeys", "", "Landroidx/compose/runtime/KeyInfo;", "forEachData", "group", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "data", "forEachData$runtime_release", "get", "groupGet", "hasMark", "hasObjectKey", "next", "node", "parentOf", "reposition", "restoreParent", "skipGroup", "skipToGroupEnd", "startGroup", "startNode", "toString", "", "aux", "objectKey", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SlotReader {
    private boolean closed;
    private int currentEnd;
    private int currentGroup;
    private int currentSlot;
    private int currentSlotEnd;
    private int emptyCount;
    @NotNull
    private final int[] groups;
    private final int groupsSize;
    private int parent = -1;
    @NotNull
    private final Object[] slots;
    private final int slotsSize;
    @NotNull
    private final SlotTable table;

    public SlotReader(@NotNull SlotTable slotTable) {
        Intrinsics.checkNotNullParameter(slotTable, "table");
        this.table = slotTable;
        this.groups = slotTable.getGroups();
        int groupsSize2 = slotTable.getGroupsSize();
        this.groupsSize = groupsSize2;
        this.slots = slotTable.getSlots();
        this.slotsSize = slotTable.getSlotsSize();
        this.currentEnd = groupsSize2;
    }

    public static /* synthetic */ Anchor anchor$default(SlotReader slotReader, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = slotReader.currentGroup;
        }
        return slotReader.anchor(i11);
    }

    private final Object aux(int[] iArr, int i11) {
        if (SlotTableKt.hasAux(iArr, i11)) {
            return this.slots[SlotTableKt.auxIndex(iArr, i11)];
        }
        return Composer.Companion.getEmpty();
    }

    private final Object objectKey(int[] iArr, int i11) {
        if (SlotTableKt.hasObjectKey(iArr, i11)) {
            return this.slots[SlotTableKt.objectKeyIndex(iArr, i11)];
        }
        return null;
    }

    @NotNull
    public final Anchor anchor(int i11) {
        ArrayList<Anchor> anchors$runtime_release = this.table.getAnchors$runtime_release();
        int access$search = SlotTableKt.search(anchors$runtime_release, i11, this.groupsSize);
        if (access$search < 0) {
            Anchor anchor = new Anchor(i11);
            anchors$runtime_release.add(-(access$search + 1), anchor);
            return anchor;
        }
        Anchor anchor2 = anchors$runtime_release.get(access$search);
        Intrinsics.checkNotNullExpressionValue(anchor2, "get(location)");
        return anchor2;
    }

    public final void beginEmpty() {
        this.emptyCount++;
    }

    public final void close() {
        this.closed = true;
        this.table.close$runtime_release(this);
    }

    public final boolean containsMark(int i11) {
        return SlotTableKt.containsMark(this.groups, i11);
    }

    public final void endEmpty() {
        boolean z11;
        int i11 = this.emptyCount;
        if (i11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.emptyCount = i11 - 1;
            return;
        }
        throw new IllegalArgumentException("Unbalanced begin/end empty".toString());
    }

    public final void endGroup() {
        boolean z11;
        int i11;
        if (this.emptyCount == 0) {
            if (this.currentGroup == this.currentEnd) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                int access$parentAnchor = SlotTableKt.parentAnchor(this.groups, this.parent);
                this.parent = access$parentAnchor;
                if (access$parentAnchor < 0) {
                    i11 = this.groupsSize;
                } else {
                    i11 = access$parentAnchor + SlotTableKt.groupSize(this.groups, access$parentAnchor);
                }
                this.currentEnd = i11;
                return;
            }
            ComposerKt.composeRuntimeError("endGroup() not called at the end of a group".toString());
            throw new KotlinNothingValueException();
        }
    }

    @NotNull
    public final List<KeyInfo> extractKeys() {
        int i11;
        ArrayList arrayList = new ArrayList();
        if (this.emptyCount > 0) {
            return arrayList;
        }
        int i12 = this.currentGroup;
        int i13 = 0;
        while (i12 < this.currentEnd) {
            int access$key = SlotTableKt.key(this.groups, i12);
            Object objectKey = objectKey(this.groups, i12);
            if (SlotTableKt.isNode(this.groups, i12)) {
                i11 = 1;
            } else {
                i11 = SlotTableKt.nodeCount(this.groups, i12);
            }
            arrayList.add(new KeyInfo(access$key, objectKey, i12, i11, i13));
            i12 += SlotTableKt.groupSize(this.groups, i12);
            i13++;
        }
        return arrayList;
    }

    public final void forEachData$runtime_release(int i11, @NotNull Function2<? super Integer, Object, Unit> function2) {
        int i12;
        Intrinsics.checkNotNullParameter(function2, "block");
        int access$slotAnchor = SlotTableKt.slotAnchor(this.groups, i11);
        int i13 = i11 + 1;
        if (i13 < this.table.getGroupsSize()) {
            i12 = SlotTableKt.dataAnchor(this.table.getGroups(), i13);
        } else {
            i12 = this.table.getSlotsSize();
        }
        for (int i14 = access$slotAnchor; i14 < i12; i14++) {
            function2.invoke(Integer.valueOf(i14 - access$slotAnchor), this.slots[i14]);
        }
    }

    @Nullable
    public final Object get(int i11) {
        int i12 = this.currentSlot + i11;
        if (i12 < this.currentSlotEnd) {
            return this.slots[i12];
        }
        return Composer.Companion.getEmpty();
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final int getCurrentEnd() {
        return this.currentEnd;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    @Nullable
    public final Object getGroupAux() {
        int i11 = this.currentGroup;
        if (i11 < this.currentEnd) {
            return aux(this.groups, i11);
        }
        return 0;
    }

    public final int getGroupEnd() {
        return this.currentEnd;
    }

    public final int getGroupKey() {
        int i11 = this.currentGroup;
        if (i11 < this.currentEnd) {
            return SlotTableKt.key(this.groups, i11);
        }
        return 0;
    }

    @Nullable
    public final Object getGroupNode() {
        int i11 = this.currentGroup;
        if (i11 < this.currentEnd) {
            return node(this.groups, i11);
        }
        return null;
    }

    @Nullable
    public final Object getGroupObjectKey() {
        int i11 = this.currentGroup;
        if (i11 < this.currentEnd) {
            return objectKey(this.groups, i11);
        }
        return null;
    }

    public final int getGroupSize() {
        return SlotTableKt.groupSize(this.groups, this.currentGroup);
    }

    public final int getGroupSlotCount() {
        int i11;
        int i12 = this.currentGroup;
        int access$slotAnchor = SlotTableKt.slotAnchor(this.groups, i12);
        int i13 = i12 + 1;
        if (i13 < this.groupsSize) {
            i11 = SlotTableKt.dataAnchor(this.groups, i13);
        } else {
            i11 = this.slotsSize;
        }
        return i11 - access$slotAnchor;
    }

    public final int getGroupSlotIndex() {
        return this.currentSlot - SlotTableKt.slotAnchor(this.groups, this.parent);
    }

    public final boolean getInEmpty() {
        return this.emptyCount > 0;
    }

    public final int getNodeCount() {
        return SlotTableKt.nodeCount(this.groups, this.currentGroup);
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getParentNodes() {
        int i11 = this.parent;
        if (i11 >= 0) {
            return SlotTableKt.nodeCount(this.groups, i11);
        }
        return 0;
    }

    public final int getSize() {
        return this.groupsSize;
    }

    public final int getSlot() {
        return this.currentSlot - SlotTableKt.slotAnchor(this.groups, this.parent);
    }

    @NotNull
    public final SlotTable getTable$runtime_release() {
        return this.table;
    }

    @Nullable
    public final Object groupAux(int i11) {
        return aux(this.groups, i11);
    }

    public final int groupEnd(int i11) {
        return i11 + SlotTableKt.groupSize(this.groups, i11);
    }

    @Nullable
    public final Object groupGet(int i11) {
        return groupGet(this.currentGroup, i11);
    }

    public final int groupKey(int i11) {
        return SlotTableKt.key(this.groups, i11);
    }

    @Nullable
    public final Object groupObjectKey(int i11) {
        return objectKey(this.groups, i11);
    }

    public final int groupSize(int i11) {
        return SlotTableKt.groupSize(this.groups, i11);
    }

    public final boolean hasMark(int i11) {
        return SlotTableKt.hasMark(this.groups, i11);
    }

    public final boolean hasObjectKey(int i11) {
        return SlotTableKt.hasObjectKey(this.groups, i11);
    }

    public final boolean isGroupEnd() {
        return getInEmpty() || this.currentGroup == this.currentEnd;
    }

    public final boolean isNode() {
        return SlotTableKt.isNode(this.groups, this.currentGroup);
    }

    @Nullable
    public final Object next() {
        int i11;
        if (this.emptyCount > 0 || (i11 = this.currentSlot) >= this.currentSlotEnd) {
            return Composer.Companion.getEmpty();
        }
        Object[] objArr = this.slots;
        this.currentSlot = i11 + 1;
        return objArr[i11];
    }

    @Nullable
    public final Object node(int i11) {
        if (SlotTableKt.isNode(this.groups, i11)) {
            return node(this.groups, i11);
        }
        return null;
    }

    public final int nodeCount(int i11) {
        return SlotTableKt.nodeCount(this.groups, i11);
    }

    public final int parent(int i11) {
        return SlotTableKt.parentAnchor(this.groups, i11);
    }

    public final int parentOf(int i11) {
        boolean z11;
        if (i11 < 0 || i11 >= this.groupsSize) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return SlotTableKt.parentAnchor(this.groups, i11);
        }
        throw new IllegalArgumentException(("Invalid group index " + i11).toString());
    }

    public final void reposition(int i11) {
        boolean z11;
        int i12;
        if (this.emptyCount == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.currentGroup = i11;
            if (i11 < this.groupsSize) {
                i12 = SlotTableKt.parentAnchor(this.groups, i11);
            } else {
                i12 = -1;
            }
            this.parent = i12;
            if (i12 < 0) {
                this.currentEnd = this.groupsSize;
            } else {
                this.currentEnd = i12 + SlotTableKt.groupSize(this.groups, i12);
            }
            this.currentSlot = 0;
            this.currentSlotEnd = 0;
            return;
        }
        ComposerKt.composeRuntimeError("Cannot reposition while in an empty region".toString());
        throw new KotlinNothingValueException();
    }

    public final void restoreParent(int i11) {
        boolean z11;
        int access$groupSize = SlotTableKt.groupSize(this.groups, i11) + i11;
        int i12 = this.currentGroup;
        if (i12 < i11 || i12 > access$groupSize) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            this.parent = i11;
            this.currentEnd = access$groupSize;
            this.currentSlot = 0;
            this.currentSlotEnd = 0;
            return;
        }
        ComposerKt.composeRuntimeError(("Index " + i11 + " is not a parent of " + i12).toString());
        throw new KotlinNothingValueException();
    }

    public final int skipGroup() {
        boolean z11;
        int i11 = 1;
        if (this.emptyCount == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (!SlotTableKt.isNode(this.groups, this.currentGroup)) {
                i11 = SlotTableKt.nodeCount(this.groups, this.currentGroup);
            }
            int i12 = this.currentGroup;
            this.currentGroup = i12 + SlotTableKt.groupSize(this.groups, i12);
            return i11;
        }
        ComposerKt.composeRuntimeError("Cannot skip while in an empty region".toString());
        throw new KotlinNothingValueException();
    }

    public final void skipToGroupEnd() {
        boolean z11;
        if (this.emptyCount == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.currentGroup = this.currentEnd;
        } else {
            ComposerKt.composeRuntimeError("Cannot skip the enclosing group while in an empty region".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void startGroup() {
        boolean z11;
        int i11;
        if (this.emptyCount <= 0) {
            if (SlotTableKt.parentAnchor(this.groups, this.currentGroup) == this.parent) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                int i12 = this.currentGroup;
                this.parent = i12;
                this.currentEnd = i12 + SlotTableKt.groupSize(this.groups, i12);
                int i13 = this.currentGroup;
                int i14 = i13 + 1;
                this.currentGroup = i14;
                this.currentSlot = SlotTableKt.slotAnchor(this.groups, i13);
                if (i13 >= this.groupsSize - 1) {
                    i11 = this.slotsSize;
                } else {
                    i11 = SlotTableKt.dataAnchor(this.groups, i14);
                }
                this.currentSlotEnd = i11;
                return;
            }
            throw new IllegalArgumentException("Invalid slot table detected".toString());
        }
    }

    public final void startNode() {
        if (this.emptyCount > 0) {
            return;
        }
        if (SlotTableKt.isNode(this.groups, this.currentGroup)) {
            startGroup();
            return;
        }
        throw new IllegalArgumentException("Expected a node group".toString());
    }

    @NotNull
    public String toString() {
        return "SlotReader(current=" + this.currentGroup + ", key=" + getGroupKey() + ", parent=" + this.parent + ", end=" + this.currentEnd + ')';
    }

    private final Object node(int[] iArr, int i11) {
        if (SlotTableKt.isNode(iArr, i11)) {
            return this.slots[SlotTableKt.nodeIndex(iArr, i11)];
        }
        return Composer.Companion.getEmpty();
    }

    @Nullable
    public final Object groupGet(int i11, int i12) {
        int access$slotAnchor = SlotTableKt.slotAnchor(this.groups, i11);
        int i13 = i11 + 1;
        int i14 = access$slotAnchor + i12;
        return i14 < (i13 < this.groupsSize ? SlotTableKt.dataAnchor(this.groups, i13) : this.slotsSize) ? this.slots[i14] : Composer.Companion.getEmpty();
    }

    public final int groupKey(@NotNull Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, Param.ANCHOR);
        if (anchor.getValid()) {
            return SlotTableKt.key(this.groups, this.table.anchorIndex(anchor));
        }
        return 0;
    }

    public final boolean isNode(int i11) {
        return SlotTableKt.isNode(this.groups, i11);
    }
}
