package com.talabat.sidemenu;

import android.content.Context;
import com.talabat.helpers.Talabat;
import library.talabat.mvp.home.VoucherStateDomainModel;
import org.jetbrains.annotations.Nullable;

public interface SideMenuView extends Talabat {
    Context getContext();

    void hideBnplOverdueNotification();

    void onCreditBalanceRefresh();

    void onSideMenuLinkNavigation(String str, String str2);

    void onSideMenuNavigation(String str);

    void setSideMenu();

    void showBNPLOption();

    void showBnplOverdueNotification(double d11);

    void updateRafVoucherLabel(String str);

    void updateVoucherCounter(@Nullable VoucherStateDomainModel voucherStateDomainModel);
}
