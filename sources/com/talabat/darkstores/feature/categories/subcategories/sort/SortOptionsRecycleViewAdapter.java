package com.talabat.darkstores.feature.categories.subcategories.sort;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.data.discovery.model.SortOption;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0006H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0004¢\u0006\u0002\n\u0000R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/sort/SortOptionsRecycleViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/darkstores/feature/categories/subcategories/sort/SortItemViewHolder;", "onRadioButtonClickedCallback", "Lkotlin/Function2;", "Lcom/talabat/darkstores/data/discovery/model/SortOption;", "", "", "list", "", "selectedIndex", "(Lkotlin/jvm/functions/Function2;Ljava/util/List;I)V", "getItemCount", "getItemId", "", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onRadioButtonClicked", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SortOptionsRecycleViewAdapter extends RecyclerView.Adapter<SortItemViewHolder> {
    @NotNull
    private final List<SortOption> list;
    @NotNull
    private final Function2<SortOption, Integer, Unit> onRadioButtonClickedCallback;
    private int selectedIndex;

    public SortOptionsRecycleViewAdapter(@NotNull Function2<? super SortOption, ? super Integer, Unit> function2, @NotNull List<SortOption> list2, int i11) {
        Intrinsics.checkNotNullParameter(function2, "onRadioButtonClickedCallback");
        Intrinsics.checkNotNullParameter(list2, DefaultCardView.CARD_LIST);
        this.onRadioButtonClickedCallback = function2;
        this.list = list2;
        this.selectedIndex = i11;
    }

    /* access modifiers changed from: private */
    public final void onRadioButtonClicked(int i11) {
        this.selectedIndex = i11;
        this.onRadioButtonClickedCallback.invoke(this.list.get(i11), Integer.valueOf(i11));
    }

    public int getItemCount() {
        return this.list.size();
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public void onBindViewHolder(@NotNull SortItemViewHolder sortItemViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(sortItemViewHolder, "holder");
        sortItemViewHolder.bind(this.list.get(i11), i11, this.selectedIndex);
    }

    @NotNull
    public SortItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return new SortItemViewHolder(ViewKt.inflate(viewGroup, R.layout.darkstores_item_sort_option), new SortOptionsRecycleViewAdapter$onCreateViewHolder$1(this));
    }
}
