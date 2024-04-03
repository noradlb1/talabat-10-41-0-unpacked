package com.talabat.feature.walletcobrandedcc.domain.usecase.impl;

import com.talabat.customer.domain.CustomerRepository;
import com.talabat.feature.walletcobrandedcc.domain.WalletCobrandedCcRepository;
import com.talabat.feature.walletcobrandedcc.domain.model.CobrandedCcInProgressAppNotification;
import com.talabat.feature.walletcobrandedcc.domain.usecase.ShowCobrandedNotificationUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/feature/walletcobrandedcc/domain/usecase/impl/ShowCobrandedNotificationUseCaseImpl;", "Lcom/talabat/feature/walletcobrandedcc/domain/usecase/ShowCobrandedNotificationUseCase;", "walletCobrandedCcRepository", "Lcom/talabat/feature/walletcobrandedcc/domain/WalletCobrandedCcRepository;", "customerRepository", "Lcom/talabat/customer/domain/CustomerRepository;", "(Lcom/talabat/feature/walletcobrandedcc/domain/WalletCobrandedCcRepository;Lcom/talabat/customer/domain/CustomerRepository;)V", "invoke", "Lcom/talabat/feature/walletcobrandedcc/domain/model/CobrandedCcInProgressAppNotification;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_wallet-cobranded-cc_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShowCobrandedNotificationUseCaseImpl implements ShowCobrandedNotificationUseCase {
    @NotNull
    private final CustomerRepository customerRepository;
    @NotNull
    private final WalletCobrandedCcRepository walletCobrandedCcRepository;

    @Inject
    public ShowCobrandedNotificationUseCaseImpl(@NotNull WalletCobrandedCcRepository walletCobrandedCcRepository2, @NotNull CustomerRepository customerRepository2) {
        Intrinsics.checkNotNullParameter(walletCobrandedCcRepository2, "walletCobrandedCcRepository");
        Intrinsics.checkNotNullParameter(customerRepository2, "customerRepository");
        this.walletCobrandedCcRepository = walletCobrandedCcRepository2;
        this.customerRepository = customerRepository2;
    }

    @Nullable
    public Object invoke(@NotNull Continuation<? super CobrandedCcInProgressAppNotification> continuation) {
        if (!this.customerRepository.isLoggedIn()) {
            return new CobrandedCcInProgressAppNotification(false);
        }
        return this.walletCobrandedCcRepository.shouldDisplayCobrandedCcInProgressNotification(continuation);
    }
}
