package com.talabat.talabatcommon.listeners;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\fH&J \u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/listeners/PaginationScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setLayoutManager", "isLastPage", "", "isLoading", "loadMoreItems", "", "onScrolled", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class PaginationScrollListener extends RecyclerView.OnScrollListener {
    @NotNull
    private LinearLayoutManager layoutManager;

    public PaginationScrollListener(@NotNull LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        this.layoutManager = linearLayoutManager;
    }

    @NotNull
    public final LinearLayoutManager getLayoutManager() {
        return this.layoutManager;
    }

    public abstract boolean isLastPage();

    public abstract boolean isLoading();

    public abstract void loadMoreItems();

    public void onScrolled(@NotNull RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i11, i12);
        int childCount = this.layoutManager.getChildCount();
        int itemCount = this.layoutManager.getItemCount();
        int findFirstVisibleItemPosition = this.layoutManager.findFirstVisibleItemPosition();
        if (!isLoading() && !isLastPage() && childCount + findFirstVisibleItemPosition >= itemCount && findFirstVisibleItemPosition >= 0) {
            loadMoreItems();
        }
    }

    public final void setLayoutManager(@NotNull LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkNotNullParameter(linearLayoutManager, "<set-?>");
        this.layoutManager = linearLayoutManager;
    }
}
