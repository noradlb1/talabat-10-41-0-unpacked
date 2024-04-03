package androidx.compose.ui.focus;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0002H\u0002\u001a\u0016\u0010\u0006\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\t\u001a\u00020\u0004*\u00020\u0002H\u0000\u001a\f\u0010\n\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0014\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002\u001a\f\u0010\u000f\u001a\u00020\u0004*\u00020\u0002H\u0002\u001a\f\u0010\u0010\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0011"}, d2 = {"activateNode", "", "Landroidx/compose/ui/focus/FocusModifier;", "captureFocus", "", "clearChildFocus", "clearFocus", "forcedClear", "deactivateNode", "freeFocus", "grantFocus", "grantFocusToChild", "childNode", "requestFocus", "requestFocusForChild", "requestFocusForOwner", "sendOnFocusEvent", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FocusTransactionsKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.Captured.ordinal()] = 2;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 4;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void activateNode(@NotNull FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        int i11 = WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()];
        if (i11 == 4) {
            focusModifier.setFocusState(FocusStateImpl.Inactive);
        } else if (i11 == 5) {
            focusModifier.setFocusState(FocusStateImpl.ActiveParent);
        }
    }

    public static final boolean captureFocus(@NotNull FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
                focusModifier.setFocusState(FocusStateImpl.Captured);
                return true;
            case 2:
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final boolean clearChildFocus(FocusModifier focusModifier) {
        FocusModifier focusedChild = focusModifier.getFocusedChild();
        if (focusedChild == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        } else if (!clearFocus$default(focusedChild, false, 1, (Object) null)) {
            return false;
        } else {
            focusModifier.setFocusedChild((FocusModifier) null);
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean clearFocus(@org.jetbrains.annotations.NotNull androidx.compose.ui.focus.FocusModifier r3, boolean r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            androidx.compose.ui.focus.FocusStateImpl r0 = r3.getFocusState()
            int[] r1 = androidx.compose.ui.focus.FocusTransactionsKt.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 0
            r2 = 1
            switch(r0) {
                case 1: goto L_0x003e;
                case 2: goto L_0x0036;
                case 3: goto L_0x0028;
                case 4: goto L_0x0043;
                case 5: goto L_0x001c;
                case 6: goto L_0x0043;
                default: goto L_0x0016;
            }
        L_0x0016:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        L_0x001c:
            boolean r4 = clearChildFocus(r3)
            if (r4 == 0) goto L_0x0034
            androidx.compose.ui.focus.FocusStateImpl r4 = androidx.compose.ui.focus.FocusStateImpl.Deactivated
            r3.setFocusState(r4)
            goto L_0x0043
        L_0x0028:
            boolean r4 = clearChildFocus(r3)
            if (r4 == 0) goto L_0x0034
            androidx.compose.ui.focus.FocusStateImpl r4 = androidx.compose.ui.focus.FocusStateImpl.Inactive
            r3.setFocusState(r4)
            goto L_0x0043
        L_0x0034:
            r4 = r1
            goto L_0x0044
        L_0x0036:
            if (r4 == 0) goto L_0x0044
            androidx.compose.ui.focus.FocusStateImpl r0 = androidx.compose.ui.focus.FocusStateImpl.Inactive
            r3.setFocusState(r0)
            goto L_0x0044
        L_0x003e:
            androidx.compose.ui.focus.FocusStateImpl r4 = androidx.compose.ui.focus.FocusStateImpl.Inactive
            r3.setFocusState(r4)
        L_0x0043:
            r4 = r2
        L_0x0044:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTransactionsKt.clearFocus(androidx.compose.ui.focus.FocusModifier, boolean):boolean");
    }

    public static /* synthetic */ boolean clearFocus$default(FocusModifier focusModifier, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        return clearFocus(focusModifier, z11);
    }

    public static final void deactivateNode(@NotNull FocusModifier focusModifier) {
        LayoutNode layoutNode;
        Owner owner$ui_release;
        FocusManager focusManager;
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        int i11 = WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()];
        if (i11 == 1 || i11 == 2) {
            NodeCoordinator coordinator = focusModifier.getCoordinator();
            if (!(coordinator == null || (layoutNode = coordinator.getLayoutNode()) == null || (owner$ui_release = layoutNode.getOwner$ui_release()) == null || (focusManager = owner$ui_release.getFocusManager()) == null)) {
                focusManager.clearFocus(true);
            }
            focusModifier.setFocusState(FocusStateImpl.Deactivated);
        } else if (i11 == 3) {
            focusModifier.setFocusState(FocusStateImpl.DeactivatedParent);
        } else if (i11 == 6) {
            focusModifier.setFocusState(FocusStateImpl.Deactivated);
        }
    }

    public static final boolean freeFocus(@NotNull FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
                return true;
            case 2:
                focusModifier.setFocusState(FocusStateImpl.Active);
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final void grantFocus(FocusModifier focusModifier) {
        FocusStateImpl focusStateImpl;
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 3:
            case 6:
                focusStateImpl = FocusStateImpl.Active;
                break;
            case 2:
                focusStateImpl = FocusStateImpl.Captured;
                break;
            case 4:
            case 5:
                throw new IllegalStateException("Granting focus to a deactivated node.".toString());
            default:
                throw new NoWhenBranchMatchedException();
        }
        focusModifier.setFocusState(focusStateImpl);
    }

    private static final boolean grantFocusToChild(FocusModifier focusModifier, FocusModifier focusModifier2) {
        focusModifier.setFocusedChild(focusModifier2);
        grantFocus(focusModifier2);
        return true;
    }

    public static final void requestFocus(@NotNull FocusModifier focusModifier) {
        Owner owner;
        LayoutNode layoutNode;
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        NodeCoordinator coordinator = focusModifier.getCoordinator();
        if (coordinator == null || (layoutNode = coordinator.getLayoutNode()) == null) {
            owner = null;
        } else {
            owner = layoutNode.getOwner$ui_release();
        }
        if (owner == null) {
            focusModifier.setFocusRequestedOnPlaced(true);
            return;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 2:
                sendOnFocusEvent(focusModifier);
                return;
            case 3:
                if (clearChildFocus(focusModifier)) {
                    grantFocus(focusModifier);
                    return;
                }
                return;
            case 4:
            case 5:
                TwoDimensionalFocusSearchKt.m2637findChildCorrespondingToFocusEnterOMvw8(focusModifier, FocusDirection.Companion.m2609getEnterdhqQ8s(), FocusTransactionsKt$requestFocus$1.INSTANCE);
                return;
            case 6:
                FocusModifier parent = focusModifier.getParent();
                if (parent != null) {
                    requestFocusForChild(parent, focusModifier);
                    return;
                } else if (requestFocusForOwner(focusModifier)) {
                    grantFocus(focusModifier);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    private static final boolean requestFocusForChild(FocusModifier focusModifier, FocusModifier focusModifier2) {
        if (focusModifier.getChildren().contains(focusModifier2)) {
            switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
                case 1:
                    focusModifier.setFocusState(FocusStateImpl.ActiveParent);
                    return grantFocusToChild(focusModifier, focusModifier2);
                case 2:
                    return false;
                case 3:
                    if (clearChildFocus(focusModifier)) {
                        return grantFocusToChild(focusModifier, focusModifier2);
                    }
                    return false;
                case 4:
                    activateNode(focusModifier);
                    boolean requestFocusForChild = requestFocusForChild(focusModifier, focusModifier2);
                    deactivateNode(focusModifier);
                    return requestFocusForChild;
                case 5:
                    if (focusModifier.getFocusedChild() == null) {
                        return grantFocusToChild(focusModifier, focusModifier2);
                    }
                    if (clearChildFocus(focusModifier)) {
                        return grantFocusToChild(focusModifier, focusModifier2);
                    }
                    return false;
                case 6:
                    FocusModifier parent = focusModifier.getParent();
                    if (parent == null && requestFocusForOwner(focusModifier)) {
                        focusModifier.setFocusState(FocusStateImpl.Active);
                        return requestFocusForChild(focusModifier, focusModifier2);
                    } else if (parent == null || !requestFocusForChild(parent, focusModifier)) {
                        return false;
                    } else {
                        return requestFocusForChild(focusModifier, focusModifier2);
                    }
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else {
            throw new IllegalStateException("Non child node cannot request focus.".toString());
        }
    }

    private static final boolean requestFocusForOwner(FocusModifier focusModifier) {
        LayoutNode layoutNode;
        Owner owner$ui_release;
        NodeCoordinator coordinator = focusModifier.getCoordinator();
        if (coordinator != null && (layoutNode = coordinator.getLayoutNode()) != null && (owner$ui_release = layoutNode.getOwner$ui_release()) != null) {
            return owner$ui_release.requestFocus();
        }
        throw new IllegalStateException("Owner not initialized.".toString());
    }

    public static final void sendOnFocusEvent(@NotNull FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        FocusEventModifierLocal focusEventListener = focusModifier.getFocusEventListener();
        if (focusEventListener != null) {
            focusEventListener.propagateFocusEvent();
        }
    }
}
