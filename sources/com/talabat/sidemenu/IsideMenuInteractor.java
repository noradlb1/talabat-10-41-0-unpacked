package com.talabat.sidemenu;

import kotlin.Metadata;
import library.talabat.mvp.IGlobalInteractor;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/talabat/sidemenu/IsideMenuInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "checkUserEligibleForBNPL", "", "loadBnplOverdues", "loadLastOrderDetails", "loadRafSenderVoucherLabel", "loadTalabatCreditBalance", "loadUserActiveVoucherCount", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IsideMenuInteractor extends IGlobalInteractor {
    void checkUserEligibleForBNPL();

    void loadBnplOverdues();

    void loadLastOrderDetails();

    void loadRafSenderVoucherLabel();

    void loadTalabatCreditBalance();

    void loadUserActiveVoucherCount();
}
