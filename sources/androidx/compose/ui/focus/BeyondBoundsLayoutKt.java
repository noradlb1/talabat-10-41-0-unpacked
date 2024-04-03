package androidx.compose.ui.focus;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006¢\u0006\u0002\b\bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"searchBeyondBounds", "T", "Landroidx/compose/ui/focus/FocusModifier;", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "searchBeyondBounds--OM-vw8", "(Landroidx/compose/ui/focus/FocusModifier;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BeyondBoundsLayoutKt {
    @Nullable
    /* renamed from: searchBeyondBounds--OM-vw8  reason: not valid java name */
    public static final <T> T m2596searchBeyondBoundsOMvw8(@NotNull FocusModifier focusModifier, int i11, @NotNull Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> function1) {
        int i12;
        Intrinsics.checkNotNullParameter(focusModifier, "$this$searchBeyondBounds");
        Intrinsics.checkNotNullParameter(function1, "block");
        BeyondBoundsLayout beyondBoundsLayoutParent = focusModifier.getBeyondBoundsLayoutParent();
        if (beyondBoundsLayoutParent == null) {
            return null;
        }
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2600equalsimpl0(i11, companion.m2617getUpdhqQ8s())) {
            i12 = BeyondBoundsLayout.LayoutDirection.Companion.m4435getAbovehoxUOeE();
        } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2608getDowndhqQ8s())) {
            i12 = BeyondBoundsLayout.LayoutDirection.Companion.m4438getBelowhoxUOeE();
        } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2612getLeftdhqQ8s())) {
            i12 = BeyondBoundsLayout.LayoutDirection.Companion.m4439getLefthoxUOeE();
        } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2616getRightdhqQ8s())) {
            i12 = BeyondBoundsLayout.LayoutDirection.Companion.m4440getRighthoxUOeE();
        } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2613getNextdhqQ8s())) {
            i12 = BeyondBoundsLayout.LayoutDirection.Companion.m4436getAfterhoxUOeE();
        } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2615getPreviousdhqQ8s())) {
            i12 = BeyondBoundsLayout.LayoutDirection.Companion.m4437getBeforehoxUOeE();
        } else {
            throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
        }
        return beyondBoundsLayoutParent.m4427layouto7g1Pn8(i12, function1);
    }
}
