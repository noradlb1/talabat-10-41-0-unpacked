package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.Nodes;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010D\u001a\u00020E2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00000GH\u0002J6\u0010H\u001a\u00020\u00002\b\u0010I\u001a\u0004\u0018\u00010J2\u0017\u0010K\u001a\u0013\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020E0L¢\u0006\u0002\bNH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\bOJ\r\u0010P\u001a\u00020QH\u0000¢\u0006\u0002\bRJ(\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00000\u00102\u000e\b\u0002\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00000G2\b\b\u0002\u0010U\u001a\u00020\u0005H\u0002J\u000e\u0010V\u001a\u00020\u00192\u0006\u0010W\u001a\u00020XJ&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u00102\u0006\u0010U\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\u0005H\u0002J\u0010\u0010[\u001a\u00020E2\u0006\u0010\\\u001a\u00020\u0014H\u0002J'\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00000\u00102\b\b\u0002\u0010U\u001a\u00020\u00052\b\b\u0002\u0010Z\u001a\u00020\u0005H\u0000¢\u0006\u0002\b]R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001eR\u0011\u0010\"\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001eR\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u0002008Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b1\u00102R\u001a\u00103\u001a\u0002008Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b4\u00102R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u00000\u00108@X\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0012R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u00000\u00108@X\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0012R\u0013\u00109\u001a\u0004\u0018\u00010:8F¢\u0006\u0006\u001a\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020>8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b?\u00102R\u0011\u0010@\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bA\u0010\fR\u0014\u0010B\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0016\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006^"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsNode;", "", "outerSemanticsNode", "Landroidx/compose/ui/node/SemanticsModifierNode;", "mergingEnabled", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/SemanticsModifierNode;ZLandroidx/compose/ui/node/LayoutNode;)V", "boundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "getBoundsInRoot", "()Landroidx/compose/ui/geometry/Rect;", "boundsInWindow", "getBoundsInWindow", "children", "", "getChildren", "()Ljava/util/List;", "config", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getConfig", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "fakeNodeParent", "id", "", "getId", "()I", "isFake", "isFake$ui_release", "()Z", "setFake$ui_release", "(Z)V", "isMergingSemanticsOfDescendants", "isRoot", "layoutInfo", "Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutNode$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "getMergingEnabled", "getOuterSemanticsNode$ui_release", "()Landroidx/compose/ui/node/SemanticsModifierNode;", "parent", "getParent", "()Landroidx/compose/ui/semantics/SemanticsNode;", "positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "getPositionInRoot-F1C5BW0", "()J", "positionInWindow", "getPositionInWindow-F1C5BW0", "replacedChildren", "getReplacedChildren$ui_release", "replacedChildrenSortedByBounds", "getReplacedChildrenSortedByBounds$ui_release", "root", "Landroidx/compose/ui/node/RootForTest;", "getRoot", "()Landroidx/compose/ui/node/RootForTest;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "touchBoundsInRoot", "getTouchBoundsInRoot", "unmergedConfig", "getUnmergedConfig$ui_release", "emitFakeNodes", "", "unmergedChildren", "", "fakeSemanticsNode", "role", "Landroidx/compose/ui/semantics/Role;", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "Lkotlin/ExtensionFunctionType;", "fakeSemanticsNode-ypyhhiA", "findCoordinatorToGetBounds", "Landroidx/compose/ui/node/NodeCoordinator;", "findCoordinatorToGetBounds$ui_release", "findOneLayerOfMergingSemanticsNodes", "list", "sortByBounds", "getAlignmentLinePosition", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "includeReplacedSemantics", "includeFakeNodes", "mergeConfig", "mergedConfig", "unmergedChildren$ui_release", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SemanticsNode {
    public static final int $stable = 8;
    @Nullable
    private SemanticsNode fakeNodeParent;

    /* renamed from: id  reason: collision with root package name */
    private final int f10119id;
    private boolean isFake;
    @NotNull
    private final LayoutNode layoutNode;
    private final boolean mergingEnabled;
    @NotNull
    private final SemanticsModifierNode outerSemanticsNode;
    @NotNull
    private final SemanticsConfiguration unmergedConfig;

    public SemanticsNode(@NotNull SemanticsModifierNode semanticsModifierNode, boolean z11, @NotNull LayoutNode layoutNode2) {
        Intrinsics.checkNotNullParameter(semanticsModifierNode, "outerSemanticsNode");
        Intrinsics.checkNotNullParameter(layoutNode2, "layoutNode");
        this.outerSemanticsNode = semanticsModifierNode;
        this.mergingEnabled = z11;
        this.layoutNode = layoutNode2;
        this.unmergedConfig = SemanticsModifierNodeKt.collapsedSemanticsConfiguration(semanticsModifierNode);
        this.f10119id = layoutNode2.getSemanticsId();
    }

    public static /* synthetic */ List a(SemanticsNode semanticsNode, List list, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = new ArrayList();
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return semanticsNode.findOneLayerOfMergingSemanticsNodes(list, z11);
    }

    private final void emitFakeNodes(List<SemanticsNode> list) {
        String str;
        Role access$getRole = SemanticsNodeKt.getRole(this);
        if (access$getRole != null && this.unmergedConfig.isMergingSemanticsOfDescendants() && (!list.isEmpty())) {
            list.add(m4917fakeSemanticsNodeypyhhiA(access$getRole, new SemanticsNode$emitFakeNodes$fakeNode$1(access$getRole)));
        }
        SemanticsConfiguration semanticsConfiguration = this.unmergedConfig;
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (semanticsConfiguration.contains(semanticsProperties.getContentDescription()) && (!list.isEmpty()) && this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            List list2 = (List) SemanticsConfigurationKt.getOrNull(this.unmergedConfig, semanticsProperties.getContentDescription());
            if (list2 != null) {
                str = (String) CollectionsKt___CollectionsKt.firstOrNull(list2);
            } else {
                str = null;
            }
            if (str != null) {
                list.add(0, m4917fakeSemanticsNodeypyhhiA((Role) null, new SemanticsNode$emitFakeNodes$fakeNode$2(str)));
            }
        }
    }

    /* renamed from: fakeSemanticsNode-ypyhhiA  reason: not valid java name */
    private final SemanticsNode m4917fakeSemanticsNodeypyhhiA(Role role, Function1<? super SemanticsPropertyReceiver, Unit> function1) {
        int i11;
        SemanticsNode$fakeSemanticsNode$fakeNode$1 semanticsNode$fakeSemanticsNode$fakeNode$1 = new SemanticsNode$fakeSemanticsNode$fakeNode$1(function1);
        if (role != null) {
            i11 = SemanticsNodeKt.roleFakeNodeId(this);
        } else {
            i11 = SemanticsNodeKt.contentDescriptionFakeNodeId(this);
        }
        SemanticsNode semanticsNode = new SemanticsNode(semanticsNode$fakeSemanticsNode$fakeNode$1, false, new LayoutNode(true, i11));
        semanticsNode.isFake = true;
        semanticsNode.fakeNodeParent = this;
        return semanticsNode;
    }

    private final List<SemanticsNode> findOneLayerOfMergingSemanticsNodes(List<SemanticsNode> list, boolean z11) {
        List unmergedChildren$ui_release$default = unmergedChildren$ui_release$default(this, z11, false, 2, (Object) null);
        int size = unmergedChildren$ui_release$default.size();
        for (int i11 = 0; i11 < size; i11++) {
            SemanticsNode semanticsNode = (SemanticsNode) unmergedChildren$ui_release$default.get(i11);
            if (semanticsNode.isMergingSemanticsOfDescendants()) {
                list.add(semanticsNode);
            } else if (!semanticsNode.unmergedConfig.isClearingSemantics()) {
                a(semanticsNode, list, false, 2, (Object) null);
            }
        }
        return list;
    }

    private final boolean isMergingSemanticsOfDescendants() {
        return this.mergingEnabled && this.unmergedConfig.isMergingSemanticsOfDescendants();
    }

    private final void mergeConfig(SemanticsConfiguration semanticsConfiguration) {
        if (!this.unmergedConfig.isClearingSemantics()) {
            List unmergedChildren$ui_release$default = unmergedChildren$ui_release$default(this, false, false, 3, (Object) null);
            int size = unmergedChildren$ui_release$default.size();
            for (int i11 = 0; i11 < size; i11++) {
                SemanticsNode semanticsNode = (SemanticsNode) unmergedChildren$ui_release$default.get(i11);
                if (!semanticsNode.isMergingSemanticsOfDescendants()) {
                    semanticsConfiguration.mergeChild$ui_release(semanticsNode.unmergedConfig);
                    semanticsNode.mergeConfig(semanticsConfiguration);
                }
            }
        }
    }

    public static /* synthetic */ List unmergedChildren$ui_release$default(SemanticsNode semanticsNode, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        if ((i11 & 2) != 0) {
            z12 = false;
        }
        return semanticsNode.unmergedChildren$ui_release(z11, z12);
    }

    @NotNull
    public final NodeCoordinator findCoordinatorToGetBounds$ui_release() {
        if (!this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            return DelegatableNodeKt.m4588requireCoordinator64DMado(this.outerSemanticsNode, Nodes.INSTANCE.m4766getSemanticsOLwlOKw());
        }
        SemanticsModifierNode outerMergingSemantics = SemanticsNodeKt.getOuterMergingSemantics(this.layoutNode);
        if (outerMergingSemantics == null) {
            outerMergingSemantics = this.outerSemanticsNode;
        }
        return DelegatableNodeKt.m4588requireCoordinator64DMado(outerMergingSemantics, Nodes.INSTANCE.m4766getSemanticsOLwlOKw());
    }

    public final int getAlignmentLinePosition(@NotNull AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return findCoordinatorToGetBounds$ui_release().get(alignmentLine);
    }

    @NotNull
    public final Rect getBoundsInRoot() {
        if (!this.layoutNode.isAttached()) {
            return Rect.Companion.getZero();
        }
        return LayoutCoordinatesKt.boundsInRoot(findCoordinatorToGetBounds$ui_release());
    }

    @NotNull
    public final Rect getBoundsInWindow() {
        if (!this.layoutNode.isAttached()) {
            return Rect.Companion.getZero();
        }
        return LayoutCoordinatesKt.boundsInWindow(findCoordinatorToGetBounds$ui_release());
    }

    @NotNull
    public final List<SemanticsNode> getChildren() {
        return getChildren(false, !this.mergingEnabled, false);
    }

    @NotNull
    public final SemanticsConfiguration getConfig() {
        if (!isMergingSemanticsOfDescendants()) {
            return this.unmergedConfig;
        }
        SemanticsConfiguration copy = this.unmergedConfig.copy();
        mergeConfig(copy);
        return copy;
    }

    public final int getId() {
        return this.f10119id;
    }

    @NotNull
    public final LayoutInfo getLayoutInfo() {
        return this.layoutNode;
    }

    @NotNull
    public final LayoutNode getLayoutNode$ui_release() {
        return this.layoutNode;
    }

    public final boolean getMergingEnabled() {
        return this.mergingEnabled;
    }

    @NotNull
    public final SemanticsModifierNode getOuterSemanticsNode$ui_release() {
        return this.outerSemanticsNode;
    }

    @Nullable
    public final SemanticsNode getParent() {
        LayoutNode layoutNode2;
        SemanticsModifierNode semanticsModifierNode;
        SemanticsNode semanticsNode = this.fakeNodeParent;
        if (semanticsNode != null) {
            return semanticsNode;
        }
        if (this.mergingEnabled) {
            layoutNode2 = SemanticsNodeKt.findClosestParentNode(this.layoutNode, SemanticsNode$parent$1.INSTANCE);
        } else {
            layoutNode2 = null;
        }
        if (layoutNode2 == null) {
            layoutNode2 = SemanticsNodeKt.findClosestParentNode(this.layoutNode, SemanticsNode$parent$2.INSTANCE);
        }
        if (layoutNode2 != null) {
            semanticsModifierNode = SemanticsNodeKt.getOuterSemantics(layoutNode2);
        } else {
            semanticsModifierNode = null;
        }
        if (semanticsModifierNode == null) {
            return null;
        }
        return new SemanticsNode(semanticsModifierNode, this.mergingEnabled, (LayoutNode) null, 4, (DefaultConstructorMarker) null);
    }

    /* renamed from: getPositionInRoot-F1C5BW0  reason: not valid java name */
    public final long m4918getPositionInRootF1C5BW0() {
        if (!this.layoutNode.isAttached()) {
            return Offset.Companion.m2692getZeroF1C5BW0();
        }
        return LayoutCoordinatesKt.positionInRoot(findCoordinatorToGetBounds$ui_release());
    }

    /* renamed from: getPositionInWindow-F1C5BW0  reason: not valid java name */
    public final long m4919getPositionInWindowF1C5BW0() {
        if (!this.layoutNode.isAttached()) {
            return Offset.Companion.m2692getZeroF1C5BW0();
        }
        return LayoutCoordinatesKt.positionInWindow(findCoordinatorToGetBounds$ui_release());
    }

    @NotNull
    public final List<SemanticsNode> getReplacedChildren$ui_release() {
        return getChildren(false, false, true);
    }

    @NotNull
    public final List<SemanticsNode> getReplacedChildrenSortedByBounds$ui_release() {
        return getChildren(true, false, true);
    }

    @Nullable
    public final RootForTest getRoot() {
        Owner owner$ui_release = this.layoutNode.getOwner$ui_release();
        if (owner$ui_release != null) {
            return owner$ui_release.getRootForTest();
        }
        return null;
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public final long m4920getSizeYbymL2g() {
        return findCoordinatorToGetBounds$ui_release().m4722getSizeYbymL2g();
    }

    @NotNull
    public final Rect getTouchBoundsInRoot() {
        SemanticsModifierNode semanticsModifierNode;
        if (this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            semanticsModifierNode = SemanticsNodeKt.getOuterMergingSemantics(this.layoutNode);
            if (semanticsModifierNode == null) {
                semanticsModifierNode = this.outerSemanticsNode;
            }
        } else {
            semanticsModifierNode = this.outerSemanticsNode;
        }
        return SemanticsModifierNodeKt.touchBoundsInRoot(semanticsModifierNode);
    }

    @NotNull
    public final SemanticsConfiguration getUnmergedConfig$ui_release() {
        return this.unmergedConfig;
    }

    public final boolean isFake$ui_release() {
        return this.isFake;
    }

    public final boolean isRoot() {
        return getParent() == null;
    }

    public final void setFake$ui_release(boolean z11) {
        this.isFake = z11;
    }

    @NotNull
    public final List<SemanticsNode> unmergedChildren$ui_release(boolean z11, boolean z12) {
        List list;
        if (this.isFake) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        if (z11) {
            list = SemanticsSortKt.findOneLayerOfSemanticsWrappersSortedByBounds$default(this.layoutNode, (List) null, 1, (Object) null);
        } else {
            list = SemanticsNodeKt.a(this.layoutNode, (List) null, 1, (Object) null);
        }
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(new SemanticsNode((SemanticsModifierNode) list.get(i11), this.mergingEnabled, (LayoutNode) null, 4, (DefaultConstructorMarker) null));
        }
        if (z12) {
            emitFakeNodes(arrayList);
        }
        return arrayList;
    }

    private final List<SemanticsNode> getChildren(boolean z11, boolean z12, boolean z13) {
        if (!z12 && this.unmergedConfig.isClearingSemantics()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (isMergingSemanticsOfDescendants()) {
            return a(this, (List) null, z11, 1, (Object) null);
        }
        return unmergedChildren$ui_release(z11, z13);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SemanticsNode(SemanticsModifierNode semanticsModifierNode, boolean z11, LayoutNode layoutNode2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(semanticsModifierNode, z11, (i11 & 4) != 0 ? DelegatableNodeKt.requireLayoutNode(semanticsModifierNode) : layoutNode2);
    }
}
