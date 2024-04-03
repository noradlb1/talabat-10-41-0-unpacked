package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BuildDrawCacheParams;
import androidx.compose.ui.draw.DrawCacheModifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusOrderModifierToProperties;
import androidx.compose.ui.focus.FocusPropertiesModifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.layout.IntermediateLayoutModifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.LookaheadOnPlacedModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.modifier.BackwardsCompatLocalMap;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalNode;
import androidx.compose.ui.modifier.ModifierLocalNodeKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.HashSet;
import k0.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\rB\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u001eH\u0002J\b\u0010G\u001a\u00020\u001eH\u0016J\b\u0010H\u001a\u00020EH\u0016J\b\u0010I\u001a\u00020EH\u0016J\b\u0010J\u001a\u00020EH\u0016J\r\u0010K\u001a\u00020EH\u0000¢\u0006\u0002\bLJ\u0010\u0010M\u001a\u00020E2\u0006\u0010N\u001a\u00020\"H\u0016J\u0010\u0010O\u001a\u00020E2\u0006\u0010N\u001a\u00020PH\u0016J\b\u0010Q\u001a\u00020EH\u0016J\u0010\u0010R\u001a\u00020E2\u0006\u0010N\u001a\u00020\"H\u0016J-\u0010S\u001a\u00020E2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020;H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ\u001d\u0010[\u001a\u00020E2\u0006\u00107\u001a\u00020;H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\\\u0010?J\b\u0010]\u001a\u00020\u001eH\u0016J\b\u0010^\u001a\u00020_H\u0016J\b\u0010`\u001a\u00020EH\u0002J\b\u0010a\u001a\u00020EH\u0002J\u0006\u0010b\u001a\u00020EJ\u0006\u0010c\u001a\u00020EJ\u0012\u0010d\u001a\u00020E2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030eJ\f\u0010f\u001a\u00020E*\u00020gH\u0016J\u001c\u0010h\u001a\u00020i*\u00020j2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020iH\u0016J\u001c\u0010n\u001a\u00020i*\u00020j2\u0006\u0010k\u001a\u00020l2\u0006\u0010o\u001a\u00020iH\u0016J)\u0010p\u001a\u00020q*\u00020r2\u0006\u0010k\u001a\u00020s2\u0006\u0010t\u001a\u00020uH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bv\u0010wJ\u001c\u0010x\u001a\u00020i*\u00020j2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020iH\u0016J\u001c\u0010y\u001a\u00020i*\u00020j2\u0006\u0010k\u001a\u00020l2\u0006\u0010o\u001a\u00020iH\u0016J\u0018\u0010z\u001a\u0004\u0018\u00010{*\u00020\u00142\b\u0010|\u001a\u0004\u0018\u00010{H\u0016R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u0010R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R2\u0010+\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030-0,j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030-`.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0014\u00103\u001a\u0002048VX\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u001d\u00107\u001a\u0002088VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b9\u0010:R-\u0010<\u001a\u00020;2\u0006\u0010\u0017\u001a\u00020;8V@VX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u001a\u0004\b=\u0010:\"\u0004\b>\u0010?R$\u0010@\u001a\u0002HA\"\u0004\b\u0000\u0010A*\b\u0012\u0004\u0012\u0002HA0-8VX\u0004¢\u0006\u0006\u001a\u0004\bB\u0010C\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006}"}, d2 = {"Landroidx/compose/ui/node/BackwardsCompatNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/IntermediateLayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalNode;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "Landroidx/compose/ui/Modifier$Node;", "element", "Landroidx/compose/ui/Modifier$Element;", "(Landroidx/compose/ui/Modifier$Element;)V", "_providedValues", "Landroidx/compose/ui/modifier/BackwardsCompatLocalMap;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "value", "getElement", "()Landroidx/compose/ui/Modifier$Element;", "setElement", "focusOrderElement", "Landroidx/compose/ui/focus/FocusPropertiesModifier;", "invalidateCache", "", "isValid", "()Z", "lastOnPlacedCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "readValues", "Ljava/util/HashSet;", "Landroidx/compose/ui/modifier/ModifierLocal;", "Lkotlin/collections/HashSet;", "getReadValues", "()Ljava/util/HashSet;", "setReadValues", "(Ljava/util/HashSet;)V", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getSemanticsConfiguration", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "Landroidx/compose/ui/unit/IntSize;", "targetSize", "getTargetSize-YbymL2g", "setTargetSize-ozmzZPI", "(J)V", "current", "T", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "initializeModifier", "", "duringAttach", "interceptOutOfBoundsChildEvents", "onAttach", "onCancelPointerInput", "onDetach", "onDrawCacheReadsChanged", "onDrawCacheReadsChanged$ui_release", "onGloballyPositioned", "coordinates", "onLookaheadPlaced", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "onMeasureResultChanged", "onPlaced", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onRemeasured", "onRemeasured-ozmzZPI", "sharePointerInputWithSiblings", "toString", "", "uninitializeModifier", "updateDrawCache", "updateFocusOrderModifierLocalConsumer", "updateModifierLocalConsumer", "updateModifierLocalProvider", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "modifyParentData", "", "parentData", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BackwardsCompatNode extends Modifier.Node implements LayoutModifierNode, IntermediateLayoutModifierNode, DrawModifierNode, SemanticsModifierNode, PointerInputModifierNode, ModifierLocalNode, ModifierLocalReadScope, ParentDataModifierNode, LayoutAwareModifierNode, GlobalPositionAwareModifierNode, OwnerScope, BuildDrawCacheParams {
    @Nullable
    private BackwardsCompatLocalMap _providedValues;
    @NotNull
    private Modifier.Element element;
    /* access modifiers changed from: private */
    @Nullable
    public FocusPropertiesModifier focusOrderElement;
    private boolean invalidateCache = true;
    /* access modifiers changed from: private */
    @Nullable
    public LayoutCoordinates lastOnPlacedCoordinates;
    @NotNull
    private HashSet<ModifierLocal<?>> readValues = new HashSet<>();

    public BackwardsCompatNode(@NotNull Modifier.Element element2) {
        Intrinsics.checkNotNullParameter(element2, "element");
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(element2));
        this.element = element2;
    }

    private final void initializeModifier(boolean z11) {
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        Function1 function1;
        if (isAttached()) {
            Modifier.Element element2 = this.element;
            Nodes nodes = Nodes.INSTANCE;
            boolean z18 = false;
            if ((nodes.m4763getLocalsOLwlOKw() & getKindSet$ui_release()) != 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (element2 instanceof ModifierLocalProvider) {
                    updateModifierLocalProvider((ModifierLocalProvider) element2);
                }
                if (element2 instanceof ModifierLocalConsumer) {
                    if (z11) {
                        updateModifierLocalConsumer();
                    } else {
                        sideEffect(new BackwardsCompatNode$initializeModifier$1(this));
                    }
                }
                if (element2 instanceof FocusOrderModifier) {
                    FocusOrderModifierToProperties focusOrderModifierToProperties = new FocusOrderModifierToProperties((FocusOrderModifier) element2);
                    if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
                        function1 = new BackwardsCompatNode$initializeModifier$$inlined$debugInspectorInfo$1(focusOrderModifierToProperties);
                    } else {
                        function1 = InspectableValueKt.getNoInspectorInfo();
                    }
                    FocusPropertiesModifier focusPropertiesModifier = new FocusPropertiesModifier(focusOrderModifierToProperties, function1);
                    this.focusOrderElement = focusPropertiesModifier;
                    Intrinsics.checkNotNull(focusPropertiesModifier);
                    updateModifierLocalProvider(focusPropertiesModifier);
                    if (z11) {
                        updateFocusOrderModifierLocalConsumer();
                    } else {
                        sideEffect(new BackwardsCompatNode$initializeModifier$3(this));
                    }
                }
            }
            if ((nodes.m4758getDrawOLwlOKw() & getKindSet$ui_release()) != 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z13) {
                if (element2 instanceof DrawCacheModifier) {
                    this.invalidateCache = true;
                }
                LayoutModifierNodeKt.invalidateLayer(this);
            }
            if ((nodes.m4761getLayoutOLwlOKw() & getKindSet$ui_release()) != 0) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (z14) {
                if (DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release().getTail$ui_release().isAttached()) {
                    NodeCoordinator coordinator$ui_release = getCoordinator$ui_release();
                    Intrinsics.checkNotNull(coordinator$ui_release);
                    ((LayoutModifierNodeCoordinator) coordinator$ui_release).setLayoutModifierNode$ui_release(this);
                    coordinator$ui_release.onLayoutModifierNodeChanged();
                }
                LayoutModifierNodeKt.invalidateLayer(this);
                DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
            }
            if (element2 instanceof RemeasurementModifier) {
                ((RemeasurementModifier) element2).onRemeasurementAvailable(this);
            }
            if ((nodes.m4762getLayoutAwareOLwlOKw() & getKindSet$ui_release()) != 0) {
                z15 = true;
            } else {
                z15 = false;
            }
            if (z15) {
                if ((element2 instanceof OnRemeasuredModifier) && DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release().getTail$ui_release().isAttached()) {
                    DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
                }
                if (element2 instanceof OnPlacedModifier) {
                    this.lastOnPlacedCoordinates = null;
                    if (DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release().getTail$ui_release().isAttached()) {
                        DelegatableNodeKt.requireOwner(this).registerOnLayoutCompletedListener(new BackwardsCompatNode$initializeModifier$4(this));
                    }
                }
            }
            if ((nodes.m4759getGlobalPositionAwareOLwlOKw() & getKindSet$ui_release()) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && (element2 instanceof OnGloballyPositionedModifier) && DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release().getTail$ui_release().isAttached()) {
                DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
            }
            if ((nodes.m4765getPointerInputOLwlOKw() & getKindSet$ui_release()) != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 && (element2 instanceof PointerInputModifier)) {
                ((PointerInputModifier) element2).getPointerInputFilter().setLayoutCoordinates$ui_release(getCoordinator$ui_release());
            }
            if ((nodes.m4766getSemanticsOLwlOKw() & getKindSet$ui_release()) != 0) {
                z18 = true;
            }
            if (z18) {
                DelegatableNodeKt.requireOwner(this).onSemanticsChange();
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final void uninitializeModifier() {
        boolean z11;
        FocusPropertiesModifier focusPropertiesModifier;
        if (isAttached()) {
            Modifier.Element element2 = this.element;
            Nodes nodes = Nodes.INSTANCE;
            boolean z12 = true;
            if ((nodes.m4763getLocalsOLwlOKw() & getKindSet$ui_release()) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (element2 instanceof ModifierLocalProvider) {
                    DelegatableNodeKt.requireOwner(this).getModifierLocalManager().removedProvider(this, ((ModifierLocalProvider) element2).getKey());
                }
                if (element2 instanceof ModifierLocalConsumer) {
                    ((ModifierLocalConsumer) element2).onModifierLocalsUpdated(BackwardsCompatNodeKt.DetachedModifierLocalReadScope);
                }
                if ((element2 instanceof FocusOrderModifier) && (focusPropertiesModifier = this.focusOrderElement) != null) {
                    DelegatableNodeKt.requireOwner(this).getModifierLocalManager().removedProvider(this, focusPropertiesModifier.getKey());
                }
            }
            if ((nodes.m4766getSemanticsOLwlOKw() & getKindSet$ui_release()) == 0) {
                z12 = false;
            }
            if (z12) {
                DelegatableNodeKt.requireOwner(this).onSemanticsChange();
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final void updateDrawCache() {
        Modifier.Element element2 = this.element;
        if (element2 instanceof DrawCacheModifier) {
            DelegatableNodeKt.requireOwner(this).getSnapshotObserver().observeReads$ui_release(this, BackwardsCompatNodeKt.onDrawCacheReadsChanged, new BackwardsCompatNode$updateDrawCache$1(element2, this));
        }
        this.invalidateCache = false;
    }

    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.draw.DrawModifier");
        DrawModifier drawModifier = (DrawModifier) element2;
        if (this.invalidateCache && (element2 instanceof DrawCacheModifier)) {
            updateDrawCache();
        }
        drawModifier.draw(contentDrawScope);
    }

    public /* synthetic */ void forceRemeasure() {
        a.a(this);
    }

    public <T> T getCurrent(@NotNull ModifierLocal<T> modifierLocal) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(modifierLocal, "<this>");
        this.readValues.add(modifierLocal);
        int r02 = Nodes.INSTANCE.m4763getLocalsOLwlOKw();
        if (getNode().isAttached()) {
            Modifier.Node parent$ui_release = getNode().getParent$ui_release();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(this);
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r02) != 0) {
                    while (parent$ui_release != null) {
                        if ((parent$ui_release.getKindSet$ui_release() & r02) != 0 && (parent$ui_release instanceof ModifierLocalNode)) {
                            ModifierLocalNode modifierLocalNode = (ModifierLocalNode) parent$ui_release;
                            if (modifierLocalNode.getProvidedValues().contains$ui_release(modifierLocal)) {
                                return modifierLocalNode.getProvidedValues().get$ui_release(modifierLocal);
                            }
                        }
                        parent$ui_release = parent$ui_release.getParent$ui_release();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                if (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) {
                    parent$ui_release = null;
                } else {
                    parent$ui_release = nodes$ui_release.getTail$ui_release();
                }
            }
            return modifierLocal.getDefaultFactory$ui_release().invoke();
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @NotNull
    public Density getDensity() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity();
    }

    @NotNull
    public final Modifier.Element getElement() {
        return this.element;
    }

    @NotNull
    public LayoutDirection getLayoutDirection() {
        return DelegatableNodeKt.requireLayoutNode(this).getLayoutDirection();
    }

    @NotNull
    public ModifierLocalMap getProvidedValues() {
        BackwardsCompatLocalMap backwardsCompatLocalMap = this._providedValues;
        return backwardsCompatLocalMap != null ? backwardsCompatLocalMap : ModifierLocalNodeKt.modifierLocalMapOf();
    }

    @NotNull
    public final HashSet<ModifierLocal<?>> getReadValues() {
        return this.readValues;
    }

    @NotNull
    public SemanticsConfiguration getSemanticsConfiguration() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsModifier");
        return ((SemanticsModifier) element2).getSemanticsConfiguration();
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public long m4568getSizeNHjbRc() {
        return IntSizeKt.m5648toSizeozmzZPI(DelegatableNodeKt.m4588requireCoordinator64DMado(this, Nodes.INSTANCE.m4762getLayoutAwareOLwlOKw()).m4722getSizeYbymL2g());
    }

    /* renamed from: getTargetSize-YbymL2g  reason: not valid java name */
    public long m4569getTargetSizeYbymL2g() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.IntermediateLayoutModifier");
        return ((IntermediateLayoutModifier) element2).m4459getTargetSizeYbymL2g();
    }

    public boolean interceptOutOfBoundsChildEvents() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((PointerInputModifier) element2).getPointerInputFilter().getInterceptOutOfBoundsChildEvents();
    }

    public boolean isValid() {
        return isAttached();
    }

    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).maxIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).maxIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m4570measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).m4481measure3p2s80s(measureScope, measurable, j11);
    }

    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).minIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).minIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    @Nullable
    public Object modifyParentData(@NotNull Density density, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.ParentDataModifier");
        return ((ParentDataModifier) element2).modifyParentData(density, obj);
    }

    public void onAttach() {
        initializeModifier(true);
    }

    public void onCancelPointerInput() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((PointerInputModifier) element2).getPointerInputFilter().onCancel();
    }

    public void onDetach() {
        uninitializeModifier();
    }

    public final void onDrawCacheReadsChanged$ui_release() {
        this.invalidateCache = true;
        DrawModifierNodeKt.requestDraw(this);
    }

    public void onGloballyPositioned(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.OnGloballyPositionedModifier");
        ((OnGloballyPositionedModifier) element2).onGloballyPositioned(layoutCoordinates);
    }

    public void onLookaheadPlaced(@NotNull LookaheadLayoutCoordinates lookaheadLayoutCoordinates) {
        Intrinsics.checkNotNullParameter(lookaheadLayoutCoordinates, "coordinates");
        Modifier.Element element2 = this.element;
        if (element2 instanceof LookaheadOnPlacedModifier) {
            ((LookaheadOnPlacedModifier) element2).onPlaced(lookaheadLayoutCoordinates);
        }
    }

    public void onMeasureResultChanged() {
        this.invalidateCache = true;
        DrawModifierNodeKt.requestDraw(this);
    }

    public void onPlaced(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        this.lastOnPlacedCoordinates = layoutCoordinates;
        Modifier.Element element2 = this.element;
        if (element2 instanceof OnPlacedModifier) {
            ((OnPlacedModifier) element2).onPlaced(layoutCoordinates);
        }
    }

    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void m4571onPointerEventH0pRuoY(@NotNull PointerEvent pointerEvent, @NotNull PointerEventPass pointerEventPass, long j11) {
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pointerEventPass, "pass");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((PointerInputModifier) element2).getPointerInputFilter().m4327onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j11);
    }

    /* renamed from: onRemeasured-ozmzZPI  reason: not valid java name */
    public void m4572onRemeasuredozmzZPI(long j11) {
        Modifier.Element element2 = this.element;
        if (element2 instanceof OnRemeasuredModifier) {
            ((OnRemeasuredModifier) element2).m4525onRemeasuredozmzZPI(j11);
        }
    }

    public /* synthetic */ void provide(ModifierLocal modifierLocal, Object obj) {
        b.c(this, modifierLocal, obj);
    }

    public final void setElement(@NotNull Modifier.Element element2) {
        Intrinsics.checkNotNullParameter(element2, "value");
        if (isAttached()) {
            uninitializeModifier();
        }
        this.element = element2;
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(element2));
        if (isAttached()) {
            initializeModifier(false);
        }
    }

    public final void setReadValues(@NotNull HashSet<ModifierLocal<?>> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
        this.readValues = hashSet;
    }

    /* renamed from: setTargetSize-ozmzZPI  reason: not valid java name */
    public void m4573setTargetSizeozmzZPI(long j11) {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.IntermediateLayoutModifier");
        ((IntermediateLayoutModifier) element2).m4460setTargetSizeozmzZPI(j11);
    }

    public boolean sharePointerInputWithSiblings() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((PointerInputModifier) element2).getPointerInputFilter().getShareWithSiblings();
    }

    @NotNull
    public String toString() {
        return this.element.toString();
    }

    public final void updateFocusOrderModifierLocalConsumer() {
        if (isAttached()) {
            DelegatableNodeKt.requireOwner(this).getSnapshotObserver().observeReads$ui_release(this, BackwardsCompatNodeKt.updateFocusOrderModifierLocalConsumer, new BackwardsCompatNode$updateFocusOrderModifierLocalConsumer$1(this));
        }
    }

    public final void updateModifierLocalConsumer() {
        if (isAttached()) {
            this.readValues.clear();
            DelegatableNodeKt.requireOwner(this).getSnapshotObserver().observeReads$ui_release(this, BackwardsCompatNodeKt.updateModifierLocalConsumer, new BackwardsCompatNode$updateModifierLocalConsumer$1(this));
        }
    }

    public final void updateModifierLocalProvider(@NotNull ModifierLocalProvider<?> modifierLocalProvider) {
        Intrinsics.checkNotNullParameter(modifierLocalProvider, "element");
        BackwardsCompatLocalMap backwardsCompatLocalMap = this._providedValues;
        if (backwardsCompatLocalMap == null || !backwardsCompatLocalMap.contains$ui_release(modifierLocalProvider.getKey())) {
            this._providedValues = new BackwardsCompatLocalMap(modifierLocalProvider);
            if (DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release().getTail$ui_release().isAttached()) {
                DelegatableNodeKt.requireOwner(this).getModifierLocalManager().insertedProvider(this, modifierLocalProvider.getKey());
                return;
            }
            return;
        }
        backwardsCompatLocalMap.setElement(modifierLocalProvider);
        DelegatableNodeKt.requireOwner(this).getModifierLocalManager().updatedProvider(this, modifierLocalProvider.getKey());
    }
}
