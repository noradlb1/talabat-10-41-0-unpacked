package com.talabat.core.observabilityNew.domain.entity;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/core/observabilityNew/domain/entity/QCommerceScreenTracingNames;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "QCOMMERCE_VLP_START_TO_INTERACTIVE", "QCOMMERCE_BASKET_START_TO_INTERACTIVE", "TLB_QCOMMERCE_BASKET_START_TO_INTERACTIVE", "QCOMMERCE_PLP_START_TO_INTERACTIVE", "TLB_QCOMMERCE_PLP_START_TO_INTERACTIVE", "TTFL_QCOMMERCE_VLP", "TTI_QCOMMERCE_VLP", "com_talabat_core_observability_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum QCommerceScreenTracingNames {
    QCOMMERCE_VLP_START_TO_INTERACTIVE("qCommerceVLP"),
    QCOMMERCE_BASKET_START_TO_INTERACTIVE("qCommerceBasket"),
    TLB_QCOMMERCE_BASKET_START_TO_INTERACTIVE("tlbQCommerceBasket"),
    QCOMMERCE_PLP_START_TO_INTERACTIVE("qCommercePLP"),
    TLB_QCOMMERCE_PLP_START_TO_INTERACTIVE("tlbQCommercePLP"),
    TTFL_QCOMMERCE_VLP("TTFL_QCOMMERCE_VLP"),
    TTI_QCOMMERCE_VLP("TTI_QCOMMERCE_VLP");
    
    @NotNull
    private final String value;

    private QCommerceScreenTracingNames(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
