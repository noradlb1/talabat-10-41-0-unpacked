package com.talabat.feature.walletaddcard.domain.usecase;

import com.talabat.feature.walletaddcard.domain.WalletAddCardRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/walletaddcard/domain/usecase/IsBenefitEnabledUseCase;", "", "repository", "Lcom/talabat/feature/walletaddcard/domain/WalletAddCardRepository;", "(Lcom/talabat/feature/walletaddcard/domain/WalletAddCardRepository;)V", "invoke", "", "com_talabat_feature_wallet-add-card_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsBenefitEnabledUseCase {
    @NotNull
    private final WalletAddCardRepository repository;

    @Inject
    public IsBenefitEnabledUseCase(@NotNull WalletAddCardRepository walletAddCardRepository) {
        Intrinsics.checkNotNullParameter(walletAddCardRepository, "repository");
        this.repository = walletAddCardRepository;
    }

    public final boolean invoke() {
        return this.repository.isBenefitDeflectionEnabled();
    }
}
