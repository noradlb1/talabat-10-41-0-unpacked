package com.talabat.feature.tpro.presentation.model.mapper;

import com.talabat.feature.subscriptions.domain.model.SubscriptionPlan;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import com.talabat.mapper.ModelMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/feature/tpro/presentation/model/mapper/TProPlanDisplayModelMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPlan;", "Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;", "tProMapper", "Lcom/talabat/feature/tpro/presentation/model/mapper/TProMapperUtility;", "(Lcom/talabat/feature/tpro/presentation/model/mapper/TProMapperUtility;)V", "apply", "source", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProPlanDisplayModelMapper implements ModelMapper<SubscriptionPlan, TProPlanDisplayModel> {
    @NotNull
    private final TProMapperUtility tProMapper;

    @Inject
    public TProPlanDisplayModelMapper(@NotNull TProMapperUtility tProMapperUtility) {
        Intrinsics.checkNotNullParameter(tProMapperUtility, "tProMapper");
        this.tProMapper = tProMapperUtility;
    }

    @NotNull
    public TProPlanDisplayModel apply(@NotNull SubscriptionPlan subscriptionPlan) {
        Intrinsics.checkNotNullParameter(subscriptionPlan, "source");
        return this.tProMapper.mapPlanDisplayModel(subscriptionPlan);
    }
}
