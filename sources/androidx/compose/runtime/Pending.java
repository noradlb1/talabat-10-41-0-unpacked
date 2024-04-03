package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020%2\u0006\u0010#\u001a\u00020\u0004J\u0016\u0010&\u001a\u00020'2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0006J\u001e\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006J\u0016\u0010-\u001a\u00020'2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006J\u000e\u0010.\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0004J\u0016\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006J\u000e\u00102\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0004R\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f`\u0010X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012RW\u0010\u0013\u001a>\u0012\u0004\u0012\u00020\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0014j\b\u0012\u0004\u0012\u00020\u0004`\u00150\u000ej\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0014j\b\u0012\u0004\u0012\u00020\u0004`\u0015`\u00108FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0012R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Landroidx/compose/runtime/Pending;", "", "keyInfos", "", "Landroidx/compose/runtime/KeyInfo;", "startIndex", "", "(Ljava/util/List;I)V", "groupIndex", "getGroupIndex", "()I", "setGroupIndex", "(I)V", "groupInfos", "Ljava/util/HashMap;", "Landroidx/compose/runtime/GroupInfo;", "Lkotlin/collections/HashMap;", "getKeyInfos", "()Ljava/util/List;", "keyMap", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "getKeyMap", "()Ljava/util/HashMap;", "keyMap$delegate", "Lkotlin/Lazy;", "getStartIndex", "used", "", "getUsed", "usedKeys", "getNext", "key", "dataKey", "nodePositionOf", "keyInfo", "recordUsed", "", "registerInsert", "", "insertIndex", "registerMoveNode", "from", "to", "count", "registerMoveSlot", "slotPositionOf", "updateNodeCount", "group", "newCount", "updatedNodeCountOf", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class Pending {
    private int groupIndex;
    @NotNull
    private final HashMap<Integer, GroupInfo> groupInfos;
    @NotNull
    private final List<KeyInfo> keyInfos;
    @NotNull
    private final Lazy keyMap$delegate;
    private final int startIndex;
    @NotNull
    private final List<KeyInfo> usedKeys;

    public Pending(@NotNull List<KeyInfo> list, int i11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(list, "keyInfos");
        this.keyInfos = list;
        this.startIndex = i11;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.usedKeys = new ArrayList();
            HashMap<Integer, GroupInfo> hashMap = new HashMap<>();
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                KeyInfo keyInfo = this.keyInfos.get(i13);
                hashMap.put(Integer.valueOf(keyInfo.getLocation()), new GroupInfo(i13, i12, keyInfo.getNodes()));
                i12 += keyInfo.getNodes();
            }
            this.groupInfos = hashMap;
            this.keyMap$delegate = LazyKt__LazyJVMKt.lazy(new Pending$keyMap$2(this));
            return;
        }
        throw new IllegalArgumentException("Invalid start index".toString());
    }

    public final int getGroupIndex() {
        return this.groupIndex;
    }

    @NotNull
    public final List<KeyInfo> getKeyInfos() {
        return this.keyInfos;
    }

    @NotNull
    public final HashMap<Object, LinkedHashSet<KeyInfo>> getKeyMap() {
        return (HashMap) this.keyMap$delegate.getValue();
    }

    @Nullable
    public final KeyInfo getNext(int i11, @Nullable Object obj) {
        Object obj2;
        if (obj != null) {
            obj2 = new JoinedKey(Integer.valueOf(i11), obj);
        } else {
            obj2 = Integer.valueOf(i11);
        }
        return (KeyInfo) ComposerKt.pop(getKeyMap(), obj2);
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    @NotNull
    public final List<KeyInfo> getUsed() {
        return this.usedKeys;
    }

    public final int nodePositionOf(@NotNull KeyInfo keyInfo) {
        Intrinsics.checkNotNullParameter(keyInfo, "keyInfo");
        GroupInfo groupInfo = this.groupInfos.get(Integer.valueOf(keyInfo.getLocation()));
        if (groupInfo != null) {
            return groupInfo.getNodeIndex();
        }
        return -1;
    }

    public final boolean recordUsed(@NotNull KeyInfo keyInfo) {
        Intrinsics.checkNotNullParameter(keyInfo, "keyInfo");
        return this.usedKeys.add(keyInfo);
    }

    public final void registerInsert(@NotNull KeyInfo keyInfo, int i11) {
        Intrinsics.checkNotNullParameter(keyInfo, "keyInfo");
        this.groupInfos.put(Integer.valueOf(keyInfo.getLocation()), new GroupInfo(-1, i11, 0));
    }

    public final void registerMoveNode(int i11, int i12, int i13) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        if (i11 > i12) {
            Collection<GroupInfo> values = this.groupInfos.values();
            Intrinsics.checkNotNullExpressionValue(values, "groupInfos.values");
            for (GroupInfo groupInfo : values) {
                int nodeIndex = groupInfo.getNodeIndex();
                if (i11 > nodeIndex || nodeIndex >= i11 + i13) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                if (z13) {
                    groupInfo.setNodeIndex((nodeIndex - i11) + i12);
                } else {
                    if (i12 > nodeIndex || nodeIndex >= i11) {
                        z14 = false;
                    } else {
                        z14 = true;
                    }
                    if (z14) {
                        groupInfo.setNodeIndex(nodeIndex + i13);
                    }
                }
            }
        } else if (i12 > i11) {
            Collection<GroupInfo> values2 = this.groupInfos.values();
            Intrinsics.checkNotNullExpressionValue(values2, "groupInfos.values");
            for (GroupInfo groupInfo2 : values2) {
                int nodeIndex2 = groupInfo2.getNodeIndex();
                if (i11 > nodeIndex2 || nodeIndex2 >= i11 + i13) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z11) {
                    groupInfo2.setNodeIndex((nodeIndex2 - i11) + i12);
                } else {
                    if (i11 + 1 > nodeIndex2 || nodeIndex2 >= i12) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    if (z12) {
                        groupInfo2.setNodeIndex(nodeIndex2 - i13);
                    }
                }
            }
        }
    }

    public final void registerMoveSlot(int i11, int i12) {
        boolean z11;
        boolean z12;
        if (i11 > i12) {
            Collection<GroupInfo> values = this.groupInfos.values();
            Intrinsics.checkNotNullExpressionValue(values, "groupInfos.values");
            for (GroupInfo groupInfo : values) {
                int slotIndex = groupInfo.getSlotIndex();
                if (slotIndex == i11) {
                    groupInfo.setSlotIndex(i12);
                } else {
                    if (i12 > slotIndex || slotIndex >= i11) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    if (z12) {
                        groupInfo.setSlotIndex(slotIndex + 1);
                    }
                }
            }
        } else if (i12 > i11) {
            Collection<GroupInfo> values2 = this.groupInfos.values();
            Intrinsics.checkNotNullExpressionValue(values2, "groupInfos.values");
            for (GroupInfo groupInfo2 : values2) {
                int slotIndex2 = groupInfo2.getSlotIndex();
                if (slotIndex2 == i11) {
                    groupInfo2.setSlotIndex(i12);
                } else {
                    if (i11 + 1 > slotIndex2 || slotIndex2 >= i12) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    if (z11) {
                        groupInfo2.setSlotIndex(slotIndex2 - 1);
                    }
                }
            }
        }
    }

    public final void setGroupIndex(int i11) {
        this.groupIndex = i11;
    }

    public final int slotPositionOf(@NotNull KeyInfo keyInfo) {
        Intrinsics.checkNotNullParameter(keyInfo, "keyInfo");
        GroupInfo groupInfo = this.groupInfos.get(Integer.valueOf(keyInfo.getLocation()));
        if (groupInfo != null) {
            return groupInfo.getSlotIndex();
        }
        return -1;
    }

    public final boolean updateNodeCount(int i11, int i12) {
        int nodeIndex;
        GroupInfo groupInfo = this.groupInfos.get(Integer.valueOf(i11));
        if (groupInfo == null) {
            return false;
        }
        int nodeIndex2 = groupInfo.getNodeIndex();
        int nodeCount = i12 - groupInfo.getNodeCount();
        groupInfo.setNodeCount(i12);
        if (nodeCount == 0) {
            return true;
        }
        Collection<GroupInfo> values = this.groupInfos.values();
        Intrinsics.checkNotNullExpressionValue(values, "groupInfos.values");
        for (GroupInfo groupInfo2 : values) {
            if (groupInfo2.getNodeIndex() >= nodeIndex2 && !Intrinsics.areEqual((Object) groupInfo2, (Object) groupInfo) && (nodeIndex = groupInfo2.getNodeIndex() + nodeCount) >= 0) {
                groupInfo2.setNodeIndex(nodeIndex);
            }
        }
        return true;
    }

    public final int updatedNodeCountOf(@NotNull KeyInfo keyInfo) {
        Intrinsics.checkNotNullParameter(keyInfo, "keyInfo");
        GroupInfo groupInfo = this.groupInfos.get(Integer.valueOf(keyInfo.getLocation()));
        if (groupInfo != null) {
            return groupInfo.getNodeCount();
        }
        return keyInfo.getNodes();
    }
}
