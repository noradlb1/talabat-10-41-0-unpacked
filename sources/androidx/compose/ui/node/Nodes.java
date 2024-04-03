package androidx.compose.ui.node;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000b\u0010\u0007R\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0011\u0010\u0007R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0007R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001d\u0010\u0007R\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b \u0010\u0007R\"\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b#\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/compose/ui/node/Nodes;", "", "()V", "Any", "Landroidx/compose/ui/node/NodeKind;", "Landroidx/compose/ui/Modifier$Node;", "getAny-OLwlOKw", "()I", "I", "Draw", "Landroidx/compose/ui/node/DrawModifierNode;", "getDraw-OLwlOKw", "GlobalPositionAware", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "getGlobalPositionAware-OLwlOKw", "IntermediateMeasure", "Landroidx/compose/ui/node/IntermediateLayoutModifierNode;", "getIntermediateMeasure-OLwlOKw", "Layout", "Landroidx/compose/ui/node/LayoutModifierNode;", "getLayout-OLwlOKw", "LayoutAware", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "getLayoutAware-OLwlOKw", "Locals", "Landroidx/compose/ui/modifier/ModifierLocalNode;", "getLocals-OLwlOKw", "ParentData", "Landroidx/compose/ui/node/ParentDataModifierNode;", "getParentData-OLwlOKw", "PointerInput", "Landroidx/compose/ui/node/PointerInputModifierNode;", "getPointerInput-OLwlOKw", "Semantics", "Landroidx/compose/ui/node/SemanticsModifierNode;", "getSemantics-OLwlOKw", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Nodes {
    private static final int Any = NodeKind.m4745constructorimpl(1);
    private static final int Draw = NodeKind.m4745constructorimpl(4);
    private static final int GlobalPositionAware = NodeKind.m4745constructorimpl(256);
    @NotNull
    public static final Nodes INSTANCE = new Nodes();
    private static final int IntermediateMeasure = NodeKind.m4745constructorimpl(512);
    private static final int Layout = NodeKind.m4745constructorimpl(2);
    private static final int LayoutAware = NodeKind.m4745constructorimpl(128);
    private static final int Locals = NodeKind.m4745constructorimpl(32);
    private static final int ParentData = NodeKind.m4745constructorimpl(64);
    private static final int PointerInput = NodeKind.m4745constructorimpl(16);
    private static final int Semantics = NodeKind.m4745constructorimpl(8);

    private Nodes() {
    }

    /* renamed from: getAny-OLwlOKw  reason: not valid java name */
    public final int m4757getAnyOLwlOKw() {
        return Any;
    }

    /* renamed from: getDraw-OLwlOKw  reason: not valid java name */
    public final int m4758getDrawOLwlOKw() {
        return Draw;
    }

    /* renamed from: getGlobalPositionAware-OLwlOKw  reason: not valid java name */
    public final int m4759getGlobalPositionAwareOLwlOKw() {
        return GlobalPositionAware;
    }

    /* renamed from: getIntermediateMeasure-OLwlOKw  reason: not valid java name */
    public final int m4760getIntermediateMeasureOLwlOKw() {
        return IntermediateMeasure;
    }

    /* renamed from: getLayout-OLwlOKw  reason: not valid java name */
    public final int m4761getLayoutOLwlOKw() {
        return Layout;
    }

    /* renamed from: getLayoutAware-OLwlOKw  reason: not valid java name */
    public final int m4762getLayoutAwareOLwlOKw() {
        return LayoutAware;
    }

    /* renamed from: getLocals-OLwlOKw  reason: not valid java name */
    public final int m4763getLocalsOLwlOKw() {
        return Locals;
    }

    /* renamed from: getParentData-OLwlOKw  reason: not valid java name */
    public final int m4764getParentDataOLwlOKw() {
        return ParentData;
    }

    /* renamed from: getPointerInput-OLwlOKw  reason: not valid java name */
    public final int m4765getPointerInputOLwlOKw() {
        return PointerInput;
    }

    /* renamed from: getSemantics-OLwlOKw  reason: not valid java name */
    public final int m4766getSemanticsOLwlOKw() {
        return Semantics;
    }
}
