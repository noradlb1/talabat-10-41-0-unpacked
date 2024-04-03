package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyInputModifier;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002\u001a\u0012\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b*\u00020\u0004H\u0000\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\u0004*\u00020\u0004H\u0000\u001a\u000e\u0010\r\u001a\u0004\u0018\u00010\u0004*\u00020\u0004H\u0000\u001a\u000e\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\u0004H\u0000\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0004H\u0000\u001a=\u0010\u0011\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00030\u0017H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"invalidFocusDirection", "", "isEligibleForFocusSearch", "", "Landroidx/compose/ui/focus/FocusModifier;", "(Landroidx/compose/ui/focus/FocusModifier;)Z", "lastOf", "Landroidx/compose/ui/input/key/KeyInputModifier;", "one", "two", "activatedChildren", "Landroidx/compose/runtime/collection/MutableVector;", "findActiveFocusNode", "findActiveParent", "findLastKeyInputModifier", "focusRect", "Landroidx/compose/ui/geometry/Rect;", "focusSearch", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "onFound", "Lkotlin/Function1;", "focusSearch-sMXa3k8", "(Landroidx/compose/ui/focus/FocusModifier;ILandroidx/compose/ui/unit/LayoutDirection;Lkotlin/jvm/functions/Function1;)Z", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FocusTraversalKt {
    @NotNull
    private static final String invalidFocusDirection = "Invalid FocusDirection";

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Rtl.ordinal()] = 1;
            iArr[LayoutDirection.Ltr.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            iArr2[FocusStateImpl.Active.ordinal()] = 1;
            iArr2[FocusStateImpl.Captured.ordinal()] = 2;
            iArr2[FocusStateImpl.ActiveParent.ordinal()] = 3;
            iArr2[FocusStateImpl.DeactivatedParent.ordinal()] = 4;
            iArr2[FocusStateImpl.Inactive.ordinal()] = 5;
            iArr2[FocusStateImpl.Deactivated.ordinal()] = 6;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @NotNull
    public static final MutableVector<FocusModifier> activatedChildren(@NotNull FocusModifier focusModifier) {
        boolean z11;
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        MutableVector<FocusModifier> children = focusModifier.getChildren();
        int size = children.getSize();
        if (size > 0) {
            Object[] content = children.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            while (true) {
                if (!((FocusModifier) content[i11]).getFocusState().isDeactivated()) {
                    i11++;
                    if (i11 >= size) {
                        break;
                    }
                } else {
                    z11 = true;
                    break;
                }
            }
            z11 = false;
        } else {
            z11 = false;
        }
        if (!z11) {
            return focusModifier.getChildren();
        }
        MutableVector<FocusModifier> mutableVector = new MutableVector<>(new FocusModifier[16], 0);
        MutableVector<FocusModifier> children2 = focusModifier.getChildren();
        int size2 = children2.getSize();
        if (size2 > 0) {
            Object[] content2 = children2.getContent();
            Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i12 = 0;
            do {
                FocusModifier focusModifier2 = (FocusModifier) content2[i12];
                if (!focusModifier2.getFocusState().isDeactivated()) {
                    mutableVector.add(focusModifier2);
                } else {
                    FocusRequester invoke = focusModifier2.getFocusProperties().getEnter().invoke(FocusDirection.m2597boximpl(FocusDirection.Companion.m2609getEnterdhqQ8s()));
                    FocusRequester.Companion companion = FocusRequester.Companion;
                    if (Intrinsics.areEqual((Object) invoke, (Object) companion.getCancel())) {
                        return new MutableVector<>(new FocusModifier[16], 0);
                    }
                    if (Intrinsics.areEqual((Object) invoke, (Object) companion.getDefault())) {
                        mutableVector.addAll(mutableVector.getSize(), activatedChildren(focusModifier2));
                    } else {
                        MutableVector<FocusRequesterModifierLocal> focusRequesterModifierLocals$ui_release = invoke.getFocusRequesterModifierLocals$ui_release();
                        int size3 = focusRequesterModifierLocals$ui_release.getSize();
                        if (size3 > 0) {
                            Object[] content3 = focusRequesterModifierLocals$ui_release.getContent();
                            Intrinsics.checkNotNull(content3, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                            int i13 = 0;
                            do {
                                FocusModifier findFocusNode = ((FocusRequesterModifierLocal) content3[i13]).findFocusNode();
                                if (findFocusNode != null) {
                                    mutableVector.add(findFocusNode);
                                }
                                i13++;
                            } while (i13 < size3);
                        }
                    }
                }
                i12++;
            } while (i12 < size2);
        }
        return mutableVector;
    }

    @Nullable
    public static final FocusModifier findActiveFocusNode(@NotNull FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 2:
                return focusModifier;
            case 3:
            case 4:
                FocusModifier focusedChild = focusModifier.getFocusedChild();
                if (focusedChild != null) {
                    return findActiveFocusNode(focusedChild);
                }
                break;
            case 5:
            case 6:
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return null;
    }

    @Nullable
    public static final FocusModifier findActiveParent(@NotNull FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        FocusModifier parent = focusModifier.getParent();
        if (parent == null) {
            return null;
        }
        switch (WhenMappings.$EnumSwitchMapping$1[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
                return findActiveParent(parent);
            case 3:
                return focusModifier;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Nullable
    public static final KeyInputModifier findLastKeyInputModifier(@NotNull FocusModifier focusModifier) {
        LayoutNode layoutNode;
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        NodeCoordinator coordinator = focusModifier.getCoordinator();
        KeyInputModifier keyInputModifier = null;
        if (coordinator == null || (layoutNode = coordinator.getLayoutNode()) == null) {
            return null;
        }
        MutableVector<KeyInputModifier> keyInputChildren = focusModifier.getKeyInputChildren();
        int size = keyInputChildren.getSize();
        if (size > 0) {
            Object[] content = keyInputChildren.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                KeyInputModifier keyInputModifier2 = (KeyInputModifier) content[i11];
                if (Intrinsics.areEqual((Object) keyInputModifier2.getLayoutNode(), (Object) layoutNode)) {
                    keyInputModifier = lastOf(keyInputModifier2, keyInputModifier);
                }
                i11++;
            } while (i11 < size);
        }
        if (keyInputModifier != null) {
            return keyInputModifier;
        }
        return focusModifier.getKeyInputModifier();
    }

    @NotNull
    public static final Rect focusRect(@NotNull FocusModifier focusModifier) {
        Rect localBoundingBoxOf;
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        NodeCoordinator coordinator = focusModifier.getCoordinator();
        if (coordinator == null || (localBoundingBoxOf = LayoutCoordinatesKt.findRootCoordinates(coordinator).localBoundingBoxOf(coordinator, false)) == null) {
            return Rect.Companion.getZero();
        }
        return localBoundingBoxOf;
    }

    /* renamed from: focusSearch-sMXa3k8  reason: not valid java name */
    public static final boolean m2628focusSearchsMXa3k8(@NotNull FocusModifier focusModifier, int i11, @NotNull LayoutDirection layoutDirection, @NotNull Function1<? super FocusModifier, Boolean> function1) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        FocusModifier focusModifier2;
        int i12;
        Intrinsics.checkNotNullParameter(focusModifier, "$this$focusSearch");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(function1, "onFound");
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2600equalsimpl0(i11, companion.m2613getNextdhqQ8s())) {
            z11 = true;
        } else {
            z11 = FocusDirection.m2600equalsimpl0(i11, companion.m2615getPreviousdhqQ8s());
        }
        if (z11) {
            return OneDimensionalFocusSearchKt.m2631oneDimensionalFocusSearchOMvw8(focusModifier, i11, function1);
        }
        if (FocusDirection.m2600equalsimpl0(i11, companion.m2612getLeftdhqQ8s())) {
            z12 = true;
        } else {
            z12 = FocusDirection.m2600equalsimpl0(i11, companion.m2616getRightdhqQ8s());
        }
        if (z12) {
            z13 = true;
        } else {
            z13 = FocusDirection.m2600equalsimpl0(i11, companion.m2617getUpdhqQ8s());
        }
        if (z13) {
            z14 = true;
        } else {
            z14 = FocusDirection.m2600equalsimpl0(i11, companion.m2608getDowndhqQ8s());
        }
        if (z14) {
            return TwoDimensionalFocusSearchKt.m2641twoDimensionalFocusSearchOMvw8(focusModifier, i11, function1);
        }
        if (FocusDirection.m2600equalsimpl0(i11, companion.m2609getEnterdhqQ8s())) {
            int i13 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i13 == 1) {
                i12 = companion.m2612getLeftdhqQ8s();
            } else if (i13 == 2) {
                i12 = companion.m2616getRightdhqQ8s();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            FocusModifier findActiveFocusNode = findActiveFocusNode(focusModifier);
            if (findActiveFocusNode != null) {
                return TwoDimensionalFocusSearchKt.m2641twoDimensionalFocusSearchOMvw8(findActiveFocusNode, i12, function1);
            }
        } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2610getExitdhqQ8s())) {
            FocusModifier findActiveFocusNode2 = findActiveFocusNode(focusModifier);
            if (findActiveFocusNode2 != null) {
                focusModifier2 = findActiveParent(findActiveFocusNode2);
            } else {
                focusModifier2 = null;
            }
            if (!Intrinsics.areEqual((Object) focusModifier2, (Object) focusModifier) && focusModifier2 != null) {
                return function1.invoke(focusModifier2).booleanValue();
            }
        } else {
            throw new IllegalStateException(invalidFocusDirection.toString());
        }
        return false;
    }

    public static final boolean isEligibleForFocusSearch(@NotNull FocusModifier focusModifier) {
        boolean z11;
        boolean z12;
        LayoutNode layoutNode;
        LayoutNode layoutNode2;
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        NodeCoordinator coordinator = focusModifier.getCoordinator();
        if (coordinator == null || (layoutNode2 = coordinator.getLayoutNode()) == null || !layoutNode2.isPlaced()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            NodeCoordinator coordinator2 = focusModifier.getCoordinator();
            if (coordinator2 == null || (layoutNode = coordinator2.getLayoutNode()) == null || !layoutNode.isAttached()) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final androidx.compose.ui.input.key.KeyInputModifier lastOf(androidx.compose.ui.input.key.KeyInputModifier r3, androidx.compose.ui.input.key.KeyInputModifier r4) {
        /*
            if (r4 != 0) goto L_0x0003
            return r3
        L_0x0003:
            androidx.compose.ui.node.LayoutNode r0 = r3.getLayoutNode()
            r1 = r4
        L_0x0008:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r2 != 0) goto L_0x001f
            androidx.compose.ui.input.key.KeyInputModifier r1 = r1.getParent()
            if (r1 == 0) goto L_0x001e
            androidx.compose.ui.node.LayoutNode r2 = r1.getLayoutNode()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r0)
            if (r2 != 0) goto L_0x0008
        L_0x001e:
            return r3
        L_0x001f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTraversalKt.lastOf(androidx.compose.ui.input.key.KeyInputModifier, androidx.compose.ui.input.key.KeyInputModifier):androidx.compose.ui.input.key.KeyInputModifier");
    }
}
