package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.markers.KMappedMarker;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010(\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0015J\u000e\u0010-\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0007J\u0006\u0010.\u001a\u00020/J\u0015\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\b4JW\u00100\u001a\u0002012\u0006\u0010)\u001a\u0002052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u0006\u0010#\u001a\u00020\u00152\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0000¢\u0006\u0004\b4\u00106J\u0006\u00107\u001a\u00020\u001aJ\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020\u001509H\u0002J\u0012\u0010:\u001a\u0004\u0018\u00010\u00032\u0006\u0010;\u001a\u00020\u001eH\u0016J\u0012\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020\u0015H\u0002J\u0016\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0007J\u000e\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001509H\u0002J\u0010\u0010B\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u0015H\u0002J\u001d\u0010C\u001a\n\u0012\u0004\u0012\u00020=\u0018\u0001092\u0006\u0010D\u001a\u00020\u0015H\u0000¢\u0006\u0002\bEJ\u000f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00030GH\u0002J\u000e\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001509H\u0002J\u000e\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001509H\u0002J\u0006\u0010J\u001a\u000203J\u0006\u0010K\u001a\u000205J\u000e\u0010L\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0007J\u000e\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001509H\u0002J:\u0010N\u001a\u0002HO\"\u0004\b\u0000\u0010O2!\u0010P\u001a\u001d\u0012\u0013\u0012\u001103¢\u0006\f\bR\u0012\b\bS\u0012\u0004\b\b(2\u0012\u0004\u0012\u0002HO0QH\bø\u0001\u0000¢\u0006\u0002\u0010TJO\u0010U\u001a\u0002012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u0006\u0010#\u001a\u00020\u00152\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0000¢\u0006\u0004\bV\u0010WJ\u001d\u0010X\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e092\u0006\u0010>\u001a\u00020\u0015H\u0000¢\u0006\u0002\bYJ\u0006\u0010Z\u001a\u000201J:\u0010[\u001a\u0002HO\"\u0004\b\u0000\u0010O2!\u0010P\u001a\u001d\u0012\u0013\u0012\u001105¢\u0006\f\bR\u0012\b\bS\u0012\u0004\b\b()\u0012\u0004\u0012\u0002HO0QH\bø\u0001\u0000¢\u0006\u0002\u0010TJ \u0010\\\u001a\u00020\u0015*\u00060]j\u0002`^2\u0006\u0010,\u001a\u00020\u00152\u0006\u0010_\u001a\u00020\u0015H\u0002R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R0\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d@BX\u000e¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001e\u0010#\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u001a\u0010%\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u001a@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001b\u0002\u0007\n\u0005\b20\u0001¨\u0006`"}, d2 = {"Landroidx/compose/runtime/SlotTable;", "Landroidx/compose/runtime/tooling/CompositionData;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "()V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "getAnchors$runtime_release", "()Ljava/util/ArrayList;", "setAnchors$runtime_release", "(Ljava/util/ArrayList;)V", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "<set-?>", "", "groups", "getGroups", "()[I", "", "groupsSize", "getGroupsSize", "()I", "isEmpty", "", "()Z", "readers", "", "", "slots", "getSlots", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "slotsSize", "getSlotsSize", "version", "getVersion$runtime_release", "setVersion$runtime_release", "(I)V", "writer", "getWriter$runtime_release", "anchor", "index", "anchorIndex", "asString", "", "close", "", "reader", "Landroidx/compose/runtime/SlotReader;", "close$runtime_release", "Landroidx/compose/runtime/SlotWriter;", "(Landroidx/compose/runtime/SlotWriter;[II[Ljava/lang/Object;ILjava/util/ArrayList;)V", "containsMark", "dataIndexes", "", "find", "identityToFind", "findEffectiveRecomposeScope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "group", "groupContainsAnchor", "groupIndex", "groupSizes", "invalidateGroup", "invalidateGroupsWithKey", "target", "invalidateGroupsWithKey$runtime_release", "iterator", "", "keys", "nodes", "openReader", "openWriter", "ownsAnchor", "parentIndexes", "read", "T", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "setTo", "setTo$runtime_release", "([II[Ljava/lang/Object;ILjava/util/ArrayList;)V", "slotsOf", "slotsOf$runtime_release", "verifyWellFormed", "write", "emitGroup", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "level", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SlotTable implements CompositionData, Iterable<CompositionGroup>, KMappedMarker {
    @NotNull
    private ArrayList<Anchor> anchors = new ArrayList<>();
    @NotNull
    private int[] groups = new int[0];
    private int groupsSize;
    private int readers;
    @NotNull
    private Object[] slots = new Object[0];
    private int slotsSize;
    private int version;
    private boolean writer;

    private final List<Integer> dataIndexes() {
        return SlotTableKt.dataAnchors(this.groups, this.groupsSize * 5);
    }

    private final int emitGroup(StringBuilder sb2, int i11, int i12) {
        boolean z11 = false;
        for (int i13 = 0; i13 < i12; i13++) {
            sb2.append(' ');
        }
        sb2.append("Group(");
        sb2.append(i11);
        sb2.append(") key=");
        sb2.append(SlotTableKt.key(this.groups, i11));
        int access$groupSize = SlotTableKt.groupSize(this.groups, i11);
        sb2.append(", nodes=");
        sb2.append(SlotTableKt.nodeCount(this.groups, i11));
        sb2.append(", size=");
        sb2.append(access$groupSize);
        if (SlotTableKt.hasMark(this.groups, i11)) {
            sb2.append(", mark");
        }
        if (SlotTableKt.containsMark(this.groups, i11)) {
            sb2.append(", contains mark");
        }
        int emitGroup$dataIndex = emitGroup$dataIndex(this, i11);
        int i14 = i11 + 1;
        int emitGroup$dataIndex2 = emitGroup$dataIndex(this, i14);
        if (emitGroup$dataIndex >= 0 && emitGroup$dataIndex <= emitGroup$dataIndex2) {
            z11 = true;
        }
        if (!z11 || emitGroup$dataIndex2 > this.slotsSize) {
            sb2.append(", *invalid data offsets " + emitGroup$dataIndex + SignatureVisitor.SUPER + emitGroup$dataIndex2 + TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH);
        } else {
            if (SlotTableKt.hasObjectKey(this.groups, i11)) {
                sb2.append(" objectKey=" + this.slots[SlotTableKt.objectKeyIndex(this.groups, i11)]);
            }
            if (SlotTableKt.isNode(this.groups, i11)) {
                sb2.append(" node=" + this.slots[SlotTableKt.nodeIndex(this.groups, i11)]);
            }
            if (SlotTableKt.hasAux(this.groups, i11)) {
                sb2.append(" aux=" + this.slots[SlotTableKt.auxIndex(this.groups, i11)]);
            }
            int access$slotAnchor = SlotTableKt.slotAnchor(this.groups, i11);
            if (access$slotAnchor < emitGroup$dataIndex2) {
                sb2.append(", slots=[");
                sb2.append(access$slotAnchor);
                sb2.append(": ");
                for (int i15 = access$slotAnchor; i15 < emitGroup$dataIndex2; i15++) {
                    if (i15 != access$slotAnchor) {
                        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                    }
                    sb2.append(String.valueOf(this.slots[i15]));
                }
                sb2.append("]");
            }
        }
        sb2.append(10);
        int i16 = i11 + access$groupSize;
        while (i14 < i16) {
            i14 += emitGroup(sb2, i14, i12 + 1);
        }
        return access$groupSize;
    }

    private static final int emitGroup$dataIndex(SlotTable slotTable, int i11) {
        return i11 >= slotTable.groupsSize ? slotTable.slotsSize : SlotTableKt.dataAnchor(slotTable.groups, i11);
    }

    private final RecomposeScopeImpl findEffectiveRecomposeScope(int i11) {
        while (i11 > 0) {
            Iterator<Object> it = new DataIterator(this, i11).iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof RecomposeScopeImpl) {
                    return (RecomposeScopeImpl) next;
                }
            }
            i11 = SlotTableKt.parentAnchor(this.groups, i11);
        }
        return null;
    }

    private final List<Integer> groupSizes() {
        return SlotTableKt.groupSizes(this.groups, this.groupsSize * 5);
    }

    private final boolean invalidateGroup(int i11) {
        while (i11 >= 0) {
            Iterator<Object> it = new DataIterator(this, i11).iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof RecomposeScopeImpl) {
                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) next;
                    recomposeScopeImpl.setRequiresRecompose(true);
                    if (recomposeScopeImpl.invalidateForResult((Object) null) != InvalidationResult.IGNORED) {
                        return true;
                    }
                    return false;
                }
            }
            i11 = SlotTableKt.parentAnchor(this.groups, i11);
        }
        return false;
    }

    /* renamed from: invalidateGroupsWithKey$lambda-14$scanGroup  reason: not valid java name */
    private static final void m2534invalidateGroupsWithKey$lambda14$scanGroup(SlotReader slotReader, int i11, List<Anchor> list, Ref.BooleanRef booleanRef, SlotTable slotTable, List<RecomposeScopeImpl> list2) {
        if (slotReader.getGroupKey() == i11) {
            list.add(SlotReader.anchor$default(slotReader, 0, 1, (Object) null));
            if (booleanRef.element) {
                RecomposeScopeImpl findEffectiveRecomposeScope = slotTable.findEffectiveRecomposeScope(slotReader.getCurrentGroup());
                if (findEffectiveRecomposeScope != null) {
                    list2.add(findEffectiveRecomposeScope);
                } else {
                    booleanRef.element = false;
                    list2.clear();
                }
            }
            slotReader.skipGroup();
            return;
        }
        slotReader.startGroup();
        while (!slotReader.isGroupEnd()) {
            m2534invalidateGroupsWithKey$lambda14$scanGroup(slotReader, i11, list, booleanRef, slotTable, list2);
        }
        slotReader.endGroup();
    }

    private final List<Integer> keys() {
        return SlotTableKt.keys(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> nodes() {
        return SlotTableKt.nodeCounts(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> parentIndexes() {
        return SlotTableKt.parentAnchors(this.groups, this.groupsSize * 5);
    }

    private static final int verifyWellFormed$validateGroup(Ref.IntRef intRef, SlotTable slotTable, int i11, int i12) {
        boolean z11;
        boolean z12;
        boolean z13;
        int i13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z21;
        int i14 = intRef.element;
        int i15 = i14 + 1;
        intRef.element = i15;
        int access$parentAnchor = SlotTableKt.parentAnchor(slotTable.groups, i14);
        boolean z22 = false;
        if (access$parentAnchor == i11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            int access$groupSize = SlotTableKt.groupSize(slotTable.groups, i14) + i14;
            if (access$groupSize <= slotTable.groupsSize) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (access$groupSize <= i12) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (z13) {
                    int access$dataAnchor = SlotTableKt.dataAnchor(slotTable.groups, i14);
                    if (i14 >= slotTable.groupsSize - 1) {
                        i13 = slotTable.slotsSize;
                    } else {
                        i13 = SlotTableKt.dataAnchor(slotTable.groups, i15);
                    }
                    if (i13 <= slotTable.slots.length) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (z14) {
                        if (access$dataAnchor <= i13) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        if (z15) {
                            if (SlotTableKt.slotAnchor(slotTable.groups, i14) <= i13) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                if (i13 - access$dataAnchor >= (SlotTableKt.isNode(slotTable.groups, i14) ? 1 : 0) + (SlotTableKt.hasObjectKey(slotTable.groups, i14) ? 1 : 0) + (SlotTableKt.hasAux(slotTable.groups, i14) ? 1 : 0)) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                if (z17) {
                                    boolean access$isNode = SlotTableKt.isNode(slotTable.groups, i14);
                                    if (!access$isNode || slotTable.slots[SlotTableKt.nodeIndex(slotTable.groups, i14)] != null) {
                                        z18 = true;
                                    } else {
                                        z18 = false;
                                    }
                                    if (z18) {
                                        int i16 = 0;
                                        while (intRef.element < access$groupSize) {
                                            i16 += verifyWellFormed$validateGroup(intRef, slotTable, i14, access$groupSize);
                                        }
                                        int access$nodeCount = SlotTableKt.nodeCount(slotTable.groups, i14);
                                        int access$groupSize2 = SlotTableKt.groupSize(slotTable.groups, i14);
                                        if (access$nodeCount == i16) {
                                            z19 = true;
                                        } else {
                                            z19 = false;
                                        }
                                        if (z19) {
                                            int i17 = intRef.element - i14;
                                            if (access$groupSize2 == i17) {
                                                z21 = true;
                                            } else {
                                                z21 = false;
                                            }
                                            if (z21) {
                                                if (SlotTableKt.containsAnyMark(slotTable.groups, i14)) {
                                                    if (i14 <= 0 || SlotTableKt.containsMark(slotTable.groups, i11)) {
                                                        z22 = true;
                                                    }
                                                    if (!z22) {
                                                        throw new IllegalStateException(("Expected group " + i11 + " to record it contains a mark because " + i14 + " does").toString());
                                                    }
                                                }
                                                if (access$isNode) {
                                                    return 1;
                                                }
                                                return i16;
                                            }
                                            throw new IllegalStateException(("Incorrect slot count detected at " + i14 + ", expected " + access$groupSize2 + ", received " + i17).toString());
                                        }
                                        throw new IllegalStateException(("Incorrect node count detected at " + i14 + ", expected " + access$nodeCount + ", received " + i16).toString());
                                    }
                                    throw new IllegalStateException(("No node recorded for a node group at " + i14).toString());
                                }
                                throw new IllegalStateException(("Not enough slots added for group " + i14).toString());
                            }
                            throw new IllegalStateException(("Slots start out of range at " + i14).toString());
                        }
                        throw new IllegalStateException(("Invalid data anchor at " + i14).toString());
                    }
                    throw new IllegalStateException(("Slots for " + i14 + " extend past the end of the slot table").toString());
                }
                throw new IllegalStateException(("A group extends past its parent group at " + i14).toString());
            }
            throw new IllegalStateException(("A group extends past the end of the table at " + i14).toString());
        }
        throw new IllegalStateException(("Invalid parent index detected at " + i14 + ", expected parent index to be " + i11 + " found " + access$parentAnchor).toString());
    }

    @NotNull
    public final Anchor anchor(int i11) {
        if (!this.writer) {
            boolean z11 = false;
            if (i11 >= 0 && i11 < this.groupsSize) {
                z11 = true;
            }
            if (z11) {
                ArrayList<Anchor> arrayList = this.anchors;
                int access$search = SlotTableKt.search(arrayList, i11, this.groupsSize);
                if (access$search < 0) {
                    Anchor anchor = new Anchor(i11);
                    arrayList.add(-(access$search + 1), anchor);
                    return anchor;
                }
                Anchor anchor2 = arrayList.get(access$search);
                Intrinsics.checkNotNullExpressionValue(anchor2, "get(location)");
                return anchor2;
            }
            throw new IllegalArgumentException("Parameter index is out of range".toString());
        }
        ComposerKt.composeRuntimeError("use active SlotWriter to create an anchor location instead ".toString());
        throw new KotlinNothingValueException();
    }

    public final int anchorIndex(@NotNull Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, Param.ANCHOR);
        if (!(!this.writer)) {
            ComposerKt.composeRuntimeError("Use active SlotWriter to determine anchor location instead".toString());
            throw new KotlinNothingValueException();
        } else if (anchor.getValid()) {
            return anchor.getLocation$runtime_release();
        } else {
            throw new IllegalArgumentException("Anchor refers to a group that was removed".toString());
        }
    }

    @NotNull
    public final String asString() {
        if (this.writer) {
            return super.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(10);
        int i11 = this.groupsSize;
        if (i11 > 0) {
            int i12 = 0;
            while (i12 < i11) {
                i12 += emitGroup(sb2, i12, 0);
            }
        } else {
            sb2.append("<EMPTY>");
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public final void close$runtime_release(@NotNull SlotReader slotReader) {
        Intrinsics.checkNotNullParameter(slotReader, "reader");
        if (slotReader.getTable$runtime_release() == this && this.readers > 0) {
            this.readers--;
        } else {
            ComposerKt.composeRuntimeError("Unexpected reader close()".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final boolean containsMark() {
        return this.groupsSize > 0 && SlotTableKt.containsMark(this.groups, 0);
    }

    @Nullable
    public CompositionGroup find(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "identityToFind");
        return new SlotTableGroup(this, 0, 0, 4, (DefaultConstructorMarker) null).find(obj);
    }

    @NotNull
    public final ArrayList<Anchor> getAnchors$runtime_release() {
        return this.anchors;
    }

    @NotNull
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }

    @NotNull
    public final int[] getGroups() {
        return this.groups;
    }

    public final int getGroupsSize() {
        return this.groupsSize;
    }

    @NotNull
    public final Object[] getSlots() {
        return this.slots;
    }

    public final int getSlotsSize() {
        return this.slotsSize;
    }

    public final int getVersion$runtime_release() {
        return this.version;
    }

    public final boolean getWriter$runtime_release() {
        return this.writer;
    }

    public final boolean groupContainsAnchor(int i11, @NotNull Anchor anchor) {
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(anchor, Param.ANCHOR);
        if (!this.writer) {
            if (i11 < 0 || i11 >= this.groupsSize) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                if (ownsAnchor(anchor)) {
                    int access$groupSize = SlotTableKt.groupSize(this.groups, i11) + i11;
                    int location$runtime_release = anchor.getLocation$runtime_release();
                    if (i11 > location$runtime_release || location$runtime_release >= access$groupSize) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    if (z12) {
                        return true;
                    }
                }
                return false;
            }
            ComposerKt.composeRuntimeError("Invalid group index".toString());
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("Writer is active".toString());
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: finally extract failed */
    @Nullable
    public final List<RecomposeScopeImpl> invalidateGroupsWithKey$runtime_release(int i11) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        SlotReader openReader = openReader();
        try {
            m2534invalidateGroupsWithKey$lambda14$scanGroup(openReader, i11, arrayList, booleanRef, this, arrayList2);
            Unit unit = Unit.INSTANCE;
            openReader.close();
            SlotWriter openWriter = openWriter();
            try {
                openWriter.startGroup();
                int size = arrayList.size();
                for (int i12 = 0; i12 < size; i12++) {
                    Anchor anchor = (Anchor) arrayList.get(i12);
                    if (anchor.toIndexFor(openWriter) >= openWriter.getCurrentGroup()) {
                        openWriter.seek(anchor);
                        openWriter.bashGroup$runtime_release();
                    }
                }
                openWriter.skipToGroupEnd();
                openWriter.endGroup();
                openWriter.close();
                if (booleanRef.element) {
                    return arrayList2;
                }
                return null;
            } catch (Throwable th2) {
                openWriter.close();
                throw th2;
            }
        } catch (Throwable th3) {
            openReader.close();
            throw th3;
        }
    }

    public boolean isEmpty() {
        return this.groupsSize == 0;
    }

    @NotNull
    public Iterator<CompositionGroup> iterator() {
        return new GroupIterator(this, 0, this.groupsSize);
    }

    @NotNull
    public final SlotReader openReader() {
        if (!this.writer) {
            this.readers++;
            return new SlotReader(this);
        }
        throw new IllegalStateException("Cannot read while a writer is pending".toString());
    }

    @NotNull
    public final SlotWriter openWriter() {
        boolean z11;
        if (!this.writer) {
            if (this.readers <= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                this.writer = true;
                this.version++;
                return new SlotWriter(this);
            }
            ComposerKt.composeRuntimeError("Cannot start a writer when a reader is pending".toString());
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("Cannot start a writer when another writer is pending".toString());
        throw new KotlinNothingValueException();
    }

    public final boolean ownsAnchor(@NotNull Anchor anchor) {
        boolean z11;
        Intrinsics.checkNotNullParameter(anchor, Param.ANCHOR);
        if (!anchor.getValid()) {
            return false;
        }
        int access$search = SlotTableKt.search(this.anchors, anchor.getLocation$runtime_release(), this.groupsSize);
        if (access$search < 0 || !Intrinsics.areEqual((Object) this.anchors.get(access$search), (Object) anchor)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return true;
        }
        return false;
    }

    public final <T> T read(@NotNull Function1<? super SlotReader, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        SlotReader openReader = openReader();
        try {
            return function1.invoke(openReader);
        } finally {
            InlineMarker.finallyStart(1);
            openReader.close();
            InlineMarker.finallyEnd(1);
        }
    }

    public final void setAnchors$runtime_release(@NotNull ArrayList<Anchor> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.anchors = arrayList;
    }

    public final void setTo$runtime_release(@NotNull int[] iArr, int i11, @NotNull Object[] objArr, int i12, @NotNull ArrayList<Anchor> arrayList) {
        Intrinsics.checkNotNullParameter(iArr, "groups");
        Intrinsics.checkNotNullParameter(objArr, "slots");
        Intrinsics.checkNotNullParameter(arrayList, "anchors");
        this.groups = iArr;
        this.groupsSize = i11;
        this.slots = objArr;
        this.slotsSize = i12;
        this.anchors = arrayList;
    }

    public final void setVersion$runtime_release(int i11) {
        this.version = i11;
    }

    @NotNull
    public final List<Object> slotsOf$runtime_release(int i11) {
        int i12;
        int access$dataAnchor = SlotTableKt.dataAnchor(this.groups, i11);
        int i13 = i11 + 1;
        if (i13 < this.groupsSize) {
            i12 = SlotTableKt.dataAnchor(this.groups, i13);
        } else {
            i12 = this.slots.length;
        }
        return ArraysKt___ArraysKt.toList((T[]) this.slots).subList(access$dataAnchor, i12);
    }

    public final void verifyWellFormed() {
        boolean z11;
        boolean z12;
        int i11;
        int i12;
        boolean z13;
        Ref.IntRef intRef = new Ref.IntRef();
        int i13 = -1;
        if (this.groupsSize > 0) {
            while (true) {
                i11 = intRef.element;
                i12 = this.groupsSize;
                if (i11 >= i12) {
                    break;
                }
                verifyWellFormed$validateGroup(intRef, this, -1, i11 + SlotTableKt.groupSize(this.groups, i11));
            }
            if (i11 == i12) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (!z13) {
                throw new IllegalStateException(("Incomplete group at root " + intRef.element + " expected to be " + this.groupsSize).toString());
            }
        }
        ArrayList<Anchor> arrayList = this.anchors;
        int size = arrayList.size();
        int i14 = 0;
        while (i14 < size) {
            int indexFor = arrayList.get(i14).toIndexFor(this);
            if (indexFor < 0 || indexFor > this.groupsSize) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                if (i13 < indexFor) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    i14++;
                    i13 = indexFor;
                } else {
                    throw new IllegalArgumentException("Anchor is out of order".toString());
                }
            } else {
                throw new IllegalArgumentException("Invalid anchor, location out of bound".toString());
            }
        }
    }

    public final <T> T write(@NotNull Function1<? super SlotWriter, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        SlotWriter openWriter = openWriter();
        try {
            return function1.invoke(openWriter);
        } finally {
            InlineMarker.finallyStart(1);
            openWriter.close();
            InlineMarker.finallyEnd(1);
        }
    }

    public final void close$runtime_release(@NotNull SlotWriter slotWriter, @NotNull int[] iArr, int i11, @NotNull Object[] objArr, int i12, @NotNull ArrayList<Anchor> arrayList) {
        Intrinsics.checkNotNullParameter(slotWriter, "writer");
        Intrinsics.checkNotNullParameter(iArr, "groups");
        Intrinsics.checkNotNullParameter(objArr, "slots");
        Intrinsics.checkNotNullParameter(arrayList, "anchors");
        if (slotWriter.getTable$runtime_release() == this && this.writer) {
            this.writer = false;
            setTo$runtime_release(iArr, i11, objArr, i12, arrayList);
            return;
        }
        throw new IllegalArgumentException("Unexpected writer close()".toString());
    }
}
