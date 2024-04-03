package androidx.compose.foundation.gestures;

import a0.a;
import a0.b;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.FocusedBoundsKt;
import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.foundation.relocation.BringIntoViewResponderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonCancellable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ!\u0010\"\u001a\u00020#2\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120%H@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0012H\u0016J%\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020!H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001d\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020!H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101J%\u00102\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104J!\u00105\u001a\u00020#2\u0006\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u00108J \u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020:H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128B@BX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010 \u001a\u0004\u0018\u00010!X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006>"}, d2 = {"Landroidx/compose/foundation/gestures/ContentInViewModifier;", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "Landroidx/compose/ui/layout/OnRemeasuredModifier;", "Landroidx/compose/ui/layout/OnPlacedModifier;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "reverseDirection", "", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/ScrollableState;Z)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "focusAnimationJob", "Lkotlinx/coroutines/Job;", "<set-?>", "Landroidx/compose/ui/geometry/Rect;", "focusTargetBounds", "getFocusTargetBounds", "()Landroidx/compose/ui/geometry/Rect;", "setFocusTargetBounds", "(Landroidx/compose/ui/geometry/Rect;)V", "focusTargetBounds$delegate", "Landroidx/compose/runtime/MutableState;", "focusedChild", "focusedChildBeingAnimated", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "oldSize", "Landroidx/compose/ui/unit/IntSize;", "bringChildIntoView", "", "localRect", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateRectForParent", "computeDestination", "childBounds", "containerSize", "computeDestination-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/Rect;", "onPlaced", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "onSizeChanged", "onSizeChanged-O0kMr_c", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)V", "performBringIntoView", "source", "destination", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "relocationDistance", "", "leadingEdge", "trailingEdge", "parentSize", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ContentInViewModifier implements BringIntoViewResponder, OnRemeasuredModifier, OnPlacedModifier {
    @Nullable
    private LayoutCoordinates coordinates;
    /* access modifiers changed from: private */
    @Nullable
    public Job focusAnimationJob;
    @NotNull
    private final MutableState focusTargetBounds$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    /* access modifiers changed from: private */
    @Nullable
    public LayoutCoordinates focusedChild;
    /* access modifiers changed from: private */
    @Nullable
    public LayoutCoordinates focusedChildBeingAnimated;
    @NotNull
    private final Modifier modifier = BringIntoViewResponderKt.bringIntoViewResponder(FocusedBoundsKt.onFocusedBoundsChanged(this, new ContentInViewModifier$modifier$1(this)), this);
    @Nullable
    private IntSize oldSize;
    @NotNull
    private final Orientation orientation;
    private final boolean reverseDirection;
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final ScrollableState scrollableState;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            iArr[Orientation.Vertical.ordinal()] = 1;
            iArr[Orientation.Horizontal.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ContentInViewModifier(@NotNull CoroutineScope coroutineScope, @NotNull Orientation orientation2, @NotNull ScrollableState scrollableState2, boolean z11) {
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        Intrinsics.checkNotNullParameter(scrollableState2, "scrollableState");
        this.scope = coroutineScope;
        this.orientation = orientation2;
        this.scrollableState = scrollableState2;
        this.reverseDirection = z11;
    }

    /* renamed from: computeDestination-O0kMr_c  reason: not valid java name */
    private final Rect m262computeDestinationO0kMr_c(Rect rect, long j11) {
        long r52 = IntSizeKt.m5648toSizeozmzZPI(j11);
        int i11 = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i11 == 1) {
            return rect.translate(0.0f, -relocationDistance(rect.getTop(), rect.getBottom(), Size.m2742getHeightimpl(r52)));
        }
        if (i11 == 2) {
            return rect.translate(-relocationDistance(rect.getLeft(), rect.getRight(), Size.m2745getWidthimpl(r52)), 0.0f);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Rect getFocusTargetBounds() {
        return (Rect) this.focusTargetBounds$delegate.getValue();
    }

    /* renamed from: onSizeChanged-O0kMr_c  reason: not valid java name */
    private final void m263onSizeChangedO0kMr_c(LayoutCoordinates layoutCoordinates, long j11) {
        LayoutCoordinates layoutCoordinates2;
        Rect rect;
        boolean z11 = true;
        if (this.orientation != Orientation.Horizontal ? IntSize.m5637getHeightimpl(layoutCoordinates.m4473getSizeYbymL2g()) >= IntSize.m5637getHeightimpl(j11) : IntSize.m5638getWidthimpl(layoutCoordinates.m4473getSizeYbymL2g()) >= IntSize.m5638getWidthimpl(j11)) {
            z11 = false;
        }
        if (z11 && (layoutCoordinates2 = this.focusedChild) != null) {
            Rect localBoundingBoxOf = layoutCoordinates.localBoundingBoxOf(layoutCoordinates2, false);
            if (layoutCoordinates2 == this.focusedChildBeingAnimated) {
                rect = getFocusTargetBounds();
                if (rect == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            } else {
                rect = localBoundingBoxOf;
            }
            if (RectKt.m2716Recttz77jQw(Offset.Companion.m2692getZeroF1C5BW0(), IntSizeKt.m5648toSizeozmzZPI(j11)).overlaps(rect)) {
                Rect r92 = m262computeDestinationO0kMr_c(rect, layoutCoordinates.m4473getSizeYbymL2g());
                if (!Intrinsics.areEqual((Object) r92, (Object) rect)) {
                    this.focusedChildBeingAnimated = layoutCoordinates2;
                    setFocusTargetBounds(r92);
                    Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, NonCancellable.INSTANCE, (CoroutineStart) null, new ContentInViewModifier$onSizeChanged$1(this, localBoundingBoxOf, r92, (Continuation<? super ContentInViewModifier$onSizeChanged$1>) null), 2, (Object) null);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final Object performBringIntoView(Rect rect, Rect rect2, Continuation<? super Unit> continuation) {
        float f11;
        float f12;
        int i11 = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i11 == 1) {
            f11 = rect2.getTop();
            f12 = rect.getTop();
        } else if (i11 == 2) {
            f11 = rect2.getLeft();
            f12 = rect.getLeft();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        float f13 = f11 - f12;
        if (this.reverseDirection) {
            f13 = -f13;
        }
        Object animateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(this.scrollableState, f13, (AnimationSpec) null, continuation, 2, (Object) null);
        if (animateScrollBy$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return animateScrollBy$default;
        }
        return Unit.INSTANCE;
    }

    private final float relocationDistance(float f11, float f12, float f13) {
        if ((f11 >= 0.0f && f12 <= f13) || (f11 < 0.0f && f12 > f13)) {
            return 0.0f;
        }
        float f14 = f12 - f13;
        return Math.abs(f11) < Math.abs(f14) ? f11 : f14;
    }

    /* access modifiers changed from: private */
    public final void setFocusTargetBounds(Rect rect) {
        this.focusTargetBounds$delegate.setValue(rect);
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    @Nullable
    public Object bringChildIntoView(@NotNull Function0<Rect> function0, @NotNull Continuation<? super Unit> continuation) {
        Rect invoke = function0.invoke();
        if (invoke == null) {
            return Unit.INSTANCE;
        }
        Object performBringIntoView = performBringIntoView(invoke, calculateRectForParent(invoke), continuation);
        if (performBringIntoView == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return performBringIntoView;
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public Rect calculateRectForParent(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "localRect");
        IntSize intSize = this.oldSize;
        if (intSize != null) {
            return m262computeDestinationO0kMr_c(rect, intSize.m5642unboximpl());
        }
        throw new IllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.".toString());
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    @NotNull
    public final Modifier getModifier() {
        return this.modifier;
    }

    public void onPlaced(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        this.coordinates = layoutCoordinates;
    }

    /* renamed from: onRemeasured-ozmzZPI  reason: not valid java name */
    public void m264onRemeasuredozmzZPI(long j11) {
        LayoutCoordinates layoutCoordinates = this.coordinates;
        IntSize intSize = this.oldSize;
        if (intSize != null && !IntSize.m5636equalsimpl0(intSize.m5642unboximpl(), j11)) {
            boolean z11 = false;
            if (layoutCoordinates != null && layoutCoordinates.isAttached()) {
                z11 = true;
            }
            if (z11) {
                m263onSizeChangedO0kMr_c(layoutCoordinates, intSize.m5642unboximpl());
            }
        }
        this.oldSize = IntSize.m5630boximpl(j11);
    }

    public /* synthetic */ Modifier then(Modifier modifier2) {
        return a.a(this, modifier2);
    }
}
