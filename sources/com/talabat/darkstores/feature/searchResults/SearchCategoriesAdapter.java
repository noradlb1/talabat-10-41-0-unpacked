package com.talabat.darkstores.feature.searchResults;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.talabat.darkstores.R;
import com.talabat.darkstores.data.SearchCategory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import oj.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0015\u0016B\u001f\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u000b\u001a\u00020\u00072\n\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006R \u0010\u0004\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchCategoriesAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/talabat/darkstores/data/SearchCategory;", "Lcom/talabat/darkstores/feature/searchResults/SearchCategoriesAdapter$ViewHolder;", "categoryClickListener", "Lkotlin/Function1;", "", "", "Lcom/talabat/darkstores/feature/searchResults/CategoryClickListener;", "(Lkotlin/jvm/functions/Function1;)V", "currentSelectedId", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectCategory", "selectedId", "CategoriesDiffCallback", "ViewHolder", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchCategoriesAdapter extends ListAdapter<SearchCategory, ViewHolder> {
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<String, Unit> categoryClickListener;
    /* access modifiers changed from: private */
    @Nullable
    public String currentSelectedId;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchCategoriesAdapter$CategoriesDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/talabat/darkstores/data/SearchCategory;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CategoriesDiffCallback extends DiffUtil.ItemCallback<SearchCategory> {
        @NotNull
        public static final CategoriesDiffCallback INSTANCE = new CategoriesDiffCallback();

        private CategoriesDiffCallback() {
        }

        public boolean areContentsTheSame(@NotNull SearchCategory searchCategory, @NotNull SearchCategory searchCategory2) {
            Intrinsics.checkNotNullParameter(searchCategory, "oldItem");
            Intrinsics.checkNotNullParameter(searchCategory2, "newItem");
            return Intrinsics.areEqual((Object) searchCategory, (Object) searchCategory2);
        }

        public boolean areItemsTheSame(@NotNull SearchCategory searchCategory, @NotNull SearchCategory searchCategory2) {
            Intrinsics.checkNotNullParameter(searchCategory, "oldItem");
            Intrinsics.checkNotNullParameter(searchCategory2, "newItem");
            return Intrinsics.areEqual((Object) searchCategory.getId(), (Object) searchCategory2.getId());
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchCategoriesAdapter$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "containerView", "Landroid/view/View;", "(Lcom/talabat/darkstores/feature/searchResults/SearchCategoriesAdapter;Landroid/view/View;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "category", "Lcom/talabat/darkstores/data/SearchCategory;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
        @NotNull
        private final View containerView;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SearchCategoriesAdapter f56585h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull SearchCategoriesAdapter searchCategoriesAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "containerView");
            this.f56585h = searchCategoriesAdapter;
            this.containerView = view;
        }

        /* access modifiers changed from: private */
        /* renamed from: bind$lambda-0  reason: not valid java name */
        public static final void m10079bind$lambda0(SearchCategoriesAdapter searchCategoriesAdapter, SearchCategory searchCategory, View view) {
            Intrinsics.checkNotNullParameter(searchCategoriesAdapter, "this$0");
            Intrinsics.checkNotNullParameter(searchCategory, "$category");
            searchCategoriesAdapter.categoryClickListener.invoke(searchCategory.getId());
        }

        public final void bind(@NotNull SearchCategory searchCategory) {
            boolean z11;
            Intrinsics.checkNotNullParameter(searchCategory, "category");
            View containerView2 = getContainerView();
            int i11 = R.id.search_category_chip;
            Chip chip = (Chip) containerView2.findViewById(i11);
            if (!(this.f56585h.currentSelectedId == null && getBindingAdapterPosition() == 0) && !Intrinsics.areEqual((Object) searchCategory.getId(), (Object) this.f56585h.currentSelectedId)) {
                z11 = false;
            } else {
                z11 = true;
            }
            chip.setSelected(z11);
            ((Chip) getContainerView().findViewById(i11)).setText(searchCategory.getName());
            getContainerView().setOnClickListener(new a(this.f56585h, searchCategory));
        }

        @NotNull
        public View getContainerView() {
            return this.containerView;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchCategoriesAdapter(@NotNull Function1<? super String, Unit> function1) {
        super(CategoriesDiffCallback.INSTANCE);
        Intrinsics.checkNotNullParameter(function1, "categoryClickListener");
        this.categoryClickListener = function1;
    }

    public final void selectCategory(@Nullable String str) {
        this.currentSelectedId = str;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Object item = getItem(i11);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        viewHolder.bind((SearchCategory) item);
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.darkstores_item_search_category, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   …_category, parent, false)");
        return new ViewHolder(this, inflate);
    }
}
