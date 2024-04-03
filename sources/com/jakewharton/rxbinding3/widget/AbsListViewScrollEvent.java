package com.jakewharton.rxbinding3.widget;

import android.widget.AbsListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/AbsListViewScrollEvent;", "", "view", "Landroid/widget/AbsListView;", "scrollState", "", "firstVisibleItem", "visibleItemCount", "totalItemCount", "(Landroid/widget/AbsListView;IIII)V", "getFirstVisibleItem", "()I", "getScrollState", "getTotalItemCount", "getView", "()Landroid/widget/AbsListView;", "getVisibleItemCount", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
public final class AbsListViewScrollEvent {
    private final int firstVisibleItem;
    private final int scrollState;
    private final int totalItemCount;
    @NotNull
    private final AbsListView view;
    private final int visibleItemCount;

    public AbsListViewScrollEvent(@NotNull AbsListView absListView, int i11, int i12, int i13, int i14) {
        Intrinsics.checkParameterIsNotNull(absListView, "view");
        this.view = absListView;
        this.scrollState = i11;
        this.firstVisibleItem = i12;
        this.visibleItemCount = i13;
        this.totalItemCount = i14;
    }

    public static /* synthetic */ AbsListViewScrollEvent copy$default(AbsListViewScrollEvent absListViewScrollEvent, AbsListView absListView, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            absListView = absListViewScrollEvent.view;
        }
        if ((i15 & 2) != 0) {
            i11 = absListViewScrollEvent.scrollState;
        }
        int i16 = i11;
        if ((i15 & 4) != 0) {
            i12 = absListViewScrollEvent.firstVisibleItem;
        }
        int i17 = i12;
        if ((i15 & 8) != 0) {
            i13 = absListViewScrollEvent.visibleItemCount;
        }
        int i18 = i13;
        if ((i15 & 16) != 0) {
            i14 = absListViewScrollEvent.totalItemCount;
        }
        return absListViewScrollEvent.copy(absListView, i16, i17, i18, i14);
    }

    @NotNull
    public final AbsListView component1() {
        return this.view;
    }

    public final int component2() {
        return this.scrollState;
    }

    public final int component3() {
        return this.firstVisibleItem;
    }

    public final int component4() {
        return this.visibleItemCount;
    }

    public final int component5() {
        return this.totalItemCount;
    }

    @NotNull
    public final AbsListViewScrollEvent copy(@NotNull AbsListView absListView, int i11, int i12, int i13, int i14) {
        Intrinsics.checkParameterIsNotNull(absListView, "view");
        return new AbsListViewScrollEvent(absListView, i11, i12, i13, i14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof AbsListViewScrollEvent) {
                AbsListViewScrollEvent absListViewScrollEvent = (AbsListViewScrollEvent) obj;
                if (Intrinsics.areEqual((Object) this.view, (Object) absListViewScrollEvent.view)) {
                    if (this.scrollState == absListViewScrollEvent.scrollState) {
                        if (this.firstVisibleItem == absListViewScrollEvent.firstVisibleItem) {
                            if (this.visibleItemCount == absListViewScrollEvent.visibleItemCount) {
                                if (this.totalItemCount == absListViewScrollEvent.totalItemCount) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int getFirstVisibleItem() {
        return this.firstVisibleItem;
    }

    public final int getScrollState() {
        return this.scrollState;
    }

    public final int getTotalItemCount() {
        return this.totalItemCount;
    }

    @NotNull
    public final AbsListView getView() {
        return this.view;
    }

    public final int getVisibleItemCount() {
        return this.visibleItemCount;
    }

    public int hashCode() {
        AbsListView absListView = this.view;
        return ((((((((absListView != null ? absListView.hashCode() : 0) * 31) + this.scrollState) * 31) + this.firstVisibleItem) * 31) + this.visibleItemCount) * 31) + this.totalItemCount;
    }

    @NotNull
    public String toString() {
        return "AbsListViewScrollEvent(view=" + this.view + ", scrollState=" + this.scrollState + ", firstVisibleItem=" + this.firstVisibleItem + ", visibleItemCount=" + this.visibleItemCount + ", totalItemCount=" + this.totalItemCount + ")";
    }
}
