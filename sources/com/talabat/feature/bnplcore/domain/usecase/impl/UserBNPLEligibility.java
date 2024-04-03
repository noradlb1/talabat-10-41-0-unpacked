package com.talabat.feature.bnplcore.domain.usecase.impl;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/usecase/impl/UserBNPLEligibility;", "", "(Ljava/lang/String;I)V", "isBNPLEligible", "", "BNPL_ELIGIBLE", "BNPL_NOT_ELIGIBLE", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum UserBNPLEligibility {
    BNPL_ELIGIBLE,
    BNPL_NOT_ELIGIBLE;

    public final boolean isBNPLEligible() {
        return this == BNPL_ELIGIBLE;
    }
}
