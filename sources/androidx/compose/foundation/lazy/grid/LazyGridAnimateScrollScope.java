package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import o.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0015\u001a\u00020\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0016J\u0017\u0010\u001f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001d\u001a\u00020\nH\u0016¢\u0006\u0002\u0010 J:\u0010!\u001a\u00020\"2'\u0010#\u001a#\b\u0001\u0012\u0004\u0012\u00020%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0&\u0012\u0006\u0012\u0004\u0018\u00010'0$¢\u0006\u0002\b(H@ø\u0001\u0000¢\u0006\u0002\u0010)J\u001c\u0010*\u001a\u00020\"*\u00020%2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010+\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridAnimateScrollScope;", "Landroidx/compose/foundation/lazy/layout/LazyAnimateScrollScope;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;)V", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "firstVisibleItemIndex", "", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "itemCount", "getItemCount", "lastVisibleItemIndex", "getLastVisibleItemIndex", "numOfItemsForTeleport", "getNumOfItemsForTeleport", "calculateLineAverageMainAxisSize", "visibleItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "isVertical", "", "expectedDistanceTo", "", "index", "targetScrollOffset", "getTargetItemOffset", "(I)Ljava/lang/Integer;", "scroll", "", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapToItem", "scrollOffset", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyGridAnimateScrollScope implements LazyAnimateScrollScope {
    @NotNull
    private final LazyGridState state;

    public LazyGridAnimateScrollScope(@NotNull LazyGridState lazyGridState) {
        Intrinsics.checkNotNullParameter(lazyGridState, "state");
        this.state = lazyGridState;
    }

    private final int calculateLineAverageMainAxisSize(List<? extends LazyGridItemInfo> list, boolean z11) {
        int i11;
        LazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1 lazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1 = new LazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1(z11, list);
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < list.size()) {
            int intValue = ((Number) lazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1.invoke(Integer.valueOf(i12))).intValue();
            if (intValue == -1) {
                i12++;
            } else {
                int i15 = 0;
                while (i12 < list.size() && ((Number) lazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1.invoke(Integer.valueOf(i12))).intValue() == intValue) {
                    if (z11) {
                        i11 = IntSize.m5637getHeightimpl(((LazyGridItemInfo) list.get(i12)).m686getSizeYbymL2g());
                    } else {
                        i11 = IntSize.m5638getWidthimpl(((LazyGridItemInfo) list.get(i12)).m686getSizeYbymL2g());
                    }
                    i15 = Math.max(i15, i11);
                    i12++;
                }
                i13 += i15;
                i14++;
            }
        }
        return i13 / i14;
    }

    public float expectedDistanceTo(int i11, int i12) {
        boolean z11;
        List<LazyGridItemInfo> visibleItemsInfo = this.state.getLayoutInfo().getVisibleItemsInfo();
        int slotsPerLine$foundation_release = this.state.getSlotsPerLine$foundation_release();
        int calculateLineAverageMainAxisSize = calculateLineAverageMainAxisSize(visibleItemsInfo, this.state.isVertical$foundation_release());
        int i13 = 1;
        if (i11 < getFirstVisibleItemIndex()) {
            z11 = true;
        } else {
            z11 = false;
        }
        int firstVisibleItemIndex = i11 - getFirstVisibleItemIndex();
        int i14 = slotsPerLine$foundation_release - 1;
        if (z11) {
            i13 = -1;
        }
        return (((float) (calculateLineAverageMainAxisSize * ((firstVisibleItemIndex + (i14 * i13)) / slotsPerLine$foundation_release))) + ((float) i12)) - ((float) getFirstVisibleItemScrollOffset());
    }

    @NotNull
    public Density getDensity() {
        return this.state.getDensity$foundation_release();
    }

    public int getFirstVisibleItemIndex() {
        return this.state.getFirstVisibleItemIndex();
    }

    public int getFirstVisibleItemScrollOffset() {
        return this.state.getFirstVisibleItemScrollOffset();
    }

    public int getItemCount() {
        return this.state.getLayoutInfo().getTotalItemsCount();
    }

    public int getLastVisibleItemIndex() {
        LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt___CollectionsKt.lastOrNull(this.state.getLayoutInfo().getVisibleItemsInfo());
        if (lazyGridItemInfo != null) {
            return lazyGridItemInfo.getIndex();
        }
        return 0;
    }

    public int getNumOfItemsForTeleport() {
        return this.state.getSlotsPerLine$foundation_release() * 100;
    }

    @Nullable
    public Integer getTargetItemOffset(int i11) {
        LazyGridItemInfo lazyGridItemInfo;
        int i12;
        boolean z11;
        List<LazyGridItemInfo> visibleItemsInfo = this.state.getLayoutInfo().getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i13 = 0;
        while (true) {
            if (i13 >= size) {
                lazyGridItemInfo = null;
                break;
            }
            lazyGridItemInfo = visibleItemsInfo.get(i13);
            if (lazyGridItemInfo.getIndex() == i11) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                break;
            }
            i13++;
        }
        LazyGridItemInfo lazyGridItemInfo2 = lazyGridItemInfo;
        if (lazyGridItemInfo2 == null) {
            return null;
        }
        if (this.state.isVertical$foundation_release()) {
            i12 = IntOffset.m5597getYimpl(lazyGridItemInfo2.m685getOffsetnOccac());
        } else {
            i12 = IntOffset.m5596getXimpl(lazyGridItemInfo2.m685getOffsetnOccac());
        }
        return Integer.valueOf(i12);
    }

    @Nullable
    public Object scroll(@NotNull Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        Object a11 = c.a(this.state, (MutatePriority) null, function2, continuation, 1, (Object) null);
        return a11 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a11 : Unit.INSTANCE;
    }

    public void snapToItem(@NotNull ScrollScope scrollScope, int i11, int i12) {
        Intrinsics.checkNotNullParameter(scrollScope, "<this>");
        this.state.snapToItemIndexInternal$foundation_release(i11, i12);
    }
}
