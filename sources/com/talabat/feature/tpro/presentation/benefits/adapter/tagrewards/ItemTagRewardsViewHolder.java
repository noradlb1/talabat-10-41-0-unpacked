package com.talabat.feature.tpro.presentation.benefits.adapter.tagrewards;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingCardTagsModel;
import com.talabat.feature.tpro.presentation.R;
import com.talabat.feature.tpro.presentation.databinding.ItemTagRewardsBinding;
import com.talabat.feature.tpro.presentation.util.ExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/tagrewards/ItemTagRewardsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Lcom/talabat/feature/tpro/presentation/databinding/ItemTagRewardsBinding;", "(Lcom/talabat/feature/tpro/presentation/databinding/ItemTagRewardsBinding;)V", "bind", "", "tProOnBoardingCardTagsModel", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCardTagsModel;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ItemTagRewardsViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final ItemTagRewardsBinding view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemTagRewardsViewHolder(@NotNull ItemTagRewardsBinding itemTagRewardsBinding) {
        super(itemTagRewardsBinding.getRoot());
        Intrinsics.checkNotNullParameter(itemTagRewardsBinding, "view");
        this.view = itemTagRewardsBinding;
    }

    public final void bind(@NotNull TProOnBoardingCardTagsModel tProOnBoardingCardTagsModel) {
        Intrinsics.checkNotNullParameter(tProOnBoardingCardTagsModel, "tProOnBoardingCardTagsModel");
        ItemTagRewardsBinding itemTagRewardsBinding = this.view;
        itemTagRewardsBinding.tvTitle.setText(tProOnBoardingCardTagsModel.getTitle());
        TextView textView = itemTagRewardsBinding.tvTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "tvTitle");
        ExtensionsKt.applyTextColor(textView, tProOnBoardingCardTagsModel.getTitleColor());
        ImageView imageView = itemTagRewardsBinding.toolTip;
        Intrinsics.checkNotNullExpressionValue(imageView, "toolTip");
        ExtensionsKt.loadImage$default(imageView, tProOnBoardingCardTagsModel.getToolTipImage(), (Function1) null, 2, (Object) null);
        AppCompatImageView appCompatImageView = itemTagRewardsBinding.voucherImage;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "voucherImage");
        ExtensionsKt.loadImage$default((ImageView) appCompatImageView, tProOnBoardingCardTagsModel.getImage(), (Function1) null, 2, (Object) null);
        AppCompatImageView appCompatImageView2 = itemTagRewardsBinding.voucherImage;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "voucherImage");
        ExtensionsKt.applyBgColor(appCompatImageView2, tProOnBoardingCardTagsModel.getImageBackgroundColor());
        ConstraintLayout constraintLayout = itemTagRewardsBinding.voucherRoot;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "voucherRoot");
        ExtensionsKt.applyDrawableWithTint(constraintLayout, tProOnBoardingCardTagsModel.getBackground(), R.drawable.bg_item_tag_rewards);
    }
}
