package androidx.compose.ui.node;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b=\u0010>J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\n\u001a\u00020\bJ\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000bJ\u0014\u0010\r\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H$J\u0006\u0010\u000e\u001a\u00020\bJ\u000f\u0010\u0011\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0012\u001a\u00020\bJ!\u0010\u0015\u001a\u00020\u0013*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H$ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u001c8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\"\u0010&\u001a\u00020\u001c8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001e\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\"\u0010)\u001a\u00020\u001c8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001e\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\"\u0010,\u001a\u00020\u001c8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001e\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\"\u0010/\u001a\u00020\u001c8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b/\u0010\u001e\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"R\u0018\u00102\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010\u0019R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004038\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u00020\u001c8@X\u0004¢\u0006\u0006\u001a\u0004\b6\u0010 R\u0014\u00109\u001a\u00020\u001c8@X\u0004¢\u0006\u0006\u001a\u0004\b8\u0010 R$\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b*\u00020\u00068$X¤\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;\u0001\u0002?@\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006A"}, d2 = {"Landroidx/compose/ui/node/AlignmentLines;", "", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", "", "initialPosition", "Landroidx/compose/ui/node/NodeCoordinator;", "initialCoordinator", "", "addAlignmentLine", "recalculateQueryOwner", "", "getLastCalculation", "c", "recalculate", "reset$ui_release", "()V", "reset", "onAlignmentsChanged", "Landroidx/compose/ui/geometry/Offset;", "position", "a", "(Landroidx/compose/ui/node/NodeCoordinator;J)J", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "", "dirty", "Z", "getDirty$ui_release", "()Z", "setDirty$ui_release", "(Z)V", "usedDuringParentMeasurement", "getUsedDuringParentMeasurement$ui_release", "setUsedDuringParentMeasurement$ui_release", "usedDuringParentLayout", "getUsedDuringParentLayout$ui_release", "setUsedDuringParentLayout$ui_release", "previousUsedDuringParentLayout", "getPreviousUsedDuringParentLayout$ui_release", "setPreviousUsedDuringParentLayout$ui_release", "usedByModifierMeasurement", "getUsedByModifierMeasurement$ui_release", "setUsedByModifierMeasurement$ui_release", "usedByModifierLayout", "getUsedByModifierLayout$ui_release", "setUsedByModifierLayout$ui_release", "queryOwner", "", "alignmentLineMap", "Ljava/util/Map;", "getQueried$ui_release", "queried", "getRequired$ui_release", "required", "b", "(Landroidx/compose/ui/node/NodeCoordinator;)Ljava/util/Map;", "alignmentLinesMap", "<init>", "(Landroidx/compose/ui/node/AlignmentLinesOwner;)V", "Landroidx/compose/ui/node/LayoutNodeAlignmentLines;", "Landroidx/compose/ui/node/LookaheadAlignmentLines;", "ui_release"}, k = 1, mv = {1, 7, 1})
public abstract class AlignmentLines {
    /* access modifiers changed from: private */
    @NotNull
    public final Map<AlignmentLine, Integer> alignmentLineMap;
    @NotNull
    private final AlignmentLinesOwner alignmentLinesOwner;
    private boolean dirty;
    private boolean previousUsedDuringParentLayout;
    @Nullable
    private AlignmentLinesOwner queryOwner;
    private boolean usedByModifierLayout;
    private boolean usedByModifierMeasurement;
    private boolean usedDuringParentLayout;
    private boolean usedDuringParentMeasurement;

    private AlignmentLines(AlignmentLinesOwner alignmentLinesOwner2) {
        this.alignmentLinesOwner = alignmentLinesOwner2;
        this.dirty = true;
        this.alignmentLineMap = new HashMap();
    }

