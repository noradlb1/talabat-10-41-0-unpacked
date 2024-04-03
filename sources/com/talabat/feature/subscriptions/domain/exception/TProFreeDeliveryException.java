package com.talabat.feature.subscriptions.domain.exception;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/exception/TProFreeDeliveryException;", "", "()V", "message", "", "getMessage", "()Ljava/lang/String;", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProFreeDeliveryException extends Throwable {
    @NotNull
    public String getMessage() {
        return "Free Delivery accounted for non eligible vendor";
    }
}
