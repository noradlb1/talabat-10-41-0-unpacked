package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u001a5\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a5\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\f\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0013H\u0002\u001a\f\u0010\u0014\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a1\u0010\u0015\u001a\u0004\u0018\u00010\u0013*\b\u0012\u0004\u0012\u00020\u00130\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a5\u0010\u001a\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u001cH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a=\u0010\u001f\u001a\u00020\u0004*\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u001cH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"\u001a=\u0010#\u001a\u00020\u0004*\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u001cH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\"\u001a\f\u0010%\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a5\u0010&\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u001cH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010\u001e\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006("}, d2 = {"InvalidFocusDirection", "", "NoActiveChild", "beamBeats", "", "source", "Landroidx/compose/ui/geometry/Rect;", "rect1", "rect2", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "beamBeats-I7lrPNg", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;I)Z", "isBetterCandidate", "proposedCandidate", "currentCandidate", "focusedRect", "isBetterCandidate-I7lrPNg", "activeNode", "Landroidx/compose/ui/focus/FocusModifier;", "bottomRight", "findBestCandidate", "Landroidx/compose/runtime/collection/MutableVector;", "focusRect", "findBestCandidate-4WY_MpI", "(Landroidx/compose/runtime/collection/MutableVector;Landroidx/compose/ui/geometry/Rect;I)Landroidx/compose/ui/focus/FocusModifier;", "findChildCorrespondingToFocusEnter", "onFound", "Lkotlin/Function1;", "findChildCorrespondingToFocusEnter--OM-vw8", "(Landroidx/compose/ui/focus/FocusModifier;ILkotlin/jvm/functions/Function1;)Z", "generateAndSearchChildren", "focusedItem", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusModifier;Landroidx/compose/ui/focus/FocusModifier;ILkotlin/jvm/functions/Function1;)Z", "searchChildren", "searchChildren-4C6V_qg", "topLeft", "twoDimensionalFocusSearch", "twoDimensionalFocusSearch--OM-vw8", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TwoDimensionalFocusSearchKt {
    @NotNull
    private static final String InvalidFocusDirection = "This function should only be used for 2-D focus search";
    @NotNull
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 1;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 2;
            iArr[FocusStateImpl.Active.ordinal()] = 3;
            iArr[FocusStateImpl.Captured.ordinal()] = 4;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final FocusModifier activeNode(FocusModifier focusModifier) {
        boolean z11;
        if (focusModifier.getFocusState() == FocusStateImpl.ActiveParent || focusModifier.getFocusState() == FocusStateImpl.DeactivatedParent) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            FocusModifier findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusModifier);
            if (findActiveFocusNode != null) {
                return findActiveFocusNode;
            }
            throw new IllegalStateException(NoActiveChild.toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* renamed from: beamBeats-I7lrPNg  reason: not valid java name */
    private static final boolean m2634beamBeatsI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i11) {
        if (beamBeats_I7lrPNg$inSourceBeam(rect3, i11, rect) || !beamBeats_I7lrPNg$inSourceBeam(rect2, i11, rect)) {
            return false;
        }
        if (beamBeats_I7lrPNg$isInDirectionOfSearch(rect3, i11, rect)) {
            FocusDirection.Companion companion = FocusDirection.Companion;
            if (!FocusDirection.m2600equalsimpl0(i11, companion.m2612getLeftdhqQ8s()) && !FocusDirection.m2600equalsimpl0(i11, companion.m2616getRightdhqQ8s()) && m2635beamBeats_I7lrPNg$majorAxisDistance6(rect2, i11, rect) >= beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(rect3, i11, rect)) {
                return false;
            }
        }
        return true;
    }

    private static final boolean beamBeats_I7lrPNg$inSourceBeam(Rect rect, int i11, Rect rect2) {
        boolean z11;
        boolean z12;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2600equalsimpl0(i11, companion.m2612getLeftdhqQ8s())) {
            z11 = true;
        } else {
            z11 = FocusDirection.m2600equalsimpl0(i11, companion.m2616getRightdhqQ8s());
        }
        if (!z11) {
            if (FocusDirection.m2600equalsimpl0(i11, companion.m2617getUpdhqQ8s())) {
                z12 = true;
            } else {
                z12 = FocusDirection.m2600equalsimpl0(i11, companion.m2608getDowndhqQ8s());
            }
            if (!z12) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            } else if (rect.getRight() > rect2.getLeft() && rect.getLeft() < rect2.getRight()) {
                return true;
            }
        } else if (rect.getBottom() > rect2.getTop() && rect.getTop() < rect2.getBottom()) {
            return true;
        }
        return false;
    }

    private static final boolean beamBeats_I7lrPNg$isInDirectionOfSearch(Rect rect, int i11, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2600equalsimpl0(i11, companion.m2612getLeftdhqQ8s())) {
            if (rect2.getLeft() >= rect.getRight()) {
                return true;
            }
        } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2616getRightdhqQ8s())) {
            if (rect2.getRight() <= rect.getLeft()) {
                return true;
            }
        } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2617getUpdhqQ8s())) {
            if (rect2.getTop() >= rect.getBottom()) {
                return true;
            }
        } else if (!FocusDirection.m2600equalsimpl0(i11, companion.m2608getDowndhqQ8s())) {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        } else if (rect2.getBottom() <= rect.getTop()) {
            return true;
        }
        return false;
    }

    /* renamed from: beamBeats_I7lrPNg$majorAxisDistance-6  reason: not valid java name */
    private static final float m2635beamBeats_I7lrPNg$majorAxisDistance6(Rect rect, int i11, Rect rect2) {
        float f11;
        float top;
        float bottom;
        float top2;
        float bottom2;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2600equalsimpl0(i11, companion.m2612getLeftdhqQ8s())) {
            top2 = rect2.getLeft();
            bottom2 = rect.getRight();
        } else {
            if (FocusDirection.m2600equalsimpl0(i11, companion.m2616getRightdhqQ8s())) {
                top = rect.getLeft();
                bottom = rect2.getRight();
            } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2617getUpdhqQ8s())) {
                top2 = rect2.getTop();
                bottom2 = rect.getBottom();
            } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2608getDowndhqQ8s())) {
                top = rect.getTop();
                bottom = rect2.getBottom();
            } else {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            f11 = top - bottom;
            return Math.max(0.0f, f11);
        }
        f11 = top2 - bottom2;
        return Math.max(0.0f, f11);
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(Rect rect, int i11, Rect rect2) {
        float f11;
        float bottom;
        float bottom2;
        float top;
        float top2;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2600equalsimpl0(i11, companion.m2612getLeftdhqQ8s())) {
            top = rect2.getLeft();
            top2 = rect.getLeft();
        } else {
            if (FocusDirection.m2600equalsimpl0(i11, companion.m2616getRightdhqQ8s())) {
                bottom = rect.getRight();
                bottom2 = rect2.getRight();
            } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2617getUpdhqQ8s())) {
                top = rect2.getTop();
                top2 = rect.getTop();
            } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2608getDowndhqQ8s())) {
                bottom = rect.getBottom();
                bottom2 = rect2.getBottom();
            } else {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            f11 = bottom - bottom2;
            return Math.max(1.0f, f11);
        }
        f11 = top - top2;
        return Math.max(1.0f, f11);
    }

    private static final Rect bottomRight(Rect rect) {
        return new Rect(rect.getRight(), rect.getBottom(), rect.getRight(), rect.getBottom());
    }

    /* renamed from: findBestCandidate-4WY_MpI  reason: not valid java name */
    private static final FocusModifier m2636findBestCandidate4WY_MpI(MutableVector<FocusModifier> mutableVector, Rect rect, int i11) {
        Rect rect2;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2600equalsimpl0(i11, companion.m2612getLeftdhqQ8s())) {
            rect2 = rect.translate(rect.getWidth() + ((float) 1), 0.0f);
        } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2616getRightdhqQ8s())) {
            rect2 = rect.translate(-(rect.getWidth() + ((float) 1)), 0.0f);
        } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2617getUpdhqQ8s())) {
            rect2 = rect.translate(0.0f, rect.getHeight() + ((float) 1));
        } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2608getDowndhqQ8s())) {
            rect2 = rect.translate(0.0f, -(rect.getHeight() + ((float) 1)));
        } else {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        }
        int size = mutableVector.getSize();
        FocusModifier focusModifier = null;
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i12 = 0;
            do {
                FocusModifier focusModifier2 = (FocusModifier) content[i12];
                if (FocusTraversalKt.isEligibleForFocusSearch(focusModifier2)) {
                    Rect focusRect = FocusTraversalKt.focusRect(focusModifier2);
                    if (m2639isBetterCandidateI7lrPNg(focusRect, rect2, rect, i11)) {
                        focusModifier = focusModifier2;
                        rect2 = focusRect;
                    }
                }
                i12++;
            } while (i12 < size);
        }
        return focusModifier;
    }

    /* renamed from: findChildCorrespondingToFocusEnter--OM-vw8  reason: not valid java name */
    public static final boolean m2637findChildCorrespondingToFocusEnterOMvw8(@NotNull FocusModifier focusModifier, int i11, @NotNull Function1<? super FocusModifier, Boolean> function1) {
        boolean z11;
        Rect rect;
        Object obj;
        Intrinsics.checkNotNullParameter(focusModifier, "$this$findChildCorrespondingToFocusEnter");
        Intrinsics.checkNotNullParameter(function1, "onFound");
        Boolean performRequestFocus$ui_release = focusModifier.getFocusProperties().getEnter().invoke(FocusDirection.m2597boximpl(i11)).performRequestFocus$ui_release(function1);
        if (performRequestFocus$ui_release != null) {
            return performRequestFocus$ui_release.booleanValue();
        }
        MutableVector<FocusModifier> activatedChildren = FocusTraversalKt.activatedChildren(focusModifier);
        boolean z12 = true;
        if (activatedChildren.getSize() <= 1) {
            if (activatedChildren.isEmpty()) {
                obj = null;
            } else {
                obj = activatedChildren.getContent()[0];
            }
            FocusModifier focusModifier2 = (FocusModifier) obj;
            if (focusModifier2 != null) {
                return function1.invoke(focusModifier2).booleanValue();
            }
            return false;
        }
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2600equalsimpl0(i11, companion.m2609getEnterdhqQ8s())) {
            i11 = companion.m2612getLeftdhqQ8s();
        }
        if (FocusDirection.m2600equalsimpl0(i11, companion.m2616getRightdhqQ8s())) {
            z11 = true;
        } else {
            z11 = FocusDirection.m2600equalsimpl0(i11, companion.m2608getDowndhqQ8s());
        }
        if (z11) {
            rect = topLeft(FocusTraversalKt.focusRect(focusModifier));
        } else {
            if (!FocusDirection.m2600equalsimpl0(i11, companion.m2612getLeftdhqQ8s())) {
                z12 = FocusDirection.m2600equalsimpl0(i11, companion.m2617getUpdhqQ8s());
            }
            if (z12) {
                rect = bottomRight(FocusTraversalKt.focusRect(focusModifier));
            } else {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
        }
        FocusModifier r52 = m2636findBestCandidate4WY_MpI(activatedChildren, rect, i11);
        if (r52 != null) {
            return function1.invoke(r52).booleanValue();
        }
        return false;
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg  reason: not valid java name */
    private static final boolean m2638generateAndSearchChildren4C6V_qg(FocusModifier focusModifier, FocusModifier focusModifier2, int i11, Function1<? super FocusModifier, Boolean> function1) {
        if (m2640searchChildren4C6V_qg(focusModifier, focusModifier2, i11, function1)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m2596searchBeyondBoundsOMvw8(focusModifier, i11, new TwoDimensionalFocusSearchKt$generateAndSearchChildren$1(focusModifier, focusModifier2, i11, function1));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* renamed from: isBetterCandidate-I7lrPNg  reason: not valid java name */
    private static final boolean m2639isBetterCandidateI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i11) {
        if (!isBetterCandidate_I7lrPNg$isCandidate(rect, i11, rect3)) {
            return false;
        }
        if (isBetterCandidate_I7lrPNg$isCandidate(rect2, i11, rect3) && !m2634beamBeatsI7lrPNg(rect3, rect, rect2, i11) && (m2634beamBeatsI7lrPNg(rect3, rect2, rect, i11) || isBetterCandidate_I7lrPNg$weightedDistance(i11, rect3, rect) >= isBetterCandidate_I7lrPNg$weightedDistance(i11, rect3, rect2))) {
            return false;
        }
        return true;
    }

    private static final boolean isBetterCandidate_I7lrPNg$isCandidate(Rect rect, int i11, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2600equalsimpl0(i11, companion.m2612getLeftdhqQ8s())) {
            if ((rect2.getRight() > rect.getRight() || rect2.getLeft() >= rect.getRight()) && rect2.getLeft() > rect.getLeft()) {
                return true;
            }
        } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2616getRightdhqQ8s())) {
            if ((rect2.getLeft() < rect.getLeft() || rect2.getRight() <= rect.getLeft()) && rect2.getRight() < rect.getRight()) {
                return true;
            }
        } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2617getUpdhqQ8s())) {
            if ((rect2.getBottom() > rect.getBottom() || rect2.getTop() >= rect.getBottom()) && rect2.getTop() > rect.getTop()) {
                return true;
            }
        } else if (!FocusDirection.m2600equalsimpl0(i11, companion.m2608getDowndhqQ8s())) {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        } else if ((rect2.getTop() < rect.getTop() || rect2.getBottom() <= rect.getTop()) && rect2.getBottom() < rect.getBottom()) {
            return true;
        }
        return false;
    }

    private static final float isBetterCandidate_I7lrPNg$majorAxisDistance(Rect rect, int i11, Rect rect2) {
        float f11;
        float top;
        float bottom;
        float top2;
        float bottom2;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2600equalsimpl0(i11, companion.m2612getLeftdhqQ8s())) {
            top2 = rect2.getLeft();
            bottom2 = rect.getRight();
        } else {
            if (FocusDirection.m2600equalsimpl0(i11, companion.m2616getRightdhqQ8s())) {
                top = rect.getLeft();
                bottom = rect2.getRight();
            } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2617getUpdhqQ8s())) {
                top2 = rect2.getTop();
                bottom2 = rect.getBottom();
            } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2608getDowndhqQ8s())) {
                top = rect.getTop();
                bottom = rect2.getBottom();
            } else {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            f11 = top - bottom;
            return Math.max(0.0f, f11);
        }
        f11 = top2 - bottom2;
        return Math.max(0.0f, f11);
    }

    private static final float isBetterCandidate_I7lrPNg$minorAxisDistance(Rect rect, int i11, Rect rect2) {
        boolean z11;
        float f11;
        float left;
        float left2;
        float width;
        FocusDirection.Companion companion = FocusDirection.Companion;
        boolean z12 = true;
        if (FocusDirection.m2600equalsimpl0(i11, companion.m2612getLeftdhqQ8s())) {
            z11 = true;
        } else {
            z11 = FocusDirection.m2600equalsimpl0(i11, companion.m2616getRightdhqQ8s());
        }
        if (z11) {
            f11 = (float) 2;
            left = rect2.getTop() + (rect2.getHeight() / f11);
            left2 = rect.getTop();
            width = rect.getHeight();
        } else {
            if (!FocusDirection.m2600equalsimpl0(i11, companion.m2617getUpdhqQ8s())) {
                z12 = FocusDirection.m2600equalsimpl0(i11, companion.m2608getDowndhqQ8s());
            }
            if (z12) {
                f11 = (float) 2;
                left = rect2.getLeft() + (rect2.getWidth() / f11);
                left2 = rect.getLeft();
                width = rect.getWidth();
            } else {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
        }
        return left - (left2 + (width / f11));
    }

    private static final long isBetterCandidate_I7lrPNg$weightedDistance(int i11, Rect rect, Rect rect2) {
        long abs = (long) Math.abs(isBetterCandidate_I7lrPNg$majorAxisDistance(rect2, i11, rect));
        long abs2 = (long) Math.abs(isBetterCandidate_I7lrPNg$minorAxisDistance(rect2, i11, rect));
        return (((long) 13) * abs * abs) + (abs2 * abs2);
    }

    /* access modifiers changed from: private */
    /* renamed from: searchChildren-4C6V_qg  reason: not valid java name */
    public static final boolean m2640searchChildren4C6V_qg(FocusModifier focusModifier, FocusModifier focusModifier2, int i11, Function1<? super FocusModifier, Boolean> function1) {
        FocusModifier r42;
        MutableVector mutableVector = new MutableVector(new FocusModifier[focusModifier.getChildren().getSize()], 0);
        mutableVector.addAll(mutableVector.getSize(), focusModifier.getChildren());
        while (mutableVector.isNotEmpty() && (r42 = m2636findBestCandidate4WY_MpI(mutableVector, FocusTraversalKt.focusRect(focusModifier2), i11)) != null) {
            if (!r42.getFocusState().isDeactivated()) {
                return function1.invoke(r42).booleanValue();
            }
            Boolean performRequestFocus$ui_release = r42.getFocusProperties().getEnter().invoke(FocusDirection.m2597boximpl(i11)).performRequestFocus$ui_release(function1);
            if (performRequestFocus$ui_release != null) {
                return performRequestFocus$ui_release.booleanValue();
            }
            if (m2638generateAndSearchChildren4C6V_qg(r42, focusModifier2, i11, function1)) {
                return true;
            }
            mutableVector.remove(r42);
        }
        return false;
    }

    private static final Rect topLeft(Rect rect) {
        return new Rect(rect.getLeft(), rect.getTop(), rect.getLeft(), rect.getTop());
    }

    /* renamed from: twoDimensionalFocusSearch--OM-vw8  reason: not valid java name */
    public static final boolean m2641twoDimensionalFocusSearchOMvw8(@NotNull FocusModifier focusModifier, int i11, @NotNull Function1<? super FocusModifier, Boolean> function1) {
        Intrinsics.checkNotNullParameter(focusModifier, "$this$twoDimensionalFocusSearch");
        Intrinsics.checkNotNullParameter(function1, "onFound");
        FocusStateImpl focusState = focusModifier.getFocusState();
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        switch (iArr[focusState.ordinal()]) {
            case 1:
            case 2:
                FocusModifier focusedChild = focusModifier.getFocusedChild();
                if (focusedChild != null) {
                    switch (iArr[focusedChild.getFocusState().ordinal()]) {
                        case 1:
                        case 2:
                            if (m2641twoDimensionalFocusSearchOMvw8(focusedChild, i11, function1)) {
                                return true;
                            }
                            Boolean performRequestFocus$ui_release = focusedChild.getFocusProperties().getExit().invoke(FocusDirection.m2597boximpl(i11)).performRequestFocus$ui_release(function1);
                            if (performRequestFocus$ui_release != null) {
                                return performRequestFocus$ui_release.booleanValue();
                            }
                            return m2638generateAndSearchChildren4C6V_qg(focusModifier, activeNode(focusedChild), i11, function1);
                        case 3:
                        case 4:
                            return m2638generateAndSearchChildren4C6V_qg(focusModifier, focusedChild, i11, function1);
                        case 5:
                        case 6:
                            throw new IllegalStateException(NoActiveChild.toString());
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                } else {
                    throw new IllegalStateException(NoActiveChild.toString());
                }
            case 3:
            case 4:
                return m2637findChildCorrespondingToFocusEnterOMvw8(focusModifier, i11, function1);
            case 5:
                return false;
            case 6:
                return function1.invoke(focusModifier).booleanValue();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
