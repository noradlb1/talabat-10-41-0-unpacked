package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadLayoutCoordinatesImpl;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\b \u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\bo\u0010pJ\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\f\u001a\u00020\tH\u0010¢\u0006\u0004\b\n\u0010\u000bJ@\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0019\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011¢\u0006\u0002\b\u0013H\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001a\u00020\tH\u0014J/\u0010 \u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0016J \u0010*\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0000H\u0000ø\u0001\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)R\u0017\u0010,\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R+\u0010\u000e\u001a\u00020\r8\u0016@\u0016X\u000eø\u0001\u0001ø\u0001\u0000ø\u0001\u0003¢\u0006\u0012\n\u0004\b\u000e\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0017\u0010>\u001a\u00020=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR(\u0010C\u001a\u0004\u0018\u00010\u001b2\b\u0010B\u001a\u0004\u0018\u00010\u001b8\u0002@BX\u000e¢\u0006\f\n\u0004\bC\u0010D\"\u0004\bE\u0010FR&\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050:8\u0004X\u0004¢\u0006\f\n\u0004\bG\u0010<\u001a\u0004\bH\u0010IR\u0016\u0010L\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8VX\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010S\u001a\u00020\u001b8PX\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8VX\u0004¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0014\u0010Z\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0014\u0010\\\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b[\u0010YR\u0016\u0010^\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b]\u0010KR\u0014\u0010b\u001a\u00020_8VX\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0014\u0010f\u001a\u00020c8VX\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR\u0014\u0010j\u001a\u00020g8VX\u0004¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0016\u0010n\u001a\u0004\u0018\u00010k8VX\u0004¢\u0006\u0006\u001a\u0004\bl\u0010m\u0002\u0016\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0005\b20\u0001\n\u0002\b!¨\u0006q"}, d2 = {"Landroidx/compose/ui/node/LookaheadDelegate;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", "", "getCachedAlignmentLine$ui_release", "(Landroidx/compose/ui/layout/AlignmentLine;)I", "getCachedAlignmentLine", "", "replace$ui_release", "()V", "replace", "Landroidx/compose/ui/unit/IntOffset;", "position", "", "zIndex", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "d", "(JFLkotlin/jvm/functions/Function1;)V", "i", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/MeasureResult;", "block", "Landroidx/compose/ui/layout/Placeable;", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "performingMeasure", "height", "minIntrinsicWidth", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "ancestor", "positionIn-Bjo55l4$ui_release", "(Landroidx/compose/ui/node/LookaheadDelegate;)J", "positionIn", "Landroidx/compose/ui/node/NodeCoordinator;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/layout/LookaheadScope;", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "getLookaheadScope", "()Landroidx/compose/ui/layout/LookaheadScope;", "J", "getPosition-nOcc-ac", "()J", "setPosition--gyyYBs", "(J)V", "", "oldAlignmentLines", "Ljava/util/Map;", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinatesImpl;", "lookaheadLayoutCoordinates", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinatesImpl;", "getLookaheadLayoutCoordinates", "()Landroidx/compose/ui/layout/LookaheadLayoutCoordinatesImpl;", "result", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "set_measureResult", "(Landroidx/compose/ui/layout/MeasureResult;)V", "cachedAlignmentLinesMap", "h", "()Ljava/util/Map;", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "child", "", "getHasMeasureResult", "()Z", "hasMeasureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "measureResult", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getDensity", "()F", "density", "getFontScale", "fontScale", "getParent", "parent", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "alignmentLinesOwner", "", "getParentData", "()Ljava/lang/Object;", "parentData", "<init>", "(Landroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/layout/LookaheadScope;)V", "ui_release"}, k = 1, mv = {1, 7, 1})
public abstract class LookaheadDelegate extends LookaheadCapablePlaceable implements Measurable {
    @Nullable
    private MeasureResult _measureResult;
    @NotNull
    private final Map<AlignmentLine, Integer> cachedAlignmentLinesMap = new LinkedHashMap();
    @NotNull
    private final NodeCoordinator coordinator;
    @NotNull
    private final LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinates = new LookaheadLayoutCoordinatesImpl(this);
    @NotNull
    private final LookaheadScope lookaheadScope;
    @Nullable
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position = IntOffset.Companion.m5606getZeronOccac();

    public LookaheadDelegate(@NotNull NodeCoordinator nodeCoordinator, @NotNull LookaheadScope lookaheadScope2) {
        Intrinsics.checkNotNullParameter(nodeCoordinator, "coordinator");
        Intrinsics.checkNotNullParameter(lookaheadScope2, "lookaheadScope");
        this.coordinator = nodeCoordinator;
        this.lookaheadScope = lookaheadScope2;
    }

    /* access modifiers changed from: private */
    public final void set_measureResult(MeasureResult measureResult) {
        Unit unit;
        boolean z11;
        if (measureResult != null) {
            e(IntSizeKt.IntSize(measureResult.getWidth(), measureResult.getHeight()));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            e(IntSize.Companion.m5643getZeroYbymL2g());
        }
        if (!Intrinsics.areEqual((Object) this._measureResult, (Object) measureResult) && measureResult != null) {
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if (map == null || map.isEmpty()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if ((!z11 || (!measureResult.getAlignmentLines().isEmpty())) && !Intrinsics.areEqual((Object) measureResult.getAlignmentLines(), (Object) this.oldAlignmentLines)) {
                getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
                Map map2 = this.oldAlignmentLines;
                if (map2 == null) {
                    map2 = new LinkedHashMap();
                    this.oldAlignmentLines = map2;
                }
                map2.clear();
                map2.putAll(measureResult.getAlignmentLines());
            }
        }
        this._measureResult = measureResult;
    }

    public final void d(long j11, float f11, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
        if (!IntOffset.m5595equalsimpl0(m4689getPositionnOccac(), j11)) {
            m4692setPositiongyyYBs(j11);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLayoutNode().getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
            if (lookaheadPassDelegate$ui_release != null) {
                lookaheadPassDelegate$ui_release.notifyChildrenUsingCoordinatesWhilePlacing();
            }
            g(this.coordinator);
        }
        if (!isShallowPlacing$ui_release()) {
            i();
        }
    }

    @NotNull
    public AlignmentLinesOwner getAlignmentLinesOwner() {
        AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = this.coordinator.getLayoutNode().getLayoutDelegate$ui_release().getLookaheadAlignmentLinesOwner$ui_release();
        Intrinsics.checkNotNull(lookaheadAlignmentLinesOwner$ui_release);
        return lookaheadAlignmentLinesOwner$ui_release;
    }

    public final int getCachedAlignmentLine$ui_release(@NotNull AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        Integer num = this.cachedAlignmentLinesMap.get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    @Nullable
    public LookaheadCapablePlaceable getChild() {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        if (wrapped$ui_release != null) {
            return wrapped$ui_release.getLookaheadDelegate$ui_release();
        }
        return null;
    }

    @NotNull
    public LayoutCoordinates getCoordinates() {
        return this.lookaheadLayoutCoordinates;
    }

    @NotNull
    public final NodeCoordinator getCoordinator() {
        return this.coordinator;
    }

    public float getDensity() {
        return this.coordinator.getDensity();
    }

    public float getFontScale() {
        return this.coordinator.getFontScale();
    }

    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.coordinator.getLayoutDirection();
    }

    @NotNull
    public LayoutNode getLayoutNode() {
        return this.coordinator.getLayoutNode();
    }

    @NotNull
    public final LookaheadLayoutCoordinatesImpl getLookaheadLayoutCoordinates() {
        return this.lookaheadLayoutCoordinates;
    }

    @NotNull
    public final LookaheadScope getLookaheadScope() {
        return this.lookaheadScope;
    }

    @NotNull
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException("LookaheadDelegate has not been measured yet when measureResult is requested.".toString());
    }

    @Nullable
    public LookaheadCapablePlaceable getParent() {
        NodeCoordinator wrappedBy$ui_release = this.coordinator.getWrappedBy$ui_release();
        if (wrappedBy$ui_release != null) {
            return wrappedBy$ui_release.getLookaheadDelegate$ui_release();
        }
        return null;
    }

    @Nullable
    public Object getParentData() {
        return this.coordinator.getParentData();
    }

    /* renamed from: getPosition-nOcc-ac  reason: not valid java name */
    public long m4689getPositionnOccac() {
        return this.position;
    }

    @NotNull
    public final Map<AlignmentLine, Integer> h() {
        return this.cachedAlignmentLinesMap;
    }

    public void i() {
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        int width = getMeasureResult$ui_release().getWidth();
        LayoutDirection layoutDirection = this.coordinator.getLayoutDirection();
        LayoutCoordinates access$get_coordinates$cp = Placeable.PlacementScope._coordinates;
        int access$getParentWidth = companion.b();
        LayoutDirection access$getParentLayoutDirection = companion.a();
        LayoutNodeLayoutDelegate access$getLayoutDelegate$cp = Placeable.PlacementScope.layoutDelegate;
        Placeable.PlacementScope.parentWidth = width;
        Placeable.PlacementScope.parentLayoutDirection = layoutDirection;
        boolean access$configureForPlacingForAlignment = companion.configureForPlacingForAlignment(this);
        getMeasureResult$ui_release().placeChildren();
        setPlacingForAlignment$ui_release(access$configureForPlacingForAlignment);
        Placeable.PlacementScope.parentWidth = access$getParentWidth;
        Placeable.PlacementScope.parentLayoutDirection = access$getParentLayoutDirection;
        Placeable.PlacementScope._coordinates = access$get_coordinates$cp;
        Placeable.PlacementScope.layoutDelegate = access$getLayoutDelegate$cp;
    }

    public int maxIntrinsicHeight(int i11) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate$ui_release = wrapped$ui_release.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.maxIntrinsicHeight(i11);
    }

    public int maxIntrinsicWidth(int i11) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate$ui_release = wrapped$ui_release.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.maxIntrinsicWidth(i11);
    }

    public int minIntrinsicHeight(int i11) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate$ui_release = wrapped$ui_release.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.minIntrinsicHeight(i11);
    }

    public int minIntrinsicWidth(int i11) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate$ui_release = wrapped$ui_release.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.minIntrinsicWidth(i11);
    }

    @NotNull
    /* renamed from: performingMeasure-K40F9xA  reason: not valid java name */
    public final Placeable m4690performingMeasureK40F9xA(long j11, @NotNull Function0<? extends MeasureResult> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        f(j11);
        set_measureResult((MeasureResult) function0.invoke());
        return this;
    }

    /* renamed from: positionIn-Bjo55l4$ui_release  reason: not valid java name */
    public final long m4691positionInBjo55l4$ui_release(@NotNull LookaheadDelegate lookaheadDelegate) {
        Intrinsics.checkNotNullParameter(lookaheadDelegate, "ancestor");
        long r02 = IntOffset.Companion.m5606getZeronOccac();
        LookaheadDelegate lookaheadDelegate2 = this;
        while (!Intrinsics.areEqual((Object) lookaheadDelegate2, (Object) lookaheadDelegate)) {
            long r32 = lookaheadDelegate2.m4689getPositionnOccac();
            r02 = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r02) + IntOffset.m5596getXimpl(r32), IntOffset.m5597getYimpl(r02) + IntOffset.m5597getYimpl(r32));
            NodeCoordinator wrappedBy$ui_release = lookaheadDelegate2.coordinator.getWrappedBy$ui_release();
            Intrinsics.checkNotNull(wrappedBy$ui_release);
            lookaheadDelegate2 = wrappedBy$ui_release.getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate2);
        }
        return r02;
    }

    public void replace$ui_release() {
        d(m4689getPositionnOccac(), 0.0f, (Function1<? super GraphicsLayerScope, Unit>) null);
    }

    /* renamed from: setPosition--gyyYBs  reason: not valid java name */
    public void m4692setPositiongyyYBs(long j11) {
        this.position = j11;
    }
}
