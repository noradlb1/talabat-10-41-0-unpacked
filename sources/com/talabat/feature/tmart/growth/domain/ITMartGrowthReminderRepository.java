package com.talabat.feature.tmart.growth.domain;

import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\nR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthReminderRepository;", "", "trackingInfo", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthTrackingInfo;", "getTrackingInfo", "()Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthTrackingInfo;", "getVoucherReminder", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthReminderData;", "screenType", "Lcom/talabat/feature/tmart/growth/domain/TMartGrowthScreenType;", "(Lcom/talabat/feature/tmart/growth/domain/TMartGrowthScreenType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ITMartGrowthReminderRepository {
    @Nullable
    TMartGrowthTrackingInfo getTrackingInfo();

    @Nullable
    Object getVoucherReminder(@NotNull TMartGrowthScreenType tMartGrowthScreenType, @NotNull Continuation<? super TMartGrowthReminderData> continuation);
}
