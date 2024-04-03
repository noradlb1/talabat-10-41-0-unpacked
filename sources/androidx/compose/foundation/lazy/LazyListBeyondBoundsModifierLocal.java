package androidx.compose.foundation.lazy;

import a0.a;
import a0.b;
import androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ%\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J@\u0010\u001a\u001a\u0004\u0018\u0001H\u001b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0019\u0010\u001c\u001a\u0015\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u0001H\u001b0\u001d¢\u0006\u0002\b\u001fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!J!\u0010\"\u001a\u00020\b*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006%"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListBeyondBoundsModifierLocal;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "reverseLayout", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;ZLandroidx/compose/ui/unit/LayoutDirection;)V", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "getValue", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "addNextInterval", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;", "currentInterval", "direction", "Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "addNextInterval-FR3nfPY", "(Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;I)Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;", "layout", "T", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "layout-o7g1Pn8", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "hasMoreContent", "hasMoreContent-FR3nfPY", "(Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;I)Z", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class LazyListBeyondBoundsModifierLocal implements ModifierLocalProvider<BeyondBoundsLayout>, BeyondBoundsLayout {
    @NotNull
    private final LazyListBeyondBoundsInfo beyondBoundsInfo;
    @NotNull
    private final LayoutDirection layoutDirection;
    private final boolean reverseLayout;
    @NotNull
    private final LazyListState state;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LazyListBeyondBoundsModifierLocal(@NotNull LazyListState lazyListState, @NotNull LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, boolean z11, @NotNull LayoutDirection layoutDirection2) {
        Intrinsics.checkNotNullParameter(lazyListState, "state");
        Intrinsics.checkNotNullParameter(lazyListBeyondBoundsInfo, "beyondBoundsInfo");
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        this.state = lazyListState;
        this.beyondBoundsInfo = lazyListBeyondBoundsInfo;
        this.reverseLayout = z11;
        this.layoutDirection = layoutDirection2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (r5.reverseLayout != false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0061, code lost:
        if (r5.reverseLayout != false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0066, code lost:
        if (r5.reverseLayout != false) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0084, code lost:
        if (r5.reverseLayout != false) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0089, code lost:
        if (r5.reverseLayout != false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
        if (r5.reverseLayout != false) goto L_0x0022;
     */
    /* renamed from: addNextInterval-FR3nfPY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo.Interval m627addNextIntervalFR3nfPY(androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo.Interval r6, int r7) {
        /*
            r5 = this;
            int r0 = r6.getStart()
            int r6 = r6.getEnd()
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r1 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.Companion
            int r2 = r1.m4437getBeforehoxUOeE()
            boolean r2 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.m4431equalsimpl0(r7, r2)
            if (r2 == 0) goto L_0x0018
        L_0x0014:
            int r0 = r0 + -1
            goto L_0x008c
        L_0x0018:
            int r2 = r1.m4436getAfterhoxUOeE()
            boolean r2 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.m4431equalsimpl0(r7, r2)
            if (r2 == 0) goto L_0x0026
        L_0x0022:
            int r6 = r6 + 1
            goto L_0x008c
        L_0x0026:
            int r2 = r1.m4435getAbovehoxUOeE()
            boolean r2 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.m4431equalsimpl0(r7, r2)
            if (r2 == 0) goto L_0x0035
            boolean r7 = r5.reverseLayout
            if (r7 == 0) goto L_0x0014
            goto L_0x0022
        L_0x0035:
            int r2 = r1.m4438getBelowhoxUOeE()
            boolean r2 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.m4431equalsimpl0(r7, r2)
            if (r2 == 0) goto L_0x0044
            boolean r7 = r5.reverseLayout
            if (r7 == 0) goto L_0x0022
            goto L_0x0014
        L_0x0044:
            int r2 = r1.m4439getLefthoxUOeE()
            boolean r2 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.m4431equalsimpl0(r7, r2)
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0069
            androidx.compose.ui.unit.LayoutDirection r7 = r5.layoutDirection
            int[] r1 = androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierLocal.WhenMappings.$EnumSwitchMapping$0
            int r7 = r7.ordinal()
            r7 = r1[r7]
            if (r7 == r4) goto L_0x0064
            if (r7 == r3) goto L_0x005f
            goto L_0x008c
        L_0x005f:
            boolean r7 = r5.reverseLayout
            if (r7 == 0) goto L_0x0022
            goto L_0x0014
        L_0x0064:
            boolean r7 = r5.reverseLayout
            if (r7 == 0) goto L_0x0014
            goto L_0x0022
        L_0x0069:
            int r1 = r1.m4440getRighthoxUOeE()
            boolean r7 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.m4431equalsimpl0(r7, r1)
            if (r7 == 0) goto L_0x0093
            androidx.compose.ui.unit.LayoutDirection r7 = r5.layoutDirection
            int[] r1 = androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierLocal.WhenMappings.$EnumSwitchMapping$0
            int r7 = r7.ordinal()
            r7 = r1[r7]
            if (r7 == r4) goto L_0x0087
            if (r7 == r3) goto L_0x0082
            goto L_0x008c
        L_0x0082:
            boolean r7 = r5.reverseLayout
            if (r7 == 0) goto L_0x0014
            goto L_0x0022
        L_0x0087:
            boolean r7 = r5.reverseLayout
            if (r7 == 0) goto L_0x0022
            goto L_0x0014
        L_0x008c:
            androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo r7 = r5.beyondBoundsInfo
            androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo$Interval r6 = r7.addInterval(r0, r6)
            return r6
        L_0x0093:
            java.lang.Void unused = androidx.compose.foundation.lazy.LazyBeyondBoundsModifierKt.unsupportedDirection()
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierLocal.m627addNextIntervalFR3nfPY(androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo$Interval, int):androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo$Interval");
    }

    /* access modifiers changed from: private */
    /* renamed from: hasMoreContent-FR3nfPY  reason: not valid java name */
    public final boolean m628hasMoreContentFR3nfPY(LazyListBeyondBoundsInfo.Interval interval, int i11) {
        BeyondBoundsLayout.LayoutDirection.Companion companion = BeyondBoundsLayout.LayoutDirection.Companion;
        if (BeyondBoundsLayout.LayoutDirection.m4431equalsimpl0(i11, companion.m4437getBeforehoxUOeE())) {
            return hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
        }
        if (BeyondBoundsLayout.LayoutDirection.m4431equalsimpl0(i11, companion.m4436getAfterhoxUOeE())) {
            return hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
        }
        if (BeyondBoundsLayout.LayoutDirection.m4431equalsimpl0(i11, companion.m4435getAbovehoxUOeE())) {
            if (this.reverseLayout) {
                return hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
            }
            return hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
        } else if (BeyondBoundsLayout.LayoutDirection.m4431equalsimpl0(i11, companion.m4438getBelowhoxUOeE())) {
            if (this.reverseLayout) {
                return hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
            }
            return hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
        } else if (BeyondBoundsLayout.LayoutDirection.m4431equalsimpl0(i11, companion.m4439getLefthoxUOeE())) {
            int i12 = WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()];
            if (i12 != 1) {
                if (i12 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else if (this.reverseLayout) {
                    return hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
                } else {
                    return hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
                }
            } else if (this.reverseLayout) {
                return hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
            } else {
                return hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
            }
        } else if (BeyondBoundsLayout.LayoutDirection.m4431equalsimpl0(i11, companion.m4440getRighthoxUOeE())) {
            int i13 = WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()];
            if (i13 != 1) {
                if (i13 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else if (this.reverseLayout) {
                    return hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
                } else {
                    return hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
                }
            } else if (this.reverseLayout) {
                return hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
            } else {
                return hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
            }
        } else {
            Void unused = LazyBeyondBoundsModifierKt.unsupportedDirection();
            throw new KotlinNothingValueException();
        }
    }

    private static final boolean hasMoreContent_FR3nfPY$hasMoreItemsAfter(LazyListBeyondBoundsInfo.Interval interval, LazyListBeyondBoundsModifierLocal lazyListBeyondBoundsModifierLocal) {
        return interval.getEnd() < lazyListBeyondBoundsModifierLocal.state.getLayoutInfo().getTotalItemsCount() - 1;
    }

    private static final boolean hasMoreContent_FR3nfPY$hasMoreItemsBefore(LazyListBeyondBoundsInfo.Interval interval) {
        return interval.getStart() > 0;
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    @NotNull
    public ProvidableModifierLocal<BeyondBoundsLayout> getKey() {
        return BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout();
    }

    @NotNull
    public BeyondBoundsLayout getValue() {
        return this;
    }

    @Nullable
    /* renamed from: layout-o7g1Pn8  reason: not valid java name */
    public <T> T m629layouto7g1Pn8(int i11, @NotNull Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = this.beyondBoundsInfo.addInterval(this.state.getFirstVisibleItemIndex(), ((LazyListItemInfo) CollectionsKt___CollectionsKt.last(this.state.getLayoutInfo().getVisibleItemsInfo())).getIndex());
        T t11 = null;
        while (t11 == null && m628hasMoreContentFR3nfPY((LazyListBeyondBoundsInfo.Interval) objectRef.element, i11)) {
            T r12 = m627addNextIntervalFR3nfPY((LazyListBeyondBoundsInfo.Interval) objectRef.element, i11);
            this.beyondBoundsInfo.removeInterval((LazyListBeyondBoundsInfo.Interval) objectRef.element);
            objectRef.element = r12;
            Remeasurement remeasurement$foundation_release = this.state.getRemeasurement$foundation_release();
            if (remeasurement$foundation_release != null) {
                remeasurement$foundation_release.forceRemeasure();
            }
            t11 = function1.invoke(new LazyListBeyondBoundsModifierLocal$layout$2(this, objectRef, i11));
        }
        this.beyondBoundsInfo.removeInterval((LazyListBeyondBoundsInfo.Interval) objectRef.element);
        Remeasurement remeasurement$foundation_release2 = this.state.getRemeasurement$foundation_release();
        if (remeasurement$foundation_release2 != null) {
            remeasurement$foundation_release2.forceRemeasure();
        }
        return t11;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }
}
