package com.talabat.sdsquad.ui.restaurantssearch.globalsearch;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchCellType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/talabat/sdsquad/ui/restaurantssearch/globalsearch/GlobalSearchFragment$mListScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalSearchFragment$mListScrollListener$1 extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlobalSearchFragment f61341a;

    public GlobalSearchFragment$mListScrollListener$1(GlobalSearchFragment globalSearchFragment) {
        this.f61341a = globalSearchFragment;
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i11, int i12) {
        TabLayout.Tab tabAt;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i11, i12);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(linearLayoutManager);
        View findViewByPosition = linearLayoutManager.findViewByPosition(linearLayoutManager.findFirstVisibleItemPosition());
        Intrinsics.checkNotNull(findViewByPosition);
        if (linearLayoutManager.getItemViewType(findViewByPosition) == GlobalSearchCellType.DishHeader.ordinal() || linearLayoutManager.getItemViewType(findViewByPosition) == GlobalSearchCellType.Dish.ordinal()) {
            GlobalSearchFragment globalSearchFragment = this.f61341a;
            int i13 = R.id.tabLayout;
            if (((TabLayout) globalSearchFragment._$_findCachedViewById(i13)).getTabCount() > 1 && (tabAt = ((TabLayout) this.f61341a._$_findCachedViewById(i13)).getTabAt(1)) != null) {
                GlobalSearchFragment globalSearchFragment2 = this.f61341a;
                if (!tabAt.isSelected()) {
                    ((TabLayout) globalSearchFragment2._$_findCachedViewById(i13)).removeOnTabSelectedListener(globalSearchFragment2.mTabSelectedListener);
                    TabLayout.Tab tabAt2 = ((TabLayout) globalSearchFragment2._$_findCachedViewById(i13)).getTabAt(1);
                    if (tabAt2 != null) {
                        tabAt2.select();
                    }
                    ((TabLayout) globalSearchFragment2._$_findCachedViewById(i13)).addOnTabSelectedListener(globalSearchFragment2.mTabSelectedListener);
                }
            }
        } else if (linearLayoutManager.getItemViewType(findViewByPosition) == GlobalSearchCellType.VendorHeader.ordinal() || linearLayoutManager.getItemViewType(findViewByPosition) == GlobalSearchCellType.Vendor.ordinal()) {
            GlobalSearchFragment globalSearchFragment3 = this.f61341a;
            int i14 = R.id.tabLayout;
            TabLayout.Tab tabAt3 = ((TabLayout) globalSearchFragment3._$_findCachedViewById(i14)).getTabAt(0);
            if (tabAt3 != null) {
                GlobalSearchFragment globalSearchFragment4 = this.f61341a;
                if (!tabAt3.isSelected()) {
                    ((TabLayout) globalSearchFragment4._$_findCachedViewById(i14)).removeOnTabSelectedListener(globalSearchFragment4.mTabSelectedListener);
                    TabLayout.Tab tabAt4 = ((TabLayout) globalSearchFragment4._$_findCachedViewById(i14)).getTabAt(0);
                    if (tabAt4 != null) {
                        tabAt4.select();
                    }
                    ((TabLayout) globalSearchFragment4._$_findCachedViewById(i14)).addOnTabSelectedListener(globalSearchFragment4.mTabSelectedListener);
                }
            }
        }
    }
}
