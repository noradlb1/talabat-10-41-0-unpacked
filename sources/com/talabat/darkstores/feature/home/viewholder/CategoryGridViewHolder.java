package com.talabat.darkstores.feature.home.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.home.CategoriesListAdapter;
import com.talabat.darkstores.feature.home.CategoryViewHolderData;
import com.talabat.darkstores.feature.home.categories.CategoriesMissionView;
import com.talabat.darkstores.model.Category;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B~\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012:\u0010\u0006\u001a6\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u000e\u0012+\u0010\u000f\u001a'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b0\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\r0\u0010j\u0002`\u0013¢\u0006\u0002\u0010\u0014J\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u001cR\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0018X\u0004¢\u0006\u0002\n\u0000RE\u0010\u0006\u001a6\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/talabat/darkstores/feature/home/viewholder/CategoryGridViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "categoriesRowsCount", "", "onCategoryClicked", "Lkotlin/Function2;", "Lcom/talabat/darkstores/model/Category;", "Lkotlin/ParameterName;", "name", "item", "position", "", "Lcom/talabat/darkstores/feature/home/OnCategoryClicked;", "onViewAllCategoryClicked", "Lkotlin/Function1;", "", "categoryList", "Lcom/talabat/darkstores/feature/home/viewholder/OnViewAllCategoryClicked;", "(Landroid/view/View;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "categoriesListAdapter", "Lcom/talabat/darkstores/feature/home/CategoriesListAdapter;", "itemList", "", "getOnCategoryClicked", "()Lkotlin/jvm/functions/Function2;", "bind", "Lcom/talabat/darkstores/feature/home/CategoryViewHolderData;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CategoryGridViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final CategoriesListAdapter categoriesListAdapter;
    /* access modifiers changed from: private */
    @NotNull
    public final List<Category> itemList = new ArrayList();
    @NotNull
    private final Function2<Category, Integer, Unit> onCategoryClicked;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CategoryGridViewHolder(@NotNull View view, int i11, @NotNull Function2<? super Category, ? super Integer, Unit> function2, @NotNull Function1<? super List<Category>, Unit> function1) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(function2, "onCategoryClicked");
        Intrinsics.checkNotNullParameter(function1, "onViewAllCategoryClicked");
        this.onCategoryClicked = function2;
        CategoriesListAdapter categoriesListAdapter2 = new CategoriesListAdapter(function2, new CategoryGridViewHolder$categoriesListAdapter$1(function1, this), true, i11);
        this.categoriesListAdapter = categoriesListAdapter2;
        ((RecyclerView) this.itemView.findViewById(R.id.recyclerView)).setAdapter(categoriesListAdapter2);
    }

    public final void bind(@NotNull CategoryViewHolderData categoryViewHolderData) {
        Intrinsics.checkNotNullParameter(categoryViewHolderData, "item");
        this.itemList.clear();
        this.itemList.addAll(categoryViewHolderData.getCategories());
        this.categoriesListAdapter.submitCategories(this.itemList);
        List<Category> topTwoCategories = categoryViewHolderData.getTopTwoCategories();
        if (topTwoCategories.size() == 2) {
            View view = this.itemView;
            int i11 = R.id.topTwoCategoriesView;
            CategoriesMissionView categoriesMissionView = (CategoriesMissionView) view.findViewById(i11);
            Intrinsics.checkNotNullExpressionValue(categoriesMissionView, "itemView.topTwoCategoriesView");
            categoriesMissionView.setVisibility(0);
            ((CategoriesMissionView) this.itemView.findViewById(i11)).setContent(topTwoCategories.get(0), topTwoCategories.get(1), new CategoryGridViewHolder$bind$1(this));
            return;
        }
        CategoriesMissionView categoriesMissionView2 = (CategoriesMissionView) this.itemView.findViewById(R.id.topTwoCategoriesView);
        Intrinsics.checkNotNullExpressionValue(categoriesMissionView2, "itemView.topTwoCategoriesView");
        categoriesMissionView2.setVisibility(8);
    }

    @NotNull
    public final Function2<Category, Integer, Unit> getOnCategoryClicked() {
        return this.onCategoryClicked;
    }
}
