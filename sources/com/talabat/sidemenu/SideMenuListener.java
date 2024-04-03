package com.talabat.sidemenu;

import JsonModels.Response.CustomerLastOrderDetailsRM;
import JsonModels.Response.TalabatCreditBalanceResponse;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalListener;
import library.talabat.mvp.home.VoucherStateDomainModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0016"}, d2 = {"Lcom/talabat/sidemenu/SideMenuListener;", "Llibrary/talabat/mvp/IGlobalListener;", "onBnplOverdueLoaded", "", "overdueResult", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase$OverdueResult;", "onCreditBalanceDetailsReceived", "result", "LJsonModels/Response/TalabatCreditBalanceResponse;", "onRedirectToLiveChat", "onTalabatCreditBalError", "onUserActiveVouchersCountFail", "onUserActiveVouchersCountReceived", "userActiveVouchersCount", "Llibrary/talabat/mvp/home/VoucherStateDomainModel;", "onUserRafSenderVoucherLabelReceived", "rafSenderVoucherLabel", "", "showBNPLOption", "updateLastOrderDetails", "customerLastOrderDetailsRM", "LJsonModels/Response/CustomerLastOrderDetailsRM;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SideMenuListener extends IGlobalListener {
    void onBnplOverdueLoaded(@NotNull GetOverdueUseCase.OverdueResult overdueResult);

    void onCreditBalanceDetailsReceived(@Nullable TalabatCreditBalanceResponse talabatCreditBalanceResponse);

    void onRedirectToLiveChat();

    void onTalabatCreditBalError();

    void onUserActiveVouchersCountFail();

    void onUserActiveVouchersCountReceived(@NotNull VoucherStateDomainModel voucherStateDomainModel);

    void onUserRafSenderVoucherLabelReceived(@NotNull String str);

    void showBNPLOption();

    void updateLastOrderDetails(@NotNull CustomerLastOrderDetailsRM customerLastOrderDetailsRM);
}
