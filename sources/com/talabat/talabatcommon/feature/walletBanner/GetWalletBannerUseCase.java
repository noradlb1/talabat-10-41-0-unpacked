package com.talabat.talabatcommon.feature.walletBanner;

import com.talabat.talabatcommon.feature.walletBanner.repository.WalletBannerRepository;
import com.talabat.talabatcommon.model.wallet.WalletBannerDisplayModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletBanner/GetWalletBannerUseCase;", "", "walletBannerRepository", "Lcom/talabat/talabatcommon/feature/walletBanner/repository/WalletBannerRepository;", "(Lcom/talabat/talabatcommon/feature/walletBanner/repository/WalletBannerRepository;)V", "run", "Lcom/talabat/talabatcommon/model/wallet/WalletBannerDisplayModel;", "params", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetWalletBannerUseCase {
    @NotNull
    private final WalletBannerRepository walletBannerRepository;

    @Inject
    public GetWalletBannerUseCase(@NotNull WalletBannerRepository walletBannerRepository2) {
        Intrinsics.checkNotNullParameter(walletBannerRepository2, "walletBannerRepository");
        this.walletBannerRepository = walletBannerRepository2;
    }

    @Nullable
    public final Object run(@NotNull String str, @NotNull Continuation<? super WalletBannerDisplayModel> continuation) {
        return this.walletBannerRepository.getWalletBanner(str, continuation);
    }
}
