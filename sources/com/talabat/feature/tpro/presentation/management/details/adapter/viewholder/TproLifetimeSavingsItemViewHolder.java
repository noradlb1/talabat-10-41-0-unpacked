package com.talabat.feature.tpro.presentation.management.details.adapter.viewholder;

import androidx.recyclerview.widget.RecyclerView;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import com.talabat.feature.tpro.presentation.databinding.ItemLifetimeSavingsBinding;
import com.talabat.feature.tpro.presentation.util.DisplayAmountUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/details/adapter/viewholder/TproLifetimeSavingsItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ItemLifetimeSavingsBinding;", "savingsInfo", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;", "locationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "(Lcom/talabat/feature/tpro/presentation/databinding/ItemLifetimeSavingsBinding;Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "bind", "", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproLifetimeSavingsItemViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final ItemLifetimeSavingsBinding binding;
    @NotNull
    private final LocationConfigurationRepository locationRepository;
    @NotNull
    private final SubscriptionSavingsInfo savingsInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproLifetimeSavingsItemViewHolder(@NotNull ItemLifetimeSavingsBinding itemLifetimeSavingsBinding, @NotNull SubscriptionSavingsInfo subscriptionSavingsInfo, @NotNull LocationConfigurationRepository locationConfigurationRepository) {
        super(itemLifetimeSavingsBinding.getRoot());
        Intrinsics.checkNotNullParameter(itemLifetimeSavingsBinding, "binding");
        Intrinsics.checkNotNullParameter(subscriptionSavingsInfo, "savingsInfo");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationRepository");
        this.binding = itemLifetimeSavingsBinding;
        this.savingsInfo = subscriptionSavingsInfo;
        this.locationRepository = locationConfigurationRepository;
    }

    public final void bind() {
        this.binding.tvLifetimeSavingsTitle.setText(DisplayAmountUtil.INSTANCE.getDisplayAmount(this.locationRepository, this.savingsInfo.getOverallSavings()));
    }
}
