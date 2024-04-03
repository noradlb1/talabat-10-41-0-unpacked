package com.talabat.feature.bnplcore.domain;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/BnplObservabilityConstants;", "", "()V", "EXPLANATION_BNPL_OVERDUES_NOTIFICATION_EXCEPTION", "", "KEY_BNPL_OVERDUES_NOTIFICATION_ERROR_MSG", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BnplObservabilityConstants {
    @NotNull
    public static final String EXPLANATION_BNPL_OVERDUES_NOTIFICATION_EXCEPTION = "BNPL Overdue notification exception";
    @NotNull
    public static final BnplObservabilityConstants INSTANCE = new BnplObservabilityConstants();
    @NotNull
    public static final String KEY_BNPL_OVERDUES_NOTIFICATION_ERROR_MSG = "errorMessage";

    private BnplObservabilityConstants() {
    }
}
