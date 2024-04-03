package com.talabat.feature.darkstorestooltip.domain.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/talabat/feature/darkstorestooltip/domain/model/TooltipKey;", "", "key", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "BASKET_LIFETIME", "EXTENDED_INFO", "com_talabat_feature_darkstores-tooltip_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum TooltipKey {
    BASKET_LIFETIME("basket_lifetime"),
    EXTENDED_INFO("product_extended_info");
    
    @NotNull
    private final String key;

    private TooltipKey(String str) {
        this.key = str;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }
}
