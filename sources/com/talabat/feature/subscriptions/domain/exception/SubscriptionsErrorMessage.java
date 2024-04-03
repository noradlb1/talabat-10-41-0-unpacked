package com.talabat.feature.subscriptions.domain.exception;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/exception/SubscriptionsErrorMessage;", "", "throwable", "errorCode", "", "errors", "", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/util/List;)V", "getErrorCode", "()Ljava/lang/String;", "getErrors", "()Ljava/util/List;", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionsErrorMessage extends Throwable {
    @Nullable
    private final String errorCode;
    @Nullable
    private final List<String> errors;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionsErrorMessage(@NotNull Throwable th2, @Nullable String str, @Nullable List<String> list) {
        super(th2);
        Intrinsics.checkNotNullParameter(th2, "throwable");
        this.errorCode = str;
        this.errors = list;
    }

    @Nullable
    public final String getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final List<String> getErrors() {
        return this.errors;
    }
}
