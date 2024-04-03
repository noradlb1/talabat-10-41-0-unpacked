package com.talabat.feature.walletaddcard.data.di;

import com.talabat.feature.walletaddcard.data.WalletAddCardRepositoryImpl;
import com.talabat.feature.walletaddcard.domain.WalletAddCardRepository;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/walletaddcard/data/di/WalletAddCardFeatureModule;", "", "walletAddCardRepository", "Lcom/talabat/feature/walletaddcard/domain/WalletAddCardRepository;", "impl", "Lcom/talabat/feature/walletaddcard/data/WalletAddCardRepositoryImpl;", "com_talabat_feature_wallet-add-card_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {WalletAddCardCheckoutKitModule.class})
public interface WalletAddCardFeatureModule {
    @NotNull
    @Binds
    @Reusable
    WalletAddCardRepository walletAddCardRepository(@NotNull WalletAddCardRepositoryImpl walletAddCardRepositoryImpl);
}
