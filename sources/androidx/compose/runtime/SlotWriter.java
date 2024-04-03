package androidx.compose.runtime;

import androidx.compose.runtime.Composer;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u001f\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b8\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\nJ\u000e\u00105\u001a\u0002022\u0006\u00104\u001a\u00020\nJ\u0010\u00106\u001a\u00020\u00072\b\b\u0002\u00107\u001a\u00020\nJ\u000e\u00108\u001a\u00020\n2\u0006\u00106\u001a\u00020\u0007J\r\u00109\u001a\u000202H\u0000¢\u0006\u0002\b:J\u0006\u0010;\u001a\u000202J\u0010\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\nH\u0002J\u0006\u0010>\u001a\u000202J\u0010\u0010?\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\nH\u0002J\u0010\u0010@\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\nH\u0002J \u0010A\u001a\u00020\n2\u0006\u00106\u001a\u00020\n2\u0006\u0010B\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010C\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0002J\u0010\u0010D\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0002J(\u0010E\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u0010F\u001a\u00020\n2\u0006\u0010B\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010G\u001a\u00020\nJ\u0006\u0010H\u001a\u000202J\u000e\u0010I\u001a\u0002022\u0006\u00106\u001a\u00020\u0007J\u000e\u0010I\u001a\u0002022\u0006\u00107\u001a\u00020\nJ \u0010J\u001a\u0002022\u0006\u0010\"\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n2\u0006\u0010K\u001a\u00020\nH\u0002J\u0010\u0010L\u001a\u0004\u0018\u00010\u00012\u0006\u00107\u001a\u00020\nJ\u0010\u0010M\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0002J\u000e\u0010N\u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u0010\u0010O\u001a\u0004\u0018\u00010\u00012\u0006\u00107\u001a\u00020\nJ\u000e\u0010P\u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u000e\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010RJ\u0006\u0010S\u001a\u00020TJ\u000e\u0010U\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\nJ\u0016\u0010V\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010W\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\nJ\u0010\u0010X\u001a\u0002022\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u0010\u0010Z\u001a\u0002022\u0006\u0010&\u001a\u00020\nH\u0002J\u000e\u0010[\u001a\u0002022\u0006\u0010\\\u001a\u00020\nJ\u0018\u0010]\u001a\u0002022\u0006\u0010&\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0002J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\nJ\u000e\u0010^\u001a\b\u0012\u0004\u0012\u00020\n0_H\u0002J\u0010\u0010`\u001a\u0002022\b\b\u0002\u0010=\u001a\u00020\nJ \u0010a\u001a\u0002022\u0006\u0010b\u001a\u00020\n2\u0006\u0010c\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J\u001c\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00070_2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00107\u001a\u00020\nJ\u000e\u0010e\u001a\u0002022\u0006\u0010f\u001a\u00020\nJ\u0010\u0010g\u001a\u0002022\u0006\u00107\u001a\u00020\nH\u0002J$\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00070_2\u0006\u0010f\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00107\u001a\u00020\nJ\u0018\u0010i\u001a\u0002022\u0006\u00107\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0002J$\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00070_2\u0006\u00106\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\n2\u0006\u0010k\u001a\u00020\u0000J\u0010\u0010l\u001a\u0004\u0018\u00010\u00012\u0006\u00106\u001a\u00020\u0007J\u0010\u0010l\u001a\u0004\u0018\u00010\u00012\u0006\u00107\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\n2\u0006\u00106\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u0010\u0010m\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0002J\u0018\u0010n\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u0010F\u001a\u00020\nH\u0002J\b\u0010o\u001a\u000202H\u0002J\u0018\u0010p\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J\u0006\u0010q\u001a\u00020\u000eJ\u0018\u0010r\u001a\u00020\u000e2\u0006\u0010s\u001a\u00020\n2\u0006\u0010t\u001a\u00020\nH\u0002J \u0010u\u001a\u0002022\u0006\u0010s\u001a\u00020\n2\u0006\u0010t\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0002J\u0006\u0010v\u001a\u000202J\b\u0010w\u001a\u00020\nH\u0002J\b\u0010x\u001a\u000202H\u0002J\u000e\u0010y\u001a\u0002022\u0006\u00106\u001a\u00020\u0007J\u0010\u0010z\u001a\u0002022\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u001a\u0010z\u001a\u0004\u0018\u00010\u00012\u0006\u00107\u001a\u00020\n2\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\b\u0010{\u001a\u0004\u0018\u00010\u0001J\u0006\u0010|\u001a\u00020\nJ\u0006\u0010}\u001a\u000202J\u0018\u0010~\u001a\u0004\u0018\u00010\u00012\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\nJ\u0018\u0010~\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u001a\u0010\u0001\u001a\u0002022\u0006\u0010\\\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001J%\u0010\u0001\u001a\u0002022\u0006\u0010\\\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001J\u0007\u0010\u0001\u001a\u000202J\u000f\u0010\u0001\u001a\u0002022\u0006\u0010\\\u001a\u00020\nJ\u001a\u0010\u0001\u001a\u0002022\u0006\u0010\\\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001J/\u0010\u0001\u001a\u0002022\u0006\u0010\\\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u00020\u000e2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001H\u0002J\u0011\u0010\u0001\u001a\u0002022\b\u0010\\\u001a\u0004\u0018\u00010\u0001J\u001b\u0010\u0001\u001a\u0002022\b\u0010\\\u001a\u0004\u0018\u00010\u00012\b\u0010l\u001a\u0004\u0018\u00010\u0001J\t\u0010\u0001\u001a\u00020TH\u0016J\u0013\u0010\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u001b\u0010\u0001\u001a\u0002022\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0002J\u0011\u0010\u0001\u001a\u0002022\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u0011\u0010\u0001\u001a\u0002022\u0006\u0010=\u001a\u00020\nH\u0002J\u0019\u0010\u0001\u001a\u0002022\u0006\u0010=\u001a\u00020\n2\u0006\u0010z\u001a\u00020%H\u0002J\u0019\u0010\u0001\u001a\u0002022\u0006\u00106\u001a\u00020\u00072\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u0011\u0010\u0001\u001a\u0002022\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u001b\u0010\u0001\u001a\u0002022\u0006\u00107\u001a\u00020\n2\b\u0010Y\u001a\u0004\u0018\u00010\u0001H\u0002J\u0011\u0010\u0001\u001a\u0002022\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u000f\u0010\u0001\u001a\u000202H\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u000202H\u0000¢\u0006\u0003\b\u0001J\u0015\u0010\u0001\u001a\u00020\n*\u00020\u001c2\u0006\u00103\u001a\u00020\nH\u0002J\u0014\u0010C\u001a\u00020\n*\u00020\u001c2\u0006\u00103\u001a\u00020\nH\u0002J\u0013\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\n0_*\u00020\u001cH\u0002J\u001b\u0010\u0001\u001a\u000202*\b0\u0001j\u0003`\u00012\u0006\u00107\u001a\u00020\nH\u0002J\u0015\u0010\u0001\u001a\u00020\n*\u00020\u001c2\u0006\u00103\u001a\u00020\nH\u0002J\u0014\u0010\"\u001a\u00020\n*\u00020\u001c2\u0006\u00107\u001a\u00020\nH\u0002J\u0015\u0010\u0001\u001a\u00020\n*\u00020\u001c2\u0006\u00103\u001a\u00020\nH\u0002J\u001d\u0010\u0001\u001a\u000202*\u00020\u001c2\u0006\u00103\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u000e\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0011R\u0011\u0010\u001f\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011R\u000e\u0010 \u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\fR\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\fR\u0018\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010)X\u000e¢\u0006\u0004\n\u0002\u0010*R\u000e\u0010+\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/SlotWriter;", "", "table", "Landroidx/compose/runtime/SlotTable;", "(Landroidx/compose/runtime/SlotTable;)V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "capacity", "", "getCapacity", "()I", "<set-?>", "", "closed", "getClosed", "()Z", "currentGroup", "getCurrentGroup", "currentGroupEnd", "currentSlot", "currentSlotEnd", "endStack", "Landroidx/compose/runtime/IntStack;", "groupGapLen", "groupGapStart", "groups", "", "insertCount", "isGroupEnd", "isNode", "nodeCount", "nodeCountStack", "parent", "getParent", "pendingRecalculateMarks", "Landroidx/compose/runtime/PrioritySet;", "size", "getSize$runtime_release", "slots", "", "[Ljava/lang/Object;", "slotsGapLen", "slotsGapOwner", "slotsGapStart", "startStack", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "addToGroupSizeAlongSpine", "", "address", "amount", "advanceBy", "anchor", "index", "anchorIndex", "bashGroup", "bashGroup$runtime_release", "beginInsert", "childContainsAnyMarks", "group", "close", "containsAnyGroupMarks", "containsGroupMark", "dataAnchorToDataIndex", "gapLen", "dataIndex", "dataIndexToDataAddress", "dataIndexToDataAnchor", "gapStart", "endGroup", "endInsert", "ensureStarted", "fixParentAnchorsFor", "firstChild", "groupAux", "groupIndexToAddress", "groupKey", "groupObjectKey", "groupSize", "groupSlots", "", "groupsAsString", "", "indexInCurrentGroup", "indexInGroup", "indexInParent", "insertAux", "value", "insertGroups", "insertParentGroup", "key", "insertSlots", "keys", "", "markGroup", "moveAnchors", "originalLocation", "newLocation", "moveFrom", "moveGroup", "offset", "moveGroupGapTo", "moveIntoGroupFrom", "moveSlotGapTo", "moveTo", "writer", "node", "parentAnchorToIndex", "parentIndexToAnchor", "recalculateMarks", "removeAnchors", "removeGroup", "removeGroups", "start", "len", "removeSlots", "reset", "restoreCurrentGroupEnd", "saveCurrentGroupEnd", "seek", "set", "skip", "skipGroup", "skipToGroupEnd", "slot", "groupIndex", "startData", "aux", "objectKey", "startGroup", "dataKey", "startNode", "toString", "update", "updateAnchors", "previousGapStart", "newGapStart", "updateAux", "updateContainsMark", "updateContainsMarkNow", "updateNode", "updateNodeOfGroup", "updateParentNode", "verifyDataAnchors", "verifyDataAnchors$runtime_release", "verifyParentAnchors", "verifyParentAnchors$runtime_release", "auxIndex", "dataIndexes", "groupAsString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nodeIndex", "slotIndex", "updateDataIndex", "Companion", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SlotWriter {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public ArrayList<Anchor> anchors;
    private boolean closed;
    /* access modifiers changed from: private */
    public int currentGroup;
    private int currentGroupEnd;
    /* access modifiers changed from: private */
    public int currentSlot;
    private int currentSlotEnd;
    @NotNull
    private final IntStack endStack = new IntStack();
    private int groupGapLen;
    /* access modifiers changed from: private */
    public int groupGapStart;
    /* access modifiers changed from: private */
    @NotNull
    public int[] groups;
    private int insertCount;
    /* access modifiers changed from: private */
    public int nodeCount;
    @NotNull
    private final IntStack nodeCountStack = new IntStack();
    private int parent = -1;
    @Nullable
    private PrioritySet pendingRecalculateMarks;
    /* access modifiers changed from: private */
    @NotNull
    public Object[] slots;
    /* access modifiers changed from: private */
    public int slotsGapLen;
    /* access modifiers changed from: private */
    public int slotsGapOwner;
    /* access modifiers changed from: private */
    public int slotsGapStart;
    @NotNull
    private final IntStack startStack = new IntStack();
    @NotNull
    private final SlotTable table;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002¨\u0006\u000e"}, d2 = {"Landroidx/compose/runtime/SlotWriter$Companion;", "", "()V", "moveGroup", "", "Landroidx/compose/runtime/Anchor;", "fromWriter", "Landroidx/compose/runtime/SlotWriter;", "fromIndex", "", "toWriter", "updateFromCursor", "", "updateToCursor", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final List<Anchor> moveGroup(SlotWriter slotWriter, int i11, SlotWriter slotWriter2, boolean z11, boolean z12) {
            int i12;
            ArrayList arrayList;
            boolean z13;
            int i13;
            SlotWriter slotWriter3 = slotWriter;
            int i14 = i11;
            SlotWriter slotWriter4 = slotWriter2;
            int groupSize = slotWriter.groupSize(i11);
            int i15 = i14 + groupSize;
            int access$dataIndex = slotWriter.dataIndex(i11);
            int access$dataIndex2 = slotWriter3.dataIndex(i15);
            int i16 = access$dataIndex2 - access$dataIndex;
            boolean access$containsAnyGroupMarks = slotWriter.containsAnyGroupMarks(i11);
            slotWriter4.insertGroups(groupSize);
            slotWriter4.insertSlots(i16, slotWriter2.getCurrentGroup());
            if (slotWriter.groupGapStart < i15) {
                slotWriter3.moveGroupGapTo(i15);
            }
            if (slotWriter.slotsGapStart < access$dataIndex2) {
                slotWriter3.moveSlotGapTo(access$dataIndex2, i15);
            }
            int[] access$getGroups$p = slotWriter2.groups;
            int currentGroup = slotWriter2.getCurrentGroup();
            int[] unused = ArraysKt___ArraysJvmKt.copyInto(slotWriter.groups, access$getGroups$p, currentGroup * 5, i14 * 5, i15 * 5);
            Object[] access$getSlots$p = slotWriter2.slots;
            int access$getCurrentSlot$p = slotWriter2.currentSlot;
            Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) slotWriter.slots, (T[]) access$getSlots$p, access$getCurrentSlot$p, access$dataIndex, access$dataIndex2);
            int parent = slotWriter2.getParent();
            SlotTableKt.updateParentAnchor(access$getGroups$p, currentGroup, parent);
            int i17 = currentGroup - i14;
            int i18 = currentGroup + groupSize;
            int access$dataIndex3 = access$getCurrentSlot$p - slotWriter4.dataIndex(access$getGroups$p, currentGroup);
            int access$getSlotsGapOwner$p = slotWriter2.slotsGapOwner;
            int i19 = parent;
            int access$getSlotsGapLen$p = slotWriter2.slotsGapLen;
            int length = access$getSlots$p.length;
            boolean z14 = access$containsAnyGroupMarks;
            int i21 = access$getSlotsGapOwner$p;
            int i22 = access$getCurrentSlot$p;
            int i23 = currentGroup;
            while (true) {
                i12 = 0;
                if (i23 >= i18) {
                    break;
                }
                if (i23 != currentGroup) {
                    i13 = i18;
                    SlotTableKt.updateParentAnchor(access$getGroups$p, i23, SlotTableKt.parentAnchor(access$getGroups$p, i23) + i17);
                } else {
                    i13 = i18;
                }
                int access$dataIndex4 = slotWriter4.dataIndex(access$getGroups$p, i23) + access$dataIndex3;
                if (i21 >= i23) {
                    i12 = slotWriter2.slotsGapStart;
                }
                int i24 = access$dataIndex3;
                SlotTableKt.updateDataAnchor(access$getGroups$p, i23, slotWriter4.dataIndexToDataAnchor(access$dataIndex4, i12, access$getSlotsGapLen$p, length));
                if (i23 == i21) {
                    i21++;
                }
                i23++;
                access$dataIndex3 = i24;
                i18 = i13;
            }
            int i25 = i18;
            slotWriter4.slotsGapOwner = i21;
            int access$locationOf = SlotTableKt.locationOf(slotWriter.anchors, i14, slotWriter.getSize$runtime_release());
            int access$locationOf2 = SlotTableKt.locationOf(slotWriter.anchors, i15, slotWriter.getSize$runtime_release());
            if (access$locationOf < access$locationOf2) {
                ArrayList access$getAnchors$p = slotWriter.anchors;
                ArrayList arrayList2 = new ArrayList(access$locationOf2 - access$locationOf);
                for (int i26 = access$locationOf; i26 < access$locationOf2; i26++) {
                    Object obj = access$getAnchors$p.get(i26);
                    Intrinsics.checkNotNullExpressionValue(obj, "sourceAnchors[anchorIndex]");
                    Anchor anchor = (Anchor) obj;
                    anchor.setLocation$runtime_release(anchor.getLocation$runtime_release() + i17);
                    arrayList2.add(anchor);
                }
                slotWriter2.anchors.addAll(SlotTableKt.locationOf(slotWriter2.anchors, slotWriter2.getCurrentGroup(), slotWriter2.getSize$runtime_release()), arrayList2);
                access$getAnchors$p.subList(access$locationOf, access$locationOf2).clear();
                arrayList = arrayList2;
            } else {
                arrayList = CollectionsKt__CollectionsKt.emptyList();
            }
            int parent2 = slotWriter.parent(i11);
            int i27 = 1;
            if (z11) {
                if (parent2 >= 0) {
                    i12 = 1;
                }
                if (i12 != 0) {
                    slotWriter.startGroup();
                    slotWriter3.advanceBy(parent2 - slotWriter.getCurrentGroup());
                    slotWriter.startGroup();
                }
                slotWriter3.advanceBy(i14 - slotWriter.getCurrentGroup());
                z13 = slotWriter.removeGroup();
                if (i12 != 0) {
                    slotWriter.skipToGroupEnd();
                    slotWriter.endGroup();
                    slotWriter.skipToGroupEnd();
                    slotWriter.endGroup();
                }
            } else {
                boolean access$removeGroups = slotWriter3.removeGroups(i14, groupSize);
                slotWriter3.removeSlots(access$dataIndex, i16, i14 - 1);
                z13 = access$removeGroups;
            }
            if (!z13) {
                int access$getNodeCount$p = slotWriter2.nodeCount;
                if (!SlotTableKt.isNode(access$getGroups$p, currentGroup)) {
                    i27 = SlotTableKt.nodeCount(access$getGroups$p, currentGroup);
                }
                slotWriter4.nodeCount = access$getNodeCount$p + i27;
                if (z12) {
                    slotWriter4.currentGroup = i25;
                    slotWriter4.currentSlot = i22 + i16;
                }
                if (z14) {
                    slotWriter4.updateContainsMark(i19);
                }
                return arrayList;
            }
            ComposerKt.composeRuntimeError("Unexpectedly removed anchors".toString());
            throw new KotlinNothingValueException();
        }
    }

    public SlotWriter(@NotNull SlotTable slotTable) {
        Intrinsics.checkNotNullParameter(slotTable, "table");
        this.table = slotTable;
        this.groups = slotTable.getGroups();
        this.slots = slotTable.getSlots();
        this.anchors = slotTable.getAnchors$runtime_release();
        this.groupGapStart = slotTable.getGroupsSize();
        this.groupGapLen = (this.groups.length / 5) - slotTable.getGroupsSize();
        this.currentGroupEnd = slotTable.getGroupsSize();
        this.slotsGapStart = slotTable.getSlotsSize();
        this.slotsGapLen = this.slots.length - slotTable.getSlotsSize();
        this.slotsGapOwner = slotTable.getGroupsSize();
    }

    public static /* synthetic */ Anchor anchor$default(SlotWriter slotWriter, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = slotWriter.currentGroup;
        }
        return slotWriter.anchor(i11);
    }

    private final int auxIndex(int[] iArr, int i11) {
        return dataIndex(iArr, i11) + SlotTableKt.countOneBits(SlotTableKt.groupInfo(iArr, i11) >> 29);
    }

    private final boolean childContainsAnyMarks(int i11) {
        int i12 = i11 + 1;
        int groupSize = i11 + groupSize(i11);
        while (i12 < groupSize) {
            if (SlotTableKt.containsAnyMark(this.groups, groupIndexToAddress(i12))) {
                return true;
            }
            i12 += groupSize(i12);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean containsAnyGroupMarks(int i11) {
        return i11 >= 0 && SlotTableKt.containsAnyMark(this.groups, groupIndexToAddress(i11));
    }

    private final boolean containsGroupMark(int i11) {
        return i11 >= 0 && SlotTableKt.containsMark(this.groups, groupIndexToAddress(i11));
    }

    private final int dataAnchorToDataIndex(int i11, int i12, int i13) {
        return i11 < 0 ? (i13 - i12) + i11 + 1 : i11;
    }

    /* access modifiers changed from: private */
    public final int dataIndex(int i11) {
        return dataIndex(this.groups, groupIndexToAddress(i11));
    }

    /* access modifiers changed from: private */
    public final int dataIndexToDataAddress(int i11) {
        return i11 < this.slotsGapStart ? i11 : i11 + this.slotsGapLen;
    }

    /* access modifiers changed from: private */
    public final int dataIndexToDataAnchor(int i11, int i12, int i13, int i14) {
        return i11 > i12 ? -(((i14 - i13) - i11) + 1) : i11;
    }

    private final List<Integer> dataIndexes(int[] iArr) {
        List a11 = SlotTableKt.a(this.groups, 0, 1, (Object) null);
        List plus = CollectionsKt___CollectionsKt.plus(CollectionsKt___CollectionsKt.slice(a11, RangesKt___RangesKt.until(0, this.groupGapStart)), CollectionsKt___CollectionsKt.slice(a11, RangesKt___RangesKt.until(this.groupGapStart + this.groupGapLen, iArr.length / 5)));
        ArrayList arrayList = new ArrayList(plus.size());
        int size = plus.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(Integer.valueOf(dataAnchorToDataIndex(((Number) plus.get(i11)).intValue(), this.slotsGapLen, this.slots.length)));
        }
        return arrayList;
    }

    private final void fixParentAnchorsFor(int i11, int i12, int i13) {
        int parentIndexToAnchor = parentIndexToAnchor(i11, this.groupGapStart);
        while (i13 < i12) {
            SlotTableKt.updateParentAnchor(this.groups, groupIndexToAddress(i13), parentIndexToAnchor);
            int access$groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress(i13)) + i13;
            fixParentAnchorsFor(i13, access$groupSize, i13 + 1);
            i13 = access$groupSize;
        }
    }

    private final int getCapacity() {
        return this.groups.length / 5;
    }

    private final void groupAsString(StringBuilder sb2, int i11) {
        int groupIndexToAddress = groupIndexToAddress(i11);
        sb2.append("Group(");
        if (i11 < 10) {
            sb2.append(' ');
        }
        if (i11 < 100) {
            sb2.append(' ');
        }
        if (i11 < 1000) {
            sb2.append(' ');
        }
        sb2.append(i11);
        if (groupIndexToAddress != i11) {
            sb2.append("(");
            sb2.append(groupIndexToAddress);
            sb2.append(")");
        }
        sb2.append('#');
        sb2.append(SlotTableKt.groupSize(this.groups, groupIndexToAddress));
        boolean groupAsString$isStarted = groupAsString$isStarted(this, i11);
        if (groupAsString$isStarted) {
            sb2.append('?');
        }
        sb2.append('^');
        sb2.append(parentAnchorToIndex(SlotTableKt.parentAnchor(this.groups, groupIndexToAddress)));
        sb2.append(": key=");
        sb2.append(SlotTableKt.key(this.groups, groupIndexToAddress));
        sb2.append(", nodes=");
        sb2.append(SlotTableKt.nodeCount(this.groups, groupIndexToAddress));
        if (groupAsString$isStarted) {
            sb2.append('?');
        }
        sb2.append(", dataAnchor=");
        sb2.append(SlotTableKt.dataAnchor(this.groups, groupIndexToAddress));
        sb2.append(", parentAnchor=");
        sb2.append(SlotTableKt.parentAnchor(this.groups, groupIndexToAddress));
        if (SlotTableKt.isNode(this.groups, groupIndexToAddress)) {
            sb2.append(", node=" + this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))]);
        }
        int slotIndex = slotIndex(this.groups, groupIndexToAddress);
        int dataIndex = dataIndex(this.groups, groupIndexToAddress + 1);
        if (dataIndex > slotIndex) {
            sb2.append(", [");
            for (int i12 = slotIndex; i12 < dataIndex; i12++) {
                if (i12 != slotIndex) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                sb2.append(String.valueOf(this.slots[dataIndexToDataAddress(i12)]));
            }
            sb2.append(AbstractJsonLexerKt.END_LIST);
        }
        sb2.append(")");
    }

    private static final boolean groupAsString$isStarted(SlotWriter slotWriter, int i11) {
        if (i11 >= slotWriter.currentGroup || (i11 != slotWriter.parent && slotWriter.startStack.indexOf(i11) < 0 && !groupAsString$isStarted(slotWriter, slotWriter.parent(i11)))) {
            return false;
        }
        return true;
    }

    private final int groupIndexToAddress(int i11) {
        return i11 < this.groupGapStart ? i11 : i11 + this.groupGapLen;
    }

    /* access modifiers changed from: private */
    public final void insertGroups(int i11) {
        int i12;
        if (i11 > 0) {
            int i13 = this.currentGroup;
            moveGroupGapTo(i13);
            int i14 = this.groupGapStart;
            int i15 = this.groupGapLen;
            int[] iArr = this.groups;
            int length = iArr.length / 5;
            int i16 = length - i15;
            int i17 = 0;
            if (i15 < i11) {
                int max = Math.max(Math.max(length * 2, i16 + i11), 32);
                int[] iArr2 = new int[(max * 5)];
                int i18 = max - i16;
                int[] unused = ArraysKt___ArraysJvmKt.copyInto(iArr, iArr2, 0, 0, i14 * 5);
                int[] unused2 = ArraysKt___ArraysJvmKt.copyInto(iArr, iArr2, (i14 + i18) * 5, (i15 + i14) * 5, length * 5);
                this.groups = iArr2;
                i15 = i18;
            }
            int i19 = this.currentGroupEnd;
            if (i19 >= i14) {
                this.currentGroupEnd = i19 + i11;
            }
            int i21 = i14 + i11;
            this.groupGapStart = i21;
            this.groupGapLen = i15 - i11;
            if (i16 > 0) {
                i12 = dataIndex(i13 + i11);
            } else {
                i12 = 0;
            }
            if (this.slotsGapOwner >= i14) {
                i17 = this.slotsGapStart;
            }
            int dataIndexToDataAnchor = dataIndexToDataAnchor(i12, i17, this.slotsGapLen, this.slots.length);
            for (int i22 = i14; i22 < i21; i22++) {
                SlotTableKt.updateDataAnchor(this.groups, i22, dataIndexToDataAnchor);
            }
            int i23 = this.slotsGapOwner;
            if (i23 >= i14) {
                this.slotsGapOwner = i23 + i11;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void insertSlots(int i11, int i12) {
        if (i11 > 0) {
            moveSlotGapTo(this.currentSlot, i12);
            int i13 = this.slotsGapStart;
            int i14 = this.slotsGapLen;
            if (i14 < i11) {
                Object[] objArr = this.slots;
                int length = objArr.length;
                int i15 = length - i14;
                int max = Math.max(Math.max(length * 2, i15 + i11), 32);
                Object[] objArr2 = new Object[max];
                for (int i16 = 0; i16 < max; i16++) {
                    objArr2[i16] = null;
                }
                int i17 = max - i15;
                Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr2, 0, 0, i13);
                Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr2, i13 + i17, i14 + i13, length);
                this.slots = objArr2;
                i14 = i17;
            }
            int i18 = this.currentSlotEnd;
            if (i18 >= i13) {
                this.currentSlotEnd = i18 + i11;
            }
            this.slotsGapStart = i13 + i11;
            this.slotsGapLen = i14 - i11;
        }
    }

    private final List<Integer> keys() {
        boolean z11;
        List b11 = SlotTableKt.b(this.groups, 0, 1, (Object) null);
        ArrayList arrayList = new ArrayList(b11.size());
        int size = b11.size();
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = b11.get(i11);
            ((Number) obj).intValue();
            int i12 = this.groupGapStart;
            if (i11 < i12 || i11 >= i12 + this.groupGapLen) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void markGroup$default(SlotWriter slotWriter, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = slotWriter.parent;
        }
        slotWriter.markGroup(i11);
    }

    private final void moveAnchors(int i11, int i12, int i13) {
        int i14 = i13 + i11;
        int size$runtime_release = getSize$runtime_release();
        int access$locationOf = SlotTableKt.locationOf(this.anchors, i11, size$runtime_release);
        ArrayList arrayList = new ArrayList();
        if (access$locationOf >= 0) {
            while (access$locationOf < this.anchors.size()) {
                Anchor anchor = this.anchors.get(access$locationOf);
                Intrinsics.checkNotNullExpressionValue(anchor, "anchors[index]");
                Anchor anchor2 = anchor;
                int anchorIndex = anchorIndex(anchor2);
                if (anchorIndex < i11 || anchorIndex >= i14) {
                    break;
                }
                arrayList.add(anchor2);
                this.anchors.remove(access$locationOf);
            }
        }
        int i15 = i12 - i11;
        int size = arrayList.size();
        for (int i16 = 0; i16 < size; i16++) {
            Anchor anchor3 = (Anchor) arrayList.get(i16);
            int anchorIndex2 = anchorIndex(anchor3) + i15;
            if (anchorIndex2 >= this.groupGapStart) {
                anchor3.setLocation$runtime_release(-(size$runtime_release - anchorIndex2));
            } else {
                anchor3.setLocation$runtime_release(anchorIndex2);
            }
            this.anchors.add(SlotTableKt.locationOf(this.anchors, anchorIndex2, size$runtime_release), anchor3);
        }
    }

    /* access modifiers changed from: private */
    public final void moveGroupGapTo(int i11) {
        int i12;
        int i13 = this.groupGapLen;
        int i14 = this.groupGapStart;
        if (i14 != i11) {
            boolean z11 = true;
            if (!this.anchors.isEmpty()) {
                updateAnchors(i14, i11);
            }
            if (i13 > 0) {
                int[] iArr = this.groups;
                int i15 = i11 * 5;
                int i16 = i13 * 5;
                int i17 = i14 * 5;
                if (i11 < i14) {
                    int[] unused = ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, i16 + i15, i15, i17);
                } else {
                    int[] unused2 = ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, i17, i17 + i16, i15 + i16);
                }
            }
            if (i11 < i14) {
                i14 = i11 + i13;
            }
            int capacity = getCapacity();
            if (i12 >= capacity) {
                z11 = false;
            }
            ComposerKt.runtimeCheck(z11);
            while (i12 < capacity) {
                int access$parentAnchor = SlotTableKt.parentAnchor(this.groups, i12);
                int parentIndexToAnchor = parentIndexToAnchor(parentAnchorToIndex(access$parentAnchor), i11);
                if (parentIndexToAnchor != access$parentAnchor) {
                    SlotTableKt.updateParentAnchor(this.groups, i12, parentIndexToAnchor);
                }
                i12++;
                if (i12 == i11) {
                    i12 += i13;
                }
            }
        }
        this.groupGapStart = i11;
    }

    /* access modifiers changed from: private */
    public final void moveSlotGapTo(int i11, int i12) {
        boolean z11;
        boolean z12;
        int i13 = this.slotsGapLen;
        int i14 = this.slotsGapStart;
        int i15 = this.slotsGapOwner;
        if (i14 != i11) {
            Object[] objArr = this.slots;
            if (i11 < i14) {
                Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr, i11 + i13, i11, i14);
            } else {
                Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr, i14, i14 + i13, i11 + i13);
            }
            ArraysKt___ArraysJvmKt.fill((T[]) objArr, null, i11, i11 + i13);
        }
        int min = Math.min(i12 + 1, getSize$runtime_release());
        if (i15 != min) {
            int length = this.slots.length - i13;
            if (min < i15) {
                int groupIndexToAddress = groupIndexToAddress(min);
                int groupIndexToAddress2 = groupIndexToAddress(i15);
                int i16 = this.groupGapStart;
                while (groupIndexToAddress < groupIndexToAddress2) {
                    int access$dataAnchor = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress);
                    if (access$dataAnchor >= 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        SlotTableKt.updateDataAnchor(this.groups, groupIndexToAddress, -((length - access$dataAnchor) + 1));
                        groupIndexToAddress++;
                        if (groupIndexToAddress == i16) {
                            groupIndexToAddress += this.groupGapLen;
                        }
                    } else {
                        ComposerKt.composeRuntimeError("Unexpected anchor value, expected a positive anchor".toString());
                        throw new KotlinNothingValueException();
                    }
                }
            } else {
                int groupIndexToAddress3 = groupIndexToAddress(i15);
                int groupIndexToAddress4 = groupIndexToAddress(min);
                while (groupIndexToAddress3 < groupIndexToAddress4) {
                    int access$dataAnchor2 = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress3);
                    if (access$dataAnchor2 < 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        SlotTableKt.updateDataAnchor(this.groups, groupIndexToAddress3, access$dataAnchor2 + length + 1);
                        groupIndexToAddress3++;
                        if (groupIndexToAddress3 == this.groupGapStart) {
                            groupIndexToAddress3 += this.groupGapLen;
                        }
                    } else {
                        ComposerKt.composeRuntimeError("Unexpected anchor value, expected a negative anchor".toString());
                        throw new KotlinNothingValueException();
                    }
                }
            }
            this.slotsGapOwner = min;
        }
        this.slotsGapStart = i11;
    }

    private final int nodeIndex(int[] iArr, int i11) {
        return dataIndex(iArr, i11);
    }

    private final int parentAnchorToIndex(int i11) {
        return i11 > -2 ? i11 : getSize$runtime_release() + i11 + 2;
    }

    private final int parentIndexToAnchor(int i11, int i12) {
        return i11 < i12 ? i11 : -((getSize$runtime_release() - i11) + 2);
    }

    private final void recalculateMarks() {
        PrioritySet prioritySet = this.pendingRecalculateMarks;
        if (prioritySet != null) {
            while (prioritySet.isNotEmpty()) {
                updateContainsMarkNow(prioritySet.takeMax(), prioritySet);
            }
        }
    }

    private final boolean removeAnchors(int i11, int i12) {
        int i13 = i12 + i11;
        int access$locationOf = SlotTableKt.locationOf(this.anchors, i13, getCapacity() - this.groupGapLen);
        if (access$locationOf >= this.anchors.size()) {
            access$locationOf--;
        }
        int i14 = access$locationOf + 1;
        boolean z11 = false;
        int i15 = 0;
        while (access$locationOf >= 0) {
            Anchor anchor = this.anchors.get(access$locationOf);
            Intrinsics.checkNotNullExpressionValue(anchor, "anchors[index]");
            Anchor anchor2 = anchor;
            int anchorIndex = anchorIndex(anchor2);
            if (anchorIndex < i11) {
                break;
            }
            if (anchorIndex < i13) {
                anchor2.setLocation$runtime_release(Integer.MIN_VALUE);
                if (i15 == 0) {
                    i15 = access$locationOf + 1;
                }
                i14 = access$locationOf;
            }
            access$locationOf--;
        }
        if (i14 < i15) {
            z11 = true;
        }
        if (z11) {
            this.anchors.subList(i14, i15).clear();
        }
        return z11;
    }

    /* access modifiers changed from: private */
    public final boolean removeGroups(int i11, int i12) {
        boolean z11 = false;
        if (i12 > 0) {
            ArrayList<Anchor> arrayList = this.anchors;
            moveGroupGapTo(i11);
            if (!arrayList.isEmpty()) {
                z11 = removeAnchors(i11, i12);
            }
            this.groupGapStart = i11;
            this.groupGapLen += i12;
            int i13 = this.slotsGapOwner;
            if (i13 > i11) {
                this.slotsGapOwner = Math.max(i11, i13 - i12);
            }
            int i14 = this.currentGroupEnd;
            if (i14 >= this.groupGapStart) {
                this.currentGroupEnd = i14 - i12;
            }
            if (containsGroupMark(this.parent)) {
                updateContainsMark(this.parent);
            }
        }
        return z11;
    }

    /* access modifiers changed from: private */
    public final void removeSlots(int i11, int i12, int i13) {
        if (i12 > 0) {
            int i14 = this.slotsGapLen;
            int i15 = i11 + i12;
            moveSlotGapTo(i15, i13);
            this.slotsGapStart = i11;
            this.slotsGapLen = i14 + i12;
            ArraysKt___ArraysJvmKt.fill((T[]) this.slots, null, i11, i15);
            int i16 = this.currentSlotEnd;
            if (i16 >= i11) {
                this.currentSlotEnd = i16 - i12;
            }
        }
    }

    private final int restoreCurrentGroupEnd() {
        int capacity = (getCapacity() - this.groupGapLen) - this.endStack.pop();
        this.currentGroupEnd = capacity;
        return capacity;
    }

    private final void saveCurrentGroupEnd() {
        this.endStack.push((getCapacity() - this.groupGapLen) - this.currentGroupEnd);
    }

    private final int slotIndex(int[] iArr, int i11) {
        if (i11 >= getCapacity()) {
            return this.slots.length - this.slotsGapLen;
        }
        return dataAnchorToDataIndex(SlotTableKt.slotAnchor(iArr, i11), this.slotsGapLen, this.slots.length);
    }

    private final void updateAnchors(int i11, int i12) {
        int i13;
        int capacity = getCapacity() - this.groupGapLen;
        if (i11 < i12) {
            int access$locationOf = SlotTableKt.locationOf(this.anchors, i11, capacity);
            while (access$locationOf < this.anchors.size()) {
                Anchor anchor = this.anchors.get(access$locationOf);
                Intrinsics.checkNotNullExpressionValue(anchor, "anchors[index]");
                Anchor anchor2 = anchor;
                int location$runtime_release = anchor2.getLocation$runtime_release();
                if (location$runtime_release < 0 && (i13 = location$runtime_release + capacity) < i12) {
                    anchor2.setLocation$runtime_release(i13);
                    access$locationOf++;
                } else {
                    return;
                }
            }
            return;
        }
        int access$locationOf2 = SlotTableKt.locationOf(this.anchors, i12, capacity);
        while (access$locationOf2 < this.anchors.size()) {
            Anchor anchor3 = this.anchors.get(access$locationOf2);
            Intrinsics.checkNotNullExpressionValue(anchor3, "anchors[index]");
            Anchor anchor4 = anchor3;
            int location$runtime_release2 = anchor4.getLocation$runtime_release();
            if (location$runtime_release2 >= 0) {
                anchor4.setLocation$runtime_release(-(capacity - location$runtime_release2));
                access$locationOf2++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateContainsMark(int i11) {
        if (i11 >= 0) {
            PrioritySet prioritySet = this.pendingRecalculateMarks;
            if (prioritySet == null) {
                prioritySet = new PrioritySet((List) null, 1, (DefaultConstructorMarker) null);
                this.pendingRecalculateMarks = prioritySet;
            }
            prioritySet.add(i11);
        }
    }

    private final void updateContainsMarkNow(int i11, PrioritySet prioritySet) {
        boolean z11;
        int groupIndexToAddress = groupIndexToAddress(i11);
        boolean childContainsAnyMarks = childContainsAnyMarks(i11);
        if (SlotTableKt.containsMark(this.groups, groupIndexToAddress) != childContainsAnyMarks) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            SlotTableKt.updateContainsMark(this.groups, groupIndexToAddress, childContainsAnyMarks);
            int parent2 = parent(i11);
            if (parent2 >= 0) {
                prioritySet.add(parent2);
            }
        }
    }

    private final void updateDataIndex(int[] iArr, int i11, int i12) {
        SlotTableKt.updateDataAnchor(iArr, i11, dataIndexToDataAnchor(i12, this.slotsGapStart, this.slotsGapLen, this.slots.length));
    }

    private final void updateNodeOfGroup(int i11, Object obj) {
        boolean z11;
        int groupIndexToAddress = groupIndexToAddress(i11);
        int[] iArr = this.groups;
        if (groupIndexToAddress >= iArr.length || !SlotTableKt.isNode(iArr, groupIndexToAddress)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))] = obj;
            return;
        }
        ComposerKt.composeRuntimeError(("Updating the node of a group at " + i11 + " that was not created with as a node group").toString());
        throw new KotlinNothingValueException();
    }

    public final void addToGroupSizeAlongSpine(int i11, int i12) {
        while (i11 > 0) {
            int[] iArr = this.groups;
            SlotTableKt.updateGroupSize(iArr, i11, SlotTableKt.groupSize(iArr, i11) + i12);
            i11 = groupIndexToAddress(parentAnchorToIndex(SlotTableKt.parentAnchor(this.groups, i11)));
        }
    }

    public final void advanceBy(int i11) {
        boolean z11;
        boolean z12;
        boolean z13 = true;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (this.insertCount <= 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                throw new IllegalStateException("Cannot call seek() while inserting".toString());
            } else if (i11 != 0) {
                int i12 = this.currentGroup + i11;
                if (i12 < this.parent || i12 > this.currentGroupEnd) {
                    z13 = false;
                }
                if (z13) {
                    this.currentGroup = i12;
                    int dataIndex = dataIndex(this.groups, groupIndexToAddress(i12));
                    this.currentSlot = dataIndex;
                    this.currentSlotEnd = dataIndex;
                    return;
                }
                ComposerKt.composeRuntimeError(("Cannot seek outside the current group (" + this.parent + SignatureVisitor.SUPER + this.currentGroupEnd + ')').toString());
                throw new KotlinNothingValueException();
            }
        } else {
            ComposerKt.composeRuntimeError("Cannot seek backwards".toString());
            throw new KotlinNothingValueException();
        }
    }

    @NotNull
    public final Anchor anchor(int i11) {
        ArrayList<Anchor> arrayList = this.anchors;
        int access$search = SlotTableKt.search(arrayList, i11, getSize$runtime_release());
        if (access$search < 0) {
            if (i11 > this.groupGapStart) {
                i11 = -(getSize$runtime_release() - i11);
            }
            Anchor anchor = new Anchor(i11);
            arrayList.add(-(access$search + 1), anchor);
            return anchor;
        }
        Anchor anchor2 = arrayList.get(access$search);
        Intrinsics.checkNotNullExpressionValue(anchor2, "get(location)");
        return anchor2;
    }

    public final int anchorIndex(@NotNull Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, Param.ANCHOR);
        int location$runtime_release = anchor.getLocation$runtime_release();
        if (location$runtime_release < 0) {
            return location$runtime_release + getSize$runtime_release();
        }
        return location$runtime_release;
    }

    public final void bashGroup$runtime_release() {
        startGroup();
        while (!isGroupEnd()) {
            insertParentGroup(-3);
            skipGroup();
        }
        endGroup();
    }

    public final void beginInsert() {
        int i11 = this.insertCount;
        this.insertCount = i11 + 1;
        if (i11 == 0) {
            saveCurrentGroupEnd();
        }
    }

    public final void close() {
        this.closed = true;
        if (this.startStack.isEmpty()) {
            moveGroupGapTo(getSize$runtime_release());
            moveSlotGapTo(this.slots.length - this.slotsGapLen, this.groupGapStart);
            recalculateMarks();
        }
        this.table.close$runtime_release(this, this.groups, this.groupGapStart, this.slots, this.slotsGapStart, this.anchors);
    }

    public final int endGroup() {
        boolean z11;
        int i11;
        int i12 = 1;
        int i13 = 0;
        if (this.insertCount > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        int i14 = this.currentGroup;
        int i15 = this.currentGroupEnd;
        int i16 = this.parent;
        int groupIndexToAddress = groupIndexToAddress(i16);
        int i17 = this.nodeCount;
        int i18 = i14 - i16;
        boolean access$isNode = SlotTableKt.isNode(this.groups, groupIndexToAddress);
        if (z11) {
            SlotTableKt.updateGroupSize(this.groups, groupIndexToAddress, i18);
            SlotTableKt.updateNodeCount(this.groups, groupIndexToAddress, i17);
            int pop = this.nodeCountStack.pop();
            if (!access$isNode) {
                i12 = i17;
            }
            this.nodeCount = pop + i12;
            this.parent = parent(this.groups, i16);
        } else {
            if (i14 != i15) {
                i12 = 0;
            }
            if (i12 != 0) {
                int access$groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress);
                int access$nodeCount = SlotTableKt.nodeCount(this.groups, groupIndexToAddress);
                SlotTableKt.updateGroupSize(this.groups, groupIndexToAddress, i18);
                SlotTableKt.updateNodeCount(this.groups, groupIndexToAddress, i17);
                int pop2 = this.startStack.pop();
                restoreCurrentGroupEnd();
                this.parent = pop2;
                int parent2 = parent(this.groups, i16);
                int pop3 = this.nodeCountStack.pop();
                this.nodeCount = pop3;
                if (parent2 == pop2) {
                    if (!access$isNode) {
                        i13 = i17 - access$nodeCount;
                    }
                    this.nodeCount = pop3 + i13;
                } else {
                    int i19 = i18 - access$groupSize;
                    if (access$isNode) {
                        i11 = 0;
                    } else {
                        i11 = i17 - access$nodeCount;
                    }
                    if (!(i19 == 0 && i11 == 0)) {
                        while (parent2 != 0 && parent2 != pop2 && (i11 != 0 || i19 != 0)) {
                            int groupIndexToAddress2 = groupIndexToAddress(parent2);
                            if (i19 != 0) {
                                SlotTableKt.updateGroupSize(this.groups, groupIndexToAddress2, SlotTableKt.groupSize(this.groups, groupIndexToAddress2) + i19);
                            }
                            if (i11 != 0) {
                                int[] iArr = this.groups;
                                SlotTableKt.updateNodeCount(iArr, groupIndexToAddress2, SlotTableKt.nodeCount(iArr, groupIndexToAddress2) + i11);
                            }
                            if (SlotTableKt.isNode(this.groups, groupIndexToAddress2)) {
                                i11 = 0;
                            }
                            parent2 = parent(this.groups, parent2);
                        }
                    }
                    this.nodeCount += i11;
                }
            } else {
                ComposerKt.composeRuntimeError("Expected to be at the end of a group".toString());
                throw new KotlinNothingValueException();
            }
        }
        return i17;
    }

    public final void endInsert() {
        boolean z11;
        int i11 = this.insertCount;
        boolean z12 = true;
        if (i11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            int i12 = i11 - 1;
            this.insertCount = i12;
            if (i12 == 0) {
                if (this.nodeCountStack.getSize() != this.startStack.getSize()) {
                    z12 = false;
                }
                if (z12) {
                    restoreCurrentGroupEnd();
                } else {
                    ComposerKt.composeRuntimeError("startGroup/endGroup mismatch while inserting".toString());
                    throw new KotlinNothingValueException();
                }
            }
        } else {
            throw new IllegalStateException("Unbalanced begin/end insert".toString());
        }
    }

    public final void ensureStarted(int i11) {
        boolean z11 = true;
        if (this.insertCount <= 0) {
            int i12 = this.parent;
            if (i12 != i11) {
                if (i11 < i12 || i11 >= this.currentGroupEnd) {
                    z11 = false;
                }
                if (z11) {
                    int i13 = this.currentGroup;
                    int i14 = this.currentSlot;
                    int i15 = this.currentSlotEnd;
                    this.currentGroup = i11;
                    startGroup();
                    this.currentGroup = i13;
                    this.currentSlot = i14;
                    this.currentSlotEnd = i15;
                    return;
                }
                ComposerKt.composeRuntimeError(("Started group at " + i11 + " must be a subgroup of the group at " + i12).toString());
                throw new KotlinNothingValueException();
            }
            return;
        }
        ComposerKt.composeRuntimeError("Cannot call ensureStarted() while inserting".toString());
        throw new KotlinNothingValueException();
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getSize$runtime_release() {
        return getCapacity() - this.groupGapLen;
    }

    @NotNull
    public final SlotTable getTable$runtime_release() {
        return this.table;
    }

    @Nullable
    public final Object groupAux(int i11) {
        int groupIndexToAddress = groupIndexToAddress(i11);
        if (SlotTableKt.hasAux(this.groups, groupIndexToAddress)) {
            return this.slots[auxIndex(this.groups, groupIndexToAddress)];
        }
        return Composer.Companion.getEmpty();
    }

    public final int groupKey(int i11) {
        return SlotTableKt.key(this.groups, groupIndexToAddress(i11));
    }

    @Nullable
    public final Object groupObjectKey(int i11) {
        int groupIndexToAddress = groupIndexToAddress(i11);
        if (SlotTableKt.hasObjectKey(this.groups, groupIndexToAddress)) {
            return this.slots[SlotTableKt.objectKeyIndex(this.groups, groupIndexToAddress)];
        }
        return null;
    }

    public final int groupSize(int i11) {
        return SlotTableKt.groupSize(this.groups, groupIndexToAddress(i11));
    }

    @NotNull
    public final Iterator<Object> groupSlots() {
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int[] iArr = this.groups;
        int i11 = this.currentGroup;
        return new SlotWriter$groupSlots$1(dataIndex, dataIndex(iArr, groupIndexToAddress(i11 + groupSize(i11))), this);
    }

    @NotNull
    public final String groupsAsString() {
        StringBuilder sb2 = new StringBuilder();
        int size$runtime_release = getSize$runtime_release();
        for (int i11 = 0; i11 < size$runtime_release; i11++) {
            groupAsString(sb2, i11);
            sb2.append(10);
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public final boolean indexInCurrentGroup(int i11) {
        return indexInGroup(i11, this.currentGroup);
    }

    public final boolean indexInGroup(int i11, int i12) {
        int i13;
        int groupSize;
        if (i12 == this.parent) {
            i13 = this.currentGroupEnd;
        } else {
            if (i12 > this.startStack.peekOr(0)) {
                groupSize = groupSize(i12);
            } else {
                int indexOf = this.startStack.indexOf(i12);
                if (indexOf < 0) {
                    groupSize = groupSize(i12);
                } else {
                    i13 = (getCapacity() - this.groupGapLen) - this.endStack.peek(indexOf);
                }
            }
            i13 = groupSize + i12;
        }
        if (i11 <= i12 || i11 >= i13) {
            return false;
        }
        return true;
    }

    public final boolean indexInParent(int i11) {
        int i12 = this.parent;
        return (i11 > i12 && i11 < this.currentGroupEnd) || (i12 == 0 && i11 == 0);
    }

    public final void insertAux(@Nullable Object obj) {
        boolean z11;
        boolean z12 = false;
        if (this.insertCount >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            int i11 = this.parent;
            int groupIndexToAddress = groupIndexToAddress(i11);
            if (!SlotTableKt.hasAux(this.groups, groupIndexToAddress)) {
                insertSlots(1, i11);
                int auxIndex = auxIndex(this.groups, groupIndexToAddress);
                int dataIndexToDataAddress = dataIndexToDataAddress(auxIndex);
                int i12 = this.currentSlot;
                if (i12 > auxIndex) {
                    int i13 = i12 - auxIndex;
                    if (i13 < 3) {
                        z12 = true;
                    }
                    if (z12) {
                        if (i13 > 1) {
                            Object[] objArr = this.slots;
                            objArr[dataIndexToDataAddress + 2] = objArr[dataIndexToDataAddress + 1];
                        }
                        Object[] objArr2 = this.slots;
                        objArr2[dataIndexToDataAddress + 1] = objArr2[dataIndexToDataAddress];
                    } else {
                        throw new IllegalStateException("Moving more than two slot not supported".toString());
                    }
                }
                SlotTableKt.addAux(this.groups, groupIndexToAddress);
                this.slots[dataIndexToDataAddress] = obj;
                this.currentSlot++;
                return;
            }
            ComposerKt.composeRuntimeError("Group already has auxiliary data".toString());
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("Cannot insert auxiliary data when not inserting".toString());
        throw new KotlinNothingValueException();
    }

    public final void insertParentGroup(int i11) {
        boolean z11;
        int i12 = 0;
        if (this.insertCount == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            ComposerKt.composeRuntimeError("Writer cannot be inserting".toString());
            throw new KotlinNothingValueException();
        } else if (isGroupEnd()) {
            beginInsert();
            startGroup(i11);
            endGroup();
            endInsert();
        } else {
            int i13 = this.currentGroup;
            int parent2 = parent(this.groups, i13);
            int groupSize = parent2 + groupSize(parent2);
            int i14 = groupSize - i13;
            int i15 = i13;
            while (i15 < groupSize) {
                int groupIndexToAddress = groupIndexToAddress(i15);
                i12 += SlotTableKt.nodeCount(this.groups, groupIndexToAddress);
                i15 += SlotTableKt.groupSize(this.groups, groupIndexToAddress);
            }
            int access$dataAnchor = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress(i13));
            beginInsert();
            insertGroups(1);
            endInsert();
            int groupIndexToAddress2 = groupIndexToAddress(i13);
            SlotTableKt.initGroup(this.groups, groupIndexToAddress2, i11, false, false, false, parent2, access$dataAnchor);
            SlotTableKt.updateGroupSize(this.groups, groupIndexToAddress2, i14 + 1);
            SlotTableKt.updateNodeCount(this.groups, groupIndexToAddress2, i12);
            addToGroupSizeAlongSpine(groupIndexToAddress(parent2), 1);
            fixParentAnchorsFor(parent2, groupSize, i13);
            this.currentGroup = groupSize;
        }
    }

    public final boolean isGroupEnd() {
        return this.currentGroup == this.currentGroupEnd;
    }

    public final boolean isNode() {
        int i11 = this.currentGroup;
        return i11 < this.currentGroupEnd && SlotTableKt.isNode(this.groups, groupIndexToAddress(i11));
    }

    public final void markGroup(int i11) {
        int groupIndexToAddress = groupIndexToAddress(i11);
        if (!SlotTableKt.hasMark(this.groups, groupIndexToAddress)) {
            SlotTableKt.updateMark(this.groups, groupIndexToAddress, true);
            if (!SlotTableKt.containsMark(this.groups, groupIndexToAddress)) {
                updateContainsMark(parent(i11));
            }
        }
    }

    @NotNull
    public final List<Anchor> moveFrom(@NotNull SlotTable slotTable, int i11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(slotTable, "table");
        if (this.insertCount > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        ComposerKt.runtimeCheck(z11);
        if (i11 == 0 && this.currentGroup == 0 && this.table.getGroupsSize() == 0) {
            int[] iArr = this.groups;
            Object[] objArr = this.slots;
            ArrayList<Anchor> arrayList = this.anchors;
            int[] groups2 = slotTable.getGroups();
            int groupsSize = slotTable.getGroupsSize();
            Object[] slots2 = slotTable.getSlots();
            int slotsSize = slotTable.getSlotsSize();
            this.groups = groups2;
            this.slots = slots2;
            this.anchors = slotTable.getAnchors$runtime_release();
            this.groupGapStart = groupsSize;
            this.groupGapLen = (groups2.length / 5) - groupsSize;
            this.slotsGapStart = slotsSize;
            this.slotsGapLen = slots2.length - slotsSize;
            this.slotsGapOwner = groupsSize;
            slotTable.setTo$runtime_release(iArr, 0, objArr, 0, arrayList);
            return this.anchors;
        }
        SlotWriter openWriter = slotTable.openWriter();
        try {
            return Companion.moveGroup(openWriter, i11, this, true, true);
        } finally {
            openWriter.close();
        }
    }

    public final void moveGroup(int i11) {
        boolean z11;
        boolean z12;
        int i12;
        boolean z13;
        if (this.insertCount == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (i11 >= 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                ComposerKt.composeRuntimeError("Parameter offset is out of bounds".toString());
                throw new KotlinNothingValueException();
            } else if (i11 != 0) {
                int i13 = this.currentGroup;
                int i14 = this.parent;
                int i15 = this.currentGroupEnd;
                int i16 = i11;
                int i17 = i13;
                while (i16 > 0) {
                    i17 += SlotTableKt.groupSize(this.groups, groupIndexToAddress(i17));
                    if (i17 <= i15) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (z13) {
                        i16--;
                    } else {
                        ComposerKt.composeRuntimeError("Parameter offset is out of bounds".toString());
                        throw new KotlinNothingValueException();
                    }
                }
                int access$groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress(i17));
                int i18 = this.currentSlot;
                int dataIndex = dataIndex(this.groups, groupIndexToAddress(i17));
                int i19 = i17 + access$groupSize;
                int dataIndex2 = dataIndex(this.groups, groupIndexToAddress(i19));
                int i21 = dataIndex2 - dataIndex;
                insertSlots(i21, Math.max(this.currentGroup - 1, 0));
                insertGroups(access$groupSize);
                int[] iArr = this.groups;
                int groupIndexToAddress = groupIndexToAddress(i19) * 5;
                int[] unused = ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, groupIndexToAddress(i13) * 5, groupIndexToAddress, (access$groupSize * 5) + groupIndexToAddress);
                if (i21 > 0) {
                    Object[] objArr = this.slots;
                    Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr, i18, dataIndexToDataAddress(dataIndex + i21), dataIndexToDataAddress(dataIndex2 + i21));
                }
                int i22 = dataIndex + i21;
                int i23 = i22 - i18;
                int i24 = this.slotsGapStart;
                int i25 = this.slotsGapLen;
                int length = this.slots.length;
                int i26 = this.slotsGapOwner;
                int i27 = i13 + access$groupSize;
                int i28 = i13;
                while (i28 < i27) {
                    int groupIndexToAddress2 = groupIndexToAddress(i28);
                    int i29 = i24;
                    int dataIndex3 = dataIndex(iArr, groupIndexToAddress2) - i23;
                    int i31 = i23;
                    if (i26 < groupIndexToAddress2) {
                        i12 = 0;
                    } else {
                        i12 = i29;
                    }
                    updateDataIndex(iArr, groupIndexToAddress2, dataIndexToDataAnchor(dataIndex3, i12, i25, length));
                    i28++;
                    i24 = i29;
                    i23 = i31;
                }
                moveAnchors(i19, i13, access$groupSize);
                if (!removeGroups(i19, access$groupSize)) {
                    fixParentAnchorsFor(i14, this.currentGroupEnd, i13);
                    if (i21 > 0) {
                        removeSlots(i22, i21, i19 - 1);
                        return;
                    }
                    return;
                }
                ComposerKt.composeRuntimeError("Unexpectedly removed anchors".toString());
                throw new KotlinNothingValueException();
            }
        } else {
            ComposerKt.composeRuntimeError("Cannot move a group while inserting".toString());
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0011, code lost:
        if (groupSize(r9.currentGroup + r10) == 1) goto L_0x0015;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<androidx.compose.runtime.Anchor> moveIntoGroupFrom(int r10, @org.jetbrains.annotations.NotNull androidx.compose.runtime.SlotTable r11, int r12) {
        /*
            r9 = this;
            java.lang.String r0 = "table"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            int r0 = r9.insertCount
            if (r0 > 0) goto L_0x0014
            int r0 = r9.currentGroup
            int r0 = r0 + r10
            int r0 = r9.groupSize(r0)
            r1 = 1
            if (r0 != r1) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            androidx.compose.runtime.ComposerKt.runtimeCheck(r1)
            int r0 = r9.currentGroup
            int r1 = r9.currentSlot
            int r2 = r9.currentSlotEnd
            r9.advanceBy(r10)
            r9.startGroup()
            r9.beginInsert()
            androidx.compose.runtime.SlotWriter r10 = r11.openWriter()
            androidx.compose.runtime.SlotWriter$Companion r3 = Companion     // Catch:{ all -> 0x0046 }
            r7 = 0
            r8 = 1
            r4 = r10
            r5 = r12
            r6 = r9
            java.util.List r11 = r3.moveGroup(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0046 }
            r10.close()
            r9.endInsert()
            r9.endGroup()
            r9.currentGroup = r0
            r9.currentSlot = r1
            r9.currentSlotEnd = r2
            return r11
        L_0x0046:
            r11 = move-exception
            r10.close()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SlotWriter.moveIntoGroupFrom(int, androidx.compose.runtime.SlotTable, int):java.util.List");
    }

    @NotNull
    public final List<Anchor> moveTo(@NotNull Anchor anchor, int i11, @NotNull SlotWriter slotWriter) {
        boolean z11;
        boolean z12;
        boolean z13;
        int i12;
        boolean z14;
        Intrinsics.checkNotNullParameter(anchor, Param.ANCHOR);
        Intrinsics.checkNotNullParameter(slotWriter, "writer");
        boolean z15 = true;
        if (slotWriter.insertCount > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        ComposerKt.runtimeCheck(z11);
        if (this.insertCount == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        ComposerKt.runtimeCheck(z12);
        ComposerKt.runtimeCheck(anchor.getValid());
        int anchorIndex = anchorIndex(anchor) + i11;
        int i13 = this.currentGroup;
        if (i13 > anchorIndex || anchorIndex >= this.currentGroupEnd) {
            z13 = false;
        } else {
            z13 = true;
        }
        ComposerKt.runtimeCheck(z13);
        int parent2 = parent(anchorIndex);
        int groupSize = groupSize(anchorIndex);
        if (isNode(anchorIndex)) {
            i12 = 1;
        } else {
            i12 = nodeCount(anchorIndex);
        }
        List<Anchor> access$moveGroup = Companion.moveGroup(this, anchorIndex, slotWriter, false, false);
        updateContainsMark(parent2);
        if (i12 > 0) {
            z14 = true;
        } else {
            z14 = false;
        }
        while (parent2 >= i13) {
            int groupIndexToAddress = groupIndexToAddress(parent2);
            int[] iArr = this.groups;
            SlotTableKt.updateGroupSize(iArr, groupIndexToAddress, SlotTableKt.groupSize(iArr, groupIndexToAddress) - groupSize);
            if (z14) {
                if (SlotTableKt.isNode(this.groups, groupIndexToAddress)) {
                    z14 = false;
                } else {
                    int[] iArr2 = this.groups;
                    SlotTableKt.updateNodeCount(iArr2, groupIndexToAddress, SlotTableKt.nodeCount(iArr2, groupIndexToAddress) - i12);
                }
            }
            parent2 = parent(parent2);
        }
        if (z14) {
            if (this.nodeCount < i12) {
                z15 = false;
            }
            ComposerKt.runtimeCheck(z15);
            this.nodeCount -= i12;
        }
        return access$moveGroup;
    }

    @Nullable
    public final Object node(int i11) {
        int groupIndexToAddress = groupIndexToAddress(i11);
        if (SlotTableKt.isNode(this.groups, groupIndexToAddress)) {
            return this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))];
        }
        return null;
    }

    public final int nodeCount(int i11) {
        return SlotTableKt.nodeCount(this.groups, groupIndexToAddress(i11));
    }

    public final int parent(int i11) {
        return parent(this.groups, i11);
    }

    public final boolean removeGroup() {
        boolean z11;
        if (this.insertCount == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            int i11 = this.currentGroup;
            int i12 = this.currentSlot;
            int skipGroup = skipGroup();
            PrioritySet prioritySet = this.pendingRecalculateMarks;
            if (prioritySet != null) {
                while (prioritySet.isNotEmpty() && prioritySet.peek() >= i11) {
                    prioritySet.takeMax();
                }
            }
            boolean removeGroups = removeGroups(i11, this.currentGroup - i11);
            removeSlots(i12, this.currentSlot - i12, i11 - 1);
            this.currentGroup = i11;
            this.currentSlot = i12;
            this.nodeCount -= skipGroup;
            return removeGroups;
        }
        ComposerKt.composeRuntimeError("Cannot remove group while inserting".toString());
        throw new KotlinNothingValueException();
    }

    public final void reset() {
        boolean z11;
        if (this.insertCount == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            recalculateMarks();
            this.currentGroup = 0;
            this.currentGroupEnd = getCapacity() - this.groupGapLen;
            this.currentSlot = 0;
            this.currentSlotEnd = 0;
            this.nodeCount = 0;
            return;
        }
        ComposerKt.composeRuntimeError("Cannot reset when inserting".toString());
        throw new KotlinNothingValueException();
    }

    public final void seek(@NotNull Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, Param.ANCHOR);
        advanceBy(anchor.toIndexFor(this) - this.currentGroup);
    }

    public final void set(@Nullable Object obj) {
        int i11 = this.currentSlot;
        if (i11 <= this.currentSlotEnd) {
            this.slots[dataIndexToDataAddress(i11 - 1)] = obj;
        } else {
            ComposerKt.composeRuntimeError("Writing to an invalid slot".toString());
            throw new KotlinNothingValueException();
        }
    }

    @Nullable
    public final Object skip() {
        if (this.insertCount > 0) {
            insertSlots(1, this.parent);
        }
        Object[] objArr = this.slots;
        int i11 = this.currentSlot;
        this.currentSlot = i11 + 1;
        return objArr[dataIndexToDataAddress(i11)];
    }

    public final int skipGroup() {
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        int access$groupSize = this.currentGroup + SlotTableKt.groupSize(this.groups, groupIndexToAddress);
        this.currentGroup = access$groupSize;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(access$groupSize));
        if (SlotTableKt.isNode(this.groups, groupIndexToAddress)) {
            return 1;
        }
        return SlotTableKt.nodeCount(this.groups, groupIndexToAddress);
    }

    public final void skipToGroupEnd() {
        int i11 = this.currentGroupEnd;
        this.currentGroup = i11;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(i11));
    }

    @Nullable
    public final Object slot(@NotNull Anchor anchor, int i11) {
        Intrinsics.checkNotNullParameter(anchor, Param.ANCHOR);
        return slot(anchorIndex(anchor), i11);
    }

    public final void startData(int i11, @Nullable Object obj, @Nullable Object obj2) {
        startGroup(i11, obj, false, obj2);
    }

    public final void startGroup() {
        if (this.insertCount == 0) {
            Composer.Companion companion = Composer.Companion;
            startGroup(0, companion.getEmpty(), false, companion.getEmpty());
            return;
        }
        ComposerKt.composeRuntimeError("Key must be supplied when inserting".toString());
        throw new KotlinNothingValueException();
    }

    public final void startNode(@Nullable Object obj) {
        startGroup(125, obj, true, Composer.Companion.getEmpty());
    }

    @NotNull
    public String toString() {
        return "SlotWriter(current = " + this.currentGroup + " end=" + this.currentGroupEnd + " size = " + getSize$runtime_release() + " gap=" + this.groupGapStart + SignatureVisitor.SUPER + (this.groupGapStart + this.groupGapLen) + ')';
    }

    @Nullable
    public final Object update(@Nullable Object obj) {
        Object skip = skip();
        set(obj);
        return skip;
    }

    public final void updateAux(@Nullable Object obj) {
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        if (SlotTableKt.hasAux(this.groups, groupIndexToAddress)) {
            this.slots[dataIndexToDataAddress(auxIndex(this.groups, groupIndexToAddress))] = obj;
        } else {
            ComposerKt.composeRuntimeError("Updating the data of a group that was not created with a data slot".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void updateNode(@Nullable Object obj) {
        updateNodeOfGroup(this.currentGroup, obj);
    }

    public final void updateParentNode(@Nullable Object obj) {
        updateNodeOfGroup(this.parent, obj);
    }

    public final void verifyDataAnchors$runtime_release() {
        boolean z11;
        boolean z12;
        boolean z13;
        int i11 = this.slotsGapOwner;
        int length = this.slots.length - this.slotsGapLen;
        int size$runtime_release = getSize$runtime_release();
        int i12 = 0;
        int i13 = 0;
        boolean z14 = false;
        while (i12 < size$runtime_release) {
            int groupIndexToAddress = groupIndexToAddress(i12);
            int access$dataAnchor = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress);
            int dataIndex = dataIndex(this.groups, groupIndexToAddress);
            if (dataIndex >= i13) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (dataIndex <= length) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    if (access$dataAnchor < 0 && !z14) {
                        if (i11 == i12) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        if (z13) {
                            z14 = true;
                        } else {
                            throw new IllegalStateException(("Expected the slot gap owner to be " + i11 + " found gap at " + i12).toString());
                        }
                    }
                    i12++;
                    i13 = dataIndex;
                } else {
                    throw new IllegalStateException(("Data index, " + dataIndex + ", out of bound at " + i12).toString());
                }
            } else {
                throw new IllegalStateException(("Data index out of order at " + i12 + ", previous = " + i13 + ", current = " + dataIndex).toString());
            }
        }
    }

    public final void verifyParentAnchors$runtime_release() {
        boolean z11;
        boolean z12;
        int i11 = this.groupGapStart;
        int i12 = this.groupGapLen;
        int capacity = getCapacity();
        int i13 = 0;
        while (true) {
            boolean z13 = true;
            if (i13 < i11) {
                if (SlotTableKt.parentAnchor(this.groups, i13) <= -2) {
                    z13 = false;
                }
                if (z13) {
                    i13++;
                } else {
                    throw new IllegalStateException(("Expected a start relative anchor at " + i13).toString());
                }
            } else {
                for (int i14 = i12 + i11; i14 < capacity; i14++) {
                    int access$parentAnchor = SlotTableKt.parentAnchor(this.groups, i14);
                    if (parentAnchorToIndex(access$parentAnchor) < i11) {
                        if (access$parentAnchor > -2) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (!z12) {
                            throw new IllegalStateException(("Expected a start relative anchor at " + i14).toString());
                        }
                    } else {
                        if (access$parentAnchor <= -2) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (!z11) {
                            throw new IllegalStateException(("Expected an end relative anchor at " + i14).toString());
                        }
                    }
                }
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final int dataIndex(int[] iArr, int i11) {
        if (i11 >= getCapacity()) {
            return this.slots.length - this.slotsGapLen;
        }
        return dataAnchorToDataIndex(SlotTableKt.dataAnchor(iArr, i11), this.slotsGapLen, this.slots.length);
    }

    public final boolean isNode(int i11) {
        return SlotTableKt.isNode(this.groups, groupIndexToAddress(i11));
    }

    public final int parent(@NotNull Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, Param.ANCHOR);
        if (anchor.getValid()) {
            return parent(this.groups, anchorIndex(anchor));
        }
        return -1;
    }

    @Nullable
    public final Object slot(int i11, int i12) {
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(i11));
        boolean z11 = true;
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i11 + 1));
        int i13 = i12 + slotIndex;
        if (slotIndex > i13 || i13 >= dataIndex) {
            z11 = false;
        }
        if (!z11) {
            return Composer.Companion.getEmpty();
        }
        return this.slots[dataIndexToDataAddress(i13)];
    }

    public final void startData(int i11, @Nullable Object obj) {
        startGroup(i11, Composer.Companion.getEmpty(), false, obj);
    }

    public final void startNode(@Nullable Object obj, @Nullable Object obj2) {
        startGroup(125, obj, true, obj2);
    }

    public final void updateNode(@NotNull Anchor anchor, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(anchor, Param.ANCHOR);
        updateNodeOfGroup(anchor.toIndexFor(this), obj);
    }

    private final int parent(int[] iArr, int i11) {
        return parentAnchorToIndex(SlotTableKt.parentAnchor(iArr, groupIndexToAddress(i11)));
    }

    @Nullable
    public final Object node(@NotNull Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, Param.ANCHOR);
        return node(anchor.toIndexFor(this));
    }

    @Nullable
    public final Object set(int i11, @Nullable Object obj) {
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(this.currentGroup));
        boolean z11 = true;
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
        int i12 = slotIndex + i11;
        if (i12 < slotIndex || i12 >= dataIndex) {
            z11 = false;
        }
        if (z11) {
            int dataIndexToDataAddress = dataIndexToDataAddress(i12);
            Object[] objArr = this.slots;
            Object obj2 = objArr[dataIndexToDataAddress];
            objArr[dataIndexToDataAddress] = obj;
            return obj2;
        }
        ComposerKt.composeRuntimeError(("Write to an invalid slot index " + i11 + " for group " + this.currentGroup).toString());
        throw new KotlinNothingValueException();
    }

    public final void startGroup(int i11) {
        Composer.Companion companion = Composer.Companion;
        startGroup(i11, companion.getEmpty(), false, companion.getEmpty());
    }

    public final void startGroup(int i11, @Nullable Object obj) {
        startGroup(i11, obj, false, Composer.Companion.getEmpty());
    }

    private final void startGroup(int i11, Object obj, boolean z11, Object obj2) {
        int i12;
        Object obj3 = obj;
        Object obj4 = obj2;
        boolean z12 = this.insertCount > 0;
        this.nodeCountStack.push(this.nodeCount);
        if (z12) {
            insertGroups(1);
            int i13 = this.currentGroup;
            int groupIndexToAddress = groupIndexToAddress(i13);
            Composer.Companion companion = Composer.Companion;
            boolean z13 = obj3 != companion.getEmpty();
            boolean z14 = !z11 && obj4 != companion.getEmpty();
            SlotTableKt.initGroup(this.groups, groupIndexToAddress, i11, z11, z13, z14, this.parent, this.currentSlot);
            this.currentSlotEnd = this.currentSlot;
            int i14 = (z11 ? 1 : 0) + (z13 ? 1 : 0) + (z14 ? 1 : 0);
            if (i14 > 0) {
                insertSlots(i14, i13);
                Object[] objArr = this.slots;
                int i15 = this.currentSlot;
                if (z11) {
                    objArr[i15] = obj4;
                    i15++;
                }
                if (z13) {
                    objArr[i15] = obj3;
                    i15++;
                }
                if (z14) {
                    objArr[i15] = obj4;
                    i15++;
                }
                this.currentSlot = i15;
            }
            this.nodeCount = 0;
            i12 = i13 + 1;
            this.parent = i13;
            this.currentGroup = i12;
        } else {
            this.startStack.push(this.parent);
            saveCurrentGroupEnd();
            int i16 = this.currentGroup;
            int groupIndexToAddress2 = groupIndexToAddress(i16);
            if (!Intrinsics.areEqual(obj4, Composer.Companion.getEmpty())) {
                if (z11) {
                    updateNode(obj4);
                } else {
                    updateAux(obj4);
                }
            }
            this.currentSlot = slotIndex(this.groups, groupIndexToAddress2);
            this.currentSlotEnd = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
            this.nodeCount = SlotTableKt.nodeCount(this.groups, groupIndexToAddress2);
            this.parent = i16;
            this.currentGroup = i16 + 1;
            i12 = i16 + SlotTableKt.groupSize(this.groups, groupIndexToAddress2);
        }
        this.currentGroupEnd = i12;
    }

    public final void ensureStarted(@NotNull Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, Param.ANCHOR);
        ensureStarted(anchor.toIndexFor(this));
    }
}
