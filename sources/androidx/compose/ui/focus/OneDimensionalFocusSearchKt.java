package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.focus.FocusDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a \u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001aE\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\f\u001a\u0002H\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\t0\u0007H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u000e\u001aE\u0010\u000f\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\f\u001a\u0002H\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\t0\u0007H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u000e\u001a \u0010\u0010\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001a=\u0010\u0011\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\u0004*\u00020\u0005H\u0002\u001a5\u0010\u0018\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a \u0010\u001b\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001a \u0010\u001c\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001a=\u0010\u001d\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u0016\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"InvalidFocusDirection", "", "NoActiveChild", "backwardFocusSearch", "", "Landroidx/compose/ui/focus/FocusModifier;", "onFound", "Lkotlin/Function1;", "forEachItemAfter", "", "T", "Landroidx/compose/runtime/collection/MutableVector;", "item", "action", "(Landroidx/compose/runtime/collection/MutableVector;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "forEachItemBefore", "forwardFocusSearch", "generateAndSearchChildren", "focusedItem", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusModifier;Landroidx/compose/ui/focus/FocusModifier;ILkotlin/jvm/functions/Function1;)Z", "isRoot", "oneDimensionalFocusSearch", "oneDimensionalFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusModifier;ILkotlin/jvm/functions/Function1;)Z", "pickChildForBackwardSearch", "pickChildForForwardSearch", "searchChildren", "searchChildren-4C6V_qg", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class OneDimensionalFocusSearchKt {
    @NotNull
    private static final String InvalidFocusDirection = "This function should only be used for 1-D focus search";
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

    private static final boolean backwardFocusSearch(FocusModifier focusModifier, Function1<? super FocusModifier, Boolean> function1) {
        FocusStateImpl focusState = focusModifier.getFocusState();
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        switch (iArr[focusState.ordinal()]) {
            case 1:
            case 2:
                FocusModifier focusedChild = focusModifier.getFocusedChild();
                if (focusedChild != null) {
                    switch (iArr[focusedChild.getFocusState().ordinal()]) {
                        case 1:
                            if (!backwardFocusSearch(focusedChild, function1) && !function1.invoke(focusedChild).booleanValue()) {
                                return false;
                            }
                        case 2:
                            if (!backwardFocusSearch(focusedChild, function1) && !m2630generateAndSearchChildren4C6V_qg(focusModifier, focusedChild, FocusDirection.Companion.m2615getPreviousdhqQ8s(), function1)) {
                                return false;
                            }
                        case 3:
                        case 4:
                            return m2630generateAndSearchChildren4C6V_qg(focusModifier, focusedChild, FocusDirection.Companion.m2615getPreviousdhqQ8s(), function1);
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
            case 5:
                return pickChildForBackwardSearch(focusModifier, function1);
            case 6:
                if (!pickChildForBackwardSearch(focusModifier, function1) && !function1.invoke(focusModifier).booleanValue()) {
                    return false;
                }
            default:
                throw new NoWhenBranchMatchedException();
        }
        return true;
    }

    private static final <T> void forEachItemAfter(MutableVector<T> mutableVector, T t11, Function1<? super T, Unit> function1) {
        boolean z11 = false;
        IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first <= last) {
            while (true) {
                if (z11) {
                    function1.invoke(mutableVector.getContent()[first]);
                }
                if (Intrinsics.areEqual(mutableVector.getContent()[first], (Object) t11)) {
                    z11 = true;
                }
                if (first != last) {
                    first++;
                } else {
                    return;
                }
            }
        }
    }

    private static final <T> void forEachItemBefore(MutableVector<T> mutableVector, T t11, Function1<? super T, Unit> function1) {
        boolean z11 = false;
        IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first <= last) {
            while (true) {
                if (z11) {
                    function1.invoke(mutableVector.getContent()[last]);
                }
                if (Intrinsics.areEqual(mutableVector.getContent()[last], (Object) t11)) {
                    z11 = true;
                }
                if (last != first) {
                    last--;
                } else {
                    return;
                }
            }
        }
    }

    private static final boolean forwardFocusSearch(FocusModifier focusModifier, Function1<? super FocusModifier, Boolean> function1) {
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 2:
                FocusModifier focusedChild = focusModifier.getFocusedChild();
                if (focusedChild == null) {
                    throw new IllegalStateException(NoActiveChild.toString());
                } else if (forwardFocusSearch(focusedChild, function1) || m2630generateAndSearchChildren4C6V_qg(focusModifier, focusedChild, FocusDirection.Companion.m2613getNextdhqQ8s(), function1)) {
                    return true;
                } else {
                    return false;
                }
            case 3:
            case 4:
            case 5:
                return pickChildForForwardSearch(focusModifier, function1);
            case 6:
                return function1.invoke(focusModifier).booleanValue();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg  reason: not valid java name */
    private static final boolean m2630generateAndSearchChildren4C6V_qg(FocusModifier focusModifier, FocusModifier focusModifier2, int i11, Function1<? super FocusModifier, Boolean> function1) {
        if (m2632searchChildren4C6V_qg(focusModifier, focusModifier2, i11, function1)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m2596searchBeyondBoundsOMvw8(focusModifier, i11, new OneDimensionalFocusSearchKt$generateAndSearchChildren$1(focusModifier, focusModifier2, i11, function1));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static final boolean isRoot(FocusModifier focusModifier) {
        return focusModifier.getParent() == null;
    }

    /* renamed from: oneDimensionalFocusSearch--OM-vw8  reason: not valid java name */
    public static final boolean m2631oneDimensionalFocusSearchOMvw8(@NotNull FocusModifier focusModifier, int i11, @NotNull Function1<? super FocusModifier, Boolean> function1) {
        Intrinsics.checkNotNullParameter(focusModifier, "$this$oneDimensionalFocusSearch");
        Intrinsics.checkNotNullParameter(function1, "onFound");
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2600equalsimpl0(i11, companion.m2613getNextdhqQ8s())) {
            return forwardFocusSearch(focusModifier, function1);
        }
        if (FocusDirection.m2600equalsimpl0(i11, companion.m2615getPreviousdhqQ8s())) {
            return backwardFocusSearch(focusModifier, function1);
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    private static final boolean pickChildForBackwardSearch(FocusModifier focusModifier, Function1<? super FocusModifier, Boolean> function1) {
        focusModifier.getChildren().sortWith(FocusableChildrenComparator.INSTANCE);
        MutableVector<FocusModifier> children = focusModifier.getChildren();
        int size = children.getSize();
        if (size <= 0) {
            return false;
        }
        int i11 = size - 1;
        Object[] content = children.getContent();
        Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        do {
            FocusModifier focusModifier2 = (FocusModifier) content[i11];
            if (FocusTraversalKt.isEligibleForFocusSearch(focusModifier2) && backwardFocusSearch(focusModifier2, function1)) {
                return true;
            }
            i11--;
        } while (i11 >= 0);
        return false;
    }

    private static final boolean pickChildForForwardSearch(FocusModifier focusModifier, Function1<? super FocusModifier, Boolean> function1) {
        boolean z11;
        focusModifier.getChildren().sortWith(FocusableChildrenComparator.INSTANCE);
        MutableVector<FocusModifier> children = focusModifier.getChildren();
        int size = children.getSize();
        if (size <= 0) {
            return false;
        }
        Object[] content = children.getContent();
        Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        int i11 = 0;
        do {
            FocusModifier focusModifier2 = (FocusModifier) content[i11];
            if (!FocusTraversalKt.isEligibleForFocusSearch(focusModifier2) || !forwardFocusSearch(focusModifier2, function1)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                return true;
            }
            i11++;
        } while (i11 < size);
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: searchChildren-4C6V_qg  reason: not valid java name */
    public static final boolean m2632searchChildren4C6V_qg(FocusModifier focusModifier, FocusModifier focusModifier2, int i11, Function1<? super FocusModifier, Boolean> function1) {
        boolean z11;
        if (focusModifier.getFocusState() == FocusStateImpl.ActiveParent || focusModifier.getFocusState() == FocusStateImpl.DeactivatedParent) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            focusModifier.getChildren().sortWith(FocusableChildrenComparator.INSTANCE);
            FocusDirection.Companion companion = FocusDirection.Companion;
            if (FocusDirection.m2600equalsimpl0(i11, companion.m2613getNextdhqQ8s())) {
                MutableVector<FocusModifier> children = focusModifier.getChildren();
                IntRange intRange = new IntRange(0, children.getSize() - 1);
                int first = intRange.getFirst();
                int last = intRange.getLast();
                if (first <= last) {
                    boolean z12 = false;
                    while (true) {
                        if (z12) {
                            FocusModifier focusModifier3 = (FocusModifier) children.getContent()[first];
                            if (FocusTraversalKt.isEligibleForFocusSearch(focusModifier3) && forwardFocusSearch(focusModifier3, function1)) {
                                return true;
                            }
                        }
                        if (Intrinsics.areEqual(children.getContent()[first], (Object) focusModifier2)) {
                            z12 = true;
                        }
                        if (first == last) {
                            break;
                        }
                        first++;
                    }
                }
            } else if (FocusDirection.m2600equalsimpl0(i11, companion.m2615getPreviousdhqQ8s())) {
                MutableVector<FocusModifier> children2 = focusModifier.getChildren();
                IntRange intRange2 = new IntRange(0, children2.getSize() - 1);
                int first2 = intRange2.getFirst();
                int last2 = intRange2.getLast();
                if (first2 <= last2) {
                    boolean z13 = false;
                    while (true) {
                        if (z13) {
                            FocusModifier focusModifier4 = (FocusModifier) children2.getContent()[last2];
                            if (FocusTraversalKt.isEligibleForFocusSearch(focusModifier4) && backwardFocusSearch(focusModifier4, function1)) {
                                return true;
                            }
                        }
                        if (Intrinsics.areEqual(children2.getContent()[last2], (Object) focusModifier2)) {
                            z13 = true;
                        }
                        if (last2 == first2) {
                            break;
                        }
                        last2--;
                    }
                }
            } else {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            if (FocusDirection.m2600equalsimpl0(i11, FocusDirection.Companion.m2613getNextdhqQ8s()) || focusModifier.getFocusState() == FocusStateImpl.DeactivatedParent || isRoot(focusModifier)) {
                return false;
            }
            return function1.invoke(focusModifier).booleanValue();
        }
        throw new IllegalStateException("This function should only be used within a parent that has focus.".toString());
    }
}
