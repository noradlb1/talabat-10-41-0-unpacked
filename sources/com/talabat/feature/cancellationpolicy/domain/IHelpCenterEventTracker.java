package com.talabat.feature.cancellationpolicy.domain;

import com.talabat.feature.cancellationpolicy.domain.model.CancellationPolicyEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterEventTracker;", "", "cancellationPolicyClicked", "", "cancellationPolicyEvent", "Lcom/talabat/feature/cancellationpolicy/domain/model/CancellationPolicyEvent;", "cancellationPolicyShown", "com_talabat_feature_helpcenter_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IHelpCenterEventTracker {
    void cancellationPolicyClicked(@NotNull CancellationPolicyEvent cancellationPolicyEvent);

    void cancellationPolicyShown(@NotNull CancellationPolicyEvent cancellationPolicyEvent);
}
