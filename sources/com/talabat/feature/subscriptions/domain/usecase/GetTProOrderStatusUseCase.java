package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\tH¦\u0002¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/GetTProOrderStatusUseCase;", "", "invoke", "", "shouldUpdateCart", "", "subscribeAtCheckout", "shouldMOVRecalculate", "onTProOrderStatusLoaded", "Lkotlin/Function1;", "Lcom/talabat/feature/subscriptions/domain/model/TProOrderStatus;", "Lkotlin/ParameterName;", "name", "tProOrderStatus", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GetTProOrderStatusUseCase {
    void invoke(boolean z11, boolean z12, boolean z13, @NotNull Function1<? super TProOrderStatus, Unit> function1);
}
