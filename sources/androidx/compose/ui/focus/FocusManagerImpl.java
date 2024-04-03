package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\u0010J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\b\u0015J\u001d\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0010J\u0006\u0010\u001c\u001a\u00020\u0010J\u001d\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/focus/FocusManagerImpl;", "Landroidx/compose/ui/focus/FocusManager;", "focusModifier", "Landroidx/compose/ui/focus/FocusModifier;", "(Landroidx/compose/ui/focus/FocusModifier;)V", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "clearFocus", "", "force", "", "fetchUpdatedFocusProperties", "getActiveFocusModifier", "getActiveFocusModifier$ui_release", "moveFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "moveFocus-3ESFkO8", "(I)Z", "releaseFocus", "takeFocus", "wrapAroundFocus", "wrapAroundFocus-3ESFkO8", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FocusManagerImpl implements FocusManager {
    @NotNull
    private final FocusModifier focusModifier;
    public LayoutDirection layoutDirection;
    @NotNull
    private final Modifier modifier;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 2;
            iArr[FocusStateImpl.Captured.ordinal()] = 3;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 4;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FocusManagerImpl() {
        this((FocusModifier) null, 1, (DefaultConstructorMarker) null);
    }

    public FocusManagerImpl(@NotNull FocusModifier focusModifier2) {
        Intrinsics.checkNotNullParameter(focusModifier2, "focusModifier");
        this.focusModifier = focusModifier2;
        this.modifier = FocusModifierKt.focusTarget(Modifier.Companion, focusModifier2);
    }

    /* renamed from: wrapAroundFocus-3ESFkO8  reason: not valid java name */
    private final boolean m2619wrapAroundFocus3ESFkO8(int i11) {
        boolean z11;
        if (this.focusModifier.getFocusState().getHasFocus() && !this.focusModifier.getFocusState().isFocused()) {
            FocusDirection.Companion companion = FocusDirection.Companion;
            if (FocusDirection.m2600equalsimpl0(i11, companion.m2613getNextdhqQ8s())) {
                z11 = true;
            } else {
                z11 = FocusDirection.m2600equalsimpl0(i11, companion.m2615getPreviousdhqQ8s());
            }
            if (z11) {
                clearFocus(false);
                if (!this.focusModifier.getFocusState().isFocused()) {
                    return false;
                }
                return m2620moveFocus3ESFkO8(i11);
            }
        }
        return false;
    }

    public void clearFocus(boolean z11) {
        FocusStateImpl focusStateImpl;
        FocusStateImpl focusState = this.focusModifier.getFocusState();
        if (FocusTransactionsKt.clearFocus(this.focusModifier, z11)) {
            FocusModifier focusModifier2 = this.focusModifier;
            switch (WhenMappings.$EnumSwitchMapping$0[focusState.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    focusStateImpl = FocusStateImpl.Active;
                    break;
                case 4:
                case 5:
                    focusStateImpl = FocusStateImpl.Deactivated;
                    break;
                case 6:
                    focusStateImpl = FocusStateImpl.Inactive;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            focusModifier2.setFocusState(focusStateImpl);
        }
    }

    public final void fetchUpdatedFocusProperties() {
        FocusManagerKt.updateProperties(this.focusModifier);
    }

    @Nullable
    public final FocusModifier getActiveFocusModifier$ui_release() {
        return FocusManagerKt.findActiveItem(this.focusModifier);
    }

    @NotNull
    public final LayoutDirection getLayoutDirection() {
        LayoutDirection layoutDirection2 = this.layoutDirection;
        if (layoutDirection2 != null) {
            return layoutDirection2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutDirection");
        return null;
    }

    @NotNull
    public final Modifier getModifier() {
        return this.modifier;
    }

    /* renamed from: moveFocus-3ESFkO8  reason: not valid java name */
    public boolean m2620moveFocus3ESFkO8(int i11) {
        FocusModifier findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.focusModifier);
        if (findActiveFocusNode == null) {
            return false;
        }
        FocusRequester r22 = FocusOrderModifierKt.m2621customFocusSearchOMvw8(findActiveFocusNode, i11, getLayoutDirection());
        FocusRequester.Companion companion = FocusRequester.Companion;
        if (Intrinsics.areEqual((Object) r22, (Object) companion.getCancel())) {
            return false;
        }
        if (!Intrinsics.areEqual((Object) r22, (Object) companion.getDefault())) {
            r22.requestFocus();
        } else if (!FocusTraversalKt.m2628focusSearchsMXa3k8(this.focusModifier, i11, getLayoutDirection(), new FocusManagerImpl$moveFocus$foundNextItem$1(findActiveFocusNode)) && !m2619wrapAroundFocus3ESFkO8(i11)) {
            return false;
        }
        return true;
    }

    public final void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.focusModifier, true);
    }

    public final void setLayoutDirection(@NotNull LayoutDirection layoutDirection2) {
        Intrinsics.checkNotNullParameter(layoutDirection2, "<set-?>");
        this.layoutDirection = layoutDirection2;
    }

    public final void takeFocus() {
        if (this.focusModifier.getFocusState() == FocusStateImpl.Inactive) {
            this.focusModifier.setFocusState(FocusStateImpl.Active);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FocusManagerImpl(FocusModifier focusModifier2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new FocusModifier(FocusStateImpl.Inactive, (Function1) null, 2, (DefaultConstructorMarker) null) : focusModifier2);
    }
}
