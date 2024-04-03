package com.talabat.feature.tpro.presentation.benefits.adapter.tagrewards;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingCardTagsModel;
import com.talabat.feature.tpro.presentation.databinding.ItemTagRewardsBinding;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/tagrewards/TagRewardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/feature/tpro/presentation/benefits/adapter/tagrewards/ItemTagRewardsViewHolder;", "()V", "cardTagModels", "", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCardTagsModel;", "addTagList", "", "list", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TagRewardsAdapter extends RecyclerView.Adapter<ItemTagRewardsViewHolder> {
    @NotNull
    private List<TProOnBoardingCardTagsModel> cardTagModels = new ArrayList();

    public final void addTagList(@NotNull List<TProOnBoardingCardTagsModel> list) {
        Intrinsics.checkNotNullParameter(list, DefaultCardView.CARD_LIST);
        this.cardTagModels.clear();
        this.cardTagModels.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.cardTagModels.size();
    }

    public void onBindViewHolder(@NotNull ItemTagRewardsViewHolder itemTagRewardsViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(itemTagRewardsViewHolder, "holder");
        itemTagRewardsViewHolder.bind(this.cardTagModels.get(i11));
    }

    @NotNull
    public ItemTagRewardsViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemTagRewardsBinding inflate = ItemTagRewardsBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ItemTagRewardsViewHolder(inflate);
    }
}
