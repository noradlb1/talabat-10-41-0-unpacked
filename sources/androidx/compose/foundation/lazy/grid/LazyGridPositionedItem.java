package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0019\u00106\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001072\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000J\u0006\u00108\u001a\u00020\u0006J\u0006\u00109\u001a\u00020\u0006J\u000e\u00104\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=R\u0014\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010#\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b$\u0010\u001bR\u0011\u0010%\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b&\u0010\u001bR\u000e\u0010\u000e\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010)\u001a\u0004\b*\u0010(R\u0011\u0010+\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b,\u0010\u001bR\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\u001f\u0010\u000b\u001a\u00020\fX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010)\u001a\u0004\b.\u0010(R\u0019\u0010\u0018\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010)R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u00020\u0006*\u00020\u00038BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b0\u00101R\u0018\u00102\u001a\u00020\u0006*\u0002038BX\u0004¢\u0006\u0006\u001a\u0004\b4\u00105\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006>"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "placeableOffset", "index", "", "key", "", "row", "column", "size", "Landroidx/compose/ui/unit/IntSize;", "lineMainAxisSize", "mainAxisSpacing", "minMainAxisOffset", "maxMainAxisOffset", "isVertical", "", "wrappers", "", "Landroidx/compose/foundation/lazy/grid/LazyGridPlaceableWrapper;", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "visualOffset", "(JJILjava/lang/Object;IIJIIIIZLjava/util/List;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColumn", "()I", "hasAnimations", "getHasAnimations", "()Z", "getIndex", "getKey", "()Ljava/lang/Object;", "getLineMainAxisSize", "lineMainAxisSizeWithSpacings", "getLineMainAxisSizeWithSpacings", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "getOffset-nOcc-ac", "()J", "J", "getPlaceableOffset-nOcc-ac", "placeablesCount", "getPlaceablesCount", "getRow", "getSize-YbymL2g", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "mainAxisSize", "Landroidx/compose/ui/layout/Placeable;", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "getAnimationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "getCrossAxisOffset", "getCrossAxisSize", "place", "", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyGridPositionedItem implements LazyGridItemInfo {
    private final int column;
    private final boolean hasAnimations;
    private final int index;
    private final boolean isVertical;
    @NotNull
    private final Object key;
    private final int lineMainAxisSize;
    private final int mainAxisSpacing;
    private final int maxMainAxisOffset;
    private final int minMainAxisOffset;
    private final long offset;
    private final long placeableOffset;
    @NotNull
    private final LazyGridItemPlacementAnimator placementAnimator;
    private final int row;
    private final long size;
    private final long visualOffset;
    @NotNull
    private final List<LazyGridPlaceableWrapper> wrappers;

    private LazyGridPositionedItem(long j11, long j12, int i11, Object obj, int i12, int i13, long j13, int i14, int i15, int i16, int i17, boolean z11, List<LazyGridPlaceableWrapper> list, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j14) {
        this.offset = j11;
        this.placeableOffset = j12;
        this.index = i11;
        this.key = obj;
        this.row = i12;
        this.column = i13;
        this.size = j13;
        this.lineMainAxisSize = i14;
        this.mainAxisSpacing = i15;
        this.minMainAxisOffset = i16;
        this.maxMainAxisOffset = i17;
        this.isVertical = z11;
        this.wrappers = list;
        this.placementAnimator = lazyGridItemPlacementAnimator;
        this.visualOffset = j14;
        int placeablesCount = getPlaceablesCount();
        boolean z12 = false;
        int i18 = 0;
        while (true) {
            if (i18 >= placeablesCount) {
                break;
            } else if (getAnimationSpec(i18) != null) {
                z12 = true;
                break;
            } else {
                i18++;
            }
        }
        this.hasAnimations = z12;
    }

    public /* synthetic */ LazyGridPositionedItem(long j11, long j12, int i11, Object obj, int i12, int i13, long j13, int i14, int i15, int i16, int i17, boolean z11, List list, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j14, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, i11, obj, i12, i13, j13, i14, i15, i16, i17, z11, list, lazyGridItemPlacementAnimator, j14);
    }

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m702getMainAxisgyyYBs(long j11) {
        return this.isVertical ? IntOffset.m5597getYimpl(j11) : IntOffset.m5596getXimpl(j11);
    }

    @Nullable
    public final FiniteAnimationSpec<IntOffset> getAnimationSpec(int i11) {
        Object parentData = this.wrappers.get(i11).getParentData();
        if (parentData instanceof FiniteAnimationSpec) {
            return (FiniteAnimationSpec) parentData;
        }
        return null;
    }

    public int getColumn() {
        return this.column;
    }

    public final int getCrossAxisOffset() {
        return this.isVertical ? IntOffset.m5596getXimpl(m703getOffsetnOccac()) : IntOffset.m5597getYimpl(m703getOffsetnOccac());
    }

    public final int getCrossAxisSize() {
        return this.isVertical ? IntSize.m5638getWidthimpl(m705getSizeYbymL2g()) : IntSize.m5637getHeightimpl(m705getSizeYbymL2g());
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

    public final int getLineMainAxisSize() {
        return this.lineMainAxisSize;
    }

    public final int getLineMainAxisSizeWithSpacings() {
        return this.mainAxisSpacing + this.lineMainAxisSize;
    }

    public final int getMainAxisSize(int i11) {
        return getMainAxisSize(this.wrappers.get(i11).getPlaceable());
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSpacing + (this.isVertical ? IntSize.m5637getHeightimpl(m705getSizeYbymL2g()) : IntSize.m5638getWidthimpl(m705getSizeYbymL2g()));
    }

    /* renamed from: getOffset-nOcc-ac  reason: not valid java name */
    public long m703getOffsetnOccac() {
        return this.offset;
    }

    /* renamed from: getPlaceableOffset-nOcc-ac  reason: not valid java name */
    public final long m704getPlaceableOffsetnOccac() {
        return this.placeableOffset;
    }

    public final int getPlaceablesCount() {
        return this.wrappers.size();
    }

    public int getRow() {
        return this.row;
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public long m705getSizeYbymL2g() {
        return this.size;
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
                j11 = this.placementAnimator.m690getAnimatedOffsetYT5a7pE(getKey(), i11, mainAxisSize, i12, this.placeableOffset);
            } else {
                j11 = this.placeableOffset;
            }
            if (m702getMainAxisgyyYBs(j11) > mainAxisSize && m702getMainAxisgyyYBs(j11) < i12) {
                if (this.isVertical) {
                    long j12 = this.visualOffset;
                    Placeable.PlacementScope.m4532placeWithLayeraW9wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(j11) + IntOffset.m5596getXimpl(j12), IntOffset.m5597getYimpl(j11) + IntOffset.m5597getYimpl(j12)), 0.0f, (Function1) null, 6, (Object) null);
                } else {
                    long j13 = this.visualOffset;
                    Placeable.PlacementScope.m4531placeRelativeWithLayeraW9wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(j11) + IntOffset.m5596getXimpl(j13), IntOffset.m5597getYimpl(j11) + IntOffset.m5597getYimpl(j13)), 0.0f, (Function1) null, 6, (Object) null);
                }
            }
        }
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }
}
