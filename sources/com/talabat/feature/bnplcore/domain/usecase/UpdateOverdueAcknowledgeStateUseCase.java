package com.talabat.feature.bnplcore.domain.usecase;

import com.talabat.feature.bnplcore.domain.model.OverdueAcknowledgeState;
import io.reactivex.Completable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0002¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/usecase/UpdateOverdueAcknowledgeStateUseCase;", "", "invoke", "Lio/reactivex/Completable;", "overdue", "Lcom/talabat/feature/bnplcore/domain/model/OverdueAcknowledgeState;", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface UpdateOverdueAcknowledgeStateUseCase {
    @NotNull
    Completable invoke(@NotNull OverdueAcknowledgeState overdueAcknowledgeState);
}
