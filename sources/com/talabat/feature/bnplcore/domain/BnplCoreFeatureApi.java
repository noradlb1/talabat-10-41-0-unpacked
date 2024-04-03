package com.talabat.feature.bnplcore.domain;

import com.talabat.core.di.Api;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueNotificationAcknowledgeUseCase;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase;
import com.talabat.feature.bnplcore.domain.usecase.SendNavigationOptionLoadedEventUseCase;
import com.talabat.feature.bnplcore.domain.usecase.UpdateOverdueAcknowledgeStateUseCase;
import com.talabat.feature.bnplcore.domain.usecase.impl.IsUserBNPLEligibleUseCase;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/BnplCoreFeatureApi;", "Lcom/talabat/core/di/Api;", "getBnplOverduesUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase;", "getOverdueNotificationAcknowledgeUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueNotificationAcknowledgeUseCase;", "isUserBNPLEligibleUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/impl/IsUserBNPLEligibleUseCase;", "sendNavigationOptionLoadedEventUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/SendNavigationOptionLoadedEventUseCase;", "updateOverdueAcknowledgeStateUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/UpdateOverdueAcknowledgeStateUseCase;", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BnplCoreFeatureApi extends Api {
    @NotNull
    GetOverdueUseCase getBnplOverduesUseCase();

    @NotNull
    GetOverdueNotificationAcknowledgeUseCase getOverdueNotificationAcknowledgeUseCase();

    @NotNull
    IsUserBNPLEligibleUseCase isUserBNPLEligibleUseCase();

    @NotNull
    SendNavigationOptionLoadedEventUseCase sendNavigationOptionLoadedEventUseCase();

    @NotNull
    UpdateOverdueAcknowledgeStateUseCase updateOverdueAcknowledgeStateUseCase();
}
