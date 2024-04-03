package com.talabat.feature.subscriptions.domain.mocks;

import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import com.talabat.feature.subscriptions.domain.usecase.GetTProOrderStatusUseCase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\nH\u0002¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/mocks/MockGetTProOrderStatusUseCaseImpl;", "Lcom/talabat/feature/subscriptions/domain/usecase/GetTProOrderStatusUseCase;", "()V", "invoke", "", "shouldUpdateCart", "", "subscribeAtCheckout", "shouldMOVRecalculate", "onTProOrderStatusLoaded", "Lkotlin/Function1;", "Lcom/talabat/feature/subscriptions/domain/model/TProOrderStatus;", "Lkotlin/ParameterName;", "name", "tProOrderStatus", "Companion", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MockGetTProOrderStatusUseCaseImpl implements GetTProOrderStatusUseCase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static TProOrderStatus mockOrderStatus = new TProOrderStatus(false, 0.0d, false, false, 15, (DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/mocks/MockGetTProOrderStatusUseCaseImpl$Companion;", "", "()V", "mockOrderStatus", "Lcom/talabat/feature/subscriptions/domain/model/TProOrderStatus;", "getMockOrderStatus", "()Lcom/talabat/feature/subscriptions/domain/model/TProOrderStatus;", "setMockOrderStatus", "(Lcom/talabat/feature/subscriptions/domain/model/TProOrderStatus;)V", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TProOrderStatus getMockOrderStatus() {
            return MockGetTProOrderStatusUseCaseImpl.mockOrderStatus;
        }

        public final void setMockOrderStatus(@NotNull TProOrderStatus tProOrderStatus) {
            Intrinsics.checkNotNullParameter(tProOrderStatus, "<set-?>");
            MockGetTProOrderStatusUseCaseImpl.mockOrderStatus = tProOrderStatus;
        }
    }

    public void invoke(boolean z11, boolean z12, boolean z13, @NotNull Function1<? super TProOrderStatus, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onTProOrderStatusLoaded");
        function1.invoke(mockOrderStatus);
    }
}
