package com.talabat.darkstores.feature.categories.subcategories;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/talabat/darkstores/feature/categories/subcategories/SubcategoriesFragment$setupSwimlanesRecyclerView$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesFragment$setupSwimlanesRecyclerView$1$1 extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragment f56321a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GridLayoutManager f56322b;

    public SubcategoriesFragment$setupSwimlanesRecyclerView$1$1(SubcategoriesFragment subcategoriesFragment, GridLayoutManager gridLayoutManager) {
        this.f56321a = subcategoriesFragment;
        this.f56322b = gridLayoutManager;
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.f56321a.getViewModel().setScrollPosition(this.f56322b.findFirstVisibleItemPosition());
    }
}
