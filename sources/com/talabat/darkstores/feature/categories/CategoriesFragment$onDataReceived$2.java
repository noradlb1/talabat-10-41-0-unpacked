package com.talabat.darkstores.feature.categories;

import androidx.viewpager.widget.ViewPager;
import com.talabat.darkstores.model.Category;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/talabat/darkstores/feature/categories/CategoriesFragment$onDataReceived$2", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CategoriesFragment$onDataReceived$2 implements ViewPager.OnPageChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CategoriesFragment f56307b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List<Category> f56308c;

    public CategoriesFragment$onDataReceived$2(CategoriesFragment categoriesFragment, List<Category> list) {
        this.f56307b = categoriesFragment;
        this.f56308c = list;
    }

    public void onPageScrollStateChanged(int i11) {
    }

    public void onPageScrolled(int i11, float f11, int i12) {
    }

    public void onPageSelected(int i11) {
        CategoriesFragmentViewModel access$getViewModel = this.f56307b.getViewModel();
        List<Category> list = this.f56308c;
        this.f56307b.getViewModel().trackCategorySelected(access$getViewModel.getTopLevelCategory(list, list.get(i11).getId()), i11);
    }
}
