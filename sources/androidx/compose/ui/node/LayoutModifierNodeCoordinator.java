package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 <2\u00020\u0001:\u0003<=>B\u0017\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u00109\u001a\u00020%¢\u0006\u0004\b:\u0010;J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J@\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0019\u0010\u001b\u001a\u0015\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017¢\u0006\u0002\b\u001aH\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0019H\u0016J\u0010\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\"H\u0016R*\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020%8\u0006@@X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u0002008VX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0011\u00106\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b4\u00105\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006?"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/layout/LookaheadScope;", "scope", "Landroidx/compose/ui/node/LookaheadDelegate;", "createLookaheadDelegate", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/Placeable;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "measure", "", "height", "minIntrinsicWidth", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "Landroidx/compose/ui/unit/IntOffset;", "position", "", "zIndex", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "layerBlock", "d", "(JFLkotlin/jvm/functions/Function1;)V", "onLayoutModifierNodeChanged", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", "calculateAlignmentLine", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "performDraw", "Landroidx/compose/ui/node/LayoutModifierNode;", "<set-?>", "layoutModifierNode", "Landroidx/compose/ui/node/LayoutModifierNode;", "getLayoutModifierNode", "()Landroidx/compose/ui/node/LayoutModifierNode;", "setLayoutModifierNode$ui_release", "(Landroidx/compose/ui/node/LayoutModifierNode;)V", "Landroidx/compose/ui/node/IntermediateLayoutModifierNode;", "lookAheadTransientMeasureNode", "Landroidx/compose/ui/node/IntermediateLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "tail", "getWrappedNonNull", "()Landroidx/compose/ui/node/NodeCoordinator;", "wrappedNonNull", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "measureNode", "<init>", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/LayoutModifierNode;)V", "Companion", "LookaheadDelegateForIntermediateLayoutModifier", "LookaheadDelegateForLayoutModifierNode", "ui_release"}, k = 1, mv = {1, 7, 1})
public final class LayoutModifierNodeCoordinator extends NodeCoordinator {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Paint modifierBoundsPaint;
    @NotNull
    private LayoutModifierNode layoutModifierNode;
    @Nullable
    private IntermediateLayoutModifierNode lookAheadTransientMeasureNode;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$Companion;", "", "()V", "modifierBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getModifierBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Paint getModifierBoundsPaint() {
            return LayoutModifierNodeCoordinator.modifierBoundsPaint;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001d\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n0\nR\u00060\u0000R\u00020\u000bX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$LookaheadDelegateForIntermediateLayoutModifier;", "Landroidx/compose/ui/node/LookaheadDelegate;", "scope", "Landroidx/compose/ui/layout/LookaheadScope;", "intermediateMeasureNode", "Landroidx/compose/ui/node/IntermediateLayoutModifierNode;", "(Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;Landroidx/compose/ui/layout/LookaheadScope;Landroidx/compose/ui/node/IntermediateLayoutModifierNode;)V", "getIntermediateMeasureNode", "()Landroidx/compose/ui/node/IntermediateLayoutModifierNode;", "passThroughMeasureResult", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$LookaheadDelegateForIntermediateLayoutModifier$PassThroughMeasureResult;", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "PassThroughMeasureResult", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class LookaheadDelegateForIntermediateLayoutModifier extends LookaheadDelegate {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LayoutModifierNodeCoordinator f9918b;
        @NotNull
        private final IntermediateLayoutModifierNode intermediateMeasureNode;
        @NotNull
        private final PassThroughMeasureResult passThroughMeasureResult = new PassThroughMeasureResult();

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$LookaheadDelegateForIntermediateLayoutModifier$PassThroughMeasureResult;", "Landroidx/compose/ui/layout/MeasureResult;", "(Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$LookaheadDelegateForIntermediateLayoutModifier;)V", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "()I", "width", "getWidth", "placeChildren", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public final class PassThroughMeasureResult implements MeasureResult {
            @NotNull
            private final Map<AlignmentLine, Integer> alignmentLines = MapsKt__MapsKt.emptyMap();

            public PassThroughMeasureResult() {
            }

            @NotNull
            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return this.alignmentLines;
            }

            public int getHeight() {
                LookaheadDelegate lookaheadDelegate$ui_release = LookaheadDelegateForIntermediateLayoutModifier.this.f9918b.getWrappedNonNull().getLookaheadDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
                return lookaheadDelegate$ui_release.getMeasureResult$ui_release().getHeight();
            }

            public int getWidth() {
                LookaheadDelegate lookaheadDelegate$ui_release = LookaheadDelegateForIntermediateLayoutModifier.this.f9918b.getWrappedNonNull().getLookaheadDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
                return lookaheadDelegate$ui_release.getMeasureResult$ui_release().getWidth();
            }

            public void placeChildren() {
                Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
                LookaheadDelegate lookaheadDelegate$ui_release = LookaheadDelegateForIntermediateLayoutModifier.this.f9918b.getWrappedNonNull().getLookaheadDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
                Placeable.PlacementScope.place$default(companion, lookaheadDelegate$ui_release, 0, 0, 0.0f, 4, (Object) null);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LookaheadDelegateForIntermediateLayoutModifier(@NotNull LayoutModifierNodeCoordinator layoutModifierNodeCoordinator, @NotNull LookaheadScope lookaheadScope, IntermediateLayoutModifierNode intermediateLayoutModifierNode) {
            super(layoutModifierNodeCoordinator, lookaheadScope);
            Intrinsics.checkNotNullParameter(lookaheadScope, "scope");
            Intrinsics.checkNotNullParameter(intermediateLayoutModifierNode, "intermediateMeasureNode");
            this.f9918b = layoutModifierNodeCoordinator;
            this.intermediateMeasureNode = intermediateLayoutModifierNode;
        }

        public int calculateAlignmentLine(@NotNull AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            int access$calculateAlignmentAndPlaceChildAsNeeded = LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
            h().put(alignmentLine, Integer.valueOf(access$calculateAlignmentAndPlaceChildAsNeeded));
            return access$calculateAlignmentAndPlaceChildAsNeeded;
        }

        @NotNull
        public final IntermediateLayoutModifierNode getIntermediateMeasureNode() {
            return this.intermediateMeasureNode;
        }

        @NotNull
        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m4614measureBRTryo0(long j11) {
            IntermediateLayoutModifierNode intermediateLayoutModifierNode = this.intermediateMeasureNode;
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = this.f9918b;
            f(j11);
            LookaheadDelegate lookaheadDelegate$ui_release = layoutModifierNodeCoordinator.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            lookaheadDelegate$ui_release.m4508measureBRTryo0(j11);
            intermediateLayoutModifierNode.m4610setTargetSizeozmzZPI(IntSizeKt.IntSize(lookaheadDelegate$ui_release.getMeasureResult$ui_release().getWidth(), lookaheadDelegate$ui_release.getMeasureResult$ui_release().getHeight()));
            set_measureResult(this.passThroughMeasureResult);
            return this;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$LookaheadDelegateForLayoutModifierNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "scope", "Landroidx/compose/ui/layout/LookaheadScope;", "(Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;Landroidx/compose/ui/layout/LookaheadScope;)V", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class LookaheadDelegateForLayoutModifierNode extends LookaheadDelegate {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LayoutModifierNodeCoordinator f9920b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LookaheadDelegateForLayoutModifierNode(@NotNull LayoutModifierNodeCoordinator layoutModifierNodeCoordinator, LookaheadScope lookaheadScope) {
            super(layoutModifierNodeCoordinator, lookaheadScope);
            Intrinsics.checkNotNullParameter(lookaheadScope, "scope");
            this.f9920b = layoutModifierNodeCoordinator;
        }

        public int calculateAlignmentLine(@NotNull AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            int access$calculateAlignmentAndPlaceChildAsNeeded = LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
            h().put(alignmentLine, Integer.valueOf(access$calculateAlignmentAndPlaceChildAsNeeded));
            return access$calculateAlignmentAndPlaceChildAsNeeded;
        }

        public int maxIntrinsicHeight(int i11) {
            LayoutModifierNode layoutModifierNode = this.f9920b.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate$ui_release = this.f9920b.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return layoutModifierNode.maxIntrinsicHeight(this, lookaheadDelegate$ui_release, i11);
        }

        public int maxIntrinsicWidth(int i11) {
            LayoutModifierNode layoutModifierNode = this.f9920b.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate$ui_release = this.f9920b.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return layoutModifierNode.maxIntrinsicWidth(this, lookaheadDelegate$ui_release, i11);
        }

        @NotNull
        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m4615measureBRTryo0(long j11) {
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = this.f9920b;
            f(j11);
            LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate$ui_release = layoutModifierNodeCoordinator.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            set_measureResult(layoutModifierNode.m4612measure3p2s80s(this, lookaheadDelegate$ui_release, j11));
            return this;
        }

        public int minIntrinsicHeight(int i11) {
            LayoutModifierNode layoutModifierNode = this.f9920b.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate$ui_release = this.f9920b.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return layoutModifierNode.minIntrinsicHeight(this, lookaheadDelegate$ui_release, i11);
        }

        public int minIntrinsicWidth(int i11) {
            LayoutModifierNode layoutModifierNode = this.f9920b.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate$ui_release = this.f9920b.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return layoutModifierNode.minIntrinsicWidth(this, lookaheadDelegate$ui_release, i11);
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.m3136setColor8_81llA(Color.Companion.m2946getBlue0d7_KjU());
        Paint.setStrokeWidth(1.0f);
        Paint.m3140setStylek9PVt8s(PaintingStyle.Companion.m3149getStrokeTiuSbCo());
        modifierBoundsPaint = Paint;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutModifierNodeCoordinator(@NotNull LayoutNode layoutNode, @NotNull LayoutModifierNode layoutModifierNode2) {
        super(layoutNode);
        boolean z11;
        IntermediateLayoutModifierNode intermediateLayoutModifierNode;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Intrinsics.checkNotNullParameter(layoutModifierNode2, "measureNode");
        this.layoutModifierNode = layoutModifierNode2;
        Modifier.Node node = layoutModifierNode2.getNode();
        if ((node.getKindSet$ui_release() & Nodes.INSTANCE.m4760getIntermediateMeasureOLwlOKw()) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || !(layoutModifierNode2 instanceof IntermediateLayoutModifierNode)) {
            intermediateLayoutModifierNode = null;
        } else {
            intermediateLayoutModifierNode = (IntermediateLayoutModifierNode) layoutModifierNode2;
        }
        this.lookAheadTransientMeasureNode = intermediateLayoutModifierNode;
    }

    public int calculateAlignmentLine(@NotNull AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        LookaheadDelegate lookaheadDelegate$ui_release = getLookaheadDelegate$ui_release();
        if (lookaheadDelegate$ui_release != null) {
            return lookaheadDelegate$ui_release.getCachedAlignmentLine$ui_release(alignmentLine);
        }
        return LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
    }

    @NotNull
    public LookaheadDelegate createLookaheadDelegate(@NotNull LookaheadScope lookaheadScope) {
        Intrinsics.checkNotNullParameter(lookaheadScope, "scope");
        IntermediateLayoutModifierNode intermediateLayoutModifierNode = this.lookAheadTransientMeasureNode;
        if (intermediateLayoutModifierNode != null) {
            return new LookaheadDelegateForIntermediateLayoutModifier(this, lookaheadScope, intermediateLayoutModifierNode);
        }
        return new LookaheadDelegateForLayoutModifierNode(this, lookaheadScope);
    }

    public void d(long j11, float f11, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
        super.d(j11, f11, function1);
        if (!isShallowPlacing$ui_release()) {
            onPlaced();
            Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
            int r52 = IntSize.m5638getWidthimpl(b());
            LayoutDirection layoutDirection = getLayoutDirection();
            LayoutCoordinates access$get_coordinates$cp = Placeable.PlacementScope._coordinates;
            int access$getParentWidth = companion.b();
            LayoutDirection access$getParentLayoutDirection = companion.a();
            LayoutNodeLayoutDelegate access$getLayoutDelegate$cp = Placeable.PlacementScope.layoutDelegate;
            Placeable.PlacementScope.parentWidth = r52;
            Placeable.PlacementScope.parentLayoutDirection = layoutDirection;
            boolean access$configureForPlacingForAlignment = companion.configureForPlacingForAlignment(this);
            getMeasureResult$ui_release().placeChildren();
            setPlacingForAlignment$ui_release(access$configureForPlacingForAlignment);
            Placeable.PlacementScope.parentWidth = access$getParentWidth;
            Placeable.PlacementScope.parentLayoutDirection = access$getParentLayoutDirection;
            Placeable.PlacementScope._coordinates = access$get_coordinates$cp;
            Placeable.PlacementScope.layoutDelegate = access$getLayoutDelegate$cp;
        }
    }

    @NotNull
    public final LayoutModifierNode getLayoutModifierNode() {
        return this.layoutModifierNode;
    }

    @NotNull
    public Modifier.Node getTail() {
        return this.layoutModifierNode.getNode();
    }

    @NotNull
    public final NodeCoordinator getWrappedNonNull() {
        NodeCoordinator wrapped$ui_release = getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        return wrapped$ui_release;
    }

    public int maxIntrinsicHeight(int i11) {
        return this.layoutModifierNode.maxIntrinsicHeight(this, getWrappedNonNull(), i11);
    }

    public int maxIntrinsicWidth(int i11) {
        return this.layoutModifierNode.maxIntrinsicWidth(this, getWrappedNonNull(), i11);
    }

    @NotNull
    /* renamed from: measure-BRTryo0  reason: not valid java name */
    public Placeable m4613measureBRTryo0(long j11) {
        f(j11);
        setMeasureResult$ui_release(this.layoutModifierNode.m4612measure3p2s80s(this, getWrappedNonNull(), j11));
        OwnedLayer layer = getLayer();
        if (layer != null) {
            layer.m4771resizeozmzZPI(b());
        }
        onMeasured();
        return this;
    }

    public int minIntrinsicHeight(int i11) {
        return this.layoutModifierNode.minIntrinsicHeight(this, getWrappedNonNull(), i11);
    }

    public int minIntrinsicWidth(int i11) {
        return this.layoutModifierNode.minIntrinsicWidth(this, getWrappedNonNull(), i11);
    }

    public void onLayoutModifierNodeChanged() {
        boolean z11;
        super.onLayoutModifierNodeChanged();
        LayoutModifierNode layoutModifierNode2 = this.layoutModifierNode;
        Modifier.Node node = layoutModifierNode2.getNode();
        if ((node.getKindSet$ui_release() & Nodes.INSTANCE.m4760getIntermediateMeasureOLwlOKw()) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || !(layoutModifierNode2 instanceof IntermediateLayoutModifierNode)) {
            this.lookAheadTransientMeasureNode = null;
            LookaheadDelegate lookaheadDelegate$ui_release = getLookaheadDelegate$ui_release();
            if (lookaheadDelegate$ui_release != null) {
                o(new LookaheadDelegateForLayoutModifierNode(this, lookaheadDelegate$ui_release.getLookaheadScope()));
                return;
            }
            return;
        }
        IntermediateLayoutModifierNode intermediateLayoutModifierNode = (IntermediateLayoutModifierNode) layoutModifierNode2;
        this.lookAheadTransientMeasureNode = intermediateLayoutModifierNode;
        LookaheadDelegate lookaheadDelegate$ui_release2 = getLookaheadDelegate$ui_release();
        if (lookaheadDelegate$ui_release2 != null) {
            o(new LookaheadDelegateForIntermediateLayoutModifier(this, lookaheadDelegate$ui_release2.getLookaheadScope(), intermediateLayoutModifierNode));
        }
    }

    public void performDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getWrappedNonNull().draw(canvas);
        if (LayoutNodeKt.requireOwner(getLayoutNode()).getShowLayoutBounds()) {
            j(canvas, modifierBoundsPaint);
        }
    }

    public final void setLayoutModifierNode$ui_release(@NotNull LayoutModifierNode layoutModifierNode2) {
        Intrinsics.checkNotNullParameter(layoutModifierNode2, "<set-?>");
        this.layoutModifierNode = layoutModifierNode2;
    }
}
