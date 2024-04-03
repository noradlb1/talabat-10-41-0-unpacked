package com.talabat.feature.walletaddcard.domain;

import com.talabat.feature.walletaddcard.domain.model.BankCard;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/feature/walletaddcard/domain/WalletAddCardRepository;", "", "generateCardToken", "", "bankCard", "Lcom/talabat/feature/walletaddcard/domain/model/BankCard;", "(Lcom/talabat/feature/walletaddcard/domain/model/BankCard;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isBenefitDeflectionEnabled", "", "isQPayDeflectionEnabled", "com_talabat_feature_wallet-add-card_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletAddCardRepository {
    @Nullable
    Object generateCardToken(@NotNull BankCard bankCard, @NotNull Continuation<? super String> continuation);

    boolean isBenefitDeflectionEnabled();

    boolean isQPayDeflectionEnabled();
}
