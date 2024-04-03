package com.talabat.feature.subscriptions.fake;

import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.model.CountryParams;
import com.talabat.feature.subscriptions.domain.model.ProCentralization;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nHBø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/feature/subscriptions/fake/FakeGetProCentralizationStatusUseCase;", "Lcom/talabat/feature/subscriptions/domain/usecase/GetProCentralizationStatusUseCase;", "repository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;)V", "invoke", "Lcom/talabat/feature/subscriptions/domain/model/ProCentralization;", "params", "Lcom/talabat/feature/subscriptions/domain/model/CountryParams;", "(Lcom/talabat/feature/subscriptions/domain/model/CountryParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_subscriptions_fake_fake"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FakeGetProCentralizationStatusUseCase implements GetProCentralizationStatusUseCase {
    @NotNull
    private final ISubscriptionsRepository repository;
    @NotNull
    private final ISubscriptionStatusRepository subscriptionStatusRepository;

    @Inject
    public FakeGetProCentralizationStatusUseCase(@NotNull ISubscriptionsRepository iSubscriptionsRepository, @NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsRepository, "repository");
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "subscriptionStatusRepository");
        this.repository = iSubscriptionsRepository;
        this.subscriptionStatusRepository = iSubscriptionStatusRepository;
    }

    @Nullable
    public Object invoke(@NotNull CountryParams countryParams, @NotNull Continuation<? super ProCentralization> continuation) {
        System.out.println("com.talabat.feature.subscriptions.fake.FakeGetProCentralizationStatusUseCase.invoke()");
        return new ProCentralization((List) null, false, false, 7, (DefaultConstructorMarker) null);
    }
}
