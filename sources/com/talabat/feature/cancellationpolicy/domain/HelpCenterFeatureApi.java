package com.talabat.feature.cancellationpolicy.domain;

import com.talabat.core.di.Api;
import com.talabat.feature.cancellationpolicy.domain.repo.ICancellationPolicyRepository;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/cancellationpolicy/domain/HelpCenterFeatureApi;", "Lcom/talabat/core/di/Api;", "cancellationPolicyFlag", "Lcom/talabat/feature/cancellationpolicy/domain/ICancellationPolicyFlag;", "getCancellationPolicyFlag", "()Lcom/talabat/feature/cancellationpolicy/domain/ICancellationPolicyFlag;", "cancellationPolicyRepository", "Lcom/talabat/feature/cancellationpolicy/domain/repo/ICancellationPolicyRepository;", "getCancellationPolicyRepository", "()Lcom/talabat/feature/cancellationpolicy/domain/repo/ICancellationPolicyRepository;", "helpCenterDeeplinkNavigator", "Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;", "getHelpCenterDeeplinkNavigator", "()Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;", "helpCenterEventTracker", "Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterEventTracker;", "getHelpCenterEventTracker", "()Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterEventTracker;", "com_talabat_feature_helpcenter_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface HelpCenterFeatureApi extends Api {
    @NotNull
    ICancellationPolicyFlag getCancellationPolicyFlag();

    @NotNull
    ICancellationPolicyRepository getCancellationPolicyRepository();

    @NotNull
    IHelpCenterDeeplinkBuilder getHelpCenterDeeplinkNavigator();

    @NotNull
    IHelpCenterEventTracker getHelpCenterEventTracker();
}
