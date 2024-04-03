package com.talabat.wallet.screens.walletDashboard.view;

import JsonModels.Response.WalletTransactionListDataModel;
import com.talabat.helpers.Talabat;
import com.talabat.wallet.common.walletBalance.IWalletBalanceView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\u0004H&J\b\u0010\f\u001a\u00020\u0004H&J\b\u0010\r\u001a\u00020\u0004H&J\b\u0010\u000e\u001a\u00020\u0004H&¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/screens/walletDashboard/view/WalletTransactionDashboardScreenView;", "Lcom/talabat/helpers/Talabat;", "Lcom/talabat/wallet/common/walletBalance/IWalletBalanceView;", "addWalletCreditTransactionListData", "", "walletTransactionListDataModel", "LJsonModels/Response/WalletTransactionListDataModel;", "displayServerErrorMessage", "redirectToEmptyListView", "redirectToLoginScreen", "refreshSidemenu", "setupProgressBarBeforeServiceRequest", "showCardManagementIcon", "showSendGiftIcon", "showTopUpIcon", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletTransactionDashboardScreenView extends Talabat, IWalletBalanceView {
    void addWalletCreditTransactionListData(@Nullable WalletTransactionListDataModel walletTransactionListDataModel);

    void displayServerErrorMessage();

    void redirectToEmptyListView();

    void redirectToLoginScreen();

    void refreshSidemenu();

    void setupProgressBarBeforeServiceRequest();

    void showCardManagementIcon();

    void showSendGiftIcon();

    void showTopUpIcon();
}
