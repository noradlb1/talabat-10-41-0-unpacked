package com.talabat.feature.tpro.presentation.benefits.adapter.expandablelist;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingExpandableItemModel;
import com.talabat.feature.tpro.presentation.databinding.ExpandableItemViewBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/expandablelist/HeroItemExpandableAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/feature/tpro/presentation/benefits/adapter/expandablelist/HeroItemExpandableViewHolder;", "listItems", "", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingExpandableItemModel;", "(Ljava/util/List;)V", "getListItems", "()Ljava/util/List;", "setListItems", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HeroItemExpandableAdapter extends RecyclerView.Adapter<HeroItemExpandableViewHolder> {
    @NotNull
    private List<TProOnBoardingExpandableItemModel> listItems;

    public HeroItemExpandableAdapter(@NotNull List<TProOnBoardingExpandableItemModel> list) {
        Intrinsics.checkNotNullParameter(list, "listItems");
        this.listItems = list;
    }

    public int getItemCount() {
        return this.listItems.size();
    }

    @NotNull
    public final List<TProOnBoardingExpandableItemModel> getListItems() {
        return this.listItems;
    }

    public final void setListItems(@NotNull List<TProOnBoardingExpandableItemModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.listItems = list;
    }

    public void onBindViewHolder(@NotNull HeroItemExpandableViewHolder heroItemExpandableViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(heroItemExpandableViewHolder, "holder");
        heroItemExpandableViewHolder.bind(this.listItems.get(i11));
    }

    @NotNull
    public HeroItemExpandableViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ExpandableItemViewBinding inflate = ExpandableItemViewBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               …      false\n            )");
        return new HeroItemExpandableViewHolder(inflate);
    }
}
