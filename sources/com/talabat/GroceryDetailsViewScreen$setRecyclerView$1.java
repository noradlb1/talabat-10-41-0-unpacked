package com.talabat;

import android.text.TextUtils;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.materialedittext.MaterialEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/talabat/GroceryDetailsViewScreen$setRecyclerView$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryDetailsViewScreen$setRecyclerView$1 extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsViewScreen f54108a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<GridLayoutManager> f54109b;

    public GroceryDetailsViewScreen$setRecyclerView$1(GroceryDetailsViewScreen groceryDetailsViewScreen, Ref.ObjectRef<GridLayoutManager> objectRef) {
        this.f54108a = groceryDetailsViewScreen;
        this.f54109b = objectRef;
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i11, i12);
        if (TextUtils.isEmpty(StringsKt__StringsKt.trim((CharSequence) String.valueOf(((MaterialEditText) this.f54108a._$_findCachedViewById(R.id.search_field)).getText())).toString())) {
            if (i12 > 0 && !this.f54108a.getGroceryDetailsPresenter().isAllItemsLoaded()) {
                this.f54108a.setVisibleItemCount(((GridLayoutManager) this.f54109b.element).getChildCount());
                this.f54108a.setFirstVisibleItem(((GridLayoutManager) this.f54109b.element).findFirstVisibleItemPosition());
                if (this.f54108a.loading) {
                    return;
                }
                if (this.f54108a.getVisibleItemCount() + this.f54108a.getFirstVisibleItem() >= this.f54108a.getTotalItemCount() || (this.f54108a.getVisibleItemCount() + this.f54108a.getFirstVisibleItem() == ((GridLayoutManager) this.f54109b.element).getItemCount() && ((GridLayoutManager) this.f54109b.element).getItemCount() < this.f54108a.getTotalItemCount())) {
                    String.valueOf(this.f54108a.getPageNumber());
                    if (this.f54108a.getPageNumber() == 1 && this.f54108a.getTotalPages() > 1) {
                        GroceryDetailsViewScreen groceryDetailsViewScreen = this.f54108a;
                        groceryDetailsViewScreen.setPageNumber(groceryDetailsViewScreen.getPageNumber() + 1);
                    }
                    if (this.f54108a.getPageNumber() <= this.f54108a.getTotalPages()) {
                        GroceryDetailsViewScreen groceryDetailsViewScreen2 = this.f54108a;
                        int i13 = R.id.linear_progressBar;
                        ((ProgressBar) groceryDetailsViewScreen2._$_findCachedViewById(i13)).setIndeterminate(true);
                        ((ProgressBar) this.f54108a._$_findCachedViewById(i13)).setVisibility(0);
                        this.f54108a.getGroceryDetailsPresenter().loadMoreItems(this.f54108a.getPageNumber());
                        this.f54108a.loading = true;
                    }
                }
            }
        } else if (i12 > 0 && !this.f54108a.allItemsForCurrentKeywordLoaded) {
            this.f54108a.setVisibleItemCount(((GridLayoutManager) this.f54109b.element).getChildCount());
            this.f54108a.setTotalItemCount(((GridLayoutManager) this.f54109b.element).getItemCount());
            this.f54108a.setFirstVisibleItem(((GridLayoutManager) this.f54109b.element).findFirstVisibleItemPosition());
            if (!this.f54108a.loading && this.f54108a.getVisibleItemCount() + this.f54108a.getFirstVisibleItem() >= this.f54108a.getTotalItemCount()) {
                int access$getSearchPageNumber$p = this.f54108a.searchPageNumber;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("searchPageNumber ");
                sb2.append(access$getSearchPageNumber$p);
                if (this.f54108a.searchPageNumber <= this.f54108a.getTotalPages()) {
                    ((ProgressBar) this.f54108a._$_findCachedViewById(R.id.linear_progressBar)).setVisibility(0);
                    this.f54108a.getGroceryDetailsPresenter().setNewPageNumber(this.f54108a.searchPageNumber);
                }
                this.f54108a.loading = true;
            }
        }
    }
}
