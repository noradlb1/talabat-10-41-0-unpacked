package com.talabat.feature.tpro.presentation.management.details.upgrade.details.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.talabat.feature.subscriptions.domain.model.UpgradePlanBenefit;
import com.talabat.feature.tpro.presentation.databinding.ItemUpgradeBenefitBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/details/upgrade/details/adapter/UpgradeBenefitViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ItemUpgradeBenefitBinding;", "(Lcom/talabat/feature/tpro/presentation/databinding/ItemUpgradeBenefitBinding;)V", "bind", "", "benefit", "Lcom/talabat/feature/subscriptions/domain/model/UpgradePlanBenefit;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpgradeBenefitViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final ItemUpgradeBenefitBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UpgradeBenefitViewHolder(@NotNull ItemUpgradeBenefitBinding itemUpgradeBenefitBinding) {
        super(itemUpgradeBenefitBinding.getRoot());
        Intrinsics.checkNotNullParameter(itemUpgradeBenefitBinding, "binding");
        this.binding = itemUpgradeBenefitBinding;
    }

    public final void bind(@NotNull UpgradePlanBenefit upgradePlanBenefit) {
        Intrinsics.checkNotNullParameter(upgradePlanBenefit, "benefit");
        this.binding.tvUpgradeHeader.setText(upgradePlanBenefit.getName());
        this.binding.tvUpgradeContent.setText(upgradePlanBenefit.getDescription());
        Glide.with((View) this.binding.ivUpgradeIcon).load(upgradePlanBenefit.getIcon()).apply((BaseRequestOptions<?>) RequestOptions.fitCenterTransform()).into(this.binding.ivUpgradeIcon);
    }
}
