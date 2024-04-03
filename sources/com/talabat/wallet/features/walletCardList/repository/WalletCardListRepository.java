package com.talabat.wallet.features.walletCardList.repository;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/wallet/features/walletCardList/repository/WalletCardListRepository;", "", "getWalletCardList", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "country", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletCardListRepository {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Either getWalletCardList$default(WalletCardListRepository walletCardListRepository, int i11, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
                }
                return walletCardListRepository.getWalletCardList(i11);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWalletCardList");
        }
    }

    @NotNull
    Either<Failure, WalletCardListDisplayModel> getWalletCardList(int i11);
}
