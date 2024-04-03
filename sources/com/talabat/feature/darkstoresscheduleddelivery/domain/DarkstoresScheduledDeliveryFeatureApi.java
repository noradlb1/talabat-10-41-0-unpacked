package com.talabat.feature.darkstoresscheduleddelivery.domain;

import com.talabat.core.di.Api;
import com.talabat.feature.darkstoresscheduleddelivery.domain.usecase.DarkstoresScheduledDeliveryUseCase;
import com.talabat.feature.darkstoresscheduleddelivery.domain.usecase.IsDarkstoresScheduledDeliveryDiscountEnabledUseCase;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/darkstoresscheduleddelivery/domain/DarkstoresScheduledDeliveryFeatureApi;", "Lcom/talabat/core/di/Api;", "darkstoresScheduledDeliveryUseCase", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/usecase/DarkstoresScheduledDeliveryUseCase;", "isDarkstoresScheduledDeliveryDiscountEnabledUseCase", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/usecase/IsDarkstoresScheduledDeliveryDiscountEnabledUseCase;", "com_talabat_feature_darkstores-scheduled-delivery_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkstoresScheduledDeliveryFeatureApi extends Api {
    @NotNull
    DarkstoresScheduledDeliveryUseCase darkstoresScheduledDeliveryUseCase();

    @NotNull
    IsDarkstoresScheduledDeliveryDiscountEnabledUseCase isDarkstoresScheduledDeliveryDiscountEnabledUseCase();
}