    public /* synthetic */ AlignmentLines(AlignmentLinesOwner alignmentLinesOwner2, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignmentLinesOwner2);
    }

    /* access modifiers changed from: private */
    public final void addAlignmentLine(AlignmentLine alignmentLine, int i11, NodeCoordinator nodeCoordinator) {
        int i12;
        float f11 = (float) i11;
        long Offset = OffsetKt.Offset(f11, f11);
        while (true) {
            Offset = a(nodeCoordinator, Offset);
            nodeCoordinator = nodeCoordinator.getWrappedBy$ui_release();
            Intrinsics.checkNotNull(nodeCoordinator);
            if (Intrinsics.areEqual((Object) nodeCoordinator, (Object) this.alignmentLinesOwner.getInnerCoordinator())) {
                break;
            } else if (b(nodeCoordinator).containsKey(alignmentLine)) {
                float c11 = (float) c(nodeCoordinator, alignmentLine);
                Offset = OffsetKt.Offset(c11, c11);
            }
        }
        if (alignmentLine instanceof HorizontalAlignmentLine) {
            i12 = MathKt__MathJVMKt.roundToInt(Offset.m2677getYimpl(Offset));
        } else {
            i12 = MathKt__MathJVMKt.roundToInt(Offset.m2676getXimpl(Offset));
        }
        Map<AlignmentLine, Integer> map = this.alignmentLineMap;
        if (map.containsKey(alignmentLine)) {
            i12 = AlignmentLineKt.merge(alignmentLine, ((Number) MapsKt__MapsKt.getValue(this.alignmentLineMap, alignmentLine)).intValue(), i12);
        }
        map.put(alignmentLine, Integer.valueOf(i12));
    }

    public abstract long a(@NotNull NodeCoordinator nodeCoordinator, long j11);

    @NotNull
    public abstract Map<AlignmentLine, Integer> b(@NotNull NodeCoordinator nodeCoordinator);

    public abstract int c(@NotNull NodeCoordinator nodeCoordinator, @NotNull AlignmentLine alignmentLine);

    @NotNull
    public final AlignmentLinesOwner getAlignmentLinesOwner() {
        return this.alignmentLinesOwner;
    }

    public final boolean getDirty$ui_release() {
        return this.dirty;
    }

    @NotNull
    public final Map<AlignmentLine, Integer> getLastCalculation() {
        return this.alignmentLineMap;
    }

    public final boolean getPreviousUsedDuringParentLayout$ui_release() {
        return this.previousUsedDuringParentLayout;
    }

    public final boolean getQueried$ui_release() {
        if (this.usedDuringParentMeasurement || this.previousUsedDuringParentLayout || this.usedByModifierMeasurement || this.usedByModifierLayout) {
            return true;
        }
        return false;
    }

    public final boolean getRequired$ui_release() {
        recalculateQueryOwner();
        if (this.queryOwner != null) {
            return true;
        }
        return false;
    }

    public final boolean getUsedByModifierLayout$ui_release() {
        return this.usedByModifierLayout;
    }

    public final boolean getUsedByModifierMeasurement$ui_release() {
        return this.usedByModifierMeasurement;
    }

    public final boolean getUsedDuringParentLayout$ui_release() {
        return this.usedDuringParentLayout;
    }

    public final boolean getUsedDuringParentMeasurement$ui_release() {
        return this.usedDuringParentMeasurement;
    }

    public final void onAlignmentsChanged() {
        this.dirty = true;
        AlignmentLinesOwner parentAlignmentLinesOwner = this.alignmentLinesOwner.getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner != null) {
            if (this.usedDuringParentMeasurement) {
                parentAlignmentLinesOwner.requestMeasure();
            } else if (this.previousUsedDuringParentLayout || this.usedDuringParentLayout) {
                parentAlignmentLinesOwner.requestLayout();
            }
            if (this.usedByModifierMeasurement) {
                this.alignmentLinesOwner.requestMeasure();
            }
            if (this.usedByModifierLayout) {
                parentAlignmentLinesOwner.requestLayout();
            }
            parentAlignmentLinesOwner.getAlignmentLines().onAlignmentsChanged();
        }
    }

    public final void recalculate() {
        this.alignmentLineMap.clear();
        this.alignmentLinesOwner.forEachChildAlignmentLinesOwner(new AlignmentLines$recalculate$1(this));
        this.alignmentLineMap.putAll(b(this.alignmentLinesOwner.getInnerCoordinator()));
        this.dirty = false;
    }

    public final void recalculateQueryOwner() {
        AlignmentLinesOwner alignmentLinesOwner2;
        AlignmentLines alignmentLines;
        AlignmentLines alignmentLines2;
        if (getQueried$ui_release()) {
            alignmentLinesOwner2 = this.alignmentLinesOwner;
        } else {
            AlignmentLinesOwner parentAlignmentLinesOwner = this.alignmentLinesOwner.getParentAlignmentLinesOwner();
            if (parentAlignmentLinesOwner != null) {
                alignmentLinesOwner2 = parentAlignmentLinesOwner.getAlignmentLines().queryOwner;
                if (alignmentLinesOwner2 == null || !alignmentLinesOwner2.getAlignmentLines().getQueried$ui_release()) {
                    AlignmentLinesOwner alignmentLinesOwner3 = this.queryOwner;
                    if (alignmentLinesOwner3 != null && !alignmentLinesOwner3.getAlignmentLines().getQueried$ui_release()) {
                        AlignmentLinesOwner parentAlignmentLinesOwner2 = alignmentLinesOwner3.getParentAlignmentLinesOwner();
                        if (!(parentAlignmentLinesOwner2 == null || (alignmentLines2 = parentAlignmentLinesOwner2.getAlignmentLines()) == null)) {
                            alignmentLines2.recalculateQueryOwner();
                        }
                        AlignmentLinesOwner parentAlignmentLinesOwner3 = alignmentLinesOwner3.getParentAlignmentLinesOwner();
                        if (parentAlignmentLinesOwner3 == null || (alignmentLines = parentAlignmentLinesOwner3.getAlignmentLines()) == null) {
                            alignmentLinesOwner2 = null;
                        } else {
                            alignmentLinesOwner2 = alignmentLines.queryOwner;
                        }
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        this.queryOwner = alignmentLinesOwner2;
    }

    public final void reset$ui_release() {
        this.dirty = true;
        this.usedDuringParentMeasurement = false;
        this.previousUsedDuringParentLayout = false;
        this.usedDuringParentLayout = false;
        this.usedByModifierMeasurement = false;
        this.usedByModifierLayout = false;
        this.queryOwner = null;
    }

    public final void setDirty$ui_release(boolean z11) {
        this.dirty = z11;
    }

    public final void setPreviousUsedDuringParentLayout$ui_release(boolean z11) {
        this.previousUsedDuringParentLayout = z11;
    }

    public final void setUsedByModifierLayout$ui_release(boolean z11) {
        this.usedByModifierLayout = z11;
    }

    public final void setUsedByModifierMeasurement$ui_release(boolean z11) {
        this.usedByModifierMeasurement = z11;
    }

    public final void setUsedDuringParentLayout$ui_release(boolean z11) {
        this.usedDuringParentLayout = z11;
    }

    public final void setUsedDuringParentMeasurement$ui_release(boolean z11) {
        this.usedDuringParentMeasurement = z11;
    }
}
