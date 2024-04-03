package com.talabat.core.fwfprojectskeys.domain.projects.ordering;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/talabat/core/fwfprojectskeys/domain/projects/ordering/OrderingRemoteConfigurationsKeys;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "value", "", "projectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;)V", "getProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getValue", "()Ljava/lang/String;", "PAY_CONFIG_IS_BIN_CAMPAIGN_AVAILABLE", "PAY_CONFIG_VISA_CHECKOUT_PUBLIC_KEY", "ORDER_EXPERIENCE_CONFIG_IS_GO_GREEN", "MULTI_ORDER_PAYMENT_CONFIG", "PAYMENT_DEFLECTION_CONFIG", "com_talabat_core_fwf-projects-keys_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum OrderingRemoteConfigurationsKeys implements FWFKey {
    PAY_CONFIG_IS_BIN_CAMPAIGN_AVAILABLE("rc_ordering_is_bin_campaign_available", (int) null, 2, (FWFProjectName) null),
    PAY_CONFIG_VISA_CHECKOUT_PUBLIC_KEY("rc_ordering_visa_checkout_public_key", (int) null, 2, (FWFProjectName) null),
    ORDER_EXPERIENCE_CONFIG_IS_GO_GREEN("rc_ordering_is_go_green", (int) null, 2, (FWFProjectName) null),
    MULTI_ORDER_PAYMENT_CONFIG("rc_ordering_lending_multi_orders_payment_config", (int) null, 2, (FWFProjectName) null),
    PAYMENT_DEFLECTION_CONFIG("rc_ordering_payment_deflection_config", (int) null, 2, (FWFProjectName) null);
    
    @NotNull
    private final FWFProjectName projectName;
    @NotNull
    private final String value;

    private OrderingRemoteConfigurationsKeys(String str, FWFProjectName fWFProjectName) {
        this.value = str;
        this.projectName = fWFProjectName;
    }

    @NotNull
    public FWFProjectName getProjectName() {
        return this.projectName;
    }

    @NotNull
    public String getValue() {
        return this.value;
    }
}
