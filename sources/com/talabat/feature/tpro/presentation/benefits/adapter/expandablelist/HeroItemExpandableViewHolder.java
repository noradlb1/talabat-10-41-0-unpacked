package com.talabat.feature.tpro.presentation.benefits.adapter.expandablelist;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingExpandableItemModel;
import com.talabat.feature.tpro.presentation.databinding.ExpandableItemViewBinding;
import com.talabat.feature.tpro.presentation.util.ExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/expandablelist/HeroItemExpandableViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ExpandableItemViewBinding;", "(Lcom/talabat/feature/tpro/presentation/databinding/ExpandableItemViewBinding;)V", "bind", "", "proItem", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingExpandableItemModel;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HeroItemExpandableViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final ExpandableItemViewBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeroItemExpandableViewHolder(@NotNull ExpandableItemViewBinding expandableItemViewBinding) {
        super(expandableItemViewBinding.getRoot());
        Intrinsics.checkNotNullParameter(expandableItemViewBinding, "binding");
        this.binding = expandableItemViewBinding;
    }

    public final void bind(@NotNull TProOnBoardingExpandableItemModel tProOnBoardingExpandableItemModel) {
        Intrinsics.checkNotNullParameter(tProOnBoardingExpandableItemModel, "proItem");
        this.binding.tvPrimary.setText(tProOnBoardingExpandableItemModel.getTitle());
        TextView textView = this.binding.tvPrimary;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvPrimary");
        ExtensionsKt.applyTextColor(textView, tProOnBoardingExpandableItemModel.getTitleColor());
        this.binding.tvSecondary.setText(tProOnBoardingExpandableItemModel.getValue());
        TextView textView2 = this.binding.tvSecondary;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvSecondary");
        ExtensionsKt.applyTextColor(textView2, tProOnBoardingExpandableItemModel.getValueColor());
        this.binding.tvSubtitle.setText(tProOnBoardingExpandableItemModel.getSubTitle());
        TextView textView3 = this.binding.tvSubtitle;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvSubtitle");
        ExtensionsKt.applyTextColor(textView3, tProOnBoardingExpandableItemModel.getSubTitleColor());
    }
}
