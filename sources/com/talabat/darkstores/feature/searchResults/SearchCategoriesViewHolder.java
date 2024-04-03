package com.talabat.darkstores.feature.searchResults;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.data.SearchCategory;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b¢\u0006\u0002\u0010\tJ\u001e\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchCategoriesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "categoryClickListener", "Lkotlin/Function1;", "", "", "Lcom/talabat/darkstores/feature/searchResults/CategoryClickListener;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "categoriesAdapter", "Lcom/talabat/darkstores/feature/searchResults/SearchCategoriesAdapter;", "bind", "categories", "", "Lcom/talabat/darkstores/data/SearchCategory;", "selectedCategoryId", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchCategoriesViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final SearchCategoriesAdapter categoriesAdapter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchCategoriesViewHolder(@NotNull View view, @NotNull Function1<? super String, Unit> function1) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(function1, "categoryClickListener");
        SearchCategoriesAdapter searchCategoriesAdapter = new SearchCategoriesAdapter(function1);
        this.categoriesAdapter = searchCategoriesAdapter;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.search_categories);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.setAdapter(searchCategoriesAdapter);
    }

    public final void bind(@NotNull List<SearchCategory> list, @Nullable String str) {
        Intrinsics.checkNotNullParameter(list, "categories");
        this.categoriesAdapter.submitList(list);
        this.categoriesAdapter.selectCategory(str);
        Iterator<SearchCategory> it = list.iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            } else if (Intrinsics.areEqual((Object) it.next().getId(), (Object) str)) {
                break;
            } else {
                i11++;
            }
        }
        ((RecyclerView) this.itemView.findViewById(R.id.search_categories)).scrollToPosition(RangesKt___RangesKt.coerceAtLeast(i11, 0));
    }
}
