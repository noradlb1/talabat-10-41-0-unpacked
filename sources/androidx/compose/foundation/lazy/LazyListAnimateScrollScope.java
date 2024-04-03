package androidx.compose.foundation.lazy;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import o.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u001aJ:\u0010\u001b\u001a\u00020\u001c2'\u0010\u001d\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001e¢\u0006\u0002\b\"H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u001c\u0010$\u001a\u00020\u001c*\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListAnimateScrollScope;", "Landroidx/compose/foundation/lazy/layout/LazyAnimateScrollScope;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;)V", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "firstVisibleItemIndex", "", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "itemCount", "getItemCount", "lastVisibleItemIndex", "getLastVisibleItemIndex", "numOfItemsForTeleport", "getNumOfItemsForTeleport", "expectedDistanceTo", "", "index", "targetScrollOffset", "getTargetItemOffset", "(I)Ljava/lang/Integer;", "scroll", "", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapToItem", "scrollOffset", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyListAnimateScrollScope implements LazyAnimateScrollScope {
    private final int numOfItemsForTeleport = 100;
    @NotNull
    private final LazyListState state;

    public LazyListAnimateScrollScope(@NotNull LazyListState lazyListState) {
        Intrinsics.checkNotNullParameter(lazyListState, "state");
        this.state = lazyListState;
    }

    public float expectedDistanceTo(int i11, int i12) {
        List<LazyListItemInfo> visibleItemsInfo = this.state.getLayoutInfo().getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i13 = 0;
        for (int i14 = 0; i14 < size; i14++) {
            i13 += visibleItemsInfo.get(i14).getSize();
        }
        return (((float) ((i13 / visibleItemsInfo.size()) * (i11 - getFirstVisibleItemIndex()))) + ((float) i12)) - ((float) getFirstVisibleItemScrollOffset());
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
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt___CollectionsKt.lastOrNull(this.state.getLayoutInfo().getVisibleItemsInfo());
        if (lazyListItemInfo != null) {
            return lazyListItemInfo.getIndex();
        }
        return 0;
    }

    public int getNumOfItemsForTeleport() {
        return this.numOfItemsForTeleport;
    }

    @Nullable
    public Integer getTargetItemOffset(int i11) {
        LazyListItemInfo lazyListItemInfo;
        boolean z11;
        List<LazyListItemInfo> visibleItemsInfo = this.state.getLayoutInfo().getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i12 = 0;
        while (true) {
            if (i12 >= size) {
                lazyListItemInfo = null;
                break;
            }
            lazyListItemInfo = visibleItemsInfo.get(i12);
            if (lazyListItemInfo.getIndex() == i11) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                break;
            }
            i12++;
        }
        LazyListItemInfo lazyListItemInfo2 = lazyListItemInfo;
        if (lazyListItemInfo2 != null) {
            return Integer.valueOf(lazyListItemInfo2.getOffset());
        }
        return null;
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
