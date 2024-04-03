package com.deliveryhero.impression.view.viewpager;

import com.deliveryhero.impression.view.ItemVisibleArea;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/deliveryhero/impression/view/viewpager/ViewPagerInfo;", "", "showTime", "", "hideTime", "visibleArea", "Lcom/deliveryhero/impression/view/ItemVisibleArea;", "(JJLcom/deliveryhero/impression/view/ItemVisibleArea;)V", "getHideTime", "()J", "setHideTime", "(J)V", "getShowTime", "setShowTime", "getVisibleArea", "()Lcom/deliveryhero/impression/view/ItemVisibleArea;", "setVisibleArea", "(Lcom/deliveryhero/impression/view/ItemVisibleArea;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ViewPagerInfo {
    private long hideTime;
    private long showTime;
    @NotNull
    private ItemVisibleArea visibleArea;

    public ViewPagerInfo(long j11, long j12, @NotNull ItemVisibleArea itemVisibleArea) {
        Intrinsics.checkNotNullParameter(itemVisibleArea, "visibleArea");
        this.showTime = j11;
        this.hideTime = j12;
        this.visibleArea = itemVisibleArea;
    }

    public static /* synthetic */ ViewPagerInfo copy$default(ViewPagerInfo viewPagerInfo, long j11, long j12, ItemVisibleArea itemVisibleArea, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = viewPagerInfo.showTime;
        }
        long j13 = j11;
        if ((i11 & 2) != 0) {
            j12 = viewPagerInfo.hideTime;
        }
        long j14 = j12;
        if ((i11 & 4) != 0) {
            itemVisibleArea = viewPagerInfo.visibleArea;
        }
        return viewPagerInfo.copy(j13, j14, itemVisibleArea);
    }

    public final long component1() {
        return this.showTime;
    }

    public final long component2() {
        return this.hideTime;
    }

    @NotNull
    public final ItemVisibleArea component3() {
        return this.visibleArea;
    }

    @NotNull
    public final ViewPagerInfo copy(long j11, long j12, @NotNull ItemVisibleArea itemVisibleArea) {
        Intrinsics.checkNotNullParameter(itemVisibleArea, "visibleArea");
        return new ViewPagerInfo(j11, j12, itemVisibleArea);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewPagerInfo)) {
            return false;
        }
        ViewPagerInfo viewPagerInfo = (ViewPagerInfo) obj;
        return this.showTime == viewPagerInfo.showTime && this.hideTime == viewPagerInfo.hideTime && Intrinsics.areEqual((Object) this.visibleArea, (Object) viewPagerInfo.visibleArea);
    }

    public final long getHideTime() {
        return this.hideTime;
    }

    public final long getShowTime() {
        return this.showTime;
    }

    @NotNull
    public final ItemVisibleArea getVisibleArea() {
        return this.visibleArea;
    }

    public int hashCode() {
        return (((a.a(this.showTime) * 31) + a.a(this.hideTime)) * 31) + this.visibleArea.hashCode();
    }

    public final void setHideTime(long j11) {
        this.hideTime = j11;
    }

    public final void setShowTime(long j11) {
        this.showTime = j11;
    }

    public final void setVisibleArea(@NotNull ItemVisibleArea itemVisibleArea) {
        Intrinsics.checkNotNullParameter(itemVisibleArea, "<set-?>");
        this.visibleArea = itemVisibleArea;
    }

    @NotNull
    public String toString() {
        return "ViewPagerInfo(showTime=" + this.showTime + ", hideTime=" + this.hideTime + ", visibleArea=" + this.visibleArea + ')';
    }
}
