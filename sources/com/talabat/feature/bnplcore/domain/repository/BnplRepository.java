package com.talabat.feature.bnplcore.domain.repository;

import com.talabat.feature.bnplcore.domain.model.OverdueAcknowledgeState;
import com.talabat.feature.bnplcore.domain.model.Overdues;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H&¨\u0006\n"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/repository/BnplRepository;", "", "getOverdueAcknowledgeState", "Lio/reactivex/Single;", "Lcom/talabat/feature/bnplcore/domain/model/OverdueAcknowledgeState;", "getOverdues", "Lcom/talabat/feature/bnplcore/domain/model/Overdues;", "updateOverdueAcknowledgedState", "", "overdue", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BnplRepository {
    @NotNull
    Single<OverdueAcknowledgeState> getOverdueAcknowledgeState();

    @NotNull
    Single<Overdues> getOverdues();

    void updateOverdueAcknowledgedState(@NotNull OverdueAcknowledgeState overdueAcknowledgeState);
}
