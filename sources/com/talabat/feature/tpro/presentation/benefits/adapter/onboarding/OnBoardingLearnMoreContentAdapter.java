package com.talabat.feature.tpro.presentation.benefits.adapter.onboarding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingMoreContentItemModel;
import com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.viewholders.LearnMoreContentItemViewHolder;
import com.talabat.feature.tpro.presentation.databinding.LearnMoreContentItemBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/OnBoardingLearnMoreContentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onBoardingMoreContentItemList", "", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingMoreContentItemModel;", "(Ljava/util/List;)V", "context", "Landroid/content/Context;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OnBoardingLearnMoreContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Nullable
    private Context context;
    @Nullable
    private final List<TProOnBoardingMoreContentItemModel> onBoardingMoreContentItemList;

    public OnBoardingLearnMoreContentAdapter(@Nullable List<TProOnBoardingMoreContentItemModel> list) {
        this.onBoardingMoreContentItemList = list;
    }

    public int getItemCount() {
        List<TProOnBoardingMoreContentItemModel> list = this.onBoardingMoreContentItemList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        TProOnBoardingMoreContentItemModel tProOnBoardingMoreContentItemModel;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof LearnMoreContentItemViewHolder) {
            LearnMoreContentItemViewHolder learnMoreContentItemViewHolder = (LearnMoreContentItemViewHolder) viewHolder;
            List<TProOnBoardingMoreContentItemModel> list = this.onBoardingMoreContentItemList;
            if (list != null) {
                tProOnBoardingMoreContentItemModel = list.get(i11);
            } else {
                tProOnBoardingMoreContentItemModel = null;
            }
            learnMoreContentItemViewHolder.bind(tProOnBoardingMoreContentItemModel);
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.context = viewGroup.getContext();
        LearnMoreContentItemBinding inflate = LearnMoreContentItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               …      false\n            )");
        return new LearnMoreContentItemViewHolder(inflate);
    }
}
