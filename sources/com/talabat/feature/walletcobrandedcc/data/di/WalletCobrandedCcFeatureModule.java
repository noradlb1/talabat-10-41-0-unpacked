package com.talabat.feature.walletcobrandedcc.data.di;

import com.talabat.feature.walletcobrandedcc.data.WalletCobrandedCcRepositoryImpl;
import com.talabat.feature.walletcobrandedcc.domain.WalletCobrandedCcRepository;
import com.talabat.feature.walletcobrandedcc.domain.usecase.GetWalletStatusUseCase;
import com.talabat.feature.walletcobrandedcc.domain.usecase.ShowCobrandedNotificationUseCase;
import com.talabat.feature.walletcobrandedcc.domain.usecase.impl.GetWalletStatusUseCaseImpl;
import com.talabat.feature.walletcobrandedcc.domain.usecase.impl.ShowCobrandedNotificationUseCaseImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH'¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/walletcobrandedcc/data/di/WalletCobrandedCcFeatureModule;", "", "()V", "provideGetWalletStatusUseCase", "Lcom/talabat/feature/walletcobrandedcc/domain/usecase/GetWalletStatusUseCase;", "getWalletStatusUseCaseImpl", "Lcom/talabat/feature/walletcobrandedcc/domain/usecase/impl/GetWalletStatusUseCaseImpl;", "provideShowCobrandedNotificationUseCase", "Lcom/talabat/feature/walletcobrandedcc/domain/usecase/ShowCobrandedNotificationUseCase;", "showCobrandedNotificationUseCaseImpl", "Lcom/talabat/feature/walletcobrandedcc/domain/usecase/impl/ShowCobrandedNotificationUseCaseImpl;", "walletCobrandedCcRepository", "Lcom/talabat/feature/walletcobrandedcc/domain/WalletCobrandedCcRepository;", "impl", "Lcom/talabat/feature/walletcobrandedcc/data/WalletCobrandedCcRepositoryImpl;", "com_talabat_feature_wallet-cobranded-cc_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {WalletCobrandedCcNetworkModule.class})
public abstract class WalletCobrandedCcFeatureModule {
    @NotNull
    @Binds
    @Reusable
    public abstract GetWalletStatusUseCase provideGetWalletStatusUseCase(@NotNull GetWalletStatusUseCaseImpl getWalletStatusUseCaseImpl);

    @NotNull
    @Binds
    @Reusable
    public abstract ShowCobrandedNotificationUseCase provideShowCobrandedNotificationUseCase(@NotNull ShowCobrandedNotificationUseCaseImpl showCobrandedNotificationUseCaseImpl);

    @NotNull
    @Binds
    @Reusable
    public abstract WalletCobrandedCcRepository walletCobrandedCcRepository(@NotNull WalletCobrandedCcRepositoryImpl walletCobrandedCcRepositoryImpl);
}
