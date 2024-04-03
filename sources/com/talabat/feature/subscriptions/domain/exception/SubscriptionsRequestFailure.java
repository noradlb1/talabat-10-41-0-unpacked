package com.talabat.feature.subscriptions.domain.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/exception/SubscriptionsRequestFailure;", "", "throwable", "(Ljava/lang/Throwable;)V", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionsRequestFailure extends Throwable {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionsRequestFailure(@NotNull Throwable th2) {
        super(th2);
        Intrinsics.checkNotNullParameter(th2, "throwable");
    }
}
