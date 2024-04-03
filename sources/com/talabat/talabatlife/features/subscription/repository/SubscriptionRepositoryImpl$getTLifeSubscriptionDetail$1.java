package com.talabat.talabatlife.features.subscription.repository;

import com.talabat.talabatlife.features.subscription.model.response.TLifeSubscriptionDetailResponse;
import com.talabat.talabatlife.ui.subscriptionManagement.model.TLifeSubscriptionDetailDisplayModel;
import com.talabat.talabatlife.ui.subscriptionManagement.model.TLifeSubscriptionManagementMapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatlife/ui/subscriptionManagement/model/TLifeSubscriptionDetailDisplayModel;", "it", "Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionDetailResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionRepositoryImpl$getTLifeSubscriptionDetail$1 extends Lambda implements Function1<TLifeSubscriptionDetailResponse, TLifeSubscriptionDetailDisplayModel> {
    public static final SubscriptionRepositoryImpl$getTLifeSubscriptionDetail$1 INSTANCE = new SubscriptionRepositoryImpl$getTLifeSubscriptionDetail$1();

    public SubscriptionRepositoryImpl$getTLifeSubscriptionDetail$1() {
        super(1);
    }

    @NotNull
    public final TLifeSubscriptionDetailDisplayModel invoke(@NotNull TLifeSubscriptionDetailResponse tLifeSubscriptionDetailResponse) {
        Intrinsics.checkNotNullParameter(tLifeSubscriptionDetailResponse, "it");
        return TLifeSubscriptionManagementMapper.Companion.mapTLifeSubscriptionDetail(tLifeSubscriptionDetailResponse);
    }
}
