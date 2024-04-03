package com.talabat.wallet.ui.walletCardManagement.model;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/ui/walletCardManagement/model/WalletAdapterCardListMapper;", "", "()V", "mapToItemDisplayModel", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$WalletCardAdapterDisplayModel;", "model", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "mapWalletCardListToCardManagementList", "", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel;", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletAdapterCardListMapper {
    @NotNull
    public static final WalletAdapterCardListMapper INSTANCE = new WalletAdapterCardListMapper();

    private WalletAdapterCardListMapper() {
    }

    @NotNull
    public final WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel mapToItemDisplayModel(@NotNull WalletCardDisplayModel walletCardDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel walletCardAdapterDisplayModel = new WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel();
        walletCardAdapterDisplayModel.setCard4Digits(StringsKt___StringsKt.takeLast(walletCardDisplayModel.getCardNumber(), 4));
        walletCardAdapterDisplayModel.setDefaultCard(walletCardDisplayModel.isDefaultCard());
        walletCardAdapterDisplayModel.setToken(walletCardDisplayModel.getToken());
        walletCardAdapterDisplayModel.setTokenId(walletCardDisplayModel.getTokenId());
        walletCardAdapterDisplayModel.setCardNumber(walletCardDisplayModel.getCardNumber());
        walletCardAdapterDisplayModel.setExpiryMonth(walletCardDisplayModel.getExpiryMonth());
        walletCardAdapterDisplayModel.setExpiryYear(walletCardDisplayModel.getExpiryYear());
        walletCardAdapterDisplayModel.setBinNumber(walletCardDisplayModel.getBinNumber());
        walletCardAdapterDisplayModel.setCardType(walletCardDisplayModel.getCardType());
        return walletCardAdapterDisplayModel;
    }

    @NotNull
    public final List<WalletCreditCardListDataItemDisplayModel> mapWalletCardListToCardManagementList(@NotNull WalletCardListDisplayModel walletCardListDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardListDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        ArrayList arrayList = new ArrayList();
        if (walletCardListDisplayModel.getCardList().isEmpty()) {
            return arrayList;
        }
        boolean z11 = false;
        for (WalletCardDisplayModel next : walletCardListDisplayModel.getCardList()) {
            if (z11 || !next.isDefaultCard()) {
                arrayList.add(mapToItemDisplayModel(next));
            } else {
                WalletCreditCardListDataItemDisplayModel.HeaderMessage headerMessage = new WalletCreditCardListDataItemDisplayModel.HeaderMessage();
                headerMessage.setMessage(CardMessageHeaderType.PRIMARY_CARD);
                Unit unit = Unit.INSTANCE;
                arrayList.add(0, headerMessage);
                arrayList.add(1, mapToItemDisplayModel(next));
                z11 = true;
            }
        }
        if (z11 && walletCardListDisplayModel.getCardList().size() > 1) {
            WalletCreditCardListDataItemDisplayModel.HeaderMessage headerMessage2 = new WalletCreditCardListDataItemDisplayModel.HeaderMessage();
            headerMessage2.setMessage(CardMessageHeaderType.OTHER_CARDS);
            Unit unit2 = Unit.INSTANCE;
            arrayList.add(2, headerMessage2);
        } else if (!z11) {
            WalletCreditCardListDataItemDisplayModel.HeaderMessage headerMessage3 = new WalletCreditCardListDataItemDisplayModel.HeaderMessage();
            headerMessage3.setMessage(CardMessageHeaderType.PRIMARY_CARD);
            Unit unit3 = Unit.INSTANCE;
            arrayList.add(0, headerMessage3);
            arrayList.add(1, WalletCreditCardListDataItemDisplayModel.CardPlaceholder.INSTANCE);
            WalletCreditCardListDataItemDisplayModel.HeaderMessage headerMessage4 = new WalletCreditCardListDataItemDisplayModel.HeaderMessage();
            headerMessage4.setMessage(CardMessageHeaderType.OTHER_CARDS);
            arrayList.add(2, headerMessage4);
        }
        return arrayList;
    }
}
