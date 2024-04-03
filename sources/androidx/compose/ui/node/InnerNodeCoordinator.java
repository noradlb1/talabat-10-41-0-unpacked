package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 =2\u00020\u0001:\u0002=>B\u000f\u0012\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010<J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016J@\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0019\u0010\u001b\u001a\u0015\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017¢\u0006\u0002\b\u001aH\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020!H\u0016JS\u00101\u001a\u00020\u0019\"\b\b\u0000\u0010%*\u00020$2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&2\u0006\u0010)\u001a\u00020(2\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100R \u00103\u001a\u0002028\u0016X\u0004¢\u0006\u0012\n\u0004\b3\u00104\u0012\u0004\b7\u00108\u001a\u0004\b5\u00106\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006?"}, d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator;", "Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/layout/LookaheadScope;", "scope", "Landroidx/compose/ui/node/LookaheadDelegate;", "createLookaheadDelegate", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/Placeable;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "measure", "", "height", "minIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicWidth", "maxIntrinsicHeight", "Landroidx/compose/ui/unit/IntOffset;", "position", "", "zIndex", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "layerBlock", "d", "(JFLkotlin/jvm/functions/Function1;)V", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", "calculateAlignmentLine", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "performDraw", "Landroidx/compose/ui/node/DelegatableNode;", "T", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "hitTestSource", "Landroidx/compose/ui/geometry/Offset;", "pointerPosition", "Landroidx/compose/ui/node/HitTestResult;", "hitTestResult", "", "isTouchEvent", "isInLayer", "hitTestChild-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestChild", "Landroidx/compose/ui/Modifier$Node;", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "getTail$annotations", "()V", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "<init>", "(Landroidx/compose/ui/node/LayoutNode;)V", "Companion", "LookaheadDelegateImpl", "ui_release"}, k = 1, mv = {1, 7, 1})
public final class InnerNodeCoordinator extends NodeCoordinator {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Paint innerBoundsPaint;
    @NotNull
    private final Modifier.Node tail = new InnerNodeCoordinator$tail$1();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator$Companion;", "", "()V", "innerBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getInnerBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Paint getInnerBoundsPaint() {
            return InnerNodeCoordinator.innerBoundsPaint;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator$LookaheadDelegateImpl;", "Landroidx/compose/ui/node/LookaheadDelegate;", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/Placeable;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "measure", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", "", "calculateAlignmentLine", "", "i", "height", "minIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicWidth", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/LookaheadScope;", "scope", "<init>", "(Landroidx/compose/ui/node/InnerNodeCoordinator;Landroidx/compose/ui/layout/LookaheadScope;)V", "ui_release"}, k = 1, mv = {1, 7, 1})
    public final class LookaheadDelegateImpl extends LookaheadDelegate {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ InnerNodeCoordinator f9917b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LookaheadDelegateImpl(@NotNull InnerNodeCoordinator innerNodeCoordinator, LookaheadScope lookaheadScope) {
            super(innerNodeCoordinator, lookaheadScope);
            Intrinsics.checkNotNullParameter(lookaheadScope, "scope");
            this.f9917b = innerNodeCoordinator;
        }

        public int calculateAlignmentLine(@NotNull AlignmentLine alignmentLine) {
            int i11;
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            Integer num = getAlignmentLinesOwner().calculateAlignmentLines().get(alignmentLine);
            if (num != null) {
                i11 = num.intValue();
            } else {
                i11 = Integer.MIN_VALUE;
            }
            h().put(alignmentLine, Integer.valueOf(i11));
            return i11;
        }

        public void i() {
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLayoutNode().getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
            lookaheadPassDelegate$ui_release.onPlaced();
            getAlignmentLinesOwner().layoutChildren();
        }

        public int maxIntrinsicHeight(int i11) {
            return getLayoutNode().getIntrinsicsPolicy$ui_release().maxLookaheadIntrinsicHeight(i11);
        }

        public int maxIntrinsicWidth(int i11) {
            return getLayoutNode().getIntrinsicsPolicy$ui_release().maxLookaheadIntrinsicWidth(i11);
        }

        @NotNull
        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m4608measureBRTryo0(long j11) {
            f(j11);
            MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                int i11 = 0;
                do {
                    ((LayoutNode) content[i11]).setMeasuredByParentInLookahead$ui_release(LayoutNode.UsageByParent.NotUsed);
                    i11++;
                } while (i11 < size);
            }
            set_measureResult(getLayoutNode().getMeasurePolicy().m4509measure3p2s80s(this, getLayoutNode().getChildLookaheadMeasurables$ui_release(), j11));
            return this;
        }

        public int minIntrinsicHeight(int i11) {
            return getLayoutNode().getIntrinsicsPolicy$ui_release().minLookaheadIntrinsicHeight(i11);
        }

        public int minIntrinsicWidth(int i11) {
            return getLayoutNode().getIntrinsicsPolicy$ui_release().minLookaheadIntrinsicWidth(i11);
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.m3136setColor8_81llA(Color.Companion.m2953getRed0d7_KjU());
        Paint.setStrokeWidth(1.0f);
        Paint.m3140setStylek9PVt8s(PaintingStyle.Companion.m3149getStrokeTiuSbCo());
        innerBoundsPaint = Paint;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InnerNodeCoordinator(@NotNull LayoutNode layoutNode) {
        super(layoutNode);
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        getTail().updateCoordinator$ui_release(this);
    }

    public static /* synthetic */ void getTail$annotations() {
    }

    public int calculateAlignmentLine(@NotNull AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        LookaheadDelegate lookaheadDelegate$ui_release = getLookaheadDelegate$ui_release();
        if (lookaheadDelegate$ui_release != null) {
            return lookaheadDelegate$ui_release.calculateAlignmentLine(alignmentLine);
        }
        Integer num = getAlignmentLinesOwner().calculateAlignmentLines().get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    @NotNull
    public LookaheadDelegate createLookaheadDelegate(@NotNull LookaheadScope lookaheadScope) {
        Intrinsics.checkNotNullParameter(lookaheadScope, "scope");
        return new LookaheadDelegateImpl(this, lookaheadScope);
    }

    public void d(long j11, float f11, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
        super.d(j11, f11, function1);
        if (!isShallowPlacing$ui_release()) {
            onPlaced();
            getLayoutNode().onNodePlaced$ui_release();
        }
    }

    @NotNull
    public Modifier.Node getTail() {
        return this.tail;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* renamed from: hitTestChild-YqVAtuI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends androidx.compose.ui.node.DelegatableNode> void m4606hitTestChildYqVAtuI(@org.jetbrains.annotations.NotNull androidx.compose.ui.node.NodeCoordinator.HitTestSource<T> r20, long r21, @org.jetbrains.annotations.NotNull androidx.compose.ui.node.HitTestResult<T> r23, boolean r24, boolean r25) {
        /*
            r19 = this;
            r0 = r19
            r8 = r20
            r9 = r21
            r11 = r23
            java.lang.String r1 = "hitTestSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            java.lang.String r1 = "hitTestResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            androidx.compose.ui.node.LayoutNode r1 = r19.getLayoutNode()
            boolean r1 = r8.shouldHitTestChildren(r1)
            r12 = 1
            r13 = 0
            if (r1 == 0) goto L_0x0046
            boolean r1 = r0.p(r9)
            if (r1 == 0) goto L_0x0028
            r14 = r25
            r1 = r12
            goto L_0x0049
        L_0x0028:
            if (r24 == 0) goto L_0x0046
            long r1 = r19.m4720getMinimumTouchTargetSizeNHjbRc()
            float r1 = r0.i(r9, r1)
            boolean r2 = java.lang.Float.isInfinite(r1)
            if (r2 != 0) goto L_0x0040
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0040
            r1 = r12
            goto L_0x0041
        L_0x0040:
            r1 = r13
        L_0x0041:
            if (r1 == 0) goto L_0x0046
            r1 = r12
            r14 = r13
            goto L_0x0049
        L_0x0046:
            r14 = r25
            r1 = r13
        L_0x0049:
            if (r1 == 0) goto L_0x00b0
            int r15 = r23.hitDepth
            androidx.compose.ui.node.LayoutNode r1 = r19.getLayoutNode()
            androidx.compose.runtime.collection.MutableVector r1 = r1.getZSortedChildren()
            int r2 = r1.getSize()
            if (r2 <= 0) goto L_0x00ad
            int r2 = r2 - r12
            java.lang.Object[] r7 = r1.getContent()
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r1)
            r16 = r2
        L_0x0069:
            r1 = r7[r16]
            r17 = r1
            androidx.compose.ui.node.LayoutNode r17 = (androidx.compose.ui.node.LayoutNode) r17
            boolean r1 = r17.isPlaced()
            if (r1 == 0) goto L_0x00a0
            r1 = r20
            r2 = r17
            r3 = r21
            r5 = r23
            r6 = r24
            r18 = r7
            r7 = r14
            r1.m4740childHitTestYqVAtuI(r2, r3, r5, r6, r7)
            boolean r1 = r23.hasHit()
            if (r1 != 0) goto L_0x008d
        L_0x008b:
            r1 = r12
            goto L_0x009c
        L_0x008d:
            androidx.compose.ui.node.NodeCoordinator r1 = r17.getOuterCoordinator$ui_release()
            boolean r1 = r1.shouldSharePointerInputWithSiblings()
            if (r1 == 0) goto L_0x009b
            r23.acceptHits()
            goto L_0x008b
        L_0x009b:
            r1 = r13
        L_0x009c:
            if (r1 != 0) goto L_0x00a2
            r1 = r12
            goto L_0x00a3
        L_0x00a0:
            r18 = r7
        L_0x00a2:
            r1 = r13
        L_0x00a3:
            if (r1 != 0) goto L_0x00ad
            int r16 = r16 + -1
            if (r16 >= 0) goto L_0x00aa
            goto L_0x00ad
        L_0x00aa:
            r7 = r18
            goto L_0x0069
        L_0x00ad:
            r11.hitDepth = r15
        L_0x00b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.InnerNodeCoordinator.m4606hitTestChildYqVAtuI(androidx.compose.ui.node.NodeCoordinator$HitTestSource, long, androidx.compose.ui.node.HitTestResult, boolean, boolean):void");
    }

    public int maxIntrinsicHeight(int i11) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().maxIntrinsicHeight(i11);
    }

    public int maxIntrinsicWidth(int i11) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().maxIntrinsicWidth(i11);
    }

    @NotNull
    /* renamed from: measure-BRTryo0  reason: not valid java name */
    public Placeable m4607measureBRTryo0(long j11) {
        f(j11);
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                ((LayoutNode) content[i11]).setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                i11++;
            } while (i11 < size);
        }
        setMeasureResult$ui_release(getLayoutNode().getMeasurePolicy().m4509measure3p2s80s(this, getLayoutNode().getChildMeasurables$ui_release(), j11));
        onMeasured();
        return this;
    }

    public int minIntrinsicHeight(int i11) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().minIntrinsicHeight(i11);
    }

    public int minIntrinsicWidth(int i11) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().minIntrinsicWidth(i11);
    }

    public void performDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Owner requireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
        MutableVector<LayoutNode> zSortedChildren = getLayoutNode().getZSortedChildren();
        int size = zSortedChildren.getSize();
        if (size > 0) {
            Object[] content = zSortedChildren.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) content[i11];
                if (layoutNode.isPlaced()) {
                    layoutNode.draw$ui_release(canvas);
                }
                i11++;
            } while (i11 < size);
        }
        if (requireOwner.getShowLayoutBounds()) {
            j(canvas, innerBoundsPaint);
        }
    }
}
