package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001Bf\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0019\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010'2\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000J\u000e\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u001e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-R\u0011\u0010\u0015\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u001d\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0019R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0019\u0010\u0012\u001a\u00020\u0013X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\"\u001a\u00020\u0003*\u00020#8BX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/foundation/lazy/LazyListPositionedItem;", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "offset", "", "index", "key", "", "size", "sizeWithSpacings", "minMainAxisOffset", "maxMainAxisOffset", "isVertical", "", "wrappers", "", "Landroidx/compose/foundation/lazy/LazyListPlaceableWrapper;", "placementAnimator", "Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "(IILjava/lang/Object;IIIIZLjava/util/List;Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "hasAnimations", "getHasAnimations", "()Z", "getIndex", "()I", "getKey", "()Ljava/lang/Object;", "getOffset", "placeablesCount", "getPlaceablesCount", "getSize", "getSizeWithSpacings", "J", "mainAxisSize", "Landroidx/compose/ui/layout/Placeable;", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "getAnimationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "getOffset-Bjo55l4", "(I)J", "place", "", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyListPositionedItem implements LazyListItemInfo {
    private final boolean hasAnimations;
    private final int index;
    private final boolean isVertical;
    @NotNull
    private final Object key;
    private final int maxMainAxisOffset;
    private final int minMainAxisOffset;
    private final int offset;
    @NotNull
    private final LazyListItemPlacementAnimator placementAnimator;
    private final int size;
    private final int sizeWithSpacings;
    private final long visualOffset;
    @NotNull
    private final List<LazyListPlaceableWrapper> wrappers;

    private LazyListPositionedItem(int i11, int i12, Object obj, int i13, int i14, int i15, int i16, boolean z11, List<LazyListPlaceableWrapper> list, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, long j11) {
        this.offset = i11;
        this.index = i12;
        this.key = obj;
        this.size = i13;
        this.sizeWithSpacings = i14;
        this.minMainAxisOffset = i15;
        this.maxMainAxisOffset = i16;
        this.isVertical = z11;
        this.wrappers = list;
        this.placementAnimator = lazyListItemPlacementAnimator;
        this.visualOffset = j11;
        int placeablesCount = getPlaceablesCount();
        boolean z12 = false;
        int i17 = 0;
        while (true) {
            if (i17 >= placeablesCount) {
                break;
            } else if (getAnimationSpec(i17) != null) {
                z12 = true;
                break;
            } else {
                i17++;
            }
        }
        this.hasAnimations = z12;
    }

    public /* synthetic */ LazyListPositionedItem(int i11, int i12, Object obj, int i13, int i14, int i15, int i16, boolean z11, List list, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12, obj, i13, i14, i15, i16, z11, list, lazyListItemPlacementAnimator, j11);
    }

    @Nullable
    public final FiniteAnimationSpec<IntOffset> getAnimationSpec(int i11) {
        Object parentData = this.wrappers.get(i11).getParentData();
        if (parentData instanceof FiniteAnimationSpec) {
            return (FiniteAnimationSpec) parentData;
        }
        return null;
    }

    public final boolean getHasAnimations() {
        return this.hasAnimations;
    }

    public int getIndex() {
        return this.index;
    }

    @NotNull
    public Object getKey() {
        return this.key;
    }

    public final int getMainAxisSize(int i11) {
        return getMainAxisSize(this.wrappers.get(i11).getPlaceable());
    }

    public int getOffset() {
        return this.offset;
    }

    /* renamed from: getOffset-Bjo55l4  reason: not valid java name */
    public final long m641getOffsetBjo55l4(int i11) {
        return this.wrappers.get(i11).m640getOffsetnOccac();
    }

    public final int getPlaceablesCount() {
        return this.wrappers.size();
    }

    public int getSize() {
        return this.size;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    public final void place(@NotNull Placeable.PlacementScope placementScope) {
        long j11;
        Intrinsics.checkNotNullParameter(placementScope, "scope");
        int placeablesCount = getPlaceablesCount();
        for (int i11 = 0; i11 < placeablesCount; i11++) {
            Placeable placeable = this.wrappers.get(i11).getPlaceable();
            int mainAxisSize = this.minMainAxisOffset - getMainAxisSize(placeable);
            int i12 = this.maxMainAxisOffset;
            if (getAnimationSpec(i11) != null) {
                j11 = this.placementAnimator.m633getAnimatedOffsetYT5a7pE(getKey(), i11, mainAxisSize, i12, m641getOffsetBjo55l4(i11));
            } else {
                j11 = m641getOffsetBjo55l4(i11);
            }
            if (this.isVertical) {
                long j12 = this.visualOffset;
                Placeable.PlacementScope.m4532placeWithLayeraW9wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(j11) + IntOffset.m5596getXimpl(j12), IntOffset.m5597getYimpl(j11) + IntOffset.m5597getYimpl(j12)), 0.0f, (Function1) null, 6, (Object) null);
            } else {
                long j13 = this.visualOffset;
                Placeable.PlacementScope.m4531placeRelativeWithLayeraW9wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(j11) + IntOffset.m5596getXimpl(j13), IntOffset.m5597getYimpl(j11) + IntOffset.m5597getYimpl(j13)), 0.0f, (Function1) null, 6, (Object) null);
            }
        }
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }
}
