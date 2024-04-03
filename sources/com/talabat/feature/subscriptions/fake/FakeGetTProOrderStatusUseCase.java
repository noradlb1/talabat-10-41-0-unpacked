package com.talabat.feature.subscriptions.fake;

import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import com.talabat.feature.subscriptions.domain.usecase.GetTProOrderStatusUseCase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\nH\u0002¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/subscriptions/fake/FakeGetTProOrderStatusUseCase;", "Lcom/talabat/feature/subscriptions/domain/usecase/GetTProOrderStatusUseCase;", "()V", "invoke", "", "shouldUpdateCart", "", "subscribeAtCheckout", "shouldMOVRecalculate", "onTProOrderStatusLoaded", "Lkotlin/Function1;", "Lcom/talabat/feature/subscriptions/domain/model/TProOrderStatus;", "Lkotlin/ParameterName;", "name", "tProOrderStatus", "com_talabat_feature_subscriptions_fake_fake"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FakeGetTProOrderStatusUseCase implements GetTProOrderStatusUseCase {
    public void invoke(boolean z11, boolean z12, boolean z13, @NotNull Function1<? super TProOrderStatus, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onTProOrderStatusLoaded");
        System.out.println("com.talabat.feature.subscriptions.fake.FakeGetTProOrderStatusUseCase.invoke()");
    }
}
