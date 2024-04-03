package com.talabat.talabatcommon.views.wallet.walletCardManagement.model;

import com.talabat.mapper.ModelMappingIntegrationKt;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletAddCardResponse;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardResult;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletSetDefaultCardResult;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletAddCardDisplayModelState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletDeleteCardDisplayModelState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletSetDefaultCardDisplayModelState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardManagementMapper;", "", "()V", "mapDeleteCardToDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletDeleteCardDisplayModelState;", "result", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardResult;", "mapSetDefaultCardToDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletSetDefaultCardDisplayModelState;", "response", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletSetDefaultCardResult;", "mapWalletAddCardToDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardDisplayModelState;", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletAddCardResponse;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCardManagementMapper {
    @NotNull
    public static final WalletCardManagementMapper INSTANCE = new WalletCardManagementMapper();

    private WalletCardManagementMapper() {
    }

    @NotNull
    public final WalletDeleteCardDisplayModelState mapDeleteCardToDisplayModel(@NotNull WalletDeleteCardResult walletDeleteCardResult) {
        Intrinsics.checkNotNullParameter(walletDeleteCardResult, "result");
        if (BooleanKt.orFalse(walletDeleteCardResult.isSuccessful())) {
            return WalletDeleteCardDisplayModelState.SuccessDeleteCard.INSTANCE;
        }
        return new WalletDeleteCardDisplayModelState.ErrorDeleteCard(walletDeleteCardResult.getError());
    }

    @NotNull
    public final WalletSetDefaultCardDisplayModelState mapSetDefaultCardToDisplayModel(@NotNull WalletSetDefaultCardResult walletSetDefaultCardResult) {
        Intrinsics.checkNotNullParameter(walletSetDefaultCardResult, "response");
        if (BooleanKt.orFalse(walletSetDefaultCardResult.isSuccessful())) {
            return WalletSetDefaultCardDisplayModelState.SuccessSetDefaultCard.INSTANCE;
        }
        return WalletSetDefaultCardDisplayModelState.ErrorSetDefaultCard.INSTANCE;
    }

    @NotNull
    public final WalletAddCardDisplayModelState mapWalletAddCardToDisplayModel(@NotNull WalletAddCardResponse walletAddCardResponse) {
        boolean z11;
        Intrinsics.checkNotNullParameter(walletAddCardResponse, "response");
        WalletAddCardDisplayModel walletAddCardDisplayModel = (WalletAddCardDisplayModel) ModelMappingIntegrationKt.parseFromNullable(new WalletAddCardDisplayModel((String) null, false, (String) null, 0, 0, 31, (DefaultConstructorMarker) null), walletAddCardResponse);
        if (walletAddCardDisplayModel.isValid() && walletAddCardDisplayModel.getVerificationCode() == 0) {
            return WalletAddCardDisplayModelState.SuccessWalletAddCardNonThreeDS.INSTANCE;
        }
        if (walletAddCardDisplayModel.isValid() && walletAddCardDisplayModel.getVerificationCode() == 1) {
            if (walletAddCardDisplayModel.getRedirectUrl().length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return new WalletAddCardDisplayModelState.SuccessWalletAddCardThreeDS(walletAddCardDisplayModel.getRedirectUrl());
            }
        }
        if (!walletAddCardDisplayModel.isValid() || walletAddCardDisplayModel.getVerificationCode() != 1) {
            return new WalletAddCardDisplayModelState.ErrorWalletAddCard(WalletAddCardErrorState.INVALID_INPUT);
        }
        return new WalletAddCardDisplayModelState.ErrorWalletAddCard(WalletAddCardErrorState.API_SERVICE_ERROR);
    }
}
