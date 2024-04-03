package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u001c\n\u0002\b\n\u001a\u0010\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u001a\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u001b\u001a\u00020\u001c*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u001d\u001a\u00020\u001c*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u001e\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010 *\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u0001H\u0002\u001a;\u0010\"\u001a\u00020#*\u0012\u0012\u0004\u0012\u00020#0$j\b\u0012\u0004\u0012\u00020#`%2\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u00012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020#0)H\b\u001a\u0014\u0010*\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u0010+\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00010 *\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u0001H\u0002\u001a\u0014\u0010-\u001a\u00020\u001c*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u0010.\u001a\u00020\u001c*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u0010/\u001a\u00020\u001c*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001aD\u00100\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0002\u001a\u0014\u00102\u001a\u00020\u001c*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u00101\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u00010 *\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u0001H\u0002\u001a,\u00107\u001a\u00020\u0001*\u0012\u0012\u0004\u0012\u00020#0$j\b\u0012\u0004\u0012\u00020#`%2\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0001H\u0002\u001a\u0014\u00108\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u00010 *\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u0001H\u0002\u001a\u0014\u0010:\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u0010;\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u00105\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00010 *\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u0001H\u0002\u001a,\u0010=\u001a\u00020\u0001*\u0012\u0012\u0004\u0012\u00020#0$j\b\u0012\u0004\u0012\u00020#`%2\u0006\u0010>\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0001H\u0002\u001a \u0010?\u001a\b\u0012\u0004\u0012\u00020\u00010 *\u00020\u00182\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00010AH\u0002\u001a\u0014\u0010B\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u001c\u0010C\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u001cH\u0002\u001a\u001c\u0010D\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010E\u001a\u00020\u0001H\u0002\u001a\u001c\u0010F\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\u0002\u001a\u001c\u0010G\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\u001a\u001c\u0010H\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u001cH\u0002\u001a\u001c\u0010I\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\u001a\u001c\u0010J\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Aux_Mask", "", "Aux_Shift", "ContainsMark_Mask", "DataAnchor_Offset", "GroupInfo_Offset", "Group_Fields_Size", "Key_Offset", "Mark_Mask", "MinGroupGrowthSize", "MinSlotsGrowthSize", "NodeBit_Mask", "NodeCount_Mask", "NodeKey", "ObjectKey_Mask", "ObjectKey_Shift", "ParentAnchor_Offset", "Size_Offset", "Slots_Shift", "parentAnchorPivot", "countOneBits", "value", "addAux", "", "", "address", "auxIndex", "containsAnyMark", "", "containsMark", "dataAnchor", "dataAnchors", "", "len", "getOrAdd", "Landroidx/compose/runtime/Anchor;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "index", "effectiveSize", "block", "Lkotlin/Function0;", "groupInfo", "groupSize", "groupSizes", "hasAux", "hasMark", "hasObjectKey", "initGroup", "key", "isNode", "hasDataKey", "hasData", "parentAnchor", "keys", "locationOf", "nodeCount", "nodeCounts", "nodeIndex", "objectKeyIndex", "parentAnchors", "search", "location", "slice", "indices", "", "slotAnchor", "updateContainsMark", "updateDataAnchor", "anchor", "updateGroupKey", "updateGroupSize", "updateMark", "updateNodeCount", "updateParentAnchor", "runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SlotTableKt {
    private static final int Aux_Mask = 268435456;
    private static final int Aux_Shift = 28;
    private static final int ContainsMark_Mask = 67108864;
    private static final int DataAnchor_Offset = 4;
    private static final int GroupInfo_Offset = 1;
    private static final int Group_Fields_Size = 5;
    private static final int Key_Offset = 0;
    private static final int Mark_Mask = 134217728;
    private static final int MinGroupGrowthSize = 32;
    private static final int MinSlotsGrowthSize = 32;
    private static final int NodeBit_Mask = 1073741824;
    private static final int NodeCount_Mask = 67108863;
    private static final int NodeKey = 125;
    private static final int ObjectKey_Mask = 536870912;
    private static final int ObjectKey_Shift = 29;
    private static final int ParentAnchor_Offset = 2;
    private static final int Size_Offset = 3;
    private static final int Slots_Shift = 28;
    private static final int parentAnchorPivot = -2;

    public static /* synthetic */ List a(int[] iArr, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = iArr.length;
        }
        return dataAnchors(iArr, i11);
    }

    /* access modifiers changed from: private */
    public static final void addAux(int[] iArr, int i11) {
        int i12 = (i11 * 5) + 1;
        iArr[i12] = iArr[i12] | 268435456;
    }

    /* access modifiers changed from: private */
    public static final int auxIndex(int[] iArr, int i11) {
        int i12 = i11 * 5;
        if (i12 >= iArr.length) {
            return iArr.length;
        }
        return countOneBits(iArr[i12 + 1] >> 29) + iArr[i12 + 4];
    }

    public static /* synthetic */ List b(int[] iArr, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = iArr.length;
        }
        return keys(iArr, i11);
    }

    /* access modifiers changed from: private */
    public static final boolean containsAnyMark(int[] iArr, int i11) {
        return (iArr[(i11 * 5) + 1] & 201326592) != 0;
    }

    /* access modifiers changed from: private */
    public static final boolean containsMark(int[] iArr, int i11) {
        return (iArr[(i11 * 5) + 1] & ContainsMark_Mask) != 0;
    }

    /* access modifiers changed from: private */
    public static final int countOneBits(int i11) {
        switch (i11) {
            case 0:
                return 0;
            case 1:
            case 2:
            case 4:
                return 1;
            case 3:
            case 5:
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    /* access modifiers changed from: private */
    public static final int dataAnchor(int[] iArr, int i11) {
        return iArr[(i11 * 5) + 4];
    }

    /* access modifiers changed from: private */
    public static final List<Integer> dataAnchors(int[] iArr, int i11) {
        return slice(iArr, RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(4, i11), 5));
    }

    private static final Anchor getOrAdd(ArrayList<Anchor> arrayList, int i11, int i12, Function0<Anchor> function0) {
        int access$search = search(arrayList, i11, i12);
        if (access$search < 0) {
            Anchor invoke = function0.invoke();
            arrayList.add(-(access$search + 1), invoke);
            return invoke;
        }
        Anchor anchor = arrayList.get(access$search);
        Intrinsics.checkNotNullExpressionValue(anchor, "get(location)");
        return anchor;
    }

    /* access modifiers changed from: private */
    public static final int groupInfo(int[] iArr, int i11) {
        return iArr[(i11 * 5) + 1];
    }

    /* access modifiers changed from: private */
    public static final int groupSize(int[] iArr, int i11) {
        return iArr[(i11 * 5) + 3];
    }

    /* access modifiers changed from: private */
    public static final List<Integer> groupSizes(int[] iArr, int i11) {
        return slice(iArr, RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(3, i11), 5));
    }

    /* access modifiers changed from: private */
    public static final boolean hasAux(int[] iArr, int i11) {
        return (iArr[(i11 * 5) + 1] & 268435456) != 0;
    }

    /* access modifiers changed from: private */
    public static final boolean hasMark(int[] iArr, int i11) {
        return (iArr[(i11 * 5) + 1] & 134217728) != 0;
    }

    /* access modifiers changed from: private */
    public static final boolean hasObjectKey(int[] iArr, int i11) {
        return (iArr[(i11 * 5) + 1] & 536870912) != 0;
    }

    /* access modifiers changed from: private */
    public static final void initGroup(int[] iArr, int i11, int i12, boolean z11, boolean z12, boolean z13, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        if (z11) {
            i15 = 1073741824;
        } else {
            i15 = 0;
        }
        if (z12) {
            i16 = 536870912;
        } else {
            i16 = 0;
        }
        if (z13) {
            i17 = 268435456;
        } else {
            i17 = 0;
        }
        int i18 = i11 * 5;
        iArr[i18 + 0] = i12;
        iArr[i18 + 1] = i15 | i16 | i17;
        iArr[i18 + 2] = i13;
        iArr[i18 + 3] = 0;
        iArr[i18 + 4] = i14;
    }

    /* access modifiers changed from: private */
    public static final boolean isNode(int[] iArr, int i11) {
        return (iArr[(i11 * 5) + 1] & 1073741824) != 0;
    }

    /* access modifiers changed from: private */
    public static final int key(int[] iArr, int i11) {
        return iArr[i11 * 5];
    }

    /* access modifiers changed from: private */
    public static final List<Integer> keys(int[] iArr, int i11) {
        return slice(iArr, RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(0, i11), 5));
    }

    /* access modifiers changed from: private */
    public static final int locationOf(ArrayList<Anchor> arrayList, int i11, int i12) {
        int search = search(arrayList, i11, i12);
        return search >= 0 ? search : -(search + 1);
    }

    /* access modifiers changed from: private */
    public static final int nodeCount(int[] iArr, int i11) {
        return iArr[(i11 * 5) + 1] & NodeCount_Mask;
    }

    /* access modifiers changed from: private */
    public static final List<Integer> nodeCounts(int[] iArr, int i11) {
        List<Integer> slice = slice(iArr, RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(1, i11), 5));
        ArrayList arrayList = new ArrayList(slice.size());
        int size = slice.size();
        for (int i12 = 0; i12 < size; i12++) {
            arrayList.add(Integer.valueOf(slice.get(i12).intValue() & NodeCount_Mask));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final int nodeIndex(int[] iArr, int i11) {
        return iArr[(i11 * 5) + 4];
    }

    /* access modifiers changed from: private */
    public static final int objectKeyIndex(int[] iArr, int i11) {
        int i12 = i11 * 5;
        return iArr[i12 + 4] + countOneBits(iArr[i12 + 1] >> 30);
    }

    /* access modifiers changed from: private */
    public static final int parentAnchor(int[] iArr, int i11) {
        return iArr[(i11 * 5) + 2];
    }

    /* access modifiers changed from: private */
    public static final List<Integer> parentAnchors(int[] iArr, int i11) {
        return slice(iArr, RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(2, i11), 5));
    }

    /* access modifiers changed from: private */
    public static final int search(ArrayList<Anchor> arrayList, int i11, int i12) {
        int size = arrayList.size() - 1;
        int i13 = 0;
        while (i13 <= size) {
            int i14 = (i13 + size) >>> 1;
            int location$runtime_release = arrayList.get(i14).getLocation$runtime_release();
            if (location$runtime_release < 0) {
                location$runtime_release += i12;
            }
            int compare = Intrinsics.compare(location$runtime_release, i11);
            if (compare < 0) {
                i13 = i14 + 1;
            } else if (compare <= 0) {
                return i14;
            } else {
                size = i14 - 1;
            }
        }
        return -(i13 + 1);
    }

    private static final List<Integer> slice(int[] iArr, Iterable<Integer> iterable) {
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : iterable) {
            arrayList.add(Integer.valueOf(iArr[intValue.intValue()]));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final int slotAnchor(int[] iArr, int i11) {
        int i12 = i11 * 5;
        return iArr[i12 + 4] + countOneBits(iArr[i12 + 1] >> 28);
    }

    /* access modifiers changed from: private */
    public static final void updateContainsMark(int[] iArr, int i11, boolean z11) {
        int i12 = (i11 * 5) + 1;
        if (z11) {
            iArr[i12] = iArr[i12] | ContainsMark_Mask;
        } else {
            iArr[i12] = iArr[i12] & -67108865;
        }
    }

    /* access modifiers changed from: private */
    public static final void updateDataAnchor(int[] iArr, int i11, int i12) {
        iArr[(i11 * 5) + 4] = i12;
    }

    private static final void updateGroupKey(int[] iArr, int i11, int i12) {
        iArr[(i11 * 5) + 0] = i12;
    }

    /* access modifiers changed from: private */
    public static final void updateGroupSize(int[] iArr, int i11, int i12) {
        boolean z11;
        if (i12 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        ComposerKt.runtimeCheck(z11);
        iArr[(i11 * 5) + 3] = i12;
    }

    /* access modifiers changed from: private */
    public static final void updateMark(int[] iArr, int i11, boolean z11) {
        int i12 = (i11 * 5) + 1;
        if (z11) {
            iArr[i12] = iArr[i12] | 134217728;
        } else {
            iArr[i12] = iArr[i12] & -134217729;
        }
    }

    /* access modifiers changed from: private */
    public static final void updateNodeCount(int[] iArr, int i11, int i12) {
        boolean z11;
        if (i12 < 0 || i12 >= NodeCount_Mask) {
            z11 = false;
        } else {
            z11 = true;
        }
        ComposerKt.runtimeCheck(z11);
        int i13 = (i11 * 5) + 1;
        iArr[i13] = i12 | (iArr[i13] & -67108864);
    }

    /* access modifiers changed from: private */
    public static final void updateParentAnchor(int[] iArr, int i11, int i12) {
        iArr[(i11 * 5) + 2] = i12;
    }
}
