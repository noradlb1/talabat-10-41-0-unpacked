package com.talabat.talabatcommon.feature.walletPaymentWidgetConfig;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.talabat.talabatcommon.extentions.SafeLetKt;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentWidgetDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/GetWalletPaymentOptionViewConfigUseCase;", "Lkotlin/Function1;", "Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/WalletPaymentWidgetDisplayModelParam;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentWidgetDisplayModel;", "()V", "invoke", "param", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetWalletPaymentOptionViewConfigUseCase implements Function1<WalletPaymentWidgetDisplayModelParam, WalletPaymentWidgetDisplayModel> {
    @NotNull
    public WalletPaymentWidgetDisplayModel invoke(@NotNull WalletPaymentWidgetDisplayModelParam walletPaymentWidgetDisplayModelParam) {
        Intrinsics.checkNotNullParameter(walletPaymentWidgetDisplayModelParam, RemoteMessageConst.MessageBody.PARAM);
        SafeLetKt.safeLet(walletPaymentWidgetDisplayModelParam.isWalletBalanceServiceCompleted(), walletPaymentWidgetDisplayModelParam.isCardListServiceCompleted(), new GetWalletPaymentOptionViewConfigUseCase$invoke$1(walletPaymentWidgetDisplayModelParam));
        return walletPaymentWidgetDisplayModelParam.getWalletPaymentWidgetDisplayModel();
    }
}
